package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity ciK;
    private final /* synthetic */ MarkData ciR;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ciS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ciK = pbActivity;
        this.ciR = markData;
        this.ciS = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        int[] iArr = new int[2];
        ccVar = this.ciK.cim;
        if (ccVar != null) {
            ccVar2 = this.ciK.cim;
            if (ccVar2.getView() != null) {
                ccVar3 = this.ciK.cim;
                ccVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ciR);
            this.ciK.setResult(-1, intent);
            this.ciS.dismiss();
            this.ciK.afp();
        }
    }
}
