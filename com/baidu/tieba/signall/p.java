package com.baidu.tieba.signall;

import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o ciu;
    private final /* synthetic */ e civ;
    private final /* synthetic */ r ciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, e eVar, r rVar) {
        this.ciu = oVar;
        this.civ = eVar;
        this.ciw = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        SignAllForumActivity signAllForumActivity2;
        if (!this.civ.akD()) {
            this.ciw.ciH.setVisibility(4);
            this.ciw.ciI.setVisibility(0);
            this.ciw.ciJ.setText(com.baidu.tieba.t.signallforum_resigning);
            this.civ.eT(true);
            signAllForumActivity = this.ciu.cis;
            ag agVar = new ag(signAllForumActivity);
            agVar.a(this.ciu);
            String sb = new StringBuilder(String.valueOf(this.civ.getForumId())).toString();
            synchronized (this.ciu) {
                hashMap = this.ciu.cit;
                hashMap.put(sb, agVar);
            }
            agVar.au(this.civ.getForumName(), sb);
            signAllForumActivity2 = this.ciu.cis;
            com.baidu.tbadk.core.k.A(signAllForumActivity2.getPageContext().getPageActivity(), "signall_resign_click");
        }
    }
}
