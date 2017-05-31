package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gk implements View.OnClickListener {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(fx fxVar) {
        this.evi = fxVar;
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
        z = this.evi.euH;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").r("obj_id", 2));
        }
        pbActivity = this.evi.elf;
        if (pbActivity.elV.ewA != null) {
            z2 = this.evi.euH;
            if (!z2) {
                fVar = this.evi.epx;
                if (fVar != null) {
                    fVar2 = this.evi.epx;
                    if (fVar2.aIB() != null) {
                        fVar3 = this.evi.epx;
                        if (fVar3.aIB().getAuthor() != null) {
                            fVar4 = this.evi.epx;
                            if (fVar4.aIB().getAuthor().isBigV()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12151").r("obj_locate", 1));
                            }
                        }
                    }
                }
            }
            pbActivity2 = this.evi.elf;
            pbActivity2.elV.ewA.onClick(view);
        }
    }
}
