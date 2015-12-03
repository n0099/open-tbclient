package com.baidu.tieba.image;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ a cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cfw = aVar;
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
        iVar = this.cfw.cft;
        iVar.adV();
        bVar = this.cfw.cfq;
        String str = bVar.Ur;
        bVar2 = this.cfw.cfq;
        String str2 = bVar2.Uq;
        bVar3 = this.cfw.cfq;
        k kVar = new k(str, str2, bVar3.Un);
        tbPageContext = this.cfw.mContext;
        if (ah.a(tbPageContext.getPageActivity(), kVar, 0)) {
            iVar2 = this.cfw.cft;
            bVar4 = this.cfw.cfq;
            iVar2.jk(bVar4.Ur);
        }
        aVar.dismiss();
    }
}
