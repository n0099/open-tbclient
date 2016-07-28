package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.b {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.fq()) {
            aVar2 = this.fVn.atn;
            aVar2.Cl();
        } else {
            this.fVn.b(1, true, null);
            dVar = this.fVn.asY;
            dVar.bgp();
        }
        aVar.dismiss();
    }
}
