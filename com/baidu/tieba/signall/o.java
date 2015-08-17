package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.n;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n cAI;
    private final /* synthetic */ e cAJ;
    private final /* synthetic */ n.b cAK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, n.b bVar) {
        this.cAI = nVar;
        this.cAJ = eVar;
        this.cAK = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.cAJ.anf()) {
            this.cAK.cAV.setVisibility(4);
            this.cAK.cAW.setVisibility(0);
            this.cAK.cAX.setText(i.C0057i.signallforum_resigning);
            this.cAJ.fm(true);
            signAllForumActivity = this.cAI.cAG;
            ab abVar = new ab(signAllForumActivity);
            abVar.a(this.cAI);
            String sb = new StringBuilder(String.valueOf(this.cAJ.getForumId())).toString();
            synchronized (this.cAI) {
                hashMap = this.cAI.cAH;
                hashMap.put(sb, abVar);
            }
            abVar.au(this.cAJ.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
