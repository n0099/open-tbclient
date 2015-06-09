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
    private com.baidu.tbadk.coreExtra.c.f bSF;
    final /* synthetic */ PersonChangeActivity bSO;

    public ba(PersonChangeActivity personChangeActivity, com.baidu.tbadk.coreExtra.c.f fVar) {
        this.bSO = personChangeActivity;
        this.bSF = null;
        this.bSF = fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bSO.bSI = null;
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
        this.bSO.bSI = null;
        this.bSO.closeLoadingDialog();
        if (this.OE != null) {
            if (this.OE.sX().tT().qa()) {
                this.bSO.showToast(this.bSO.getPageContext().getString(com.baidu.tieba.t.success));
                Intent intent = new Intent();
                bool = this.bSO.bSt;
                if (bool.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.bSF.wI());
                } else {
                    intent.putExtra("data", this.bSF.wI());
                }
                TbadkCoreApplication.m411getInst().setPersonChangeData(this.bSF.wI());
                this.bSO.setResult(-1, intent);
                this.bSO.finish();
            } else {
                this.bSO.showToast(this.OE.getErrorString());
            }
        }
        super.onPostExecute((ba) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.bSO;
        String string = this.bSO.getPageContext().getString(com.baidu.tieba.t.saving);
        onCancelListener = this.bSO.bSJ;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        if (this.bSF != null) {
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
            this.OE.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.bSF.wI().getSex()));
            this.OE.o("intro", this.bSF.wI().getIntro());
            this.OE.sz();
            if (this.OE.sX().tT().qa()) {
                com.baidu.tieba.tbadkCore.util.j.apw();
            }
        }
        return null;
    }
}
