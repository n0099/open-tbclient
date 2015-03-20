package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, String> {
    private com.baidu.tbadk.core.util.aa ZD;
    final /* synthetic */ EditHeadActivity this$0;

    private s(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
        this.ZD = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(EditHeadActivity editHeadActivity, s sVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(com.baidu.tieba.y.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        String str;
        Exception e;
        this.ZD = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_HEAD_MODIFY);
        try {
            str = this.ZD.cD(TbConfig.PERSON_HEAD_FILE);
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            if (this.ZD.sp().tq().pv()) {
                return str;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.this$0.closeLoadingDialog();
        this.this$0.bOQ = null;
        if (this.ZD != null) {
            this.ZD.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        this.this$0.closeLoadingDialog();
        if (this.ZD != null) {
            if (this.ZD.sp().tq().pv()) {
                this.this$0.setResult(-1);
                this.this$0.finish();
                this.this$0.showToast(this.this$0.getPageContext().getString(com.baidu.tieba.y.upload_head_ok));
                return;
            }
            this.this$0.showToast(this.ZD.getErrorString());
        }
    }
}
