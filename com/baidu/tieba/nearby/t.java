package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ NearbyListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NearbyListActivity nearbyListActivity) {
        this.a = nearbyListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        w wVar;
        com.baidu.tieba.b.j jVar;
        com.baidu.tieba.b.j jVar2;
        com.baidu.tieba.b.j jVar3;
        com.baidu.tieba.b.j jVar4;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        wVar = this.a.e;
        long itemId = wVar.getItemId(i);
        jVar = this.a.g;
        if (jVar == null) {
            this.a.h();
            return;
        }
        jVar2 = this.a.g;
        if (itemId < jVar2.a().size()) {
            wVar4 = this.a.e;
            if (wVar4.getItem(i) instanceof com.baidu.tieba.b.l) {
                wVar5 = this.a.e;
                com.baidu.tieba.b.l lVar = (com.baidu.tieba.b.l) wVar5.getItem(i);
                if (ad.d(lVar.a())) {
                    FrsActivity.a(this.a, lVar.a(), "radar_list");
                    return;
                }
                return;
            }
            return;
        }
        jVar3 = this.a.g;
        int size = jVar3.a().size();
        jVar4 = this.a.g;
        if (itemId >= size + jVar4.b().size()) {
            this.a.h();
            return;
        }
        wVar2 = this.a.e;
        if (wVar2.getItem(i) instanceof com.baidu.tieba.b.m) {
            wVar3 = this.a.e;
            PbActivity.a((Context) this.a, ((com.baidu.tieba.b.m) wVar3.getItem(i)).b(), "radar_list", false);
        }
    }
}
