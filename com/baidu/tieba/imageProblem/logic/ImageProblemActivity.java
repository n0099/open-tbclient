package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dME;
    ImageProblemAssistant dMF;
    CheckTask dMG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dMF = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dME = new ImageProblemView(this, this.dMF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dMG != null) {
            this.dMG.cancel();
            this.dMG = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dME.getCheckButton()) {
            if (this.dMG == null) {
                this.dME.getCheckButton().setText(getResources().getText(d.l.stop));
                this.dMG = new CheckTask();
                this.dMG.execute(new Object[0]);
                return;
            }
            this.dME.getCheckButton().setText(getResources().getText(d.l.diagnose));
            if (this.dMG != null) {
                this.dMG.cancel();
                this.dMG = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dME.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dME.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dMF.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dMF.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dMF.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dMF.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dMF.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dMF.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dMF.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dME.setValue(numArr[0].intValue(), ImageProblemActivity.this.dMF.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dME.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.l.diagnose));
            ImageProblemActivity.this.dME.complete();
            ImageProblemActivity.this.dMG = null;
        }
    }
}
