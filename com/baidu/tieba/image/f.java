package com.baidu.tieba.image;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ a bOD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bOD = aVar;
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
        iVar = this.bOD.bOA;
        iVar.ZY();
        bVar = this.bOD.bOx;
        String str = bVar.TZ;
        bVar2 = this.bOD.bOx;
        String str2 = bVar2.TY;
        bVar3 = this.bOD.bOx;
        k kVar = new k(str, str2, bVar3.TV);
        tbPageContext = this.bOD.mContext;
        if (ag.a(tbPageContext.getPageActivity(), kVar, 0)) {
            iVar2 = this.bOD.bOA;
            bVar4 = this.bOD.bOx;
            iVar2.iO(bVar4.TZ);
        }
        aVar.dismiss();
    }
}
