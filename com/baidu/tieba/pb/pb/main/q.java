package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        dk dkVar;
        com.baidu.tbadk.editortools.d.e eVar;
        dk dkVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        boolean z;
        dk dkVar3;
        dk dkVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.performanceLog.e eVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tbadk.performanceLog.e eVar6;
        dk dkVar5;
        com.baidu.tbadk.performanceLog.e eVar7;
        dk dkVar6;
        com.baidu.tbadk.performanceLog.e eVar8;
        if (i == 2 || i == 1) {
            dkVar = this.cFS.cFq;
            dkVar.ana();
            eVar = this.cFS.cFx;
            if (eVar != null) {
                dkVar4 = this.cFS.cFq;
                eVar3 = this.cFS.cFx;
                dkVar4.ft(eVar3.BU());
            }
            dkVar2 = this.cFS.cFq;
            dkVar2.amz();
            eVar2 = this.cFS.cFx;
            eVar2.BX();
            z = this.cFS.cFj;
            if (!z) {
                this.cFS.cFj = true;
                dkVar3 = this.cFS.cFq;
                dkVar3.and();
            }
        }
        eVar4 = this.cFS.cFk;
        if (eVar4 == null) {
            this.cFS.cFk = new com.baidu.tbadk.performanceLog.e();
            eVar8 = this.cFS.cFk;
            eVar8.eF(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            dkVar5 = this.cFS.cFq;
            if (dkVar5.amE() != null) {
                dkVar6 = this.cFS.cFq;
                dkVar6.amE().notifyDataSetChanged();
            }
            eVar7 = this.cFS.cFk;
            eVar7.Ek();
            PbActivity.cEZ = false;
        } else if (i == 1) {
            eVar6 = this.cFS.cFk;
            eVar6.Ek();
            PbActivity.cEZ = true;
        } else {
            eVar5 = this.cFS.cFk;
            eVar5.Ek();
            PbActivity.cEZ = true;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        cf cfVar;
        cf cfVar2;
        dk dkVar;
        dk dkVar2;
        dk dkVar3;
        cf cfVar3;
        cf cfVar4;
        dk dkVar4;
        cf cfVar5;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        cf cfVar6;
        cf cfVar7;
        cf cfVar8;
        cf cfVar9;
        com.baidu.tieba.tbadkCore.data.e eVar4;
        cf cfVar10;
        cfVar = this.cFS.cFl;
        if (cfVar != null) {
            cfVar2 = this.cFS.cFl;
            if (cfVar2.getPbData() != null) {
                dkVar = this.cFS.cFq;
                if (dkVar != null) {
                    dkVar2 = this.cFS.cFq;
                    if (dkVar2.amE() != null) {
                        dkVar3 = this.cFS.cFq;
                        dkVar3.onScroll(absListView, i, i2, i3);
                        cfVar3 = this.cFS.cFl;
                        if (cfVar3.ama()) {
                            cfVar4 = this.cFS.cFl;
                            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = cfVar4.getPbData().akI();
                            if (akI != null && !akI.isEmpty()) {
                                dkVar4 = this.cFS.cFq;
                                int Nw = ((i + i2) - dkVar4.amE().Nw()) - 1;
                                cfVar5 = this.cFS.cFl;
                                com.baidu.tieba.pb.a.c pbData = cfVar5.getPbData();
                                if (pbData != null) {
                                    int i4 = (pbData.akJ() == null || StringUtils.isNull(pbData.akJ().getSummary())) ? Nw : Nw - 1;
                                    int size = akI.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.r rVar = akI.get(i4);
                                        eVar = this.cFS.cFw;
                                        if (eVar != null) {
                                            eVar2 = this.cFS.cFw;
                                            int mV = eVar2.mV(i4);
                                            if (mV >= 0) {
                                                if (rVar instanceof com.baidu.tieba.tbadkCore.data.q) {
                                                    eVar4 = this.cFS.cFw;
                                                    cfVar10 = this.cFS.cFl;
                                                    eVar4.c(i4, 1, cfVar10.getThreadID(), mV);
                                                    com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.q) rVar, "show"));
                                                    return;
                                                }
                                                eVar3 = this.cFS.cFw;
                                                cfVar6 = this.cFS.cFl;
                                                eVar3.c(i4, 2, cfVar6.getThreadID(), mV);
                                                int i5 = 0;
                                                cfVar7 = this.cFS.cFl;
                                                if (cfVar7 != null) {
                                                    cfVar8 = this.cFS.cFl;
                                                    if (cfVar8.VB() != null) {
                                                        cfVar9 = this.cFS.cFl;
                                                        i5 = cfVar9.VB().rM();
                                                    }
                                                }
                                                com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.g("store", mV, i5));
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
