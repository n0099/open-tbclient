package com.baidu.tieba.person.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.personInfo.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements AdapterView.OnItemClickListener {
    final /* synthetic */ ap dyL;
    private final /* synthetic */ am dyN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar, am amVar) {
        this.dyL = apVar;
        this.dyN = amVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bq.a item = this.dyN.getItem(i);
        if (item == null) {
            return;
        }
        this.dyL.mt(item.aCu());
    }
}
