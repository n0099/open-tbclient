package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dUh;
    ImageProblemAssistant dUi;
    CheckTask dUj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dUi = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dUh = new ImageProblemView(this, this.dUi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dUj != null) {
            this.dUj.cancel();
            this.dUj = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dUh.getCheckButton()) {
            if (this.dUj == null) {
                this.dUh.getCheckButton().setText(getResources().getText(d.j.stop));
                this.dUj = new CheckTask();
                this.dUj.execute(new Object[0]);
                return;
            }
            this.dUh.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.dUj != null) {
                this.dUj.cancel();
                this.dUj = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dUh.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dUh.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dUi.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dUi.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dUi.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dUi.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dUi.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dUi.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dUi.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            ImageProblemActivity.this.dUh.setValue(numArr[0].intValue(), ImageProblemActivity.this.dUi.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dUh.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.dUh.complete();
            ImageProblemActivity.this.dUj = null;
        }
    }
}
