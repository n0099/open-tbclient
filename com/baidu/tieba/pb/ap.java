package com.baidu.tieba.pb;

import com.baidu.tieba.data.MarkData;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ap implements com.baidu.tieba.model.bi {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2164a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.f2164a = newPbActivity;
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
        crVar = this.f2164a.y;
        crVar.r();
        if (z) {
            bgVar = this.f2164a.t;
            bgVar.a(z2);
            bmVar = this.f2164a.s;
            bmVar.c(z2);
            bmVar2 = this.f2164a.s;
            if (bmVar2.t()) {
                this.f2164a.r();
            } else {
                crVar2 = this.f2164a.y;
                bmVar3 = this.f2164a.s;
                crVar2.a(bmVar3.l());
            }
            if (z2) {
                bgVar2 = this.f2164a.t;
                MarkData b = bgVar2.b();
                if (b != null) {
                    this.f2164a.showToast(MessageFormat.format(this.f2164a.getString(R.string.add_mark_on_pb), Integer.valueOf(b.getFloor())));
                    return;
                } else {
                    this.f2164a.showToast(this.f2164a.getString(R.string.add_mark));
                    return;
                }
            }
            this.f2164a.showToast(this.f2164a.getString(R.string.remove_mark));
            return;
        }
        this.f2164a.showToast(str);
    }
}
