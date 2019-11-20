package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gZP;
    ImageProblemAssistant gZQ;
    CheckTask gZR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZQ = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gZP = new ImageProblemView(this, this.gZQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gZR != null) {
            this.gZR.cancel();
            this.gZR = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gZP.getCheckButton()) {
            if (this.gZR == null) {
                this.gZP.getCheckButton().setText(getResources().getText(R.string.stop));
                this.gZR = new CheckTask();
                this.gZR.execute(new Object[0]);
                return;
            }
            this.gZP.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.gZR != null) {
                this.gZR.cancel();
                this.gZR = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gZP.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gZP.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gZQ.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gZQ.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gZQ.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gZQ.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gZQ.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gZQ.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gZQ.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.gZP.setValue(numArr[0].intValue(), ImageProblemActivity.this.gZQ.Sj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gZP.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.gZP.complete();
            ImageProblemActivity.this.gZR = null;
        }
    }
}
