package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dIX;
    ImageProblemAssistant dIY;
    CheckTask dIZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dIY = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dIX = new ImageProblemView(this, this.dIY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dIZ != null) {
            this.dIZ.cancel();
            this.dIZ = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dIX.getCheckButton()) {
            if (this.dIZ == null) {
                this.dIX.getCheckButton().setText(getResources().getText(d.l.stop));
                this.dIZ = new CheckTask();
                this.dIZ.execute(new Object[0]);
                return;
            }
            this.dIX.getCheckButton().setText(getResources().getText(d.l.diagnose));
            if (this.dIZ != null) {
                this.dIZ.cancel();
                this.dIZ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dIX.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dIX.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dIY.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dIY.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dIY.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dIY.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dIY.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dIY.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dIY.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dIX.setValue(numArr[0].intValue(), ImageProblemActivity.this.dIY.dJc);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dIX.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.l.diagnose));
            ImageProblemActivity.this.dIX.complete();
            ImageProblemActivity.this.dIZ = null;
        }
    }
}
