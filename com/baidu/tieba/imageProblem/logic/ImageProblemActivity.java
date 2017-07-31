package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dHb;
    ImageProblemAssistant dHc;
    CheckTask dHd;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dHc = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dHb = new ImageProblemView(this, this.dHc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dHd != null) {
            this.dHd.cancel();
            this.dHd = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dHb.getCheckButton()) {
            if (this.dHd == null) {
                this.dHb.getCheckButton().setText(getResources().getText(d.l.stop));
                this.dHd = new CheckTask();
                this.dHd.execute(new Object[0]);
                return;
            }
            this.dHb.getCheckButton().setText(getResources().getText(d.l.diagnose));
            if (this.dHd != null) {
                this.dHd.cancel();
                this.dHd = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dHb.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dHb.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dHc.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dHc.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dHc.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dHc.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dHc.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dHc.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dHc.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dHb.setValue(numArr[0].intValue(), ImageProblemActivity.this.dHc.dHg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dHb.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.l.diagnose));
            ImageProblemActivity.this.dHb.complete();
            ImageProblemActivity.this.dHd = null;
        }
    }
}
