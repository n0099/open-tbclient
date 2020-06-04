package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView iUV;
    ImageProblemAssistant iUW;
    CheckTask iUX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iUW = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.iUV = new ImageProblemView(this, this.iUW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iUX != null) {
            this.iUX.cancel();
            this.iUX = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iUV.getCheckButton()) {
            if (this.iUX == null) {
                this.iUV.getCheckButton().setText(getResources().getText(R.string.stop));
                this.iUX = new CheckTask();
                this.iUX.execute(new Object[0]);
                return;
            }
            this.iUV.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.iUX != null) {
                this.iUX.cancel();
                this.iUX = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iUV.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.iUV.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.iUW.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.iUW.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.iUW.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.iUW.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.iUW.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.iUW.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.iUW.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.iUV.setValue(numArr[0].intValue(), ImageProblemActivity.this.iUW.ayS);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.iUV.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.iUV.complete();
            ImageProblemActivity.this.iUX = null;
        }
    }
}
