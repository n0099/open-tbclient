package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, Integer, String> {
    private com.baidu.tbadk.core.util.aa OE = null;
    private com.baidu.tbadk.coreExtra.c.f bSE;
    final /* synthetic */ PersonChangeActivity bSN;

    public ba(PersonChangeActivity personChangeActivity, com.baidu.tbadk.coreExtra.c.f fVar) {
        this.bSN = personChangeActivity;
        this.bSE = null;
        this.bSE = fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bSN.bSH = null;
        if (this.OE != null) {
            this.OE.gS();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Boolean bool;
        this.bSN.bSH = null;
        this.bSN.closeLoadingDialog();
        if (this.OE != null) {
            if (this.OE.sX().tT().qa()) {
                this.bSN.showToast(this.bSN.getPageContext().getString(com.baidu.tieba.t.success));
                Intent intent = new Intent();
                bool = this.bSN.bSs;
                if (bool.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.bSE.wH());
                } else {
                    intent.putExtra("data", this.bSE.wH());
                }
                TbadkCoreApplication.m411getInst().setPersonChangeData(this.bSE.wH());
                this.bSN.setResult(-1, intent);
                this.bSN.finish();
            } else {
                this.bSN.showToast(this.OE.getErrorString());
            }
        }
        super.onPostExecute((ba) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.bSN;
        String string = this.bSN.getPageContext().getString(com.baidu.tieba.t.saving);
        onCancelListener = this.bSN.bSI;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        if (this.bSE != null) {
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
            this.OE.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.bSE.wH().getSex()));
            this.OE.o("intro", this.bSE.wH().getIntro());
            this.OE.sz();
            if (this.OE.sX().tT().qa()) {
                com.baidu.tieba.tbadkCore.util.j.apv();
            }
        }
        return null;
    }
}
