package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class be implements bt {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.bzj = pbActivity;
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
        this.bzj.byw = true;
        long currentTimeMillis = System.currentTimeMillis();
        bzVar = this.bzj.byO;
        bzVar.Yd();
        PbActivity pbActivity = this.bzj;
        bzVar2 = this.bzj.byO;
        pbActivity.hideLoadingView(bzVar2.getView());
        bzVar3 = this.bzj.byO;
        bzVar3.PQ();
        z2 = this.bzj.ZD;
        if (z2) {
            this.bzj.ZD = false;
            bzVar16 = this.bzj.byO;
            bzVar16.bBo.bDk.setEnabled(true);
        }
        if (i4 == 0 && iVar != null) {
            this.bzj.aBL = true;
        }
        if (z && iVar != null) {
            bzVar7 = this.bzj.byO;
            bzVar7.Gv();
            bzVar8 = this.bzj.byO;
            bzVar8.YM();
            TbadkCoreApplication.m255getInst().setDefaultBubble(iVar.getUserData().getBimg_url());
            TbadkCoreApplication.m255getInst().setDefaultBubbleEndTime(iVar.getUserData().getBimg_end_time());
            bzVar9 = this.bzj.byO;
            if (bzVar9.Fh() != null) {
                bzVar15 = this.bzj.byO;
                bzVar15.Fh().refresh();
            }
            eVar = this.bzj.byK;
            eVar.Y(iVar.li());
            bzVar10 = this.bzj.byO;
            bqVar = this.bzj.byJ;
            bzVar10.a(iVar, i2, i3, bqVar.Xg(), i4);
            bzVar11 = this.bzj.byO;
            bqVar2 = this.bzj.byJ;
            bzVar11.a(iVar, bqVar2.Xg(), false, i2);
            bzVar12 = this.bzj.byO;
            bqVar3 = this.bzj.byJ;
            bzVar12.dT(bqVar3.getHostMode());
            this.bzj.WS();
            AntiData mP = iVar.mP();
            if (mP != null) {
                Boolean valueOf = Boolean.valueOf(mP.isIfvoice());
                this.bzj.byI = mP.getVoice_message();
                this.bzj.g(valueOf);
            }
            if (iVar == null || iVar.Ci() != 1) {
                bzVar13 = this.bzj.byO;
                bzVar13.dV(false);
            } else {
                bzVar14 = this.bzj.byO;
                bzVar14.dV(true);
            }
        } else if (str != null) {
            if (i == 4 || i == 28) {
                this.bzj.finish();
            }
            z3 = this.bzj.aBL;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bzj;
                    bzVar5 = this.bzj.byO;
                    pbActivity2.showNetRefreshView(bzVar5.getView(), this.bzj.getPageContext().getResources().getString(com.baidu.tieba.z.net_error_text, str, Integer.valueOf(i)), true);
                    bzVar6 = this.bzj.byO;
                    bzVar6.YN();
                }
            } else {
                this.bzj.showToast(str);
            }
            bzVar4 = this.bzj.byO;
            bzVar4.qz();
        }
        this.bzj.agu = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void a(com.baidu.tieba.tbadkCore.b.i iVar) {
        bz bzVar;
        bzVar = this.bzj.byO;
        bzVar.e(iVar);
    }

    @Override // com.baidu.tieba.pb.main.bt
    public void dG(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bzj;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bzj.aCo;
        pbActivity.agv = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dR(1001);
            wVar.agm = this.bzj.aCy;
            j2 = this.bzj.createTime;
            wVar.ago = j2;
            j3 = this.bzj.agv;
            wVar.agv = j3;
            wVar.zb();
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
            j = this.bzj.createTime;
            wVar.ago = j;
            this.bzj.createTime = 0L;
            wVar.agm = this.bzj.aCy;
            j2 = this.bzj.agu;
            wVar.agu = j2;
            j3 = this.bzj.agv;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bzj.aCo;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bzj.agv;
            }
            wVar.agv = j4;
            wVar.zc();
        }
    }
}
