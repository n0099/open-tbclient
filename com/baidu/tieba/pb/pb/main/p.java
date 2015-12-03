package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import java.util.ArrayList;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        da daVar;
        com.baidu.tbadk.editortools.d.e eVar;
        da daVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        boolean z;
        da daVar3;
        da daVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.performanceLog.e eVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tbadk.performanceLog.e eVar6;
        da daVar5;
        com.baidu.tbadk.performanceLog.e eVar7;
        da daVar6;
        com.baidu.tbadk.performanceLog.e eVar8;
        if (i == 2 || i == 1) {
            daVar = this.cCm.cBL;
            daVar.alO();
            eVar = this.cCm.cBS;
            if (eVar != null) {
                daVar4 = this.cCm.cBL;
                eVar3 = this.cCm.cBS;
                daVar4.fu(eVar3.Cf());
            }
            daVar2 = this.cCm.cBL;
            daVar2.aln();
            eVar2 = this.cCm.cBS;
            eVar2.Ci();
            z = this.cCm.cBE;
            if (!z) {
                this.cCm.cBE = true;
                daVar3 = this.cCm.cBL;
                daVar3.alR();
            }
        }
        eVar4 = this.cCm.cBF;
        if (eVar4 == null) {
            this.cCm.cBF = new com.baidu.tbadk.performanceLog.e();
            eVar8 = this.cCm.cBF;
            eVar8.eL(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            daVar5 = this.cCm.cBL;
            if (daVar5.als() != null) {
                daVar6 = this.cCm.cBL;
                daVar6.als().notifyDataSetChanged();
            }
            eVar7 = this.cCm.cBF;
            eVar7.Ev();
            PbActivity.cBu = false;
        } else if (i == 1) {
            eVar6 = this.cCm.cBF;
            eVar6.Ev();
            PbActivity.cBu = true;
        } else {
            eVar5 = this.cCm.cBF;
            eVar5.Ev();
            PbActivity.cBu = true;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        cc ccVar;
        cc ccVar2;
        da daVar;
        da daVar2;
        da daVar3;
        cc ccVar3;
        cc ccVar4;
        da daVar4;
        cc ccVar5;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        cc ccVar6;
        cc ccVar7;
        cc ccVar8;
        cc ccVar9;
        com.baidu.tieba.tbadkCore.data.e eVar4;
        cc ccVar10;
        ccVar = this.cCm.cBG;
        if (ccVar != null) {
            ccVar2 = this.cCm.cBG;
            if (ccVar2.getPbData() != null) {
                daVar = this.cCm.cBL;
                if (daVar != null) {
                    daVar2 = this.cCm.cBL;
                    if (daVar2.als() != null) {
                        daVar3 = this.cCm.cBL;
                        daVar3.onScroll(absListView, i, i2, i3);
                        ccVar3 = this.cCm.cBG;
                        if (ccVar3.akT()) {
                            ccVar4 = this.cCm.cBG;
                            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = ccVar4.getPbData().ajA();
                            if (ajA != null && !ajA.isEmpty()) {
                                daVar4 = this.cCm.cBL;
                                int Nd = ((i + i2) - daVar4.als().Nd()) - 1;
                                ccVar5 = this.cCm.cBG;
                                com.baidu.tieba.pb.a.c pbData = ccVar5.getPbData();
                                if (pbData != null) {
                                    int i4 = (pbData.ajB() == null || StringUtils.isNull(pbData.ajB().getSummary())) ? Nd : Nd - 1;
                                    int size = ajA.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.o oVar = ajA.get(i4);
                                        eVar = this.cCm.cBR;
                                        if (eVar != null) {
                                            eVar2 = this.cCm.cBR;
                                            int mu = eVar2.mu(i4);
                                            if (mu >= 0) {
                                                if (oVar instanceof com.baidu.tieba.tbadkCore.data.n) {
                                                    eVar4 = this.cCm.cBR;
                                                    ccVar10 = this.cCm.cBG;
                                                    eVar4.c(i4, 1, ccVar10.getThreadID(), mu);
                                                    com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.n) oVar, "show"));
                                                    return;
                                                }
                                                eVar3 = this.cCm.cBR;
                                                ccVar6 = this.cCm.cBG;
                                                eVar3.c(i4, 2, ccVar6.getThreadID(), mu);
                                                int i5 = 0;
                                                ccVar7 = this.cCm.cBG;
                                                if (ccVar7 != null) {
                                                    ccVar8 = this.cCm.cBG;
                                                    if (ccVar8.Uy() != null) {
                                                        ccVar9 = this.cCm.cBG;
                                                        i5 = ccVar9.Uy().sd();
                                                    }
                                                }
                                                com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.g("store", mu, i5));
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
    }
}
