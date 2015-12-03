package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity cCm;
    private final /* synthetic */ MarkData cCt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cCu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cCm = pbActivity;
        this.cCt = markData;
        this.cCu = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        da daVar;
        da daVar2;
        da daVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        daVar = this.cCm.cBL;
        if (daVar != null) {
            daVar2 = this.cCm.cBL;
            if (daVar2.getView() != null) {
                daVar3 = this.cCm.cBL;
                daVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.cCt);
            this.cCm.setResult(-1, intent);
            this.cCu.dismiss();
            this.cCm.akh();
        }
    }
}
