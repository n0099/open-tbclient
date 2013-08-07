package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.f1300a = hVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        o oVar;
        int i2;
        e eVar = (e) ((ListView) adapterView).getAdapter();
        long itemId = eVar.getItemId(i);
        if (itemId == -1) {
            this.f1300a.b();
        } else if (itemId == -2) {
            h hVar = this.f1300a;
            i2 = hVar.g;
            hVar.g = i2 + 1;
            this.f1300a.o = 4;
            this.f1300a.d();
        } else {
            com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) eVar.getItem(i);
            if (uVar != null) {
                oVar = this.f1300a.q;
                oVar.a(uVar);
                this.f1300a.a(uVar);
            }
        }
    }
}
