package com.baidu.tieba.tbadkCore.c;

import android.graphics.drawable.Drawable;
import com.baidu.adp.widget.p;
import com.baidu.adp.widget.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements q {
    private final /* synthetic */ TbPageContext Nn;
    final /* synthetic */ j coc;
    private final /* synthetic */ IconData cod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, IconData iconData, TbPageContext tbPageContext) {
        this.coc = jVar;
        this.cod = iconData;
        this.Nn = tbPageContext;
    }

    @Override // com.baidu.adp.widget.q
    public Drawable a(p pVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.cod.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            l lVar = new l(this, pVar, this.Nn);
            if (this.Nn.getPageActivity() instanceof com.baidu.adp.base.l) {
                com.baidu.adp.lib.f.d.hB().a(this.cod.getIcon(), 21, lVar, ((com.baidu.adp.base.l) this.Nn.getPageActivity()).getUniqueId());
            }
        }
        return this.coc.f(aVar);
    }
}
