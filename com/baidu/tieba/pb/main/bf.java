package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class bf implements bt {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity) {
        this.bAT = pbActivity;
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
        this.bAT.bAf = true;
        long currentTimeMillis = System.currentTimeMillis();
        bzVar = this.bAT.bAx;
        bzVar.YI();
        PbActivity pbActivity = this.bAT;
        bzVar2 = this.bAT.bAx;
        pbActivity.hideLoadingView(bzVar2.getView());
        bzVar3 = this.bAT.bAx;
        bzVar3.Qn();
        z2 = this.bAT.aae;
        if (z2) {
            this.bAT.aae = false;
            bzVar16 = this.bAT.bAx;
            bzVar16.bCY.bEV.setEnabled(true);
        }
        if (i4 == 0 && iVar != null) {
            this.bAT.aCM = true;
        }
        if (z && iVar != null) {
            bzVar7 = this.bAT.bAx;
            bzVar7.GS();
            bzVar8 = this.bAT.bAx;
            bzVar8.Zr();
            TbadkCoreApplication.m255getInst().setDefaultBubble(iVar.getUserData().getBimg_url());
            TbadkCoreApplication.m255getInst().setDefaultBubbleEndTime(iVar.getUserData().getBimg_end_time());
            bzVar9 = this.bAT.bAx;
            if (bzVar9.FF() != null) {
                bzVar15 = this.bAT.bAx;
                bzVar15.FF().refresh();
            }
            eVar = this.bAT.bAt;
            eVar.Y(iVar.li());
            bzVar10 = this.bAT.bAx;
            bqVar = this.bAT.bAs;
            bzVar10.a(iVar, i2, i3, bqVar.XL(), i4);
            bzVar11 = this.bAT.bAx;
            bqVar2 = this.bAT.bAs;
            bzVar11.a(iVar, bqVar2.XL(), false, i2);
            bzVar12 = this.bAT.bAx;
            bqVar3 = this.bAT.bAs;
            bzVar12.dZ(bqVar3.getHostMode());
            this.bAT.Xx();
            AntiData mR = iVar.mR();
            if (mR != null) {
                Boolean valueOf = Boolean.valueOf(mR.isIfvoice());
                this.bAT.bAr = mR.getVoice_message();
                this.bAT.g(valueOf);
            }
            if (iVar == null || iVar.CH() != 1) {
                bzVar13 = this.bAT.bAx;
                bzVar13.eb(false);
            } else {
                bzVar14 = this.bAT.bAx;
                bzVar14.eb(true);
            }
        } else if (str != null) {
            if (i == 4 || i == 28) {
                this.bAT.finish();
            }
            z3 = this.bAT.aCM;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bAT;
                    bzVar5 = this.bAT.bAx;
                    pbActivity2.showNetRefreshView(bzVar5.getView(), this.bAT.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, str, Integer.valueOf(i)), true);
                    bzVar6 = this.bAT.bAx;
                    bzVar6.Zs();
                }
            } else {
                this.bAT.showToast(str);
            }
            bzVar4 = this.bAT.bAx;
            bzVar4.qK();
        }
        this.bAT.agS = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void a(com.baidu.tieba.tbadkCore.b.i iVar) {
        bz bzVar;
        bzVar = this.bAT.bAx;
        bzVar.e(iVar);
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void dM(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bAT;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bAT.aDp;
        pbActivity.agT = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1001);
            wVar.agK = this.bAT.aDz;
            j2 = this.bAT.createTime;
            wVar.agM = j2;
            j3 = this.bAT.agT;
            wVar.agT = j3;
            wVar.zs();
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
            j = this.bAT.createTime;
            wVar.agM = j;
            this.bAT.createTime = 0L;
            wVar.agK = this.bAT.aDz;
            j2 = this.bAT.agS;
            wVar.agS = j2;
            j3 = this.bAT.agT;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bAT.aDp;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bAT.agT;
            }
            wVar.agT = j4;
            wVar.zt();
        }
    }
}
