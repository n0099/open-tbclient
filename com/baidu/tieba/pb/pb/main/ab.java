package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ab implements dh.a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.eqa = pbActivity;
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
        com.baidu.tbadk.editortools.e.e eVar;
        com.baidu.tbadk.editortools.e.e eVar2;
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
        com.baidu.tbadk.editortools.e.e eVar3;
        com.baidu.tbadk.editortools.e.e eVar4;
        com.baidu.tbadk.editortools.e.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        ex exVar22;
        dh dhVar18;
        ex exVar23;
        dh dhVar19;
        dh dhVar20;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.editortools.e.e eVar6;
        com.baidu.tbadk.editortools.e.e eVar7;
        com.baidu.tbadk.editortools.e.e eVar8;
        dh dhVar21;
        dh dhVar22;
        dh dhVar23;
        dh dhVar24;
        ex exVar24;
        com.baidu.tbadk.editortools.e.e eVar9;
        ex exVar25;
        ex exVar26;
        dh dhVar25;
        if (!z || hVar == null || hVar.aMt() == null || hVar.aMt().size() >= 1) {
            this.eqa.dQG = true;
            long currentTimeMillis = System.currentTimeMillis();
            exVar = this.eqa.epe;
            exVar.aQb();
            if (hVar != null && hVar.aMy()) {
                exVar26 = this.eqa.epe;
                if (exVar26.aPD() == null) {
                    this.eqa.epr = true;
                }
            } else {
                PbActivity pbActivity = this.eqa;
                exVar2 = this.eqa.epe;
                pbActivity.hideLoadingView(exVar2.getView());
            }
            exVar3 = this.eqa.epe;
            exVar3.auB();
            exVar4 = this.eqa.epe;
            exVar4.gE(false);
            z2 = this.eqa.mIsLoading;
            if (z2) {
                this.eqa.mIsLoading = false;
                exVar25 = this.eqa.epe;
                exVar25.eug.exj.setEnabled(true);
            }
            if (i4 == 0 && hVar != null) {
                this.eqa.bOT = true;
            }
            if (z && hVar != null) {
                this.eqa.mForumId = hVar.getForumId();
                this.eqa.mThreadId = hVar.getThreadId();
                exVar13 = this.eqa.epe;
                exVar13.JK();
                exVar14 = this.eqa.epe;
                exVar14.iD(hVar.aMy());
                if (hVar.aMs() != null && hVar.aMs().sI() != null) {
                    this.eqa.a(hVar.aMs().sI());
                }
                eVar = this.eqa.epp;
                if (eVar != null) {
                    exVar24 = this.eqa.epe;
                    eVar9 = this.eqa.epp;
                    exVar24.gD(eVar9.Dr());
                }
                TbadkCoreApplication.m9getInst().setDefaultBubble(hVar.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(hVar.getUserData().getBimg_end_time());
                if (hVar.aMt() != null && hVar.aMt().size() >= 1 && hVar.aMt().get(0) != null) {
                    String id = hVar.aMt().get(0).getId();
                    dhVar24 = this.eqa.eov;
                    dhVar24.ph(id);
                }
                eVar2 = this.eqa.epp;
                if (eVar2 != null) {
                    eVar6 = this.eqa.epp;
                    eVar6.a(hVar.qq());
                    eVar7 = this.eqa.epp;
                    eVar7.a(hVar.aMr(), hVar.getUserData());
                    eVar8 = this.eqa.epp;
                    dhVar21 = this.eqa.eov;
                    MetaData aOC = dhVar21.aOC();
                    dhVar22 = this.eqa.eov;
                    String threadID = dhVar22.getThreadID();
                    dhVar23 = this.eqa.eov;
                    eVar8.a(aOC, threadID, dhVar23.aOs());
                }
                aVar = this.eqa.dMU;
                if (aVar != null) {
                    aVar2 = this.eqa.dMU;
                    aVar2.ad(hVar.nv());
                }
                if (hVar == null || hVar.aMA() != 1) {
                    this.eqa.mIsFromCDN = false;
                } else {
                    this.eqa.mIsFromCDN = true;
                }
                exVar15 = this.eqa.epe;
                z4 = this.eqa.mIsFromCDN;
                exVar15.iC(z4);
                exVar16 = this.eqa.epe;
                dhVar9 = this.eqa.eov;
                exVar16.iw(dhVar9.aOw());
                z5 = this.eqa.epk;
                if (!z5) {
                    z6 = this.eqa.epl;
                    if (z6) {
                        z7 = this.eqa.epm;
                        if (!z7) {
                            PbActivity pbActivity2 = this.eqa;
                            dhVar10 = this.eqa.eov;
                            pbActivity2.a(dhVar10.getPbData(), -1, false, true);
                            this.eqa.epm = true;
                            this.eqa.epk = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.eqa;
                    dhVar20 = this.eqa.eov;
                    pbActivity3.a(dhVar20.getPbData(), -1, 0, false, true);
                }
                exVar17 = this.eqa.epe;
                dhVar11 = this.eqa.eov;
                boolean aOw = dhVar11.aOw();
                dhVar12 = this.eqa.eov;
                exVar17.a(hVar, i2, i3, aOw, i4, dhVar12.getIsFromMark());
                exVar18 = this.eqa.epe;
                dhVar13 = this.eqa.eov;
                exVar18.a(hVar, dhVar13.aOw(), false, i2);
                exVar19 = this.eqa.epe;
                dhVar14 = this.eqa.eov;
                exVar19.iA(dhVar14.getHostMode());
                dhVar15 = this.eqa.eov;
                if (dhVar15.aOR() != null) {
                    exVar22 = this.eqa.epe;
                    dhVar18 = this.eqa.eov;
                    exVar22.c(dhVar18.aOR().aOi());
                    if (hVar.aMs() != null && hVar.aMs().UH == null) {
                        exVar23 = this.eqa.epe;
                        dhVar19 = this.eqa.eov;
                        exVar23.iy(dhVar19.aOR().aOj());
                    }
                }
                this.eqa.aNC();
                AntiData qq = hVar.qq();
                if (qq != null) {
                    this.eqa.avP = qq.getVoice_message();
                    str2 = this.eqa.avP;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.eqa.epp;
                        if (eVar3 != null) {
                            eVar4 = this.eqa.epp;
                            if (eVar4.CG() != null) {
                                eVar5 = this.eqa.epp;
                                com.baidu.tbadk.editortools.s ew = eVar5.CG().ew(6);
                                if (ew != null) {
                                    str3 = this.eqa.avP;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.eqa.dxY;
                                        ((View) ew).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                dhVar16 = this.eqa.eov;
                if (dhVar16.aOR() != null) {
                    dhVar17 = this.eqa.eov;
                    if (dhVar17.aOR().aOl()) {
                        exVar20 = this.eqa.epe;
                        if (!exVar20.aQJ()) {
                            exVar21 = this.eqa.epe;
                            exVar21.aOn();
                        }
                    }
                }
            } else if (str != null) {
                z3 = this.eqa.bOT;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            dhVar = this.eqa.eov;
                            if (dhVar != null) {
                                dhVar2 = this.eqa.eov;
                                if (dhVar2.getAppealInfo() != null) {
                                    dhVar3 = this.eqa.eov;
                                    if (!StringUtils.isNull(dhVar3.getAppealInfo().elW)) {
                                        exVar10 = this.eqa.epe;
                                        dhVar4 = this.eqa.eov;
                                        exVar10.a(dhVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.eqa;
                            exVar9 = this.eqa.epe;
                            pbActivity4.showNetRefreshView(exVar9.getView(), this.eqa.getPageContext().getResources().getString(r.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.eqa.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.eqa;
                            exVar7 = this.eqa.epe;
                            pbActivity5.showNetRefreshView(exVar7.getView(), this.eqa.getPageContext().getResources().getString(r.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.eqa.setNetRefreshViewEmotionDefMarginTop();
                        }
                        exVar8 = this.eqa.epe;
                        exVar8.aQu();
                    }
                } else {
                    this.eqa.showToast(str);
                }
                exVar5 = this.eqa.epe;
                exVar5.pn(this.eqa.getResources().getString(r.j.list_no_more));
                exVar6 = this.eqa.epe;
                exVar6.wC();
            }
            this.eqa.aBU = System.currentTimeMillis() - currentTimeMillis;
            if (!this.eqa.aNl().aOw() || this.eqa.aNl().getPbData().getPage().qC() != 0 || this.eqa.aNl().aOP()) {
                this.eqa.epq = true;
            }
            dhVar5 = this.eqa.eov;
            if (dhVar5 != null) {
                exVar11 = this.eqa.epe;
                if (exVar11 != null) {
                    dhVar6 = this.eqa.eov;
                    if (dhVar6.aOR() != null) {
                        dhVar7 = this.eqa.eov;
                        if (dhVar7.aOR().aOf()) {
                            exVar12 = this.eqa.epe;
                            exVar12.aOp();
                            dhVar8 = this.eqa.eov;
                            dhVar8.aOR().aOh();
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
        dhVar25 = this.eqa.eov;
        dhVar25.os(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
        ex exVar;
        exVar = this.eqa.epe;
        exVar.j(hVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.Go().Gp()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.eqa.bGX;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.eqa.aBM;
            j4 = this.eqa.createTime;
            j5 = this.eqa.aBU;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.eqa.createTime = 0L;
            this.eqa.aBM = 0L;
            if (vVar != null) {
                vVar.Gj();
            }
        }
    }
}
