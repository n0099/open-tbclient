package com.baidu.tieba.pb.video;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.d;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements c.h {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.tieba.play.c.h
    public void aSZ() {
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
        pbActivity = this.eKu.euf;
        if (pbActivity.checkUpIsLogin()) {
            pbActivity2 = this.eKu.euf;
            pbActivity2.aOj();
            pbActivity3 = this.eKu.euf;
            if (pbActivity3.aNz() != null) {
                pbActivity4 = this.eKu.euf;
                if (pbActivity4.aNz().getPbData() != null) {
                    pbActivity5 = this.eKu.euf;
                    if (pbActivity5.aNz().getPbData().aMS() != null) {
                        pbActivity6 = this.eKu.euf;
                        com.baidu.tieba.pb.data.m aMS = pbActivity6.aNz().getPbData().aMS();
                        dVar = this.eKu.eKo;
                        if (dVar == null) {
                            l lVar = this.eKu;
                            pbActivity7 = this.eKu.euf;
                            lVar.eKo = new com.baidu.tieba.pb.view.d(pbActivity7.getActivity());
                            dVar3 = this.eKu.eKo;
                            aVar = this.eKu.eKp;
                            dVar3.setFloatingHuajiAninationListener(aVar);
                        }
                        dVar2 = this.eKu.eKo;
                        dVar2.startAnimation(!aMS.aMY());
                    }
                }
            }
        }
    }
}
