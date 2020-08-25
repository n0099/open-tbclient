package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView jKj;
    ImageProblemAssistant jKk;
    CheckTask jKl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKk = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.jKj = new ImageProblemView(this, this.jKk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jKl != null) {
            this.jKl.cancel();
            this.jKl = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jKj.getCheckButton()) {
            if (this.jKl == null) {
                this.jKj.getCheckButton().setText(getResources().getText(R.string.stop));
                this.jKl = new CheckTask();
                this.jKl.execute(new Object[0]);
                return;
            }
            this.jKj.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.jKl != null) {
                this.jKl.cancel();
                this.jKl = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jKj.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.jKj.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.jKk.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.jKk.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.jKk.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.jKk.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.jKk.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.jKk.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.jKk.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.jKj.setValue(numArr[0].intValue(), ImageProblemActivity.this.jKk.aHG);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.jKj.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.jKj.complete();
            ImageProblemActivity.this.jKl = null;
        }
    }
}
