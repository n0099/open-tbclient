package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dUd;
    ImageProblemAssistant dUe;
    CheckTask dUf;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dUe = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dUd = new ImageProblemView(this, this.dUe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dUf != null) {
            this.dUf.cancel();
            this.dUf = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dUd.getCheckButton()) {
            if (this.dUf == null) {
                this.dUd.getCheckButton().setText(getResources().getText(d.j.stop));
                this.dUf = new CheckTask();
                this.dUf.execute(new Object[0]);
                return;
            }
            this.dUd.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.dUf != null) {
                this.dUf.cancel();
                this.dUf = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dUd.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dUd.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dUe.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dUe.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dUe.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dUe.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dUe.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dUe.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dUe.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.dUd.setValue(numArr[0].intValue(), ImageProblemActivity.this.dUe.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dUd.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.dUd.complete();
            ImageProblemActivity.this.dUf = null;
        }
    }
}
