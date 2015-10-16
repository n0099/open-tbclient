package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        s sVar;
        s sVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        if (this.cfl.checkUpIsLogin()) {
            i = this.cfl.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            sVar = this.cfl.ceZ;
            if (sVar == null) {
                this.cfl.ceZ = new s(this.cfl);
            }
            sVar2 = this.cfl.ceZ;
            aVar = this.cfl.chosenData;
            str = this.cfl.shareUrl;
            sVar2.a(aVar, str);
        }
    }
}
