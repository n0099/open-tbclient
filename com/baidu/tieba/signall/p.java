package com.baidu.tieba.signall;

import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o bPv;
    private final /* synthetic */ d bPw;
    private final /* synthetic */ r bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, d dVar, r rVar) {
        this.bPv = oVar;
        this.bPw = dVar;
        this.bPx = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        SignAllForumActivity signAllForumActivity2;
        if (!this.bPw.adn()) {
            this.bPx.bPI.setVisibility(4);
            this.bPx.bPJ.setVisibility(0);
            this.bPx.bPK.setText(com.baidu.tieba.z.signallforum_resigning);
            this.bPw.em(true);
            signAllForumActivity = this.bPv.bPt;
            af afVar = new af(signAllForumActivity);
            afVar.a(this.bPv);
            String sb = new StringBuilder(String.valueOf(this.bPw.getForumId())).toString();
            synchronized (this.bPv) {
                hashMap = this.bPv.bPu;
                hashMap.put(sb, afVar);
            }
            afVar.an(this.bPw.getForumName(), sb);
            signAllForumActivity2 = this.bPv.bPt;
            com.baidu.tbadk.core.i.B(signAllForumActivity2.getPageContext().getPageActivity(), "signall_resign_click");
        }
    }
}
