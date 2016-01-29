package com.baidu.tieba.image;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a coa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.coa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.c cVar;
        i iVar;
        com.baidu.tbadk.core.data.c cVar2;
        com.baidu.tbadk.core.data.c cVar3;
        i iVar2;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.c cVar4;
        i iVar3;
        com.baidu.tbadk.core.data.c cVar5;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.c cVar6;
        com.baidu.tbadk.core.data.c cVar7;
        com.baidu.tbadk.core.data.c cVar8;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.c cVar9;
        com.baidu.tbadk.core.data.c cVar10;
        com.baidu.tbadk.core.data.c cVar11;
        cVar = this.coa.cnU;
        if (cVar != null) {
            iVar = this.coa.cnX;
            iVar.ain();
            cVar2 = this.coa.cnU;
            int i = cVar2.Us;
            if (i == 0 || i == 3) {
                if (!com.baidu.adp.lib.util.i.iZ() || com.baidu.adp.lib.util.i.ja()) {
                    cVar3 = this.coa.cnU;
                    String str = cVar3.Uu;
                    if (StringUtils.isNull(str)) {
                        tbPageContext2 = this.coa.MR;
                        str = tbPageContext2.getString(t.j.app_name);
                    }
                    iVar2 = this.coa.cnX;
                    iVar2.aip();
                    tbPageContext = this.coa.MR;
                    Activity pageActivity = tbPageContext.getPageActivity();
                    cVar4 = this.coa.cnU;
                    if (ag.a(pageActivity, cVar4, 0, str)) {
                        iVar3 = this.coa.cnX;
                        cVar5 = this.coa.cnU;
                        iVar3.jC(cVar5.Uy);
                        return;
                    }
                    return;
                }
                a aVar = this.coa;
                cVar6 = this.coa.cnU;
                aVar.c(cVar6);
            } else if (i == 1) {
                cVar10 = this.coa.cnU;
                ag.e(cVar10);
                cVar11 = this.coa.cnU;
                cVar11.Us = 3;
                this.coa.aic();
            } else if (i == 2) {
                com.baidu.tbadk.download.b Cr = com.baidu.tbadk.download.b.Cr();
                cVar7 = this.coa.cnU;
                if (!Cr.eZ(cVar7.Uy)) {
                    cVar8 = this.coa.cnU;
                    cVar8.Us = 0;
                    this.coa.aic();
                    return;
                }
                tbPageContext3 = this.coa.MR;
                Activity pageActivity2 = tbPageContext3.getPageActivity();
                cVar9 = this.coa.cnU;
                ag.N(pageActivity2, cVar9.Uy);
            }
        }
    }
}
