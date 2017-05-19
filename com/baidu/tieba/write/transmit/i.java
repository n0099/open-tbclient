package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements w {
    final /* synthetic */ h fOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.fOT = hVar;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public void a(View view, v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        ArrayList arrayList;
        com.baidu.tieba.likedForum.a aVar;
        a.InterfaceC0070a interfaceC0070a;
        com.baidu.tieba.likedForum.a aVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.hk()) {
            context = this.fOT.mContext;
            com.baidu.adp.lib.util.k.showToast(context, w.l.neterror);
        }
        TiebaStatic.log(new as("c12053"));
        arrayList = this.fOT.beS;
        if (x.r(arrayList)) {
            this.fOT.beR = new com.baidu.tieba.likedForum.a();
            aVar = this.fOT.beR;
            interfaceC0070a = this.fOT.bfj;
            aVar.a(interfaceC0070a);
            aVar2 = this.fOT.beR;
            aVar2.EG();
            return;
        }
        this.fOT.Oe();
    }
}
