package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int bAD;
    final /* synthetic */ q eCE;
    private final /* synthetic */ com.baidu.tbadk.data.j eCF;
    private final /* synthetic */ List eCG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.j jVar, List list, int i) {
        this.eCE = qVar;
        this.eCF = jVar;
        this.eCG = list;
        this.bAD = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eCE.d(this.eCF, this.eCG, this.bAD);
                break;
            case 1:
                com.baidu.tbadk.data.j jVar = this.eCF;
                tbPageContext = this.eCE.ajr;
                aa.a(jVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eCF, this.eCG);
                break;
        }
        cVar.dismiss();
    }
}
