package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import com.baidu.tieba.write.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity drb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VcodeActivity vcodeActivity) {
        this.drb = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        VcodeActivity.b bVar;
        VcodeActivity.b bVar2;
        this.drb.destroyWaitingDialog();
        bVar = this.drb.dqZ;
        if (bVar != null) {
            bVar2 = this.drb.dqZ;
            bVar2.cancel();
        }
    }
}
