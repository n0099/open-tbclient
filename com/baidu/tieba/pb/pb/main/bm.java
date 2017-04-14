package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ MarkData ekg;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ekh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ejU = pbActivity;
        this.ekg = markData;
        this.ekh = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        eyVar = this.ejU.eiS;
        if (eyVar != null) {
            eyVar2 = this.ejU.eiS;
            if (eyVar2.getView() != null) {
                eyVar3 = this.ejU.eiS;
                eyVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ekg);
            this.ejU.setResult(-1, intent);
            this.ekh.dismiss();
            this.ejU.aKA();
        }
    }
}
