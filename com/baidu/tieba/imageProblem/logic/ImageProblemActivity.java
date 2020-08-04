package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView juO;
    ImageProblemAssistant juP;
    CheckTask juQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.juP = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.juO = new ImageProblemView(this, this.juP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.juQ != null) {
            this.juQ.cancel();
            this.juQ = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.juO.getCheckButton()) {
            if (this.juQ == null) {
                this.juO.getCheckButton().setText(getResources().getText(R.string.stop));
                this.juQ = new CheckTask();
                this.juQ.execute(new Object[0]);
                return;
            }
            this.juO.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.juQ != null) {
                this.juQ.cancel();
                this.juQ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.juO.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.juO.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.juP.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.juP.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.juP.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.juP.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.juP.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.juP.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.juP.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.juO.setValue(numArr[0].intValue(), ImageProblemActivity.this.juP.aCw);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.juO.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.juO.complete();
            ImageProblemActivity.this.juQ = null;
        }
    }
}
