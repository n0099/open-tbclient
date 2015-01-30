package com.baidu.tieba.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.baseEditMark.g {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.g
    public void a(boolean z, boolean z2, String str) {
        bz bzVar;
        com.baidu.tbadk.baseEditMark.e eVar;
        bq bqVar;
        bq bqVar2;
        bz bzVar2;
        bq bqVar3;
        com.baidu.tbadk.baseEditMark.e eVar2;
        bzVar = this.bAT.bAx;
        bzVar.YI();
        if (z) {
            eVar = this.bAT.bAt;
            eVar.Y(z2);
            bqVar = this.bAT.bAs;
            bqVar.dS(z2);
            bqVar2 = this.bAT.bAs;
            if (!bqVar2.li()) {
                bzVar2 = this.bAT.bAx;
                bqVar3 = this.bAT.bAs;
                bzVar2.e(bqVar3.getPbData());
            } else {
                this.bAT.Xr();
            }
            if (z2) {
                eVar2 = this.bAT.bAt;
                MarkData lj = eVar2.lj();
                if (lj != null) {
                    this.bAT.showToast(MessageFormat.format(this.bAT.getPageContext().getString(com.baidu.tieba.z.add_mark_on_pb), Integer.valueOf(lj.getFloor())));
                    return;
                } else {
                    this.bAT.showToast(this.bAT.getPageContext().getString(com.baidu.tieba.z.add_mark));
                    return;
                }
            }
            this.bAT.showToast(this.bAT.getPageContext().getString(com.baidu.tieba.z.remove_mark));
            return;
        }
        this.bAT.showToast(this.bAT.getPageContext().getString(com.baidu.tieba.z.update_mark_failed));
    }
}
