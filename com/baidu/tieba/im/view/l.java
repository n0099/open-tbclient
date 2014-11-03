package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bjM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bjM = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        o oVar;
        o oVar2;
        int i2;
        mVar = this.bjM.bjI;
        Object item = mVar.getItem(i);
        if (item instanceof com.baidu.tieba.im.data.f) {
            com.baidu.tieba.im.data.f fVar = (com.baidu.tieba.im.data.f) item;
            oVar = this.bjM.bjL;
            if (oVar != null) {
                oVar2 = this.bjM.bjL;
                i2 = this.bjM.bjJ;
                oVar2.a(i2, fVar);
            }
        }
    }
}
