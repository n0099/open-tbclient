package com.baidu.tieba.image;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bPj = aVar;
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
        bVar = this.bPj.bPd;
        if (bVar != null) {
            iVar = this.bPj.bPg;
            iVar.aat();
            bVar2 = this.bPj.bPd;
            int i = bVar2.TV;
            if (i == 0) {
                if (!com.baidu.adp.lib.util.i.iN() || com.baidu.adp.lib.util.i.iO()) {
                    iVar2 = this.bPj.bPg;
                    iVar2.aas();
                    bVar8 = this.bPj.bPd;
                    String str = bVar8.TX;
                    if (StringUtils.isNull(str)) {
                        tbPageContext3 = this.bPj.mContext;
                        str = tbPageContext3.getString(i.h.app_name);
                    }
                    bVar9 = this.bPj.bPd;
                    String str2 = bVar9.Ub;
                    bVar10 = this.bPj.bPd;
                    k kVar = new k(str2, bVar10.Ua, str);
                    tbPageContext2 = this.bPj.mContext;
                    if (ag.a(tbPageContext2.getPageActivity(), kVar, 0)) {
                        iVar3 = this.bPj.bPg;
                        bVar11 = this.bPj.bPd;
                        iVar3.iQ(bVar11.Ub);
                        return;
                    }
                    return;
                }
                a aVar = this.bPj;
                bVar12 = this.bPj.bPd;
                aVar.b(bVar12);
            } else if (i == 2) {
                com.baidu.tbadk.download.b Ap = com.baidu.tbadk.download.b.Ap();
                bVar3 = this.bPj.bPd;
                if (Ap.eI(bVar3.Ub)) {
                    bVar5 = this.bPj.bPd;
                    String str3 = bVar5.Ub;
                    bVar6 = this.bPj.bPd;
                    String str4 = bVar6.Ua;
                    bVar7 = this.bPj.bPd;
                    k kVar2 = new k(str3, str4, bVar7.TX);
                    tbPageContext = this.bPj.mContext;
                    ag.a(tbPageContext.getPageActivity(), kVar2);
                    return;
                }
                bVar4 = this.bPj.bPd;
                bVar4.TV = 0;
                this.bPj.aae();
            }
        }
    }
}
