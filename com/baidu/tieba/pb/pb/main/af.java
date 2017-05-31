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
class af implements PbModel.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03a1  */
    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        fx fxVar4;
        boolean z2;
        fx fxVar5;
        boolean z3;
        boolean z4;
        fx fxVar6;
        fx fxVar7;
        fx fxVar8;
        fx fxVar9;
        fx fxVar10;
        PbModel pbModel;
        fx fxVar11;
        PbModel pbModel2;
        PbModel pbModel3;
        fx fxVar12;
        PbModel pbModel4;
        fx fxVar13;
        fx fxVar14;
        com.baidu.tbadk.editortools.pb.c cVar;
        PbModel pbModel5;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        fx fxVar15;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        PbModel pbModel6;
        fx fxVar16;
        PbModel pbModel7;
        PbModel pbModel8;
        fx fxVar17;
        PbModel pbModel9;
        fx fxVar18;
        PbModel pbModel10;
        PbModel pbModel11;
        boolean z9;
        PbModel pbModel12;
        SuggestEmotionModel.a aVar2;
        int aJM;
        String str2;
        com.baidu.tbadk.editortools.pb.c cVar3;
        com.baidu.tbadk.editortools.pb.c cVar4;
        com.baidu.tbadk.editortools.pb.c cVar5;
        String str3;
        View.OnClickListener onClickListener;
        fx fxVar19;
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
        fx fxVar20;
        com.baidu.tbadk.editortools.pb.c cVar10;
        fx fxVar21;
        fx fxVar22;
        fx fxVar23;
        fx fxVar24;
        PbModel pbModel19;
        if (!z || fVar == null || fVar.aIK() != null || com.baidu.tbadk.core.util.x.q(fVar.aID()) >= 1) {
            this.enc.dLm = true;
            long currentTimeMillis = System.currentTimeMillis();
            fxVar = this.enc.elU;
            fxVar.aMB();
            if (fVar != null && fVar.aIH()) {
                fxVar24 = this.enc.elU;
                if (fxVar24.aMc() == null) {
                    this.enc.emj = true;
                }
            } else {
                PbActivity pbActivity = this.enc;
                fxVar2 = this.enc.elU;
                pbActivity.hideLoadingView(fxVar2.getView());
            }
            fxVar3 = this.enc.elU;
            fxVar3.aqm();
            fxVar4 = this.enc.elU;
            fxVar4.aMv();
            z2 = this.enc.elN;
            if (!z2) {
                fxVar22 = this.enc.elU;
                if (!fxVar22.aNb()) {
                    fxVar23 = this.enc.elU;
                    fxVar23.gA(false);
                    z3 = this.enc.mIsLoading;
                    if (z3) {
                        this.enc.mIsLoading = false;
                        fxVar21 = this.enc.elU;
                        fxVar21.esG.exj.setEnabled(true);
                    }
                    if (i4 == 0 && fVar != null) {
                        this.enc.emd = true;
                    }
                    if (!z && fVar != null) {
                        fxVar13 = this.enc.elU;
                        fxVar13.My();
                        fxVar14 = this.enc.elU;
                        fxVar14.iU(fVar.aIH());
                        if (fVar.aIB() != null && fVar.aIB().sq() != null) {
                            this.enc.a(fVar.aIB().sq());
                        }
                        cVar = this.enc.emh;
                        if (cVar != null) {
                            fxVar20 = this.enc.elU;
                            cVar10 = this.enc.emh;
                            fxVar20.gz(cVar10.CS());
                        }
                        TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                        TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                        if (fVar.aID() != null && fVar.aID().size() >= 1 && fVar.aID().get(0) != null) {
                            String id = fVar.aID().get(0).getId();
                            pbModel18 = this.enc.ele;
                            pbModel18.nW(id);
                        } else if (fVar.aIK() != null) {
                            String id2 = fVar.aIK().getId();
                            pbModel5 = this.enc.ele;
                            pbModel5.nW(id2);
                        }
                        cVar2 = this.enc.emh;
                        if (cVar2 != null) {
                            cVar6 = this.enc.emh;
                            cVar6.a(fVar.qh());
                            cVar7 = this.enc.emh;
                            cVar7.a(fVar.aIz(), fVar.getUserData());
                            cVar8 = this.enc.emh;
                            pbModel15 = this.enc.ele;
                            MetaData aKU = pbModel15.aKU();
                            pbModel16 = this.enc.ele;
                            String threadID = pbModel16.getThreadID();
                            pbModel17 = this.enc.ele;
                            cVar8.a(aKU, threadID, pbModel17.aLp());
                            if (fVar.aIB() != null) {
                                cVar9 = this.enc.emh;
                                cVar9.bG(fVar.aIB().sE());
                            }
                        }
                        aVar = this.enc.dHz;
                        if (aVar != null) {
                            aVar3 = this.enc.dHz;
                            aVar3.ac(fVar.nD());
                        }
                        if (fVar == null || fVar.aIN() != 1) {
                            this.enc.mIsFromCDN = false;
                        } else {
                            this.enc.mIsFromCDN = true;
                        }
                        fxVar15 = this.enc.elU;
                        z5 = this.enc.mIsFromCDN;
                        fxVar15.iT(z5);
                        z6 = this.enc.ema;
                        if (!z6) {
                            z7 = this.enc.emb;
                            if (z7) {
                                z8 = this.enc.emc;
                                if (!z8) {
                                    PbActivity pbActivity2 = this.enc;
                                    pbModel6 = this.enc.ele;
                                    pbActivity2.a(pbModel6.getPbData(), -1, false, true);
                                    this.enc.emc = true;
                                    this.enc.ema = true;
                                }
                            }
                        } else {
                            PbActivity pbActivity3 = this.enc;
                            pbModel14 = this.enc.ele;
                            pbActivity3.a(pbModel14.getPbData(), -1, 0, false, true);
                        }
                        fxVar16 = this.enc.elU;
                        pbModel7 = this.enc.ele;
                        boolean aKN = pbModel7.aKN();
                        pbModel8 = this.enc.ele;
                        fxVar16.a(fVar, i2, i3, aKN, i4, pbModel8.getIsFromMark());
                        fxVar17 = this.enc.elU;
                        pbModel9 = this.enc.ele;
                        fxVar17.e(fVar, pbModel9.aKN());
                        fxVar18 = this.enc.elU;
                        pbModel10 = this.enc.ele;
                        fxVar18.iR(pbModel10.getHostMode());
                        pbModel11 = this.enc.ele;
                        if (pbModel11.aLj() != null) {
                            fxVar19 = this.enc.elU;
                            pbModel13 = this.enc.ele;
                            fxVar19.iQ(pbModel13.aLj().aKI());
                        }
                        AntiData qh = fVar.qh();
                        if (qh != null) {
                            this.enc.aAG = qh.getVoice_message();
                            str2 = this.enc.aAG;
                            if (!StringUtils.isNull(str2)) {
                                cVar3 = this.enc.emh;
                                if (cVar3 != null) {
                                    cVar4 = this.enc.emh;
                                    if (cVar4.Cm() != null) {
                                        cVar5 = this.enc.emh;
                                        com.baidu.tbadk.editortools.p ew = cVar5.Cm().ew(6);
                                        if (ew != null) {
                                            str3 = this.enc.aAG;
                                            if (!TextUtils.isEmpty(str3)) {
                                                onClickListener = this.enc.dqr;
                                                ((View) ew).setOnClickListener(onClickListener);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.pb.e.nF(fVar.eiW);
                        z9 = this.enc.emf;
                        if (z9) {
                            this.enc.emf = false;
                            aJM = this.enc.aJM();
                            this.enc.aJE().getListView().setSelection(aJM);
                        }
                        pbModel12 = this.enc.ele;
                        ForumData aIz = fVar.aIz();
                        aVar2 = this.enc.emw;
                        pbModel12.a(aIz, aVar2);
                    } else if (str != null) {
                        z4 = this.enc.emd;
                        if (!z4 && i4 == 1) {
                            if (i2 == 3 || i2 == 4 || i2 == 6) {
                                if (i == 4) {
                                    pbModel = this.enc.ele;
                                    if (pbModel != null) {
                                        pbModel2 = this.enc.ele;
                                        if (pbModel2.getAppealInfo() != null) {
                                            pbModel3 = this.enc.ele;
                                            if (!StringUtils.isNull(pbModel3.getAppealInfo().eir)) {
                                                fxVar12 = this.enc.elU;
                                                pbModel4 = this.enc.ele;
                                                fxVar12.a(pbModel4.getAppealInfo());
                                            }
                                        }
                                    }
                                    PbActivity pbActivity4 = this.enc;
                                    fxVar11 = this.enc.elU;
                                    pbActivity4.showNetRefreshView(fxVar11.getView(), this.enc.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                                    this.enc.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.enc.getApplicationContext(), w.f.ds200));
                                } else {
                                    PbActivity pbActivity5 = this.enc;
                                    fxVar9 = this.enc.elU;
                                    pbActivity5.showNetRefreshView(fxVar9.getView(), this.enc.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                                    this.enc.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.enc.getApplicationContext(), w.f.ds200));
                                }
                                fxVar10 = this.enc.elU;
                                fxVar10.aMP();
                            }
                        } else {
                            this.enc.showToast(str);
                        }
                        if (i != -1) {
                            fxVar8 = this.enc.elU;
                            fxVar8.nY(this.enc.getResources().getString(w.l.list_no_more_new));
                        } else {
                            fxVar6 = this.enc.elU;
                            fxVar6.nY("");
                        }
                        fxVar7 = this.enc.elU;
                        fxVar7.wm();
                    }
                    this.enc.aGx = System.currentTimeMillis() - currentTimeMillis;
                    if (this.enc.aJF().aKN() || this.enc.aJF().getPbData().qx().qu() != 0 || this.enc.aJF().aLh()) {
                        this.enc.emi = true;
                        return;
                    }
                    return;
                }
            }
            fxVar5 = this.enc.elU;
            fxVar5.aMP();
            z3 = this.enc.mIsLoading;
            if (z3) {
            }
            if (i4 == 0) {
                this.enc.emd = true;
            }
            if (!z) {
            }
            if (str != null) {
            }
            this.enc.aGx = System.currentTimeMillis() - currentTimeMillis;
            if (this.enc.aJF().aKN()) {
            }
            this.enc.emi = true;
            return;
        }
        pbModel19 = this.enc.ele;
        pbModel19.oy(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        fx fxVar;
        fxVar = this.enc.elU;
        fxVar.l(fVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.j.aa.FE().FF()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.enc.bMF;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.enc.aGp;
            j4 = this.enc.createTime;
            j5 = this.enc.aGx;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.enc.createTime = 0L;
            this.enc.aGp = 0L;
            if (vVar != null) {
                vVar.Fz();
            }
        }
    }
}
