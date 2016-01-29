package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class q implements cm.c {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4) {
        dz dzVar;
        dz dzVar2;
        dz dzVar3;
        dz dzVar4;
        boolean z2;
        boolean z3;
        dz dzVar5;
        dz dzVar6;
        dz dzVar7;
        dz dzVar8;
        dz dzVar9;
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        dz dzVar10;
        boolean z4;
        dz dzVar11;
        cm cmVar;
        boolean z5;
        boolean z6;
        boolean z7;
        cm cmVar2;
        dz dzVar12;
        cm cmVar3;
        cm cmVar4;
        dz dzVar13;
        cm cmVar5;
        dz dzVar14;
        cm cmVar6;
        String str2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.editortools.d.e eVar4;
        com.baidu.tbadk.editortools.d.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        cm cmVar7;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.d.e eVar6;
        com.baidu.tbadk.editortools.d.e eVar7;
        com.baidu.tbadk.editortools.d.e eVar8;
        cm cmVar8;
        cm cmVar9;
        cm cmVar10;
        cm cmVar11;
        dz dzVar15;
        com.baidu.tbadk.editortools.d.e eVar9;
        dz dzVar16;
        cm cmVar12;
        if (cVar == null || cVar.aoG() == null || cVar.aoG().size() >= 1) {
            this.cNq.cIp = true;
            long currentTimeMillis = System.currentTimeMillis();
            dzVar = this.cNq.cMK;
            dzVar.ark();
            PbActivity pbActivity = this.cNq;
            dzVar2 = this.cNq.cMK;
            pbActivity.hideLoadingView(dzVar2.getView());
            dzVar3 = this.cNq.cMK;
            dzVar3.acL();
            dzVar4 = this.cNq.cMK;
            dzVar4.eq(false);
            z2 = this.cNq.mIsLoading;
            if (z2) {
                this.cNq.mIsLoading = false;
                dzVar16 = this.cNq.cMK;
                dzVar16.cQn.cSM.setEnabled(true);
            }
            if (i4 == 0 && cVar != null) {
                this.cNq.bfq = true;
            }
            if (z && cVar != null) {
                dzVar9 = this.cNq.cMK;
                dzVar9.KZ();
                eVar = this.cNq.cMU;
                if (eVar != null) {
                    dzVar15 = this.cNq.cMK;
                    eVar9 = this.cNq.cMU;
                    dzVar15.ep(eVar9.Dk());
                }
                TbadkCoreApplication.m411getInst().setDefaultBubble(cVar.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(cVar.getUserData().getBimg_end_time());
                if (cVar.aoG() != null && cVar.aoG().size() >= 1 && cVar.aoG().get(0) != null) {
                    String id = cVar.aoG().get(0).getId();
                    cmVar11 = this.cNq.cMF;
                    cmVar11.kI(id);
                }
                eVar2 = this.cNq.cMU;
                if (eVar2 != null) {
                    eVar6 = this.cNq.cMU;
                    eVar6.a(cVar.so());
                    eVar7 = this.cNq.cMU;
                    eVar7.a(cVar.aoE(), cVar.getUserData());
                    eVar8 = this.cNq.cMU;
                    cmVar8 = this.cNq.cMF;
                    MetaData apW = cmVar8.apW();
                    cmVar9 = this.cNq.cMF;
                    String threadID = cmVar9.getThreadID();
                    cmVar10 = this.cNq.cMF;
                    eVar8.a(apW, threadID, cmVar10.apL());
                }
                aVar = this.cNq.cMG;
                if (aVar != null) {
                    aVar2 = this.cNq.cMG;
                    aVar2.Y(cVar.qg());
                }
                if (cVar == null || cVar.aoK() != 1) {
                    this.cNq.mIsFromCDN = false;
                } else {
                    this.cNq.mIsFromCDN = true;
                }
                dzVar10 = this.cNq.cMK;
                z4 = this.cNq.mIsFromCDN;
                dzVar10.fK(z4);
                dzVar11 = this.cNq.cMK;
                cmVar = this.cNq.cMF;
                dzVar11.fG(cmVar.apP());
                z5 = this.cNq.cMP;
                if (!z5) {
                    z6 = this.cNq.cMQ;
                    if (z6) {
                        z7 = this.cNq.cMR;
                        if (!z7) {
                            PbActivity pbActivity2 = this.cNq;
                            cmVar2 = this.cNq.cMF;
                            pbActivity2.b(cmVar2.getPbData(), -1, false, true);
                            this.cNq.cMR = true;
                            this.cNq.cMP = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.cNq;
                    cmVar7 = this.cNq.cMF;
                    pbActivity3.a(cmVar7.getPbData(), -1, false, true);
                }
                dzVar12 = this.cNq.cMK;
                cmVar3 = this.cNq.cMF;
                boolean apP = cmVar3.apP();
                cmVar4 = this.cNq.cMF;
                dzVar12.a(cVar, i2, i3, apP, i4, cmVar4.getIsFromMark());
                dzVar13 = this.cNq.cMK;
                cmVar5 = this.cNq.cMF;
                dzVar13.a(cVar, cmVar5.apP(), false, i2);
                dzVar14 = this.cNq.cMK;
                cmVar6 = this.cNq.cMF;
                dzVar14.fI(cmVar6.getHostMode());
                this.cNq.apA();
                AntiData so = cVar.so();
                if (so != null) {
                    this.cNq.avb = so.getVoice_message();
                    str2 = this.cNq.avb;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.cNq.cMU;
                        if (eVar3 != null) {
                            eVar4 = this.cNq.cMU;
                            if (eVar4.Cz() != null) {
                                eVar5 = this.cNq.cMU;
                                com.baidu.tbadk.editortools.r ev = eVar5.Cz().ev(6);
                                if (ev != null) {
                                    str3 = this.cNq.avb;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.cNq.cqV;
                                        ((View) ev).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (str != null) {
                z3 = this.cNq.bfq;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        PbActivity pbActivity4 = this.cNq;
                        dzVar7 = this.cNq.cMK;
                        pbActivity4.showNetRefreshView(dzVar7.getView(), this.cNq.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), true);
                        dzVar8 = this.cNq.cMK;
                        dzVar8.arC();
                    }
                } else {
                    this.cNq.showToast(str);
                }
                dzVar5 = this.cNq.cMK;
                dzVar5.kO(this.cNq.getResources().getString(t.j.list_no_more));
                dzVar6 = this.cNq.cMK;
                dzVar6.xc();
            }
            this.cNq.aAK = System.currentTimeMillis() - currentTimeMillis;
            if (!this.cNq.apk().apP() || this.cNq.apk().getPbData().getPage().sw() != 0 || this.cNq.apk().aqj()) {
                this.cNq.cMV = true;
                return;
            }
            return;
        }
        cmVar12 = this.cNq.cMF;
        cmVar12.kQ(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void c(com.baidu.tieba.pb.a.c cVar) {
        dz dzVar;
        dzVar = this.cNq.cMK;
        dzVar.j(cVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void fo(boolean z) {
        long j;
        long j2;
        long j3;
        PbActivity pbActivity = this.cNq;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.cNq.aWx;
        pbActivity.aAL = currentTimeMillis - j;
        if (z) {
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eZ(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            j2 = this.cNq.createTime;
            vVar.aAE = j2;
            j3 = this.cNq.aAL;
            vVar.aAL = j3;
            vVar.FS();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void e(com.baidu.tbadk.performanceLog.v vVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (vVar != null) {
            j = this.cNq.createTime;
            vVar.aAE = j;
            this.cNq.createTime = 0L;
            j2 = this.cNq.aAK;
            vVar.aAK = j2;
            j3 = this.cNq.aAL;
            if (j3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.cNq.aWx;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = this.cNq.aAL;
            }
            vVar.aAL = j4;
            vVar.FT();
        }
    }
}
