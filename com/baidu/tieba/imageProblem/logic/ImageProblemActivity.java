package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dnx;
    ImageProblemAssistant dny;
    CheckTask dnz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dny = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dnx = new ImageProblemView(this, this.dny);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dnz != null) {
            this.dnz.cancel();
            this.dnz = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dnx.getCheckButton()) {
            if (this.dnz == null) {
                this.dnx.getCheckButton().setText(getResources().getText(w.l.stop));
                this.dnz = new CheckTask(this, null);
                this.dnz.execute(new Object[0]);
                return;
            }
            this.dnx.getCheckButton().setText(getResources().getText(w.l.diagnose));
            if (this.dnz != null) {
                this.dnz.cancel();
                this.dnz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dnx.onChangeSkinType(i);
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
            ImageProblemActivity.this.dnx.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dny.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dny.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dny.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dny.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dny.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dny.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dny.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dnx.setValue(numArr[0].intValue(), ImageProblemActivity.this.dny.dnC);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dnx.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(w.l.diagnose));
            ImageProblemActivity.this.dnx.complete();
            ImageProblemActivity.this.dnz = null;
        }
    }
}
