package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView fiF;
    ImageProblemAssistant fiG;
    CheckTask fiH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fiG = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.fiF = new ImageProblemView(this, this.fiG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fiH != null) {
            this.fiH.cancel();
            this.fiH = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fiF.getCheckButton()) {
            if (this.fiH == null) {
                this.fiF.getCheckButton().setText(getResources().getText(e.j.stop));
                this.fiH = new CheckTask();
                this.fiH.execute(new Object[0]);
                return;
            }
            this.fiF.getCheckButton().setText(getResources().getText(e.j.diagnose));
            if (this.fiH != null) {
                this.fiH.cancel();
                this.fiH = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fiF.onChangeSkinType(i);
    }

    /* loaded from: classes4.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.fiF.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.fiG.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.fiG.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.fiG.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.fiG.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.fiG.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.fiG.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.fiG.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.fiF.setValue(numArr[0].intValue(), ImageProblemActivity.this.fiG.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.fiF.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(e.j.diagnose));
            ImageProblemActivity.this.fiF.complete();
            ImageProblemActivity.this.fiH = null;
        }
    }
}
