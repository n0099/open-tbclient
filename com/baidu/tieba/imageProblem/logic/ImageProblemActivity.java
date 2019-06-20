package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gTH;
    ImageProblemAssistant gTI;
    CheckTask gTJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gTI = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gTH = new ImageProblemView(this, this.gTI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gTJ != null) {
            this.gTJ.cancel();
            this.gTJ = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gTH.getCheckButton()) {
            if (this.gTJ == null) {
                this.gTH.getCheckButton().setText(getResources().getText(R.string.stop));
                this.gTJ = new CheckTask();
                this.gTJ.execute(new Object[0]);
                return;
            }
            this.gTH.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.gTJ != null) {
                this.gTJ.cancel();
                this.gTJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gTH.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gTH.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gTI.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gTI.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gTI.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gTI.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gTI.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gTI.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gTI.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gTH.setValue(numArr[0].intValue(), ImageProblemActivity.this.gTI.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gTH.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.gTH.complete();
            ImageProblemActivity.this.gTJ = null;
        }
    }
}
