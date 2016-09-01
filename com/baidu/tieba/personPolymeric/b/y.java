package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int dQq;
    final /* synthetic */ q eHF;
    private final /* synthetic */ com.baidu.tbadk.data.k eHG;
    private final /* synthetic */ List eHH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eHF = qVar;
        this.eHG = kVar;
        this.eHH = list;
        this.dQq = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eHF.d(this.eHG, this.eHH, this.dQq);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eHG;
                tbPageContext = this.eHF.GM;
                aa.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eHG, this.eHH);
                break;
        }
        cVar.dismiss();
    }
}
