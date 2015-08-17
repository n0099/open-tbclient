package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity cbo;
    private final /* synthetic */ MarkData cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, MarkData markData) {
        this.cbo = pbActivity;
        this.cbv = markData;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        int[] iArr = new int[2];
        cbVar = this.cbo.caQ;
        if (cbVar != null) {
            cbVar2 = this.cbo.caQ;
            if (cbVar2.getView() != null) {
                cbVar3 = this.cbo.caQ;
                cbVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.cbv);
            this.cbo.setResult(-1, intent);
            this.cbo.ade();
        }
    }
}
