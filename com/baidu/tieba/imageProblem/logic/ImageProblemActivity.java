package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView fbN;
    ImageProblemAssistant fbO;
    CheckTask fbP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fbO = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.fbN = new ImageProblemView(this, this.fbO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fbP != null) {
            this.fbP.cancel();
            this.fbP = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbN.getCheckButton()) {
            if (this.fbP == null) {
                this.fbN.getCheckButton().setText(getResources().getText(e.j.stop));
                this.fbP = new CheckTask();
                this.fbP.execute(new Object[0]);
                return;
            }
            this.fbN.getCheckButton().setText(getResources().getText(e.j.diagnose));
            if (this.fbP != null) {
                this.fbP.cancel();
                this.fbP = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fbN.onChangeSkinType(i);
    }

    /* loaded from: classes4.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.fbN.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.fbO.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.fbO.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.fbO.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.fbO.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.fbO.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.fbO.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.fbO.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.fbN.setValue(numArr[0].intValue(), ImageProblemActivity.this.fbO.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.fbN.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(e.j.diagnose));
            ImageProblemActivity.this.fbN.complete();
            ImageProblemActivity.this.fbP = null;
        }
    }
}
