package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int brs;
    final /* synthetic */ q eDB;
    private final /* synthetic */ com.baidu.tbadk.data.k eDC;
    private final /* synthetic */ List eDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eDB = qVar;
        this.eDC = kVar;
        this.eDD = list;
        this.brs = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eDB.d(this.eDC, this.eDD, this.brs);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eDC;
                tbPageContext = this.eDB.FY;
                aa.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eDC, this.eDD);
                break;
        }
        cVar.dismiss();
    }
}
