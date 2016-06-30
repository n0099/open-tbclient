package com.baidu.tieba.person.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.person.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements AdapterView.OnItemClickListener {
    final /* synthetic */ aq ehq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar) {
        this.ehq = aqVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        am amVar;
        amVar = this.ehq.ehp;
        bs.a item = amVar.getItem(i);
        if (item == null) {
            return;
        }
        this.ehq.nZ(item.efw);
        this.ehq.a(item);
    }
}
