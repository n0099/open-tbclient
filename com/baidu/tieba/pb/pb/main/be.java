package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class be implements com.baidu.tbadk.baseEditMark.b {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.b
    public void a(boolean z, boolean z2, String str) {
        cj cjVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        br brVar;
        br brVar2;
        cj cjVar2;
        br brVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        cjVar = this.bIJ.bIl;
        cjVar.aba();
        if (z) {
            aVar = this.bIJ.bIh;
            if (aVar != null) {
                aVar4 = this.bIJ.bIh;
                aVar4.W(z2);
            }
            brVar = this.bIJ.bIg;
            brVar.dM(z2);
            brVar2 = this.bIJ.bIg;
            if (!brVar2.oQ()) {
                cjVar2 = this.bIJ.bIl;
                brVar3 = this.bIJ.bIg;
                cjVar2.e(brVar3.getPbData());
            } else {
                this.bIJ.ZF();
            }
            if (z2) {
                aVar2 = this.bIJ.bIh;
                if (aVar2 != null) {
                    aVar3 = this.bIJ.bIh;
                    MarkData oT = aVar3.oT();
                    if (oT != null) {
                        this.bIJ.showToast(MessageFormat.format(this.bIJ.getPageContext().getString(com.baidu.tieba.y.add_mark_on_pb), Integer.valueOf(oT.getFloor())));
                        return;
                    } else {
                        this.bIJ.showToast(this.bIJ.getPageContext().getString(com.baidu.tieba.y.add_mark));
                        return;
                    }
                }
                return;
            }
            this.bIJ.showToast(this.bIJ.getPageContext().getString(com.baidu.tieba.y.remove_mark));
            return;
        }
        this.bIJ.showToast(this.bIJ.getPageContext().getString(com.baidu.tieba.y.update_mark_failed));
    }
}
