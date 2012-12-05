package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.model.BarlistModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditBarActivity extends BaseActivity {
    private BarlistModel mModel = null;
    private ListView mList = null;
    private Button mBack = null;
    private EditBarAdapter mAdapter = null;
    private ProgressBar mProgress = null;
    private MyBarAsyncTask mMyBarTask = null;
    private AlertDialog mDialog = null;
    private AlertDialog mAffirmDialog = null;
    private DialogInterface.OnClickListener mAffirmListener = null;
    private int mClickItem = -1;
    private UnlikeAsyncTask mUnlikeTask = null;

    public static void startActivity(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, EditBarActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_bar_activity);
        InitData();
        InitUI();
        refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mMyBarTask != null) {
            this.mMyBarTask.cancel();
        }
        if (this.mUnlikeTask != null) {
            this.mUnlikeTask.cancel();
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void refreshData() {
        if (this.mMyBarTask != null) {
            this.mMyBarTask.cancel();
        }
        this.mMyBarTask = new MyBarAsyncTask(this, null);
        this.mMyBarTask.execute(new Object[0]);
    }

    private void InitData() {
        this.mModel = new BarlistModel();
    }

    private void InitUI() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        String[] items = {getString(R.string.delete), getString(R.string.cancel)};
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.person.EditBarActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                ArrayList<ForumData> datas;
                if (which == 0) {
                    ForumData data = (ForumData) EditBarActivity.this.mAdapter.getItem(EditBarActivity.this.mClickItem);
                    if (data != null) {
                        if (data.isIs_like() == 1) {
                            if (EditBarActivity.this.mAffirmDialog == null) {
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(EditBarActivity.this);
                                builder2.setTitle(R.string.alerm_title);
                                builder2.setIcon(R.drawable.dialogue_quit);
                                builder2.setMessage(R.string.delete_like_info);
                                EditBarActivity.this.mAffirmListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.person.EditBarActivity.1.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface arg0, int which2) {
                                        ArrayList<ForumData> datas2;
                                        if (which2 != -1) {
                                            EditBarActivity.this.mAffirmDialog.dismiss();
                                        } else if (EditBarActivity.this.mUnlikeTask == null && (datas2 = EditBarActivity.this.mModel.getForum_list()) != null && EditBarActivity.this.mClickItem >= 0 && EditBarActivity.this.mClickItem < datas2.size()) {
                                            EditBarActivity.this.mUnlikeTask = new UnlikeAsyncTask(EditBarActivity.this, null);
                                            EditBarActivity.this.mUnlikeTask.execute(datas2.get(EditBarActivity.this.mClickItem));
                                        }
                                    }
                                };
                                builder2.setPositiveButton(EditBarActivity.this.getString(R.string.confirm), EditBarActivity.this.mAffirmListener);
                                builder2.setNegativeButton(EditBarActivity.this.getString(R.string.cancel), EditBarActivity.this.mAffirmListener);
                                EditBarActivity.this.mAffirmDialog = builder2.create();
                            }
                            EditBarActivity.this.mAffirmDialog.show();
                            return;
                        } else if (EditBarActivity.this.mUnlikeTask == null && (datas = EditBarActivity.this.mModel.getForum_list()) != null && EditBarActivity.this.mClickItem >= 0 && EditBarActivity.this.mClickItem < datas.size()) {
                            EditBarActivity.this.mUnlikeTask = new UnlikeAsyncTask(EditBarActivity.this, null);
                            EditBarActivity.this.mUnlikeTask.execute(datas.get(EditBarActivity.this.mClickItem));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                dialog.dismiss();
            }
        });
        this.mDialog = builder.create();
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.EditBarActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditBarActivity.this.finish();
            }
        });
        this.mAdapter = new EditBarAdapter(this, this.mModel);
        this.mList = (ListView) findViewById(R.id.list);
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.person.EditBarActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                if (EditBarActivity.this.mAdapter.getItem(position) != null && EditBarActivity.this.mUnlikeTask == null) {
                    EditBarActivity.this.mDialog.show();
                    EditBarActivity.this.mClickItem = position;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MyBarAsyncTask extends AsyncTask<Object, Integer, BarlistModel> {
        private NetWork mNetwork;

        private MyBarAsyncTask() {
            this.mNetwork = null;
        }

        /* synthetic */ MyBarAsyncTask(EditBarActivity editBarActivity, MyBarAsyncTask myBarAsyncTask) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            EditBarActivity.this.mProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public BarlistModel doInBackground(Object... params) {
            BarlistModel barlistData = null;
            try {
                this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/f/forum/like");
                String data = this.mNetwork.postNetData();
                if (!this.mNetwork.isRequestSuccess()) {
                    return null;
                }
                BarlistModel barlistData2 = new BarlistModel();
                try {
                    barlistData2.parserJson(data);
                    return barlistData2;
                } catch (Exception e) {
                    ex = e;
                    barlistData = barlistData2;
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return barlistData;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(BarlistModel data) {
            EditBarActivity.this.mProgress.setVisibility(8);
            EditBarActivity.this.mMyBarTask = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess() && data != null) {
                    EditBarActivity.this.mModel.setForum_list(data.getForum_list());
                    if (EditBarActivity.this.mAdapter != null) {
                        EditBarActivity.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                EditBarActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            EditBarActivity.this.mProgress.setVisibility(8);
            EditBarActivity.this.mMyBarTask = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes.dex */
    private class UnlikeAsyncTask extends AsyncTask<ForumData, Integer, String> {
        private NetWork mNetwork;

        private UnlikeAsyncTask() {
            this.mNetwork = null;
        }

        /* synthetic */ UnlikeAsyncTask(EditBarActivity editBarActivity, UnlikeAsyncTask unlikeAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(ForumData... params) {
            ForumData data = params[0];
            if (data != null) {
                try {
                    if (data.getId() != null && data.getName() != null) {
                        this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/unfavolike");
                        this.mNetwork.addPostData("fid", data.getId());
                        this.mNetwork.addPostData("kw", data.getName());
                        this.mNetwork.addPostData("favo_type", String.valueOf(data.getFavo_type()));
                        this.mNetwork.setIsNeedTbs(true);
                        this.mNetwork.postNetData();
                        return null;
                    }
                    return null;
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((UnlikeAsyncTask) result);
            EditBarActivity.this.mUnlikeTask = null;
            EditBarActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    ArrayList<ForumData> datas = EditBarActivity.this.mModel.getForum_list();
                    if (datas != null && EditBarActivity.this.mClickItem >= 0 && EditBarActivity.this.mClickItem < datas.size()) {
                        datas.remove(EditBarActivity.this.mClickItem);
                        if (EditBarActivity.this.mAdapter != null) {
                            EditBarActivity.this.mAdapter.notifyDataSetChanged();
                        }
                    }
                    if (!TiebaApplication.app.getLikeChanged()) {
                        TiebaApplication.app.setLikeChanged(true);
                        DatabaseService.delLikeData();
                    }
                    EditBarActivity.this.showToast(EditBarActivity.this.getString(R.string.success));
                    return;
                }
                EditBarActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            EditBarActivity.this.mProgress.setVisibility(0);
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            EditBarActivity.this.mProgress.setVisibility(8);
            EditBarActivity.this.mUnlikeTask = null;
            super.cancel(true);
        }
    }
}
