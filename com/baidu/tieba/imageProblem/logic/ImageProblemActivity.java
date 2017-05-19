package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView djT;
    ImageProblemAssistant djU;
    CheckTask djV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djU = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.djT = new ImageProblemView(this, this.djU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.djV != null) {
            this.djV.cancel();
            this.djV = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.djT.getCheckButton()) {
            if (this.djV == null) {
                this.djT.getCheckButton().setText(getResources().getText(w.l.stop));
                this.djV = new CheckTask(this, null);
                this.djV.execute(new Object[0]);
                return;
            }
            this.djT.getCheckButton().setText(getResources().getText(w.l.diagnose));
            if (this.djV != null) {
                this.djV.cancel();
                this.djV = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.djT.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.djT.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.djU.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.djU.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.djU.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.djU.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.djU.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.djU.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.djU.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.djT.setValue(numArr[0].intValue(), ImageProblemActivity.this.djU.djY);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.djT.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(w.l.diagnose));
            ImageProblemActivity.this.djT.complete();
            ImageProblemActivity.this.djV = null;
        }
    }
}
