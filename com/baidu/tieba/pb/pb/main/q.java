package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class q implements f.a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void ds(boolean z) {
        ex exVar;
        ex exVar2;
        this.eqa.ic(z);
        exVar = this.eqa.epe;
        if (exVar.aQC() != null && z) {
            exVar2 = this.eqa.epe;
            exVar2.iv(false);
        }
    }
}
