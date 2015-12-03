package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
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
        aVar = this.cyo.chosenData;
        if (aVar != null) {
            aVar3 = this.cyo.chosenData;
            if (aVar3.getThreadInfo() != null) {
                av avVar = new av("pb_new_share");
                aVar4 = this.cyo.chosenData;
                av r = avVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                aVar5 = this.cyo.chosenData;
                TiebaStatic.log(r.ab("abtest", aVar5.getThreadInfo().abtest));
            }
        }
        if (this.cyo.checkUpIsLogin()) {
            i = this.cyo.from;
            if (i == 2) {
                TiebaStatic.log("c10148");
            }
            tVar = this.cyo.cya;
            if (tVar == null) {
                this.cyo.cya = new t(this.cyo);
            }
            tVar2 = this.cyo.cya;
            aVar2 = this.cyo.chosenData;
            str = this.cyo.shareUrl;
            tVar2.a(aVar2, str);
        }
    }
}
