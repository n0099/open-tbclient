package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dmF;
    ImageProblemAssistant dmG;
    CheckTask dmH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dmG = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dmF = new ImageProblemView(this, this.dmG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dmH != null) {
            this.dmH.cancel();
            this.dmH = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dmF.getCheckButton()) {
            if (this.dmH == null) {
                this.dmF.getCheckButton().setText(getResources().getText(r.l.stop));
                this.dmH = new CheckTask(this, null);
                this.dmH.execute(new Object[0]);
                return;
            }
            this.dmF.getCheckButton().setText(getResources().getText(r.l.diagnose));
            if (this.dmH != null) {
                this.dmH.cancel();
                this.dmH = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dmF.onChangeSkinType(i);
    }

    /* loaded from: classes.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, CheckTask checkTask) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dmF.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dmG.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dmG.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dmG.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dmG.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dmG.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dmG.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dmG.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dmF.setValue(numArr[0].intValue(), ImageProblemActivity.this.dmG.dmK);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dmF.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(r.l.diagnose));
            ImageProblemActivity.this.dmF.complete();
            ImageProblemActivity.this.dmH = null;
        }
    }
}
