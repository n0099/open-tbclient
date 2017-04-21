package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int bAC;
    final /* synthetic */ q eHp;
    private final /* synthetic */ com.baidu.tbadk.data.k eHq;
    private final /* synthetic */ List eHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eHp = qVar;
        this.eHq = kVar;
        this.eHr = list;
        this.bAC = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eHp.d(this.eHq, this.eHr, this.bAC);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eHq;
                tbPageContext = this.eHp.ajU;
                aa.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eHq, this.eHr);
                break;
        }
        cVar.dismiss();
    }
}
