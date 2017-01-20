package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity erC;
    private boolean erE = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aOK() {
        ao aoVar;
        aoVar = this.erC.ern;
        aoVar.jc(false);
        this.erE = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aOL() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aOM() {
        ao aoVar;
        ao aoVar2;
        if (!this.erE) {
            aoVar = this.erC.ern;
            if (aoVar.aOS() != null) {
                aoVar2 = this.erC.ern;
                return aoVar2.aOS().getTop() == 0;
            }
            return false;
        }
        this.erE = false;
        return false;
    }
}
