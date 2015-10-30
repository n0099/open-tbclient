package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.n;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n cQA;
    private final /* synthetic */ e cQB;
    private final /* synthetic */ n.b cQC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, n.b bVar) {
        this.cQA = nVar;
        this.cQB = eVar;
        this.cQC = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.cQB.atE()) {
            this.cQC.cQN.setVisibility(4);
            this.cQC.cQO.setVisibility(0);
            this.cQC.cQP.setText(i.h.signallforum_resigning);
            this.cQB.gi(true);
            signAllForumActivity = this.cQA.cQy;
            ab abVar = new ab(signAllForumActivity);
            abVar.a(this.cQA);
            String sb = new StringBuilder(String.valueOf(this.cQB.getForumId())).toString();
            synchronized (this.cQA) {
                hashMap = this.cQA.cQz;
                hashMap.put(sb, abVar);
            }
            abVar.au(this.cQB.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
