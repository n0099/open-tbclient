package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView clq;
    ImageProblemAssistant clr;
    CheckTask cls;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.clr = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.clq = new ImageProblemView(this, this.clr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cls != null) {
            this.cls.cancel();
            this.cls = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.clq.getCheckButton()) {
            if (this.cls == null) {
                this.clq.getCheckButton().setText(getResources().getText(n.j.stop));
                this.cls = new CheckTask(this, null);
                this.cls.execute(new Object[0]);
                return;
            }
            this.clq.getCheckButton().setText(getResources().getText(n.j.diagnose));
            if (this.cls != null) {
                this.cls.cancel();
                this.cls = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.clq.onChangeSkinType(i);
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
            ImageProblemActivity.this.clq.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.clr.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.clr.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.clr.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.clr.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.clr.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.clr.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.clr.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.clq.setValue(numArr[0].intValue(), ImageProblemActivity.this.clr.clv);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.clq.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(n.j.diagnose));
            ImageProblemActivity.this.clq.complete();
            ImageProblemActivity.this.cls = null;
        }
    }
}
