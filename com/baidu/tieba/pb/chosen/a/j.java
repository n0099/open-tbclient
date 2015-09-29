package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cfO;
    private final /* synthetic */ String cfP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.cfO = iVar;
        this.cfP = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cfO.cfH;
        if (aVar != null) {
            aVar2 = this.cfO.cfH;
            aVar2.jD(this.cfP);
        }
    }
}
