package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView jKp;
    ImageProblemAssistant jKq;
    CheckTask jKr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKq = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.jKp = new ImageProblemView(this, this.jKq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jKr != null) {
            this.jKr.cancel();
            this.jKr = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jKp.getCheckButton()) {
            if (this.jKr == null) {
                this.jKp.getCheckButton().setText(getResources().getText(R.string.stop));
                this.jKr = new CheckTask();
                this.jKr.execute(new Object[0]);
                return;
            }
            this.jKp.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.jKr != null) {
                this.jKr.cancel();
                this.jKr = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jKp.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.jKp.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.jKq.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.jKq.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.jKq.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.jKq.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.jKq.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.jKq.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.jKq.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.jKp.setValue(numArr[0].intValue(), ImageProblemActivity.this.jKq.aHI);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.jKp.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.jKp.complete();
            ImageProblemActivity.this.jKr = null;
        }
    }
}
