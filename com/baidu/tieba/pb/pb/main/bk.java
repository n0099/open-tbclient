package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ MarkData evW;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a evX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.evL = pbActivity;
        this.evW = markData;
        this.evX = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        eyVar = this.evL.euP;
        if (eyVar != null) {
            eyVar2 = this.evL.euP;
            if (eyVar2.getView() != null) {
                eyVar3 = this.evL.euP;
                eyVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.evW);
            this.evL.setResult(-1, intent);
            this.evX.dismiss();
            this.evL.aPm();
        }
    }
}
