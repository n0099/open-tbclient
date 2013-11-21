package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1847a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.f1847a = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar = (f) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = fVar.getItemId(i);
        if (itemId == -1) {
            this.f1847a.b();
        } else if (itemId == -2) {
            j.e(this.f1847a);
            this.f1847a.n = 4;
            this.f1847a.d();
        } else {
            com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) fVar.getItem(i);
            if (uVar != null) {
                this.f1847a.a(uVar);
            }
        }
    }
}
