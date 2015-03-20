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
    private aa Oi = null;
    final /* synthetic */ PersonChangeActivity ccF;
    private com.baidu.tbadk.coreExtra.c.f ccw;

    public q(PersonChangeActivity personChangeActivity, com.baidu.tbadk.coreExtra.c.f fVar) {
        this.ccF = personChangeActivity;
        this.ccw = null;
        this.ccw = fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.ccF.ccz = null;
        if (this.Oi != null) {
            this.Oi.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Boolean bool;
        this.ccF.ccz = null;
        this.ccF.closeLoadingDialog();
        if (this.Oi != null) {
            if (this.Oi.sp().tq().pv()) {
                this.ccF.showToast(this.ccF.getPageContext().getString(y.success));
                Intent intent = new Intent();
                bool = this.ccF.cck;
                if (bool.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ccw.vR());
                } else {
                    intent.putExtra("data", this.ccw.vR());
                }
                TbadkCoreApplication.m411getInst().setPersonChangeData(this.ccw.vR());
                this.ccF.setResult(-1, intent);
                this.ccF.finish();
            } else {
                this.ccF.showToast(this.Oi.getErrorString());
            }
        }
        super.onPostExecute((q) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.ccF;
        String string = this.ccF.getPageContext().getString(y.saving);
        onCancelListener = this.ccF.ccA;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        if (this.ccw != null) {
            this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
            this.Oi.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.ccw.vR().getSex()));
            this.Oi.o("intro", this.ccw.vR().getIntro());
            this.Oi.rR();
            if (this.Oi.sp().tq().pv()) {
                com.baidu.tieba.tbadkCore.util.j.ano();
            }
        }
        return null;
    }
}
