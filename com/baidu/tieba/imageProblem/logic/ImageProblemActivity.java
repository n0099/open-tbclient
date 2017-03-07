package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView doZ;
    ImageProblemAssistant dpa;
    CheckTask dpb;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dpa = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.doZ = new ImageProblemView(this, this.dpa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dpb != null) {
            this.dpb.cancel();
            this.dpb = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.doZ.getCheckButton()) {
            if (this.dpb == null) {
                this.doZ.getCheckButton().setText(getResources().getText(w.l.stop));
                this.dpb = new CheckTask(this, null);
                this.dpb.execute(new Object[0]);
                return;
            }
            this.doZ.getCheckButton().setText(getResources().getText(w.l.diagnose));
            if (this.dpb != null) {
                this.dpb.cancel();
                this.dpb = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.doZ.onChangeSkinType(i);
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
            ImageProblemActivity.this.doZ.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dpa.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dpa.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dpa.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dpa.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dpa.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dpa.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dpa.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.doZ.setValue(numArr[0].intValue(), ImageProblemActivity.this.dpa.dpe);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.doZ.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(w.l.diagnose));
            ImageProblemActivity.this.doZ.complete();
            ImageProblemActivity.this.dpb = null;
        }
    }
}
