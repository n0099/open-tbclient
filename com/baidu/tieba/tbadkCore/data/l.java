package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ k cZw;
    private final /* synthetic */ IconData cZx;
    private final /* synthetic */ BdUniqueId cZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.cZw = kVar;
        this.cZx = iconData;
        this.cZy = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.cZx.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.ha().a(this.cZx.getIcon(), 21, new m(this, eVar), this.cZy);
        }
        return this.cZw.g(aVar);
    }
}
