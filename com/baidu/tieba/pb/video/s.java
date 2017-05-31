package com.baidu.tieba.pb.video;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.d;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements c.h {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.tieba.play.c.h
    public void aPa() {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        PbActivity pbActivity5;
        PbActivity pbActivity6;
        com.baidu.tieba.pb.view.d dVar;
        com.baidu.tieba.pb.view.d dVar2;
        PbActivity pbActivity7;
        com.baidu.tieba.pb.view.d dVar3;
        d.a aVar;
        pbActivity = this.eAW.elf;
        if (pbActivity.checkUpIsLogin()) {
            pbActivity2 = this.eAW.elf;
            pbActivity2.aKm();
            pbActivity3 = this.eAW.elf;
            if (pbActivity3.aJF() != null) {
                pbActivity4 = this.eAW.elf;
                if (pbActivity4.aJF().getPbData() != null) {
                    pbActivity5 = this.eAW.elf;
                    if (pbActivity5.aJF().getPbData().aIY() != null) {
                        pbActivity6 = this.eAW.elf;
                        com.baidu.tieba.pb.data.m aIY = pbActivity6.aJF().getPbData().aIY();
                        dVar = this.eAW.eAQ;
                        if (dVar == null) {
                            l lVar = this.eAW;
                            pbActivity7 = this.eAW.elf;
                            lVar.eAQ = new com.baidu.tieba.pb.view.d(pbActivity7.getActivity());
                            dVar3 = this.eAW.eAQ;
                            aVar = this.eAW.eAR;
                            dVar3.setFloatingHuajiAninationListener(aVar);
                        }
                        dVar2 = this.eAW.eAQ;
                        dVar2.startAnimation(!aIY.aJe());
                    }
                }
            }
        }
    }
}
