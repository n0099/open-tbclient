package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class y implements a.b {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        dh dhVar;
        ex exVar;
        ex exVar2;
        ex exVar3;
        dh dhVar2;
        ex exVar4;
        this.eqa.abd();
        dhVar = this.eqa.eov;
        com.baidu.tbadk.core.data.am api = dhVar.api();
        exVar = this.eqa.epe;
        int pageNum = exVar.getPageNum();
        if (pageNum <= 0) {
            this.eqa.showToast(r.j.pb_page_error);
        } else if (api == null || pageNum <= api.qw()) {
            exVar2 = this.eqa.epe;
            exVar2.aBc();
            this.eqa.on(2);
            this.eqa.abb();
            exVar3 = this.eqa.epe;
            exVar3.aPY();
            if (com.baidu.adp.lib.util.i.gm()) {
                dhVar2 = this.eqa.eov;
                exVar4 = this.eqa.epe;
                dhVar2.os(exVar4.getPageNum());
            } else {
                this.eqa.showToast(r.j.neterror);
            }
            aVar.dismiss();
        } else {
            this.eqa.showToast(r.j.pb_page_error);
        }
    }
}
