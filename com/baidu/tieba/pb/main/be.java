package com.baidu.tieba.pb.main;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bc bcVar) {
        this.a = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        int intValue = ((Integer) view.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof com.baidu.tieba.data.ah) {
            com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) item;
            context = this.a.b;
            com.baidu.tbadk.core.f.a(context, "pb_tb_btc");
            int h = ahVar.h();
            if (h == 0) {
                this.a.a(ahVar, intValue);
            } else if (h == 2) {
                this.a.a(ahVar);
            }
        }
    }
}
