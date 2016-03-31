package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements e.a {
    final /* synthetic */ s eqg;
    private final /* synthetic */ IconData eqh;
    private final /* synthetic */ BdUniqueId eqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.eqg = sVar;
        this.eqh = iconData;
        this.eqi = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hr().a(this.eqh.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.g.c.hr().a(this.eqh.getIcon(), 21, new u(this, eVar), this.eqi);
        }
        return this.eqg.g(aVar);
    }
}
