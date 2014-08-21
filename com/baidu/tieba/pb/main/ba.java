package com.baidu.tieba.pb.main;

import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.dv;
/* loaded from: classes.dex */
class ba implements dv {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.frs.dv
    public void a(String str) {
        dt dtVar;
        bl blVar;
        boolean z;
        this.a.N = false;
        dtVar = this.a.O;
        if (dtVar != null) {
            blVar = this.a.y;
            if (blVar.r().d().g().getIsLike() == 1) {
                this.a.a(0);
            } else {
                this.a.a(1);
            }
            z = this.a.M;
            if (!z) {
                this.a.M = true;
            } else {
                this.a.M = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.dv
    public void b(String str) {
        dt dtVar;
        this.a.N = false;
        dtVar = this.a.O;
        if (dtVar != null && str != null) {
            this.a.showToast(str);
        }
    }
}
