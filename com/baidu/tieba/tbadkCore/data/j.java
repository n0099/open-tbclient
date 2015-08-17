package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements e.a {
    final /* synthetic */ i cIS;
    private final /* synthetic */ IconData cIT;
    private final /* synthetic */ BdUniqueId cIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.cIS = iVar;
        this.cIT = iconData;
        this.cIU = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hc().a(this.cIT.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.hc().a(this.cIT.getIcon(), 21, new k(this, eVar), this.cIU);
        }
        return this.cIS.f(aVar);
    }
}
