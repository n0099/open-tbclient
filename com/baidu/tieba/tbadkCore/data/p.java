package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements e.a {
    final /* synthetic */ PostData fMS;
    private final /* synthetic */ IconData fMT;
    private final /* synthetic */ BdUniqueId fMU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PostData postData, IconData iconData, BdUniqueId bdUniqueId) {
        this.fMS = postData;
        this.fMT = iconData;
        this.fMU = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.fMT.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.fL().a(this.fMT.getIcon(), 21, new q(this, eVar), this.fMU);
        }
        return this.fMS.g(aVar);
    }
}
