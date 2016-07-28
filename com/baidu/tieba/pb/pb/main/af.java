package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean ny;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        dh dhVar;
        ew ewVar;
        com.baidu.tbadk.performanceLog.e eVar4;
        ew ewVar2;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean ny2;
        ew ewVar3;
        boolean z;
        ew ewVar4;
        ew ewVar5;
        com.baidu.tbadk.editortools.d.e eVar6;
        ew ewVar6;
        ew ewVar7;
        ew ewVar8;
        com.baidu.tbadk.editortools.d.e eVar7;
        boolean z2 = true;
        PbActivity pbActivity = this.ebT;
        i2 = this.ebT.cxL;
        ny = pbActivity.ny(i2);
        if (!ny) {
            ny2 = this.ebT.ny(i);
            if (ny2) {
                ewVar3 = this.ebT.ebb;
                if (ewVar3 != null) {
                    ewVar5 = this.ebT.ebb;
                    ewVar5.avR();
                    eVar6 = this.ebT.ebk;
                    if (eVar6 != null) {
                        ewVar7 = this.ebT.ebb;
                        if (!ewVar7.aKh()) {
                            ewVar8 = this.ebT.ebb;
                            eVar7 = this.ebT.ebk;
                            ewVar8.ge(eVar7.BW());
                        }
                    }
                    ewVar6 = this.ebT.ebb;
                    ewVar6.aKg();
                }
                z = this.ebT.eaR;
                if (!z) {
                    this.ebT.eaR = true;
                    ewVar4 = this.ebT.ebb;
                    ewVar4.aKT();
                }
            }
        }
        fVar = this.ebT.eaK;
        if (fVar != null) {
            fVar2 = this.ebT.eaK;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.ebT.eaS;
        if (eVar == null) {
            this.ebT.eaS = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.ebT.eaS;
            eVar5.eQ(1001);
        }
        if (i == 0) {
            dhVar = this.ebT.eas;
            if (dhVar != null) {
                dhVar2 = this.ebT.eas;
                if (dhVar2.getPbData() != null) {
                    dhVar3 = this.ebT.eas;
                    if (dhVar3.getPbData().aGY() != null) {
                        dhVar4 = this.ebT.eas;
                        if (dhVar4.getPbData().aGY().rh()) {
                            z2 = false;
                        }
                    }
                }
            }
            ewVar = this.ebT.ebb;
            if (ewVar.aKs() != null && z2) {
                ewVar2 = this.ebT.ebb;
                ewVar2.aKs().notifyDataSetChanged();
            }
            eVar4 = this.ebT.eaS;
            eVar4.EC();
        } else if (i == 1) {
            eVar3 = this.ebT.eaS;
            eVar3.EC();
        } else {
            eVar2 = this.ebT.eaS;
            eVar2.EC();
        }
        this.ebT.cxL = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0196  */
    @Override // android.widget.AbsListView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        dh dhVar;
        dh dhVar2;
        ew ewVar;
        ew ewVar2;
        ew ewVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        dh dhVar3;
        dh dhVar4;
        ew ewVar4;
        dh dhVar5;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        dh dhVar6;
        dh dhVar7;
        ForumData forumData;
        dh dhVar8;
        AccountData currentAccountObj;
        dh dhVar9;
        dh dhVar10;
        dh dhVar11;
        com.baidu.tieba.tbadkCore.data.f fVar5;
        dh dhVar12;
        com.baidu.tieba.pb.pb.main.a.f fVar6;
        com.baidu.tbadk.core.data.aj ajVar = null;
        dhVar = this.ebT.eas;
        if (dhVar != null) {
            dhVar2 = this.ebT.eas;
            if (dhVar2.getPbData() != null) {
                ewVar = this.ebT.ebb;
                if (ewVar != null) {
                    ewVar2 = this.ebT.ebb;
                    if (ewVar2.aKs() != null) {
                        ewVar3 = this.ebT.ebb;
                        ewVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.ebT.eaK;
                        if (fVar != null) {
                            fVar6 = this.ebT.eaK;
                            fVar6.onScroll(absListView, i, i2, i3);
                        }
                        dhVar3 = this.ebT.eas;
                        if (dhVar3.aJl()) {
                            dhVar4 = this.ebT.eas;
                            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = dhVar4.getPbData().aGZ();
                            if (aGZ != null && !aGZ.isEmpty()) {
                                ewVar4 = this.ebT.ebb;
                                int aIx = ((i + i2) - ewVar4.aKs().aIx()) - 1;
                                dhVar5 = this.ebT.eas;
                                com.baidu.tieba.pb.data.h pbData = dhVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aHa() != null && pbData.aHa().hasData()) {
                                        aIx--;
                                    }
                                    if (pbData.aHb() != null && pbData.aHb().hasData()) {
                                        aIx--;
                                    }
                                    z = this.ebT.eaU;
                                    int i4 = z ? aIx - 1 : aIx;
                                    int size = aGZ.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.s sVar = aGZ.get(i4);
                                        fVar2 = this.ebT.ebj;
                                        if (fVar2 != null) {
                                            fVar3 = this.ebT.ebj;
                                            int qU = fVar3.qU(i4);
                                            if (qU >= 0) {
                                                if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
                                                    fVar5 = this.ebT.ebj;
                                                    dhVar12 = this.ebT.eas;
                                                    fVar5.c(i4, 1, dhVar12.getThreadID(), qU);
                                                    com.baidu.tieba.recapp.report.b.aYc().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.r) sVar, "show"));
                                                    return;
                                                }
                                                fVar4 = this.ebT.ebj;
                                                dhVar6 = this.ebT.eas;
                                                fVar4.c(i4, 2, dhVar6.getThreadID(), qU);
                                                dhVar7 = this.ebT.eas;
                                                if (dhVar7 != null) {
                                                    dhVar10 = this.ebT.eas;
                                                    if (dhVar10.getPbData() != null) {
                                                        dhVar11 = this.ebT.eas;
                                                        forumData = dhVar11.getPbData().aGX();
                                                        dhVar8 = this.ebT.eas;
                                                        if (dhVar8 != null) {
                                                            dhVar9 = this.ebT.eas;
                                                            ajVar = dhVar9.akg();
                                                        }
                                                        int pl = ajVar == null ? ajVar.pl() : 0;
                                                        currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                        com.baidu.tieba.recapp.report.a i5 = com.baidu.tieba.recapp.report.e.i("store", qU, pl);
                                                        i5.bL("page", "PB");
                                                        if (forumData != null) {
                                                            i5.bL("fid", forumData.getId());
                                                            i5.bL("fc1", forumData.getFirst_class());
                                                            i5.bL("fc2", forumData.getSecond_class());
                                                        }
                                                        if (currentAccountObj != null) {
                                                            i5.bL("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                                        }
                                                        com.baidu.tieba.recapp.report.b.aYc().a(i5);
                                                    }
                                                }
                                                forumData = null;
                                                dhVar8 = this.ebT.eas;
                                                if (dhVar8 != null) {
                                                }
                                                if (ajVar == null) {
                                                }
                                                currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                com.baidu.tieba.recapp.report.a i52 = com.baidu.tieba.recapp.report.e.i("store", qU, pl);
                                                i52.bL("page", "PB");
                                                if (forumData != null) {
                                                }
                                                if (currentAccountObj != null) {
                                                }
                                                com.baidu.tieba.recapp.report.b.aYc().a(i52);
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
