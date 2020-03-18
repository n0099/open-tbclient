package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView hVm;
    ImageProblemAssistant hVn;
    CheckTask hVo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hVn = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.hVm = new ImageProblemView(this, this.hVn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hVo != null) {
            this.hVo.cancel();
            this.hVo = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVm.getCheckButton()) {
            if (this.hVo == null) {
                this.hVm.getCheckButton().setText(getResources().getText(R.string.stop));
                this.hVo = new CheckTask();
                this.hVo.execute(new Object[0]);
                return;
            }
            this.hVm.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.hVo != null) {
                this.hVo.cancel();
                this.hVo = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hVm.onChangeSkinType(i);
    }

    /* loaded from: classes6.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.hVm.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.hVn.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.hVn.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.hVn.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.hVn.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.hVn.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.hVn.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.hVn.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.hVm.setValue(numArr[0].intValue(), ImageProblemActivity.this.hVn.abp);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.hVm.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.hVm.complete();
            ImageProblemActivity.this.hVo = null;
        }
    }
}
