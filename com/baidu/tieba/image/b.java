package com.baidu.tieba.image;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cfw = aVar;
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
        bVar = this.cfw.cfq;
        if (bVar != null) {
            iVar = this.cfw.cft;
            iVar.adZ();
            bVar2 = this.cfw.cfq;
            int i = bVar2.Ul;
            if (i == 0) {
                if (!com.baidu.adp.lib.util.i.iP() || com.baidu.adp.lib.util.i.iQ()) {
                    iVar2 = this.cfw.cft;
                    iVar2.adY();
                    bVar8 = this.cfw.cfq;
                    String str = bVar8.Un;
                    if (StringUtils.isNull(str)) {
                        tbPageContext3 = this.cfw.mContext;
                        str = tbPageContext3.getString(n.i.app_name);
                    }
                    bVar9 = this.cfw.cfq;
                    String str2 = bVar9.Ur;
                    bVar10 = this.cfw.cfq;
                    k kVar = new k(str2, bVar10.Uq, str);
                    tbPageContext2 = this.cfw.mContext;
                    if (ah.a(tbPageContext2.getPageActivity(), kVar, 0)) {
                        iVar3 = this.cfw.cft;
                        bVar11 = this.cfw.cfq;
                        iVar3.jk(bVar11.Ur);
                        return;
                    }
                    return;
                }
                a aVar = this.cfw;
                bVar12 = this.cfw.cfq;
                aVar.b(bVar12);
            } else if (i == 2) {
                com.baidu.tbadk.download.b Bm = com.baidu.tbadk.download.b.Bm();
                bVar3 = this.cfw.cfq;
                if (Bm.eW(bVar3.Ur)) {
                    bVar5 = this.cfw.cfq;
                    String str3 = bVar5.Ur;
                    bVar6 = this.cfw.cfq;
                    String str4 = bVar6.Uq;
                    bVar7 = this.cfw.cfq;
                    k kVar2 = new k(str3, str4, bVar7.Un);
                    tbPageContext = this.cfw.mContext;
                    ah.a(tbPageContext.getPageActivity(), kVar2);
                    return;
                }
                bVar4 = this.cfw.cfq;
                bVar4.Ul = 0;
                this.cfw.adK();
            }
        }
    }
}
