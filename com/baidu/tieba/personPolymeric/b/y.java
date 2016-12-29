package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int dCo;
    final /* synthetic */ q etH;
    private final /* synthetic */ com.baidu.tbadk.data.l etI;
    private final /* synthetic */ List etJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.l lVar, List list, int i) {
        this.etH = qVar;
        this.etI = lVar;
        this.etJ = list;
        this.dCo = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.etH.d(this.etI, this.etJ, this.dCo);
                break;
            case 1:
                com.baidu.tbadk.data.l lVar = this.etI;
                tbPageContext = this.etH.GO;
                aa.a(lVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.etI, this.etJ);
                break;
        }
        cVar.dismiss();
    }
}
