package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.baseEditMark.b {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bKU = pbActivity;
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
        chVar = this.bKU.bKA;
        chVar.acj();
        if (z) {
            aVar = this.bKU.bKx;
            if (aVar != null) {
                aVar4 = this.bKU.bKx;
                aVar4.Z(z2);
            }
            boVar = this.bKU.bKw;
            boVar.dX(z2);
            boVar2 = this.bKU.bKw;
            if (!boVar2.pq()) {
                chVar2 = this.bKU.bKA;
                boVar3 = this.bKU.bKw;
                chVar2.e(boVar3.getPbData());
            } else {
                this.bKU.aaX();
            }
            if (z2) {
                aVar2 = this.bKU.bKx;
                if (aVar2 != null) {
                    aVar3 = this.bKU.bKx;
                    MarkData pt = aVar3.pt();
                    if (pt != null) {
                        this.bKU.showToast(MessageFormat.format(this.bKU.getPageContext().getString(com.baidu.tieba.t.add_mark_on_pb), Integer.valueOf(pt.getFloor())));
                        return;
                    } else {
                        this.bKU.showToast(this.bKU.getPageContext().getString(com.baidu.tieba.t.add_mark));
                        return;
                    }
                }
                return;
            }
            this.bKU.showToast(this.bKU.getPageContext().getString(com.baidu.tieba.t.remove_mark));
            return;
        }
        this.bKU.showToast(this.bKU.getPageContext().getString(com.baidu.tieba.t.update_mark_failed));
    }
}
