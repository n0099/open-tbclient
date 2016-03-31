package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    final /* synthetic */ WriteLocationView eJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteLocationView writeLocationView) {
        this.eJG = writeLocationView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.jf()) {
            aVar2 = this.eJG.avJ;
            aVar2.Ek();
        } else {
            this.eJG.b(1, true, null);
            dVar = this.eJG.avu;
            dVar.aUl();
        }
        aVar.dismiss();
    }
}
