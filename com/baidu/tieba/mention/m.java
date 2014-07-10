package com.baidu.tieba.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar = (c) ((BdListView) adapterView).getWrappedAdapter();
        long itemId = cVar.getItemId(i);
        if (itemId == -1) {
            this.a.b();
        } else if (itemId != -2) {
            com.baidu.tieba.data.p pVar = (com.baidu.tieba.data.p) cVar.getItem(i);
            if (pVar != null) {
                this.a.a(pVar);
            }
        } else {
            this.a.g();
        }
    }
}
