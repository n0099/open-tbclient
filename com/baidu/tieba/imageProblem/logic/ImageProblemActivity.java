package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kuo;
    ImageProblemAssistant kup;
    CheckTask kuq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kup = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kuo = new ImageProblemView(this, this.kup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kuq != null) {
            this.kuq.cancel();
            this.kuq = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kuo.getCheckButton()) {
            if (this.kuq == null) {
                this.kuo.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kuq = new CheckTask();
                this.kuq.execute(new Object[0]);
                return;
            }
            this.kuo.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kuq != null) {
                this.kuq.cancel();
                this.kuq = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kuo.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kuo.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kup.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kup.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kup.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kup.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kup.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kup.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kup.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kuo.setValue(numArr[0].intValue(), ImageProblemActivity.this.kup.aMM);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kuo.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kuo.complete();
            ImageProblemActivity.this.kuq = null;
        }
    }
}
