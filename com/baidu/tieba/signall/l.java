package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k a;
    private final /* synthetic */ b b;
    private final /* synthetic */ o c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, b bVar, o oVar) {
        this.a = kVar;
        this.b = bVar;
        this.c = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap;
        Context context;
        if (!this.b.k()) {
            this.c.i.setVisibility(4);
            this.c.j.setVisibility(0);
            this.c.k.setText(com.baidu.tieba.u.signallforum_resigning);
            this.b.c(true);
            aa aaVar = new aa();
            aaVar.a(this.a);
            String sb = new StringBuilder(String.valueOf(this.b.a())).toString();
            synchronized (this.a) {
                hashMap = this.a.g;
                hashMap.put(sb, aaVar);
            }
            aaVar.a(this.b.b(), sb);
            context = this.a.c;
            com.baidu.tbadk.core.g.a(context, "signall_resign_click");
        }
    }
}
