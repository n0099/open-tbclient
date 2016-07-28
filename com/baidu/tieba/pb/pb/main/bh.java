package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ MarkData ecb;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ecc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ebT = pbActivity;
        this.ecb = markData;
        this.ecc = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ew ewVar;
        ew ewVar2;
        ew ewVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        ewVar = this.ebT.ebb;
        if (ewVar != null) {
            ewVar2 = this.ebT.ebb;
            if (ewVar2.getView() != null) {
                ewVar3 = this.ebT.ebb;
                ewVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ecb);
            this.ebT.setResult(-1, intent);
            this.ecc.dismiss();
            this.ebT.aHW();
        }
    }
}
