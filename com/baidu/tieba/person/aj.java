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
    private com.baidu.tbadk.core.util.ad AR = null;
    private com.baidu.tbadk.coreExtra.c.f bHC;
    final /* synthetic */ PersonChangeActivity bHL;

    public aj(PersonChangeActivity personChangeActivity, com.baidu.tbadk.coreExtra.c.f fVar) {
        this.bHL = personChangeActivity;
        this.bHC = null;
        this.bHC = fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bHL.bHF = null;
        if (this.AR != null) {
            this.AR.dJ();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Boolean bool;
        this.bHL.bHF = null;
        this.bHL.closeLoadingDialog();
        if (this.AR != null) {
            if (this.AR.oZ().qh().ma()) {
                this.bHL.showToast(this.bHL.getPageContext().getString(com.baidu.tieba.z.success));
                Intent intent = new Intent();
                bool = this.bHL.bHr;
                if (bool.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.bHC.sB());
                } else {
                    intent.putExtra("data", this.bHC.sB());
                }
                TbadkCoreApplication.m255getInst().setPersonChangeData(this.bHC.sB());
                this.bHL.setResult(-1, intent);
                this.bHL.finish();
            } else {
                this.bHL.showToast(this.AR.getErrorString());
            }
        }
        super.onPostExecute((aj) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.bHL;
        String string = this.bHL.getPageContext().getString(com.baidu.tieba.z.saving);
        onCancelListener = this.bHL.bHG;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        if (this.bHC != null) {
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
            this.AR.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.bHC.sB().getSex()));
            this.AR.o("intro", this.bHC.sB().getIntro());
            this.AR.oB();
            if (this.AR.oZ().qh().ma()) {
                com.baidu.tieba.tbadkCore.util.j.delPersonData();
            }
        }
        return null;
    }
}
