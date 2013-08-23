package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1335a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.f1335a = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        o oVar;
        int i2;
        f fVar = (f) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = fVar.getItemId(i);
        if (itemId == -1) {
            this.f1335a.b();
        } else if (itemId == -2) {
            i iVar = this.f1335a;
            i2 = iVar.g;
            iVar.g = i2 + 1;
            this.f1335a.m = 4;
            this.f1335a.d();
        } else {
            com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) fVar.getItem(i);
            if (uVar != null) {
                oVar = this.f1335a.o;
                oVar.a(uVar);
                this.f1335a.a(uVar, i);
            }
        }
    }
}
