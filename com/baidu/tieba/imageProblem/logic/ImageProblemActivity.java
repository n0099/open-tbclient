package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gTF;
    ImageProblemAssistant gTG;
    CheckTask gTH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gTG = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gTF = new ImageProblemView(this, this.gTG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gTH != null) {
            this.gTH.cancel();
            this.gTH = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gTF.getCheckButton()) {
            if (this.gTH == null) {
                this.gTF.getCheckButton().setText(getResources().getText(R.string.stop));
                this.gTH = new CheckTask();
                this.gTH.execute(new Object[0]);
                return;
            }
            this.gTF.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.gTH != null) {
                this.gTH.cancel();
                this.gTH = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gTF.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gTF.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gTG.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gTG.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gTG.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gTG.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gTG.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gTG.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gTG.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gTF.setValue(numArr[0].intValue(), ImageProblemActivity.this.gTG.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gTF.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.gTF.complete();
            ImageProblemActivity.this.gTH = null;
        }
    }
}
