package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView ern;
    ImageProblemAssistant ero;
    CheckTask erp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ero = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.ern = new ImageProblemView(this, this.ero);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.erp != null) {
            this.erp.cancel();
            this.erp = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.ern.getCheckButton()) {
            if (this.erp == null) {
                this.ern.getCheckButton().setText(getResources().getText(d.k.stop));
                this.erp = new CheckTask();
                this.erp.execute(new Object[0]);
                return;
            }
            this.ern.getCheckButton().setText(getResources().getText(d.k.diagnose));
            if (this.erp != null) {
                this.erp.cancel();
                this.erp = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ern.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.ern.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.ero.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.ero.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.ero.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.ero.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.ero.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.ero.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.ero.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.ern.setValue(numArr[0].intValue(), ImageProblemActivity.this.ero.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.ern.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.k.diagnose));
            ImageProblemActivity.this.ern.complete();
            ImageProblemActivity.this.erp = null;
        }
    }
}
