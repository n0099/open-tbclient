package com.baidu.tieba.pb.main;

import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.frs.dm;
/* loaded from: classes.dex */
class at implements Cdo {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.frs.Cdo
    public void a(String str) {
        dm dmVar;
        bc bcVar;
        boolean z;
        this.a.M = false;
        dmVar = this.a.N;
        if (dmVar != null) {
            bcVar = this.a.y;
            if (bcVar.p().d().j().getIsLike() == 1) {
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

    @Override // com.baidu.tieba.frs.Cdo
    public void b(String str) {
        dm dmVar;
        this.a.M = false;
        dmVar = this.a.N;
        if (dmVar != null && str != null) {
            this.a.showToast(str);
        }
    }
}
