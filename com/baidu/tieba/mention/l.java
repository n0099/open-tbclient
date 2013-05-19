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
        com.baidu.tieba.a.r rVar = (com.baidu.tieba.a.r) ((ListView) adapterView).getAdapter().getItem(i);
        if (rVar != null) {
            oVar = this.a.q;
            oVar.a(rVar);
            this.a.a(rVar);
            return true;
        }
        return true;
    }
}
