package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView bvv;
    ImageProblemAssistant bvw;
    CheckTask bvx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bvw = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.bvv = new ImageProblemView(this, this.bvw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bvx != null) {
            this.bvx.cancel();
            this.bvx = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvv.getCheckButton()) {
            if (this.bvx == null) {
                this.bvv.getCheckButton().setText(getResources().getText(y.stop));
                this.bvx = new CheckTask(this, null);
                this.bvx.execute(new Object[0]);
                return;
            }
            this.bvv.getCheckButton().setText(getResources().getText(y.diagnose));
            if (this.bvx != null) {
                this.bvx.cancel();
                this.bvx = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bvv.onChangeSkinType(i);
    }

    /* loaded from: classes.dex */
    class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.bvv.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.bvw.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.bvw.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.bvw.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.bvw.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.bvw.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.bvw.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.bvw.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.bvv.setValue(numArr[0].intValue(), ImageProblemActivity.this.bvw.bvA);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.bvv.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(y.diagnose));
            ImageProblemActivity.this.bvv.complete();
            ImageProblemActivity.this.bvx = null;
        }
    }
}
