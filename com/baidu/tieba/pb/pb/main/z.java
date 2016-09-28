package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommEnsureOrderActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.data.PbEcommRecommendMessage;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v13, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v178, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x06c9, code lost:
        if (r21 == r1.eug.aQP().aPj()) goto L135;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:428:0x137d  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x1425  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x143d  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x1447  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x153f  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x1625  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x163c  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x1652  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x1664  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x1672  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x16f5  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x1755  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x1825  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x183d  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x1870  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x1873  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x1894  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x18a7  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x18ba  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x1f3f  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x1f42  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x1f45  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x1f48  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x1f4b  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x1f4e  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x1f51  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        ex exVar;
        ex exVar2;
        ex exVar3;
        ex exVar4;
        ex exVar5;
        ex exVar6;
        dh dhVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        ex exVar7;
        ex exVar8;
        ex exVar9;
        ex exVar10;
        ex exVar11;
        dh dhVar2;
        dh dhVar3;
        ex exVar12;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ex exVar13;
        ex exVar14;
        ex exVar15;
        ex exVar16;
        ex exVar17;
        ex exVar18;
        ex exVar19;
        ex exVar20;
        ex exVar21;
        ex exVar22;
        boolean z;
        ex exVar23;
        ex exVar24;
        ex exVar25;
        dh dhVar4;
        String aND;
        ex exVar26;
        ex exVar27;
        ex exVar28;
        ex exVar29;
        ex exVar30;
        ex exVar31;
        ex exVar32;
        ex exVar33;
        ex exVar34;
        ex exVar35;
        ex exVar36;
        ex exVar37;
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        Cdo cdo4;
        Cdo cdo5;
        ex exVar38;
        ex exVar39;
        Cdo cdo6;
        ex exVar40;
        dh dhVar5;
        ex exVar41;
        dh dhVar6;
        dh dhVar7;
        PbActivity.b pg;
        dh dhVar8;
        dh dhVar9;
        dh dhVar10;
        PbActivity.b pg2;
        dh dhVar11;
        dh dhVar12;
        dh dhVar13;
        PbActivity.b pg3;
        dh dhVar14;
        dh dhVar15;
        dh dhVar16;
        dh dhVar17;
        dh dhVar18;
        ex exVar42;
        dh dhVar19;
        dh dhVar20;
        dh dhVar21;
        dh dhVar22;
        dh dhVar23;
        dh dhVar24;
        dh dhVar25;
        dh dhVar26;
        dh dhVar27;
        dh dhVar28;
        dh dhVar29;
        dh dhVar30;
        dh dhVar31;
        dh dhVar32;
        dh dhVar33;
        dh dhVar34;
        dh dhVar35;
        dh dhVar36;
        dh dhVar37;
        dh dhVar38;
        dh dhVar39;
        dh dhVar40;
        PbEcommRecommendMessage pbEcommRecommendMessage;
        int aNr;
        int aNr2;
        dh dhVar41;
        dh dhVar42;
        dh dhVar43;
        dh dhVar44;
        dh dhVar45;
        dh dhVar46;
        dh dhVar47;
        dh dhVar48;
        int aNr3;
        int aNr4;
        dh dhVar49;
        dh dhVar50;
        dh dhVar51;
        dh dhVar52;
        dh dhVar53;
        dh dhVar54;
        dh dhVar55;
        dh dhVar56;
        ex exVar43;
        dh dhVar57;
        dh dhVar58;
        dh dhVar59;
        ex exVar44;
        dh dhVar60;
        dh dhVar61;
        dh dhVar62;
        dh dhVar63;
        dh dhVar64;
        dh dhVar65;
        ex exVar45;
        ex exVar46;
        dh dhVar66;
        Cdo cdo7;
        Cdo cdo8;
        dh dhVar67;
        boolean z2;
        Cdo cdo9;
        Cdo cdo10;
        Cdo cdo11;
        Cdo cdo12;
        dh dhVar68;
        Cdo cdo13;
        SparseArray sparseArray;
        Cdo cdo14;
        SparseArray sparseArray2;
        boolean booleanValue;
        boolean z3;
        Cdo cdo15;
        Cdo cdo16;
        Cdo cdo17;
        Cdo cdo18;
        Cdo cdo19;
        Cdo cdo20;
        Cdo cdo21;
        SparseArray sparseArray3;
        boolean z4;
        boolean z5;
        boolean hZ;
        boolean isLogin;
        Cdo cdo22;
        Cdo cdo23;
        Cdo cdo24;
        SparseArray sparseArray4;
        boolean z6;
        String str;
        int i;
        Cdo cdo25;
        Cdo cdo26;
        Cdo cdo27;
        Cdo cdo28;
        Cdo cdo29;
        Cdo cdo30;
        Cdo cdo31;
        Cdo cdo32;
        Cdo cdo33;
        Cdo cdo34;
        Cdo cdo35;
        Cdo cdo36;
        Cdo cdo37;
        Cdo cdo38;
        Cdo cdo39;
        Cdo cdo40;
        Cdo cdo41;
        dh dhVar69;
        Cdo cdo42;
        Cdo cdo43;
        boolean z7;
        com.baidu.tbadk.core.data.bp bpVar;
        dh dhVar70;
        dh dhVar71;
        dh dhVar72;
        ex exVar47;
        ex exVar48;
        dh dhVar73;
        ex exVar49;
        dh dhVar74;
        dh dhVar75;
        dh dhVar76;
        dh dhVar77;
        ex exVar50;
        ex exVar51;
        Cdo cdo44;
        ex exVar52;
        ex exVar53;
        dh dhVar78;
        dh dhVar79;
        ex exVar54;
        dh dhVar80;
        Cdo cdo45;
        dh dhVar81;
        Cdo cdo46;
        ex exVar55;
        dh dhVar82;
        Cdo cdo47;
        dh dhVar83;
        ex exVar56;
        dh dhVar84;
        Cdo cdo48;
        Cdo cdo49;
        ex exVar57;
        String aNq;
        ex exVar58;
        ex exVar59;
        ex exVar60;
        ex exVar61;
        ex exVar62;
        dh dhVar85;
        dh dhVar86;
        ex exVar63;
        ex exVar64;
        dh dhVar87;
        dh dhVar88;
        dh dhVar89;
        ex exVar65;
        ex exVar66;
        dh dhVar90;
        dh dhVar91;
        dh dhVar92;
        ex exVar67;
        dh dhVar93;
        ex exVar68;
        ex exVar69;
        ex exVar70;
        dh dhVar94;
        ex exVar71;
        ex exVar72;
        dh dhVar95;
        ex exVar73;
        dh dhVar96;
        ex exVar74;
        dh dhVar97;
        dh dhVar98;
        dh dhVar99;
        dh dhVar100;
        dh dhVar101;
        ex exVar75;
        ex exVar76;
        ex exVar77;
        ex exVar78;
        ex exVar79;
        boolean om;
        dh dhVar102;
        ex exVar80;
        dh dhVar103;
        dh dhVar104;
        dh dhVar105;
        dh dhVar106;
        dh dhVar107;
        dh dhVar108;
        dh dhVar109;
        dh dhVar110;
        dh dhVar111;
        dh dhVar112;
        ex exVar81;
        ex exVar82;
        dh dhVar113;
        dh dhVar114;
        String name;
        dh dhVar115;
        dh dhVar116;
        dh dhVar117;
        dh dhVar118;
        dh dhVar119;
        dh dhVar120;
        ex exVar83;
        dh dhVar121;
        ex exVar84;
        ex exVar85;
        ex exVar86;
        dh dhVar122;
        ex exVar87;
        dh dhVar123;
        dh dhVar124;
        dh dhVar125;
        ex exVar88;
        exVar = this.eqa.epe;
        if (view == exVar.getNextView()) {
            dhVar125 = this.eqa.eov;
            if (dhVar125.m17if(true)) {
                exVar88 = this.eqa.epe;
                exVar88.aPZ();
                return;
            }
            return;
        }
        exVar2 = this.eqa.epe;
        if (view == exVar2.aPU()) {
            exVar87 = this.eqa.epe;
            exVar87.aPO();
            if (UtilHelper.isFloatWindowOpAllowed(this.eqa.getPageContext().getPageActivity())) {
                this.eqa.epk = true;
                PbActivity pbActivity = this.eqa;
                dhVar123 = this.eqa.eov;
                pbActivity.a(dhVar123.getPbData(), 0, 1, true, true);
                com.baidu.tbadk.core.util.ax axVar = new com.baidu.tbadk.core.util.ax("c10830");
                dhVar124 = this.eqa.eov;
                TiebaStatic.log(axVar.ab("tid", dhVar124.getThreadID()));
                return;
            }
            this.eqa.aNp();
            return;
        }
        exVar3 = this.eqa.epe;
        if (view == exVar3.aQv()) {
            exVar84 = this.eqa.epe;
            exVar84.aBc();
            this.eqa.abb();
            exVar85 = this.eqa.epe;
            exVar85.aPY();
            exVar86 = this.eqa.epe;
            exVar86.ayI();
            dhVar122 = this.eqa.eov;
            dhVar122.os(1);
            return;
        }
        exVar4 = this.eqa.epe;
        if (view == exVar4.eug.aDK) {
            exVar83 = this.eqa.epe;
            dhVar121 = this.eqa.eov;
            if (!exVar83.iB(dhVar121.aOz())) {
                this.eqa.eoO = false;
                this.eqa.finish();
                return;
            }
            this.eqa.abb();
            return;
        }
        exVar5 = this.eqa.epe;
        if (view != exVar5.aQm()) {
            exVar14 = this.eqa.epe;
            if (view != exVar14.aQn()) {
                exVar15 = this.eqa.epe;
                if (view != exVar15.aQo()) {
                    exVar16 = this.eqa.epe;
                    if (view != exVar16.aQp()) {
                        exVar17 = this.eqa.epe;
                        if (view != exVar17.aPW()) {
                            exVar18 = this.eqa.epe;
                            if (view == exVar18.aQs()) {
                                dhVar119 = this.eqa.eov;
                                if (dhVar119 != null) {
                                    dhVar120 = this.eqa.eov;
                                    com.baidu.tbadk.browser.f.u(this.eqa.getPageContext().getPageActivity(), dhVar120.getPbData().aMs().rN().getLink());
                                    return;
                                }
                                return;
                            }
                            exVar19 = this.eqa.epe;
                            if (view != exVar19.eug.exi) {
                                exVar20 = this.eqa.epe;
                                if (view == exVar20.eug.exk) {
                                    dhVar109 = this.eqa.eov;
                                    if (dhVar109 != null) {
                                        dhVar110 = this.eqa.eov;
                                        if (dhVar110.getPbData() != null) {
                                            dhVar111 = this.eqa.eov;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = dhVar111.getPbData().aMt();
                                            if (aMt == null || aMt.size() <= 0) {
                                                dhVar112 = this.eqa.eov;
                                                if (dhVar112.aOw()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.eqa.getPageContext().getPageActivity(), this.eqa.getPageContext().getString(r.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            exVar81 = this.eqa.epe;
                                            exVar81.aPG();
                                            exVar82 = this.eqa.epe;
                                            exVar82.aQx();
                                            this.eqa.aNs();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.eqa.getPageContext().getPageActivity(), this.eqa.getPageContext().getString(r.j.pb_no_data_tips));
                                    return;
                                }
                                exVar21 = this.eqa.epe;
                                if (view != exVar21.eug.exj && view.getId() != r.g.pb_god_user_tip_content) {
                                    exVar28 = this.eqa.epe;
                                    if (view == exVar28.eug.exl) {
                                        dhVar103 = this.eqa.eov;
                                        AdditionData aMC = dhVar103.getPbData().aMC();
                                        if (!TextUtils.isEmpty(aMC.getWarnMsg())) {
                                            com.baidu.adp.lib.util.k.showToast(this.eqa.getPageContext().getPageActivity(), aMC.getWarnMsg());
                                            return;
                                        } else if (aMC.getAlreadyCount() != aMC.getTotalCount()) {
                                            dhVar104 = this.eqa.eov;
                                            ForumData aMr = dhVar104.getPbData().aMr();
                                            dhVar105 = this.eqa.eov;
                                            com.baidu.tbadk.core.data.bi aMs = dhVar105.getPbData().aMs();
                                            dhVar106 = this.eqa.eov;
                                            AntiData qq = dhVar106.getPbData().qq();
                                            if (aMs.getId() != null) {
                                                if (qq != null && qq.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.k.showToast(this.eqa.getPageContext().getPageActivity(), qq.getForbid_info());
                                                    return;
                                                }
                                                int i2 = 0;
                                                dhVar107 = this.eqa.eov;
                                                if (dhVar107.getPbData().getUserData() != null) {
                                                    dhVar108 = this.eqa.eov;
                                                    i2 = dhVar108.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.eqa.getPageContext().getPageActivity(), 2, aMr.getId(), aMr.getName(), aMs.getId(), aMC.getPostId(), 0, qq, 13008, false, false, null, false, false, null, aMC, null, i2)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.k.showToast(this.eqa.getPageContext().getPageActivity(), String.format(this.eqa.getPageContext().getString(r.j.write_addition_limit), Integer.valueOf(aMC.getTotalCount())));
                                            return;
                                        }
                                    }
                                    exVar29 = this.eqa.epe;
                                    if (exVar29.eug.aQP() != null) {
                                        exVar78 = this.eqa.epe;
                                        if (view == exVar78.eug.aQP().aOU()) {
                                            exVar79 = this.eqa.epe;
                                            exVar79.aBc();
                                            om = this.eqa.om(11009);
                                            if (om) {
                                                dhVar102 = this.eqa.eov;
                                                exVar80 = this.eqa.epe;
                                                if (dhVar102.oy(exVar80.aQf()) == null) {
                                                    return;
                                                }
                                                this.eqa.aNx();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    exVar30 = this.eqa.epe;
                                    if (exVar30.eug.aQP() != null) {
                                        exVar75 = this.eqa.epe;
                                        if (view != exVar75.eug.aQP().aPi()) {
                                            exVar77 = this.eqa.epe;
                                        }
                                        exVar76 = this.eqa.epe;
                                        exVar76.eug.ob();
                                        return;
                                    }
                                    exVar31 = this.eqa.epe;
                                    if (view != exVar31.aQd()) {
                                        exVar32 = this.eqa.epe;
                                        if (exVar32.eug.aQP() != null) {
                                            exVar71 = this.eqa.epe;
                                            if (view == exVar71.eug.aQP().aPd()) {
                                                exVar72 = this.eqa.epe;
                                                exVar72.aBc();
                                                dhVar95 = this.eqa.eov;
                                                if (dhVar95.api() != null) {
                                                    exVar73 = this.eqa.epe;
                                                    dhVar96 = this.eqa.eov;
                                                    exVar73.a(dhVar96.api(), this.eqa.dZi);
                                                }
                                                TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        exVar33 = this.eqa.epe;
                                        if (exVar33.eug.aQP() != null) {
                                            exVar68 = this.eqa.epe;
                                            if (view == exVar68.eug.aQP().aPe()) {
                                                exVar69 = this.eqa.epe;
                                                exVar69.aBc();
                                                this.eqa.on(2);
                                                this.eqa.abb();
                                                exVar70 = this.eqa.epe;
                                                exVar70.aPY();
                                                dhVar94 = this.eqa.eov;
                                                dhVar94.aOF();
                                                TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        exVar34 = this.eqa.epe;
                                        if (exVar34.eug.aQP() != null) {
                                            exVar66 = this.eqa.epe;
                                            if (view == exVar66.eug.aQP().aPf()) {
                                                dhVar90 = this.eqa.eov;
                                                if (dhVar90 != null) {
                                                    dhVar91 = this.eqa.eov;
                                                    if (dhVar91.getPbData() != null) {
                                                        dhVar92 = this.eqa.eov;
                                                        if (dhVar92.getPbData().aMs() != null) {
                                                            exVar67 = this.eqa.epe;
                                                            exVar67.eug.ob();
                                                            PbActivity pbActivity2 = this.eqa;
                                                            dhVar93 = this.eqa.eov;
                                                            pbActivity2.pd(dhVar93.getPbData().aMs().sc());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        exVar35 = this.eqa.epe;
                                        if (exVar35.eug.aQP() != null) {
                                            exVar64 = this.eqa.epe;
                                            if (view == exVar64.eug.aQP().esm) {
                                                dhVar87 = this.eqa.eov;
                                                if (dhVar87 != null) {
                                                    dhVar88 = this.eqa.eov;
                                                    if (dhVar88.getPbData() != null) {
                                                        dhVar89 = this.eqa.eov;
                                                        if (dhVar89.getPbData().aMs() != null) {
                                                            exVar65 = this.eqa.epe;
                                                            exVar65.eug.ob();
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.eqa.getPageContext().getPageActivity(), 0, TbConfig.ECOMM_FEED_BACK_ID, TbConfig.ECOMM_FEED_BACK_NAME, null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0)));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        exVar36 = this.eqa.epe;
                                        if (exVar36.eug.aQP() != null) {
                                            exVar60 = this.eqa.epe;
                                            if (view == exVar60.eug.aQP().aPg()) {
                                                TiebaStatic.log("c10414");
                                                exVar61 = this.eqa.epe;
                                                exVar61.aBc();
                                                exVar62 = this.eqa.epe;
                                                if (exVar62.rD() != ex.evW) {
                                                    dhVar85 = this.eqa.eov;
                                                    if (dhVar85.aOT() != null) {
                                                        dhVar86 = this.eqa.eov;
                                                        dhVar86.aOT().oq(dh.erf);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                exVar63 = this.eqa.epe;
                                                exVar63.aQB();
                                                return;
                                            }
                                        }
                                        exVar37 = this.eqa.epe;
                                        if (exVar37.eug.aQP() != null) {
                                            exVar57 = this.eqa.epe;
                                            if (view == exVar57.eug.aQP().aPh()) {
                                                aNq = this.eqa.aNq();
                                                this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.eqa.getPageContext().getPageActivity(), null, aNq, true)));
                                                exVar58 = this.eqa.epe;
                                                exVar58.eug.ob();
                                                exVar59 = this.eqa.epe;
                                                exVar59.eug.aQP().aPm();
                                                return;
                                            }
                                        }
                                        cdo = this.eqa.epj;
                                        if (cdo != null) {
                                            cdo49 = this.eqa.epj;
                                            if (view == cdo49.aOW()) {
                                                Object tag = view.getTag();
                                                if (!(tag instanceof String)) {
                                                    if (tag instanceof SparseArray) {
                                                        SparseArray<Object> sparseArray5 = (SparseArray) tag;
                                                        if ((sparseArray5.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(r.g.tag_user_mute_visible)).booleanValue()) {
                                                            sparseArray5.put(r.g.tag_from, 0);
                                                            sparseArray5.put(r.g.tag_check_mute_from, 2);
                                                            this.eqa.d(sparseArray5);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.eqa.pd((String) tag);
                                                return;
                                            }
                                        }
                                        cdo2 = this.eqa.epj;
                                        if (cdo2 != null) {
                                            cdo48 = this.eqa.epj;
                                            if (view == cdo48.aOU()) {
                                                if (!this.eqa.checkUpIsLogin()) {
                                                    return;
                                                }
                                                this.eqa.aU(view);
                                                return;
                                            }
                                        }
                                        cdo3 = this.eqa.epj;
                                        if (cdo3 != null) {
                                            cdo47 = this.eqa.epj;
                                            if (view == cdo47.aPa()) {
                                                if (view.getTag(r.g.tag_pb_floor_postion) instanceof Integer) {
                                                    dhVar83 = this.eqa.eov;
                                                    if (dhVar83 != null) {
                                                        exVar56 = this.eqa.epe;
                                                        exVar56.aPO();
                                                        if (!UtilHelper.isFloatWindowOpAllowed(this.eqa.getPageContext().getPageActivity())) {
                                                            this.eqa.aNp();
                                                            return;
                                                        }
                                                        int intValue = ((Integer) view.getTag(r.g.tag_pb_floor_postion)).intValue();
                                                        int intValue2 = ((Integer) view.getTag(r.g.tag_pb_floor_number)).intValue();
                                                        this.eqa.epk = true;
                                                        PbActivity pbActivity3 = this.eqa;
                                                        dhVar84 = this.eqa.eov;
                                                        pbActivity3.a(dhVar84.getPbData(), intValue, intValue2, true, true);
                                                        TiebaStatic.log("c10834");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        cdo4 = this.eqa.epj;
                                        if (cdo4 != null) {
                                            cdo46 = this.eqa.epj;
                                            if (view == cdo46.aOX()) {
                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                if (sparseArray6 != null && (sparseArray6.get(r.g.tag_del_post_type) instanceof Integer) && (sparseArray6.get(r.g.tag_del_post_id) instanceof String) && (sparseArray6.get(r.g.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(r.g.tag_del_post_is_self) instanceof Boolean)) {
                                                    boolean booleanValue2 = ((Boolean) sparseArray6.get(r.g.tag_del_post_is_self)).booleanValue();
                                                    int intValue3 = ((Integer) sparseArray6.get(r.g.tag_manage_user_identity)).intValue();
                                                    if (!booleanValue2 && intValue3 != 0 && com.baidu.tieba.c.a.NO()) {
                                                        Context baseContext = this.eqa.getBaseContext();
                                                        dhVar82 = this.eqa.eov;
                                                        if (com.baidu.tieba.c.a.f(baseContext, dhVar82.getThreadID(), (String) sparseArray6.get(r.g.tag_del_post_id))) {
                                                            return;
                                                        }
                                                    }
                                                    exVar55 = this.eqa.epe;
                                                    exVar55.a(((Integer) sparseArray6.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray6.get(r.g.tag_del_post_id), intValue3, booleanValue2);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        cdo5 = this.eqa.epj;
                                        if (cdo5 != null) {
                                            cdo45 = this.eqa.epj;
                                            if (view == cdo45.aOY()) {
                                                long j = -1;
                                                String str2 = "";
                                                int i3 = 0;
                                                if (view.getTag(r.g.tag_chudian_template_id) instanceof Long) {
                                                    j = ((Long) view.getTag(r.g.tag_chudian_template_id)).longValue();
                                                }
                                                if (view.getTag(r.g.tag_chudian_monitor_id) instanceof String) {
                                                    str2 = (String) view.getTag(r.g.tag_chudian_monitor_id);
                                                }
                                                if (view.getTag(r.g.tag_chudian_hide_day) instanceof Integer) {
                                                    i3 = ((Integer) view.getTag(r.g.tag_chudian_hide_day)).intValue();
                                                }
                                                dhVar81 = this.eqa.eov;
                                                com.baidu.tieba.pb.data.h pbData = dhVar81.getPbData();
                                                String str3 = null;
                                                String str4 = null;
                                                String str5 = null;
                                                if (pbData != null && pbData.aMr() != null) {
                                                    str3 = pbData.aMr().getId();
                                                    str4 = pbData.aMr().getName();
                                                    str5 = pbData.getThreadId();
                                                }
                                                com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                                this.eqa.a(j, str2, str3, str4, str5, i3);
                                                return;
                                            }
                                        }
                                        exVar38 = this.eqa.epe;
                                        if (exVar38.aQC() == view) {
                                            exVar54 = this.eqa.epe;
                                            if (exVar54.aQC().getIndicateStatus()) {
                                                dhVar80 = this.eqa.eov;
                                                com.baidu.tieba.pb.data.h pbData2 = dhVar80.getPbData();
                                                if (pbData2 != null && pbData2.aMs() != null && pbData2.aMs().rx() != null) {
                                                    String pt = pbData2.aMs().rx().pt();
                                                    if (StringUtils.isNull(pt)) {
                                                        pt = pbData2.aMs().rx().getTaskId();
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11107").ab("obj_id", pt));
                                                }
                                            } else {
                                                com.baidu.tieba.tbadkCore.d.a.bS("c10725", null);
                                            }
                                            this.eqa.aNK();
                                            return;
                                        }
                                        exVar39 = this.eqa.epe;
                                        if (exVar39.aPR() != view) {
                                            cdo6 = this.eqa.epj;
                                            if (cdo6 != null) {
                                                cdo44 = this.eqa.epj;
                                                if (view == cdo44.aOV()) {
                                                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                                                    if (sparseArray7 != null) {
                                                        if (com.baidu.tieba.c.a.NO() && sparseArray7.get(r.g.tag_del_post_id) != null) {
                                                            Context baseContext2 = this.eqa.getBaseContext();
                                                            dhVar78 = this.eqa.eov;
                                                            if (com.baidu.tieba.c.a.f(baseContext2, dhVar78.getThreadID(), (String) sparseArray7.get(r.g.tag_del_post_id))) {
                                                                return;
                                                            }
                                                        }
                                                        boolean booleanValue3 = ((Boolean) sparseArray7.get(r.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue4 = ((Boolean) sparseArray7.get(r.g.tag_should_delete_visible)).booleanValue();
                                                        boolean booleanValue5 = ((Boolean) sparseArray7.get(r.g.tag_user_mute_visible)).booleanValue();
                                                        if (booleanValue3) {
                                                            if (booleanValue5) {
                                                                sparseArray7.put(r.g.tag_from, 1);
                                                                sparseArray7.put(r.g.tag_check_mute_from, 2);
                                                                this.eqa.d(sparseArray7);
                                                                return;
                                                            }
                                                            sparseArray7.put(r.g.tag_check_mute_from, 2);
                                                            exVar53 = this.eqa.epe;
                                                            exVar53.aY(view);
                                                            return;
                                                        } else if (booleanValue4) {
                                                            exVar52 = this.eqa.epe;
                                                            exVar52.a(((Integer) sparseArray7.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(r.g.tag_del_post_id), ((Integer) sparseArray7.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(r.g.tag_del_post_is_self)).booleanValue());
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                            }
                                            exVar40 = this.eqa.epe;
                                            if (view == exVar40.aOr()) {
                                                if (this.eqa.checkUpIsLogin()) {
                                                    exVar49 = this.eqa.epe;
                                                    if (!exVar49.aOo()) {
                                                        dhVar74 = this.eqa.eov;
                                                        if (dhVar74 != null) {
                                                            dhVar75 = this.eqa.eov;
                                                            if (dhVar75.aOR() != null) {
                                                                dhVar76 = this.eqa.eov;
                                                                if (dhVar76.aOR().aOi() != null) {
                                                                    dhVar77 = this.eqa.eov;
                                                                    if (com.baidu.tbadk.core.util.y.s(dhVar77.aOR().aOi().getItems()) != 0) {
                                                                        exVar50 = this.eqa.epe;
                                                                        exVar50.aOp();
                                                                        return;
                                                                    }
                                                                    this.eqa.showToast(r.j.graffiti_quick_vote_empty);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    exVar51 = this.eqa.epe;
                                                    exVar51.aOq();
                                                    return;
                                                }
                                                return;
                                            } else if (view.getId() == r.g.pb_head_function_manage_delormanage) {
                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                if (!((Boolean) sparseArray8.get(r.g.tag_should_manage_visible)).booleanValue()) {
                                                    exVar47 = this.eqa.epe;
                                                    exVar47.a(((Integer) sparseArray8.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(r.g.tag_del_post_id), ((Integer) sparseArray8.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(r.g.tag_del_post_is_self)).booleanValue());
                                                    return;
                                                }
                                                if (com.baidu.tieba.c.a.NO()) {
                                                    Context baseContext3 = this.eqa.getBaseContext();
                                                    dhVar73 = this.eqa.eov;
                                                    if (com.baidu.tieba.c.a.f(baseContext3, dhVar73.getThreadID(), null)) {
                                                        return;
                                                    }
                                                }
                                                exVar48 = this.eqa.epe;
                                                exVar48.aY(view);
                                                return;
                                            } else if (view.getId() != r.g.replybtn && view.getId() != r.g.sub_pb_more && view.getId() != r.g.sub_pb_item) {
                                                exVar42 = this.eqa.epe;
                                                if (view == exVar42.aNf()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                        dhVar70 = this.eqa.eov;
                                                        long c2 = com.baidu.adp.lib.h.b.c(dhVar70.getPbData().getForumId(), 0L);
                                                        dhVar71 = this.eqa.eov;
                                                        long c3 = com.baidu.adp.lib.h.b.c(dhVar71.getThreadID(), 0L);
                                                        dhVar72 = this.eqa.eov;
                                                        this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.eqa.getPageContext().getPageActivity(), 24008, c2, c3, c, dhVar72.getPbData().aMs().sf())));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                int id = view.getId();
                                                if (id == r.g.pb_u9_text_view) {
                                                    if (this.eqa.checkUpIsLogin() && (bpVar = (com.baidu.tbadk.core.data.bp) view.getTag()) != null && !StringUtils.isNull(bpVar.tb())) {
                                                        TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                        com.baidu.tbadk.core.util.bh.vL().c(this.eqa.getPageContext(), new String[]{bpVar.tb()});
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == r.g.reply) {
                                                    cdo7 = this.eqa.epj;
                                                    if (cdo7 == null) {
                                                        this.eqa.epj = new Cdo(this.eqa.getPageContext(), this.eqa.bRx);
                                                        cdo43 = this.eqa.epj;
                                                        z7 = this.eqa.mIsLogin;
                                                        cdo43.ij(z7);
                                                    }
                                                    cdo8 = this.eqa.epj;
                                                    cdo8.GM();
                                                    com.baidu.tieba.tbadkCore.data.q qVar = null;
                                                    if (view != null && view.getTag() != null) {
                                                        qVar = (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_load_sub_data);
                                                        if (!this.eqa.aNE()) {
                                                            dhVar69 = this.eqa.eov;
                                                            if (dhVar69.aOG() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                                                                cdo42 = this.eqa.epj;
                                                                cdo42.aPc();
                                                                sparseArray = (SparseArray) view.getTag();
                                                                if (sparseArray.get(r.g.tag_pb_floor_postion) instanceof Integer) {
                                                                    int intValue4 = ((Integer) sparseArray.get(r.g.tag_pb_floor_postion)).intValue();
                                                                    int intValue5 = ((Integer) sparseArray.get(r.g.tag_pb_floor_number)).intValue();
                                                                    cdo40 = this.eqa.epj;
                                                                    cdo40.aPa().setTag(r.g.tag_pb_floor_postion, Integer.valueOf(intValue4));
                                                                    cdo41 = this.eqa.epj;
                                                                    cdo41.aPa().setTag(r.g.tag_pb_floor_number, Integer.valueOf(intValue5));
                                                                }
                                                                SparseArray sparseArray9 = new SparseArray();
                                                                sparseArray9.put(r.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_clip_board));
                                                                sparseArray9.put(r.g.tag_is_subpb, false);
                                                                cdo14 = this.eqa.epj;
                                                                cdo14.aOU().setTag(sparseArray9);
                                                                sparseArray2 = (SparseArray) view.getTag();
                                                                booleanValue = ((Boolean) sparseArray2.get(r.g.tag_should_manage_visible)).booleanValue();
                                                                boolean booleanValue6 = ((Boolean) sparseArray2.get(r.g.tag_user_mute_visible)).booleanValue();
                                                                boolean booleanValue7 = ((Boolean) sparseArray2.get(r.g.tag_should_delete_visible)).booleanValue();
                                                                if (sparseArray2.get(r.g.tag_del_post_is_self) instanceof Boolean) {
                                                                    z3 = false;
                                                                } else {
                                                                    z3 = ((Boolean) sparseArray2.get(r.g.tag_del_post_is_self)).booleanValue();
                                                                }
                                                                String str6 = null;
                                                                if (sparseArray2.get(r.g.tag_forbid_user_post_id) instanceof String) {
                                                                    str6 = (String) sparseArray2.get(r.g.tag_forbid_user_post_id);
                                                                }
                                                                if (!booleanValue) {
                                                                    SparseArray sparseArray10 = new SparseArray();
                                                                    sparseArray10.put(r.g.tag_should_manage_visible, true);
                                                                    sparseArray10.put(r.g.tag_manage_user_identity, sparseArray2.get(r.g.tag_manage_user_identity));
                                                                    sparseArray10.put(r.g.tag_forbid_user_name, sparseArray2.get(r.g.tag_forbid_user_name));
                                                                    sparseArray10.put(r.g.tag_forbid_user_post_id, str6);
                                                                    if (booleanValue6) {
                                                                        sparseArray10.put(r.g.tag_user_mute_visible, true);
                                                                        sparseArray10.put(r.g.tag_is_mem, sparseArray2.get(r.g.tag_is_mem));
                                                                        sparseArray10.put(r.g.tag_user_mute_mute_userid, sparseArray2.get(r.g.tag_user_mute_mute_userid));
                                                                        sparseArray10.put(r.g.tag_user_mute_mute_username, sparseArray2.get(r.g.tag_user_mute_mute_username));
                                                                        sparseArray10.put(r.g.tag_user_mute_post_id, sparseArray2.get(r.g.tag_user_mute_post_id));
                                                                        sparseArray10.put(r.g.tag_user_mute_thread_id, sparseArray2.get(r.g.tag_user_mute_thread_id));
                                                                    } else {
                                                                        sparseArray10.put(r.g.tag_user_mute_visible, false);
                                                                    }
                                                                    if (booleanValue7) {
                                                                        sparseArray10.put(r.g.tag_should_delete_visible, true);
                                                                        sparseArray10.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                        sparseArray10.put(r.g.tag_del_post_id, sparseArray2.get(r.g.tag_del_post_id));
                                                                        sparseArray10.put(r.g.tag_del_post_type, sparseArray2.get(r.g.tag_del_post_type));
                                                                        cdo39 = this.eqa.epj;
                                                                        cdo39.aOX().setVisibility(0);
                                                                    } else {
                                                                        sparseArray10.put(r.g.tag_should_delete_visible, false);
                                                                        cdo34 = this.eqa.epj;
                                                                        cdo34.aOX().setVisibility(8);
                                                                    }
                                                                    cdo35 = this.eqa.epj;
                                                                    cdo35.aOV().setTag(sparseArray10);
                                                                    cdo36 = this.eqa.epj;
                                                                    cdo36.aOX().setTag(sparseArray10);
                                                                    cdo37 = this.eqa.epj;
                                                                    cdo37.aOV().setText(r.j.bar_manager);
                                                                    cdo38 = this.eqa.epj;
                                                                    cdo38.aOV().setVisibility(0);
                                                                } else if (!booleanValue7) {
                                                                    cdo15 = this.eqa.epj;
                                                                    cdo15.aOV().setVisibility(8);
                                                                    cdo16 = this.eqa.epj;
                                                                    cdo16.aOX().setVisibility(8);
                                                                } else {
                                                                    SparseArray sparseArray11 = new SparseArray();
                                                                    sparseArray11.put(r.g.tag_should_manage_visible, false);
                                                                    sparseArray11.put(r.g.tag_user_mute_visible, false);
                                                                    sparseArray11.put(r.g.tag_should_delete_visible, true);
                                                                    sparseArray11.put(r.g.tag_manage_user_identity, sparseArray2.get(r.g.tag_manage_user_identity));
                                                                    sparseArray11.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                    sparseArray11.put(r.g.tag_del_post_id, sparseArray2.get(r.g.tag_del_post_id));
                                                                    sparseArray11.put(r.g.tag_del_post_type, sparseArray2.get(r.g.tag_del_post_type));
                                                                    cdo17 = this.eqa.epj;
                                                                    cdo17.aOV().setTag(sparseArray11);
                                                                    cdo18 = this.eqa.epj;
                                                                    cdo18.aOX().setTag(sparseArray11);
                                                                    cdo19 = this.eqa.epj;
                                                                    cdo19.aOV().setText(r.j.delete);
                                                                    cdo20 = this.eqa.epj;
                                                                    cdo20.aOX().setVisibility(0);
                                                                    cdo21 = this.eqa.epj;
                                                                    cdo21.aOV().setVisibility(8);
                                                                }
                                                                sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3.get(r.g.tag_user_mute_visible) instanceof Boolean) {
                                                                    z4 = false;
                                                                } else {
                                                                    z4 = ((Boolean) sparseArray3.get(r.g.tag_user_mute_visible)).booleanValue();
                                                                }
                                                                if (((Boolean) sparseArray3.get(r.g.tag_should_manage_visible)).booleanValue() && z4) {
                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                    sparseArray12.put(r.g.tag_user_mute_visible, true);
                                                                    sparseArray12.put(r.g.tag_is_mem, sparseArray3.get(r.g.tag_is_mem));
                                                                    sparseArray12.put(r.g.tag_user_mute_mute_userid, sparseArray3.get(r.g.tag_user_mute_mute_userid));
                                                                    sparseArray12.put(r.g.tag_user_mute_mute_username, sparseArray3.get(r.g.tag_user_mute_mute_username));
                                                                    sparseArray12.put(r.g.tag_user_mute_post_id, sparseArray3.get(r.g.tag_user_mute_post_id));
                                                                    sparseArray12.put(r.g.tag_user_mute_thread_id, sparseArray3.get(r.g.tag_user_mute_thread_id));
                                                                    sparseArray12.put(r.g.tag_del_post_is_self, sparseArray3.get(r.g.tag_del_post_is_self));
                                                                    sparseArray12.put(r.g.tag_del_post_type, sparseArray3.get(r.g.tag_del_post_type));
                                                                    sparseArray12.put(r.g.tag_del_post_id, sparseArray3.get(r.g.tag_del_post_id));
                                                                    sparseArray12.put(r.g.tag_manage_user_identity, sparseArray3.get(r.g.tag_manage_user_identity));
                                                                    cdo30 = this.eqa.epj;
                                                                    cdo30.aOW().setTag(sparseArray12);
                                                                    cdo31 = this.eqa.epj;
                                                                    cdo31.aOW().setVisibility(0);
                                                                    cdo32 = this.eqa.epj;
                                                                    cdo32.aOV().setVisibility(8);
                                                                    cdo33 = this.eqa.epj;
                                                                    cdo33.aOW().setText(r.j.mute_option);
                                                                } else {
                                                                    if (sparseArray3.get(r.g.tag_del_post_is_self) instanceof Boolean) {
                                                                        z5 = false;
                                                                    } else {
                                                                        z5 = ((Boolean) sparseArray3.get(r.g.tag_del_post_is_self)).booleanValue();
                                                                    }
                                                                    String str7 = null;
                                                                    if (sparseArray3.get(r.g.tag_forbid_user_post_id) instanceof String) {
                                                                        str7 = (String) sparseArray3.get(r.g.tag_forbid_user_post_id);
                                                                    }
                                                                    hZ = this.eqa.hZ(z5);
                                                                    isLogin = hZ & this.eqa.isLogin();
                                                                    this.eqa.epR = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(r.g.tag_clip_board);
                                                                    if (!(!ew.g(this.eqa.epR) ? false : isLogin)) {
                                                                        cdo23 = this.eqa.epj;
                                                                        cdo23.aOW().setVisibility(0);
                                                                        cdo24 = this.eqa.epj;
                                                                        cdo24.aOW().setTag(str7);
                                                                    } else {
                                                                        cdo22 = this.eqa.epj;
                                                                        cdo22.aOW().setVisibility(8);
                                                                    }
                                                                }
                                                                sparseArray4 = (SparseArray) view.getTag();
                                                                long j2 = 0;
                                                                if (sparseArray4.get(r.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = ((Boolean) sparseArray4.get(r.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                }
                                                                if (sparseArray4.get(r.g.tag_chudian_template_id) instanceof Long) {
                                                                    j2 = ((Long) sparseArray4.get(r.g.tag_chudian_template_id)).longValue();
                                                                }
                                                                if (sparseArray4.get(r.g.tag_chudian_monitor_id) instanceof String) {
                                                                    str = "";
                                                                } else {
                                                                    str = (String) sparseArray4.get(r.g.tag_chudian_monitor_id);
                                                                }
                                                                if (sparseArray4.get(r.g.tag_chudian_hide_day) instanceof Integer) {
                                                                    i = 0;
                                                                } else {
                                                                    i = ((Integer) sparseArray4.get(r.g.tag_chudian_hide_day)).intValue();
                                                                }
                                                                if (!z6) {
                                                                    cdo26 = this.eqa.epj;
                                                                    cdo26.aOY().setVisibility(0);
                                                                    cdo27 = this.eqa.epj;
                                                                    cdo27.aOY().setTag(r.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                    cdo28 = this.eqa.epj;
                                                                    cdo28.aOY().setTag(r.g.tag_chudian_monitor_id, str);
                                                                    cdo29 = this.eqa.epj;
                                                                    cdo29.aOY().setTag(r.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                } else {
                                                                    cdo25 = this.eqa.epj;
                                                                    cdo25.aOY().setVisibility(8);
                                                                }
                                                            }
                                                        }
                                                        cdo13 = this.eqa.epj;
                                                        cdo13.aPb();
                                                        sparseArray = (SparseArray) view.getTag();
                                                        if (sparseArray.get(r.g.tag_pb_floor_postion) instanceof Integer) {
                                                        }
                                                        SparseArray sparseArray92 = new SparseArray();
                                                        sparseArray92.put(r.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_clip_board));
                                                        sparseArray92.put(r.g.tag_is_subpb, false);
                                                        cdo14 = this.eqa.epj;
                                                        cdo14.aOU().setTag(sparseArray92);
                                                        sparseArray2 = (SparseArray) view.getTag();
                                                        booleanValue = ((Boolean) sparseArray2.get(r.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue62 = ((Boolean) sparseArray2.get(r.g.tag_user_mute_visible)).booleanValue();
                                                        boolean booleanValue72 = ((Boolean) sparseArray2.get(r.g.tag_should_delete_visible)).booleanValue();
                                                        if (sparseArray2.get(r.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str62 = null;
                                                        if (sparseArray2.get(r.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        if (!booleanValue) {
                                                        }
                                                        sparseArray3 = (SparseArray) view.getTag();
                                                        if (sparseArray3.get(r.g.tag_user_mute_visible) instanceof Boolean) {
                                                        }
                                                        if (((Boolean) sparseArray3.get(r.g.tag_should_manage_visible)).booleanValue()) {
                                                        }
                                                        if (sparseArray3.get(r.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str72 = null;
                                                        if (sparseArray3.get(r.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        hZ = this.eqa.hZ(z5);
                                                        isLogin = hZ & this.eqa.isLogin();
                                                        this.eqa.epR = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(r.g.tag_clip_board);
                                                        if (!(!ew.g(this.eqa.epR) ? false : isLogin)) {
                                                        }
                                                        sparseArray4 = (SparseArray) view.getTag();
                                                        long j22 = 0;
                                                        if (sparseArray4.get(r.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                        }
                                                        if (sparseArray4.get(r.g.tag_chudian_template_id) instanceof Long) {
                                                        }
                                                        if (sparseArray4.get(r.g.tag_chudian_monitor_id) instanceof String) {
                                                        }
                                                        if (sparseArray4.get(r.g.tag_chudian_hide_day) instanceof Integer) {
                                                        }
                                                        if (!z6) {
                                                        }
                                                    }
                                                    dhVar67 = this.eqa.eov;
                                                    if (dhVar67.getPbData().nv()) {
                                                        dhVar68 = this.eqa.eov;
                                                        String nu = dhVar68.getPbData().nu();
                                                        if (qVar != null && !com.baidu.adp.lib.util.j.isEmpty(nu) && nu.equals(qVar.getId())) {
                                                            z2 = true;
                                                            if (!z2) {
                                                                cdo12 = this.eqa.epj;
                                                                cdo12.aOU().setText(r.j.remove_mark);
                                                            } else {
                                                                cdo9 = this.eqa.epj;
                                                                cdo9.aOU().setText(r.j.mark);
                                                            }
                                                            cdo10 = this.eqa.epj;
                                                            cdo10.ik(true);
                                                            cdo11 = this.eqa.epj;
                                                            cdo11.wf();
                                                            return;
                                                        }
                                                    }
                                                    z2 = false;
                                                    if (!z2) {
                                                    }
                                                    cdo10 = this.eqa.epj;
                                                    cdo10.ik(true);
                                                    cdo11 = this.eqa.epj;
                                                    cdo11.wf();
                                                    return;
                                                } else if (id != r.g.pb_head_reverse_hint) {
                                                    if (id == r.g.pb_act_btn) {
                                                        dhVar60 = this.eqa.eov;
                                                        if (dhVar60.getPbData() != null) {
                                                            dhVar61 = this.eqa.eov;
                                                            if (dhVar61.getPbData().aMs() != null) {
                                                                dhVar62 = this.eqa.eov;
                                                                if (dhVar62.getPbData().aMs().ss() != null) {
                                                                    Activity activity = this.eqa.getActivity();
                                                                    dhVar63 = this.eqa.eov;
                                                                    com.baidu.tbadk.browser.f.u(activity, dhVar63.getPbData().aMs().ss());
                                                                    dhVar64 = this.eqa.eov;
                                                                    if (dhVar64.getPbData().aMs().sq() != 1) {
                                                                        dhVar65 = this.eqa.eov;
                                                                        if (dhVar65.getPbData().aMs().sq() == 2) {
                                                                            TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == r.g.lottery_tail) {
                                                        if (view.getTag(r.g.tag_pb_lottery_tail_link) instanceof String) {
                                                            String str8 = (String) view.getTag(r.g.tag_pb_lottery_tail_link);
                                                            com.baidu.tbadk.core.util.ax axVar2 = new com.baidu.tbadk.core.util.ax("c10912");
                                                            dhVar57 = this.eqa.eov;
                                                            com.baidu.tbadk.core.util.ax ab = axVar2.ab("fid", dhVar57.getPbData().getForumId());
                                                            dhVar58 = this.eqa.eov;
                                                            TiebaStatic.log(ab.ab("tid", dhVar58.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                            dhVar59 = this.eqa.eov;
                                                            if (dhVar59.getPbData().getThreadId().equals(str8)) {
                                                                exVar44 = this.eqa.epe;
                                                                exVar44.setSelection(0);
                                                                return;
                                                            }
                                                            this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.eqa.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == r.g.pb_item_tail_content) {
                                                        if (com.baidu.tbadk.core.util.bm.ak(this.eqa.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.m9getInst().getString(r.j.tail_web_view_title);
                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.uh().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                            }
                                                            exVar43 = this.eqa.epe;
                                                            exVar43.aPG();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == r.g.join_vote_tv) {
                                                        if (view != null) {
                                                            com.baidu.tbadk.browser.f.u(this.eqa.getActivity(), (String) view.getTag());
                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                            aNr3 = this.eqa.aNr();
                                                            if (aNr3 == 1) {
                                                                dhVar53 = this.eqa.eov;
                                                                if (dhVar53 != null) {
                                                                    dhVar54 = this.eqa.eov;
                                                                    if (dhVar54.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ax axVar3 = new com.baidu.tbadk.core.util.ax("c10397");
                                                                        dhVar55 = this.eqa.eov;
                                                                        com.baidu.tbadk.core.util.ax ab2 = axVar3.ab("fid", dhVar55.getPbData().getForumId());
                                                                        dhVar56 = this.eqa.eov;
                                                                        TiebaStatic.log(ab2.ab("tid", dhVar56.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aNr4 = this.eqa.aNr();
                                                            if (aNr4 == 2) {
                                                                dhVar49 = this.eqa.eov;
                                                                if (dhVar49 != null) {
                                                                    dhVar50 = this.eqa.eov;
                                                                    if (dhVar50.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ax axVar4 = new com.baidu.tbadk.core.util.ax("c10401");
                                                                        dhVar51 = this.eqa.eov;
                                                                        com.baidu.tbadk.core.util.ax ab3 = axVar4.ab("fid", dhVar51.getPbData().getForumId());
                                                                        dhVar52 = this.eqa.eov;
                                                                        TiebaStatic.log(ab3.ab("tid", dhVar52.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == r.g.look_all_tv) {
                                                        if (view != null) {
                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                            com.baidu.tbadk.browser.f.u(this.eqa.getActivity(), (String) view.getTag());
                                                            aNr = this.eqa.aNr();
                                                            if (aNr == 1) {
                                                                dhVar45 = this.eqa.eov;
                                                                if (dhVar45 != null) {
                                                                    dhVar46 = this.eqa.eov;
                                                                    if (dhVar46.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ax axVar5 = new com.baidu.tbadk.core.util.ax("c10507");
                                                                        dhVar47 = this.eqa.eov;
                                                                        com.baidu.tbadk.core.util.ax ab4 = axVar5.ab("fid", dhVar47.getPbData().getForumId());
                                                                        dhVar48 = this.eqa.eov;
                                                                        TiebaStatic.log(ab4.ab("tid", dhVar48.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aNr2 = this.eqa.aNr();
                                                            if (aNr2 == 2) {
                                                                dhVar41 = this.eqa.eov;
                                                                if (dhVar41 != null) {
                                                                    dhVar42 = this.eqa.eov;
                                                                    if (dhVar42.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ax axVar6 = new com.baidu.tbadk.core.util.ax("c10508");
                                                                        dhVar43 = this.eqa.eov;
                                                                        com.baidu.tbadk.core.util.ax ab5 = axVar6.ab("fid", dhVar43.getPbData().getForumId());
                                                                        dhVar44 = this.eqa.eov;
                                                                        TiebaStatic.log(ab5.ab("tid", dhVar44.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id != r.g.manga_prev_btn) {
                                                        if (id != r.g.manga_next_btn) {
                                                            if (id == r.g.pb_ecomm_like_button) {
                                                                dhVar35 = this.eqa.eov;
                                                                if (dhVar35 != null) {
                                                                    dhVar37 = this.eqa.eov;
                                                                    if (dhVar37.getPbData() != null) {
                                                                        dhVar38 = this.eqa.eov;
                                                                        if (dhVar38.getPbData().aMs() != null) {
                                                                            dhVar39 = this.eqa.eov;
                                                                            if (dhVar39.getPbData().aMs().UH != null) {
                                                                                if (com.baidu.tbadk.core.util.bm.ak(this.eqa.getPageContext().getPageActivity())) {
                                                                                    dhVar40 = this.eqa.eov;
                                                                                    DealInfoData dealInfoData = dhVar40.getPbData().aMs().UH;
                                                                                    long j3 = dealInfoData.productId;
                                                                                    if (dealInfoData.hasRecommend) {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, false);
                                                                                    } else {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, true);
                                                                                    }
                                                                                    this.eqa.sendMessage(pbEcommRecommendMessage);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ax axVar7 = new com.baidu.tbadk.core.util.ax("c11428");
                                                                axVar7.s("obj_param1", 1);
                                                                dhVar36 = this.eqa.eov;
                                                                axVar7.ab("obj_id", new StringBuilder(String.valueOf(dhVar36.getPbData().aMs().UH.productId)).toString());
                                                                axVar7.s("obj_locate", 3);
                                                                if (axVar7 != null) {
                                                                    TiebaStatic.log(axVar7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id == r.g.pb_editor_tool_comment_ecomm_buy_layout) {
                                                                dhVar27 = this.eqa.eov;
                                                                if (dhVar27 != null) {
                                                                    dhVar29 = this.eqa.eov;
                                                                    if (dhVar29.getPbData() != null) {
                                                                        dhVar30 = this.eqa.eov;
                                                                        if (dhVar30.getPbData().aMs() != null) {
                                                                            dhVar31 = this.eqa.eov;
                                                                            if (dhVar31.getPbData().aMs().UH != null) {
                                                                                if (com.baidu.tbadk.core.util.bm.ak(this.eqa.getPageContext().getPageActivity())) {
                                                                                    dhVar32 = this.eqa.eov;
                                                                                    long j4 = dhVar32.getPbData().aMs().UH.productId;
                                                                                    dhVar33 = this.eqa.eov;
                                                                                    String threadID = dhVar33.getThreadID();
                                                                                    dhVar34 = this.eqa.eov;
                                                                                    String name2 = dhVar34.getPbData().aMr().getName();
                                                                                    EcommEnsureOrderActivityConfig ecommEnsureOrderActivityConfig = new EcommEnsureOrderActivityConfig(this.eqa.getPageContext().getPageActivity(), j4, threadID);
                                                                                    ecommEnsureOrderActivityConfig.setForumName(name2);
                                                                                    this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommEnsureOrderActivityConfig));
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ax axVar8 = new com.baidu.tbadk.core.util.ax("c11428");
                                                                axVar8.s("obj_param1", 1);
                                                                dhVar28 = this.eqa.eov;
                                                                axVar8.ab("obj_id", new StringBuilder(String.valueOf(dhVar28.getPbData().aMs().UH.productId)).toString());
                                                                axVar8.s("obj_locate", 2);
                                                                if (axVar8 != null) {
                                                                    TiebaStatic.log(axVar8);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id == r.g.yule_head_img_img) {
                                                                dhVar23 = this.eqa.eov;
                                                                if (dhVar23 != null) {
                                                                    dhVar24 = this.eqa.eov;
                                                                    if (dhVar24.getPbData() != null) {
                                                                        dhVar25 = this.eqa.eov;
                                                                        if (dhVar25.getPbData().aMG() != null) {
                                                                            dhVar26 = this.eqa.eov;
                                                                            com.baidu.tieba.pb.data.h pbData3 = dhVar26.getPbData();
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11679").ab("fid", pbData3.getForumId()));
                                                                            com.baidu.tbadk.core.util.bh.vL().c(this.eqa.getPageContext(), new String[]{pbData3.aMG().aMJ()});
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id == r.g.yule_head_img_all_rank) {
                                                                dhVar19 = this.eqa.eov;
                                                                if (dhVar19 != null) {
                                                                    dhVar20 = this.eqa.eov;
                                                                    if (dhVar20.getPbData() != null) {
                                                                        dhVar21 = this.eqa.eov;
                                                                        if (dhVar21.getPbData().aMG() != null) {
                                                                            dhVar22 = this.eqa.eov;
                                                                            com.baidu.tieba.pb.data.h pbData4 = dhVar22.getPbData();
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11678").ab("fid", pbData4.getForumId()));
                                                                            com.baidu.tbadk.core.util.bh.vL().c(this.eqa.getPageContext(), new String[]{pbData4.aMG().aMJ()});
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        this.eqa.aNG();
                                                        return;
                                                    } else {
                                                        this.eqa.aNF();
                                                        return;
                                                    }
                                                } else {
                                                    this.eqa.abb();
                                                    exVar45 = this.eqa.epe;
                                                    exVar45.aBc();
                                                    exVar46 = this.eqa.epe;
                                                    exVar46.aPY();
                                                    dhVar66 = this.eqa.eov;
                                                    dhVar66.aOF();
                                                    this.eqa.on(2);
                                                    this.eqa.aNJ();
                                                    return;
                                                }
                                            } else if (this.eqa.checkUpIsLogin()) {
                                                dhVar5 = this.eqa.eov;
                                                if (dhVar5.getPbData() != null) {
                                                    exVar41 = this.eqa.epe;
                                                    exVar41.aBc();
                                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) sparseArray13.get(r.g.tag_load_sub_data);
                                                    View view2 = (View) sparseArray13.get(r.g.tag_load_sub_view);
                                                    if (qVar2 != null && view2 != null) {
                                                        dhVar6 = this.eqa.eov;
                                                        String threadID2 = dhVar6.getThreadID();
                                                        String id2 = qVar2.getId();
                                                        int i4 = 0;
                                                        dhVar7 = this.eqa.eov;
                                                        if (dhVar7.getPbData() != null) {
                                                            dhVar17 = this.eqa.eov;
                                                            i4 = dhVar17.getPbData().aMz();
                                                        }
                                                        this.eqa.abb();
                                                        if (view.getId() != r.g.replybtn) {
                                                            if (view.getId() == r.g.sub_pb_item) {
                                                                SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                                String str9 = (String) sparseArray14.get(r.g.tag_photo_username);
                                                                com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) sparseArray14.get(r.g.tag_clip_board);
                                                                String str10 = null;
                                                                if (qVar3 != null) {
                                                                    str10 = qVar3.getId();
                                                                }
                                                                TiebaStatic.log("c10088");
                                                                pg2 = this.eqa.pg(id2);
                                                                if (qVar2 != null) {
                                                                    dhVar11 = this.eqa.eov;
                                                                    if (dhVar11 != null) {
                                                                        dhVar12 = this.eqa.eov;
                                                                        if (dhVar12.getPbData() != null && pg2 != null) {
                                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.eqa.getPageContext().getPageActivity());
                                                                            SmallTailInfo aRG = qVar2.aRG();
                                                                            dhVar13 = this.eqa.eov;
                                                                            this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID2, id2, "pb", true, str9, true, str10, i4, aRG, dhVar13.getPbData().qq(), false, qVar2.getAuthor().getIconInfo()).addBigImageData(pg2.eqo, pg2.eqp, pg2.eqq, pg2.index)));
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.log("c10089");
                                                            pg = this.eqa.pg(id2);
                                                            if (qVar2 != null) {
                                                                dhVar8 = this.eqa.eov;
                                                                if (dhVar8 != null) {
                                                                    dhVar9 = this.eqa.eov;
                                                                    if (dhVar9.getPbData() != null && pg != null) {
                                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.eqa.getPageContext().getPageActivity());
                                                                        SmallTailInfo aRG2 = qVar2.aRG();
                                                                        dhVar10 = this.eqa.eov;
                                                                        this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id2, "pb", true, null, false, null, i4, aRG2, dhVar10.getPbData().qq(), false, qVar2.getAuthor().getIconInfo()).addBigImageData(pg.eqo, pg.eqp, pg.eqq, pg.index)));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        pg3 = this.eqa.pg(id2);
                                                        if (qVar2 != null) {
                                                            dhVar14 = this.eqa.eov;
                                                            if (dhVar14 != null) {
                                                                dhVar15 = this.eqa.eov;
                                                                if (dhVar15.getPbData() != null && pg3 != null) {
                                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.eqa.getPageContext().getPageActivity());
                                                                    SmallTailInfo aRG3 = qVar2.aRG();
                                                                    dhVar16 = this.eqa.eov;
                                                                    this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id2, "pb", true, null, true, null, i4, aRG3, dhVar16.getPbData().qq(), false, qVar2.getAuthor().getIconInfo()).addBigImageData(pg3.eqo, pg3.eqp, pg3.eqq, pg3.index)));
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
                                                return;
                                            } else {
                                                com.baidu.tbadk.core.util.ax s = new com.baidu.tbadk.core.util.ax("c10517").s("obj_locate", 3);
                                                dhVar18 = this.eqa.eov;
                                                TiebaStatic.log(s.ab("fid", dhVar18.getPbData().getForumId()));
                                                return;
                                            }
                                        } else if (!this.eqa.checkUpIsLogin()) {
                                            com.baidu.tbadk.core.util.ax s2 = new com.baidu.tbadk.core.util.ax("c10517").s("obj_locate", 2);
                                            dhVar79 = this.eqa.eov;
                                            TiebaStatic.log(s2.ab("fid", dhVar79.getPbData().getForumId()));
                                            return;
                                        } else {
                                            this.eqa.aNh();
                                            return;
                                        }
                                    } else if (this.eqa.checkUpIsLogin()) {
                                        exVar74 = this.eqa.epe;
                                        exVar74.aBc();
                                        this.eqa.abb();
                                        this.eqa.on(2);
                                        dhVar97 = this.eqa.eov;
                                        if (dhVar97 != null) {
                                            dhVar98 = this.eqa.eov;
                                            if (dhVar98.getPbData() != null) {
                                                dhVar99 = this.eqa.eov;
                                                if (dhVar99.getPbData().aMG() != null) {
                                                    dhVar100 = this.eqa.eov;
                                                    if (!StringUtils.isNull(dhVar100.getPbData().aMG().pO(), true)) {
                                                        com.baidu.tbadk.core.util.ax axVar9 = new com.baidu.tbadk.core.util.ax("c11678");
                                                        dhVar101 = this.eqa.eov;
                                                        TiebaStatic.log(axVar9.ab("fid", dhVar101.getPbData().getForumId()));
                                                    }
                                                }
                                            }
                                        }
                                        this.eqa.agp();
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.i.gm()) {
                                    exVar22 = this.eqa.epe;
                                    exVar22.aPG();
                                    z = this.eqa.mIsLoading;
                                    if (!z) {
                                        this.eqa.mIsLoading = true;
                                        exVar23 = this.eqa.epe;
                                        exVar23.eug.exj.setEnabled(false);
                                        exVar24 = this.eqa.epe;
                                        exVar24.auC();
                                        this.eqa.abb();
                                        exVar25 = this.eqa.epe;
                                        exVar25.aPY();
                                        dhVar4 = this.eqa.eov;
                                        aND = this.eqa.aND();
                                        dhVar4.pj(aND);
                                        TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        exVar26 = this.eqa.epe;
                                        exVar26.aQx();
                                        exVar27 = this.eqa.epe;
                                        exVar27.aOq();
                                        this.eqa.on(2);
                                        return;
                                    }
                                    return;
                                } else {
                                    this.eqa.showToast(r.j.network_not_available);
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            dhVar113 = this.eqa.eov;
                            if (dhVar113.getErrorNo() == 4) {
                                dhVar116 = this.eqa.eov;
                                if (StringUtils.isNull(dhVar116.aOv())) {
                                    dhVar117 = this.eqa.eov;
                                    if (dhVar117.getAppealInfo() != null) {
                                        dhVar118 = this.eqa.eov;
                                        name = dhVar118.getAppealInfo().forumName;
                                    }
                                }
                                this.eqa.finish();
                                return;
                            }
                            dhVar114 = this.eqa.eov;
                            name = dhVar114.getPbData().aMr().getName();
                            if (!StringUtils.isNull(name)) {
                                dhVar115 = this.eqa.eov;
                                String aOv = dhVar115.aOv();
                                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.eqa.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (StringUtils.isNull(aOv)) {
                                    this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                } else if (aOv.equals(name)) {
                                    this.eqa.finish();
                                    return;
                                } else {
                                    this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                }
                            }
                            this.eqa.finish();
                            return;
                        }
                    }
                }
            }
        }
        exVar6 = this.eqa.epe;
        exVar6.aQr();
        dhVar = this.eqa.eov;
        if (dhVar.getPbData().aMz() == 1) {
            aVar = this.eqa.epd;
            if (!aVar.bkE()) {
                int i5 = 0;
                exVar7 = this.eqa.epe;
                if (view != exVar7.aQm()) {
                    exVar8 = this.eqa.epe;
                    if (view != exVar8.aQn()) {
                        exVar9 = this.eqa.epe;
                        if (view != exVar9.aQo()) {
                            exVar10 = this.eqa.epe;
                            if (view != exVar10.aQp()) {
                                exVar11 = this.eqa.epe;
                                if (view == exVar11.aPW()) {
                                    i5 = 2;
                                }
                            } else {
                                i5 = 5;
                            }
                        } else {
                            i5 = 4;
                        }
                    } else {
                        i5 = 3;
                    }
                } else {
                    i5 = 6;
                }
                dhVar2 = this.eqa.eov;
                ForumData aMr2 = dhVar2.getPbData().aMr();
                String name3 = aMr2.getName();
                String id3 = aMr2.getId();
                dhVar3 = this.eqa.eov;
                String id4 = dhVar3.getPbData().aMs().getId();
                if (!com.baidu.tieba.c.a.NO() || !com.baidu.tieba.c.a.f(this.eqa.getBaseContext(), id4, null)) {
                    exVar12 = this.eqa.epe;
                    exVar12.aPV();
                    aVar2 = this.eqa.epd;
                    exVar13 = this.eqa.epe;
                    aVar2.a(id3, name3, id4, i5, exVar13.aPX());
                }
            }
        }
    }
}
