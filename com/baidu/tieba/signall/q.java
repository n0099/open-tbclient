package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.signall.p;
import com.baidu.tieba.t;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p ejx;
    private final /* synthetic */ e ejy;
    private final /* synthetic */ p.b ejz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, e eVar, p.b bVar) {
        this.ejx = pVar;
        this.ejy = eVar;
        this.ejz = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.ejy.aQf()) {
            this.ejz.ejK.setVisibility(4);
            this.ejz.ejL.setVisibility(0);
            this.ejz.ejM.setText(t.j.signallforum_resigning);
            this.ejy.jm(true);
            signAllForumActivity = this.ejx.ejv;
            ah ahVar = new ah(signAllForumActivity);
            ahVar.a(this.ejx);
            String sb = new StringBuilder(String.valueOf(this.ejy.getForumId())).toString();
            synchronized (this.ejx) {
                hashMap = this.ejx.ejw;
                hashMap.put(sb, ahVar);
            }
            ahVar.bG(this.ejy.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
