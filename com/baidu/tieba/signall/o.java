package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.n;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n cRW;
    private final /* synthetic */ e cRX;
    private final /* synthetic */ n.b cRY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, n.b bVar) {
        this.cRW = nVar;
        this.cRX = eVar;
        this.cRY = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.cRX.auk()) {
            this.cRY.cSj.setVisibility(4);
            this.cRY.cSk.setVisibility(0);
            this.cRY.cSl.setText(i.h.signallforum_resigning);
            this.cRX.gl(true);
            signAllForumActivity = this.cRW.cRU;
            ab abVar = new ab(signAllForumActivity);
            abVar.a(this.cRW);
            String sb = new StringBuilder(String.valueOf(this.cRX.getForumId())).toString();
            synchronized (this.cRW) {
                hashMap = this.cRW.cRV;
                hashMap.put(sb, abVar);
            }
            abVar.at(this.cRX.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
