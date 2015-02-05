package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class bf implements bt {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.tbadkCore.b.i iVar, String str, int i4) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        boolean z2;
        boolean z3;
        bz bzVar4;
        bz bzVar5;
        bz bzVar6;
        bz bzVar7;
        bz bzVar8;
        bz bzVar9;
        com.baidu.tbadk.baseEditMark.e eVar;
        bz bzVar10;
        bq bqVar;
        bz bzVar11;
        bq bqVar2;
        bz bzVar12;
        bq bqVar3;
        bz bzVar13;
        bz bzVar14;
        bz bzVar15;
        bz bzVar16;
        this.bAS.bAe = true;
        long currentTimeMillis = System.currentTimeMillis();
        bzVar = this.bAS.bAw;
        bzVar.YD();
        PbActivity pbActivity = this.bAS;
        bzVar2 = this.bAS.bAw;
        pbActivity.hideLoadingView(bzVar2.getView());
        bzVar3 = this.bAS.bAw;
        bzVar3.Qi();
        z2 = this.bAS.aab;
        if (z2) {
            this.bAS.aab = false;
            bzVar16 = this.bAS.bAw;
            bzVar16.bCX.bEU.setEnabled(true);
        }
        if (i4 == 0 && iVar != null) {
            this.bAS.aCJ = true;
        }
        if (z && iVar != null) {
            bzVar7 = this.bAS.bAw;
            bzVar7.GM();
            bzVar8 = this.bAS.bAw;
            bzVar8.Zm();
            TbadkCoreApplication.m255getInst().setDefaultBubble(iVar.getUserData().getBimg_url());
            TbadkCoreApplication.m255getInst().setDefaultBubbleEndTime(iVar.getUserData().getBimg_end_time());
            bzVar9 = this.bAS.bAw;
            if (bzVar9.Fz() != null) {
                bzVar15 = this.bAS.bAw;
                bzVar15.Fz().refresh();
            }
            eVar = this.bAS.bAs;
            eVar.Y(iVar.lb());
            bzVar10 = this.bAS.bAw;
            bqVar = this.bAS.bAr;
            bzVar10.a(iVar, i2, i3, bqVar.XG(), i4);
            bzVar11 = this.bAS.bAw;
            bqVar2 = this.bAS.bAr;
            bzVar11.a(iVar, bqVar2.XG(), false, i2);
            bzVar12 = this.bAS.bAw;
            bqVar3 = this.bAS.bAr;
            bzVar12.dZ(bqVar3.getHostMode());
            this.bAS.Xs();
            AntiData mK = iVar.mK();
            if (mK != null) {
                Boolean valueOf = Boolean.valueOf(mK.isIfvoice());
                this.bAS.bAq = mK.getVoice_message();
                this.bAS.g(valueOf);
            }
            if (iVar == null || iVar.CB() != 1) {
                bzVar13 = this.bAS.bAw;
                bzVar13.eb(false);
            } else {
                bzVar14 = this.bAS.bAw;
                bzVar14.eb(true);
            }
        } else if (str != null) {
            if (i == 4 || i == 28) {
                this.bAS.finish();
            }
            z3 = this.bAS.aCJ;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bAS;
                    bzVar5 = this.bAS.bAw;
                    pbActivity2.showNetRefreshView(bzVar5.getView(), this.bAS.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, str, Integer.valueOf(i)), true);
                    bzVar6 = this.bAS.bAw;
                    bzVar6.Zn();
                }
            } else {
                this.bAS.showToast(str);
            }
            bzVar4 = this.bAS.bAw;
            bzVar4.qE();
        }
        this.bAS.agP = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void a(com.baidu.tieba.tbadkCore.b.i iVar) {
        bz bzVar;
        bzVar = this.bAS.bAw;
        bzVar.e(iVar);
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void dM(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bAS;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bAS.aDm;
        pbActivity.agQ = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1001);
            wVar.agH = this.bAS.aDw;
            j2 = this.bAS.createTime;
            wVar.agJ = j2;
            j3 = this.bAS.agQ;
            wVar.agQ = j3;
            wVar.zm();
        }
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void e(com.baidu.tbadk.performanceLog.w wVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (wVar != null) {
            j = this.bAS.createTime;
            wVar.agJ = j;
            this.bAS.createTime = 0L;
            wVar.agH = this.bAS.aDw;
            j2 = this.bAS.agP;
            wVar.agP = j2;
            j3 = this.bAS.agQ;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bAS.aDm;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bAS.agQ;
            }
            wVar.agQ = j4;
            wVar.zn();
        }
    }
}
