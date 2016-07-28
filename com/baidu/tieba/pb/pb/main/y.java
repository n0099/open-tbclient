package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v170, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x06b1, code lost:
        if (r21 == r1.efS.aLp().aJK()) goto L135;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:398:0x1282  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x132a  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x1342  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x134c  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x1444  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x152a  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x1541  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x1557  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x1569  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x1577  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x15fa  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x165a  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x172a  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x1742  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x1775  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x1778  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x1799  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x17ac  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x17bf  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x1d61  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x1d64  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x1d67  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x1d6a  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x1d6d  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x1d70  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x1d73  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        ew ewVar;
        ew ewVar2;
        ew ewVar3;
        ew ewVar4;
        ew ewVar5;
        ew ewVar6;
        dh dhVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        ew ewVar7;
        ew ewVar8;
        ew ewVar9;
        ew ewVar10;
        ew ewVar11;
        ew ewVar12;
        dh dhVar2;
        dh dhVar3;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ew ewVar13;
        ew ewVar14;
        ew ewVar15;
        ew ewVar16;
        ew ewVar17;
        ew ewVar18;
        ew ewVar19;
        ew ewVar20;
        ew ewVar21;
        ew ewVar22;
        boolean z;
        ew ewVar23;
        ew ewVar24;
        ew ewVar25;
        dh dhVar4;
        String aIf;
        ew ewVar26;
        ew ewVar27;
        ew ewVar28;
        ew ewVar29;
        ew ewVar30;
        ew ewVar31;
        ew ewVar32;
        ew ewVar33;
        ew ewVar34;
        ew ewVar35;
        ew ewVar36;
        ew ewVar37;
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        Cdo cdo4;
        Cdo cdo5;
        ew ewVar38;
        ew ewVar39;
        Cdo cdo6;
        ew ewVar40;
        dh dhVar5;
        ew ewVar41;
        dh dhVar6;
        dh dhVar7;
        PbActivity.b oi;
        dh dhVar8;
        dh dhVar9;
        dh dhVar10;
        PbActivity.b oi2;
        dh dhVar11;
        dh dhVar12;
        dh dhVar13;
        PbActivity.b oi3;
        dh dhVar14;
        dh dhVar15;
        dh dhVar16;
        dh dhVar17;
        dh dhVar18;
        ew ewVar42;
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
        int aHT;
        int aHT2;
        dh dhVar33;
        dh dhVar34;
        dh dhVar35;
        dh dhVar36;
        dh dhVar37;
        dh dhVar38;
        dh dhVar39;
        dh dhVar40;
        int aHT3;
        int aHT4;
        dh dhVar41;
        dh dhVar42;
        dh dhVar43;
        dh dhVar44;
        dh dhVar45;
        dh dhVar46;
        dh dhVar47;
        dh dhVar48;
        ew ewVar43;
        dh dhVar49;
        dh dhVar50;
        dh dhVar51;
        ew ewVar44;
        dh dhVar52;
        dh dhVar53;
        dh dhVar54;
        dh dhVar55;
        dh dhVar56;
        dh dhVar57;
        ew ewVar45;
        ew ewVar46;
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
        boolean hA;
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
        com.baidu.tbadk.core.data.bj bjVar;
        dh dhVar62;
        dh dhVar63;
        dh dhVar64;
        ew ewVar47;
        ew ewVar48;
        ew ewVar49;
        dh dhVar65;
        dh dhVar66;
        dh dhVar67;
        dh dhVar68;
        ew ewVar50;
        ew ewVar51;
        Cdo cdo44;
        ew ewVar52;
        ew ewVar53;
        dh dhVar69;
        ew ewVar54;
        dh dhVar70;
        Cdo cdo45;
        dh dhVar71;
        Cdo cdo46;
        ew ewVar55;
        Cdo cdo47;
        dh dhVar72;
        ew ewVar56;
        dh dhVar73;
        Cdo cdo48;
        Cdo cdo49;
        ew ewVar57;
        String aHS;
        ew ewVar58;
        ew ewVar59;
        ew ewVar60;
        ew ewVar61;
        ew ewVar62;
        dh dhVar74;
        dh dhVar75;
        ew ewVar63;
        ew ewVar64;
        dh dhVar76;
        dh dhVar77;
        dh dhVar78;
        ew ewVar65;
        ew ewVar66;
        dh dhVar79;
        dh dhVar80;
        dh dhVar81;
        ew ewVar67;
        dh dhVar82;
        ew ewVar68;
        ew ewVar69;
        ew ewVar70;
        dh dhVar83;
        ew ewVar71;
        ew ewVar72;
        dh dhVar84;
        ew ewVar73;
        dh dhVar85;
        ew ewVar74;
        ew ewVar75;
        ew ewVar76;
        ew ewVar77;
        ew ewVar78;
        ew ewVar79;
        boolean nz;
        dh dhVar86;
        ew ewVar80;
        dh dhVar87;
        dh dhVar88;
        dh dhVar89;
        dh dhVar90;
        dh dhVar91;
        dh dhVar92;
        dh dhVar93;
        dh dhVar94;
        dh dhVar95;
        dh dhVar96;
        ew ewVar81;
        ew ewVar82;
        dh dhVar97;
        dh dhVar98;
        String name;
        dh dhVar99;
        dh dhVar100;
        dh dhVar101;
        dh dhVar102;
        dh dhVar103;
        dh dhVar104;
        ew ewVar83;
        dh dhVar105;
        ew ewVar84;
        ew ewVar85;
        ew ewVar86;
        dh dhVar106;
        ew ewVar87;
        dh dhVar107;
        dh dhVar108;
        dh dhVar109;
        ew ewVar88;
        ewVar = this.ebT.ebb;
        if (view == ewVar.getNextView()) {
            dhVar109 = this.ebT.eas;
            if (dhVar109.hH(true)) {
                ewVar88 = this.ebT.ebb;
                ewVar88.aKz();
                return;
            }
            return;
        }
        ewVar2 = this.ebT.ebb;
        if (view == ewVar2.aKu()) {
            ewVar87 = this.ebT.ebb;
            ewVar87.aKo();
            if (UtilHelper.isFloatWindowOpAllowed(this.ebT.getPageContext().getPageActivity())) {
                this.ebT.ebf = true;
                PbActivity pbActivity = this.ebT;
                dhVar107 = this.ebT.eas;
                pbActivity.a(dhVar107.getPbData(), 0, 1, true, true);
                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10830");
                dhVar108 = this.ebT.eas;
                TiebaStatic.log(ayVar.ab("tid", dhVar108.getThreadID()));
                return;
            }
            this.ebT.aHR();
            return;
        }
        ewVar3 = this.ebT.ebb;
        if (view == ewVar3.aKV()) {
            ewVar84 = this.ebT.ebb;
            ewVar84.avR();
            this.ebT.VR();
            ewVar85 = this.ebT.ebb;
            ewVar85.aKy();
            ewVar86 = this.ebT.ebb;
            ewVar86.atw();
            dhVar106 = this.ebT.eas;
            dhVar106.nE(1);
            return;
        }
        ewVar4 = this.ebT.ebb;
        if (view == ewVar4.efS.aBf) {
            ewVar83 = this.ebT.ebb;
            dhVar105 = this.ebT.eas;
            if (!ewVar83.id(dhVar105.aJa())) {
                this.ebT.eaL = false;
                this.ebT.finish();
                return;
            }
            this.ebT.VR();
            return;
        }
        ewVar5 = this.ebT.ebb;
        if (view != ewVar5.aKM()) {
            ewVar14 = this.ebT.ebb;
            if (view != ewVar14.aKN()) {
                ewVar15 = this.ebT.ebb;
                if (view != ewVar15.aKO()) {
                    ewVar16 = this.ebT.ebb;
                    if (view != ewVar16.aKP()) {
                        ewVar17 = this.ebT.ebb;
                        if (view != ewVar17.aKw()) {
                            ewVar18 = this.ebT.ebb;
                            if (view == ewVar18.aKS()) {
                                dhVar103 = this.ebT.eas;
                                if (dhVar103 != null) {
                                    dhVar104 = this.ebT.eas;
                                    com.baidu.tbadk.browser.f.u(this.ebT.getPageContext().getPageActivity(), dhVar104.getPbData().aGY().qw().getLink());
                                    return;
                                }
                                return;
                            }
                            ewVar19 = this.ebT.ebb;
                            if (view != ewVar19.efS.eiV) {
                                ewVar20 = this.ebT.ebb;
                                if (view == ewVar20.efS.eiX) {
                                    dhVar93 = this.ebT.eas;
                                    if (dhVar93 != null) {
                                        dhVar94 = this.ebT.eas;
                                        if (dhVar94.getPbData() != null) {
                                            dhVar95 = this.ebT.eas;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = dhVar95.getPbData().aGZ();
                                            if (aGZ == null || aGZ.size() <= 0) {
                                                dhVar96 = this.ebT.eas;
                                                if (dhVar96.aIX()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.ebT.getPageContext().getPageActivity(), this.ebT.getPageContext().getString(u.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            ewVar81 = this.ebT.ebb;
                                            ewVar81.aKg();
                                            ewVar82 = this.ebT.ebb;
                                            ewVar82.aKX();
                                            this.ebT.aHU();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.ebT.getPageContext().getPageActivity(), this.ebT.getPageContext().getString(u.j.pb_no_data_tips));
                                    return;
                                }
                                ewVar21 = this.ebT.ebb;
                                if (view != ewVar21.efS.eiW && view.getId() != u.g.pb_god_user_tip_content) {
                                    ewVar28 = this.ebT.ebb;
                                    if (view == ewVar28.efS.eiY) {
                                        dhVar87 = this.ebT.eas;
                                        AdditionData aHi = dhVar87.getPbData().aHi();
                                        if (!TextUtils.isEmpty(aHi.getWarnMsg())) {
                                            com.baidu.adp.lib.util.k.showToast(this.ebT.getPageContext().getPageActivity(), aHi.getWarnMsg());
                                            return;
                                        } else if (aHi.getAlreadyCount() != aHi.getTotalCount()) {
                                            dhVar88 = this.ebT.eas;
                                            ForumData aGX = dhVar88.getPbData().aGX();
                                            dhVar89 = this.ebT.eas;
                                            com.baidu.tbadk.core.data.be aGY = dhVar89.getPbData().aGY();
                                            dhVar90 = this.ebT.eas;
                                            AntiData pc = dhVar90.getPbData().pc();
                                            if (aGY.getId() != null) {
                                                if (pc != null && pc.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.k.showToast(this.ebT.getPageContext().getPageActivity(), pc.getForbid_info());
                                                    return;
                                                }
                                                int i2 = 0;
                                                dhVar91 = this.ebT.eas;
                                                if (dhVar91.getPbData().getUserData() != null) {
                                                    dhVar92 = this.ebT.eas;
                                                    i2 = dhVar92.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.ebT.getPageContext().getPageActivity(), 2, aGX.getId(), aGX.getName(), aGY.getId(), aHi.getPostId(), 0, pc, 13008, false, false, null, false, false, null, aHi, null, i2)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.k.showToast(this.ebT.getPageContext().getPageActivity(), String.format(this.ebT.getPageContext().getString(u.j.write_addition_limit), Integer.valueOf(aHi.getTotalCount())));
                                            return;
                                        }
                                    }
                                    ewVar29 = this.ebT.ebb;
                                    if (ewVar29.efS.aLp() != null) {
                                        ewVar78 = this.ebT.ebb;
                                        if (view == ewVar78.efS.aLp().aJv()) {
                                            ewVar79 = this.ebT.ebb;
                                            ewVar79.avR();
                                            nz = this.ebT.nz(11009);
                                            if (nz) {
                                                dhVar86 = this.ebT.eas;
                                                ewVar80 = this.ebT.ebb;
                                                if (dhVar86.nK(ewVar80.aKF()) == null) {
                                                    return;
                                                }
                                                this.ebT.aHZ();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ewVar30 = this.ebT.ebb;
                                    if (ewVar30.efS.aLp() != null) {
                                        ewVar75 = this.ebT.ebb;
                                        if (view != ewVar75.efS.aLp().aJJ()) {
                                            ewVar77 = this.ebT.ebb;
                                        }
                                        ewVar76 = this.ebT.ebb;
                                        ewVar76.efS.nf();
                                        return;
                                    }
                                    ewVar31 = this.ebT.ebb;
                                    if (view != ewVar31.aKD()) {
                                        ewVar32 = this.ebT.ebb;
                                        if (ewVar32.efS.aLp() != null) {
                                            ewVar71 = this.ebT.ebb;
                                            if (view == ewVar71.efS.aLp().aJE()) {
                                                ewVar72 = this.ebT.ebb;
                                                ewVar72.avR();
                                                dhVar84 = this.ebT.eas;
                                                if (dhVar84.akg() != null) {
                                                    ewVar73 = this.ebT.ebb;
                                                    dhVar85 = this.ebT.eas;
                                                    ewVar73.a(dhVar85.akg(), this.ebT.dLr);
                                                }
                                                TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        ewVar33 = this.ebT.ebb;
                                        if (ewVar33.efS.aLp() != null) {
                                            ewVar68 = this.ebT.ebb;
                                            if (view == ewVar68.efS.aLp().aJF()) {
                                                ewVar69 = this.ebT.ebb;
                                                ewVar69.avR();
                                                this.ebT.nA(2);
                                                this.ebT.VR();
                                                ewVar70 = this.ebT.ebb;
                                                ewVar70.aKy();
                                                dhVar83 = this.ebT.eas;
                                                dhVar83.aJg();
                                                TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        ewVar34 = this.ebT.ebb;
                                        if (ewVar34.efS.aLp() != null) {
                                            ewVar66 = this.ebT.ebb;
                                            if (view == ewVar66.efS.aLp().aJG()) {
                                                dhVar79 = this.ebT.eas;
                                                if (dhVar79 != null) {
                                                    dhVar80 = this.ebT.eas;
                                                    if (dhVar80.getPbData() != null) {
                                                        dhVar81 = this.ebT.eas;
                                                        if (dhVar81.getPbData().aGY() != null) {
                                                            ewVar67 = this.ebT.ebb;
                                                            ewVar67.efS.nf();
                                                            PbActivity pbActivity2 = this.ebT;
                                                            dhVar82 = this.ebT.eas;
                                                            pbActivity2.oe(dhVar82.getPbData().aGY().qL());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        ewVar35 = this.ebT.ebb;
                                        if (ewVar35.efS.aLp() != null) {
                                            ewVar64 = this.ebT.ebb;
                                            if (view == ewVar64.efS.aLp().eej) {
                                                dhVar76 = this.ebT.eas;
                                                if (dhVar76 != null) {
                                                    dhVar77 = this.ebT.eas;
                                                    if (dhVar77.getPbData() != null) {
                                                        dhVar78 = this.ebT.eas;
                                                        if (dhVar78.getPbData().aGY() != null) {
                                                            ewVar65 = this.ebT.ebb;
                                                            ewVar65.efS.nf();
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.ebT.getPageContext().getPageActivity(), 0, TbConfig.ECOMM_FEED_BACK_ID, TbConfig.ECOMM_FEED_BACK_NAME, null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0)));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        ewVar36 = this.ebT.ebb;
                                        if (ewVar36.efS.aLp() != null) {
                                            ewVar60 = this.ebT.ebb;
                                            if (view == ewVar60.efS.aLp().aJH()) {
                                                TiebaStatic.log("c10414");
                                                ewVar61 = this.ebT.ebb;
                                                ewVar61.avR();
                                                ewVar62 = this.ebT.ebb;
                                                if (ewVar62.qn() != ew.ehH) {
                                                    dhVar74 = this.ebT.eas;
                                                    if (dhVar74.aJu() != null) {
                                                        dhVar75 = this.ebT.eas;
                                                        dhVar75.aJu().nC(dh.edc);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                ewVar63 = this.ebT.ebb;
                                                ewVar63.aLb();
                                                return;
                                            }
                                        }
                                        ewVar37 = this.ebT.ebb;
                                        if (ewVar37.efS.aLp() != null) {
                                            ewVar57 = this.ebT.ebb;
                                            if (view == ewVar57.efS.aLp().aJI()) {
                                                aHS = this.ebT.aHS();
                                                this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.ebT.getPageContext().getPageActivity(), null, aHS, true)));
                                                ewVar58 = this.ebT.ebb;
                                                ewVar58.efS.nf();
                                                ewVar59 = this.ebT.ebb;
                                                ewVar59.efS.aLp().aJN();
                                                return;
                                            }
                                        }
                                        cdo = this.ebT.ebe;
                                        if (cdo != null) {
                                            cdo49 = this.ebT.ebe;
                                            if (view == cdo49.aJx()) {
                                                Object tag = view.getTag();
                                                if (!(tag instanceof String)) {
                                                    if (tag instanceof SparseArray) {
                                                        SparseArray<Object> sparseArray5 = (SparseArray) tag;
                                                        if ((sparseArray5.get(u.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(u.g.tag_user_mute_visible)).booleanValue()) {
                                                            sparseArray5.put(u.g.tag_from, 0);
                                                            sparseArray5.put(u.g.tag_check_mute_from, 2);
                                                            this.ebT.d(sparseArray5);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.ebT.oe((String) tag);
                                                return;
                                            }
                                        }
                                        cdo2 = this.ebT.ebe;
                                        if (cdo2 != null) {
                                            cdo48 = this.ebT.ebe;
                                            if (view == cdo48.aJv()) {
                                                if (!this.ebT.checkUpIsLogin()) {
                                                    return;
                                                }
                                                this.ebT.aW(view);
                                                return;
                                            }
                                        }
                                        cdo3 = this.ebT.ebe;
                                        if (cdo3 != null) {
                                            cdo47 = this.ebT.ebe;
                                            if (view == cdo47.aJB()) {
                                                if (view.getTag(u.g.tag_pb_floor_postion) instanceof Integer) {
                                                    dhVar72 = this.ebT.eas;
                                                    if (dhVar72 != null) {
                                                        ewVar56 = this.ebT.ebb;
                                                        ewVar56.aKo();
                                                        if (!UtilHelper.isFloatWindowOpAllowed(this.ebT.getPageContext().getPageActivity())) {
                                                            this.ebT.aHR();
                                                            return;
                                                        }
                                                        int intValue = ((Integer) view.getTag(u.g.tag_pb_floor_postion)).intValue();
                                                        int intValue2 = ((Integer) view.getTag(u.g.tag_pb_floor_number)).intValue();
                                                        this.ebT.ebf = true;
                                                        PbActivity pbActivity3 = this.ebT;
                                                        dhVar73 = this.ebT.eas;
                                                        pbActivity3.a(dhVar73.getPbData(), intValue, intValue2, true, true);
                                                        TiebaStatic.log("c10834");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        cdo4 = this.ebT.ebe;
                                        if (cdo4 != null) {
                                            cdo46 = this.ebT.ebe;
                                            if (view == cdo46.aJy()) {
                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                if (sparseArray6 != null && (sparseArray6.get(u.g.tag_del_post_type) instanceof Integer) && (sparseArray6.get(u.g.tag_del_post_id) instanceof String) && (sparseArray6.get(u.g.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(u.g.tag_del_post_is_self) instanceof Boolean)) {
                                                    ewVar55 = this.ebT.ebb;
                                                    ewVar55.a(((Integer) sparseArray6.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray6.get(u.g.tag_del_post_id), ((Integer) sparseArray6.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(u.g.tag_del_post_is_self)).booleanValue());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        cdo5 = this.ebT.ebe;
                                        if (cdo5 != null) {
                                            cdo45 = this.ebT.ebe;
                                            if (view == cdo45.aJz()) {
                                                long j = -1;
                                                String str2 = "";
                                                int i3 = 0;
                                                if (view.getTag(u.g.tag_chudian_template_id) instanceof Long) {
                                                    j = ((Long) view.getTag(u.g.tag_chudian_template_id)).longValue();
                                                }
                                                if (view.getTag(u.g.tag_chudian_monitor_id) instanceof String) {
                                                    str2 = (String) view.getTag(u.g.tag_chudian_monitor_id);
                                                }
                                                if (view.getTag(u.g.tag_chudian_hide_day) instanceof Integer) {
                                                    i3 = ((Integer) view.getTag(u.g.tag_chudian_hide_day)).intValue();
                                                }
                                                dhVar71 = this.ebT.eas;
                                                com.baidu.tieba.pb.data.h pbData = dhVar71.getPbData();
                                                String str3 = null;
                                                String str4 = null;
                                                String str5 = null;
                                                if (pbData != null && pbData.aGX() != null) {
                                                    str3 = pbData.aGX().getId();
                                                    str4 = pbData.aGX().getName();
                                                    str5 = pbData.getThreadId();
                                                }
                                                com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                                this.ebT.a(j, str2, str3, str4, str5, i3);
                                                return;
                                            }
                                        }
                                        ewVar38 = this.ebT.ebb;
                                        if (ewVar38.aLc() == view) {
                                            ewVar54 = this.ebT.ebb;
                                            if (ewVar54.aLc().getIndicateStatus()) {
                                                dhVar70 = this.ebT.eas;
                                                com.baidu.tieba.pb.data.h pbData2 = dhVar70.getPbData();
                                                if (pbData2 != null && pbData2.aGY() != null && pbData2.aGY().qh() != null) {
                                                    String ow = pbData2.aGY().qh().ow();
                                                    if (StringUtils.isNull(ow)) {
                                                        ow = pbData2.aGY().qh().getTaskId();
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11107").ab("obj_id", ow));
                                                }
                                            } else {
                                                com.baidu.tieba.tbadkCore.d.a.bQ("c10725", null);
                                            }
                                            this.ebT.aIm();
                                            return;
                                        }
                                        ewVar39 = this.ebT.ebb;
                                        if (ewVar39.aKr() != view) {
                                            cdo6 = this.ebT.ebe;
                                            if (cdo6 != null) {
                                                cdo44 = this.ebT.ebe;
                                                if (view == cdo44.aJw()) {
                                                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                                                    if (sparseArray7 != null) {
                                                        boolean booleanValue2 = ((Boolean) sparseArray7.get(u.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue3 = ((Boolean) sparseArray7.get(u.g.tag_should_delete_visible)).booleanValue();
                                                        boolean booleanValue4 = ((Boolean) sparseArray7.get(u.g.tag_user_mute_visible)).booleanValue();
                                                        if (booleanValue2) {
                                                            if (booleanValue4) {
                                                                sparseArray7.put(u.g.tag_from, 1);
                                                                sparseArray7.put(u.g.tag_check_mute_from, 2);
                                                                this.ebT.d(sparseArray7);
                                                                return;
                                                            }
                                                            sparseArray7.put(u.g.tag_check_mute_from, 2);
                                                            ewVar53 = this.ebT.ebb;
                                                            ewVar53.aZ(view);
                                                            return;
                                                        } else if (booleanValue3) {
                                                            ewVar52 = this.ebT.ebb;
                                                            ewVar52.a(((Integer) sparseArray7.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(u.g.tag_del_post_id), ((Integer) sparseArray7.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(u.g.tag_del_post_is_self)).booleanValue());
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                            }
                                            ewVar40 = this.ebT.ebb;
                                            if (view == ewVar40.aIS()) {
                                                if (this.ebT.checkUpIsLogin()) {
                                                    ewVar49 = this.ebT.ebb;
                                                    if (!ewVar49.aIP()) {
                                                        dhVar65 = this.ebT.eas;
                                                        if (dhVar65 != null) {
                                                            dhVar66 = this.ebT.eas;
                                                            if (dhVar66.aJs() != null) {
                                                                dhVar67 = this.ebT.eas;
                                                                if (dhVar67.aJs().aIJ() != null) {
                                                                    dhVar68 = this.ebT.eas;
                                                                    if (com.baidu.tbadk.core.util.y.s(dhVar68.aJs().aIJ().getItems()) != 0) {
                                                                        ewVar50 = this.ebT.ebb;
                                                                        ewVar50.aIQ();
                                                                        return;
                                                                    }
                                                                    this.ebT.showToast(u.j.graffiti_quick_vote_empty);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    ewVar51 = this.ebT.ebb;
                                                    ewVar51.aIR();
                                                    return;
                                                }
                                                return;
                                            } else if (view.getId() == u.g.pb_head_function_manage_delormanage) {
                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                if (((Boolean) sparseArray8.get(u.g.tag_should_manage_visible)).booleanValue()) {
                                                    ewVar48 = this.ebT.ebb;
                                                    ewVar48.aZ(view);
                                                    return;
                                                }
                                                ewVar47 = this.ebT.ebb;
                                                ewVar47.a(((Integer) sparseArray8.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(u.g.tag_del_post_id), ((Integer) sparseArray8.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(u.g.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else if (view.getId() != u.g.replybtn && view.getId() != u.g.sub_pb_more && view.getId() != u.g.sub_pb_item) {
                                                ewVar42 = this.ebT.ebb;
                                                if (view == ewVar42.aHI()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                        dhVar62 = this.ebT.eas;
                                                        long c2 = com.baidu.adp.lib.h.b.c(dhVar62.getPbData().getForumId(), 0L);
                                                        dhVar63 = this.ebT.eas;
                                                        long c3 = com.baidu.adp.lib.h.b.c(dhVar63.getThreadID(), 0L);
                                                        dhVar64 = this.ebT.eas;
                                                        this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.ebT.getPageContext().getPageActivity(), 24008, c2, c3, c, dhVar64.getPbData().aGY().qO())));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                int id = view.getId();
                                                if (id == u.g.pb_u9_text_view) {
                                                    if (this.ebT.checkUpIsLogin() && (bjVar = (com.baidu.tbadk.core.data.bj) view.getTag()) != null && !StringUtils.isNull(bjVar.rH())) {
                                                        TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                        com.baidu.tbadk.core.util.bi.us().c(this.ebT.getPageContext(), new String[]{bjVar.rH()});
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == u.g.reply) {
                                                    cdo7 = this.ebT.ebe;
                                                    if (cdo7 == null) {
                                                        this.ebT.ebe = new Cdo(this.ebT.getPageContext(), this.ebT.bGw);
                                                        cdo43 = this.ebT.ebe;
                                                        z7 = this.ebT.mIsLogin;
                                                        cdo43.hL(z7);
                                                    }
                                                    cdo8 = this.ebT.ebe;
                                                    cdo8.Ft();
                                                    com.baidu.tieba.tbadkCore.data.s sVar = null;
                                                    if (view != null && view.getTag() != null) {
                                                        sVar = (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(u.g.tag_load_sub_data);
                                                        if (!this.ebT.aIg()) {
                                                            dhVar61 = this.ebT.eas;
                                                            if (dhVar61.aJh() && TbadkCoreApplication.m10getInst().isTTSCanUse()) {
                                                                cdo42 = this.ebT.ebe;
                                                                cdo42.aJD();
                                                                sparseArray = (SparseArray) view.getTag();
                                                                if (sparseArray.get(u.g.tag_pb_floor_postion) instanceof Integer) {
                                                                    int intValue3 = ((Integer) sparseArray.get(u.g.tag_pb_floor_postion)).intValue();
                                                                    int intValue4 = ((Integer) sparseArray.get(u.g.tag_pb_floor_number)).intValue();
                                                                    cdo40 = this.ebT.ebe;
                                                                    cdo40.aJB().setTag(u.g.tag_pb_floor_postion, Integer.valueOf(intValue3));
                                                                    cdo41 = this.ebT.ebe;
                                                                    cdo41.aJB().setTag(u.g.tag_pb_floor_number, Integer.valueOf(intValue4));
                                                                }
                                                                SparseArray sparseArray9 = new SparseArray();
                                                                sparseArray9.put(u.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(u.g.tag_clip_board));
                                                                sparseArray9.put(u.g.tag_is_subpb, false);
                                                                cdo14 = this.ebT.ebe;
                                                                cdo14.aJv().setTag(sparseArray9);
                                                                sparseArray2 = (SparseArray) view.getTag();
                                                                booleanValue = ((Boolean) sparseArray2.get(u.g.tag_should_manage_visible)).booleanValue();
                                                                boolean booleanValue5 = ((Boolean) sparseArray2.get(u.g.tag_user_mute_visible)).booleanValue();
                                                                boolean booleanValue6 = ((Boolean) sparseArray2.get(u.g.tag_should_delete_visible)).booleanValue();
                                                                if (sparseArray2.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                                    z3 = false;
                                                                } else {
                                                                    z3 = ((Boolean) sparseArray2.get(u.g.tag_del_post_is_self)).booleanValue();
                                                                }
                                                                String str6 = null;
                                                                if (sparseArray2.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                                    str6 = (String) sparseArray2.get(u.g.tag_forbid_user_post_id);
                                                                }
                                                                if (!booleanValue) {
                                                                    SparseArray sparseArray10 = new SparseArray();
                                                                    sparseArray10.put(u.g.tag_should_manage_visible, true);
                                                                    sparseArray10.put(u.g.tag_manage_user_identity, sparseArray2.get(u.g.tag_manage_user_identity));
                                                                    sparseArray10.put(u.g.tag_forbid_user_name, sparseArray2.get(u.g.tag_forbid_user_name));
                                                                    sparseArray10.put(u.g.tag_forbid_user_post_id, str6);
                                                                    if (booleanValue5) {
                                                                        sparseArray10.put(u.g.tag_user_mute_visible, true);
                                                                        sparseArray10.put(u.g.tag_is_mem, sparseArray2.get(u.g.tag_is_mem));
                                                                        sparseArray10.put(u.g.tag_user_mute_mute_userid, sparseArray2.get(u.g.tag_user_mute_mute_userid));
                                                                        sparseArray10.put(u.g.tag_user_mute_mute_username, sparseArray2.get(u.g.tag_user_mute_mute_username));
                                                                        sparseArray10.put(u.g.tag_user_mute_post_id, sparseArray2.get(u.g.tag_user_mute_post_id));
                                                                        sparseArray10.put(u.g.tag_user_mute_thread_id, sparseArray2.get(u.g.tag_user_mute_thread_id));
                                                                    } else {
                                                                        sparseArray10.put(u.g.tag_user_mute_visible, false);
                                                                    }
                                                                    if (booleanValue6) {
                                                                        sparseArray10.put(u.g.tag_should_delete_visible, true);
                                                                        sparseArray10.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                        sparseArray10.put(u.g.tag_del_post_id, sparseArray2.get(u.g.tag_del_post_id));
                                                                        sparseArray10.put(u.g.tag_del_post_type, sparseArray2.get(u.g.tag_del_post_type));
                                                                        cdo39 = this.ebT.ebe;
                                                                        cdo39.aJy().setVisibility(0);
                                                                    } else {
                                                                        sparseArray10.put(u.g.tag_should_delete_visible, false);
                                                                        cdo34 = this.ebT.ebe;
                                                                        cdo34.aJy().setVisibility(8);
                                                                    }
                                                                    cdo35 = this.ebT.ebe;
                                                                    cdo35.aJw().setTag(sparseArray10);
                                                                    cdo36 = this.ebT.ebe;
                                                                    cdo36.aJy().setTag(sparseArray10);
                                                                    cdo37 = this.ebT.ebe;
                                                                    cdo37.aJw().setText(u.j.bar_manager);
                                                                    cdo38 = this.ebT.ebe;
                                                                    cdo38.aJw().setVisibility(0);
                                                                } else if (!booleanValue6) {
                                                                    cdo15 = this.ebT.ebe;
                                                                    cdo15.aJw().setVisibility(8);
                                                                    cdo16 = this.ebT.ebe;
                                                                    cdo16.aJy().setVisibility(8);
                                                                } else {
                                                                    SparseArray sparseArray11 = new SparseArray();
                                                                    sparseArray11.put(u.g.tag_should_manage_visible, false);
                                                                    sparseArray11.put(u.g.tag_user_mute_visible, false);
                                                                    sparseArray11.put(u.g.tag_should_delete_visible, true);
                                                                    sparseArray11.put(u.g.tag_manage_user_identity, sparseArray2.get(u.g.tag_manage_user_identity));
                                                                    sparseArray11.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                    sparseArray11.put(u.g.tag_del_post_id, sparseArray2.get(u.g.tag_del_post_id));
                                                                    sparseArray11.put(u.g.tag_del_post_type, sparseArray2.get(u.g.tag_del_post_type));
                                                                    cdo17 = this.ebT.ebe;
                                                                    cdo17.aJw().setTag(sparseArray11);
                                                                    cdo18 = this.ebT.ebe;
                                                                    cdo18.aJy().setTag(sparseArray11);
                                                                    cdo19 = this.ebT.ebe;
                                                                    cdo19.aJw().setText(u.j.delete);
                                                                    cdo20 = this.ebT.ebe;
                                                                    cdo20.aJy().setVisibility(0);
                                                                    cdo21 = this.ebT.ebe;
                                                                    cdo21.aJw().setVisibility(8);
                                                                }
                                                                sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3.get(u.g.tag_user_mute_visible) instanceof Boolean) {
                                                                    z4 = false;
                                                                } else {
                                                                    z4 = ((Boolean) sparseArray3.get(u.g.tag_user_mute_visible)).booleanValue();
                                                                }
                                                                if (((Boolean) sparseArray3.get(u.g.tag_should_manage_visible)).booleanValue() && z4) {
                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                    sparseArray12.put(u.g.tag_user_mute_visible, true);
                                                                    sparseArray12.put(u.g.tag_is_mem, sparseArray3.get(u.g.tag_is_mem));
                                                                    sparseArray12.put(u.g.tag_user_mute_mute_userid, sparseArray3.get(u.g.tag_user_mute_mute_userid));
                                                                    sparseArray12.put(u.g.tag_user_mute_mute_username, sparseArray3.get(u.g.tag_user_mute_mute_username));
                                                                    sparseArray12.put(u.g.tag_user_mute_post_id, sparseArray3.get(u.g.tag_user_mute_post_id));
                                                                    sparseArray12.put(u.g.tag_user_mute_thread_id, sparseArray3.get(u.g.tag_user_mute_thread_id));
                                                                    sparseArray12.put(u.g.tag_del_post_is_self, sparseArray3.get(u.g.tag_del_post_is_self));
                                                                    sparseArray12.put(u.g.tag_del_post_type, sparseArray3.get(u.g.tag_del_post_type));
                                                                    sparseArray12.put(u.g.tag_del_post_id, sparseArray3.get(u.g.tag_del_post_id));
                                                                    sparseArray12.put(u.g.tag_manage_user_identity, sparseArray3.get(u.g.tag_manage_user_identity));
                                                                    cdo30 = this.ebT.ebe;
                                                                    cdo30.aJx().setTag(sparseArray12);
                                                                    cdo31 = this.ebT.ebe;
                                                                    cdo31.aJx().setVisibility(0);
                                                                    cdo32 = this.ebT.ebe;
                                                                    cdo32.aJw().setVisibility(8);
                                                                    cdo33 = this.ebT.ebe;
                                                                    cdo33.aJx().setText(u.j.mute_option);
                                                                } else {
                                                                    if (sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                                        z5 = false;
                                                                    } else {
                                                                        z5 = ((Boolean) sparseArray3.get(u.g.tag_del_post_is_self)).booleanValue();
                                                                    }
                                                                    String str7 = null;
                                                                    if (sparseArray3.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                                        str7 = (String) sparseArray3.get(u.g.tag_forbid_user_post_id);
                                                                    }
                                                                    hA = this.ebT.hA(z5);
                                                                    isLogin = hA & this.ebT.isLogin();
                                                                    this.ebT.ebK = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(u.g.tag_clip_board);
                                                                    if (!(!ev.g(this.ebT.ebK) ? false : isLogin)) {
                                                                        cdo23 = this.ebT.ebe;
                                                                        cdo23.aJx().setVisibility(0);
                                                                        cdo24 = this.ebT.ebe;
                                                                        cdo24.aJx().setTag(str7);
                                                                    } else {
                                                                        cdo22 = this.ebT.ebe;
                                                                        cdo22.aJx().setVisibility(8);
                                                                    }
                                                                }
                                                                sparseArray4 = (SparseArray) view.getTag();
                                                                long j2 = 0;
                                                                if (sparseArray4.get(u.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = ((Boolean) sparseArray4.get(u.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                }
                                                                if (sparseArray4.get(u.g.tag_chudian_template_id) instanceof Long) {
                                                                    j2 = ((Long) sparseArray4.get(u.g.tag_chudian_template_id)).longValue();
                                                                }
                                                                if (sparseArray4.get(u.g.tag_chudian_monitor_id) instanceof String) {
                                                                    str = "";
                                                                } else {
                                                                    str = (String) sparseArray4.get(u.g.tag_chudian_monitor_id);
                                                                }
                                                                if (sparseArray4.get(u.g.tag_chudian_hide_day) instanceof Integer) {
                                                                    i = 0;
                                                                } else {
                                                                    i = ((Integer) sparseArray4.get(u.g.tag_chudian_hide_day)).intValue();
                                                                }
                                                                if (!z6) {
                                                                    cdo26 = this.ebT.ebe;
                                                                    cdo26.aJz().setVisibility(0);
                                                                    cdo27 = this.ebT.ebe;
                                                                    cdo27.aJz().setTag(u.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                    cdo28 = this.ebT.ebe;
                                                                    cdo28.aJz().setTag(u.g.tag_chudian_monitor_id, str);
                                                                    cdo29 = this.ebT.ebe;
                                                                    cdo29.aJz().setTag(u.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                } else {
                                                                    cdo25 = this.ebT.ebe;
                                                                    cdo25.aJz().setVisibility(8);
                                                                }
                                                            }
                                                        }
                                                        cdo13 = this.ebT.ebe;
                                                        cdo13.aJC();
                                                        sparseArray = (SparseArray) view.getTag();
                                                        if (sparseArray.get(u.g.tag_pb_floor_postion) instanceof Integer) {
                                                        }
                                                        SparseArray sparseArray92 = new SparseArray();
                                                        sparseArray92.put(u.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(u.g.tag_clip_board));
                                                        sparseArray92.put(u.g.tag_is_subpb, false);
                                                        cdo14 = this.ebT.ebe;
                                                        cdo14.aJv().setTag(sparseArray92);
                                                        sparseArray2 = (SparseArray) view.getTag();
                                                        booleanValue = ((Boolean) sparseArray2.get(u.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue52 = ((Boolean) sparseArray2.get(u.g.tag_user_mute_visible)).booleanValue();
                                                        boolean booleanValue62 = ((Boolean) sparseArray2.get(u.g.tag_should_delete_visible)).booleanValue();
                                                        if (sparseArray2.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str62 = null;
                                                        if (sparseArray2.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        if (!booleanValue) {
                                                        }
                                                        sparseArray3 = (SparseArray) view.getTag();
                                                        if (sparseArray3.get(u.g.tag_user_mute_visible) instanceof Boolean) {
                                                        }
                                                        if (((Boolean) sparseArray3.get(u.g.tag_should_manage_visible)).booleanValue()) {
                                                        }
                                                        if (sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str72 = null;
                                                        if (sparseArray3.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        hA = this.ebT.hA(z5);
                                                        isLogin = hA & this.ebT.isLogin();
                                                        this.ebT.ebK = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(u.g.tag_clip_board);
                                                        if (!(!ev.g(this.ebT.ebK) ? false : isLogin)) {
                                                        }
                                                        sparseArray4 = (SparseArray) view.getTag();
                                                        long j22 = 0;
                                                        if (sparseArray4.get(u.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                        }
                                                        if (sparseArray4.get(u.g.tag_chudian_template_id) instanceof Long) {
                                                        }
                                                        if (sparseArray4.get(u.g.tag_chudian_monitor_id) instanceof String) {
                                                        }
                                                        if (sparseArray4.get(u.g.tag_chudian_hide_day) instanceof Integer) {
                                                        }
                                                        if (!z6) {
                                                        }
                                                    }
                                                    dhVar59 = this.ebT.eas;
                                                    if (dhVar59.getPbData().mA()) {
                                                        dhVar60 = this.ebT.eas;
                                                        String mz = dhVar60.getPbData().mz();
                                                        if (sVar != null && !com.baidu.adp.lib.util.j.isEmpty(mz) && mz.equals(sVar.getId())) {
                                                            z2 = true;
                                                            if (!z2) {
                                                                cdo12 = this.ebT.ebe;
                                                                cdo12.aJv().setText(u.j.remove_mark);
                                                            } else {
                                                                cdo9 = this.ebT.ebe;
                                                                cdo9.aJv().setText(u.j.mark);
                                                            }
                                                            cdo10 = this.ebT.ebe;
                                                            cdo10.hM(true);
                                                            cdo11 = this.ebT.ebe;
                                                            cdo11.uP();
                                                            return;
                                                        }
                                                    }
                                                    z2 = false;
                                                    if (!z2) {
                                                    }
                                                    cdo10 = this.ebT.ebe;
                                                    cdo10.hM(true);
                                                    cdo11 = this.ebT.ebe;
                                                    cdo11.uP();
                                                    return;
                                                } else if (id != u.g.pb_head_reverse_hint) {
                                                    if (id == u.g.pb_act_btn) {
                                                        dhVar52 = this.ebT.eas;
                                                        if (dhVar52.getPbData() != null) {
                                                            dhVar53 = this.ebT.eas;
                                                            if (dhVar53.getPbData().aGY() != null) {
                                                                dhVar54 = this.ebT.eas;
                                                                if (dhVar54.getPbData().aGY().rb() != null) {
                                                                    Activity activity = this.ebT.getActivity();
                                                                    dhVar55 = this.ebT.eas;
                                                                    com.baidu.tbadk.browser.f.u(activity, dhVar55.getPbData().aGY().rb());
                                                                    dhVar56 = this.ebT.eas;
                                                                    if (dhVar56.getPbData().aGY().qZ() != 1) {
                                                                        dhVar57 = this.ebT.eas;
                                                                        if (dhVar57.getPbData().aGY().qZ() == 2) {
                                                                            TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == u.g.lottery_tail) {
                                                        if (view.getTag(u.g.tag_pb_lottery_tail_link) instanceof String) {
                                                            String str8 = (String) view.getTag(u.g.tag_pb_lottery_tail_link);
                                                            com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c10912");
                                                            dhVar49 = this.ebT.eas;
                                                            com.baidu.tbadk.core.util.ay ab = ayVar2.ab("fid", dhVar49.getPbData().getForumId());
                                                            dhVar50 = this.ebT.eas;
                                                            TiebaStatic.log(ab.ab("tid", dhVar50.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                            dhVar51 = this.ebT.eas;
                                                            if (dhVar51.getPbData().getThreadId().equals(str8)) {
                                                                ewVar44 = this.ebT.ebb;
                                                                ewVar44.setSelection(0);
                                                                return;
                                                            }
                                                            this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ebT.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == u.g.pb_item_tail_content) {
                                                        if (com.baidu.tbadk.core.util.bn.ab(this.ebT.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.m10getInst().getString(u.j.tail_web_view_title);
                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.sN().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                            }
                                                            ewVar43 = this.ebT.ebb;
                                                            ewVar43.aKg();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == u.g.join_vote_tv) {
                                                        if (view != null) {
                                                            com.baidu.tbadk.browser.f.u(this.ebT.getActivity(), (String) view.getTag());
                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                            aHT3 = this.ebT.aHT();
                                                            if (aHT3 == 1) {
                                                                dhVar45 = this.ebT.eas;
                                                                if (dhVar45 != null) {
                                                                    dhVar46 = this.ebT.eas;
                                                                    if (dhVar46.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c10397");
                                                                        dhVar47 = this.ebT.eas;
                                                                        com.baidu.tbadk.core.util.ay ab2 = ayVar3.ab("fid", dhVar47.getPbData().getForumId());
                                                                        dhVar48 = this.ebT.eas;
                                                                        TiebaStatic.log(ab2.ab("tid", dhVar48.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aHT4 = this.ebT.aHT();
                                                            if (aHT4 == 2) {
                                                                dhVar41 = this.ebT.eas;
                                                                if (dhVar41 != null) {
                                                                    dhVar42 = this.ebT.eas;
                                                                    if (dhVar42.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar4 = new com.baidu.tbadk.core.util.ay("c10401");
                                                                        dhVar43 = this.ebT.eas;
                                                                        com.baidu.tbadk.core.util.ay ab3 = ayVar4.ab("fid", dhVar43.getPbData().getForumId());
                                                                        dhVar44 = this.ebT.eas;
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
                                                    } else if (id == u.g.look_all_tv) {
                                                        if (view != null) {
                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                            com.baidu.tbadk.browser.f.u(this.ebT.getActivity(), (String) view.getTag());
                                                            aHT = this.ebT.aHT();
                                                            if (aHT == 1) {
                                                                dhVar37 = this.ebT.eas;
                                                                if (dhVar37 != null) {
                                                                    dhVar38 = this.ebT.eas;
                                                                    if (dhVar38.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar5 = new com.baidu.tbadk.core.util.ay("c10507");
                                                                        dhVar39 = this.ebT.eas;
                                                                        com.baidu.tbadk.core.util.ay ab4 = ayVar5.ab("fid", dhVar39.getPbData().getForumId());
                                                                        dhVar40 = this.ebT.eas;
                                                                        TiebaStatic.log(ab4.ab("tid", dhVar40.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aHT2 = this.ebT.aHT();
                                                            if (aHT2 == 2) {
                                                                dhVar33 = this.ebT.eas;
                                                                if (dhVar33 != null) {
                                                                    dhVar34 = this.ebT.eas;
                                                                    if (dhVar34.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar6 = new com.baidu.tbadk.core.util.ay("c10508");
                                                                        dhVar35 = this.ebT.eas;
                                                                        com.baidu.tbadk.core.util.ay ab5 = ayVar6.ab("fid", dhVar35.getPbData().getForumId());
                                                                        dhVar36 = this.ebT.eas;
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
                                                    } else if (id != u.g.manga_prev_btn) {
                                                        if (id != u.g.manga_next_btn) {
                                                            if (id == u.g.pb_ecomm_like_button) {
                                                                dhVar27 = this.ebT.eas;
                                                                if (dhVar27 != null) {
                                                                    dhVar29 = this.ebT.eas;
                                                                    if (dhVar29.getPbData() != null) {
                                                                        dhVar30 = this.ebT.eas;
                                                                        if (dhVar30.getPbData().aGY() != null) {
                                                                            dhVar31 = this.ebT.eas;
                                                                            if (dhVar31.getPbData().aGY().RO != null) {
                                                                                if (com.baidu.tbadk.core.util.bn.ab(this.ebT.getPageContext().getPageActivity())) {
                                                                                    dhVar32 = this.ebT.eas;
                                                                                    DealInfoData dealInfoData = dhVar32.getPbData().aGY().RO;
                                                                                    long j3 = dealInfoData.productId;
                                                                                    if (dealInfoData.hasRecommend) {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, false);
                                                                                    } else {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, true);
                                                                                    }
                                                                                    this.ebT.sendMessage(pbEcommRecommendMessage);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ay ayVar7 = new com.baidu.tbadk.core.util.ay("c11428");
                                                                ayVar7.s("obj_param1", 1);
                                                                dhVar28 = this.ebT.eas;
                                                                ayVar7.ab("obj_id", new StringBuilder(String.valueOf(dhVar28.getPbData().aGY().RO.productId)).toString());
                                                                ayVar7.s("obj_locate", 3);
                                                                if (ayVar7 != null) {
                                                                    TiebaStatic.log(ayVar7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id == u.g.pb_editor_tool_comment_ecomm_buy_layout) {
                                                                dhVar19 = this.ebT.eas;
                                                                if (dhVar19 != null) {
                                                                    dhVar21 = this.ebT.eas;
                                                                    if (dhVar21.getPbData() != null) {
                                                                        dhVar22 = this.ebT.eas;
                                                                        if (dhVar22.getPbData().aGY() != null) {
                                                                            dhVar23 = this.ebT.eas;
                                                                            if (dhVar23.getPbData().aGY().RO != null) {
                                                                                if (com.baidu.tbadk.core.util.bn.ab(this.ebT.getPageContext().getPageActivity())) {
                                                                                    dhVar24 = this.ebT.eas;
                                                                                    long j4 = dhVar24.getPbData().aGY().RO.productId;
                                                                                    dhVar25 = this.ebT.eas;
                                                                                    String threadID = dhVar25.getThreadID();
                                                                                    dhVar26 = this.ebT.eas;
                                                                                    String name2 = dhVar26.getPbData().aGX().getName();
                                                                                    EcommEnsureOrderActivityConfig ecommEnsureOrderActivityConfig = new EcommEnsureOrderActivityConfig(this.ebT.getPageContext().getPageActivity(), j4, threadID);
                                                                                    ecommEnsureOrderActivityConfig.setForumName(name2);
                                                                                    this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommEnsureOrderActivityConfig));
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ay ayVar8 = new com.baidu.tbadk.core.util.ay("c11428");
                                                                ayVar8.s("obj_param1", 1);
                                                                dhVar20 = this.ebT.eas;
                                                                ayVar8.ab("obj_id", new StringBuilder(String.valueOf(dhVar20.getPbData().aGY().RO.productId)).toString());
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
                                                        this.ebT.aIi();
                                                        return;
                                                    } else {
                                                        this.ebT.aIh();
                                                        return;
                                                    }
                                                } else {
                                                    this.ebT.VR();
                                                    ewVar45 = this.ebT.ebb;
                                                    ewVar45.avR();
                                                    ewVar46 = this.ebT.ebb;
                                                    ewVar46.aKy();
                                                    dhVar58 = this.ebT.eas;
                                                    dhVar58.aJg();
                                                    this.ebT.nA(2);
                                                    this.ebT.aIl();
                                                    return;
                                                }
                                            } else if (this.ebT.checkUpIsLogin()) {
                                                dhVar5 = this.ebT.eas;
                                                if (dhVar5.getPbData() != null) {
                                                    ewVar41 = this.ebT.ebb;
                                                    ewVar41.avR();
                                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) sparseArray13.get(u.g.tag_load_sub_data);
                                                    View view2 = (View) sparseArray13.get(u.g.tag_load_sub_view);
                                                    if (sVar2 != null && view2 != null) {
                                                        dhVar6 = this.ebT.eas;
                                                        String threadID2 = dhVar6.getThreadID();
                                                        String id2 = sVar2.getId();
                                                        int i4 = 0;
                                                        dhVar7 = this.ebT.eas;
                                                        if (dhVar7.getPbData() != null) {
                                                            dhVar17 = this.ebT.eas;
                                                            i4 = dhVar17.getPbData().aHf();
                                                        }
                                                        this.ebT.VR();
                                                        if (view.getId() != u.g.replybtn) {
                                                            if (view.getId() == u.g.sub_pb_item) {
                                                                SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                                String str9 = (String) sparseArray14.get(u.g.tag_photo_username);
                                                                com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) sparseArray14.get(u.g.tag_clip_board);
                                                                String str10 = null;
                                                                if (sVar3 != null) {
                                                                    str10 = sVar3.getId();
                                                                }
                                                                TiebaStatic.log("c10088");
                                                                oi2 = this.ebT.oi(id2);
                                                                if (sVar2 != null) {
                                                                    dhVar11 = this.ebT.eas;
                                                                    if (dhVar11 != null) {
                                                                        dhVar12 = this.ebT.eas;
                                                                        if (dhVar12.getPbData() != null && oi2 != null) {
                                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.ebT.getPageContext().getPageActivity());
                                                                            SmallTailInfo aMg = sVar2.aMg();
                                                                            dhVar13 = this.ebT.eas;
                                                                            this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID2, id2, "pb", true, str9, true, str10, i4, aMg, dhVar13.getPbData().pc(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(oi2.ech, oi2.eci, oi2.ecj, oi2.index)));
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.log("c10089");
                                                            oi = this.ebT.oi(id2);
                                                            if (sVar2 != null) {
                                                                dhVar8 = this.ebT.eas;
                                                                if (dhVar8 != null) {
                                                                    dhVar9 = this.ebT.eas;
                                                                    if (dhVar9.getPbData() != null && oi != null) {
                                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.ebT.getPageContext().getPageActivity());
                                                                        SmallTailInfo aMg2 = sVar2.aMg();
                                                                        dhVar10 = this.ebT.eas;
                                                                        this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id2, "pb", true, null, false, null, i4, aMg2, dhVar10.getPbData().pc(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(oi.ech, oi.eci, oi.ecj, oi.index)));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        oi3 = this.ebT.oi(id2);
                                                        if (sVar2 != null) {
                                                            dhVar14 = this.ebT.eas;
                                                            if (dhVar14 != null) {
                                                                dhVar15 = this.ebT.eas;
                                                                if (dhVar15.getPbData() != null && oi3 != null) {
                                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.ebT.getPageContext().getPageActivity());
                                                                    SmallTailInfo aMg3 = sVar2.aMg();
                                                                    dhVar16 = this.ebT.eas;
                                                                    this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id2, "pb", true, null, true, null, i4, aMg3, dhVar16.getPbData().pc(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(oi3.ech, oi3.eci, oi3.ecj, oi3.index)));
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
                                                dhVar18 = this.ebT.eas;
                                                TiebaStatic.log(s.ab("fid", dhVar18.getPbData().getForumId()));
                                                return;
                                            }
                                        } else if (!this.ebT.checkUpIsLogin()) {
                                            com.baidu.tbadk.core.util.ay s2 = new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 2);
                                            dhVar69 = this.ebT.eas;
                                            TiebaStatic.log(s2.ab("fid", dhVar69.getPbData().getForumId()));
                                            return;
                                        } else {
                                            this.ebT.aHK();
                                            return;
                                        }
                                    } else if (this.ebT.checkUpIsLogin()) {
                                        ewVar74 = this.ebT.ebb;
                                        ewVar74.avR();
                                        this.ebT.VR();
                                        this.ebT.nA(2);
                                        this.ebT.abq();
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.i.fq()) {
                                    ewVar22 = this.ebT.ebb;
                                    ewVar22.aKg();
                                    z = this.ebT.mIsLoading;
                                    if (!z) {
                                        this.ebT.mIsLoading = true;
                                        ewVar23 = this.ebT.ebb;
                                        ewVar23.efS.eiW.setEnabled(false);
                                        ewVar24 = this.ebT.ebb;
                                        ewVar24.app();
                                        this.ebT.VR();
                                        ewVar25 = this.ebT.ebb;
                                        ewVar25.aKy();
                                        dhVar4 = this.ebT.eas;
                                        aIf = this.ebT.aIf();
                                        dhVar4.ol(aIf);
                                        TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        ewVar26 = this.ebT.ebb;
                                        ewVar26.aKX();
                                        ewVar27 = this.ebT.ebb;
                                        ewVar27.aIR();
                                        this.ebT.nA(2);
                                        return;
                                    }
                                    return;
                                } else {
                                    this.ebT.showToast(u.j.network_not_available);
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            dhVar97 = this.ebT.eas;
                            if (dhVar97.getErrorNo() == 4) {
                                dhVar100 = this.ebT.eas;
                                if (StringUtils.isNull(dhVar100.aIW())) {
                                    dhVar101 = this.ebT.eas;
                                    if (dhVar101.getAppealInfo() != null) {
                                        dhVar102 = this.ebT.eas;
                                        name = dhVar102.getAppealInfo().forumName;
                                    }
                                }
                                this.ebT.finish();
                                return;
                            }
                            dhVar98 = this.ebT.eas;
                            name = dhVar98.getPbData().aGX().getName();
                            if (!StringUtils.isNull(name)) {
                                dhVar99 = this.ebT.eas;
                                String aIW = dhVar99.aIW();
                                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.ebT.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (StringUtils.isNull(aIW)) {
                                    this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                } else if (aIW.equals(name)) {
                                    this.ebT.finish();
                                    return;
                                } else {
                                    this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                }
                            }
                            this.ebT.finish();
                            return;
                        }
                    }
                }
            }
        }
        ewVar6 = this.ebT.ebb;
        ewVar6.aKR();
        dhVar = this.ebT.eas;
        if (dhVar.getPbData().aHf() == 1) {
            aVar = this.ebT.eba;
            if (!aVar.bgr()) {
                ewVar7 = this.ebT.ebb;
                ewVar7.aKv();
                int i5 = 0;
                ewVar8 = this.ebT.ebb;
                if (view != ewVar8.aKM()) {
                    ewVar9 = this.ebT.ebb;
                    if (view != ewVar9.aKN()) {
                        ewVar10 = this.ebT.ebb;
                        if (view != ewVar10.aKO()) {
                            ewVar11 = this.ebT.ebb;
                            if (view != ewVar11.aKP()) {
                                ewVar12 = this.ebT.ebb;
                                if (view == ewVar12.aKw()) {
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
                dhVar2 = this.ebT.eas;
                ForumData aGX2 = dhVar2.getPbData().aGX();
                String name3 = aGX2.getName();
                String id3 = aGX2.getId();
                dhVar3 = this.ebT.eas;
                String id4 = dhVar3.getPbData().aGY().getId();
                aVar2 = this.ebT.eba;
                ewVar13 = this.ebT.ebb;
                aVar2.a(id3, name3, id4, i5, ewVar13.aKx());
            }
        }
    }
}
