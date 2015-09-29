package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ k cYW;
    private final /* synthetic */ IconData cYX;
    private final /* synthetic */ BdUniqueId cYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.cYW = kVar;
        this.cYX = iconData;
        this.cYY = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.cYX.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.ha().a(this.cYX.getIcon(), 21, new m(this, eVar), this.cYY);
        }
        return this.cYW.g(aVar);
    }
}
