package com.baidu.tieba.pb.main;

import com.baidu.tieba.data.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class bd implements com.baidu.tieba.model.al {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.model.al
    public void a(boolean z, boolean z2, String str) {
        bv bvVar;
        com.baidu.tieba.model.aj ajVar;
        bn bnVar;
        bn bnVar2;
        bv bvVar2;
        bn bnVar3;
        com.baidu.tieba.model.aj ajVar2;
        bvVar = this.bvg.buL;
        bvVar.XD();
        if (z) {
            ajVar = this.bvg.buH;
            ajVar.bs(z2);
            bnVar = this.bvg.buG;
            bnVar.eb(z2);
            bnVar2 = this.bvg.buG;
            if (!bnVar2.zN()) {
                bvVar2 = this.bvg.buL;
                bnVar3 = this.bvg.buG;
                bvVar2.e(bnVar3.getPbData());
            } else {
                this.bvg.Wm();
            }
            if (z2) {
                ajVar2 = this.bvg.buH;
                MarkData TH = ajVar2.TH();
                if (TH != null) {
                    this.bvg.showToast(MessageFormat.format(this.bvg.getString(com.baidu.tieba.y.add_mark_on_pb), Integer.valueOf(TH.getFloor())));
                    return;
                } else {
                    this.bvg.showToast(this.bvg.getString(com.baidu.tieba.y.add_mark));
                    return;
                }
            }
            this.bvg.showToast(this.bvg.getString(com.baidu.tieba.y.remove_mark));
            return;
        }
        this.bvg.showToast(this.bvg.getString(com.baidu.tieba.y.update_mark_failed));
    }
}
