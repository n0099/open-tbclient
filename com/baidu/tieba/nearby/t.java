package com.baidu.tieba.nearby;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.c.ae;
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
        com.baidu.tieba.b.l lVar;
        com.baidu.tieba.b.l lVar2;
        com.baidu.tieba.b.l lVar3;
        com.baidu.tieba.b.l lVar4;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        wVar = this.a.f;
        long itemId = wVar.getItemId(i);
        lVar = this.a.h;
        if (lVar != null) {
            lVar2 = this.a.h;
            if (itemId < lVar2.a().size()) {
                wVar4 = this.a.f;
                if (wVar4.getItem(i) instanceof com.baidu.tieba.b.n) {
                    wVar5 = this.a.f;
                    com.baidu.tieba.b.n nVar = (com.baidu.tieba.b.n) wVar5.getItem(i);
                    if (ae.d(nVar.a())) {
                        FrsActivity.a(this.a, nVar.a(), "radar_list");
                        return;
                    }
                    return;
                }
                return;
            }
            lVar3 = this.a.h;
            int size = lVar3.a().size();
            lVar4 = this.a.h;
            if (itemId < size + lVar4.b().size()) {
                wVar2 = this.a.f;
                if (wVar2.getItem(i) instanceof com.baidu.tieba.b.o) {
                    wVar3 = this.a.f;
                    PbActivity.a((Context) this.a, ((com.baidu.tieba.b.o) wVar3.getItem(i)).b(), "radar_list", false);
                    return;
                }
                return;
            }
            this.a.j();
            return;
        }
        this.a.j();
    }
}
