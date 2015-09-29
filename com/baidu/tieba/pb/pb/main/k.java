package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.location.BDLocationStatusCodes;
import java.util.ArrayList;
/* loaded from: classes.dex */
class k implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.ciz = pbActivity;
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
            ccVar = this.ciz.cia;
            ccVar.agM();
            dVar = this.ciz.cij;
            if (dVar != null) {
                ccVar4 = this.ciz.cia;
                dVar3 = this.ciz.cij;
                ccVar4.eN(dVar3.Br());
            }
            ccVar2 = this.ciz.cia;
            ccVar2.ago();
            dVar2 = this.ciz.cij;
            dVar2.Bu();
            z = this.ciz.chT;
            if (!z) {
                this.ciz.chT = true;
                ccVar3 = this.ciz.cia;
                ccVar3.agP();
            }
        }
        eVar = this.ciz.chU;
        if (eVar == null) {
            this.ciz.chU = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.ciz.chU;
            eVar5.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            ccVar5 = this.ciz.cia;
            if (ccVar5.ags() != null) {
                ccVar6 = this.ciz.cia;
                ccVar6.ags().notifyDataSetChanged();
            }
            eVar4 = this.ciz.chU;
            eVar4.DE();
        } else if (i == 1) {
            eVar3 = this.ciz.chU;
            eVar3.DE();
        } else {
            eVar2 = this.ciz.chU;
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
        com.baidu.tieba.tbadkCore.data.b bVar4;
        bl blVar5;
        blVar = this.ciz.chV;
        if (blVar != null) {
            blVar2 = this.ciz.chV;
            if (blVar2.getPbData() != null) {
                ccVar = this.ciz.cia;
                if (ccVar != null) {
                    ccVar2 = this.ciz.cia;
                    if (ccVar2.ags() != null) {
                        blVar3 = this.ciz.chV;
                        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = blVar3.getPbData().aeP();
                        if (aeP != null && !aeP.isEmpty()) {
                            ccVar3 = this.ciz.cia;
                            int Lt = (i + i2) - ccVar3.ags().Lt();
                            int i4 = Lt - 1;
                            int size = aeP.size();
                            if (i4 >= 0 && i4 < size) {
                                com.baidu.tieba.tbadkCore.data.k kVar = aeP.get(i4);
                                bVar = this.ciz.cii;
                                if (bVar != null) {
                                    bVar2 = this.ciz.cii;
                                    if (bVar2.kS(Lt)) {
                                        if (kVar instanceof com.baidu.tieba.tbadkCore.data.j) {
                                            bVar4 = this.ciz.cii;
                                            blVar5 = this.ciz.chV;
                                            bVar4.d(Lt, 1, blVar5.getThreadID());
                                            return;
                                        }
                                        bVar3 = this.ciz.cii;
                                        blVar4 = this.ciz.chV;
                                        bVar3.d(Lt, 2, blVar4.getThreadID());
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
