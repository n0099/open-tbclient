package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView fmq;
    ImageProblemAssistant fmr;
    CheckTask fms;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fmr = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.fmq = new ImageProblemView(this, this.fmr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fms != null) {
            this.fms.cancel();
            this.fms = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmq.getCheckButton()) {
            if (this.fms == null) {
                this.fmq.getCheckButton().setText(getResources().getText(e.j.stop));
                this.fms = new CheckTask();
                this.fms.execute(new Object[0]);
                return;
            }
            this.fmq.getCheckButton().setText(getResources().getText(e.j.diagnose));
            if (this.fms != null) {
                this.fms.cancel();
                this.fms = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fmq.onChangeSkinType(i);
    }

    /* loaded from: classes4.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.fmq.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.fmr.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.fmr.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.fmr.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.fmr.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.fmr.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.fmr.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.fmr.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.fmq.setValue(numArr[0].intValue(), ImageProblemActivity.this.fmr.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.fmq.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(e.j.diagnose));
            ImageProblemActivity.this.fmq.complete();
            ImageProblemActivity.this.fms = null;
        }
    }
}
