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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v170, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x06c8, code lost:
        if (r21 == r1.erX.aQg().aOB()) goto L135;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:419:0x1316  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x13be  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x13d6  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x13e0  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x14d8  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x15be  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x15d5  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x15eb  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x15fd  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x160b  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x168e  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x16ee  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x17be  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x17d6  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x1809  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x180c  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x182d  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x1840  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x1853  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x1df9  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x1dfc  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x1dff  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x1e02  */
    /* JADX WARN: Removed duplicated region for block: B:600:0x1e05  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x1e08  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x1e0b  */
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
        String aMX;
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
        PbActivity.b oR;
        dh dhVar8;
        dh dhVar9;
        dh dhVar10;
        PbActivity.b oR2;
        dh dhVar11;
        dh dhVar12;
        dh dhVar13;
        PbActivity.b oR3;
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
        PbEcommRecommendMessage pbEcommRecommendMessage;
        int aML;
        int aML2;
        dh dhVar33;
        dh dhVar34;
        dh dhVar35;
        dh dhVar36;
        dh dhVar37;
        dh dhVar38;
        dh dhVar39;
        dh dhVar40;
        int aML3;
        int aML4;
        dh dhVar41;
        dh dhVar42;
        dh dhVar43;
        dh dhVar44;
        dh dhVar45;
        dh dhVar46;
        dh dhVar47;
        dh dhVar48;
        ex exVar43;
        dh dhVar49;
        dh dhVar50;
        dh dhVar51;
        ex exVar44;
        dh dhVar52;
        dh dhVar53;
        dh dhVar54;
        dh dhVar55;
        dh dhVar56;
        dh dhVar57;
        ex exVar45;
        ex exVar46;
        dh dhVar58;
        Cdo cdo7;
        Cdo cdo8;
        dh dhVar59;
        boolean z2;
        Cdo cdo9;
        Cdo cdo10;
        Cdo cdo11;
        Cdo cdo12;
        dh dhVar60;
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
        boolean hW;
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
        dh dhVar61;
        Cdo cdo42;
        Cdo cdo43;
        boolean z7;
        com.baidu.tbadk.core.data.bn bnVar;
        dh dhVar62;
        dh dhVar63;
        dh dhVar64;
        ex exVar47;
        ex exVar48;
        dh dhVar65;
        ex exVar49;
        dh dhVar66;
        dh dhVar67;
        dh dhVar68;
        dh dhVar69;
        ex exVar50;
        ex exVar51;
        Cdo cdo44;
        ex exVar52;
        ex exVar53;
        dh dhVar70;
        dh dhVar71;
        ex exVar54;
        dh dhVar72;
        Cdo cdo45;
        dh dhVar73;
        Cdo cdo46;
        ex exVar55;
        dh dhVar74;
        Cdo cdo47;
        dh dhVar75;
        ex exVar56;
        dh dhVar76;
        Cdo cdo48;
        Cdo cdo49;
        ex exVar57;
        String aMK;
        ex exVar58;
        ex exVar59;
        ex exVar60;
        ex exVar61;
        ex exVar62;
        dh dhVar77;
        dh dhVar78;
        ex exVar63;
        ex exVar64;
        dh dhVar79;
        dh dhVar80;
        dh dhVar81;
        ex exVar65;
        ex exVar66;
        dh dhVar82;
        dh dhVar83;
        dh dhVar84;
        ex exVar67;
        dh dhVar85;
        ex exVar68;
        ex exVar69;
        ex exVar70;
        dh dhVar86;
        ex exVar71;
        ex exVar72;
        dh dhVar87;
        ex exVar73;
        dh dhVar88;
        ex exVar74;
        ex exVar75;
        ex exVar76;
        ex exVar77;
        ex exVar78;
        ex exVar79;
        boolean oc;
        dh dhVar89;
        ex exVar80;
        dh dhVar90;
        dh dhVar91;
        dh dhVar92;
        dh dhVar93;
        dh dhVar94;
        dh dhVar95;
        dh dhVar96;
        dh dhVar97;
        dh dhVar98;
        dh dhVar99;
        ex exVar81;
        ex exVar82;
        dh dhVar100;
        dh dhVar101;
        String name;
        dh dhVar102;
        dh dhVar103;
        dh dhVar104;
        dh dhVar105;
        dh dhVar106;
        dh dhVar107;
        ex exVar83;
        dh dhVar108;
        ex exVar84;
        ex exVar85;
        ex exVar86;
        dh dhVar109;
        ex exVar87;
        dh dhVar110;
        dh dhVar111;
        dh dhVar112;
        ex exVar88;
        exVar = this.eob.enh;
        if (view == exVar.getNextView()) {
            dhVar112 = this.eob.emx;
            if (dhVar112.ic(true)) {
                exVar88 = this.eob.enh;
                exVar88.aPq();
                return;
            }
            return;
        }
        exVar2 = this.eob.enh;
        if (view == exVar2.aPl()) {
            exVar87 = this.eob.enh;
            exVar87.aPf();
            if (UtilHelper.isFloatWindowOpAllowed(this.eob.getPageContext().getPageActivity())) {
                this.eob.enn = true;
                PbActivity pbActivity = this.eob;
                dhVar110 = this.eob.emx;
                pbActivity.a(dhVar110.getPbData(), 0, 1, true, true);
                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10830");
                dhVar111 = this.eob.emx;
                TiebaStatic.log(ayVar.ab("tid", dhVar111.getThreadID()));
                return;
            }
            this.eob.aMJ();
            return;
        }
        exVar3 = this.eob.enh;
        if (view == exVar3.aPM()) {
            exVar84 = this.eob.enh;
            exVar84.aAE();
            this.eob.aaO();
            exVar85 = this.eob.enh;
            exVar85.aPp();
            exVar86 = this.eob.enh;
            exVar86.ayk();
            dhVar109 = this.eob.emx;
            dhVar109.oi(1);
            return;
        }
        exVar4 = this.eob.enh;
        if (view == exVar4.erX.aEm) {
            exVar83 = this.eob.enh;
            dhVar108 = this.eob.emx;
            if (!exVar83.iy(dhVar108.aNR())) {
                this.eob.emQ = false;
                this.eob.finish();
                return;
            }
            this.eob.aaO();
            return;
        }
        exVar5 = this.eob.enh;
        if (view != exVar5.aPD()) {
            exVar14 = this.eob.enh;
            if (view != exVar14.aPE()) {
                exVar15 = this.eob.enh;
                if (view != exVar15.aPF()) {
                    exVar16 = this.eob.enh;
                    if (view != exVar16.aPG()) {
                        exVar17 = this.eob.enh;
                        if (view != exVar17.aPn()) {
                            exVar18 = this.eob.enh;
                            if (view == exVar18.aPJ()) {
                                dhVar106 = this.eob.emx;
                                if (dhVar106 != null) {
                                    dhVar107 = this.eob.emx;
                                    com.baidu.tbadk.browser.f.u(this.eob.getPageContext().getPageActivity(), dhVar107.getPbData().aLQ().rB().getLink());
                                    return;
                                }
                                return;
                            }
                            exVar19 = this.eob.enh;
                            if (view != exVar19.erX.evc) {
                                exVar20 = this.eob.enh;
                                if (view == exVar20.erX.eve) {
                                    dhVar96 = this.eob.emx;
                                    if (dhVar96 != null) {
                                        dhVar97 = this.eob.emx;
                                        if (dhVar97.getPbData() != null) {
                                            dhVar98 = this.eob.emx;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = dhVar98.getPbData().aLR();
                                            if (aLR == null || aLR.size() <= 0) {
                                                dhVar99 = this.eob.emx;
                                                if (dhVar99.aNO()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.eob.getPageContext().getPageActivity(), this.eob.getPageContext().getString(t.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            exVar81 = this.eob.enh;
                                            exVar81.aOX();
                                            exVar82 = this.eob.enh;
                                            exVar82.aPO();
                                            this.eob.aMM();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.eob.getPageContext().getPageActivity(), this.eob.getPageContext().getString(t.j.pb_no_data_tips));
                                    return;
                                }
                                exVar21 = this.eob.enh;
                                if (view != exVar21.erX.evd && view.getId() != t.g.pb_god_user_tip_content) {
                                    exVar28 = this.eob.enh;
                                    if (view == exVar28.erX.evf) {
                                        dhVar90 = this.eob.emx;
                                        AdditionData aMa = dhVar90.getPbData().aMa();
                                        if (!TextUtils.isEmpty(aMa.getWarnMsg())) {
                                            com.baidu.adp.lib.util.k.showToast(this.eob.getPageContext().getPageActivity(), aMa.getWarnMsg());
                                            return;
                                        } else if (aMa.getAlreadyCount() != aMa.getTotalCount()) {
                                            dhVar91 = this.eob.emx;
                                            ForumData aLP = dhVar91.getPbData().aLP();
                                            dhVar92 = this.eob.emx;
                                            com.baidu.tbadk.core.data.bg aLQ = dhVar92.getPbData().aLQ();
                                            dhVar93 = this.eob.emx;
                                            AntiData qf = dhVar93.getPbData().qf();
                                            if (aLQ.getId() != null) {
                                                if (qf != null && qf.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.k.showToast(this.eob.getPageContext().getPageActivity(), qf.getForbid_info());
                                                    return;
                                                }
                                                int i2 = 0;
                                                dhVar94 = this.eob.emx;
                                                if (dhVar94.getPbData().getUserData() != null) {
                                                    dhVar95 = this.eob.emx;
                                                    i2 = dhVar95.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.eob.getPageContext().getPageActivity(), 2, aLP.getId(), aLP.getName(), aLQ.getId(), aMa.getPostId(), 0, qf, 13008, false, false, null, false, false, null, aMa, null, i2)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.k.showToast(this.eob.getPageContext().getPageActivity(), String.format(this.eob.getPageContext().getString(t.j.write_addition_limit), Integer.valueOf(aMa.getTotalCount())));
                                            return;
                                        }
                                    }
                                    exVar29 = this.eob.enh;
                                    if (exVar29.erX.aQg() != null) {
                                        exVar78 = this.eob.enh;
                                        if (view == exVar78.erX.aQg().aOm()) {
                                            exVar79 = this.eob.enh;
                                            exVar79.aAE();
                                            oc = this.eob.oc(11009);
                                            if (oc) {
                                                dhVar89 = this.eob.emx;
                                                exVar80 = this.eob.enh;
                                                if (dhVar89.oo(exVar80.aPw()) == null) {
                                                    return;
                                                }
                                                this.eob.aMR();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    exVar30 = this.eob.enh;
                                    if (exVar30.erX.aQg() != null) {
                                        exVar75 = this.eob.enh;
                                        if (view != exVar75.erX.aQg().aOA()) {
                                            exVar77 = this.eob.enh;
                                        }
                                        exVar76 = this.eob.enh;
                                        exVar76.erX.oa();
                                        return;
                                    }
                                    exVar31 = this.eob.enh;
                                    if (view != exVar31.aPu()) {
                                        exVar32 = this.eob.enh;
                                        if (exVar32.erX.aQg() != null) {
                                            exVar71 = this.eob.enh;
                                            if (view == exVar71.erX.aQg().aOv()) {
                                                exVar72 = this.eob.enh;
                                                exVar72.aAE();
                                                dhVar87 = this.eob.emx;
                                                if (dhVar87.aoU() != null) {
                                                    exVar73 = this.eob.enh;
                                                    dhVar88 = this.eob.emx;
                                                    exVar73.a(dhVar88.aoU(), this.eob.dXo);
                                                }
                                                TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        exVar33 = this.eob.enh;
                                        if (exVar33.erX.aQg() != null) {
                                            exVar68 = this.eob.enh;
                                            if (view == exVar68.erX.aQg().aOw()) {
                                                exVar69 = this.eob.enh;
                                                exVar69.aAE();
                                                this.eob.od(2);
                                                this.eob.aaO();
                                                exVar70 = this.eob.enh;
                                                exVar70.aPp();
                                                dhVar86 = this.eob.emx;
                                                dhVar86.aNX();
                                                TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        exVar34 = this.eob.enh;
                                        if (exVar34.erX.aQg() != null) {
                                            exVar66 = this.eob.enh;
                                            if (view == exVar66.erX.aQg().aOx()) {
                                                dhVar82 = this.eob.emx;
                                                if (dhVar82 != null) {
                                                    dhVar83 = this.eob.emx;
                                                    if (dhVar83.getPbData() != null) {
                                                        dhVar84 = this.eob.emx;
                                                        if (dhVar84.getPbData().aLQ() != null) {
                                                            exVar67 = this.eob.enh;
                                                            exVar67.erX.oa();
                                                            PbActivity pbActivity2 = this.eob;
                                                            dhVar85 = this.eob.emx;
                                                            pbActivity2.oO(dhVar85.getPbData().aLQ().rQ());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        exVar35 = this.eob.enh;
                                        if (exVar35.erX.aQg() != null) {
                                            exVar64 = this.eob.enh;
                                            if (view == exVar64.erX.aQg().eqo) {
                                                dhVar79 = this.eob.emx;
                                                if (dhVar79 != null) {
                                                    dhVar80 = this.eob.emx;
                                                    if (dhVar80.getPbData() != null) {
                                                        dhVar81 = this.eob.emx;
                                                        if (dhVar81.getPbData().aLQ() != null) {
                                                            exVar65 = this.eob.enh;
                                                            exVar65.erX.oa();
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.eob.getPageContext().getPageActivity(), 0, TbConfig.ECOMM_FEED_BACK_ID, TbConfig.ECOMM_FEED_BACK_NAME, null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0)));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        exVar36 = this.eob.enh;
                                        if (exVar36.erX.aQg() != null) {
                                            exVar60 = this.eob.enh;
                                            if (view == exVar60.erX.aQg().aOy()) {
                                                TiebaStatic.log("c10414");
                                                exVar61 = this.eob.enh;
                                                exVar61.aAE();
                                                exVar62 = this.eob.enh;
                                                if (exVar62.rr() != ex.etO) {
                                                    dhVar77 = this.eob.emx;
                                                    if (dhVar77.aOl() != null) {
                                                        dhVar78 = this.eob.emx;
                                                        dhVar78.aOl().og(dh.eph);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                exVar63 = this.eob.enh;
                                                exVar63.aPS();
                                                return;
                                            }
                                        }
                                        exVar37 = this.eob.enh;
                                        if (exVar37.erX.aQg() != null) {
                                            exVar57 = this.eob.enh;
                                            if (view == exVar57.erX.aQg().aOz()) {
                                                aMK = this.eob.aMK();
                                                this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.eob.getPageContext().getPageActivity(), null, aMK, true)));
                                                exVar58 = this.eob.enh;
                                                exVar58.erX.oa();
                                                exVar59 = this.eob.enh;
                                                exVar59.erX.aQg().aOE();
                                                return;
                                            }
                                        }
                                        cdo = this.eob.enm;
                                        if (cdo != null) {
                                            cdo49 = this.eob.enm;
                                            if (view == cdo49.aOo()) {
                                                Object tag = view.getTag();
                                                if (!(tag instanceof String)) {
                                                    if (tag instanceof SparseArray) {
                                                        SparseArray<Object> sparseArray5 = (SparseArray) tag;
                                                        if ((sparseArray5.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(t.g.tag_user_mute_visible)).booleanValue()) {
                                                            sparseArray5.put(t.g.tag_from, 0);
                                                            sparseArray5.put(t.g.tag_check_mute_from, 2);
                                                            this.eob.d(sparseArray5);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.eob.oO((String) tag);
                                                return;
                                            }
                                        }
                                        cdo2 = this.eob.enm;
                                        if (cdo2 != null) {
                                            cdo48 = this.eob.enm;
                                            if (view == cdo48.aOm()) {
                                                if (!this.eob.checkUpIsLogin()) {
                                                    return;
                                                }
                                                this.eob.aW(view);
                                                return;
                                            }
                                        }
                                        cdo3 = this.eob.enm;
                                        if (cdo3 != null) {
                                            cdo47 = this.eob.enm;
                                            if (view == cdo47.aOs()) {
                                                if (view.getTag(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                    dhVar75 = this.eob.emx;
                                                    if (dhVar75 != null) {
                                                        exVar56 = this.eob.enh;
                                                        exVar56.aPf();
                                                        if (!UtilHelper.isFloatWindowOpAllowed(this.eob.getPageContext().getPageActivity())) {
                                                            this.eob.aMJ();
                                                            return;
                                                        }
                                                        int intValue = ((Integer) view.getTag(t.g.tag_pb_floor_postion)).intValue();
                                                        int intValue2 = ((Integer) view.getTag(t.g.tag_pb_floor_number)).intValue();
                                                        this.eob.enn = true;
                                                        PbActivity pbActivity3 = this.eob;
                                                        dhVar76 = this.eob.emx;
                                                        pbActivity3.a(dhVar76.getPbData(), intValue, intValue2, true, true);
                                                        TiebaStatic.log("c10834");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        cdo4 = this.eob.enm;
                                        if (cdo4 != null) {
                                            cdo46 = this.eob.enm;
                                            if (view == cdo46.aOp()) {
                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                if (sparseArray6 != null && (sparseArray6.get(t.g.tag_del_post_type) instanceof Integer) && (sparseArray6.get(t.g.tag_del_post_id) instanceof String) && (sparseArray6.get(t.g.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(t.g.tag_del_post_is_self) instanceof Boolean)) {
                                                    boolean booleanValue2 = ((Boolean) sparseArray6.get(t.g.tag_del_post_is_self)).booleanValue();
                                                    int intValue3 = ((Integer) sparseArray6.get(t.g.tag_manage_user_identity)).intValue();
                                                    if (!booleanValue2 && intValue3 != 0 && com.baidu.tieba.c.a.Nn()) {
                                                        Context baseContext = this.eob.getBaseContext();
                                                        dhVar74 = this.eob.emx;
                                                        if (com.baidu.tieba.c.a.f(baseContext, dhVar74.getThreadID(), (String) sparseArray6.get(t.g.tag_del_post_id))) {
                                                            return;
                                                        }
                                                    }
                                                    exVar55 = this.eob.enh;
                                                    exVar55.a(((Integer) sparseArray6.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray6.get(t.g.tag_del_post_id), intValue3, booleanValue2);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        cdo5 = this.eob.enm;
                                        if (cdo5 != null) {
                                            cdo45 = this.eob.enm;
                                            if (view == cdo45.aOq()) {
                                                long j = -1;
                                                String str2 = "";
                                                int i3 = 0;
                                                if (view.getTag(t.g.tag_chudian_template_id) instanceof Long) {
                                                    j = ((Long) view.getTag(t.g.tag_chudian_template_id)).longValue();
                                                }
                                                if (view.getTag(t.g.tag_chudian_monitor_id) instanceof String) {
                                                    str2 = (String) view.getTag(t.g.tag_chudian_monitor_id);
                                                }
                                                if (view.getTag(t.g.tag_chudian_hide_day) instanceof Integer) {
                                                    i3 = ((Integer) view.getTag(t.g.tag_chudian_hide_day)).intValue();
                                                }
                                                dhVar73 = this.eob.emx;
                                                com.baidu.tieba.pb.data.h pbData = dhVar73.getPbData();
                                                String str3 = null;
                                                String str4 = null;
                                                String str5 = null;
                                                if (pbData != null && pbData.aLP() != null) {
                                                    str3 = pbData.aLP().getId();
                                                    str4 = pbData.aLP().getName();
                                                    str5 = pbData.getThreadId();
                                                }
                                                com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                                this.eob.a(j, str2, str3, str4, str5, i3);
                                                return;
                                            }
                                        }
                                        exVar38 = this.eob.enh;
                                        if (exVar38.aPT() == view) {
                                            exVar54 = this.eob.enh;
                                            if (exVar54.aPT().getIndicateStatus()) {
                                                dhVar72 = this.eob.emx;
                                                com.baidu.tieba.pb.data.h pbData2 = dhVar72.getPbData();
                                                if (pbData2 != null && pbData2.aLQ() != null && pbData2.aLQ().rl() != null) {
                                                    String ps = pbData2.aLQ().rl().ps();
                                                    if (StringUtils.isNull(ps)) {
                                                        ps = pbData2.aLQ().rl().getTaskId();
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11107").ab("obj_id", ps));
                                                }
                                            } else {
                                                com.baidu.tieba.tbadkCore.d.a.bR("c10725", null);
                                            }
                                            this.eob.aNe();
                                            return;
                                        }
                                        exVar39 = this.eob.enh;
                                        if (exVar39.aPi() != view) {
                                            cdo6 = this.eob.enm;
                                            if (cdo6 != null) {
                                                cdo44 = this.eob.enm;
                                                if (view == cdo44.aOn()) {
                                                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                                                    if (sparseArray7 != null) {
                                                        if (com.baidu.tieba.c.a.Nn() && sparseArray7.get(t.g.tag_del_post_id) != null) {
                                                            Context baseContext2 = this.eob.getBaseContext();
                                                            dhVar70 = this.eob.emx;
                                                            if (com.baidu.tieba.c.a.f(baseContext2, dhVar70.getThreadID(), (String) sparseArray7.get(t.g.tag_del_post_id))) {
                                                                return;
                                                            }
                                                        }
                                                        boolean booleanValue3 = ((Boolean) sparseArray7.get(t.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue4 = ((Boolean) sparseArray7.get(t.g.tag_should_delete_visible)).booleanValue();
                                                        boolean booleanValue5 = ((Boolean) sparseArray7.get(t.g.tag_user_mute_visible)).booleanValue();
                                                        if (booleanValue3) {
                                                            if (booleanValue5) {
                                                                sparseArray7.put(t.g.tag_from, 1);
                                                                sparseArray7.put(t.g.tag_check_mute_from, 2);
                                                                this.eob.d(sparseArray7);
                                                                return;
                                                            }
                                                            sparseArray7.put(t.g.tag_check_mute_from, 2);
                                                            exVar53 = this.eob.enh;
                                                            exVar53.aZ(view);
                                                            return;
                                                        } else if (booleanValue4) {
                                                            exVar52 = this.eob.enh;
                                                            exVar52.a(((Integer) sparseArray7.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(t.g.tag_del_post_id), ((Integer) sparseArray7.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(t.g.tag_del_post_is_self)).booleanValue());
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                            }
                                            exVar40 = this.eob.enh;
                                            if (view == exVar40.aNJ()) {
                                                if (this.eob.checkUpIsLogin()) {
                                                    exVar49 = this.eob.enh;
                                                    if (!exVar49.aNG()) {
                                                        dhVar66 = this.eob.emx;
                                                        if (dhVar66 != null) {
                                                            dhVar67 = this.eob.emx;
                                                            if (dhVar67.aOj() != null) {
                                                                dhVar68 = this.eob.emx;
                                                                if (dhVar68.aOj().aNA() != null) {
                                                                    dhVar69 = this.eob.emx;
                                                                    if (com.baidu.tbadk.core.util.y.s(dhVar69.aOj().aNA().getItems()) != 0) {
                                                                        exVar50 = this.eob.enh;
                                                                        exVar50.aNH();
                                                                        return;
                                                                    }
                                                                    this.eob.showToast(t.j.graffiti_quick_vote_empty);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    exVar51 = this.eob.enh;
                                                    exVar51.aNI();
                                                    return;
                                                }
                                                return;
                                            } else if (view.getId() == t.g.pb_head_function_manage_delormanage) {
                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                if (!((Boolean) sparseArray8.get(t.g.tag_should_manage_visible)).booleanValue()) {
                                                    exVar47 = this.eob.enh;
                                                    exVar47.a(((Integer) sparseArray8.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(t.g.tag_del_post_id), ((Integer) sparseArray8.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(t.g.tag_del_post_is_self)).booleanValue());
                                                    return;
                                                }
                                                if (com.baidu.tieba.c.a.Nn()) {
                                                    Context baseContext3 = this.eob.getBaseContext();
                                                    dhVar65 = this.eob.emx;
                                                    if (com.baidu.tieba.c.a.f(baseContext3, dhVar65.getThreadID(), null)) {
                                                        return;
                                                    }
                                                }
                                                exVar48 = this.eob.enh;
                                                exVar48.aZ(view);
                                                return;
                                            } else if (view.getId() != t.g.replybtn && view.getId() != t.g.sub_pb_more && view.getId() != t.g.sub_pb_item) {
                                                exVar42 = this.eob.enh;
                                                if (view == exVar42.aMA()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                        dhVar62 = this.eob.emx;
                                                        long c2 = com.baidu.adp.lib.h.b.c(dhVar62.getPbData().getForumId(), 0L);
                                                        dhVar63 = this.eob.emx;
                                                        long c3 = com.baidu.adp.lib.h.b.c(dhVar63.getThreadID(), 0L);
                                                        dhVar64 = this.eob.emx;
                                                        this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.eob.getPageContext().getPageActivity(), 24008, c2, c3, c, dhVar64.getPbData().aLQ().rT())));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                int id = view.getId();
                                                if (id == t.g.pb_u9_text_view) {
                                                    if (this.eob.checkUpIsLogin() && (bnVar = (com.baidu.tbadk.core.data.bn) view.getTag()) != null && !StringUtils.isNull(bnVar.sM())) {
                                                        TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                        com.baidu.tbadk.core.util.bi.vx().c(this.eob.getPageContext(), new String[]{bnVar.sM()});
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == t.g.reply) {
                                                    cdo7 = this.eob.enm;
                                                    if (cdo7 == null) {
                                                        this.eob.enm = new Cdo(this.eob.getPageContext(), this.eob.bRE);
                                                        cdo43 = this.eob.enm;
                                                        z7 = this.eob.mIsLogin;
                                                        cdo43.ig(z7);
                                                    }
                                                    cdo8 = this.eob.enm;
                                                    cdo8.GN();
                                                    com.baidu.tieba.tbadkCore.data.q qVar = null;
                                                    if (view != null && view.getTag() != null) {
                                                        qVar = (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(t.g.tag_load_sub_data);
                                                        if (!this.eob.aMY()) {
                                                            dhVar61 = this.eob.emx;
                                                            if (dhVar61.aNY() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                                                                cdo42 = this.eob.enm;
                                                                cdo42.aOu();
                                                                sparseArray = (SparseArray) view.getTag();
                                                                if (sparseArray.get(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                                    int intValue4 = ((Integer) sparseArray.get(t.g.tag_pb_floor_postion)).intValue();
                                                                    int intValue5 = ((Integer) sparseArray.get(t.g.tag_pb_floor_number)).intValue();
                                                                    cdo40 = this.eob.enm;
                                                                    cdo40.aOs().setTag(t.g.tag_pb_floor_postion, Integer.valueOf(intValue4));
                                                                    cdo41 = this.eob.enm;
                                                                    cdo41.aOs().setTag(t.g.tag_pb_floor_number, Integer.valueOf(intValue5));
                                                                }
                                                                SparseArray sparseArray9 = new SparseArray();
                                                                sparseArray9.put(t.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(t.g.tag_clip_board));
                                                                sparseArray9.put(t.g.tag_is_subpb, false);
                                                                cdo14 = this.eob.enm;
                                                                cdo14.aOm().setTag(sparseArray9);
                                                                sparseArray2 = (SparseArray) view.getTag();
                                                                booleanValue = ((Boolean) sparseArray2.get(t.g.tag_should_manage_visible)).booleanValue();
                                                                boolean booleanValue6 = ((Boolean) sparseArray2.get(t.g.tag_user_mute_visible)).booleanValue();
                                                                boolean booleanValue7 = ((Boolean) sparseArray2.get(t.g.tag_should_delete_visible)).booleanValue();
                                                                if (sparseArray2.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                                    z3 = false;
                                                                } else {
                                                                    z3 = ((Boolean) sparseArray2.get(t.g.tag_del_post_is_self)).booleanValue();
                                                                }
                                                                String str6 = null;
                                                                if (sparseArray2.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                                    str6 = (String) sparseArray2.get(t.g.tag_forbid_user_post_id);
                                                                }
                                                                if (!booleanValue) {
                                                                    SparseArray sparseArray10 = new SparseArray();
                                                                    sparseArray10.put(t.g.tag_should_manage_visible, true);
                                                                    sparseArray10.put(t.g.tag_manage_user_identity, sparseArray2.get(t.g.tag_manage_user_identity));
                                                                    sparseArray10.put(t.g.tag_forbid_user_name, sparseArray2.get(t.g.tag_forbid_user_name));
                                                                    sparseArray10.put(t.g.tag_forbid_user_post_id, str6);
                                                                    if (booleanValue6) {
                                                                        sparseArray10.put(t.g.tag_user_mute_visible, true);
                                                                        sparseArray10.put(t.g.tag_is_mem, sparseArray2.get(t.g.tag_is_mem));
                                                                        sparseArray10.put(t.g.tag_user_mute_mute_userid, sparseArray2.get(t.g.tag_user_mute_mute_userid));
                                                                        sparseArray10.put(t.g.tag_user_mute_mute_username, sparseArray2.get(t.g.tag_user_mute_mute_username));
                                                                        sparseArray10.put(t.g.tag_user_mute_post_id, sparseArray2.get(t.g.tag_user_mute_post_id));
                                                                        sparseArray10.put(t.g.tag_user_mute_thread_id, sparseArray2.get(t.g.tag_user_mute_thread_id));
                                                                    } else {
                                                                        sparseArray10.put(t.g.tag_user_mute_visible, false);
                                                                    }
                                                                    if (booleanValue7) {
                                                                        sparseArray10.put(t.g.tag_should_delete_visible, true);
                                                                        sparseArray10.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                        sparseArray10.put(t.g.tag_del_post_id, sparseArray2.get(t.g.tag_del_post_id));
                                                                        sparseArray10.put(t.g.tag_del_post_type, sparseArray2.get(t.g.tag_del_post_type));
                                                                        cdo39 = this.eob.enm;
                                                                        cdo39.aOp().setVisibility(0);
                                                                    } else {
                                                                        sparseArray10.put(t.g.tag_should_delete_visible, false);
                                                                        cdo34 = this.eob.enm;
                                                                        cdo34.aOp().setVisibility(8);
                                                                    }
                                                                    cdo35 = this.eob.enm;
                                                                    cdo35.aOn().setTag(sparseArray10);
                                                                    cdo36 = this.eob.enm;
                                                                    cdo36.aOp().setTag(sparseArray10);
                                                                    cdo37 = this.eob.enm;
                                                                    cdo37.aOn().setText(t.j.bar_manager);
                                                                    cdo38 = this.eob.enm;
                                                                    cdo38.aOn().setVisibility(0);
                                                                } else if (!booleanValue7) {
                                                                    cdo15 = this.eob.enm;
                                                                    cdo15.aOn().setVisibility(8);
                                                                    cdo16 = this.eob.enm;
                                                                    cdo16.aOp().setVisibility(8);
                                                                } else {
                                                                    SparseArray sparseArray11 = new SparseArray();
                                                                    sparseArray11.put(t.g.tag_should_manage_visible, false);
                                                                    sparseArray11.put(t.g.tag_user_mute_visible, false);
                                                                    sparseArray11.put(t.g.tag_should_delete_visible, true);
                                                                    sparseArray11.put(t.g.tag_manage_user_identity, sparseArray2.get(t.g.tag_manage_user_identity));
                                                                    sparseArray11.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                    sparseArray11.put(t.g.tag_del_post_id, sparseArray2.get(t.g.tag_del_post_id));
                                                                    sparseArray11.put(t.g.tag_del_post_type, sparseArray2.get(t.g.tag_del_post_type));
                                                                    cdo17 = this.eob.enm;
                                                                    cdo17.aOn().setTag(sparseArray11);
                                                                    cdo18 = this.eob.enm;
                                                                    cdo18.aOp().setTag(sparseArray11);
                                                                    cdo19 = this.eob.enm;
                                                                    cdo19.aOn().setText(t.j.delete);
                                                                    cdo20 = this.eob.enm;
                                                                    cdo20.aOp().setVisibility(0);
                                                                    cdo21 = this.eob.enm;
                                                                    cdo21.aOn().setVisibility(8);
                                                                }
                                                                sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3.get(t.g.tag_user_mute_visible) instanceof Boolean) {
                                                                    z4 = false;
                                                                } else {
                                                                    z4 = ((Boolean) sparseArray3.get(t.g.tag_user_mute_visible)).booleanValue();
                                                                }
                                                                if (((Boolean) sparseArray3.get(t.g.tag_should_manage_visible)).booleanValue() && z4) {
                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                    sparseArray12.put(t.g.tag_user_mute_visible, true);
                                                                    sparseArray12.put(t.g.tag_is_mem, sparseArray3.get(t.g.tag_is_mem));
                                                                    sparseArray12.put(t.g.tag_user_mute_mute_userid, sparseArray3.get(t.g.tag_user_mute_mute_userid));
                                                                    sparseArray12.put(t.g.tag_user_mute_mute_username, sparseArray3.get(t.g.tag_user_mute_mute_username));
                                                                    sparseArray12.put(t.g.tag_user_mute_post_id, sparseArray3.get(t.g.tag_user_mute_post_id));
                                                                    sparseArray12.put(t.g.tag_user_mute_thread_id, sparseArray3.get(t.g.tag_user_mute_thread_id));
                                                                    sparseArray12.put(t.g.tag_del_post_is_self, sparseArray3.get(t.g.tag_del_post_is_self));
                                                                    sparseArray12.put(t.g.tag_del_post_type, sparseArray3.get(t.g.tag_del_post_type));
                                                                    sparseArray12.put(t.g.tag_del_post_id, sparseArray3.get(t.g.tag_del_post_id));
                                                                    sparseArray12.put(t.g.tag_manage_user_identity, sparseArray3.get(t.g.tag_manage_user_identity));
                                                                    cdo30 = this.eob.enm;
                                                                    cdo30.aOo().setTag(sparseArray12);
                                                                    cdo31 = this.eob.enm;
                                                                    cdo31.aOo().setVisibility(0);
                                                                    cdo32 = this.eob.enm;
                                                                    cdo32.aOn().setVisibility(8);
                                                                    cdo33 = this.eob.enm;
                                                                    cdo33.aOo().setText(t.j.mute_option);
                                                                } else {
                                                                    if (sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                                        z5 = false;
                                                                    } else {
                                                                        z5 = ((Boolean) sparseArray3.get(t.g.tag_del_post_is_self)).booleanValue();
                                                                    }
                                                                    String str7 = null;
                                                                    if (sparseArray3.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                                        str7 = (String) sparseArray3.get(t.g.tag_forbid_user_post_id);
                                                                    }
                                                                    hW = this.eob.hW(z5);
                                                                    isLogin = hW & this.eob.isLogin();
                                                                    this.eob.enS = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(t.g.tag_clip_board);
                                                                    if (!(!ew.g(this.eob.enS) ? false : isLogin)) {
                                                                        cdo23 = this.eob.enm;
                                                                        cdo23.aOo().setVisibility(0);
                                                                        cdo24 = this.eob.enm;
                                                                        cdo24.aOo().setTag(str7);
                                                                    } else {
                                                                        cdo22 = this.eob.enm;
                                                                        cdo22.aOo().setVisibility(8);
                                                                    }
                                                                }
                                                                sparseArray4 = (SparseArray) view.getTag();
                                                                long j2 = 0;
                                                                if (sparseArray4.get(t.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = ((Boolean) sparseArray4.get(t.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                }
                                                                if (sparseArray4.get(t.g.tag_chudian_template_id) instanceof Long) {
                                                                    j2 = ((Long) sparseArray4.get(t.g.tag_chudian_template_id)).longValue();
                                                                }
                                                                if (sparseArray4.get(t.g.tag_chudian_monitor_id) instanceof String) {
                                                                    str = "";
                                                                } else {
                                                                    str = (String) sparseArray4.get(t.g.tag_chudian_monitor_id);
                                                                }
                                                                if (sparseArray4.get(t.g.tag_chudian_hide_day) instanceof Integer) {
                                                                    i = 0;
                                                                } else {
                                                                    i = ((Integer) sparseArray4.get(t.g.tag_chudian_hide_day)).intValue();
                                                                }
                                                                if (!z6) {
                                                                    cdo26 = this.eob.enm;
                                                                    cdo26.aOq().setVisibility(0);
                                                                    cdo27 = this.eob.enm;
                                                                    cdo27.aOq().setTag(t.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                    cdo28 = this.eob.enm;
                                                                    cdo28.aOq().setTag(t.g.tag_chudian_monitor_id, str);
                                                                    cdo29 = this.eob.enm;
                                                                    cdo29.aOq().setTag(t.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                } else {
                                                                    cdo25 = this.eob.enm;
                                                                    cdo25.aOq().setVisibility(8);
                                                                }
                                                            }
                                                        }
                                                        cdo13 = this.eob.enm;
                                                        cdo13.aOt();
                                                        sparseArray = (SparseArray) view.getTag();
                                                        if (sparseArray.get(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                        }
                                                        SparseArray sparseArray92 = new SparseArray();
                                                        sparseArray92.put(t.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(t.g.tag_clip_board));
                                                        sparseArray92.put(t.g.tag_is_subpb, false);
                                                        cdo14 = this.eob.enm;
                                                        cdo14.aOm().setTag(sparseArray92);
                                                        sparseArray2 = (SparseArray) view.getTag();
                                                        booleanValue = ((Boolean) sparseArray2.get(t.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue62 = ((Boolean) sparseArray2.get(t.g.tag_user_mute_visible)).booleanValue();
                                                        boolean booleanValue72 = ((Boolean) sparseArray2.get(t.g.tag_should_delete_visible)).booleanValue();
                                                        if (sparseArray2.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str62 = null;
                                                        if (sparseArray2.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        if (!booleanValue) {
                                                        }
                                                        sparseArray3 = (SparseArray) view.getTag();
                                                        if (sparseArray3.get(t.g.tag_user_mute_visible) instanceof Boolean) {
                                                        }
                                                        if (((Boolean) sparseArray3.get(t.g.tag_should_manage_visible)).booleanValue()) {
                                                        }
                                                        if (sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str72 = null;
                                                        if (sparseArray3.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        hW = this.eob.hW(z5);
                                                        isLogin = hW & this.eob.isLogin();
                                                        this.eob.enS = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(t.g.tag_clip_board);
                                                        if (!(!ew.g(this.eob.enS) ? false : isLogin)) {
                                                        }
                                                        sparseArray4 = (SparseArray) view.getTag();
                                                        long j22 = 0;
                                                        if (sparseArray4.get(t.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                        }
                                                        if (sparseArray4.get(t.g.tag_chudian_template_id) instanceof Long) {
                                                        }
                                                        if (sparseArray4.get(t.g.tag_chudian_monitor_id) instanceof String) {
                                                        }
                                                        if (sparseArray4.get(t.g.tag_chudian_hide_day) instanceof Integer) {
                                                        }
                                                        if (!z6) {
                                                        }
                                                    }
                                                    dhVar59 = this.eob.emx;
                                                    if (dhVar59.getPbData().nv()) {
                                                        dhVar60 = this.eob.emx;
                                                        String nu = dhVar60.getPbData().nu();
                                                        if (qVar != null && !com.baidu.adp.lib.util.j.isEmpty(nu) && nu.equals(qVar.getId())) {
                                                            z2 = true;
                                                            if (!z2) {
                                                                cdo12 = this.eob.enm;
                                                                cdo12.aOm().setText(t.j.remove_mark);
                                                            } else {
                                                                cdo9 = this.eob.enm;
                                                                cdo9.aOm().setText(t.j.mark);
                                                            }
                                                            cdo10 = this.eob.enm;
                                                            cdo10.ih(true);
                                                            cdo11 = this.eob.enm;
                                                            cdo11.vR();
                                                            return;
                                                        }
                                                    }
                                                    z2 = false;
                                                    if (!z2) {
                                                    }
                                                    cdo10 = this.eob.enm;
                                                    cdo10.ih(true);
                                                    cdo11 = this.eob.enm;
                                                    cdo11.vR();
                                                    return;
                                                } else if (id != t.g.pb_head_reverse_hint) {
                                                    if (id == t.g.pb_act_btn) {
                                                        dhVar52 = this.eob.emx;
                                                        if (dhVar52.getPbData() != null) {
                                                            dhVar53 = this.eob.emx;
                                                            if (dhVar53.getPbData().aLQ() != null) {
                                                                dhVar54 = this.eob.emx;
                                                                if (dhVar54.getPbData().aLQ().sg() != null) {
                                                                    Activity activity = this.eob.getActivity();
                                                                    dhVar55 = this.eob.emx;
                                                                    com.baidu.tbadk.browser.f.u(activity, dhVar55.getPbData().aLQ().sg());
                                                                    dhVar56 = this.eob.emx;
                                                                    if (dhVar56.getPbData().aLQ().se() != 1) {
                                                                        dhVar57 = this.eob.emx;
                                                                        if (dhVar57.getPbData().aLQ().se() == 2) {
                                                                            TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == t.g.lottery_tail) {
                                                        if (view.getTag(t.g.tag_pb_lottery_tail_link) instanceof String) {
                                                            String str8 = (String) view.getTag(t.g.tag_pb_lottery_tail_link);
                                                            com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c10912");
                                                            dhVar49 = this.eob.emx;
                                                            com.baidu.tbadk.core.util.ay ab = ayVar2.ab("fid", dhVar49.getPbData().getForumId());
                                                            dhVar50 = this.eob.emx;
                                                            TiebaStatic.log(ab.ab("tid", dhVar50.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                            dhVar51 = this.eob.emx;
                                                            if (dhVar51.getPbData().getThreadId().equals(str8)) {
                                                                exVar44 = this.eob.enh;
                                                                exVar44.setSelection(0);
                                                                return;
                                                            }
                                                            this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.eob.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == t.g.pb_item_tail_content) {
                                                        if (com.baidu.tbadk.core.util.bn.al(this.eob.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.m9getInst().getString(t.j.tail_web_view_title);
                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.tS().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                            }
                                                            exVar43 = this.eob.enh;
                                                            exVar43.aOX();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == t.g.join_vote_tv) {
                                                        if (view != null) {
                                                            com.baidu.tbadk.browser.f.u(this.eob.getActivity(), (String) view.getTag());
                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                            aML3 = this.eob.aML();
                                                            if (aML3 == 1) {
                                                                dhVar45 = this.eob.emx;
                                                                if (dhVar45 != null) {
                                                                    dhVar46 = this.eob.emx;
                                                                    if (dhVar46.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c10397");
                                                                        dhVar47 = this.eob.emx;
                                                                        com.baidu.tbadk.core.util.ay ab2 = ayVar3.ab("fid", dhVar47.getPbData().getForumId());
                                                                        dhVar48 = this.eob.emx;
                                                                        TiebaStatic.log(ab2.ab("tid", dhVar48.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aML4 = this.eob.aML();
                                                            if (aML4 == 2) {
                                                                dhVar41 = this.eob.emx;
                                                                if (dhVar41 != null) {
                                                                    dhVar42 = this.eob.emx;
                                                                    if (dhVar42.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar4 = new com.baidu.tbadk.core.util.ay("c10401");
                                                                        dhVar43 = this.eob.emx;
                                                                        com.baidu.tbadk.core.util.ay ab3 = ayVar4.ab("fid", dhVar43.getPbData().getForumId());
                                                                        dhVar44 = this.eob.emx;
                                                                        TiebaStatic.log(ab3.ab("tid", dhVar44.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == t.g.look_all_tv) {
                                                        if (view != null) {
                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                            com.baidu.tbadk.browser.f.u(this.eob.getActivity(), (String) view.getTag());
                                                            aML = this.eob.aML();
                                                            if (aML == 1) {
                                                                dhVar37 = this.eob.emx;
                                                                if (dhVar37 != null) {
                                                                    dhVar38 = this.eob.emx;
                                                                    if (dhVar38.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar5 = new com.baidu.tbadk.core.util.ay("c10507");
                                                                        dhVar39 = this.eob.emx;
                                                                        com.baidu.tbadk.core.util.ay ab4 = ayVar5.ab("fid", dhVar39.getPbData().getForumId());
                                                                        dhVar40 = this.eob.emx;
                                                                        TiebaStatic.log(ab4.ab("tid", dhVar40.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aML2 = this.eob.aML();
                                                            if (aML2 == 2) {
                                                                dhVar33 = this.eob.emx;
                                                                if (dhVar33 != null) {
                                                                    dhVar34 = this.eob.emx;
                                                                    if (dhVar34.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar6 = new com.baidu.tbadk.core.util.ay("c10508");
                                                                        dhVar35 = this.eob.emx;
                                                                        com.baidu.tbadk.core.util.ay ab5 = ayVar6.ab("fid", dhVar35.getPbData().getForumId());
                                                                        dhVar36 = this.eob.emx;
                                                                        TiebaStatic.log(ab5.ab("tid", dhVar36.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id != t.g.manga_prev_btn) {
                                                        if (id != t.g.manga_next_btn) {
                                                            if (id == t.g.pb_ecomm_like_button) {
                                                                dhVar27 = this.eob.emx;
                                                                if (dhVar27 != null) {
                                                                    dhVar29 = this.eob.emx;
                                                                    if (dhVar29.getPbData() != null) {
                                                                        dhVar30 = this.eob.emx;
                                                                        if (dhVar30.getPbData().aLQ() != null) {
                                                                            dhVar31 = this.eob.emx;
                                                                            if (dhVar31.getPbData().aLQ().Uw != null) {
                                                                                if (com.baidu.tbadk.core.util.bn.al(this.eob.getPageContext().getPageActivity())) {
                                                                                    dhVar32 = this.eob.emx;
                                                                                    DealInfoData dealInfoData = dhVar32.getPbData().aLQ().Uw;
                                                                                    long j3 = dealInfoData.productId;
                                                                                    if (dealInfoData.hasRecommend) {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, false);
                                                                                    } else {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, true);
                                                                                    }
                                                                                    this.eob.sendMessage(pbEcommRecommendMessage);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ay ayVar7 = new com.baidu.tbadk.core.util.ay("c11428");
                                                                ayVar7.s("obj_param1", 1);
                                                                dhVar28 = this.eob.emx;
                                                                ayVar7.ab("obj_id", new StringBuilder(String.valueOf(dhVar28.getPbData().aLQ().Uw.productId)).toString());
                                                                ayVar7.s("obj_locate", 3);
                                                                if (ayVar7 != null) {
                                                                    TiebaStatic.log(ayVar7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id == t.g.pb_editor_tool_comment_ecomm_buy_layout) {
                                                                dhVar19 = this.eob.emx;
                                                                if (dhVar19 != null) {
                                                                    dhVar21 = this.eob.emx;
                                                                    if (dhVar21.getPbData() != null) {
                                                                        dhVar22 = this.eob.emx;
                                                                        if (dhVar22.getPbData().aLQ() != null) {
                                                                            dhVar23 = this.eob.emx;
                                                                            if (dhVar23.getPbData().aLQ().Uw != null) {
                                                                                if (com.baidu.tbadk.core.util.bn.al(this.eob.getPageContext().getPageActivity())) {
                                                                                    dhVar24 = this.eob.emx;
                                                                                    long j4 = dhVar24.getPbData().aLQ().Uw.productId;
                                                                                    dhVar25 = this.eob.emx;
                                                                                    String threadID = dhVar25.getThreadID();
                                                                                    dhVar26 = this.eob.emx;
                                                                                    String name2 = dhVar26.getPbData().aLP().getName();
                                                                                    EcommEnsureOrderActivityConfig ecommEnsureOrderActivityConfig = new EcommEnsureOrderActivityConfig(this.eob.getPageContext().getPageActivity(), j4, threadID);
                                                                                    ecommEnsureOrderActivityConfig.setForumName(name2);
                                                                                    this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommEnsureOrderActivityConfig));
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ay ayVar8 = new com.baidu.tbadk.core.util.ay("c11428");
                                                                ayVar8.s("obj_param1", 1);
                                                                dhVar20 = this.eob.emx;
                                                                ayVar8.ab("obj_id", new StringBuilder(String.valueOf(dhVar20.getPbData().aLQ().Uw.productId)).toString());
                                                                ayVar8.s("obj_locate", 2);
                                                                if (ayVar8 != null) {
                                                                    TiebaStatic.log(ayVar8);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        this.eob.aNa();
                                                        return;
                                                    } else {
                                                        this.eob.aMZ();
                                                        return;
                                                    }
                                                } else {
                                                    this.eob.aaO();
                                                    exVar45 = this.eob.enh;
                                                    exVar45.aAE();
                                                    exVar46 = this.eob.enh;
                                                    exVar46.aPp();
                                                    dhVar58 = this.eob.emx;
                                                    dhVar58.aNX();
                                                    this.eob.od(2);
                                                    this.eob.aNd();
                                                    return;
                                                }
                                            } else if (this.eob.checkUpIsLogin()) {
                                                dhVar5 = this.eob.emx;
                                                if (dhVar5.getPbData() != null) {
                                                    exVar41 = this.eob.enh;
                                                    exVar41.aAE();
                                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) sparseArray13.get(t.g.tag_load_sub_data);
                                                    View view2 = (View) sparseArray13.get(t.g.tag_load_sub_view);
                                                    if (qVar2 != null && view2 != null) {
                                                        dhVar6 = this.eob.emx;
                                                        String threadID2 = dhVar6.getThreadID();
                                                        String id2 = qVar2.getId();
                                                        int i4 = 0;
                                                        dhVar7 = this.eob.emx;
                                                        if (dhVar7.getPbData() != null) {
                                                            dhVar17 = this.eob.emx;
                                                            i4 = dhVar17.getPbData().aLX();
                                                        }
                                                        this.eob.aaO();
                                                        if (view.getId() != t.g.replybtn) {
                                                            if (view.getId() == t.g.sub_pb_item) {
                                                                SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                                String str9 = (String) sparseArray14.get(t.g.tag_photo_username);
                                                                com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) sparseArray14.get(t.g.tag_clip_board);
                                                                String str10 = null;
                                                                if (qVar3 != null) {
                                                                    str10 = qVar3.getId();
                                                                }
                                                                TiebaStatic.log("c10088");
                                                                oR2 = this.eob.oR(id2);
                                                                if (qVar2 != null) {
                                                                    dhVar11 = this.eob.emx;
                                                                    if (dhVar11 != null) {
                                                                        dhVar12 = this.eob.emx;
                                                                        if (dhVar12.getPbData() != null && oR2 != null) {
                                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.eob.getPageContext().getPageActivity());
                                                                            SmallTailInfo aQY = qVar2.aQY();
                                                                            dhVar13 = this.eob.emx;
                                                                            this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID2, id2, "pb", true, str9, true, str10, i4, aQY, dhVar13.getPbData().qf(), false, qVar2.getAuthor().getIconInfo()).addBigImageData(oR2.eoq, oR2.eor, oR2.eos, oR2.index)));
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.log("c10089");
                                                            oR = this.eob.oR(id2);
                                                            if (qVar2 != null) {
                                                                dhVar8 = this.eob.emx;
                                                                if (dhVar8 != null) {
                                                                    dhVar9 = this.eob.emx;
                                                                    if (dhVar9.getPbData() != null && oR != null) {
                                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.eob.getPageContext().getPageActivity());
                                                                        SmallTailInfo aQY2 = qVar2.aQY();
                                                                        dhVar10 = this.eob.emx;
                                                                        this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id2, "pb", true, null, false, null, i4, aQY2, dhVar10.getPbData().qf(), false, qVar2.getAuthor().getIconInfo()).addBigImageData(oR.eoq, oR.eor, oR.eos, oR.index)));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        oR3 = this.eob.oR(id2);
                                                        if (qVar2 != null) {
                                                            dhVar14 = this.eob.emx;
                                                            if (dhVar14 != null) {
                                                                dhVar15 = this.eob.emx;
                                                                if (dhVar15.getPbData() != null && oR3 != null) {
                                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.eob.getPageContext().getPageActivity());
                                                                    SmallTailInfo aQY3 = qVar2.aQY();
                                                                    dhVar16 = this.eob.emx;
                                                                    this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id2, "pb", true, null, true, null, i4, aQY3, dhVar16.getPbData().qf(), false, qVar2.getAuthor().getIconInfo()).addBigImageData(oR3.eoq, oR3.eor, oR3.eos, oR3.index)));
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
                                                com.baidu.tbadk.core.util.ay s = new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 3);
                                                dhVar18 = this.eob.emx;
                                                TiebaStatic.log(s.ab("fid", dhVar18.getPbData().getForumId()));
                                                return;
                                            }
                                        } else if (!this.eob.checkUpIsLogin()) {
                                            com.baidu.tbadk.core.util.ay s2 = new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 2);
                                            dhVar71 = this.eob.emx;
                                            TiebaStatic.log(s2.ab("fid", dhVar71.getPbData().getForumId()));
                                            return;
                                        } else {
                                            this.eob.aMC();
                                            return;
                                        }
                                    } else if (this.eob.checkUpIsLogin()) {
                                        exVar74 = this.eob.enh;
                                        exVar74.aAE();
                                        this.eob.aaO();
                                        this.eob.od(2);
                                        this.eob.agb();
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.i.gm()) {
                                    exVar22 = this.eob.enh;
                                    exVar22.aOX();
                                    z = this.eob.mIsLoading;
                                    if (!z) {
                                        this.eob.mIsLoading = true;
                                        exVar23 = this.eob.enh;
                                        exVar23.erX.evd.setEnabled(false);
                                        exVar24 = this.eob.enh;
                                        exVar24.aud();
                                        this.eob.aaO();
                                        exVar25 = this.eob.enh;
                                        exVar25.aPp();
                                        dhVar4 = this.eob.emx;
                                        aMX = this.eob.aMX();
                                        dhVar4.oU(aMX);
                                        TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        exVar26 = this.eob.enh;
                                        exVar26.aPO();
                                        exVar27 = this.eob.enh;
                                        exVar27.aNI();
                                        this.eob.od(2);
                                        return;
                                    }
                                    return;
                                } else {
                                    this.eob.showToast(t.j.network_not_available);
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            dhVar100 = this.eob.emx;
                            if (dhVar100.getErrorNo() == 4) {
                                dhVar103 = this.eob.emx;
                                if (StringUtils.isNull(dhVar103.aNN())) {
                                    dhVar104 = this.eob.emx;
                                    if (dhVar104.getAppealInfo() != null) {
                                        dhVar105 = this.eob.emx;
                                        name = dhVar105.getAppealInfo().forumName;
                                    }
                                }
                                this.eob.finish();
                                return;
                            }
                            dhVar101 = this.eob.emx;
                            name = dhVar101.getPbData().aLP().getName();
                            if (!StringUtils.isNull(name)) {
                                dhVar102 = this.eob.emx;
                                String aNN = dhVar102.aNN();
                                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.eob.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (StringUtils.isNull(aNN)) {
                                    this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                } else if (aNN.equals(name)) {
                                    this.eob.finish();
                                    return;
                                } else {
                                    this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                }
                            }
                            this.eob.finish();
                            return;
                        }
                    }
                }
            }
        }
        exVar6 = this.eob.enh;
        exVar6.aPI();
        dhVar = this.eob.emx;
        if (dhVar.getPbData().aLX() == 1) {
            aVar = this.eob.eng;
            if (!aVar.bjS()) {
                int i5 = 0;
                exVar7 = this.eob.enh;
                if (view != exVar7.aPD()) {
                    exVar8 = this.eob.enh;
                    if (view != exVar8.aPE()) {
                        exVar9 = this.eob.enh;
                        if (view != exVar9.aPF()) {
                            exVar10 = this.eob.enh;
                            if (view != exVar10.aPG()) {
                                exVar11 = this.eob.enh;
                                if (view == exVar11.aPn()) {
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
                dhVar2 = this.eob.emx;
                ForumData aLP2 = dhVar2.getPbData().aLP();
                String name3 = aLP2.getName();
                String id3 = aLP2.getId();
                dhVar3 = this.eob.emx;
                String id4 = dhVar3.getPbData().aLQ().getId();
                if (!com.baidu.tieba.c.a.Nn() || !com.baidu.tieba.c.a.f(this.eob.getBaseContext(), id4, null)) {
                    exVar12 = this.eob.enh;
                    exVar12.aPm();
                    aVar2 = this.eob.eng;
                    exVar13 = this.eob.enh;
                    aVar2.a(id3, name3, id4, i5, exVar13.aPo());
                }
            }
        }
    }
}
