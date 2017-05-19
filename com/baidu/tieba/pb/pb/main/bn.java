package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements DialogInterface.OnCancelListener {
    private final /* synthetic */ MarkData ehK;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ehL;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ehy = pbActivity;
        this.ehK = markData;
        this.ehL = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        dialogInterface.dismiss();
        int[] iArr = new int[2];
        fmVar = this.ehy.egt;
        if (fmVar != null) {
            fmVar2 = this.ehy.egt;
            if (fmVar2.getView() != null) {
                fmVar3 = this.ehy.egt;
                fmVar3.getView().getLocationOnScreen(iArr);
            }
        }
        if (iArr[0] > 0) {
            Intent intent = new Intent();
            intent.putExtra(PbActivityConfig.KEY_MARK, this.ehK);
            this.ehy.setResult(-1, intent);
            this.ehL.dismiss();
            this.ehy.aIW();
        }
    }
}
