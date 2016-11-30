package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommEnsureOrderActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.data.PbEcommRecommendMessage;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v130, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v134, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v183, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x06f5, code lost:
        if (r21 == r1.eAx.aSP().aRd()) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0299, code lost:
        if (r21 == r1.eAx.aSP().aRg()) goto L829;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:487:0x164e  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x1709  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x1721  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x172b  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x1823  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x1909  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x1920  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x1936  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x1948  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x1956  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x19d9  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x1a39  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x1b09  */
    /* JADX WARN: Removed duplicated region for block: B:545:0x1b21  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x1b54  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x1b57  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x1b78  */
    /* JADX WARN: Removed duplicated region for block: B:552:0x1b8b  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x1b9e  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x21dd  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x21e0  */
    /* JADX WARN: Removed duplicated region for block: B:681:0x21e3  */
    /* JADX WARN: Removed duplicated region for block: B:682:0x21e6  */
    /* JADX WARN: Removed duplicated region for block: B:683:0x21e9  */
    /* JADX WARN: Removed duplicated region for block: B:684:0x21ec  */
    /* JADX WARN: Removed duplicated region for block: B:685:0x21ef  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        ey eyVar5;
        dj djVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        ey eyVar6;
        ey eyVar7;
        ey eyVar8;
        ey eyVar9;
        dj djVar2;
        dj djVar3;
        dj djVar4;
        ey eyVar10;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ey eyVar11;
        dj djVar5;
        ey eyVar12;
        ey eyVar13;
        ey eyVar14;
        ey eyVar15;
        ey eyVar16;
        ey eyVar17;
        boolean z;
        ey eyVar18;
        ey eyVar19;
        ey eyVar20;
        dj djVar6;
        String aPu;
        ey eyVar21;
        ey eyVar22;
        ey eyVar23;
        ey eyVar24;
        ey eyVar25;
        ey eyVar26;
        ey eyVar27;
        ey eyVar28;
        ey eyVar29;
        ey eyVar30;
        ey eyVar31;
        dq dqVar;
        dq dqVar2;
        dq dqVar3;
        dq dqVar4;
        dq dqVar5;
        dq dqVar6;
        ey eyVar32;
        ey eyVar33;
        dq dqVar7;
        ey eyVar34;
        ey eyVar35;
        ey eyVar36;
        dj djVar7;
        ey eyVar37;
        dj djVar8;
        dj djVar9;
        PbActivity.b pt;
        dj djVar10;
        dj djVar11;
        dj djVar12;
        PbActivity.b pt2;
        dj djVar13;
        dj djVar14;
        dj djVar15;
        dj djVar16;
        PbActivity.b pt3;
        dj djVar17;
        dj djVar18;
        dj djVar19;
        dj djVar20;
        dj djVar21;
        ey eyVar38;
        dq dqVar8;
        dq dqVar9;
        dj djVar22;
        boolean z2;
        dq dqVar10;
        dq dqVar11;
        dq dqVar12;
        dq dqVar13;
        dj djVar23;
        dq dqVar14;
        SparseArray sparseArray;
        dq dqVar15;
        dq dqVar16;
        SparseArray sparseArray2;
        boolean booleanValue;
        boolean z3;
        dq dqVar17;
        dq dqVar18;
        dq dqVar19;
        dq dqVar20;
        dq dqVar21;
        dq dqVar22;
        dq dqVar23;
        SparseArray sparseArray3;
        boolean z4;
        boolean z5;
        boolean iq;
        boolean isLogin;
        dq dqVar24;
        dq dqVar25;
        dq dqVar26;
        SparseArray sparseArray4;
        boolean z6;
        String str;
        int i;
        dq dqVar27;
        dq dqVar28;
        dq dqVar29;
        dq dqVar30;
        dq dqVar31;
        dq dqVar32;
        dq dqVar33;
        dq dqVar34;
        dq dqVar35;
        dq dqVar36;
        dq dqVar37;
        dq dqVar38;
        dq dqVar39;
        dq dqVar40;
        dq dqVar41;
        dq dqVar42;
        dq dqVar43;
        dj djVar24;
        dq dqVar44;
        dq dqVar45;
        boolean z7;
        dj djVar25;
        dj djVar26;
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
        dj djVar44;
        dj djVar45;
        dj djVar46;
        PbEcommRecommendMessage pbEcommRecommendMessage;
        int aPi;
        int aPi2;
        dj djVar47;
        dj djVar48;
        dj djVar49;
        dj djVar50;
        dj djVar51;
        dj djVar52;
        dj djVar53;
        dj djVar54;
        int aPi3;
        int aPi4;
        dj djVar55;
        dj djVar56;
        dj djVar57;
        dj djVar58;
        dj djVar59;
        dj djVar60;
        dj djVar61;
        dj djVar62;
        ey eyVar39;
        dj djVar63;
        dj djVar64;
        dj djVar65;
        ey eyVar40;
        dj djVar66;
        dj djVar67;
        dj djVar68;
        dj djVar69;
        dj djVar70;
        dj djVar71;
        com.baidu.tbadk.core.data.br brVar;
        dj djVar72;
        dj djVar73;
        dj djVar74;
        ey eyVar41;
        ey eyVar42;
        dj djVar75;
        dj djVar76;
        ey eyVar43;
        ey eyVar44;
        ey eyVar45;
        ey eyVar46;
        ey eyVar47;
        dj djVar77;
        dj djVar78;
        dj djVar79;
        dj djVar80;
        dj djVar81;
        dj djVar82;
        ey eyVar48;
        dj djVar83;
        dj djVar84;
        dj djVar85;
        dj djVar86;
        ey eyVar49;
        ey eyVar50;
        dq dqVar46;
        ey eyVar51;
        ey eyVar52;
        dj djVar87;
        dj djVar88;
        ey eyVar53;
        dj djVar89;
        dq dqVar47;
        dj djVar90;
        dq dqVar48;
        ey eyVar54;
        dj djVar91;
        dq dqVar49;
        dj djVar92;
        ey eyVar55;
        dj djVar93;
        dq dqVar50;
        dj djVar94;
        ey eyVar56;
        SparseArray sparseArray5;
        com.baidu.tieba.tbadkCore.data.q qVar;
        dj djVar95;
        dj djVar96;
        PbActivity.b pt4;
        dj djVar97;
        dj djVar98;
        dq dqVar51;
        dq dqVar52;
        ey eyVar57;
        String aPh;
        ey eyVar58;
        ey eyVar59;
        ey eyVar60;
        ey eyVar61;
        ey eyVar62;
        dj djVar99;
        dj djVar100;
        ey eyVar63;
        ey eyVar64;
        dj djVar101;
        dj djVar102;
        dj djVar103;
        ey eyVar65;
        ey eyVar66;
        dj djVar104;
        dj djVar105;
        dj djVar106;
        ey eyVar67;
        dj djVar107;
        ey eyVar68;
        ey eyVar69;
        ey eyVar70;
        dj djVar108;
        ey eyVar71;
        ey eyVar72;
        dj djVar109;
        ey eyVar73;
        dj djVar110;
        ey eyVar74;
        ey eyVar75;
        dj djVar111;
        dj djVar112;
        dj djVar113;
        dj djVar114;
        dj djVar115;
        ey eyVar76;
        ey eyVar77;
        ey eyVar78;
        ey eyVar79;
        ey eyVar80;
        boolean ow;
        dj djVar116;
        ey eyVar81;
        dj djVar117;
        dj djVar118;
        dj djVar119;
        dj djVar120;
        ey eyVar82;
        ey eyVar83;
        dj djVar121;
        dj djVar122;
        String name;
        dj djVar123;
        dj djVar124;
        dj djVar125;
        dj djVar126;
        dj djVar127;
        dj djVar128;
        ey eyVar84;
        ey eyVar85;
        ey eyVar86;
        dj djVar129;
        ey eyVar87;
        ey eyVar88;
        ey eyVar89;
        ey eyVar90;
        dj djVar130;
        ey eyVar91;
        ey eyVar92;
        dj djVar131;
        dj djVar132;
        ey eyVar93;
        dj djVar133;
        ey eyVar94;
        boolean z8;
        dj djVar134;
        dj djVar135;
        dj djVar136;
        dj djVar137;
        if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
            z8 = this.evL.euI;
            if (z8) {
                this.evL.euI = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(r.g.tag_clip_board);
                if (obj instanceof com.baidu.tieba.tbadkCore.data.q) {
                    com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) obj;
                    djVar134 = this.evL.euf;
                    if (djVar134 != null) {
                        djVar135 = this.evL.euf;
                        if (djVar135.getPbData() != null && this.evL.aPc().aRH() != null && qVar2.getAuthor() != null && qVar2.bml() != 1) {
                            com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                            djVar136 = this.evL.euf;
                            nVar.b(djVar136.getPbData().aOk());
                            djVar137 = this.evL.euf;
                            nVar.c(djVar137.getPbData().aOl());
                            nVar.b(qVar2);
                            this.evL.aPc().aRH().c(nVar);
                            this.evL.aPc().aRH().setPostId(qVar2.getId());
                            this.evL.a(view, qVar2.getAuthor().getUserId(), "");
                            TiebaStatic.log("c11743");
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
        eyVar = this.evL.euP;
        if (view == eyVar.getNextView()) {
            djVar133 = this.evL.euf;
            if (djVar133.ix(true)) {
                eyVar94 = this.evL.euP;
                eyVar94.aSb();
                return;
            }
            return;
        }
        eyVar2 = this.evL.euP;
        if (eyVar2.eAx.aSP() != null) {
            eyVar91 = this.evL.euP;
            if (view == eyVar91.eAx.aSP().aRe()) {
                eyVar92 = this.evL.euP;
                eyVar92.aRT();
                if (UtilHelper.isFloatWindowOpAllowed(this.evL.getPageContext().getPageActivity())) {
                    this.evL.euV = true;
                    PbActivity pbActivity = this.evL;
                    djVar131 = this.evL.euf;
                    pbActivity.a(djVar131.getPbData(), 0, 1, true, true);
                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10830");
                    djVar132 = this.evL.euf;
                    TiebaStatic.log(avVar.ab("tid", djVar132.getThreadID()));
                    eyVar93 = this.evL.euP;
                    eyVar93.aCY();
                    return;
                }
                this.evL.aPg();
                return;
            }
        }
        eyVar3 = this.evL.euP;
        if (eyVar3.eAx.aSP() != null) {
            eyVar87 = this.evL.euP;
            if (view == eyVar87.eAx.aSP().aRj()) {
                if (com.baidu.adp.lib.util.i.gm()) {
                    eyVar88 = this.evL.euP;
                    eyVar88.aCY();
                    this.evL.acp();
                    eyVar89 = this.evL.euP;
                    eyVar89.aSa();
                    eyVar90 = this.evL.euP;
                    eyVar90.aAF();
                    djVar130 = this.evL.euf;
                    djVar130.oC(1);
                    return;
                }
                this.evL.showToast(r.j.network_not_available);
                return;
            }
        }
        eyVar4 = this.evL.euP;
        if (view == eyVar4.eAx.aEA) {
            eyVar86 = this.evL.euP;
            djVar129 = this.evL.euf;
            if (!eyVar86.iY(djVar129.aQs())) {
                this.evL.euy = false;
                this.evL.finish();
                return;
            }
            this.evL.acp();
            return;
        }
        eyVar5 = this.evL.euP;
        if (view != eyVar5.aRY()) {
            eyVar12 = this.evL.euP;
            if (eyVar12.eAx.aSP() != null) {
                eyVar84 = this.evL.euP;
                if (view != eyVar84.eAx.aSP().aRi()) {
                    eyVar85 = this.evL.euP;
                }
            }
            eyVar13 = this.evL.euP;
            if (view == eyVar13.aSn()) {
                djVar127 = this.evL.euf;
                if (djVar127 != null) {
                    djVar128 = this.evL.euf;
                    com.baidu.tbadk.browser.f.u(this.evL.getPageContext().getPageActivity(), djVar128.getPbData().aOl().rP().getLink());
                    return;
                }
                return;
            }
            eyVar14 = this.evL.euP;
            if (view != eyVar14.eAx.eDH) {
                eyVar15 = this.evL.euP;
                if (view == eyVar15.eAx.eDJ) {
                    djVar117 = this.evL.euf;
                    if (djVar117 != null) {
                        djVar118 = this.evL.euf;
                        if (djVar118.getPbData() != null) {
                            djVar119 = this.evL.euf;
                            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = djVar119.getPbData().aOm();
                            if (aOm == null || aOm.size() <= 0) {
                                djVar120 = this.evL.euf;
                                if (djVar120.aQp()) {
                                    com.baidu.adp.lib.util.k.showToast(this.evL.getPageContext().getPageActivity(), this.evL.getPageContext().getString(r.j.pb_no_data_tips));
                                    return;
                                }
                            }
                            eyVar82 = this.evL.euP;
                            eyVar82.aRJ();
                            eyVar83 = this.evL.euP;
                            eyVar83.aSs();
                            this.evL.aPj();
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.k.showToast(this.evL.getPageContext().getPageActivity(), this.evL.getPageContext().getString(r.j.pb_no_data_tips));
                    return;
                }
                eyVar16 = this.evL.euP;
                if (view != eyVar16.eAx.eDI && view.getId() != r.g.pb_god_user_tip_content) {
                    eyVar23 = this.evL.euP;
                    if (eyVar23.eAx.aSP() != null) {
                        eyVar79 = this.evL.euP;
                        if (view == eyVar79.eAx.aSP().aQN()) {
                            if (com.baidu.adp.lib.util.i.gm()) {
                                eyVar80 = this.evL.euP;
                                eyVar80.aCY();
                                ow = this.evL.ow(11009);
                                if (ow) {
                                    djVar116 = this.evL.euf;
                                    eyVar81 = this.evL.euP;
                                    if (djVar116.oI(eyVar81.aSf()) == null) {
                                        return;
                                    }
                                    this.evL.aPp();
                                    return;
                                }
                                return;
                            }
                            this.evL.showToast(r.j.network_not_available);
                            return;
                        }
                    }
                    eyVar24 = this.evL.euP;
                    if (eyVar24.eAx.aSP() != null) {
                        eyVar76 = this.evL.euP;
                        if (view != eyVar76.eAx.aSP().aRc()) {
                            eyVar78 = this.evL.euP;
                        }
                        eyVar77 = this.evL.euP;
                        eyVar77.eAx.od();
                        return;
                    }
                    eyVar25 = this.evL.euP;
                    if (eyVar25.eAx.aSP() != null) {
                        eyVar74 = this.evL.euP;
                        if (view == eyVar74.eAx.aSP().aRf()) {
                            if (this.evL.checkUpIsLogin()) {
                                eyVar75 = this.evL.euP;
                                eyVar75.aCY();
                                this.evL.acp();
                                this.evL.ox(2);
                                djVar111 = this.evL.euf;
                                if (djVar111 != null) {
                                    djVar112 = this.evL.euf;
                                    if (djVar112.getPbData() != null) {
                                        djVar113 = this.evL.euf;
                                        if (djVar113.getPbData().aOz() != null) {
                                            djVar114 = this.evL.euf;
                                            if (!StringUtils.isNull(djVar114.getPbData().aOz().pR(), true)) {
                                                com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c11678");
                                                djVar115 = this.evL.euf;
                                                TiebaStatic.log(avVar2.ab("fid", djVar115.getPbData().getForumId()));
                                            }
                                        }
                                    }
                                }
                                this.evL.aik();
                                return;
                            }
                            return;
                        }
                    }
                    eyVar26 = this.evL.euP;
                    if (eyVar26.eAx.aSP() != null) {
                        eyVar71 = this.evL.euP;
                        if (view == eyVar71.eAx.aSP().aQX()) {
                            eyVar72 = this.evL.euP;
                            eyVar72.aCY();
                            djVar109 = this.evL.euf;
                            if (djVar109.are() != null) {
                                eyVar73 = this.evL.euP;
                                djVar110 = this.evL.euf;
                                eyVar73.a(djVar110.are(), this.evL.efh);
                            }
                            TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    eyVar27 = this.evL.euP;
                    if (eyVar27.eAx.aSP() != null) {
                        eyVar68 = this.evL.euP;
                        if (view == eyVar68.eAx.aSP().aQY()) {
                            eyVar69 = this.evL.euP;
                            eyVar69.aCY();
                            this.evL.ox(2);
                            this.evL.acp();
                            eyVar70 = this.evL.euP;
                            eyVar70.aSa();
                            djVar108 = this.evL.euf;
                            djVar108.aQy();
                            TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    eyVar28 = this.evL.euP;
                    if (eyVar28.eAx.aSP() != null) {
                        eyVar66 = this.evL.euP;
                        if (view == eyVar66.eAx.aSP().aQZ()) {
                            djVar104 = this.evL.euf;
                            if (djVar104 != null) {
                                djVar105 = this.evL.euf;
                                if (djVar105.getPbData() != null) {
                                    djVar106 = this.evL.euf;
                                    if (djVar106.getPbData().aOl() != null) {
                                        eyVar67 = this.evL.euP;
                                        eyVar67.eAx.od();
                                        PbActivity pbActivity2 = this.evL;
                                        djVar107 = this.evL.euf;
                                        pbActivity2.pq(djVar107.getPbData().aOl().se());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    eyVar29 = this.evL.euP;
                    if (eyVar29.eAx.aSP() != null) {
                        eyVar64 = this.evL.euP;
                        if (view == eyVar64.eAx.aSP().eyp) {
                            djVar101 = this.evL.euf;
                            if (djVar101 != null) {
                                djVar102 = this.evL.euf;
                                if (djVar102.getPbData() != null) {
                                    djVar103 = this.evL.euf;
                                    if (djVar103.getPbData().aOl() != null) {
                                        eyVar65 = this.evL.euP;
                                        eyVar65.eAx.od();
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.evL.getPageContext().getPageActivity(), 0, TbConfig.ECOMM_FEED_BACK_ID, TbConfig.ECOMM_FEED_BACK_NAME, null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0)));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    eyVar30 = this.evL.euP;
                    if (eyVar30.eAx.aSP() != null) {
                        eyVar60 = this.evL.euP;
                        if (view == eyVar60.eAx.aSP().aRa()) {
                            TiebaStatic.log("c10414");
                            eyVar61 = this.evL.euP;
                            eyVar61.aCY();
                            eyVar62 = this.evL.euP;
                            if (eyVar62.rF() != ey.eCd) {
                                djVar99 = this.evL.euf;
                                if (djVar99.aQM() != null) {
                                    djVar100 = this.evL.euf;
                                    djVar100.aQM().oA(dj.ewY);
                                    return;
                                }
                                return;
                            }
                            eyVar63 = this.evL.euP;
                            eyVar63.aSw();
                            return;
                        }
                    }
                    eyVar31 = this.evL.euP;
                    if (eyVar31.eAx.aSP() != null) {
                        eyVar57 = this.evL.euP;
                        if (view == eyVar57.eAx.aSP().aRb()) {
                            aPh = this.evL.aPh();
                            this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.evL.getPageContext().getPageActivity(), null, aPh, true)));
                            eyVar58 = this.evL.euP;
                            eyVar58.eAx.od();
                            eyVar59 = this.evL.euP;
                            eyVar59.eAx.aSP().aRn();
                            return;
                        }
                    }
                    dqVar = this.evL.euU;
                    if (dqVar != null) {
                        dqVar52 = this.evL.euU;
                        if (view == dqVar52.aQP()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.gm()) {
                                this.evL.showToast(r.j.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            if (!(tag instanceof String)) {
                                if (tag instanceof SparseArray) {
                                    SparseArray<Object> sparseArray6 = (SparseArray) tag;
                                    if ((sparseArray6.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(r.g.tag_user_mute_visible)).booleanValue()) {
                                        sparseArray6.put(r.g.tag_from, 0);
                                        sparseArray6.put(r.g.tag_check_mute_from, 2);
                                        this.evL.d(sparseArray6);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            this.evL.pq((String) tag);
                            return;
                        }
                    }
                    dqVar2 = this.evL.euU;
                    if (dqVar2 != null) {
                        dqVar51 = this.evL.euU;
                        if (view == dqVar51.aQN()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11739").s("obj_locate", 2));
                            if (!this.evL.checkUpIsLogin()) {
                                return;
                            }
                            this.evL.aT(view);
                            return;
                        }
                    }
                    dqVar3 = this.evL.euU;
                    if (dqVar3 != null) {
                        dqVar50 = this.evL.euU;
                        if (view == dqVar50.aQS()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11739").s("obj_locate", 1));
                            if (this.evL.checkUpIsLogin()) {
                                djVar94 = this.evL.euf;
                                if (djVar94.getPbData() != null) {
                                    eyVar56 = this.evL.euP;
                                    eyVar56.aCY();
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
                                        djVar95 = this.evL.euf;
                                        String threadID = djVar95.getThreadID();
                                        String id = qVar.getId();
                                        int i2 = 0;
                                        djVar96 = this.evL.euf;
                                        if (djVar96.getPbData() != null) {
                                            djVar98 = this.evL.euf;
                                            i2 = djVar98.getPbData().aOt();
                                        }
                                        this.evL.acp();
                                        pt4 = this.evL.pt(id);
                                        if (pt4 != null) {
                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.evL.getPageContext().getPageActivity());
                                            SmallTailInfo aTO = qVar.aTO();
                                            djVar97 = this.evL.euf;
                                            this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, true, null, i2, aTO, djVar97.getPbData().qs(), false, qVar.getAuthor().getIconInfo()).addBigImageData(pt4.ewc, pt4.ewd, pt4.ewe, pt4.index)));
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
                    dqVar4 = this.evL.euU;
                    if (dqVar4 != null) {
                        dqVar49 = this.evL.euU;
                        if (view == dqVar49.aQU()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11739").s("obj_locate", 3));
                            if (view.getTag(r.g.tag_pb_floor_postion) instanceof Integer) {
                                djVar92 = this.evL.euf;
                                if (djVar92 != null) {
                                    eyVar55 = this.evL.euP;
                                    eyVar55.aRT();
                                    if (!UtilHelper.isFloatWindowOpAllowed(this.evL.getPageContext().getPageActivity())) {
                                        this.evL.aPg();
                                        return;
                                    }
                                    int intValue = ((Integer) view.getTag(r.g.tag_pb_floor_postion)).intValue();
                                    int intValue2 = ((Integer) view.getTag(r.g.tag_pb_floor_number)).intValue();
                                    this.evL.euV = true;
                                    PbActivity pbActivity3 = this.evL;
                                    djVar93 = this.evL.euf;
                                    pbActivity3.a(djVar93.getPbData(), intValue, intValue2, true, true);
                                    TiebaStatic.log("c10834");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    dqVar5 = this.evL.euU;
                    if (dqVar5 != null) {
                        dqVar48 = this.evL.euU;
                        if (view == dqVar48.aQQ()) {
                            SparseArray sparseArray7 = (SparseArray) view.getTag();
                            if (sparseArray7 != null && (sparseArray7.get(r.g.tag_del_post_type) instanceof Integer) && (sparseArray7.get(r.g.tag_del_post_id) instanceof String) && (sparseArray7.get(r.g.tag_manage_user_identity) instanceof Integer) && (sparseArray7.get(r.g.tag_del_post_is_self) instanceof Boolean)) {
                                boolean booleanValue2 = ((Boolean) sparseArray7.get(r.g.tag_del_post_is_self)).booleanValue();
                                int intValue3 = ((Integer) sparseArray7.get(r.g.tag_manage_user_identity)).intValue();
                                if (!booleanValue2 && intValue3 != 0 && com.baidu.tieba.c.a.OR()) {
                                    Context baseContext = this.evL.getBaseContext();
                                    djVar91 = this.evL.euf;
                                    if (com.baidu.tieba.c.a.f(baseContext, djVar91.getThreadID(), (String) sparseArray7.get(r.g.tag_del_post_id))) {
                                        return;
                                    }
                                }
                                eyVar54 = this.evL.euP;
                                eyVar54.a(((Integer) sparseArray7.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(r.g.tag_del_post_id), intValue3, booleanValue2);
                                return;
                            }
                            return;
                        }
                    }
                    dqVar6 = this.evL.euU;
                    if (dqVar6 != null) {
                        dqVar47 = this.evL.euU;
                        if (view == dqVar47.aQR()) {
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
                            djVar90 = this.evL.euf;
                            com.baidu.tieba.pb.data.h pbData = djVar90.getPbData();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            if (pbData != null && pbData.aOk() != null) {
                                str3 = pbData.aOk().getId();
                                str4 = pbData.aOk().getName();
                                str5 = pbData.getThreadId();
                            }
                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                            this.evL.a(j, str2, str3, str4, str5, i3);
                            return;
                        }
                    }
                    eyVar32 = this.evL.euP;
                    if (eyVar32.aSx() == view) {
                        eyVar53 = this.evL.euP;
                        if (eyVar53.aSx().getIndicateStatus()) {
                            djVar89 = this.evL.euf;
                            com.baidu.tieba.pb.data.h pbData2 = djVar89.getPbData();
                            if (pbData2 != null && pbData2.aOl() != null && pbData2.aOl().rz() != null) {
                                String pw = pbData2.aOl().rz().pw();
                                if (StringUtils.isNull(pw)) {
                                    pw = pbData2.aOl().rz().getTaskId();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11107").ab("obj_id", pw));
                            }
                        } else {
                            com.baidu.tieba.tbadkCore.d.a.bU("c10725", null);
                        }
                        this.evL.aPB();
                        return;
                    }
                    eyVar33 = this.evL.euP;
                    if (eyVar33.aRV() != view) {
                        dqVar7 = this.evL.euU;
                        if (dqVar7 != null) {
                            dqVar46 = this.evL.euU;
                            if (view == dqVar46.aQO()) {
                                if (!com.baidu.adp.lib.util.i.gm()) {
                                    this.evL.showToast(r.j.network_not_available);
                                    return;
                                }
                                SparseArray<Object> sparseArray8 = (SparseArray) view.getTag();
                                if (sparseArray8 != null) {
                                    if (com.baidu.tieba.c.a.OR() && sparseArray8.get(r.g.tag_del_post_id) != null) {
                                        Context baseContext2 = this.evL.getBaseContext();
                                        djVar87 = this.evL.euf;
                                        if (com.baidu.tieba.c.a.f(baseContext2, djVar87.getThreadID(), (String) sparseArray8.get(r.g.tag_del_post_id))) {
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
                                            this.evL.d(sparseArray8);
                                            return;
                                        }
                                        sparseArray8.put(r.g.tag_check_mute_from, 2);
                                        eyVar52 = this.evL.euP;
                                        eyVar52.aX(view);
                                        return;
                                    } else if (booleanValue4) {
                                        eyVar51 = this.evL.euP;
                                        eyVar51.a(((Integer) sparseArray8.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(r.g.tag_del_post_id), ((Integer) sparseArray8.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(r.g.tag_del_post_is_self)).booleanValue());
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        eyVar34 = this.evL.euP;
                        if (view != eyVar34.aQk()) {
                            eyVar35 = this.evL.euP;
                            if (eyVar35.eAx.aSP() != null) {
                                eyVar45 = this.evL.euP;
                                if (view == eyVar45.eAx.aSP().aRk()) {
                                    if (com.baidu.adp.lib.util.i.gm()) {
                                        eyVar46 = this.evL.euP;
                                        eyVar46.aCY();
                                        eyVar47 = this.evL.euP;
                                        djVar77 = this.evL.euf;
                                        com.baidu.tieba.pb.data.h pbData3 = djVar77.getPbData();
                                        djVar78 = this.evL.euf;
                                        SparseArray<Object> c = eyVar47.c(pbData3, djVar78.aQp(), 1);
                                        if (c != null) {
                                            djVar79 = this.evL.euf;
                                            PbActivity pbActivity4 = this.evL;
                                            Activity pageActivity = this.evL.getPageContext().getPageActivity();
                                            djVar80 = this.evL.euf;
                                            String id2 = djVar80.getPbData().aOk().getId();
                                            djVar81 = this.evL.euf;
                                            String name2 = djVar81.getPbData().aOk().getName();
                                            djVar82 = this.evL.euf;
                                            pbActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id2, name2, djVar82.getPbData().aOl().getId(), String.valueOf(djVar79.getPbData().getUserData().getUserId()), (String) c.get(r.g.tag_forbid_user_name), (String) c.get(r.g.tag_forbid_user_post_id))));
                                            return;
                                        }
                                        return;
                                    }
                                    this.evL.showToast(r.j.network_not_available);
                                    return;
                                }
                            }
                            eyVar36 = this.evL.euP;
                            if (eyVar36.eAx.aSP() != null) {
                                eyVar41 = this.evL.euP;
                                if (view == eyVar41.eAx.aSP().aRh()) {
                                    if (com.baidu.adp.lib.util.i.gm()) {
                                        eyVar42 = this.evL.euP;
                                        djVar75 = this.evL.euf;
                                        com.baidu.tieba.pb.data.h pbData4 = djVar75.getPbData();
                                        djVar76 = this.evL.euf;
                                        SparseArray<Object> c2 = eyVar42.c(pbData4, djVar76.aQp(), 1);
                                        if (c2 != null) {
                                            eyVar44 = this.evL.euP;
                                            eyVar44.a(((Integer) c2.get(r.g.tag_del_post_type)).intValue(), (String) c2.get(r.g.tag_del_post_id), ((Integer) c2.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(r.g.tag_del_post_is_self)).booleanValue());
                                        }
                                        eyVar43 = this.evL.euP;
                                        eyVar43.eAx.od();
                                        return;
                                    }
                                    this.evL.showToast(r.j.network_not_available);
                                    return;
                                }
                            }
                            if (view.getId() != r.g.sub_pb_more && view.getId() != r.g.sub_pb_item) {
                                eyVar38 = this.evL.euP;
                                if (view == eyVar38.aOX()) {
                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                        long c3 = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                        djVar72 = this.evL.euf;
                                        long c4 = com.baidu.adp.lib.h.b.c(djVar72.getPbData().getForumId(), 0L);
                                        djVar73 = this.evL.euf;
                                        long c5 = com.baidu.adp.lib.h.b.c(djVar73.getThreadID(), 0L);
                                        djVar74 = this.evL.euf;
                                        this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.evL.getPageContext().getPageActivity(), 24008, c4, c5, c3, djVar74.getPbData().aOl().sh())));
                                        return;
                                    }
                                    return;
                                }
                                int id3 = view.getId();
                                if (id3 == r.g.pb_u9_text_view) {
                                    if (this.evL.checkUpIsLogin() && (brVar = (com.baidu.tbadk.core.data.br) view.getTag()) != null && !StringUtils.isNull(brVar.tf())) {
                                        TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                        com.baidu.tbadk.core.util.bf.vP().c(this.evL.getPageContext(), new String[]{brVar.tf()});
                                        return;
                                    }
                                    return;
                                } else if (id3 == r.g.replybtn || id3 == r.g.cover_reply_content) {
                                    dqVar8 = this.evL.euU;
                                    if (dqVar8 == null) {
                                        this.evL.euU = new dq(this.evL.getPageContext(), this.evL.bTO);
                                        dqVar45 = this.evL.euU;
                                        z7 = this.evL.mIsLogin;
                                        dqVar45.iB(z7);
                                    }
                                    dqVar9 = this.evL.euU;
                                    dqVar9.GP();
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11740"));
                                    com.baidu.tieba.tbadkCore.data.q qVar3 = null;
                                    if (view != null && view.getTag() != null) {
                                        qVar3 = (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_load_sub_data);
                                        if (!this.evL.aPv()) {
                                            djVar24 = this.evL.euf;
                                            if (djVar24.aQz() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                                                dqVar44 = this.evL.euU;
                                                dqVar44.aQW();
                                                sparseArray = (SparseArray) view.getTag();
                                                if (sparseArray.get(r.g.tag_pb_floor_postion) instanceof Integer) {
                                                    int intValue4 = ((Integer) sparseArray.get(r.g.tag_pb_floor_postion)).intValue();
                                                    int intValue5 = ((Integer) sparseArray.get(r.g.tag_pb_floor_number)).intValue();
                                                    dqVar42 = this.evL.euU;
                                                    dqVar42.aQU().setTag(r.g.tag_pb_floor_postion, Integer.valueOf(intValue4));
                                                    dqVar43 = this.evL.euU;
                                                    dqVar43.aQU().setTag(r.g.tag_pb_floor_number, Integer.valueOf(intValue5));
                                                }
                                                SparseArray sparseArray9 = new SparseArray();
                                                sparseArray9.put(r.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_clip_board));
                                                sparseArray9.put(r.g.tag_is_subpb, false);
                                                dqVar15 = this.evL.euU;
                                                dqVar15.aQN().setTag(sparseArray9);
                                                dqVar16 = this.evL.euU;
                                                dqVar16.aQS().setTag(view.getTag());
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
                                                        dqVar41 = this.evL.euU;
                                                        dqVar41.aQQ().setVisibility(0);
                                                    } else {
                                                        sparseArray10.put(r.g.tag_should_delete_visible, false);
                                                        dqVar36 = this.evL.euU;
                                                        dqVar36.aQQ().setVisibility(8);
                                                    }
                                                    dqVar37 = this.evL.euU;
                                                    dqVar37.aQO().setTag(sparseArray10);
                                                    dqVar38 = this.evL.euU;
                                                    dqVar38.aQQ().setTag(sparseArray10);
                                                    dqVar39 = this.evL.euU;
                                                    dqVar39.aQO().setText(r.j.bar_manager);
                                                    dqVar40 = this.evL.euU;
                                                    dqVar40.aQO().setVisibility(0);
                                                } else if (!booleanValue7) {
                                                    dqVar17 = this.evL.euU;
                                                    dqVar17.aQO().setVisibility(8);
                                                    dqVar18 = this.evL.euU;
                                                    dqVar18.aQQ().setVisibility(8);
                                                } else {
                                                    SparseArray sparseArray11 = new SparseArray();
                                                    sparseArray11.put(r.g.tag_should_manage_visible, false);
                                                    sparseArray11.put(r.g.tag_user_mute_visible, false);
                                                    sparseArray11.put(r.g.tag_should_delete_visible, true);
                                                    sparseArray11.put(r.g.tag_manage_user_identity, sparseArray2.get(r.g.tag_manage_user_identity));
                                                    sparseArray11.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                    sparseArray11.put(r.g.tag_del_post_id, sparseArray2.get(r.g.tag_del_post_id));
                                                    sparseArray11.put(r.g.tag_del_post_type, sparseArray2.get(r.g.tag_del_post_type));
                                                    dqVar19 = this.evL.euU;
                                                    dqVar19.aQO().setTag(sparseArray11);
                                                    dqVar20 = this.evL.euU;
                                                    dqVar20.aQQ().setTag(sparseArray11);
                                                    dqVar21 = this.evL.euU;
                                                    dqVar21.aQO().setText(r.j.delete);
                                                    dqVar22 = this.evL.euU;
                                                    dqVar22.aQQ().setVisibility(0);
                                                    dqVar23 = this.evL.euU;
                                                    dqVar23.aQO().setVisibility(8);
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
                                                    dqVar32 = this.evL.euU;
                                                    dqVar32.aQP().setTag(sparseArray12);
                                                    dqVar33 = this.evL.euU;
                                                    dqVar33.aQP().setVisibility(0);
                                                    dqVar34 = this.evL.euU;
                                                    dqVar34.aQO().setVisibility(8);
                                                    dqVar35 = this.evL.euU;
                                                    dqVar35.aQP().setText(r.j.mute_option);
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
                                                    iq = this.evL.iq(z5);
                                                    isLogin = iq & this.evL.isLogin();
                                                    this.evL.evC = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(r.g.tag_clip_board);
                                                    if (!(!ex.h(this.evL.evC) ? false : isLogin)) {
                                                        dqVar25 = this.evL.euU;
                                                        dqVar25.aQP().setVisibility(0);
                                                        dqVar26 = this.evL.euU;
                                                        dqVar26.aQP().setTag(str7);
                                                    } else {
                                                        dqVar24 = this.evL.euU;
                                                        dqVar24.aQP().setVisibility(8);
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
                                                    dqVar28 = this.evL.euU;
                                                    dqVar28.aQR().setVisibility(0);
                                                    dqVar29 = this.evL.euU;
                                                    dqVar29.aQR().setTag(r.g.tag_chudian_template_id, Long.valueOf(j2));
                                                    dqVar30 = this.evL.euU;
                                                    dqVar30.aQR().setTag(r.g.tag_chudian_monitor_id, str);
                                                    dqVar31 = this.evL.euU;
                                                    dqVar31.aQR().setTag(r.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                } else {
                                                    dqVar27 = this.evL.euU;
                                                    dqVar27.aQR().setVisibility(8);
                                                }
                                            }
                                        }
                                        dqVar14 = this.evL.euU;
                                        dqVar14.aQV();
                                        sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray.get(r.g.tag_pb_floor_postion) instanceof Integer) {
                                        }
                                        SparseArray sparseArray92 = new SparseArray();
                                        sparseArray92.put(r.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.q) ((SparseArray) view.getTag()).get(r.g.tag_clip_board));
                                        sparseArray92.put(r.g.tag_is_subpb, false);
                                        dqVar15 = this.evL.euU;
                                        dqVar15.aQN().setTag(sparseArray92);
                                        dqVar16 = this.evL.euU;
                                        dqVar16.aQS().setTag(view.getTag());
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
                                        iq = this.evL.iq(z5);
                                        isLogin = iq & this.evL.isLogin();
                                        this.evL.evC = (com.baidu.tieba.tbadkCore.data.q) sparseArray3.get(r.g.tag_clip_board);
                                        if (!(!ex.h(this.evL.evC) ? false : isLogin)) {
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
                                    djVar22 = this.evL.euf;
                                    if (djVar22.getPbData().nz()) {
                                        djVar23 = this.evL.euf;
                                        String ny = djVar23.getPbData().ny();
                                        if (qVar3 != null && !com.baidu.adp.lib.util.j.isEmpty(ny) && ny.equals(qVar3.getId())) {
                                            z2 = true;
                                            if (!z2) {
                                                dqVar13 = this.evL.euU;
                                                dqVar13.aQN().setText(r.j.remove_mark);
                                            } else {
                                                dqVar10 = this.evL.euU;
                                                dqVar10.aQN().setText(r.j.mark);
                                            }
                                            dqVar11 = this.evL.euU;
                                            dqVar11.iC(true);
                                            dqVar12 = this.evL.euU;
                                            dqVar12.wj();
                                            return;
                                        }
                                    }
                                    z2 = false;
                                    if (!z2) {
                                    }
                                    dqVar11 = this.evL.euU;
                                    dqVar11.iC(true);
                                    dqVar12 = this.evL.euU;
                                    dqVar12.wj();
                                    return;
                                } else if (id3 == r.g.pb_act_btn) {
                                    djVar66 = this.evL.euf;
                                    if (djVar66.getPbData() != null) {
                                        djVar67 = this.evL.euf;
                                        if (djVar67.getPbData().aOl() != null) {
                                            djVar68 = this.evL.euf;
                                            if (djVar68.getPbData().aOl().su() != null) {
                                                Activity activity = this.evL.getActivity();
                                                djVar69 = this.evL.euf;
                                                com.baidu.tbadk.browser.f.u(activity, djVar69.getPbData().aOl().su());
                                                djVar70 = this.evL.euf;
                                                if (djVar70.getPbData().aOl().ss() != 1) {
                                                    djVar71 = this.evL.euf;
                                                    if (djVar71.getPbData().aOl().ss() == 2) {
                                                        TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (id3 == r.g.lottery_tail) {
                                    if (view.getTag(r.g.tag_pb_lottery_tail_link) instanceof String) {
                                        String str8 = (String) view.getTag(r.g.tag_pb_lottery_tail_link);
                                        com.baidu.tbadk.core.util.av avVar3 = new com.baidu.tbadk.core.util.av("c10912");
                                        djVar63 = this.evL.euf;
                                        com.baidu.tbadk.core.util.av ab = avVar3.ab("fid", djVar63.getPbData().getForumId());
                                        djVar64 = this.evL.euf;
                                        TiebaStatic.log(ab.ab("tid", djVar64.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                        djVar65 = this.evL.euf;
                                        if (djVar65.getPbData().getThreadId().equals(str8)) {
                                            eyVar40 = this.evL.euP;
                                            eyVar40.setSelection(0);
                                            return;
                                        }
                                        this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.evL.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                        return;
                                    }
                                    return;
                                } else if (id3 == r.g.pb_item_tail_content) {
                                    if (com.baidu.tbadk.core.util.bk.ak(this.evL.getPageContext().getPageActivity())) {
                                        String string = TbadkCoreApplication.m9getInst().getString(r.j.tail_web_view_title);
                                        String string2 = com.baidu.tbadk.core.sharedPref.b.um().getString("tail_link", "");
                                        if (!StringUtils.isNull(string2)) {
                                            TiebaStatic.log("c10056");
                                            com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                        }
                                        eyVar39 = this.evL.euP;
                                        eyVar39.aRJ();
                                        return;
                                    }
                                    return;
                                } else if (id3 == r.g.join_vote_tv) {
                                    if (view != null) {
                                        com.baidu.tbadk.browser.f.u(this.evL.getActivity(), (String) view.getTag());
                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                        aPi3 = this.evL.aPi();
                                        if (aPi3 == 1) {
                                            djVar59 = this.evL.euf;
                                            if (djVar59 != null) {
                                                djVar60 = this.evL.euf;
                                                if (djVar60.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.av avVar4 = new com.baidu.tbadk.core.util.av("c10397");
                                                    djVar61 = this.evL.euf;
                                                    com.baidu.tbadk.core.util.av ab2 = avVar4.ab("fid", djVar61.getPbData().getForumId());
                                                    djVar62 = this.evL.euf;
                                                    TiebaStatic.log(ab2.ab("tid", djVar62.getPbData().getThreadId()).ab("uid", currentAccount));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        aPi4 = this.evL.aPi();
                                        if (aPi4 == 2) {
                                            djVar55 = this.evL.euf;
                                            if (djVar55 != null) {
                                                djVar56 = this.evL.euf;
                                                if (djVar56.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.av avVar5 = new com.baidu.tbadk.core.util.av("c10401");
                                                    djVar57 = this.evL.euf;
                                                    com.baidu.tbadk.core.util.av ab3 = avVar5.ab("fid", djVar57.getPbData().getForumId());
                                                    djVar58 = this.evL.euf;
                                                    TiebaStatic.log(ab3.ab("tid", djVar58.getPbData().getThreadId()).ab("uid", currentAccount));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (id3 == r.g.look_all_tv) {
                                    if (view != null) {
                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                        com.baidu.tbadk.browser.f.u(this.evL.getActivity(), (String) view.getTag());
                                        aPi = this.evL.aPi();
                                        if (aPi == 1) {
                                            djVar51 = this.evL.euf;
                                            if (djVar51 != null) {
                                                djVar52 = this.evL.euf;
                                                if (djVar52.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.av avVar6 = new com.baidu.tbadk.core.util.av("c10507");
                                                    djVar53 = this.evL.euf;
                                                    com.baidu.tbadk.core.util.av ab4 = avVar6.ab("fid", djVar53.getPbData().getForumId());
                                                    djVar54 = this.evL.euf;
                                                    TiebaStatic.log(ab4.ab("tid", djVar54.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        aPi2 = this.evL.aPi();
                                        if (aPi2 == 2) {
                                            djVar47 = this.evL.euf;
                                            if (djVar47 != null) {
                                                djVar48 = this.evL.euf;
                                                if (djVar48.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.av avVar7 = new com.baidu.tbadk.core.util.av("c10508");
                                                    djVar49 = this.evL.euf;
                                                    com.baidu.tbadk.core.util.av ab5 = avVar7.ab("fid", djVar49.getPbData().getForumId());
                                                    djVar50 = this.evL.euf;
                                                    TiebaStatic.log(ab5.ab("tid", djVar50.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (id3 != r.g.manga_prev_btn) {
                                    if (id3 != r.g.manga_next_btn) {
                                        if (id3 == r.g.pb_ecomm_like_button) {
                                            djVar41 = this.evL.euf;
                                            if (djVar41 != null) {
                                                djVar43 = this.evL.euf;
                                                if (djVar43.getPbData() != null) {
                                                    djVar44 = this.evL.euf;
                                                    if (djVar44.getPbData().aOl() != null) {
                                                        djVar45 = this.evL.euf;
                                                        if (djVar45.getPbData().aOl().Ve != null) {
                                                            if (com.baidu.tbadk.core.util.bk.ak(this.evL.getPageContext().getPageActivity())) {
                                                                djVar46 = this.evL.euf;
                                                                DealInfoData dealInfoData = djVar46.getPbData().aOl().Ve;
                                                                long j3 = dealInfoData.productId;
                                                                if (dealInfoData.hasRecommend) {
                                                                    pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, false);
                                                                } else {
                                                                    pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, true);
                                                                }
                                                                this.evL.sendMessage(pbEcommRecommendMessage);
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            com.baidu.tbadk.core.util.av avVar8 = new com.baidu.tbadk.core.util.av("c11428");
                                            avVar8.s("obj_param1", 1);
                                            djVar42 = this.evL.euf;
                                            avVar8.ab("obj_id", new StringBuilder(String.valueOf(djVar42.getPbData().aOl().Ve.productId)).toString());
                                            avVar8.s("obj_locate", 3);
                                            if (avVar8 != null) {
                                                TiebaStatic.log(avVar8);
                                                return;
                                            }
                                            return;
                                        } else if (id3 == r.g.pb_editor_tool_comment_ecomm_buy_layout) {
                                            djVar33 = this.evL.euf;
                                            if (djVar33 != null) {
                                                djVar35 = this.evL.euf;
                                                if (djVar35.getPbData() != null) {
                                                    djVar36 = this.evL.euf;
                                                    if (djVar36.getPbData().aOl() != null) {
                                                        djVar37 = this.evL.euf;
                                                        if (djVar37.getPbData().aOl().Ve != null) {
                                                            if (com.baidu.tbadk.core.util.bk.ak(this.evL.getPageContext().getPageActivity())) {
                                                                djVar38 = this.evL.euf;
                                                                long j4 = djVar38.getPbData().aOl().Ve.productId;
                                                                djVar39 = this.evL.euf;
                                                                String threadID2 = djVar39.getThreadID();
                                                                djVar40 = this.evL.euf;
                                                                String name3 = djVar40.getPbData().aOk().getName();
                                                                EcommEnsureOrderActivityConfig ecommEnsureOrderActivityConfig = new EcommEnsureOrderActivityConfig(this.evL.getPageContext().getPageActivity(), j4, threadID2);
                                                                ecommEnsureOrderActivityConfig.setForumName(name3);
                                                                this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommEnsureOrderActivityConfig));
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            com.baidu.tbadk.core.util.av avVar9 = new com.baidu.tbadk.core.util.av("c11428");
                                            avVar9.s("obj_param1", 1);
                                            djVar34 = this.evL.euf;
                                            avVar9.ab("obj_id", new StringBuilder(String.valueOf(djVar34.getPbData().aOl().Ve.productId)).toString());
                                            avVar9.s("obj_locate", 2);
                                            if (avVar9 != null) {
                                                TiebaStatic.log(avVar9);
                                                return;
                                            }
                                            return;
                                        } else if (id3 == r.g.yule_head_img_img) {
                                            djVar29 = this.evL.euf;
                                            if (djVar29 != null) {
                                                djVar30 = this.evL.euf;
                                                if (djVar30.getPbData() != null) {
                                                    djVar31 = this.evL.euf;
                                                    if (djVar31.getPbData().aOz() != null) {
                                                        djVar32 = this.evL.euf;
                                                        com.baidu.tieba.pb.data.h pbData5 = djVar32.getPbData();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11679").ab("fid", pbData5.getForumId()));
                                                        com.baidu.tbadk.core.util.bf.vP().c(this.evL.getPageContext(), new String[]{pbData5.aOz().aOC()});
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else if (id3 == r.g.yule_head_img_all_rank) {
                                            djVar25 = this.evL.euf;
                                            if (djVar25 != null) {
                                                djVar26 = this.evL.euf;
                                                if (djVar26.getPbData() != null) {
                                                    djVar27 = this.evL.euf;
                                                    if (djVar27.getPbData().aOz() != null) {
                                                        djVar28 = this.evL.euf;
                                                        com.baidu.tieba.pb.data.h pbData6 = djVar28.getPbData();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11678").ab("fid", pbData6.getForumId()));
                                                        com.baidu.tbadk.core.util.bf.vP().c(this.evL.getPageContext(), new String[]{pbData6.aOz().aOC()});
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
                                    this.evL.aPx();
                                    return;
                                } else {
                                    this.evL.aPw();
                                    return;
                                }
                            } else if (this.evL.checkUpIsLogin()) {
                                djVar7 = this.evL.euf;
                                if (djVar7.getPbData() != null) {
                                    eyVar37 = this.evL.euP;
                                    eyVar37.aCY();
                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                    com.baidu.tieba.tbadkCore.data.q qVar4 = (com.baidu.tieba.tbadkCore.data.q) sparseArray13.get(r.g.tag_load_sub_data);
                                    View view2 = (View) sparseArray13.get(r.g.tag_load_sub_view);
                                    if (qVar4 != null && view2 != null) {
                                        djVar8 = this.evL.euf;
                                        String threadID3 = djVar8.getThreadID();
                                        String id4 = qVar4.getId();
                                        int i4 = 0;
                                        djVar9 = this.evL.euf;
                                        if (djVar9.getPbData() != null) {
                                            djVar20 = this.evL.euf;
                                            i4 = djVar20.getPbData().aOt();
                                        }
                                        this.evL.acp();
                                        if (view.getId() != r.g.replybtn) {
                                            if (view.getId() == r.g.sub_pb_item) {
                                                SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                String str9 = (String) sparseArray14.get(r.g.tag_photo_username);
                                                String str10 = (String) sparseArray13.get(r.g.tag_photo_userid);
                                                com.baidu.tieba.tbadkCore.data.q qVar5 = (com.baidu.tieba.tbadkCore.data.q) sparseArray14.get(r.g.tag_load_sub_data);
                                                String str11 = null;
                                                if (qVar5 != null) {
                                                    str11 = qVar5.getId();
                                                }
                                                TiebaStatic.log("c11741");
                                                pt2 = this.evL.pt(id4);
                                                if (qVar4 != null) {
                                                    djVar13 = this.evL.euf;
                                                    if (djVar13 != null) {
                                                        djVar14 = this.evL.euf;
                                                        if (djVar14.getPbData() != null && pt2 != null && this.evL.aPc().aRH() != null) {
                                                            com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                                                            djVar15 = this.evL.euf;
                                                            nVar2.b(djVar15.getPbData().aOk());
                                                            djVar16 = this.evL.euf;
                                                            nVar2.c(djVar16.getPbData().aOl());
                                                            nVar2.b(qVar5);
                                                            this.evL.aPc().aRH().c(nVar2);
                                                            this.evL.aPc().aRH().setPostId(str11);
                                                            this.evL.a(view, str10, str9);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            TiebaStatic.log("c11742");
                                            pt = this.evL.pt(id4);
                                            if (qVar4 != null) {
                                                djVar10 = this.evL.euf;
                                                if (djVar10 != null) {
                                                    djVar11 = this.evL.euf;
                                                    if (djVar11.getPbData() != null && pt != null) {
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.evL.getPageContext().getPageActivity());
                                                        SmallTailInfo aTO2 = qVar4.aTO();
                                                        djVar12 = this.evL.euf;
                                                        this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID3, id4, "pb", true, null, false, null, i4, aTO2, djVar12.getPbData().qs(), false, qVar4.getAuthor().getIconInfo()).addBigImageData(pt.ewc, pt.ewd, pt.ewe, pt.index)));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        pt3 = this.evL.pt(id4);
                                        if (qVar4 != null) {
                                            djVar17 = this.evL.euf;
                                            if (djVar17 != null) {
                                                djVar18 = this.evL.euf;
                                                if (djVar18.getPbData() != null && pt3 != null) {
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.evL.getPageContext().getPageActivity());
                                                    SmallTailInfo aTO3 = qVar4.aTO();
                                                    djVar19 = this.evL.euf;
                                                    this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID3, id4, "pb", true, null, true, null, i4, aTO3, djVar19.getPbData().qs(), false, qVar4.getAuthor().getIconInfo()).addBigImageData(pt3.ewc, pt3.ewd, pt3.ewe, pt3.index)));
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
                                com.baidu.tbadk.core.util.av s = new com.baidu.tbadk.core.util.av("c10517").s("obj_locate", 3);
                                djVar21 = this.evL.euf;
                                TiebaStatic.log(s.ab("fid", djVar21.getPbData().getForumId()));
                                return;
                            }
                        } else if (this.evL.checkUpIsLogin()) {
                            eyVar48 = this.evL.euP;
                            if (!eyVar48.aQh()) {
                                djVar83 = this.evL.euf;
                                if (djVar83 != null) {
                                    djVar84 = this.evL.euf;
                                    if (djVar84.aQK() != null) {
                                        djVar85 = this.evL.euf;
                                        if (djVar85.aQK().aQb() != null) {
                                            djVar86 = this.evL.euf;
                                            if (com.baidu.tbadk.core.util.x.s(djVar86.aQK().aQb().getItems()) != 0) {
                                                eyVar49 = this.evL.euP;
                                                eyVar49.aQi();
                                                return;
                                            }
                                            this.evL.showToast(r.j.graffiti_quick_vote_empty);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            eyVar50 = this.evL.euP;
                            eyVar50.aQj();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.evL.checkUpIsLogin()) {
                        com.baidu.tbadk.core.util.av s2 = new com.baidu.tbadk.core.util.av("c10517").s("obj_locate", 2);
                        djVar88 = this.evL.euf;
                        TiebaStatic.log(s2.ab("fid", djVar88.getPbData().getForumId()));
                        return;
                    } else {
                        this.evL.aOZ();
                        return;
                    }
                } else if (com.baidu.adp.lib.util.i.gm()) {
                    eyVar17 = this.evL.euP;
                    eyVar17.aRJ();
                    z = this.evL.mIsLoading;
                    if (!z) {
                        this.evL.mIsLoading = true;
                        eyVar18 = this.evL.euP;
                        eyVar18.eAx.eDI.setEnabled(false);
                        eyVar19 = this.evL.euP;
                        eyVar19.awz();
                        this.evL.acp();
                        eyVar20 = this.evL.euP;
                        eyVar20.aSa();
                        djVar6 = this.evL.euf;
                        aPu = this.evL.aPu();
                        djVar6.pw(aPu);
                        TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        eyVar21 = this.evL.euP;
                        eyVar21.aSs();
                        eyVar22 = this.evL.euP;
                        eyVar22.aQj();
                        this.evL.ox(2);
                        return;
                    }
                    return;
                } else {
                    this.evL.showToast(r.j.network_not_available);
                    return;
                }
            }
            TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            djVar121 = this.evL.euf;
            if (djVar121.getErrorNo() == 4) {
                djVar124 = this.evL.euf;
                if (StringUtils.isNull(djVar124.aQo())) {
                    djVar125 = this.evL.euf;
                    if (djVar125.getAppealInfo() != null) {
                        djVar126 = this.evL.euf;
                        name = djVar126.getAppealInfo().forumName;
                    }
                }
                this.evL.finish();
                return;
            }
            djVar122 = this.evL.euf;
            name = djVar122.getPbData().aOk().getName();
            if (!StringUtils.isNull(name)) {
                djVar123 = this.evL.euf;
                String aQo = djVar123.aQo();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.evL.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                if (StringUtils.isNull(aQo)) {
                    this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                } else if (aQo.equals(name)) {
                    this.evL.finish();
                    return;
                } else {
                    this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                }
            }
            this.evL.finish();
            return;
        }
        if (com.baidu.adp.lib.util.i.gm()) {
            djVar = this.evL.euf;
            if (djVar.getPbData().aOt() == 1) {
                aVar = this.evL.euO;
                if (!aVar.bmU()) {
                    eyVar6 = this.evL.euP;
                    eyVar6.aCY();
                    int i5 = 0;
                    eyVar7 = this.evL.euP;
                    if (view == eyVar7.eAx.aSP().aRg()) {
                        djVar5 = this.evL.euf;
                        if (djVar5.getPbData().aOl().rL() == 1) {
                            i5 = 5;
                        } else {
                            i5 = 4;
                        }
                    } else {
                        eyVar8 = this.evL.euP;
                        if (view == eyVar8.eAx.aSP().aRi()) {
                            djVar2 = this.evL.euf;
                            if (djVar2.getPbData().aOl().rM() == 1) {
                                i5 = 3;
                            } else {
                                i5 = 6;
                            }
                        } else {
                            eyVar9 = this.evL.euP;
                            if (view == eyVar9.aRY()) {
                                i5 = 2;
                            }
                        }
                    }
                    djVar3 = this.evL.euf;
                    ForumData aOk = djVar3.getPbData().aOk();
                    String name4 = aOk.getName();
                    String id5 = aOk.getId();
                    djVar4 = this.evL.euf;
                    String id6 = djVar4.getPbData().aOl().getId();
                    if (!com.baidu.tieba.c.a.OR() || !com.baidu.tieba.c.a.f(this.evL.getBaseContext(), id6, null)) {
                        eyVar10 = this.evL.euP;
                        eyVar10.aRX();
                        aVar2 = this.evL.euO;
                        eyVar11 = this.evL.euP;
                        aVar2.a(id5, name4, id6, i5, eyVar11.aRZ());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.evL.showToast(r.j.network_not_available);
    }
}
