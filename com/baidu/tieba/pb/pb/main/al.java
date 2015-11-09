package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity cjN;
    private final /* synthetic */ MarkData cjU;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cjN = pbActivity;
        this.cjU = markData;
        this.cjV = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        ctVar = this.cjN.cjo;
        if (ctVar != null) {
            ctVar2 = this.cjN.cjo;
            if (ctVar2.getView() != null) {
                ctVar3 = this.cjN.cjo;
                ctVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.cjU);
            this.cjN.setResult(-1, intent);
            this.cjV.dismiss();
            this.cjN.afP();
        }
    }
}
