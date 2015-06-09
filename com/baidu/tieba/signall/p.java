package com.baidu.tieba.signall;

import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o civ;
    private final /* synthetic */ e ciw;
    private final /* synthetic */ r cix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, e eVar, r rVar) {
        this.civ = oVar;
        this.ciw = eVar;
        this.cix = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        SignAllForumActivity signAllForumActivity2;
        if (!this.ciw.akE()) {
            this.cix.ciI.setVisibility(4);
            this.cix.ciJ.setVisibility(0);
            this.cix.ciK.setText(com.baidu.tieba.t.signallforum_resigning);
            this.ciw.eT(true);
            signAllForumActivity = this.civ.cit;
            ag agVar = new ag(signAllForumActivity);
            agVar.a(this.civ);
            String sb = new StringBuilder(String.valueOf(this.ciw.getForumId())).toString();
            synchronized (this.civ) {
                hashMap = this.civ.ciu;
                hashMap.put(sb, agVar);
            }
            agVar.au(this.ciw.getForumName(), sb);
            signAllForumActivity2 = this.civ.cit;
            com.baidu.tbadk.core.k.A(signAllForumActivity2.getPageContext().getPageActivity(), "signall_resign_click");
        }
    }
}
