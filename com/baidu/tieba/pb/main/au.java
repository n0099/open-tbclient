package com.baidu.tieba.pb.main;

import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.dg;
/* loaded from: classes.dex */
final class au implements dg {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.frs.dg
    public final void a() {
        de deVar;
        bf bfVar;
        boolean z;
        this.a.L = false;
        deVar = this.a.M;
        if (deVar != null) {
            bfVar = this.a.x;
            if (bfVar.p().d().k().getIsLike() == 1) {
                PbActivity.a(this.a, 0);
            } else {
                PbActivity.a(this.a, 1);
            }
            z = this.a.K;
            if (!z) {
                this.a.K = true;
            } else {
                this.a.K = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public final void a(String str) {
        de deVar;
        this.a.L = false;
        deVar = this.a.M;
        if (deVar != null && str != null) {
            this.a.showToast(str);
        }
    }
}
