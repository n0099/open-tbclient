package com.baidu.tieba.pb.main;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.a = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        int intValue = ((Integer) view.getTag()).intValue();
        Object item = this.a.getItem(intValue);
        if (item instanceof com.baidu.tieba.data.ae) {
            com.baidu.tieba.data.ae aeVar = (com.baidu.tieba.data.ae) item;
            context = this.a.b;
            com.baidu.tbadk.core.f.a(context, "pb_tb_btc");
            int h = aeVar.h();
            if (h == 0) {
                this.a.a(aeVar, intValue);
            } else if (h == 2) {
                this.a.a(aeVar);
            }
        }
    }
}
