package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cfZ;
    private final /* synthetic */ String cga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.cfZ = iVar;
        this.cga = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cfZ.cfS;
        if (aVar != null) {
            aVar2 = this.cfZ.cfS;
            aVar2.jD(this.cga);
        }
    }
}
