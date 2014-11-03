package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
class bc implements bq {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.bvu = pbActivity;
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
        this.bvu.buG = true;
        long currentTimeMillis = System.currentTimeMillis();
        bvVar = this.bvu.buZ;
        bvVar.XG();
        PbActivity pbActivity = this.bvu;
        bvVar2 = this.bvu.buZ;
        pbActivity.hideLoadingView(bvVar2.getView());
        if (i4 == 0 && ahVar != null) {
            this.bvu.aAt = true;
        }
        if (z && ahVar != null) {
            bvVar6 = this.bvu.buZ;
            bvVar6.Gq();
            bvVar7 = this.bvu.buZ;
            bvVar7.Yo();
            TbadkApplication.m251getInst().setDefaultBubble(ahVar.getUserData().getBimg_url());
            TbadkApplication.m251getInst().setDefaultBubbleEndTime(ahVar.getUserData().getBimg_end_time());
            bvVar8 = this.bvu.buZ;
            if (bvVar8.EQ() != null) {
                bvVar14 = this.bvu.buZ;
                bvVar14.EQ().refresh();
            }
            ajVar = this.bvu.buV;
            ajVar.bs(ahVar.zP());
            bvVar9 = this.bvu.buZ;
            bnVar = this.bvu.buU;
            bvVar9.a(ahVar, i2, i3, bnVar.WJ(), i4);
            bvVar10 = this.bvu.buZ;
            bnVar2 = this.bvu.buU;
            bvVar10.a(ahVar, bnVar2.WJ(), false, i2);
            bvVar11 = this.bvu.buZ;
            bnVar3 = this.bvu.buU;
            bvVar11.ei(bnVar3.getHostMode());
            this.bvu.Wv();
            AntiData jZ = ahVar.jZ();
            if (jZ != null) {
                Boolean valueOf = Boolean.valueOf(jZ.isIfvoice());
                this.bvu.buT = jZ.getVoice_message();
                this.bvu.f(valueOf);
            }
            if (ahVar == null || ahVar.yW() != 1) {
                bvVar12 = this.bvu.buZ;
                bvVar12.ek(false);
            } else {
                bvVar13 = this.bvu.buZ;
                bvVar13.ek(true);
            }
        } else if (str != null) {
            if (i == 4 || i == 28) {
                this.bvu.finish();
            }
            z2 = this.bvu.aAt;
            if (!z2 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.bvu;
                    bvVar4 = this.bvu.buZ;
                    pbActivity2.showNetRefreshView(bvVar4.getView(), this.bvu.getString(com.baidu.tieba.y.net_error_text, new Object[]{str, Integer.valueOf(i)}), true);
                    bvVar5 = this.bvu.buZ;
                    bvVar5.Yp();
                }
            } else {
                this.bvu.showToast(str);
            }
            bvVar3 = this.bvu.buZ;
            bvVar3.XW();
        }
        this.bvu.Zf = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.main.bq
    public void a(com.baidu.tieba.data.ah ahVar) {
        bv bvVar;
        bvVar = this.bvu.buZ;
        bvVar.e(ahVar);
    }

    @Override // com.baidu.tieba.pb.main.bq
    public void dV(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.bvu;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.bvu.aAU;
        pbActivity.Zg = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
            pVar.dm(1001);
            pVar.YX = this.bvu.buS;
            j2 = this.bvu.createTime;
            pVar.YZ = j2;
            j3 = this.bvu.Zg;
            pVar.Zg = j3;
            pVar.uJ();
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
            j = this.bvu.createTime;
            pVar.YZ = j;
            this.bvu.createTime = 0L;
            pVar.YX = this.bvu.buS;
            j2 = this.bvu.Zf;
            pVar.Zf = j2;
            j3 = this.bvu.Zg;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.bvu.aAU;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.bvu.Zg;
            }
            pVar.Zg = j4;
            pVar.uK();
        }
    }
}
