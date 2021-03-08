package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kZk;
    ImageProblemAssistant kZl;
    CheckTask kZm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZl = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kZk = new ImageProblemView(this, this.kZl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kZm != null) {
            this.kZm.cancel();
            this.kZm = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kZk.getCheckButton()) {
            if (this.kZm == null) {
                this.kZk.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kZm = new CheckTask();
                this.kZm.execute(new Object[0]);
                return;
            }
            this.kZk.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kZm != null) {
                this.kZm.cancel();
                this.kZm = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kZk.onChangeSkinType(i);
    }

    /* loaded from: classes7.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kZk.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kZl.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kZl.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kZl.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kZl.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kZl.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kZl.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kZl.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kZk.setValue(numArr[0].intValue(), ImageProblemActivity.this.kZl.aPq);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kZk.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kZk.complete();
            ImageProblemActivity.this.kZm = null;
        }
    }
}
