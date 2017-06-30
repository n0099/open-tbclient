package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dxi;
    ImageProblemAssistant dxj;
    CheckTask dxk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxj = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dxi = new ImageProblemView(this, this.dxj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dxk != null) {
            this.dxk.cancel();
            this.dxk = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dxi.getCheckButton()) {
            if (this.dxk == null) {
                this.dxi.getCheckButton().setText(getResources().getText(w.l.stop));
                this.dxk = new CheckTask(this, null);
                this.dxk.execute(new Object[0]);
                return;
            }
            this.dxi.getCheckButton().setText(getResources().getText(w.l.diagnose));
            if (this.dxk != null) {
                this.dxk.cancel();
                this.dxk = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dxi.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dxi.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dxj.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dxj.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dxj.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dxj.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dxj.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dxj.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dxj.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dxi.setValue(numArr[0].intValue(), ImageProblemActivity.this.dxj.dxn);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dxi.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(w.l.diagnose));
            ImageProblemActivity.this.dxi.complete();
            ImageProblemActivity.this.dxk = null;
        }
    }
}
