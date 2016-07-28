package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aa implements dh.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4) {
        ew ewVar;
        ew ewVar2;
        ew ewVar3;
        ew ewVar4;
        boolean z2;
        boolean z3;
        ew ewVar5;
        ew ewVar6;
        ew ewVar7;
        ew ewVar8;
        dh dhVar;
        ew ewVar9;
        dh dhVar2;
        dh dhVar3;
        ew ewVar10;
        dh dhVar4;
        dh dhVar5;
        ew ewVar11;
        dh dhVar6;
        dh dhVar7;
        ew ewVar12;
        dh dhVar8;
        ew ewVar13;
        ew ewVar14;
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.baseEditMark.a aVar;
        ew ewVar15;
        boolean z4;
        ew ewVar16;
        dh dhVar9;
        boolean z5;
        boolean z6;
        boolean z7;
        dh dhVar10;
        ew ewVar17;
        dh dhVar11;
        dh dhVar12;
        ew ewVar18;
        dh dhVar13;
        ew ewVar19;
        dh dhVar14;
        dh dhVar15;
        dh dhVar16;
        dh dhVar17;
        ew ewVar20;
        ew ewVar21;
        String str2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tbadk.editortools.d.e eVar4;
        com.baidu.tbadk.editortools.d.e eVar5;
        String str3;
        View.OnClickListener onClickListener;
        ew ewVar22;
        dh dhVar18;
        ew ewVar23;
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
        ew ewVar24;
        com.baidu.tbadk.editortools.d.e eVar9;
        ew ewVar25;
        ew ewVar26;
        dh dhVar25;
        if (!z || hVar == null || hVar.aGZ() == null || hVar.aGZ().size() >= 1) {
            this.ebT.dCV = true;
            long currentTimeMillis = System.currentTimeMillis();
            ewVar = this.ebT.ebb;
            ewVar.aKB();
            if (hVar != null && hVar.aHe()) {
                ewVar26 = this.ebT.ebb;
                if (ewVar26.aKd() == null) {
                    this.ebT.ebm = true;
                }
            } else {
                PbActivity pbActivity = this.ebT;
                ewVar2 = this.ebT.ebb;
                pbActivity.hideLoadingView(ewVar2.getView());
            }
            ewVar3 = this.ebT.ebb;
            ewVar3.apo();
            ewVar4 = this.ebT.ebb;
            ewVar4.gf(false);
            z2 = this.ebT.mIsLoading;
            if (z2) {
                this.ebT.mIsLoading = false;
                ewVar25 = this.ebT.ebb;
                ewVar25.efS.eiW.setEnabled(true);
            }
            if (i4 == 0 && hVar != null) {
                this.ebT.bDv = true;
            }
            if (z && hVar != null) {
                ewVar13 = this.ebT.ebb;
                ewVar13.Mb();
                ewVar14 = this.ebT.ebb;
                ewVar14.m19if(hVar.aHe());
                if (hVar.aGY() != null && hVar.aGY().rr() != null) {
                    this.ebT.a(hVar.aGY().rr());
                }
                eVar = this.ebT.ebk;
                if (eVar != null) {
                    ewVar24 = this.ebT.ebb;
                    eVar9 = this.ebT.ebk;
                    ewVar24.ge(eVar9.BW());
                }
                TbadkCoreApplication.m10getInst().setDefaultBubble(hVar.getUserData().getBimg_url());
                TbadkCoreApplication.m10getInst().setDefaultBubbleEndTime(hVar.getUserData().getBimg_end_time());
                if (hVar.aGZ() != null && hVar.aGZ().size() >= 1 && hVar.aGZ().get(0) != null) {
                    String id = hVar.aGZ().get(0).getId();
                    dhVar24 = this.ebT.eas;
                    dhVar24.oj(id);
                }
                eVar2 = this.ebT.ebk;
                if (eVar2 != null) {
                    eVar6 = this.ebT.ebk;
                    eVar6.a(hVar.pc());
                    eVar7 = this.ebT.ebk;
                    eVar7.a(hVar.aGX(), hVar.getUserData());
                    eVar8 = this.ebT.ebk;
                    dhVar21 = this.ebT.eas;
                    MetaData aJd = dhVar21.aJd();
                    dhVar22 = this.ebT.eas;
                    String threadID = dhVar22.getThreadID();
                    dhVar23 = this.ebT.eas;
                    eVar8.a(aJd, threadID, dhVar23.aIT());
                }
                aVar = this.ebT.dzj;
                if (aVar != null) {
                    aVar2 = this.ebT.dzj;
                    aVar2.ab(hVar.mA());
                }
                if (hVar == null || hVar.aHg() != 1) {
                    this.ebT.mIsFromCDN = false;
                } else {
                    this.ebT.mIsFromCDN = true;
                }
                ewVar15 = this.ebT.ebb;
                z4 = this.ebT.mIsFromCDN;
                ewVar15.ie(z4);
                ewVar16 = this.ebT.ebb;
                dhVar9 = this.ebT.eas;
                ewVar16.hY(dhVar9.aIX());
                z5 = this.ebT.ebf;
                if (!z5) {
                    z6 = this.ebT.ebg;
                    if (z6) {
                        z7 = this.ebT.ebh;
                        if (!z7) {
                            PbActivity pbActivity2 = this.ebT;
                            dhVar10 = this.ebT.eas;
                            pbActivity2.a(dhVar10.getPbData(), -1, false, true);
                            this.ebT.ebh = true;
                            this.ebT.ebf = true;
                        }
                    }
                } else {
                    PbActivity pbActivity3 = this.ebT;
                    dhVar20 = this.ebT.eas;
                    pbActivity3.a(dhVar20.getPbData(), -1, 0, false, true);
                }
                ewVar17 = this.ebT.ebb;
                dhVar11 = this.ebT.eas;
                boolean aIX = dhVar11.aIX();
                dhVar12 = this.ebT.eas;
                ewVar17.a(hVar, i2, i3, aIX, i4, dhVar12.getIsFromMark());
                ewVar18 = this.ebT.ebb;
                dhVar13 = this.ebT.eas;
                ewVar18.a(hVar, dhVar13.aIX(), false, i2);
                ewVar19 = this.ebT.ebb;
                dhVar14 = this.ebT.eas;
                ewVar19.ic(dhVar14.getHostMode());
                dhVar15 = this.ebT.eas;
                if (dhVar15.aJs() != null) {
                    ewVar22 = this.ebT.ebb;
                    dhVar18 = this.ebT.eas;
                    ewVar22.c(dhVar18.aJs().aIJ());
                    if (hVar.aGY() != null && hVar.aGY().RO == null) {
                        ewVar23 = this.ebT.ebb;
                        dhVar19 = this.ebT.eas;
                        ewVar23.ia(dhVar19.aJs().aIK());
                    }
                }
                this.ebT.aIe();
                AntiData pc = hVar.pc();
                if (pc != null) {
                    this.ebT.atf = pc.getVoice_message();
                    str2 = this.ebT.atf;
                    if (!StringUtils.isNull(str2)) {
                        eVar3 = this.ebT.ebk;
                        if (eVar3 != null) {
                            eVar4 = this.ebT.ebk;
                            if (eVar4.Bl() != null) {
                                eVar5 = this.ebT.ebk;
                                com.baidu.tbadk.editortools.s ej = eVar5.Bl().ej(6);
                                if (ej != null) {
                                    str3 = this.ebT.atf;
                                    if (!TextUtils.isEmpty(str3)) {
                                        onClickListener = this.ebT.dkQ;
                                        ((View) ej).setOnClickListener(onClickListener);
                                    }
                                }
                            }
                        }
                    }
                }
                dhVar16 = this.ebT.eas;
                if (dhVar16.aJs() != null) {
                    dhVar17 = this.ebT.eas;
                    if (dhVar17.aJs().aIM()) {
                        ewVar20 = this.ebT.ebb;
                        if (!ewVar20.aLj()) {
                            ewVar21 = this.ebT.ebb;
                            ewVar21.aIO();
                        }
                    }
                }
            } else if (str != null) {
                z3 = this.ebT.bDv;
                if (!z3 && i4 == 1) {
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        if (i == 4) {
                            dhVar = this.ebT.eas;
                            if (dhVar != null) {
                                dhVar2 = this.ebT.eas;
                                if (dhVar2.getAppealInfo() != null) {
                                    dhVar3 = this.ebT.eas;
                                    if (!StringUtils.isNull(dhVar3.getAppealInfo().dXU)) {
                                        ewVar10 = this.ebT.ebb;
                                        dhVar4 = this.ebT.eas;
                                        ewVar10.a(dhVar4.getAppealInfo());
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.ebT;
                            ewVar9 = this.ebT.ebb;
                            pbActivity4.showNetRefreshView(ewVar9.getView(), this.ebT.getPageContext().getResources().getString(u.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.ebT.setNetRefreshViewEmotionDefMarginTop();
                        } else {
                            PbActivity pbActivity5 = this.ebT;
                            ewVar7 = this.ebT.ebb;
                            pbActivity5.showNetRefreshView(ewVar7.getView(), this.ebT.getPageContext().getResources().getString(u.j.net_error_text, str, Integer.valueOf(i)), true);
                            this.ebT.setNetRefreshViewEmotionDefMarginTop();
                        }
                        ewVar8 = this.ebT.ebb;
                        ewVar8.aKU();
                    }
                } else {
                    this.ebT.showToast(str);
                }
                ewVar5 = this.ebT.ebb;
                ewVar5.op(this.ebT.getResources().getString(u.j.list_no_more));
                ewVar6 = this.ebT.ebb;
                ewVar6.vi();
            }
            this.ebT.azk = System.currentTimeMillis() - currentTimeMillis;
            if (!this.ebT.aHO().aIX() || this.ebT.aHO().getPbData().getPage().po() != 0 || this.ebT.aHO().aJq()) {
                this.ebT.ebl = true;
            }
            dhVar5 = this.ebT.eas;
            if (dhVar5 != null) {
                ewVar11 = this.ebT.ebb;
                if (ewVar11 != null) {
                    dhVar6 = this.ebT.eas;
                    if (dhVar6.aJs() != null) {
                        dhVar7 = this.ebT.eas;
                        if (dhVar7.aJs().aIG()) {
                            ewVar12 = this.ebT.ebb;
                            ewVar12.aIQ();
                            dhVar8 = this.ebT.eas;
                            dhVar8.aJs().aII();
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
        dhVar25 = this.ebT.eas;
        dhVar25.nE(1);
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
        ew ewVar;
        ewVar = this.ebT.ebb;
        ewVar.j(hVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        if (com.baidu.tbadk.performanceLog.aa.EV().EW()) {
            if (z2) {
                j2 = j;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j6 = this.ebT.bvA;
                j2 = currentTimeMillis - j6;
            }
            j3 = this.ebT.azc;
            j4 = this.ebT.createTime;
            j5 = this.ebT.azk;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, j3, j4, j5, z2, j2);
            this.ebT.createTime = 0L;
            this.ebT.azc = 0L;
            if (vVar != null) {
                vVar.EQ();
            }
        }
    }
}
