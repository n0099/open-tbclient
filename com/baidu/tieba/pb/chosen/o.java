package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        s sVar;
        s sVar2;
        com.baidu.tieba.pb.chosen.net.a aVar;
        String str;
        if (this.cfM.checkUpIsLogin()) {
            i = this.cfM.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            sVar = this.cfM.cfA;
            if (sVar == null) {
                this.cfM.cfA = new s(this.cfM);
            }
            sVar2 = this.cfM.cfA;
            aVar = this.cfM.chosenData;
            str = this.cfM.shareUrl;
            sVar2.a(aVar, str);
        }
    }
}
