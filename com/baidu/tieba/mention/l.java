package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.f1303a = hVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        o oVar;
        com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) ((ListView) adapterView).getAdapter().getItem(i);
        if (uVar != null) {
            oVar = this.f1303a.q;
            oVar.a(uVar);
            this.f1303a.a(uVar);
            return true;
        }
        return true;
    }
}
