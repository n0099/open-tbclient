package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.cw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class x implements cw.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cw.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        el elVar;
        el elVar2;
        el elVar3;
        el elVar4;
        boolean z2;
        boolean z3;
        el elVar5;
        el elVar6;
        el elVar7;
        el elVar8;
        cw cwVar;
        el elVar9;
        cw cwVar2;
        cw cwVar3;
        el elVar10;
        cw cwVar4;
        cw cwVar5;
        el elVar11;
        cw cwVar6;
        cw cwVar7;
        el elVar12;
        cw cwVar8;
        el elVar13;
        el elVar14;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.baseEditMark.a aVar;
        el elVar15;
        boolean z4;
        el elVar16;
        cw cwVar9;
        boolean z5;
        boolean z6;
        boolean z7;
        cw cwVar10;
        el elVar17;
        cw cwVar11;
        cw cwVar12;
        el elVar18;
        cw cwVar13;
        el elVar19;
        cw cwVar14;
        cw cwVar15;
        cw cwVar16;
        cw cwVar17;
        el elVar20;
        String str2;
        com.baidu.tbadk.editortools.d.e eVar4;
        com.baidu.tbadk.editortools.d.e eVar5;
        com.baidu.tbadk.editortools.d.e eVar6;
        String str3;
        View.OnClickListener onClickListener;
        el elVar21;
        cw cwVar18;
        el elVar22;
        cw cwVar19;
        cw cwVar20;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.d.e eVar7;
        com.baidu.tbadk.editortools.d.e eVar8;
        com.baidu.tbadk.editortools.d.e eVar9;
        cw cwVar21;
        cw cwVar22;
        cw cwVar23;
        cw cwVar24;
        el elVar23;
        com.baidu.tbadk.editortools.d.e eVar10;
        el elVar24;
        el elVar25;
        cw cwVar25;
        if (!z || eVar == null || eVar.avF() == null || eVar.avF().size() >= 1) {
            this.djE.cST = true;
            long currentTimeMillis = System.currentTimeMillis();
            elVar = this.djE.diR;
            elVar.azg();
            if (eVar != null && eVar.avJ()) {
                elVar25 = this.djE.diR;
                if (elVar25.ayH() == null) {
                    this.djE.djc = true;
                }
            } else {
                PbActivity pbActivity = this.djE;
                elVar2 = this.djE.diR;
                pbActivity.hideLoadingView(elVar2.getView());
            }
            elVar3 = this.djE.diR;
            elVar3.agp();
            elVar4 = this.djE.diR;
            elVar4.fo(false);
            z2 = this.djE.mIsLoading;
            if (z2) {
                this.djE.mIsLoading = false;
                elVar24 = this.djE.diR;
                elVar24.dmZ.dpV.setEnabled(true);
            }
            if (i4 == 0 && eVar != null) {
                this.djE.bfZ = true;
            }
            if (z && eVar != null) {
                elVar13 = this.djE.diR;
                elVar13.Lf();
                elVar14 = this.djE.diR;
                elVar14.ha(eVar.avJ());
                if (eVar.avE() != null && eVar.avE().rv() != null) {
                    this.djE.a(eVar.avE().rv());
                }
                eVar2 = this.djE.dja;
                if (eVar2 != null) {
                    elVar23 = this.djE.diR;
                    eVar10 = this.djE.dja;
                    elVar23.fn(eVar10.BN());
                }
                TbadkCoreApplication.m11getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.m11getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (eVar.avF() != null && eVar.avF().size() >= 1 && eVar.avF().get(0) != null) {
                    String id = eVar.avF().get(0).getId();
                    cwVar24 = this.djE.dih;
                    cwVar24.lV(id);
                }
                eVar3 = this.djE.dja;
                if (eVar3 != null) {
                    eVar7 = this.djE.dja;
                    eVar7.a(eVar.pz());
                    eVar8 = this.djE.dja;
                    eVar8.a(eVar.avD(), eVar.getUserData());
                    eVar9 = this.djE.dja;
                    cwVar21 = this.djE.dih;
                    MetaData axL = cwVar21.axL();
                    cwVar22 = this.djE.dih;
                    String threadID = cwVar22.getThreadID();
                    cwVar23 = this.djE.dih;
                    eVar9.a(axL, threadID, cwVar23.axA());
                }
                aVar = this.djE.cPW;
                if (aVar != null) {
                    aVar2 = this.djE.cPW;
                    aVar2.aa(eVar.mP());
                }
                if (eVar == null || eVar.avL() != 1) {
                    this.djE.mIsFromCDN = false;
                } else {
                    this.djE.mIsFromCDN = true;
                }
                elVar15 = this.djE.diR;
                z4 = this.djE.mIsFromCDN;
                elVar15.gZ(z4);
                elVar16 = this.djE.diR;
                cwVar9 = this.djE.dih;
                elVar16.gT(cwVar9.axE());
                z5 = this.djE.diV;
                if (!z5) {
                    z6 = this.djE.diW;
                    if (z6) {
                        z7 = this.djE.diX;
                        if (!z7) {
                            PbActivity pbActivity2 = this.djE;
                            cwVar10 = this.djE.dih;
                            pbActivity2.a(cwVar10.getPbData(), -1, false, true);
                            this.djE.diX = true;
                            this.djE.diV = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.djE;
                    cwVar20 = this.djE.dih;
                    pbActivity3.a(cwVar20.getPbData(), -1, 0, false, true);
                }
                elVar17 = this.djE.diR;
                cwVar11 = this.djE.dih;
                boolean axE = cwVar11.axE();
                cwVar12 = this.djE.dih;
                elVar17.a(eVar, i2, i3, axE, i4, cwVar12.getIsFromMark());
                elVar18 = this.djE.diR;
                cwVar13 = this.djE.dih;
                elVar18.a(eVar, cwVar13.axE(), false, i2);
                elVar19 = this.djE.diR;
                cwVar14 = this.djE.dih;
                elVar19.gX(cwVar14.getHostMode());
                cwVar15 = this.djE.dih;
                if (cwVar15.axY() != null) {
                    elVar21 = this.djE.diR;
                    cwVar18 = this.djE.dih;
                    elVar21.b(cwVar18.axY().axq());
                    elVar22 = this.djE.diR;
                    cwVar19 = this.djE.dih;
                    elVar22.gV(cwVar19.axY().axr());
                }
                this.djE.awM();
                AntiData pz = eVar.pz();
                if (pz != null) {
                    this.djE.arA = pz.getVoice_message();
                    str2 = this.djE.arA;
                    if (!StringUtils.isNull(str2)) {
                        eVar4 = this.djE.dja;
                        if (eVar4 != null) {
                            eVar5 = this.djE.dja;
                            if (eVar5.Bc() != null) {
                                eVar6 = this.djE.dja;
                                com.baidu.tbadk.editortools.s ef = eVar6.Bc().ef(6);
                                if (ef != null) {
                                    str3 = this.djE.arA;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.djE.cCv;
                                        ((View) ef).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                cwVar16 = this.djE.dih;
                if (cwVar16.axY() != null) {
                    cwVar17 = this.djE.dih;
                    if (cwVar17.axY().axt()) {
                        elVar20 = this.djE.diR;
                        elVar20.axv();
                    }
                }
            } else if (str != null) {
                z3 = this.djE.bfZ;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            cwVar = this.djE.dih;
                            if (cwVar != null) {
                                cwVar2 = this.djE.dih;
                                if (cwVar2.getAppealInfo() != null) {
                                    cwVar3 = this.djE.dih;
                                    if (!StringUtils.isNull(cwVar3.getAppealInfo().deZ)) {
                                        elVar10 = this.djE.diR;
                                        cwVar4 = this.djE.dih;
                                        elVar10.a(cwVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.djE;
                            elVar9 = this.djE.diR;
                            pbActivity4.showNetRefreshView(elVar9.getView(), this.djE.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.djE.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.djE;
                            elVar7 = this.djE.diR;
                            pbActivity5.showNetRefreshView(elVar7.getView(), this.djE.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.djE.setNetRefreshViewEmotionDefMarginTop();
                        }
                        elVar8 = this.djE.diR;
                        elVar8.azy();
                    }
                } else {
                    this.djE.showToast(str);
                }
                elVar5 = this.djE.diR;
                elVar5.mb(this.djE.getResources().getString(t.j.list_no_more));
                elVar6 = this.djE.diR;
                elVar6.vi();
            }
            this.djE.axE = System.currentTimeMillis() - currentTimeMillis;
            if (!this.djE.awx().axE() || this.djE.awx().getPbData().getPage().pL() != 0 || this.djE.awx().axW()) {
                this.djE.djb = true;
            }
            cwVar5 = this.djE.dih;
            if (cwVar5 != null) {
                elVar11 = this.djE.diR;
                if (elVar11 != null) {
                    cwVar6 = this.djE.dih;
                    if (cwVar6.axY() != null) {
                        cwVar7 = this.djE.dih;
                        if (cwVar7.axY().axn()) {
                            elVar12 = this.djE.diR;
                            elVar12.axx();
                            cwVar8 = this.djE.dih;
                            cwVar8.axY().axp();
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
        cwVar25 = this.djE.dih;
        cwVar25.lN(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.cw.a
    public void c(com.baidu.tieba.pb.data.e eVar) {
        el elVar;
        elVar = this.djE.diR;
        elVar.j(eVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.cw.a
    public void d(com.baidu.tbadk.performanceLog.v vVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (vVar != null) {
            j = this.djE.axw;
            vVar.axw = j;
            j2 = this.djE.createTime;
            vVar.axx = j2;
            this.djE.createTime = 0L;
            this.djE.axw = 0L;
            j3 = this.djE.axE;
            vVar.axE = j3;
            if (vVar.axF == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.djE.aXp;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = vVar.axF;
            }
            vVar.axF = j4;
            vVar.EI();
        }
    }
}
