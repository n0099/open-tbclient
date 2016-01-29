package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements e.a {
    final /* synthetic */ r dXv;
    private final /* synthetic */ IconData dXw;
    private final /* synthetic */ BdUniqueId dXx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.dXv = rVar;
        this.dXw = iconData;
        this.dXx = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hl().a(this.dXw.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.g.c.hl().a(this.dXw.getIcon(), 21, new t(this, eVar), this.dXx);
        }
        return this.dXv.g(aVar);
    }
}
