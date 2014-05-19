package com.baidu.tieba.pb.main;

import com.baidu.tieba.data.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.model.ak {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.model.ak
    public void a(boolean z, boolean z2, String str) {
        bj bjVar;
        com.baidu.tieba.model.ai aiVar;
        bc bcVar;
        bc bcVar2;
        bj bjVar2;
        bc bcVar3;
        com.baidu.tieba.model.ai aiVar2;
        bjVar = this.a.E;
        bjVar.w();
        if (z) {
            aiVar = this.a.z;
            aiVar.a(z2);
            bcVar = this.a.y;
            bcVar.c(z2);
            bcVar2 = this.a.y;
            if (!bcVar2.x()) {
                bjVar2 = this.a.E;
                bcVar3 = this.a.y;
                bjVar2.a(bcVar3.p());
            } else {
                this.a.z();
            }
            if (z2) {
                aiVar2 = this.a.z;
                MarkData b = aiVar2.b();
                if (b != null) {
                    this.a.showToast(MessageFormat.format(this.a.getString(com.baidu.tieba.u.add_mark_on_pb), Integer.valueOf(b.getFloor())));
                    return;
                } else {
                    this.a.showToast(this.a.getString(com.baidu.tieba.u.add_mark));
                    return;
                }
            }
            this.a.showToast(this.a.getString(com.baidu.tieba.u.remove_mark));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.u.update_mark_failed));
    }
}
