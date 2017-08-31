package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dPD;
    ImageProblemAssistant dPE;
    CheckTask dPF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dPE = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dPD = new ImageProblemView(this, this.dPE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPF != null) {
            this.dPF.cancel();
            this.dPF = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dPD.getCheckButton()) {
            if (this.dPF == null) {
                this.dPD.getCheckButton().setText(getResources().getText(d.l.stop));
                this.dPF = new CheckTask();
                this.dPF.execute(new Object[0]);
                return;
            }
            this.dPD.getCheckButton().setText(getResources().getText(d.l.diagnose));
            if (this.dPF != null) {
                this.dPF.cancel();
                this.dPF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dPD.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dPD.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dPE.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dPE.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dPE.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dPE.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dPE.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dPE.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dPE.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dPD.setValue(numArr[0].intValue(), ImageProblemActivity.this.dPE.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dPD.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.l.diagnose));
            ImageProblemActivity.this.dPD.complete();
            ImageProblemActivity.this.dPF = null;
        }
    }
}
