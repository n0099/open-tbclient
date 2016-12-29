package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean nx;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        dc dcVar;
        er erVar;
        com.baidu.tbadk.performanceLog.e eVar4;
        er erVar2;
        dc dcVar2;
        dc dcVar3;
        dc dcVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        er erVar3;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        boolean nx2;
        er erVar4;
        boolean z;
        er erVar5;
        er erVar6;
        com.baidu.tbadk.editortools.e.e eVar6;
        er erVar7;
        er erVar8;
        er erVar9;
        com.baidu.tbadk.editortools.e.e eVar7;
        boolean z2 = true;
        PbActivity pbActivity = this.eah;
        i2 = this.eah.cuD;
        nx = pbActivity.nx(i2);
        if (!nx) {
            nx2 = this.eah.nx(i);
            if (nx2) {
                erVar4 = this.eah.dZk;
                if (erVar4 != null) {
                    erVar6 = this.eah.dZk;
                    erVar6.awl();
                    eVar6 = this.eah.dZw;
                    if (eVar6 != null) {
                        erVar8 = this.eah.dZk;
                        if (!erVar8.aLE()) {
                            erVar9 = this.eah.dZk;
                            eVar7 = this.eah.dZw;
                            erVar9.gH(eVar7.Di());
                        }
                    }
                    erVar7 = this.eah.dZk;
                    erVar7.aLD();
                }
                z = this.eah.dYZ;
                if (!z) {
                    this.eah.dYZ = true;
                    erVar5 = this.eah.dZk;
                    erVar5.aMj();
                }
            }
        }
        jVar = this.eah.dYS;
        if (jVar != null) {
            erVar3 = this.eah.dZk;
            if (!erVar3.aMc()) {
                jVar2 = this.eah.dYS;
                jVar2.onScrollStateChanged(absListView, i);
            }
        }
        eVar = this.eah.dZa;
        if (eVar == null) {
            this.eah.dZa = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.eah.dZa;
            eVar5.fg(1001);
        }
        if (i == 0) {
            dcVar = this.eah.dYA;
            if (dcVar != null) {
                dcVar2 = this.eah.dYA;
                if (dcVar2.getPbData() != null) {
                    dcVar3 = this.eah.dYA;
                    if (dcVar3.getPbData().aIl() != null) {
                        dcVar4 = this.eah.dYA;
                        if (dcVar4.getPbData().aIl().sq()) {
                            z2 = false;
                        }
                    }
                }
            }
            erVar = this.eah.dZk;
            if (erVar.aLQ() != null && z2) {
                erVar2 = this.eah.dZk;
                erVar2.aLQ().notifyDataSetChanged();
            }
            eVar4 = this.eah.dZa;
            eVar4.FB();
        } else if (i == 1) {
            eVar3 = this.eah.dZa;
            eVar3.FB();
        } else {
            eVar2 = this.eah.dZa;
            eVar2.FB();
        }
        this.eah.cuD = i;
        if (i == 0) {
            this.eah.a(false, (com.baidu.tieba.tbadkCore.data.q) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        dc dcVar;
        dc dcVar2;
        er erVar;
        er erVar2;
        er erVar3;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        dc dcVar3;
        dc dcVar4;
        er erVar4;
        dc dcVar5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        dcVar = this.eah.dYA;
        if (dcVar != null) {
            dcVar2 = this.eah.dYA;
            if (dcVar2.getPbData() != null) {
                erVar = this.eah.dZk;
                if (erVar != null) {
                    erVar2 = this.eah.dZk;
                    if (erVar2.aLQ() != null) {
                        erVar3 = this.eah.dZk;
                        erVar3.onScroll(absListView, i, i2, i3);
                        jVar = this.eah.dYS;
                        if (jVar != null) {
                            jVar2 = this.eah.dYS;
                            jVar2.onScroll(absListView, i, i2, i3);
                        }
                        dcVar3 = this.eah.dYA;
                        if (dcVar3.aKA()) {
                            dcVar4 = this.eah.dYA;
                            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = dcVar4.getPbData().aIm();
                            if (aIm != null && !aIm.isEmpty()) {
                                erVar4 = this.eah.dZk;
                                int aJL = ((i + i2) - erVar4.aLQ().aJL()) - 1;
                                dcVar5 = this.eah.dYA;
                                com.baidu.tieba.pb.data.f pbData = dcVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aIn() != null && pbData.aIn().hasData()) {
                                        aJL--;
                                    }
                                    if (pbData.aIo() != null && pbData.aIo().hasData()) {
                                        aJL--;
                                    }
                                    z = this.eah.dZc;
                                    if (z) {
                                        aJL--;
                                    }
                                    int size = aIm.size();
                                    if (aJL < 0 || aJL >= size) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
