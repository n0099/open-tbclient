package com.baidu.tieba.signall;

import android.view.View;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o cep;
    private final /* synthetic */ e ceq;
    private final /* synthetic */ r cer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, e eVar, r rVar) {
        this.cep = oVar;
        this.ceq = eVar;
        this.cer = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        SignAllForumActivity signAllForumActivity2;
        if (!this.ceq.aiT()) {
            this.cer.ceC.setVisibility(4);
            this.cer.ceD.setVisibility(0);
            this.cer.ceE.setText(com.baidu.tieba.y.signallforum_resigning);
            this.ceq.ez(true);
            signAllForumActivity = this.cep.cen;
            ag agVar = new ag(signAllForumActivity);
            agVar.a(this.cep);
            String sb = new StringBuilder(String.valueOf(this.ceq.getForumId())).toString();
            synchronized (this.cep) {
                hashMap = this.cep.ceo;
                hashMap.put(sb, agVar);
            }
            agVar.ap(this.ceq.getForumName(), sb);
            signAllForumActivity2 = this.cep.cen;
            com.baidu.tbadk.core.k.A(signAllForumActivity2.getPageContext().getPageActivity(), "signall_resign_click");
        }
    }
}
