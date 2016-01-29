package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView cpR;
    ImageProblemAssistant cpS;
    CheckTask cpT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cpS = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.cpR = new ImageProblemView(this, this.cpS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cpT != null) {
            this.cpT.cancel();
            this.cpT = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cpR.getCheckButton()) {
            if (this.cpT == null) {
                this.cpR.getCheckButton().setText(getResources().getText(t.j.stop));
                this.cpT = new CheckTask(this, null);
                this.cpT.execute(new Object[0]);
                return;
            }
            this.cpR.getCheckButton().setText(getResources().getText(t.j.diagnose));
            if (this.cpT != null) {
                this.cpT.cancel();
                this.cpT = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cpR.onChangeSkinType(i);
    }

    /* loaded from: classes.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.cpR.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.cpS.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.cpS.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.cpS.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.cpS.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.cpS.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.cpS.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.cpS.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.cpR.setValue(numArr[0].intValue(), ImageProblemActivity.this.cpS.cpW);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.cpR.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(t.j.diagnose));
            ImageProblemActivity.this.cpR.complete();
            ImageProblemActivity.this.cpT = null;
        }
    }
}
