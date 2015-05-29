package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class c implements bs {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bs
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        boolean z2;
        boolean z3;
        ch chVar4;
        ch chVar5;
        ch chVar6;
        ch chVar7;
        ch chVar8;
        ch chVar9;
        com.baidu.tbadk.baseEditMark.a aVar;
        ch chVar10;
        boolean z4;
        ch chVar11;
        bo boVar;
        ch chVar12;
        bo boVar2;
        ch chVar13;
        bo boVar3;
        String str2;
        ch chVar14;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ch chVar15;
        ch chVar16;
        this.bKT.bIU = true;
        long currentTimeMillis = System.currentTimeMillis();
        chVar = this.bKT.bKz;
        chVar.aci();
        PbActivity pbActivity = this.bKT;
        chVar2 = this.bKT.bKz;
        pbActivity.hideLoadingView(chVar2.getView());
        chVar3 = this.bKT.bKz;
        chVar3.Tc();
        z2 = this.bKT.alI;
        if (z2) {
            this.bKT.alI = false;
            chVar16 = this.bKT.bKz;
            chVar16.bNi.bOP.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.bKT.aKY = true;
        }
        if (z && bVar != null) {
            chVar7 = this.bKT.bKz;
            chVar7.Lm();
            chVar8 = this.bKT.bKz;
            chVar8.acA();
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            chVar9 = this.bKT.bKz;
            if (chVar9.Ki() != null) {
                chVar15 = this.bKT.bKz;
                chVar15.Ki().refresh();
            }
            aVar = this.bKT.bKw;
            if (aVar != null) {
                aVar2 = this.bKT.bKw;
                aVar2.Z(bVar.pq());
            }
            if (bVar == null || bVar.aaw() != 1) {
                this.bKT.mIsFromCDN = false;
            } else {
                this.bKT.mIsFromCDN = true;
            }
            chVar10 = this.bKT.bKz;
            z4 = this.bKT.mIsFromCDN;
            chVar10.ei(z4);
            chVar11 = this.bKT.bKz;
            boVar = this.bKT.bKv;
            chVar11.a(bVar, i2, i3, boVar.abp(), i4);
            chVar12 = this.bKT.bKz;
            boVar2 = this.bKT.bKv;
            chVar12.a(bVar, boVar2.abp(), false, i2);
            chVar13 = this.bKT.bKz;
            boVar3 = this.bKT.bKv;
            chVar13.eg(boVar3.getHostMode());
            this.bKT.abc();
            AntiData qK = bVar.qK();
            if (qK != null) {
                Boolean valueOf = Boolean.valueOf(qK.isIfvoice());
                this.bKT.bKu = qK.getVoice_message();
                this.bKT.f(valueOf);
                str2 = this.bKT.bKu;
                if (!StringUtils.isNull(str2)) {
                    chVar14 = this.bKT.bKz;
                    chVar14.setAudioCanUse(false);
                }
            }
        } else if (str != null) {
            z3 = this.bKT.aKY;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bKT;
                    chVar5 = this.bKT.bKz;
                    pbActivity2.showNetRefreshView(chVar5.getView(), this.bKT.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, str, Integer.valueOf(i)), true);
                    chVar6 = this.bKT.bKz;
                    chVar6.acB();
                }
            } else {
                this.bKT.showToast(str);
            }
            chVar4 = this.bKT.bKz;
            chVar4.ux();
        }
        this.bKT.aqD = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bs
    public void a(com.baidu.tieba.pb.a.b bVar) {
        ch chVar;
        chVar = this.bKT.bKz;
        chVar.e(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bs
    public void dR(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bKT;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bKT.aEP;
        pbActivity.aqE = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.bKT.createTime;
            aaVar.aqx = j2;
            j3 = this.bKT.aqE;
            aaVar.aqE = j3;
            aaVar.Dv();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.bs
    public void e(com.baidu.tbadk.performanceLog.aa aaVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (aaVar != null) {
            j = this.bKT.createTime;
            aaVar.aqx = j;
            this.bKT.createTime = 0L;
            j2 = this.bKT.aqD;
            aaVar.aqD = j2;
            j3 = this.bKT.aqE;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bKT.aEP;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bKT.aqE;
            }
            aaVar.aqE = j4;
            aaVar.Dw();
        }
    }
}
