package com.baidu.tieba.tbean;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ j caw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.caw = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        b bVar2;
        this.caw.aVU = i;
        bVar = this.caw.cah;
        bVar.hY(i);
        bVar2 = this.caw.cah;
        bVar2.notifyDataSetChanged();
        this.caw.abe();
    }
}
