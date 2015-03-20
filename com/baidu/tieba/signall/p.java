package com.baidu.tieba.signall;

import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o cea;
    private final /* synthetic */ e ceb;
    private final /* synthetic */ r cec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, e eVar, r rVar) {
        this.cea = oVar;
        this.ceb = eVar;
        this.cec = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        SignAllForumActivity signAllForumActivity2;
        if (!this.ceb.aiE()) {
            this.cec.cen.setVisibility(4);
            this.cec.ceo.setVisibility(0);
            this.cec.cep.setText(com.baidu.tieba.y.signallforum_resigning);
            this.ceb.eB(true);
            signAllForumActivity = this.cea.cdY;
            ag agVar = new ag(signAllForumActivity);
            agVar.a(this.cea);
            String sb = new StringBuilder(String.valueOf(this.ceb.getForumId())).toString();
            synchronized (this.cea) {
                hashMap = this.cea.cdZ;
                hashMap.put(sb, agVar);
            }
            agVar.ap(this.ceb.getForumName(), sb);
            signAllForumActivity2 = this.cea.cdY;
            com.baidu.tbadk.core.k.A(signAllForumActivity2.getPageContext().getPageActivity(), "signall_resign_click");
        }
    }
}
