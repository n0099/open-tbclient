package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView fmr;
    ImageProblemAssistant fms;
    CheckTask fmt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fms = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.fmr = new ImageProblemView(this, this.fms);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fmt != null) {
            this.fmt.cancel();
            this.fmt = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmr.getCheckButton()) {
            if (this.fmt == null) {
                this.fmr.getCheckButton().setText(getResources().getText(e.j.stop));
                this.fmt = new CheckTask();
                this.fmt.execute(new Object[0]);
                return;
            }
            this.fmr.getCheckButton().setText(getResources().getText(e.j.diagnose));
            if (this.fmt != null) {
                this.fmt.cancel();
                this.fmt = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fmr.onChangeSkinType(i);
    }

    /* loaded from: classes4.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.fmr.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.fms.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.fms.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.fms.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.fms.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.fms.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.fms.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.fms.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.fmr.setValue(numArr[0].intValue(), ImageProblemActivity.this.fms.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.fmr.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(e.j.diagnose));
            ImageProblemActivity.this.fmr.complete();
            ImageProblemActivity.this.fmt = null;
        }
    }
}
