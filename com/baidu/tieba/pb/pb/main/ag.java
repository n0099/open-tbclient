package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ag implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean ob;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        dh dhVar;
        ex exVar;
        com.baidu.tbadk.performanceLog.e eVar4;
        ex exVar2;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean ob2;
        ex exVar3;
        boolean z;
        ex exVar4;
        ex exVar5;
        com.baidu.tbadk.editortools.d.e eVar6;
        ex exVar6;
        ex exVar7;
        ex exVar8;
        com.baidu.tbadk.editortools.d.e eVar7;
        boolean z2 = true;
        PbActivity pbActivity = this.eob;
        i2 = this.eob.cJq;
        ob = pbActivity.ob(i2);
        if (!ob) {
            ob2 = this.eob.ob(i);
            if (ob2) {
                exVar3 = this.eob.enh;
                if (exVar3 != null) {
                    exVar5 = this.eob.enh;
                    exVar5.aAE();
                    eVar6 = this.eob.ens;
                    if (eVar6 != null) {
                        exVar7 = this.eob.enh;
                        if (!exVar7.aOY()) {
                            exVar8 = this.eob.enh;
                            eVar7 = this.eob.ens;
                            exVar8.gA(eVar7.Dr());
                        }
                    }
                    exVar6 = this.eob.enh;
                    exVar6.aOX();
                }
                z = this.eob.emW;
                if (!z) {
                    this.eob.emW = true;
                    exVar4 = this.eob.enh;
                    exVar4.aPK();
                }
            }
        }
        fVar = this.eob.emP;
        if (fVar != null) {
            fVar2 = this.eob.emP;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.eob.emX;
        if (eVar == null) {
            this.eob.emX = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.eob.emX;
            eVar5.fe(1001);
        }
        if (i == 0) {
            dhVar = this.eob.emx;
            if (dhVar != null) {
                dhVar2 = this.eob.emx;
                if (dhVar2.getPbData() != null) {
                    dhVar3 = this.eob.emx;
                    if (dhVar3.getPbData().aLQ() != null) {
                        dhVar4 = this.eob.emx;
                        if (dhVar4.getPbData().aLQ().sn()) {
                            z2 = false;
                        }
                    }
                }
            }
            exVar = this.eob.enh;
            if (exVar.aPj() != null && z2) {
                exVar2 = this.eob.enh;
                exVar2.aPj().notifyDataSetChanged();
            }
            eVar4 = this.eob.emX;
            eVar4.FW();
        } else if (i == 1) {
            eVar3 = this.eob.emX;
            eVar3.FW();
        } else {
            eVar2 = this.eob.emX;
            eVar2.FW();
        }
        this.eob.cJq = i;
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
        ex exVar;
        ex exVar2;
        ex exVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        dh dhVar3;
        dh dhVar4;
        ex exVar4;
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
        com.baidu.tbadk.core.data.ak akVar = null;
        dhVar = this.eob.emx;
        if (dhVar != null) {
            dhVar2 = this.eob.emx;
            if (dhVar2.getPbData() != null) {
                exVar = this.eob.enh;
                if (exVar != null) {
                    exVar2 = this.eob.enh;
                    if (exVar2.aPj() != null) {
                        exVar3 = this.eob.enh;
                        exVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.eob.emP;
                        if (fVar != null) {
                            fVar6 = this.eob.emP;
                            fVar6.onScroll(absListView, i, i2, i3);
                        }
                        dhVar3 = this.eob.emx;
                        if (dhVar3.aOc()) {
                            dhVar4 = this.eob.emx;
                            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = dhVar4.getPbData().aLR();
                            if (aLR != null && !aLR.isEmpty()) {
                                exVar4 = this.eob.enh;
                                int aNp = ((i + i2) - exVar4.aPj().aNp()) - 1;
                                dhVar5 = this.eob.emx;
                                com.baidu.tieba.pb.data.h pbData = dhVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aLS() != null && pbData.aLS().hasData()) {
                                        aNp--;
                                    }
                                    if (pbData.aLT() != null && pbData.aLT().hasData()) {
                                        aNp--;
                                    }
                                    z = this.eob.emZ;
                                    int i4 = z ? aNp - 1 : aNp;
                                    int size = aLR.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.q qVar = aLR.get(i4);
                                        fVar2 = this.eob.enr;
                                        if (fVar2 != null) {
                                            fVar3 = this.eob.enr;
                                            int rv = fVar3.rv(i4);
                                            if (rv >= 0) {
                                                if (qVar instanceof com.baidu.tieba.tbadkCore.data.p) {
                                                    fVar5 = this.eob.enr;
                                                    dhVar12 = this.eob.emx;
                                                    fVar5.c(i4, 1, dhVar12.getThreadID(), rv);
                                                    com.baidu.tieba.recapp.report.b.bbu().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.p) qVar, "show"));
                                                    return;
                                                }
                                                fVar4 = this.eob.enr;
                                                dhVar6 = this.eob.emx;
                                                fVar4.c(i4, 2, dhVar6.getThreadID(), rv);
                                                dhVar7 = this.eob.emx;
                                                if (dhVar7 != null) {
                                                    dhVar10 = this.eob.emx;
                                                    if (dhVar10.getPbData() != null) {
                                                        dhVar11 = this.eob.emx;
                                                        forumData = dhVar11.getPbData().aLP();
                                                        dhVar8 = this.eob.emx;
                                                        if (dhVar8 != null) {
                                                            dhVar9 = this.eob.emx;
                                                            akVar = dhVar9.aoU();
                                                        }
                                                        int qo = akVar == null ? akVar.qo() : 0;
                                                        currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                        com.baidu.tieba.recapp.report.a j = com.baidu.tieba.recapp.report.e.j("store", rv, qo);
                                                        j.bM("page", "PB");
                                                        if (forumData != null) {
                                                            j.bM("fid", forumData.getId());
                                                            j.bM("fc1", forumData.getFirst_class());
                                                            j.bM("fc2", forumData.getSecond_class());
                                                        }
                                                        if (currentAccountObj != null) {
                                                            j.bM("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                                        }
                                                        com.baidu.tieba.recapp.report.b.bbu().a(j);
                                                    }
                                                }
                                                forumData = null;
                                                dhVar8 = this.eob.emx;
                                                if (dhVar8 != null) {
                                                }
                                                if (akVar == null) {
                                                }
                                                currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                com.baidu.tieba.recapp.report.a j2 = com.baidu.tieba.recapp.report.e.j("store", rv, qo);
                                                j2.bM("page", "PB");
                                                if (forumData != null) {
                                                }
                                                if (currentAccountObj != null) {
                                                }
                                                com.baidu.tieba.recapp.report.b.bbu().a(j2);
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
