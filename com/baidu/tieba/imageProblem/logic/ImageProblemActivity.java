package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView khQ;
    ImageProblemAssistant khR;
    CheckTask khS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.khR = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.khQ = new ImageProblemView(this, this.khR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.khS != null) {
            this.khS.cancel();
            this.khS = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.khQ.getCheckButton()) {
            if (this.khS == null) {
                this.khQ.getCheckButton().setText(getResources().getText(R.string.stop));
                this.khS = new CheckTask();
                this.khS.execute(new Object[0]);
                return;
            }
            this.khQ.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.khS != null) {
                this.khS.cancel();
                this.khS = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.khQ.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.khQ.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.khR.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.khR.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.khR.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.khR.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.khR.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.khR.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.khR.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.khQ.setValue(numArr[0].intValue(), ImageProblemActivity.this.khR.aMh);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.khQ.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.khQ.complete();
            ImageProblemActivity.this.khS = null;
        }
    }
}
