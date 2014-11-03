package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonChangeActivity bCA;
    private com.baidu.tieba.model.au bCr;
    private com.baidu.tbadk.core.util.ac mNetWork = null;

    public ar(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.au auVar) {
        this.bCA = personChangeActivity;
        this.bCr = null;
        this.bCr = auVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bCA.bCu = null;
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
        this.bCA.bCu = null;
        this.bCA.closeLoadingDialog();
        if (this.mNetWork != null) {
            if (this.mNetWork.mc().nb().jq()) {
                this.bCA.showToast(this.bCA.getString(com.baidu.tieba.y.success));
                Intent intent = new Intent();
                bool = this.bCA.bCe;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.bCr.TW());
                } else {
                    intent.putExtra("data", this.bCr.TW());
                }
                com.baidu.tieba.aj.wm().a(this.bCr.TW());
                this.bCA.setResult(-1, intent);
                this.bCA.finish();
            } else {
                this.bCA.showToast(this.mNetWork.getErrorString());
            }
        }
        super.onPostExecute((ar) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.bCA;
        String string = this.bCA.getString(com.baidu.tieba.y.saving);
        onCancelListener = this.bCA.bCv;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        if (this.bCr != null) {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/profile/modify");
            this.mNetWork.k(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.bCr.TW().getSex()));
            this.mNetWork.k("intro", this.bCr.TW().getIntro());
            this.mNetWork.lD();
            if (this.mNetWork.mc().nb().jq()) {
                com.baidu.tieba.util.j.aeB();
            }
        }
        return null;
    }
}
