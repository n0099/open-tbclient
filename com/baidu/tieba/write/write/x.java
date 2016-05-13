package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import com.baidu.tieba.write.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity fcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.fcU = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        this.fcU.destroyWaitingDialog();
        bVar = this.fcU.fcQ;
        if (bVar != null) {
            bVar2 = this.fcU.fcQ;
            bVar2.cancel();
        }
    }
}
