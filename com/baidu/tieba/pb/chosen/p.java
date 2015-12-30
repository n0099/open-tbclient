package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
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
        aVar = this.cBV.chosenData;
        if (aVar != null) {
            aVar3 = this.cBV.chosenData;
            if (aVar3.getThreadInfo() != null) {
                av avVar = new av("pb_new_share");
                aVar4 = this.cBV.chosenData;
                av r = avVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                aVar5 = this.cBV.chosenData;
                TiebaStatic.log(r.aa("abtest", aVar5.getThreadInfo().abtest));
            }
        }
        if (this.cBV.checkUpIsLogin()) {
            i = this.cBV.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            tVar = this.cBV.cBH;
            if (tVar == null) {
                this.cBV.cBH = new t(this.cBV);
            }
            tVar2 = this.cBV.cBH;
            aVar2 = this.cBV.chosenData;
            str = this.cBV.shareUrl;
            tVar2.a(aVar2, str);
        }
    }
}
