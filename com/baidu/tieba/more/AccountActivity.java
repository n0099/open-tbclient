package com.baidu.tieba.more;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity {
    private ArrayList<AccountData> mModel = null;
    private AccountAdapter mAdapter = null;
    private ListView mList = null;
    private Button mBack = null;
    private Button mEdit = null;
    private View.OnClickListener mDeleteListener = null;
    private SwitchAsyncTask mSwitchTask = null;
    private DeleteAsyncTask mDeleteTask = null;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, AccountActivity.class);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_activity);
        InitData();
        InitUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        cancelAsyncTask();
        super.onDestroy();
    }

    private void InitData() {
        this.mModel = DatabaseService.getAllAccountData();
    }

    private void InitUI() {
        this.mDeleteListener = new View.OnClickListener() { // from class: com.baidu.tieba.more.AccountActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AccountData isDeletingData = (AccountData) v.getTag();
                if (isDeletingData == null) {
                    return;
                }
                AccountActivity.this.cancelAsyncTask();
                AccountActivity.this.mDeleteTask = new DeleteAsyncTask(isDeletingData);
                AccountActivity.this.mDeleteTask.execute(new Object[0]);
            }
        };
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.AccountActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                AccountActivity.this.finish();
            }
        });
        this.mEdit = (Button) findViewById(R.id.edit);
        this.mEdit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.AccountActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (!AccountActivity.this.mAdapter.getEditState()) {
                    AccountActivity.this.mAdapter.setEditState(true);
                    AccountActivity.this.mEdit.setText(R.string.done);
                    AccountActivity.this.mAdapter.notifyDataSetChanged();
                    return;
                }
                AccountActivity.this.mAdapter.setEditState(false);
                AccountActivity.this.mEdit.setText(R.string.edit);
                AccountActivity.this.mAdapter.notifyDataSetChanged();
            }
        });
        this.mAdapter = new AccountAdapter(this, this.mDeleteListener);
        this.mAdapter.setData(this.mModel);
        this.mList = (ListView) findViewById(R.id.list);
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.more.AccountActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                AccountData account;
                if (AccountActivity.this.mAdapter.getItemId(position) >= 0) {
                    if (AccountActivity.this.mAdapter.getEditState() || (account = (AccountData) AccountActivity.this.mAdapter.getItem(position)) == null || account.getIsActive() == 1) {
                        return;
                    }
                    AccountActivity.this.cancelAsyncTask();
                    AccountActivity.this.mSwitchTask = new SwitchAsyncTask(account.getAccount(), account.getPassword());
                    AccountActivity.this.mSwitchTask.execute(new Object[0]);
                    return;
                }
                LoginActivity.startActivityNoExitDialog(AccountActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAsyncTask() {
        if (this.mSwitchTask != null) {
            this.mSwitchTask.cancel();
            this.mSwitchTask = null;
        }
        if (this.mDeleteTask != null) {
            this.mDeleteTask.cancel();
            this.mDeleteTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SwitchAsyncTask extends AsyncTask<Object, Integer, Boolean> {
        private String mAccount;
        private NetWork mNetwork = null;
        private String mPassword;

        public SwitchAsyncTask(String account, String password) {
            this.mAccount = null;
            this.mPassword = null;
            this.mAccount = account;
            this.mPassword = password;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            AccountActivity.this.showLoadingDialog(AccountActivity.this.getString(R.string.account_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.more.AccountActivity.SwitchAsyncTask.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialog) {
                    AccountActivity.this.DeinitWaitingDialog();
                    AccountActivity.this.cancelAsyncTask();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Object... params) {
            boolean res = false;
            try {
                this.mNetwork = new NetWork();
                Boolean res2 = Boolean.valueOf(this.mNetwork.multiAccountLogin(this.mAccount, this.mPassword));
                return res2;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "", "doInBackground error = " + ex.getMessage());
                return res;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean data) {
            AccountActivity.this.closeLoadingDialog();
            if (!data.booleanValue()) {
                if (this.mNetwork != null) {
                    AccountActivity.this.showToast(this.mNetwork.getErrorString());
                }
            } else {
                MainTabActivity.startActivityOnUserChanged(AccountActivity.this, null);
            }
            AccountActivity.this.mSwitchTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DeleteAsyncTask extends AsyncTask<Object, Integer, Boolean> {
        private static final int DEL_CURRENT_HAS_NOT_OTHER = 2;
        private static final int DEL_CURRENT_HAS_OTHER = 1;
        private static final int DEL_NO_CURRENT_ACCOUNT = 0;
        private AccountData mDelAccount;
        private NetWork mNetwork = null;
        private int mType = 0;

        public DeleteAsyncTask(AccountData delAccount) {
            this.mDelAccount = delAccount;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            AccountActivity.this.showLoadingDialog(AccountActivity.this.getString(R.string.deleting), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.more.AccountActivity.DeleteAsyncTask.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialog) {
                    AccountActivity.this.DeinitWaitingDialog();
                    AccountActivity.this.cancelAsyncTask();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Object... params) {
            boolean res = false;
            try {
                DatabaseService.deleteAccountAllInfo(this.mDelAccount.getID());
                String currentAccountID = TiebaApplication.getCurrentAccount();
                if (this.mDelAccount.getID().equals(currentAccountID)) {
                    TiebaApplication.setCurrentAccountObj(null);
                    if (AccountActivity.this.mModel.size() >= 2) {
                        this.mType = 1;
                        AccountData toAccount = (AccountData) AccountActivity.this.mModel.get(1);
                        this.mNetwork = new NetWork();
                        res = Boolean.valueOf(this.mNetwork.multiAccountLogin(toAccount.getAccount(), toAccount.getPassword()));
                        toAccount.setIsActive(1);
                        TiebaApplication.setCurrentAccountObj(toAccount);
                        DatabaseService.saveAccountData(toAccount);
                    } else {
                        this.mType = 2;
                        res = true;
                    }
                } else {
                    this.mType = 0;
                    res = true;
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "", "doInBackground error = " + ex.getMessage());
            }
            return res;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean data) {
            AccountActivity.this.closeLoadingDialog();
            if (!data.booleanValue()) {
                switch (this.mType) {
                    case 1:
                        if (this.mNetwork != null) {
                            AccountActivity.this.showToast(this.mNetwork.getErrorString());
                            MainTabActivity.startActivity(AccountActivity.this, MainTabActivity.GOTO_CLOSE_LOGIN);
                            break;
                        }
                        break;
                }
            } else {
                switch (this.mType) {
                    case 0:
                        AccountActivity.this.showToast(AccountActivity.this.getString(R.string.success));
                        AccountActivity.this.mModel.remove(this.mDelAccount);
                        this.mDelAccount = null;
                        AccountActivity.this.mAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        MainTabActivity.startActivityOnUserChanged(AccountActivity.this, null);
                        break;
                    case 2:
                        MainTabActivity.startActivityOnUserChanged(AccountActivity.this, MainTabActivity.GOTO_MORE);
                        break;
                }
            }
            AccountActivity.this.mDeleteTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }
}
