package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity euQ;
    private boolean euS = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aOb() {
        ao aoVar;
        aoVar = this.euQ.euB;
        aoVar.iY(false);
        this.euS = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aOc() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aOd() {
        ao aoVar;
        ao aoVar2;
        if (!this.euS) {
            aoVar = this.euQ.euB;
            if (aoVar.aOj() != null) {
                aoVar2 = this.euQ.euB;
                return aoVar2.aOj().getTop() == 0;
            }
            return false;
        }
        this.euS = false;
        return false;
    }
}
