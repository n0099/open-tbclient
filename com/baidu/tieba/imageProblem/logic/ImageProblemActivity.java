package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView flw;
    ImageProblemAssistant flx;
    CheckTask fly;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.flx = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.flw = new ImageProblemView(this, this.flx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fly != null) {
            this.fly.cancel();
            this.fly = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.flw.getCheckButton()) {
            if (this.fly == null) {
                this.flw.getCheckButton().setText(getResources().getText(e.j.stop));
                this.fly = new CheckTask();
                this.fly.execute(new Object[0]);
                return;
            }
            this.flw.getCheckButton().setText(getResources().getText(e.j.diagnose));
            if (this.fly != null) {
                this.fly.cancel();
                this.fly = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.flw.onChangeSkinType(i);
    }

    /* loaded from: classes4.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.flw.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.flx.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.flx.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.flx.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.flx.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.flx.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.flx.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.flx.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.flw.setValue(numArr[0].intValue(), ImageProblemActivity.this.flx.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.flw.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(e.j.diagnose));
            ImageProblemActivity.this.flw.complete();
            ImageProblemActivity.this.fly = null;
        }
    }
}
