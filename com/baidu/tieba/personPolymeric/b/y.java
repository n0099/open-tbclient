package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int byl;
    final /* synthetic */ q eEZ;
    private final /* synthetic */ com.baidu.tbadk.data.k eFa;
    private final /* synthetic */ List eFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eEZ = qVar;
        this.eFa = kVar;
        this.eFb = list;
        this.byl = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eEZ.d(this.eFa, this.eFb, this.byl);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eFa;
                tbPageContext = this.eEZ.ajT;
                aa.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eFa, this.eFb);
                break;
        }
        cVar.dismiss();
    }
}
