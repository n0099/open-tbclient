package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.bJa = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        if (this.bJa.checkUpIsLogin()) {
            hVar = this.bJa.bIT;
            if (hVar == null) {
                this.bJa.bIT = new h(this.bJa);
            }
            hVar2 = this.bJa.bIT;
            aVar = this.bJa.chosenData;
            str = this.bJa.shareUrl;
            hVar2.a(aVar, str);
        }
    }
}
