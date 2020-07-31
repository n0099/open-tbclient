package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView juM;
    ImageProblemAssistant juN;
    CheckTask juO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.juN = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.juM = new ImageProblemView(this, this.juN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.juO != null) {
            this.juO.cancel();
            this.juO = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.juM.getCheckButton()) {
            if (this.juO == null) {
                this.juM.getCheckButton().setText(getResources().getText(R.string.stop));
                this.juO = new CheckTask();
                this.juO.execute(new Object[0]);
                return;
            }
            this.juM.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.juO != null) {
                this.juO.cancel();
                this.juO = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.juM.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.juM.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.juN.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.juN.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.juN.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.juN.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.juN.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.juN.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.juN.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.juM.setValue(numArr[0].intValue(), ImageProblemActivity.this.juN.aCw);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.juM.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.juM.complete();
            ImageProblemActivity.this.juO = null;
        }
    }
}
