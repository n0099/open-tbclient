package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kAk;
    ImageProblemAssistant kAl;
    CheckTask kAm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kAl = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kAk = new ImageProblemView(this, this.kAl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kAm != null) {
            this.kAm.cancel();
            this.kAm = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kAk.getCheckButton()) {
            if (this.kAm == null) {
                this.kAk.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kAm = new CheckTask();
                this.kAm.execute(new Object[0]);
                return;
            }
            this.kAk.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kAm != null) {
                this.kAm.cancel();
                this.kAm = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kAk.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kAk.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kAl.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kAl.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kAl.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kAl.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kAl.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kAl.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kAl.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kAk.setValue(numArr[0].intValue(), ImageProblemActivity.this.kAl.aNO);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kAk.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kAk.complete();
            ImageProblemActivity.this.kAm = null;
        }
    }
}
