package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import java.util.ArrayList;
/* loaded from: classes.dex */
class t implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        dz dzVar;
        com.baidu.tbadk.editortools.d.e eVar;
        dz dzVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        boolean z;
        dz dzVar3;
        dz dzVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.performanceLog.e eVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tbadk.performanceLog.e eVar6;
        dz dzVar5;
        com.baidu.tbadk.performanceLog.e eVar7;
        dz dzVar6;
        com.baidu.tbadk.performanceLog.e eVar8;
        if (i == 2 || i == 1) {
            dzVar = this.cNq.cMK;
            dzVar.ajp();
            eVar = this.cNq.cMU;
            if (eVar != null) {
                dzVar4 = this.cNq.cMK;
                eVar3 = this.cNq.cMU;
                dzVar4.ep(eVar3.Dk());
            }
            dzVar2 = this.cNq.cMK;
            dzVar2.aqT();
            eVar2 = this.cNq.cMU;
            eVar2.Dn();
            z = this.cNq.cMC;
            if (!z) {
                this.cNq.cMC = true;
                dzVar3 = this.cNq.cMK;
                dzVar3.arB();
            }
        }
        eVar4 = this.cNq.cMD;
        if (eVar4 == null) {
            this.cNq.cMD = new com.baidu.tbadk.performanceLog.e();
            eVar8 = this.cNq.cMD;
            eVar8.eZ(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            dzVar5 = this.cNq.cMK;
            if (dzVar5.arb() != null) {
                dzVar6 = this.cNq.cMK;
                dzVar6.arb().notifyDataSetChanged();
            }
            eVar7 = this.cNq.cMD;
            eVar7.FF();
            PbActivity.cMq = false;
        } else if (i == 1) {
            eVar6 = this.cNq.cMD;
            eVar6.FF();
            PbActivity.cMq = true;
        } else {
            eVar5 = this.cNq.cMD;
            eVar5.FF();
            PbActivity.cMq = true;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        cm cmVar;
        cm cmVar2;
        dz dzVar;
        dz dzVar2;
        dz dzVar3;
        cm cmVar3;
        cm cmVar4;
        dz dzVar4;
        cm cmVar5;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        cm cmVar6;
        cm cmVar7;
        cm cmVar8;
        cm cmVar9;
        com.baidu.tieba.tbadkCore.data.e eVar4;
        cm cmVar10;
        cmVar = this.cNq.cMF;
        if (cmVar != null) {
            cmVar2 = this.cNq.cMF;
            if (cmVar2.getPbData() != null) {
                dzVar = this.cNq.cMK;
                if (dzVar != null) {
                    dzVar2 = this.cNq.cMK;
                    if (dzVar2.arb() != null) {
                        dzVar3 = this.cNq.cMK;
                        dzVar3.onScroll(absListView, i, i2, i3);
                        cmVar3 = this.cNq.cMF;
                        if (cmVar3.aqd()) {
                            cmVar4 = this.cNq.cMF;
                            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = cmVar4.getPbData().aoG();
                            if (aoG != null && !aoG.isEmpty()) {
                                dzVar4 = this.cNq.cMK;
                                int Pw = ((i + i2) - dzVar4.arb().Pw()) - 1;
                                cmVar5 = this.cNq.cMF;
                                com.baidu.tieba.pb.a.c pbData = cmVar5.getPbData();
                                if (pbData != null) {
                                    int i4 = (pbData.aoH() == null || StringUtils.isNull(pbData.aoH().getSummary())) ? Pw : Pw - 1;
                                    int size = aoG.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.r rVar = aoG.get(i4);
                                        eVar = this.cNq.cMT;
                                        if (eVar != null) {
                                            eVar2 = this.cNq.cMT;
                                            int of = eVar2.of(i4);
                                            if (of >= 0) {
                                                if (rVar instanceof com.baidu.tieba.tbadkCore.data.q) {
                                                    eVar4 = this.cNq.cMT;
                                                    cmVar10 = this.cNq.cMF;
                                                    eVar4.c(i4, 1, cmVar10.getThreadID(), of);
                                                    com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.q) rVar, "show"));
                                                    return;
                                                }
                                                eVar3 = this.cNq.cMT;
                                                cmVar6 = this.cNq.cMF;
                                                eVar3.c(i4, 2, cmVar6.getThreadID(), of);
                                                int i5 = 0;
                                                cmVar7 = this.cNq.cMF;
                                                if (cmVar7 != null) {
                                                    cmVar8 = this.cNq.cMF;
                                                    if (cmVar8.XU() != null) {
                                                        cmVar9 = this.cNq.cMF;
                                                        i5 = cmVar9.XU().st();
                                                    }
                                                }
                                                com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.g("store", of, i5));
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
