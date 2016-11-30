package com.baidu.tieba.write.vcode.oldVcode;

import android.content.DialogInterface;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity glO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(VcodeActivity vcodeActivity) {
        this.glO = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        this.glO.destroyWaitingDialog();
        bVar = this.glO.glK;
        if (bVar != null) {
            bVar2 = this.glO.glK;
            bVar2.cancel();
        }
    }
}
