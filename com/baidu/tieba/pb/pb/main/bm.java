package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ MarkData emw;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a emx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.emk = pbActivity;
        this.emw = markData;
        this.emx = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        eyVar = this.emk.eli;
        if (eyVar != null) {
            eyVar2 = this.emk.eli;
            if (eyVar2.getView() != null) {
                eyVar3 = this.emk.eli;
                eyVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.emw);
            this.emk.setResult(-1, intent);
            this.emx.dismiss();
            this.emk.aLA();
        }
    }
}
