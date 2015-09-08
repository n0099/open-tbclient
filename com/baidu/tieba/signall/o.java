package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.n;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n cJg;
    private final /* synthetic */ e cJh;
    private final /* synthetic */ n.b cJi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, n.b bVar) {
        this.cJg = nVar;
        this.cJh = eVar;
        this.cJi = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.cJh.aro()) {
            this.cJi.cJt.setVisibility(4);
            this.cJi.cJu.setVisibility(0);
            this.cJi.cJv.setText(i.h.signallforum_resigning);
            this.cJh.fX(true);
            signAllForumActivity = this.cJg.cJe;
            ab abVar = new ab(signAllForumActivity);
            abVar.a(this.cJg);
            String sb = new StringBuilder(String.valueOf(this.cJh.getForumId())).toString();
            synchronized (this.cJg) {
                hashMap = this.cJg.cJf;
                hashMap.put(sb, abVar);
            }
            abVar.av(this.cJh.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
