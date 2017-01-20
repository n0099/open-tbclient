package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class p implements f.a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void dm(boolean z) {
        ez ezVar;
        ez ezVar2;
        this.eiV.is(z);
        ezVar = this.eiV.ehV;
        if (ezVar.aOg() != null && z) {
            ezVar2 = this.eiV.ehV;
            ezVar2.iP(false);
        }
    }
}
