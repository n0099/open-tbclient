package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            aVar2 = this.ets.avj;
            aVar2.DA();
        } else {
            this.ets.a(1, true, (String) null);
            dVar = this.ets.auU;
            dVar.aNj();
        }
        aVar.dismiss();
    }
}
