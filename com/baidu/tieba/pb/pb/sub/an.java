package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity eis;
    private boolean eiu = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aMP() {
        ao aoVar;
        aoVar = this.eis.eid;
        aoVar.iQ(false);
        this.eiu = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aMQ() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aMR() {
        ao aoVar;
        ao aoVar2;
        if (!this.eiu) {
            aoVar = this.eis.eid;
            if (aoVar.aMW() != null) {
                aoVar2 = this.eis.eid;
                return aoVar2.aMW().getTop() == 0;
            }
            return false;
        }
        this.eiu = false;
        return false;
    }
}
