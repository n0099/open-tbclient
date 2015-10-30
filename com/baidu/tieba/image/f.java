package com.baidu.tieba.image;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ a bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bOO = aVar;
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
        iVar = this.bOO.bOL;
        iVar.ZU();
        bVar = this.bOO.bOI;
        String str = bVar.Ua;
        bVar2 = this.bOO.bOI;
        String str2 = bVar2.TZ;
        bVar3 = this.bOO.bOI;
        k kVar = new k(str, str2, bVar3.TW);
        tbPageContext = this.bOO.mContext;
        if (ag.a(tbPageContext.getPageActivity(), kVar, 0)) {
            iVar2 = this.bOO.bOL;
            bVar4 = this.bOO.bOI;
            iVar2.iO(bVar4.Ua);
        }
        aVar.dismiss();
    }
}
