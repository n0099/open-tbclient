package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements e.a {
    final /* synthetic */ o dbg;
    private final /* synthetic */ IconData dbh;
    private final /* synthetic */ BdUniqueId dbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.dbg = oVar;
        this.dbh = iconData;
        this.dbi = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hb().a(this.dbh.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.hb().a(this.dbh.getIcon(), 21, new q(this, eVar), this.dbi);
        }
        return this.dbg.g(aVar);
    }
}
