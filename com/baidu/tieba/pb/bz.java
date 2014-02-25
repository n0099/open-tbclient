package com.baidu.tieba.pb;

import com.baidu.tieba.data.MarkData;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class bz implements com.baidu.tieba.model.ax {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.ax
    public void a(boolean z, boolean z2, String str) {
        cu cuVar;
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        cu cuVar2;
        com.baidu.tieba.model.bb bbVar3;
        com.baidu.tieba.model.av avVar2;
        cuVar = this.a.C;
        cuVar.t();
        if (z) {
            avVar = this.a.x;
            avVar.a(z2);
            bbVar = this.a.w;
            bbVar.c(z2);
            bbVar2 = this.a.w;
            if (!bbVar2.u()) {
                cuVar2 = this.a.C;
                bbVar3 = this.a.w;
                cuVar2.a(bbVar3.m());
            } else {
                this.a.w();
            }
            if (z2) {
                avVar2 = this.a.x;
                MarkData b = avVar2.b();
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
