package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int bys;
    final /* synthetic */ q eHd;
    private final /* synthetic */ com.baidu.tbadk.data.k eHe;
    private final /* synthetic */ List eHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eHd = qVar;
        this.eHe = kVar;
        this.eHf = list;
        this.bys = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eHd.d(this.eHe, this.eHf, this.bys);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eHe;
                tbPageContext = this.eHd.ajF;
                aa.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eHe, this.eHf);
                break;
        }
        cVar.dismiss();
    }
}
