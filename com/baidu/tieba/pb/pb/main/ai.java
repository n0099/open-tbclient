package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class ai implements PbActivity.c {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.c
    public void ia(boolean z) {
        dh dhVar;
        ex exVar;
        dh dhVar2;
        ex exVar2;
        dhVar = this.eob.emx;
        if (dhVar.id(true)) {
            exVar2 = this.eob.enh;
            exVar2.aPr();
            return;
        }
        exVar = this.eob.enh;
        exVar.aKF();
        dhVar2 = this.eob.emx;
        dhVar2.oi(1);
    }
}
