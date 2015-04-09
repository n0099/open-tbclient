package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.bGl = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        n nVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        nVar = this.bGl.bGd;
        if (nVar == null) {
            this.bGl.bGd = new n(this.bGl);
        }
        nVar2 = this.bGl.bGd;
        aVar = this.bGl.chosenData;
        str = this.bGl.shareUrl;
        nVar2.a(aVar, str);
    }
}
