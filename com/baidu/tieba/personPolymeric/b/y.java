package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    private final /* synthetic */ int dSl;
    final /* synthetic */ q eJJ;
    private final /* synthetic */ com.baidu.tbadk.data.k eJK;
    private final /* synthetic */ List eJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tbadk.data.k kVar, List list, int i) {
        this.eJJ = qVar;
        this.eJK = kVar;
        this.eJL = list;
        this.dSl = i;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        TbPageContext tbPageContext;
        switch (i) {
            case 0:
                this.eJJ.d(this.eJK, this.eJL, this.dSl);
                break;
            case 1:
                com.baidu.tbadk.data.k kVar = this.eJK;
                tbPageContext = this.eJJ.GM;
                aa.a(kVar, tbPageContext.getUniqueId());
                break;
            case 2:
                aa.a(this.eJK, this.eJL);
                break;
        }
        cVar.dismiss();
    }
}
