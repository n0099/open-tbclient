package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kTx;
    ImageProblemAssistant kTy;
    CheckTask kTz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kTy = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kTx = new ImageProblemView(this, this.kTy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kTz != null) {
            this.kTz.cancel();
            this.kTz = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kTx.getCheckButton()) {
            if (this.kTz == null) {
                this.kTx.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kTz = new CheckTask();
                this.kTz.execute(new Object[0]);
                return;
            }
            this.kTx.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kTz != null) {
                this.kTz.cancel();
                this.kTz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kTx.onChangeSkinType(i);
    }

    /* loaded from: classes8.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kTx.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kTy.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kTy.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kTy.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kTy.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kTy.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kTy.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kTy.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kTx.setValue(numArr[0].intValue(), ImageProblemActivity.this.kTy.aPH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kTx.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kTx.complete();
            ImageProblemActivity.this.kTz = null;
        }
    }
}
