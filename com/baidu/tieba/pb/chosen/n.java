package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbChosenActivity pbChosenActivity) {
        this.bYY = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        r rVar;
        r rVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        if (this.bYY.checkUpIsLogin()) {
            i = this.bYY.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            rVar = this.bYY.bYM;
            if (rVar == null) {
                this.bYY.bYM = new r(this.bYY);
            }
            rVar2 = this.bYY.bYM;
            aVar = this.bYY.chosenData;
            str = this.bYY.shareUrl;
            rVar2.a(aVar, str);
        }
    }
}
