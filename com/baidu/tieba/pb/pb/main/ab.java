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
class ab implements PbModel.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        fm fmVar4;
        boolean z2;
        fm fmVar5;
        boolean z3;
        boolean z4;
        fm fmVar6;
        fm fmVar7;
        fm fmVar8;
        fm fmVar9;
        fm fmVar10;
        PbModel pbModel;
        fm fmVar11;
        PbModel pbModel2;
        PbModel pbModel3;
        fm fmVar12;
        PbModel pbModel4;
        fm fmVar13;
        fm fmVar14;
        com.baidu.tbadk.editortools.pb.c cVar;
        PbModel pbModel5;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        fm fmVar15;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        PbModel pbModel6;
        fm fmVar16;
        PbModel pbModel7;
        PbModel pbModel8;
        fm fmVar17;
        PbModel pbModel9;
        fm fmVar18;
        PbModel pbModel10;
        PbModel pbModel11;
        boolean z9;
        int aIU;
        String str2;
        com.baidu.tbadk.editortools.pb.c cVar3;
        com.baidu.tbadk.editortools.pb.c cVar4;
        com.baidu.tbadk.editortools.pb.c cVar5;
        String str3;
        View.OnClickListener onClickListener;
        fm fmVar19;
        PbModel pbModel12;
        PbModel pbModel13;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.pb.c cVar6;
        com.baidu.tbadk.editortools.pb.c cVar7;
        com.baidu.tbadk.editortools.pb.c cVar8;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        com.baidu.tbadk.editortools.pb.c cVar9;
        PbModel pbModel17;
        fm fmVar20;
        com.baidu.tbadk.editortools.pb.c cVar10;
        fm fmVar21;
        fm fmVar22;
        fm fmVar23;
        PbModel pbModel18;
        if (!z || fVar == null || fVar.aHP() != null || com.baidu.tbadk.core.util.x.q(fVar.aHI()) >= 1) {
            this.ehy.dFR = true;
            long currentTimeMillis = System.currentTimeMillis();
            fmVar = this.ehy.egt;
            fmVar.aLF();
            if (fVar != null && fVar.aHM()) {
                fmVar23 = this.ehy.egt;
                if (fmVar23.aLg() == null) {
                    this.ehy.egI = true;
                }
            } else {
                PbActivity pbActivity = this.ehy;
                fmVar2 = this.ehy.egt;
                pbActivity.hideLoadingView(fmVar2.getView());
            }
            fmVar3 = this.ehy.egt;
            fmVar3.apm();
            fmVar4 = this.ehy.egt;
            fmVar4.aLz();
            z2 = this.ehy.egn;
            if (z2) {
                fmVar22 = this.ehy.egt;
                fmVar22.aLV();
            } else {
                fmVar5 = this.ehy.egt;
                fmVar5.gn(false);
            }
            z3 = this.ehy.mIsLoading;
            if (z3) {
                this.ehy.mIsLoading = false;
                fmVar21 = this.ehy.egt;
                fmVar21.emS.eqb.setEnabled(true);
            }
            if (i4 == 0 && fVar != null) {
                this.ehy.egC = true;
            }
            if (z && fVar != null) {
                fmVar13 = this.ehy.egt;
                fmVar13.Kn();
                fmVar14 = this.ehy.egt;
                fmVar14.iF(fVar.aHM());
                if (fVar.aHG() != null && fVar.aHG().su() != null) {
                    this.ehy.a(fVar.aHG().su());
                }
                cVar = this.ehy.egG;
                if (cVar != null) {
                    fmVar20 = this.ehy.egt;
                    cVar10 = this.ehy.egG;
                    fmVar20.gm(cVar10.CY());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (fVar.aHI() != null && fVar.aHI().size() >= 1 && fVar.aHI().get(0) != null) {
                    String id = fVar.aHI().get(0).getId();
                    pbModel17 = this.ehy.efE;
                    pbModel17.nK(id);
                } else if (fVar.aHP() != null) {
                    String id2 = fVar.aHP().getId();
                    pbModel5 = this.ehy.efE;
                    pbModel5.nK(id2);
                }
                cVar2 = this.ehy.egG;
                if (cVar2 != null) {
                    cVar6 = this.ehy.egG;
                    cVar6.a(fVar.ql());
                    cVar7 = this.ehy.egG;
                    cVar7.a(fVar.aHE(), fVar.getUserData());
                    cVar8 = this.ehy.egG;
                    pbModel14 = this.ehy.efE;
                    MetaData aKa = pbModel14.aKa();
                    pbModel15 = this.ehy.efE;
                    String threadID = pbModel15.getThreadID();
                    pbModel16 = this.ehy.efE;
                    cVar8.a(aKa, threadID, pbModel16.aKu());
                    if (fVar.aHG() != null) {
                        cVar9 = this.ehy.egG;
                        cVar9.bJ(fVar.aHG().sG());
                    }
                }
                aVar = this.ehy.dCb;
                if (aVar != null) {
                    aVar2 = this.ehy.dCb;
                    aVar2.ad(fVar.nL());
                }
                if (fVar == null || fVar.aHS() != 1) {
                    this.ehy.mIsFromCDN = false;
                } else {
                    this.ehy.mIsFromCDN = true;
                }
                fmVar15 = this.ehy.egt;
                z5 = this.ehy.mIsFromCDN;
                fmVar15.iE(z5);
                z6 = this.ehy.egz;
                if (!z6) {
                    z7 = this.ehy.egA;
                    if (z7) {
                        z8 = this.ehy.egB;
                        if (!z8) {
                            PbActivity pbActivity2 = this.ehy;
                            pbModel6 = this.ehy.efE;
                            pbActivity2.a(pbModel6.getPbData(), -1, false, true);
                            this.ehy.egB = true;
                            this.ehy.egz = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.ehy;
                    pbModel13 = this.ehy.efE;
                    pbActivity3.a(pbModel13.getPbData(), -1, 0, false, true);
                }
                fmVar16 = this.ehy.egt;
                pbModel7 = this.ehy.efE;
                boolean aJT = pbModel7.aJT();
                pbModel8 = this.ehy.efE;
                fmVar16.a(fVar, i2, i3, aJT, i4, pbModel8.getIsFromMark());
                fmVar17 = this.ehy.egt;
                pbModel9 = this.ehy.efE;
                fmVar17.e(fVar, pbModel9.aJT());
                fmVar18 = this.ehy.egt;
                pbModel10 = this.ehy.efE;
                fmVar18.iC(pbModel10.getHostMode());
                pbModel11 = this.ehy.efE;
                if (pbModel11.aKp() != null) {
                    fmVar19 = this.ehy.egt;
                    pbModel12 = this.ehy.efE;
                    fmVar19.iA(pbModel12.aKp().aJO());
                }
                AntiData ql = fVar.ql();
                if (ql != null) {
                    this.ehy.aAU = ql.getVoice_message();
                    str2 = this.ehy.aAU;
                    if (!StringUtils.isNull(str2)) {
                        cVar3 = this.ehy.egG;
                        if (cVar3 != null) {
                            cVar4 = this.ehy.egG;
                            if (cVar4.Cs() != null) {
                                cVar5 = this.ehy.egG;
                                com.baidu.tbadk.editortools.p ev = cVar5.Cs().ev(6);
                                if (ev != null) {
                                    str3 = this.ehy.aAU;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.ehy.dkX;
                                        ((View) ev).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                z9 = this.ehy.egE;
                if (z9) {
                    this.ehy.egE = false;
                    aIU = this.ehy.aIU();
                    this.ehy.aIM().getListView().setSelection(aIU);
                }
            } else if (str != null) {
                z4 = this.ehy.egC;
                if (!z4 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            pbModel = this.ehy.efE;
                            if (pbModel != null) {
                                pbModel2 = this.ehy.efE;
                                if (pbModel2.getAppealInfo() != null) {
                                    pbModel3 = this.ehy.efE;
                                    if (!StringUtils.isNull(pbModel3.getAppealInfo().ecU)) {
                                        fmVar12 = this.ehy.egt;
                                        pbModel4 = this.ehy.efE;
                                        fmVar12.a(pbModel4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.ehy;
                            fmVar11 = this.ehy.egt;
                            pbActivity4.showNetRefreshView(fmVar11.getView(), this.ehy.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.ehy.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ehy.getApplicationContext(), w.f.ds200));
                        } else {
                            PbActivity pbActivity5 = this.ehy;
                            fmVar9 = this.ehy.egt;
                            pbActivity5.showNetRefreshView(fmVar9.getView(), this.ehy.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.ehy.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ehy.getApplicationContext(), w.f.ds200));
                        }
                        fmVar10 = this.ehy.egt;
                        fmVar10.aLV();
                    }
                } else {
                    this.ehy.showToast(str);
                }
                if (i != -1) {
                    fmVar8 = this.ehy.egt;
                    fmVar8.nM(this.ehy.getResources().getString(w.l.list_no_more_new));
                } else {
                    fmVar6 = this.ehy.egt;
                    fmVar6.nM("");
                }
                fmVar7 = this.ehy.egt;
                fmVar7.wp();
            }
            this.ehy.aGK = System.currentTimeMillis() - currentTimeMillis;
            if (!this.ehy.aIN().aJT() || this.ehy.aIN().getPbData().qB().qy() != 0 || this.ehy.aIN().aKn()) {
                this.ehy.egH = true;
                return;
            }
            return;
        }
        pbModel18 = this.ehy.efE;
        pbModel18.of(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        fm fmVar;
        fmVar = this.ehy.egt;
        fmVar.l(fVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.j.aa.FK().FL()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.ehy.bGR;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.ehy.aGC;
            j4 = this.ehy.createTime;
            j5 = this.ehy.aGK;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.ehy.createTime = 0L;
            this.ehy.aGC = 0L;
            if (vVar != null) {
                vVar.FF();
            }
        }
    }
}
