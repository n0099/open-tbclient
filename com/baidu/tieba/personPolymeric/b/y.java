package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int dXL;
    final /* synthetic */ q eQi;
    private final /* synthetic */ com.baidu.tbadk.data.l eQj;
    private final /* synthetic */ List eQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.l lVar, List list, int i) {
        this.eQi = qVar;
        this.eQj = lVar;
        this.eQk = list;
        this.dXL = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eQi.d(this.eQj, this.eQk, this.dXL);
                break;
            case 1:
                com.baidu.tbadk.data.l lVar = this.eQj;
                tbPageContext = this.eQi.GO;
                aa.a(lVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eQj, this.eQk);
                break;
        }
        cVar.dismiss();
    }
}
