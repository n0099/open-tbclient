package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1868a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.f1868a = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        f fVar = (f) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = fVar.getItemId(i);
        if (itemId == -1) {
            this.f1868a.b();
        } else if (itemId == -2) {
            j.e(this.f1868a);
            this.f1868a.n = 4;
            this.f1868a.d();
        } else {
            com.baidu.tieba.data.v vVar = (com.baidu.tieba.data.v) fVar.getItem(i);
            if (vVar != null) {
                qVar = this.f1868a.p;
                qVar.a(vVar);
                this.f1868a.a(vVar, i);
            }
        }
    }
}
