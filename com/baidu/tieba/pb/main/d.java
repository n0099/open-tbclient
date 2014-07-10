package com.baidu.tieba.pb.main;

import com.baidu.tieba.data.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.model.aj {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.model.aj
    public void a(boolean z, boolean z2, String str) {
        bt btVar;
        com.baidu.tieba.model.ah ahVar;
        bm bmVar;
        bm bmVar2;
        bt btVar2;
        bm bmVar3;
        com.baidu.tieba.model.ah ahVar2;
        btVar = this.a.D;
        btVar.x();
        if (z) {
            ahVar = this.a.y;
            ahVar.a(z2);
            bmVar = this.a.x;
            bmVar.c(z2);
            bmVar2 = this.a.x;
            if (!bmVar2.B()) {
                btVar2 = this.a.D;
                bmVar3 = this.a.x;
                btVar2.a(bmVar3.r());
            } else {
                this.a.A();
            }
            if (z2) {
                ahVar2 = this.a.y;
                MarkData b = ahVar2.b();
                if (b != null) {
                    this.a.showToast(MessageFormat.format(this.a.getString(com.baidu.tieba.y.add_mark_on_pb), Integer.valueOf(b.getFloor())));
                    return;
                } else {
                    this.a.showToast(this.a.getString(com.baidu.tieba.y.add_mark));
                    return;
                }
            }
            this.a.showToast(this.a.getString(com.baidu.tieba.y.remove_mark));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.y.update_mark_failed));
    }
}
