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
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.ciK = pbActivity;
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
        this.ciK.cfb = true;
        long currentTimeMillis = System.currentTimeMillis();
        ccVar = this.ciK.cim;
        ccVar.agB();
        PbActivity pbActivity = this.ciK;
        ccVar2 = this.ciK.cim;
        pbActivity.hideLoadingView(ccVar2.getView());
        ccVar3 = this.ciK.cim;
        ccVar3.Vv();
        ccVar4 = this.ciK.cim;
        ccVar4.eP(false);
        z2 = this.ciK.atu;
        if (z2) {
            this.ciK.atu = false;
            ccVar15 = this.ciK.cim;
            ccVar15.ckl.clV.setEnabled(true);
        }
        if (i4 == 0 && bVar != null) {
            this.ciK.aTH = true;
        }
        if (z && bVar != null) {
            ccVar9 = this.ciK.cim;
            ccVar9.LP();
            dVar = this.ciK.ciu;
            if (dVar != null) {
                ccVar14 = this.ciK.cim;
                dVar8 = this.ciK.ciu;
                ccVar14.eN(dVar8.Br());
            }
            TbadkCoreApplication.m411getInst().setDefaultBubble(bVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(bVar.getUserData().getBimg_end_time());
            dVar2 = this.ciK.ciu;
            if (dVar2 != null) {
                dVar6 = this.ciK.ciu;
                dVar6.a(bVar.rF());
                dVar7 = this.ciK.ciu;
                dVar7.a(bVar.aeN(), bVar.getUserData());
            }
            aVar = this.ciK.cii;
            if (aVar != null) {
                aVar2 = this.ciK.cii;
                aVar2.ab(bVar.qk());
            }
            if (bVar == null || bVar.aeT() != 1) {
                this.ciK.mIsFromCDN = false;
            } else {
                this.ciK.mIsFromCDN = true;
            }
            ccVar10 = this.ciK.cim;
            z4 = this.ciK.mIsFromCDN;
            ccVar10.eO(z4);
            ccVar11 = this.ciK.cim;
            blVar = this.ciK.cih;
            boolean afL = blVar.afL();
            blVar2 = this.ciK.cih;
            ccVar11.a(bVar, i2, i3, afL, i4, blVar2.getIsFromMark());
            ccVar12 = this.ciK.cim;
            blVar3 = this.ciK.cih;
            ccVar12.a(bVar, blVar3.afL(), false, i2);
            ccVar13 = this.ciK.cim;
            blVar4 = this.ciK.cih;
            ccVar13.eL(blVar4.getHostMode());
            this.ciK.afy();
            AntiData rF = bVar.rF();
            if (rF != null) {
                this.ciK.asc = rF.getVoice_message();
                str2 = this.ciK.asc;
                if (!StringUtils.isNull(str2)) {
                    dVar3 = this.ciK.ciu;
                    if (dVar3 != null) {
                        dVar4 = this.ciK.ciu;
                        if (dVar4.Ax() != null) {
                            dVar5 = this.ciK.ciu;
                            com.baidu.tbadk.editortools.p dS = dVar5.Ax().dS(6);
                            if (dS != null) {
                                str3 = this.ciK.asc;
                                if (!TextUtils.isEmpty(str3)) {
                                    onClickListener = this.ciK.cix;
                                    ((View) dS).setOnClickListener(onClickListener);
                                }
                            }
                        }
                    }
                }
            }
        } else if (str != null) {
            z3 = this.ciK.aTH;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.ciK;
                    ccVar7 = this.ciK.cim;
                    pbActivity2.showNetRefreshView(ccVar7.getView(), this.ciK.getPageContext().getResources().getString(i.h.net_error_text, str, Integer.valueOf(i)), true);
                    ccVar8 = this.ciK.cim;
                    ccVar8.agQ();
                }
            } else {
                this.ciK.showToast(str);
            }
            ccVar5 = this.ciK.cim;
            ccVar5.jQ(this.ciK.getResources().getString(i.h.list_no_more));
            ccVar6 = this.ciK.cim;
            ccVar6.vy();
        }
        this.ciK.axy = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.bl.a
    public void b(com.baidu.tieba.pb.a.b bVar) {
        cc ccVar;
        ccVar = this.ciK.cim;
        ccVar.h(bVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.bl.a
    public void eu(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.ciK;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ciK.aLJ;
        pbActivity.axz = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.ciK.createTime;
            tVar.axs = j2;
            j3 = this.ciK.axz;
            tVar.axz = j3;
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
            j = this.ciK.createTime;
            tVar.axs = j;
            this.ciK.createTime = 0L;
            j2 = this.ciK.axy;
            tVar.axy = j2;
            j3 = this.ciK.axz;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.ciK.aLJ;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.ciK.axz;
            }
            tVar.axz = j4;
            tVar.DW();
        }
    }
}
