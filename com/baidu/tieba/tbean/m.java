package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j ccp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.ccp = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.ccp.aXm = i;
        bVar = this.ccp.cca;
        bVar.ii(i);
        bVar2 = this.ccp.cca;
        bVar2.notifyDataSetChanged();
        this.ccp.abD();
    }
}
