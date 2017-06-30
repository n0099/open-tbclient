package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity eHC;
    private boolean eHE = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aRJ() {
        ao aoVar;
        aoVar = this.eHC.eHn;
        aoVar.jB(false);
        this.eHE = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aRK() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aRL() {
        ao aoVar;
        ao aoVar2;
        if (!this.eHE) {
            aoVar = this.eHC.eHn;
            if (aoVar.aRR() != null) {
                aoVar2 = this.eHC.eHn;
                return aoVar2.aRR().getTop() == 0;
            }
            return false;
        }
        this.eHE = false;
        return false;
    }
}
