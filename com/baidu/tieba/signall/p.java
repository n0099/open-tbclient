package com.baidu.tieba.signall;

import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o bRe;
    private final /* synthetic */ d bRf;
    private final /* synthetic */ r bRg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, d dVar, r rVar) {
        this.bRe = oVar;
        this.bRf = dVar;
        this.bRg = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        SignAllForumActivity signAllForumActivity2;
        if (!this.bRf.adM()) {
            this.bRg.bRr.setVisibility(4);
            this.bRg.bRs.setVisibility(0);
            this.bRg.bRt.setText(com.baidu.tieba.z.signallforum_resigning);
            this.bRf.et(true);
            signAllForumActivity = this.bRe.bRc;
            af afVar = new af(signAllForumActivity);
            afVar.a(this.bRe);
            String sb = new StringBuilder(String.valueOf(this.bRf.getForumId())).toString();
            synchronized (this.bRe) {
                hashMap = this.bRe.bRd;
                hashMap.put(sb, afVar);
            }
            afVar.aq(this.bRf.getForumName(), sb);
            signAllForumActivity2 = this.bRe.bRc;
            com.baidu.tbadk.core.i.A(signAllForumActivity2.getPageContext().getPageActivity(), "signall_resign_click");
        }
    }
}
