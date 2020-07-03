package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView jmh;
    ImageProblemAssistant jmi;
    CheckTask jmj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jmi = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.jmh = new ImageProblemView(this, this.jmi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jmj != null) {
            this.jmj.cancel();
            this.jmj = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jmh.getCheckButton()) {
            if (this.jmj == null) {
                this.jmh.getCheckButton().setText(getResources().getText(R.string.stop));
                this.jmj = new CheckTask();
                this.jmj.execute(new Object[0]);
                return;
            }
            this.jmh.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.jmj != null) {
                this.jmj.cancel();
                this.jmj = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jmh.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.jmh.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.jmi.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.jmi.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.jmi.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.jmi.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.jmi.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.jmi.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.jmi.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.jmh.setValue(numArr[0].intValue(), ImageProblemActivity.this.jmi.aBj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.jmh.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.jmh.complete();
            ImageProblemActivity.this.jmj = null;
        }
    }
}
