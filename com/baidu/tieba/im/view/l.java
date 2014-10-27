package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bjy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bjy = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        o oVar;
        o oVar2;
        int i2;
        mVar = this.bjy.bju;
        Object item = mVar.getItem(i);
        if (item instanceof com.baidu.tieba.im.data.f) {
            com.baidu.tieba.im.data.f fVar = (com.baidu.tieba.im.data.f) item;
            oVar = this.bjy.bjx;
            if (oVar != null) {
                oVar2 = this.bjy.bjx;
                i2 = this.bjy.bjv;
                oVar2.a(i2, fVar);
            }
        }
    }
}
