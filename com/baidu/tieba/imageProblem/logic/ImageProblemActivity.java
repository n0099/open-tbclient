package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView hcD;
    ImageProblemAssistant hcE;
    CheckTask hcF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hcE = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.hcD = new ImageProblemView(this, this.hcE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hcF != null) {
            this.hcF.cancel();
            this.hcF = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hcD.getCheckButton()) {
            if (this.hcF == null) {
                this.hcD.getCheckButton().setText(getResources().getText(R.string.stop));
                this.hcF = new CheckTask();
                this.hcF.execute(new Object[0]);
                return;
            }
            this.hcD.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.hcF != null) {
                this.hcF.cancel();
                this.hcF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hcD.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.hcD.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.hcE.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.hcE.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.hcE.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.hcE.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.hcE.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.hcE.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.hcE.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.hcD.setValue(numArr[0].intValue(), ImageProblemActivity.this.hcE.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.hcD.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.hcD.complete();
            ImageProblemActivity.this.hcF = null;
        }
    }
}
