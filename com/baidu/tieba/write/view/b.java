package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a cAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cAS = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        e eVar;
        e eVar2;
        lVar = this.cAS.cAP;
        com.baidu.tieba.write.album.a item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.a) {
            com.baidu.tieba.write.album.a aVar = item;
            eVar = this.cAS.cAR;
            if (eVar != null) {
                eVar2 = this.cAS.cAR;
                eVar2.a(i, aVar);
            }
        }
        this.cAS.Vg();
    }
}
