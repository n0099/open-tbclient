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
        bq bqVar;
        com.baidu.tieba.model.ai aiVar;
        bj bjVar;
        bj bjVar2;
        bq bqVar2;
        bj bjVar3;
        com.baidu.tieba.model.ai aiVar2;
        bqVar = this.a.D;
        bqVar.w();
        if (z) {
            aiVar = this.a.y;
            aiVar.a(z2);
            bjVar = this.a.x;
            bjVar.c(z2);
            bjVar2 = this.a.x;
            if (!bjVar2.y()) {
                bqVar2 = this.a.D;
                bjVar3 = this.a.x;
                bqVar2.a(bjVar3.q());
            } else {
                this.a.A();
            }
            if (z2) {
                aiVar2 = this.a.y;
                MarkData b = aiVar2.b();
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
