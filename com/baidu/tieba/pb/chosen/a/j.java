package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bZP;
    private final /* synthetic */ String bZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.bZP = iVar;
        this.bZQ = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.bZP.bZI;
        if (aVar != null) {
            aVar2 = this.bZP.bZI;
            aVar2.jd(this.bZQ);
        }
    }
}
