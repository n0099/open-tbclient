package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j dKq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.dKq = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        d dVar2;
        d dVar3;
        BdListView bdListView;
        BdListView bdListView2;
        BdListView bdListView3;
        j jVar = this.dKq;
        dVar = this.dKq.dKb;
        jVar.dKm = dVar.getItem(i);
        dVar2 = this.dKq.dKb;
        dVar2.nk(i);
        dVar3 = this.dKq.dKb;
        dVar3.notifyDataSetChanged();
        this.dKq.aGP();
        bdListView = this.dKq.dKa;
        int firstVisiblePosition = bdListView.getFirstVisiblePosition();
        bdListView2 = this.dKq.dKa;
        j jVar2 = this.dKq;
        bdListView3 = this.dKq.dKa;
        jVar2.a(bdListView3, (ViewGroup) bdListView2.getChildAt(i - firstVisiblePosition), i);
    }
}
