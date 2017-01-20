package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aa implements PbModel.a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        ez ezVar4;
        boolean z2;
        ez ezVar5;
        boolean z3;
        boolean z4;
        ez ezVar6;
        ez ezVar7;
        ez ezVar8;
        ez ezVar9;
        PbModel pbModel;
        ez ezVar10;
        PbModel pbModel2;
        PbModel pbModel3;
        ez ezVar11;
        PbModel pbModel4;
        PbModel pbModel5;
        ez ezVar12;
        PbModel pbModel6;
        PbModel pbModel7;
        ez ezVar13;
        PbModel pbModel8;
        ez ezVar14;
        ez ezVar15;
        com.baidu.tbadk.editortools.pb.c cVar;
        PbModel pbModel9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        ez ezVar16;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        PbModel pbModel10;
        ez ezVar17;
        PbModel pbModel11;
        PbModel pbModel12;
        ez ezVar18;
        PbModel pbModel13;
        ez ezVar19;
        PbModel pbModel14;
        PbModel pbModel15;
        String str2;
        com.baidu.tbadk.editortools.pb.c cVar3;
        com.baidu.tbadk.editortools.pb.c cVar4;
        com.baidu.tbadk.editortools.pb.c cVar5;
        String str3;
        View.OnClickListener onClickListener;
        ez ezVar20;
        PbModel pbModel16;
        ez ezVar21;
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
        ez ezVar22;
        com.baidu.tbadk.editortools.pb.c cVar9;
        ez ezVar23;
        ez ezVar24;
        ez ezVar25;
        PbModel pbModel23;
        if (!z || fVar == null || fVar.aKi() != null || com.baidu.tbadk.core.util.w.r(fVar.aKb()) >= 1) {
            this.eiV.dJT = true;
            long currentTimeMillis = System.currentTimeMillis();
            ezVar = this.eiV.ehV;
            ezVar.aNL();
            if (fVar != null && fVar.aKg()) {
                ezVar25 = this.eiV.ehV;
                if (ezVar25.aNm() == null) {
                    this.eiV.eij = true;
                }
            } else {
                PbActivity pbActivity = this.eiV;
                ezVar2 = this.eiV.ehV;
                pbActivity.hideLoadingView(ezVar2.getView());
            }
            ezVar3 = this.eiV.ehV;
            ezVar3.asd();
            ezVar4 = this.eiV.ehV;
            ezVar4.aNF();
            z2 = this.eiV.ehO;
            if (z2) {
                ezVar24 = this.eiV.ehV;
                ezVar24.aOa();
            } else {
                ezVar5 = this.eiV.ehV;
                ezVar5.gL(false);
            }
            z3 = this.eiV.mIsLoading;
            if (z3) {
                this.eiV.mIsLoading = false;
                ezVar23 = this.eiV.ehV;
                ezVar23.enK.eqS.setEnabled(true);
            }
            if (i4 == 0 && fVar != null) {
                this.eiV.eie = true;
            }
            if (z && fVar != null) {
                ezVar14 = this.eiV.ehV;
                ezVar14.JU();
                ezVar15 = this.eiV.ehV;
                ezVar15.iW(fVar.aKg());
                if (fVar.aJZ() != null && fVar.aJZ().sr() != null) {
                    this.eiV.a(fVar.aJZ().sr());
                }
                cVar = this.eiV.eih;
                if (cVar != null) {
                    ezVar22 = this.eiV.ehV;
                    cVar9 = this.eiV.eih;
                    ezVar22.gK(cVar9.Dd());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (fVar.aKb() != null && fVar.aKb().size() >= 1 && fVar.aKb().get(0) != null) {
                    String id = fVar.aKb().get(0).getId();
                    pbModel22 = this.eiV.ehh;
                    pbModel22.op(id);
                } else if (fVar.aKi() != null) {
                    String id2 = fVar.aKi().getId();
                    pbModel9 = this.eiV.ehh;
                    pbModel9.op(id2);
                }
                cVar2 = this.eiV.eih;
                if (cVar2 != null) {
                    cVar6 = this.eiV.eih;
                    cVar6.a(fVar.qm());
                    cVar7 = this.eiV.eih;
                    cVar7.a(fVar.aJY(), fVar.getUserData());
                    cVar8 = this.eiV.eih;
                    pbModel19 = this.eiV.ehh;
                    MetaData aMf = pbModel19.aMf();
                    pbModel20 = this.eiV.ehh;
                    String threadID = pbModel20.getThreadID();
                    pbModel21 = this.eiV.ehh;
                    cVar8.a(aMf, threadID, pbModel21.aMx());
                }
                aVar = this.eiV.dGi;
                if (aVar != null) {
                    aVar2 = this.eiV.dGi;
                    aVar2.ad(fVar.nt());
                }
                if (fVar == null || fVar.aKk() != 1) {
                    this.eiV.mIsFromCDN = false;
                } else {
                    this.eiV.mIsFromCDN = true;
                }
                ezVar16 = this.eiV.ehV;
                z5 = this.eiV.mIsFromCDN;
                ezVar16.iV(z5);
                z6 = this.eiV.eib;
                if (!z6) {
                    z7 = this.eiV.eic;
                    if (z7) {
                        z8 = this.eiV.eid;
                        if (!z8) {
                            PbActivity pbActivity2 = this.eiV;
                            pbModel10 = this.eiV.ehh;
                            pbActivity2.a(pbModel10.getPbData(), -1, false, true);
                            this.eiV.eid = true;
                            this.eiV.eib = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.eiV;
                    pbModel18 = this.eiV.ehh;
                    pbActivity3.a(pbModel18.getPbData(), -1, 0, false, true);
                }
                ezVar17 = this.eiV.ehV;
                pbModel11 = this.eiV.ehh;
                boolean aLY = pbModel11.aLY();
                pbModel12 = this.eiV.ehh;
                ezVar17.a(fVar, i2, i3, aLY, i4, pbModel12.getIsFromMark());
                ezVar18 = this.eiV.ehV;
                pbModel13 = this.eiV.ehh;
                ezVar18.a(fVar, pbModel13.aLY(), false, i2);
                ezVar19 = this.eiV.ehV;
                pbModel14 = this.eiV.ehh;
                ezVar19.iT(pbModel14.getHostMode());
                pbModel15 = this.eiV.ehh;
                if (pbModel15.aMu() != null) {
                    ezVar20 = this.eiV.ehV;
                    pbModel16 = this.eiV.ehh;
                    ezVar20.b(pbModel16.aMu().aLN());
                    ezVar21 = this.eiV.ehV;
                    pbModel17 = this.eiV.ehh;
                    ezVar21.iR(pbModel17.aMu().aLO());
                }
                AntiData qm = fVar.qm();
                if (qm != null) {
                    this.eiV.avj = qm.getVoice_message();
                    str2 = this.eiV.avj;
                    if (!StringUtils.isNull(str2)) {
                        cVar3 = this.eiV.eih;
                        if (cVar3 != null) {
                            cVar4 = this.eiV.eih;
                            if (cVar4.Cw() != null) {
                                cVar5 = this.eiV.eih;
                                com.baidu.tbadk.editortools.p eB = cVar5.Cw().eB(6);
                                if (eB != null) {
                                    str3 = this.eiV.avj;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.eiV.dnJ;
                                        ((View) eB).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (str != null) {
                z4 = this.eiV.eie;
                if (!z4 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            pbModel = this.eiV.ehh;
                            if (pbModel != null) {
                                pbModel2 = this.eiV.ehh;
                                if (pbModel2.getAppealInfo() != null) {
                                    pbModel3 = this.eiV.ehh;
                                    if (!StringUtils.isNull(pbModel3.getAppealInfo().efo)) {
                                        ezVar11 = this.eiV.ehV;
                                        pbModel4 = this.eiV.ehh;
                                        ezVar11.a(pbModel4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.eiV;
                            ezVar10 = this.eiV.ehV;
                            pbActivity4.showNetRefreshView(ezVar10.getView(), this.eiV.getPageContext().getResources().getString(r.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.eiV.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.eiV;
                            ezVar8 = this.eiV.ehV;
                            pbActivity5.showNetRefreshView(ezVar8.getView(), this.eiV.getPageContext().getResources().getString(r.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.eiV.setNetRefreshViewEmotionDefMarginTop();
                        }
                        ezVar9 = this.eiV.ehV;
                        ezVar9.aOa();
                    }
                } else {
                    this.eiV.showToast(str);
                }
                ezVar6 = this.eiV.ehV;
                ezVar6.os(this.eiV.getResources().getString(r.l.list_no_more));
                ezVar7 = this.eiV.ehV;
                ezVar7.wl();
            }
            this.eiV.aAX = System.currentTimeMillis() - currentTimeMillis;
            if (!this.eiV.aKP().aLY() || this.eiV.aKP().getPbData().getPage().qy() != 0 || this.eiV.aKP().aMs()) {
                this.eiV.eii = true;
            }
            pbModel5 = this.eiV.ehh;
            if (pbModel5 != null) {
                ezVar12 = this.eiV.ehV;
                if (ezVar12 != null) {
                    pbModel6 = this.eiV.ehh;
                    if (pbModel6.aMu() != null) {
                        pbModel7 = this.eiV.ehh;
                        if (pbModel7.aMu().aLK()) {
                            ezVar13 = this.eiV.ehV;
                            ezVar13.aLS();
                            pbModel8 = this.eiV.ehh;
                            pbModel8.aMu().aLM();
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
        pbModel23 = this.eiV.ehh;
        pbModel23.ov(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        ez ezVar;
        ezVar = this.eiV.ehV;
        ezVar.j(fVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.FO().FP()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.eiV.bxH;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.eiV.aAP;
            j4 = this.eiV.createTime;
            j5 = this.eiV.aAX;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.eiV.createTime = 0L;
            this.eiV.aAP = 0L;
            if (vVar != null) {
                vVar.FJ();
            }
        }
    }
}
