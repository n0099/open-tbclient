package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ah implements PbModel.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03a1  */
    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        gg ggVar4;
        boolean z2;
        gg ggVar5;
        boolean z3;
        boolean z4;
        gg ggVar6;
        gg ggVar7;
        gg ggVar8;
        gg ggVar9;
        gg ggVar10;
        PbModel pbModel;
        gg ggVar11;
        PbModel pbModel2;
        PbModel pbModel3;
        gg ggVar12;
        PbModel pbModel4;
        gg ggVar13;
        gg ggVar14;
        com.baidu.tbadk.editortools.pb.c cVar;
        PbModel pbModel5;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        gg ggVar15;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        PbModel pbModel6;
        gg ggVar16;
        PbModel pbModel7;
        PbModel pbModel8;
        gg ggVar17;
        PbModel pbModel9;
        gg ggVar18;
        PbModel pbModel10;
        PbModel pbModel11;
        boolean z9;
        PbModel pbModel12;
        SuggestEmotionModel.a aVar2;
        int aNI;
        String str2;
        com.baidu.tbadk.editortools.pb.c cVar3;
        com.baidu.tbadk.editortools.pb.c cVar4;
        com.baidu.tbadk.editortools.pb.c cVar5;
        String str3;
        View.OnClickListener onClickListener;
        gg ggVar19;
        PbModel pbModel13;
        PbModel pbModel14;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.editortools.pb.c cVar6;
        com.baidu.tbadk.editortools.pb.c cVar7;
        com.baidu.tbadk.editortools.pb.c cVar8;
        PbModel pbModel15;
        PbModel pbModel16;
        PbModel pbModel17;
        com.baidu.tbadk.editortools.pb.c cVar9;
        PbModel pbModel18;
        gg ggVar20;
        com.baidu.tbadk.editortools.pb.c cVar10;
        gg ggVar21;
        gg ggVar22;
        gg ggVar23;
        gg ggVar24;
        PbModel pbModel19;
        if (!z || fVar == null || fVar.aME() != null || com.baidu.tbadk.core.util.z.s(fVar.aMx()) >= 1) {
            this.ewh.dTL = true;
            long currentTimeMillis = System.currentTimeMillis();
            ggVar = this.ewh.euU;
            ggVar.aQz();
            if (fVar != null && fVar.aMB()) {
                ggVar24 = this.ewh.euU;
                if (ggVar24.aQa() == null) {
                    this.ewh.evj = true;
                }
            } else {
                PbActivity pbActivity = this.ewh;
                ggVar2 = this.ewh.euU;
                pbActivity.hideLoadingView(ggVar2.getView());
            }
            ggVar3 = this.ewh.euU;
            ggVar3.atX();
            ggVar4 = this.ewh.euU;
            ggVar4.aQt();
            z2 = this.ewh.euN;
            if (!z2) {
                ggVar22 = this.ewh.euU;
                if (!ggVar22.aQZ()) {
                    ggVar23 = this.ewh.euU;
                    ggVar23.gU(false);
                    z3 = this.ewh.mIsLoading;
                    if (z3) {
                        this.ewh.mIsLoading = false;
                        ggVar21 = this.ewh.euU;
                        ggVar21.eBR.eGI.setEnabled(true);
                    }
                    if (i4 == 0 && fVar != null) {
                        this.ewh.evd = true;
                    }
                    if (!z && fVar != null) {
                        ggVar13 = this.ewh.euU;
                        ggVar13.Nq();
                        ggVar14 = this.ewh.euU;
                        ggVar14.jq(fVar.aMB());
                        if (fVar.aMv() != null && fVar.aMv().sn() != null) {
                            this.ewh.a(fVar.aMv().sn());
                        }
                        cVar = this.ewh.evh;
                        if (cVar != null) {
                            ggVar20 = this.ewh.euU;
                            cVar10 = this.ewh.evh;
                            ggVar20.gT(cVar10.Dm());
                        }
                        TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                        TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                        if (fVar.aMx() != null && fVar.aMx().size() >= 1 && fVar.aMx().get(0) != null) {
                            String id = fVar.aMx().get(0).getId();
                            pbModel18 = this.ewh.eue;
                            pbModel18.oR(id);
                        } else if (fVar.aME() != null) {
                            String id2 = fVar.aME().getId();
                            pbModel5 = this.ewh.eue;
                            pbModel5.oR(id2);
                        }
                        cVar2 = this.ewh.evh;
                        if (cVar2 != null) {
                            cVar6 = this.ewh.evh;
                            cVar6.a(fVar.qe());
                            cVar7 = this.ewh.evh;
                            cVar7.a(fVar.aMt(), fVar.getUserData());
                            cVar8 = this.ewh.evh;
                            pbModel15 = this.ewh.eue;
                            MetaData aOR = pbModel15.aOR();
                            pbModel16 = this.ewh.eue;
                            String threadID = pbModel16.getThreadID();
                            pbModel17 = this.ewh.eue;
                            cVar8.a(aOR, threadID, pbModel17.aPn());
                            if (fVar.aMv() != null) {
                                cVar9 = this.ewh.evh;
                                cVar9.bI(fVar.aMv().sC());
                            }
                        }
                        aVar = this.ewh.dPW;
                        if (aVar != null) {
                            aVar3 = this.ewh.dPW;
                            aVar3.ac(fVar.nz());
                        }
                        if (fVar == null || fVar.aMH() != 1) {
                            this.ewh.mIsFromCDN = false;
                        } else {
                            this.ewh.mIsFromCDN = true;
                        }
                        ggVar15 = this.ewh.euU;
                        z5 = this.ewh.mIsFromCDN;
                        ggVar15.jp(z5);
                        z6 = this.ewh.eva;
                        if (!z6) {
                            z7 = this.ewh.evb;
                            if (z7) {
                                z8 = this.ewh.evc;
                                if (!z8) {
                                    PbActivity pbActivity2 = this.ewh;
                                    pbModel6 = this.ewh.eue;
                                    pbActivity2.a(pbModel6.getPbData(), -1, false, true);
                                    this.ewh.evc = true;
                                    this.ewh.eva = true;
                                }
                            }
                        } else {
                            PbActivity pbActivity3 = this.ewh;
                            pbModel14 = this.ewh.eue;
                            pbActivity3.a(pbModel14.getPbData(), -1, 0, false, true);
                        }
                        ggVar16 = this.ewh.euU;
                        pbModel7 = this.ewh.eue;
                        boolean aOK = pbModel7.aOK();
                        pbModel8 = this.ewh.eue;
                        ggVar16.a(fVar, i2, i3, aOK, i4, pbModel8.getIsFromMark());
                        ggVar17 = this.ewh.euU;
                        pbModel9 = this.ewh.eue;
                        ggVar17.e(fVar, pbModel9.aOK());
                        ggVar18 = this.ewh.euU;
                        pbModel10 = this.ewh.eue;
                        ggVar18.jn(pbModel10.getHostMode());
                        pbModel11 = this.ewh.eue;
                        if (pbModel11.aPg() != null) {
                            ggVar19 = this.ewh.euU;
                            pbModel13 = this.ewh.eue;
                            ggVar19.jm(pbModel13.aPg().aOF());
                        }
                        AntiData qe = fVar.qe();
                        if (qe != null) {
                            this.ewh.aBJ = qe.getVoice_message();
                            str2 = this.ewh.aBJ;
                            if (!StringUtils.isNull(str2)) {
                                cVar3 = this.ewh.evh;
                                if (cVar3 != null) {
                                    cVar4 = this.ewh.evh;
                                    if (cVar4.CG() != null) {
                                        cVar5 = this.ewh.evh;
                                        com.baidu.tbadk.editortools.p ey = cVar5.CG().ey(6);
                                        if (ey != null) {
                                            str3 = this.ewh.aBJ;
                                            if (!TextUtils.isEmpty(str3)) {
                                                onClickListener = this.ewh.dzf;
                                                ((View) ey).setOnClickListener(onClickListener);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.pb.i.oz(fVar.erT);
                        z9 = this.ewh.evf;
                        if (z9) {
                            this.ewh.evf = false;
                            aNI = this.ewh.aNI();
                            this.ewh.aNy().getListView().setSelection(aNI);
                        }
                        pbModel12 = this.ewh.eue;
                        ForumData aMt = fVar.aMt();
                        aVar2 = this.ewh.evA;
                        pbModel12.a(aMt, aVar2);
                    } else if (str != null) {
                        z4 = this.ewh.evd;
                        if (!z4 && i4 == 1) {
                            if (i2 == 3 || i2 == 4 || i2 == 6) {
                                if (i == 4) {
                                    pbModel = this.ewh.eue;
                                    if (pbModel != null) {
                                        pbModel2 = this.ewh.eue;
                                        if (pbModel2.getAppealInfo() != null) {
                                            pbModel3 = this.ewh.eue;
                                            if (!StringUtils.isNull(pbModel3.getAppealInfo().ero)) {
                                                ggVar12 = this.ewh.euU;
                                                pbModel4 = this.ewh.eue;
                                                ggVar12.a(pbModel4.getAppealInfo());
                                            }
                                        }
                                    }
                                    PbActivity pbActivity4 = this.ewh;
                                    ggVar11 = this.ewh.euU;
                                    pbActivity4.showNetRefreshView(ggVar11.getView(), this.ewh.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                                    this.ewh.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ewh.getApplicationContext(), w.f.ds200));
                                } else {
                                    PbActivity pbActivity5 = this.ewh;
                                    ggVar9 = this.ewh.euU;
                                    pbActivity5.showNetRefreshView(ggVar9.getView(), this.ewh.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                                    this.ewh.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.ewh.getApplicationContext(), w.f.ds200));
                                }
                                ggVar10 = this.ewh.euU;
                                ggVar10.aQN();
                            }
                        } else {
                            this.ewh.showToast(str);
                        }
                        if (i != -1) {
                            ggVar8 = this.ewh.euU;
                            ggVar8.oT(this.ewh.getResources().getString(w.l.list_no_more_new));
                        } else {
                            ggVar6 = this.ewh.euU;
                            ggVar6.oT("");
                        }
                        ggVar7 = this.ewh.euU;
                        ggVar7.wE();
                    }
                    this.ewh.aHL = System.currentTimeMillis() - currentTimeMillis;
                    if (this.ewh.aNz().aOK() || this.ewh.aNz().getPbData().qu().qr() != 0 || this.ewh.aNz().aPe()) {
                        this.ewh.evi = true;
                        return;
                    }
                    return;
                }
            }
            ggVar5 = this.ewh.euU;
            ggVar5.aQN();
            z3 = this.ewh.mIsLoading;
            if (z3) {
            }
            if (i4 == 0) {
                this.ewh.evd = true;
            }
            if (!z) {
            }
            if (str != null) {
            }
            this.ewh.aHL = System.currentTimeMillis() - currentTimeMillis;
            if (this.ewh.aNz().aOK()) {
            }
            this.ewh.evi = true;
            return;
        }
        pbModel19 = this.ewh.eue;
        pbModel19.oP(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        gg ggVar;
        ggVar = this.ewh.euU;
        ggVar.l(fVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.j.aa.Gb().Gc()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.ewh.bTh;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.ewh.aHD;
            j4 = this.ewh.createTime;
            j5 = this.ewh.aHL;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.ewh.createTime = 0L;
            this.ewh.aHD = 0L;
            if (vVar != null) {
                vVar.FW();
            }
        }
    }
}
