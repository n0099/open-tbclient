package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dpP;
    ImageProblemAssistant dpQ;
    CheckTask dpR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dpQ = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dpP = new ImageProblemView(this, this.dpQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dpR != null) {
            this.dpR.cancel();
            this.dpR = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dpP.getCheckButton()) {
            if (this.dpR == null) {
                this.dpP.getCheckButton().setText(getResources().getText(w.l.stop));
                this.dpR = new CheckTask(this, null);
                this.dpR.execute(new Object[0]);
                return;
            }
            this.dpP.getCheckButton().setText(getResources().getText(w.l.diagnose));
            if (this.dpR != null) {
                this.dpR.cancel();
                this.dpR = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dpP.onChangeSkinType(i);
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
            ImageProblemActivity.this.dpP.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dpQ.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dpQ.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dpQ.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dpQ.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dpQ.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dpQ.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dpQ.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dpP.setValue(numArr[0].intValue(), ImageProblemActivity.this.dpQ.dpU);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dpP.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(w.l.diagnose));
            ImageProblemActivity.this.dpP.complete();
            ImageProblemActivity.this.dpR = null;
        }
    }
}
