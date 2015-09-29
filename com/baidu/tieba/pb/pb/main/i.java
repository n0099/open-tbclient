package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.bl;
/* loaded from: classes.dex */
class i implements bl.a {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bl.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4) {
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        cc ccVar4;
        boolean z2;
        boolean z3;
        cc ccVar5;
        cc ccVar6;
        cc ccVar7;
        cc ccVar8;
        cc ccVar9;
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        cc ccVar10;
        boolean z4;
        cc ccVar11;
        bl blVar;
        bl blVar2;
        cc ccVar12;
        bl blVar3;
        cc ccVar13;
        bl blVar4;
        String str2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tbadk.editortools.c.d dVar4;
        com.baidu.tbadk.editortools.c.d dVar5;
        String str3;
        View.OnClickListener onClickListener;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.c.d dVar6;
        com.baidu.tbadk.editortools.c.d dVar7;
        cc ccVar14;
        com.baidu.tbadk.editortools.c.d dVar8;
        cc ccVar15;
        this.ciz.ceQ = true;
        long currentTimeMillis = System.currentTimeMillis();
        ccVar = this.ciz.cia;
        ccVar.agB();
        PbActivity pbActivity = this.ciz;
        ccVar2 = this.ciz.cia;
        pbActivity.hideLoadingView(ccVar2.getView());
        ccVar3 = this.ciz.cia;
        ccVar3.Vv();
        ccVar4 = this.ciz.cia;
        ccVar4.eP(false);
        z2 = this.ciz.att;
        if (z2) {
            this.ciz.att = false;
            ccVar15 = this.ciz.cia;
            ccVar15.cka.clK.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.ciz.aTw = true;
        }
        if (z && bVar != null) {
            ccVar9 = this.ciz.cia;
            ccVar9.LP();
            dVar = this.ciz.cij;
            if (dVar != null) {
                ccVar14 = this.ciz.cia;
                dVar8 = this.ciz.cij;
                ccVar14.eN(dVar8.Br());
            }
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            dVar2 = this.ciz.cij;
            if (dVar2 != null) {
                dVar6 = this.ciz.cij;
                dVar6.a(bVar.rF());
                dVar7 = this.ciz.cij;
                dVar7.a(bVar.aeN(), bVar.getUserData());
            }
            aVar = this.ciz.chW;
            if (aVar != null) {
                aVar2 = this.ciz.chW;
                aVar2.ab(bVar.qk());
            }
            if (bVar == null || bVar.aeT() != 1) {
                this.ciz.mIsFromCDN = false;
            } else {
                this.ciz.mIsFromCDN = true;
            }
            ccVar10 = this.ciz.cia;
            z4 = this.ciz.mIsFromCDN;
            ccVar10.eO(z4);
            ccVar11 = this.ciz.cia;
            blVar = this.ciz.chV;
            boolean afL = blVar.afL();
            blVar2 = this.ciz.chV;
            ccVar11.a(bVar, i2, i3, afL, i4, blVar2.getIsFromMark());
            ccVar12 = this.ciz.cia;
            blVar3 = this.ciz.chV;
            ccVar12.a(bVar, blVar3.afL(), false, i2);
            ccVar13 = this.ciz.cia;
            blVar4 = this.ciz.chV;
            ccVar13.eL(blVar4.getHostMode());
            this.ciz.afy();
            AntiData rF = bVar.rF();
            if (rF != null) {
                this.ciz.asb = rF.getVoice_message();
                str2 = this.ciz.asb;
                if (!StringUtils.isNull(str2)) {
                    dVar3 = this.ciz.cij;
                    if (dVar3 != null) {
                        dVar4 = this.ciz.cij;
                        if (dVar4.Ax() != null) {
                            dVar5 = this.ciz.cij;
                            com.baidu.tbadk.editortools.p dS = dVar5.Ax().dS(6);
                            if (dS != null) {
                                str3 = this.ciz.asb;
                                if (!TextUtils.isEmpty(str3)) {
                                    onClickListener = this.ciz.cim;
                                    ((View) dS).setOnClickListener(onClickListener);
                                }
                            }
                        }
                    }
                }
            }
        } else if (str != null) {
            z3 = this.ciz.aTw;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.ciz;
                    ccVar7 = this.ciz.cia;
                    pbActivity2.showNetRefreshView(ccVar7.getView(), this.ciz.getPageContext().getResources().getString(i.h.net_error_text, str, Integer.valueOf(i)), true);
                    ccVar8 = this.ciz.cia;
                    ccVar8.agQ();
                }
            } else {
                this.ciz.showToast(str);
            }
            ccVar5 = this.ciz.cia;
            ccVar5.jQ(this.ciz.getResources().getString(i.h.list_no_more));
            ccVar6 = this.ciz.cia;
            ccVar6.vy();
        }
        this.ciz.axx = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bl.a
    public void b(com.baidu.tieba.pb.a.b bVar) {
        cc ccVar;
        ccVar = this.ciz.cia;
        ccVar.h(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bl.a
    public void eu(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.ciz;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ciz.aLy;
        pbActivity.axy = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.ciz.createTime;
            tVar.axr = j2;
            j3 = this.ciz.axy;
            tVar.axy = j3;
            tVar.DV();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.bl.a
    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (tVar != null) {
            j = this.ciz.createTime;
            tVar.axr = j;
            this.ciz.createTime = 0L;
            j2 = this.ciz.axx;
            tVar.axx = j2;
            j3 = this.ciz.axy;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.ciz.aLy;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.ciz.axy;
            }
            tVar.axy = j4;
            tVar.DW();
        }
    }
}
