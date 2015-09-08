package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView bMQ;
    ImageProblemAssistant bMR;
    CheckTask bMS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bMR = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.bMQ = new ImageProblemView(this, this.bMR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bMS != null) {
            this.bMS.cancel();
            this.bMS = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bMQ.getCheckButton()) {
            if (this.bMS == null) {
                this.bMQ.getCheckButton().setText(getResources().getText(i.h.stop));
                this.bMS = new CheckTask(this, null);
                this.bMS.execute(new Object[0]);
                return;
            }
            this.bMQ.getCheckButton().setText(getResources().getText(i.h.diagnose));
            if (this.bMS != null) {
                this.bMS.cancel();
                this.bMS = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bMQ.onChangeSkinType(i);
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
            ImageProblemActivity.this.bMQ.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.bMR.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.bMR.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.bMR.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.bMR.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.bMR.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.bMR.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.bMR.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.bMQ.setValue(numArr[0].intValue(), ImageProblemActivity.this.bMR.bMV);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.bMQ.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(i.h.diagnose));
            ImageProblemActivity.this.bMQ.complete();
            ImageProblemActivity.this.bMS = null;
        }
    }
}
