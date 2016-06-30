package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements a.b {
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ MarkData dPM;
    private final /* synthetic */ MarkData dPN;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a dPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.dPF = pbActivity;
        this.dPM = markData;
        this.dPN = markData2;
        this.dPO = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        com.baidu.tbadk.baseEditMark.a aVar6;
        com.baidu.tbadk.baseEditMark.a aVar7;
        com.baidu.tbadk.baseEditMark.a aVar8;
        aVar.dismiss();
        aVar2 = this.dPF.dvH;
        if (aVar2 != null) {
            aVar3 = this.dPF.dvH;
            if (aVar3.mK()) {
                aVar7 = this.dPF.dvH;
                aVar7.mL();
                aVar8 = this.dPF.dvH;
                aVar8.Z(false);
            }
            aVar4 = this.dPF.dvH;
            aVar4.a(this.dPM);
            aVar5 = this.dPF.dvH;
            aVar5.Z(true);
            aVar6 = this.dPF.dvH;
            aVar6.mM();
        }
        this.dPN.setPostId(this.dPM.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.dPN);
        this.dPF.setResult(-1, intent);
        this.dPO.dismiss();
        this.dPF.aEL();
    }
}
