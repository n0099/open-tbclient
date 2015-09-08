package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i caJ;
    private final /* synthetic */ String caK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.caJ = iVar;
        this.caK = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.caJ.caC;
        if (aVar != null) {
            aVar2 = this.caJ.caC;
            aVar2.jl(this.caK);
        }
    }
}
