package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements e.a {
    private final /* synthetic */ BdUniqueId dHA;
    final /* synthetic */ r dHy;
    private final /* synthetic */ IconData dHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, IconData iconData, BdUniqueId bdUniqueId) {
        this.dHy = rVar;
        this.dHz = iconData;
        this.dHA = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.dHz.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.g.c.hd().a(this.dHz.getIcon(), 21, new t(this, eVar), this.dHA);
        }
        return this.dHy.g(aVar);
    }
}
