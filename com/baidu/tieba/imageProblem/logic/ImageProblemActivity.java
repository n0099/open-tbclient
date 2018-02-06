package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eWE;
    ImageProblemAssistant eWF;
    CheckTask eWG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eWF = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eWE = new ImageProblemView(this, this.eWF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eWG != null) {
            this.eWG.cancel();
            this.eWG = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eWE.getCheckButton()) {
            if (this.eWG == null) {
                this.eWE.getCheckButton().setText(getResources().getText(d.j.stop));
                this.eWG = new CheckTask();
                this.eWG.execute(new Object[0]);
                return;
            }
            this.eWE.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.eWG != null) {
                this.eWG.cancel();
                this.eWG = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eWE.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eWE.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eWF.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eWF.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eWF.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eWF.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eWF.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eWF.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eWF.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eWE.setValue(numArr[0].intValue(), ImageProblemActivity.this.eWF.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eWE.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.eWE.complete();
            ImageProblemActivity.this.eWG = null;
        }
    }
}
