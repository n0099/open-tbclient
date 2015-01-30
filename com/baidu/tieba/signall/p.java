package com.baidu.tieba.signall;

import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o bRf;
    private final /* synthetic */ d bRg;
    private final /* synthetic */ r bRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, d dVar, r rVar) {
        this.bRf = oVar;
        this.bRg = dVar;
        this.bRh = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        SignAllForumActivity signAllForumActivity2;
        if (!this.bRg.adR()) {
            this.bRh.bRs.setVisibility(4);
            this.bRh.bRt.setVisibility(0);
            this.bRh.bRu.setText(com.baidu.tieba.z.signallforum_resigning);
            this.bRg.et(true);
            signAllForumActivity = this.bRf.bRd;
            af afVar = new af(signAllForumActivity);
            afVar.a(this.bRf);
            String sb = new StringBuilder(String.valueOf(this.bRg.getForumId())).toString();
            synchronized (this.bRf) {
                hashMap = this.bRf.bRe;
                hashMap.put(sb, afVar);
            }
            afVar.aq(this.bRg.getForumName(), sb);
            signAllForumActivity2 = this.bRf.bRd;
            com.baidu.tbadk.core.i.A(signAllForumActivity2.getPageContext().getPageActivity(), "signall_resign_click");
        }
    }
}
