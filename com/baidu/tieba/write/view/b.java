package com.baidu.tieba.write.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.write.album.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ a cAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cAR = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        e eVar;
        e eVar2;
        lVar = this.cAR.cAO;
        com.baidu.tieba.write.album.a item = lVar.getItem(i);
        if (item instanceof com.baidu.tieba.write.album.a) {
            com.baidu.tieba.write.album.a aVar = item;
            eVar = this.cAR.cAQ;
            if (eVar != null) {
                eVar2 = this.cAR.cAQ;
                eVar2.a(i, aVar);
            }
        }
        this.cAR.Vf();
    }
}
