package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ MarkData eno;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a enp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.enc = pbActivity;
        this.eno = markData;
        this.enp = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        fxVar = this.enc.elU;
        if (fxVar != null) {
            fxVar2 = this.enc.elU;
            if (fxVar2.getView() != null) {
                fxVar3 = this.enc.elU;
                fxVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.eno);
            this.enc.setResult(-1, intent);
            this.enp.dismiss();
            this.enc.aJO();
        }
    }
}
