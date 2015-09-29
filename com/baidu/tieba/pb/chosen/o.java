package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbChosenActivity pbChosenActivity) {
        this.cfa = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        s sVar;
        s sVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        if (this.cfa.checkUpIsLogin()) {
            i = this.cfa.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            sVar = this.cfa.ceO;
            if (sVar == null) {
                this.cfa.ceO = new s(this.cfa);
            }
            sVar2 = this.cfa.ceO;
            aVar = this.cfa.chosenData;
            str = this.cfa.shareUrl;
            sVar2.a(aVar, str);
        }
    }
}
