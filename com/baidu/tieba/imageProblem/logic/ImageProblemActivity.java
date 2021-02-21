package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kXi;
    ImageProblemAssistant kXj;
    CheckTask kXk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kXj = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kXi = new ImageProblemView(this, this.kXj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kXk != null) {
            this.kXk.cancel();
            this.kXk = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kXi.getCheckButton()) {
            if (this.kXk == null) {
                this.kXi.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kXk = new CheckTask();
                this.kXk.execute(new Object[0]);
                return;
            }
            this.kXi.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kXk != null) {
                this.kXk.cancel();
                this.kXk = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kXi.onChangeSkinType(i);
    }

    /* loaded from: classes8.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kXi.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kXj.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kXj.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kXj.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kXj.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kXj.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kXj.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kXj.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kXi.setValue(numArr[0].intValue(), ImageProblemActivity.this.kXj.aNQ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kXi.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kXi.complete();
            ImageProblemActivity.this.kXk = null;
        }
    }
}
