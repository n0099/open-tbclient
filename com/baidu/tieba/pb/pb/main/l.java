package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.ca;
/* loaded from: classes.dex */
class l implements ca.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.ca.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        boolean z2;
        boolean z3;
        ct ctVar5;
        ct ctVar6;
        ct ctVar7;
        ct ctVar8;
        ct ctVar9;
        com.baidu.tbadk.editortools.c.e eVar;
        com.baidu.tbadk.editortools.c.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        ct ctVar10;
        boolean z4;
        ct ctVar11;
        ca caVar;
        ca caVar2;
        ct ctVar12;
        ca caVar3;
        ct ctVar13;
        ca caVar4;
        String str2;
        com.baidu.tbadk.editortools.c.e eVar3;
        com.baidu.tbadk.editortools.c.e eVar4;
        com.baidu.tbadk.editortools.c.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.c.e eVar6;
        com.baidu.tbadk.editortools.c.e eVar7;
        ct ctVar14;
        com.baidu.tbadk.editortools.c.e eVar8;
        ct ctVar15;
        this.cjN.cfC = true;
        long currentTimeMillis = System.currentTimeMillis();
        ctVar = this.cjN.cjo;
        ctVar.ahd();
        PbActivity pbActivity = this.cjN;
        ctVar2 = this.cjN.cjo;
        pbActivity.hideLoadingView(ctVar2.getView());
        ctVar3 = this.cjN.cjo;
        ctVar3.VM();
        ctVar4 = this.cjN.cjo;
        ctVar4.eS(false);
        z2 = this.cjN.asi;
        if (z2) {
            this.cjN.asi = false;
            ctVar15 = this.cjN.cjo;
            ctVar15.cly.cnk.setEnabled(true);
        }
        if (i4 == 0 && cVar != null) {
            this.cjN.aTP = true;
        }
        if (z && cVar != null) {
            ctVar9 = this.cjN.cjo;
            ctVar9.Mb();
            eVar = this.cjN.cjw;
            if (eVar != null) {
                ctVar14 = this.cjN.cjo;
                eVar8 = this.cjN.cjw;
                ctVar14.eQ(eVar8.Bf());
            }
            TbadkCoreApplication.m411getInst().setDefaultBubble(cVar.getUserData().getBimg_url());
            TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(cVar.getUserData().getBimg_end_time());
            eVar2 = this.cjN.cjw;
            if (eVar2 != null) {
                eVar6 = this.cjN.cjw;
                eVar6.a(cVar.rE());
                eVar7 = this.cjN.cjw;
                eVar7.a(cVar.afg(), cVar.getUserData());
            }
            aVar = this.cjN.cjk;
            if (aVar != null) {
                aVar2 = this.cjN.cjk;
                aVar2.ab(cVar.qi());
            }
            if (cVar == null || cVar.afm() != 1) {
                this.cjN.mIsFromCDN = false;
            } else {
                this.cjN.mIsFromCDN = true;
            }
            ctVar10 = this.cjN.cjo;
            z4 = this.cjN.mIsFromCDN;
            ctVar10.eR(z4);
            ctVar11 = this.cjN.cjo;
            caVar = this.cjN.cjj;
            boolean agm = caVar.agm();
            caVar2 = this.cjN.cjj;
            ctVar11.a(cVar, i2, i3, agm, i4, caVar2.getIsFromMark());
            ctVar12 = this.cjN.cjo;
            caVar3 = this.cjN.cjj;
            ctVar12.a(cVar, caVar3.agm(), false, i2);
            ctVar13 = this.cjN.cjo;
            caVar4 = this.cjN.cjj;
            ctVar13.eO(caVar4.getHostMode());
            this.cjN.afY();
            AntiData rE = cVar.rE();
            if (rE != null) {
                this.cjN.aqB = rE.getVoice_message();
                str2 = this.cjN.aqB;
                if (!StringUtils.isNull(str2)) {
                    eVar3 = this.cjN.cjw;
                    if (eVar3 != null) {
                        eVar4 = this.cjN.cjw;
                        if (eVar4.Az() != null) {
                            eVar5 = this.cjN.cjw;
                            com.baidu.tbadk.editortools.p dS = eVar5.Az().dS(6);
                            if (dS != null) {
                                str3 = this.cjN.aqB;
                                if (!TextUtils.isEmpty(str3)) {
                                    onClickListener = this.cjN.cjA;
                                    ((View) dS).setOnClickListener(onClickListener);
                                }
                            }
                        }
                    }
                }
            }
        } else if (str != null) {
            z3 = this.cjN.aTP;
            if (!z3 && i4 == 1) {
                if (i2 == 3 || i2 == 4 || i2 == 6) {
                    PbActivity pbActivity2 = this.cjN;
                    ctVar7 = this.cjN.cjo;
                    pbActivity2.showNetRefreshView(ctVar7.getView(), this.cjN.getPageContext().getResources().getString(i.h.net_error_text, str, Integer.valueOf(i)), true);
                    ctVar8 = this.cjN.cjo;
                    ctVar8.ahs();
                }
            } else {
                this.cjN.showToast(str);
            }
            ctVar5 = this.cjN.cjo;
            ctVar5.jT(this.cjN.getResources().getString(i.h.list_no_more));
            ctVar6 = this.cjN.cjo;
            ctVar6.vz();
        }
        this.cjN.awn = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // com.baidu.tieba.pb.pb.main.ca.a
    public void b(com.baidu.tieba.pb.a.c cVar) {
        ct ctVar;
        ctVar = this.cjN.cjo;
        ctVar.h(cVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.ca.a
    public void ex(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.cjN;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.cjN.aLR;
        pbActivity.awo = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ex(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.cjN.createTime;
            tVar.awh = j2;
            j3 = this.cjN.awo;
            tVar.awo = j3;
            tVar.DL();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.ca.a
    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (tVar != null) {
            j = this.cjN.createTime;
            tVar.awh = j;
            this.cjN.createTime = 0L;
            j2 = this.cjN.awn;
            tVar.awn = j2;
            j3 = this.cjN.awo;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.cjN.aLR;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.cjN.awo;
            }
            tVar.awo = j4;
            tVar.DM();
        }
    }
}
