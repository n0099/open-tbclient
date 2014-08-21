package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o a;
    private final /* synthetic */ d b;
    private final /* synthetic */ r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, d dVar, r rVar) {
        this.a = oVar;
        this.b = dVar;
        this.c = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap;
        Context context;
        if (!this.b.l()) {
            this.c.i.setVisibility(4);
            this.c.j.setVisibility(0);
            this.c.k.setText(com.baidu.tieba.x.signallforum_resigning);
            this.b.c(true);
            ad adVar = new ad();
            adVar.a(this.a);
            String sb = new StringBuilder(String.valueOf(this.b.b())).toString();
            synchronized (this.a) {
                hashMap = this.a.d;
                hashMap.put(sb, adVar);
            }
            adVar.a(this.b.c(), sb);
            context = this.a.c;
            com.baidu.tbadk.core.f.a(context, "signall_resign_click");
        }
    }
}
