package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BdAsyncTask<String, Integer, String> {
    private com.baidu.tieba.model.au bCd;
    final /* synthetic */ PersonChangeActivity bCm;
    private com.baidu.tbadk.core.util.ac mNetWork = null;

    public ar(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.au auVar) {
        this.bCm = personChangeActivity;
        this.bCd = null;
        this.bCd = auVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bCm.bCg = null;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Boolean bool;
        this.bCm.bCg = null;
        this.bCm.closeLoadingDialog();
        if (this.mNetWork != null) {
            if (this.mNetWork.mc().nb().jq()) {
                this.bCm.showToast(this.bCm.getString(com.baidu.tieba.y.success));
                Intent intent = new Intent();
                bool = this.bCm.bBQ;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.bCd.TT());
                } else {
                    intent.putExtra("data", this.bCd.TT());
                }
                com.baidu.tieba.aj.wk().a(this.bCd.TT());
                this.bCm.setResult(-1, intent);
                this.bCm.finish();
            } else {
                this.bCm.showToast(this.mNetWork.getErrorString());
            }
        }
        super.onPostExecute((ar) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.bCm;
        String string = this.bCm.getString(com.baidu.tieba.y.saving);
        onCancelListener = this.bCm.bCh;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        if (this.bCd != null) {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/profile/modify");
            this.mNetWork.k(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.bCd.TT().getSex()));
            this.mNetWork.k("intro", this.bCd.TT().getIntro());
            this.mNetWork.lD();
            if (this.mNetWork.mc().nb().jq()) {
                com.baidu.tieba.util.j.aey();
            }
        }
        return null;
    }
}
