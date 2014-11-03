package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o bLe;
    private final /* synthetic */ d bLf;
    private final /* synthetic */ r bLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, d dVar, r rVar) {
        this.bLe = oVar;
        this.bLf = dVar;
        this.bLg = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        HashMap hashMap;
        Context context2;
        if (!this.bLf.acR()) {
            this.bLg.bLr.setVisibility(4);
            this.bLg.bLs.setVisibility(0);
            this.bLg.bLt.setText(com.baidu.tieba.y.signallforum_resigning);
            this.bLf.eF(true);
            context = this.bLe.mContext;
            ad adVar = new ad(context);
            adVar.a(this.bLe);
            String sb = new StringBuilder(String.valueOf(this.bLf.getForumId())).toString();
            synchronized (this.bLe) {
                hashMap = this.bLe.bLd;
                hashMap.put(sb, adVar);
            }
            adVar.az(this.bLf.getForumName(), sb);
            context2 = this.bLe.mContext;
            com.baidu.tbadk.core.j.l(context2, "signall_resign_click");
        }
    }
}
