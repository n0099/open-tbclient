package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ MarkData ewt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ewu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ewh = pbActivity;
        this.ewt = markData;
        this.ewu = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        ggVar = this.ewh.euU;
        if (ggVar != null) {
            ggVar2 = this.ewh.euU;
            if (ggVar2.getView() != null) {
                ggVar3 = this.ewh.euU;
                ggVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ewt);
            this.ewh.setResult(-1, intent);
            this.ewu.dismiss();
            this.ewh.aNK();
        }
    }
}
