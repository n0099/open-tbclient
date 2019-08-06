package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView haJ;
    ImageProblemAssistant haK;
    CheckTask haL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.haK = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.haJ = new ImageProblemView(this, this.haK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.haL != null) {
            this.haL.cancel();
            this.haL = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.haJ.getCheckButton()) {
            if (this.haL == null) {
                this.haJ.getCheckButton().setText(getResources().getText(R.string.stop));
                this.haL = new CheckTask();
                this.haL.execute(new Object[0]);
                return;
            }
            this.haJ.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.haL != null) {
                this.haL.cancel();
                this.haL = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.haJ.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.haJ.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.haK.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.haK.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.haK.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.haK.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.haK.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.haK.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.haK.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.haJ.setValue(numArr[0].intValue(), ImageProblemActivity.this.haK.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.haJ.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.haJ.complete();
            ImageProblemActivity.this.haL = null;
        }
    }
}
