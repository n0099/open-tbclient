package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ MarkData cFZ;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cFS = pbActivity;
        this.cFZ = markData;
        this.cGa = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dk dkVar;
        dk dkVar2;
        dk dkVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        dkVar = this.cFS.cFq;
        if (dkVar != null) {
            dkVar2 = this.cFS.cFq;
            if (dkVar2.getView() != null) {
                dkVar3 = this.cFS.cFq;
                dkVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.cFZ);
            this.cFS.setResult(-1, intent);
            this.cGa.dismiss();
            this.cFS.alo();
        }
    }
}
