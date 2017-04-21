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
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v125, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v129, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v178, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0836, code lost:
        if (r18 == r1.erm.aPa().Tx()) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x028e, code lost:
        if (r18 == r1.erm.aPa().aNv()) goto L824;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:572:0x1ad7  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x1c93  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x033e  */
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
        String aLH;
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
        PbActivity.b nz;
        PbModel pbModel10;
        PbModel pbModel11;
        PbModel pbModel12;
        PbActivity.b nz2;
        PbModel pbModel13;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        PbActivity.b nz3;
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
        boolean is;
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
        int aLw;
        int aLw2;
        PbModel pbModel33;
        PbModel pbModel34;
        PbModel pbModel35;
        PbModel pbModel36;
        PbModel pbModel37;
        PbModel pbModel38;
        PbModel pbModel39;
        PbModel pbModel40;
        int aLw3;
        int aLw4;
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
        PbActivity.b nz4;
        PbModel pbModel84;
        PbModel pbModel85;
        PbModel pbModel86;
        dp dpVar47;
        dp dpVar48;
        ey eyVar60;
        String aLv;
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
        String aLH2;
        ey eyVar86;
        ey eyVar87;
        ey eyVar88;
        ey eyVar89;
        boolean oi;
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
            z9 = this.emk.ekY;
            if (z9) {
                this.emk.ekY = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(w.h.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData3 = (PostData) obj;
                    pbModel124 = this.emk.ekv;
                    if (pbModel124 != null) {
                        pbModel125 = this.emk.ekv;
                        if (pbModel125.getPbData() != null && this.emk.aLr().aNS() != null && postData3.getAuthor() != null && postData3.bjp() != 1 && this.emk.checkUpIsLogin()) {
                            com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                            pbModel126 = this.emk.ekv;
                            jVar.b(pbModel126.getPbData().aKx());
                            pbModel127 = this.emk.ekv;
                            jVar.h(pbModel127.getPbData().aKy());
                            jVar.b(postData3);
                            this.emk.aLr().aNS().c(jVar);
                            this.emk.aLr().aNS().setPostId(postData3.getId());
                            this.emk.a(view, postData3.getAuthor().getUserId(), "");
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
        eyVar = this.emk.eli;
        if (view == eyVar.getNextView()) {
            pbModel123 = this.emk.ekv;
            if (pbModel123.iy(true)) {
                eyVar102 = this.emk.eli;
                eyVar102.aOn();
                return;
            }
            return;
        }
        eyVar2 = this.emk.eli;
        if (view == eyVar2.aNY()) {
            eyVar100 = this.emk.eli;
            eyVar100.aOe();
            if (UtilHelper.isFloatWindowOpAllowed(this.emk.getPageContext().getPageActivity())) {
                this.emk.elo = true;
                PbActivity pbActivity = this.emk;
                pbModel121 = this.emk.ekv;
                pbActivity.a(pbModel121.getPbData(), 0, 1, true, true);
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10830");
                pbModel122 = this.emk.ekv;
                TiebaStatic.log(asVar.aa("tid", pbModel122.getThreadID()));
                eyVar101 = this.emk.eli;
                eyVar101.axI();
                return;
            }
            this.emk.OI();
            return;
        }
        eyVar3 = this.emk.eli;
        if (eyVar3.erm.aPa() != null) {
            eyVar96 = this.emk.eli;
            if (view == eyVar96.erm.aPa().aNy()) {
                if (com.baidu.adp.lib.util.i.hk()) {
                    eyVar97 = this.emk.eli;
                    eyVar97.axI();
                    this.emk.aaq();
                    eyVar98 = this.emk.eli;
                    eyVar98.aOm();
                    eyVar99 = this.emk.eli;
                    eyVar99.avw();
                    pbModel120 = this.emk.ekv;
                    pbModel120.on(1);
                    return;
                }
                this.emk.showToast(w.l.network_not_available);
                return;
            }
        }
        eyVar4 = this.emk.eli;
        if (view == eyVar4.erm.aIy) {
            eyVar95 = this.emk.eli;
            pbModel119 = this.emk.ekv;
            if (!eyVar95.iY(pbModel119.aMI())) {
                this.emk.ekP = false;
                this.emk.finish();
                return;
            }
            this.emk.aaq();
            return;
        }
        eyVar5 = this.emk.eli;
        if (view != eyVar5.aOk()) {
            eyVar14 = this.emk.eli;
            if (eyVar14.erm.aPa() != null) {
                eyVar93 = this.emk.eli;
                if (view != eyVar93.erm.aPa().aNx()) {
                    eyVar94 = this.emk.eli;
                }
            }
            eyVar15 = this.emk.eli;
            if (view == eyVar15.aOB()) {
                pbModel117 = this.emk.ekv;
                if (pbModel117 != null) {
                    pbModel118 = this.emk.ekv;
                    com.baidu.tbadk.browser.f.S(this.emk.getPageContext().getPageActivity(), pbModel118.getPbData().aKy().so().getLink());
                    return;
                }
                return;
            }
            eyVar16 = this.emk.eli;
            if (view != eyVar16.erm.eux) {
                eyVar17 = this.emk.eli;
                if (view == eyVar17.erm.euz) {
                    pbModel103 = this.emk.ekv;
                    if (pbModel103 != null) {
                        pbModel104 = this.emk.ekv;
                        if (pbModel104.getPbData() != null) {
                            pbModel105 = this.emk.ekv;
                            ArrayList<PostData> aKA = pbModel105.getPbData().aKA();
                            if (aKA == null || aKA.size() <= 0) {
                                pbModel106 = this.emk.ekv;
                                if (pbModel106.aMD()) {
                                    com.baidu.adp.lib.util.k.showToast(this.emk.getPageContext().getPageActivity(), this.emk.getPageContext().getString(w.l.pb_no_data_tips));
                                    return;
                                }
                            }
                            eyVar91 = this.emk.eli;
                            eyVar91.aNU();
                            eyVar92 = this.emk.eli;
                            eyVar92.aOF();
                            this.emk.aLx();
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.k.showToast(this.emk.getPageContext().getPageActivity(), this.emk.getPageContext().getString(w.l.pb_no_data_tips));
                    return;
                }
                eyVar18 = this.emk.eli;
                if (view != eyVar18.erm.euy && view.getId() != w.h.pb_god_user_tip_content) {
                    eyVar25 = this.emk.eli;
                    if (eyVar25.erm.aPa() != null) {
                        eyVar88 = this.emk.eli;
                        if (view == eyVar88.erm.aPa().aNg()) {
                            if (com.baidu.adp.lib.util.i.hk()) {
                                eyVar89 = this.emk.eli;
                                eyVar89.axI();
                                oi = this.emk.oi(11009);
                                if (oi) {
                                    pbModel102 = this.emk.ekv;
                                    eyVar90 = this.emk.eli;
                                    if (pbModel102.ot(eyVar90.aOr()) == null) {
                                        return;
                                    }
                                    this.emk.aLD();
                                    return;
                                }
                                return;
                            }
                            this.emk.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    eyVar26 = this.emk.eli;
                    if (eyVar26.erm.aPa() != null) {
                        eyVar80 = this.emk.eli;
                        if (view == eyVar80.erm.aPa().aNu()) {
                            if (com.baidu.adp.lib.util.i.hk()) {
                                eyVar81 = this.emk.eli;
                                eyVar81.axI();
                                eyVar82 = this.emk.eli;
                                eyVar82.aNU();
                                z8 = this.emk.mIsLoading;
                                if (!z8) {
                                    this.emk.mIsLoading = true;
                                    eyVar83 = this.emk.eli;
                                    eyVar83.erm.euy.setEnabled(false);
                                    eyVar84 = this.emk.eli;
                                    eyVar84.ast();
                                    this.emk.aaq();
                                    eyVar85 = this.emk.eli;
                                    eyVar85.aOm();
                                    pbModel101 = this.emk.ekv;
                                    aLH2 = this.emk.aLH();
                                    pbModel101.nB(aLH2);
                                    TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    eyVar86 = this.emk.eli;
                                    eyVar86.aOF();
                                    eyVar87 = this.emk.eli;
                                    eyVar87.aMy();
                                    this.emk.oj(2);
                                    return;
                                }
                                return;
                            }
                            this.emk.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    eyVar27 = this.emk.eli;
                    if (eyVar27.erm.aPa() != null) {
                        eyVar77 = this.emk.eli;
                        if (view != eyVar77.erm.aPa().getCancelView()) {
                            eyVar79 = this.emk.eli;
                        }
                        eyVar78 = this.emk.eli;
                        eyVar78.erm.oI();
                        return;
                    }
                    eyVar28 = this.emk.eli;
                    if (eyVar28.erm.aPa() != null) {
                        eyVar75 = this.emk.eli;
                        if (view == eyVar75.erm.aPa().aNt()) {
                            if (this.emk.checkUpIsLogin()) {
                                eyVar76 = this.emk.eli;
                                eyVar76.axI();
                                this.emk.aaq();
                                this.emk.oj(2);
                                pbModel96 = this.emk.ekv;
                                if (pbModel96 != null) {
                                    pbModel97 = this.emk.ekv;
                                    if (pbModel97.getPbData() != null) {
                                        pbModel98 = this.emk.ekv;
                                        if (pbModel98.getPbData().aKP() != null) {
                                            pbModel99 = this.emk.ekv;
                                            if (!StringUtils.isNull(pbModel99.getPbData().aKP().qB(), true)) {
                                                com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11678");
                                                pbModel100 = this.emk.ekv;
                                                TiebaStatic.log(asVar2.aa("fid", pbModel100.getPbData().getForumId()));
                                            }
                                        }
                                    }
                                }
                                this.emk.arR();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11939"));
                                return;
                            }
                            return;
                        }
                    }
                    eyVar29 = this.emk.eli;
                    if (eyVar29.erm.aPa() != null) {
                        eyVar72 = this.emk.eli;
                        if (view == eyVar72.erm.aPa().aNo()) {
                            eyVar73 = this.emk.eli;
                            eyVar73.axI();
                            pbModel94 = this.emk.ekv;
                            if (pbModel94.amV() != null) {
                                eyVar74 = this.emk.eli;
                                pbModel95 = this.emk.ekv;
                                eyVar74.a(pbModel95.amV(), this.emk.dVo);
                            }
                            TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    eyVar30 = this.emk.eli;
                    if (eyVar30.erm.aPa() != null) {
                        eyVar69 = this.emk.eli;
                        if (view == eyVar69.erm.aPa().aNp()) {
                            eyVar70 = this.emk.eli;
                            eyVar70.axI();
                            this.emk.oj(2);
                            this.emk.aaq();
                            eyVar71 = this.emk.eli;
                            eyVar71.aOm();
                            pbModel93 = this.emk.ekv;
                            pbModel93.aMO();
                            TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    eyVar31 = this.emk.eli;
                    if (eyVar31.erm.aPa() != null) {
                        eyVar67 = this.emk.eli;
                        if (view == eyVar67.erm.aPa().aNq()) {
                            pbModel89 = this.emk.ekv;
                            if (pbModel89 != null) {
                                pbModel90 = this.emk.ekv;
                                if (pbModel90.getPbData() != null) {
                                    pbModel91 = this.emk.ekv;
                                    if (pbModel91.getPbData().aKy() != null) {
                                        eyVar68 = this.emk.eli;
                                        eyVar68.erm.oI();
                                        PbActivity pbActivity2 = this.emk;
                                        pbModel92 = this.emk.ekv;
                                        pbActivity2.nw(pbModel92.getPbData().aKy().sE());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    eyVar32 = this.emk.eli;
                    if (eyVar32.erm.aPa() != null) {
                        eyVar63 = this.emk.eli;
                        if (view == eyVar63.erm.aPa().aNr()) {
                            TiebaStatic.log("c10414");
                            eyVar64 = this.emk.eli;
                            eyVar64.axI();
                            eyVar65 = this.emk.eli;
                            if (eyVar65.sc() != ey.esV) {
                                pbModel87 = this.emk.ekv;
                                if (pbModel87.aNc() != null) {
                                    pbModel88 = this.emk.ekv;
                                    pbModel88.aNc().om(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                    return;
                                }
                                return;
                            }
                            eyVar66 = this.emk.eli;
                            eyVar66.aOJ();
                            return;
                        }
                    }
                    eyVar33 = this.emk.eli;
                    if (eyVar33.erm.aPa() != null) {
                        eyVar60 = this.emk.eli;
                        if (view == eyVar60.erm.aPa().aNs()) {
                            aLv = this.emk.aLv();
                            this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.emk.getPageContext().getPageActivity(), null, aLv, true)));
                            eyVar61 = this.emk.eli;
                            eyVar61.erm.oI();
                            eyVar62 = this.emk.eli;
                            eyVar62.erm.aPa().aNA();
                            return;
                        }
                    }
                    dpVar = this.emk.eln;
                    if (dpVar != null) {
                        dpVar48 = this.emk.eln;
                        if (view == dpVar48.aNi()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.hk()) {
                                this.emk.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            if (!(tag instanceof String)) {
                                if (tag instanceof SparseArray) {
                                    SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                    if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                        sparseArray2.put(w.h.tag_from, 0);
                                        sparseArray2.put(w.h.tag_check_mute_from, 2);
                                        this.emk.d(sparseArray2);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            this.emk.nw((String) tag);
                            return;
                        }
                    }
                    dpVar2 = this.emk.eln;
                    if (dpVar2 != null) {
                        dpVar47 = this.emk.eln;
                        if (view == dpVar47.aNg()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                            if (!this.emk.checkUpIsLogin()) {
                                return;
                            }
                            this.emk.aW(view);
                            return;
                        }
                    }
                    dpVar3 = this.emk.eln;
                    if (dpVar3 != null) {
                        dpVar45 = this.emk.eln;
                        if (view == dpVar45.aNl()) {
                            dpVar46 = this.emk.eln;
                            if (dpVar46.aNn()) {
                                com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c12007");
                                pbModel86 = this.emk.ekv;
                                TiebaStatic.log(asVar3.aa("tid", pbModel86.enB));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                            }
                            if (this.emk.checkUpIsLogin()) {
                                pbModel81 = this.emk.ekv;
                                if (pbModel81.getPbData() != null) {
                                    eyVar59 = this.emk.eli;
                                    eyVar59.axI();
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
                                        pbModel82 = this.emk.ekv;
                                        String threadID = pbModel82.getThreadID();
                                        String id2 = postData2.getId();
                                        int i2 = 0;
                                        pbModel83 = this.emk.ekv;
                                        if (pbModel83.getPbData() != null) {
                                            pbModel85 = this.emk.ekv;
                                            i2 = pbModel85.getPbData().aKI();
                                        }
                                        this.emk.aaq();
                                        nz4 = this.emk.nz(id2);
                                        if (nz4 != null) {
                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.emk.getPageContext().getPageActivity());
                                            SmallTailInfo aQc = postData2.aQc();
                                            pbModel84 = this.emk.ekv;
                                            this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, aQc, pbModel84.getPbData().rb(), false, postData2.getAuthor().getIconInfo()).addBigImageData(nz4.emB, nz4.emC, nz4.emD, nz4.index)));
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
                    dpVar4 = this.emk.eln;
                    if (dpVar4 != null) {
                        dpVar44 = this.emk.eln;
                        if (view == dpVar44.aNj()) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3 != null && (sparseArray3.get(w.h.tag_del_post_type) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_id) instanceof String) && (sparseArray3.get(w.h.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray3.get(w.h.tag_del_post_is_self)).booleanValue();
                                int intValue = ((Integer) sparseArray3.get(w.h.tag_manage_user_identity)).intValue();
                                if (!booleanValue && intValue != 0 && com.baidu.tieba.c.a.To()) {
                                    Context baseContext = this.emk.getBaseContext();
                                    pbModel80 = this.emk.ekv;
                                    if (com.baidu.tieba.c.a.h(baseContext, pbModel80.getThreadID(), (String) sparseArray3.get(w.h.tag_del_post_id))) {
                                        return;
                                    }
                                }
                                eyVar58 = this.emk.eli;
                                eyVar58.a(((Integer) sparseArray3.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray3.get(w.h.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                            return;
                        }
                    }
                    dpVar5 = this.emk.eln;
                    if (dpVar5 != null) {
                        dpVar43 = this.emk.eln;
                        if (view == dpVar43.aNk()) {
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
                            pbModel79 = this.emk.ekv;
                            com.baidu.tieba.pb.data.f pbData = pbModel79.getPbData();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            if (pbData != null && pbData.aKx() != null) {
                                str3 = pbData.aKx().getId();
                                str4 = pbData.aKx().getName();
                                str5 = pbData.getThreadId();
                            }
                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                            this.emk.a(j, str2, str3, str4, str5, i3);
                            return;
                        }
                    }
                    eyVar34 = this.emk.eli;
                    if (eyVar34.aOK() == view) {
                        eyVar57 = this.emk.eli;
                        if (eyVar57.aOK().getIndicateStatus()) {
                            pbModel78 = this.emk.ekv;
                            com.baidu.tieba.pb.data.f pbData2 = pbModel78.getPbData();
                            if (pbData2 != null && pbData2.aKy() != null && pbData2.aKy().rX() != null) {
                                String qb = pbData2.aKy().rX().qb();
                                if (StringUtils.isNull(qb)) {
                                    qb = pbData2.aKy().rX().getTaskId();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11107").aa("obj_id", qb));
                            }
                        } else {
                            com.baidu.tieba.tbadkCore.d.a.ca("c10725", null);
                        }
                        this.emk.aLO();
                        return;
                    }
                    eyVar35 = this.emk.eli;
                    if (eyVar35.aOg() != view) {
                        dpVar6 = this.emk.eln;
                        if (dpVar6 != null) {
                            dpVar42 = this.emk.eln;
                            if (view == dpVar42.aNh()) {
                                if (!com.baidu.adp.lib.util.i.hk()) {
                                    this.emk.showToast(w.l.network_not_available);
                                    return;
                                }
                                SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                if (sparseArray4 != null) {
                                    if (com.baidu.tieba.c.a.To() && sparseArray4.get(w.h.tag_del_post_id) != null) {
                                        Context baseContext2 = this.emk.getBaseContext();
                                        pbModel76 = this.emk.ekv;
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
                                            this.emk.d(sparseArray4);
                                            return;
                                        }
                                        sparseArray4.put(w.h.tag_check_mute_from, 2);
                                        eyVar56 = this.emk.eli;
                                        eyVar56.ba(view);
                                        return;
                                    } else if (booleanValue3) {
                                        eyVar55 = this.emk.eli;
                                        eyVar55.a(((Integer) sparseArray4.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray4.get(w.h.tag_del_post_id), ((Integer) sparseArray4.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(w.h.tag_del_post_is_self)).booleanValue());
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        eyVar36 = this.emk.eli;
                        if (view != eyVar36.aMz()) {
                            eyVar37 = this.emk.eli;
                            if (eyVar37.erm.aPa() != null) {
                                eyVar49 = this.emk.eli;
                                if (view == eyVar49.erm.aPa().aNz()) {
                                    if (com.baidu.adp.lib.util.i.hk()) {
                                        eyVar50 = this.emk.eli;
                                        eyVar50.axI();
                                        eyVar51 = this.emk.eli;
                                        pbModel66 = this.emk.ekv;
                                        com.baidu.tieba.pb.data.f pbData3 = pbModel66.getPbData();
                                        pbModel67 = this.emk.ekv;
                                        SparseArray<Object> c = eyVar51.c(pbData3, pbModel67.aMD(), 1);
                                        if (c != null) {
                                            pbModel68 = this.emk.ekv;
                                            PbActivity pbActivity3 = this.emk;
                                            Activity pageActivity = this.emk.getPageContext().getPageActivity();
                                            pbModel69 = this.emk.ekv;
                                            String id3 = pbModel69.getPbData().aKx().getId();
                                            pbModel70 = this.emk.ekv;
                                            String name2 = pbModel70.getPbData().aKx().getName();
                                            pbModel71 = this.emk.ekv;
                                            pbActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, pbModel71.getPbData().aKy().getId(), String.valueOf(pbModel68.getPbData().getUserData().getUserId()), (String) c.get(w.h.tag_forbid_user_name), (String) c.get(w.h.tag_forbid_user_post_id))));
                                            return;
                                        }
                                        return;
                                    }
                                    this.emk.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            eyVar38 = this.emk.eli;
                            if (eyVar38.erm.aPa() != null) {
                                eyVar45 = this.emk.eli;
                                if (view == eyVar45.erm.aPa().aNw()) {
                                    if (com.baidu.adp.lib.util.i.hk()) {
                                        eyVar46 = this.emk.eli;
                                        pbModel64 = this.emk.ekv;
                                        com.baidu.tieba.pb.data.f pbData4 = pbModel64.getPbData();
                                        pbModel65 = this.emk.ekv;
                                        SparseArray<Object> c2 = eyVar46.c(pbData4, pbModel65.aMD(), 1);
                                        if (c2 != null) {
                                            eyVar48 = this.emk.eli;
                                            eyVar48.a(((Integer) c2.get(w.h.tag_del_post_type)).intValue(), (String) c2.get(w.h.tag_del_post_id), ((Integer) c2.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(w.h.tag_del_post_is_self)).booleanValue());
                                        }
                                        eyVar47 = this.emk.eli;
                                        eyVar47.erm.oI();
                                        return;
                                    }
                                    this.emk.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            if (view.getId() != w.h.sub_pb_more && view.getId() != w.h.sub_pb_item) {
                                eyVar40 = this.emk.eli;
                                if (view != eyVar40.aLm()) {
                                    eyVar41 = this.emk.eli;
                                    if (view == eyVar41.erm.aPb()) {
                                        eyVar44 = this.emk.eli;
                                        eyVar44.aOu();
                                        return;
                                    }
                                    int id4 = view.getId();
                                    if (id4 == w.h.pb_u9_text_view) {
                                        if (this.emk.checkUpIsLogin() && (boVar = (com.baidu.tbadk.core.data.bo) view.getTag()) != null && !StringUtils.isNull(boVar.tF())) {
                                            TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                            com.baidu.tbadk.core.util.bb.wn().c(this.emk.getPageContext(), new String[]{boVar.tF()});
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.pb_floor_agree && (view instanceof PbFloorAgreeView)) {
                                        if (this.emk.checkUpIsLogin() && (postData = (PostData) view.getTag(w.h.tag_clip_board)) != null) {
                                            if (postData.bjD()) {
                                                postData.cB(postData.bjC() - 1);
                                            } else {
                                                postData.cB(postData.bjC() + 1);
                                            }
                                            postData.lu(!postData.bjD());
                                            ((PbFloorAgreeView) view).a(postData.bjD(), postData.bjC(), true);
                                            pbModel58 = this.emk.ekv;
                                            pbModel58.aNd().bJ(postData.getId(), postData.bjD() ? "0" : "1");
                                            int i4 = 2;
                                            if (postData.getAuthor() != null && postData.getAuthor().getUserId() != null) {
                                                i4 = postData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) ? 1 : 2;
                                            }
                                            if (postData.bjD()) {
                                                com.baidu.tbadk.core.util.as asVar4 = new com.baidu.tbadk.core.util.as("c12003");
                                                pbModel60 = this.emk.ekv;
                                                TiebaStatic.log(asVar4.aa("tid", pbModel60.enB).s("obj_id", i4));
                                                return;
                                            }
                                            com.baidu.tbadk.core.util.as asVar5 = new com.baidu.tbadk.core.util.as("c12008");
                                            pbModel59 = this.emk.ekv;
                                            TiebaStatic.log(asVar5.aa("tid", pbModel59.enB).s("obj_id", i4));
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.replybtn || id4 == w.h.cover_reply_content || id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right) {
                                        dpVar7 = this.emk.eln;
                                        if (dpVar7 == null) {
                                            this.emk.eln = new dp(this.emk.getPageContext(), this.emk.bQO);
                                            dpVar41 = this.emk.eln;
                                            z7 = this.emk.mIsLogin;
                                            dpVar41.iC(z7);
                                        }
                                        dpVar8 = this.emk.eln;
                                        dpVar8.showDialog();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11740"));
                                        PostData postData4 = null;
                                        if (view != null && view.getTag() != null) {
                                            postData4 = (PostData) ((SparseArray) view.getTag()).get(w.h.tag_load_sub_data);
                                            boolean z10 = id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right;
                                            if (z10) {
                                                com.baidu.tbadk.core.util.as asVar6 = new com.baidu.tbadk.core.util.as("c12006");
                                                pbModel24 = this.emk.ekv;
                                                TiebaStatic.log(asVar6.aa("tid", pbModel24.enB));
                                            }
                                            SparseArray sparseArray5 = new SparseArray();
                                            sparseArray5.put(w.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(w.h.tag_clip_board));
                                            sparseArray5.put(w.h.tag_is_subpb, false);
                                            dpVar13 = this.emk.eln;
                                            dpVar13.aNg().setTag(sparseArray5);
                                            dpVar14 = this.emk.eln;
                                            dpVar14.aNl().setTag(view.getTag());
                                            dpVar15 = this.emk.eln;
                                            dpVar15.iE(z10);
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
                                                    dpVar40 = this.emk.eln;
                                                    dpVar40.aNj().setVisibility(0);
                                                } else {
                                                    sparseArray7.put(w.h.tag_should_delete_visible, false);
                                                    dpVar35 = this.emk.eln;
                                                    dpVar35.aNj().setVisibility(8);
                                                }
                                                dpVar36 = this.emk.eln;
                                                dpVar36.aNh().setTag(sparseArray7);
                                                dpVar37 = this.emk.eln;
                                                dpVar37.aNj().setTag(sparseArray7);
                                                dpVar38 = this.emk.eln;
                                                dpVar38.aNh().setText(w.l.bar_manager);
                                                dpVar39 = this.emk.eln;
                                                dpVar39.aNh().setVisibility(0);
                                            } else if (!booleanValue7) {
                                                dpVar16 = this.emk.eln;
                                                dpVar16.aNh().setVisibility(8);
                                                dpVar17 = this.emk.eln;
                                                dpVar17.aNj().setVisibility(8);
                                            } else {
                                                SparseArray sparseArray8 = new SparseArray();
                                                sparseArray8.put(w.h.tag_should_manage_visible, false);
                                                sparseArray8.put(w.h.tag_user_mute_visible, false);
                                                sparseArray8.put(w.h.tag_should_delete_visible, true);
                                                sparseArray8.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                sparseArray8.put(w.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                sparseArray8.put(w.h.tag_del_post_id, sparseArray6.get(w.h.tag_del_post_id));
                                                sparseArray8.put(w.h.tag_del_post_type, sparseArray6.get(w.h.tag_del_post_type));
                                                dpVar18 = this.emk.eln;
                                                dpVar18.aNh().setTag(sparseArray8);
                                                dpVar19 = this.emk.eln;
                                                dpVar19.aNj().setTag(sparseArray8);
                                                dpVar20 = this.emk.eln;
                                                dpVar20.aNh().setText(w.l.delete);
                                                dpVar21 = this.emk.eln;
                                                dpVar21.aNj().setVisibility(0);
                                                dpVar22 = this.emk.eln;
                                                dpVar22.aNh().setVisibility(8);
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
                                                dpVar31 = this.emk.eln;
                                                dpVar31.aNi().setTag(sparseArray10);
                                                dpVar32 = this.emk.eln;
                                                dpVar32.aNi().setVisibility(0);
                                                dpVar33 = this.emk.eln;
                                                dpVar33.aNh().setVisibility(8);
                                                dpVar34 = this.emk.eln;
                                                dpVar34.aNi().setText(w.l.mute_option);
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
                                                is = this.emk.is(z5);
                                                boolean isLogin = is & this.emk.isLogin();
                                                this.emk.ema = (PostData) sparseArray9.get(w.h.tag_clip_board);
                                                if (ex.g(this.emk.ema) ? false : isLogin) {
                                                    dpVar24 = this.emk.eln;
                                                    dpVar24.aNi().setVisibility(0);
                                                    dpVar25 = this.emk.eln;
                                                    dpVar25.aNi().setTag(str7);
                                                } else {
                                                    dpVar23 = this.emk.eln;
                                                    dpVar23.aNi().setVisibility(8);
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
                                                dpVar27 = this.emk.eln;
                                                dpVar27.aNk().setVisibility(0);
                                                dpVar28 = this.emk.eln;
                                                dpVar28.aNk().setTag(w.h.tag_chudian_template_id, Long.valueOf(j2));
                                                dpVar29 = this.emk.eln;
                                                dpVar29.aNk().setTag(w.h.tag_chudian_monitor_id, str);
                                                dpVar30 = this.emk.eln;
                                                dpVar30.aNk().setTag(w.h.tag_chudian_hide_day, Integer.valueOf(i));
                                            } else {
                                                dpVar26 = this.emk.eln;
                                                dpVar26.aNk().setVisibility(8);
                                            }
                                        }
                                        pbModel22 = this.emk.ekv;
                                        if (pbModel22.getPbData().oe()) {
                                            pbModel23 = this.emk.ekv;
                                            String od = pbModel23.getPbData().od();
                                            if (postData4 != null && !com.baidu.adp.lib.util.j.isEmpty(od) && od.equals(postData4.getId())) {
                                                z2 = true;
                                                if (!z2) {
                                                    dpVar12 = this.emk.eln;
                                                    dpVar12.aNg().setText(w.l.remove_mark);
                                                } else {
                                                    dpVar9 = this.emk.eln;
                                                    dpVar9.aNg().setText(w.l.mark);
                                                }
                                                dpVar10 = this.emk.eln;
                                                dpVar10.iD(true);
                                                dpVar11 = this.emk.eln;
                                                dpVar11.refreshUI();
                                                return;
                                            }
                                        }
                                        z2 = false;
                                        if (!z2) {
                                        }
                                        dpVar10 = this.emk.eln;
                                        dpVar10.iD(true);
                                        dpVar11 = this.emk.eln;
                                        dpVar11.refreshUI();
                                        return;
                                    } else if (id4 == w.h.pb_act_btn) {
                                        pbModel52 = this.emk.ekv;
                                        if (pbModel52.getPbData() != null) {
                                            pbModel53 = this.emk.ekv;
                                            if (pbModel53.getPbData().aKy() != null) {
                                                pbModel54 = this.emk.ekv;
                                                if (pbModel54.getPbData().aKy().sU() != null) {
                                                    Activity activity = this.emk.getActivity();
                                                    pbModel55 = this.emk.ekv;
                                                    com.baidu.tbadk.browser.f.S(activity, pbModel55.getPbData().aKy().sU());
                                                    pbModel56 = this.emk.ekv;
                                                    if (pbModel56.getPbData().aKy().sS() != 1) {
                                                        pbModel57 = this.emk.ekv;
                                                        if (pbModel57.getPbData().aKy().sS() == 2) {
                                                            TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                            pbModel49 = this.emk.ekv;
                                            com.baidu.tbadk.core.util.as aa = asVar7.aa("fid", pbModel49.getPbData().getForumId());
                                            pbModel50 = this.emk.ekv;
                                            TiebaStatic.log(aa.aa("tid", pbModel50.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                            pbModel51 = this.emk.ekv;
                                            if (pbModel51.getPbData().getThreadId().equals(str8)) {
                                                eyVar43 = this.emk.eli;
                                                eyVar43.setSelection(0);
                                                return;
                                            }
                                            this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.emk.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.pb_item_tail_content) {
                                        if (com.baidu.tbadk.core.util.bg.aK(this.emk.getPageContext().getPageActivity())) {
                                            String string = TbadkCoreApplication.m9getInst().getString(w.l.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.uL().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                TiebaStatic.log("c10056");
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                            }
                                            eyVar42 = this.emk.eli;
                                            eyVar42.aNU();
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.join_vote_tv) {
                                        if (view != null) {
                                            com.baidu.tbadk.browser.f.S(this.emk.getActivity(), (String) view.getTag());
                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                            aLw3 = this.emk.aLw();
                                            if (aLw3 == 1) {
                                                pbModel45 = this.emk.ekv;
                                                if (pbModel45 != null) {
                                                    pbModel46 = this.emk.ekv;
                                                    if (pbModel46.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar8 = new com.baidu.tbadk.core.util.as("c10397");
                                                        pbModel47 = this.emk.ekv;
                                                        com.baidu.tbadk.core.util.as aa2 = asVar8.aa("fid", pbModel47.getPbData().getForumId());
                                                        pbModel48 = this.emk.ekv;
                                                        TiebaStatic.log(aa2.aa("tid", pbModel48.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aLw4 = this.emk.aLw();
                                            if (aLw4 == 2) {
                                                pbModel41 = this.emk.ekv;
                                                if (pbModel41 != null) {
                                                    pbModel42 = this.emk.ekv;
                                                    if (pbModel42.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar9 = new com.baidu.tbadk.core.util.as("c10401");
                                                        pbModel43 = this.emk.ekv;
                                                        com.baidu.tbadk.core.util.as aa3 = asVar9.aa("fid", pbModel43.getPbData().getForumId());
                                                        pbModel44 = this.emk.ekv;
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
                                            com.baidu.tbadk.browser.f.S(this.emk.getActivity(), (String) view.getTag());
                                            aLw = this.emk.aLw();
                                            if (aLw == 1) {
                                                pbModel37 = this.emk.ekv;
                                                if (pbModel37 != null) {
                                                    pbModel38 = this.emk.ekv;
                                                    if (pbModel38.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar10 = new com.baidu.tbadk.core.util.as("c10507");
                                                        pbModel39 = this.emk.ekv;
                                                        com.baidu.tbadk.core.util.as aa4 = asVar10.aa("fid", pbModel39.getPbData().getForumId());
                                                        pbModel40 = this.emk.ekv;
                                                        TiebaStatic.log(aa4.aa("tid", pbModel40.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aLw2 = this.emk.aLw();
                                            if (aLw2 == 2) {
                                                pbModel33 = this.emk.ekv;
                                                if (pbModel33 != null) {
                                                    pbModel34 = this.emk.ekv;
                                                    if (pbModel34.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar11 = new com.baidu.tbadk.core.util.as("c10508");
                                                        pbModel35 = this.emk.ekv;
                                                        com.baidu.tbadk.core.util.as aa5 = asVar11.aa("fid", pbModel35.getPbData().getForumId());
                                                        pbModel36 = this.emk.ekv;
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
                                                pbModel29 = this.emk.ekv;
                                                if (pbModel29 != null) {
                                                    pbModel30 = this.emk.ekv;
                                                    if (pbModel30.getPbData() != null) {
                                                        pbModel31 = this.emk.ekv;
                                                        if (pbModel31.getPbData().aKP() != null) {
                                                            pbModel32 = this.emk.ekv;
                                                            com.baidu.tieba.pb.data.f pbData5 = pbModel32.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11679").aa("fid", pbData5.getForumId()));
                                                            com.baidu.tbadk.core.util.bb.wn().c(this.emk.getPageContext(), new String[]{pbData5.aKP().aKS()});
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.yule_head_img_all_rank) {
                                                pbModel25 = this.emk.ekv;
                                                if (pbModel25 != null) {
                                                    pbModel26 = this.emk.ekv;
                                                    if (pbModel26.getPbData() != null) {
                                                        pbModel27 = this.emk.ekv;
                                                        if (pbModel27.getPbData().aKP() != null) {
                                                            pbModel28 = this.emk.ekv;
                                                            com.baidu.tieba.pb.data.f pbData6 = pbModel28.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11678").aa("fid", pbData6.getForumId()));
                                                            com.baidu.tbadk.core.util.bb.wn().c(this.emk.getPageContext(), new String[]{pbData6.aKP().aKS()});
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
                                        this.emk.aLK();
                                        return;
                                    } else {
                                        this.emk.aLJ();
                                        return;
                                    }
                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                    long c3 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                    pbModel61 = this.emk.ekv;
                                    long c4 = com.baidu.adp.lib.g.b.c(pbModel61.getPbData().getForumId(), 0L);
                                    pbModel62 = this.emk.ekv;
                                    long c5 = com.baidu.adp.lib.g.b.c(pbModel62.getThreadID(), 0L);
                                    pbModel63 = this.emk.ekv;
                                    this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.emk.getPageContext().getPageActivity(), 24008, c4, c5, c3, pbModel63.getPbData().aKy().sI())));
                                    return;
                                } else {
                                    return;
                                }
                            } else if (this.emk.checkUpIsLogin()) {
                                pbModel7 = this.emk.ekv;
                                if (pbModel7.getPbData() != null) {
                                    eyVar39 = this.emk.eli;
                                    eyVar39.axI();
                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                    PostData postData5 = (PostData) sparseArray12.get(w.h.tag_load_sub_data);
                                    View view2 = (View) sparseArray12.get(w.h.tag_load_sub_view);
                                    if (postData5 != null && view2 != null) {
                                        pbModel8 = this.emk.ekv;
                                        String threadID2 = pbModel8.getThreadID();
                                        String id5 = postData5.getId();
                                        int i5 = 0;
                                        pbModel9 = this.emk.ekv;
                                        if (pbModel9.getPbData() != null) {
                                            pbModel20 = this.emk.ekv;
                                            i5 = pbModel20.getPbData().aKI();
                                        }
                                        this.emk.aaq();
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
                                                nz2 = this.emk.nz(id5);
                                                if (postData5 != null) {
                                                    pbModel13 = this.emk.ekv;
                                                    if (pbModel13 != null) {
                                                        pbModel14 = this.emk.ekv;
                                                        if (pbModel14.getPbData() != null && nz2 != null && this.emk.aLr().aNS() != null) {
                                                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                                                            pbModel15 = this.emk.ekv;
                                                            jVar2.b(pbModel15.getPbData().aKx());
                                                            pbModel16 = this.emk.ekv;
                                                            jVar2.h(pbModel16.getPbData().aKy());
                                                            jVar2.b(postData6);
                                                            this.emk.aLr().aNS().c(jVar2);
                                                            this.emk.aLr().aNS().setPostId(str11);
                                                            this.emk.a(view, str10, str9);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            TiebaStatic.log("c11742");
                                            nz = this.emk.nz(id5);
                                            if (postData5 != null) {
                                                pbModel10 = this.emk.ekv;
                                                if (pbModel10 != null) {
                                                    pbModel11 = this.emk.ekv;
                                                    if (pbModel11.getPbData() != null && nz != null) {
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.emk.getPageContext().getPageActivity());
                                                        SmallTailInfo aQc2 = postData5.aQc();
                                                        pbModel12 = this.emk.ekv;
                                                        this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i5, aQc2, pbModel12.getPbData().rb(), false, postData5.getAuthor().getIconInfo()).addBigImageData(nz.emB, nz.emC, nz.emD, nz.index)));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        nz3 = this.emk.nz(id5);
                                        if (postData5 != null) {
                                            pbModel17 = this.emk.ekv;
                                            if (pbModel17 != null) {
                                                pbModel18 = this.emk.ekv;
                                                if (pbModel18.getPbData() != null && nz3 != null) {
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.emk.getPageContext().getPageActivity());
                                                    SmallTailInfo aQc3 = postData5.aQc();
                                                    pbModel19 = this.emk.ekv;
                                                    this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i5, aQc3, pbModel19.getPbData().rb(), false, postData5.getAuthor().getIconInfo()).addBigImageData(nz3.emB, nz3.emC, nz3.emD, nz3.index)));
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
                                pbModel21 = this.emk.ekv;
                                TiebaStatic.log(s.aa("fid", pbModel21.getPbData().getForumId()));
                                return;
                            }
                        } else if (this.emk.checkUpIsLogin()) {
                            eyVar52 = this.emk.eli;
                            if (!eyVar52.aMw()) {
                                pbModel72 = this.emk.ekv;
                                if (pbModel72 != null) {
                                    pbModel73 = this.emk.ekv;
                                    if (pbModel73.aNa() != null) {
                                        pbModel74 = this.emk.ekv;
                                        if (pbModel74.aNa().aMs() != null) {
                                            pbModel75 = this.emk.ekv;
                                            if (com.baidu.tbadk.core.util.x.p(pbModel75.aNa().aMs().getItems()) != 0) {
                                                eyVar53 = this.emk.eli;
                                                eyVar53.aMx();
                                                return;
                                            }
                                            this.emk.showToast(w.l.graffiti_quick_vote_empty);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            eyVar54 = this.emk.eli;
                            eyVar54.aMy();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.emk.checkUpIsLogin()) {
                        com.baidu.tbadk.core.util.as s2 = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
                        pbModel77 = this.emk.ekv;
                        TiebaStatic.log(s2.aa("fid", pbModel77.getPbData().getForumId()));
                        return;
                    } else {
                        this.emk.aLo();
                        return;
                    }
                } else if (com.baidu.adp.lib.util.i.hk()) {
                    eyVar19 = this.emk.eli;
                    eyVar19.aNU();
                    z = this.emk.mIsLoading;
                    if (!z) {
                        this.emk.mIsLoading = true;
                        eyVar20 = this.emk.eli;
                        eyVar20.erm.euy.setEnabled(false);
                        eyVar21 = this.emk.eli;
                        eyVar21.ast();
                        this.emk.aaq();
                        eyVar22 = this.emk.eli;
                        eyVar22.aOm();
                        pbModel6 = this.emk.ekv;
                        aLH = this.emk.aLH();
                        pbModel6.nB(aLH);
                        TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        eyVar23 = this.emk.eli;
                        eyVar23.aOF();
                        eyVar24 = this.emk.eli;
                        eyVar24.aMy();
                        this.emk.oj(2);
                        return;
                    }
                    return;
                } else {
                    this.emk.showToast(w.l.network_not_available);
                    return;
                }
            }
            TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            pbModel107 = this.emk.ekv;
            if (pbModel107.getPbData() != null) {
                pbModel114 = this.emk.ekv;
                if (pbModel114.getPbData().aKy() != null) {
                    pbModel115 = this.emk.ekv;
                    if (pbModel115.getPbData().aKy().tb()) {
                        pbModel116 = this.emk.ekv;
                        if (pbModel116.getPbData().aKy().sF() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11922"));
                        }
                    }
                }
            }
            pbModel108 = this.emk.ekv;
            if (pbModel108.getErrorNo() == 4) {
                pbModel111 = this.emk.ekv;
                if (StringUtils.isNull(pbModel111.aMC())) {
                    pbModel112 = this.emk.ekv;
                    if (pbModel112.getAppealInfo() != null) {
                        pbModel113 = this.emk.ekv;
                        name = pbModel113.getAppealInfo().forumName;
                    }
                }
                this.emk.finish();
                return;
            }
            pbModel109 = this.emk.ekv;
            name = pbModel109.getPbData().aKx().getName();
            if (!StringUtils.isNull(name)) {
                pbModel110 = this.emk.ekv;
                String aMC = pbModel110.aMC();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.emk.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                if (StringUtils.isNull(aMC)) {
                    this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                } else if (aMC.equals(name)) {
                    this.emk.finish();
                    return;
                } else {
                    this.emk.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                }
            }
            this.emk.finish();
            return;
        }
        if (com.baidu.adp.lib.util.i.hk()) {
            pbModel = this.emk.ekv;
            if (pbModel.getPbData().aKI() == 1) {
                forumManageModel = this.emk.elh;
                if (!forumManageModel.bkb()) {
                    eyVar6 = this.emk.eli;
                    eyVar6.axI();
                    int i6 = 0;
                    eyVar7 = this.emk.eli;
                    if (eyVar7.erm.aPa() != null) {
                        eyVar13 = this.emk.eli;
                        if (view == eyVar13.erm.aPa().aNv()) {
                            pbModel5 = this.emk.ekv;
                            if (pbModel5.getPbData().aKy().sk() == 1) {
                                i6 = 5;
                            } else {
                                i6 = 4;
                            }
                            pbModel3 = this.emk.ekv;
                            ForumData aKx = pbModel3.getPbData().aKx();
                            String name3 = aKx.getName();
                            String id6 = aKx.getId();
                            pbModel4 = this.emk.ekv;
                            id = pbModel4.getPbData().aKy().getId();
                            if (com.baidu.tieba.c.a.To() || !com.baidu.tieba.c.a.h(this.emk.getBaseContext(), id, null)) {
                                eyVar11 = this.emk.eli;
                                eyVar11.aOj();
                                forumManageModel2 = this.emk.elh;
                                eyVar12 = this.emk.eli;
                                forumManageModel2.a(id6, name3, id, i6, eyVar12.aOl());
                                return;
                            }
                            return;
                        }
                    }
                    eyVar8 = this.emk.eli;
                    if (eyVar8.erm.aPa() != null) {
                        eyVar10 = this.emk.eli;
                        if (view == eyVar10.erm.aPa().aNx()) {
                            pbModel2 = this.emk.ekv;
                            if (pbModel2.getPbData().aKy().sl() == 1) {
                                i6 = 3;
                            } else {
                                i6 = 6;
                            }
                            pbModel3 = this.emk.ekv;
                            ForumData aKx2 = pbModel3.getPbData().aKx();
                            String name32 = aKx2.getName();
                            String id62 = aKx2.getId();
                            pbModel4 = this.emk.ekv;
                            id = pbModel4.getPbData().aKy().getId();
                            if (com.baidu.tieba.c.a.To()) {
                            }
                            eyVar11 = this.emk.eli;
                            eyVar11.aOj();
                            forumManageModel2 = this.emk.elh;
                            eyVar12 = this.emk.eli;
                            forumManageModel2.a(id62, name32, id, i6, eyVar12.aOl());
                            return;
                        }
                    }
                    eyVar9 = this.emk.eli;
                    if (view == eyVar9.aOk()) {
                        i6 = 2;
                    }
                    pbModel3 = this.emk.ekv;
                    ForumData aKx22 = pbModel3.getPbData().aKx();
                    String name322 = aKx22.getName();
                    String id622 = aKx22.getId();
                    pbModel4 = this.emk.ekv;
                    id = pbModel4.getPbData().aKy().getId();
                    if (com.baidu.tieba.c.a.To()) {
                    }
                    eyVar11 = this.emk.eli;
                    eyVar11.aOj();
                    forumManageModel2 = this.emk.elh;
                    eyVar12 = this.emk.eli;
                    forumManageModel2.a(id622, name322, id, i6, eyVar12.aOl());
                    return;
                }
                return;
            }
            return;
        }
        this.emk.showToast(w.l.network_not_available);
    }
}
