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
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v125, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v129, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v178, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0836, code lost:
        if (r18 == r1.eqM.aNQ().RX()) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x028e, code lost:
        if (r18 == r1.eqM.aNQ().aMl()) goto L824;
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
        fa faVar;
        fa faVar2;
        fa faVar3;
        fa faVar4;
        fa faVar5;
        PbModel pbModel;
        ForumManageModel forumManageModel;
        fa faVar6;
        fa faVar7;
        fa faVar8;
        fa faVar9;
        fa faVar10;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        String id;
        fa faVar11;
        ForumManageModel forumManageModel2;
        fa faVar12;
        fa faVar13;
        PbModel pbModel5;
        fa faVar14;
        fa faVar15;
        fa faVar16;
        fa faVar17;
        fa faVar18;
        fa faVar19;
        boolean z;
        fa faVar20;
        fa faVar21;
        fa faVar22;
        PbModel pbModel6;
        String aKB;
        fa faVar23;
        fa faVar24;
        fa faVar25;
        fa faVar26;
        fa faVar27;
        fa faVar28;
        fa faVar29;
        fa faVar30;
        fa faVar31;
        fa faVar32;
        fa faVar33;
        dr drVar;
        dr drVar2;
        dr drVar3;
        dr drVar4;
        dr drVar5;
        fa faVar34;
        fa faVar35;
        dr drVar6;
        fa faVar36;
        fa faVar37;
        fa faVar38;
        PbModel pbModel7;
        fa faVar39;
        PbModel pbModel8;
        PbModel pbModel9;
        PbActivity.b ns;
        PbModel pbModel10;
        PbModel pbModel11;
        PbModel pbModel12;
        PbActivity.b ns2;
        PbModel pbModel13;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        PbActivity.b ns3;
        PbModel pbModel17;
        PbModel pbModel18;
        PbModel pbModel19;
        PbModel pbModel20;
        PbModel pbModel21;
        fa faVar40;
        fa faVar41;
        dr drVar7;
        dr drVar8;
        PbModel pbModel22;
        boolean z2;
        dr drVar9;
        dr drVar10;
        dr drVar11;
        dr drVar12;
        PbModel pbModel23;
        dr drVar13;
        dr drVar14;
        dr drVar15;
        boolean z3;
        dr drVar16;
        dr drVar17;
        dr drVar18;
        dr drVar19;
        dr drVar20;
        dr drVar21;
        dr drVar22;
        boolean z4;
        boolean z5;
        boolean ij;
        dr drVar23;
        dr drVar24;
        dr drVar25;
        boolean z6;
        String str;
        int i;
        dr drVar26;
        dr drVar27;
        dr drVar28;
        dr drVar29;
        dr drVar30;
        dr drVar31;
        dr drVar32;
        dr drVar33;
        dr drVar34;
        dr drVar35;
        dr drVar36;
        dr drVar37;
        dr drVar38;
        dr drVar39;
        dr drVar40;
        PbModel pbModel24;
        dr drVar41;
        boolean z7;
        PbModel pbModel25;
        PbModel pbModel26;
        PbModel pbModel27;
        PbModel pbModel28;
        PbModel pbModel29;
        PbModel pbModel30;
        PbModel pbModel31;
        PbModel pbModel32;
        int aKp;
        int aKp2;
        PbModel pbModel33;
        PbModel pbModel34;
        PbModel pbModel35;
        PbModel pbModel36;
        PbModel pbModel37;
        PbModel pbModel38;
        PbModel pbModel39;
        PbModel pbModel40;
        int aKp3;
        int aKp4;
        PbModel pbModel41;
        PbModel pbModel42;
        PbModel pbModel43;
        PbModel pbModel44;
        PbModel pbModel45;
        PbModel pbModel46;
        PbModel pbModel47;
        PbModel pbModel48;
        fa faVar42;
        PbModel pbModel49;
        PbModel pbModel50;
        PbModel pbModel51;
        fa faVar43;
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
        com.baidu.tbadk.core.data.bp bpVar;
        fa faVar44;
        PbModel pbModel61;
        PbModel pbModel62;
        PbModel pbModel63;
        fa faVar45;
        fa faVar46;
        PbModel pbModel64;
        PbModel pbModel65;
        fa faVar47;
        fa faVar48;
        fa faVar49;
        fa faVar50;
        fa faVar51;
        PbModel pbModel66;
        PbModel pbModel67;
        PbModel pbModel68;
        PbModel pbModel69;
        PbModel pbModel70;
        PbModel pbModel71;
        fa faVar52;
        PbModel pbModel72;
        PbModel pbModel73;
        PbModel pbModel74;
        PbModel pbModel75;
        fa faVar53;
        fa faVar54;
        dr drVar42;
        fa faVar55;
        fa faVar56;
        PbModel pbModel76;
        PbModel pbModel77;
        fa faVar57;
        PbModel pbModel78;
        dr drVar43;
        PbModel pbModel79;
        dr drVar44;
        fa faVar58;
        PbModel pbModel80;
        dr drVar45;
        dr drVar46;
        PbModel pbModel81;
        fa faVar59;
        SparseArray sparseArray;
        PostData postData2;
        PbModel pbModel82;
        PbModel pbModel83;
        PbActivity.b ns4;
        PbModel pbModel84;
        PbModel pbModel85;
        PbModel pbModel86;
        dr drVar47;
        dr drVar48;
        fa faVar60;
        String aKo;
        fa faVar61;
        fa faVar62;
        fa faVar63;
        fa faVar64;
        fa faVar65;
        PbModel pbModel87;
        PbModel pbModel88;
        fa faVar66;
        fa faVar67;
        PbModel pbModel89;
        PbModel pbModel90;
        PbModel pbModel91;
        fa faVar68;
        PbModel pbModel92;
        fa faVar69;
        fa faVar70;
        fa faVar71;
        PbModel pbModel93;
        fa faVar72;
        fa faVar73;
        PbModel pbModel94;
        fa faVar74;
        PbModel pbModel95;
        fa faVar75;
        fa faVar76;
        PbModel pbModel96;
        PbModel pbModel97;
        PbModel pbModel98;
        PbModel pbModel99;
        PbModel pbModel100;
        fa faVar77;
        fa faVar78;
        fa faVar79;
        fa faVar80;
        fa faVar81;
        fa faVar82;
        boolean z8;
        fa faVar83;
        fa faVar84;
        fa faVar85;
        PbModel pbModel101;
        String aKB2;
        fa faVar86;
        fa faVar87;
        fa faVar88;
        fa faVar89;
        boolean oe;
        PbModel pbModel102;
        fa faVar90;
        PbModel pbModel103;
        PbModel pbModel104;
        PbModel pbModel105;
        PbModel pbModel106;
        fa faVar91;
        fa faVar92;
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
        fa faVar93;
        fa faVar94;
        fa faVar95;
        PbModel pbModel119;
        fa faVar96;
        fa faVar97;
        fa faVar98;
        fa faVar99;
        PbModel pbModel120;
        fa faVar100;
        PbModel pbModel121;
        PbModel pbModel122;
        fa faVar101;
        PbModel pbModel123;
        fa faVar102;
        boolean z9;
        PbModel pbModel124;
        PbModel pbModel125;
        PbModel pbModel126;
        PbModel pbModel127;
        if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
            z9 = this.elO.ekD;
            if (z9) {
                this.elO.ekD = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(w.h.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData3 = (PostData) obj;
                    pbModel124 = this.elO.ejZ;
                    if (pbModel124 != null) {
                        pbModel125 = this.elO.ejZ;
                        if (pbModel125.getPbData() != null && this.elO.aKj().aMI() != null && postData3.getAuthor() != null && postData3.bhD() != 1 && this.elO.checkUpIsLogin()) {
                            com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                            pbModel126 = this.elO.ejZ;
                            jVar.b(pbModel126.getPbData().aJp());
                            pbModel127 = this.elO.ejZ;
                            jVar.h(pbModel127.getPbData().aJq());
                            jVar.b(postData3);
                            this.elO.aKj().aMI().c(jVar);
                            this.elO.aKj().aMI().setPostId(postData3.getId());
                            this.elO.a(view, postData3.getAuthor().getUserId(), "");
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
        faVar = this.elO.ekM;
        if (view == faVar.getNextView()) {
            pbModel123 = this.elO.ejZ;
            if (pbModel123.ip(true)) {
                faVar102 = this.elO.ekM;
                faVar102.aNd();
                return;
            }
            return;
        }
        faVar2 = this.elO.ekM;
        if (view == faVar2.aMO()) {
            faVar100 = this.elO.ekM;
            faVar100.aMU();
            if (UtilHelper.isFloatWindowOpAllowed(this.elO.getPageContext().getPageActivity())) {
                this.elO.ekS = true;
                PbActivity pbActivity = this.elO;
                pbModel121 = this.elO.ejZ;
                pbActivity.a(pbModel121.getPbData(), 0, 1, true, true);
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10830");
                pbModel122 = this.elO.ejZ;
                TiebaStatic.log(asVar.Z("tid", pbModel122.getThreadID()));
                faVar101 = this.elO.ekM;
                faVar101.awO();
                return;
            }
            this.elO.aKn();
            return;
        }
        faVar3 = this.elO.ekM;
        if (faVar3.eqM.aNQ() != null) {
            faVar96 = this.elO.ekM;
            if (view == faVar96.eqM.aNQ().aMo()) {
                if (com.baidu.adp.lib.util.i.he()) {
                    faVar97 = this.elO.ekM;
                    faVar97.awO();
                    this.elO.YT();
                    faVar98 = this.elO.ekM;
                    faVar98.aNc();
                    faVar99 = this.elO.ekM;
                    faVar99.auC();
                    pbModel120 = this.elO.ejZ;
                    pbModel120.oj(1);
                    return;
                }
                this.elO.showToast(w.l.network_not_available);
                return;
            }
        }
        faVar4 = this.elO.ekM;
        if (view == faVar4.eqM.aIg) {
            faVar95 = this.elO.ekM;
            pbModel119 = this.elO.ejZ;
            if (!faVar95.iP(pbModel119.aLy())) {
                this.elO.ekt = false;
                this.elO.finish();
                return;
            }
            this.elO.YT();
            return;
        }
        faVar5 = this.elO.ekM;
        if (view != faVar5.aNa()) {
            faVar14 = this.elO.ekM;
            if (faVar14.eqM.aNQ() != null) {
                faVar93 = this.elO.ekM;
                if (view != faVar93.eqM.aNQ().aMn()) {
                    faVar94 = this.elO.ekM;
                }
            }
            faVar15 = this.elO.ekM;
            if (view == faVar15.aNr()) {
                pbModel117 = this.elO.ejZ;
                if (pbModel117 != null) {
                    pbModel118 = this.elO.ejZ;
                    com.baidu.tbadk.browser.f.O(this.elO.getPageContext().getPageActivity(), pbModel118.getPbData().aJq().rQ().getLink());
                    return;
                }
                return;
            }
            faVar16 = this.elO.ekM;
            if (view != faVar16.eqM.euc) {
                faVar17 = this.elO.ekM;
                if (view == faVar17.eqM.eue) {
                    pbModel103 = this.elO.ejZ;
                    if (pbModel103 != null) {
                        pbModel104 = this.elO.ejZ;
                        if (pbModel104.getPbData() != null) {
                            pbModel105 = this.elO.ejZ;
                            ArrayList<PostData> aJs = pbModel105.getPbData().aJs();
                            if (aJs == null || aJs.size() <= 0) {
                                pbModel106 = this.elO.ejZ;
                                if (pbModel106.aLu()) {
                                    com.baidu.adp.lib.util.k.showToast(this.elO.getPageContext().getPageActivity(), this.elO.getPageContext().getString(w.l.pb_no_data_tips));
                                    return;
                                }
                            }
                            faVar91 = this.elO.ekM;
                            faVar91.aMK();
                            faVar92 = this.elO.ekM;
                            faVar92.aNv();
                            this.elO.aKq();
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.k.showToast(this.elO.getPageContext().getPageActivity(), this.elO.getPageContext().getString(w.l.pb_no_data_tips));
                    return;
                }
                faVar18 = this.elO.ekM;
                if (view != faVar18.eqM.eud && view.getId() != w.h.pb_god_user_tip_content) {
                    faVar25 = this.elO.ekM;
                    if (faVar25.eqM.aNQ() != null) {
                        faVar88 = this.elO.ekM;
                        if (view == faVar88.eqM.aNQ().aLW()) {
                            if (com.baidu.adp.lib.util.i.he()) {
                                faVar89 = this.elO.ekM;
                                faVar89.awO();
                                oe = this.elO.oe(11009);
                                if (oe) {
                                    pbModel102 = this.elO.ejZ;
                                    faVar90 = this.elO.ekM;
                                    if (pbModel102.op(faVar90.aNh()) == null) {
                                        return;
                                    }
                                    this.elO.aKw();
                                    return;
                                }
                                return;
                            }
                            this.elO.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    faVar26 = this.elO.ekM;
                    if (faVar26.eqM.aNQ() != null) {
                        faVar80 = this.elO.ekM;
                        if (view == faVar80.eqM.aNQ().aMk()) {
                            if (com.baidu.adp.lib.util.i.he()) {
                                faVar81 = this.elO.ekM;
                                faVar81.awO();
                                faVar82 = this.elO.ekM;
                                faVar82.aMK();
                                z8 = this.elO.mIsLoading;
                                if (!z8) {
                                    this.elO.mIsLoading = true;
                                    faVar83 = this.elO.ekM;
                                    faVar83.eqM.eud.setEnabled(false);
                                    faVar84 = this.elO.ekM;
                                    faVar84.arz();
                                    this.elO.YT();
                                    faVar85 = this.elO.ekM;
                                    faVar85.aNc();
                                    pbModel101 = this.elO.ejZ;
                                    aKB2 = this.elO.aKB();
                                    pbModel101.nu(aKB2);
                                    TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    faVar86 = this.elO.ekM;
                                    faVar86.aNv();
                                    faVar87 = this.elO.ekM;
                                    faVar87.aLp();
                                    this.elO.of(2);
                                    return;
                                }
                                return;
                            }
                            this.elO.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    faVar27 = this.elO.ekM;
                    if (faVar27.eqM.aNQ() != null) {
                        faVar77 = this.elO.ekM;
                        if (view != faVar77.eqM.aNQ().getCancelView()) {
                            faVar79 = this.elO.ekM;
                        }
                        faVar78 = this.elO.ekM;
                        faVar78.eqM.ol();
                        return;
                    }
                    faVar28 = this.elO.ekM;
                    if (faVar28.eqM.aNQ() != null) {
                        faVar75 = this.elO.ekM;
                        if (view == faVar75.eqM.aNQ().aMj()) {
                            if (this.elO.checkUpIsLogin()) {
                                faVar76 = this.elO.ekM;
                                faVar76.awO();
                                this.elO.YT();
                                this.elO.of(2);
                                pbModel96 = this.elO.ejZ;
                                if (pbModel96 != null) {
                                    pbModel97 = this.elO.ejZ;
                                    if (pbModel97.getPbData() != null) {
                                        pbModel98 = this.elO.ejZ;
                                        if (pbModel98.getPbData().aJH() != null) {
                                            pbModel99 = this.elO.ejZ;
                                            if (!StringUtils.isNull(pbModel99.getPbData().aJH().qd(), true)) {
                                                com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11678");
                                                pbModel100 = this.elO.ejZ;
                                                TiebaStatic.log(asVar2.Z("fid", pbModel100.getPbData().getForumId()));
                                            }
                                        }
                                    }
                                }
                                this.elO.aqX();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11939"));
                                return;
                            }
                            return;
                        }
                    }
                    faVar29 = this.elO.ekM;
                    if (faVar29.eqM.aNQ() != null) {
                        faVar72 = this.elO.ekM;
                        if (view == faVar72.eqM.aNQ().aMe()) {
                            faVar73 = this.elO.ekM;
                            faVar73.awO();
                            pbModel94 = this.elO.ejZ;
                            if (pbModel94.ama() != null) {
                                faVar74 = this.elO.ekM;
                                pbModel95 = this.elO.ejZ;
                                faVar74.a(pbModel95.ama(), this.elO.dVF);
                            }
                            TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    faVar30 = this.elO.ekM;
                    if (faVar30.eqM.aNQ() != null) {
                        faVar69 = this.elO.ekM;
                        if (view == faVar69.eqM.aNQ().aMf()) {
                            faVar70 = this.elO.ekM;
                            faVar70.awO();
                            this.elO.of(2);
                            this.elO.YT();
                            faVar71 = this.elO.ekM;
                            faVar71.aNc();
                            pbModel93 = this.elO.ejZ;
                            pbModel93.aLE();
                            TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                            return;
                        }
                    }
                    faVar31 = this.elO.ekM;
                    if (faVar31.eqM.aNQ() != null) {
                        faVar67 = this.elO.ekM;
                        if (view == faVar67.eqM.aNQ().aMg()) {
                            pbModel89 = this.elO.ejZ;
                            if (pbModel89 != null) {
                                pbModel90 = this.elO.ejZ;
                                if (pbModel90.getPbData() != null) {
                                    pbModel91 = this.elO.ejZ;
                                    if (pbModel91.getPbData().aJq() != null) {
                                        faVar68 = this.elO.ekM;
                                        faVar68.eqM.ol();
                                        PbActivity pbActivity2 = this.elO;
                                        pbModel92 = this.elO.ejZ;
                                        pbActivity2.np(pbModel92.getPbData().aJq().sg());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    faVar32 = this.elO.ekM;
                    if (faVar32.eqM.aNQ() != null) {
                        faVar63 = this.elO.ekM;
                        if (view == faVar63.eqM.aNQ().aMh()) {
                            TiebaStatic.log("c10414");
                            faVar64 = this.elO.ekM;
                            faVar64.awO();
                            faVar65 = this.elO.ekM;
                            if (faVar65.rE() != fa.esv) {
                                pbModel87 = this.elO.ejZ;
                                if (pbModel87.aLS() != null) {
                                    pbModel88 = this.elO.ejZ;
                                    pbModel88.aLS().oi(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                    return;
                                }
                                return;
                            }
                            faVar66 = this.elO.ekM;
                            faVar66.aNz();
                            return;
                        }
                    }
                    faVar33 = this.elO.ekM;
                    if (faVar33.eqM.aNQ() != null) {
                        faVar60 = this.elO.ekM;
                        if (view == faVar60.eqM.aNQ().aMi()) {
                            aKo = this.elO.aKo();
                            this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.elO.getPageContext().getPageActivity(), null, aKo, true)));
                            faVar61 = this.elO.ekM;
                            faVar61.eqM.ol();
                            faVar62 = this.elO.ekM;
                            faVar62.eqM.aNQ().aMq();
                            return;
                        }
                    }
                    drVar = this.elO.ekR;
                    if (drVar != null) {
                        drVar48 = this.elO.ekR;
                        if (view == drVar48.aLY()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                            if (!com.baidu.adp.lib.util.i.he()) {
                                this.elO.showToast(w.l.network_not_available);
                                return;
                            }
                            Object tag = view.getTag();
                            if (!(tag instanceof String)) {
                                if (tag instanceof SparseArray) {
                                    SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                    if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                        sparseArray2.put(w.h.tag_from, 0);
                                        sparseArray2.put(w.h.tag_check_mute_from, 2);
                                        this.elO.d(sparseArray2);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            this.elO.np((String) tag);
                            return;
                        }
                    }
                    drVar2 = this.elO.ekR;
                    if (drVar2 != null) {
                        drVar47 = this.elO.ekR;
                        if (view == drVar47.aLW()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                            if (!this.elO.checkUpIsLogin()) {
                                return;
                            }
                            this.elO.aY(view);
                            return;
                        }
                    }
                    drVar3 = this.elO.ekR;
                    if (drVar3 != null) {
                        drVar45 = this.elO.ekR;
                        if (view == drVar45.aMb()) {
                            drVar46 = this.elO.ekR;
                            if (drVar46.aMd()) {
                                com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c12007");
                                pbModel86 = this.elO.ejZ;
                                TiebaStatic.log(asVar3.Z("tid", pbModel86.enb));
                            } else {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                            }
                            if (this.elO.checkUpIsLogin()) {
                                pbModel81 = this.elO.ejZ;
                                if (pbModel81.getPbData() != null) {
                                    faVar59 = this.elO.ekM;
                                    faVar59.awO();
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
                                        pbModel82 = this.elO.ejZ;
                                        String threadID = pbModel82.getThreadID();
                                        String id2 = postData2.getId();
                                        int i2 = 0;
                                        pbModel83 = this.elO.ejZ;
                                        if (pbModel83.getPbData() != null) {
                                            pbModel85 = this.elO.ejZ;
                                            i2 = pbModel85.getPbData().aJA();
                                        }
                                        this.elO.YT();
                                        ns4 = this.elO.ns(id2);
                                        if (ns4 != null) {
                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.elO.getPageContext().getPageActivity());
                                            SmallTailInfo aOS = postData2.aOS();
                                            pbModel84 = this.elO.ejZ;
                                            this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, aOS, pbModel84.getPbData().qE(), false, postData2.getAuthor().getIconInfo()).addBigImageData(ns4.emf, ns4.emg, ns4.emh, ns4.index)));
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
                    drVar4 = this.elO.ekR;
                    if (drVar4 != null) {
                        drVar44 = this.elO.ekR;
                        if (view == drVar44.aLZ()) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3 != null && (sparseArray3.get(w.h.tag_del_post_type) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_id) instanceof String) && (sparseArray3.get(w.h.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray3.get(w.h.tag_del_post_is_self)).booleanValue();
                                int intValue = ((Integer) sparseArray3.get(w.h.tag_manage_user_identity)).intValue();
                                if (!booleanValue && intValue != 0 && com.baidu.tieba.c.a.RO()) {
                                    Context baseContext = this.elO.getBaseContext();
                                    pbModel80 = this.elO.ejZ;
                                    if (com.baidu.tieba.c.a.h(baseContext, pbModel80.getThreadID(), (String) sparseArray3.get(w.h.tag_del_post_id))) {
                                        return;
                                    }
                                }
                                faVar58 = this.elO.ekM;
                                faVar58.a(((Integer) sparseArray3.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray3.get(w.h.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                            return;
                        }
                    }
                    drVar5 = this.elO.ekR;
                    if (drVar5 != null) {
                        drVar43 = this.elO.ekR;
                        if (view == drVar43.aMa()) {
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
                            pbModel79 = this.elO.ejZ;
                            com.baidu.tieba.pb.data.f pbData = pbModel79.getPbData();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            if (pbData != null && pbData.aJp() != null) {
                                str3 = pbData.aJp().getId();
                                str4 = pbData.aJp().getName();
                                str5 = pbData.getThreadId();
                            }
                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                            this.elO.a(j, str2, str3, str4, str5, i3);
                            return;
                        }
                    }
                    faVar34 = this.elO.ekM;
                    if (faVar34.aNA() == view) {
                        faVar57 = this.elO.ekM;
                        if (faVar57.aNA().getIndicateStatus()) {
                            pbModel78 = this.elO.ejZ;
                            com.baidu.tieba.pb.data.f pbData2 = pbModel78.getPbData();
                            if (pbData2 != null && pbData2.aJq() != null && pbData2.aJq().rz() != null) {
                                String pD = pbData2.aJq().rz().pD();
                                if (StringUtils.isNull(pD)) {
                                    pD = pbData2.aJq().rz().getTaskId();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11107").Z("obj_id", pD));
                            }
                        } else {
                            com.baidu.tieba.tbadkCore.d.a.ca("c10725", null);
                        }
                        this.elO.aKI();
                        return;
                    }
                    faVar35 = this.elO.ekM;
                    if (faVar35.aMW() != view) {
                        drVar6 = this.elO.ekR;
                        if (drVar6 != null) {
                            drVar42 = this.elO.ekR;
                            if (view == drVar42.aLX()) {
                                if (!com.baidu.adp.lib.util.i.he()) {
                                    this.elO.showToast(w.l.network_not_available);
                                    return;
                                }
                                SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                if (sparseArray4 != null) {
                                    if (com.baidu.tieba.c.a.RO() && sparseArray4.get(w.h.tag_del_post_id) != null) {
                                        Context baseContext2 = this.elO.getBaseContext();
                                        pbModel76 = this.elO.ejZ;
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
                                            this.elO.d(sparseArray4);
                                            return;
                                        }
                                        sparseArray4.put(w.h.tag_check_mute_from, 2);
                                        faVar56 = this.elO.ekM;
                                        faVar56.bc(view);
                                        return;
                                    } else if (booleanValue3) {
                                        faVar55 = this.elO.ekM;
                                        faVar55.a(((Integer) sparseArray4.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray4.get(w.h.tag_del_post_id), ((Integer) sparseArray4.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(w.h.tag_del_post_is_self)).booleanValue());
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        faVar36 = this.elO.ekM;
                        if (view != faVar36.aLq()) {
                            faVar37 = this.elO.ekM;
                            if (faVar37.eqM.aNQ() != null) {
                                faVar49 = this.elO.ekM;
                                if (view == faVar49.eqM.aNQ().aMp()) {
                                    if (com.baidu.adp.lib.util.i.he()) {
                                        faVar50 = this.elO.ekM;
                                        faVar50.awO();
                                        faVar51 = this.elO.ekM;
                                        pbModel66 = this.elO.ejZ;
                                        com.baidu.tieba.pb.data.f pbData3 = pbModel66.getPbData();
                                        pbModel67 = this.elO.ejZ;
                                        SparseArray<Object> c = faVar51.c(pbData3, pbModel67.aLu(), 1);
                                        if (c != null) {
                                            pbModel68 = this.elO.ejZ;
                                            PbActivity pbActivity3 = this.elO;
                                            Activity pageActivity = this.elO.getPageContext().getPageActivity();
                                            pbModel69 = this.elO.ejZ;
                                            String id3 = pbModel69.getPbData().aJp().getId();
                                            pbModel70 = this.elO.ejZ;
                                            String name2 = pbModel70.getPbData().aJp().getName();
                                            pbModel71 = this.elO.ejZ;
                                            pbActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, pbModel71.getPbData().aJq().getId(), String.valueOf(pbModel68.getPbData().getUserData().getUserId()), (String) c.get(w.h.tag_forbid_user_name), (String) c.get(w.h.tag_forbid_user_post_id))));
                                            return;
                                        }
                                        return;
                                    }
                                    this.elO.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            faVar38 = this.elO.ekM;
                            if (faVar38.eqM.aNQ() != null) {
                                faVar45 = this.elO.ekM;
                                if (view == faVar45.eqM.aNQ().aMm()) {
                                    if (com.baidu.adp.lib.util.i.he()) {
                                        faVar46 = this.elO.ekM;
                                        pbModel64 = this.elO.ejZ;
                                        com.baidu.tieba.pb.data.f pbData4 = pbModel64.getPbData();
                                        pbModel65 = this.elO.ejZ;
                                        SparseArray<Object> c2 = faVar46.c(pbData4, pbModel65.aLu(), 1);
                                        if (c2 != null) {
                                            faVar48 = this.elO.ekM;
                                            faVar48.a(((Integer) c2.get(w.h.tag_del_post_type)).intValue(), (String) c2.get(w.h.tag_del_post_id), ((Integer) c2.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(w.h.tag_del_post_is_self)).booleanValue());
                                        }
                                        faVar47 = this.elO.ekM;
                                        faVar47.eqM.ol();
                                        return;
                                    }
                                    this.elO.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            if (view.getId() != w.h.sub_pb_more && view.getId() != w.h.sub_pb_item) {
                                faVar40 = this.elO.ekM;
                                if (view != faVar40.aKe()) {
                                    faVar41 = this.elO.ekM;
                                    if (view == faVar41.eqM.aNR()) {
                                        faVar44 = this.elO.ekM;
                                        faVar44.aNk();
                                        return;
                                    }
                                    int id4 = view.getId();
                                    if (id4 == w.h.pb_u9_text_view) {
                                        if (this.elO.checkUpIsLogin() && (bpVar = (com.baidu.tbadk.core.data.bp) view.getTag()) != null && !StringUtils.isNull(bpVar.th())) {
                                            TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                            com.baidu.tbadk.core.util.bb.vQ().c(this.elO.getPageContext(), new String[]{bpVar.th()});
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.pb_floor_agree && (view instanceof PbFloorAgreeView)) {
                                        if (this.elO.checkUpIsLogin() && (postData = (PostData) view.getTag(w.h.tag_clip_board)) != null) {
                                            if (postData.bhR()) {
                                                postData.cB(postData.bhQ() - 1);
                                            } else {
                                                postData.cB(postData.bhQ() + 1);
                                            }
                                            postData.lh(!postData.bhR());
                                            ((PbFloorAgreeView) view).a(postData.bhR(), postData.bhQ(), true);
                                            pbModel58 = this.elO.ejZ;
                                            pbModel58.aLT().bL(postData.getId(), postData.bhR() ? "0" : "1");
                                            int i4 = 2;
                                            if (postData.getAuthor() != null && postData.getAuthor().getUserId() != null) {
                                                i4 = postData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) ? 1 : 2;
                                            }
                                            if (postData.bhR()) {
                                                com.baidu.tbadk.core.util.as asVar4 = new com.baidu.tbadk.core.util.as("c12003");
                                                pbModel60 = this.elO.ejZ;
                                                TiebaStatic.log(asVar4.Z("tid", pbModel60.enb).s("obj_id", i4));
                                                return;
                                            }
                                            com.baidu.tbadk.core.util.as asVar5 = new com.baidu.tbadk.core.util.as("c12008");
                                            pbModel59 = this.elO.ejZ;
                                            TiebaStatic.log(asVar5.Z("tid", pbModel59.enb).s("obj_id", i4));
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.replybtn || id4 == w.h.cover_reply_content || id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right) {
                                        drVar7 = this.elO.ekR;
                                        if (drVar7 == null) {
                                            this.elO.ekR = new dr(this.elO.getPageContext(), this.elO.bOI);
                                            drVar41 = this.elO.ekR;
                                            z7 = this.elO.mIsLogin;
                                            drVar41.it(z7);
                                        }
                                        drVar8 = this.elO.ekR;
                                        drVar8.showDialog();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11740"));
                                        PostData postData4 = null;
                                        if (view != null && view.getTag() != null) {
                                            postData4 = (PostData) ((SparseArray) view.getTag()).get(w.h.tag_load_sub_data);
                                            boolean z10 = id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right;
                                            if (z10) {
                                                com.baidu.tbadk.core.util.as asVar6 = new com.baidu.tbadk.core.util.as("c12006");
                                                pbModel24 = this.elO.ejZ;
                                                TiebaStatic.log(asVar6.Z("tid", pbModel24.enb));
                                            }
                                            SparseArray sparseArray5 = new SparseArray();
                                            sparseArray5.put(w.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(w.h.tag_clip_board));
                                            sparseArray5.put(w.h.tag_is_subpb, false);
                                            drVar13 = this.elO.ekR;
                                            drVar13.aLW().setTag(sparseArray5);
                                            drVar14 = this.elO.ekR;
                                            drVar14.aMb().setTag(view.getTag());
                                            drVar15 = this.elO.ekR;
                                            drVar15.iv(z10);
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
                                                    drVar40 = this.elO.ekR;
                                                    drVar40.aLZ().setVisibility(0);
                                                } else {
                                                    sparseArray7.put(w.h.tag_should_delete_visible, false);
                                                    drVar35 = this.elO.ekR;
                                                    drVar35.aLZ().setVisibility(8);
                                                }
                                                drVar36 = this.elO.ekR;
                                                drVar36.aLX().setTag(sparseArray7);
                                                drVar37 = this.elO.ekR;
                                                drVar37.aLZ().setTag(sparseArray7);
                                                drVar38 = this.elO.ekR;
                                                drVar38.aLX().setText(w.l.bar_manager);
                                                drVar39 = this.elO.ekR;
                                                drVar39.aLX().setVisibility(0);
                                            } else if (!booleanValue7) {
                                                drVar16 = this.elO.ekR;
                                                drVar16.aLX().setVisibility(8);
                                                drVar17 = this.elO.ekR;
                                                drVar17.aLZ().setVisibility(8);
                                            } else {
                                                SparseArray sparseArray8 = new SparseArray();
                                                sparseArray8.put(w.h.tag_should_manage_visible, false);
                                                sparseArray8.put(w.h.tag_user_mute_visible, false);
                                                sparseArray8.put(w.h.tag_should_delete_visible, true);
                                                sparseArray8.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                sparseArray8.put(w.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                sparseArray8.put(w.h.tag_del_post_id, sparseArray6.get(w.h.tag_del_post_id));
                                                sparseArray8.put(w.h.tag_del_post_type, sparseArray6.get(w.h.tag_del_post_type));
                                                drVar18 = this.elO.ekR;
                                                drVar18.aLX().setTag(sparseArray8);
                                                drVar19 = this.elO.ekR;
                                                drVar19.aLZ().setTag(sparseArray8);
                                                drVar20 = this.elO.ekR;
                                                drVar20.aLX().setText(w.l.delete);
                                                drVar21 = this.elO.ekR;
                                                drVar21.aLZ().setVisibility(0);
                                                drVar22 = this.elO.ekR;
                                                drVar22.aLX().setVisibility(8);
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
                                                drVar31 = this.elO.ekR;
                                                drVar31.aLY().setTag(sparseArray10);
                                                drVar32 = this.elO.ekR;
                                                drVar32.aLY().setVisibility(0);
                                                drVar33 = this.elO.ekR;
                                                drVar33.aLX().setVisibility(8);
                                                drVar34 = this.elO.ekR;
                                                drVar34.aLY().setText(w.l.mute_option);
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
                                                ij = this.elO.ij(z5);
                                                boolean isLogin = ij & this.elO.isLogin();
                                                this.elO.elE = (PostData) sparseArray9.get(w.h.tag_clip_board);
                                                if (ez.g(this.elO.elE) ? false : isLogin) {
                                                    drVar24 = this.elO.ekR;
                                                    drVar24.aLY().setVisibility(0);
                                                    drVar25 = this.elO.ekR;
                                                    drVar25.aLY().setTag(str7);
                                                } else {
                                                    drVar23 = this.elO.ekR;
                                                    drVar23.aLY().setVisibility(8);
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
                                                drVar27 = this.elO.ekR;
                                                drVar27.aMa().setVisibility(0);
                                                drVar28 = this.elO.ekR;
                                                drVar28.aMa().setTag(w.h.tag_chudian_template_id, Long.valueOf(j2));
                                                drVar29 = this.elO.ekR;
                                                drVar29.aMa().setTag(w.h.tag_chudian_monitor_id, str);
                                                drVar30 = this.elO.ekR;
                                                drVar30.aMa().setTag(w.h.tag_chudian_hide_day, Integer.valueOf(i));
                                            } else {
                                                drVar26 = this.elO.ekR;
                                                drVar26.aMa().setVisibility(8);
                                            }
                                        }
                                        pbModel22 = this.elO.ejZ;
                                        if (pbModel22.getPbData().nH()) {
                                            pbModel23 = this.elO.ejZ;
                                            String nG = pbModel23.getPbData().nG();
                                            if (postData4 != null && !com.baidu.adp.lib.util.j.isEmpty(nG) && nG.equals(postData4.getId())) {
                                                z2 = true;
                                                if (!z2) {
                                                    drVar12 = this.elO.ekR;
                                                    drVar12.aLW().setText(w.l.remove_mark);
                                                } else {
                                                    drVar9 = this.elO.ekR;
                                                    drVar9.aLW().setText(w.l.mark);
                                                }
                                                drVar10 = this.elO.ekR;
                                                drVar10.iu(true);
                                                drVar11 = this.elO.ekR;
                                                drVar11.wk();
                                                return;
                                            }
                                        }
                                        z2 = false;
                                        if (!z2) {
                                        }
                                        drVar10 = this.elO.ekR;
                                        drVar10.iu(true);
                                        drVar11 = this.elO.ekR;
                                        drVar11.wk();
                                        return;
                                    } else if (id4 == w.h.pb_act_btn) {
                                        pbModel52 = this.elO.ejZ;
                                        if (pbModel52.getPbData() != null) {
                                            pbModel53 = this.elO.ejZ;
                                            if (pbModel53.getPbData().aJq() != null) {
                                                pbModel54 = this.elO.ejZ;
                                                if (pbModel54.getPbData().aJq().sw() != null) {
                                                    Activity activity = this.elO.getActivity();
                                                    pbModel55 = this.elO.ejZ;
                                                    com.baidu.tbadk.browser.f.O(activity, pbModel55.getPbData().aJq().sw());
                                                    pbModel56 = this.elO.ejZ;
                                                    if (pbModel56.getPbData().aJq().su() != 1) {
                                                        pbModel57 = this.elO.ejZ;
                                                        if (pbModel57.getPbData().aJq().su() == 2) {
                                                            TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                            pbModel49 = this.elO.ejZ;
                                            com.baidu.tbadk.core.util.as Z = asVar7.Z("fid", pbModel49.getPbData().getForumId());
                                            pbModel50 = this.elO.ejZ;
                                            TiebaStatic.log(Z.Z("tid", pbModel50.getPbData().getThreadId()).Z("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                            pbModel51 = this.elO.ejZ;
                                            if (pbModel51.getPbData().getThreadId().equals(str8)) {
                                                faVar43 = this.elO.ekM;
                                                faVar43.setSelection(0);
                                                return;
                                            }
                                            this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.elO.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.pb_item_tail_content) {
                                        if (com.baidu.tbadk.core.util.bg.aI(this.elO.getPageContext().getPageActivity())) {
                                            String string = TbadkCoreApplication.m9getInst().getString(w.l.tail_web_view_title);
                                            String string2 = com.baidu.tbadk.core.sharedPref.b.uo().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                TiebaStatic.log("c10056");
                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                            }
                                            faVar42 = this.elO.ekM;
                                            faVar42.aMK();
                                            return;
                                        }
                                        return;
                                    } else if (id4 == w.h.join_vote_tv) {
                                        if (view != null) {
                                            com.baidu.tbadk.browser.f.O(this.elO.getActivity(), (String) view.getTag());
                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                            aKp3 = this.elO.aKp();
                                            if (aKp3 == 1) {
                                                pbModel45 = this.elO.ejZ;
                                                if (pbModel45 != null) {
                                                    pbModel46 = this.elO.ejZ;
                                                    if (pbModel46.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar8 = new com.baidu.tbadk.core.util.as("c10397");
                                                        pbModel47 = this.elO.ejZ;
                                                        com.baidu.tbadk.core.util.as Z2 = asVar8.Z("fid", pbModel47.getPbData().getForumId());
                                                        pbModel48 = this.elO.ejZ;
                                                        TiebaStatic.log(Z2.Z("tid", pbModel48.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aKp4 = this.elO.aKp();
                                            if (aKp4 == 2) {
                                                pbModel41 = this.elO.ejZ;
                                                if (pbModel41 != null) {
                                                    pbModel42 = this.elO.ejZ;
                                                    if (pbModel42.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar9 = new com.baidu.tbadk.core.util.as("c10401");
                                                        pbModel43 = this.elO.ejZ;
                                                        com.baidu.tbadk.core.util.as Z3 = asVar9.Z("fid", pbModel43.getPbData().getForumId());
                                                        pbModel44 = this.elO.ejZ;
                                                        TiebaStatic.log(Z3.Z("tid", pbModel44.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
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
                                            com.baidu.tbadk.browser.f.O(this.elO.getActivity(), (String) view.getTag());
                                            aKp = this.elO.aKp();
                                            if (aKp == 1) {
                                                pbModel37 = this.elO.ejZ;
                                                if (pbModel37 != null) {
                                                    pbModel38 = this.elO.ejZ;
                                                    if (pbModel38.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar10 = new com.baidu.tbadk.core.util.as("c10507");
                                                        pbModel39 = this.elO.ejZ;
                                                        com.baidu.tbadk.core.util.as Z4 = asVar10.Z("fid", pbModel39.getPbData().getForumId());
                                                        pbModel40 = this.elO.ejZ;
                                                        TiebaStatic.log(Z4.Z("tid", pbModel40.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount2));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            aKp2 = this.elO.aKp();
                                            if (aKp2 == 2) {
                                                pbModel33 = this.elO.ejZ;
                                                if (pbModel33 != null) {
                                                    pbModel34 = this.elO.ejZ;
                                                    if (pbModel34.getPbData() != null) {
                                                        com.baidu.tbadk.core.util.as asVar11 = new com.baidu.tbadk.core.util.as("c10508");
                                                        pbModel35 = this.elO.ejZ;
                                                        com.baidu.tbadk.core.util.as Z5 = asVar11.Z("fid", pbModel35.getPbData().getForumId());
                                                        pbModel36 = this.elO.ejZ;
                                                        TiebaStatic.log(Z5.Z("tid", pbModel36.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount2));
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
                                                pbModel29 = this.elO.ejZ;
                                                if (pbModel29 != null) {
                                                    pbModel30 = this.elO.ejZ;
                                                    if (pbModel30.getPbData() != null) {
                                                        pbModel31 = this.elO.ejZ;
                                                        if (pbModel31.getPbData().aJH() != null) {
                                                            pbModel32 = this.elO.ejZ;
                                                            com.baidu.tieba.pb.data.f pbData5 = pbModel32.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11679").Z("fid", pbData5.getForumId()));
                                                            com.baidu.tbadk.core.util.bb.vQ().c(this.elO.getPageContext(), new String[]{pbData5.aJH().aJK()});
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.yule_head_img_all_rank) {
                                                pbModel25 = this.elO.ejZ;
                                                if (pbModel25 != null) {
                                                    pbModel26 = this.elO.ejZ;
                                                    if (pbModel26.getPbData() != null) {
                                                        pbModel27 = this.elO.ejZ;
                                                        if (pbModel27.getPbData().aJH() != null) {
                                                            pbModel28 = this.elO.ejZ;
                                                            com.baidu.tieba.pb.data.f pbData6 = pbModel28.getPbData();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11678").Z("fid", pbData6.getForumId()));
                                                            com.baidu.tbadk.core.util.bb.vQ().c(this.elO.getPageContext(), new String[]{pbData6.aJH().aJK()});
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
                                        this.elO.aKE();
                                        return;
                                    } else {
                                        this.elO.aKD();
                                        return;
                                    }
                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                    long c3 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                    pbModel61 = this.elO.ejZ;
                                    long c4 = com.baidu.adp.lib.g.b.c(pbModel61.getPbData().getForumId(), 0L);
                                    pbModel62 = this.elO.ejZ;
                                    long c5 = com.baidu.adp.lib.g.b.c(pbModel62.getThreadID(), 0L);
                                    pbModel63 = this.elO.ejZ;
                                    this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.elO.getPageContext().getPageActivity(), 24008, c4, c5, c3, pbModel63.getPbData().aJq().sk())));
                                    return;
                                } else {
                                    return;
                                }
                            } else if (this.elO.checkUpIsLogin()) {
                                pbModel7 = this.elO.ejZ;
                                if (pbModel7.getPbData() != null) {
                                    faVar39 = this.elO.ekM;
                                    faVar39.awO();
                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                    PostData postData5 = (PostData) sparseArray12.get(w.h.tag_load_sub_data);
                                    View view2 = (View) sparseArray12.get(w.h.tag_load_sub_view);
                                    if (postData5 != null && view2 != null) {
                                        pbModel8 = this.elO.ejZ;
                                        String threadID2 = pbModel8.getThreadID();
                                        String id5 = postData5.getId();
                                        int i5 = 0;
                                        pbModel9 = this.elO.ejZ;
                                        if (pbModel9.getPbData() != null) {
                                            pbModel20 = this.elO.ejZ;
                                            i5 = pbModel20.getPbData().aJA();
                                        }
                                        this.elO.YT();
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
                                                ns2 = this.elO.ns(id5);
                                                if (postData5 != null) {
                                                    pbModel13 = this.elO.ejZ;
                                                    if (pbModel13 != null) {
                                                        pbModel14 = this.elO.ejZ;
                                                        if (pbModel14.getPbData() != null && ns2 != null && this.elO.aKj().aMI() != null) {
                                                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                                                            pbModel15 = this.elO.ejZ;
                                                            jVar2.b(pbModel15.getPbData().aJp());
                                                            pbModel16 = this.elO.ejZ;
                                                            jVar2.h(pbModel16.getPbData().aJq());
                                                            jVar2.b(postData6);
                                                            this.elO.aKj().aMI().c(jVar2);
                                                            this.elO.aKj().aMI().setPostId(str11);
                                                            this.elO.a(view, str10, str9);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            TiebaStatic.log("c11742");
                                            ns = this.elO.ns(id5);
                                            if (postData5 != null) {
                                                pbModel10 = this.elO.ejZ;
                                                if (pbModel10 != null) {
                                                    pbModel11 = this.elO.ejZ;
                                                    if (pbModel11.getPbData() != null && ns != null) {
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.elO.getPageContext().getPageActivity());
                                                        SmallTailInfo aOS2 = postData5.aOS();
                                                        pbModel12 = this.elO.ejZ;
                                                        this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i5, aOS2, pbModel12.getPbData().qE(), false, postData5.getAuthor().getIconInfo()).addBigImageData(ns.emf, ns.emg, ns.emh, ns.index)));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        ns3 = this.elO.ns(id5);
                                        if (postData5 != null) {
                                            pbModel17 = this.elO.ejZ;
                                            if (pbModel17 != null) {
                                                pbModel18 = this.elO.ejZ;
                                                if (pbModel18.getPbData() != null && ns3 != null) {
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.elO.getPageContext().getPageActivity());
                                                    SmallTailInfo aOS3 = postData5.aOS();
                                                    pbModel19 = this.elO.ejZ;
                                                    this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i5, aOS3, pbModel19.getPbData().qE(), false, postData5.getAuthor().getIconInfo()).addBigImageData(ns3.emf, ns3.emg, ns3.emh, ns3.index)));
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
                                pbModel21 = this.elO.ejZ;
                                TiebaStatic.log(s.Z("fid", pbModel21.getPbData().getForumId()));
                                return;
                            }
                        } else if (this.elO.checkUpIsLogin()) {
                            faVar52 = this.elO.ekM;
                            if (!faVar52.aLn()) {
                                pbModel72 = this.elO.ejZ;
                                if (pbModel72 != null) {
                                    pbModel73 = this.elO.ejZ;
                                    if (pbModel73.aLQ() != null) {
                                        pbModel74 = this.elO.ejZ;
                                        if (pbModel74.aLQ().aLj() != null) {
                                            pbModel75 = this.elO.ejZ;
                                            if (com.baidu.tbadk.core.util.x.p(pbModel75.aLQ().aLj().getItems()) != 0) {
                                                faVar53 = this.elO.ekM;
                                                faVar53.aLo();
                                                return;
                                            }
                                            this.elO.showToast(w.l.graffiti_quick_vote_empty);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            faVar54 = this.elO.ekM;
                            faVar54.aLp();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.elO.checkUpIsLogin()) {
                        com.baidu.tbadk.core.util.as s2 = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
                        pbModel77 = this.elO.ejZ;
                        TiebaStatic.log(s2.Z("fid", pbModel77.getPbData().getForumId()));
                        return;
                    } else {
                        this.elO.aKg();
                        return;
                    }
                } else if (com.baidu.adp.lib.util.i.he()) {
                    faVar19 = this.elO.ekM;
                    faVar19.aMK();
                    z = this.elO.mIsLoading;
                    if (!z) {
                        this.elO.mIsLoading = true;
                        faVar20 = this.elO.ekM;
                        faVar20.eqM.eud.setEnabled(false);
                        faVar21 = this.elO.ekM;
                        faVar21.arz();
                        this.elO.YT();
                        faVar22 = this.elO.ekM;
                        faVar22.aNc();
                        pbModel6 = this.elO.ejZ;
                        aKB = this.elO.aKB();
                        pbModel6.nu(aKB);
                        TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        faVar23 = this.elO.ekM;
                        faVar23.aNv();
                        faVar24 = this.elO.ekM;
                        faVar24.aLp();
                        this.elO.of(2);
                        return;
                    }
                    return;
                } else {
                    this.elO.showToast(w.l.network_not_available);
                    return;
                }
            }
            TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            pbModel107 = this.elO.ejZ;
            if (pbModel107.getPbData() != null) {
                pbModel114 = this.elO.ejZ;
                if (pbModel114.getPbData().aJq() != null) {
                    pbModel115 = this.elO.ejZ;
                    if (pbModel115.getPbData().aJq().sD()) {
                        pbModel116 = this.elO.ejZ;
                        if (pbModel116.getPbData().aJq().sh() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11922"));
                        }
                    }
                }
            }
            pbModel108 = this.elO.ejZ;
            if (pbModel108.getErrorNo() == 4) {
                pbModel111 = this.elO.ejZ;
                if (StringUtils.isNull(pbModel111.aLt())) {
                    pbModel112 = this.elO.ejZ;
                    if (pbModel112.getAppealInfo() != null) {
                        pbModel113 = this.elO.ejZ;
                        name = pbModel113.getAppealInfo().forumName;
                    }
                }
                this.elO.finish();
                return;
            }
            pbModel109 = this.elO.ejZ;
            name = pbModel109.getPbData().aJp().getName();
            if (!StringUtils.isNull(name)) {
                pbModel110 = this.elO.ejZ;
                String aLt = pbModel110.aLt();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.elO.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                if (StringUtils.isNull(aLt)) {
                    this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                } else if (aLt.equals(name)) {
                    this.elO.finish();
                    return;
                } else {
                    this.elO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                }
            }
            this.elO.finish();
            return;
        }
        if (com.baidu.adp.lib.util.i.he()) {
            pbModel = this.elO.ejZ;
            if (pbModel.getPbData().aJA() == 1) {
                forumManageModel = this.elO.ekL;
                if (!forumManageModel.bip()) {
                    faVar6 = this.elO.ekM;
                    faVar6.awO();
                    int i6 = 0;
                    faVar7 = this.elO.ekM;
                    if (faVar7.eqM.aNQ() != null) {
                        faVar13 = this.elO.ekM;
                        if (view == faVar13.eqM.aNQ().aMl()) {
                            pbModel5 = this.elO.ejZ;
                            if (pbModel5.getPbData().aJq().rM() == 1) {
                                i6 = 5;
                            } else {
                                i6 = 4;
                            }
                            pbModel3 = this.elO.ejZ;
                            ForumData aJp = pbModel3.getPbData().aJp();
                            String name3 = aJp.getName();
                            String id6 = aJp.getId();
                            pbModel4 = this.elO.ejZ;
                            id = pbModel4.getPbData().aJq().getId();
                            if (com.baidu.tieba.c.a.RO() || !com.baidu.tieba.c.a.h(this.elO.getBaseContext(), id, null)) {
                                faVar11 = this.elO.ekM;
                                faVar11.aMZ();
                                forumManageModel2 = this.elO.ekL;
                                faVar12 = this.elO.ekM;
                                forumManageModel2.a(id6, name3, id, i6, faVar12.aNb());
                                return;
                            }
                            return;
                        }
                    }
                    faVar8 = this.elO.ekM;
                    if (faVar8.eqM.aNQ() != null) {
                        faVar10 = this.elO.ekM;
                        if (view == faVar10.eqM.aNQ().aMn()) {
                            pbModel2 = this.elO.ejZ;
                            if (pbModel2.getPbData().aJq().rN() == 1) {
                                i6 = 3;
                            } else {
                                i6 = 6;
                            }
                            pbModel3 = this.elO.ejZ;
                            ForumData aJp2 = pbModel3.getPbData().aJp();
                            String name32 = aJp2.getName();
                            String id62 = aJp2.getId();
                            pbModel4 = this.elO.ejZ;
                            id = pbModel4.getPbData().aJq().getId();
                            if (com.baidu.tieba.c.a.RO()) {
                            }
                            faVar11 = this.elO.ekM;
                            faVar11.aMZ();
                            forumManageModel2 = this.elO.ekL;
                            faVar12 = this.elO.ekM;
                            forumManageModel2.a(id62, name32, id, i6, faVar12.aNb());
                            return;
                        }
                    }
                    faVar9 = this.elO.ekM;
                    if (view == faVar9.aNa()) {
                        i6 = 2;
                    }
                    pbModel3 = this.elO.ejZ;
                    ForumData aJp22 = pbModel3.getPbData().aJp();
                    String name322 = aJp22.getName();
                    String id622 = aJp22.getId();
                    pbModel4 = this.elO.ejZ;
                    id = pbModel4.getPbData().aJq().getId();
                    if (com.baidu.tieba.c.a.RO()) {
                    }
                    faVar11 = this.elO.ekM;
                    faVar11.aMZ();
                    forumManageModel2 = this.elO.ekL;
                    faVar12 = this.elO.ekM;
                    forumManageModel2.a(id622, name322, id, i6, faVar12.aNb());
                    return;
                }
                return;
            }
            return;
        }
        this.elO.showToast(w.l.network_not_available);
    }
}
