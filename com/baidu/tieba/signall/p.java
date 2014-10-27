package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o bKP;
    private final /* synthetic */ d bKQ;
    private final /* synthetic */ r bKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, d dVar, r rVar) {
        this.bKP = oVar;
        this.bKQ = dVar;
        this.bKR = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        HashMap hashMap;
        Context context2;
        if (!this.bKQ.acO()) {
            this.bKR.bLc.setVisibility(4);
            this.bKR.bLd.setVisibility(0);
            this.bKR.bLe.setText(com.baidu.tieba.y.signallforum_resigning);
            this.bKQ.eF(true);
            context = this.bKP.mContext;
            ad adVar = new ad(context);
            adVar.a(this.bKP);
            String sb = new StringBuilder(String.valueOf(this.bKQ.getForumId())).toString();
            synchronized (this.bKP) {
                hashMap = this.bKP.bKO;
                hashMap.put(sb, adVar);
            }
            adVar.az(this.bKQ.getForumName(), sb);
            context2 = this.bKP.mContext;
            com.baidu.tbadk.core.i.l(context2, "signall_resign_click");
        }
    }
}
