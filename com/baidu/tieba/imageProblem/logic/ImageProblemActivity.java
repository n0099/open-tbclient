package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    CheckTask dCA;
    ImageProblemView dCy;
    ImageProblemAssistant dCz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dCz = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dCy = new ImageProblemView(this, this.dCz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dCA != null) {
            this.dCA.cancel();
            this.dCA = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dCy.getCheckButton()) {
            if (this.dCA == null) {
                this.dCy.getCheckButton().setText(getResources().getText(r.j.stop));
                this.dCA = new CheckTask(this, null);
                this.dCA.execute(new Object[0]);
                return;
            }
            this.dCy.getCheckButton().setText(getResources().getText(r.j.diagnose));
            if (this.dCA != null) {
                this.dCA.cancel();
                this.dCA = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dCy.onChangeSkinType(i);
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
            ImageProblemActivity.this.dCy.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dCz.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dCz.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dCz.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dCz.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dCz.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dCz.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dCz.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dCy.setValue(numArr[0].intValue(), ImageProblemActivity.this.dCz.dCD);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dCy.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(r.j.diagnose));
            ImageProblemActivity.this.dCy.complete();
            ImageProblemActivity.this.dCA = null;
        }
    }
}
