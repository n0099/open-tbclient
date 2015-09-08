package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        r rVar;
        r rVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        if (this.bZS.checkUpIsLogin()) {
            i = this.bZS.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            rVar = this.bZS.bZG;
            if (rVar == null) {
                this.bZS.bZG = new r(this.bZS);
            }
            rVar2 = this.bZS.bZG;
            aVar = this.bZS.chosenData;
            str = this.bZS.shareUrl;
            rVar2.a(aVar, str);
        }
    }
}
