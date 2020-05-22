package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView iUi;
    ImageProblemAssistant iUj;
    CheckTask iUk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iUj = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.iUi = new ImageProblemView(this, this.iUj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iUk != null) {
            this.iUk.cancel();
            this.iUk = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iUi.getCheckButton()) {
            if (this.iUk == null) {
                this.iUi.getCheckButton().setText(getResources().getText(R.string.stop));
                this.iUk = new CheckTask();
                this.iUk.execute(new Object[0]);
                return;
            }
            this.iUi.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.iUk != null) {
                this.iUk.cancel();
                this.iUk = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iUi.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.iUi.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.iUj.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.iUj.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.iUj.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.iUj.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.iUj.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.iUj.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.iUj.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.iUi.setValue(numArr[0].intValue(), ImageProblemActivity.this.iUj.ayS);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.iUi.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.iUi.complete();
            ImageProblemActivity.this.iUk = null;
        }
    }
}
