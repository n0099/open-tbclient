package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cgB;
    private final /* synthetic */ String cgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.cgB = iVar;
        this.cgC = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cgB.cgt;
        if (aVar != null) {
            aVar2 = this.cgB.cgt;
            aVar2.jF(this.cgC);
        }
    }
}
