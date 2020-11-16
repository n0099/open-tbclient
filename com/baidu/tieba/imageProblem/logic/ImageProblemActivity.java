package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemAssistant kAA;
    CheckTask kAB;
    ImageProblemView kAz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kAA = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kAz = new ImageProblemView(this, this.kAA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kAB != null) {
            this.kAB.cancel();
            this.kAB = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kAz.getCheckButton()) {
            if (this.kAB == null) {
                this.kAz.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kAB = new CheckTask();
                this.kAB.execute(new Object[0]);
                return;
            }
            this.kAz.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kAB != null) {
                this.kAB.cancel();
                this.kAB = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kAz.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kAz.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kAA.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kAA.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kAA.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kAA.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kAA.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kAA.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kAA.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kAz.setValue(numArr[0].intValue(), ImageProblemActivity.this.kAA.aMd);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kAz.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kAz.complete();
            ImageProblemActivity.this.kAB = null;
        }
    }
}
