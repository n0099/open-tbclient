package com.baidu.tieba.pb;

import com.baidu.tieba.data.MarkData;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.model.bi {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bi
    public void a(boolean z, boolean z2, String str) {
        cr crVar;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cr crVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bg bgVar2;
        crVar = this.a.A;
        crVar.s();
        if (z) {
            bgVar = this.a.v;
            bgVar.a(z2);
            bmVar = this.a.u;
            bmVar.c(z2);
            bmVar2 = this.a.u;
            if (bmVar2.t()) {
                this.a.t();
            } else {
                crVar2 = this.a.A;
                bmVar3 = this.a.u;
                crVar2.a(bmVar3.l());
            }
            if (z2) {
                bgVar2 = this.a.v;
                MarkData b = bgVar2.b();
                if (b != null) {
                    this.a.showToast(MessageFormat.format(this.a.getString(R.string.add_mark_on_pb), Integer.valueOf(b.getFloor())));
                    return;
                } else {
                    this.a.showToast(this.a.getString(R.string.add_mark));
                    return;
                }
            }
            this.a.showToast(this.a.getString(R.string.remove_mark));
            return;
        }
        this.a.showToast(str);
    }
}
