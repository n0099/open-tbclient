package com.baidu.tieba.pb;

import com.baidu.tieba.data.MarkData;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ap implements com.baidu.tieba.model.bi {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.f2073a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bi
    public void a(boolean z, boolean z2, String str) {
        cp cpVar;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cp cpVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bg bgVar2;
        cpVar = this.f2073a.y;
        cpVar.r();
        if (z) {
            bgVar = this.f2073a.t;
            bgVar.a(z2);
            bmVar = this.f2073a.s;
            bmVar.c(z2);
            bmVar2 = this.f2073a.s;
            if (bmVar2.t()) {
                this.f2073a.r();
            } else {
                cpVar2 = this.f2073a.y;
                bmVar3 = this.f2073a.s;
                cpVar2.a(bmVar3.l());
            }
            if (z2) {
                bgVar2 = this.f2073a.t;
                MarkData b = bgVar2.b();
                if (b != null) {
                    this.f2073a.showToast(MessageFormat.format(this.f2073a.getString(R.string.add_mark_on_pb), Integer.valueOf(b.getFloor())));
                    return;
                } else {
                    this.f2073a.showToast(this.f2073a.getString(R.string.add_mark));
                    return;
                }
            }
            this.f2073a.showToast(this.f2073a.getString(R.string.remove_mark));
            return;
        }
        this.f2073a.showToast(str);
    }
}
