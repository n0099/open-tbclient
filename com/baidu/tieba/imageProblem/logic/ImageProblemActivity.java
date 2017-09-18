package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView dQx;
    ImageProblemAssistant dQy;
    CheckTask dQz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dQy = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.dQx = new ImageProblemView(this, this.dQy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dQz != null) {
            this.dQz.cancel();
            this.dQz = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dQx.getCheckButton()) {
            if (this.dQz == null) {
                this.dQx.getCheckButton().setText(getResources().getText(d.l.stop));
                this.dQz = new CheckTask();
                this.dQz.execute(new Object[0]);
                return;
            }
            this.dQx.getCheckButton().setText(getResources().getText(d.l.diagnose));
            if (this.dQz != null) {
                this.dQz.cancel();
                this.dQz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dQx.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.dQx.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.dQy.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.dQy.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.dQy.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.dQy.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.dQy.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.dQy.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.dQy.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.dQx.setValue(numArr[0].intValue(), ImageProblemActivity.this.dQy.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.dQx.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.l.diagnose));
            ImageProblemActivity.this.dQx.complete();
            ImageProblemActivity.this.dQz = null;
        }
    }
}
