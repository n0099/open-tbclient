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
        bk bkVar;
        com.baidu.tieba.model.ai aiVar;
        bd bdVar;
        bd bdVar2;
        bk bkVar2;
        bd bdVar3;
        com.baidu.tieba.model.ai aiVar2;
        bkVar = this.a.D;
        bkVar.w();
        if (z) {
            aiVar = this.a.y;
            aiVar.a(z2);
            bdVar = this.a.x;
            bdVar.c(z2);
            bdVar2 = this.a.x;
            if (!bdVar2.w()) {
                bkVar2 = this.a.D;
                bdVar3 = this.a.x;
                bkVar2.a(bdVar3.p());
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
