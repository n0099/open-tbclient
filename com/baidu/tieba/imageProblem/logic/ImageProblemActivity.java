package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView bQD;
    ImageProblemAssistant bQE;
    CheckTask bQF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bQE = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.bQD = new ImageProblemView(this, this.bQE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bQF != null) {
            this.bQF.cancel();
            this.bQF = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bQD.getCheckButton()) {
            if (this.bQF == null) {
                this.bQD.getCheckButton().setText(getResources().getText(i.h.stop));
                this.bQF = new CheckTask(this, null);
                this.bQF.execute(new Object[0]);
                return;
            }
            this.bQD.getCheckButton().setText(getResources().getText(i.h.diagnose));
            if (this.bQF != null) {
                this.bQF.cancel();
                this.bQF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bQD.onChangeSkinType(i);
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
            ImageProblemActivity.this.bQD.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.bQE.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.bQE.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.bQE.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.bQE.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.bQE.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.bQE.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.bQE.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.bQD.setValue(numArr[0].intValue(), ImageProblemActivity.this.bQE.bQI);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.bQD.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(i.h.diagnose));
            ImageProblemActivity.this.bQD.complete();
            ImageProblemActivity.this.bQF = null;
        }
    }
}
