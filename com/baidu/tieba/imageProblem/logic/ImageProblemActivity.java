package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView cAr;
    ImageProblemAssistant cAs;
    CheckTask cAt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cAs = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.cAr = new ImageProblemView(this, this.cAs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cAt != null) {
            this.cAt.cancel();
            this.cAt = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cAr.getCheckButton()) {
            if (this.cAt == null) {
                this.cAr.getCheckButton().setText(getResources().getText(t.j.stop));
                this.cAt = new CheckTask(this, null);
                this.cAt.execute(new Object[0]);
                return;
            }
            this.cAr.getCheckButton().setText(getResources().getText(t.j.diagnose));
            if (this.cAt != null) {
                this.cAt.cancel();
                this.cAt = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cAr.onChangeSkinType(i);
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
            ImageProblemActivity.this.cAr.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.cAs.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.cAs.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.cAs.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.cAs.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.cAs.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.cAs.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.cAs.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.cAr.setValue(numArr[0].intValue(), ImageProblemActivity.this.cAs.cAw);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.cAr.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(t.j.diagnose));
            ImageProblemActivity.this.cAr.complete();
            ImageProblemActivity.this.cAt = null;
        }
    }
}
