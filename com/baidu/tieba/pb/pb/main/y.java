package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v130, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v134, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v171, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0700, code lost:
        if (r18 == r1.eeG.aMG().Oi()) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02a4, code lost:
        if (r18 == r1.eeG.aMG().aLe()) goto L775;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:478:0x15c4  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x167f  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x1697  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x16a1  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x1799  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x187f  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x1896  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x18ac  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x18be  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x18cc  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x194f  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x19af  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x1a7f  */
    /* JADX WARN: Removed duplicated region for block: B:536:0x1a97  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x1aca  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x1acd  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x1aee  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x1b01  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x1b14  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x1fa8  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x1fab  */
    /* JADX WARN: Removed duplicated region for block: B:636:0x1fae  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x1fb1  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x1fb4  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x1fb7  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x1fba  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        er erVar;
        er erVar2;
        er erVar3;
        er erVar4;
        er erVar5;
        dc dcVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        er erVar6;
        er erVar7;
        er erVar8;
        er erVar9;
        dc dcVar2;
        dc dcVar3;
        dc dcVar4;
        er erVar10;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        er erVar11;
        dc dcVar5;
        er erVar12;
        er erVar13;
        er erVar14;
        er erVar15;
        er erVar16;
        er erVar17;
        boolean z;
        er erVar18;
        er erVar19;
        er erVar20;
        dc dcVar6;
        String aJt;
        er erVar21;
        er erVar22;
        er erVar23;
        er erVar24;
        er erVar25;
        er erVar26;
        er erVar27;
        er erVar28;
        er erVar29;
        er erVar30;
        dj djVar;
        dj djVar2;
        dj djVar3;
        dj djVar4;
        dj djVar5;
        dj djVar6;
        er erVar31;
        er erVar32;
        dj djVar7;
        er erVar33;
        er erVar34;
        er erVar35;
        dc dcVar7;
        er erVar36;
        dc dcVar8;
        dc dcVar9;
        PbActivity.b nU;
        dc dcVar10;
        dc dcVar11;
        dc dcVar12;
        PbActivity.b nU2;
        dc dcVar13;
        dc dcVar14;
        dc dcVar15;
        dc dcVar16;
        PbActivity.b nU3;
        dc dcVar17;
        dc dcVar18;
        dc dcVar19;
        dc dcVar20;
        dc dcVar21;
        er erVar37;
        dj djVar8;
        dj djVar9;
        dc dcVar22;
        boolean z2;
        dj djVar10;
        dj djVar11;
        dj djVar12;
        dj djVar13;
        dc dcVar23;
        dj djVar14;
        SparseArray sparseArray;
        dj djVar15;
        dj djVar16;
        SparseArray sparseArray2;
        boolean booleanValue;
        boolean z3;
        dj djVar17;
        dj djVar18;
        dj djVar19;
        dj djVar20;
        dj djVar21;
        dj djVar22;
        dj djVar23;
        SparseArray sparseArray3;
        boolean z4;
        boolean z5;
        boolean id;
        boolean isLogin;
        dj djVar24;
        dj djVar25;
        dj djVar26;
        SparseArray sparseArray4;
        boolean z6;
        String str;
        int i;
        dj djVar27;
        dj djVar28;
        dj djVar29;
        dj djVar30;
        dj djVar31;
        dj djVar32;
        dj djVar33;
        dj djVar34;
        dj djVar35;
        dj djVar36;
        dj djVar37;
        dj djVar38;
        dj djVar39;
        dj djVar40;
        dj djVar41;
        dj djVar42;
        dj djVar43;
        dc dcVar24;
        dj djVar44;
        dj djVar45;
        boolean z7;
        dc dcVar25;
        dc dcVar26;
        dc dcVar27;
        dc dcVar28;
        dc dcVar29;
        dc dcVar30;
        dc dcVar31;
        dc dcVar32;
        int aJh;
        int aJh2;
        dc dcVar33;
        dc dcVar34;
        dc dcVar35;
        dc dcVar36;
        dc dcVar37;
        dc dcVar38;
        dc dcVar39;
        dc dcVar40;
        int aJh3;
        int aJh4;
        dc dcVar41;
        dc dcVar42;
        dc dcVar43;
        dc dcVar44;
        dc dcVar45;
        dc dcVar46;
        dc dcVar47;
        dc dcVar48;
        er erVar38;
        dc dcVar49;
        dc dcVar50;
        dc dcVar51;
        er erVar39;
        dc dcVar52;
        dc dcVar53;
        dc dcVar54;
        dc dcVar55;
        dc dcVar56;
        dc dcVar57;
        com.baidu.tbadk.core.data.bm bmVar;
        dc dcVar58;
        dc dcVar59;
        dc dcVar60;
        er erVar40;
        er erVar41;
        dc dcVar61;
        dc dcVar62;
        er erVar42;
        er erVar43;
        er erVar44;
        er erVar45;
        er erVar46;
        dc dcVar63;
        dc dcVar64;
        dc dcVar65;
        dc dcVar66;
        dc dcVar67;
        dc dcVar68;
        er erVar47;
        dc dcVar69;
        dc dcVar70;
        dc dcVar71;
        dc dcVar72;
        er erVar48;
        er erVar49;
        dj djVar46;
        er erVar50;
        er erVar51;
        dc dcVar73;
        dc dcVar74;
        er erVar52;
        dc dcVar75;
        dj djVar47;
        dc dcVar76;
        dj djVar48;
        er erVar53;
        dc dcVar77;
        dj djVar49;
        dc dcVar78;
        er erVar54;
        dc dcVar79;
        dj djVar50;
        dc dcVar80;
        er erVar55;
        SparseArray sparseArray5;
        com.baidu.tieba.tbadkCore.data.q qVar;
        dc dcVar81;
        dc dcVar82;
        PbActivity.b nU4;
        dc dcVar83;
        dc dcVar84;
        dj djVar51;
        dj djVar52;
        er erVar56;
        String aJg;
        er erVar57;
        er erVar58;
        er erVar59;
        er erVar60;
        er erVar61;
        dc dcVar85;
        dc dcVar86;
        er erVar62;
        er erVar63;
        dc dcVar87;
        dc dcVar88;
        dc dcVar89;
        er erVar64;
        dc dcVar90;
        er erVar65;
        er erVar66;
        er erVar67;
        dc dcVar91;
        er erVar68;
        er erVar69;
        dc dcVar92;
        er erVar70;
        dc dcVar93;
        er erVar71;
        er erVar72;
        dc dcVar94;
        dc dcVar95;
        dc dcVar96;
        dc dcVar97;
        dc dcVar98;
        er erVar73;
        er erVar74;
        er erVar75;
        er erVar76;
        er erVar77;
        boolean ny;
        dc dcVar99;
        er erVar78;
        dc dcVar100;
        dc dcVar101;
        dc dcVar102;
        dc dcVar103;
        er erVar79;
        er erVar80;
        dc dcVar104;
        dc dcVar105;
        String name;
        dc dcVar106;
        dc dcVar107;
        dc dcVar108;
        dc dcVar109;
        dc dcVar110;
        dc dcVar111;
        er erVar81;
        er erVar82;
        er erVar83;
        dc dcVar112;
        er erVar84;
        er erVar85;
        er erVar86;
        er erVar87;
        dc dcVar113;
        er erVar88;
        er erVar89;
        dc dcVar114;
        dc dcVar115;
        er erVar90;
        dc dcVar116;
        er erVar91;
        boolean z8;
        dc dcVar117;
        dc dcVar118;
        dc dcVar119;
        dc dcVar120;
        if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
            erVar = this.eah.dZk;
            if (view == erVar.getNextView()) {
                dcVar116 = this.eah.dYA;
                if (dcVar116.ik(true)) {
                    erVar91 = this.eah.dZk;
                    erVar91.aLV();
                    return;
                }
                return;
            }
            erVar2 = this.eah.dZk;
            if (erVar2.eeG.aMG() != null) {
                erVar88 = this.eah.dZk;
                if (view == erVar88.eeG.aMG().aLc()) {
                    erVar89 = this.eah.dZk;
                    erVar89.aLN();
                    if (UtilHelper.isFloatWindowOpAllowed(this.eah.getPageContext().getPageActivity())) {
                        this.eah.dZq = true;
                        PbActivity pbActivity = this.eah;
                        dcVar114 = this.eah.dYA;
                        pbActivity.a(dcVar114.getPbData(), 0, 1, true, true);
                        com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c10830");
                        dcVar115 = this.eah.dYA;
                        TiebaStatic.log(atVar.ab("tid", dcVar115.getThreadID()));
                        erVar90 = this.eah.dZk;
                        erVar90.awl();
                        return;
                    }
                    this.eah.aJf();
                    return;
                }
            }
            erVar3 = this.eah.dZk;
            if (erVar3.eeG.aMG() != null) {
                erVar84 = this.eah.dZk;
                if (view == erVar84.eeG.aMG().aLh()) {
                    if (com.baidu.adp.lib.util.i.gm()) {
                        erVar85 = this.eah.dZk;
                        erVar85.awl();
                        this.eah.WD();
                        erVar86 = this.eah.dZk;
                        erVar86.aLU();
                        erVar87 = this.eah.dZk;
                        erVar87.aub();
                        dcVar113 = this.eah.dYA;
                        dcVar113.nE(1);
                        return;
                    }
                    this.eah.showToast(r.j.network_not_available);
                    return;
                }
            }
            erVar4 = this.eah.dZk;
            if (view == erVar4.eeG.aDT) {
                erVar83 = this.eah.dZk;
                dcVar112 = this.eah.dYA;
                if (!erVar83.iK(dcVar112.aKp())) {
                    this.eah.dYT = false;
                    this.eah.finish();
                    return;
                }
                this.eah.WD();
                return;
            }
            erVar5 = this.eah.dZk;
            if (view != erVar5.aLS()) {
                erVar12 = this.eah.dZk;
                if (erVar12.eeG.aMG() != null) {
                    erVar81 = this.eah.dZk;
                    if (view != erVar81.eeG.aMG().aLg()) {
                        erVar82 = this.eah.dZk;
                    }
                }
                erVar13 = this.eah.dZk;
                if (view == erVar13.aMh()) {
                    dcVar110 = this.eah.dYA;
                    if (dcVar110 != null) {
                        dcVar111 = this.eah.dYA;
                        com.baidu.tbadk.browser.f.u(this.eah.getPageContext().getPageActivity(), dcVar111.getPbData().aIl().rE().getLink());
                        return;
                    }
                    return;
                }
                erVar14 = this.eah.dZk;
                if (view != erVar14.eeG.ehI) {
                    erVar15 = this.eah.dZk;
                    if (view == erVar15.eeG.ehK) {
                        dcVar100 = this.eah.dYA;
                        if (dcVar100 != null) {
                            dcVar101 = this.eah.dYA;
                            if (dcVar101.getPbData() != null) {
                                dcVar102 = this.eah.dYA;
                                ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = dcVar102.getPbData().aIm();
                                if (aIm == null || aIm.size() <= 0) {
                                    dcVar103 = this.eah.dYA;
                                    if (dcVar103.aKl()) {
                                        com.baidu.adp.lib.util.k.showToast(this.eah.getPageContext().getPageActivity(), this.eah.getPageContext().getString(r.j.pb_no_data_tips));
                                        return;
                                    }
                                }
                                erVar79 = this.eah.dZk;
                                erVar79.aLD();
                                erVar80 = this.eah.dZk;
                                erVar80.aMl();
                                this.eah.aJi();
                                return;
                            }
                        }
                        com.baidu.adp.lib.util.k.showToast(this.eah.getPageContext().getPageActivity(), this.eah.getPageContext().getString(r.j.pb_no_data_tips));
                        return;
                    }
                    erVar16 = this.eah.dZk;
                    if (view != erVar16.eeG.ehJ && view.getId() != r.g.pb_god_user_tip_content) {
                        erVar23 = this.eah.dZk;
                        if (erVar23.eeG.aMG() != null) {
                            erVar76 = this.eah.dZk;
                            if (view == erVar76.eeG.aMG().aKM()) {
                                if (com.baidu.adp.lib.util.i.gm()) {
                                    erVar77 = this.eah.dZk;
                                    erVar77.awl();
                                    ny = this.eah.ny(11009);
                                    if (ny) {
                                        dcVar99 = this.eah.dYA;
                                        erVar78 = this.eah.dZk;
                                        if (dcVar99.nK(erVar78.aLZ()) == null) {
                                            return;
                                        }
                                        this.eah.aJo();
                                        return;
                                    }
                                    return;
                                }
                                this.eah.showToast(r.j.network_not_available);
                                return;
                            }
                        }
                        erVar24 = this.eah.dZk;
                        if (erVar24.eeG.aMG() != null) {
                            erVar73 = this.eah.dZk;
                            if (view != erVar73.eeG.aMG().aLb()) {
                                erVar75 = this.eah.dZk;
                            }
                            erVar74 = this.eah.dZk;
                            erVar74.eeG.od();
                            return;
                        }
                        erVar25 = this.eah.dZk;
                        if (erVar25.eeG.aMG() != null) {
                            erVar71 = this.eah.dZk;
                            if (view == erVar71.eeG.aMG().aLd()) {
                                if (this.eah.checkUpIsLogin()) {
                                    erVar72 = this.eah.dZk;
                                    erVar72.awl();
                                    this.eah.WD();
                                    this.eah.nz(2);
                                    dcVar94 = this.eah.dYA;
                                    if (dcVar94 != null) {
                                        dcVar95 = this.eah.dYA;
                                        if (dcVar95.getPbData() != null) {
                                            dcVar96 = this.eah.dYA;
                                            if (dcVar96.getPbData().aIA() != null) {
                                                dcVar97 = this.eah.dYA;
                                                if (!StringUtils.isNull(dcVar97.getPbData().aIA().pS(), true)) {
                                                    com.baidu.tbadk.core.util.at atVar2 = new com.baidu.tbadk.core.util.at("c11678");
                                                    dcVar98 = this.eah.dYA;
                                                    TiebaStatic.log(atVar2.ab("fid", dcVar98.getPbData().getForumId()));
                                                }
                                            }
                                        }
                                    }
                                    this.eah.acJ();
                                    return;
                                }
                                return;
                            }
                        }
                        erVar26 = this.eah.dZk;
                        if (erVar26.eeG.aMG() != null) {
                            erVar68 = this.eah.dZk;
                            if (view == erVar68.eeG.aMG().aKW()) {
                                erVar69 = this.eah.dZk;
                                erVar69.awl();
                                dcVar92 = this.eah.dYA;
                                if (dcVar92.alG() != null) {
                                    erVar70 = this.eah.dZk;
                                    dcVar93 = this.eah.dYA;
                                    erVar70.a(dcVar93.alG(), this.eah.dJO);
                                }
                                TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                return;
                            }
                        }
                        erVar27 = this.eah.dZk;
                        if (erVar27.eeG.aMG() != null) {
                            erVar65 = this.eah.dZk;
                            if (view == erVar65.eeG.aMG().aKX()) {
                                erVar66 = this.eah.dZk;
                                erVar66.awl();
                                this.eah.nz(2);
                                this.eah.WD();
                                erVar67 = this.eah.dZk;
                                erVar67.aLU();
                                dcVar91 = this.eah.dYA;
                                dcVar91.aKv();
                                TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                return;
                            }
                        }
                        erVar28 = this.eah.dZk;
                        if (erVar28.eeG.aMG() != null) {
                            erVar63 = this.eah.dZk;
                            if (view == erVar63.eeG.aMG().aKY()) {
                                dcVar87 = this.eah.dYA;
                                if (dcVar87 != null) {
                                    dcVar88 = this.eah.dYA;
                                    if (dcVar88.getPbData() != null) {
                                        dcVar89 = this.eah.dYA;
                                        if (dcVar89.getPbData().aIl() != null) {
                                            erVar64 = this.eah.dZk;
                                            erVar64.eeG.od();
                                            PbActivity pbActivity2 = this.eah;
                                            dcVar90 = this.eah.dYA;
                                            pbActivity2.nR(dcVar90.getPbData().aIl().rV());
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        erVar29 = this.eah.dZk;
                        if (erVar29.eeG.aMG() != null) {
                            erVar59 = this.eah.dZk;
                            if (view == erVar59.eeG.aMG().aKZ()) {
                                TiebaStatic.log("c10414");
                                erVar60 = this.eah.dZk;
                                erVar60.awl();
                                erVar61 = this.eah.dZk;
                                if (erVar61.rt() != er.egj) {
                                    dcVar85 = this.eah.dYA;
                                    if (dcVar85.aKJ() != null) {
                                        dcVar86 = this.eah.dYA;
                                        dcVar86.aKJ().nC(dc.ebn);
                                        return;
                                    }
                                    return;
                                }
                                erVar62 = this.eah.dZk;
                                erVar62.aMp();
                                return;
                            }
                        }
                        erVar30 = this.eah.dZk;
                        if (erVar30.eeG.aMG() != null) {
                            erVar56 = this.eah.dZk;
                            if (view == erVar56.eeG.aMG().aLa()) {
                                aJg = this.eah.aJg();
                                this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.eah.getPageContext().getPageActivity(), null, aJg, true)));
                                erVar57 = this.eah.dZk;
                                erVar57.eeG.od();
                                erVar58 = this.eah.dZk;
                                erVar58.eeG.aMG().aLj();
                                return;
                            }
                        }
                        djVar = this.eah.dZp;
                        if (djVar != null) {
                            djVar52 = this.eah.dZp;
                            if (view == djVar52.aKO()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11739").s("obj_locate", 4));
                                if (!com.baidu.adp.lib.util.i.gm()) {
                                    this.eah.showToast(r.j.network_not_available);
                                    return;
                                }
                                Object tag = view.getTag();
                                if (!(tag instanceof String)) {
                                    if (tag instanceof SparseArray) {
                                        SparseArray<Object> sparseArray6 = (SparseArray) tag;
                                        if ((sparseArray6.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(r.g.tag_user_mute_visible)).booleanValue()) {
                                            sparseArray6.put(r.g.tag_from, 0);
                                            sparseArray6.put(r.g.tag_check_mute_from, 2);
                                            this.eah.d(sparseArray6);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                this.eah.nR((String) tag);
                                return;
                            }
                        }
                        djVar2 = this.eah.dZp;
                        if (djVar2 != null) {
                            djVar51 = this.eah.dZp;
                            if (view == djVar51.aKM()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11739").s("obj_locate", 2));
                                if (!this.eah.checkUpIsLogin()) {
                                    return;
                                }
                                this.eah.aS(view);
                                return;
                            }
                        }
                        djVar3 = this.eah.dZp;
                        if (djVar3 != null) {
                            djVar50 = this.eah.dZp;
                            if (view == djVar50.aKR()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11739").s("obj_locate", 1));
                                if (this.eah.checkUpIsLogin()) {
                                    dcVar80 = this.eah.dYA;
                                    if (dcVar80.getPbData() != null) {
                                        erVar55 = this.eah.dZk;
                                        erVar55.awl();
                                        if (!(view.getTag() instanceof SparseArray)) {
                                            sparseArray5 = null;
                                        } else {
                                            sparseArray5 = (SparseArray) view.getTag();
                                        }
                                        if (sparseArray5 == null || !(sparseArray5.get(r.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.q)) {
                                            qVar = null;
                                        } else {
                                            qVar = (com.baidu.tieba.tbadkCore.data.q) sparseArray5.get(r.g.tag_load_sub_data);
                                        }
                                        if (qVar != null) {
                                            dcVar81 = this.eah.dYA;
                                            String threadID = dcVar81.getThreadID();
                                            String id2 = qVar.getId();
                                            int i2 = 0;
                                            dcVar82 = this.eah.dYA;
                                            if (dcVar82.getPbData() != null) {
                                                dcVar84 = this.eah.dYA;
                                                i2 = dcVar84.getPbData().aIu();
                                            }
                                            this.eah.WD();
                                            nU4 = this.eah.nU(id2);
                                            if (nU4 != null) {
                                                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.eah.getPageContext().getPageActivity());
                                                SmallTailInfo aNF = qVar.aNF();
                                                dcVar83 = this.eah.dYA;
                                                this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, aNF, dcVar83.getPbData().qt(), false, qVar.getAuthor().getIconInfo()).addBigImageData(nU4.eay, nU4.eaz, nU4.eaA, nU4.index)));
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
                        }
                        djVar4 = this.eah.dZp;
                        if (djVar4 != null) {
                            djVar49 = this.eah.dZp;
                            if (view == djVar49.aKT()) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11739").s("obj_locate", 3));
                                if (view.getTag(r.g.tag_pb_floor_postion) instanceof Integer) {
                                    dcVar78 = this.eah.dYA;
                                    if (dcVar78 != null) {
                                        erVar54 = this.eah.dZk;
                                        erVar54.aLN();
                                        if (!UtilHelper.isFloatWindowOpAllowed(this.eah.getPageContext().getPageActivity())) {
                                            this.eah.aJf();
                                            return;
                                        }
                                        int intValue = ((Integer) view.getTag(r.g.tag_pb_floor_postion)).intValue();
                                        int intValue2 = ((Integer) view.getTag(r.g.tag_pb_floor_number)).intValue();
                                        this.eah.dZq = true;
                                        PbActivity pbActivity3 = this.eah;
                                        dcVar79 = this.eah.dYA;
                                        pbActivity3.a(dcVar79.getPbData(), intValue, intValue2, true, true);
                                        TiebaStatic.log("c10834");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        djVar5 = this.eah.dZp;
                        if (djVar5 != null) {
                            djVar48 = this.eah.dZp;
                            if (view == djVar48.aKP()) {
                                SparseArray sparseArray7 = (SparseArray) view.getTag();
                                if (sparseArray7 != null && (sparseArray7.get(r.g.tag_del_post_type) instanceof Integer) && (sparseArray7.get(r.g.tag_del_post_id) instanceof String) && (sparseArray7.get(r.g.tag_manage_user_identity) instanceof Integer) && (sparseArray7.get(r.g.tag_del_post_is_self) instanceof Boolean)) {
                                    boolean booleanValue2 = ((Boolean) sparseArray7.get(r.g.tag_del_post_is_self)).booleanValue();
                                    int intValue3 = ((Integer) sparseArray7.get(r.g.tag_manage_user_identity)).intValue();
                                    if (!booleanValue2 && intValue3 != 0 && com.baidu.tieba.c.a.Od()) {
                                        Context baseContext = this.eah.getBaseContext();
                                        dcVar77 = this.eah.dYA;
                                        if (com.baidu.tieba.c.a.f(baseContext, dcVar77.getThreadID(), (String) sparseArray7.get(r.g.tag_del_post_id))) {
                                            return;
                                        }
                                    }
                                    erVar53 = this.eah.dZk;
                                    erVar53.a(((Integer) sparseArray7.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(r.g.tag_del_post_id), intValue3, booleanValue2);
                                    return;
                                }
                                return;
                            }
                        }
                        djVar6 = this.eah.dZp;
                        if (djVar6 != null) {
                            djVar47 = this.eah.dZp;
                            if (view == djVar47.aKQ()) {
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
                                dcVar76 = this.eah.dYA;
                                com.baidu.tieba.pb.data.f pbData = dcVar76.getPbData();
                                String str3 = null;
                                String str4 = null;
                                String str5 = null;
                                if (pbData != null && pbData.aIk() != null) {
                                    str3 = pbData.aIk().getId();
                                    str4 = pbData.aIk().getName();
                                    str5 = pbData.getThreadId();
                                }
                                com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                this.eah.a(j, str2, str3, str4, str5, i3);
                                return;
                            }
                        }
                        erVar31 = this.eah.dZk;
                        if (erVar31.aMq() == view) {
                            erVar52 = this.eah.dZk;
                            if (erVar52.aMq().getIndicateStatus()) {
                                dcVar75 = this.eah.dYA;
                                com.baidu.tieba.pb.data.f pbData2 = dcVar75.getPbData();
                                if (pbData2 != null && pbData2.aIl() != null && pbData2.aIl().ro() != null) {
                                    String pw = pbData2.aIl().ro().pw();
                                    if (StringUtils.isNull(pw)) {
                                        pw = pbData2.aIl().ro().getTaskId();
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11107").ab("obj_id", pw));
                                }
                            } else {
                                com.baidu.tieba.tbadkCore.d.a.bX("c10725", null);
                            }
                            this.eah.aJA();
                            return;
                        }
                        erVar32 = this.eah.dZk;
                        if (erVar32.aLP() != view) {
                            djVar7 = this.eah.dZp;
                            if (djVar7 != null) {
                                djVar46 = this.eah.dZp;
                                if (view == djVar46.aKN()) {
                                    if (!com.baidu.adp.lib.util.i.gm()) {
                                        this.eah.showToast(r.j.network_not_available);
                                        return;
                                    }
                                    SparseArray<Object> sparseArray8 = (SparseArray) view.getTag();
                                    if (sparseArray8 != null) {
                                        if (com.baidu.tieba.c.a.Od() && sparseArray8.get(r.g.tag_del_post_id) != null) {
                                            Context baseContext2 = this.eah.getBaseContext();
                                            dcVar73 = this.eah.dYA;
                                            if (com.baidu.tieba.c.a.f(baseContext2, dcVar73.getThreadID(), (String) sparseArray8.get(r.g.tag_del_post_id))) {
                                                return;
                                            }
                                        }
                                        boolean booleanValue3 = ((Boolean) sparseArray8.get(r.g.tag_should_manage_visible)).booleanValue();
                                        boolean booleanValue4 = ((Boolean) sparseArray8.get(r.g.tag_should_delete_visible)).booleanValue();
                                        boolean booleanValue5 = ((Boolean) sparseArray8.get(r.g.tag_user_mute_visible)).booleanValue();
                                        if (booleanValue3) {
                                            if (booleanValue5) {
                                                sparseArray8.put(r.g.tag_from, 1);
                                                sparseArray8.put(r.g.tag_check_mute_from, 2);
                                                this.eah.d(sparseArray8);
                                                return;
                                            }
                                            sparseArray8.put(r.g.tag_check_mute_from, 2);
                                            erVar51 = this.eah.dZk;
                                            erVar51.aW(view);
                                            return;
                                        } else if (booleanValue4) {
                                            erVar50 = this.eah.dZk;
                                            erVar50.a(((Integer) sparseArray8.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(r.g.tag_del_post_id), ((Integer) sparseArray8.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(r.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                            erVar33 = this.eah.dZk;
                            if (view != erVar33.aKh()) {
                                erVar34 = this.eah.dZk;
                                if (erVar34.eeG.aMG() != null) {
                                    erVar44 = this.eah.dZk;
                                    if (view == erVar44.eeG.aMG().aLi()) {
                                        if (com.baidu.adp.lib.util.i.gm()) {
                                            erVar45 = this.eah.dZk;
                                            erVar45.awl();
                                            erVar46 = this.eah.dZk;
                                            dcVar63 = this.eah.dYA;
                                            com.baidu.tieba.pb.data.f pbData3 = dcVar63.getPbData();
                                            dcVar64 = this.eah.dYA;
                                            SparseArray<Object> c = erVar46.c(pbData3, dcVar64.aKl(), 1);
                                            if (c != null) {
                                                dcVar65 = this.eah.dYA;
                                                PbActivity pbActivity4 = this.eah;
                                                Activity pageActivity = this.eah.getPageContext().getPageActivity();
                                                dcVar66 = this.eah.dYA;
                                                String id3 = dcVar66.getPbData().aIk().getId();
                                                dcVar67 = this.eah.dYA;
                                                String name2 = dcVar67.getPbData().aIk().getName();
                                                dcVar68 = this.eah.dYA;
                                                pbActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, dcVar68.getPbData().aIl().getId(), String.valueOf(dcVar65.getPbData().getUserData().getUserId()), (String) c.get(r.g.tag_forbid_user_name), (String) c.get(r.g.tag_forbid_user_post_id))));
                                                return;
                                            }
                                            return;
                                        }
                                        this.eah.showToast(r.j.network_not_available);
                                        return;
                                    }
                                }
                                erVar35 = this.eah.dZk;
                                if (erVar35.eeG.aMG() != null) {
                                    erVar40 = this.eah.dZk;
                                    if (view == erVar40.eeG.aMG().aLf()) {
                                        if (com.baidu.adp.lib.util.i.gm()) {
                                            erVar41 = this.eah.dZk;
                                            dcVar61 = this.eah.dYA;
                                            com.baidu.tieba.pb.data.f pbData4 = dcVar61.getPbData();
                                            dcVar62 = this.eah.dYA;
                                            SparseArray<Object> c2 = erVar41.c(pbData4, dcVar62.aKl(), 1);
                                            if (c2 != null) {
                                                erVar43 = this.eah.dZk;
                                                erVar43.a(((Integer) c2.get(r.g.tag_del_post_type)).intValue(), (String) c2.get(r.g.tag_del_post_id), ((Integer) c2.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(r.g.tag_del_post_is_self)).booleanValue());
                                            }
                                            erVar42 = this.eah.dZk;
                                            erVar42.eeG.od();
                                            return;
                                        }
                                        this.eah.showToast(r.j.network_not_available);
                                        return;
                                    }
                                }
                                if (view.getId() != r.g.sub_pb_more && view.getId() != r.g.sub_pb_item) {
                                    erVar37 = this.eah.dZk;
                                    if (view == erVar37.aIW()) {
                                        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                            long c3 = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                            dcVar58 = this.eah.dYA;
                                            long c4 = com.baidu.adp.lib.h.b.c(dcVar58.getPbData().getForumId(), 0L);
                                            dcVar59 = this.eah.dYA;
                                            long c5 = com.baidu.adp.lib.h.b.c(dcVar59.getThreadID(), 0L);
                                            dcVar60 = this.eah.dYA;
                                            this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.eah.getPageContext().getPageActivity(), 24008, c4, c5, c3, dcVar60.getPbData().aIl().rY())));
                                            return;
                                        }
                                        return;
                                    }
                                    int id4 = view.getId();
                                    if (id4 == r.g.pb_u9_text_view) {
                                        if (this.eah.checkUpIsLogin() && (bmVar = (com.baidu.tbadk.core.data.bm) view.getTag()) != null && !StringUtils.isNull(bmVar.sQ())) {
                                            TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                            com.baidu.tbadk.core.util.bc.vz().c(this.eah.getPageContext(), new String[]{bmVar.sQ()});
                                            return;
                                        }
                                        return;
                                    } else if (id4 == r.g.replybtn || id4 == r.g.cover_reply_content) {
                                        djVar8 = this.eah.dZp;
                                        if (djVar8 == null) {
                                            this.eah.dZp = new dj(this.eah.getPageContext(), this.eah.bzZ);
                                            djVar45 = this.eah.dZp;
                                            z7 = this.eah.mIsLogin;
                                            djVar45.io(z7);
                                        }
                                        djVar9 = this.eah.dZp;
                                        djVar9.Gl();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11740"));
                                        com.baidu.tieba.tbadkCore.data.q qVar2 = null;
                                        if (view != null && view.getTag() != null) {
                                            qVar2 = (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_load_sub_data);
                                            if (!this.eah.aJu()) {
                                                dcVar24 = this.eah.dYA;
                                                if (dcVar24.aKw() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                                                    djVar44 = this.eah.dZp;
                                                    djVar44.aKV();
                                                    sparseArray = (SparseArray) view.getTag();
                                                    if (sparseArray.get(r.g.tag_pb_floor_postion) instanceof Integer) {
                                                        int intValue4 = ((Integer) sparseArray.get(r.g.tag_pb_floor_postion)).intValue();
                                                        int intValue5 = ((Integer) sparseArray.get(r.g.tag_pb_floor_number)).intValue();
                                                        djVar42 = this.eah.dZp;
                                                        djVar42.aKT().setTag(r.g.tag_pb_floor_postion, Integer.valueOf(intValue4));
                                                        djVar43 = this.eah.dZp;
                                                        djVar43.aKT().setTag(r.g.tag_pb_floor_number, Integer.valueOf(intValue5));
                                                    }
                                                    SparseArray sparseArray9 = new SparseArray();
                                                    sparseArray9.put(r.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_clip_board));
                                                    sparseArray9.put(r.g.tag_is_subpb, false);
                                                    djVar15 = this.eah.dZp;
                                                    djVar15.aKM().setTag(sparseArray9);
                                                    djVar16 = this.eah.dZp;
                                                    djVar16.aKR().setTag(view.getTag());
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
                                                            djVar41 = this.eah.dZp;
                                                            djVar41.aKP().setVisibility(0);
                                                        } else {
                                                            sparseArray10.put(r.g.tag_should_delete_visible, false);
                                                            djVar36 = this.eah.dZp;
                                                            djVar36.aKP().setVisibility(8);
                                                        }
                                                        djVar37 = this.eah.dZp;
                                                        djVar37.aKN().setTag(sparseArray10);
                                                        djVar38 = this.eah.dZp;
                                                        djVar38.aKP().setTag(sparseArray10);
                                                        djVar39 = this.eah.dZp;
                                                        djVar39.aKN().setText(r.j.bar_manager);
                                                        djVar40 = this.eah.dZp;
                                                        djVar40.aKN().setVisibility(0);
                                                    } else if (!booleanValue7) {
                                                        djVar17 = this.eah.dZp;
                                                        djVar17.aKN().setVisibility(8);
                                                        djVar18 = this.eah.dZp;
                                                        djVar18.aKP().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray11 = new SparseArray();
                                                        sparseArray11.put(r.g.tag_should_manage_visible, false);
                                                        sparseArray11.put(r.g.tag_user_mute_visible, false);
                                                        sparseArray11.put(r.g.tag_should_delete_visible, true);
                                                        sparseArray11.put(r.g.tag_manage_user_identity, sparseArray2.get(r.g.tag_manage_user_identity));
                                                        sparseArray11.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                        sparseArray11.put(r.g.tag_del_post_id, sparseArray2.get(r.g.tag_del_post_id));
                                                        sparseArray11.put(r.g.tag_del_post_type, sparseArray2.get(r.g.tag_del_post_type));
                                                        djVar19 = this.eah.dZp;
                                                        djVar19.aKN().setTag(sparseArray11);
                                                        djVar20 = this.eah.dZp;
                                                        djVar20.aKP().setTag(sparseArray11);
                                                        djVar21 = this.eah.dZp;
                                                        djVar21.aKN().setText(r.j.delete);
                                                        djVar22 = this.eah.dZp;
                                                        djVar22.aKP().setVisibility(0);
                                                        djVar23 = this.eah.dZp;
                                                        djVar23.aKN().setVisibility(8);
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
                                                        djVar32 = this.eah.dZp;
                                                        djVar32.aKO().setTag(sparseArray12);
                                                        djVar33 = this.eah.dZp;
                                                        djVar33.aKO().setVisibility(0);
                                                        djVar34 = this.eah.dZp;
                                                        djVar34.aKN().setVisibility(8);
                                                        djVar35 = this.eah.dZp;
                                                        djVar35.aKO().setText(r.j.mute_option);
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
                                                        id = this.eah.id(z5);
                                                        isLogin = id & this.eah.isLogin();
                                                        this.eah.dZY = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(r.g.tag_clip_board);
                                                        if (!(!eq.h(this.eah.dZY) ? false : isLogin)) {
                                                            djVar25 = this.eah.dZp;
                                                            djVar25.aKO().setVisibility(0);
                                                            djVar26 = this.eah.dZp;
                                                            djVar26.aKO().setTag(str7);
                                                        } else {
                                                            djVar24 = this.eah.dZp;
                                                            djVar24.aKO().setVisibility(8);
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
                                                        djVar28 = this.eah.dZp;
                                                        djVar28.aKQ().setVisibility(0);
                                                        djVar29 = this.eah.dZp;
                                                        djVar29.aKQ().setTag(r.g.tag_chudian_template_id, Long.valueOf(j2));
                                                        djVar30 = this.eah.dZp;
                                                        djVar30.aKQ().setTag(r.g.tag_chudian_monitor_id, str);
                                                        djVar31 = this.eah.dZp;
                                                        djVar31.aKQ().setTag(r.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                    } else {
                                                        djVar27 = this.eah.dZp;
                                                        djVar27.aKQ().setVisibility(8);
                                                    }
                                                }
                                            }
                                            djVar14 = this.eah.dZp;
                                            djVar14.aKU();
                                            sparseArray = (SparseArray) view.getTag();
                                            if (sparseArray.get(r.g.tag_pb_floor_postion) instanceof Integer) {
                                            }
                                            SparseArray sparseArray92 = new SparseArray();
                                            sparseArray92.put(r.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_clip_board));
                                            sparseArray92.put(r.g.tag_is_subpb, false);
                                            djVar15 = this.eah.dZp;
                                            djVar15.aKM().setTag(sparseArray92);
                                            djVar16 = this.eah.dZp;
                                            djVar16.aKR().setTag(view.getTag());
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
                                            id = this.eah.id(z5);
                                            isLogin = id & this.eah.isLogin();
                                            this.eah.dZY = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(r.g.tag_clip_board);
                                            if (!(!eq.h(this.eah.dZY) ? false : isLogin)) {
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
                                        dcVar22 = this.eah.dYA;
                                        if (dcVar22.getPbData().nz()) {
                                            dcVar23 = this.eah.dYA;
                                            String ny2 = dcVar23.getPbData().ny();
                                            if (qVar2 != null && !com.baidu.adp.lib.util.j.isEmpty(ny2) && ny2.equals(qVar2.getId())) {
                                                z2 = true;
                                                if (!z2) {
                                                    djVar13 = this.eah.dZp;
                                                    djVar13.aKM().setText(r.j.remove_mark);
                                                } else {
                                                    djVar10 = this.eah.dZp;
                                                    djVar10.aKM().setText(r.j.mark);
                                                }
                                                djVar11 = this.eah.dZp;
                                                djVar11.ip(true);
                                                djVar12 = this.eah.dZp;
                                                djVar12.vT();
                                                return;
                                            }
                                        }
                                        z2 = false;
                                        if (!z2) {
                                        }
                                        djVar11 = this.eah.dZp;
                                        djVar11.ip(true);
                                        djVar12 = this.eah.dZp;
                                        djVar12.vT();
                                        return;
                                    } else if (id4 == r.g.pb_act_btn) {
                                        dcVar52 = this.eah.dYA;
                                        if (dcVar52.getPbData() != null) {
                                            dcVar53 = this.eah.dYA;
                                            if (dcVar53.getPbData().aIl() != null) {
                                                dcVar54 = this.eah.dYA;
                                                if (dcVar54.getPbData().aIl().sj() != null) {
                                                    Activity activity = this.eah.getActivity();
                                                    dcVar55 = this.eah.dYA;
                                                    com.baidu.tbadk.browser.f.u(activity, dcVar55.getPbData().aIl().sj());
                                                    dcVar56 = this.eah.dYA;
                                                    if (dcVar56.getPbData().aIl().sh() != 1) {
                                                        dcVar57 = this.eah.dYA;
                                                        if (dcVar57.getPbData().aIl().sh() == 2) {
                                                            TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    } else if (id4 == r.g.lottery_tail) {
                                        if (view.getTag(r.g.tag_pb_lottery_tail_link) instanceof String) {
                                            String str8 = (String) view.getTag(r.g.tag_pb_lottery_tail_link);
                                            com.baidu.tbadk.core.util.at atVar3 = new com.baidu.tbadk.core.util.at("c10912");
                                            dcVar49 = this.eah.dYA;
                                            com.baidu.tbadk.core.util.at ab = atVar3.ab("fid", dcVar49.getPbData().getForumId());
                                            dcVar50 = this.eah.dYA;
                                            TiebaStatic.log(ab.ab("tid", dcVar50.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                            dcVar51 = this.eah.dYA;
                                            if (dcVar51.getPbData().getThreadId().equals(str8)) {
                                                erVar39 = this.eah.dZk;
                                                erVar39.setSelection(0);
                                                return;
                                            }
                                            this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.eah.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                            return;
                                        }
                                        return;
                                    } else if (id4 == r.g.pb_item_tail_content) {
                                        if (com.baidu.tbadk.core.util.bh.ai(this.eah.getPageContext().getPageActivity())) {
                                            String string = TbadkCoreApplication.m9getInst().getString(r.j.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.tW().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                TiebaStatic.log("c10056");
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                            }
                                            erVar38 = this.eah.dZk;
                                            erVar38.aLD();
                                            return;
                                        }
                                        return;
                                    } else if (id4 == r.g.join_vote_tv) {
                                        if (view != null) {
                                            com.baidu.tbadk.browser.f.u(this.eah.getActivity(), (String) view.getTag());
                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                            aJh3 = this.eah.aJh();
                                            if (aJh3 == 1) {
                                                dcVar45 = this.eah.dYA;
                                                if (dcVar45 != null) {
                                                    dcVar46 = this.eah.dYA;
                                                    if (dcVar46.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.at atVar4 = new com.baidu.tbadk.core.util.at("c10397");
                                                        dcVar47 = this.eah.dYA;
                                                        com.baidu.tbadk.core.util.at ab2 = atVar4.ab("fid", dcVar47.getPbData().getForumId());
                                                        dcVar48 = this.eah.dYA;
                                                        TiebaStatic.log(ab2.ab("tid", dcVar48.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aJh4 = this.eah.aJh();
                                            if (aJh4 == 2) {
                                                dcVar41 = this.eah.dYA;
                                                if (dcVar41 != null) {
                                                    dcVar42 = this.eah.dYA;
                                                    if (dcVar42.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.at atVar5 = new com.baidu.tbadk.core.util.at("c10401");
                                                        dcVar43 = this.eah.dYA;
                                                        com.baidu.tbadk.core.util.at ab3 = atVar5.ab("fid", dcVar43.getPbData().getForumId());
                                                        dcVar44 = this.eah.dYA;
                                                        TiebaStatic.log(ab3.ab("tid", dcVar44.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    } else if (id4 == r.g.look_all_tv) {
                                        if (view != null) {
                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                            com.baidu.tbadk.browser.f.u(this.eah.getActivity(), (String) view.getTag());
                                            aJh = this.eah.aJh();
                                            if (aJh == 1) {
                                                dcVar37 = this.eah.dYA;
                                                if (dcVar37 != null) {
                                                    dcVar38 = this.eah.dYA;
                                                    if (dcVar38.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.at atVar6 = new com.baidu.tbadk.core.util.at("c10507");
                                                        dcVar39 = this.eah.dYA;
                                                        com.baidu.tbadk.core.util.at ab4 = atVar6.ab("fid", dcVar39.getPbData().getForumId());
                                                        dcVar40 = this.eah.dYA;
                                                        TiebaStatic.log(ab4.ab("tid", dcVar40.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount2));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aJh2 = this.eah.aJh();
                                            if (aJh2 == 2) {
                                                dcVar33 = this.eah.dYA;
                                                if (dcVar33 != null) {
                                                    dcVar34 = this.eah.dYA;
                                                    if (dcVar34.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.at atVar7 = new com.baidu.tbadk.core.util.at("c10508");
                                                        dcVar35 = this.eah.dYA;
                                                        com.baidu.tbadk.core.util.at ab5 = atVar7.ab("fid", dcVar35.getPbData().getForumId());
                                                        dcVar36 = this.eah.dYA;
                                                        TiebaStatic.log(ab5.ab("tid", dcVar36.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount2));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    } else if (id4 != r.g.manga_prev_btn) {
                                        if (id4 != r.g.manga_next_btn) {
                                            if (id4 == r.g.yule_head_img_img) {
                                                dcVar29 = this.eah.dYA;
                                                if (dcVar29 != null) {
                                                    dcVar30 = this.eah.dYA;
                                                    if (dcVar30.getPbData() != null) {
                                                        dcVar31 = this.eah.dYA;
                                                        if (dcVar31.getPbData().aIA() != null) {
                                                            dcVar32 = this.eah.dYA;
                                                            com.baidu.tieba.pb.data.f pbData5 = dcVar32.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11679").ab("fid", pbData5.getForumId()));
                                                            com.baidu.tbadk.core.util.bc.vz().c(this.eah.getPageContext(), new String[]{pbData5.aIA().aIB()});
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == r.g.yule_head_img_all_rank) {
                                                dcVar25 = this.eah.dYA;
                                                if (dcVar25 != null) {
                                                    dcVar26 = this.eah.dYA;
                                                    if (dcVar26.getPbData() != null) {
                                                        dcVar27 = this.eah.dYA;
                                                        if (dcVar27.getPbData().aIA() != null) {
                                                            dcVar28 = this.eah.dYA;
                                                            com.baidu.tieba.pb.data.f pbData6 = dcVar28.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11678").ab("fid", pbData6.getForumId()));
                                                            com.baidu.tbadk.core.util.bc.vz().c(this.eah.getPageContext(), new String[]{pbData6.aIA().aIB()});
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
                                        this.eah.aJw();
                                        return;
                                    } else {
                                        this.eah.aJv();
                                        return;
                                    }
                                } else if (this.eah.checkUpIsLogin()) {
                                    dcVar7 = this.eah.dYA;
                                    if (dcVar7.getPbData() != null) {
                                        erVar36 = this.eah.dZk;
                                        erVar36.awl();
                                        SparseArray sparseArray13 = (SparseArray) view.getTag();
                                        com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) sparseArray13.get(r.g.tag_load_sub_data);
                                        View view2 = (View) sparseArray13.get(r.g.tag_load_sub_view);
                                        if (qVar3 != null && view2 != null) {
                                            dcVar8 = this.eah.dYA;
                                            String threadID2 = dcVar8.getThreadID();
                                            String id5 = qVar3.getId();
                                            int i4 = 0;
                                            dcVar9 = this.eah.dYA;
                                            if (dcVar9.getPbData() != null) {
                                                dcVar20 = this.eah.dYA;
                                                i4 = dcVar20.getPbData().aIu();
                                            }
                                            this.eah.WD();
                                            if (view.getId() != r.g.replybtn) {
                                                if (view.getId() == r.g.sub_pb_item) {
                                                    SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                    String str9 = (String) sparseArray14.get(r.g.tag_photo_username);
                                                    String str10 = (String) sparseArray13.get(r.g.tag_photo_userid);
                                                    com.baidu.tieba.tbadkCore.data.q qVar4 = (com.baidu.tieba.tbadkCore.data.q) sparseArray14.get(r.g.tag_load_sub_data);
                                                    String str11 = null;
                                                    if (qVar4 != null) {
                                                        str11 = qVar4.getId();
                                                    }
                                                    TiebaStatic.log("c11741");
                                                    nU2 = this.eah.nU(id5);
                                                    if (qVar3 != null) {
                                                        dcVar13 = this.eah.dYA;
                                                        if (dcVar13 != null) {
                                                            dcVar14 = this.eah.dYA;
                                                            if (dcVar14.getPbData() != null && nU2 != null && this.eah.aJb().aLB() != null) {
                                                                com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                                                dcVar15 = this.eah.dYA;
                                                                jVar.b(dcVar15.getPbData().aIk());
                                                                dcVar16 = this.eah.dYA;
                                                                jVar.h(dcVar16.getPbData().aIl());
                                                                jVar.b(qVar4);
                                                                this.eah.aJb().aLB().c(jVar);
                                                                this.eah.aJb().aLB().setPostId(str11);
                                                                this.eah.a(view, str10, str9);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.log("c11742");
                                                nU = this.eah.nU(id5);
                                                if (qVar3 != null) {
                                                    dcVar10 = this.eah.dYA;
                                                    if (dcVar10 != null) {
                                                        dcVar11 = this.eah.dYA;
                                                        if (dcVar11.getPbData() != null && nU != null) {
                                                            SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.eah.getPageContext().getPageActivity());
                                                            SmallTailInfo aNF2 = qVar3.aNF();
                                                            dcVar12 = this.eah.dYA;
                                                            this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i4, aNF2, dcVar12.getPbData().qt(), false, qVar3.getAuthor().getIconInfo()).addBigImageData(nU.eay, nU.eaz, nU.eaA, nU.index)));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            nU3 = this.eah.nU(id5);
                                            if (qVar3 != null) {
                                                dcVar17 = this.eah.dYA;
                                                if (dcVar17 != null) {
                                                    dcVar18 = this.eah.dYA;
                                                    if (dcVar18.getPbData() != null && nU3 != null) {
                                                        SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.eah.getPageContext().getPageActivity());
                                                        SmallTailInfo aNF3 = qVar3.aNF();
                                                        dcVar19 = this.eah.dYA;
                                                        this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i4, aNF3, dcVar19.getPbData().qt(), false, qVar3.getAuthor().getIconInfo()).addBigImageData(nU3.eay, nU3.eaz, nU3.eaA, nU3.index)));
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
                                    com.baidu.tbadk.core.util.at s = new com.baidu.tbadk.core.util.at("c10517").s("obj_locate", 3);
                                    dcVar21 = this.eah.dYA;
                                    TiebaStatic.log(s.ab("fid", dcVar21.getPbData().getForumId()));
                                    return;
                                }
                            } else if (this.eah.checkUpIsLogin()) {
                                erVar47 = this.eah.dZk;
                                if (!erVar47.aKe()) {
                                    dcVar69 = this.eah.dYA;
                                    if (dcVar69 != null) {
                                        dcVar70 = this.eah.dYA;
                                        if (dcVar70.aKH() != null) {
                                            dcVar71 = this.eah.dYA;
                                            if (dcVar71.aKH().aKa() != null) {
                                                dcVar72 = this.eah.dYA;
                                                if (com.baidu.tbadk.core.util.x.s(dcVar72.aKH().aKa().getItems()) != 0) {
                                                    erVar48 = this.eah.dZk;
                                                    erVar48.aKf();
                                                    return;
                                                }
                                                this.eah.showToast(r.j.graffiti_quick_vote_empty);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                erVar49 = this.eah.dZk;
                                erVar49.aKg();
                                return;
                            } else {
                                return;
                            }
                        } else if (!this.eah.checkUpIsLogin()) {
                            com.baidu.tbadk.core.util.at s2 = new com.baidu.tbadk.core.util.at("c10517").s("obj_locate", 2);
                            dcVar74 = this.eah.dYA;
                            TiebaStatic.log(s2.ab("fid", dcVar74.getPbData().getForumId()));
                            return;
                        } else {
                            this.eah.aIY();
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.i.gm()) {
                        erVar17 = this.eah.dZk;
                        erVar17.aLD();
                        z = this.eah.mIsLoading;
                        if (!z) {
                            this.eah.mIsLoading = true;
                            erVar18 = this.eah.dZk;
                            erVar18.eeG.ehJ.setEnabled(false);
                            erVar19 = this.eah.dZk;
                            erVar19.aqY();
                            this.eah.WD();
                            erVar20 = this.eah.dZk;
                            erVar20.aLU();
                            dcVar6 = this.eah.dYA;
                            aJt = this.eah.aJt();
                            dcVar6.nW(aJt);
                            TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                            erVar21 = this.eah.dZk;
                            erVar21.aMl();
                            erVar22 = this.eah.dZk;
                            erVar22.aKg();
                            this.eah.nz(2);
                            return;
                        }
                        return;
                    } else {
                        this.eah.showToast(r.j.network_not_available);
                        return;
                    }
                }
                TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                dcVar104 = this.eah.dYA;
                if (dcVar104.getErrorNo() == 4) {
                    dcVar107 = this.eah.dYA;
                    if (StringUtils.isNull(dcVar107.aKk())) {
                        dcVar108 = this.eah.dYA;
                        if (dcVar108.getAppealInfo() != null) {
                            dcVar109 = this.eah.dYA;
                            name = dcVar109.getAppealInfo().forumName;
                        }
                    }
                    this.eah.finish();
                    return;
                }
                dcVar105 = this.eah.dYA;
                name = dcVar105.getPbData().aIk().getName();
                if (!StringUtils.isNull(name)) {
                    dcVar106 = this.eah.dYA;
                    String aKk = dcVar106.aKk();
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.eah.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                    if (StringUtils.isNull(aKk)) {
                        this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                        return;
                    } else if (aKk.equals(name)) {
                        this.eah.finish();
                        return;
                    } else {
                        this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                        return;
                    }
                }
                this.eah.finish();
                return;
            }
            if (com.baidu.adp.lib.util.i.gm()) {
                dcVar = this.eah.dYA;
                if (dcVar.getPbData().aIu() == 1) {
                    aVar = this.eah.dZj;
                    if (!aVar.bgO()) {
                        erVar6 = this.eah.dZk;
                        erVar6.awl();
                        int i5 = 0;
                        erVar7 = this.eah.dZk;
                        if (view == erVar7.eeG.aMG().aLe()) {
                            dcVar5 = this.eah.dYA;
                            if (dcVar5.getPbData().aIl().rA() == 1) {
                                i5 = 5;
                            } else {
                                i5 = 4;
                            }
                        } else {
                            erVar8 = this.eah.dZk;
                            if (view == erVar8.eeG.aMG().aLg()) {
                                dcVar2 = this.eah.dYA;
                                if (dcVar2.getPbData().aIl().rB() == 1) {
                                    i5 = 3;
                                } else {
                                    i5 = 6;
                                }
                            } else {
                                erVar9 = this.eah.dZk;
                                if (view == erVar9.aLS()) {
                                    i5 = 2;
                                }
                            }
                        }
                        dcVar3 = this.eah.dYA;
                        ForumData aIk = dcVar3.getPbData().aIk();
                        String name3 = aIk.getName();
                        String id6 = aIk.getId();
                        dcVar4 = this.eah.dYA;
                        String id7 = dcVar4.getPbData().aIl().getId();
                        if (!com.baidu.tieba.c.a.Od() || !com.baidu.tieba.c.a.f(this.eah.getBaseContext(), id7, null)) {
                            erVar10 = this.eah.dZk;
                            erVar10.aLR();
                            aVar2 = this.eah.dZj;
                            erVar11 = this.eah.dZk;
                            aVar2.a(id6, name3, id7, i5, erVar11.aLT());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.eah.showToast(r.j.network_not_available);
        } else if (this.eah.checkUpIsLogin()) {
            z8 = this.eah.dZd;
            if (z8) {
                this.eah.dZd = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(r.g.tag_clip_board);
                if (obj instanceof com.baidu.tieba.tbadkCore.data.q) {
                    com.baidu.tieba.tbadkCore.data.q qVar5 = (com.baidu.tieba.tbadkCore.data.q) obj;
                    dcVar117 = this.eah.dYA;
                    if (dcVar117 != null) {
                        dcVar118 = this.eah.dYA;
                        if (dcVar118.getPbData() != null && this.eah.aJb().aLB() != null && qVar5.getAuthor() != null && qVar5.bga() != 1) {
                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                            dcVar119 = this.eah.dYA;
                            jVar2.b(dcVar119.getPbData().aIk());
                            dcVar120 = this.eah.dYA;
                            jVar2.h(dcVar120.getPbData().aIl());
                            jVar2.b(qVar5);
                            this.eah.aJb().aLB().c(jVar2);
                            this.eah.aJb().aLB().setPostId(qVar5.getId());
                            this.eah.a(view, qVar5.getAuthor().getUserId(), "");
                            TiebaStatic.log("c11743");
                        }
                    }
                }
            }
        }
    }
}
