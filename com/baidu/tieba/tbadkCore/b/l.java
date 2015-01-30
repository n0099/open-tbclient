package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.n {
    private final /* synthetic */ TbPageContext MI;
    final /* synthetic */ k bYR;
    private final /* synthetic */ IconData bYS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, IconData iconData, TbPageContext tbPageContext) {
        this.bYR = kVar;
        this.bYS = iconData;
        this.MI = tbPageContext;
    }

    @Override // com.baidu.tbadk.widget.n
    public Drawable a(com.baidu.tbadk.widget.m mVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.bYS.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            m mVar2 = new m(this, mVar, this.MI);
            if (this.MI.getPageActivity() instanceof com.baidu.adp.base.l) {
                com.baidu.adp.lib.f.d.ec().a(this.bYS.getIcon(), 21, mVar2, ((com.baidu.adp.base.l) this.MI.getPageActivity()).getUniqueId());
            }
        }
        return this.bYR.f(aVar);
    }
}
