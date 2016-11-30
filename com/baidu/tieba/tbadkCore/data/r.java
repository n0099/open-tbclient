package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements e.a {
    final /* synthetic */ q fCW;
    private final /* synthetic */ IconData fCX;
    private final /* synthetic */ BdUniqueId fCY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.fCW = qVar;
        this.fCX = iconData;
        this.fCY = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.fCX.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.g.c.eA().a(this.fCX.getIcon(), 21, new s(this, eVar), this.fCY);
        }
        return this.fCW.h(aVar);
    }
}
