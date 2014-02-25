package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.a = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar = (h) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = hVar.getItemId(i);
        if (itemId == -1) {
            this.a.b();
        } else if (itemId != -2) {
            com.baidu.tieba.data.t tVar = (com.baidu.tieba.data.t) hVar.getItem(i);
            if (tVar != null) {
                this.a.a(tVar);
            }
        } else {
            this.a.h();
        }
    }
}
