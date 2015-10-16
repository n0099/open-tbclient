package com.baidu.tieba.image;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bOO = aVar;
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
        bVar = this.bOO.bOI;
        if (bVar != null) {
            iVar = this.bOO.bOL;
            iVar.aac();
            bVar2 = this.bOO.bOI;
            int i = bVar2.TU;
            if (i == 0) {
                if (!com.baidu.adp.lib.util.i.iM() || com.baidu.adp.lib.util.i.iN()) {
                    iVar2 = this.bOO.bOL;
                    iVar2.aab();
                    bVar8 = this.bOO.bOI;
                    String str = bVar8.TW;
                    if (StringUtils.isNull(str)) {
                        tbPageContext3 = this.bOO.mContext;
                        str = tbPageContext3.getString(i.h.app_name);
                    }
                    bVar9 = this.bOO.bOI;
                    String str2 = bVar9.Ua;
                    bVar10 = this.bOO.bOI;
                    k kVar = new k(str2, bVar10.TZ, str);
                    tbPageContext2 = this.bOO.mContext;
                    if (ag.a(tbPageContext2.getPageActivity(), kVar, 0)) {
                        iVar3 = this.bOO.bOL;
                        bVar11 = this.bOO.bOI;
                        iVar3.iO(bVar11.Ua);
                        return;
                    }
                    return;
                }
                a aVar = this.bOO;
                bVar12 = this.bOO.bOI;
                aVar.b(bVar12);
            } else if (i == 2) {
                com.baidu.tbadk.download.b An = com.baidu.tbadk.download.b.An();
                bVar3 = this.bOO.bOI;
                if (An.eI(bVar3.Ua)) {
                    bVar5 = this.bOO.bOI;
                    String str3 = bVar5.Ua;
                    bVar6 = this.bOO.bOI;
                    String str4 = bVar6.TZ;
                    bVar7 = this.bOO.bOI;
                    k kVar2 = new k(str3, str4, bVar7.TW);
                    tbPageContext = this.bOO.mContext;
                    ag.a(tbPageContext.getPageActivity(), kVar2);
                    return;
                }
                bVar4 = this.bOO.bOI;
                bVar4.TU = 0;
                this.bOO.ZN();
            }
        }
    }
}
