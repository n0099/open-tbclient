package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ab implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean lJ;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        cw cwVar;
        el elVar;
        com.baidu.tbadk.performanceLog.e eVar4;
        el elVar2;
        cw cwVar2;
        cw cwVar3;
        cw cwVar4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean lJ2;
        el elVar3;
        boolean z;
        el elVar4;
        el elVar5;
        com.baidu.tbadk.editortools.d.e eVar6;
        el elVar6;
        el elVar7;
        el elVar8;
        com.baidu.tbadk.editortools.d.e eVar7;
        boolean z2 = true;
        PbActivity pbActivity = this.djE;
        i2 = this.djE.bQV;
        lJ = pbActivity.lJ(i2);
        if (!lJ) {
            lJ2 = this.djE.lJ(i);
            if (lJ2) {
                elVar3 = this.djE.diR;
                if (elVar3 != null) {
                    elVar5 = this.djE.diR;
                    elVar5.amQ();
                    eVar6 = this.djE.dja;
                    if (eVar6 != null) {
                        elVar7 = this.djE.diR;
                        if (!elVar7.ayI()) {
                            elVar8 = this.djE.diR;
                            eVar7 = this.djE.dja;
                            elVar8.fn(eVar7.BM());
                        }
                    }
                    elVar6 = this.djE.diR;
                    elVar6.ayH();
                }
                z = this.djE.diF;
                if (!z) {
                    this.djE.diF = true;
                    elVar4 = this.djE.diR;
                    elVar4.azu();
                }
            }
        }
        fVar = this.djE.diy;
        if (fVar != null) {
            fVar2 = this.djE.diy;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.djE.diG;
        if (eVar == null) {
            this.djE.diG = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.djE.diG;
            eVar5.eM(1001);
        }
        if (i == 0) {
            cwVar = this.djE.dih;
            if (cwVar != null) {
                cwVar2 = this.djE.dih;
                if (cwVar2.getPbData() != null) {
                    cwVar3 = this.djE.dih;
                    if (cwVar3.getPbData().avB() != null) {
                        cwVar4 = this.djE.dih;
                        if (cwVar4.getPbData().avB().rm()) {
                            z2 = false;
                        }
                    }
                }
            }
            elVar = this.djE.diR;
            if (elVar.ayU() != null && z2) {
                elVar2 = this.djE.diR;
                elVar2.ayU().notifyDataSetChanged();
            }
            eVar4 = this.djE.diG;
            eVar4.Et();
        } else if (i == 1) {
            eVar3 = this.djE.diG;
            eVar3.Et();
        } else {
            eVar2 = this.djE.diG;
            eVar2.Et();
        }
        this.djE.bQV = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0187  */
    @Override // android.widget.AbsListView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        cw cwVar;
        cw cwVar2;
        el elVar;
        el elVar2;
        el elVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        cw cwVar3;
        cw cwVar4;
        el elVar4;
        cw cwVar5;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        cw cwVar6;
        cw cwVar7;
        ForumData forumData;
        cw cwVar8;
        AccountData currentAccountObj;
        cw cwVar9;
        cw cwVar10;
        cw cwVar11;
        com.baidu.tieba.tbadkCore.data.f fVar5;
        cw cwVar12;
        com.baidu.tieba.pb.pb.main.a.f fVar6;
        com.baidu.tbadk.core.data.ad adVar = null;
        cwVar = this.djE.dih;
        if (cwVar != null) {
            cwVar2 = this.djE.dih;
            if (cwVar2.getPbData() != null) {
                elVar = this.djE.diR;
                if (elVar != null) {
                    elVar2 = this.djE.diR;
                    if (elVar2.ayU() != null) {
                        elVar3 = this.djE.diR;
                        elVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.djE.diy;
                        if (fVar != null) {
                            fVar6 = this.djE.diy;
                            fVar6.onScroll(absListView, i, i2, i3);
                        }
                        cwVar3 = this.djE.dih;
                        if (cwVar3.axP()) {
                            cwVar4 = this.djE.dih;
                            ArrayList<com.baidu.tieba.tbadkCore.data.s> avC = cwVar4.getPbData().avC();
                            if (avC != null && !avC.isEmpty()) {
                                elVar4 = this.djE.diR;
                                int axc = ((i + i2) - elVar4.ayU().axc()) - 1;
                                cwVar5 = this.djE.dih;
                                com.baidu.tieba.pb.data.e pbData = cwVar5.getPbData();
                                if (pbData != null) {
                                    if (pbData.avD() != null && !StringUtils.isNull(pbData.avD().rB())) {
                                        axc--;
                                    }
                                    z = this.djE.diI;
                                    int i4 = z ? axc - 1 : axc;
                                    int size = avC.size();
                                    if (i4 >= 0 && i4 < size) {
                                        com.baidu.tieba.tbadkCore.data.s sVar = avC.get(i4);
                                        fVar2 = this.djE.diZ;
                                        if (fVar2 != null) {
                                            fVar3 = this.djE.diZ;
                                            int pk = fVar3.pk(i4);
                                            if (pk >= 0) {
                                                if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
                                                    fVar5 = this.djE.diZ;
                                                    cwVar12 = this.djE.dih;
                                                    fVar5.c(i4, 1, cwVar12.getThreadID(), pk);
                                                    com.baidu.tieba.recapp.report.b.aLG().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tieba.tbadkCore.data.r) sVar, "show"));
                                                    return;
                                                }
                                                fVar4 = this.djE.diZ;
                                                cwVar6 = this.djE.dih;
                                                fVar4.c(i4, 2, cwVar6.getThreadID(), pk);
                                                cwVar7 = this.djE.dih;
                                                if (cwVar7 != null) {
                                                    cwVar10 = this.djE.dih;
                                                    if (cwVar10.getPbData() != null) {
                                                        cwVar11 = this.djE.dih;
                                                        forumData = cwVar11.getPbData().avA();
                                                        cwVar8 = this.djE.dih;
                                                        if (cwVar8 != null) {
                                                            cwVar9 = this.djE.dih;
                                                            adVar = cwVar9.abs();
                                                        }
                                                        int pI = adVar == null ? adVar.pI() : 0;
                                                        currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                        com.baidu.tieba.recapp.report.a i5 = com.baidu.tieba.recapp.report.e.i("store", pk, pI);
                                                        i5.bE("page", "PB");
                                                        if (forumData != null) {
                                                            i5.bE("fid", forumData.getId());
                                                            i5.bE("fc1", forumData.getFirst_class());
                                                            i5.bE("fc2", forumData.getSecond_class());
                                                        }
                                                        if (currentAccountObj != null) {
                                                            i5.bE("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                                        }
                                                        com.baidu.tieba.recapp.report.b.aLG().a(i5);
                                                    }
                                                }
                                                forumData = null;
                                                cwVar8 = this.djE.dih;
                                                if (cwVar8 != null) {
                                                }
                                                if (adVar == null) {
                                                }
                                                currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                                com.baidu.tieba.recapp.report.a i52 = com.baidu.tieba.recapp.report.e.i("store", pk, pI);
                                                i52.bE("page", "PB");
                                                if (forumData != null) {
                                                }
                                                if (currentAccountObj != null) {
                                                }
                                                com.baidu.tieba.recapp.report.b.aLG().a(i52);
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
