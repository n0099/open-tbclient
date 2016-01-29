package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbChosenActivity pbChosenActivity) {
        this.cIA = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        int i;
        t tVar;
        t tVar2;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        String str;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        aVar = this.cIA.chosenData;
        if (aVar != null) {
            aVar3 = this.cIA.chosenData;
            if (aVar3.getThreadInfo() != null) {
                au auVar = new au("pb_new_share");
                aVar4 = this.cIA.chosenData;
                au r = auVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                aVar5 = this.cIA.chosenData;
                TiebaStatic.log(r.aa("abtest", aVar5.getThreadInfo().abtest));
            }
        }
        if (this.cIA.checkUpIsLogin()) {
            i = this.cIA.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            tVar = this.cIA.cIn;
            if (tVar == null) {
                this.cIA.cIn = new t(this.cIA);
            }
            tVar2 = this.cIA.cIn;
            aVar2 = this.cIA.chosenData;
            str = this.cIA.shareUrl;
            tVar2.a(aVar2, str);
        }
    }
}
