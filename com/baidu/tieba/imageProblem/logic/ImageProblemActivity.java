package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kWU;
    ImageProblemAssistant kWV;
    CheckTask kWW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kWV = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kWU = new ImageProblemView(this, this.kWV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kWW != null) {
            this.kWW.cancel();
            this.kWW = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kWU.getCheckButton()) {
            if (this.kWW == null) {
                this.kWU.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kWW = new CheckTask();
                this.kWW.execute(new Object[0]);
                return;
            }
            this.kWU.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kWW != null) {
                this.kWW.cancel();
                this.kWW = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kWU.onChangeSkinType(i);
    }

    /* loaded from: classes8.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kWU.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kWV.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kWV.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kWV.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kWV.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kWV.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kWV.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kWV.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kWU.setValue(numArr[0].intValue(), ImageProblemActivity.this.kWV.aNQ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kWU.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kWU.complete();
            ImageProblemActivity.this.kWW = null;
        }
    }
}
