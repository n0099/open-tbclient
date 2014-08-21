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
        bs bsVar;
        com.baidu.tieba.model.ai aiVar;
        bl blVar;
        bl blVar2;
        bs bsVar2;
        bl blVar3;
        com.baidu.tieba.model.ai aiVar2;
        bsVar = this.a.E;
        bsVar.x();
        if (z) {
            aiVar = this.a.z;
            aiVar.a(z2);
            blVar = this.a.y;
            blVar.c(z2);
            blVar2 = this.a.y;
            if (!blVar2.B()) {
                bsVar2 = this.a.E;
                blVar3 = this.a.y;
                bsVar2.a(blVar3.r());
            } else {
                this.a.D();
            }
            if (z2) {
                aiVar2 = this.a.z;
                MarkData b = aiVar2.b();
                if (b != null) {
                    this.a.showToast(MessageFormat.format(this.a.getString(com.baidu.tieba.x.add_mark_on_pb), Integer.valueOf(b.getFloor())));
                    return;
                } else {
                    this.a.showToast(this.a.getString(com.baidu.tieba.x.add_mark));
                    return;
                }
            }
            this.a.showToast(this.a.getString(com.baidu.tieba.x.remove_mark));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.x.update_mark_failed));
    }
}
