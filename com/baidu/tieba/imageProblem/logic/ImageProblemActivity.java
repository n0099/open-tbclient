package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView ebX;
    ImageProblemAssistant ebY;
    CheckTask ebZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ebY = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.ebX = new ImageProblemView(this, this.ebY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ebZ != null) {
            this.ebZ.cancel();
            this.ebZ = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ebX.getCheckButton()) {
            if (this.ebZ == null) {
                this.ebX.getCheckButton().setText(getResources().getText(d.j.stop));
                this.ebZ = new CheckTask();
                this.ebZ.execute(new Object[0]);
                return;
            }
            this.ebX.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.ebZ != null) {
                this.ebZ.cancel();
                this.ebZ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ebX.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.ebX.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.ebY.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.ebY.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.ebY.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.ebY.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.ebY.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.ebY.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.ebY.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.ebX.setValue(numArr[0].intValue(), ImageProblemActivity.this.ebY.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.ebX.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.ebX.complete();
            ImageProblemActivity.this.ebZ = null;
        }
    }
}
