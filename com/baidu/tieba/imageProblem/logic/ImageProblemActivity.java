package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView bMj;
    ImageProblemAssistant bMk;
    CheckTask bMl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bMk = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.bMj = new ImageProblemView(this, this.bMk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bMl != null) {
            this.bMl.cancel();
            this.bMl = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bMj.getCheckButton()) {
            if (this.bMl == null) {
                this.bMj.getCheckButton().setText(getResources().getText(i.C0057i.stop));
                this.bMl = new CheckTask(this, null);
                this.bMl.execute(new Object[0]);
                return;
            }
            this.bMj.getCheckButton().setText(getResources().getText(i.C0057i.diagnose));
            if (this.bMl != null) {
                this.bMl.cancel();
                this.bMl = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bMj.onChangeSkinType(i);
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
            ImageProblemActivity.this.bMj.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.bMk.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.bMk.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.bMk.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.bMk.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.bMk.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.bMk.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.bMk.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.bMj.setValue(numArr[0].intValue(), ImageProblemActivity.this.bMk.bMo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.bMj.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(i.C0057i.diagnose));
            ImageProblemActivity.this.bMj.complete();
            ImageProblemActivity.this.bMl = null;
        }
    }
}
