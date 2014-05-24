package com.baidu.tieba.pb.main;

import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dp;
/* loaded from: classes.dex */
class at implements dp {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.frs.dp
    public void a(String str) {
        dn dnVar;
        bj bjVar;
        boolean z;
        this.a.L = false;
        dnVar = this.a.M;
        if (dnVar != null) {
            bjVar = this.a.x;
            if (bjVar.p().d().o().getIsLike() == 1) {
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

    @Override // com.baidu.tieba.frs.dp
    public void b(String str) {
        dn dnVar;
        this.a.L = false;
        dnVar = this.a.M;
        if (dnVar != null && str != null) {
            this.a.showToast(str);
        }
    }
}
