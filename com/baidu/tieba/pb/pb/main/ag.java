package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ag implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean ol;
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
        boolean ol2;
        ex exVar3;
        boolean z;
        ex exVar4;
        ex exVar5;
        com.baidu.tbadk.editortools.e.e eVar6;
        ex exVar6;
        ex exVar7;
        ex exVar8;
        com.baidu.tbadk.editortools.e.e eVar7;
        boolean z2 = true;
        PbActivity pbActivity = this.eqa;
        i2 = this.eqa.cKh;
        ol = pbActivity.ol(i2);
        if (!ol) {
            ol2 = this.eqa.ol(i);
            if (ol2) {
                exVar3 = this.eqa.epe;
                if (exVar3 != null) {
                    exVar5 = this.eqa.epe;
                    exVar5.aBc();
                    eVar6 = this.eqa.epp;
                    if (eVar6 != null) {
                        exVar7 = this.eqa.epe;
                        if (!exVar7.aPH()) {
                            exVar8 = this.eqa.epe;
                            eVar7 = this.eqa.epp;
                            exVar8.gD(eVar7.Dr());
                        }
                    }
                    exVar6 = this.eqa.epe;
                    exVar6.aPG();
                }
                z = this.eqa.eoU;
                if (!z) {
                    this.eqa.eoU = true;
                    exVar4 = this.eqa.epe;
                    exVar4.aQt();
                }
            }
        }
        fVar = this.eqa.eoN;
        if (fVar != null) {
            fVar2 = this.eqa.eoN;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.eqa.eoV;
        if (eVar == null) {
            this.eqa.eoV = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.eqa.eoV;
            eVar5.fd(1001);
        }
        if (i == 0) {
            dhVar = this.eqa.eov;
            if (dhVar != null) {
                dhVar2 = this.eqa.eov;
                if (dhVar2.getPbData() != null) {
                    dhVar3 = this.eqa.eov;
                    if (dhVar3.getPbData().aMs() != null) {
                        dhVar4 = this.eqa.eov;
                        if (dhVar4.getPbData().aMs().sz()) {
                            z2 = false;
                        }
                    }
                }
            }
            exVar = this.eqa.epe;
            if (exVar.aPS() != null && z2) {
                exVar2 = this.eqa.epe;
                exVar2.aPS().notifyDataSetChanged();
            }
            eVar4 = this.eqa.eoV;
            eVar4.FV();
        } else if (i == 1) {
            eVar3 = this.eqa.eoV;
            eVar3.FV();
        } else {
            eVar2 = this.eqa.eoV;
            eVar2.FV();
        }
        this.eqa.cKh = i;
        if (i == 0) {
            this.eqa.aNn();
        }
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
        com.baidu.tbadk.core.data.am amVar = null;
        dhVar = this.eqa.eov;
        if (dhVar != null) {
            dhVar2 = this.eqa.eov;
            if (dhVar2.getPbData() != null) {
                exVar = this.eqa.epe;
                if (exVar != null) {
                    exVar2 = this.eqa.epe;
                    if (exVar2.aPS() != null) {
                        exVar3 = this.eqa.epe;
                        exVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.eqa.eoN;
                        if (fVar != null) {
                            fVar6 = this.eqa.eoN;
                            fVar6.onScroll(absListView, i, i2, i3);
                        }
                        dhVar3 = this.eqa.eov;
                        if (dhVar3.aOK()) {
                            dhVar4 = this.eqa.eov;
                            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = dhVar4.getPbData().aMt();
                            if (aMt != null && !aMt.isEmpty()) {
                                exVar4 = this.eqa.epe;
                                int aNV = ((i + i2) - exVar4.aPS().aNV()) - 1;
                                dhVar5 = this.eqa.eov;
                                com.baidu.tieba.pb.data.h pbData = dhVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aMu() != null && pbData.aMu().hasData()) {
                                        aNV--;
                                    }
                                    if (pbData.aMv() != null && pbData.aMv().hasData()) {
                                        aNV--;
                                    }
                                    z = this.eqa.eoX;
                                    int i4 = z ? aNV - 1 : aNV;
                                    int size = aMt.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.q qVar = aMt.get(i4);
                                        fVar2 = this.eqa.epo;
                                        if (fVar2 != null) {
                                            fVar3 = this.eqa.epo;
                                            int rJ = fVar3.rJ(i4);
                                            if (rJ >= 0) {
                                                if (qVar instanceof com.baidu.tieba.tbadkCore.data.p) {
                                                    fVar5 = this.eqa.epo;
                                                    dhVar12 = this.eqa.eov;
                                                    fVar5.c(i4, 1, dhVar12.getThreadID(), rJ);
                                                    com.baidu.tieba.recapp.report.b.bce().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.p) qVar, "show"));
                                                    return;
                                                }
                                                fVar4 = this.eqa.epo;
                                                dhVar6 = this.eqa.eov;
                                                fVar4.c(i4, 2, dhVar6.getThreadID(), rJ);
                                                dhVar7 = this.eqa.eov;
                                                if (dhVar7 != null) {
                                                    dhVar10 = this.eqa.eov;
                                                    if (dhVar10.getPbData() != null) {
                                                        dhVar11 = this.eqa.eov;
                                                        forumData = dhVar11.getPbData().aMr();
                                                        dhVar8 = this.eqa.eov;
                                                        if (dhVar8 != null) {
                                                            dhVar9 = this.eqa.eov;
                                                            amVar = dhVar9.api();
                                                        }
                                                        int qz = amVar == null ? amVar.qz() : 0;
                                                        currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                        com.baidu.tieba.recapp.report.a j = com.baidu.tieba.recapp.report.e.j("store", rJ, qz);
                                                        j.bN("page", "PB");
                                                        if (forumData != null) {
                                                            j.bN("fid", forumData.getId());
                                                            j.bN("fc1", forumData.getFirst_class());
                                                            j.bN("fc2", forumData.getSecond_class());
                                                        }
                                                        if (currentAccountObj != null) {
                                                            j.bN("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                                        }
                                                        com.baidu.tieba.recapp.report.b.bce().a(j);
                                                    }
                                                }
                                                forumData = null;
                                                dhVar8 = this.eqa.eov;
                                                if (dhVar8 != null) {
                                                }
                                                if (amVar == null) {
                                                }
                                                currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                com.baidu.tieba.recapp.report.a j2 = com.baidu.tieba.recapp.report.e.j("store", rJ, qz);
                                                j2.bN("page", "PB");
                                                if (forumData != null) {
                                                }
                                                if (currentAccountObj != null) {
                                                }
                                                com.baidu.tieba.recapp.report.b.bce().a(j2);
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
