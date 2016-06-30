package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dgO;
    ImageProblemAssistant dgP;
    CheckTask dgQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dgP = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dgO = new ImageProblemView(this, this.dgP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dgQ != null) {
            this.dgQ.cancel();
            this.dgQ = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dgO.getCheckButton()) {
            if (this.dgQ == null) {
                this.dgO.getCheckButton().setText(getResources().getText(u.j.stop));
                this.dgQ = new CheckTask(this, null);
                this.dgQ.execute(new Object[0]);
                return;
            }
            this.dgO.getCheckButton().setText(getResources().getText(u.j.diagnose));
            if (this.dgQ != null) {
                this.dgQ.cancel();
                this.dgQ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dgO.onChangeSkinType(i);
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
            ImageProblemActivity.this.dgO.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dgP.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dgP.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dgP.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dgP.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dgP.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dgP.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dgP.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dgO.setValue(numArr[0].intValue(), ImageProblemActivity.this.dgP.dgT);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dgO.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(u.j.diagnose));
            ImageProblemActivity.this.dgO.complete();
            ImageProblemActivity.this.dgQ = null;
        }
    }
}
