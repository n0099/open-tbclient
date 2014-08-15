package com.baidu.tieba.pb.main;

import com.baidu.tieba.frs.dr;
import com.baidu.tieba.frs.dt;
/* loaded from: classes.dex */
class ba implements dt {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.frs.dt
    public void a(String str) {
        dr drVar;
        bl blVar;
        boolean z;
        this.a.M = false;
        drVar = this.a.N;
        if (drVar != null) {
            blVar = this.a.x;
            if (blVar.r().d().g().getIsLike() == 1) {
                this.a.a(0);
            } else {
                this.a.a(1);
            }
            z = this.a.L;
            if (!z) {
                this.a.L = true;
            } else {
                this.a.L = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.dt
    public void b(String str) {
        dr drVar;
        this.a.M = false;
        drVar = this.a.N;
        if (drVar != null && str != null) {
            this.a.showToast(str);
        }
    }
}
