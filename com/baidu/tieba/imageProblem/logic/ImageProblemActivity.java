package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eRh;
    ImageProblemAssistant eRi;
    CheckTask eRj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eRi = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eRh = new ImageProblemView(this, this.eRi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eRj != null) {
            this.eRj.cancel();
            this.eRj = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eRh.getCheckButton()) {
            if (this.eRj == null) {
                this.eRh.getCheckButton().setText(getResources().getText(d.j.stop));
                this.eRj = new CheckTask();
                this.eRj.execute(new Object[0]);
                return;
            }
            this.eRh.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.eRj != null) {
                this.eRj.cancel();
                this.eRj = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eRh.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eRh.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eRi.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eRi.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eRi.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eRi.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eRi.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eRi.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eRi.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.eRh.setValue(numArr[0].intValue(), ImageProblemActivity.this.eRi.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eRh.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.eRh.complete();
            ImageProblemActivity.this.eRj = null;
        }
    }
}
