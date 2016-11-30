package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ag implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean ov;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        dj djVar;
        ey eyVar;
        com.baidu.tbadk.performanceLog.e eVar4;
        ey eyVar2;
        dj djVar2;
        dj djVar3;
        dj djVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        ey eyVar3;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        boolean ov2;
        ey eyVar4;
        boolean z;
        ey eyVar5;
        ey eyVar6;
        com.baidu.tbadk.editortools.e.e eVar6;
        ey eyVar7;
        ey eyVar8;
        ey eyVar9;
        com.baidu.tbadk.editortools.e.e eVar7;
        boolean z2 = true;
        PbActivity pbActivity = this.evL;
        i2 = this.evL.cPx;
        ov = pbActivity.ov(i2);
        if (!ov) {
            ov2 = this.evL.ov(i);
            if (ov2) {
                eyVar4 = this.evL.euP;
                if (eyVar4 != null) {
                    eyVar6 = this.evL.euP;
                    eyVar6.aCY();
                    eVar6 = this.evL.evb;
                    if (eVar6 != null) {
                        eyVar8 = this.evL.euP;
                        if (!eyVar8.aRK()) {
                            eyVar9 = this.evL.euP;
                            eVar7 = this.evL.evb;
                            eyVar9.gX(eVar7.Dz());
                        }
                    }
                    eyVar7 = this.evL.euP;
                    eyVar7.aRJ();
                }
                z = this.evL.euE;
                if (!z) {
                    this.evL.euE = true;
                    eyVar5 = this.evL.euP;
                    eyVar5.aSp();
                }
            }
        }
        jVar = this.evL.eux;
        if (jVar != null) {
            eyVar3 = this.evL.euP;
            if (!eyVar3.aSi()) {
                jVar2 = this.evL.eux;
                jVar2.onScrollStateChanged(absListView, i);
            }
        }
        eVar = this.evL.euF;
        if (eVar == null) {
            this.evL.euF = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.evL.euF;
            eVar5.fg(1001);
        }
        if (i == 0) {
            djVar = this.evL.euf;
            if (djVar != null) {
                djVar2 = this.evL.euf;
                if (djVar2.getPbData() != null) {
                    djVar3 = this.evL.euf;
                    if (djVar3.getPbData().aOl() != null) {
                        djVar4 = this.evL.euf;
                        if (djVar4.getPbData().aOl().sB()) {
                            z2 = false;
                        }
                    }
                }
            }
            eyVar = this.evL.euP;
            if (eyVar.aRW() != null && z2) {
                eyVar2 = this.evL.euP;
                eyVar2.aRW().notifyDataSetChanged();
            }
            eVar4 = this.evL.euF;
            eVar4.Gb();
        } else if (i == 1) {
            eVar3 = this.evL.euF;
            eVar3.Gb();
        } else {
            eVar2 = this.evL.euF;
            eVar2.Gb();
        }
        this.evL.cPx = i;
        if (i == 0) {
            this.evL.a(false, (com.baidu.tieba.tbadkCore.data.q) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        dj djVar;
        dj djVar2;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        dj djVar3;
        dj djVar4;
        ey eyVar4;
        dj djVar5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        djVar = this.evL.euf;
        if (djVar != null) {
            djVar2 = this.evL.euf;
            if (djVar2.getPbData() != null) {
                eyVar = this.evL.euP;
                if (eyVar != null) {
                    eyVar2 = this.evL.euP;
                    if (eyVar2.aRW() != null) {
                        eyVar3 = this.evL.euP;
                        eyVar3.onScroll(absListView, i, i2, i3);
                        jVar = this.evL.eux;
                        if (jVar != null) {
                            jVar2 = this.evL.eux;
                            jVar2.onScroll(absListView, i, i2, i3);
                        }
                        djVar3 = this.evL.euf;
                        if (djVar3.aQD()) {
                            djVar4 = this.evL.euf;
                            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = djVar4.getPbData().aOm();
                            if (aOm != null && !aOm.isEmpty()) {
                                eyVar4 = this.evL.euP;
                                int aPM = ((i + i2) - eyVar4.aRW().aPM()) - 1;
                                djVar5 = this.evL.euf;
                                com.baidu.tieba.pb.data.h pbData = djVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aOn() != null && pbData.aOn().hasData()) {
                                        aPM--;
                                    }
                                    if (pbData.aOo() != null && pbData.aOo().hasData()) {
                                        aPM--;
                                    }
                                    z = this.evL.euH;
                                    if (z) {
                                        aPM--;
                                    }
                                    int size = aOm.size();
                                    if (aPM < 0 || aPM >= size) {
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
