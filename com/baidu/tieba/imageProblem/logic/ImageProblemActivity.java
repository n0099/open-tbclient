package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView djM;
    ImageProblemAssistant djN;
    CheckTask djO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djN = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.djM = new ImageProblemView(this, this.djN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.djO != null) {
            this.djO.cancel();
            this.djO = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.djM.getCheckButton()) {
            if (this.djO == null) {
                this.djM.getCheckButton().setText(getResources().getText(u.j.stop));
                this.djO = new CheckTask(this, null);
                this.djO.execute(new Object[0]);
                return;
            }
            this.djM.getCheckButton().setText(getResources().getText(u.j.diagnose));
            if (this.djO != null) {
                this.djO.cancel();
                this.djO = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.djM.onChangeSkinType(i);
    }

    /* loaded from: classes.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.djM.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.djN.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.djN.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.djN.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.djN.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.djN.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.djN.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.djN.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.djM.setValue(numArr[0].intValue(), ImageProblemActivity.this.djN.djR);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.djM.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(u.j.diagnose));
            ImageProblemActivity.this.djM.complete();
            ImageProblemActivity.this.djO = null;
        }
    }
}
