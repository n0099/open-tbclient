package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aa implements PbModel.a {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        boolean z2;
        ey eyVar5;
        boolean z3;
        boolean z4;
        ey eyVar6;
        ey eyVar7;
        ey eyVar8;
        ey eyVar9;
        PbModel pbModel;
        ey eyVar10;
        PbModel pbModel2;
        PbModel pbModel3;
        ey eyVar11;
        PbModel pbModel4;
        PbModel pbModel5;
        ey eyVar12;
        PbModel pbModel6;
        PbModel pbModel7;
        ey eyVar13;
        PbModel pbModel8;
        ey eyVar14;
        ey eyVar15;
        com.baidu.tbadk.editortools.pb.c cVar;
        PbModel pbModel9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        ey eyVar16;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        PbModel pbModel10;
        ey eyVar17;
        PbModel pbModel11;
        PbModel pbModel12;
        ey eyVar18;
        PbModel pbModel13;
        ey eyVar19;
        PbModel pbModel14;
        PbModel pbModel15;
        String str2;
        com.baidu.tbadk.editortools.pb.c cVar3;
        com.baidu.tbadk.editortools.pb.c cVar4;
        com.baidu.tbadk.editortools.pb.c cVar5;
        String str3;
        View.OnClickListener onClickListener;
        ey eyVar20;
        PbModel pbModel16;
        ey eyVar21;
        PbModel pbModel17;
        PbModel pbModel18;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.pb.c cVar6;
        com.baidu.tbadk.editortools.pb.c cVar7;
        com.baidu.tbadk.editortools.pb.c cVar8;
        PbModel pbModel19;
        PbModel pbModel20;
        PbModel pbModel21;
        PbModel pbModel22;
        ey eyVar22;
        com.baidu.tbadk.editortools.pb.c cVar9;
        ey eyVar23;
        ey eyVar24;
        ey eyVar25;
        PbModel pbModel23;
        if (!z || fVar == null || fVar.aKH() != null || com.baidu.tbadk.core.util.x.p(fVar.aKA()) >= 1) {
            this.emk.dLt = true;
            long currentTimeMillis = System.currentTimeMillis();
            eyVar = this.emk.eli;
            eyVar.aOo();
            if (fVar != null && fVar.aKF()) {
                eyVar25 = this.emk.eli;
                if (eyVar25.aNP() == null) {
                    this.emk.elw = true;
                }
            } else {
                PbActivity pbActivity = this.emk;
                eyVar2 = this.emk.eli;
                pbActivity.hideLoadingView(eyVar2.getView());
            }
            eyVar3 = this.emk.eli;
            eyVar3.ass();
            eyVar4 = this.emk.eli;
            eyVar4.aOi();
            z2 = this.emk.elc;
            if (z2) {
                eyVar24 = this.emk.eli;
                eyVar24.aOE();
            } else {
                eyVar5 = this.emk.eli;
                eyVar5.gM(false);
            }
            z3 = this.emk.mIsLoading;
            if (z3) {
                this.emk.mIsLoading = false;
                eyVar23 = this.emk.eli;
                eyVar23.erm.euy.setEnabled(true);
            }
            if (i4 == 0 && fVar != null) {
                this.emk.elr = true;
            }
            if (z && fVar != null) {
                eyVar14 = this.emk.eli;
                eyVar14.KZ();
                eyVar15 = this.emk.eli;
                eyVar15.ja(fVar.aKF());
                if (fVar.aKy() != null && fVar.aKy().tk() != null) {
                    this.emk.a(fVar.aKy().tk());
                }
                cVar = this.emk.elu;
                if (cVar != null) {
                    eyVar22 = this.emk.eli;
                    cVar9 = this.emk.elu;
                    eyVar22.gL(cVar9.DU());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (fVar.aKA() != null && fVar.aKA().size() >= 1 && fVar.aKA().get(0) != null) {
                    String id = fVar.aKA().get(0).getId();
                    pbModel22 = this.emk.ekv;
                    pbModel22.nD(id);
                } else if (fVar.aKH() != null) {
                    String id2 = fVar.aKH().getId();
                    pbModel9 = this.emk.ekv;
                    pbModel9.nD(id2);
                }
                cVar2 = this.emk.elu;
                if (cVar2 != null) {
                    cVar6 = this.emk.elu;
                    cVar6.a(fVar.rb());
                    cVar7 = this.emk.elu;
                    cVar7.a(fVar.aKx(), fVar.getUserData());
                    cVar8 = this.emk.elu;
                    pbModel19 = this.emk.ekv;
                    MetaData aML = pbModel19.aML();
                    pbModel20 = this.emk.ekv;
                    String threadID = pbModel20.getThreadID();
                    pbModel21 = this.emk.ekv;
                    cVar8.a(aML, threadID, pbModel21.aNe());
                }
                aVar = this.emk.dHE;
                if (aVar != null) {
                    aVar2 = this.emk.dHE;
                    aVar2.ae(fVar.oe());
                }
                if (fVar == null || fVar.aKJ() != 1) {
                    this.emk.mIsFromCDN = false;
                } else {
                    this.emk.mIsFromCDN = true;
                }
                eyVar16 = this.emk.eli;
                z5 = this.emk.mIsFromCDN;
                eyVar16.iZ(z5);
                z6 = this.emk.elo;
                if (!z6) {
                    z7 = this.emk.elp;
                    if (z7) {
                        z8 = this.emk.elq;
                        if (!z8) {
                            PbActivity pbActivity2 = this.emk;
                            pbModel10 = this.emk.ekv;
                            pbActivity2.a(pbModel10.getPbData(), -1, false, true);
                            this.emk.elq = true;
                            this.emk.elo = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.emk;
                    pbModel18 = this.emk.ekv;
                    pbActivity3.a(pbModel18.getPbData(), -1, 0, false, true);
                }
                eyVar17 = this.emk.eli;
                pbModel11 = this.emk.ekv;
                boolean aMD = pbModel11.aMD();
                pbModel12 = this.emk.ekv;
                eyVar17.a(fVar, i2, i3, aMD, i4, pbModel12.getIsFromMark());
                eyVar18 = this.emk.eli;
                pbModel13 = this.emk.ekv;
                eyVar18.e(fVar, pbModel13.aMD());
                eyVar19 = this.emk.eli;
                pbModel14 = this.emk.ekv;
                eyVar19.iX(pbModel14.getHostMode());
                pbModel15 = this.emk.ekv;
                if (pbModel15.aNa() != null) {
                    eyVar20 = this.emk.eli;
                    pbModel16 = this.emk.ekv;
                    eyVar20.b(pbModel16.aNa().aMs());
                    eyVar21 = this.emk.eli;
                    pbModel17 = this.emk.ekv;
                    eyVar21.iV(pbModel17.aNa().aMt());
                }
                AntiData rb = fVar.rb();
                if (rb != null) {
                    this.emk.aAW = rb.getVoice_message();
                    str2 = this.emk.aAW;
                    if (!StringUtils.isNull(str2)) {
                        cVar3 = this.emk.elu;
                        if (cVar3 != null) {
                            cVar4 = this.emk.elu;
                            if (cVar4.Dn() != null) {
                                cVar5 = this.emk.elu;
                                com.baidu.tbadk.editortools.p ez = cVar5.Dn().ez(6);
                                if (ez != null) {
                                    str3 = this.emk.aAW;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.emk.dqT;
                                        ((View) ez).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (str != null) {
                z4 = this.emk.elr;
                if (!z4 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            pbModel = this.emk.ekv;
                            if (pbModel != null) {
                                pbModel2 = this.emk.ekv;
                                if (pbModel2.getAppealInfo() != null) {
                                    pbModel3 = this.emk.ekv;
                                    if (!StringUtils.isNull(pbModel3.getAppealInfo().eig)) {
                                        eyVar11 = this.emk.eli;
                                        pbModel4 = this.emk.ekv;
                                        eyVar11.a(pbModel4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.emk;
                            eyVar10 = this.emk.eli;
                            pbActivity4.showNetRefreshView(eyVar10.getView(), this.emk.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.emk.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.emk.getApplicationContext(), w.f.ds200));
                        } else {
                            PbActivity pbActivity5 = this.emk;
                            eyVar8 = this.emk.eli;
                            pbActivity5.showNetRefreshView(eyVar8.getView(), this.emk.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.emk.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.emk.getApplicationContext(), w.f.ds200));
                        }
                        eyVar9 = this.emk.eli;
                        eyVar9.aOE();
                    }
                } else {
                    this.emk.showToast(str);
                }
                eyVar6 = this.emk.eli;
                eyVar6.nG(this.emk.getResources().getString(w.l.list_no_more));
                eyVar7 = this.emk.eli;
                eyVar7.xe();
            }
            this.emk.aGG = System.currentTimeMillis() - currentTimeMillis;
            if (!this.emk.aLs().aMD() || this.emk.aLs().getPbData().rr().ro() != 0 || this.emk.aLs().aMY()) {
                this.emk.elv = true;
            }
            pbModel5 = this.emk.ekv;
            if (pbModel5 != null) {
                eyVar12 = this.emk.eli;
                if (eyVar12 != null) {
                    pbModel6 = this.emk.ekv;
                    if (pbModel6.aNa() != null) {
                        pbModel7 = this.emk.ekv;
                        if (pbModel7.aNa().aMp()) {
                            eyVar13 = this.emk.eli;
                            eyVar13.aMx();
                            pbModel8 = this.emk.ekv;
                            pbModel8.aNa().aMr();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        pbModel23 = this.emk.ekv;
        pbModel23.on(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        ey eyVar;
        eyVar = this.emk.eli;
        eyVar.k(fVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.j.aa.GG().GH()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.emk.bGX;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.emk.aGy;
            j4 = this.emk.createTime;
            j5 = this.emk.aGG;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.emk.createTime = 0L;
            this.emk.aGy = 0L;
            if (vVar != null) {
                vVar.GB();
            }
        }
    }
}
