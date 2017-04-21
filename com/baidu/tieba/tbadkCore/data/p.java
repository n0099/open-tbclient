package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements e.a {
    final /* synthetic */ PostData fyN;
    private final /* synthetic */ IconData fyO;
    private final /* synthetic */ BdUniqueId fyP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PostData postData, IconData iconData, BdUniqueId bdUniqueId) {
        this.fyN = postData;
        this.fyO = iconData;
        this.fyP = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.fyO.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.fM().a(this.fyO.getIcon(), 21, new q(this, eVar), this.fyP);
        }
        return this.fyN.g(aVar);
    }
}
