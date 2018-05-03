package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    ImageProblemView erk;
    ImageProblemAssistant erl;
    CheckTask erm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erl = new ImageProblemAssistant(getPageContext().getPageActivity());
        this.erk = new ImageProblemView(this, this.erl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.erm != null) {
            this.erm.cancel();
            this.erm = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.erk.getCheckButton()) {
            if (this.erm == null) {
                this.erk.getCheckButton().setText(getResources().getText(d.k.stop));
                this.erm = new CheckTask();
                this.erm.execute(new Object[0]);
                return;
            }
            this.erk.getCheckButton().setText(getResources().getText(d.k.diagnose));
            if (this.erm != null) {
                this.erm.cancel();
                this.erm = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.erk.onChangeSkinType(i);
    }

    /* loaded from: classes2.dex */
    private class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        private CheckTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ImageProblemActivity.this.erk.start();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public BdStatSwitchData doInBackground(Object... objArr) {
            publishProgress(0);
            ImageProblemActivity.this.erl.networkCheck();
            publishProgress(1);
            ImageProblemActivity.this.erl.checkDNSIP();
            publishProgress(2);
            ImageProblemActivity.this.erl.checkProxyIP();
            publishProgress(3);
            ImageProblemActivity.this.erl.networkTest();
            publishProgress(4);
            ImageProblemActivity.this.erl.checkSetting();
            publishProgress(5);
            ImageProblemActivity.this.erl.checkLoadImg();
            publishProgress(6);
            ImageProblemActivity.this.erl.fix();
            publishProgress(7);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            ImageProblemActivity.this.erk.setValue(numArr[0].intValue(), ImageProblemActivity.this.erl.taskList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            ImageProblemActivity.this.erk.getCheckButton().setText(ImageProblemActivity.this.getResources().getText(d.k.diagnose));
            ImageProblemActivity.this.erk.complete();
            ImageProblemActivity.this.erm = null;
        }
    }
}
