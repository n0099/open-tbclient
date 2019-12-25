package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView hNX;
    ImageProblemAssistant hNY;
    CheckTask hNZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hNY = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.hNX = new ImageProblemView(this, this.hNY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hNZ != null) {
            this.hNZ.cancel();
            this.hNZ = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hNX.getCheckButton()) {
            if (this.hNZ == null) {
                this.hNX.getCheckButton().setText(getResources().getText(R.string.stop));
                this.hNZ = new CheckTask();
                this.hNZ.execute(new Object[0]);
                return;
            }
            this.hNX.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.hNZ != null) {
                this.hNZ.cancel();
                this.hNZ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hNX.onChangeSkinType(i);
    }

    /* loaded from: classes4.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.hNX.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.hNY.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.hNY.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.hNY.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.hNY.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.hNY.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.hNY.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.hNY.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.hNX.setValue(numArr[0].intValue(), ImageProblemActivity.this.hNY.YY);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.hNX.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.hNX.complete();
            ImageProblemActivity.this.hNZ = null;
        }
    }
}
