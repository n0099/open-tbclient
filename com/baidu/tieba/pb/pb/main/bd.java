package com.baidu.tieba.pb.pb.main;

import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class bd implements bv {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bv
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        boolean z2;
        boolean z3;
        cj cjVar4;
        cj cjVar5;
        cj cjVar6;
        cj cjVar7;
        cj cjVar8;
        cj cjVar9;
        com.baidu.tbadk.baseEditMark.a aVar;
        cj cjVar10;
        boolean z4;
        cj cjVar11;
        br brVar;
        cj cjVar12;
        br brVar2;
        cj cjVar13;
        br brVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        cj cjVar14;
        cj cjVar15;
        this.bIJ.bGe = true;
        long currentTimeMillis = System.currentTimeMillis();
        cjVar = this.bIJ.bIl;
        cjVar.aba();
        PbActivity pbActivity = this.bIJ;
        cjVar2 = this.bIJ.bIl;
        pbActivity.hideLoadingView(cjVar2.getView());
        cjVar3 = this.bIJ.bIl;
        cjVar3.RP();
        z2 = this.bIJ.akH;
        if (z2) {
            this.bIJ.akH = false;
            cjVar15 = this.bIJ.bIl;
            cjVar15.bLc.bMR.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.bIJ.aIQ = true;
        }
        if (z && bVar != null) {
            cjVar7 = this.bIJ.bIl;
            cjVar7.Kh();
            cjVar8 = this.bIJ.bIl;
            cjVar8.abL();
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            cjVar9 = this.bIJ.bIl;
            if (cjVar9.Je() != null) {
                cjVar14 = this.bIJ.bIl;
                cjVar14.Je().refresh();
            }
            aVar = this.bIJ.bIh;
            if (aVar != null) {
                aVar2 = this.bIJ.bIh;
                aVar2.W(bVar.oQ());
            }
            if (bVar == null || bVar.Zf() != 1) {
                this.bIJ.mIsFromCDN = false;
            } else {
                this.bIJ.mIsFromCDN = true;
            }
            cjVar10 = this.bIJ.bIl;
            z4 = this.bIJ.mIsFromCDN;
            cjVar10.dW(z4);
            cjVar11 = this.bIJ.bIl;
            brVar = this.bIJ.bIg;
            cjVar11.a(bVar, i2, i3, brVar.aab(), i4);
            cjVar12 = this.bIJ.bIl;
            brVar2 = this.bIJ.bIg;
            cjVar12.a(bVar, brVar2.aab(), false, i2);
            cjVar13 = this.bIJ.bIl;
            brVar3 = this.bIJ.bIg;
            cjVar13.dU(brVar3.getHostMode());
            this.bIJ.ZL();
            AntiData qe = bVar.qe();
            if (qe != null) {
                Boolean valueOf = Boolean.valueOf(qe.isIfvoice());
                this.bIJ.bIf = qe.getVoice_message();
                this.bIJ.f(valueOf);
            }
        } else if (str != null) {
            if (i == 4 || i == 28) {
                this.bIJ.finish();
            }
            z3 = this.bIJ.aIQ;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bIJ;
                    cjVar5 = this.bIJ.bIl;
                    pbActivity2.showNetRefreshView(cjVar5.getView(), this.bIJ.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, str, Integer.valueOf(i)), true);
                    cjVar6 = this.bIJ.bIl;
                    cjVar6.abM();
                }
            } else {
                this.bIJ.showToast(str);
            }
            cjVar4 = this.bIJ.bIl;
            cjVar4.tO();
        }
        this.bIJ.apB = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bv
    public void a(com.baidu.tieba.pb.a.b bVar) {
        cj cjVar;
        cjVar = this.bIJ.bIl;
        cjVar.e(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bv
    public void dG(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bIJ;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bIJ.aCO;
        pbActivity.apC = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.apt = this.bIJ.aJq;
            j2 = this.bIJ.createTime;
            aaVar.apv = j2;
            j3 = this.bIJ.apC;
            aaVar.apC = j3;
            aaVar.CK();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.bv
    public void e(com.baidu.tbadk.performanceLog.aa aaVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (aaVar != null) {
            j = this.bIJ.createTime;
            aaVar.apv = j;
            this.bIJ.createTime = 0L;
            aaVar.apt = this.bIJ.aJq;
            j2 = this.bIJ.apB;
            aaVar.apB = j2;
            j3 = this.bIJ.apC;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bIJ.aCO;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bIJ.apC;
            }
            aaVar.apC = j4;
            aaVar.CL();
        }
    }
}
