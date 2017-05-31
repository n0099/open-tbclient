package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements x {
    final /* synthetic */ h fWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.fWP = hVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void a(View view, v vVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        ArrayList arrayList;
        com.baidu.tieba.likedForum.a aVar;
        a.InterfaceC0070a interfaceC0070a;
        com.baidu.tieba.likedForum.a aVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.hk()) {
            context = this.fWP.mContext;
            com.baidu.adp.lib.util.k.showToast(context, w.l.neterror);
        }
        TiebaStatic.log(new as("c12053"));
        arrayList = this.fWP.bfU;
        if (com.baidu.tbadk.core.util.x.r(arrayList)) {
            this.fWP.bfT = new com.baidu.tieba.likedForum.a();
            aVar = this.fWP.bfT;
            interfaceC0070a = this.fWP.bgl;
            aVar.a(interfaceC0070a);
            aVar2 = this.fWP.bfT;
            aVar2.EA();
            return;
        }
        this.fWP.Oo();
    }
}
