package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ MarkData eok;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.eob = pbActivity;
        this.eok = markData;
        this.eol = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        exVar = this.eob.enh;
        if (exVar != null) {
            exVar2 = this.eob.enh;
            if (exVar2.getView() != null) {
                exVar3 = this.eob.enh;
                exVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.eok);
            this.eob.setResult(-1, intent);
            this.eol.dismiss();
            this.eob.aMO();
        }
    }
}
