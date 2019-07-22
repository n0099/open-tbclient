package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gZR;
    ImageProblemAssistant gZS;
    CheckTask gZT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZS = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gZR = new ImageProblemView(this, this.gZS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gZT != null) {
            this.gZT.cancel();
            this.gZT = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gZR.getCheckButton()) {
            if (this.gZT == null) {
                this.gZR.getCheckButton().setText(getResources().getText(R.string.stop));
                this.gZT = new CheckTask();
                this.gZT.execute(new Object[0]);
                return;
            }
            this.gZR.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.gZT != null) {
                this.gZT.cancel();
                this.gZT = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gZR.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gZR.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gZS.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gZS.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gZS.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gZS.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gZS.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gZS.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gZS.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gZR.setValue(numArr[0].intValue(), ImageProblemActivity.this.gZS.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gZR.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.gZR.complete();
            ImageProblemActivity.this.gZT = null;
        }
    }
}
