package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ MarkData cNx;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cNy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cNq = pbActivity;
        this.cNx = markData;
        this.cNy = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dz dzVar;
        dz dzVar2;
        dz dzVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        dzVar = this.cNq.cMK;
        if (dzVar != null) {
            dzVar2 = this.cNq.cMK;
            if (dzVar2.getView() != null) {
                dzVar3 = this.cNq.cMK;
                dzVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.cNx);
            this.cNq.setResult(-1, intent);
            this.cNy.dismiss();
            this.cNq.aps();
        }
    }
}
