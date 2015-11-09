package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView bQY;
    ImageProblemAssistant bQZ;
    CheckTask bRa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bQZ = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.bQY = new ImageProblemView(this, this.bQZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bRa != null) {
            this.bRa.cancel();
            this.bRa = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bQY.getCheckButton()) {
            if (this.bRa == null) {
                this.bQY.getCheckButton().setText(getResources().getText(i.h.stop));
                this.bRa = new CheckTask(this, null);
                this.bRa.execute(new Object[0]);
                return;
            }
            this.bQY.getCheckButton().setText(getResources().getText(i.h.diagnose));
            if (this.bRa != null) {
                this.bRa.cancel();
                this.bRa = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bQY.onChangeSkinType(i);
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
            ImageProblemActivity.this.bQY.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.bQZ.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.bQZ.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.bQZ.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.bQZ.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.bQZ.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.bQZ.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.bQZ.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.bQY.setValue(numArr[0].intValue(), ImageProblemActivity.this.bQZ.bRd);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.bQY.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(i.h.diagnose));
            ImageProblemActivity.this.bQY.complete();
            ImageProblemActivity.this.bRa = null;
        }
    }
}
