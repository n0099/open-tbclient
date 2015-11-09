package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ct ctVar;
        com.baidu.tbadk.editortools.c.e eVar;
        ct ctVar2;
        com.baidu.tbadk.editortools.c.e eVar2;
        boolean z;
        ct ctVar3;
        ct ctVar4;
        com.baidu.tbadk.editortools.c.e eVar3;
        com.baidu.tbadk.performanceLog.e eVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tbadk.performanceLog.e eVar6;
        ct ctVar5;
        com.baidu.tbadk.performanceLog.e eVar7;
        ct ctVar6;
        com.baidu.tbadk.performanceLog.e eVar8;
        if (i == 2 || i == 1) {
            ctVar = this.cjN.cjo;
            ctVar.aho();
            eVar = this.cjN.cjw;
            if (eVar != null) {
                ctVar4 = this.cjN.cjo;
                eVar3 = this.cjN.cjw;
                ctVar4.eQ(eVar3.Bf());
            }
            ctVar2 = this.cjN.cjo;
            ctVar2.agP();
            eVar2 = this.cjN.cjw;
            eVar2.Bi();
            z = this.cjN.cjh;
            if (!z) {
                this.cjN.cjh = true;
                ctVar3 = this.cjN.cjo;
                ctVar3.ahr();
            }
        }
        eVar4 = this.cjN.cji;
        if (eVar4 == null) {
            this.cjN.cji = new com.baidu.tbadk.performanceLog.e();
            eVar8 = this.cjN.cji;
            eVar8.ex(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            ctVar5 = this.cjN.cjo;
            if (ctVar5.agU() != null) {
                ctVar6 = this.cjN.cjo;
                ctVar6.agU().notifyDataSetChanged();
            }
            eVar7 = this.cjN.cji;
            eVar7.Du();
        } else if (i == 1) {
            eVar6 = this.cjN.cji;
            eVar6.Du();
        } else {
            eVar5 = this.cjN.cji;
            eVar5.Du();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ca caVar;
        ca caVar2;
        ct ctVar;
        ct ctVar2;
        ca caVar3;
        ct ctVar3;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        ca caVar4;
        ca caVar5;
        ca caVar6;
        ca caVar7;
        com.baidu.tieba.tbadkCore.data.e eVar4;
        ca caVar8;
        caVar = this.cjN.cjj;
        if (caVar != null) {
            caVar2 = this.cjN.cjj;
            if (caVar2.getPbData() != null) {
                ctVar = this.cjN.cjo;
                if (ctVar != null) {
                    ctVar2 = this.cjN.cjo;
                    if (ctVar2.agU() != null) {
                        caVar3 = this.cjN.cjj;
                        com.baidu.tieba.pb.a.c pbData = caVar3.getPbData();
                        ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = pbData.afi();
                        if (afi != null && !afi.isEmpty()) {
                            ctVar3 = this.cjN.cjo;
                            int LF = ((i + i2) - ctVar3.agU().LF()) - 1;
                            int i4 = (pbData.afj() == null || StringUtils.isNull(pbData.afj().getSummary())) ? LF : LF - 1;
                            int size = afi.size();
                            if (i4 >= 0 && i4 < size) {
                                com.baidu.tieba.tbadkCore.data.o oVar = afi.get(i4);
                                eVar = this.cjN.cjv;
                                if (eVar != null) {
                                    eVar2 = this.cjN.cjv;
                                    if (eVar2.li(i4)) {
                                        if (oVar instanceof com.baidu.tieba.tbadkCore.data.n) {
                                            eVar4 = this.cjN.cjv;
                                            caVar8 = this.cjN.cjj;
                                            eVar4.d(i4, 1, caVar8.getThreadID());
                                            com.baidu.tieba.recapp.report.b.aqi().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.n) oVar, "show"));
                                            return;
                                        }
                                        eVar3 = this.cjN.cjv;
                                        caVar4 = this.cjN.cjj;
                                        eVar3.d(i4, 2, caVar4.getThreadID());
                                        int i5 = 0;
                                        caVar5 = this.cjN.cjj;
                                        if (caVar5 != null) {
                                            caVar6 = this.cjN.cjj;
                                            if (caVar6.Rn() != null) {
                                                caVar7 = this.cjN.cjj;
                                                i5 = caVar7.Rn().rI();
                                            }
                                        }
                                        com.baidu.tieba.recapp.report.b.aqi().a(com.baidu.tieba.recapp.report.e.g("store", i4, i5));
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
