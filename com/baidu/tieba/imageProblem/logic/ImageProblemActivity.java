package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eHA;
    ImageProblemAssistant eHB;
    CheckTask eHC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eHB = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eHA = new ImageProblemView(this, this.eHB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eHC != null) {
            this.eHC.cancel();
            this.eHC = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eHA.getCheckButton()) {
            if (this.eHC == null) {
                this.eHA.getCheckButton().setText(getResources().getText(d.k.stop));
                this.eHC = new CheckTask();
                this.eHC.execute(new Object[0]);
                return;
            }
            this.eHA.getCheckButton().setText(getResources().getText(d.k.diagnose));
            if (this.eHC != null) {
                this.eHC.cancel();
                this.eHC = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eHA.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eHA.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eHB.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eHB.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eHB.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eHB.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eHB.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eHB.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eHB.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eHA.setValue(numArr[0].intValue(), ImageProblemActivity.this.eHB.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eHA.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.k.diagnose));
            ImageProblemActivity.this.eHA.complete();
            ImageProblemActivity.this.eHC = null;
        }
    }
}
