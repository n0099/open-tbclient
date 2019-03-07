package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gCw;
    ImageProblemAssistant gCx;
    CheckTask gCy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCx = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gCw = new ImageProblemView(this, this.gCx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCy != null) {
            this.gCy.cancel();
            this.gCy = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCw.getCheckButton()) {
            if (this.gCy == null) {
                this.gCw.getCheckButton().setText(getResources().getText(d.j.stop));
                this.gCy = new CheckTask();
                this.gCy.execute(new Object[0]);
                return;
            }
            this.gCw.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.gCy != null) {
                this.gCy.cancel();
                this.gCy = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gCw.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gCw.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gCx.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gCx.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gCx.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gCx.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gCx.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gCx.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gCx.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gCw.setValue(numArr[0].intValue(), ImageProblemActivity.this.gCx.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gCw.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.gCw.complete();
            ImageProblemActivity.this.gCy = null;
        }
    }
}
