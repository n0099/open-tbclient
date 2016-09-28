package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dwU;
    ImageProblemAssistant dwV;
    CheckTask dwW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dwV = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dwU = new ImageProblemView(this, this.dwV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dwW != null) {
            this.dwW.cancel();
            this.dwW = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dwU.getCheckButton()) {
            if (this.dwW == null) {
                this.dwU.getCheckButton().setText(getResources().getText(r.j.stop));
                this.dwW = new CheckTask(this, null);
                this.dwW.execute(new Object[0]);
                return;
            }
            this.dwU.getCheckButton().setText(getResources().getText(r.j.diagnose));
            if (this.dwW != null) {
                this.dwW.cancel();
                this.dwW = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dwU.onChangeSkinType(i);
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
            ImageProblemActivity.this.dwU.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dwV.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dwV.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dwV.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dwV.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dwV.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dwV.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dwV.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dwU.setValue(numArr[0].intValue(), ImageProblemActivity.this.dwV.dwZ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dwU.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(r.j.diagnose));
            ImageProblemActivity.this.dwU.complete();
            ImageProblemActivity.this.dwW = null;
        }
    }
}
