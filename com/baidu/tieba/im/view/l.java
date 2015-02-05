package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ k bqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bqs = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        o oVar;
        o oVar2;
        int i2;
        mVar = this.bqs.bqo;
        Object item = mVar.getItem(i);
        if (item instanceof d) {
            d dVar = (d) item;
            oVar = this.bqs.bqr;
            if (oVar != null) {
                oVar2 = this.bqs.bqr;
                i2 = this.bqs.bqp;
                oVar2.a(i2, dVar);
            }
        }
    }
}
