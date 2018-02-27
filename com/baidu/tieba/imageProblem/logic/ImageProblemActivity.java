package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eWs;
    ImageProblemAssistant eWt;
    CheckTask eWu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eWt = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eWs = new ImageProblemView(this, this.eWt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eWu != null) {
            this.eWu.cancel();
            this.eWu = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eWs.getCheckButton()) {
            if (this.eWu == null) {
                this.eWs.getCheckButton().setText(getResources().getText(d.j.stop));
                this.eWu = new CheckTask();
                this.eWu.execute(new Object[0]);
                return;
            }
            this.eWs.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.eWu != null) {
                this.eWu.cancel();
                this.eWu = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eWs.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eWs.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eWt.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eWt.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eWt.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eWt.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eWt.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eWt.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eWt.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eWs.setValue(numArr[0].intValue(), ImageProblemActivity.this.eWt.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eWs.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.eWs.complete();
            ImageProblemActivity.this.eWu = null;
        }
    }
}
