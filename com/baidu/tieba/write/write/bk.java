package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements a.b {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.iM()) {
            aVar2 = this.dqi.asi;
            aVar2.BF();
        } else {
            this.dqi.a(1, true, (String) null);
            dVar = this.dqi.arV;
            dVar.axu();
        }
        aVar.dismiss();
    }
}
