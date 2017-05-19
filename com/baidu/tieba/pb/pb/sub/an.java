package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity eqU;
    private boolean eqW = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aMA() {
        ao aoVar;
        aoVar = this.eqU.eqF;
        aoVar.iM(false);
        this.eqW = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aMB() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aMC() {
        ao aoVar;
        ao aoVar2;
        if (!this.eqW) {
            aoVar = this.eqU.eqF;
            if (aoVar.aMJ() != null) {
                aoVar2 = this.eqU.eqF;
                return aoVar2.aMJ().getTop() == 0;
            }
            return false;
        }
        this.eqW = false;
        return false;
    }
}
