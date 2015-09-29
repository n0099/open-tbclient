package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnCancelListener {
    private final /* synthetic */ MarkData ciG;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ciH;
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ciz = pbActivity;
        this.ciG = markData;
        this.ciH = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        int[] iArr = new int[2];
        ccVar = this.ciz.cia;
        if (ccVar != null) {
            ccVar2 = this.ciz.cia;
            if (ccVar2.getView() != null) {
                ccVar3 = this.ciz.cia;
                ccVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ciG);
            this.ciz.setResult(-1, intent);
            this.ciH.dismiss();
            this.ciz.afp();
        }
    }
}
