package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    final /* synthetic */ WriteLocationView fax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteLocationView writeLocationView) {
        this.fax = writeLocationView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.fq()) {
            aVar2 = this.fax.arI;
            aVar2.Cd();
        } else {
            this.fax.b(1, true, null);
            dVar = this.fax.art;
            dVar.aUG();
        }
        aVar.dismiss();
    }
}
