package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView iFj;
    ImageProblemAssistant iFk;
    CheckTask iFl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iFk = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.iFj = new ImageProblemView(this, this.iFk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iFl != null) {
            this.iFl.cancel();
            this.iFl = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iFj.getCheckButton()) {
            if (this.iFl == null) {
                this.iFj.getCheckButton().setText(getResources().getText(R.string.stop));
                this.iFl = new CheckTask();
                this.iFl.execute(new Object[0]);
                return;
            }
            this.iFj.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.iFl != null) {
                this.iFl.cancel();
                this.iFl = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iFj.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.iFj.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.iFk.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.iFk.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.iFk.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.iFk.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.iFk.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.iFk.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.iFk.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.iFj.setValue(numArr[0].intValue(), ImageProblemActivity.this.iFk.atP);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.iFj.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.iFj.complete();
            ImageProblemActivity.this.iFl = null;
        }
    }
}
