package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements DialogInterface.OnCancelListener {
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ MarkData ema;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a emb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.elO = pbActivity;
        this.ema = markData;
        this.emb = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        fa faVar;
        fa faVar2;
        fa faVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        faVar = this.elO.ekM;
        if (faVar != null) {
            faVar2 = this.elO.ekM;
            if (faVar2.getView() != null) {
                faVar3 = this.elO.ekM;
                faVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ema);
            this.elO.setResult(-1, intent);
            this.emb.dismiss();
            this.elO.aKt();
        }
    }
}
