package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import java.util.ArrayList;
/* loaded from: classes.dex */
class k implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        cc ccVar;
        com.baidu.tbadk.editortools.c.d dVar;
        cc ccVar2;
        com.baidu.tbadk.editortools.c.d dVar2;
        boolean z;
        cc ccVar3;
        cc ccVar4;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        cc ccVar5;
        com.baidu.tbadk.performanceLog.e eVar4;
        cc ccVar6;
        com.baidu.tbadk.performanceLog.e eVar5;
        if (i == 2 || i == 1) {
            ccVar = this.ciK.cim;
            ccVar.agM();
            dVar = this.ciK.ciu;
            if (dVar != null) {
                ccVar4 = this.ciK.cim;
                dVar3 = this.ciK.ciu;
                ccVar4.eN(dVar3.Br());
            }
            ccVar2 = this.ciK.cim;
            ccVar2.ago();
            dVar2 = this.ciK.ciu;
            dVar2.Bu();
            z = this.ciK.cif;
            if (!z) {
                this.ciK.cif = true;
                ccVar3 = this.ciK.cim;
                ccVar3.agP();
            }
        }
        eVar = this.ciK.cig;
        if (eVar == null) {
            this.ciK.cig = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.ciK.cig;
            eVar5.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            ccVar5 = this.ciK.cim;
            if (ccVar5.ags() != null) {
                ccVar6 = this.ciK.cim;
                ccVar6.ags().notifyDataSetChanged();
            }
            eVar4 = this.ciK.cig;
            eVar4.DE();
        } else if (i == 1) {
            eVar3 = this.ciK.cig;
            eVar3.DE();
        } else {
            eVar2 = this.ciK.cig;
            eVar2.DE();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        bl blVar;
        bl blVar2;
        cc ccVar;
        cc ccVar2;
        bl blVar3;
        cc ccVar3;
        com.baidu.tieba.tbadkCore.data.b bVar;
        com.baidu.tieba.tbadkCore.data.b bVar2;
        com.baidu.tieba.tbadkCore.data.b bVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        com.baidu.tieba.tbadkCore.data.b bVar4;
        bl blVar8;
        blVar = this.ciK.cih;
        if (blVar != null) {
            blVar2 = this.ciK.cih;
            if (blVar2.getPbData() != null) {
                ccVar = this.ciK.cim;
                if (ccVar != null) {
                    ccVar2 = this.ciK.cim;
                    if (ccVar2.ags() != null) {
                        blVar3 = this.ciK.cih;
                        com.baidu.tieba.pb.a.b pbData = blVar3.getPbData();
                        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = pbData.aeP();
                        if (aeP != null && !aeP.isEmpty()) {
                            ccVar3 = this.ciK.cim;
                            int Lt = ((i + i2) - ccVar3.ags().Lt()) - 1;
                            int i4 = (pbData.aeQ() == null || StringUtils.isNull(pbData.aeQ().getSummary())) ? Lt : Lt - 1;
                            int size = aeP.size();
                            if (i4 >= 0 && i4 < size) {
                                com.baidu.tieba.tbadkCore.data.k kVar = aeP.get(i4);
                                bVar = this.ciK.cit;
                                if (bVar != null) {
                                    bVar2 = this.ciK.cit;
                                    if (bVar2.kU(i4)) {
                                        if (kVar instanceof com.baidu.tieba.tbadkCore.data.j) {
                                            bVar4 = this.ciK.cit;
                                            blVar8 = this.ciK.cih;
                                            bVar4.d(i4, 1, blVar8.getThreadID());
                                            com.baidu.tieba.recapp.report.b.apG().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.j) kVar, "show"));
                                            return;
                                        }
                                        bVar3 = this.ciK.cit;
                                        blVar4 = this.ciK.cih;
                                        bVar3.d(i4, 2, blVar4.getThreadID());
                                        int i5 = 0;
                                        blVar5 = this.ciK.cih;
                                        if (blVar5 != null) {
                                            blVar6 = this.ciK.cih;
                                            if (blVar6.QV() != null) {
                                                blVar7 = this.ciK.cih;
                                                i5 = blVar7.QV().rJ();
                                            }
                                        }
                                        com.baidu.tieba.recapp.report.b.apG().a(com.baidu.tieba.recapp.report.e.g("store", i4, i5));
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
