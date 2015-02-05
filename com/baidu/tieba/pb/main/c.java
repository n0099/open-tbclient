package com.baidu.tieba.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.baseEditMark.g {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bAS = pbActivity;
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
        bzVar = this.bAS.bAw;
        bzVar.YD();
        if (z) {
            eVar = this.bAS.bAs;
            eVar.Y(z2);
            bqVar = this.bAS.bAr;
            bqVar.dS(z2);
            bqVar2 = this.bAS.bAr;
            if (!bqVar2.lb()) {
                bzVar2 = this.bAS.bAw;
                bqVar3 = this.bAS.bAr;
                bzVar2.e(bqVar3.getPbData());
            } else {
                this.bAS.Xm();
            }
            if (z2) {
                eVar2 = this.bAS.bAs;
                MarkData lc = eVar2.lc();
                if (lc != null) {
                    this.bAS.showToast(MessageFormat.format(this.bAS.getPageContext().getString(com.baidu.tieba.z.add_mark_on_pb), Integer.valueOf(lc.getFloor())));
                    return;
                } else {
                    this.bAS.showToast(this.bAS.getPageContext().getString(com.baidu.tieba.z.add_mark));
                    return;
                }
            }
            this.bAS.showToast(this.bAS.getPageContext().getString(com.baidu.tieba.z.remove_mark));
            return;
        }
        this.bAS.showToast(this.bAS.getPageContext().getString(com.baidu.tieba.z.update_mark_failed));
    }
}
