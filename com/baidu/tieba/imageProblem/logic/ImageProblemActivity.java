package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dFK;
    ImageProblemAssistant dFL;
    CheckTask dFM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dFL = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dFK = new ImageProblemView(this, this.dFL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dFM != null) {
            this.dFM.cancel();
            this.dFM = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dFK.getCheckButton()) {
            if (this.dFM == null) {
                this.dFK.getCheckButton().setText(getResources().getText(d.l.stop));
                this.dFM = new CheckTask();
                this.dFM.execute(new Object[0]);
                return;
            }
            this.dFK.getCheckButton().setText(getResources().getText(d.l.diagnose));
            if (this.dFM != null) {
                this.dFM.cancel();
                this.dFM = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dFK.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dFK.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dFL.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dFL.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dFL.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dFL.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dFL.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dFL.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dFL.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dFK.setValue(numArr[0].intValue(), ImageProblemActivity.this.dFL.dFP);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dFK.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.l.diagnose));
            ImageProblemActivity.this.dFK.complete();
            ImageProblemActivity.this.dFM = null;
        }
    }
}
