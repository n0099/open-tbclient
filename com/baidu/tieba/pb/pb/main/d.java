package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.baseEditMark.b {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.b
    public void a(boolean z, boolean z2, String str) {
        ch chVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        bo boVar;
        bo boVar2;
        ch chVar2;
        bo boVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        chVar = this.bKT.bKz;
        chVar.aci();
        if (z) {
            aVar = this.bKT.bKw;
            if (aVar != null) {
                aVar4 = this.bKT.bKw;
                aVar4.Z(z2);
            }
            boVar = this.bKT.bKv;
            boVar.dX(z2);
            boVar2 = this.bKT.bKv;
            if (!boVar2.pq()) {
                chVar2 = this.bKT.bKz;
                boVar3 = this.bKT.bKv;
                chVar2.e(boVar3.getPbData());
            } else {
                this.bKT.aaW();
            }
            if (z2) {
                aVar2 = this.bKT.bKw;
                if (aVar2 != null) {
                    aVar3 = this.bKT.bKw;
                    MarkData pt = aVar3.pt();
                    if (pt != null) {
                        this.bKT.showToast(MessageFormat.format(this.bKT.getPageContext().getString(com.baidu.tieba.t.add_mark_on_pb), Integer.valueOf(pt.getFloor())));
                        return;
                    } else {
                        this.bKT.showToast(this.bKT.getPageContext().getString(com.baidu.tieba.t.add_mark));
                        return;
                    }
                }
                return;
            }
            this.bKT.showToast(this.bKT.getPageContext().getString(com.baidu.tieba.t.remove_mark));
            return;
        }
        this.bKT.showToast(this.bKT.getPageContext().getString(com.baidu.tieba.t.update_mark_failed));
    }
}
