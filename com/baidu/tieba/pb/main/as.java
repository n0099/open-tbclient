package com.baidu.tieba.pb.main;

import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.de;
/* loaded from: classes.dex */
final class as implements de {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.frs.de
    public final void a() {
        dc dcVar;
        bd bdVar;
        dcVar = this.a.L;
        if (dcVar != null) {
            this.a.K = false;
            bdVar = this.a.x;
            if (bdVar.p().d().k().getIsLike() == 1) {
                PbActivity.a(this.a, 0);
            } else {
                PbActivity.a(this.a, 1);
            }
        }
    }

    @Override // com.baidu.tieba.frs.de
    public final void a(String str) {
        dc dcVar;
        dcVar = this.a.L;
        if (dcVar != null) {
            this.a.K = false;
            if (str != null) {
                this.a.showToast(str);
            }
        }
    }
}
