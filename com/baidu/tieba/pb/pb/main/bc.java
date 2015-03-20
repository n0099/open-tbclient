package com.baidu.tieba.pb.pb.main;

import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class bc implements bu {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bu
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        boolean z2;
        boolean z3;
        ci ciVar4;
        ci ciVar5;
        ci ciVar6;
        ci ciVar7;
        ci ciVar8;
        ci ciVar9;
        com.baidu.tbadk.baseEditMark.a aVar;
        ci ciVar10;
        boolean z4;
        ci ciVar11;
        bq bqVar;
        ci ciVar12;
        bq bqVar2;
        ci ciVar13;
        bq bqVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ci ciVar14;
        ci ciVar15;
        this.bIv.bFR = true;
        long currentTimeMillis = System.currentTimeMillis();
        ciVar = this.bIv.bHY;
        ciVar.aaN();
        PbActivity pbActivity = this.bIv;
        ciVar2 = this.bIv.bHY;
        pbActivity.hideLoadingView(ciVar2.getView());
        ciVar3 = this.bIv.bHY;
        ciVar3.RC();
        z2 = this.bIv.akz;
        if (z2) {
            this.bIv.akz = false;
            ciVar15 = this.bIv.bHY;
            ciVar15.bKN.bMB.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.bIv.aII = true;
        }
        if (z && bVar != null) {
            ciVar7 = this.bIv.bHY;
            ciVar7.Ka();
            ciVar8 = this.bIv.bHY;
            ciVar8.abw();
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            ciVar9 = this.bIv.bHY;
            if (ciVar9.IY() != null) {
                ciVar14 = this.bIv.bHY;
                ciVar14.IY().refresh();
            }
            aVar = this.bIv.bHU;
            if (aVar != null) {
                aVar2 = this.bIv.bHU;
                aVar2.W(bVar.oQ());
            }
            if (bVar == null || bVar.YT() != 1) {
                this.bIv.mIsFromCDN = false;
            } else {
                this.bIv.mIsFromCDN = true;
            }
            ciVar10 = this.bIv.bHY;
            z4 = this.bIv.mIsFromCDN;
            ciVar10.dY(z4);
            ciVar11 = this.bIv.bHY;
            bqVar = this.bIv.bHT;
            ciVar11.a(bVar, i2, i3, bqVar.ZO(), i4);
            ciVar12 = this.bIv.bHY;
            bqVar2 = this.bIv.bHT;
            ciVar12.a(bVar, bqVar2.ZO(), false, i2);
            ciVar13 = this.bIv.bHY;
            bqVar3 = this.bIv.bHT;
            ciVar13.dW(bqVar3.getHostMode());
            this.bIv.Zy();
            AntiData qe = bVar.qe();
            if (qe != null) {
                Boolean valueOf = Boolean.valueOf(qe.isIfvoice());
                this.bIv.bHS = qe.getVoice_message();
                this.bIv.f(valueOf);
            }
        } else if (str != null) {
            if (i == 4 || i == 28) {
                this.bIv.finish();
            }
            z3 = this.bIv.aII;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bIv;
                    ciVar5 = this.bIv.bHY;
                    pbActivity2.showNetRefreshView(ciVar5.getView(), this.bIv.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, str, Integer.valueOf(i)), true);
                    ciVar6 = this.bIv.bHY;
                    ciVar6.abx();
                }
            } else {
                this.bIv.showToast(str);
            }
            ciVar4 = this.bIv.bHY;
            ciVar4.tO();
        }
        this.bIv.apt = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bu
    public void a(com.baidu.tieba.pb.a.b bVar) {
        ci ciVar;
        ciVar = this.bIv.bHY;
        ciVar.e(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bu
    public void dI(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bIv;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bIv.aCG;
        pbActivity.apu = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
            aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            aaVar.apk = this.bIv.aJi;
            j2 = this.bIv.createTime;
            aaVar.apm = j2;
            j3 = this.bIv.apu;
            aaVar.apu = j3;
            aaVar.CE();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.bu
    public void e(com.baidu.tbadk.performanceLog.aa aaVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (aaVar != null) {
            j = this.bIv.createTime;
            aaVar.apm = j;
            this.bIv.createTime = 0L;
            aaVar.apk = this.bIv.aJi;
            j2 = this.bIv.apt;
            aaVar.apt = j2;
            j3 = this.bIv.apu;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bIv.aCG;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bIv.apu;
            }
            aaVar.apu = j4;
            aaVar.CF();
        }
    }
}
