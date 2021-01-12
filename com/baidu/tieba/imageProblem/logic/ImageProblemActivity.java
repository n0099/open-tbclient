package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kOS;
    ImageProblemAssistant kOT;
    CheckTask kOU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kOT = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kOS = new ImageProblemView(this, this.kOT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kOU != null) {
            this.kOU.cancel();
            this.kOU = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kOS.getCheckButton()) {
            if (this.kOU == null) {
                this.kOS.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kOU = new CheckTask();
                this.kOU.execute(new Object[0]);
                return;
            }
            this.kOS.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kOU != null) {
                this.kOU.cancel();
                this.kOU = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kOS.onChangeSkinType(i);
    }

    /* loaded from: classes7.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kOS.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kOT.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kOT.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kOT.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kOT.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kOT.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kOT.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kOT.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kOS.setValue(numArr[0].intValue(), ImageProblemActivity.this.kOT.aKU);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kOS.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kOS.complete();
            ImageProblemActivity.this.kOU = null;
        }
    }
}
