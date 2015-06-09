package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class c implements bs {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bKU = pbActivity;
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
        this.bKU.bIV = true;
        long currentTimeMillis = System.currentTimeMillis();
        chVar = this.bKU.bKA;
        chVar.acj();
        PbActivity pbActivity = this.bKU;
        chVar2 = this.bKU.bKA;
        pbActivity.hideLoadingView(chVar2.getView());
        chVar3 = this.bKU.bKA;
        chVar3.Td();
        z2 = this.bKU.alI;
        if (z2) {
            this.bKU.alI = false;
            chVar16 = this.bKU.bKA;
            chVar16.bNj.bOQ.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.bKU.aKZ = true;
        }
        if (z && bVar != null) {
            chVar7 = this.bKU.bKA;
            chVar7.Ln();
            chVar8 = this.bKU.bKA;
            chVar8.acB();
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            chVar9 = this.bKU.bKA;
            if (chVar9.Kj() != null) {
                chVar15 = this.bKU.bKA;
                chVar15.Kj().refresh();
            }
            aVar = this.bKU.bKx;
            if (aVar != null) {
                aVar2 = this.bKU.bKx;
                aVar2.Z(bVar.pq());
            }
            if (bVar == null || bVar.aax() != 1) {
                this.bKU.mIsFromCDN = false;
            } else {
                this.bKU.mIsFromCDN = true;
            }
            chVar10 = this.bKU.bKA;
            z4 = this.bKU.mIsFromCDN;
            chVar10.ei(z4);
            chVar11 = this.bKU.bKA;
            boVar = this.bKU.bKw;
            chVar11.a(bVar, i2, i3, boVar.abq(), i4);
            chVar12 = this.bKU.bKA;
            boVar2 = this.bKU.bKw;
            chVar12.a(bVar, boVar2.abq(), false, i2);
            chVar13 = this.bKU.bKA;
            boVar3 = this.bKU.bKw;
            chVar13.eg(boVar3.getHostMode());
            this.bKU.abd();
            AntiData qK = bVar.qK();
            if (qK != null) {
                Boolean valueOf = Boolean.valueOf(qK.isIfvoice());
                this.bKU.bKv = qK.getVoice_message();
                this.bKU.f(valueOf);
                str2 = this.bKU.bKv;
                if (!StringUtils.isNull(str2)) {
                    chVar14 = this.bKU.bKA;
                    chVar14.setAudioCanUse(false);
                }
            }
        } else if (str != null) {
            z3 = this.bKU.aKZ;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bKU;
                    chVar5 = this.bKU.bKA;
                    pbActivity2.showNetRefreshView(chVar5.getView(), this.bKU.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, str, Integer.valueOf(i)), true);
                    chVar6 = this.bKU.bKA;
                    chVar6.acC();
                }
            } else {
                this.bKU.showToast(str);
            }
            chVar4 = this.bKU.bKA;
            chVar4.ux();
        }
        this.bKU.aqD = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bs
    public void a(com.baidu.tieba.pb.a.b bVar) {
        ch chVar;
        chVar = this.bKU.bKA;
        chVar.e(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bs
    public void dR(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bKU;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bKU.aEQ;
        pbActivity.aqE = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.bKU.createTime;
            aaVar.aqx = j2;
            j3 = this.bKU.aqE;
            aaVar.aqE = j3;
            aaVar.Dw();
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
            j = this.bKU.createTime;
            aaVar.aqx = j;
            this.bKU.createTime = 0L;
            j2 = this.bKU.aqD;
            aaVar.aqD = j2;
            j3 = this.bKU.aqE;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bKU.aEQ;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bKU.aqE;
            }
            aaVar.aqE = j4;
            aaVar.Dx();
        }
    }
}
