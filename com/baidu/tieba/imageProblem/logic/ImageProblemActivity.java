package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eLu;
    ImageProblemAssistant eLv;
    CheckTask eLw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eLv = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eLu = new ImageProblemView(this, this.eLv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eLw != null) {
            this.eLw.cancel();
            this.eLw = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eLu.getCheckButton()) {
            if (this.eLw == null) {
                this.eLu.getCheckButton().setText(getResources().getText(d.j.stop));
                this.eLw = new CheckTask();
                this.eLw.execute(new Object[0]);
                return;
            }
            this.eLu.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.eLw != null) {
                this.eLw.cancel();
                this.eLw = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eLu.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eLu.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eLv.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eLv.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eLv.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eLv.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eLv.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eLv.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eLv.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eLu.setValue(numArr[0].intValue(), ImageProblemActivity.this.eLv.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eLu.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.eLu.complete();
            ImageProblemActivity.this.eLw = null;
        }
    }
}
