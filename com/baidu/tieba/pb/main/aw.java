package com.baidu.tieba.pb.main;

import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.frs.dq;
/* loaded from: classes.dex */
class aw implements dq {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.frs.dq
    public void a(String str) {
        Cdo cdo;
        bm bmVar;
        boolean z;
        this.a.L = false;
        cdo = this.a.M;
        if (cdo != null) {
            bmVar = this.a.x;
            if (bmVar.r().c().o().getIsLike() == 1) {
                this.a.a(0);
            } else {
                this.a.a(1);
            }
            z = this.a.K;
            if (!z) {
                this.a.K = true;
            } else {
                this.a.K = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.dq
    public void b(String str) {
        Cdo cdo;
        this.a.L = false;
        cdo = this.a.M;
        if (cdo != null && str != null) {
            this.a.showToast(str);
        }
    }
}
