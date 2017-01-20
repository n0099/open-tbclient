package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ MarkData ejh;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.eiV = pbActivity;
        this.ejh = markData;
        this.eji = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        ezVar = this.eiV.ehV;
        if (ezVar != null) {
            ezVar2 = this.eiV.ehV;
            if (ezVar2.getView() != null) {
                ezVar3 = this.eiV.ehV;
                ezVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ejh);
            this.eiV.setResult(-1, intent);
            this.eji.dismiss();
            this.eiV.aKY();
        }
    }
}
