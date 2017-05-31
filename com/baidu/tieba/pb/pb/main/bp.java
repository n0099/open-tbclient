package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements a.b {
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ MarkData enn;
    private final /* synthetic */ MarkData eno;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a enp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.enc = pbActivity;
        this.enn = markData;
        this.eno = markData2;
        this.enp = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        com.baidu.tbadk.baseEditMark.a aVar6;
        com.baidu.tbadk.baseEditMark.a aVar7;
        com.baidu.tbadk.baseEditMark.a aVar8;
        aVar.dismiss();
        aVar2 = this.enc.dHz;
        if (aVar2 != null) {
            aVar3 = this.enc.dHz;
            if (aVar3.nD()) {
                aVar7 = this.enc.dHz;
                aVar7.nE();
                aVar8 = this.enc.dHz;
                aVar8.ac(false);
            }
            aVar4 = this.enc.dHz;
            aVar4.a(this.enn);
            aVar5 = this.enc.dHz;
            aVar5.ac(true);
            aVar6 = this.enc.dHz;
            aVar6.nF();
        }
        this.eno.setPostId(this.enn.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.eno);
        this.enc.setResult(-1, intent);
        this.enp.dismiss();
        this.enc.aJO();
    }
}
