package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bqt = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        o oVar;
        o oVar2;
        int i2;
        mVar = this.bqt.bqp;
        Object item = mVar.getItem(i);
        if (item instanceof d) {
            d dVar = (d) item;
            oVar = this.bqt.bqs;
            if (oVar != null) {
                oVar2 = this.bqt.bqs;
                i2 = this.bqt.bqq;
                oVar2.a(i2, dVar);
            }
        }
    }
}
