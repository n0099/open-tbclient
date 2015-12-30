package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.p;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p dxJ;
    private final /* synthetic */ e dxK;
    private final /* synthetic */ p.b dxL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, e eVar, p.b bVar) {
        this.dxJ = pVar;
        this.dxK = eVar;
        this.dxL = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        HashMap hashMap;
        if (!this.dxK.aBS()) {
            this.dxL.dxW.setVisibility(4);
            this.dxL.dxX.setVisibility(0);
            this.dxL.dxY.setText(n.j.signallforum_resigning);
            this.dxK.hj(true);
            signAllForumActivity = this.dxJ.dxH;
            ag agVar = new ag(signAllForumActivity);
            agVar.a(this.dxJ);
            String sb = new StringBuilder(String.valueOf(this.dxK.getForumId())).toString();
            synchronized (this.dxJ) {
                hashMap = this.dxJ.dxI;
                hashMap.put(sb, agVar);
            }
            agVar.au(this.dxK.getForumName(), sb);
            TiebaStatic.log("signall_resign_click");
        }
    }
}
