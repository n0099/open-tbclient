package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements e.a {
    final /* synthetic */ i cRs;
    private final /* synthetic */ IconData cRt;
    private final /* synthetic */ BdUniqueId cRu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.cRs = iVar;
        this.cRt = iconData;
        this.cRu = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.gZ().a(this.cRt.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.gZ().a(this.cRt.getIcon(), 21, new k(this, eVar), this.cRu);
        }
        return this.cRs.f(aVar);
    }
}
