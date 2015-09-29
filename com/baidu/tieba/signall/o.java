package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.n;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n cQb;
    private final /* synthetic */ e cQc;
    private final /* synthetic */ n.b cQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, n.b bVar) {
        this.cQb = nVar;
        this.cQc = eVar;
        this.cQd = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.cQc.atC()) {
            this.cQd.cQo.setVisibility(4);
            this.cQd.cQp.setVisibility(0);
            this.cQd.cQq.setText(i.h.signallforum_resigning);
            this.cQc.gi(true);
            signAllForumActivity = this.cQb.cPZ;
            ab abVar = new ab(signAllForumActivity);
            abVar.a(this.cQb);
            String sb = new StringBuilder(String.valueOf(this.cQc.getForumId())).toString();
            synchronized (this.cQb) {
                hashMap = this.cQb.cQa;
                hashMap.put(sb, abVar);
            }
            abVar.au(this.cQc.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
