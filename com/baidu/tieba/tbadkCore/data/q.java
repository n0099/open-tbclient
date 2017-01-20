package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements e.a {
    final /* synthetic */ p fqp;
    private final /* synthetic */ IconData fqq;
    private final /* synthetic */ BdUniqueId fqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.fqp = pVar;
        this.fqq = iconData;
        this.fqr = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ey().a(this.fqq.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.ey().a(this.fqq.getIcon(), 21, new r(this, eVar), this.fqr);
        }
        return this.fqp.g(aVar);
    }
}
