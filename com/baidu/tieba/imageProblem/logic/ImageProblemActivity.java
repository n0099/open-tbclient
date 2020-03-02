package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView hTA;
    ImageProblemAssistant hTB;
    CheckTask hTC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hTB = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.hTA = new ImageProblemView(this, this.hTB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hTC != null) {
            this.hTC.cancel();
            this.hTC = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hTA.getCheckButton()) {
            if (this.hTC == null) {
                this.hTA.getCheckButton().setText(getResources().getText(R.string.stop));
                this.hTC = new CheckTask();
                this.hTC.execute(new Object[0]);
                return;
            }
            this.hTA.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.hTC != null) {
                this.hTC.cancel();
                this.hTC = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hTA.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.hTA.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.hTB.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.hTB.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.hTB.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.hTB.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.hTB.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.hTB.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.hTB.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.hTA.setValue(numArr[0].intValue(), ImageProblemActivity.this.hTB.abf);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.hTA.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.hTA.complete();
            ImageProblemActivity.this.hTC = null;
        }
    }
}
