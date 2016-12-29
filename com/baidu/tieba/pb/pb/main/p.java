package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.j;
/* loaded from: classes.dex */
class p implements j.a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.j.a
    public void df(boolean z) {
        er erVar;
        er erVar2;
        this.eah.ii(z);
        erVar = this.eah.dZk;
        if (erVar.aMq() != null && z) {
            erVar2 = this.eah.dZk;
            erVar2.iF(false);
        }
    }
}
