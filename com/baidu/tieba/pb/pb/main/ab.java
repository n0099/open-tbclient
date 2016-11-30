package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.dj;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ab implements dj.a {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.dj.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        boolean z2;
        boolean z3;
        ey eyVar5;
        ey eyVar6;
        ey eyVar7;
        ey eyVar8;
        dj djVar;
        ey eyVar9;
        dj djVar2;
        dj djVar3;
        ey eyVar10;
        dj djVar4;
        dj djVar5;
        ey eyVar11;
        dj djVar6;
        dj djVar7;
        ey eyVar12;
        dj djVar8;
        ey eyVar13;
        ey eyVar14;
        com.baidu.tbadk.editortools.e.e eVar;
        dj djVar9;
        com.baidu.tbadk.editortools.e.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        ey eyVar15;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        dj djVar10;
        ey eyVar16;
        dj djVar11;
        dj djVar12;
        ey eyVar17;
        dj djVar13;
        ey eyVar18;
        dj djVar14;
        dj djVar15;
        dj djVar16;
        dj djVar17;
        ey eyVar19;
        ey eyVar20;
        String str2;
        com.baidu.tbadk.editortools.e.e eVar3;
        com.baidu.tbadk.editortools.e.e eVar4;
        com.baidu.tbadk.editortools.e.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        ey eyVar21;
        dj djVar18;
        ey eyVar22;
        dj djVar19;
        dj djVar20;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.e.e eVar6;
        com.baidu.tbadk.editortools.e.e eVar7;
        com.baidu.tbadk.editortools.e.e eVar8;
        dj djVar21;
        dj djVar22;
        dj djVar23;
        dj djVar24;
        ey eyVar23;
        com.baidu.tbadk.editortools.e.e eVar9;
        ey eyVar24;
        ey eyVar25;
        dj djVar25;
        if (!z || hVar == null || hVar.aOs() != null || com.baidu.tbadk.core.util.x.s(hVar.aOm()) >= 1) {
            this.evL.dWi = true;
            long currentTimeMillis = System.currentTimeMillis();
            eyVar = this.evL.euP;
            eyVar.aSc();
            if (hVar != null && hVar.aOr()) {
                eyVar25 = this.evL.euP;
                if (eyVar25.aRE() == null) {
                    this.evL.evd = true;
                }
            } else {
                PbActivity pbActivity = this.evL;
                eyVar2 = this.evL.euP;
                pbActivity.hideLoadingView(eyVar2.getView());
            }
            eyVar3 = this.evL.euP;
            eyVar3.awy();
            eyVar4 = this.evL.euP;
            eyVar4.gY(false);
            z2 = this.evL.mIsLoading;
            if (z2) {
                this.evL.mIsLoading = false;
                eyVar24 = this.evL.euP;
                eyVar24.eAx.eDI.setEnabled(true);
            }
            if (i4 == 0 && hVar != null) {
                this.evL.euY = true;
            }
            if (z && hVar != null) {
                eyVar13 = this.evL.euP;
                eyVar13.Km();
                eyVar14 = this.evL.euP;
                eyVar14.ja(hVar.aOr());
                if (hVar.aOl() != null && hVar.aOl().sK() != null) {
                    this.evL.a(hVar.aOl().sK());
                }
                eVar = this.evL.evb;
                if (eVar != null) {
                    eyVar23 = this.evL.euP;
                    eVar9 = this.evL.evb;
                    eyVar23.gX(eVar9.Dz());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(hVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(hVar.getUserData().getBimg_end_time());
                if (hVar.aOm() != null && hVar.aOm().size() >= 1 && hVar.aOm().get(0) != null) {
                    String id = hVar.aOm().get(0).getId();
                    djVar24 = this.evL.euf;
                    djVar24.pu(id);
                } else if (hVar.aOs() != null) {
                    String id2 = hVar.aOs().getId();
                    djVar9 = this.evL.euf;
                    djVar9.pu(id2);
                }
                eVar2 = this.evL.evb;
                if (eVar2 != null) {
                    eVar6 = this.evL.evb;
                    eVar6.a(hVar.qs());
                    eVar7 = this.evL.evb;
                    eVar7.a(hVar.aOk(), hVar.getUserData());
                    eVar8 = this.evL.evb;
                    djVar21 = this.evL.euf;
                    MetaData aQv = djVar21.aQv();
                    djVar22 = this.evL.euf;
                    String threadID = djVar22.getThreadID();
                    djVar23 = this.evL.euf;
                    eVar8.a(aQv, threadID, djVar23.aQl());
                }
                aVar = this.evL.dSz;
                if (aVar != null) {
                    aVar2 = this.evL.dSz;
                    aVar2.ad(hVar.nz());
                }
                if (hVar == null || hVar.aOu() != 1) {
                    this.evL.mIsFromCDN = false;
                } else {
                    this.evL.mIsFromCDN = true;
                }
                eyVar15 = this.evL.euP;
                z4 = this.evL.mIsFromCDN;
                eyVar15.iZ(z4);
                z5 = this.evL.euV;
                if (!z5) {
                    z6 = this.evL.euW;
                    if (z6) {
                        z7 = this.evL.euX;
                        if (!z7) {
                            PbActivity pbActivity2 = this.evL;
                            djVar10 = this.evL.euf;
                            pbActivity2.a(djVar10.getPbData(), -1, false, true);
                            this.evL.euX = true;
                            this.evL.euV = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.evL;
                    djVar20 = this.evL.euf;
                    pbActivity3.a(djVar20.getPbData(), -1, 0, false, true);
                }
                eyVar16 = this.evL.euP;
                djVar11 = this.evL.euf;
                boolean aQp = djVar11.aQp();
                djVar12 = this.evL.euf;
                eyVar16.a(hVar, i2, i3, aQp, i4, djVar12.getIsFromMark());
                eyVar17 = this.evL.euP;
                djVar13 = this.evL.euf;
                eyVar17.a(hVar, djVar13.aQp(), false, i2);
                eyVar18 = this.evL.euP;
                djVar14 = this.evL.euf;
                eyVar18.iX(djVar14.getHostMode());
                djVar15 = this.evL.euf;
                if (djVar15.aQK() != null) {
                    eyVar21 = this.evL.euP;
                    djVar18 = this.evL.euf;
                    eyVar21.c(djVar18.aQK().aQb());
                    if (hVar.aOl() != null && hVar.aOl().Ve == null) {
                        eyVar22 = this.evL.euP;
                        djVar19 = this.evL.euf;
                        eyVar22.iV(djVar19.aQK().aQc());
                    }
                }
                AntiData qs = hVar.qs();
                if (qs != null) {
                    this.evL.awI = qs.getVoice_message();
                    str2 = this.evL.awI;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.evL.evb;
                        if (eVar3 != null) {
                            eVar4 = this.evL.evb;
                            if (eVar4.CO() != null) {
                                eVar5 = this.evL.evb;
                                com.baidu.tbadk.editortools.s ez = eVar5.CO().ez(6);
                                if (ez != null) {
                                    str3 = this.evL.awI;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.evL.dDC;
                                        ((View) ez).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                djVar16 = this.evL.euf;
                if (djVar16.aQK() != null) {
                    djVar17 = this.evL.euf;
                    if (djVar17.aQK().aQe()) {
                        eyVar19 = this.evL.euP;
                        if (!eyVar19.aSF()) {
                            eyVar20 = this.evL.euP;
                            eyVar20.aQg();
                        }
                    }
                }
            } else if (str != null) {
                z3 = this.evL.euY;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            djVar = this.evL.euf;
                            if (djVar != null) {
                                djVar2 = this.evL.euf;
                                if (djVar2.getAppealInfo() != null) {
                                    djVar3 = this.evL.euf;
                                    if (!StringUtils.isNull(djVar3.getAppealInfo().erT)) {
                                        eyVar10 = this.evL.euP;
                                        djVar4 = this.evL.euf;
                                        eyVar10.a(djVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.evL;
                            eyVar9 = this.evL.euP;
                            pbActivity4.showNetRefreshView(eyVar9.getView(), this.evL.getPageContext().getResources().getString(r.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.evL.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.evL;
                            eyVar7 = this.evL.euP;
                            pbActivity5.showNetRefreshView(eyVar7.getView(), this.evL.getPageContext().getResources().getString(r.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.evL.setNetRefreshViewEmotionDefMarginTop();
                        }
                        eyVar8 = this.evL.euP;
                        eyVar8.aSq();
                    }
                } else {
                    this.evL.showToast(str);
                }
                eyVar5 = this.evL.euP;
                eyVar5.pA(this.evL.getResources().getString(r.j.list_no_more));
                eyVar6 = this.evL.euP;
                eyVar6.wG();
            }
            this.evL.aCL = System.currentTimeMillis() - currentTimeMillis;
            if (!this.evL.aPd().aQp() || this.evL.aPd().getPbData().getPage().qE() != 0 || this.evL.aPd().aQI()) {
                this.evL.evc = true;
            }
            djVar5 = this.evL.euf;
            if (djVar5 != null) {
                eyVar11 = this.evL.euP;
                if (eyVar11 != null) {
                    djVar6 = this.evL.euf;
                    if (djVar6.aQK() != null) {
                        djVar7 = this.evL.euf;
                        if (djVar7.aQK().aPY()) {
                            eyVar12 = this.evL.euP;
                            eyVar12.aQi();
                            djVar8 = this.evL.euf;
                            djVar8.aQK().aQa();
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
        djVar25 = this.evL.euf;
        djVar25.oC(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.dj.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
        ey eyVar;
        eyVar = this.evL.euP;
        eyVar.j(hVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.dj.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.Gu().Gv()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.evL.bJR;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.evL.aCD;
            j4 = this.evL.createTime;
            j5 = this.evL.aCL;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.evL.createTime = 0L;
            this.evL.aCD = 0L;
            if (vVar != null) {
                vVar.Gp();
            }
        }
    }
}
