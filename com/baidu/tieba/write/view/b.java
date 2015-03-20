package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a cwl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cwl = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        e eVar;
        e eVar2;
        jVar = this.cwl.cwi;
        com.baidu.tieba.write.album.a item = jVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.a) {
            com.baidu.tieba.write.album.a aVar = item;
            eVar = this.cwl.cwk;
            if (eVar != null) {
                eVar2 = this.cwl.cwk;
                eVar2.a(i, aVar);
            }
        }
        this.cwl.TF();
    }
}
