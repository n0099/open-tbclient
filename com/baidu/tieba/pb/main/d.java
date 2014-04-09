package com.baidu.tieba.pb.main;

import com.baidu.tieba.data.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
final class d implements com.baidu.tieba.model.ak {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.model.ak
    public final void a(boolean z, boolean z2) {
        bm bmVar;
        com.baidu.tieba.model.ai aiVar;
        bf bfVar;
        bf bfVar2;
        bm bmVar2;
        bf bfVar3;
        com.baidu.tieba.model.ai aiVar2;
        bmVar = this.a.D;
        bmVar.w();
        if (z) {
            aiVar = this.a.y;
            aiVar.a(z2);
            bfVar = this.a.x;
            bfVar.c(z2);
            bfVar2 = this.a.x;
            if (!bfVar2.w()) {
                bmVar2 = this.a.D;
                bfVar3 = this.a.x;
                bmVar2.a(bfVar3.p());
            } else {
                PbActivity.c(this.a);
            }
            if (z2) {
                aiVar2 = this.a.y;
                MarkData b = aiVar2.b();
                if (b != null) {
                    this.a.showToast(MessageFormat.format(this.a.getString(com.baidu.tieba.a.k.add_mark_on_pb), Integer.valueOf(b.getFloor())));
                    return;
                } else {
                    this.a.showToast(this.a.getString(com.baidu.tieba.a.k.add_mark));
                    return;
                }
            }
            this.a.showToast(this.a.getString(com.baidu.tieba.a.k.remove_mark));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.a.k.update_mark_failed));
    }
}
