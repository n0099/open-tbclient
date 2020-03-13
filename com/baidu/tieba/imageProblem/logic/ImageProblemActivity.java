package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView hTM;
    ImageProblemAssistant hTN;
    CheckTask hTO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hTN = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.hTM = new ImageProblemView(this, this.hTN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hTO != null) {
            this.hTO.cancel();
            this.hTO = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hTM.getCheckButton()) {
            if (this.hTO == null) {
                this.hTM.getCheckButton().setText(getResources().getText(R.string.stop));
                this.hTO = new CheckTask();
                this.hTO.execute(new Object[0]);
                return;
            }
            this.hTM.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.hTO != null) {
                this.hTO.cancel();
                this.hTO = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hTM.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.hTM.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.hTN.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.hTN.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.hTN.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.hTN.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.hTN.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.hTN.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.hTN.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.hTM.setValue(numArr[0].intValue(), ImageProblemActivity.this.hTN.abf);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.hTM.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.hTM.complete();
            ImageProblemActivity.this.hTO = null;
        }
    }
}
