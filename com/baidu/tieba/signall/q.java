package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.signall.p;
import com.baidu.tieba.t;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p dNN;
    private final /* synthetic */ e dNO;
    private final /* synthetic */ p.b dNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, e eVar, p.b bVar) {
        this.dNN = pVar;
        this.dNO = eVar;
        this.dNP = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.dNO.aIZ()) {
            this.dNP.dOa.setVisibility(4);
            this.dNP.dOb.setVisibility(0);
            this.dNP.dOc.setText(t.j.signallforum_resigning);
            this.dNO.hJ(true);
            signAllForumActivity = this.dNN.dNL;
            ah ahVar = new ah(signAllForumActivity);
            ahVar.a(this.dNN);
            String sb = new StringBuilder(String.valueOf(this.dNO.getForumId())).toString();
            synchronized (this.dNN) {
                hashMap = this.dNN.dNM;
                hashMap.put(sb, ahVar);
            }
            ahVar.au(this.dNO.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
