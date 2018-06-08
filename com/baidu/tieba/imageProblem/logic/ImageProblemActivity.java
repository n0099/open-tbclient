package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eDK;
    ImageProblemAssistant eDL;
    CheckTask eDM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eDL = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eDK = new ImageProblemView(this, this.eDL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eDM != null) {
            this.eDM.cancel();
            this.eDM = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eDK.getCheckButton()) {
            if (this.eDM == null) {
                this.eDK.getCheckButton().setText(getResources().getText(d.k.stop));
                this.eDM = new CheckTask();
                this.eDM.execute(new Object[0]);
                return;
            }
            this.eDK.getCheckButton().setText(getResources().getText(d.k.diagnose));
            if (this.eDM != null) {
                this.eDM.cancel();
                this.eDM = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eDK.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eDK.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eDL.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eDL.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eDL.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eDL.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eDL.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eDL.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eDL.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eDK.setValue(numArr[0].intValue(), ImageProblemActivity.this.eDL.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eDK.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.k.diagnose));
            ImageProblemActivity.this.eDK.complete();
            ImageProblemActivity.this.eDM = null;
        }
    }
}
