package com.baidu.tieba.image;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a coa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.coa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.c cVar;
        i iVar;
        TbPageContext<?> tbPageContext;
        com.baidu.tbadk.core.data.c cVar2;
        cVar = this.coa.cnU;
        if (cVar != null) {
            iVar = this.coa.cnX;
            iVar.ain();
            be wt = be.wt();
            tbPageContext = this.coa.MR;
            cVar2 = this.coa.cnU;
            wt.a(tbPageContext, new String[]{cVar2.Uw}, true);
        }
    }
}
