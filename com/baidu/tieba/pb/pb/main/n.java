package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cf;
/* loaded from: classes.dex */
class n implements cf.c {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cf.c
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4) {
        dk dkVar;
        dk dkVar2;
        dk dkVar3;
        dk dkVar4;
        boolean z2;
        boolean z3;
        dk dkVar5;
        dk dkVar6;
        dk dkVar7;
        dk dkVar8;
        dk dkVar9;
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        dk dkVar10;
        boolean z4;
        dk dkVar11;
        cf cfVar;
        cf cfVar2;
        dk dkVar12;
        cf cfVar3;
        dk dkVar13;
        cf cfVar4;
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
        cf cfVar5;
        cf cfVar6;
        cf cfVar7;
        cf cfVar8;
        dk dkVar14;
        com.baidu.tbadk.editortools.d.e eVar9;
        dk dkVar15;
        cf cfVar9;
        if (cVar == null || cVar.akI() == null || cVar.akI().size() >= 1) {
            this.cFS.cBJ = true;
            long currentTimeMillis = System.currentTimeMillis();
            dkVar = this.cFS.cFq;
            dkVar.amN();
            PbActivity pbActivity = this.cFS;
            dkVar2 = this.cFS.cFq;
            pbActivity.hideLoadingView(dkVar2.getView());
            dkVar3 = this.cFS.cFq;
            dkVar3.ZX();
            dkVar4 = this.cFS.cFq;
            dkVar4.fv(false);
            z2 = this.cFS.mIsLoading;
            if (z2) {
                this.cFS.mIsLoading = false;
                dkVar15 = this.cFS.cFq;
                dkVar15.cIl.cKu.setEnabled(true);
            }
            if (i4 == 0 && cVar != null) {
                this.cFS.bcZ = true;
            }
            if (z && cVar != null) {
                dkVar9 = this.cFS.cFq;
                dkVar9.NV();
                eVar = this.cFS.cFx;
                if (eVar != null) {
                    dkVar14 = this.cFS.cFq;
                    eVar9 = this.cFS.cFx;
                    dkVar14.ft(eVar9.BU());
                }
                TbadkCoreApplication.m411getInst().setDefaultBubble(cVar.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(cVar.getUserData().getBimg_end_time());
                if (cVar.akI() != null && cVar.akI().size() >= 1 && cVar.akI().get(0) != null) {
                    String id = cVar.akI().get(0).getId();
                    cfVar8 = this.cFS.cFl;
                    cfVar8.kD(id);
                }
                eVar2 = this.cFS.cFx;
                if (eVar2 != null) {
                    eVar6 = this.cFS.cFx;
                    eVar6.a(cVar.rI());
                    eVar7 = this.cFS.cFx;
                    eVar7.a(cVar.akG(), cVar.getUserData());
                    eVar8 = this.cFS.cFx;
                    cfVar5 = this.cFS.cFl;
                    MetaData alT = cfVar5.alT();
                    cfVar6 = this.cFS.cFl;
                    String threadID = cfVar6.getThreadID();
                    cfVar7 = this.cFS.cFl;
                    eVar8.a(alT, threadID, cfVar7.alI());
                }
                aVar = this.cFS.cFm;
                if (aVar != null) {
                    aVar2 = this.cFS.cFm;
                    aVar2.Y(cVar.pN());
                }
                if (cVar == null || cVar.akM() != 1) {
                    this.cFS.mIsFromCDN = false;
                } else {
                    this.cFS.mIsFromCDN = true;
                }
                dkVar10 = this.cFS.cFq;
                z4 = this.cFS.mIsFromCDN;
                dkVar10.fu(z4);
                dkVar11 = this.cFS.cFq;
                cfVar = this.cFS.cFl;
                boolean alM = cfVar.alM();
                cfVar2 = this.cFS.cFl;
                dkVar11.a(cVar, i2, i3, alM, i4, cfVar2.getIsFromMark());
                dkVar12 = this.cFS.cFq;
                cfVar3 = this.cFS.cFl;
                dkVar12.a(cVar, cfVar3.alM(), false, i2);
                dkVar13 = this.cFS.cFq;
                cfVar4 = this.cFS.cFl;
                dkVar13.fr(cfVar4.getHostMode());
                this.cFS.alx();
                AntiData rI = cVar.rI();
                if (rI != null) {
                    this.cFS.auj = rI.getVoice_message();
                    str2 = this.cFS.auj;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.cFS.cFx;
                        if (eVar3 != null) {
                            eVar4 = this.cFS.cFx;
                            if (eVar4.Bj() != null) {
                                eVar5 = this.cFS.cFx;
                                com.baidu.tbadk.editortools.r ea = eVar5.Bj().ea(6);
                                if (ea != null) {
                                    str3 = this.cFS.auj;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.cFS.cFC;
                                        ((View) ea).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (str != null) {
                z3 = this.cFS.bcZ;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        PbActivity pbActivity2 = this.cFS;
                        dkVar7 = this.cFS.cFq;
                        pbActivity2.showNetRefreshView(dkVar7.getView(), this.cFS.getPageContext().getResources().getString(n.j.net_error_text, str, Integer.valueOf(i)), true);
                        dkVar8 = this.cFS.cFq;
                        dkVar8.ane();
                    }
                } else {
                    this.cFS.showToast(str);
                }
                dkVar5 = this.cFS.cFq;
                dkVar5.kI(this.cFS.getResources().getString(n.j.list_no_more));
                dkVar6 = this.cFS.cFq;
                dkVar6.vP();
            }
            this.cFS.azV = System.currentTimeMillis() - currentTimeMillis;
            return;
        }
        cfVar9 = this.cFS.cFl;
        cfVar9.kq(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.cf.c
    public void b(com.baidu.tieba.pb.a.c cVar) {
        dk dkVar;
        dkVar = this.cFS.cFq;
        dkVar.i(cVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.cf.c
    public void eZ(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.cFS;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.cFS.aUp;
        pbActivity.azW = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eF(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.cFS.createTime;
            tVar.azP = j2;
            j3 = this.cFS.azW;
            tVar.azW = j3;
            tVar.EB();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cf.c
    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (tVar != null) {
            j = this.cFS.createTime;
            tVar.azP = j;
            this.cFS.createTime = 0L;
            j2 = this.cFS.azV;
            tVar.azV = j2;
            j3 = this.cFS.azW;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.cFS.aUp;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.cFS.azW;
            }
            tVar.azW = j4;
            tVar.EC();
        }
    }
}
