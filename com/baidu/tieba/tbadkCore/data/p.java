package com.baidu.tieba.tbadkCore.data;

import android.graphics.drawable.Drawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.e;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements e.a {
    final /* synthetic */ PostData fuN;
    private final /* synthetic */ IconData fuO;
    private final /* synthetic */ BdUniqueId fuP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PostData postData, IconData iconData, BdUniqueId bdUniqueId) {
        this.fuN = postData;
        this.fuO = iconData;
        this.fuP = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.e.a
    public Drawable a(com.baidu.adp.widget.e eVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fG().a(this.fuO.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            com.baidu.adp.lib.f.c.fG().a(this.fuO.getIcon(), 21, new q(this, eVar), this.fuP);
        }
        return this.fuN.g(aVar);
    }
}
