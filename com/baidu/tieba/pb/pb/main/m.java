package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cc;
/* loaded from: classes.dex */
class m implements cc.b {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cc.b
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4) {
        da daVar;
        da daVar2;
        da daVar3;
        da daVar4;
        boolean z2;
        boolean z3;
        da daVar5;
        da daVar6;
        da daVar7;
        da daVar8;
        da daVar9;
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        da daVar10;
        boolean z4;
        da daVar11;
        cc ccVar;
        cc ccVar2;
        da daVar12;
        cc ccVar3;
        da daVar13;
        cc ccVar4;
        String str2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.editortools.d.e eVar4;
        com.baidu.tbadk.editortools.d.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.d.e eVar6;
        com.baidu.tbadk.editortools.d.e eVar7;
        com.baidu.tbadk.editortools.d.e eVar8;
        cc ccVar5;
        cc ccVar6;
        cc ccVar7;
        cc ccVar8;
        da daVar14;
        com.baidu.tbadk.editortools.d.e eVar9;
        da daVar15;
        this.cCm.cyc = true;
        long currentTimeMillis = System.currentTimeMillis();
        daVar = this.cCm.cBL;
        daVar.alB();
        PbActivity pbActivity = this.cCm;
        daVar2 = this.cCm.cBL;
        pbActivity.hideLoadingView(daVar2.getView());
        daVar3 = this.cCm.cBL;
        daVar3.YS();
        daVar4 = this.cCm.cBL;
        daVar4.fw(false);
        z2 = this.cCm.mIsLoading;
        if (z2) {
            this.cCm.mIsLoading = false;
            daVar15 = this.cCm.cBL;
            daVar15.cEm.cGv.setEnabled(true);
        }
        if (i4 == 0 && cVar != null) {
            this.cCm.aZd = true;
        }
        if (z && cVar != null) {
            daVar9 = this.cCm.cBL;
            daVar9.NC();
            eVar = this.cCm.cBS;
            if (eVar != null) {
                daVar14 = this.cCm.cBL;
                eVar9 = this.cCm.cBS;
                daVar14.fu(eVar9.Cf());
            }
            TbadkCoreApplication.m411getInst().setDefaultBubble(cVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(cVar.getUserData().getBimg_end_time());
            if (cVar.ajA() != null && cVar.ajA().size() >= 1 && cVar.ajA().get(0) != null) {
                String id = cVar.ajA().get(0).getId();
                ccVar8 = this.cCm.cBG;
                ccVar8.kF(id);
            }
            eVar2 = this.cCm.cBS;
            if (eVar2 != null) {
                eVar6 = this.cCm.cBS;
                eVar6.a(cVar.rZ());
                eVar7 = this.cCm.cBS;
                eVar7.a(cVar.ajy(), cVar.getUserData());
                eVar8 = this.cCm.cBS;
                ccVar5 = this.cCm.cBG;
                MetaData akM = ccVar5.akM();
                ccVar6 = this.cCm.cBG;
                String threadID = ccVar6.getThreadID();
                ccVar7 = this.cCm.cBG;
                eVar8.a(akM, threadID, ccVar7.akB());
            }
            aVar = this.cCm.cBH;
            if (aVar != null) {
                aVar2 = this.cCm.cBH;
                aVar2.ab(cVar.qp());
            }
            if (cVar == null || cVar.ajE() != 1) {
                this.cCm.mIsFromCDN = false;
            } else {
                this.cCm.mIsFromCDN = true;
            }
            daVar10 = this.cCm.cBL;
            z4 = this.cCm.mIsFromCDN;
            daVar10.fv(z4);
            daVar11 = this.cCm.cBL;
            ccVar = this.cCm.cBG;
            boolean akF = ccVar.akF();
            ccVar2 = this.cCm.cBG;
            daVar11.a(cVar, i2, i3, akF, i4, ccVar2.getIsFromMark());
            daVar12 = this.cCm.cBL;
            ccVar3 = this.cCm.cBG;
            daVar12.a(cVar, ccVar3.akF(), false, i2);
            daVar13 = this.cCm.cBL;
            ccVar4 = this.cCm.cBG;
            daVar13.fs(ccVar4.getHostMode());
            this.cCm.akq();
            AntiData rZ = cVar.rZ();
            if (rZ != null) {
                this.cCm.asF = rZ.getVoice_message();
                str2 = this.cCm.asF;
                if (!StringUtils.isNull(str2)) {
                    eVar3 = this.cCm.cBS;
                    if (eVar3 != null) {
                        eVar4 = this.cCm.cBS;
                        if (eVar4.Bu() != null) {
                            eVar5 = this.cCm.cBS;
                            com.baidu.tbadk.editortools.r eg = eVar5.Bu().eg(6);
                            if (eg != null) {
                                str3 = this.cCm.asF;
                                if (!TextUtils.isEmpty(str3)) {
                                    onClickListener = this.cCm.cBW;
                                    ((View) eg).setOnClickListener(onClickListener);
                                }
                            }
                        }
                    }
                }
            }
        } else if (str != null) {
            z3 = this.cCm.aZd;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.cCm;
                    daVar7 = this.cCm.cBL;
                    pbActivity2.showNetRefreshView(daVar7.getView(), this.cCm.getPageContext().getResources().getString(n.i.net_error_text, str, Integer.valueOf(i)), true);
                    daVar8 = this.cCm.cBL;
                    daVar8.alS();
                }
            } else {
                this.cCm.showToast(str);
            }
            daVar5 = this.cCm.cBL;
            daVar5.kK(this.cCm.getResources().getString(n.i.list_no_more));
            daVar6 = this.cCm.cBL;
            daVar6.wf();
        }
        this.cCm.ays = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.cc.b
    public void b(com.baidu.tieba.pb.a.c cVar) {
        da daVar;
        daVar = this.cCm.cBL;
        daVar.i(cVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.cc.b
    public void fa(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.cCm;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.cCm.aQy;
        pbActivity.ayt = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eL(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.cCm.createTime;
            tVar.aym = j2;
            j3 = this.cCm.ayt;
            tVar.ayt = j3;
            tVar.EM();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cc.b
    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (tVar != null) {
            j = this.cCm.createTime;
            tVar.aym = j;
            this.cCm.createTime = 0L;
            j2 = this.cCm.ays;
            tVar.ays = j2;
            j3 = this.cCm.ayt;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.cCm.aQy;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.cCm.ayt;
            }
            tVar.ayt = j4;
            tVar.EN();
        }
    }
}
