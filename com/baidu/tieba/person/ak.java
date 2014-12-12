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
public class ak extends BdAsyncTask<String, Integer, String> {
    private com.baidu.tbadk.core.util.ad AR = null;
    private com.baidu.tbadk.coreExtra.c.f bFR;
    final /* synthetic */ PersonChangeActivity bGa;

    public ak(PersonChangeActivity personChangeActivity, com.baidu.tbadk.coreExtra.c.f fVar) {
        this.bGa = personChangeActivity;
        this.bFR = null;
        this.bFR = fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bGa.bFU = null;
        if (this.AR != null) {
            this.AR.dL();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Boolean bool;
        this.bGa.bFU = null;
        this.bGa.closeLoadingDialog();
        if (this.AR != null) {
            if (this.AR.oW().pW().ma()) {
                this.bGa.showToast(this.bGa.getPageContext().getString(com.baidu.tieba.z.success));
                Intent intent = new Intent();
                bool = this.bGa.bFG;
                if (bool.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.bFR.sl());
                } else {
                    intent.putExtra("data", this.bFR.sl());
                }
                TbadkCoreApplication.m255getInst().setPersonChangeData(this.bFR.sl());
                this.bGa.setResult(-1, intent);
                this.bGa.finish();
            } else {
                this.bGa.showToast(this.AR.getErrorString());
            }
        }
        super.onPostExecute((ak) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.bGa;
        String string = this.bGa.getPageContext().getString(com.baidu.tieba.z.saving);
        onCancelListener = this.bGa.bFV;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        if (this.bFR != null) {
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
            this.AR.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.bFR.sl().getSex()));
            this.AR.o("intro", this.bFR.sl().getIntro());
            this.AR.oy();
            if (this.AR.oW().pW().ma()) {
                com.baidu.tieba.tbadkCore.util.j.delPersonData();
            }
        }
        return null;
    }
}
