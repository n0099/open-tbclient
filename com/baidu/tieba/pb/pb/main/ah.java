package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity ccj;
    private final /* synthetic */ MarkData ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, MarkData markData) {
        this.ccj = pbActivity;
        this.ccq = markData;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        int[] iArr = new int[2];
        cbVar = this.ccj.cbL;
        if (cbVar != null) {
            cbVar2 = this.ccj.cbL;
            if (cbVar2.getView() != null) {
                cbVar3 = this.ccj.cbL;
                cbVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ccq);
            this.ccj.setResult(-1, intent);
            this.ccj.adr();
        }
    }
}
