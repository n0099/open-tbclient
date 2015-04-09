package com.baidu.tieba.tbadkCore.c;

import android.graphics.drawable.Drawable;
import com.baidu.adp.widget.p;
import com.baidu.adp.widget.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements q {
    private final /* synthetic */ TbPageContext Np;
    final /* synthetic */ j cos;
    private final /* synthetic */ IconData cot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, IconData iconData, TbPageContext tbPageContext) {
        this.cos = jVar;
        this.cot = iconData;
        this.Np = tbPageContext;
    }

    @Override // com.baidu.adp.widget.q
    public Drawable a(p pVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.cot.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            l lVar = new l(this, pVar, this.Np);
            if (this.Np.getPageActivity() instanceof com.baidu.adp.base.l) {
                com.baidu.adp.lib.f.d.hB().a(this.cot.getIcon(), 21, lVar, ((com.baidu.adp.base.l) this.Np.getPageActivity()).getUniqueId());
            }
        }
        return this.cos.f(aVar);
    }
}
