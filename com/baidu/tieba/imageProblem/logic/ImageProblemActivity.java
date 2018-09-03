package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eLp;
    ImageProblemAssistant eLq;
    CheckTask eLr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eLq = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eLp = new ImageProblemView(this, this.eLq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eLr != null) {
            this.eLr.cancel();
            this.eLr = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eLp.getCheckButton()) {
            if (this.eLr == null) {
                this.eLp.getCheckButton().setText(getResources().getText(f.j.stop));
                this.eLr = new CheckTask();
                this.eLr.execute(new Object[0]);
                return;
            }
            this.eLp.getCheckButton().setText(getResources().getText(f.j.diagnose));
            if (this.eLr != null) {
                this.eLr.cancel();
                this.eLr = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eLp.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eLp.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eLq.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eLq.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eLq.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eLq.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eLq.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eLq.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eLq.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eLp.setValue(numArr[0].intValue(), ImageProblemActivity.this.eLq.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eLp.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(f.j.diagnose));
            ImageProblemActivity.this.eLp.complete();
            ImageProblemActivity.this.eLr = null;
        }
    }
}
