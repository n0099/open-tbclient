package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.f1370a = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        p pVar;
        int i2;
        f fVar = (f) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = fVar.getItemId(i);
        if (itemId == -1) {
            this.f1370a.b();
        } else if (itemId == -2) {
            i iVar = this.f1370a;
            i2 = iVar.h;
            iVar.h = i2 + 1;
            this.f1370a.n = 4;
            this.f1370a.d();
        } else {
            com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) fVar.getItem(i);
            if (uVar != null) {
                pVar = this.f1370a.p;
                pVar.a(uVar);
                this.f1370a.a(uVar, i);
            }
        }
    }
}
