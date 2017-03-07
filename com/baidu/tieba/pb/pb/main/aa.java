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
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        fa faVar;
        fa faVar2;
        fa faVar3;
        fa faVar4;
        boolean z2;
        fa faVar5;
        boolean z3;
        boolean z4;
        fa faVar6;
        fa faVar7;
        fa faVar8;
        fa faVar9;
        PbModel pbModel;
        fa faVar10;
        PbModel pbModel2;
        PbModel pbModel3;
        fa faVar11;
        PbModel pbModel4;
        PbModel pbModel5;
        fa faVar12;
        PbModel pbModel6;
        PbModel pbModel7;
        fa faVar13;
        PbModel pbModel8;
        fa faVar14;
        fa faVar15;
        com.baidu.tbadk.editortools.pb.c cVar;
        PbModel pbModel9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        fa faVar16;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        PbModel pbModel10;
        fa faVar17;
        PbModel pbModel11;
        PbModel pbModel12;
        fa faVar18;
        PbModel pbModel13;
        fa faVar19;
        PbModel pbModel14;
        PbModel pbModel15;
        String str2;
        com.baidu.tbadk.editortools.pb.c cVar3;
        com.baidu.tbadk.editortools.pb.c cVar4;
        com.baidu.tbadk.editortools.pb.c cVar5;
        String str3;
        View.OnClickListener onClickListener;
        fa faVar20;
        PbModel pbModel16;
        fa faVar21;
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
        fa faVar22;
        com.baidu.tbadk.editortools.pb.c cVar9;
        fa faVar23;
        fa faVar24;
        fa faVar25;
        PbModel pbModel23;
        if (!z || fVar == null || fVar.aJz() != null || com.baidu.tbadk.core.util.x.p(fVar.aJs()) >= 1) {
            this.elO.dMB = true;
            long currentTimeMillis = System.currentTimeMillis();
            faVar = this.elO.ekM;
            faVar.aNe();
            if (fVar != null && fVar.aJx()) {
                faVar25 = this.elO.ekM;
                if (faVar25.aMF() == null) {
                    this.elO.ela = true;
                }
            } else {
                PbActivity pbActivity = this.elO;
                faVar2 = this.elO.ekM;
                pbActivity.hideLoadingView(faVar2.getView());
            }
            faVar3 = this.elO.ekM;
            faVar3.ary();
            faVar4 = this.elO.ekM;
            faVar4.aMY();
            z2 = this.elO.ekG;
            if (z2) {
                faVar24 = this.elO.ekM;
                faVar24.aNu();
            } else {
                faVar5 = this.elO.ekM;
                faVar5.gC(false);
            }
            z3 = this.elO.mIsLoading;
            if (z3) {
                this.elO.mIsLoading = false;
                faVar23 = this.elO.ekM;
                faVar23.eqM.eud.setEnabled(true);
            }
            if (i4 == 0 && fVar != null) {
                this.elO.ekV = true;
            }
            if (z && fVar != null) {
                faVar14 = this.elO.ekM;
                faVar14.Kz();
                faVar15 = this.elO.ekM;
                faVar15.iR(fVar.aJx());
                if (fVar.aJq() != null && fVar.aJq().sM() != null) {
                    this.elO.a(fVar.aJq().sM());
                }
                cVar = this.elO.ekY;
                if (cVar != null) {
                    faVar22 = this.elO.ekM;
                    cVar9 = this.elO.ekY;
                    faVar22.gB(cVar9.Dw());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (fVar.aJs() != null && fVar.aJs().size() >= 1 && fVar.aJs().get(0) != null) {
                    String id = fVar.aJs().get(0).getId();
                    pbModel22 = this.elO.ejZ;
                    pbModel22.nw(id);
                } else if (fVar.aJz() != null) {
                    String id2 = fVar.aJz().getId();
                    pbModel9 = this.elO.ejZ;
                    pbModel9.nw(id2);
                }
                cVar2 = this.elO.ekY;
                if (cVar2 != null) {
                    cVar6 = this.elO.ekY;
                    cVar6.a(fVar.qE());
                    cVar7 = this.elO.ekY;
                    cVar7.a(fVar.aJp(), fVar.getUserData());
                    cVar8 = this.elO.ekY;
                    pbModel19 = this.elO.ejZ;
                    MetaData aLB = pbModel19.aLB();
                    pbModel20 = this.elO.ejZ;
                    String threadID = pbModel20.getThreadID();
                    pbModel21 = this.elO.ejZ;
                    cVar8.a(aLB, threadID, pbModel21.aLU());
                }
                aVar = this.elO.dIP;
                if (aVar != null) {
                    aVar2 = this.elO.dIP;
                    aVar2.ac(fVar.nH());
                }
                if (fVar == null || fVar.aJB() != 1) {
                    this.elO.mIsFromCDN = false;
                } else {
                    this.elO.mIsFromCDN = true;
                }
                faVar16 = this.elO.ekM;
                z5 = this.elO.mIsFromCDN;
                faVar16.iQ(z5);
                z6 = this.elO.ekS;
                if (!z6) {
                    z7 = this.elO.ekT;
                    if (z7) {
                        z8 = this.elO.ekU;
                        if (!z8) {
                            PbActivity pbActivity2 = this.elO;
                            pbModel10 = this.elO.ejZ;
                            pbActivity2.a(pbModel10.getPbData(), -1, false, true);
                            this.elO.ekU = true;
                            this.elO.ekS = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.elO;
                    pbModel18 = this.elO.ejZ;
                    pbActivity3.a(pbModel18.getPbData(), -1, 0, false, true);
                }
                faVar17 = this.elO.ekM;
                pbModel11 = this.elO.ejZ;
                boolean aLu = pbModel11.aLu();
                pbModel12 = this.elO.ejZ;
                faVar17.a(fVar, i2, i3, aLu, i4, pbModel12.getIsFromMark());
                faVar18 = this.elO.ekM;
                pbModel13 = this.elO.ejZ;
                faVar18.e(fVar, pbModel13.aLu());
                faVar19 = this.elO.ekM;
                pbModel14 = this.elO.ejZ;
                faVar19.iO(pbModel14.getHostMode());
                pbModel15 = this.elO.ejZ;
                if (pbModel15.aLQ() != null) {
                    faVar20 = this.elO.ekM;
                    pbModel16 = this.elO.ejZ;
                    faVar20.b(pbModel16.aLQ().aLj());
                    faVar21 = this.elO.ekM;
                    pbModel17 = this.elO.ejZ;
                    faVar21.iM(pbModel17.aLQ().aLk());
                }
                AntiData qE = fVar.qE();
                if (qE != null) {
                    this.elO.aAE = qE.getVoice_message();
                    str2 = this.elO.aAE;
                    if (!StringUtils.isNull(str2)) {
                        cVar3 = this.elO.ekY;
                        if (cVar3 != null) {
                            cVar4 = this.elO.ekY;
                            if (cVar4.CP() != null) {
                                cVar5 = this.elO.ekY;
                                com.baidu.tbadk.editortools.p ew = cVar5.CP().ew(6);
                                if (ew != null) {
                                    str3 = this.elO.aAE;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.elO.dqd;
                                        ((View) ew).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (str != null) {
                z4 = this.elO.ekV;
                if (!z4 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            pbModel = this.elO.ejZ;
                            if (pbModel != null) {
                                pbModel2 = this.elO.ejZ;
                                if (pbModel2.getAppealInfo() != null) {
                                    pbModel3 = this.elO.ejZ;
                                    if (!StringUtils.isNull(pbModel3.getAppealInfo().ehJ)) {
                                        faVar11 = this.elO.ekM;
                                        pbModel4 = this.elO.ejZ;
                                        faVar11.a(pbModel4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.elO;
                            faVar10 = this.elO.ekM;
                            pbActivity4.showNetRefreshView(faVar10.getView(), this.elO.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.elO.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.elO.getApplicationContext(), w.f.ds200));
                        } else {
                            PbActivity pbActivity5 = this.elO;
                            faVar8 = this.elO.ekM;
                            pbActivity5.showNetRefreshView(faVar8.getView(), this.elO.getPageContext().getResources().getString(w.l.net_error_text, str, Integer.valueOf(i)), true);
                            this.elO.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(this.elO.getApplicationContext(), w.f.ds200));
                        }
                        faVar9 = this.elO.ekM;
                        faVar9.aNu();
                    }
                } else {
                    this.elO.showToast(str);
                }
                faVar6 = this.elO.ekM;
                faVar6.nz(this.elO.getResources().getString(w.l.list_no_more));
                faVar7 = this.elO.ekM;
                faVar7.wI();
            }
            this.elO.aGp = System.currentTimeMillis() - currentTimeMillis;
            if (!this.elO.aKk().aLu() || this.elO.aKk().getPbData().getPage().qR() != 0 || this.elO.aKk().aLO()) {
                this.elO.ekZ = true;
            }
            pbModel5 = this.elO.ejZ;
            if (pbModel5 != null) {
                faVar12 = this.elO.ekM;
                if (faVar12 != null) {
                    pbModel6 = this.elO.ejZ;
                    if (pbModel6.aLQ() != null) {
                        pbModel7 = this.elO.ejZ;
                        if (pbModel7.aLQ().aLg()) {
                            faVar13 = this.elO.ekM;
                            faVar13.aLo();
                            pbModel8 = this.elO.ejZ;
                            pbModel8.aLQ().aLi();
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
        pbModel23 = this.elO.ejZ;
        pbModel23.oj(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
        fa faVar;
        faVar = this.elO.ekM;
        faVar.k(fVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.Gi().Gj()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.elO.bEN;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.elO.aGh;
            j4 = this.elO.createTime;
            j5 = this.elO.aGp;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.elO.createTime = 0L;
            this.elO.aGh = 0L;
            if (vVar != null) {
                vVar.Gd();
            }
        }
    }
}
