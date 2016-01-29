package com.baidu.tieba.image;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ a coa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.coa = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.data.c cVar;
        i iVar;
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.c cVar2;
        i iVar2;
        com.baidu.tbadk.core.data.c cVar3;
        TbPageContext tbPageContext2;
        cVar = this.coa.cnU;
        String str = cVar.Uu;
        if (StringUtils.isNull(str)) {
            tbPageContext2 = this.coa.MR;
            str = tbPageContext2.getString(t.j.app_name);
        }
        iVar = this.coa.cnX;
        iVar.aip();
        tbPageContext = this.coa.MR;
        Activity pageActivity = tbPageContext.getPageActivity();
        cVar2 = this.coa.cnU;
        if (ag.a(pageActivity, cVar2, 0, str)) {
            iVar2 = this.coa.cnX;
            cVar3 = this.coa.cnU;
            iVar2.jC(cVar3.Uy);
        }
        aVar.dismiss();
    }
}
