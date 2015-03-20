package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.bFY = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        n nVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        nVar = this.bFY.bFQ;
        if (nVar == null) {
            this.bFY.bFQ = new n(this.bFY);
        }
        nVar2 = this.bFY.bFQ;
        aVar = this.bFY.chosenData;
        str = this.bFY.shareUrl;
        nVar2.a(aVar, str);
    }
}
