package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity bKT;
    private final /* synthetic */ MarkData bKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity, MarkData markData) {
        this.bKT = pbActivity;
        this.bKX = markData;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        int[] iArr = new int[2];
        chVar = this.bKT.bKz;
        if (chVar != null) {
            chVar2 = this.bKT.bKz;
            if (chVar2.getView() != null) {
                chVar3 = this.bKT.bKz;
                chVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.bKX);
            this.bKT.setResult(-1, intent);
            this.bKT.aaS();
        }
    }
}
