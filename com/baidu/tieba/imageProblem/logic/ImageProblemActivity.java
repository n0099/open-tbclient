package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView bvL;
    ImageProblemAssistant bvM;
    CheckTask bvN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bvM = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.bvL = new ImageProblemView(this, this.bvM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bvN != null) {
            this.bvN.cancel();
            this.bvN = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvL.getCheckButton()) {
            if (this.bvN == null) {
                this.bvL.getCheckButton().setText(getResources().getText(y.stop));
                this.bvN = new CheckTask(this, null);
                this.bvN.execute(new Object[0]);
                return;
            }
            this.bvL.getCheckButton().setText(getResources().getText(y.diagnose));
            if (this.bvN != null) {
                this.bvN.cancel();
                this.bvN = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bvL.onChangeSkinType(i);
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
            ImageProblemActivity.this.bvL.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.bvM.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.bvM.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.bvM.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.bvM.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.bvM.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.bvM.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.bvM.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.bvL.setValue(numArr[0].intValue(), ImageProblemActivity.this.bvM.bvQ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.bvL.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(y.diagnose));
            ImageProblemActivity.this.bvL.complete();
            ImageProblemActivity.this.bvN = null;
        }
    }
}
