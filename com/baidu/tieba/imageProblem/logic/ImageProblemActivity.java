package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView chl;
    ImageProblemAssistant chm;
    CheckTask chn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chm = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.chl = new ImageProblemView(this, this.chm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.chn != null) {
            this.chn.cancel();
            this.chn = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.chl.getCheckButton()) {
            if (this.chn == null) {
                this.chl.getCheckButton().setText(getResources().getText(n.i.stop));
                this.chn = new CheckTask(this, null);
                this.chn.execute(new Object[0]);
                return;
            }
            this.chl.getCheckButton().setText(getResources().getText(n.i.diagnose));
            if (this.chn != null) {
                this.chn.cancel();
                this.chn = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.chl.onChangeSkinType(i);
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
            ImageProblemActivity.this.chl.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.chm.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.chm.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.chm.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.chm.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.chm.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.chm.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.chm.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.chl.setValue(numArr[0].intValue(), ImageProblemActivity.this.chm.chq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.chl.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(n.i.diagnose));
            ImageProblemActivity.this.chl.complete();
            ImageProblemActivity.this.chn = null;
        }
    }
}
