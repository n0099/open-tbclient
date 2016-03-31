package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ae implements df.c {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.df.c
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        eu euVar;
        eu euVar2;
        eu euVar3;
        eu euVar4;
        boolean z2;
        boolean z3;
        eu euVar5;
        eu euVar6;
        eu euVar7;
        eu euVar8;
        df dfVar;
        eu euVar9;
        df dfVar2;
        df dfVar3;
        eu euVar10;
        df dfVar4;
        df dfVar5;
        eu euVar11;
        df dfVar6;
        df dfVar7;
        eu euVar12;
        df dfVar8;
        eu euVar13;
        eu euVar14;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.baseEditMark.a aVar;
        eu euVar15;
        boolean z4;
        eu euVar16;
        df dfVar9;
        boolean z5;
        boolean z6;
        boolean z7;
        df dfVar10;
        eu euVar17;
        df dfVar11;
        df dfVar12;
        eu euVar18;
        df dfVar13;
        eu euVar19;
        df dfVar14;
        df dfVar15;
        df dfVar16;
        df dfVar17;
        eu euVar20;
        String str2;
        com.baidu.tbadk.editortools.d.e eVar4;
        com.baidu.tbadk.editortools.d.e eVar5;
        com.baidu.tbadk.editortools.d.e eVar6;
        String str3;
        View.OnClickListener onClickListener;
        eu euVar21;
        df dfVar18;
        eu euVar22;
        df dfVar19;
        df dfVar20;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.d.e eVar7;
        com.baidu.tbadk.editortools.d.e eVar8;
        com.baidu.tbadk.editortools.d.e eVar9;
        df dfVar21;
        df dfVar22;
        df dfVar23;
        df dfVar24;
        eu euVar23;
        com.baidu.tbadk.editortools.d.e eVar10;
        eu euVar24;
        df dfVar25;
        if (!z || eVar == null || eVar.avw() == null || eVar.avw().size() >= 1) {
            this.dht.dbx = true;
            long currentTimeMillis = System.currentTimeMillis();
            euVar = this.dht.dgF;
            euVar.ayH();
            if (eVar == null || !eVar.avA()) {
                PbActivity pbActivity = this.dht;
                euVar2 = this.dht.dgF;
                pbActivity.hideLoadingView(euVar2.getView());
            }
            euVar3 = this.dht.dgF;
            euVar3.agg();
            euVar4 = this.dht.dgF;
            euVar4.eM(false);
            z2 = this.dht.mIsLoading;
            if (z2) {
                this.dht.mIsLoading = false;
                euVar24 = this.dht.dgF;
                euVar24.dkF.dnG.setEnabled(true);
            }
            if (i4 == 0 && eVar != null) {
                this.dht.bka = true;
            }
            if (z && eVar != null) {
                euVar13 = this.dht.dgF;
                euVar13.Mu();
                euVar14 = this.dht.dgF;
                euVar14.gy(eVar.avA());
                if (eVar.avv() != null && eVar.avv().tW() != null) {
                    this.dht.a(eVar.avv().tW());
                }
                eVar2 = this.dht.dgP;
                if (eVar2 != null) {
                    euVar23 = this.dht.dgF;
                    eVar10 = this.dht.dgP;
                    euVar23.eL(eVar10.DT());
                }
                TbadkCoreApplication.m411getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (eVar.avw() != null && eVar.avw().size() >= 1 && eVar.avw().get(0) != null) {
                    String id = eVar.avw().get(0).getId();
                    dfVar24 = this.dht.dfV;
                    dfVar24.lV(id);
                }
                eVar3 = this.dht.dgP;
                if (eVar3 != null) {
                    eVar7 = this.dht.dgP;
                    eVar7.a(eVar.sf());
                    eVar8 = this.dht.dgP;
                    eVar8.a(eVar.avu(), eVar.getUserData());
                    eVar9 = this.dht.dgP;
                    dfVar21 = this.dht.dfV;
                    MetaData axl = dfVar21.axl();
                    dfVar22 = this.dht.dfV;
                    String threadID = dfVar22.getThreadID();
                    dfVar23 = this.dht.dfV;
                    eVar9.a(axl, threadID, dfVar23.axa());
                }
                aVar = this.dht.cOZ;
                if (aVar != null) {
                    aVar2 = this.dht.cOZ;
                    aVar2.X(eVar.pu());
                }
                if (eVar == null || eVar.avC() != 1) {
                    this.dht.mIsFromCDN = false;
                } else {
                    this.dht.mIsFromCDN = true;
                }
                euVar15 = this.dht.dgF;
                z4 = this.dht.mIsFromCDN;
                euVar15.gw(z4);
                euVar16 = this.dht.dgF;
                dfVar9 = this.dht.dfV;
                euVar16.gq(dfVar9.axe());
                z5 = this.dht.dgK;
                if (!z5) {
                    z6 = this.dht.dgL;
                    if (z6) {
                        z7 = this.dht.dgM;
                        if (!z7) {
                            PbActivity pbActivity2 = this.dht;
                            dfVar10 = this.dht.dfV;
                            pbActivity2.b(dfVar10.getPbData(), -1, false, true);
                            this.dht.dgM = true;
                            this.dht.dgK = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.dht;
                    dfVar20 = this.dht.dfV;
                    pbActivity3.a(dfVar20.getPbData(), -1, false, true);
                }
                euVar17 = this.dht.dgF;
                dfVar11 = this.dht.dfV;
                boolean axe = dfVar11.axe();
                dfVar12 = this.dht.dfV;
                euVar17.a(eVar, i2, i3, axe, i4, dfVar12.getIsFromMark());
                euVar18 = this.dht.dgF;
                dfVar13 = this.dht.dfV;
                euVar18.a(eVar, dfVar13.axe(), false, i2);
                euVar19 = this.dht.dgF;
                dfVar14 = this.dht.dfV;
                euVar19.gu(dfVar14.getHostMode());
                dfVar15 = this.dht.dfV;
                if (dfVar15.axA() != null) {
                    euVar21 = this.dht.dgF;
                    dfVar18 = this.dht.dfV;
                    euVar21.b(dfVar18.axA().awW());
                    euVar22 = this.dht.dgF;
                    dfVar19 = this.dht.dfV;
                    euVar22.gs(dfVar19.axA().awX());
                }
                this.dht.awB();
                AntiData sf = eVar.sf();
                if (sf != null) {
                    this.dht.avB = sf.getVoice_message();
                    str2 = this.dht.avB;
                    if (!StringUtils.isNull(str2)) {
                        eVar4 = this.dht.dgP;
                        if (eVar4 != null) {
                            eVar5 = this.dht.dgP;
                            if (eVar5.Dh() != null) {
                                eVar6 = this.dht.dgP;
                                com.baidu.tbadk.editortools.s eA = eVar6.Dh().eA(6);
                                if (eA != null) {
                                    str3 = this.dht.avB;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.dht.cBv;
                                        ((View) eA).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                dfVar16 = this.dht.dfV;
                if (dfVar16.axA() != null) {
                    dfVar17 = this.dht.dfV;
                    if (dfVar17.axA().awZ()) {
                        euVar20 = this.dht.dgF;
                        euVar20.azn();
                    }
                }
            } else if (str != null) {
                z3 = this.dht.bka;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            dfVar = this.dht.dfV;
                            if (dfVar != null) {
                                dfVar2 = this.dht.dfV;
                                if (dfVar2.getAppealInfo() != null) {
                                    dfVar3 = this.dht.dfV;
                                    if (!StringUtils.isNull(dfVar3.getAppealInfo().dcF)) {
                                        euVar10 = this.dht.dgF;
                                        dfVar4 = this.dht.dfV;
                                        euVar10.a(dfVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.dht;
                            euVar9 = this.dht.dgF;
                            pbActivity4.showNetRefreshView(euVar9.getView(), this.dht.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), true);
                        } else {
                            PbActivity pbActivity5 = this.dht;
                            euVar7 = this.dht.dgF;
                            pbActivity5.showNetRefreshView(euVar7.getView(), this.dht.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), true);
                        }
                        euVar8 = this.dht.dgF;
                        euVar8.azd();
                    }
                } else {
                    this.dht.showToast(str);
                }
                euVar5 = this.dht.dgF;
                euVar5.mb(this.dht.getResources().getString(t.j.list_no_more));
                euVar6 = this.dht.dgF;
                euVar6.xv();
            }
            this.dht.aBB = System.currentTimeMillis() - currentTimeMillis;
            if (!this.dht.awj().axe() || this.dht.awj().getPbData().getPage().sr() != 0 || this.dht.awj().axy()) {
                this.dht.dgQ = true;
            }
            dfVar5 = this.dht.dfV;
            if (dfVar5 != null) {
                euVar11 = this.dht.dgF;
                if (euVar11 != null) {
                    dfVar6 = this.dht.dfV;
                    if (dfVar6.axA() != null) {
                        dfVar7 = this.dht.dfV;
                        if (dfVar7.axA().awT()) {
                            euVar12 = this.dht.dgF;
                            euVar12.ayK();
                            dfVar8 = this.dht.dfV;
                            dfVar8.axA().awV();
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
        dfVar25 = this.dht.dfV;
        dfVar25.lY(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.df.c
    public void c(com.baidu.tieba.pb.data.e eVar) {
        eu euVar;
        euVar = this.dht.dgF;
        euVar.j(eVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.df.c
    public void d(com.baidu.tbadk.performanceLog.v vVar) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (vVar != null) {
            j = this.dht.aBt;
            vVar.aBt = j;
            j2 = this.dht.createTime;
            vVar.aBu = j2;
            this.dht.createTime = 0L;
            this.dht.aBt = 0L;
            j3 = this.dht.aBB;
            vVar.aBB = j3;
            if (vVar.aBC == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j5 = this.dht.bbg;
                j4 = currentTimeMillis - j5;
            } else {
                j4 = vVar.aBC;
            }
            vVar.aBC = j4;
            vVar.GP();
        }
    }
}
