package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class bc implements bq {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bq
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ah ahVar, String str, int i4) {
        bv bvVar;
        bv bvVar2;
        boolean z2;
        bv bvVar3;
        bv bvVar4;
        bv bvVar5;
        bv bvVar6;
        bv bvVar7;
        bv bvVar8;
        com.baidu.tieba.model.aj ajVar;
        bv bvVar9;
        bn bnVar;
        bv bvVar10;
        bn bnVar2;
        bv bvVar11;
        bn bnVar3;
        bv bvVar12;
        bv bvVar13;
        bv bvVar14;
        long currentTimeMillis = System.currentTimeMillis();
        bvVar = this.bvg.buL;
        bvVar.XD();
        PbActivity pbActivity = this.bvg;
        bvVar2 = this.bvg.buL;
        pbActivity.hideLoadingView(bvVar2.getView());
        if (i4 == 0 && ahVar != null) {
            this.bvg.aAj = true;
        }
        if (z && ahVar != null) {
            bvVar6 = this.bvg.buL;
            bvVar6.Go();
            bvVar7 = this.bvg.buL;
            bvVar7.Yl();
            TbadkApplication.m251getInst().setDefaultBubble(ahVar.getUserData().getBimg_url());
            TbadkApplication.m251getInst().setDefaultBubbleEndTime(ahVar.getUserData().getBimg_end_time());
            bvVar8 = this.bvg.buL;
            if (bvVar8.EO() != null) {
                bvVar14 = this.bvg.buL;
                bvVar14.EO().refresh();
            }
            ajVar = this.bvg.buH;
            ajVar.bs(ahVar.zN());
            bvVar9 = this.bvg.buL;
            bnVar = this.bvg.buG;
            bvVar9.a(ahVar, i2, i3, bnVar.WG(), i4);
            bvVar10 = this.bvg.buL;
            bnVar2 = this.bvg.buG;
            bvVar10.a(ahVar, bnVar2.WG(), false, i2);
            bvVar11 = this.bvg.buL;
            bnVar3 = this.bvg.buG;
            bvVar11.ei(bnVar3.getHostMode());
            this.bvg.Ws();
            AntiData jZ = ahVar.jZ();
            if (jZ != null) {
                Boolean valueOf = Boolean.valueOf(jZ.isIfvoice());
                this.bvg.buF = jZ.getVoice_message();
                this.bvg.f(valueOf);
            }
            if (ahVar == null || ahVar.yU() != 1) {
                bvVar12 = this.bvg.buL;
                bvVar12.ek(false);
            } else {
                bvVar13 = this.bvg.buL;
                bvVar13.ek(true);
            }
        } else if (str != null) {
            if (i == 4 || i == 28) {
                this.bvg.finish();
            }
            z2 = this.bvg.aAj;
            if (!z2 && i4 == 1) {
                if (i2 == 3) {
                    PbActivity pbActivity2 = this.bvg;
                    bvVar4 = this.bvg.buL;
                    pbActivity2.showNetRefreshView(bvVar4.getView(), this.bvg.getString(com.baidu.tieba.y.net_error_text, new Object[]{str, Integer.valueOf(i)}), true);
                    bvVar5 = this.bvg.buL;
                    bvVar5.Ym();
                }
            } else {
                this.bvg.showToast(str);
            }
            bvVar3 = this.bvg.buL;
            bvVar3.XT();
        }
        this.bvg.Zb = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.main.bq
    public void a(com.baidu.tieba.data.ah ahVar) {
        bv bvVar;
        bvVar = this.bvg.buL;
        bvVar.e(ahVar);
    }

    @Override // com.baidu.tieba.pb.main.bq
    public void dV(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bvg;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bvg.aAK;
        pbActivity.Zc = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
            pVar.dm(1001);
            pVar.YT = this.bvg.buE;
            j2 = this.bvg.createTime;
            pVar.YV = j2;
            j3 = this.bvg.Zc;
            pVar.Zc = j3;
            pVar.uH();
        }
    }

    @Override // com.baidu.tieba.pb.main.bq
    public void e(com.baidu.tbadk.performanceLog.p pVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (pVar != null) {
            j = this.bvg.createTime;
            pVar.YV = j;
            this.bvg.createTime = 0L;
            pVar.YT = this.bvg.buE;
            j2 = this.bvg.Zb;
            pVar.Zb = j2;
            j3 = this.bvg.Zc;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bvg.aAK;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bvg.Zc;
            }
            pVar.Zc = j4;
            pVar.uI();
        }
    }
}
