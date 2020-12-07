package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView kNR;
    ImageProblemAssistant kNS;
    CheckTask kNT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kNS = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.kNR = new ImageProblemView(this, this.kNS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kNT != null) {
            this.kNT.cancel();
            this.kNT = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kNR.getCheckButton()) {
            if (this.kNT == null) {
                this.kNR.getCheckButton().setText(getResources().getText(R.string.stop));
                this.kNT = new CheckTask();
                this.kNT.execute(new Object[0]);
                return;
            }
            this.kNR.getCheckButton().setText(getResources().getText(R.string.diagnose));
            if (this.kNT != null) {
                this.kNT.cancel();
                this.kNT = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kNR.onChangeSkinType(i);
    }

    /* loaded from: classes13.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.kNR.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.kNS.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.kNS.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.kNS.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.kNS.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.kNS.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.kNS.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.kNS.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.kNR.setValue(numArr[0].intValue(), ImageProblemActivity.this.kNS.aPa);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.kNR.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(R.string.diagnose));
            ImageProblemActivity.this.kNR.complete();
            ImageProblemActivity.this.kNT = null;
        }
    }
}
