package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView bQs;
    ImageProblemAssistant bQt;
    CheckTask bQu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bQt = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.bQs = new ImageProblemView(this, this.bQt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bQu != null) {
            this.bQu.cancel();
            this.bQu = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bQs.getCheckButton()) {
            if (this.bQu == null) {
                this.bQs.getCheckButton().setText(getResources().getText(i.h.stop));
                this.bQu = new CheckTask(this, null);
                this.bQu.execute(new Object[0]);
                return;
            }
            this.bQs.getCheckButton().setText(getResources().getText(i.h.diagnose));
            if (this.bQu != null) {
                this.bQu.cancel();
                this.bQu = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bQs.onChangeSkinType(i);
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
            ImageProblemActivity.this.bQs.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.bQt.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.bQt.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.bQt.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.bQt.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.bQt.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.bQt.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.bQt.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.bQs.setValue(numArr[0].intValue(), ImageProblemActivity.this.bQt.bQx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.bQs.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(i.h.diagnose));
            ImageProblemActivity.this.bQs.complete();
            ImageProblemActivity.this.bQu = null;
        }
    }
}
