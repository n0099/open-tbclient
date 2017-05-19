package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements e.a {
    final /* synthetic */ PostData fuV;
    private final /* synthetic */ IconData fuW;
    private final /* synthetic */ BdUniqueId fuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PostData postData, IconData iconData, BdUniqueId bdUniqueId) {
        this.fuV = postData;
        this.fuW = iconData;
        this.fuX = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.fuW.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.fM().a(this.fuW.getIcon(), 21, new q(this, eVar), this.fuX);
        }
        return this.fuV.g(aVar);
    }
}
