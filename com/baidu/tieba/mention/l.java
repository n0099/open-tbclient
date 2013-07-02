package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        o oVar;
        com.baidu.tieba.data.q qVar = (com.baidu.tieba.data.q) ((ListView) adapterView).getAdapter().getItem(i);
        if (qVar != null) {
            oVar = this.a.q;
            oVar.a(qVar);
            this.a.a(qVar);
            return true;
        }
        return true;
    }
}
