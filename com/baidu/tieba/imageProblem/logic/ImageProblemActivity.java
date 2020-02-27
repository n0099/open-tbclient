package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    CheckTask hTA;
    ImageProblemView hTy;
    ImageProblemAssistant hTz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hTz = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.hTy = new ImageProblemView(this, this.hTz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hTA != null) {
            this.hTA.cancel();
            this.hTA = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hTy.getCheckButton()) {
            if (this.hTA == null) {
                this.hTy.getCheckButton().setText(getResources().getText(R.string.stop));
                this.hTA = new CheckTask();
                this.hTA.execute(new Object[0]);
                return;
            }
            this.hTy.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.hTA != null) {
                this.hTA.cancel();
                this.hTA = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hTy.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.hTy.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.hTz.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.hTz.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.hTz.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.hTz.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.hTz.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.hTz.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.hTz.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.hTy.setValue(numArr[0].intValue(), ImageProblemActivity.this.hTz.abf);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.hTy.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.hTy.complete();
            ImageProblemActivity.this.hTA = null;
        }
    }
}
