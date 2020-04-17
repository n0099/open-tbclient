package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView iFd;
    ImageProblemAssistant iFe;
    CheckTask iFf;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iFe = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.iFd = new ImageProblemView(this, this.iFe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iFf != null) {
            this.iFf.cancel();
            this.iFf = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iFd.getCheckButton()) {
            if (this.iFf == null) {
                this.iFd.getCheckButton().setText(getResources().getText(R.string.stop));
                this.iFf = new CheckTask();
                this.iFf.execute(new Object[0]);
                return;
            }
            this.iFd.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.iFf != null) {
                this.iFf.cancel();
                this.iFf = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iFd.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.iFd.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.iFe.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.iFe.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.iFe.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.iFe.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.iFe.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.iFe.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.iFe.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.iFd.setValue(numArr[0].intValue(), ImageProblemActivity.this.iFe.atJ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.iFd.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.iFd.complete();
            ImageProblemActivity.this.iFf = null;
        }
    }
}
