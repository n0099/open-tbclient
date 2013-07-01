package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f989a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.f989a = hVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        o oVar;
        int i2;
        e eVar = (e) ((ListView) adapterView).getAdapter();
        long itemId = eVar.getItemId(i);
        if (itemId == -1) {
            this.f989a.b();
        } else if (itemId == -2) {
            h hVar = this.f989a;
            i2 = hVar.g;
            hVar.g = i2 + 1;
            this.f989a.o = 4;
            this.f989a.d();
        } else {
            com.baidu.tieba.data.q qVar = (com.baidu.tieba.data.q) eVar.getItem(i);
            if (qVar != null) {
                oVar = this.f989a.q;
                oVar.a(qVar);
                this.f989a.a(qVar);
            }
        }
    }
}
