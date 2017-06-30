package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements c.b {
    private final /* synthetic */ int bHp;
    final /* synthetic */ z eVB;
    private final /* synthetic */ com.baidu.tbadk.data.k eVC;
    private final /* synthetic */ List eVD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(z zVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eVB = zVar;
        this.eVC = kVar;
        this.eVD = list;
        this.bHp = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eVB.d(this.eVC, this.eVD, this.bHp);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eVC;
                tbPageContext = this.eVB.ajP;
                aj.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aj.a(this.eVC, this.eVD);
                break;
        }
        cVar.dismiss();
    }
}
