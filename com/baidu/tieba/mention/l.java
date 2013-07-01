package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f990a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.f990a = hVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        o oVar;
        com.baidu.tieba.data.q qVar = (com.baidu.tieba.data.q) ((ListView) adapterView).getAdapter().getItem(i);
        if (qVar != null) {
            oVar = this.f990a.q;
            oVar.a(qVar);
            this.f990a.a(qVar);
            return true;
        }
        return true;
    }
}
