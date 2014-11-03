package com.baidu.tieba.pb.main;

import com.baidu.tieba.data.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class bd implements com.baidu.tieba.model.al {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.bvu = pbActivity;
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
        bvVar = this.bvu.buZ;
        bvVar.XG();
        if (z) {
            ajVar = this.bvu.buV;
            ajVar.bs(z2);
            bnVar = this.bvu.buU;
            bnVar.eb(z2);
            bnVar2 = this.bvu.buU;
            if (!bnVar2.zP()) {
                bvVar2 = this.bvu.buZ;
                bnVar3 = this.bvu.buU;
                bvVar2.e(bnVar3.getPbData());
            } else {
                this.bvu.Wp();
            }
            if (z2) {
                ajVar2 = this.bvu.buV;
                MarkData TK = ajVar2.TK();
                if (TK != null) {
                    this.bvu.showToast(MessageFormat.format(this.bvu.getString(com.baidu.tieba.y.add_mark_on_pb), Integer.valueOf(TK.getFloor())));
                    return;
                } else {
                    this.bvu.showToast(this.bvu.getString(com.baidu.tieba.y.add_mark));
                    return;
                }
            }
            this.bvu.showToast(this.bvu.getString(com.baidu.tieba.y.remove_mark));
            return;
        }
        this.bvu.showToast(this.bvu.getString(com.baidu.tieba.y.update_mark_failed));
    }
}
