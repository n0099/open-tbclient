package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.bJb = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        if (this.bJb.checkUpIsLogin()) {
            hVar = this.bJb.bIU;
            if (hVar == null) {
                this.bJb.bIU = new h(this.bJb);
            }
            hVar2 = this.bJb.bIU;
            aVar = this.bJb.chosenData;
            str = this.bJb.shareUrl;
            hVar2.a(aVar, str);
        }
    }
}
