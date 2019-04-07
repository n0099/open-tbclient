package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gCk;
    ImageProblemAssistant gCl;
    CheckTask gCm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCl = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gCk = new ImageProblemView(this, this.gCl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCm != null) {
            this.gCm.cancel();
            this.gCm = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCk.getCheckButton()) {
            if (this.gCm == null) {
                this.gCk.getCheckButton().setText(getResources().getText(d.j.stop));
                this.gCm = new CheckTask();
                this.gCm.execute(new Object[0]);
                return;
            }
            this.gCk.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.gCm != null) {
                this.gCm.cancel();
                this.gCm = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gCk.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gCk.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gCl.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gCl.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gCl.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gCl.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gCl.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gCl.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gCl.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gCk.setValue(numArr[0].intValue(), ImageProblemActivity.this.gCl.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gCk.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.gCk.complete();
            ImageProblemActivity.this.gCm = null;
        }
    }
}
