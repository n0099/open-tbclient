package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView eWG;
    ImageProblemAssistant eWH;
    CheckTask eWI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eWH = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.eWG = new ImageProblemView(this, this.eWH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eWI != null) {
            this.eWI.cancel();
            this.eWI = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eWG.getCheckButton()) {
            if (this.eWI == null) {
                this.eWG.getCheckButton().setText(getResources().getText(d.j.stop));
                this.eWI = new CheckTask();
                this.eWI.execute(new Object[0]);
                return;
            }
            this.eWG.getCheckButton().setText(getResources().getText(d.j.diagnose));
            if (this.eWI != null) {
                this.eWI.cancel();
                this.eWI = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eWG.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.eWG.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.eWH.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.eWH.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.eWH.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.eWH.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.eWH.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.eWH.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.eWH.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.eWG.setValue(numArr[0].intValue(), ImageProblemActivity.this.eWH.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.eWG.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.j.diagnose));
            ImageProblemActivity.this.eWG.complete();
            ImageProblemActivity.this.eWI = null;
        }
    }
}
