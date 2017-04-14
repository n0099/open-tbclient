package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity esV;
    private boolean esX = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aOk() {
        ao aoVar;
        aoVar = this.esV.esG;
        aoVar.iX(false);
        this.esX = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aOl() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aOm() {
        ao aoVar;
        ao aoVar2;
        if (!this.esX) {
            aoVar = this.esV.esG;
            if (aoVar.aOs() != null) {
                aoVar2 = this.esV.esG;
                return aoVar2.aOs().getTop() == 0;
            }
            return false;
        }
        this.esX = false;
        return false;
    }
}
