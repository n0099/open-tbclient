package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements e.a {
    final /* synthetic */ q ftf;
    private final /* synthetic */ IconData ftg;
    private final /* synthetic */ BdUniqueId fth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.ftf = qVar;
        this.ftg = iconData;
        this.fth = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ftg.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.g.c.eA().a(this.ftg.getIcon(), 21, new s(this, eVar), this.fth);
        }
        return this.ftf.h(aVar);
    }
}
