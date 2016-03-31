package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.signall.p;
import com.baidu.tieba.t;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p egm;
    private final /* synthetic */ e egn;
    private final /* synthetic */ p.b ego;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, e eVar, p.b bVar) {
        this.egm = pVar;
        this.egn = eVar;
        this.ego = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.egn.aPP()) {
            this.ego.egz.setVisibility(4);
            this.ego.egA.setVisibility(0);
            this.ego.egB.setText(t.j.signallforum_resigning);
            this.egn.iy(true);
            signAllForumActivity = this.egm.egk;
            ah ahVar = new ah(signAllForumActivity);
            ahVar.a(this.egm);
            String sb = new StringBuilder(String.valueOf(this.egn.getForumId())).toString();
            synchronized (this.egm) {
                hashMap = this.egm.egl;
                hashMap.put(sb, ahVar);
            }
            ahVar.bB(this.egn.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
