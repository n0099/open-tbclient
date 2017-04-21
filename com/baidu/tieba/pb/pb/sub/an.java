package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity evm;
    private boolean evo = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aPl() {
        ao aoVar;
        aoVar = this.evm.euX;
        aoVar.jh(false);
        this.evo = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aPm() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aPn() {
        ao aoVar;
        ao aoVar2;
        if (!this.evo) {
            aoVar = this.evm.euX;
            if (aoVar.aPt() != null) {
                aoVar2 = this.evm.euX;
                return aoVar2.aPt().getTop() == 0;
            }
            return false;
        }
        this.evo = false;
        return false;
    }
}
