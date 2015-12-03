package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j dCO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.dCO = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        d dVar2;
        d dVar3;
        BdListView bdListView;
        BdListView bdListView2;
        BdListView bdListView3;
        j jVar = this.dCO;
        dVar = this.dCO.dCz;
        jVar.dCK = dVar.getItem(i);
        dVar2 = this.dCO.dCz;
        dVar2.mI(i);
        dVar3 = this.dCO.dCz;
        dVar3.notifyDataSetChanged();
        this.dCO.aEB();
        bdListView = this.dCO.dCy;
        int firstVisiblePosition = bdListView.getFirstVisiblePosition();
        bdListView2 = this.dCO.dCy;
        j jVar2 = this.dCO;
        bdListView3 = this.dCO.dCy;
        jVar2.a(bdListView3, (ViewGroup) bdListView2.getChildAt(i - firstVisiblePosition), i);
    }
}
