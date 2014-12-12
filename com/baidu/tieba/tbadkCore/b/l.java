package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.widget.n {
    private final /* synthetic */ TbPageContext Mm;
    final /* synthetic */ k bWY;
    private final /* synthetic */ IconData bWZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, IconData iconData, TbPageContext tbPageContext) {
        this.bWY = kVar;
        this.bWZ = iconData;
        this.Mm = tbPageContext;
    }

    @Override // com.baidu.tbadk.widget.n
    public Drawable a(com.baidu.tbadk.widget.m mVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ee().a(this.bWZ.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            m mVar2 = new m(this, mVar, this.Mm);
            if (this.Mm instanceof com.baidu.adp.base.l) {
                com.baidu.adp.lib.f.d.ee().a(this.bWZ.getIcon(), 21, mVar2, ((com.baidu.adp.base.l) this.Mm).getUniqueId());
            }
        }
        return this.bWY.f(aVar);
    }
}
