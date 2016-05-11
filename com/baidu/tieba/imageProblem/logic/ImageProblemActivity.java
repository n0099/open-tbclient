package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView cBr;
    ImageProblemAssistant cBs;
    CheckTask cBt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cBs = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.cBr = new ImageProblemView(this, this.cBs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cBt != null) {
            this.cBt.cancel();
            this.cBt = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cBr.getCheckButton()) {
            if (this.cBt == null) {
                this.cBr.getCheckButton().setText(getResources().getText(t.j.stop));
                this.cBt = new CheckTask(this, null);
                this.cBt.execute(new Object[0]);
                return;
            }
            this.cBr.getCheckButton().setText(getResources().getText(t.j.diagnose));
            if (this.cBt != null) {
                this.cBt.cancel();
                this.cBt = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cBr.onChangeSkinType(i);
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
            ImageProblemActivity.this.cBr.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.cBs.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.cBs.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.cBs.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.cBs.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.cBs.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.cBs.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.cBs.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.cBr.setValue(numArr[0].intValue(), ImageProblemActivity.this.cBs.cBw);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.cBr.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(t.j.diagnose));
            ImageProblemActivity.this.cBr.complete();
            ImageProblemActivity.this.cBt = null;
        }
    }
}
