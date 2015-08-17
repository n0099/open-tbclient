package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.bk;
/* loaded from: classes.dex */
class i implements bk.a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bk.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4) {
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        boolean z2;
        boolean z3;
        cb cbVar4;
        cb cbVar5;
        cb cbVar6;
        cb cbVar7;
        cb cbVar8;
        com.baidu.tbadk.editortools.c.d dVar;
        cb cbVar9;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        cb cbVar10;
        boolean z4;
        cb cbVar11;
        bk bkVar;
        bk bkVar2;
        cb cbVar12;
        bk bkVar3;
        cb cbVar13;
        bk bkVar4;
        String str2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tbadk.editortools.c.d dVar4;
        com.baidu.tbadk.editortools.c.d dVar5;
        String str3;
        View.OnClickListener onClickListener;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.c.d dVar6;
        com.baidu.tbadk.editortools.c.d dVar7;
        cb cbVar14;
        com.baidu.tbadk.editortools.c.d dVar8;
        cb cbVar15;
        this.cbo.bYO = true;
        long currentTimeMillis = System.currentTimeMillis();
        cbVar = this.cbo.caQ;
        cbVar.aep();
        PbActivity pbActivity = this.cbo;
        cbVar2 = this.cbo.caQ;
        pbActivity.hideLoadingView(cbVar2.getView());
        cbVar3 = this.cbo.caQ;
        cbVar3.UK();
        z2 = this.cbo.atm;
        if (z2) {
            this.cbo.atm = false;
            cbVar15 = this.cbo.caQ;
            cbVar15.cdM.cfs.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.cbo.aUm = true;
        }
        if (z && bVar != null) {
            cbVar8 = this.cbo.caQ;
            cbVar8.LZ();
            dVar = this.cbo.caX;
            if (dVar != null) {
                cbVar14 = this.cbo.caQ;
                dVar8 = this.cbo.caX;
                cbVar14.eA(dVar8.Br());
            }
            cbVar9 = this.cbo.caQ;
            cbVar9.eC(false);
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            dVar2 = this.cbo.caX;
            if (dVar2 != null) {
                dVar6 = this.cbo.caX;
                dVar6.a(bVar.rM());
                dVar7 = this.cbo.caX;
                dVar7.a(bVar.acG(), bVar.getUserData());
            }
            aVar = this.cbo.caM;
            if (aVar != null) {
                aVar2 = this.cbo.caM;
                aVar2.ab(bVar.qr());
            }
            if (bVar == null || bVar.acL() != 1) {
                this.cbo.mIsFromCDN = false;
            } else {
                this.cbo.mIsFromCDN = true;
            }
            cbVar10 = this.cbo.caQ;
            z4 = this.cbo.mIsFromCDN;
            cbVar10.eB(z4);
            cbVar11 = this.cbo.caQ;
            bkVar = this.cbo.caL;
            boolean ady = bkVar.ady();
            bkVar2 = this.cbo.caL;
            cbVar11.a(bVar, i2, i3, ady, i4, bkVar2.getIsFromMark());
            cbVar12 = this.cbo.caQ;
            bkVar3 = this.cbo.caL;
            cbVar12.a(bVar, bkVar3.ady(), false, i2);
            cbVar13 = this.cbo.caQ;
            bkVar4 = this.cbo.caL;
            cbVar13.ey(bkVar4.getHostMode());
            this.cbo.adn();
            AntiData rM = bVar.rM();
            if (rM != null) {
                this.cbo.arU = rM.getVoice_message();
                str2 = this.cbo.arU;
                if (!StringUtils.isNull(str2)) {
                    dVar3 = this.cbo.caX;
                    if (dVar3 != null) {
                        dVar4 = this.cbo.caX;
                        if (dVar4.Ay() != null) {
                            dVar5 = this.cbo.caX;
                            com.baidu.tbadk.editortools.p dJ = dVar5.Ay().dJ(6);
                            if (dJ != null) {
                                str3 = this.cbo.arU;
                                if (!TextUtils.isEmpty(str3)) {
                                    onClickListener = this.cbo.cba;
                                    ((View) dJ).setOnClickListener(onClickListener);
                                }
                            }
                        }
                    }
                }
            }
        } else if (str != null) {
            z3 = this.cbo.aUm;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.cbo;
                    cbVar6 = this.cbo.caQ;
                    pbActivity2.showNetRefreshView(cbVar6.getView(), this.cbo.getPageContext().getResources().getString(i.C0057i.net_error_text, str, Integer.valueOf(i)), true);
                    cbVar7 = this.cbo.caQ;
                    cbVar7.aeE();
                }
            } else {
                this.cbo.showToast(str);
            }
            cbVar4 = this.cbo.caQ;
            cbVar4.jo(this.cbo.getResources().getString(i.C0057i.list_no_more));
            cbVar5 = this.cbo.caQ;
            cbVar5.vB();
        }
        this.cbo.axq = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bk.a
    public void a(com.baidu.tieba.pb.a.b bVar) {
        cb cbVar;
        cbVar = this.cbo.caQ;
        cbVar.h(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bk.a
    public void ef(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.cbo;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.cbo.aMq;
        pbActivity.axr = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.cbo.createTime;
            tVar.axk = j2;
            j3 = this.cbo.axr;
            tVar.axr = j3;
            tVar.DY();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.bk.a
    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (tVar != null) {
            j = this.cbo.createTime;
            tVar.axk = j;
            this.cbo.createTime = 0L;
            j2 = this.cbo.axq;
            tVar.axq = j2;
            j3 = this.cbo.axr;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.cbo.aMq;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.cbo.axr;
            }
            tVar.axr = j4;
            tVar.DZ();
        }
    }
}
