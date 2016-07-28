package com.baidu.tieba.write.vcode.oldVcode;

import android.content.DialogInterface;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity fRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(VcodeActivity vcodeActivity) {
        this.fRW = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        this.fRW.destroyWaitingDialog();
        bVar = this.fRW.fRS;
        if (bVar != null) {
            bVar2 = this.fRW.fRS;
            bVar2.cancel();
        }
    }
}
