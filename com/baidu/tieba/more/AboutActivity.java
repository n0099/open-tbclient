package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.model.SyncModel;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity {
    private TextView version = null;
    private Button mBack = null;
    private Button mCheckUpdate = null;
    private SyncAsyncTask mSyncTask = null;
    private SyncModel mModel = null;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        this.version = (TextView) findViewById(R.id.version);
        this.version.setText(String.valueOf(getString(R.string.app_name)) + " Android " + Config.VERSION);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.AboutActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                AboutActivity.this.finish();
            }
        });
        this.mCheckUpdate = (Button) findViewById(R.id.check_update_button);
        this.mCheckUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.AboutActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                AboutActivity.this.checkUpdata();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.mSyncTask != null) {
            this.mSyncTask.cancel();
        }
        this.mSyncTask = new SyncAsyncTask(this, null);
        this.mSyncTask.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SyncAsyncTask extends AsyncTask<String, Integer, SyncModel> {
        NetWork mNetWork;

        private SyncAsyncTask() {
            this.mNetWork = null;
        }

        /* synthetic */ SyncAsyncTask(AboutActivity aboutActivity, SyncAsyncTask syncAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SyncModel doInBackground(String... arg0) {
            SyncModel data = null;
            try {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/s/sync");
                this.mNetWork.addPostData("_os_version", Build.VERSION.RELEASE);
                StringBuffer buffer = new StringBuffer(15);
                buffer.append(String.valueOf(UtilHelper.getEquipmentWidth(TiebaApplication.app)));
                buffer.append(",");
                buffer.append(String.valueOf(UtilHelper.getEquipmentHeight(TiebaApplication.app)));
                this.mNetWork.addPostData("_phone_screen", buffer.toString());
                if (TiebaApplication.app.getMsgFrequency() > 0) {
                    this.mNetWork.addPostData("_msg_status", "0");
                } else {
                    this.mNetWork.addPostData("_msg_status", NetWorkCore.NET_TYPE_NET);
                }
                String ret = this.mNetWork.postNetData();
                if (!this.mNetWork.isRequestSuccess()) {
                    return null;
                }
                SyncModel data2 = new SyncModel();
                try {
                    data2.parserJson(ret);
                    String id = TiebaApplication.getClientId();
                    if (id != null || data2.getClient().getClient_id() == null || data2.getClient().getClient_id().length() <= 0) {
                        return data2;
                    }
                    TiebaApplication.saveClientId(AboutActivity.this, data2.getClient().getClient_id());
                    TiebaApplication.setClientId(data2.getClient().getClient_id());
                    return data2;
                } catch (Exception e) {
                    ex = e;
                    data = data2;
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return data;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        public void cancel() {
            AboutActivity.this.mSyncTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SyncModel result) {
            super.onPostExecute((SyncAsyncTask) result);
            AboutActivity.this.mSyncTask = null;
            if (result != null) {
                AboutActivity.this.mModel = result;
                if (AboutActivity.this.mModel.getVersion().getHas_new_ver() == 1 && Config.COULD_UPDATE) {
                    if (AboutActivity.this.mModel.getVersion().getForce_update() == 1) {
                        UpdateDialog.startActivity(TiebaApplication.app, AboutActivity.this.mModel.getVersion());
                        return;
                    }
                    Long new_time = Long.valueOf(new Date().getTime());
                    TiebaApplication.app.setUpdateNotifyTime(new_time.longValue());
                    UpdateDialog.startActivity(TiebaApplication.app, AboutActivity.this.mModel.getVersion());
                    return;
                }
                AboutActivity.this.showToast(AboutActivity.this.getResources().getString(R.string.neednot_update));
            }
        }
    }
}
