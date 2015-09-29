package com.baidu.tieba.image;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bOD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bOD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.b bVar;
        i iVar;
        com.baidu.tbadk.core.data.b bVar2;
        com.baidu.tbadk.core.data.b bVar3;
        com.baidu.tbadk.core.data.b bVar4;
        com.baidu.tbadk.core.data.b bVar5;
        com.baidu.tbadk.core.data.b bVar6;
        com.baidu.tbadk.core.data.b bVar7;
        TbPageContext tbPageContext;
        i iVar2;
        com.baidu.tbadk.core.data.b bVar8;
        com.baidu.tbadk.core.data.b bVar9;
        com.baidu.tbadk.core.data.b bVar10;
        TbPageContext tbPageContext2;
        i iVar3;
        com.baidu.tbadk.core.data.b bVar11;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.b bVar12;
        bVar = this.bOD.bOx;
        if (bVar != null) {
            iVar = this.bOD.bOA;
            iVar.aac();
            bVar2 = this.bOD.bOx;
            int i = bVar2.TT;
            if (i == 0) {
                if (!com.baidu.adp.lib.util.i.iM() || com.baidu.adp.lib.util.i.iN()) {
                    iVar2 = this.bOD.bOA;
                    iVar2.aab();
                    bVar8 = this.bOD.bOx;
                    String str = bVar8.TV;
                    if (StringUtils.isNull(str)) {
                        tbPageContext3 = this.bOD.mContext;
                        str = tbPageContext3.getString(i.h.app_name);
                    }
                    bVar9 = this.bOD.bOx;
                    String str2 = bVar9.TZ;
                    bVar10 = this.bOD.bOx;
                    k kVar = new k(str2, bVar10.TY, str);
                    tbPageContext2 = this.bOD.mContext;
                    if (ag.a(tbPageContext2.getPageActivity(), kVar, 0)) {
                        iVar3 = this.bOD.bOA;
                        bVar11 = this.bOD.bOx;
                        iVar3.iO(bVar11.TZ);
                        return;
                    }
                    return;
                }
                a aVar = this.bOD;
                bVar12 = this.bOD.bOx;
                aVar.b(bVar12);
            } else if (i == 2) {
                com.baidu.tbadk.download.b An = com.baidu.tbadk.download.b.An();
                bVar3 = this.bOD.bOx;
                if (An.eI(bVar3.TZ)) {
                    bVar5 = this.bOD.bOx;
                    String str3 = bVar5.TZ;
                    bVar6 = this.bOD.bOx;
                    String str4 = bVar6.TY;
                    bVar7 = this.bOD.bOx;
                    k kVar2 = new k(str3, str4, bVar7.TV);
                    tbPageContext = this.bOD.mContext;
                    ag.a(tbPageContext.getPageActivity(), kVar2);
                    return;
                }
                bVar4 = this.bOD.bOx;
                bVar4.TT = 0;
                this.bOD.ZN();
            }
        }
    }
}
