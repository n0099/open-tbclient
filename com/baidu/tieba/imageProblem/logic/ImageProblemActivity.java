package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView est;
    ImageProblemAssistant esu;
    CheckTask esv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.esu = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.est = new ImageProblemView(this, this.esu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.esv != null) {
            this.esv.cancel();
            this.esv = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.est.getCheckButton()) {
            if (this.esv == null) {
                this.est.getCheckButton().setText(getResources().getText(d.k.stop));
                this.esv = new CheckTask();
                this.esv.execute(new Object[0]);
                return;
            }
            this.est.getCheckButton().setText(getResources().getText(d.k.diagnose));
            if (this.esv != null) {
                this.esv.cancel();
                this.esv = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.est.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.est.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.esu.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.esu.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.esu.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.esu.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.esu.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.esu.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.esu.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.est.setValue(numArr[0].intValue(), ImageProblemActivity.this.esu.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.est.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.k.diagnose));
            ImageProblemActivity.this.est.complete();
            ImageProblemActivity.this.esv = null;
        }
    }
}
