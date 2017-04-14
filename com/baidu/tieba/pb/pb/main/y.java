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
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v125, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v129, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v178, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0835, code lost:
        if (r18 == r1.eoV.aNZ().Sv()) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x028d, code lost:
        if (r18 == r1.eoV.aNZ().aMu()) goto L824;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:572:0x1ad2  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x1c8e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x033d  */
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
        PbModel pbModel;
        ForumManageModel forumManageModel;
        ey eyVar6;
        ey eyVar7;
        ey eyVar8;
        ey eyVar9;
        ey eyVar10;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        String id;
        ey eyVar11;
        ForumManageModel forumManageModel2;
        ey eyVar12;
        ey eyVar13;
        PbModel pbModel5;
        ey eyVar14;
        ey eyVar15;
        ey eyVar16;
        ey eyVar17;
        ey eyVar18;
        ey eyVar19;
        boolean z;
        ey eyVar20;
        ey eyVar21;
        ey eyVar22;
        PbModel pbModel6;
        String aKH;
        ey eyVar23;
        ey eyVar24;
        ey eyVar25;
        ey eyVar26;
        ey eyVar27;
        ey eyVar28;
        ey eyVar29;
        ey eyVar30;
        ey eyVar31;
        ey eyVar32;
        ey eyVar33;
        dp dpVar;
        dp dpVar2;
        dp dpVar3;
        dp dpVar4;
        dp dpVar5;
        ey eyVar34;
        ey eyVar35;
        dp dpVar6;
        ey eyVar36;
        ey eyVar37;
        ey eyVar38;
        PbModel pbModel7;
        ey eyVar39;
        PbModel pbModel8;
        PbModel pbModel9;
        PbActivity.b ny;
        PbModel pbModel10;
        PbModel pbModel11;
        PbModel pbModel12;
        PbActivity.b ny2;
        PbModel pbModel13;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        PbActivity.b ny3;
        PbModel pbModel17;
        PbModel pbModel18;
        PbModel pbModel19;
        PbModel pbModel20;
        PbModel pbModel21;
        ey eyVar40;
        ey eyVar41;
        dp dpVar7;
        dp dpVar8;
        PbModel pbModel22;
        boolean z2;
        dp dpVar9;
        dp dpVar10;
        dp dpVar11;
        dp dpVar12;
        PbModel pbModel23;
        dp dpVar13;
        dp dpVar14;
        dp dpVar15;
        boolean z3;
        dp dpVar16;
        dp dpVar17;
        dp dpVar18;
        dp dpVar19;
        dp dpVar20;
        dp dpVar21;
        dp dpVar22;
        boolean z4;
        boolean z5;
        boolean ii;
        dp dpVar23;
        dp dpVar24;
        dp dpVar25;
        boolean z6;
        String str;
        int i;
        dp dpVar26;
        dp dpVar27;
        dp dpVar28;
        dp dpVar29;
        dp dpVar30;
        dp dpVar31;
        dp dpVar32;
        dp dpVar33;
        dp dpVar34;
        dp dpVar35;
        dp dpVar36;
        dp dpVar37;
        dp dpVar38;
        dp dpVar39;
        dp dpVar40;
        PbModel pbModel24;
        dp dpVar41;
        boolean z7;
        PbModel pbModel25;
        PbModel pbModel26;
        PbModel pbModel27;
        PbModel pbModel28;
        PbModel pbModel29;
        PbModel pbModel30;
        PbModel pbModel31;
        PbModel pbModel32;
        int aKw;
        int aKw2;
        PbModel pbModel33;
        PbModel pbModel34;
        PbModel pbModel35;
        PbModel pbModel36;
        PbModel pbModel37;
        PbModel pbModel38;
        PbModel pbModel39;
        PbModel pbModel40;
        int aKw3;
        int aKw4;
        PbModel pbModel41;
        PbModel pbModel42;
        PbModel pbModel43;
        PbModel pbModel44;
        PbModel pbModel45;
        PbModel pbModel46;
        PbModel pbModel47;
        PbModel pbModel48;
        ey eyVar42;
        PbModel pbModel49;
        PbModel pbModel50;
        PbModel pbModel51;
        ey eyVar43;
        PbModel pbModel52;
        PbModel pbModel53;
        PbModel pbModel54;
        PbModel pbModel55;
        PbModel pbModel56;
        PbModel pbModel57;
        PostData postData;
        PbModel pbModel58;
        PbModel pbModel59;
        PbModel pbModel60;
        com.baidu.tbadk.core.data.bo boVar;
        ey eyVar44;
        PbModel pbModel61;
        PbModel pbModel62;
        PbModel pbModel63;
        ey eyVar45;
        ey eyVar46;
        PbModel pbModel64;
        PbModel pbModel65;
        ey eyVar47;
        ey eyVar48;
        ey eyVar49;
        ey eyVar50;
        ey eyVar51;
        PbModel pbModel66;
        PbModel pbModel67;
        PbModel pbModel68;
        PbModel pbModel69;
        PbModel pbModel70;
        PbModel pbModel71;
        ey eyVar52;
        PbModel pbModel72;
        PbModel pbModel73;
        PbModel pbModel74;
        PbModel pbModel75;
        ey eyVar53;
        ey eyVar54;
        dp dpVar42;
        ey eyVar55;
        ey eyVar56;
        PbModel pbModel76;
        PbModel pbModel77;
        ey eyVar57;
        PbModel pbModel78;
        dp dpVar43;
        PbModel pbModel79;
        dp dpVar44;
        ey eyVar58;
        PbModel pbModel80;
        dp dpVar45;
        dp dpVar46;
        PbModel pbModel81;
        ey eyVar59;
        SparseArray sparseArray;
        PostData postData2;
        PbModel pbModel82;
        PbModel pbModel83;
        PbActivity.b ny4;
        PbModel pbModel84;
        PbModel pbModel85;
        PbModel pbModel86;
        dp dpVar47;
        dp dpVar48;
        ey eyVar60;
        String aKv;
        ey eyVar61;
        ey eyVar62;
        ey eyVar63;
        ey eyVar64;
        ey eyVar65;
        PbModel pbModel87;
        PbModel pbModel88;
        ey eyVar66;
        ey eyVar67;
        PbModel pbModel89;
        PbModel pbModel90;
        PbModel pbModel91;
        ey eyVar68;
        PbModel pbModel92;
        ey eyVar69;
        ey eyVar70;
        ey eyVar71;
        PbModel pbModel93;
        ey eyVar72;
        ey eyVar73;
        PbModel pbModel94;
        ey eyVar74;
        PbModel pbModel95;
        ey eyVar75;
        ey eyVar76;
        PbModel pbModel96;
        PbModel pbModel97;
        PbModel pbModel98;
        PbModel pbModel99;
        PbModel pbModel100;
        ey eyVar77;
        ey eyVar78;
        ey eyVar79;
        ey eyVar80;
        ey eyVar81;
        ey eyVar82;
        boolean z8;
        ey eyVar83;
        ey eyVar84;
        ey eyVar85;
        PbModel pbModel101;
        String aKH2;
        ey eyVar86;
        ey eyVar87;
        ey eyVar88;
        ey eyVar89;
        boolean oc;
        PbModel pbModel102;
        ey eyVar90;
        PbModel pbModel103;
        PbModel pbModel104;
        PbModel pbModel105;
        PbModel pbModel106;
        ey eyVar91;
        ey eyVar92;
        PbModel pbModel107;
        PbModel pbModel108;
        PbModel pbModel109;
        String name;
        PbModel pbModel110;
        PbModel pbModel111;
        PbModel pbModel112;
        PbModel pbModel113;
        PbModel pbModel114;
        PbModel pbModel115;
        PbModel pbModel116;
        PbModel pbModel117;
        PbModel pbModel118;
        ey eyVar93;
        ey eyVar94;
        ey eyVar95;
        PbModel pbModel119;
        ey eyVar96;
        ey eyVar97;
        ey eyVar98;
        ey eyVar99;
        PbModel pbModel120;
        ey eyVar100;
        PbModel pbModel121;
        PbModel pbModel122;
        ey eyVar101;
        PbModel pbModel123;
        ey eyVar102;
        boolean z9;
        PbModel pbModel124;
        PbModel pbModel125;
        PbModel pbModel126;
        PbModel pbModel127;
        if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
            z9 = this.ejU.eiI;
            if (z9) {
                this.ejU.eiI = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(w.h.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData3 = (PostData) obj;
                    pbModel124 = this.ejU.eif;
                    if (pbModel124 != null) {
                        pbModel125 = this.ejU.eif;
                        if (pbModel125.getPbData() != null && this.ejU.aKq().aMR() != null && postData3.getAuthor() != null && postData3.bio() != 1 && this.ejU.checkUpIsLogin()) {
                            com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                            pbModel126 = this.ejU.eif;
                            jVar.b(pbModel126.getPbData().aJw());
                            pbModel127 = this.ejU.eif;
                            jVar.h(pbModel127.getPbData().aJx());
                            jVar.b(postData3);
                            this.ejU.aKq().aMR().c(jVar);
                            this.ejU.aKq().aMR().setPostId(postData3.getId());
                            this.ejU.a(view, postData3.getAuthor().getUserId(), "");
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
        eyVar = this.ejU.eiS;
        if (view == eyVar.getNextView()) {
            pbModel123 = this.ejU.eif;
            if (pbModel123.io(true)) {
                eyVar102 = this.ejU.eiS;
                eyVar102.aNm();
                return;
            }
            return;
        }
        eyVar2 = this.ejU.eiS;
        if (view == eyVar2.aMX()) {
            eyVar100 = this.ejU.eiS;
            eyVar100.aNd();
            if (UtilHelper.isFloatWindowOpAllowed(this.ejU.getPageContext().getPageActivity())) {
                this.ejU.eiY = true;
                PbActivity pbActivity = this.ejU;
                pbModel121 = this.ejU.eif;
                pbActivity.a(pbModel121.getPbData(), 0, 1, true, true);
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10830");
                pbModel122 = this.ejU.eif;
                TiebaStatic.log(asVar.aa("tid", pbModel122.getThreadID()));
                eyVar101 = this.ejU.eiS;
                eyVar101.awH();
                return;
            }
            this.ejU.aKu();
            return;
        }
        eyVar3 = this.ejU.eiS;
        if (eyVar3.eoV.aNZ() != null) {
            eyVar96 = this.ejU.eiS;
            if (view == eyVar96.eoV.aNZ().aMx()) {
                if (com.baidu.adp.lib.util.i.hj()) {
                    eyVar97 = this.ejU.eiS;
                    eyVar97.awH();
                    this.ejU.Zp();
                    eyVar98 = this.ejU.eiS;
                    eyVar98.aNl();
                    eyVar99 = this.ejU.eiS;
                    eyVar99.auv();
                    pbModel120 = this.ejU.eif;
                    pbModel120.oh(1);
                    return;
                }
                this.ejU.showToast(w.l.network_not_available);
                return;
            }
        }
        eyVar4 = this.ejU.eiS;
        if (view == eyVar4.eoV.aIw) {
            eyVar95 = this.ejU.eiS;
            pbModel119 = this.ejU.eif;
            if (!eyVar95.iO(pbModel119.aLH())) {
                this.ejU.eiz = false;
                this.ejU.finish();
                return;
            }
            this.ejU.Zp();
            return;
        }
        eyVar5 = this.ejU.eiS;
        if (view != eyVar5.aNj()) {
            eyVar14 = this.ejU.eiS;
            if (eyVar14.eoV.aNZ() != null) {
                eyVar93 = this.ejU.eiS;
                if (view != eyVar93.eoV.aNZ().aMw()) {
                    eyVar94 = this.ejU.eiS;
                }
            }
            eyVar15 = this.ejU.eiS;
            if (view == eyVar15.aNA()) {
                pbModel117 = this.ejU.eif;
                if (pbModel117 != null) {
                    pbModel118 = this.ejU.eif;
                    com.baidu.tbadk.browser.f.S(this.ejU.getPageContext().getPageActivity(), pbModel118.getPbData().aJx().so().getLink());
                    return;
                }
                return;
            }
            eyVar16 = this.ejU.eiS;
            if (view != eyVar16.eoV.esf) {
                eyVar17 = this.ejU.eiS;
                if (view == eyVar17.eoV.esh) {
                    pbModel103 = this.ejU.eif;
                    if (pbModel103 != null) {
                        pbModel104 = this.ejU.eif;
                        if (pbModel104.getPbData() != null) {
                            pbModel105 = this.ejU.eif;
                            ArrayList<PostData> aJz = pbModel105.getPbData().aJz();
                            if (aJz == null || aJz.size() <= 0) {
                                pbModel106 = this.ejU.eif;
                                if (pbModel106.aLC()) {
                                    com.baidu.adp.lib.util.k.showToast(this.ejU.getPageContext().getPageActivity(), this.ejU.getPageContext().getString(w.l.pb_no_data_tips));
                                    return;
                                }
                            }
                            eyVar91 = this.ejU.eiS;
                            eyVar91.aMT();
                            eyVar92 = this.ejU.eiS;
                            eyVar92.aNE();
                            this.ejU.aKx();
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.k.showToast(this.ejU.getPageContext().getPageActivity(), this.ejU.getPageContext().getString(w.l.pb_no_data_tips));
                    return;
                }
                eyVar18 = this.ejU.eiS;
                if (view != eyVar18.eoV.esg && view.getId() != w.h.pb_god_user_tip_content) {
                    eyVar25 = this.ejU.eiS;
                    if (eyVar25.eoV.aNZ() != null) {
                        eyVar88 = this.ejU.eiS;
                        if (view == eyVar88.eoV.aNZ().aMf()) {
                            if (com.baidu.adp.lib.util.i.hj()) {
                                eyVar89 = this.ejU.eiS;
                                eyVar89.awH();
                                oc = this.ejU.oc(11009);
                                if (oc) {
                                    pbModel102 = this.ejU.eif;
                                    eyVar90 = this.ejU.eiS;
                                    if (pbModel102.on(eyVar90.aNq()) == null) {
                                        return;
                                    }
                                    this.ejU.aKD();
                                    return;
                                }
                                return;
                            }
                            this.ejU.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    eyVar26 = this.ejU.eiS;
                    if (eyVar26.eoV.aNZ() != null) {
                        eyVar80 = this.ejU.eiS;
                        if (view == eyVar80.eoV.aNZ().aMt()) {
                            if (com.baidu.adp.lib.util.i.hj()) {
                                eyVar81 = this.ejU.eiS;
                                eyVar81.awH();
                                eyVar82 = this.ejU.eiS;
                                eyVar82.aMT();
                                z8 = this.ejU.mIsLoading;
                                if (!z8) {
                                    this.ejU.mIsLoading = true;
                                    eyVar83 = this.ejU.eiS;
                                    eyVar83.eoV.esg.setEnabled(false);
                                    eyVar84 = this.ejU.eiS;
                                    eyVar84.ars();
                                    this.ejU.Zp();
                                    eyVar85 = this.ejU.eiS;
                                    eyVar85.aNl();
                                    pbModel101 = this.ejU.eif;
                                    aKH2 = this.ejU.aKH();
                                    pbModel101.nA(aKH2);
                                    TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    eyVar86 = this.ejU.eiS;
                                    eyVar86.aNE();
                                    eyVar87 = this.ejU.eiS;
                                    eyVar87.aLx();
                                    this.ejU.od(2);
                                    return;
                                }
                                return;
                            }
                            this.ejU.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    eyVar27 = this.ejU.eiS;
                    if (eyVar27.eoV.aNZ() != null) {
                        eyVar77 = this.ejU.eiS;
                        if (view != eyVar77.eoV.aNZ().getCancelView()) {
                            eyVar79 = this.ejU.eiS;
                        }
                        eyVar78 = this.ejU.eiS;
                        eyVar78.eoV.oI();
                        return;
                    }
                    eyVar28 = this.ejU.eiS;
                    if (eyVar28.eoV.aNZ() != null) {
                        eyVar75 = this.ejU.eiS;
                        if (view == eyVar75.eoV.aNZ().aMs()) {
                            if (this.ejU.checkUpIsLogin()) {
                                eyVar76 = this.ejU.eiS;
                                eyVar76.awH();
                                this.ejU.Zp();
                                this.ejU.od(2);
                                pbModel96 = this.ejU.eif;
                                if (pbModel96 != null) {
                                    pbModel97 = this.ejU.eif;
                                    if (pbModel97.getPbData() != null) {
                                        pbModel98 = this.ejU.eif;
                                        if (pbModel98.getPbData().aJO() != null) {
                                            pbModel99 = this.ejU.eif;
                                            if (!StringUtils.isNull(pbModel99.getPbData().aJO().qB(), true)) {
                                                com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11678");
                                                pbModel100 = this.ejU.eif;
                                                TiebaStatic.log(asVar2.aa("fid", pbModel100.getPbData().getForumId()));
                                            }
                                        }
                                    }
                                }
                                this.ejU.aqQ();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11939"));
                                return;
                            }
                            return;
                        }
                    }
                    eyVar29 = this.ejU.eiS;
                    if (eyVar29.eoV.aNZ() != null) {
                        eyVar72 = this.ejU.eiS;
                        if (view == eyVar72.eoV.aNZ().aMn()) {
                            eyVar73 = this.ejU.eiS;
                            eyVar73.awH();
                            pbModel94 = this.ejU.eif;
                            if (pbModel94.alU() != null) {
                                eyVar74 = this.ejU.eiS;
                                pbModel95 = this.ejU.eif;
                                eyVar74.a(pbModel95.alU(), this.ejU.dSY);
                            }
                            TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    eyVar30 = this.ejU.eiS;
                    if (eyVar30.eoV.aNZ() != null) {
                        eyVar69 = this.ejU.eiS;
                        if (view == eyVar69.eoV.aNZ().aMo()) {
                            eyVar70 = this.ejU.eiS;
                            eyVar70.awH();
                            this.ejU.od(2);
                            this.ejU.Zp();
                            eyVar71 = this.ejU.eiS;
                            eyVar71.aNl();
                            pbModel93 = this.ejU.eif;
                            pbModel93.aLN();
                            TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    eyVar31 = this.ejU.eiS;
                    if (eyVar31.eoV.aNZ() != null) {
                        eyVar67 = this.ejU.eiS;
                        if (view == eyVar67.eoV.aNZ().aMp()) {
                            pbModel89 = this.ejU.eif;
                            if (pbModel89 != null) {
                                pbModel90 = this.ejU.eif;
                                if (pbModel90.getPbData() != null) {
                                    pbModel91 = this.ejU.eif;
                                    if (pbModel91.getPbData().aJx() != null) {
                                        eyVar68 = this.ejU.eiS;
                                        eyVar68.eoV.oI();
                                        PbActivity pbActivity2 = this.ejU;
                                        pbModel92 = this.ejU.eif;
                                        pbActivity2.nv(pbModel92.getPbData().aJx().sE());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    eyVar32 = this.ejU.eiS;
                    if (eyVar32.eoV.aNZ() != null) {
                        eyVar63 = this.ejU.eiS;
                        if (view == eyVar63.eoV.aNZ().aMq()) {
                            TiebaStatic.log("c10414");
                            eyVar64 = this.ejU.eiS;
                            eyVar64.awH();
                            eyVar65 = this.ejU.eiS;
                            if (eyVar65.sc() != ey.eqE) {
                                pbModel87 = this.ejU.eif;
                                if (pbModel87.aMb() != null) {
                                    pbModel88 = this.ejU.eif;
                                    pbModel88.aMb().og(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                    return;
                                }
                                return;
                            }
                            eyVar66 = this.ejU.eiS;
                            eyVar66.aNI();
                            return;
                        }
                    }
                    eyVar33 = this.ejU.eiS;
                    if (eyVar33.eoV.aNZ() != null) {
                        eyVar60 = this.ejU.eiS;
                        if (view == eyVar60.eoV.aNZ().aMr()) {
                            aKv = this.ejU.aKv();
                            this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.ejU.getPageContext().getPageActivity(), null, aKv, true)));
                            eyVar61 = this.ejU.eiS;
                            eyVar61.eoV.oI();
                            eyVar62 = this.ejU.eiS;
                            eyVar62.eoV.aNZ().aMz();
                            return;
                        }
                    }
                    dpVar = this.ejU.eiX;
                    if (dpVar != null) {
                        dpVar48 = this.ejU.eiX;
                        if (view == dpVar48.aMh()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.hj()) {
                                this.ejU.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            if (!(tag instanceof String)) {
                                if (tag instanceof SparseArray) {
                                    SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                    if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                        sparseArray2.put(w.h.tag_from, 0);
                                        sparseArray2.put(w.h.tag_check_mute_from, 2);
                                        this.ejU.d(sparseArray2);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            this.ejU.nv((String) tag);
                            return;
                        }
                    }
                    dpVar2 = this.ejU.eiX;
                    if (dpVar2 != null) {
                        dpVar47 = this.ejU.eiX;
                        if (view == dpVar47.aMf()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                            if (!this.ejU.checkUpIsLogin()) {
                                return;
                            }
                            this.ejU.aW(view);
                            return;
                        }
                    }
                    dpVar3 = this.ejU.eiX;
                    if (dpVar3 != null) {
                        dpVar45 = this.ejU.eiX;
                        if (view == dpVar45.aMk()) {
                            dpVar46 = this.ejU.eiX;
                            if (dpVar46.aMm()) {
                                com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c12007");
                                pbModel86 = this.ejU.eif;
                                TiebaStatic.log(asVar3.aa("tid", pbModel86.elj));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                            }
                            if (this.ejU.checkUpIsLogin()) {
                                pbModel81 = this.ejU.eif;
                                if (pbModel81.getPbData() != null) {
                                    eyVar59 = this.ejU.eiS;
                                    eyVar59.awH();
                                    if (!(view.getTag() instanceof SparseArray)) {
                                        sparseArray = null;
                                    } else {
                                        sparseArray = (SparseArray) view.getTag();
                                    }
                                    if (sparseArray == null || !(sparseArray.get(w.h.tag_load_sub_data) instanceof PostData)) {
                                        postData2 = null;
                                    } else {
                                        postData2 = (PostData) sparseArray.get(w.h.tag_load_sub_data);
                                    }
                                    if (postData2 != null) {
                                        pbModel82 = this.ejU.eif;
                                        String threadID = pbModel82.getThreadID();
                                        String id2 = postData2.getId();
                                        int i2 = 0;
                                        pbModel83 = this.ejU.eif;
                                        if (pbModel83.getPbData() != null) {
                                            pbModel85 = this.ejU.eif;
                                            i2 = pbModel85.getPbData().aJH();
                                        }
                                        this.ejU.Zp();
                                        ny4 = this.ejU.ny(id2);
                                        if (ny4 != null) {
                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.ejU.getPageContext().getPageActivity());
                                            SmallTailInfo aPb = postData2.aPb();
                                            pbModel84 = this.ejU.eif;
                                            this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, aPb, pbModel84.getPbData().rb(), false, postData2.getAuthor().getIconInfo()).addBigImageData(ny4.ekl, ny4.ekm, ny4.ekn, ny4.index)));
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
                    dpVar4 = this.ejU.eiX;
                    if (dpVar4 != null) {
                        dpVar44 = this.ejU.eiX;
                        if (view == dpVar44.aMi()) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3 != null && (sparseArray3.get(w.h.tag_del_post_type) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_id) instanceof String) && (sparseArray3.get(w.h.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray3.get(w.h.tag_del_post_is_self)).booleanValue();
                                int intValue = ((Integer) sparseArray3.get(w.h.tag_manage_user_identity)).intValue();
                                if (!booleanValue && intValue != 0 && com.baidu.tieba.c.a.Sm()) {
                                    Context baseContext = this.ejU.getBaseContext();
                                    pbModel80 = this.ejU.eif;
                                    if (com.baidu.tieba.c.a.h(baseContext, pbModel80.getThreadID(), (String) sparseArray3.get(w.h.tag_del_post_id))) {
                                        return;
                                    }
                                }
                                eyVar58 = this.ejU.eiS;
                                eyVar58.a(((Integer) sparseArray3.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray3.get(w.h.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                            return;
                        }
                    }
                    dpVar5 = this.ejU.eiX;
                    if (dpVar5 != null) {
                        dpVar43 = this.ejU.eiX;
                        if (view == dpVar43.aMj()) {
                            long j = -1;
                            String str2 = "";
                            int i3 = 0;
                            if (view.getTag(w.h.tag_chudian_template_id) instanceof Long) {
                                j = ((Long) view.getTag(w.h.tag_chudian_template_id)).longValue();
                            }
                            if (view.getTag(w.h.tag_chudian_monitor_id) instanceof String) {
                                str2 = (String) view.getTag(w.h.tag_chudian_monitor_id);
                            }
                            if (view.getTag(w.h.tag_chudian_hide_day) instanceof Integer) {
                                i3 = ((Integer) view.getTag(w.h.tag_chudian_hide_day)).intValue();
                            }
                            pbModel79 = this.ejU.eif;
                            com.baidu.tieba.pb.data.f pbData = pbModel79.getPbData();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            if (pbData != null && pbData.aJw() != null) {
                                str3 = pbData.aJw().getId();
                                str4 = pbData.aJw().getName();
                                str5 = pbData.getThreadId();
                            }
                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                            this.ejU.a(j, str2, str3, str4, str5, i3);
                            return;
                        }
                    }
                    eyVar34 = this.ejU.eiS;
                    if (eyVar34.aNJ() == view) {
                        eyVar57 = this.ejU.eiS;
                        if (eyVar57.aNJ().getIndicateStatus()) {
                            pbModel78 = this.ejU.eif;
                            com.baidu.tieba.pb.data.f pbData2 = pbModel78.getPbData();
                            if (pbData2 != null && pbData2.aJx() != null && pbData2.aJx().rX() != null) {
                                String qb = pbData2.aJx().rX().qb();
                                if (StringUtils.isNull(qb)) {
                                    qb = pbData2.aJx().rX().getTaskId();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11107").aa("obj_id", qb));
                            }
                        } else {
                            com.baidu.tieba.tbadkCore.d.a.cb("c10725", null);
                        }
                        this.ejU.aKO();
                        return;
                    }
                    eyVar35 = this.ejU.eiS;
                    if (eyVar35.aNf() != view) {
                        dpVar6 = this.ejU.eiX;
                        if (dpVar6 != null) {
                            dpVar42 = this.ejU.eiX;
                            if (view == dpVar42.aMg()) {
                                if (!com.baidu.adp.lib.util.i.hj()) {
                                    this.ejU.showToast(w.l.network_not_available);
                                    return;
                                }
                                SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                if (sparseArray4 != null) {
                                    if (com.baidu.tieba.c.a.Sm() && sparseArray4.get(w.h.tag_del_post_id) != null) {
                                        Context baseContext2 = this.ejU.getBaseContext();
                                        pbModel76 = this.ejU.eif;
                                        if (com.baidu.tieba.c.a.h(baseContext2, pbModel76.getThreadID(), (String) sparseArray4.get(w.h.tag_del_post_id))) {
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
                                            this.ejU.d(sparseArray4);
                                            return;
                                        }
                                        sparseArray4.put(w.h.tag_check_mute_from, 2);
                                        eyVar56 = this.ejU.eiS;
                                        eyVar56.ba(view);
                                        return;
                                    } else if (booleanValue3) {
                                        eyVar55 = this.ejU.eiS;
                                        eyVar55.a(((Integer) sparseArray4.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray4.get(w.h.tag_del_post_id), ((Integer) sparseArray4.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(w.h.tag_del_post_is_self)).booleanValue());
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        eyVar36 = this.ejU.eiS;
                        if (view != eyVar36.aLy()) {
                            eyVar37 = this.ejU.eiS;
                            if (eyVar37.eoV.aNZ() != null) {
                                eyVar49 = this.ejU.eiS;
                                if (view == eyVar49.eoV.aNZ().aMy()) {
                                    if (com.baidu.adp.lib.util.i.hj()) {
                                        eyVar50 = this.ejU.eiS;
                                        eyVar50.awH();
                                        eyVar51 = this.ejU.eiS;
                                        pbModel66 = this.ejU.eif;
                                        com.baidu.tieba.pb.data.f pbData3 = pbModel66.getPbData();
                                        pbModel67 = this.ejU.eif;
                                        SparseArray<Object> c = eyVar51.c(pbData3, pbModel67.aLC(), 1);
                                        if (c != null) {
                                            pbModel68 = this.ejU.eif;
                                            PbActivity pbActivity3 = this.ejU;
                                            Activity pageActivity = this.ejU.getPageContext().getPageActivity();
                                            pbModel69 = this.ejU.eif;
                                            String id3 = pbModel69.getPbData().aJw().getId();
                                            pbModel70 = this.ejU.eif;
                                            String name2 = pbModel70.getPbData().aJw().getName();
                                            pbModel71 = this.ejU.eif;
                                            pbActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, pbModel71.getPbData().aJx().getId(), String.valueOf(pbModel68.getPbData().getUserData().getUserId()), (String) c.get(w.h.tag_forbid_user_name), (String) c.get(w.h.tag_forbid_user_post_id))));
                                            return;
                                        }
                                        return;
                                    }
                                    this.ejU.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            eyVar38 = this.ejU.eiS;
                            if (eyVar38.eoV.aNZ() != null) {
                                eyVar45 = this.ejU.eiS;
                                if (view == eyVar45.eoV.aNZ().aMv()) {
                                    if (com.baidu.adp.lib.util.i.hj()) {
                                        eyVar46 = this.ejU.eiS;
                                        pbModel64 = this.ejU.eif;
                                        com.baidu.tieba.pb.data.f pbData4 = pbModel64.getPbData();
                                        pbModel65 = this.ejU.eif;
                                        SparseArray<Object> c2 = eyVar46.c(pbData4, pbModel65.aLC(), 1);
                                        if (c2 != null) {
                                            eyVar48 = this.ejU.eiS;
                                            eyVar48.a(((Integer) c2.get(w.h.tag_del_post_type)).intValue(), (String) c2.get(w.h.tag_del_post_id), ((Integer) c2.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(w.h.tag_del_post_is_self)).booleanValue());
                                        }
                                        eyVar47 = this.ejU.eiS;
                                        eyVar47.eoV.oI();
                                        return;
                                    }
                                    this.ejU.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            if (view.getId() != w.h.sub_pb_more && view.getId() != w.h.sub_pb_item) {
                                eyVar40 = this.ejU.eiS;
                                if (view != eyVar40.aKl()) {
                                    eyVar41 = this.ejU.eiS;
                                    if (view == eyVar41.eoV.aOa()) {
                                        eyVar44 = this.ejU.eiS;
                                        eyVar44.aNt();
                                        return;
                                    }
                                    int id4 = view.getId();
                                    if (id4 == w.h.pb_u9_text_view) {
                                        if (this.ejU.checkUpIsLogin() && (boVar = (com.baidu.tbadk.core.data.bo) view.getTag()) != null && !StringUtils.isNull(boVar.tF())) {
                                            TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                            com.baidu.tbadk.core.util.bb.wn().c(this.ejU.getPageContext(), new String[]{boVar.tF()});
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.pb_floor_agree && (view instanceof PbFloorAgreeView)) {
                                        if (this.ejU.checkUpIsLogin() && (postData = (PostData) view.getTag(w.h.tag_clip_board)) != null) {
                                            if (postData.biC()) {
                                                postData.cB(postData.biB() - 1);
                                            } else {
                                                postData.cB(postData.biB() + 1);
                                            }
                                            postData.lk(!postData.biC());
                                            ((PbFloorAgreeView) view).a(postData.biC(), postData.biB(), true);
                                            pbModel58 = this.ejU.eif;
                                            pbModel58.aMc().bK(postData.getId(), postData.biC() ? "0" : "1");
                                            int i4 = 2;
                                            if (postData.getAuthor() != null && postData.getAuthor().getUserId() != null) {
                                                i4 = postData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) ? 1 : 2;
                                            }
                                            if (postData.biC()) {
                                                com.baidu.tbadk.core.util.as asVar4 = new com.baidu.tbadk.core.util.as("c12003");
                                                pbModel60 = this.ejU.eif;
                                                TiebaStatic.log(asVar4.aa("tid", pbModel60.elj).s("obj_id", i4));
                                                return;
                                            }
                                            com.baidu.tbadk.core.util.as asVar5 = new com.baidu.tbadk.core.util.as("c12008");
                                            pbModel59 = this.ejU.eif;
                                            TiebaStatic.log(asVar5.aa("tid", pbModel59.elj).s("obj_id", i4));
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.replybtn || id4 == w.h.cover_reply_content || id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right) {
                                        dpVar7 = this.ejU.eiX;
                                        if (dpVar7 == null) {
                                            this.ejU.eiX = new dp(this.ejU.getPageContext(), this.ejU.bOx);
                                            dpVar41 = this.ejU.eiX;
                                            z7 = this.ejU.mIsLogin;
                                            dpVar41.is(z7);
                                        }
                                        dpVar8 = this.ejU.eiX;
                                        dpVar8.showDialog();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11740"));
                                        PostData postData4 = null;
                                        if (view != null && view.getTag() != null) {
                                            postData4 = (PostData) ((SparseArray) view.getTag()).get(w.h.tag_load_sub_data);
                                            boolean z10 = id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right;
                                            if (z10) {
                                                com.baidu.tbadk.core.util.as asVar6 = new com.baidu.tbadk.core.util.as("c12006");
                                                pbModel24 = this.ejU.eif;
                                                TiebaStatic.log(asVar6.aa("tid", pbModel24.elj));
                                            }
                                            SparseArray sparseArray5 = new SparseArray();
                                            sparseArray5.put(w.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(w.h.tag_clip_board));
                                            sparseArray5.put(w.h.tag_is_subpb, false);
                                            dpVar13 = this.ejU.eiX;
                                            dpVar13.aMf().setTag(sparseArray5);
                                            dpVar14 = this.ejU.eiX;
                                            dpVar14.aMk().setTag(view.getTag());
                                            dpVar15 = this.ejU.eiX;
                                            dpVar15.iu(z10);
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
                                                    dpVar40 = this.ejU.eiX;
                                                    dpVar40.aMi().setVisibility(0);
                                                } else {
                                                    sparseArray7.put(w.h.tag_should_delete_visible, false);
                                                    dpVar35 = this.ejU.eiX;
                                                    dpVar35.aMi().setVisibility(8);
                                                }
                                                dpVar36 = this.ejU.eiX;
                                                dpVar36.aMg().setTag(sparseArray7);
                                                dpVar37 = this.ejU.eiX;
                                                dpVar37.aMi().setTag(sparseArray7);
                                                dpVar38 = this.ejU.eiX;
                                                dpVar38.aMg().setText(w.l.bar_manager);
                                                dpVar39 = this.ejU.eiX;
                                                dpVar39.aMg().setVisibility(0);
                                            } else if (!booleanValue7) {
                                                dpVar16 = this.ejU.eiX;
                                                dpVar16.aMg().setVisibility(8);
                                                dpVar17 = this.ejU.eiX;
                                                dpVar17.aMi().setVisibility(8);
                                            } else {
                                                SparseArray sparseArray8 = new SparseArray();
                                                sparseArray8.put(w.h.tag_should_manage_visible, false);
                                                sparseArray8.put(w.h.tag_user_mute_visible, false);
                                                sparseArray8.put(w.h.tag_should_delete_visible, true);
                                                sparseArray8.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                sparseArray8.put(w.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                sparseArray8.put(w.h.tag_del_post_id, sparseArray6.get(w.h.tag_del_post_id));
                                                sparseArray8.put(w.h.tag_del_post_type, sparseArray6.get(w.h.tag_del_post_type));
                                                dpVar18 = this.ejU.eiX;
                                                dpVar18.aMg().setTag(sparseArray8);
                                                dpVar19 = this.ejU.eiX;
                                                dpVar19.aMi().setTag(sparseArray8);
                                                dpVar20 = this.ejU.eiX;
                                                dpVar20.aMg().setText(w.l.delete);
                                                dpVar21 = this.ejU.eiX;
                                                dpVar21.aMi().setVisibility(0);
                                                dpVar22 = this.ejU.eiX;
                                                dpVar22.aMg().setVisibility(8);
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
                                                dpVar31 = this.ejU.eiX;
                                                dpVar31.aMh().setTag(sparseArray10);
                                                dpVar32 = this.ejU.eiX;
                                                dpVar32.aMh().setVisibility(0);
                                                dpVar33 = this.ejU.eiX;
                                                dpVar33.aMg().setVisibility(8);
                                                dpVar34 = this.ejU.eiX;
                                                dpVar34.aMh().setText(w.l.mute_option);
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
                                                ii = this.ejU.ii(z5);
                                                boolean isLogin = ii & this.ejU.isLogin();
                                                this.ejU.ejK = (PostData) sparseArray9.get(w.h.tag_clip_board);
                                                if (ex.g(this.ejU.ejK) ? false : isLogin) {
                                                    dpVar24 = this.ejU.eiX;
                                                    dpVar24.aMh().setVisibility(0);
                                                    dpVar25 = this.ejU.eiX;
                                                    dpVar25.aMh().setTag(str7);
                                                } else {
                                                    dpVar23 = this.ejU.eiX;
                                                    dpVar23.aMh().setVisibility(8);
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
                                                dpVar27 = this.ejU.eiX;
                                                dpVar27.aMj().setVisibility(0);
                                                dpVar28 = this.ejU.eiX;
                                                dpVar28.aMj().setTag(w.h.tag_chudian_template_id, Long.valueOf(j2));
                                                dpVar29 = this.ejU.eiX;
                                                dpVar29.aMj().setTag(w.h.tag_chudian_monitor_id, str);
                                                dpVar30 = this.ejU.eiX;
                                                dpVar30.aMj().setTag(w.h.tag_chudian_hide_day, Integer.valueOf(i));
                                            } else {
                                                dpVar26 = this.ejU.eiX;
                                                dpVar26.aMj().setVisibility(8);
                                            }
                                        }
                                        pbModel22 = this.ejU.eif;
                                        if (pbModel22.getPbData().oe()) {
                                            pbModel23 = this.ejU.eif;
                                            String od = pbModel23.getPbData().od();
                                            if (postData4 != null && !com.baidu.adp.lib.util.j.isEmpty(od) && od.equals(postData4.getId())) {
                                                z2 = true;
                                                if (!z2) {
                                                    dpVar12 = this.ejU.eiX;
                                                    dpVar12.aMf().setText(w.l.remove_mark);
                                                } else {
                                                    dpVar9 = this.ejU.eiX;
                                                    dpVar9.aMf().setText(w.l.mark);
                                                }
                                                dpVar10 = this.ejU.eiX;
                                                dpVar10.it(true);
                                                dpVar11 = this.ejU.eiX;
                                                dpVar11.refreshUI();
                                                return;
                                            }
                                        }
                                        z2 = false;
                                        if (!z2) {
                                        }
                                        dpVar10 = this.ejU.eiX;
                                        dpVar10.it(true);
                                        dpVar11 = this.ejU.eiX;
                                        dpVar11.refreshUI();
                                        return;
                                    } else if (id4 == w.h.pb_act_btn) {
                                        pbModel52 = this.ejU.eif;
                                        if (pbModel52.getPbData() != null) {
                                            pbModel53 = this.ejU.eif;
                                            if (pbModel53.getPbData().aJx() != null) {
                                                pbModel54 = this.ejU.eif;
                                                if (pbModel54.getPbData().aJx().sU() != null) {
                                                    Activity activity = this.ejU.getActivity();
                                                    pbModel55 = this.ejU.eif;
                                                    com.baidu.tbadk.browser.f.S(activity, pbModel55.getPbData().aJx().sU());
                                                    pbModel56 = this.ejU.eif;
                                                    if (pbModel56.getPbData().aJx().sS() != 1) {
                                                        pbModel57 = this.ejU.eif;
                                                        if (pbModel57.getPbData().aJx().sS() == 2) {
                                                            TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                            com.baidu.tbadk.core.util.as asVar7 = new com.baidu.tbadk.core.util.as("c10912");
                                            pbModel49 = this.ejU.eif;
                                            com.baidu.tbadk.core.util.as aa = asVar7.aa("fid", pbModel49.getPbData().getForumId());
                                            pbModel50 = this.ejU.eif;
                                            TiebaStatic.log(aa.aa("tid", pbModel50.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                            pbModel51 = this.ejU.eif;
                                            if (pbModel51.getPbData().getThreadId().equals(str8)) {
                                                eyVar43 = this.ejU.eiS;
                                                eyVar43.setSelection(0);
                                                return;
                                            }
                                            this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ejU.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.pb_item_tail_content) {
                                        if (com.baidu.tbadk.core.util.bg.aK(this.ejU.getPageContext().getPageActivity())) {
                                            String string = TbadkCoreApplication.m9getInst().getString(w.l.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.uL().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                TiebaStatic.log("c10056");
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                            }
                                            eyVar42 = this.ejU.eiS;
                                            eyVar42.aMT();
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.join_vote_tv) {
                                        if (view != null) {
                                            com.baidu.tbadk.browser.f.S(this.ejU.getActivity(), (String) view.getTag());
                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                            aKw3 = this.ejU.aKw();
                                            if (aKw3 == 1) {
                                                pbModel45 = this.ejU.eif;
                                                if (pbModel45 != null) {
                                                    pbModel46 = this.ejU.eif;
                                                    if (pbModel46.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar8 = new com.baidu.tbadk.core.util.as("c10397");
                                                        pbModel47 = this.ejU.eif;
                                                        com.baidu.tbadk.core.util.as aa2 = asVar8.aa("fid", pbModel47.getPbData().getForumId());
                                                        pbModel48 = this.ejU.eif;
                                                        TiebaStatic.log(aa2.aa("tid", pbModel48.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aKw4 = this.ejU.aKw();
                                            if (aKw4 == 2) {
                                                pbModel41 = this.ejU.eif;
                                                if (pbModel41 != null) {
                                                    pbModel42 = this.ejU.eif;
                                                    if (pbModel42.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar9 = new com.baidu.tbadk.core.util.as("c10401");
                                                        pbModel43 = this.ejU.eif;
                                                        com.baidu.tbadk.core.util.as aa3 = asVar9.aa("fid", pbModel43.getPbData().getForumId());
                                                        pbModel44 = this.ejU.eif;
                                                        TiebaStatic.log(aa3.aa("tid", pbModel44.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
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
                                            com.baidu.tbadk.browser.f.S(this.ejU.getActivity(), (String) view.getTag());
                                            aKw = this.ejU.aKw();
                                            if (aKw == 1) {
                                                pbModel37 = this.ejU.eif;
                                                if (pbModel37 != null) {
                                                    pbModel38 = this.ejU.eif;
                                                    if (pbModel38.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar10 = new com.baidu.tbadk.core.util.as("c10507");
                                                        pbModel39 = this.ejU.eif;
                                                        com.baidu.tbadk.core.util.as aa4 = asVar10.aa("fid", pbModel39.getPbData().getForumId());
                                                        pbModel40 = this.ejU.eif;
                                                        TiebaStatic.log(aa4.aa("tid", pbModel40.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aKw2 = this.ejU.aKw();
                                            if (aKw2 == 2) {
                                                pbModel33 = this.ejU.eif;
                                                if (pbModel33 != null) {
                                                    pbModel34 = this.ejU.eif;
                                                    if (pbModel34.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar11 = new com.baidu.tbadk.core.util.as("c10508");
                                                        pbModel35 = this.ejU.eif;
                                                        com.baidu.tbadk.core.util.as aa5 = asVar11.aa("fid", pbModel35.getPbData().getForumId());
                                                        pbModel36 = this.ejU.eif;
                                                        TiebaStatic.log(aa5.aa("tid", pbModel36.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
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
                                                pbModel29 = this.ejU.eif;
                                                if (pbModel29 != null) {
                                                    pbModel30 = this.ejU.eif;
                                                    if (pbModel30.getPbData() != null) {
                                                        pbModel31 = this.ejU.eif;
                                                        if (pbModel31.getPbData().aJO() != null) {
                                                            pbModel32 = this.ejU.eif;
                                                            com.baidu.tieba.pb.data.f pbData5 = pbModel32.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11679").aa("fid", pbData5.getForumId()));
                                                            com.baidu.tbadk.core.util.bb.wn().c(this.ejU.getPageContext(), new String[]{pbData5.aJO().aJR()});
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.yule_head_img_all_rank) {
                                                pbModel25 = this.ejU.eif;
                                                if (pbModel25 != null) {
                                                    pbModel26 = this.ejU.eif;
                                                    if (pbModel26.getPbData() != null) {
                                                        pbModel27 = this.ejU.eif;
                                                        if (pbModel27.getPbData().aJO() != null) {
                                                            pbModel28 = this.ejU.eif;
                                                            com.baidu.tieba.pb.data.f pbData6 = pbModel28.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11678").aa("fid", pbData6.getForumId()));
                                                            com.baidu.tbadk.core.util.bb.wn().c(this.ejU.getPageContext(), new String[]{pbData6.aJO().aJR()});
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
                                        this.ejU.aKK();
                                        return;
                                    } else {
                                        this.ejU.aKJ();
                                        return;
                                    }
                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                    long c3 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                    pbModel61 = this.ejU.eif;
                                    long c4 = com.baidu.adp.lib.g.b.c(pbModel61.getPbData().getForumId(), 0L);
                                    pbModel62 = this.ejU.eif;
                                    long c5 = com.baidu.adp.lib.g.b.c(pbModel62.getThreadID(), 0L);
                                    pbModel63 = this.ejU.eif;
                                    this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.ejU.getPageContext().getPageActivity(), 24008, c4, c5, c3, pbModel63.getPbData().aJx().sI())));
                                    return;
                                } else {
                                    return;
                                }
                            } else if (this.ejU.checkUpIsLogin()) {
                                pbModel7 = this.ejU.eif;
                                if (pbModel7.getPbData() != null) {
                                    eyVar39 = this.ejU.eiS;
                                    eyVar39.awH();
                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                    PostData postData5 = (PostData) sparseArray12.get(w.h.tag_load_sub_data);
                                    View view2 = (View) sparseArray12.get(w.h.tag_load_sub_view);
                                    if (postData5 != null && view2 != null) {
                                        pbModel8 = this.ejU.eif;
                                        String threadID2 = pbModel8.getThreadID();
                                        String id5 = postData5.getId();
                                        int i5 = 0;
                                        pbModel9 = this.ejU.eif;
                                        if (pbModel9.getPbData() != null) {
                                            pbModel20 = this.ejU.eif;
                                            i5 = pbModel20.getPbData().aJH();
                                        }
                                        this.ejU.Zp();
                                        if (view.getId() != w.h.replybtn) {
                                            if (view.getId() == w.h.sub_pb_item) {
                                                SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                String str9 = (String) sparseArray13.get(w.h.tag_photo_username);
                                                String str10 = (String) sparseArray12.get(w.h.tag_photo_userid);
                                                PostData postData6 = (PostData) sparseArray13.get(w.h.tag_load_sub_data);
                                                String str11 = null;
                                                if (postData6 != null) {
                                                    str11 = postData6.getId();
                                                }
                                                TiebaStatic.log("c11741");
                                                ny2 = this.ejU.ny(id5);
                                                if (postData5 != null) {
                                                    pbModel13 = this.ejU.eif;
                                                    if (pbModel13 != null) {
                                                        pbModel14 = this.ejU.eif;
                                                        if (pbModel14.getPbData() != null && ny2 != null && this.ejU.aKq().aMR() != null) {
                                                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                                                            pbModel15 = this.ejU.eif;
                                                            jVar2.b(pbModel15.getPbData().aJw());
                                                            pbModel16 = this.ejU.eif;
                                                            jVar2.h(pbModel16.getPbData().aJx());
                                                            jVar2.b(postData6);
                                                            this.ejU.aKq().aMR().c(jVar2);
                                                            this.ejU.aKq().aMR().setPostId(str11);
                                                            this.ejU.a(view, str10, str9);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            TiebaStatic.log("c11742");
                                            ny = this.ejU.ny(id5);
                                            if (postData5 != null) {
                                                pbModel10 = this.ejU.eif;
                                                if (pbModel10 != null) {
                                                    pbModel11 = this.ejU.eif;
                                                    if (pbModel11.getPbData() != null && ny != null) {
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.ejU.getPageContext().getPageActivity());
                                                        SmallTailInfo aPb2 = postData5.aPb();
                                                        pbModel12 = this.ejU.eif;
                                                        this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i5, aPb2, pbModel12.getPbData().rb(), false, postData5.getAuthor().getIconInfo()).addBigImageData(ny.ekl, ny.ekm, ny.ekn, ny.index)));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        ny3 = this.ejU.ny(id5);
                                        if (postData5 != null) {
                                            pbModel17 = this.ejU.eif;
                                            if (pbModel17 != null) {
                                                pbModel18 = this.ejU.eif;
                                                if (pbModel18.getPbData() != null && ny3 != null) {
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.ejU.getPageContext().getPageActivity());
                                                    SmallTailInfo aPb3 = postData5.aPb();
                                                    pbModel19 = this.ejU.eif;
                                                    this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i5, aPb3, pbModel19.getPbData().rb(), false, postData5.getAuthor().getIconInfo()).addBigImageData(ny3.ekl, ny3.ekm, ny3.ekn, ny3.index)));
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
                                com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 3);
                                pbModel21 = this.ejU.eif;
                                TiebaStatic.log(s.aa("fid", pbModel21.getPbData().getForumId()));
                                return;
                            }
                        } else if (this.ejU.checkUpIsLogin()) {
                            eyVar52 = this.ejU.eiS;
                            if (!eyVar52.aLv()) {
                                pbModel72 = this.ejU.eif;
                                if (pbModel72 != null) {
                                    pbModel73 = this.ejU.eif;
                                    if (pbModel73.aLZ() != null) {
                                        pbModel74 = this.ejU.eif;
                                        if (pbModel74.aLZ().aLr() != null) {
                                            pbModel75 = this.ejU.eif;
                                            if (com.baidu.tbadk.core.util.x.p(pbModel75.aLZ().aLr().getItems()) != 0) {
                                                eyVar53 = this.ejU.eiS;
                                                eyVar53.aLw();
                                                return;
                                            }
                                            this.ejU.showToast(w.l.graffiti_quick_vote_empty);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            eyVar54 = this.ejU.eiS;
                            eyVar54.aLx();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.ejU.checkUpIsLogin()) {
                        com.baidu.tbadk.core.util.as s2 = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
                        pbModel77 = this.ejU.eif;
                        TiebaStatic.log(s2.aa("fid", pbModel77.getPbData().getForumId()));
                        return;
                    } else {
                        this.ejU.aKn();
                        return;
                    }
                } else if (com.baidu.adp.lib.util.i.hj()) {
                    eyVar19 = this.ejU.eiS;
                    eyVar19.aMT();
                    z = this.ejU.mIsLoading;
                    if (!z) {
                        this.ejU.mIsLoading = true;
                        eyVar20 = this.ejU.eiS;
                        eyVar20.eoV.esg.setEnabled(false);
                        eyVar21 = this.ejU.eiS;
                        eyVar21.ars();
                        this.ejU.Zp();
                        eyVar22 = this.ejU.eiS;
                        eyVar22.aNl();
                        pbModel6 = this.ejU.eif;
                        aKH = this.ejU.aKH();
                        pbModel6.nA(aKH);
                        TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        eyVar23 = this.ejU.eiS;
                        eyVar23.aNE();
                        eyVar24 = this.ejU.eiS;
                        eyVar24.aLx();
                        this.ejU.od(2);
                        return;
                    }
                    return;
                } else {
                    this.ejU.showToast(w.l.network_not_available);
                    return;
                }
            }
            TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            pbModel107 = this.ejU.eif;
            if (pbModel107.getPbData() != null) {
                pbModel114 = this.ejU.eif;
                if (pbModel114.getPbData().aJx() != null) {
                    pbModel115 = this.ejU.eif;
                    if (pbModel115.getPbData().aJx().tb()) {
                        pbModel116 = this.ejU.eif;
                        if (pbModel116.getPbData().aJx().sF() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11922"));
                        }
                    }
                }
            }
            pbModel108 = this.ejU.eif;
            if (pbModel108.getErrorNo() == 4) {
                pbModel111 = this.ejU.eif;
                if (StringUtils.isNull(pbModel111.aLB())) {
                    pbModel112 = this.ejU.eif;
                    if (pbModel112.getAppealInfo() != null) {
                        pbModel113 = this.ejU.eif;
                        name = pbModel113.getAppealInfo().forumName;
                    }
                }
                this.ejU.finish();
                return;
            }
            pbModel109 = this.ejU.eif;
            name = pbModel109.getPbData().aJw().getName();
            if (!StringUtils.isNull(name)) {
                pbModel110 = this.ejU.eif;
                String aLB = pbModel110.aLB();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.ejU.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                if (StringUtils.isNull(aLB)) {
                    this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                } else if (aLB.equals(name)) {
                    this.ejU.finish();
                    return;
                } else {
                    this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                }
            }
            this.ejU.finish();
            return;
        }
        if (com.baidu.adp.lib.util.i.hj()) {
            pbModel = this.ejU.eif;
            if (pbModel.getPbData().aJH() == 1) {
                forumManageModel = this.ejU.eiR;
                if (!forumManageModel.bja()) {
                    eyVar6 = this.ejU.eiS;
                    eyVar6.awH();
                    int i6 = 0;
                    eyVar7 = this.ejU.eiS;
                    if (eyVar7.eoV.aNZ() != null) {
                        eyVar13 = this.ejU.eiS;
                        if (view == eyVar13.eoV.aNZ().aMu()) {
                            pbModel5 = this.ejU.eif;
                            if (pbModel5.getPbData().aJx().sk() == 1) {
                                i6 = 5;
                            } else {
                                i6 = 4;
                            }
                            pbModel3 = this.ejU.eif;
                            ForumData aJw = pbModel3.getPbData().aJw();
                            String name3 = aJw.getName();
                            String id6 = aJw.getId();
                            pbModel4 = this.ejU.eif;
                            id = pbModel4.getPbData().aJx().getId();
                            if (com.baidu.tieba.c.a.Sm() || !com.baidu.tieba.c.a.h(this.ejU.getBaseContext(), id, null)) {
                                eyVar11 = this.ejU.eiS;
                                eyVar11.aNi();
                                forumManageModel2 = this.ejU.eiR;
                                eyVar12 = this.ejU.eiS;
                                forumManageModel2.a(id6, name3, id, i6, eyVar12.aNk());
                                return;
                            }
                            return;
                        }
                    }
                    eyVar8 = this.ejU.eiS;
                    if (eyVar8.eoV.aNZ() != null) {
                        eyVar10 = this.ejU.eiS;
                        if (view == eyVar10.eoV.aNZ().aMw()) {
                            pbModel2 = this.ejU.eif;
                            if (pbModel2.getPbData().aJx().sl() == 1) {
                                i6 = 3;
                            } else {
                                i6 = 6;
                            }
                            pbModel3 = this.ejU.eif;
                            ForumData aJw2 = pbModel3.getPbData().aJw();
                            String name32 = aJw2.getName();
                            String id62 = aJw2.getId();
                            pbModel4 = this.ejU.eif;
                            id = pbModel4.getPbData().aJx().getId();
                            if (com.baidu.tieba.c.a.Sm()) {
                            }
                            eyVar11 = this.ejU.eiS;
                            eyVar11.aNi();
                            forumManageModel2 = this.ejU.eiR;
                            eyVar12 = this.ejU.eiS;
                            forumManageModel2.a(id62, name32, id, i6, eyVar12.aNk());
                            return;
                        }
                    }
                    eyVar9 = this.ejU.eiS;
                    if (view == eyVar9.aNj()) {
                        i6 = 2;
                    }
                    pbModel3 = this.ejU.eif;
                    ForumData aJw22 = pbModel3.getPbData().aJw();
                    String name322 = aJw22.getName();
                    String id622 = aJw22.getId();
                    pbModel4 = this.ejU.eif;
                    id = pbModel4.getPbData().aJx().getId();
                    if (com.baidu.tieba.c.a.Sm()) {
                    }
                    eyVar11 = this.ejU.eiS;
                    eyVar11.aNi();
                    forumManageModel2 = this.ejU.eiR;
                    eyVar12 = this.ejU.eiS;
                    forumManageModel2.a(id622, name322, id, i6, eyVar12.aNk());
                    return;
                }
                return;
            }
            return;
        }
        this.ejU.showToast(w.l.network_not_available);
    }
}
