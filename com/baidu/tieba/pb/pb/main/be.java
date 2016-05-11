package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ MarkData djM;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a djN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.djE = pbActivity;
        this.djM = markData;
        this.djN = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        el elVar;
        el elVar2;
        el elVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        elVar = this.djE.diR;
        if (elVar != null) {
            elVar2 = this.djE.diR;
            if (elVar2.getView() != null) {
                elVar3 = this.djE.diR;
                elVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.djM);
            this.djE.setResult(-1, intent);
            this.djN.dismiss();
            this.djE.awB();
        }
    }
}
