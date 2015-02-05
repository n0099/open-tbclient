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
public class aj extends BdAsyncTask<String, Integer, String> {
    private com.baidu.tbadk.core.util.ad AO = null;
    private com.baidu.tbadk.coreExtra.c.f bHB;
    final /* synthetic */ PersonChangeActivity bHK;

    public aj(PersonChangeActivity personChangeActivity, com.baidu.tbadk.coreExtra.c.f fVar) {
        this.bHK = personChangeActivity;
        this.bHB = null;
        this.bHB = fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bHK.bHE = null;
        if (this.AO != null) {
            this.AO.dJ();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Boolean bool;
        this.bHK.bHE = null;
        this.bHK.closeLoadingDialog();
        if (this.AO != null) {
            if (this.AO.oS().qa().lT()) {
                this.bHK.showToast(this.bHK.getPageContext().getString(com.baidu.tieba.z.success));
                Intent intent = new Intent();
                bool = this.bHK.bHq;
                if (bool.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.bHB.sv());
                } else {
                    intent.putExtra("data", this.bHB.sv());
                }
                TbadkCoreApplication.m255getInst().setPersonChangeData(this.bHB.sv());
                this.bHK.setResult(-1, intent);
                this.bHK.finish();
            } else {
                this.bHK.showToast(this.AO.getErrorString());
            }
        }
        super.onPostExecute((aj) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.bHK;
        String string = this.bHK.getPageContext().getString(com.baidu.tieba.z.saving);
        onCancelListener = this.bHK.bHF;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        if (this.bHB != null) {
            this.AO = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
            this.AO.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.bHB.sv().getSex()));
            this.AO.o("intro", this.bHB.sv().getIntro());
            this.AO.ou();
            if (this.AO.oS().qa().lT()) {
                com.baidu.tieba.tbadkCore.util.j.delPersonData();
            }
        }
        return null;
    }
}
