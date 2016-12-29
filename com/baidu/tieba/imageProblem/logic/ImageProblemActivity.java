package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dfw;
    ImageProblemAssistant dfx;
    CheckTask dfy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dfx = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dfw = new ImageProblemView(this, this.dfx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfy != null) {
            this.dfy.cancel();
            this.dfy = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dfw.getCheckButton()) {
            if (this.dfy == null) {
                this.dfw.getCheckButton().setText(getResources().getText(r.j.stop));
                this.dfy = new CheckTask(this, null);
                this.dfy.execute(new Object[0]);
                return;
            }
            this.dfw.getCheckButton().setText(getResources().getText(r.j.diagnose));
            if (this.dfy != null) {
                this.dfy.cancel();
                this.dfy = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dfw.onChangeSkinType(i);
    }

    /* loaded from: classes.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dfw.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dfx.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dfx.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dfx.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dfx.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dfx.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dfx.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dfx.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dfw.setValue(numArr[0].intValue(), ImageProblemActivity.this.dfx.dfB);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dfw.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(r.j.diagnose));
            ImageProblemActivity.this.dfw.complete();
            ImageProblemActivity.this.dfy = null;
        }
    }
}
