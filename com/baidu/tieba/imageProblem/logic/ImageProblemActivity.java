package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView ePm;
    ImageProblemAssistant ePn;
    CheckTask ePo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ePn = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.ePm = new ImageProblemView(this, this.ePn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ePo != null) {
            this.ePo.cancel();
            this.ePo = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ePm.getCheckButton()) {
            if (this.ePo == null) {
                this.ePm.getCheckButton().setText(getResources().getText(d.j.stop));
                this.ePo = new CheckTask();
                this.ePo.execute(new Object[0]);
                return;
            }
            this.ePm.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.ePo != null) {
                this.ePo.cancel();
                this.ePo = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ePm.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.ePm.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.ePn.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.ePn.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.ePn.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.ePn.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.ePn.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.ePn.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.ePn.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.ePm.setValue(numArr[0].intValue(), ImageProblemActivity.this.ePn.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.ePm.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.ePm.complete();
            ImageProblemActivity.this.ePo = null;
        }
    }
}
