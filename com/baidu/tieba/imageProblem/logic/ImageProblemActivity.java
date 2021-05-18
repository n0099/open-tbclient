package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    public ImageProblemAssistant mImageProblemAssistant;
    public CheckTask mTask;
    public ImageProblemView mView;

    /* loaded from: classes4.dex */
    public class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        public CheckTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.mImageProblemAssistant.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.mImageProblemAssistant.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.mImageProblemAssistant.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.mImageProblemAssistant.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.mImageProblemAssistant.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.mImageProblemAssistant.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.mImageProblemAssistant.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.mView.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.mView.complete();
            ImageProblemActivity.this.mTask = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            int intValue = numArr[0].intValue();
            ImageProblemActivity imageProblemActivity = ImageProblemActivity.this;
            imageProblemActivity.mView.setValue(intValue, imageProblemActivity.mImageProblemAssistant.f17793d);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.mView.start();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mView.getCheckButton()) {
            if (this.mTask == null) {
                this.mView.getCheckButton().setText(getResources().getText(R.string.stop));
                CheckTask checkTask = new CheckTask();
                this.mTask = checkTask;
                checkTask.execute(new Object[0]);
                return;
            }
            this.mView.getCheckButton().setText(getResources().getText(R.string.diagnose));
            CheckTask checkTask2 = this.mTask;
            if (checkTask2 != null) {
                checkTask2.cancel();
                this.mTask = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImageProblemAssistant imageProblemAssistant = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.mImageProblemAssistant = imageProblemAssistant;
        this.mView = new ImageProblemView(this, imageProblemAssistant);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CheckTask checkTask = this.mTask;
        if (checkTask != null) {
            checkTask.cancel();
            this.mTask = null;
        }
    }
}
