package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView gCx;
    ImageProblemAssistant gCy;
    CheckTask gCz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCy = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.gCx = new ImageProblemView(this, this.gCy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCz != null) {
            this.gCz.cancel();
            this.gCz = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCx.getCheckButton()) {
            if (this.gCz == null) {
                this.gCx.getCheckButton().setText(getResources().getText(d.j.stop));
                this.gCz = new CheckTask();
                this.gCz.execute(new Object[0]);
                return;
            }
            this.gCx.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.gCz != null) {
                this.gCz.cancel();
                this.gCz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gCx.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.gCx.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.gCy.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.gCy.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.gCy.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.gCy.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.gCy.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.gCy.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.gCy.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.gCx.setValue(numArr[0].intValue(), ImageProblemActivity.this.gCy.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.gCx.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.gCx.complete();
            ImageProblemActivity.this.gCz = null;
        }
    }
}
