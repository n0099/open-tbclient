package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.dg;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aa implements dg.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.dg.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4) {
        es esVar;
        es esVar2;
        es esVar3;
        es esVar4;
        boolean z2;
        boolean z3;
        es esVar5;
        es esVar6;
        es esVar7;
        es esVar8;
        dg dgVar;
        es esVar9;
        dg dgVar2;
        dg dgVar3;
        es esVar10;
        dg dgVar4;
        dg dgVar5;
        es esVar11;
        dg dgVar6;
        dg dgVar7;
        es esVar12;
        dg dgVar8;
        es esVar13;
        es esVar14;
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        es esVar15;
        boolean z4;
        es esVar16;
        dg dgVar9;
        boolean z5;
        boolean z6;
        boolean z7;
        dg dgVar10;
        es esVar17;
        dg dgVar11;
        dg dgVar12;
        es esVar18;
        dg dgVar13;
        es esVar19;
        dg dgVar14;
        dg dgVar15;
        dg dgVar16;
        dg dgVar17;
        es esVar20;
        String str2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.editortools.d.e eVar4;
        com.baidu.tbadk.editortools.d.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        es esVar21;
        dg dgVar18;
        es esVar22;
        dg dgVar19;
        dg dgVar20;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.d.e eVar6;
        com.baidu.tbadk.editortools.d.e eVar7;
        com.baidu.tbadk.editortools.d.e eVar8;
        dg dgVar21;
        dg dgVar22;
        dg dgVar23;
        dg dgVar24;
        es esVar23;
        com.baidu.tbadk.editortools.d.e eVar9;
        es esVar24;
        es esVar25;
        dg dgVar25;
        if (!z || hVar == null || hVar.aDP() == null || hVar.aDP().size() >= 1) {
            this.dPF.dyP = true;
            long currentTimeMillis = System.currentTimeMillis();
            esVar = this.dPF.dOO;
            esVar.aHq();
            if (hVar != null && hVar.aDT()) {
                esVar25 = this.dPF.dOO;
                if (esVar25.aGQ() == null) {
                    this.dPF.dOZ = true;
                }
            } else {
                PbActivity pbActivity = this.dPF;
                esVar2 = this.dPF.dOO;
                pbActivity.hideLoadingView(esVar2.getView());
            }
            esVar3 = this.dPF.dOO;
            esVar3.aoC();
            esVar4 = this.dPF.dOO;
            esVar4.gc(false);
            z2 = this.dPF.mIsLoading;
            if (z2) {
                this.dPF.mIsLoading = false;
                esVar24 = this.dPF.dOO;
                esVar24.dTq.dWt.setEnabled(true);
            }
            if (i4 == 0 && hVar != null) {
                this.dPF.bCo = true;
            }
            if (z && hVar != null) {
                esVar13 = this.dPF.dOO;
                esVar13.Mc();
                esVar14 = this.dPF.dOO;
                esVar14.hT(hVar.aDT());
                if (hVar.aDO() != null && hVar.aDO().rs() != null) {
                    this.dPF.a(hVar.aDO().rs());
                }
                eVar = this.dPF.dOX;
                if (eVar != null) {
                    esVar23 = this.dPF.dOO;
                    eVar9 = this.dPF.dOX;
                    esVar23.gb(eVar9.BW());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(hVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(hVar.getUserData().getBimg_end_time());
                if (hVar.aDP() != null && hVar.aDP().size() >= 1 && hVar.aDP().get(0) != null) {
                    String id = hVar.aDP().get(0).getId();
                    dgVar24 = this.dPF.dOf;
                    dgVar24.nw(id);
                }
                eVar2 = this.dPF.dOX;
                if (eVar2 != null) {
                    eVar6 = this.dPF.dOX;
                    eVar6.a(hVar.pt());
                    eVar7 = this.dPF.dOX;
                    eVar7.a(hVar.aDN(), hVar.getUserData());
                    eVar8 = this.dPF.dOX;
                    dgVar21 = this.dPF.dOf;
                    MetaData aFS = dgVar21.aFS();
                    dgVar22 = this.dPF.dOf;
                    String threadID = dgVar22.getThreadID();
                    dgVar23 = this.dPF.dOf;
                    eVar8.a(aFS, threadID, dgVar23.aFI());
                }
                aVar = this.dPF.dvH;
                if (aVar != null) {
                    aVar2 = this.dPF.dvH;
                    aVar2.Z(hVar.mK());
                }
                if (hVar == null || hVar.aDV() != 1) {
                    this.dPF.mIsFromCDN = false;
                } else {
                    this.dPF.mIsFromCDN = true;
                }
                esVar15 = this.dPF.dOO;
                z4 = this.dPF.mIsFromCDN;
                esVar15.hS(z4);
                esVar16 = this.dPF.dOO;
                dgVar9 = this.dPF.dOf;
                esVar16.hM(dgVar9.aFM());
                z5 = this.dPF.dOS;
                if (!z5) {
                    z6 = this.dPF.dOT;
                    if (z6) {
                        z7 = this.dPF.dOU;
                        if (!z7) {
                            PbActivity pbActivity2 = this.dPF;
                            dgVar10 = this.dPF.dOf;
                            pbActivity2.a(dgVar10.getPbData(), -1, false, true);
                            this.dPF.dOU = true;
                            this.dPF.dOS = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.dPF;
                    dgVar20 = this.dPF.dOf;
                    pbActivity3.a(dgVar20.getPbData(), -1, 0, false, true);
                }
                esVar17 = this.dPF.dOO;
                dgVar11 = this.dPF.dOf;
                boolean aFM = dgVar11.aFM();
                dgVar12 = this.dPF.dOf;
                esVar17.a(hVar, i2, i3, aFM, i4, dgVar12.getIsFromMark());
                esVar18 = this.dPF.dOO;
                dgVar13 = this.dPF.dOf;
                esVar18.a(hVar, dgVar13.aFM(), false, i2);
                esVar19 = this.dPF.dOO;
                dgVar14 = this.dPF.dOf;
                esVar19.hQ(dgVar14.getHostMode());
                dgVar15 = this.dPF.dOf;
                if (dgVar15.aGh() != null) {
                    esVar21 = this.dPF.dOO;
                    dgVar18 = this.dPF.dOf;
                    esVar21.c(dgVar18.aGh().aFy());
                    if (hVar.aDO() != null && hVar.aDO().Rl == null) {
                        esVar22 = this.dPF.dOO;
                        dgVar19 = this.dPF.dOf;
                        esVar22.hO(dgVar19.aGh().aFz());
                    }
                }
                this.dPF.aET();
                AntiData pt = hVar.pt();
                if (pt != null) {
                    this.dPF.asq = pt.getVoice_message();
                    str2 = this.dPF.asq;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.dPF.dOX;
                        if (eVar3 != null) {
                            eVar4 = this.dPF.dOX;
                            if (eVar4.Bl() != null) {
                                eVar5 = this.dPF.dOX;
                                com.baidu.tbadk.editortools.s ej = eVar5.Bl().ej(6);
                                if (ej != null) {
                                    str3 = this.dPF.asq;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.dPF.dhS;
                                        ((View) ej).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                dgVar16 = this.dPF.dOf;
                if (dgVar16.aGh() != null) {
                    dgVar17 = this.dPF.dOf;
                    if (dgVar17.aGh().aFB()) {
                        esVar20 = this.dPF.dOO;
                        esVar20.aFD();
                    }
                }
            } else if (str != null) {
                z3 = this.dPF.bCo;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            dgVar = this.dPF.dOf;
                            if (dgVar != null) {
                                dgVar2 = this.dPF.dOf;
                                if (dgVar2.getAppealInfo() != null) {
                                    dgVar3 = this.dPF.dOf;
                                    if (!StringUtils.isNull(dgVar3.getAppealInfo().dLL)) {
                                        esVar10 = this.dPF.dOO;
                                        dgVar4 = this.dPF.dOf;
                                        esVar10.a(dgVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.dPF;
                            esVar9 = this.dPF.dOO;
                            pbActivity4.showNetRefreshView(esVar9.getView(), this.dPF.getPageContext().getResources().getString(u.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.dPF.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.dPF;
                            esVar7 = this.dPF.dOO;
                            pbActivity5.showNetRefreshView(esVar7.getView(), this.dPF.getPageContext().getResources().getString(u.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.dPF.setNetRefreshViewEmotionDefMarginTop();
                        }
                        esVar8 = this.dPF.dOO;
                        esVar8.aHJ();
                    }
                } else {
                    this.dPF.showToast(str);
                }
                esVar5 = this.dPF.dOO;
                esVar5.nC(this.dPF.getResources().getString(u.j.list_no_more));
                esVar6 = this.dPF.dOO;
                esVar6.vi();
            }
            this.dPF.ayu = System.currentTimeMillis() - currentTimeMillis;
            if (!this.dPF.aEE().aFM() || this.dPF.aEE().getPbData().getPage().pF() != 0 || this.dPF.aEE().aGf()) {
                this.dPF.dOY = true;
            }
            dgVar5 = this.dPF.dOf;
            if (dgVar5 != null) {
                esVar11 = this.dPF.dOO;
                if (esVar11 != null) {
                    dgVar6 = this.dPF.dOf;
                    if (dgVar6.aGh() != null) {
                        dgVar7 = this.dPF.dOf;
                        if (dgVar7.aGh().aFv()) {
                            esVar12 = this.dPF.dOO;
                            esVar12.aFF();
                            dgVar8 = this.dPF.dOf;
                            dgVar8.aGh().aFx();
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
        dgVar25 = this.dPF.dOf;
        dgVar25.nm(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.dg.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
        es esVar;
        esVar = this.dPF.dOO;
        esVar.j(hVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.dg.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.EW().EX()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.dPF.btl;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.dPF.aym;
            j4 = this.dPF.createTime;
            j5 = this.dPF.ayu;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.dPF.createTime = 0L;
            this.dPF.aym = 0L;
            if (vVar != null) {
                vVar.ER();
            }
        }
    }
}
