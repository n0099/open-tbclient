package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ab implements dh.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        ex exVar4;
        boolean z2;
        boolean z3;
        ex exVar5;
        ex exVar6;
        ex exVar7;
        ex exVar8;
        dh dhVar;
        ex exVar9;
        dh dhVar2;
        dh dhVar3;
        ex exVar10;
        dh dhVar4;
        dh dhVar5;
        ex exVar11;
        dh dhVar6;
        dh dhVar7;
        ex exVar12;
        dh dhVar8;
        ex exVar13;
        ex exVar14;
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        ex exVar15;
        boolean z4;
        ex exVar16;
        dh dhVar9;
        boolean z5;
        boolean z6;
        boolean z7;
        dh dhVar10;
        ex exVar17;
        dh dhVar11;
        dh dhVar12;
        ex exVar18;
        dh dhVar13;
        ex exVar19;
        dh dhVar14;
        dh dhVar15;
        dh dhVar16;
        dh dhVar17;
        ex exVar20;
        ex exVar21;
        String str2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.editortools.d.e eVar4;
        com.baidu.tbadk.editortools.d.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        ex exVar22;
        dh dhVar18;
        ex exVar23;
        dh dhVar19;
        dh dhVar20;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.d.e eVar6;
        com.baidu.tbadk.editortools.d.e eVar7;
        com.baidu.tbadk.editortools.d.e eVar8;
        dh dhVar21;
        dh dhVar22;
        dh dhVar23;
        dh dhVar24;
        ex exVar24;
        com.baidu.tbadk.editortools.d.e eVar9;
        ex exVar25;
        ex exVar26;
        dh dhVar25;
        if (!z || hVar == null || hVar.aLR() == null || hVar.aLR().size() >= 1) {
            this.eob.dOK = true;
            long currentTimeMillis = System.currentTimeMillis();
            exVar = this.eob.enh;
            exVar.aPs();
            if (hVar != null && hVar.aLW()) {
                exVar26 = this.eob.enh;
                if (exVar26.aOU() == null) {
                    this.eob.enu = true;
                }
            } else {
                PbActivity pbActivity = this.eob;
                exVar2 = this.eob.enh;
                pbActivity.hideLoadingView(exVar2.getView());
            }
            exVar3 = this.eob.enh;
            exVar3.auc();
            exVar4 = this.eob.enh;
            exVar4.gB(false);
            z2 = this.eob.mIsLoading;
            if (z2) {
                this.eob.mIsLoading = false;
                exVar25 = this.eob.enh;
                exVar25.erX.evd.setEnabled(true);
            }
            if (i4 == 0 && hVar != null) {
                this.eob.bOZ = true;
            }
            if (z && hVar != null) {
                exVar13 = this.eob.enh;
                exVar13.OG();
                exVar14 = this.eob.enh;
                exVar14.iA(hVar.aLW());
                if (hVar.aLQ() != null && hVar.aLQ().sw() != null) {
                    this.eob.a(hVar.aLQ().sw());
                }
                eVar = this.eob.ens;
                if (eVar != null) {
                    exVar24 = this.eob.enh;
                    eVar9 = this.eob.ens;
                    exVar24.gA(eVar9.Dr());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(hVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(hVar.getUserData().getBimg_end_time());
                if (hVar.aLR() != null && hVar.aLR().size() >= 1 && hVar.aLR().get(0) != null) {
                    String id = hVar.aLR().get(0).getId();
                    dhVar24 = this.eob.emx;
                    dhVar24.oS(id);
                }
                eVar2 = this.eob.ens;
                if (eVar2 != null) {
                    eVar6 = this.eob.ens;
                    eVar6.a(hVar.qf());
                    eVar7 = this.eob.ens;
                    eVar7.a(hVar.aLP(), hVar.getUserData());
                    eVar8 = this.eob.ens;
                    dhVar21 = this.eob.emx;
                    MetaData aNU = dhVar21.aNU();
                    dhVar22 = this.eob.emx;
                    String threadID = dhVar22.getThreadID();
                    dhVar23 = this.eob.emx;
                    eVar8.a(aNU, threadID, dhVar23.aNK());
                }
                aVar = this.eob.dKY;
                if (aVar != null) {
                    aVar2 = this.eob.dKY;
                    aVar2.ad(hVar.nv());
                }
                if (hVar == null || hVar.aLY() != 1) {
                    this.eob.mIsFromCDN = false;
                } else {
                    this.eob.mIsFromCDN = true;
                }
                exVar15 = this.eob.enh;
                z4 = this.eob.mIsFromCDN;
                exVar15.iz(z4);
                exVar16 = this.eob.enh;
                dhVar9 = this.eob.emx;
                exVar16.it(dhVar9.aNO());
                z5 = this.eob.enn;
                if (!z5) {
                    z6 = this.eob.eno;
                    if (z6) {
                        z7 = this.eob.enp;
                        if (!z7) {
                            PbActivity pbActivity2 = this.eob;
                            dhVar10 = this.eob.emx;
                            pbActivity2.a(dhVar10.getPbData(), -1, false, true);
                            this.eob.enp = true;
                            this.eob.enn = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.eob;
                    dhVar20 = this.eob.emx;
                    pbActivity3.a(dhVar20.getPbData(), -1, 0, false, true);
                }
                exVar17 = this.eob.enh;
                dhVar11 = this.eob.emx;
                boolean aNO = dhVar11.aNO();
                dhVar12 = this.eob.emx;
                exVar17.a(hVar, i2, i3, aNO, i4, dhVar12.getIsFromMark());
                exVar18 = this.eob.enh;
                dhVar13 = this.eob.emx;
                exVar18.a(hVar, dhVar13.aNO(), false, i2);
                exVar19 = this.eob.enh;
                dhVar14 = this.eob.emx;
                exVar19.ix(dhVar14.getHostMode());
                dhVar15 = this.eob.emx;
                if (dhVar15.aOj() != null) {
                    exVar22 = this.eob.enh;
                    dhVar18 = this.eob.emx;
                    exVar22.c(dhVar18.aOj().aNA());
                    if (hVar.aLQ() != null && hVar.aLQ().Uw == null) {
                        exVar23 = this.eob.enh;
                        dhVar19 = this.eob.emx;
                        exVar23.iv(dhVar19.aOj().aNB());
                    }
                }
                this.eob.aMW();
                AntiData qf = hVar.qf();
                if (qf != null) {
                    this.eob.awm = qf.getVoice_message();
                    str2 = this.eob.awm;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.eob.ens;
                        if (eVar3 != null) {
                            eVar4 = this.eob.ens;
                            if (eVar4.CG() != null) {
                                eVar5 = this.eob.ens;
                                com.baidu.tbadk.editortools.s ex = eVar5.CG().ex(6);
                                if (ex != null) {
                                    str3 = this.eob.awm;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.eob.dwy;
                                        ((View) ex).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                dhVar16 = this.eob.emx;
                if (dhVar16.aOj() != null) {
                    dhVar17 = this.eob.emx;
                    if (dhVar17.aOj().aND()) {
                        exVar20 = this.eob.enh;
                        if (!exVar20.aQa()) {
                            exVar21 = this.eob.enh;
                            exVar21.aNF();
                        }
                    }
                }
            } else if (str != null) {
                z3 = this.eob.bOZ;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            dhVar = this.eob.emx;
                            if (dhVar != null) {
                                dhVar2 = this.eob.emx;
                                if (dhVar2.getAppealInfo() != null) {
                                    dhVar3 = this.eob.emx;
                                    if (!StringUtils.isNull(dhVar3.getAppealInfo().ejY)) {
                                        exVar10 = this.eob.enh;
                                        dhVar4 = this.eob.emx;
                                        exVar10.a(dhVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.eob;
                            exVar9 = this.eob.enh;
                            pbActivity4.showNetRefreshView(exVar9.getView(), this.eob.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.eob.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.eob;
                            exVar7 = this.eob.enh;
                            pbActivity5.showNetRefreshView(exVar7.getView(), this.eob.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.eob.setNetRefreshViewEmotionDefMarginTop();
                        }
                        exVar8 = this.eob.enh;
                        exVar8.aPL();
                    }
                } else {
                    this.eob.showToast(str);
                }
                exVar5 = this.eob.enh;
                exVar5.oY(this.eob.getResources().getString(t.j.list_no_more));
                exVar6 = this.eob.enh;
                exVar6.wm();
            }
            this.eob.aCr = System.currentTimeMillis() - currentTimeMillis;
            if (!this.eob.aMG().aNO() || this.eob.aMG().getPbData().getPage().qr() != 0 || this.eob.aMG().aOh()) {
                this.eob.ent = true;
            }
            dhVar5 = this.eob.emx;
            if (dhVar5 != null) {
                exVar11 = this.eob.enh;
                if (exVar11 != null) {
                    dhVar6 = this.eob.emx;
                    if (dhVar6.aOj() != null) {
                        dhVar7 = this.eob.emx;
                        if (dhVar7.aOj().aNx()) {
                            exVar12 = this.eob.enh;
                            exVar12.aNH();
                            dhVar8 = this.eob.emx;
                            dhVar8.aOj().aNz();
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
        dhVar25 = this.eob.emx;
        dhVar25.oi(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
        ex exVar;
        exVar = this.eob.enh;
        exVar.j(hVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.Gp().Gq()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.eob.bGO;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.eob.aCj;
            j4 = this.eob.createTime;
            j5 = this.eob.aCr;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.eob.createTime = 0L;
            this.eob.aCj = 0L;
            if (vVar != null) {
                vVar.Gk();
            }
        }
    }
}
