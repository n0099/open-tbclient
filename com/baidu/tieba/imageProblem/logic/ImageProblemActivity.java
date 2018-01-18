package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eQM;
    ImageProblemAssistant eQN;
    CheckTask eQO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eQN = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eQM = new ImageProblemView(this, this.eQN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eQO != null) {
            this.eQO.cancel();
            this.eQO = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eQM.getCheckButton()) {
            if (this.eQO == null) {
                this.eQM.getCheckButton().setText(getResources().getText(d.j.stop));
                this.eQO = new CheckTask();
                this.eQO.execute(new Object[0]);
                return;
            }
            this.eQM.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.eQO != null) {
                this.eQO.cancel();
                this.eQO = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eQM.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eQM.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eQN.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eQN.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eQN.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eQN.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eQN.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eQN.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eQN.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.eQM.setValue(numArr[0].intValue(), ImageProblemActivity.this.eQN.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eQM.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.eQM.complete();
            ImageProblemActivity.this.eQO = null;
        }
    }
}
