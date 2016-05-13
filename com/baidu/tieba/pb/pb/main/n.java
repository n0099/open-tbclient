package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class n implements f.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void gA(boolean z) {
        el elVar;
        el elVar2;
        this.djE.gz(z);
        elVar = this.djE.diR;
        if (elVar.azG() != null && z) {
            elVar2 = this.djE.diR;
            elVar2.gS(false);
        }
    }
}
