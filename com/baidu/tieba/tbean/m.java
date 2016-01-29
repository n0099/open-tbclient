package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j eav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.eav = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        d dVar2;
        d dVar3;
        BdListView bdListView;
        BdListView bdListView2;
        BdListView bdListView3;
        j jVar = this.eav;
        dVar = this.eav.eag;
        jVar.ear = dVar.getItem(i);
        dVar2 = this.eav.eag;
        dVar2.oy(i);
        dVar3 = this.eav.eag;
        dVar3.notifyDataSetChanged();
        this.eav.aNT();
        bdListView = this.eav.eaf;
        int firstVisiblePosition = bdListView.getFirstVisiblePosition();
        bdListView2 = this.eav.eaf;
        j jVar2 = this.eav;
        bdListView3 = this.eav.eaf;
        jVar2.a(bdListView3, (ViewGroup) bdListView2.getChildAt(i - firstVisiblePosition), i);
    }
}
