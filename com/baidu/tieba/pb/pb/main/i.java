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
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.ccj = pbActivity;
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
        this.ccj.bZI = true;
        long currentTimeMillis = System.currentTimeMillis();
        cbVar = this.ccj.cbL;
        cbVar.aeD();
        PbActivity pbActivity = this.ccj;
        cbVar2 = this.ccj.cbL;
        pbActivity.hideLoadingView(cbVar2.getView());
        cbVar3 = this.ccj.cbL;
        cbVar3.UM();
        z2 = this.ccj.auW;
        if (z2) {
            this.ccj.auW = false;
            cbVar15 = this.ccj.cbL;
            cbVar15.ceJ.cgp.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.ccj.aUA = true;
        }
        if (z && bVar != null) {
            cbVar8 = this.ccj.cbL;
            cbVar8.LQ();
            dVar = this.ccj.cbS;
            if (dVar != null) {
                cbVar14 = this.ccj.cbL;
                dVar8 = this.ccj.cbS;
                cbVar14.eI(dVar8.BE());
            }
            cbVar9 = this.ccj.cbL;
            cbVar9.eK(false);
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            dVar2 = this.ccj.cbS;
            if (dVar2 != null) {
                dVar6 = this.ccj.cbS;
                dVar6.a(bVar.rK());
                dVar7 = this.ccj.cbS;
                dVar7.a(bVar.acP(), bVar.getUserData());
            }
            aVar = this.ccj.cbH;
            if (aVar != null) {
                aVar2 = this.ccj.cbH;
                aVar2.ab(bVar.qo());
            }
            if (bVar == null || bVar.acV() != 1) {
                this.ccj.mIsFromCDN = false;
            } else {
                this.ccj.mIsFromCDN = true;
            }
            cbVar10 = this.ccj.cbL;
            z4 = this.ccj.mIsFromCDN;
            cbVar10.eJ(z4);
            cbVar11 = this.ccj.cbL;
            bkVar = this.ccj.cbG;
            boolean adM = bkVar.adM();
            bkVar2 = this.ccj.cbG;
            cbVar11.a(bVar, i2, i3, adM, i4, bkVar2.getIsFromMark());
            cbVar12 = this.ccj.cbL;
            bkVar3 = this.ccj.cbG;
            cbVar12.a(bVar, bkVar3.adM(), false, i2);
            cbVar13 = this.ccj.cbL;
            bkVar4 = this.ccj.cbG;
            cbVar13.eG(bkVar4.getHostMode());
            this.ccj.adA();
            AntiData rK = bVar.rK();
            if (rK != null) {
                this.ccj.atE = rK.getVoice_message();
                str2 = this.ccj.atE;
                if (!StringUtils.isNull(str2)) {
                    dVar3 = this.ccj.cbS;
                    if (dVar3 != null) {
                        dVar4 = this.ccj.cbS;
                        if (dVar4.AL() != null) {
                            dVar5 = this.ccj.cbS;
                            com.baidu.tbadk.editortools.p dR = dVar5.AL().dR(6);
                            if (dR != null) {
                                str3 = this.ccj.atE;
                                if (!TextUtils.isEmpty(str3)) {
                                    onClickListener = this.ccj.cbV;
                                    ((View) dR).setOnClickListener(onClickListener);
                                }
                            }
                        }
                    }
                }
            }
        } else if (str != null) {
            z3 = this.ccj.aUA;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.ccj;
                    cbVar6 = this.ccj.cbL;
                    pbActivity2.showNetRefreshView(cbVar6.getView(), this.ccj.getPageContext().getResources().getString(i.h.net_error_text, str, Integer.valueOf(i)), true);
                    cbVar7 = this.ccj.cbL;
                    cbVar7.aeS();
                }
            } else {
                this.ccj.showToast(str);
            }
            cbVar4 = this.ccj.cbL;
            cbVar4.jw(this.ccj.getResources().getString(i.h.list_no_more));
            cbVar5 = this.ccj.cbL;
            cbVar5.vG();
        }
        this.ccj.ayY = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bk.a
    public void a(com.baidu.tieba.pb.a.b bVar) {
        cb cbVar;
        cbVar = this.ccj.cbL;
        cbVar.h(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bk.a
    public void em(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.ccj;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ccj.aMD;
        pbActivity.ayZ = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ey(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.ccj.createTime;
            tVar.ayS = j2;
            j3 = this.ccj.ayZ;
            tVar.ayZ = j3;
            tVar.Ei();
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
            j = this.ccj.createTime;
            tVar.ayS = j;
            this.ccj.createTime = 0L;
            j2 = this.ccj.ayY;
            tVar.ayY = j2;
            j3 = this.ccj.ayZ;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.ccj.aMD;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.ccj.ayZ;
            }
            tVar.ayZ = j4;
            tVar.Ej();
        }
    }
}
