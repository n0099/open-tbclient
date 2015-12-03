package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.n;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n dqt;
    private final /* synthetic */ e dqu;
    private final /* synthetic */ n.b dqv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, n.b bVar) {
        this.dqt = nVar;
        this.dqu = eVar;
        this.dqv = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.dqu.azL()) {
            this.dqv.dqG.setVisibility(4);
            this.dqv.dqH.setVisibility(0);
            this.dqv.dqI.setText(n.i.signallforum_resigning);
            this.dqu.ha(true);
            signAllForumActivity = this.dqt.dqr;
            ab abVar = new ab(signAllForumActivity);
            abVar.a(this.dqt);
            String sb = new StringBuilder(String.valueOf(this.dqu.getForumId())).toString();
            synchronized (this.dqt) {
                hashMap = this.dqt.dqs;
                hashMap.put(sb, abVar);
            }
            abVar.aw(this.dqu.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
