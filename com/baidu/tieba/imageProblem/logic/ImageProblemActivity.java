package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dvu;
    ImageProblemAssistant dvv;
    CheckTask dvw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dvv = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dvu = new ImageProblemView(this, this.dvv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dvw != null) {
            this.dvw.cancel();
            this.dvw = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dvu.getCheckButton()) {
            if (this.dvw == null) {
                this.dvu.getCheckButton().setText(getResources().getText(t.j.stop));
                this.dvw = new CheckTask(this, null);
                this.dvw.execute(new Object[0]);
                return;
            }
            this.dvu.getCheckButton().setText(getResources().getText(t.j.diagnose));
            if (this.dvw != null) {
                this.dvw.cancel();
                this.dvw = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dvu.onChangeSkinType(i);
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
            ImageProblemActivity.this.dvu.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dvv.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dvv.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dvv.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dvv.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dvv.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dvv.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dvv.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dvu.setValue(numArr[0].intValue(), ImageProblemActivity.this.dvv.dvz);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dvu.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(t.j.diagnose));
            ImageProblemActivity.this.dvu.complete();
            ImageProblemActivity.this.dvw = null;
        }
    }
}
