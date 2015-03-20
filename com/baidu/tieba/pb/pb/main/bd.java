package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class bd implements com.baidu.tbadk.baseEditMark.b {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.b
    public void a(boolean z, boolean z2, String str) {
        ci ciVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        bq bqVar;
        bq bqVar2;
        ci ciVar2;
        bq bqVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        ciVar = this.bIv.bHY;
        ciVar.aaN();
        if (z) {
            aVar = this.bIv.bHU;
            if (aVar != null) {
                aVar4 = this.bIv.bHU;
                aVar4.W(z2);
            }
            bqVar = this.bIv.bHT;
            bqVar.dO(z2);
            bqVar2 = this.bIv.bHT;
            if (!bqVar2.oQ()) {
                ciVar2 = this.bIv.bHY;
                bqVar3 = this.bIv.bHT;
                ciVar2.e(bqVar3.getPbData());
            } else {
                this.bIv.Zs();
            }
            if (z2) {
                aVar2 = this.bIv.bHU;
                if (aVar2 != null) {
                    aVar3 = this.bIv.bHU;
                    MarkData oT = aVar3.oT();
                    if (oT != null) {
                        this.bIv.showToast(MessageFormat.format(this.bIv.getPageContext().getString(com.baidu.tieba.y.add_mark_on_pb), Integer.valueOf(oT.getFloor())));
                        return;
                    } else {
                        this.bIv.showToast(this.bIv.getPageContext().getString(com.baidu.tieba.y.add_mark));
                        return;
                    }
                }
                return;
            }
            this.bIv.showToast(this.bIv.getPageContext().getString(com.baidu.tieba.y.remove_mark));
            return;
        }
        this.bIv.showToast(this.bIv.getPageContext().getString(com.baidu.tieba.y.update_mark_failed));
    }
}
