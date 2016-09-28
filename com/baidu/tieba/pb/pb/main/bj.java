package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ MarkData eqi;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.eqa = pbActivity;
        this.eqi = markData;
        this.eqj = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        exVar = this.eqa.epe;
        if (exVar != null) {
            exVar2 = this.eqa.epe;
            if (exVar2.getView() != null) {
                exVar3 = this.eqa.epe;
                exVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.eqi);
            this.eqa.setResult(-1, intent);
            this.eqj.dismiss();
            this.eqa.aNu();
        }
    }
}
