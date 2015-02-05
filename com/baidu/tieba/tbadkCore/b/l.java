package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.n {
    private final /* synthetic */ TbPageContext MF;
    final /* synthetic */ k bYQ;
    private final /* synthetic */ IconData bYR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, IconData iconData, TbPageContext tbPageContext) {
        this.bYQ = kVar;
        this.bYR = iconData;
        this.MF = tbPageContext;
    }

    @Override // com.baidu.tbadk.widget.n
    public Drawable a(com.baidu.tbadk.widget.m mVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.bYR.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            m mVar2 = new m(this, mVar, this.MF);
            if (this.MF.getPageActivity() instanceof com.baidu.adp.base.l) {
                com.baidu.adp.lib.f.d.ec().a(this.bYR.getIcon(), 21, mVar2, ((com.baidu.adp.base.l) this.MF.getPageActivity()).getUniqueId());
            }
        }
        return this.bYQ.f(aVar);
    }
}
