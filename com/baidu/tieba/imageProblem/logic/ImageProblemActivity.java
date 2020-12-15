package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kNT;
    ImageProblemAssistant kNU;
    CheckTask kNV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kNU = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kNT = new ImageProblemView(this, this.kNU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kNV != null) {
            this.kNV.cancel();
            this.kNV = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kNT.getCheckButton()) {
            if (this.kNV == null) {
                this.kNT.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kNV = new CheckTask();
                this.kNV.execute(new Object[0]);
                return;
            }
            this.kNT.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kNV != null) {
                this.kNV.cancel();
                this.kNV = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kNT.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kNT.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kNU.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kNU.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kNU.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kNU.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kNU.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kNU.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kNU.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kNT.setValue(numArr[0].intValue(), ImageProblemActivity.this.kNU.aPa);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kNT.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kNT.complete();
            ImageProblemActivity.this.kNV = null;
        }
    }
}
