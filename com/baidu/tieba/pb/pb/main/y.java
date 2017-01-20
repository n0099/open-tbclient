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
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v130, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v134, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v171, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x084b, code lost:
        if (r18 == r1.enK.aOy().Rb()) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02a3, code lost:
        if (r18 == r1.enK.aOy().aMS()) goto L797;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:501:0x171a  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x17d5  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x17ed  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x17f7  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x18ef  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x19d5  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x19ec  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x1a02  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x1a14  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x1a22  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x1aa5  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x1b05  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x1bd5  */
    /* JADX WARN: Removed duplicated region for block: B:559:0x1bed  */
    /* JADX WARN: Removed duplicated region for block: B:562:0x1c20  */
    /* JADX WARN: Removed duplicated region for block: B:564:0x1c23  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x1c44  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x1c57  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x1c6a  */
    /* JADX WARN: Removed duplicated region for block: B:657:0x2102  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x2105  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x2108  */
    /* JADX WARN: Removed duplicated region for block: B:660:0x210b  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x210e  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x2111  */
    /* JADX WARN: Removed duplicated region for block: B:663:0x2114  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0353  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        ez ezVar4;
        ez ezVar5;
        PbModel pbModel;
        ForumManageModel forumManageModel;
        ez ezVar6;
        ez ezVar7;
        ez ezVar8;
        ez ezVar9;
        ez ezVar10;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        String id;
        ez ezVar11;
        ForumManageModel forumManageModel2;
        ez ezVar12;
        ez ezVar13;
        PbModel pbModel5;
        ez ezVar14;
        ez ezVar15;
        ez ezVar16;
        ez ezVar17;
        ez ezVar18;
        ez ezVar19;
        boolean z;
        ez ezVar20;
        ez ezVar21;
        ez ezVar22;
        PbModel pbModel6;
        String aLg;
        ez ezVar23;
        ez ezVar24;
        ez ezVar25;
        ez ezVar26;
        ez ezVar27;
        ez ezVar28;
        ez ezVar29;
        ez ezVar30;
        ez ezVar31;
        ez ezVar32;
        ez ezVar33;
        dq dqVar;
        dq dqVar2;
        dq dqVar3;
        dq dqVar4;
        dq dqVar5;
        dq dqVar6;
        ez ezVar34;
        ez ezVar35;
        dq dqVar7;
        ez ezVar36;
        ez ezVar37;
        ez ezVar38;
        PbModel pbModel7;
        ez ezVar39;
        PbModel pbModel8;
        PbModel pbModel9;
        PbActivity.b ol;
        PbModel pbModel10;
        PbModel pbModel11;
        PbModel pbModel12;
        PbActivity.b ol2;
        PbModel pbModel13;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        PbActivity.b ol3;
        PbModel pbModel17;
        PbModel pbModel18;
        PbModel pbModel19;
        PbModel pbModel20;
        PbModel pbModel21;
        ez ezVar40;
        dq dqVar8;
        dq dqVar9;
        PbModel pbModel22;
        boolean z2;
        dq dqVar10;
        dq dqVar11;
        dq dqVar12;
        dq dqVar13;
        PbModel pbModel23;
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
        boolean io;
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
        PbModel pbModel24;
        dq dqVar44;
        dq dqVar45;
        boolean z7;
        PbModel pbModel25;
        PbModel pbModel26;
        PbModel pbModel27;
        PbModel pbModel28;
        PbModel pbModel29;
        PbModel pbModel30;
        PbModel pbModel31;
        PbModel pbModel32;
        int aKU;
        int aKU2;
        PbModel pbModel33;
        PbModel pbModel34;
        PbModel pbModel35;
        PbModel pbModel36;
        PbModel pbModel37;
        PbModel pbModel38;
        PbModel pbModel39;
        PbModel pbModel40;
        int aKU3;
        int aKU4;
        PbModel pbModel41;
        PbModel pbModel42;
        PbModel pbModel43;
        PbModel pbModel44;
        PbModel pbModel45;
        PbModel pbModel46;
        PbModel pbModel47;
        PbModel pbModel48;
        ez ezVar41;
        PbModel pbModel49;
        PbModel pbModel50;
        PbModel pbModel51;
        ez ezVar42;
        PbModel pbModel52;
        PbModel pbModel53;
        PbModel pbModel54;
        PbModel pbModel55;
        PbModel pbModel56;
        PbModel pbModel57;
        com.baidu.tbadk.core.data.bn bnVar;
        PbModel pbModel58;
        PbModel pbModel59;
        PbModel pbModel60;
        ez ezVar43;
        ez ezVar44;
        PbModel pbModel61;
        PbModel pbModel62;
        ez ezVar45;
        ez ezVar46;
        ez ezVar47;
        ez ezVar48;
        ez ezVar49;
        PbModel pbModel63;
        PbModel pbModel64;
        PbModel pbModel65;
        PbModel pbModel66;
        PbModel pbModel67;
        PbModel pbModel68;
        ez ezVar50;
        PbModel pbModel69;
        PbModel pbModel70;
        PbModel pbModel71;
        PbModel pbModel72;
        ez ezVar51;
        ez ezVar52;
        dq dqVar46;
        ez ezVar53;
        ez ezVar54;
        PbModel pbModel73;
        PbModel pbModel74;
        ez ezVar55;
        PbModel pbModel75;
        dq dqVar47;
        PbModel pbModel76;
        dq dqVar48;
        ez ezVar56;
        PbModel pbModel77;
        dq dqVar49;
        PbModel pbModel78;
        ez ezVar57;
        PbModel pbModel79;
        dq dqVar50;
        PbModel pbModel80;
        ez ezVar58;
        SparseArray sparseArray5;
        com.baidu.tieba.tbadkCore.data.p pVar;
        PbModel pbModel81;
        PbModel pbModel82;
        PbActivity.b ol4;
        PbModel pbModel83;
        PbModel pbModel84;
        dq dqVar51;
        dq dqVar52;
        ez ezVar59;
        String aKT;
        ez ezVar60;
        ez ezVar61;
        ez ezVar62;
        ez ezVar63;
        ez ezVar64;
        PbModel pbModel85;
        PbModel pbModel86;
        ez ezVar65;
        ez ezVar66;
        PbModel pbModel87;
        PbModel pbModel88;
        PbModel pbModel89;
        ez ezVar67;
        PbModel pbModel90;
        ez ezVar68;
        ez ezVar69;
        ez ezVar70;
        PbModel pbModel91;
        ez ezVar71;
        ez ezVar72;
        PbModel pbModel92;
        ez ezVar73;
        PbModel pbModel93;
        ez ezVar74;
        ez ezVar75;
        PbModel pbModel94;
        PbModel pbModel95;
        PbModel pbModel96;
        PbModel pbModel97;
        PbModel pbModel98;
        ez ezVar76;
        ez ezVar77;
        ez ezVar78;
        ez ezVar79;
        ez ezVar80;
        ez ezVar81;
        boolean z8;
        ez ezVar82;
        ez ezVar83;
        ez ezVar84;
        PbModel pbModel99;
        String aLg2;
        ez ezVar85;
        ez ezVar86;
        ez ezVar87;
        ez ezVar88;
        boolean oq;
        PbModel pbModel100;
        ez ezVar89;
        PbModel pbModel101;
        PbModel pbModel102;
        PbModel pbModel103;
        PbModel pbModel104;
        ez ezVar90;
        ez ezVar91;
        PbModel pbModel105;
        PbModel pbModel106;
        PbModel pbModel107;
        String name;
        PbModel pbModel108;
        PbModel pbModel109;
        PbModel pbModel110;
        PbModel pbModel111;
        PbModel pbModel112;
        PbModel pbModel113;
        PbModel pbModel114;
        PbModel pbModel115;
        PbModel pbModel116;
        ez ezVar92;
        ez ezVar93;
        ez ezVar94;
        PbModel pbModel117;
        ez ezVar95;
        ez ezVar96;
        ez ezVar97;
        ez ezVar98;
        PbModel pbModel118;
        ez ezVar99;
        ez ezVar100;
        PbModel pbModel119;
        PbModel pbModel120;
        ez ezVar101;
        PbModel pbModel121;
        ez ezVar102;
        boolean z9;
        PbModel pbModel122;
        PbModel pbModel123;
        PbModel pbModel124;
        PbModel pbModel125;
        if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
            z9 = this.eiV.ehL;
            if (z9) {
                this.eiV.ehL = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(r.h.tag_clip_board);
                if (obj instanceof com.baidu.tieba.tbadkCore.data.p) {
                    com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) obj;
                    pbModel122 = this.eiV.ehh;
                    if (pbModel122 != null) {
                        pbModel123 = this.eiV.ehh;
                        if (pbModel123.getPbData() != null && this.eiV.aKO().aNp() != null && pVar2.getAuthor() != null && pVar2.bhQ() != 1 && this.eiV.checkUpIsLogin()) {
                            com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                            pbModel124 = this.eiV.ehh;
                            jVar.b(pbModel124.getPbData().aJY());
                            pbModel125 = this.eiV.ehh;
                            jVar.h(pbModel125.getPbData().aJZ());
                            jVar.b(pVar2);
                            this.eiV.aKO().aNp().c(jVar);
                            this.eiV.aKO().aNp().setPostId(pVar2.getId());
                            this.eiV.a(view, pVar2.getAuthor().getUserId(), "");
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
        ezVar = this.eiV.ehV;
        if (view == ezVar.getNextView()) {
            pbModel121 = this.eiV.ehh;
            if (pbModel121.iu(true)) {
                ezVar102 = this.eiV.ehV;
                ezVar102.aNK();
                return;
            }
            return;
        }
        ezVar2 = this.eiV.ehV;
        if (ezVar2.enK.aOy() != null) {
            ezVar99 = this.eiV.ehV;
            if (view == ezVar99.enK.aOy().aMP()) {
                ezVar100 = this.eiV.ehV;
                ezVar100.aNB();
                if (UtilHelper.isFloatWindowOpAllowed(this.eiV.getPageContext().getPageActivity())) {
                    this.eiV.eib = true;
                    PbActivity pbActivity = this.eiV;
                    pbModel119 = this.eiV.ehh;
                    pbActivity.a(pbModel119.getPbData(), 0, 1, true, true);
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c10830");
                    pbModel120 = this.eiV.ehh;
                    TiebaStatic.log(arVar.ab("tid", pbModel120.getThreadID()));
                    ezVar101 = this.eiV.ehV;
                    ezVar101.axs();
                    return;
                }
                this.eiV.aKS();
                return;
            }
        }
        ezVar3 = this.eiV.ehV;
        if (ezVar3.enK.aOy() != null) {
            ezVar95 = this.eiV.ehV;
            if (view == ezVar95.enK.aOy().aMV()) {
                if (com.baidu.adp.lib.util.i.gk()) {
                    ezVar96 = this.eiV.ehV;
                    ezVar96.axs();
                    this.eiV.XU();
                    ezVar97 = this.eiV.ehV;
                    ezVar97.aNJ();
                    ezVar98 = this.eiV.ehV;
                    ezVar98.avh();
                    pbModel118 = this.eiV.ehh;
                    pbModel118.ov(1);
                    return;
                }
                this.eiV.showToast(r.l.network_not_available);
                return;
            }
        }
        ezVar4 = this.eiV.ehV;
        if (view == ezVar4.enK.aCJ) {
            ezVar94 = this.eiV.ehV;
            pbModel117 = this.eiV.ehh;
            if (!ezVar94.iU(pbModel117.aMc())) {
                this.eiV.ehB = false;
                this.eiV.finish();
                return;
            }
            this.eiV.XU();
            return;
        }
        ezVar5 = this.eiV.ehV;
        if (view != ezVar5.aNH()) {
            ezVar14 = this.eiV.ehV;
            if (ezVar14.enK.aOy() != null) {
                ezVar92 = this.eiV.ehV;
                if (view != ezVar92.enK.aOy().aMU()) {
                    ezVar93 = this.eiV.ehV;
                }
            }
            ezVar15 = this.eiV.ehV;
            if (view == ezVar15.aNX()) {
                pbModel115 = this.eiV.ehh;
                if (pbModel115 != null) {
                    pbModel116 = this.eiV.ehh;
                    com.baidu.tbadk.browser.f.u(this.eiV.getPageContext().getPageActivity(), pbModel116.getPbData().aJZ().rw().getLink());
                    return;
                }
                return;
            }
            ezVar16 = this.eiV.ehV;
            if (view != ezVar16.enK.eqR) {
                ezVar17 = this.eiV.ehV;
                if (view == ezVar17.enK.eqT) {
                    pbModel101 = this.eiV.ehh;
                    if (pbModel101 != null) {
                        pbModel102 = this.eiV.ehh;
                        if (pbModel102.getPbData() != null) {
                            pbModel103 = this.eiV.ehh;
                            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = pbModel103.getPbData().aKb();
                            if (aKb == null || aKb.size() <= 0) {
                                pbModel104 = this.eiV.ehh;
                                if (pbModel104.aLY()) {
                                    com.baidu.adp.lib.util.k.showToast(this.eiV.getPageContext().getPageActivity(), this.eiV.getPageContext().getString(r.l.pb_no_data_tips));
                                    return;
                                }
                            }
                            ezVar90 = this.eiV.ehV;
                            ezVar90.aNr();
                            ezVar91 = this.eiV.ehV;
                            ezVar91.aOb();
                            this.eiV.aKV();
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.k.showToast(this.eiV.getPageContext().getPageActivity(), this.eiV.getPageContext().getString(r.l.pb_no_data_tips));
                    return;
                }
                ezVar18 = this.eiV.ehV;
                if (view != ezVar18.enK.eqS && view.getId() != r.h.pb_god_user_tip_content) {
                    ezVar25 = this.eiV.ehV;
                    if (ezVar25.enK.aOy() != null) {
                        ezVar87 = this.eiV.ehV;
                        if (view == ezVar87.enK.aOy().aMz()) {
                            if (com.baidu.adp.lib.util.i.gk()) {
                                ezVar88 = this.eiV.ehV;
                                ezVar88.axs();
                                oq = this.eiV.oq(11009);
                                if (oq) {
                                    pbModel100 = this.eiV.ehh;
                                    ezVar89 = this.eiV.ehV;
                                    if (pbModel100.oB(ezVar89.aNO()) == null) {
                                        return;
                                    }
                                    this.eiV.aLb();
                                    return;
                                }
                                return;
                            }
                            this.eiV.showToast(r.l.network_not_available);
                            return;
                        }
                    }
                    ezVar26 = this.eiV.ehV;
                    if (ezVar26.enK.aOy() != null) {
                        ezVar79 = this.eiV.ehV;
                        if (view == ezVar79.enK.aOy().aMR()) {
                            if (com.baidu.adp.lib.util.i.gk()) {
                                ezVar80 = this.eiV.ehV;
                                ezVar80.axs();
                                ezVar81 = this.eiV.ehV;
                                ezVar81.aNr();
                                z8 = this.eiV.mIsLoading;
                                if (!z8) {
                                    this.eiV.mIsLoading = true;
                                    ezVar82 = this.eiV.ehV;
                                    ezVar82.enK.eqS.setEnabled(false);
                                    ezVar83 = this.eiV.ehV;
                                    ezVar83.ase();
                                    this.eiV.XU();
                                    ezVar84 = this.eiV.ehV;
                                    ezVar84.aNJ();
                                    pbModel99 = this.eiV.ehh;
                                    aLg2 = this.eiV.aLg();
                                    pbModel99.on(aLg2);
                                    TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    ezVar85 = this.eiV.ehV;
                                    ezVar85.aOb();
                                    ezVar86 = this.eiV.ehV;
                                    ezVar86.aLT();
                                    this.eiV.or(2);
                                    return;
                                }
                                return;
                            }
                            this.eiV.showToast(r.l.network_not_available);
                            return;
                        }
                    }
                    ezVar27 = this.eiV.ehV;
                    if (ezVar27.enK.aOy() != null) {
                        ezVar76 = this.eiV.ehV;
                        if (view != ezVar76.enK.aOy().aMO()) {
                            ezVar78 = this.eiV.ehV;
                        }
                        ezVar77 = this.eiV.ehV;
                        ezVar77.enK.nX();
                        return;
                    }
                    ezVar28 = this.eiV.ehV;
                    if (ezVar28.enK.aOy() != null) {
                        ezVar74 = this.eiV.ehV;
                        if (view == ezVar74.enK.aOy().aMQ()) {
                            if (this.eiV.checkUpIsLogin()) {
                                ezVar75 = this.eiV.ehV;
                                ezVar75.axs();
                                this.eiV.XU();
                                this.eiV.or(2);
                                pbModel94 = this.eiV.ehh;
                                if (pbModel94 != null) {
                                    pbModel95 = this.eiV.ehh;
                                    if (pbModel95.getPbData() != null) {
                                        pbModel96 = this.eiV.ehh;
                                        if (pbModel96.getPbData().aKq() != null) {
                                            pbModel97 = this.eiV.ehh;
                                            if (!StringUtils.isNull(pbModel97.getPbData().aKq().pL(), true)) {
                                                com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c11678");
                                                pbModel98 = this.eiV.ehh;
                                                TiebaStatic.log(arVar2.ab("fid", pbModel98.getPbData().getForumId()));
                                            }
                                        }
                                    }
                                }
                                this.eiV.adT();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                                return;
                            }
                            return;
                        }
                    }
                    ezVar29 = this.eiV.ehV;
                    if (ezVar29.enK.aOy() != null) {
                        ezVar71 = this.eiV.ehV;
                        if (view == ezVar71.enK.aOy().aMJ()) {
                            ezVar72 = this.eiV.ehV;
                            ezVar72.axs();
                            pbModel92 = this.eiV.ehh;
                            if (pbModel92.amN() != null) {
                                ezVar73 = this.eiV.ehV;
                                pbModel93 = this.eiV.ehh;
                                ezVar73.a(pbModel93.amN(), this.eiV.dSL);
                            }
                            TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    ezVar30 = this.eiV.ehV;
                    if (ezVar30.enK.aOy() != null) {
                        ezVar68 = this.eiV.ehV;
                        if (view == ezVar68.enK.aOy().aMK()) {
                            ezVar69 = this.eiV.ehV;
                            ezVar69.axs();
                            this.eiV.or(2);
                            this.eiV.XU();
                            ezVar70 = this.eiV.ehV;
                            ezVar70.aNJ();
                            pbModel91 = this.eiV.ehh;
                            pbModel91.aMi();
                            TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    ezVar31 = this.eiV.ehV;
                    if (ezVar31.enK.aOy() != null) {
                        ezVar66 = this.eiV.ehV;
                        if (view == ezVar66.enK.aOy().aML()) {
                            pbModel87 = this.eiV.ehh;
                            if (pbModel87 != null) {
                                pbModel88 = this.eiV.ehh;
                                if (pbModel88.getPbData() != null) {
                                    pbModel89 = this.eiV.ehh;
                                    if (pbModel89.getPbData().aJZ() != null) {
                                        ezVar67 = this.eiV.ehV;
                                        ezVar67.enK.nX();
                                        PbActivity pbActivity2 = this.eiV;
                                        pbModel90 = this.eiV.ehh;
                                        pbActivity2.oi(pbModel90.getPbData().aJZ().rM());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    ezVar32 = this.eiV.ehV;
                    if (ezVar32.enK.aOy() != null) {
                        ezVar62 = this.eiV.ehV;
                        if (view == ezVar62.enK.aOy().aMM()) {
                            TiebaStatic.log("c10414");
                            ezVar63 = this.eiV.ehV;
                            ezVar63.axs();
                            ezVar64 = this.eiV.ehV;
                            if (ezVar64.rl() != ez.epp) {
                                pbModel85 = this.eiV.ehh;
                                if (pbModel85.aMw() != null) {
                                    pbModel86 = this.eiV.ehh;
                                    pbModel86.aMw().ou(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                    return;
                                }
                                return;
                            }
                            ezVar65 = this.eiV.ehV;
                            ezVar65.aOf();
                            return;
                        }
                    }
                    ezVar33 = this.eiV.ehV;
                    if (ezVar33.enK.aOy() != null) {
                        ezVar59 = this.eiV.ehV;
                        if (view == ezVar59.enK.aOy().aMN()) {
                            aKT = this.eiV.aKT();
                            this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.eiV.getPageContext().getPageActivity(), null, aKT, true)));
                            ezVar60 = this.eiV.ehV;
                            ezVar60.enK.nX();
                            ezVar61 = this.eiV.ehV;
                            ezVar61.enK.aOy().aMX();
                            return;
                        }
                    }
                    dqVar = this.eiV.eia;
                    if (dqVar != null) {
                        dqVar52 = this.eiV.eia;
                        if (view == dqVar52.aMB()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.gk()) {
                                this.eiV.showToast(r.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            if (!(tag instanceof String)) {
                                if (tag instanceof SparseArray) {
                                    SparseArray<Object> sparseArray6 = (SparseArray) tag;
                                    if ((sparseArray6.get(r.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(r.h.tag_user_mute_visible)).booleanValue()) {
                                        sparseArray6.put(r.h.tag_from, 0);
                                        sparseArray6.put(r.h.tag_check_mute_from, 2);
                                        this.eiV.d(sparseArray6);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            this.eiV.oi((String) tag);
                            return;
                        }
                    }
                    dqVar2 = this.eiV.eia;
                    if (dqVar2 != null) {
                        dqVar51 = this.eiV.eia;
                        if (view == dqVar51.aMz()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").s("obj_locate", 2));
                            if (!this.eiV.checkUpIsLogin()) {
                                return;
                            }
                            this.eiV.aZ(view);
                            return;
                        }
                    }
                    dqVar3 = this.eiV.eia;
                    if (dqVar3 != null) {
                        dqVar50 = this.eiV.eia;
                        if (view == dqVar50.aME()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").s("obj_locate", 1));
                            if (this.eiV.checkUpIsLogin()) {
                                pbModel80 = this.eiV.ehh;
                                if (pbModel80.getPbData() != null) {
                                    ezVar58 = this.eiV.ehV;
                                    ezVar58.axs();
                                    if (!(view.getTag() instanceof SparseArray)) {
                                        sparseArray5 = null;
                                    } else {
                                        sparseArray5 = (SparseArray) view.getTag();
                                    }
                                    if (sparseArray5 == null || !(sparseArray5.get(r.h.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.p)) {
                                        pVar = null;
                                    } else {
                                        pVar = (com.baidu.tieba.tbadkCore.data.p) sparseArray5.get(r.h.tag_load_sub_data);
                                    }
                                    if (pVar != null) {
                                        pbModel81 = this.eiV.ehh;
                                        String threadID = pbModel81.getThreadID();
                                        String id2 = pVar.getId();
                                        int i2 = 0;
                                        pbModel82 = this.eiV.ehh;
                                        if (pbModel82.getPbData() != null) {
                                            pbModel84 = this.eiV.ehh;
                                            i2 = pbModel84.getPbData().aKj();
                                        }
                                        this.eiV.XU();
                                        ol4 = this.eiV.ol(id2);
                                        if (ol4 != null) {
                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.eiV.getPageContext().getPageActivity());
                                            SmallTailInfo aPB = pVar.aPB();
                                            pbModel83 = this.eiV.ehh;
                                            this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, aPB, pbModel83.getPbData().qm(), false, pVar.getAuthor().getIconInfo()).addBigImageData(ol4.ejn, ol4.ejo, ol4.ejp, ol4.index)));
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
                    dqVar4 = this.eiV.eia;
                    if (dqVar4 != null) {
                        dqVar49 = this.eiV.eia;
                        if (view == dqVar49.aMG()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").s("obj_locate", 3));
                            if (view.getTag(r.h.tag_pb_floor_postion) instanceof Integer) {
                                pbModel78 = this.eiV.ehh;
                                if (pbModel78 != null) {
                                    ezVar57 = this.eiV.ehV;
                                    ezVar57.aNB();
                                    if (!UtilHelper.isFloatWindowOpAllowed(this.eiV.getPageContext().getPageActivity())) {
                                        this.eiV.aKS();
                                        return;
                                    }
                                    int intValue = ((Integer) view.getTag(r.h.tag_pb_floor_postion)).intValue();
                                    int intValue2 = ((Integer) view.getTag(r.h.tag_pb_floor_number)).intValue();
                                    this.eiV.eib = true;
                                    PbActivity pbActivity3 = this.eiV;
                                    pbModel79 = this.eiV.ehh;
                                    pbActivity3.a(pbModel79.getPbData(), intValue, intValue2, true, true);
                                    TiebaStatic.log("c10834");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    dqVar5 = this.eiV.eia;
                    if (dqVar5 != null) {
                        dqVar48 = this.eiV.eia;
                        if (view == dqVar48.aMC()) {
                            SparseArray sparseArray7 = (SparseArray) view.getTag();
                            if (sparseArray7 != null && (sparseArray7.get(r.h.tag_del_post_type) instanceof Integer) && (sparseArray7.get(r.h.tag_del_post_id) instanceof String) && (sparseArray7.get(r.h.tag_manage_user_identity) instanceof Integer) && (sparseArray7.get(r.h.tag_del_post_is_self) instanceof Boolean)) {
                                boolean booleanValue2 = ((Boolean) sparseArray7.get(r.h.tag_del_post_is_self)).booleanValue();
                                int intValue3 = ((Integer) sparseArray7.get(r.h.tag_manage_user_identity)).intValue();
                                if (!booleanValue2 && intValue3 != 0 && com.baidu.tieba.c.a.QW()) {
                                    Context baseContext = this.eiV.getBaseContext();
                                    pbModel77 = this.eiV.ehh;
                                    if (com.baidu.tieba.c.a.f(baseContext, pbModel77.getThreadID(), (String) sparseArray7.get(r.h.tag_del_post_id))) {
                                        return;
                                    }
                                }
                                ezVar56 = this.eiV.ehV;
                                ezVar56.a(((Integer) sparseArray7.get(r.h.tag_del_post_type)).intValue(), (String) sparseArray7.get(r.h.tag_del_post_id), intValue3, booleanValue2);
                                return;
                            }
                            return;
                        }
                    }
                    dqVar6 = this.eiV.eia;
                    if (dqVar6 != null) {
                        dqVar47 = this.eiV.eia;
                        if (view == dqVar47.aMD()) {
                            long j = -1;
                            String str2 = "";
                            int i3 = 0;
                            if (view.getTag(r.h.tag_chudian_template_id) instanceof Long) {
                                j = ((Long) view.getTag(r.h.tag_chudian_template_id)).longValue();
                            }
                            if (view.getTag(r.h.tag_chudian_monitor_id) instanceof String) {
                                str2 = (String) view.getTag(r.h.tag_chudian_monitor_id);
                            }
                            if (view.getTag(r.h.tag_chudian_hide_day) instanceof Integer) {
                                i3 = ((Integer) view.getTag(r.h.tag_chudian_hide_day)).intValue();
                            }
                            pbModel76 = this.eiV.ehh;
                            com.baidu.tieba.pb.data.f pbData = pbModel76.getPbData();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            if (pbData != null && pbData.aJY() != null) {
                                str3 = pbData.aJY().getId();
                                str4 = pbData.aJY().getName();
                                str5 = pbData.getThreadId();
                            }
                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                            this.eiV.a(j, str2, str3, str4, str5, i3);
                            return;
                        }
                    }
                    ezVar34 = this.eiV.ehV;
                    if (ezVar34.aOg() == view) {
                        ezVar55 = this.eiV.ehV;
                        if (ezVar55.aOg().getIndicateStatus()) {
                            pbModel75 = this.eiV.ehh;
                            com.baidu.tieba.pb.data.f pbData2 = pbModel75.getPbData();
                            if (pbData2 != null && pbData2.aJZ() != null && pbData2.aJZ().rg() != null) {
                                String pp = pbData2.aJZ().rg().pp();
                                if (StringUtils.isNull(pp)) {
                                    pp = pbData2.aJZ().rg().getTaskId();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11107").ab("obj_id", pp));
                            }
                        } else {
                            com.baidu.tieba.tbadkCore.d.a.cg("c10725", null);
                        }
                        this.eiV.aLn();
                        return;
                    }
                    ezVar35 = this.eiV.ehV;
                    if (ezVar35.aND() != view) {
                        dqVar7 = this.eiV.eia;
                        if (dqVar7 != null) {
                            dqVar46 = this.eiV.eia;
                            if (view == dqVar46.aMA()) {
                                if (!com.baidu.adp.lib.util.i.gk()) {
                                    this.eiV.showToast(r.l.network_not_available);
                                    return;
                                }
                                SparseArray<Object> sparseArray8 = (SparseArray) view.getTag();
                                if (sparseArray8 != null) {
                                    if (com.baidu.tieba.c.a.QW() && sparseArray8.get(r.h.tag_del_post_id) != null) {
                                        Context baseContext2 = this.eiV.getBaseContext();
                                        pbModel73 = this.eiV.ehh;
                                        if (com.baidu.tieba.c.a.f(baseContext2, pbModel73.getThreadID(), (String) sparseArray8.get(r.h.tag_del_post_id))) {
                                            return;
                                        }
                                    }
                                    boolean booleanValue3 = ((Boolean) sparseArray8.get(r.h.tag_should_manage_visible)).booleanValue();
                                    boolean booleanValue4 = ((Boolean) sparseArray8.get(r.h.tag_should_delete_visible)).booleanValue();
                                    boolean booleanValue5 = ((Boolean) sparseArray8.get(r.h.tag_user_mute_visible)).booleanValue();
                                    if (booleanValue3) {
                                        if (booleanValue5) {
                                            sparseArray8.put(r.h.tag_from, 1);
                                            sparseArray8.put(r.h.tag_check_mute_from, 2);
                                            this.eiV.d(sparseArray8);
                                            return;
                                        }
                                        sparseArray8.put(r.h.tag_check_mute_from, 2);
                                        ezVar54 = this.eiV.ehV;
                                        ezVar54.bd(view);
                                        return;
                                    } else if (booleanValue4) {
                                        ezVar53 = this.eiV.ehV;
                                        ezVar53.a(((Integer) sparseArray8.get(r.h.tag_del_post_type)).intValue(), (String) sparseArray8.get(r.h.tag_del_post_id), ((Integer) sparseArray8.get(r.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(r.h.tag_del_post_is_self)).booleanValue());
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        ezVar36 = this.eiV.ehV;
                        if (view != ezVar36.aLU()) {
                            ezVar37 = this.eiV.ehV;
                            if (ezVar37.enK.aOy() != null) {
                                ezVar47 = this.eiV.ehV;
                                if (view == ezVar47.enK.aOy().aMW()) {
                                    if (com.baidu.adp.lib.util.i.gk()) {
                                        ezVar48 = this.eiV.ehV;
                                        ezVar48.axs();
                                        ezVar49 = this.eiV.ehV;
                                        pbModel63 = this.eiV.ehh;
                                        com.baidu.tieba.pb.data.f pbData3 = pbModel63.getPbData();
                                        pbModel64 = this.eiV.ehh;
                                        SparseArray<Object> c = ezVar49.c(pbData3, pbModel64.aLY(), 1);
                                        if (c != null) {
                                            pbModel65 = this.eiV.ehh;
                                            PbActivity pbActivity4 = this.eiV;
                                            Activity pageActivity = this.eiV.getPageContext().getPageActivity();
                                            pbModel66 = this.eiV.ehh;
                                            String id3 = pbModel66.getPbData().aJY().getId();
                                            pbModel67 = this.eiV.ehh;
                                            String name2 = pbModel67.getPbData().aJY().getName();
                                            pbModel68 = this.eiV.ehh;
                                            pbActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, pbModel68.getPbData().aJZ().getId(), String.valueOf(pbModel65.getPbData().getUserData().getUserId()), (String) c.get(r.h.tag_forbid_user_name), (String) c.get(r.h.tag_forbid_user_post_id))));
                                            return;
                                        }
                                        return;
                                    }
                                    this.eiV.showToast(r.l.network_not_available);
                                    return;
                                }
                            }
                            ezVar38 = this.eiV.ehV;
                            if (ezVar38.enK.aOy() != null) {
                                ezVar43 = this.eiV.ehV;
                                if (view == ezVar43.enK.aOy().aMT()) {
                                    if (com.baidu.adp.lib.util.i.gk()) {
                                        ezVar44 = this.eiV.ehV;
                                        pbModel61 = this.eiV.ehh;
                                        com.baidu.tieba.pb.data.f pbData4 = pbModel61.getPbData();
                                        pbModel62 = this.eiV.ehh;
                                        SparseArray<Object> c2 = ezVar44.c(pbData4, pbModel62.aLY(), 1);
                                        if (c2 != null) {
                                            ezVar46 = this.eiV.ehV;
                                            ezVar46.a(((Integer) c2.get(r.h.tag_del_post_type)).intValue(), (String) c2.get(r.h.tag_del_post_id), ((Integer) c2.get(r.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(r.h.tag_del_post_is_self)).booleanValue());
                                        }
                                        ezVar45 = this.eiV.ehV;
                                        ezVar45.enK.nX();
                                        return;
                                    }
                                    this.eiV.showToast(r.l.network_not_available);
                                    return;
                                }
                            }
                            if (view.getId() != r.h.sub_pb_more && view.getId() != r.h.sub_pb_item) {
                                ezVar40 = this.eiV.ehV;
                                if (view == ezVar40.aKJ()) {
                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                        long c3 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                        pbModel58 = this.eiV.ehh;
                                        long c4 = com.baidu.adp.lib.g.b.c(pbModel58.getPbData().getForumId(), 0L);
                                        pbModel59 = this.eiV.ehh;
                                        long c5 = com.baidu.adp.lib.g.b.c(pbModel59.getThreadID(), 0L);
                                        pbModel60 = this.eiV.ehh;
                                        this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.eiV.getPageContext().getPageActivity(), 24008, c4, c5, c3, pbModel60.getPbData().aJZ().rQ())));
                                        return;
                                    }
                                    return;
                                }
                                int id4 = view.getId();
                                if (id4 == r.h.pb_u9_text_view) {
                                    if (this.eiV.checkUpIsLogin() && (bnVar = (com.baidu.tbadk.core.data.bn) view.getTag()) != null && !StringUtils.isNull(bnVar.sK())) {
                                        TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                        com.baidu.tbadk.core.util.ba.vt().c(this.eiV.getPageContext(), new String[]{bnVar.sK()});
                                        return;
                                    }
                                    return;
                                } else if (id4 == r.h.replybtn || id4 == r.h.cover_reply_content) {
                                    dqVar8 = this.eiV.eia;
                                    if (dqVar8 == null) {
                                        this.eiV.eia = new dq(this.eiV.getPageContext(), this.eiV.bHz);
                                        dqVar45 = this.eiV.eia;
                                        z7 = this.eiV.mIsLogin;
                                        dqVar45.iy(z7);
                                    }
                                    dqVar9 = this.eiV.eia;
                                    dqVar9.showDialog();
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11740"));
                                    com.baidu.tieba.tbadkCore.data.p pVar3 = null;
                                    if (view != null && view.getTag() != null) {
                                        pVar3 = (com.baidu.tieba.tbadkCore.data.p) ((SparseArray) view.getTag()).get(r.h.tag_load_sub_data);
                                        if (!this.eiV.aLh()) {
                                            pbModel24 = this.eiV.ehh;
                                            if (pbModel24.aMj() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                                                dqVar44 = this.eiV.eia;
                                                dqVar44.aMI();
                                                sparseArray = (SparseArray) view.getTag();
                                                if (sparseArray.get(r.h.tag_pb_floor_postion) instanceof Integer) {
                                                    int intValue4 = ((Integer) sparseArray.get(r.h.tag_pb_floor_postion)).intValue();
                                                    int intValue5 = ((Integer) sparseArray.get(r.h.tag_pb_floor_number)).intValue();
                                                    dqVar42 = this.eiV.eia;
                                                    dqVar42.aMG().setTag(r.h.tag_pb_floor_postion, Integer.valueOf(intValue4));
                                                    dqVar43 = this.eiV.eia;
                                                    dqVar43.aMG().setTag(r.h.tag_pb_floor_number, Integer.valueOf(intValue5));
                                                }
                                                SparseArray sparseArray9 = new SparseArray();
                                                sparseArray9.put(r.h.tag_clip_board, (com.baidu.tieba.tbadkCore.data.p) ((SparseArray) view.getTag()).get(r.h.tag_clip_board));
                                                sparseArray9.put(r.h.tag_is_subpb, false);
                                                dqVar15 = this.eiV.eia;
                                                dqVar15.aMz().setTag(sparseArray9);
                                                dqVar16 = this.eiV.eia;
                                                dqVar16.aME().setTag(view.getTag());
                                                sparseArray2 = (SparseArray) view.getTag();
                                                booleanValue = ((Boolean) sparseArray2.get(r.h.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue6 = ((Boolean) sparseArray2.get(r.h.tag_user_mute_visible)).booleanValue();
                                                boolean booleanValue7 = ((Boolean) sparseArray2.get(r.h.tag_should_delete_visible)).booleanValue();
                                                if (sparseArray2.get(r.h.tag_del_post_is_self) instanceof Boolean) {
                                                    z3 = false;
                                                } else {
                                                    z3 = ((Boolean) sparseArray2.get(r.h.tag_del_post_is_self)).booleanValue();
                                                }
                                                String str6 = null;
                                                if (sparseArray2.get(r.h.tag_forbid_user_post_id) instanceof String) {
                                                    str6 = (String) sparseArray2.get(r.h.tag_forbid_user_post_id);
                                                }
                                                if (!booleanValue) {
                                                    SparseArray sparseArray10 = new SparseArray();
                                                    sparseArray10.put(r.h.tag_should_manage_visible, true);
                                                    sparseArray10.put(r.h.tag_manage_user_identity, sparseArray2.get(r.h.tag_manage_user_identity));
                                                    sparseArray10.put(r.h.tag_forbid_user_name, sparseArray2.get(r.h.tag_forbid_user_name));
                                                    sparseArray10.put(r.h.tag_forbid_user_post_id, str6);
                                                    if (booleanValue6) {
                                                        sparseArray10.put(r.h.tag_user_mute_visible, true);
                                                        sparseArray10.put(r.h.tag_is_mem, sparseArray2.get(r.h.tag_is_mem));
                                                        sparseArray10.put(r.h.tag_user_mute_mute_userid, sparseArray2.get(r.h.tag_user_mute_mute_userid));
                                                        sparseArray10.put(r.h.tag_user_mute_mute_username, sparseArray2.get(r.h.tag_user_mute_mute_username));
                                                        sparseArray10.put(r.h.tag_user_mute_post_id, sparseArray2.get(r.h.tag_user_mute_post_id));
                                                        sparseArray10.put(r.h.tag_user_mute_thread_id, sparseArray2.get(r.h.tag_user_mute_thread_id));
                                                    } else {
                                                        sparseArray10.put(r.h.tag_user_mute_visible, false);
                                                    }
                                                    if (booleanValue7) {
                                                        sparseArray10.put(r.h.tag_should_delete_visible, true);
                                                        sparseArray10.put(r.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                        sparseArray10.put(r.h.tag_del_post_id, sparseArray2.get(r.h.tag_del_post_id));
                                                        sparseArray10.put(r.h.tag_del_post_type, sparseArray2.get(r.h.tag_del_post_type));
                                                        dqVar41 = this.eiV.eia;
                                                        dqVar41.aMC().setVisibility(0);
                                                    } else {
                                                        sparseArray10.put(r.h.tag_should_delete_visible, false);
                                                        dqVar36 = this.eiV.eia;
                                                        dqVar36.aMC().setVisibility(8);
                                                    }
                                                    dqVar37 = this.eiV.eia;
                                                    dqVar37.aMA().setTag(sparseArray10);
                                                    dqVar38 = this.eiV.eia;
                                                    dqVar38.aMC().setTag(sparseArray10);
                                                    dqVar39 = this.eiV.eia;
                                                    dqVar39.aMA().setText(r.l.bar_manager);
                                                    dqVar40 = this.eiV.eia;
                                                    dqVar40.aMA().setVisibility(0);
                                                } else if (!booleanValue7) {
                                                    dqVar17 = this.eiV.eia;
                                                    dqVar17.aMA().setVisibility(8);
                                                    dqVar18 = this.eiV.eia;
                                                    dqVar18.aMC().setVisibility(8);
                                                } else {
                                                    SparseArray sparseArray11 = new SparseArray();
                                                    sparseArray11.put(r.h.tag_should_manage_visible, false);
                                                    sparseArray11.put(r.h.tag_user_mute_visible, false);
                                                    sparseArray11.put(r.h.tag_should_delete_visible, true);
                                                    sparseArray11.put(r.h.tag_manage_user_identity, sparseArray2.get(r.h.tag_manage_user_identity));
                                                    sparseArray11.put(r.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                    sparseArray11.put(r.h.tag_del_post_id, sparseArray2.get(r.h.tag_del_post_id));
                                                    sparseArray11.put(r.h.tag_del_post_type, sparseArray2.get(r.h.tag_del_post_type));
                                                    dqVar19 = this.eiV.eia;
                                                    dqVar19.aMA().setTag(sparseArray11);
                                                    dqVar20 = this.eiV.eia;
                                                    dqVar20.aMC().setTag(sparseArray11);
                                                    dqVar21 = this.eiV.eia;
                                                    dqVar21.aMA().setText(r.l.delete);
                                                    dqVar22 = this.eiV.eia;
                                                    dqVar22.aMC().setVisibility(0);
                                                    dqVar23 = this.eiV.eia;
                                                    dqVar23.aMA().setVisibility(8);
                                                }
                                                sparseArray3 = (SparseArray) view.getTag();
                                                if (sparseArray3.get(r.h.tag_user_mute_visible) instanceof Boolean) {
                                                    z4 = false;
                                                } else {
                                                    z4 = ((Boolean) sparseArray3.get(r.h.tag_user_mute_visible)).booleanValue();
                                                }
                                                if (((Boolean) sparseArray3.get(r.h.tag_should_manage_visible)).booleanValue() && z4) {
                                                    SparseArray sparseArray12 = new SparseArray();
                                                    sparseArray12.put(r.h.tag_user_mute_visible, true);
                                                    sparseArray12.put(r.h.tag_is_mem, sparseArray3.get(r.h.tag_is_mem));
                                                    sparseArray12.put(r.h.tag_user_mute_mute_userid, sparseArray3.get(r.h.tag_user_mute_mute_userid));
                                                    sparseArray12.put(r.h.tag_user_mute_mute_username, sparseArray3.get(r.h.tag_user_mute_mute_username));
                                                    sparseArray12.put(r.h.tag_user_mute_post_id, sparseArray3.get(r.h.tag_user_mute_post_id));
                                                    sparseArray12.put(r.h.tag_user_mute_thread_id, sparseArray3.get(r.h.tag_user_mute_thread_id));
                                                    sparseArray12.put(r.h.tag_del_post_is_self, sparseArray3.get(r.h.tag_del_post_is_self));
                                                    sparseArray12.put(r.h.tag_del_post_type, sparseArray3.get(r.h.tag_del_post_type));
                                                    sparseArray12.put(r.h.tag_del_post_id, sparseArray3.get(r.h.tag_del_post_id));
                                                    sparseArray12.put(r.h.tag_manage_user_identity, sparseArray3.get(r.h.tag_manage_user_identity));
                                                    dqVar32 = this.eiV.eia;
                                                    dqVar32.aMB().setTag(sparseArray12);
                                                    dqVar33 = this.eiV.eia;
                                                    dqVar33.aMB().setVisibility(0);
                                                    dqVar34 = this.eiV.eia;
                                                    dqVar34.aMA().setVisibility(8);
                                                    dqVar35 = this.eiV.eia;
                                                    dqVar35.aMB().setText(r.l.mute_option);
                                                } else {
                                                    if (sparseArray3.get(r.h.tag_del_post_is_self) instanceof Boolean) {
                                                        z5 = false;
                                                    } else {
                                                        z5 = ((Boolean) sparseArray3.get(r.h.tag_del_post_is_self)).booleanValue();
                                                    }
                                                    String str7 = null;
                                                    if (sparseArray3.get(r.h.tag_forbid_user_post_id) instanceof String) {
                                                        str7 = (String) sparseArray3.get(r.h.tag_forbid_user_post_id);
                                                    }
                                                    io = this.eiV.io(z5);
                                                    isLogin = io & this.eiV.isLogin();
                                                    this.eiV.eiL = (com.baidu.tieba.tbadkCore.data.p) sparseArray3.get(r.h.tag_clip_board);
                                                    if (!(!ey.g(this.eiV.eiL) ? false : isLogin)) {
                                                        dqVar25 = this.eiV.eia;
                                                        dqVar25.aMB().setVisibility(0);
                                                        dqVar26 = this.eiV.eia;
                                                        dqVar26.aMB().setTag(str7);
                                                    } else {
                                                        dqVar24 = this.eiV.eia;
                                                        dqVar24.aMB().setVisibility(8);
                                                    }
                                                }
                                                sparseArray4 = (SparseArray) view.getTag();
                                                long j2 = 0;
                                                if (sparseArray4.get(r.h.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                    z6 = false;
                                                } else {
                                                    z6 = ((Boolean) sparseArray4.get(r.h.tag_should_hide_chudian_visible)).booleanValue();
                                                }
                                                if (sparseArray4.get(r.h.tag_chudian_template_id) instanceof Long) {
                                                    j2 = ((Long) sparseArray4.get(r.h.tag_chudian_template_id)).longValue();
                                                }
                                                if (sparseArray4.get(r.h.tag_chudian_monitor_id) instanceof String) {
                                                    str = "";
                                                } else {
                                                    str = (String) sparseArray4.get(r.h.tag_chudian_monitor_id);
                                                }
                                                if (sparseArray4.get(r.h.tag_chudian_hide_day) instanceof Integer) {
                                                    i = 0;
                                                } else {
                                                    i = ((Integer) sparseArray4.get(r.h.tag_chudian_hide_day)).intValue();
                                                }
                                                if (!z6) {
                                                    dqVar28 = this.eiV.eia;
                                                    dqVar28.aMD().setVisibility(0);
                                                    dqVar29 = this.eiV.eia;
                                                    dqVar29.aMD().setTag(r.h.tag_chudian_template_id, Long.valueOf(j2));
                                                    dqVar30 = this.eiV.eia;
                                                    dqVar30.aMD().setTag(r.h.tag_chudian_monitor_id, str);
                                                    dqVar31 = this.eiV.eia;
                                                    dqVar31.aMD().setTag(r.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                } else {
                                                    dqVar27 = this.eiV.eia;
                                                    dqVar27.aMD().setVisibility(8);
                                                }
                                            }
                                        }
                                        dqVar14 = this.eiV.eia;
                                        dqVar14.aMH();
                                        sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray.get(r.h.tag_pb_floor_postion) instanceof Integer) {
                                        }
                                        SparseArray sparseArray92 = new SparseArray();
                                        sparseArray92.put(r.h.tag_clip_board, (com.baidu.tieba.tbadkCore.data.p) ((SparseArray) view.getTag()).get(r.h.tag_clip_board));
                                        sparseArray92.put(r.h.tag_is_subpb, false);
                                        dqVar15 = this.eiV.eia;
                                        dqVar15.aMz().setTag(sparseArray92);
                                        dqVar16 = this.eiV.eia;
                                        dqVar16.aME().setTag(view.getTag());
                                        sparseArray2 = (SparseArray) view.getTag();
                                        booleanValue = ((Boolean) sparseArray2.get(r.h.tag_should_manage_visible)).booleanValue();
                                        boolean booleanValue62 = ((Boolean) sparseArray2.get(r.h.tag_user_mute_visible)).booleanValue();
                                        boolean booleanValue72 = ((Boolean) sparseArray2.get(r.h.tag_should_delete_visible)).booleanValue();
                                        if (sparseArray2.get(r.h.tag_del_post_is_self) instanceof Boolean) {
                                        }
                                        String str62 = null;
                                        if (sparseArray2.get(r.h.tag_forbid_user_post_id) instanceof String) {
                                        }
                                        if (!booleanValue) {
                                        }
                                        sparseArray3 = (SparseArray) view.getTag();
                                        if (sparseArray3.get(r.h.tag_user_mute_visible) instanceof Boolean) {
                                        }
                                        if (((Boolean) sparseArray3.get(r.h.tag_should_manage_visible)).booleanValue()) {
                                        }
                                        if (sparseArray3.get(r.h.tag_del_post_is_self) instanceof Boolean) {
                                        }
                                        String str72 = null;
                                        if (sparseArray3.get(r.h.tag_forbid_user_post_id) instanceof String) {
                                        }
                                        io = this.eiV.io(z5);
                                        isLogin = io & this.eiV.isLogin();
                                        this.eiV.eiL = (com.baidu.tieba.tbadkCore.data.p) sparseArray3.get(r.h.tag_clip_board);
                                        if (!(!ey.g(this.eiV.eiL) ? false : isLogin)) {
                                        }
                                        sparseArray4 = (SparseArray) view.getTag();
                                        long j22 = 0;
                                        if (sparseArray4.get(r.h.tag_should_hide_chudian_visible) instanceof Boolean) {
                                        }
                                        if (sparseArray4.get(r.h.tag_chudian_template_id) instanceof Long) {
                                        }
                                        if (sparseArray4.get(r.h.tag_chudian_monitor_id) instanceof String) {
                                        }
                                        if (sparseArray4.get(r.h.tag_chudian_hide_day) instanceof Integer) {
                                        }
                                        if (!z6) {
                                        }
                                    }
                                    pbModel22 = this.eiV.ehh;
                                    if (pbModel22.getPbData().nt()) {
                                        pbModel23 = this.eiV.ehh;
                                        String ns = pbModel23.getPbData().ns();
                                        if (pVar3 != null && !com.baidu.adp.lib.util.j.isEmpty(ns) && ns.equals(pVar3.getId())) {
                                            z2 = true;
                                            if (!z2) {
                                                dqVar13 = this.eiV.eia;
                                                dqVar13.aMz().setText(r.l.remove_mark);
                                            } else {
                                                dqVar10 = this.eiV.eia;
                                                dqVar10.aMz().setText(r.l.mark);
                                            }
                                            dqVar11 = this.eiV.eia;
                                            dqVar11.iz(true);
                                            dqVar12 = this.eiV.eia;
                                            dqVar12.vN();
                                            return;
                                        }
                                    }
                                    z2 = false;
                                    if (!z2) {
                                    }
                                    dqVar11 = this.eiV.eia;
                                    dqVar11.iz(true);
                                    dqVar12 = this.eiV.eia;
                                    dqVar12.vN();
                                    return;
                                } else if (id4 == r.h.pb_act_btn) {
                                    pbModel52 = this.eiV.ehh;
                                    if (pbModel52.getPbData() != null) {
                                        pbModel53 = this.eiV.ehh;
                                        if (pbModel53.getPbData().aJZ() != null) {
                                            pbModel54 = this.eiV.ehh;
                                            if (pbModel54.getPbData().aJZ().sb() != null) {
                                                Activity activity = this.eiV.getActivity();
                                                pbModel55 = this.eiV.ehh;
                                                com.baidu.tbadk.browser.f.u(activity, pbModel55.getPbData().aJZ().sb());
                                                pbModel56 = this.eiV.ehh;
                                                if (pbModel56.getPbData().aJZ().rZ() != 1) {
                                                    pbModel57 = this.eiV.ehh;
                                                    if (pbModel57.getPbData().aJZ().rZ() == 2) {
                                                        TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (id4 == r.h.lottery_tail) {
                                    if (view.getTag(r.h.tag_pb_lottery_tail_link) instanceof String) {
                                        String str8 = (String) view.getTag(r.h.tag_pb_lottery_tail_link);
                                        com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c10912");
                                        pbModel49 = this.eiV.ehh;
                                        com.baidu.tbadk.core.util.ar ab = arVar3.ab("fid", pbModel49.getPbData().getForumId());
                                        pbModel50 = this.eiV.ehh;
                                        TiebaStatic.log(ab.ab("tid", pbModel50.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                        pbModel51 = this.eiV.ehh;
                                        if (pbModel51.getPbData().getThreadId().equals(str8)) {
                                            ezVar42 = this.eiV.ehV;
                                            ezVar42.setSelection(0);
                                            return;
                                        }
                                        this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.eiV.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                        return;
                                    }
                                    return;
                                } else if (id4 == r.h.pb_item_tail_content) {
                                    if (com.baidu.tbadk.core.util.bf.ak(this.eiV.getPageContext().getPageActivity())) {
                                        String string = TbadkCoreApplication.m9getInst().getString(r.l.tail_web_view_title);
                                        String string2 = com.baidu.tbadk.core.sharedPref.b.tQ().getString("tail_link", "");
                                        if (!StringUtils.isNull(string2)) {
                                            TiebaStatic.log("c10056");
                                            com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                        }
                                        ezVar41 = this.eiV.ehV;
                                        ezVar41.aNr();
                                        return;
                                    }
                                    return;
                                } else if (id4 == r.h.join_vote_tv) {
                                    if (view != null) {
                                        com.baidu.tbadk.browser.f.u(this.eiV.getActivity(), (String) view.getTag());
                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                        aKU3 = this.eiV.aKU();
                                        if (aKU3 == 1) {
                                            pbModel45 = this.eiV.ehh;
                                            if (pbModel45 != null) {
                                                pbModel46 = this.eiV.ehh;
                                                if (pbModel46.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c10397");
                                                    pbModel47 = this.eiV.ehh;
                                                    com.baidu.tbadk.core.util.ar ab2 = arVar4.ab("fid", pbModel47.getPbData().getForumId());
                                                    pbModel48 = this.eiV.ehh;
                                                    TiebaStatic.log(ab2.ab("tid", pbModel48.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        aKU4 = this.eiV.aKU();
                                        if (aKU4 == 2) {
                                            pbModel41 = this.eiV.ehh;
                                            if (pbModel41 != null) {
                                                pbModel42 = this.eiV.ehh;
                                                if (pbModel42.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c10401");
                                                    pbModel43 = this.eiV.ehh;
                                                    com.baidu.tbadk.core.util.ar ab3 = arVar5.ab("fid", pbModel43.getPbData().getForumId());
                                                    pbModel44 = this.eiV.ehh;
                                                    TiebaStatic.log(ab3.ab("tid", pbModel44.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (id4 == r.h.look_all_tv) {
                                    if (view != null) {
                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                        com.baidu.tbadk.browser.f.u(this.eiV.getActivity(), (String) view.getTag());
                                        aKU = this.eiV.aKU();
                                        if (aKU == 1) {
                                            pbModel37 = this.eiV.ehh;
                                            if (pbModel37 != null) {
                                                pbModel38 = this.eiV.ehh;
                                                if (pbModel38.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c10507");
                                                    pbModel39 = this.eiV.ehh;
                                                    com.baidu.tbadk.core.util.ar ab4 = arVar6.ab("fid", pbModel39.getPbData().getForumId());
                                                    pbModel40 = this.eiV.ehh;
                                                    TiebaStatic.log(ab4.ab("tid", pbModel40.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount2));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        aKU2 = this.eiV.aKU();
                                        if (aKU2 == 2) {
                                            pbModel33 = this.eiV.ehh;
                                            if (pbModel33 != null) {
                                                pbModel34 = this.eiV.ehh;
                                                if (pbModel34.getPbData() != null) {
                                                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c10508");
                                                    pbModel35 = this.eiV.ehh;
                                                    com.baidu.tbadk.core.util.ar ab5 = arVar7.ab("fid", pbModel35.getPbData().getForumId());
                                                    pbModel36 = this.eiV.ehh;
                                                    TiebaStatic.log(ab5.ab("tid", pbModel36.getPbData().getThreadId()).ab(SapiAccountManager.SESSION_UID, currentAccount2));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (id4 != r.h.manga_prev_btn) {
                                    if (id4 != r.h.manga_next_btn) {
                                        if (id4 == r.h.yule_head_img_img) {
                                            pbModel29 = this.eiV.ehh;
                                            if (pbModel29 != null) {
                                                pbModel30 = this.eiV.ehh;
                                                if (pbModel30.getPbData() != null) {
                                                    pbModel31 = this.eiV.ehh;
                                                    if (pbModel31.getPbData().aKq() != null) {
                                                        pbModel32 = this.eiV.ehh;
                                                        com.baidu.tieba.pb.data.f pbData5 = pbModel32.getPbData();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11679").ab("fid", pbData5.getForumId()));
                                                        com.baidu.tbadk.core.util.ba.vt().c(this.eiV.getPageContext(), new String[]{pbData5.aKq().aKs()});
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else if (id4 == r.h.yule_head_img_all_rank) {
                                            pbModel25 = this.eiV.ehh;
                                            if (pbModel25 != null) {
                                                pbModel26 = this.eiV.ehh;
                                                if (pbModel26.getPbData() != null) {
                                                    pbModel27 = this.eiV.ehh;
                                                    if (pbModel27.getPbData().aKq() != null) {
                                                        pbModel28 = this.eiV.ehh;
                                                        com.baidu.tieba.pb.data.f pbData6 = pbModel28.getPbData();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").ab("fid", pbData6.getForumId()));
                                                        com.baidu.tbadk.core.util.ba.vt().c(this.eiV.getPageContext(), new String[]{pbData6.aKq().aKs()});
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
                                    this.eiV.aLj();
                                    return;
                                } else {
                                    this.eiV.aLi();
                                    return;
                                }
                            } else if (this.eiV.checkUpIsLogin()) {
                                pbModel7 = this.eiV.ehh;
                                if (pbModel7.getPbData() != null) {
                                    ezVar39 = this.eiV.ehV;
                                    ezVar39.axs();
                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                    com.baidu.tieba.tbadkCore.data.p pVar4 = (com.baidu.tieba.tbadkCore.data.p) sparseArray13.get(r.h.tag_load_sub_data);
                                    View view2 = (View) sparseArray13.get(r.h.tag_load_sub_view);
                                    if (pVar4 != null && view2 != null) {
                                        pbModel8 = this.eiV.ehh;
                                        String threadID2 = pbModel8.getThreadID();
                                        String id5 = pVar4.getId();
                                        int i4 = 0;
                                        pbModel9 = this.eiV.ehh;
                                        if (pbModel9.getPbData() != null) {
                                            pbModel20 = this.eiV.ehh;
                                            i4 = pbModel20.getPbData().aKj();
                                        }
                                        this.eiV.XU();
                                        if (view.getId() != r.h.replybtn) {
                                            if (view.getId() == r.h.sub_pb_item) {
                                                SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                String str9 = (String) sparseArray14.get(r.h.tag_photo_username);
                                                String str10 = (String) sparseArray13.get(r.h.tag_photo_userid);
                                                com.baidu.tieba.tbadkCore.data.p pVar5 = (com.baidu.tieba.tbadkCore.data.p) sparseArray14.get(r.h.tag_load_sub_data);
                                                String str11 = null;
                                                if (pVar5 != null) {
                                                    str11 = pVar5.getId();
                                                }
                                                TiebaStatic.log("c11741");
                                                ol2 = this.eiV.ol(id5);
                                                if (pVar4 != null) {
                                                    pbModel13 = this.eiV.ehh;
                                                    if (pbModel13 != null) {
                                                        pbModel14 = this.eiV.ehh;
                                                        if (pbModel14.getPbData() != null && ol2 != null && this.eiV.aKO().aNp() != null) {
                                                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                                                            pbModel15 = this.eiV.ehh;
                                                            jVar2.b(pbModel15.getPbData().aJY());
                                                            pbModel16 = this.eiV.ehh;
                                                            jVar2.h(pbModel16.getPbData().aJZ());
                                                            jVar2.b(pVar5);
                                                            this.eiV.aKO().aNp().c(jVar2);
                                                            this.eiV.aKO().aNp().setPostId(str11);
                                                            this.eiV.a(view, str10, str9);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            TiebaStatic.log("c11742");
                                            ol = this.eiV.ol(id5);
                                            if (pVar4 != null) {
                                                pbModel10 = this.eiV.ehh;
                                                if (pbModel10 != null) {
                                                    pbModel11 = this.eiV.ehh;
                                                    if (pbModel11.getPbData() != null && ol != null) {
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.eiV.getPageContext().getPageActivity());
                                                        SmallTailInfo aPB2 = pVar4.aPB();
                                                        pbModel12 = this.eiV.ehh;
                                                        this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i4, aPB2, pbModel12.getPbData().qm(), false, pVar4.getAuthor().getIconInfo()).addBigImageData(ol.ejn, ol.ejo, ol.ejp, ol.index)));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        ol3 = this.eiV.ol(id5);
                                        if (pVar4 != null) {
                                            pbModel17 = this.eiV.ehh;
                                            if (pbModel17 != null) {
                                                pbModel18 = this.eiV.ehh;
                                                if (pbModel18.getPbData() != null && ol3 != null) {
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.eiV.getPageContext().getPageActivity());
                                                    SmallTailInfo aPB3 = pVar4.aPB();
                                                    pbModel19 = this.eiV.ehh;
                                                    this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i4, aPB3, pbModel19.getPbData().qm(), false, pVar4.getAuthor().getIconInfo()).addBigImageData(ol3.ejn, ol3.ejo, ol3.ejp, ol3.index)));
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
                                com.baidu.tbadk.core.util.ar s = new com.baidu.tbadk.core.util.ar("c10517").s("obj_locate", 3);
                                pbModel21 = this.eiV.ehh;
                                TiebaStatic.log(s.ab("fid", pbModel21.getPbData().getForumId()));
                                return;
                            }
                        } else if (this.eiV.checkUpIsLogin()) {
                            ezVar50 = this.eiV.ehV;
                            if (!ezVar50.aLR()) {
                                pbModel69 = this.eiV.ehh;
                                if (pbModel69 != null) {
                                    pbModel70 = this.eiV.ehh;
                                    if (pbModel70.aMu() != null) {
                                        pbModel71 = this.eiV.ehh;
                                        if (pbModel71.aMu().aLN() != null) {
                                            pbModel72 = this.eiV.ehh;
                                            if (com.baidu.tbadk.core.util.w.r(pbModel72.aMu().aLN().getItems()) != 0) {
                                                ezVar51 = this.eiV.ehV;
                                                ezVar51.aLS();
                                                return;
                                            }
                                            this.eiV.showToast(r.l.graffiti_quick_vote_empty);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            ezVar52 = this.eiV.ehV;
                            ezVar52.aLT();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.eiV.checkUpIsLogin()) {
                        com.baidu.tbadk.core.util.ar s2 = new com.baidu.tbadk.core.util.ar("c10517").s("obj_locate", 2);
                        pbModel74 = this.eiV.ehh;
                        TiebaStatic.log(s2.ab("fid", pbModel74.getPbData().getForumId()));
                        return;
                    } else {
                        this.eiV.aKL();
                        return;
                    }
                } else if (com.baidu.adp.lib.util.i.gk()) {
                    ezVar19 = this.eiV.ehV;
                    ezVar19.aNr();
                    z = this.eiV.mIsLoading;
                    if (!z) {
                        this.eiV.mIsLoading = true;
                        ezVar20 = this.eiV.ehV;
                        ezVar20.enK.eqS.setEnabled(false);
                        ezVar21 = this.eiV.ehV;
                        ezVar21.ase();
                        this.eiV.XU();
                        ezVar22 = this.eiV.ehV;
                        ezVar22.aNJ();
                        pbModel6 = this.eiV.ehh;
                        aLg = this.eiV.aLg();
                        pbModel6.on(aLg);
                        TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        ezVar23 = this.eiV.ehV;
                        ezVar23.aOb();
                        ezVar24 = this.eiV.ehV;
                        ezVar24.aLT();
                        this.eiV.or(2);
                        return;
                    }
                    return;
                } else {
                    this.eiV.showToast(r.l.network_not_available);
                    return;
                }
            }
            TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            pbModel105 = this.eiV.ehh;
            if (pbModel105.getPbData() != null) {
                pbModel112 = this.eiV.ehh;
                if (pbModel112.getPbData().aJZ() != null) {
                    pbModel113 = this.eiV.ehh;
                    if (pbModel113.getPbData().aJZ().si()) {
                        pbModel114 = this.eiV.ehh;
                        if (pbModel114.getPbData().aJZ().rN() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11922"));
                        }
                    }
                }
            }
            pbModel106 = this.eiV.ehh;
            if (pbModel106.getErrorNo() == 4) {
                pbModel109 = this.eiV.ehh;
                if (StringUtils.isNull(pbModel109.aLX())) {
                    pbModel110 = this.eiV.ehh;
                    if (pbModel110.getAppealInfo() != null) {
                        pbModel111 = this.eiV.ehh;
                        name = pbModel111.getAppealInfo().forumName;
                    }
                }
                this.eiV.finish();
                return;
            }
            pbModel107 = this.eiV.ehh;
            name = pbModel107.getPbData().aJY().getName();
            if (!StringUtils.isNull(name)) {
                pbModel108 = this.eiV.ehh;
                String aLX = pbModel108.aLX();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.eiV.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                if (StringUtils.isNull(aLX)) {
                    this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                } else if (aLX.equals(name)) {
                    this.eiV.finish();
                    return;
                } else {
                    this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                }
            }
            this.eiV.finish();
            return;
        }
        if (com.baidu.adp.lib.util.i.gk()) {
            pbModel = this.eiV.ehh;
            if (pbModel.getPbData().aKj() == 1) {
                forumManageModel = this.eiV.ehU;
                if (!forumManageModel.biz()) {
                    ezVar6 = this.eiV.ehV;
                    ezVar6.axs();
                    int i5 = 0;
                    ezVar7 = this.eiV.ehV;
                    if (ezVar7.enK.aOy() != null) {
                        ezVar13 = this.eiV.ehV;
                        if (view == ezVar13.enK.aOy().aMS()) {
                            pbModel5 = this.eiV.ehh;
                            if (pbModel5.getPbData().aJZ().rs() == 1) {
                                i5 = 5;
                            } else {
                                i5 = 4;
                            }
                            pbModel3 = this.eiV.ehh;
                            ForumData aJY = pbModel3.getPbData().aJY();
                            String name3 = aJY.getName();
                            String id6 = aJY.getId();
                            pbModel4 = this.eiV.ehh;
                            id = pbModel4.getPbData().aJZ().getId();
                            if (com.baidu.tieba.c.a.QW() || !com.baidu.tieba.c.a.f(this.eiV.getBaseContext(), id, null)) {
                                ezVar11 = this.eiV.ehV;
                                ezVar11.aNG();
                                forumManageModel2 = this.eiV.ehU;
                                ezVar12 = this.eiV.ehV;
                                forumManageModel2.a(id6, name3, id, i5, ezVar12.aNI());
                                return;
                            }
                            return;
                        }
                    }
                    ezVar8 = this.eiV.ehV;
                    if (ezVar8.enK.aOy() != null) {
                        ezVar10 = this.eiV.ehV;
                        if (view == ezVar10.enK.aOy().aMU()) {
                            pbModel2 = this.eiV.ehh;
                            if (pbModel2.getPbData().aJZ().rt() == 1) {
                                i5 = 3;
                            } else {
                                i5 = 6;
                            }
                            pbModel3 = this.eiV.ehh;
                            ForumData aJY2 = pbModel3.getPbData().aJY();
                            String name32 = aJY2.getName();
                            String id62 = aJY2.getId();
                            pbModel4 = this.eiV.ehh;
                            id = pbModel4.getPbData().aJZ().getId();
                            if (com.baidu.tieba.c.a.QW()) {
                            }
                            ezVar11 = this.eiV.ehV;
                            ezVar11.aNG();
                            forumManageModel2 = this.eiV.ehU;
                            ezVar12 = this.eiV.ehV;
                            forumManageModel2.a(id62, name32, id, i5, ezVar12.aNI());
                            return;
                        }
                    }
                    ezVar9 = this.eiV.ehV;
                    if (view == ezVar9.aNH()) {
                        i5 = 2;
                    }
                    pbModel3 = this.eiV.ehh;
                    ForumData aJY22 = pbModel3.getPbData().aJY();
                    String name322 = aJY22.getName();
                    String id622 = aJY22.getId();
                    pbModel4 = this.eiV.ehh;
                    id = pbModel4.getPbData().aJZ().getId();
                    if (com.baidu.tieba.c.a.QW()) {
                    }
                    ezVar11 = this.eiV.ehV;
                    ezVar11.aNG();
                    forumManageModel2 = this.eiV.ehU;
                    ezVar12 = this.eiV.ehV;
                    forumManageModel2.a(id622, name322, id, i5, ezVar12.aNI());
                    return;
                }
                return;
            }
            return;
        }
        this.eiV.showToast(r.l.network_not_available);
    }
}
