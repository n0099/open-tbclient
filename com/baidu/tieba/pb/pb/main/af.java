package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v136, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v140, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v181, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x07d6, code lost:
        if (r18 != r1.eBR.aRz().aPE()) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x092f, code lost:
        if (r18 == r1.eBR.aRz().UF()) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0ad6, code lost:
        if (r18 != r1.eBR.aRz().aPA()) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0115, code lost:
        if (r1.eBR.aRz().aZ(r18) == false) goto L951;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x012d, code lost:
        if (r18.getId() != com.baidu.tieba.w.h.pb_item_tail_content) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0327, code lost:
        if (r18 == r1.eBR.aRz().aPF()) goto L914;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:653:0x1cb1  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x1e6d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03d7  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        gg ggVar4;
        gg ggVar5;
        gg ggVar6;
        gg ggVar7;
        PbModel pbModel;
        ForumManageModel forumManageModel;
        gg ggVar8;
        gg ggVar9;
        gg ggVar10;
        gg ggVar11;
        gg ggVar12;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        String id;
        gg ggVar13;
        ForumManageModel forumManageModel2;
        gg ggVar14;
        gg ggVar15;
        PbModel pbModel5;
        gg ggVar16;
        gg ggVar17;
        gg ggVar18;
        gg ggVar19;
        gg ggVar20;
        gg ggVar21;
        gg ggVar22;
        boolean z;
        gg ggVar23;
        gg ggVar24;
        gg ggVar25;
        PbModel pbModel6;
        String aNT;
        gg ggVar26;
        gg ggVar27;
        gg ggVar28;
        gg ggVar29;
        gg ggVar30;
        gg ggVar31;
        gg ggVar32;
        gg ggVar33;
        gg ggVar34;
        eu euVar;
        eu euVar2;
        eu euVar3;
        eu euVar4;
        eu euVar5;
        gg ggVar35;
        gg ggVar36;
        eu euVar6;
        gg ggVar37;
        gg ggVar38;
        PbModel pbModel7;
        gg ggVar39;
        PbModel pbModel8;
        PbModel pbModel9;
        PbActivity.b oM;
        PbModel pbModel10;
        PbModel pbModel11;
        PbModel pbModel12;
        PbActivity.b oM2;
        PbModel pbModel13;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        PbActivity.b oM3;
        PbModel pbModel17;
        PbModel pbModel18;
        PbModel pbModel19;
        PbModel pbModel20;
        PbModel pbModel21;
        gg ggVar40;
        gg ggVar41;
        PbModel pbModel22;
        PbModel pbModel23;
        PbModel pbModel24;
        PbModel pbModel25;
        PbModel pbModel26;
        PbModel pbModel27;
        boolean z2;
        eu euVar7;
        eu euVar8;
        eu euVar9;
        eu euVar10;
        PbModel pbModel28;
        eu euVar11;
        eu euVar12;
        eu euVar13;
        eu euVar14;
        eu euVar15;
        boolean z3;
        eu euVar16;
        eu euVar17;
        eu euVar18;
        eu euVar19;
        eu euVar20;
        eu euVar21;
        eu euVar22;
        boolean z4;
        boolean z5;
        boolean iC;
        eu euVar23;
        eu euVar24;
        eu euVar25;
        boolean z6;
        String str;
        int i;
        eu euVar26;
        eu euVar27;
        eu euVar28;
        eu euVar29;
        eu euVar30;
        eu euVar31;
        eu euVar32;
        eu euVar33;
        eu euVar34;
        eu euVar35;
        eu euVar36;
        eu euVar37;
        eu euVar38;
        eu euVar39;
        eu euVar40;
        PbModel pbModel29;
        eu euVar41;
        boolean z7;
        PbModel pbModel30;
        PbModel pbModel31;
        PbModel pbModel32;
        PbModel pbModel33;
        PbModel pbModel34;
        PbModel pbModel35;
        PbModel pbModel36;
        PbModel pbModel37;
        int aNE;
        int aNE2;
        PbModel pbModel38;
        PbModel pbModel39;
        PbModel pbModel40;
        PbModel pbModel41;
        PbModel pbModel42;
        PbModel pbModel43;
        PbModel pbModel44;
        PbModel pbModel45;
        int aNE3;
        int aNE4;
        PbModel pbModel46;
        PbModel pbModel47;
        PbModel pbModel48;
        PbModel pbModel49;
        PbModel pbModel50;
        PbModel pbModel51;
        PbModel pbModel52;
        PbModel pbModel53;
        gg ggVar42;
        PbModel pbModel54;
        PbModel pbModel55;
        PbModel pbModel56;
        gg ggVar43;
        PbModel pbModel57;
        PbModel pbModel58;
        PbModel pbModel59;
        PbModel pbModel60;
        PbModel pbModel61;
        PbModel pbModel62;
        com.baidu.tbadk.core.data.bs bsVar;
        gg ggVar44;
        PbModel pbModel63;
        PbModel pbModel64;
        PbModel pbModel65;
        gg ggVar45;
        gg ggVar46;
        PbModel pbModel66;
        PbModel pbModel67;
        gg ggVar47;
        gg ggVar48;
        gg ggVar49;
        gg ggVar50;
        gg ggVar51;
        PbModel pbModel68;
        PbModel pbModel69;
        PbModel pbModel70;
        PbModel pbModel71;
        PbModel pbModel72;
        PbModel pbModel73;
        eu euVar42;
        gg ggVar52;
        gg ggVar53;
        PbModel pbModel74;
        PbModel pbModel75;
        gg ggVar54;
        PbModel pbModel76;
        eu euVar43;
        PbModel pbModel77;
        eu euVar44;
        gg ggVar55;
        PbModel pbModel78;
        eu euVar45;
        eu euVar46;
        PbModel pbModel79;
        gg ggVar56;
        SparseArray sparseArray;
        PostData postData;
        PbModel pbModel80;
        PbModel pbModel81;
        PbActivity.b oM4;
        PbModel pbModel82;
        PbModel pbModel83;
        PbModel pbModel84;
        eu euVar47;
        eu euVar48;
        gg ggVar57;
        String aND;
        gg ggVar58;
        gg ggVar59;
        gg ggVar60;
        gg ggVar61;
        gg ggVar62;
        PbModel pbModel85;
        PbModel pbModel86;
        gg ggVar63;
        gg ggVar64;
        PbModel pbModel87;
        PbModel pbModel88;
        PbModel pbModel89;
        gg ggVar65;
        PbModel pbModel90;
        gg ggVar66;
        gg ggVar67;
        gg ggVar68;
        PbModel pbModel91;
        int i2;
        int i3;
        PbModel pbModel92;
        gg ggVar69;
        gg ggVar70;
        gg ggVar71;
        PbModel pbModel93;
        gg ggVar72;
        PbModel pbModel94;
        gg ggVar73;
        gg ggVar74;
        PbModel pbModel95;
        gg ggVar75;
        gg ggVar76;
        PbModel pbModel96;
        PbModel pbModel97;
        PbModel pbModel98;
        PbModel pbModel99;
        PbModel pbModel100;
        gg ggVar77;
        gg ggVar78;
        gg ggVar79;
        gg ggVar80;
        gg ggVar81;
        boolean z8;
        gg ggVar82;
        gg ggVar83;
        PbModel pbModel101;
        String aNT2;
        boolean oP;
        PbModel pbModel102;
        String aNT3;
        gg ggVar84;
        PbModel pbModel103;
        String aNT4;
        gg ggVar85;
        gg ggVar86;
        gg ggVar87;
        gg ggVar88;
        gg ggVar89;
        gg ggVar90;
        boolean oH;
        PbModel pbModel104;
        gg ggVar91;
        PbModel pbModel105;
        PbModel pbModel106;
        PbModel pbModel107;
        PbModel pbModel108;
        gg ggVar92;
        gg ggVar93;
        PbModel pbModel109;
        PbModel pbModel110;
        PbModel pbModel111;
        String name;
        PbModel pbModel112;
        PbModel pbModel113;
        PbModel pbModel114;
        PbModel pbModel115;
        PbModel pbModel116;
        PbModel pbModel117;
        PbModel pbModel118;
        PbModel pbModel119;
        PbModel pbModel120;
        PbModel pbModel121;
        gg ggVar94;
        gg ggVar95;
        gg ggVar96;
        PbModel pbModel122;
        gg ggVar97;
        gg ggVar98;
        gg ggVar99;
        gg ggVar100;
        PbModel pbModel123;
        gg ggVar101;
        PbModel pbModel124;
        PbModel pbModel125;
        gg ggVar102;
        boolean z9;
        PbModel pbModel126;
        gg ggVar103;
        PbModel pbModel127;
        PbModel pbModel128;
        PbModel pbModel129;
        gg ggVar104;
        boolean z10;
        PbModel pbModel130;
        PbModel pbModel131;
        PbModel pbModel132;
        PbModel pbModel133;
        if (view != null) {
            if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                z10 = this.ewh.euI;
                if (z10) {
                    this.ewh.euI = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(w.h.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData2 = (PostData) obj;
                        pbModel130 = this.ewh.eue;
                        if (pbModel130 != null) {
                            pbModel131 = this.ewh.eue;
                            if (pbModel131.getPbData() != null && this.ewh.aNy().aQd() != null && postData2.getAuthor() != null && postData2.bmu() != 1 && this.ewh.checkUpIsLogin() && !com.baidu.tieba.pb.i.d(postData2)) {
                                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                pbModel132 = this.ewh.eue;
                                nVar.b(pbModel132.getPbData().aMt());
                                pbModel133 = this.ewh.eue;
                                nVar.O(pbModel133.getPbData().aMv());
                                nVar.f(postData2);
                                this.ewh.aNy().aQd().d(nVar);
                                this.ewh.aNy().aQd().setPostId(postData2.getId());
                                this.ewh.a(view, postData2.getAuthor().getUserId(), "");
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
            ggVar = this.ewh.euU;
            if (ggVar.eBR.aRz() != null) {
                ggVar104 = this.ewh.euU;
            }
            ggVar2 = this.ewh.euU;
            if (ggVar2.aQr() != view) {
            }
            if (this.ewh.checkUpIsLogin()) {
                pbModel127 = this.ewh.eue;
                if (pbModel127 != null) {
                    pbModel128 = this.ewh.eue;
                    if (pbModel128.getPbData() != null) {
                        pbModel129 = this.ewh.eue;
                        if (com.baidu.tieba.pb.i.N(pbModel129.getPbData().aMv())) {
                            return;
                        }
                    }
                }
                ggVar3 = this.ewh.euU;
                if (view == ggVar3.getNextView()) {
                    z9 = this.ewh.mIsLoading;
                    if (!z9) {
                        pbModel126 = this.ewh.eue;
                        if (pbModel126.iN(true)) {
                            this.ewh.mIsLoading = true;
                            ggVar103 = this.ewh.euU;
                            ggVar103.aQy();
                            return;
                        }
                        return;
                    }
                    return;
                }
                ggVar4 = this.ewh.euU;
                if (view == ggVar4.aQj()) {
                    ggVar101 = this.ewh.euU;
                    ggVar101.aQp();
                    if (UtilHelper.isFloatWindowOpAllowed(this.ewh.getPageContext().getPageActivity())) {
                        this.ewh.eva = true;
                        PbActivity pbActivity = this.ewh;
                        pbModel124 = this.ewh.eue;
                        pbActivity.a(pbModel124.getPbData(), 0, 1, true, true);
                        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10830");
                        pbModel125 = this.ewh.eue;
                        TiebaStatic.log(auVar.Z("tid", pbModel125.getThreadID()));
                        ggVar102 = this.ewh.euU;
                        ggVar102.azw();
                        return;
                    }
                    this.ewh.Pz();
                    return;
                }
                ggVar5 = this.ewh.euU;
                if (ggVar5.eBR.aRz() != null) {
                    ggVar97 = this.ewh.euU;
                    if (view == ggVar97.eBR.aRz().aPI()) {
                        if (com.baidu.adp.lib.util.i.hj()) {
                            ggVar98 = this.ewh.euU;
                            ggVar98.azw();
                            this.ewh.aei();
                            ggVar99 = this.ewh.euU;
                            ggVar99.aQx();
                            ggVar100 = this.ewh.euU;
                            ggVar100.Qx();
                            pbModel123 = this.ewh.eue;
                            pbModel123.oP(1);
                            return;
                        }
                        this.ewh.showToast(w.l.network_not_available);
                        return;
                    }
                }
                ggVar6 = this.ewh.euU;
                if (view == ggVar6.eBR.aJD) {
                    ggVar96 = this.ewh.euU;
                    pbModel122 = this.ewh.eue;
                    if (!ggVar96.jo(pbModel122.aOO())) {
                        this.ewh.euz = false;
                        this.ewh.eux = false;
                        this.ewh.finish();
                        return;
                    }
                    this.ewh.aei();
                    return;
                }
                ggVar7 = this.ewh.euU;
                if (view != ggVar7.aQv()) {
                    ggVar16 = this.ewh.euU;
                    if (ggVar16.eBR.aRz() != null) {
                        ggVar94 = this.ewh.euU;
                        if (view != ggVar94.eBR.aRz().aPH()) {
                            ggVar95 = this.ewh.euU;
                        }
                    }
                    ggVar17 = this.ewh.euU;
                    if (view == ggVar17.aQK()) {
                        pbModel120 = this.ewh.eue;
                        if (pbModel120 != null) {
                            pbModel121 = this.ewh.eue;
                            com.baidu.tbadk.browser.g.T(this.ewh.getPageContext().getPageActivity(), pbModel121.getPbData().aMv().rq().getLink());
                            return;
                        }
                        return;
                    }
                    ggVar18 = this.ewh.euU;
                    if (view != ggVar18.eBR.eGH) {
                        ggVar19 = this.ewh.euU;
                        if (view == ggVar19.eBR.eGJ) {
                            pbModel105 = this.ewh.eue;
                            if (pbModel105 != null) {
                                pbModel106 = this.ewh.eue;
                                if (pbModel106.getPbData() != null) {
                                    pbModel107 = this.ewh.eue;
                                    ArrayList<PostData> aMx = pbModel107.getPbData().aMx();
                                    if (aMx == null || aMx.size() <= 0) {
                                        pbModel108 = this.ewh.eue;
                                        if (pbModel108.aOK()) {
                                            com.baidu.adp.lib.util.k.showToast(this.ewh.getPageContext().getPageActivity(), this.ewh.getPageContext().getString(w.l.pb_no_data_tips));
                                            return;
                                        }
                                    }
                                    ggVar92 = this.ewh.euU;
                                    if (!ggVar92.aQZ()) {
                                        ggVar93 = this.ewh.euU;
                                        ggVar93.aOk();
                                    }
                                    this.ewh.aNG();
                                    return;
                                }
                            }
                            com.baidu.adp.lib.util.k.showToast(this.ewh.getPageContext().getPageActivity(), this.ewh.getPageContext().getString(w.l.pb_no_data_tips));
                            return;
                        }
                        ggVar20 = this.ewh.euU;
                        if (view != ggVar20.eBR.eGI && view.getId() != w.h.pb_god_user_tip_content) {
                            ggVar26 = this.ewh.euU;
                            if (ggVar26.eBR.aRz() != null) {
                                ggVar89 = this.ewh.euU;
                                if (view == ggVar89.eBR.aRz().aPr()) {
                                    if (com.baidu.adp.lib.util.i.hj()) {
                                        ggVar90 = this.ewh.euU;
                                        ggVar90.azw();
                                        oH = this.ewh.oH(11009);
                                        if (oH) {
                                            pbModel104 = this.ewh.eue;
                                            ggVar91 = this.ewh.euU;
                                            if (pbModel104.oW(ggVar91.aQC()) == null) {
                                                return;
                                            }
                                            this.ewh.aNN();
                                            return;
                                        }
                                        return;
                                    }
                                    this.ewh.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            ggVar27 = this.ewh.euU;
                            if (ggVar27.eBR.aRz() != null) {
                                ggVar88 = this.ewh.euU;
                            }
                            if (view.getId() != w.h.floor_owner_reply && view.getId() != w.h.reply_title) {
                                ggVar28 = this.ewh.euU;
                                if (ggVar28.eBR.aRz() != null) {
                                    ggVar77 = this.ewh.euU;
                                    if (view != ggVar77.eBR.aRz().getCancelView()) {
                                        ggVar79 = this.ewh.euU;
                                    }
                                    ggVar78 = this.ewh.euU;
                                    ggVar78.eBR.od();
                                    return;
                                }
                                ggVar29 = this.ewh.euU;
                                if (ggVar29.eBR.aRz() != null) {
                                    ggVar73 = this.ewh.euU;
                                    if (view == ggVar73.eBR.aRz().aPK()) {
                                        if (this.ewh.checkUpIsLogin()) {
                                            if (com.baidu.adp.lib.util.k.hA()) {
                                                ggVar74 = this.ewh.euU;
                                                ggVar74.azw();
                                                this.ewh.aei();
                                                this.ewh.oI(2);
                                                pbModel95 = this.ewh.eue;
                                                if (pbModel95 != null) {
                                                    pbModel97 = this.ewh.eue;
                                                    if (pbModel97.getPbData() != null) {
                                                        pbModel98 = this.ewh.eue;
                                                        if (pbModel98.getPbData().aMN() != null) {
                                                            pbModel99 = this.ewh.eue;
                                                            if (!StringUtils.isNull(pbModel99.getPbData().aMN().pI(), true)) {
                                                                com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c11678");
                                                                pbModel100 = this.ewh.eue;
                                                                TiebaStatic.log(auVar2.Z("fid", pbModel100.getPbData().getForumId()));
                                                            }
                                                        }
                                                    }
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11939"));
                                                ggVar75 = this.ewh.euU;
                                                ggVar75.Qx();
                                                ggVar76 = this.ewh.euU;
                                                int i4 = view == ggVar76.eDq ? 1 : 2;
                                                pbModel96 = this.ewh.eue;
                                                pbModel96.aPl().p(CheckRealNameModel.TYPE_PB_SHARE, Integer.valueOf(i4));
                                                return;
                                            }
                                            this.ewh.showToast(w.l.neterror);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ggVar30 = this.ewh.euU;
                                if (ggVar30.eBR.aRz() != null) {
                                    ggVar70 = this.ewh.euU;
                                    if (view == ggVar70.eBR.aRz().aPz()) {
                                        ggVar71 = this.ewh.euU;
                                        ggVar71.azw();
                                        pbModel93 = this.ewh.eue;
                                        if (pbModel93.aov() != null) {
                                            ggVar72 = this.ewh.euU;
                                            pbModel94 = this.ewh.eue;
                                            ggVar72.a(pbModel94.aov(), this.ewh.edT);
                                        }
                                        TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                ggVar31 = this.ewh.euU;
                                if (ggVar31.eBR.aRz() != null) {
                                    ggVar69 = this.ewh.euU;
                                }
                                if (view.getId() != w.h.pb_sort) {
                                    ggVar32 = this.ewh.euU;
                                    if (ggVar32.eBR.aRz() != null) {
                                        ggVar64 = this.ewh.euU;
                                        if (view == ggVar64.eBR.aRz().aPB()) {
                                            pbModel87 = this.ewh.eue;
                                            if (pbModel87 != null) {
                                                pbModel88 = this.ewh.eue;
                                                if (pbModel88.getPbData() != null) {
                                                    pbModel89 = this.ewh.eue;
                                                    if (pbModel89.getPbData().aMv() != null) {
                                                        ggVar65 = this.ewh.euU;
                                                        ggVar65.eBR.od();
                                                        PbActivity pbActivity2 = this.ewh;
                                                        pbModel90 = this.ewh.eue;
                                                        pbActivity2.oJ(pbModel90.getPbData().aMv().rH());
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ggVar33 = this.ewh.euU;
                                    if (ggVar33.eBR.aRz() != null) {
                                        ggVar60 = this.ewh.euU;
                                        if (view == ggVar60.eBR.aRz().aPC()) {
                                            TiebaStatic.log("c10414");
                                            ggVar61 = this.ewh.euU;
                                            ggVar61.azw();
                                            ggVar62 = this.ewh.euU;
                                            if (ggVar62.rf() != gg.eDH) {
                                                pbModel85 = this.ewh.eue;
                                                if (pbModel85.aPi() != null) {
                                                    pbModel86 = this.ewh.eue;
                                                    pbModel86.aPi().oN(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                                    return;
                                                }
                                                return;
                                            }
                                            ggVar63 = this.ewh.euU;
                                            ggVar63.aQP();
                                            return;
                                        }
                                    }
                                    ggVar34 = this.ewh.euU;
                                    if (ggVar34.eBR.aRz() != null) {
                                        ggVar57 = this.ewh.euU;
                                        if (view == ggVar57.eBR.aRz().aPD()) {
                                            aND = this.ewh.aND();
                                            this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.ewh.getPageContext().getPageActivity(), null, aND, true)));
                                            ggVar58 = this.ewh.euU;
                                            ggVar58.eBR.od();
                                            ggVar59 = this.ewh.euU;
                                            ggVar59.eBR.aRz().aPL();
                                            return;
                                        }
                                    }
                                    euVar = this.ewh.euZ;
                                    if (euVar != null) {
                                        euVar48 = this.ewh.euZ;
                                        if (view == euVar48.aPt()) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11739").r("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.i.hj()) {
                                                this.ewh.showToast(w.l.network_not_available);
                                                return;
                                            }
                                            Object tag = view.getTag();
                                            if (!(tag instanceof String)) {
                                                if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                    if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray2.put(w.h.tag_from, 0);
                                                        sparseArray2.put(w.h.tag_check_mute_from, 2);
                                                        this.ewh.d(sparseArray2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            this.ewh.oJ((String) tag);
                                            return;
                                        }
                                    }
                                    euVar2 = this.ewh.euZ;
                                    if (euVar2 != null) {
                                        euVar47 = this.ewh.euZ;
                                        if (view == euVar47.aPr()) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11739").r("obj_locate", 2));
                                            if (!this.ewh.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.ewh.aW(view);
                                            return;
                                        }
                                    }
                                    euVar3 = this.ewh.euZ;
                                    if (euVar3 != null) {
                                        euVar45 = this.ewh.euZ;
                                        if (view == euVar45.aPw()) {
                                            euVar46 = this.ewh.euZ;
                                            if (euVar46.aPy()) {
                                                com.baidu.tbadk.core.util.au auVar3 = new com.baidu.tbadk.core.util.au("c12007");
                                                pbModel84 = this.ewh.eue;
                                                TiebaStatic.log(auVar3.Z("tid", pbModel84.eyr));
                                            } else {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11739").r("obj_locate", 1));
                                            }
                                            if (this.ewh.checkUpIsLogin()) {
                                                pbModel79 = this.ewh.eue;
                                                if (pbModel79.getPbData() != null) {
                                                    ggVar56 = this.ewh.euU;
                                                    ggVar56.azw();
                                                    if (!(view.getTag() instanceof SparseArray)) {
                                                        sparseArray = null;
                                                    } else {
                                                        sparseArray = (SparseArray) view.getTag();
                                                    }
                                                    if (sparseArray == null || !(sparseArray.get(w.h.tag_load_sub_data) instanceof PostData)) {
                                                        postData = null;
                                                    } else {
                                                        postData = (PostData) sparseArray.get(w.h.tag_load_sub_data);
                                                    }
                                                    if (postData != null) {
                                                        pbModel80 = this.ewh.eue;
                                                        String threadID = pbModel80.getThreadID();
                                                        String id2 = postData.getId();
                                                        int i5 = 0;
                                                        pbModel81 = this.ewh.eue;
                                                        if (pbModel81.getPbData() != null) {
                                                            pbModel83 = this.ewh.eue;
                                                            i5 = pbModel83.getPbData().aMG();
                                                        }
                                                        this.ewh.aei();
                                                        oM4 = this.ewh.oM(id2);
                                                        if (oM4 != null) {
                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.ewh.getPageContext().getPageActivity());
                                                            SmallTailInfo aSA = postData.aSA();
                                                            pbModel82 = this.ewh.eue;
                                                            this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i5, aSA, pbModel82.getPbData().qe(), false, postData.getAuthor().getIconInfo()).addBigImageData(oM4.ewy, oM4.ewz, oM4.ewA, oM4.index)));
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
                                    euVar4 = this.ewh.euZ;
                                    if (euVar4 != null) {
                                        euVar44 = this.ewh.euZ;
                                        if (view == euVar44.aPu()) {
                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(w.h.tag_del_post_type) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_id) instanceof String) && (sparseArray3.get(w.h.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(w.h.tag_del_post_is_self)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(w.h.tag_manage_user_identity)).intValue();
                                                if (!booleanValue && intValue != 0 && com.baidu.tieba.c.a.Ux()) {
                                                    Context baseContext = this.ewh.getBaseContext();
                                                    pbModel78 = this.ewh.eue;
                                                    if (com.baidu.tieba.c.a.h(baseContext, pbModel78.getThreadID(), (String) sparseArray3.get(w.h.tag_del_post_id))) {
                                                        return;
                                                    }
                                                }
                                                ggVar55 = this.ewh.euU;
                                                ggVar55.a(((Integer) sparseArray3.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray3.get(w.h.tag_del_post_id), intValue, booleanValue);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    euVar5 = this.ewh.euZ;
                                    if (euVar5 != null) {
                                        euVar43 = this.ewh.euZ;
                                        if (view == euVar43.aPv()) {
                                            long j = -1;
                                            String str2 = "";
                                            int i6 = 0;
                                            if (view.getTag(w.h.tag_chudian_template_id) instanceof Long) {
                                                j = ((Long) view.getTag(w.h.tag_chudian_template_id)).longValue();
                                            }
                                            if (view.getTag(w.h.tag_chudian_monitor_id) instanceof String) {
                                                str2 = (String) view.getTag(w.h.tag_chudian_monitor_id);
                                            }
                                            if (view.getTag(w.h.tag_chudian_hide_day) instanceof Integer) {
                                                i6 = ((Integer) view.getTag(w.h.tag_chudian_hide_day)).intValue();
                                            }
                                            pbModel77 = this.ewh.eue;
                                            com.baidu.tieba.pb.data.f pbData = pbModel77.getPbData();
                                            String str3 = null;
                                            String str4 = null;
                                            String str5 = null;
                                            if (pbData != null && pbData.aMt() != null) {
                                                str3 = pbData.aMt().getId();
                                                str4 = pbData.aMt().getName();
                                                str5 = pbData.getThreadId();
                                            }
                                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                            this.ewh.a(j, str2, str3, str4, str5, i6);
                                            return;
                                        }
                                    }
                                    ggVar35 = this.ewh.euU;
                                    if (ggVar35.aQQ() == view) {
                                        ggVar54 = this.ewh.euU;
                                        if (ggVar54.aQQ().getIndicateStatus()) {
                                            pbModel76 = this.ewh.eue;
                                            com.baidu.tieba.pb.data.f pbData2 = pbModel76.getPbData();
                                            if (pbData2 != null && pbData2.aMv() != null && pbData2.aMv().ra() != null) {
                                                String pu = pbData2.aMv().ra().pu();
                                                if (StringUtils.isNull(pu)) {
                                                    pu = pbData2.aMv().ra().getTaskId();
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11107").Z("obj_id", pu));
                                            }
                                        } else {
                                            com.baidu.tieba.tbadkCore.d.a.ce("c10725", null);
                                        }
                                        this.ewh.aOa();
                                        return;
                                    }
                                    ggVar36 = this.ewh.euU;
                                    if (ggVar36.aQr() != view) {
                                        euVar6 = this.ewh.euZ;
                                        if (euVar6 != null) {
                                            euVar42 = this.ewh.euZ;
                                            if (view == euVar42.aPs()) {
                                                if (!com.baidu.adp.lib.util.i.hj()) {
                                                    this.ewh.showToast(w.l.network_not_available);
                                                    return;
                                                }
                                                SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                                if (sparseArray4 != null) {
                                                    if (com.baidu.tieba.c.a.Ux() && sparseArray4.get(w.h.tag_del_post_id) != null) {
                                                        Context baseContext2 = this.ewh.getBaseContext();
                                                        pbModel74 = this.ewh.eue;
                                                        if (com.baidu.tieba.c.a.h(baseContext2, pbModel74.getThreadID(), (String) sparseArray4.get(w.h.tag_del_post_id))) {
                                                            return;
                                                        }
                                                    }
                                                    boolean booleanValue2 = ((Boolean) sparseArray4.get(w.h.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue3 = ((Boolean) sparseArray4.get(w.h.tag_should_delete_visible)).booleanValue();
                                                    boolean booleanValue4 = ((Boolean) sparseArray4.get(w.h.tag_user_mute_visible)).booleanValue();
                                                    if (booleanValue2) {
                                                        if (booleanValue4) {
                                                            sparseArray4.put(w.h.tag_from, 1);
                                                            sparseArray4.put(w.h.tag_check_mute_from, 2);
                                                            this.ewh.d(sparseArray4);
                                                            return;
                                                        }
                                                        sparseArray4.put(w.h.tag_check_mute_from, 2);
                                                        ggVar53 = this.ewh.euU;
                                                        ggVar53.ba(view);
                                                        return;
                                                    } else if (booleanValue3) {
                                                        ggVar52 = this.ewh.euU;
                                                        ggVar52.a(((Integer) sparseArray4.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray4.get(w.h.tag_del_post_id), ((Integer) sparseArray4.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(w.h.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        ggVar37 = this.ewh.euU;
                                        if (ggVar37.eBR.aRz() != null) {
                                            ggVar49 = this.ewh.euU;
                                            if (view == ggVar49.eBR.aRz().aPJ()) {
                                                if (com.baidu.adp.lib.util.i.hj()) {
                                                    ggVar50 = this.ewh.euU;
                                                    ggVar50.azw();
                                                    ggVar51 = this.ewh.euU;
                                                    pbModel68 = this.ewh.eue;
                                                    com.baidu.tieba.pb.data.f pbData3 = pbModel68.getPbData();
                                                    pbModel69 = this.ewh.eue;
                                                    SparseArray<Object> c = ggVar51.c(pbData3, pbModel69.aOK(), 1);
                                                    if (c != null) {
                                                        pbModel70 = this.ewh.eue;
                                                        PbActivity pbActivity3 = this.ewh;
                                                        Activity pageActivity = this.ewh.getPageContext().getPageActivity();
                                                        pbModel71 = this.ewh.eue;
                                                        String id3 = pbModel71.getPbData().aMt().getId();
                                                        pbModel72 = this.ewh.eue;
                                                        String name2 = pbModel72.getPbData().aMt().getName();
                                                        pbModel73 = this.ewh.eue;
                                                        pbActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, pbModel73.getPbData().aMv().getId(), String.valueOf(pbModel70.getPbData().getUserData().getUserId()), (String) c.get(w.h.tag_forbid_user_name), (String) c.get(w.h.tag_forbid_user_post_id))));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.ewh.showToast(w.l.network_not_available);
                                                return;
                                            }
                                        }
                                        ggVar38 = this.ewh.euU;
                                        if (ggVar38.eBR.aRz() != null) {
                                            ggVar45 = this.ewh.euU;
                                            if (view == ggVar45.eBR.aRz().aPG()) {
                                                if (com.baidu.adp.lib.util.i.hj()) {
                                                    ggVar46 = this.ewh.euU;
                                                    pbModel66 = this.ewh.eue;
                                                    com.baidu.tieba.pb.data.f pbData4 = pbModel66.getPbData();
                                                    pbModel67 = this.ewh.eue;
                                                    SparseArray<Object> c2 = ggVar46.c(pbData4, pbModel67.aOK(), 1);
                                                    if (c2 != null) {
                                                        ggVar48 = this.ewh.euU;
                                                        ggVar48.a(((Integer) c2.get(w.h.tag_del_post_type)).intValue(), (String) c2.get(w.h.tag_del_post_id), ((Integer) c2.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(w.h.tag_del_post_is_self)).booleanValue());
                                                    }
                                                    ggVar47 = this.ewh.euU;
                                                    ggVar47.eBR.od();
                                                    return;
                                                }
                                                this.ewh.showToast(w.l.network_not_available);
                                                return;
                                            }
                                        }
                                        if (view.getId() != w.h.sub_pb_more && view.getId() != w.h.sub_pb_item && view.getId() != w.h.pb_floor_reply_more) {
                                            ggVar40 = this.ewh.euU;
                                            if (view != ggVar40.aNt()) {
                                                ggVar41 = this.ewh.euU;
                                                if (view == ggVar41.eBR.aRA()) {
                                                    ggVar44 = this.ewh.euU;
                                                    ggVar44.aQD();
                                                    return;
                                                }
                                                int id4 = view.getId();
                                                if (id4 == w.h.pb_u9_text_view) {
                                                    if (this.ewh.checkUpIsLogin() && (bsVar = (com.baidu.tbadk.core.data.bs) view.getTag()) != null && !StringUtils.isNull(bsVar.sP())) {
                                                        TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                        com.baidu.tbadk.core.util.be.vP().c(this.ewh.getPageContext(), new String[]{bsVar.sP()});
                                                        return;
                                                    }
                                                    return;
                                                } else if ((id4 == w.h.pb_floor_agree || id4 == w.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                    PostData aV = this.ewh.aV(view);
                                                    if (aV != null) {
                                                        TiebaStatic.log(this.ewh.aNC().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", aV.bmH() ? 0 : 1));
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.view_main_thread_praise_state) {
                                                    this.ewh.f(view, 2, false);
                                                    if (this.ewh.aNz() != null && this.ewh.aNz().getPbData() != null && this.ewh.aNz().getPbData().aMS() != null && this.ewh.aNz().getPbData().aMS() != null) {
                                                        TiebaStatic.log(this.ewh.aNC().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", this.ewh.aNz().getPbData().aMS().aMY() ? 0 : 1));
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.view_main_thread_praise_num || id4 == w.h.view_main_thread_praise_name_list) {
                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                                                        pbModel22 = this.ewh.eue;
                                                        if (pbModel22 != null) {
                                                            pbModel23 = this.ewh.eue;
                                                            if (pbModel23.getPbData() != null) {
                                                                pbModel24 = this.ewh.eue;
                                                                if (!StringUtils.isNull(pbModel24.getPbData().getThreadId())) {
                                                                    pbModel25 = this.ewh.eue;
                                                                    com.baidu.tieba.pb.data.m aMS = pbModel25.getPbData().aMS();
                                                                    if (aMS != null && aMS.getPraiseNum() > 0) {
                                                                        StringBuilder sb = new StringBuilder("https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=");
                                                                        pbModel26 = this.ewh.eue;
                                                                        com.baidu.tbadk.core.util.be.vP().c(this.ewh.getPageContext(), new String[]{sb.append(pbModel26.getPbData().getThreadId()).toString()});
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
                                                } else if (id4 == w.h.replybtn || id4 == w.h.cover_reply_content || id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right || id4 == w.h.image_more_tip) {
                                                    if (this.ewh.checkUpIsLogin()) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11740"));
                                                        PostData postData3 = null;
                                                        if (view != null && view.getTag() != null) {
                                                            postData3 = (PostData) ((SparseArray) view.getTag()).get(w.h.tag_load_sub_data);
                                                            if (postData3 == null || !com.baidu.tieba.pb.i.d(postData3)) {
                                                                euVar11 = this.ewh.euZ;
                                                                if (euVar11 == null) {
                                                                    this.ewh.euZ = new eu(this.ewh.getPageContext(), this.ewh.cdH);
                                                                    euVar41 = this.ewh.euZ;
                                                                    z7 = this.ewh.mIsLogin;
                                                                    euVar41.iS(z7);
                                                                }
                                                                euVar12 = this.ewh.euZ;
                                                                euVar12.showDialog();
                                                                boolean z11 = id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right;
                                                                if (z11) {
                                                                    com.baidu.tbadk.core.util.au auVar4 = new com.baidu.tbadk.core.util.au("c12006");
                                                                    pbModel29 = this.ewh.eue;
                                                                    TiebaStatic.log(auVar4.Z("tid", pbModel29.eyr));
                                                                }
                                                                SparseArray sparseArray5 = new SparseArray();
                                                                sparseArray5.put(w.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(w.h.tag_clip_board));
                                                                sparseArray5.put(w.h.tag_is_subpb, false);
                                                                euVar13 = this.ewh.euZ;
                                                                euVar13.aPr().setTag(sparseArray5);
                                                                euVar14 = this.ewh.euZ;
                                                                euVar14.aPw().setTag(view.getTag());
                                                                euVar15 = this.ewh.euZ;
                                                                euVar15.iU(z11);
                                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                boolean booleanValue5 = ((Boolean) sparseArray6.get(w.h.tag_should_manage_visible)).booleanValue();
                                                                boolean booleanValue6 = ((Boolean) sparseArray6.get(w.h.tag_user_mute_visible)).booleanValue();
                                                                boolean booleanValue7 = ((Boolean) sparseArray6.get(w.h.tag_should_delete_visible)).booleanValue();
                                                                if (!(sparseArray6.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                    z3 = false;
                                                                } else {
                                                                    z3 = ((Boolean) sparseArray6.get(w.h.tag_del_post_is_self)).booleanValue();
                                                                }
                                                                String str6 = null;
                                                                if (sparseArray6.get(w.h.tag_forbid_user_post_id) instanceof String) {
                                                                    str6 = (String) sparseArray6.get(w.h.tag_forbid_user_post_id);
                                                                }
                                                                if (booleanValue5) {
                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                    sparseArray7.put(w.h.tag_should_manage_visible, true);
                                                                    sparseArray7.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                                    sparseArray7.put(w.h.tag_forbid_user_name, sparseArray6.get(w.h.tag_forbid_user_name));
                                                                    sparseArray7.put(w.h.tag_forbid_user_post_id, str6);
                                                                    if (booleanValue6) {
                                                                        sparseArray7.put(w.h.tag_user_mute_visible, true);
                                                                        sparseArray7.put(w.h.tag_is_mem, sparseArray6.get(w.h.tag_is_mem));
                                                                        sparseArray7.put(w.h.tag_user_mute_mute_userid, sparseArray6.get(w.h.tag_user_mute_mute_userid));
                                                                        sparseArray7.put(w.h.tag_user_mute_mute_username, sparseArray6.get(w.h.tag_user_mute_mute_username));
                                                                        sparseArray7.put(w.h.tag_user_mute_post_id, sparseArray6.get(w.h.tag_user_mute_post_id));
                                                                        sparseArray7.put(w.h.tag_user_mute_thread_id, sparseArray6.get(w.h.tag_user_mute_thread_id));
                                                                    } else {
                                                                        sparseArray7.put(w.h.tag_user_mute_visible, false);
                                                                    }
                                                                    if (booleanValue7) {
                                                                        sparseArray7.put(w.h.tag_should_delete_visible, true);
                                                                        sparseArray7.put(w.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                        sparseArray7.put(w.h.tag_del_post_id, sparseArray6.get(w.h.tag_del_post_id));
                                                                        sparseArray7.put(w.h.tag_del_post_type, sparseArray6.get(w.h.tag_del_post_type));
                                                                        euVar40 = this.ewh.euZ;
                                                                        euVar40.aPu().setVisibility(0);
                                                                    } else {
                                                                        sparseArray7.put(w.h.tag_should_delete_visible, false);
                                                                        euVar35 = this.ewh.euZ;
                                                                        euVar35.aPu().setVisibility(8);
                                                                    }
                                                                    euVar36 = this.ewh.euZ;
                                                                    euVar36.aPs().setTag(sparseArray7);
                                                                    euVar37 = this.ewh.euZ;
                                                                    euVar37.aPu().setTag(sparseArray7);
                                                                    euVar38 = this.ewh.euZ;
                                                                    euVar38.aPs().setText(w.l.bar_manager);
                                                                    euVar39 = this.ewh.euZ;
                                                                    euVar39.aPs().setVisibility(0);
                                                                } else if (!booleanValue7) {
                                                                    euVar16 = this.ewh.euZ;
                                                                    euVar16.aPs().setVisibility(8);
                                                                    euVar17 = this.ewh.euZ;
                                                                    euVar17.aPu().setVisibility(8);
                                                                } else {
                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                    sparseArray8.put(w.h.tag_should_manage_visible, false);
                                                                    sparseArray8.put(w.h.tag_user_mute_visible, false);
                                                                    sparseArray8.put(w.h.tag_should_delete_visible, true);
                                                                    sparseArray8.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                                    sparseArray8.put(w.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                    sparseArray8.put(w.h.tag_del_post_id, sparseArray6.get(w.h.tag_del_post_id));
                                                                    sparseArray8.put(w.h.tag_del_post_type, sparseArray6.get(w.h.tag_del_post_type));
                                                                    euVar18 = this.ewh.euZ;
                                                                    euVar18.aPs().setTag(sparseArray8);
                                                                    euVar19 = this.ewh.euZ;
                                                                    euVar19.aPu().setTag(sparseArray8);
                                                                    euVar20 = this.ewh.euZ;
                                                                    euVar20.aPs().setText(w.l.delete);
                                                                    euVar21 = this.ewh.euZ;
                                                                    euVar21.aPu().setVisibility(0);
                                                                    euVar22 = this.ewh.euZ;
                                                                    euVar22.aPs().setVisibility(8);
                                                                }
                                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                if (!(sparseArray9.get(w.h.tag_user_mute_visible) instanceof Boolean)) {
                                                                    z4 = false;
                                                                } else {
                                                                    z4 = ((Boolean) sparseArray9.get(w.h.tag_user_mute_visible)).booleanValue();
                                                                }
                                                                if (!((Boolean) sparseArray9.get(w.h.tag_should_manage_visible)).booleanValue() && z4) {
                                                                    SparseArray sparseArray10 = new SparseArray();
                                                                    sparseArray10.put(w.h.tag_user_mute_visible, true);
                                                                    sparseArray10.put(w.h.tag_is_mem, sparseArray9.get(w.h.tag_is_mem));
                                                                    sparseArray10.put(w.h.tag_user_mute_mute_userid, sparseArray9.get(w.h.tag_user_mute_mute_userid));
                                                                    sparseArray10.put(w.h.tag_user_mute_mute_username, sparseArray9.get(w.h.tag_user_mute_mute_username));
                                                                    sparseArray10.put(w.h.tag_user_mute_post_id, sparseArray9.get(w.h.tag_user_mute_post_id));
                                                                    sparseArray10.put(w.h.tag_user_mute_thread_id, sparseArray9.get(w.h.tag_user_mute_thread_id));
                                                                    sparseArray10.put(w.h.tag_del_post_is_self, sparseArray9.get(w.h.tag_del_post_is_self));
                                                                    sparseArray10.put(w.h.tag_del_post_type, sparseArray9.get(w.h.tag_del_post_type));
                                                                    sparseArray10.put(w.h.tag_del_post_id, sparseArray9.get(w.h.tag_del_post_id));
                                                                    sparseArray10.put(w.h.tag_manage_user_identity, sparseArray9.get(w.h.tag_manage_user_identity));
                                                                    euVar31 = this.ewh.euZ;
                                                                    euVar31.aPt().setTag(sparseArray10);
                                                                    euVar32 = this.ewh.euZ;
                                                                    euVar32.aPt().setVisibility(0);
                                                                    euVar33 = this.ewh.euZ;
                                                                    euVar33.aPs().setVisibility(8);
                                                                    euVar34 = this.ewh.euZ;
                                                                    euVar34.aPt().setText(w.l.mute_option);
                                                                } else {
                                                                    if (!(sparseArray9.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                        z5 = false;
                                                                    } else {
                                                                        z5 = ((Boolean) sparseArray9.get(w.h.tag_del_post_is_self)).booleanValue();
                                                                    }
                                                                    String str7 = null;
                                                                    if (sparseArray9.get(w.h.tag_forbid_user_post_id) instanceof String) {
                                                                        str7 = (String) sparseArray9.get(w.h.tag_forbid_user_post_id);
                                                                    }
                                                                    iC = this.ewh.iC(z5);
                                                                    boolean isLogin = iC & this.ewh.isLogin();
                                                                    this.ewh.evW = (PostData) sparseArray9.get(w.h.tag_clip_board);
                                                                    if (gf.k(this.ewh.evW) ? false : isLogin) {
                                                                        euVar24 = this.ewh.euZ;
                                                                        euVar24.aPt().setVisibility(0);
                                                                        euVar25 = this.ewh.euZ;
                                                                        euVar25.aPt().setTag(str7);
                                                                    } else {
                                                                        euVar23 = this.ewh.euZ;
                                                                        euVar23.aPt().setVisibility(8);
                                                                    }
                                                                }
                                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                                long j2 = 0;
                                                                if (!(sparseArray11.get(w.h.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = ((Boolean) sparseArray11.get(w.h.tag_should_hide_chudian_visible)).booleanValue();
                                                                }
                                                                if (sparseArray11.get(w.h.tag_chudian_template_id) instanceof Long) {
                                                                    j2 = ((Long) sparseArray11.get(w.h.tag_chudian_template_id)).longValue();
                                                                }
                                                                if (!(sparseArray11.get(w.h.tag_chudian_monitor_id) instanceof String)) {
                                                                    str = "";
                                                                } else {
                                                                    str = (String) sparseArray11.get(w.h.tag_chudian_monitor_id);
                                                                }
                                                                if (!(sparseArray11.get(w.h.tag_chudian_hide_day) instanceof Integer)) {
                                                                    i = 0;
                                                                } else {
                                                                    i = ((Integer) sparseArray11.get(w.h.tag_chudian_hide_day)).intValue();
                                                                }
                                                                if (z6) {
                                                                    euVar27 = this.ewh.euZ;
                                                                    euVar27.aPv().setVisibility(0);
                                                                    euVar28 = this.ewh.euZ;
                                                                    euVar28.aPv().setTag(w.h.tag_chudian_template_id, Long.valueOf(j2));
                                                                    euVar29 = this.ewh.euZ;
                                                                    euVar29.aPv().setTag(w.h.tag_chudian_monitor_id, str);
                                                                    euVar30 = this.ewh.euZ;
                                                                    euVar30.aPv().setTag(w.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                } else {
                                                                    euVar26 = this.ewh.euZ;
                                                                    euVar26.aPv().setVisibility(8);
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        pbModel27 = this.ewh.eue;
                                                        if (pbModel27.getPbData().nz()) {
                                                            pbModel28 = this.ewh.eue;
                                                            String ny = pbModel28.getPbData().ny();
                                                            if (postData3 != null && !com.baidu.adp.lib.util.j.isEmpty(ny) && ny.equals(postData3.getId())) {
                                                                z2 = true;
                                                                if (!z2) {
                                                                    euVar10 = this.ewh.euZ;
                                                                    euVar10.aPr().setText(w.l.remove_mark);
                                                                } else {
                                                                    euVar7 = this.ewh.euZ;
                                                                    euVar7.aPr().setText(w.l.mark);
                                                                }
                                                                euVar8 = this.ewh.euZ;
                                                                euVar8.iT(true);
                                                                euVar9 = this.ewh.euZ;
                                                                euVar9.refreshUI();
                                                                return;
                                                            }
                                                        }
                                                        z2 = false;
                                                        if (!z2) {
                                                        }
                                                        euVar8 = this.ewh.euZ;
                                                        euVar8.iT(true);
                                                        euVar9 = this.ewh.euZ;
                                                        euVar9.refreshUI();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.pb_act_btn) {
                                                    pbModel57 = this.ewh.eue;
                                                    if (pbModel57.getPbData() != null) {
                                                        pbModel58 = this.ewh.eue;
                                                        if (pbModel58.getPbData().aMv() != null) {
                                                            pbModel59 = this.ewh.eue;
                                                            if (pbModel59.getPbData().aMv().rX() != null) {
                                                                Activity activity = this.ewh.getActivity();
                                                                pbModel60 = this.ewh.eue;
                                                                com.baidu.tbadk.browser.g.T(activity, pbModel60.getPbData().aMv().rX());
                                                                pbModel61 = this.ewh.eue;
                                                                if (pbModel61.getPbData().aMv().rV() != 1) {
                                                                    pbModel62 = this.ewh.eue;
                                                                    if (pbModel62.getPbData().aMv().rV() == 2) {
                                                                        TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.lottery_tail) {
                                                    if (view.getTag(w.h.tag_pb_lottery_tail_link) instanceof String) {
                                                        String str8 = (String) view.getTag(w.h.tag_pb_lottery_tail_link);
                                                        com.baidu.tbadk.core.util.au auVar5 = new com.baidu.tbadk.core.util.au("c10912");
                                                        pbModel54 = this.ewh.eue;
                                                        com.baidu.tbadk.core.util.au Z = auVar5.Z("fid", pbModel54.getPbData().getForumId());
                                                        pbModel55 = this.ewh.eue;
                                                        TiebaStatic.log(Z.Z("tid", pbModel55.getPbData().getThreadId()).Z("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                        pbModel56 = this.ewh.eue;
                                                        if (pbModel56.getPbData().getThreadId().equals(str8)) {
                                                            ggVar43 = this.ewh.euU;
                                                            ggVar43.setSelection(0);
                                                            return;
                                                        }
                                                        this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ewh.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.pb_item_tail_content) {
                                                    if (com.baidu.tbadk.core.util.bl.aN(this.ewh.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.m9getInst().getString(w.l.tail_web_view_title);
                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                        if (!StringUtils.isNull(string2)) {
                                                            TiebaStatic.log("c10056");
                                                            com.baidu.tbadk.browser.g.a(view.getContext(), string, string2, true, true, true);
                                                        }
                                                        ggVar42 = this.ewh.euU;
                                                        ggVar42.aOk();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.join_vote_tv) {
                                                    if (view != null) {
                                                        com.baidu.tbadk.browser.g.T(this.ewh.getActivity(), (String) view.getTag());
                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                        aNE3 = this.ewh.aNE();
                                                        if (aNE3 == 1) {
                                                            pbModel50 = this.ewh.eue;
                                                            if (pbModel50 != null) {
                                                                pbModel51 = this.ewh.eue;
                                                                if (pbModel51.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.au auVar6 = new com.baidu.tbadk.core.util.au("c10397");
                                                                    pbModel52 = this.ewh.eue;
                                                                    com.baidu.tbadk.core.util.au Z2 = auVar6.Z("fid", pbModel52.getPbData().getForumId());
                                                                    pbModel53 = this.ewh.eue;
                                                                    TiebaStatic.log(Z2.Z("tid", pbModel53.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        aNE4 = this.ewh.aNE();
                                                        if (aNE4 == 2) {
                                                            pbModel46 = this.ewh.eue;
                                                            if (pbModel46 != null) {
                                                                pbModel47 = this.ewh.eue;
                                                                if (pbModel47.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.au auVar7 = new com.baidu.tbadk.core.util.au("c10401");
                                                                    pbModel48 = this.ewh.eue;
                                                                    com.baidu.tbadk.core.util.au Z3 = auVar7.Z("fid", pbModel48.getPbData().getForumId());
                                                                    pbModel49 = this.ewh.eue;
                                                                    TiebaStatic.log(Z3.Z("tid", pbModel49.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.look_all_tv) {
                                                    if (view != null) {
                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                        com.baidu.tbadk.browser.g.T(this.ewh.getActivity(), (String) view.getTag());
                                                        aNE = this.ewh.aNE();
                                                        if (aNE == 1) {
                                                            pbModel42 = this.ewh.eue;
                                                            if (pbModel42 != null) {
                                                                pbModel43 = this.ewh.eue;
                                                                if (pbModel43.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.au auVar8 = new com.baidu.tbadk.core.util.au("c10507");
                                                                    pbModel44 = this.ewh.eue;
                                                                    com.baidu.tbadk.core.util.au Z4 = auVar8.Z("fid", pbModel44.getPbData().getForumId());
                                                                    pbModel45 = this.ewh.eue;
                                                                    TiebaStatic.log(Z4.Z("tid", pbModel45.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        aNE2 = this.ewh.aNE();
                                                        if (aNE2 == 2) {
                                                            pbModel38 = this.ewh.eue;
                                                            if (pbModel38 != null) {
                                                                pbModel39 = this.ewh.eue;
                                                                if (pbModel39.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.au auVar9 = new com.baidu.tbadk.core.util.au("c10508");
                                                                    pbModel40 = this.ewh.eue;
                                                                    com.baidu.tbadk.core.util.au Z5 = auVar9.Z("fid", pbModel40.getPbData().getForumId());
                                                                    pbModel41 = this.ewh.eue;
                                                                    TiebaStatic.log(Z5.Z("tid", pbModel41.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 != w.h.manga_prev_btn) {
                                                    if (id4 != w.h.manga_next_btn) {
                                                        if (id4 == w.h.yule_head_img_img) {
                                                            pbModel34 = this.ewh.eue;
                                                            if (pbModel34 != null) {
                                                                pbModel35 = this.ewh.eue;
                                                                if (pbModel35.getPbData() != null) {
                                                                    pbModel36 = this.ewh.eue;
                                                                    if (pbModel36.getPbData().aMN() != null) {
                                                                        pbModel37 = this.ewh.eue;
                                                                        com.baidu.tieba.pb.data.f pbData5 = pbModel37.getPbData();
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11679").Z("fid", pbData5.getForumId()));
                                                                        com.baidu.tbadk.core.util.be.vP().c(this.ewh.getPageContext(), new String[]{pbData5.aMN().aMU()});
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id4 == w.h.yule_head_img_all_rank) {
                                                            pbModel30 = this.ewh.eue;
                                                            if (pbModel30 != null) {
                                                                pbModel31 = this.ewh.eue;
                                                                if (pbModel31.getPbData() != null) {
                                                                    pbModel32 = this.ewh.eue;
                                                                    if (pbModel32.getPbData().aMN() != null) {
                                                                        pbModel33 = this.ewh.eue;
                                                                        com.baidu.tieba.pb.data.f pbData6 = pbModel33.getPbData();
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11678").Z("fid", pbData6.getForumId()));
                                                                        com.baidu.tbadk.core.util.be.vP().c(this.ewh.getPageContext(), new String[]{pbData6.aMN().aMU()});
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
                                                    this.ewh.aNW();
                                                    return;
                                                } else {
                                                    this.ewh.aNV();
                                                    return;
                                                }
                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                long c3 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                pbModel63 = this.ewh.eue;
                                                long c4 = com.baidu.adp.lib.g.b.c(pbModel63.getPbData().getForumId(), 0L);
                                                pbModel64 = this.ewh.eue;
                                                long c5 = com.baidu.adp.lib.g.b.c(pbModel64.getThreadID(), 0L);
                                                pbModel65 = this.ewh.eue;
                                                this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.ewh.getPageContext().getPageActivity(), 24008, c4, c5, c3, pbModel65.getPbData().aMv().rL())));
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (this.ewh.checkUpIsLogin()) {
                                            pbModel7 = this.ewh.eue;
                                            if (pbModel7.getPbData() != null) {
                                                ggVar39 = this.ewh.euU;
                                                ggVar39.azw();
                                                SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                PostData postData4 = (PostData) sparseArray12.get(w.h.tag_load_sub_data);
                                                View view2 = (View) sparseArray12.get(w.h.tag_load_sub_view);
                                                if (postData4 != null && view2 != null) {
                                                    pbModel8 = this.ewh.eue;
                                                    String threadID2 = pbModel8.getThreadID();
                                                    String id5 = postData4.getId();
                                                    int i7 = 0;
                                                    pbModel9 = this.ewh.eue;
                                                    if (pbModel9.getPbData() != null) {
                                                        pbModel20 = this.ewh.eue;
                                                        i7 = pbModel20.getPbData().aMG();
                                                    }
                                                    if (com.baidu.tieba.pb.i.d(postData4)) {
                                                        return;
                                                    }
                                                    this.ewh.aei();
                                                    if (view.getId() != w.h.replybtn) {
                                                        if (view.getId() == w.h.sub_pb_item) {
                                                            SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                            String str9 = (String) sparseArray13.get(w.h.tag_photo_username);
                                                            String str10 = (String) sparseArray12.get(w.h.tag_photo_userid);
                                                            PostData postData5 = (PostData) sparseArray13.get(w.h.tag_load_sub_data);
                                                            String str11 = null;
                                                            if (postData5 != null) {
                                                                str11 = postData5.getId();
                                                            }
                                                            TiebaStatic.log("c11741");
                                                            oM2 = this.ewh.oM(id5);
                                                            pbModel13 = this.ewh.eue;
                                                            if (pbModel13 != null) {
                                                                pbModel14 = this.ewh.eue;
                                                                if (pbModel14.getPbData() != null && oM2 != null && this.ewh.aNy().aQd() != null) {
                                                                    com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                                                                    pbModel15 = this.ewh.eue;
                                                                    nVar2.b(pbModel15.getPbData().aMt());
                                                                    pbModel16 = this.ewh.eue;
                                                                    nVar2.O(pbModel16.getPbData().aMv());
                                                                    nVar2.f(postData5);
                                                                    this.ewh.aNy().aQd().d(nVar2);
                                                                    this.ewh.aNy().aQd().setPostId(str11);
                                                                    this.ewh.a(view, str10, str9);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        TiebaStatic.log("c11742");
                                                        oM = this.ewh.oM(id5);
                                                        if (postData4 != null) {
                                                            pbModel10 = this.ewh.eue;
                                                            if (pbModel10 != null) {
                                                                pbModel11 = this.ewh.eue;
                                                                if (pbModel11.getPbData() != null && oM != null) {
                                                                    SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.ewh.getPageContext().getPageActivity());
                                                                    SmallTailInfo aSA2 = postData4.aSA();
                                                                    pbModel12 = this.ewh.eue;
                                                                    this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i7, aSA2, pbModel12.getPbData().qe(), false, postData4.getAuthor().getIconInfo()).addBigImageData(oM.ewy, oM.ewz, oM.ewA, oM.index)));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    oM3 = this.ewh.oM(id5);
                                                    pbModel17 = this.ewh.eue;
                                                    if (pbModel17 != null) {
                                                        pbModel18 = this.ewh.eue;
                                                        if (pbModel18.getPbData() != null && oM3 != null) {
                                                            SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.ewh.getPageContext().getPageActivity());
                                                            SmallTailInfo aSA3 = postData4.aSA();
                                                            pbModel19 = this.ewh.eue;
                                                            this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i7, aSA3, pbModel19.getPbData().qe(), false, postData4.getAuthor().getIconInfo()).addBigImageData(oM3.ewy, oM3.ewz, oM3.ewA, oM3.index)));
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
                                            com.baidu.tbadk.core.util.au r = new com.baidu.tbadk.core.util.au("c10517").r("obj_locate", 3);
                                            pbModel21 = this.ewh.eue;
                                            TiebaStatic.log(r.Z("fid", pbModel21.getPbData().getForumId()));
                                            return;
                                        }
                                    } else if (!this.ewh.checkUpIsLogin()) {
                                        com.baidu.tbadk.core.util.au r2 = new com.baidu.tbadk.core.util.au("c10517").r("obj_locate", 2);
                                        pbModel75 = this.ewh.eue;
                                        TiebaStatic.log(r2.Z("fid", pbModel75.getPbData().getForumId()));
                                        return;
                                    } else {
                                        this.ewh.aNv();
                                        return;
                                    }
                                }
                                ggVar66 = this.ewh.euU;
                                ggVar66.azw();
                                if (!com.baidu.adp.lib.util.i.hj()) {
                                    this.ewh.showToast(w.l.network_not_available);
                                    return;
                                }
                                this.ewh.oI(2);
                                this.ewh.aei();
                                ggVar67 = this.ewh.euU;
                                ggVar67.aQx();
                                ggVar68 = this.ewh.euU;
                                ggVar68.aQs().iH(true);
                                boolean z12 = false;
                                if (view.getTag() instanceof Boolean) {
                                    pbModel92 = this.ewh.eue;
                                    z12 = pbModel92.iP(!((Boolean) view.getTag()).booleanValue());
                                } else {
                                    pbModel91 = this.ewh.eue;
                                    pbModel91.aOU();
                                }
                                TiebaStatic.log("c12097");
                                if (z12 && this.ewh.getListView() != null) {
                                    i2 = this.ewh.evo;
                                    if (i2 > this.ewh.getListView().getFirstVisiblePosition()) {
                                        this.ewh.evo = this.ewh.getListView().getFirstVisiblePosition();
                                    }
                                    View childAt = this.ewh.getListView().getChildAt(0);
                                    int i8 = -1;
                                    if (childAt != null) {
                                        i8 = childAt.getTop();
                                    }
                                    gg aNy = this.ewh.aNy();
                                    i3 = this.ewh.evo;
                                    aNy.i(i3, i8);
                                    return;
                                }
                                return;
                            }
                            if (com.baidu.adp.lib.util.i.hj()) {
                                ggVar80 = this.ewh.euU;
                                ggVar80.azw();
                                ggVar81 = this.ewh.euU;
                                if (ggVar81.eBR.aRz() != null) {
                                    ggVar85 = this.ewh.euU;
                                    if (view == ggVar85.eBR.aRz().aPE()) {
                                        ggVar86 = this.ewh.euU;
                                        if (!ggVar86.aQZ()) {
                                            ggVar87 = this.ewh.euU;
                                            ggVar87.aOk();
                                        }
                                    }
                                }
                                z8 = this.ewh.mIsLoading;
                                if (!z8) {
                                    ggVar82 = this.ewh.euU;
                                    ggVar82.eBR.eGI.setEnabled(false);
                                    this.ewh.aei();
                                    ggVar83 = this.ewh.euU;
                                    ggVar83.aQx();
                                    if (view.getId() == w.h.floor_owner_reply) {
                                        pbModel103 = this.ewh.eue;
                                        aNT4 = this.ewh.aNT();
                                        oP = pbModel103.h(true, aNT4);
                                    } else if (view.getId() == w.h.reply_title) {
                                        pbModel102 = this.ewh.eue;
                                        aNT3 = this.ewh.aNT();
                                        oP = pbModel102.h(false, aNT3);
                                    } else {
                                        pbModel101 = this.ewh.eue;
                                        aNT2 = this.ewh.aNT();
                                        oP = pbModel101.oP(aNT2);
                                    }
                                    if (oP) {
                                        ggVar84 = this.ewh.euU;
                                        ggVar84.atY();
                                        this.ewh.mIsLoading = true;
                                    }
                                    TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    this.ewh.oI(2);
                                    return;
                                }
                                return;
                            }
                            this.ewh.showToast(w.l.network_not_available);
                            return;
                        } else if (com.baidu.adp.lib.util.i.hj()) {
                            ggVar21 = this.ewh.euU;
                            ggVar21.iK(true);
                            ggVar22 = this.ewh.euU;
                            ggVar22.aOk();
                            z = this.ewh.mIsLoading;
                            if (!z) {
                                this.ewh.mIsLoading = true;
                                ggVar23 = this.ewh.euU;
                                ggVar23.eBR.eGI.setEnabled(false);
                                ggVar24 = this.ewh.euU;
                                ggVar24.atY();
                                this.ewh.aei();
                                ggVar25 = this.ewh.euU;
                                ggVar25.aQx();
                                pbModel6 = this.ewh.eue;
                                aNT = this.ewh.aNT();
                                pbModel6.oP(aNT);
                                TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                this.ewh.oI(2);
                                return;
                            }
                            return;
                        } else {
                            this.ewh.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                    pbModel109 = this.ewh.eue;
                    if (pbModel109.getPbData() != null) {
                        pbModel117 = this.ewh.eue;
                        if (pbModel117.getPbData().aMv() != null) {
                            pbModel118 = this.ewh.eue;
                            if (pbModel118.getPbData().aMv().se()) {
                                pbModel119 = this.ewh.eue;
                                if (pbModel119.getPbData().aMv().rI() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11922"));
                                }
                            }
                        }
                    }
                    pbModel110 = this.ewh.eue;
                    if (pbModel110.getErrorNo() == 4) {
                        pbModel114 = this.ewh.eue;
                        if (StringUtils.isNull(pbModel114.aOJ())) {
                            pbModel115 = this.ewh.eue;
                            if (pbModel115.getAppealInfo() != null) {
                                pbModel116 = this.ewh.eue;
                                name = pbModel116.getAppealInfo().forumName;
                            }
                        }
                        this.ewh.finish();
                        return;
                    }
                    pbModel111 = this.ewh.eue;
                    name = pbModel111.getPbData().aMt().getName();
                    if (!StringUtils.isNull(name)) {
                        pbModel112 = this.ewh.eue;
                        String aOJ = pbModel112.aOJ();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.ewh.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                        pbModel113 = this.ewh.eue;
                        if (pbModel113.aOL() && aOJ != null && aOJ.equals(name)) {
                            this.ewh.finish();
                            return;
                        } else {
                            this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                            return;
                        }
                    }
                    this.ewh.finish();
                    return;
                }
                if (com.baidu.adp.lib.util.i.hj()) {
                    pbModel = this.ewh.eue;
                    if (pbModel.getPbData().aMG() == 1) {
                        forumManageModel = this.ewh.euT;
                        if (!forumManageModel.bng()) {
                            ggVar8 = this.ewh.euU;
                            ggVar8.azw();
                            int i9 = 0;
                            ggVar9 = this.ewh.euU;
                            if (ggVar9.eBR.aRz() != null) {
                                ggVar15 = this.ewh.euU;
                                if (view == ggVar15.eBR.aRz().aPF()) {
                                    pbModel5 = this.ewh.eue;
                                    if (pbModel5.getPbData().aMv().rm() == 1) {
                                        i9 = 5;
                                    } else {
                                        i9 = 4;
                                    }
                                    pbModel3 = this.ewh.eue;
                                    ForumData aMt = pbModel3.getPbData().aMt();
                                    String name3 = aMt.getName();
                                    String id6 = aMt.getId();
                                    pbModel4 = this.ewh.eue;
                                    id = pbModel4.getPbData().aMv().getId();
                                    if (com.baidu.tieba.c.a.Ux() || !com.baidu.tieba.c.a.h(this.ewh.getBaseContext(), id, null)) {
                                        ggVar13 = this.ewh.euU;
                                        ggVar13.aQu();
                                        forumManageModel2 = this.ewh.euT;
                                        ggVar14 = this.ewh.euU;
                                        forumManageModel2.a(id6, name3, id, i9, ggVar14.aQw());
                                        return;
                                    }
                                    return;
                                }
                            }
                            ggVar10 = this.ewh.euU;
                            if (ggVar10.eBR.aRz() != null) {
                                ggVar12 = this.ewh.euU;
                                if (view == ggVar12.eBR.aRz().aPH()) {
                                    pbModel2 = this.ewh.eue;
                                    if (pbModel2.getPbData().aMv().rn() == 1) {
                                        i9 = 3;
                                    } else {
                                        i9 = 6;
                                    }
                                    pbModel3 = this.ewh.eue;
                                    ForumData aMt2 = pbModel3.getPbData().aMt();
                                    String name32 = aMt2.getName();
                                    String id62 = aMt2.getId();
                                    pbModel4 = this.ewh.eue;
                                    id = pbModel4.getPbData().aMv().getId();
                                    if (com.baidu.tieba.c.a.Ux()) {
                                    }
                                    ggVar13 = this.ewh.euU;
                                    ggVar13.aQu();
                                    forumManageModel2 = this.ewh.euT;
                                    ggVar14 = this.ewh.euU;
                                    forumManageModel2.a(id62, name32, id, i9, ggVar14.aQw());
                                    return;
                                }
                            }
                            ggVar11 = this.ewh.euU;
                            if (view == ggVar11.aQv()) {
                                i9 = 2;
                            }
                            pbModel3 = this.ewh.eue;
                            ForumData aMt22 = pbModel3.getPbData().aMt();
                            String name322 = aMt22.getName();
                            String id622 = aMt22.getId();
                            pbModel4 = this.ewh.eue;
                            id = pbModel4.getPbData().aMv().getId();
                            if (com.baidu.tieba.c.a.Ux()) {
                            }
                            ggVar13 = this.ewh.euU;
                            ggVar13.aQu();
                            forumManageModel2 = this.ewh.euT;
                            ggVar14 = this.ewh.euU;
                            forumManageModel2.a(id622, name322, id, i9, ggVar14.aQw());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.ewh.showToast(w.l.network_not_available);
            }
        }
    }
}
