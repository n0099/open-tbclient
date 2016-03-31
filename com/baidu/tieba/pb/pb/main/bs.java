package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements DialogInterface.OnCancelListener {
    private final /* synthetic */ MarkData dhD;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a dhE;
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.dht = pbActivity;
        this.dhD = markData;
        this.dhE = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        eu euVar;
        eu euVar2;
        eu euVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        euVar = this.dht.dgF;
        if (euVar != null) {
            euVar2 = this.dht.dgF;
            if (euVar2.getView() != null) {
                euVar3 = this.dht.dgF;
                euVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.dhD);
            this.dht.setResult(-1, intent);
            this.dhE.dismiss();
            this.dht.awr();
        }
    }
}
