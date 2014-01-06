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
        cs csVar;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cs csVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bg bgVar2;
        csVar = this.a.z;
        csVar.s();
        if (z) {
            bgVar = this.a.u;
            bgVar.a(z2);
            bmVar = this.a.t;
            bmVar.c(z2);
            bmVar2 = this.a.t;
            if (bmVar2.t()) {
                this.a.t();
            } else {
                csVar2 = this.a.z;
                bmVar3 = this.a.t;
                csVar2.a(bmVar3.l());
            }
            if (z2) {
                bgVar2 = this.a.u;
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
