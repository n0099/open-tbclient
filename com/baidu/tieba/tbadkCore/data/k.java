package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.widget.p;
import com.baidu.adp.widget.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements q {
    private final /* synthetic */ TbPageContext NC;
    final /* synthetic */ j csr;
    private final /* synthetic */ IconData css;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, IconData iconData, TbPageContext tbPageContext) {
        this.csr = jVar;
        this.css = iconData;
        this.NC = tbPageContext;
    }

    @Override // com.baidu.adp.widget.q
    public Drawable a(p pVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hl().a(this.css.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            l lVar = new l(this, pVar, this.NC);
            if (this.NC.getPageActivity() instanceof com.baidu.adp.base.m) {
                com.baidu.adp.lib.f.d.hl().a(this.css.getIcon(), 21, lVar, ((com.baidu.adp.base.m) this.NC.getPageActivity()).getUniqueId());
            }
        }
        return this.csr.f(aVar);
    }
}
