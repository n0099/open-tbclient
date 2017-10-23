package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dMq;
    ImageProblemAssistant dMr;
    CheckTask dMs;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dMr = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dMq = new ImageProblemView(this, this.dMr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dMs != null) {
            this.dMs.cancel();
            this.dMs = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dMq.getCheckButton()) {
            if (this.dMs == null) {
                this.dMq.getCheckButton().setText(getResources().getText(d.l.stop));
                this.dMs = new CheckTask();
                this.dMs.execute(new Object[0]);
                return;
            }
            this.dMq.getCheckButton().setText(getResources().getText(d.l.diagnose));
            if (this.dMs != null) {
                this.dMs.cancel();
                this.dMs = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dMq.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dMq.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dMr.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dMr.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dMr.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dMr.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dMr.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dMr.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dMr.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.dMq.setValue(numArr[0].intValue(), ImageProblemActivity.this.dMr.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dMq.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.l.diagnose));
            ImageProblemActivity.this.dMq.complete();
            ImageProblemActivity.this.dMs = null;
        }
    }
}
