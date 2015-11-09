package com.baidu.tieba.image;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ a bPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bPj = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        i iVar;
        com.baidu.tbadk.core.data.b bVar;
        com.baidu.tbadk.core.data.b bVar2;
        com.baidu.tbadk.core.data.b bVar3;
        TbPageContext tbPageContext;
        i iVar2;
        com.baidu.tbadk.core.data.b bVar4;
        iVar = this.bPj.bPg;
        iVar.aap();
        bVar = this.bPj.bPd;
        String str = bVar.Ub;
        bVar2 = this.bPj.bPd;
        String str2 = bVar2.Ua;
        bVar3 = this.bPj.bPd;
        k kVar = new k(str, str2, bVar3.TX);
        tbPageContext = this.bPj.mContext;
        if (ag.a(tbPageContext.getPageActivity(), kVar, 0)) {
            iVar2 = this.bPj.bPg;
            bVar4 = this.bPj.bPd;
            iVar2.iQ(bVar4.Ub);
        }
        aVar.dismiss();
    }
}
