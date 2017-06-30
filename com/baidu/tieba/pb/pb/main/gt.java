package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gt implements View.OnClickListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gt(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        PbActivity pbActivity;
        boolean z2;
        PbActivity pbActivity2;
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        com.baidu.tieba.pb.data.f fVar3;
        com.baidu.tieba.pb.data.f fVar4;
        z = this.eEv.eDU;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11923").r("obj_id", 2));
        }
        pbActivity = this.eEv.euf;
        if (pbActivity.euV.eFW != null) {
            z2 = this.eEv.eDU;
            if (!z2) {
                fVar = this.eEv.eyH;
                if (fVar != null) {
                    fVar2 = this.eEv.eyH;
                    if (fVar2.aMv() != null) {
                        fVar3 = this.eEv.eyH;
                        if (fVar3.aMv().getAuthor() != null) {
                            fVar4 = this.eEv.eyH;
                            if (fVar4.aMv().getAuthor().isBigV()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12151").r("obj_locate", 1));
                            }
                        }
                    }
                }
            }
            pbActivity2 = this.eEv.euf;
            pbActivity2.euV.eFW.onClick(view);
        }
    }
}
