package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class q implements f.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void dr(boolean z) {
        ex exVar;
        ex exVar2;
        this.eob.hZ(z);
        exVar = this.eob.enh;
        if (exVar.aPT() != null && z) {
            exVar2 = this.eob.enh;
            exVar2.is(false);
        }
    }
}
