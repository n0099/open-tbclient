package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import com.baidu.tieba.write.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity dQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VcodeActivity vcodeActivity) {
        this.dQg = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        this.dQg.destroyWaitingDialog();
        bVar = this.dQg.dQe;
        if (bVar != null) {
            bVar2 = this.dQg.dQe;
            bVar2.cancel();
        }
    }
}
