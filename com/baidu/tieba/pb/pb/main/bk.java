package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ MarkData eas;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.eah = pbActivity;
        this.eas = markData;
        this.eat = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        er erVar;
        er erVar2;
        er erVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        erVar = this.eah.dZk;
        if (erVar != null) {
            erVar2 = this.eah.dZk;
            if (erVar2.getView() != null) {
                erVar3 = this.eah.dZk;
                erVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.eas);
            this.eah.setResult(-1, intent);
            this.eat.dismiss();
            this.eah.aJl();
        }
    }
}
