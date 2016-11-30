package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity eEs;
    private boolean eEu = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aSY() {
        ao aoVar;
        aoVar = this.eEs.eEd;
        aoVar.jf(false);
        this.eEu = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aSZ() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aTa() {
        ao aoVar;
        ao aoVar2;
        if (!this.eEu) {
            aoVar = this.eEs.eEd;
            if (aoVar.aTf() != null) {
                aoVar2 = this.eEs.eEd;
                return aoVar2.aTf().getTop() == 0;
            }
            return false;
        }
        this.eEu = false;
        return false;
    }
}
