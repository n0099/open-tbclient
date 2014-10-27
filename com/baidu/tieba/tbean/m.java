package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j bNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.bNX = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.bNX.aUh = i;
        bVar = this.bNX.bNI;
        bVar.hp(i);
        bVar2 = this.bNX.bNI;
        bVar2.notifyDataSetChanged();
        this.bNX.Hu();
    }
}
