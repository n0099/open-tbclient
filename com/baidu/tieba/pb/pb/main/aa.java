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
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.ejU = pbActivity;
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
        if (!z || fVar == null || fVar.aJG() != null || com.baidu.tbadk.core.util.x.p(fVar.aJz()) >= 1) {
            this.ejU.dJd = true;
            long currentTimeMillis = System.currentTimeMillis();
            eyVar = this.ejU.eiS;
            eyVar.aNn();
            if (fVar != null && fVar.aJE()) {
                eyVar25 = this.ejU.eiS;
                if (eyVar25.aMO() == null) {
                    this.ejU.ejg = true;
                }
            } else {
                PbActivity pbActivity = this.ejU;
                eyVar2 = this.ejU.eiS;
                pbActivity.hideLoadingView(eyVar2.getView());
            }
            eyVar3 = this.ejU.eiS;
            eyVar3.arr();
            eyVar4 = this.ejU.eiS;
            eyVar4.aNh();
            z2 = this.ejU.eiM;
            if (z2) {
                eyVar24 = this.ejU.eiS;
                eyVar24.aND();
            } else {
                eyVar5 = this.ejU.eiS;
                eyVar5.gC(false);
            }
            z3 = this.ejU.mIsLoading;
            if (z3) {
                this.ejU.mIsLoading = false;
                eyVar23 = this.ejU.eiS;
                eyVar23.eoV.esg.setEnabled(true);
            }
            if (i4 == 0 && fVar != null) {
                this.ejU.ejb = true;
            }
            if (z && fVar != null) {
                eyVar14 = this.ejU.eiS;
                eyVar14.KZ();
                eyVar15 = this.ejU.eiS;
                eyVar15.iQ(fVar.aJE());
                if (fVar.aJx() != null && fVar.aJx().tk() != null) {
                    this.ejU.a(fVar.aJx().tk());
                }
                cVar = this.ejU.eje;
                if (cVar != null) {
                    eyVar22 = this.ejU.eiS;
                    cVar9 = this.ejU.eje;
                    eyVar22.gB(cVar9.DU());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (fVar.aJz() != null && fVar.aJz().size() >= 1 && fVar.aJz().get(0) != null) {
                    String id = fVar.aJz().get(0).getId();
                    pbModel22 = this.ejU.eif;
                    pbModel22.nC(id);
                } else if (fVar.aJG() != null) {
                    String id2 = fVar.aJG().getId();
                    pbModel9 = this.ejU.eif;
                    pbModel9.nC(id2);
                }
                cVar2 = this.ejU.eje;
                if (cVar2 != null) {
                    cVar6 = this.ejU.eje;
                    cVar6.a(fVar.rb());
                    cVar7 = this.ejU.eje;
                    cVar7.a(fVar.aJw(), fVar.getUserData());
                    cVar8 = this.ejU.eje;
                    pbModel19 = this.ejU.eif;
                    MetaData aLK = pbModel19.aLK();
                    pbModel20 = this.ejU.eif;
                    String threadID = pbModel20.getThreadID();
                    pbModel21 = this.ejU.eif;
                    cVar8.a(aLK, threadID, pbModel21.aMd());
                }
                aVar = this.ejU.dFo;
                if (aVar != null) {
                    aVar2 = this.ejU.dFo;
                    aVar2.ae(fVar.oe());
                }
                if (fVar == null || fVar.aJI() != 1) {
                    this.ejU.mIsFromCDN = false;
                } else {
                    this.ejU.mIsFromCDN = true;
                }
                eyVar16 = this.ejU.eiS;
                z5 = this.ejU.mIsFromCDN;
                eyVar16.iP(z5);
                z6 = this.ejU.eiY;
                if (!z6) {
                    z7 = this.ejU.eiZ;
                    if (z7) {
                        z8 = this.ejU.eja;
                        if (!z8) {
                            PbActivity pbActivity2 = this.ejU;
                            pbModel10 = this.ejU.eif;
                            pbActivity2.a(pbModel10.getPbData(), -1, false, true);
                            this.ejU.eja = true;
                            this.ejU.eiY = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.ejU;
                    pbModel18 = this.ejU.eif;
                    pbActivity3.a(pbModel18.getPbData(), -1, 0, false, true);
                }
                eyVar17 = this.ejU.eiS;
                pbModel11 = this.ejU.eif;
                boolean aLC = pbModel11.aLC();
                pbModel12 = this.ejU.eif;
                eyVar17.a(fVar, i2, i3, aLC, i4, pbModel12.getIsFromMark());
                eyVar18 = this.ejU.eiS;
                pbModel13 = this.ejU.eif;
                eyVar18.e(fVar, pbModel13.aLC());
                eyVar19 = this.ejU.eiS;
                pbModel14 = this.ejU.eif;
                eyVar19.iN(pbModel14.getHostMode());
                pbModel15 = this.ejU.eif;
                if (pbModel15.aLZ() != null) {
                    eyVar20 = this.ejU.eiS;
                    pbModel16 = this.ejU.eif;
                    eyVar20.b(pbModel16.aLZ().aLr());
                    eyVar21 = this.ejU.eiS;
                    pbModel17 = this.ejU.eif;
                    eyVar21.iL(pbModel17.aLZ().aLs());
                }
                AntiData rb = fVar.rb();
                if (rb != null) {
                    this.ejU.aAU = rb.getVoice_message();
                    str2 = this.ejU.aAU;
                    if (!StringUtils.isNull(str2)) {
                        cVar3 = this.ejU.eje;
                        if (cVar3 != null) {
                            cVar4 = this.ejU.eje;
                            if (cVar4.Dn() != null) {
                                cVar5 = this.ejU.eje;
                                com.baidu.tbadk.editortools.p ez = cVar5.Dn().ez(6);
                                if (ez != null) {
                                    str3 = this.ejU.aAU;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.ejU.doC;
                                        ((View) ez).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (str != null) {
                z4 = this.ejU.ejb;
                if (!z4 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            pbModel = this.ejU.eif;
                            if (pbModel != null) {
                                pbModel2 = this.ejU.eif;
                                if (pbModel2.getAppealInfo() != null) {
                                    pbModel3 = this.ejU.eif;
                                    if (!StringUtils.isNull(pbModel3.getAppealInfo().efQ)) {
                                        eyVar11 = this.ejU.eiS;
                                        pbModel4 = this.ejU.eif;
                                        eyVar11.a(pbModel4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.ejU;
                            eyVar10 = this.ejU.eiS;
                            pbActivity4.showNetRefreshView(eyVar10.getView(), this.ejU.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.ejU.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ejU.getApplicationContext(), w.f.ds200));
                        } else {
                            PbActivity pbActivity5 = this.ejU;
                            eyVar8 = this.ejU.eiS;
                            pbActivity5.showNetRefreshView(eyVar8.getView(), this.ejU.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.ejU.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ejU.getApplicationContext(), w.f.ds200));
                        }
                        eyVar9 = this.ejU.eiS;
                        eyVar9.aND();
                    }
                } else {
                    this.ejU.showToast(str);
                }
                eyVar6 = this.ejU.eiS;
                eyVar6.nF(this.ejU.getResources().getString(w.l.list_no_more));
                eyVar7 = this.ejU.eiS;
                eyVar7.xe();
            }
            this.ejU.aGE = System.currentTimeMillis() - currentTimeMillis;
            if (!this.ejU.aKr().aLC() || this.ejU.aKr().getPbData().rr().ro() != 0 || this.ejU.aKr().aLX()) {
                this.ejU.ejf = true;
            }
            pbModel5 = this.ejU.eif;
            if (pbModel5 != null) {
                eyVar12 = this.ejU.eiS;
                if (eyVar12 != null) {
                    pbModel6 = this.ejU.eif;
                    if (pbModel6.aLZ() != null) {
                        pbModel7 = this.ejU.eif;
                        if (pbModel7.aLZ().aLo()) {
                            eyVar13 = this.ejU.eiS;
                            eyVar13.aLw();
                            pbModel8 = this.ejU.eif;
                            pbModel8.aLZ().aLq();
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
        pbModel23 = this.ejU.eif;
        pbModel23.oh(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        ey eyVar;
        eyVar = this.ejU.eiS;
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
                j6 = this.ejU.bEG;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.ejU.aGw;
            j4 = this.ejU.createTime;
            j5 = this.ejU.aGE;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.ejU.createTime = 0L;
            this.ejU.aGw = 0L;
            if (vVar != null) {
                vVar.GB();
            }
        }
    }
}
