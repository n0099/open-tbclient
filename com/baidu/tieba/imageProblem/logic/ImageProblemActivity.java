package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView byt;
    ImageProblemAssistant byu;
    CheckTask byv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byu = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.byt = new ImageProblemView(this, this.byu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.byv != null) {
            this.byv.cancel();
            this.byv = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byt.getCheckButton()) {
            if (this.byv == null) {
                this.byt.getCheckButton().setText(getResources().getText(t.stop));
                this.byv = new CheckTask(this, null);
                this.byv.execute(new Object[0]);
                return;
            }
            this.byt.getCheckButton().setText(getResources().getText(t.diagnose));
            if (this.byv != null) {
                this.byv.cancel();
                this.byv = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.byt.onChangeSkinType(i);
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
            ImageProblemActivity.this.byt.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.byu.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.byu.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.byu.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.byu.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.byu.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.byu.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.byu.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.byt.setValue(numArr[0].intValue(), ImageProblemActivity.this.byu.byy);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.byt.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(t.diagnose));
            ImageProblemActivity.this.byt.complete();
            ImageProblemActivity.this.byv = null;
        }
    }
}
