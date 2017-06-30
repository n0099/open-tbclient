package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements x {
    final /* synthetic */ k ghP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ghP = kVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void a(View view, v vVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        ArrayList arrayList;
        BdUniqueId bdUniqueId2;
        com.baidu.tieba.likedForum.a aVar;
        a.InterfaceC0073a interfaceC0073a;
        com.baidu.tieba.likedForum.a aVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.hj()) {
            context = this.ghP.mContext;
            com.baidu.adp.lib.util.k.showToast(context, w.l.neterror);
        }
        TiebaStatic.log(new au("c12053"));
        arrayList = this.ghP.biS;
        if (z.t(arrayList)) {
            k kVar = this.ghP;
            bdUniqueId2 = this.ghP.mPageId;
            kVar.biR = new com.baidu.tieba.likedForum.a(bdUniqueId2);
            aVar = this.ghP.biR;
            interfaceC0073a = this.ghP.bjn;
            aVar.a(interfaceC0073a);
            aVar2 = this.ghP.biR;
            aVar2.EX();
            return;
        }
        this.ghP.PF();
    }
}
