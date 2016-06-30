package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean ng;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        dg dgVar;
        es esVar;
        com.baidu.tbadk.performanceLog.e eVar4;
        es esVar2;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean ng2;
        es esVar3;
        boolean z;
        es esVar4;
        es esVar5;
        com.baidu.tbadk.editortools.d.e eVar6;
        es esVar6;
        es esVar7;
        es esVar8;
        com.baidu.tbadk.editortools.d.e eVar7;
        boolean z2 = true;
        PbActivity pbActivity = this.dPF;
        i2 = this.dPF.cuW;
        ng = pbActivity.ng(i2);
        if (!ng) {
            ng2 = this.dPF.ng(i);
            if (ng2) {
                esVar3 = this.dPF.dOO;
                if (esVar3 != null) {
                    esVar5 = this.dPF.dOO;
                    esVar5.avf();
                    eVar6 = this.dPF.dOX;
                    if (eVar6 != null) {
                        esVar7 = this.dPF.dOO;
                        if (!esVar7.aGU()) {
                            esVar8 = this.dPF.dOO;
                            eVar7 = this.dPF.dOX;
                            esVar8.gb(eVar7.BW());
                        }
                    }
                    esVar6 = this.dPF.dOO;
                    esVar6.aGT();
                }
                z = this.dPF.dOE;
                if (!z) {
                    this.dPF.dOE = true;
                    esVar4 = this.dPF.dOO;
                    esVar4.aHI();
                }
            }
        }
        fVar = this.dPF.dOx;
        if (fVar != null) {
            fVar2 = this.dPF.dOx;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.dPF.dOF;
        if (eVar == null) {
            this.dPF.dOF = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.dPF.dOF;
            eVar5.eQ(1001);
        }
        if (i == 0) {
            dgVar = this.dPF.dOf;
            if (dgVar != null) {
                dgVar2 = this.dPF.dOf;
                if (dgVar2.getPbData() != null) {
                    dgVar3 = this.dPF.dOf;
                    if (dgVar3.getPbData().aDO() != null) {
                        dgVar4 = this.dPF.dOf;
                        if (dgVar4.getPbData().aDO().rj()) {
                            z2 = false;
                        }
                    }
                }
            }
            esVar = this.dPF.dOO;
            if (esVar.aHh() != null && z2) {
                esVar2 = this.dPF.dOO;
                esVar2.aHh().notifyDataSetChanged();
            }
            eVar4 = this.dPF.dOF;
            eVar4.ED();
        } else if (i == 1) {
            eVar3 = this.dPF.dOF;
            eVar3.ED();
        } else {
            eVar2 = this.dPF.dOF;
            eVar2.ED();
        }
        this.dPF.cuW = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0183  */
    @Override // android.widget.AbsListView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        dg dgVar;
        dg dgVar2;
        es esVar;
        es esVar2;
        es esVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        dg dgVar3;
        dg dgVar4;
        es esVar4;
        dg dgVar5;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        dg dgVar6;
        dg dgVar7;
        ForumData forumData;
        dg dgVar8;
        AccountData currentAccountObj;
        dg dgVar9;
        dg dgVar10;
        dg dgVar11;
        com.baidu.tieba.tbadkCore.data.f fVar5;
        dg dgVar12;
        com.baidu.tieba.pb.pb.main.a.f fVar6;
        com.baidu.tbadk.core.data.af afVar = null;
        dgVar = this.dPF.dOf;
        if (dgVar != null) {
            dgVar2 = this.dPF.dOf;
            if (dgVar2.getPbData() != null) {
                esVar = this.dPF.dOO;
                if (esVar != null) {
                    esVar2 = this.dPF.dOO;
                    if (esVar2.aHh() != null) {
                        esVar3 = this.dPF.dOO;
                        esVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.dPF.dOx;
                        if (fVar != null) {
                            fVar6 = this.dPF.dOx;
                            fVar6.onScroll(absListView, i, i2, i3);
                        }
                        dgVar3 = this.dPF.dOf;
                        if (dgVar3.aGa()) {
                            dgVar4 = this.dPF.dOf;
                            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = dgVar4.getPbData().aDP();
                            if (aDP != null && !aDP.isEmpty()) {
                                esVar4 = this.dPF.dOO;
                                int aFm = ((i + i2) - esVar4.aHh().aFm()) - 1;
                                dgVar5 = this.dPF.dOf;
                                com.baidu.tieba.pb.data.h pbData = dgVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aDQ() != null && pbData.aDQ().hasData()) {
                                        aFm--;
                                    }
                                    z = this.dPF.dOH;
                                    int i4 = z ? aFm - 1 : aFm;
                                    int size = aDP.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.s sVar = aDP.get(i4);
                                        fVar2 = this.dPF.dOW;
                                        if (fVar2 != null) {
                                            fVar3 = this.dPF.dOW;
                                            int qz = fVar3.qz(i4);
                                            if (qz >= 0) {
                                                if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
                                                    fVar5 = this.dPF.dOW;
                                                    dgVar12 = this.dPF.dOf;
                                                    fVar5.c(i4, 1, dgVar12.getThreadID(), qz);
                                                    com.baidu.tieba.recapp.report.b.aUO().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.r) sVar, "show"));
                                                    return;
                                                }
                                                fVar4 = this.dPF.dOW;
                                                dgVar6 = this.dPF.dOf;
                                                fVar4.c(i4, 2, dgVar6.getThreadID(), qz);
                                                dgVar7 = this.dPF.dOf;
                                                if (dgVar7 != null) {
                                                    dgVar10 = this.dPF.dOf;
                                                    if (dgVar10.getPbData() != null) {
                                                        dgVar11 = this.dPF.dOf;
                                                        forumData = dgVar11.getPbData().aDN();
                                                        dgVar8 = this.dPF.dOf;
                                                        if (dgVar8 != null) {
                                                            dgVar9 = this.dPF.dOf;
                                                            afVar = dgVar9.ajw();
                                                        }
                                                        int pC = afVar == null ? afVar.pC() : 0;
                                                        currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                        com.baidu.tieba.recapp.report.a i5 = com.baidu.tieba.recapp.report.e.i("store", qz, pC);
                                                        i5.bG("page", "PB");
                                                        if (forumData != null) {
                                                            i5.bG("fid", forumData.getId());
                                                            i5.bG("fc1", forumData.getFirst_class());
                                                            i5.bG("fc2", forumData.getSecond_class());
                                                        }
                                                        if (currentAccountObj != null) {
                                                            i5.bG("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                                        }
                                                        com.baidu.tieba.recapp.report.b.aUO().a(i5);
                                                    }
                                                }
                                                forumData = null;
                                                dgVar8 = this.dPF.dOf;
                                                if (dgVar8 != null) {
                                                }
                                                if (afVar == null) {
                                                }
                                                currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                com.baidu.tieba.recapp.report.a i52 = com.baidu.tieba.recapp.report.e.i("store", qz, pC);
                                                i52.bG("page", "PB");
                                                if (forumData != null) {
                                                }
                                                if (currentAccountObj != null) {
                                                }
                                                com.baidu.tieba.recapp.report.b.aUO().a(i52);
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
