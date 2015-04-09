package com.baidu.tieba.setting.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, String> {
    private aa Ok = null;
    private com.baidu.tbadk.coreExtra.c.f ccL;
    final /* synthetic */ PersonChangeActivity ccU;

    public q(PersonChangeActivity personChangeActivity, com.baidu.tbadk.coreExtra.c.f fVar) {
        this.ccU = personChangeActivity;
        this.ccL = null;
        this.ccL = fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.ccU.ccO = null;
        if (this.Ok != null) {
            this.Ok.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Boolean bool;
        this.ccU.ccO = null;
        this.ccU.closeLoadingDialog();
        if (this.Ok != null) {
            if (this.Ok.sp().tq().pv()) {
                this.ccU.showToast(this.ccU.getPageContext().getString(y.success));
                Intent intent = new Intent();
                bool = this.ccU.ccz;
                if (bool.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ccL.vX());
                } else {
                    intent.putExtra("data", this.ccL.vX());
                }
                TbadkCoreApplication.m411getInst().setPersonChangeData(this.ccL.vX());
                this.ccU.setResult(-1, intent);
                this.ccU.finish();
            } else {
                this.ccU.showToast(this.Ok.getErrorString());
            }
        }
        super.onPostExecute((q) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.ccU;
        String string = this.ccU.getPageContext().getString(y.saving);
        onCancelListener = this.ccU.ccP;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        if (this.ccL != null) {
            this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
            this.Ok.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.ccL.vX().getSex()));
            this.Ok.o("intro", this.ccL.vX().getIntro());
            this.Ok.rR();
            if (this.Ok.sp().tq().pv()) {
                com.baidu.tieba.tbadkCore.util.j.anD();
            }
        }
        return null;
    }
}
