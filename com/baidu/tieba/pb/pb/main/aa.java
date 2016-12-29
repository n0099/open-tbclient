package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.dc;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aa implements dc.a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.dc.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        er erVar;
        er erVar2;
        er erVar3;
        er erVar4;
        boolean z2;
        boolean z3;
        er erVar5;
        er erVar6;
        er erVar7;
        er erVar8;
        dc dcVar;
        er erVar9;
        dc dcVar2;
        dc dcVar3;
        er erVar10;
        dc dcVar4;
        dc dcVar5;
        er erVar11;
        dc dcVar6;
        dc dcVar7;
        er erVar12;
        dc dcVar8;
        er erVar13;
        er erVar14;
        com.baidu.tbadk.editortools.e.e eVar;
        dc dcVar9;
        com.baidu.tbadk.editortools.e.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        er erVar15;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        dc dcVar10;
        er erVar16;
        dc dcVar11;
        dc dcVar12;
        er erVar17;
        dc dcVar13;
        er erVar18;
        dc dcVar14;
        dc dcVar15;
        String str2;
        com.baidu.tbadk.editortools.e.e eVar3;
        com.baidu.tbadk.editortools.e.e eVar4;
        com.baidu.tbadk.editortools.e.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        er erVar19;
        dc dcVar16;
        er erVar20;
        dc dcVar17;
        dc dcVar18;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.e.e eVar6;
        com.baidu.tbadk.editortools.e.e eVar7;
        com.baidu.tbadk.editortools.e.e eVar8;
        dc dcVar19;
        dc dcVar20;
        dc dcVar21;
        dc dcVar22;
        er erVar21;
        com.baidu.tbadk.editortools.e.e eVar9;
        er erVar22;
        er erVar23;
        dc dcVar23;
        if (!z || fVar == null || fVar.aIt() != null || com.baidu.tbadk.core.util.x.s(fVar.aIm()) >= 1) {
            this.eah.dAL = true;
            long currentTimeMillis = System.currentTimeMillis();
            erVar = this.eah.dZk;
            erVar.aLW();
            if (fVar != null && fVar.aIr()) {
                erVar23 = this.eah.dZk;
                if (erVar23.aLy() == null) {
                    this.eah.dZy = true;
                }
            } else {
                PbActivity pbActivity = this.eah;
                erVar2 = this.eah.dZk;
                pbActivity.hideLoadingView(erVar2.getView());
            }
            erVar3 = this.eah.dZk;
            erVar3.aqX();
            erVar4 = this.eah.dZk;
            erVar4.gI(false);
            z2 = this.eah.mIsLoading;
            if (z2) {
                this.eah.mIsLoading = false;
                erVar22 = this.eah.dZk;
                erVar22.eeG.ehJ.setEnabled(true);
            }
            if (i4 == 0 && fVar != null) {
                this.eah.dZt = true;
            }
            if (z && fVar != null) {
                erVar13 = this.eah.dZk;
                erVar13.JF();
                erVar14 = this.eah.dZk;
                erVar14.iM(fVar.aIr());
                if (fVar.aIl() != null && fVar.aIl().sz() != null) {
                    this.eah.a(fVar.aIl().sz());
                }
                eVar = this.eah.dZw;
                if (eVar != null) {
                    erVar21 = this.eah.dZk;
                    eVar9 = this.eah.dZw;
                    erVar21.gH(eVar9.Di());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (fVar.aIm() != null && fVar.aIm().size() >= 1 && fVar.aIm().get(0) != null) {
                    String id = fVar.aIm().get(0).getId();
                    dcVar22 = this.eah.dYA;
                    dcVar22.nY(id);
                } else if (fVar.aIt() != null) {
                    String id2 = fVar.aIt().getId();
                    dcVar9 = this.eah.dYA;
                    dcVar9.nY(id2);
                }
                eVar2 = this.eah.dZw;
                if (eVar2 != null) {
                    eVar6 = this.eah.dZw;
                    eVar6.a(fVar.qt());
                    eVar7 = this.eah.dZw;
                    eVar7.a(fVar.aIk(), fVar.getUserData());
                    eVar8 = this.eah.dZw;
                    dcVar19 = this.eah.dYA;
                    MetaData aKs = dcVar19.aKs();
                    dcVar20 = this.eah.dYA;
                    String threadID = dcVar20.getThreadID();
                    dcVar21 = this.eah.dYA;
                    eVar8.a(aKs, threadID, dcVar21.aKK());
                }
                aVar = this.eah.dxb;
                if (aVar != null) {
                    aVar2 = this.eah.dxb;
                    aVar2.ad(fVar.nz());
                }
                if (fVar == null || fVar.aIv() != 1) {
                    this.eah.mIsFromCDN = false;
                } else {
                    this.eah.mIsFromCDN = true;
                }
                erVar15 = this.eah.dZk;
                z4 = this.eah.mIsFromCDN;
                erVar15.iL(z4);
                z5 = this.eah.dZq;
                if (!z5) {
                    z6 = this.eah.dZr;
                    if (z6) {
                        z7 = this.eah.dZs;
                        if (!z7) {
                            PbActivity pbActivity2 = this.eah;
                            dcVar10 = this.eah.dYA;
                            pbActivity2.a(dcVar10.getPbData(), -1, false, true);
                            this.eah.dZs = true;
                            this.eah.dZq = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.eah;
                    dcVar18 = this.eah.dYA;
                    pbActivity3.a(dcVar18.getPbData(), -1, 0, false, true);
                }
                erVar16 = this.eah.dZk;
                dcVar11 = this.eah.dYA;
                boolean aKl = dcVar11.aKl();
                dcVar12 = this.eah.dYA;
                erVar16.a(fVar, i2, i3, aKl, i4, dcVar12.getIsFromMark());
                erVar17 = this.eah.dZk;
                dcVar13 = this.eah.dYA;
                erVar17.a(fVar, dcVar13.aKl(), false, i2);
                erVar18 = this.eah.dZk;
                dcVar14 = this.eah.dYA;
                erVar18.iJ(dcVar14.getHostMode());
                dcVar15 = this.eah.dYA;
                if (dcVar15.aKH() != null) {
                    erVar19 = this.eah.dZk;
                    dcVar16 = this.eah.dYA;
                    erVar19.c(dcVar16.aKH().aKa());
                    erVar20 = this.eah.dZk;
                    dcVar17 = this.eah.dYA;
                    erVar20.iH(dcVar17.aKH().aKb());
                }
                AntiData qt = fVar.qt();
                if (qt != null) {
                    this.eah.awf = qt.getVoice_message();
                    str2 = this.eah.awf;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.eah.dZw;
                        if (eVar3 != null) {
                            eVar4 = this.eah.dZw;
                            if (eVar4.CB() != null) {
                                eVar5 = this.eah.dZw;
                                com.baidu.tbadk.editortools.p eA = eVar5.CB().eA(6);
                                if (eA != null) {
                                    str3 = this.eah.awf;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.eah.dgA;
                                        ((View) eA).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (str != null) {
                z3 = this.eah.dZt;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            dcVar = this.eah.dYA;
                            if (dcVar != null) {
                                dcVar2 = this.eah.dYA;
                                if (dcVar2.getAppealInfo() != null) {
                                    dcVar3 = this.eah.dYA;
                                    if (!StringUtils.isNull(dcVar3.getAppealInfo().dWv)) {
                                        erVar10 = this.eah.dZk;
                                        dcVar4 = this.eah.dYA;
                                        erVar10.a(dcVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.eah;
                            erVar9 = this.eah.dZk;
                            pbActivity4.showNetRefreshView(erVar9.getView(), this.eah.getPageContext().getResources().getString(r.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.eah.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.eah;
                            erVar7 = this.eah.dZk;
                            pbActivity5.showNetRefreshView(erVar7.getView(), this.eah.getPageContext().getResources().getString(r.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.eah.setNetRefreshViewEmotionDefMarginTop();
                        }
                        erVar8 = this.eah.dZk;
                        erVar8.aMk();
                    }
                } else {
                    this.eah.showToast(str);
                }
                erVar5 = this.eah.dZk;
                erVar5.ob(this.eah.getResources().getString(r.j.list_no_more));
                erVar6 = this.eah.dZk;
                erVar6.wq();
            }
            this.eah.aCf = System.currentTimeMillis() - currentTimeMillis;
            if (!this.eah.aJc().aKl() || this.eah.aJc().getPbData().getPage().qF() != 0 || this.eah.aJc().aKF()) {
                this.eah.dZx = true;
            }
            dcVar5 = this.eah.dYA;
            if (dcVar5 != null) {
                erVar11 = this.eah.dZk;
                if (erVar11 != null) {
                    dcVar6 = this.eah.dYA;
                    if (dcVar6.aKH() != null) {
                        dcVar7 = this.eah.dYA;
                        if (dcVar7.aKH().aJX()) {
                            erVar12 = this.eah.dZk;
                            erVar12.aKf();
                            dcVar8 = this.eah.dYA;
                            dcVar8.aKH().aJZ();
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
        dcVar23 = this.eah.dYA;
        dcVar23.nE(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.dc.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        er erVar;
        erVar = this.eah.dZk;
        erVar.j(fVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.dc.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.FU().FV()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.eah.bpV;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.eah.aBX;
            j4 = this.eah.createTime;
            j5 = this.eah.aCf;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.eah.createTime = 0L;
            this.eah.aBX = 0L;
            if (vVar != null) {
                vVar.FP();
            }
        }
    }
}
