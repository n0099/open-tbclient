package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eSK;
    ImageProblemAssistant eSL;
    CheckTask eSM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eSL = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eSK = new ImageProblemView(this, this.eSL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eSM != null) {
            this.eSM.cancel();
            this.eSM = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eSK.getCheckButton()) {
            if (this.eSM == null) {
                this.eSK.getCheckButton().setText(getResources().getText(e.j.stop));
                this.eSM = new CheckTask();
                this.eSM.execute(new Object[0]);
                return;
            }
            this.eSK.getCheckButton().setText(getResources().getText(e.j.diagnose));
            if (this.eSM != null) {
                this.eSM.cancel();
                this.eSM = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eSK.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eSK.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eSL.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eSL.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eSL.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eSL.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eSL.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eSL.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eSL.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eSK.setValue(numArr[0].intValue(), ImageProblemActivity.this.eSL.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eSK.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(e.j.diagnose));
            ImageProblemActivity.this.eSK.complete();
            ImageProblemActivity.this.eSM = null;
        }
    }
}
