package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ MarkData dPN;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a dPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.dPF = pbActivity;
        this.dPN = markData;
        this.dPO = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        es esVar;
        es esVar2;
        es esVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        esVar = this.dPF.dOO;
        if (esVar != null) {
            esVar2 = this.dPF.dOO;
            if (esVar2.getView() != null) {
                esVar3 = this.dPF.dOO;
                esVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.dPN);
            this.dPF.setResult(-1, intent);
            this.dPO.dismiss();
            this.dPF.aEL();
        }
    }
}
