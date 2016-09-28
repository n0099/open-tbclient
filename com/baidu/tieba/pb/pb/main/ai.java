package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class ai implements PbActivity.c {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.c
    public void id(boolean z) {
        dh dhVar;
        ex exVar;
        dh dhVar2;
        ex exVar2;
        dhVar = this.eqa.eov;
        if (dhVar.ig(true)) {
            exVar2 = this.eqa.epe;
            exVar2.aQa();
            return;
        }
        exVar = this.eqa.epe;
        exVar.aLg();
        dhVar2 = this.eqa.eov;
        dhVar2.os(1);
    }
}
