package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ k boW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.boW = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        o oVar;
        o oVar2;
        int i2;
        mVar = this.boW.boS;
        Object item = mVar.getItem(i);
        if (item instanceof c) {
            c cVar = (c) item;
            oVar = this.boW.boV;
            if (oVar != null) {
                oVar2 = this.boW.boV;
                i2 = this.boW.boT;
                oVar2.a(i2, cVar);
            }
        }
    }
}
