package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gTC;
    ImageProblemAssistant gTD;
    CheckTask gTE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gTD = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gTC = new ImageProblemView(this, this.gTD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gTE != null) {
            this.gTE.cancel();
            this.gTE = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gTC.getCheckButton()) {
            if (this.gTE == null) {
                this.gTC.getCheckButton().setText(getResources().getText(R.string.stop));
                this.gTE = new CheckTask();
                this.gTE.execute(new Object[0]);
                return;
            }
            this.gTC.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.gTE != null) {
                this.gTE.cancel();
                this.gTE = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gTC.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gTC.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gTD.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gTD.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gTD.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gTD.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gTD.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gTD.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gTD.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gTC.setValue(numArr[0].intValue(), ImageProblemActivity.this.gTD.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gTC.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.gTC.complete();
            ImageProblemActivity.this.gTE = null;
        }
    }
}
