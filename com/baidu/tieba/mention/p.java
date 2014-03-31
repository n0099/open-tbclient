package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.a = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar = (g) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = gVar.getItemId(i);
        if (itemId == -1) {
            this.a.b();
        } else if (itemId == -2) {
            m.i(this.a);
        } else {
            com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) gVar.getItem(i);
            if (oVar != null) {
                m.a(this.a, oVar);
            }
        }
    }
}
