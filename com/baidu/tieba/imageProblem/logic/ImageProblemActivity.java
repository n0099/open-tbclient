package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gCl;
    ImageProblemAssistant gCm;
    CheckTask gCn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCm = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gCl = new ImageProblemView(this, this.gCm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCn != null) {
            this.gCn.cancel();
            this.gCn = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCl.getCheckButton()) {
            if (this.gCn == null) {
                this.gCl.getCheckButton().setText(getResources().getText(d.j.stop));
                this.gCn = new CheckTask();
                this.gCn.execute(new Object[0]);
                return;
            }
            this.gCl.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.gCn != null) {
                this.gCn.cancel();
                this.gCn = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gCl.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gCl.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gCm.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gCm.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gCm.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gCm.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gCm.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gCm.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gCm.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gCl.setValue(numArr[0].intValue(), ImageProblemActivity.this.gCm.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gCl.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.gCl.complete();
            ImageProblemActivity.this.gCn = null;
        }
    }
}
