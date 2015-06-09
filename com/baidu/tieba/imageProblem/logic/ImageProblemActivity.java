package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView byu;
    ImageProblemAssistant byv;
    CheckTask byw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byv = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.byu = new ImageProblemView(this, this.byv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.byw != null) {
            this.byw.cancel();
            this.byw = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byu.getCheckButton()) {
            if (this.byw == null) {
                this.byu.getCheckButton().setText(getResources().getText(t.stop));
                this.byw = new CheckTask(this, null);
                this.byw.execute(new Object[0]);
                return;
            }
            this.byu.getCheckButton().setText(getResources().getText(t.diagnose));
            if (this.byw != null) {
                this.byw.cancel();
                this.byw = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.byu.onChangeSkinType(i);
    }

    /* loaded from: classes.dex */
    class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.byu.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.byv.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.byv.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.byv.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.byv.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.byv.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.byv.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.byv.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.byu.setValue(numArr[0].intValue(), ImageProblemActivity.this.byv.byz);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.byu.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(t.diagnose));
            ImageProblemActivity.this.byu.complete();
            ImageProblemActivity.this.byw = null;
        }
    }
}
