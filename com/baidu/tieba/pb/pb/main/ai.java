package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ai implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        eu euVar;
        com.baidu.tbadk.editortools.d.e eVar;
        eu euVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        boolean z;
        eu euVar3;
        eu euVar4;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.performanceLog.e eVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tbadk.performanceLog.e eVar6;
        df dfVar;
        eu euVar5;
        com.baidu.tbadk.performanceLog.e eVar7;
        eu euVar6;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        com.baidu.tbadk.performanceLog.e eVar8;
        boolean z2 = true;
        if (i == 2 || i == 1) {
            euVar = this.dht.dgF;
            euVar.amI();
            eVar = this.dht.dgP;
            if (eVar != null) {
                euVar4 = this.dht.dgF;
                eVar3 = this.dht.dgP;
                euVar4.eL(eVar3.DT());
            }
            euVar2 = this.dht.dgF;
            euVar2.ayk();
            eVar2 = this.dht.dgP;
            eVar2.DW();
            z = this.dht.dgx;
            if (!z) {
                this.dht.dgx = true;
                euVar3 = this.dht.dgF;
                euVar3.azc();
            }
        }
        eVar4 = this.dht.dgy;
        if (eVar4 == null) {
            this.dht.dgy = new com.baidu.tbadk.performanceLog.e();
            eVar8 = this.dht.dgy;
            eVar8.fh(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            dfVar = this.dht.dfV;
            if (dfVar != null) {
                dfVar2 = this.dht.dfV;
                if (dfVar2.getPbData() != null) {
                    dfVar3 = this.dht.dfV;
                    if (dfVar3.getPbData().avv() != null) {
                        dfVar4 = this.dht.dfV;
                        if (dfVar4.getPbData().avv().tO()) {
                            z2 = false;
                        }
                    }
                }
            }
            euVar5 = this.dht.dgF;
            if (euVar5.ayy() != null && z2) {
                euVar6 = this.dht.dgF;
                euVar6.ayy().notifyDataSetChanged();
            }
            eVar7 = this.dht.dgy;
            eVar7.GB();
        } else if (i == 1) {
            eVar6 = this.dht.dgy;
            eVar6.GB();
        } else {
            eVar5 = this.dht.dgy;
            eVar5.GB();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0163  */
    @Override // android.widget.AbsListView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        df dfVar;
        df dfVar2;
        eu euVar;
        eu euVar2;
        eu euVar3;
        df dfVar3;
        df dfVar4;
        eu euVar4;
        df dfVar5;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        df dfVar6;
        df dfVar7;
        ForumData forumData;
        df dfVar8;
        df dfVar9;
        df dfVar10;
        df dfVar11;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        df dfVar12;
        com.baidu.tbadk.core.data.ac acVar = null;
        dfVar = this.dht.dfV;
        if (dfVar != null) {
            dfVar2 = this.dht.dfV;
            if (dfVar2.getPbData() != null) {
                euVar = this.dht.dgF;
                if (euVar != null) {
                    euVar2 = this.dht.dgF;
                    if (euVar2.ayy() != null) {
                        euVar3 = this.dht.dgF;
                        euVar3.onScroll(absListView, i, i2, i3);
                        dfVar3 = this.dht.dfV;
                        if (dfVar3.axs()) {
                            dfVar4 = this.dht.dfV;
                            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = dfVar4.getPbData().avw();
                            if (avw != null && !avw.isEmpty()) {
                                euVar4 = this.dht.dgF;
                                int Rl = ((i + i2) - euVar4.ayy().Rl()) - 1;
                                dfVar5 = this.dht.dfV;
                                com.baidu.tieba.pb.data.e pbData = dfVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.avx() != null && !StringUtils.isNull(pbData.avx().getSummary())) {
                                        Rl--;
                                    }
                                    z = this.dht.dgA;
                                    int i4 = z ? Rl - 1 : Rl;
                                    int size = avw.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.s sVar = avw.get(i4);
                                        fVar = this.dht.dgO;
                                        if (fVar != null) {
                                            fVar2 = this.dht.dgO;
                                            int po = fVar2.po(i4);
                                            if (po >= 0) {
                                                if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
                                                    fVar4 = this.dht.dgO;
                                                    dfVar12 = this.dht.dfV;
                                                    fVar4.c(i4, 1, dfVar12.getThreadID(), po);
                                                    com.baidu.tieba.recapp.report.b.aLC().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.r) sVar, "show"));
                                                    return;
                                                }
                                                fVar3 = this.dht.dgO;
                                                dfVar6 = this.dht.dfV;
                                                fVar3.c(i4, 2, dfVar6.getThreadID(), po);
                                                dfVar7 = this.dht.dfV;
                                                if (dfVar7 != null) {
                                                    dfVar10 = this.dht.dfV;
                                                    if (dfVar10.getPbData() != null) {
                                                        dfVar11 = this.dht.dfV;
                                                        forumData = dfVar11.getPbData().avu();
                                                        dfVar8 = this.dht.dfV;
                                                        if (dfVar8 != null) {
                                                            dfVar9 = this.dht.dfV;
                                                            acVar = dfVar9.abt();
                                                        }
                                                        com.baidu.tieba.recapp.report.a h = com.baidu.tieba.recapp.report.e.h("store", po, acVar == null ? acVar.so() : 0);
                                                        h.bz("page", "PB");
                                                        if (forumData != null) {
                                                            h.bz("fid", forumData.getId());
                                                            h.bz("fc1", forumData.getFirst_class());
                                                            h.bz("fc2", forumData.getSecond_class());
                                                        }
                                                        com.baidu.tieba.recapp.report.b.aLC().a(h);
                                                    }
                                                }
                                                forumData = null;
                                                dfVar8 = this.dht.dfV;
                                                if (dfVar8 != null) {
                                                }
                                                com.baidu.tieba.recapp.report.a h2 = com.baidu.tieba.recapp.report.e.h("store", po, acVar == null ? acVar.so() : 0);
                                                h2.bz("page", "PB");
                                                if (forumData != null) {
                                                }
                                                com.baidu.tieba.recapp.report.b.aLC().a(h2);
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
