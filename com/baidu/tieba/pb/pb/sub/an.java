package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.b;
/* loaded from: classes.dex */
class an implements b.a {
    final /* synthetic */ NewSubPbActivity eye;
    private boolean eyg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aNJ() {
        ao aoVar;
        aoVar = this.eye.exP;
        aoVar.jd(false);
        this.eyg = true;
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public void aNK() {
    }

    @Override // com.baidu.tieba.pb.pb.sub.b.a
    public boolean aNL() {
        ao aoVar;
        ao aoVar2;
        if (!this.eyg) {
            aoVar = this.eye.exP;
            if (aoVar.aNS() != null) {
                aoVar2 = this.eye.exP;
                return aoVar2.aNS().getTop() == 0;
            }
            return false;
        }
        this.eyg = false;
        return false;
    }
}
