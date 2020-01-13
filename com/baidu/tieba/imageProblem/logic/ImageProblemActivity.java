package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView hRA;
    ImageProblemAssistant hRB;
    CheckTask hRC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hRB = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.hRA = new ImageProblemView(this, this.hRB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hRC != null) {
            this.hRC.cancel();
            this.hRC = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hRA.getCheckButton()) {
            if (this.hRC == null) {
                this.hRA.getCheckButton().setText(getResources().getText(R.string.stop));
                this.hRC = new CheckTask();
                this.hRC.execute(new Object[0]);
                return;
            }
            this.hRA.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.hRC != null) {
                this.hRC.cancel();
                this.hRC = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hRA.onChangeSkinType(i);
    }

    /* loaded from: classes5.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.hRA.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.hRB.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.hRB.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.hRB.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.hRB.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.hRB.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.hRB.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.hRB.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.hRA.setValue(numArr[0].intValue(), ImageProblemActivity.this.hRB.Zm);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.hRA.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.hRA.complete();
            ImageProblemActivity.this.hRC = null;
        }
    }
}
