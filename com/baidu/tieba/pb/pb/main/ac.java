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
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v148, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v152, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v190, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v31, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x07d6, code lost:
        if (r18 != r1.esG.aNz().aLG()) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x092f, code lost:
        if (r18 == r1.esG.aNz().Td()) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0ad6, code lost:
        if (r18 != r1.esG.aNz().aLC()) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0115, code lost:
        if (r1.esG.aNz().aW(r18) == false) goto L965;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x012d, code lost:
        if (r18.getId() != com.baidu.tieba.w.h.pb_item_tail_content) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0327, code lost:
        if (r18 == r1.esG.aNz().aLH()) goto L928;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:668:0x1d0c  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x1ec8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03d7  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        fx fxVar4;
        fx fxVar5;
        fx fxVar6;
        fx fxVar7;
        PbModel pbModel;
        ForumManageModel forumManageModel;
        fx fxVar8;
        fx fxVar9;
        fx fxVar10;
        fx fxVar11;
        fx fxVar12;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        String id;
        fx fxVar13;
        ForumManageModel forumManageModel2;
        fx fxVar14;
        fx fxVar15;
        PbModel pbModel5;
        fx fxVar16;
        fx fxVar17;
        fx fxVar18;
        fx fxVar19;
        fx fxVar20;
        fx fxVar21;
        fx fxVar22;
        boolean z;
        fx fxVar23;
        fx fxVar24;
        fx fxVar25;
        PbModel pbModel6;
        String aJW;
        fx fxVar26;
        fx fxVar27;
        fx fxVar28;
        fx fxVar29;
        fx fxVar30;
        fx fxVar31;
        fx fxVar32;
        fx fxVar33;
        fx fxVar34;
        el elVar;
        el elVar2;
        el elVar3;
        el elVar4;
        el elVar5;
        fx fxVar35;
        fx fxVar36;
        el elVar6;
        fx fxVar37;
        fx fxVar38;
        PbModel pbModel7;
        fx fxVar39;
        PbModel pbModel8;
        PbModel pbModel9;
        PbActivity.b nS;
        PbModel pbModel10;
        PbModel pbModel11;
        PbModel pbModel12;
        PbActivity.b nS2;
        PbModel pbModel13;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        PbActivity.b nS3;
        PbModel pbModel17;
        PbModel pbModel18;
        PbModel pbModel19;
        PbModel pbModel20;
        PbModel pbModel21;
        fx fxVar40;
        fx fxVar41;
        PostData postData;
        PbModel pbModel22;
        PbModel pbModel23;
        PbModel pbModel24;
        PbModel pbModel25;
        PbModel pbModel26;
        PbModel pbModel27;
        PbModel pbModel28;
        PbModel pbModel29;
        PbModel pbModel30;
        PbModel pbModel31;
        boolean z2;
        el elVar7;
        el elVar8;
        el elVar9;
        el elVar10;
        PbModel pbModel32;
        el elVar11;
        el elVar12;
        el elVar13;
        el elVar14;
        el elVar15;
        boolean z3;
        el elVar16;
        el elVar17;
        el elVar18;
        el elVar19;
        el elVar20;
        el elVar21;
        el elVar22;
        boolean z4;
        boolean z5;
        boolean ig;
        el elVar23;
        el elVar24;
        el elVar25;
        boolean z6;
        String str;
        int i;
        el elVar26;
        el elVar27;
        el elVar28;
        el elVar29;
        el elVar30;
        el elVar31;
        el elVar32;
        el elVar33;
        el elVar34;
        el elVar35;
        el elVar36;
        el elVar37;
        el elVar38;
        el elVar39;
        el elVar40;
        PbModel pbModel33;
        el elVar41;
        boolean z7;
        PbModel pbModel34;
        PbModel pbModel35;
        PbModel pbModel36;
        PbModel pbModel37;
        PbModel pbModel38;
        PbModel pbModel39;
        PbModel pbModel40;
        PbModel pbModel41;
        int aJJ;
        int aJJ2;
        PbModel pbModel42;
        PbModel pbModel43;
        PbModel pbModel44;
        PbModel pbModel45;
        PbModel pbModel46;
        PbModel pbModel47;
        PbModel pbModel48;
        PbModel pbModel49;
        int aJJ3;
        int aJJ4;
        PbModel pbModel50;
        PbModel pbModel51;
        PbModel pbModel52;
        PbModel pbModel53;
        PbModel pbModel54;
        PbModel pbModel55;
        PbModel pbModel56;
        PbModel pbModel57;
        fx fxVar42;
        PbModel pbModel58;
        PbModel pbModel59;
        PbModel pbModel60;
        fx fxVar43;
        PbModel pbModel61;
        PbModel pbModel62;
        PbModel pbModel63;
        PbModel pbModel64;
        PbModel pbModel65;
        PbModel pbModel66;
        com.baidu.tbadk.core.data.br brVar;
        fx fxVar44;
        PbModel pbModel67;
        PbModel pbModel68;
        PbModel pbModel69;
        fx fxVar45;
        fx fxVar46;
        PbModel pbModel70;
        PbModel pbModel71;
        fx fxVar47;
        fx fxVar48;
        fx fxVar49;
        fx fxVar50;
        fx fxVar51;
        PbModel pbModel72;
        PbModel pbModel73;
        PbModel pbModel74;
        PbModel pbModel75;
        PbModel pbModel76;
        PbModel pbModel77;
        el elVar42;
        fx fxVar52;
        fx fxVar53;
        PbModel pbModel78;
        PbModel pbModel79;
        fx fxVar54;
        PbModel pbModel80;
        el elVar43;
        PbModel pbModel81;
        el elVar44;
        fx fxVar55;
        PbModel pbModel82;
        el elVar45;
        el elVar46;
        PbModel pbModel83;
        fx fxVar56;
        SparseArray sparseArray;
        PostData postData2;
        PbModel pbModel84;
        PbModel pbModel85;
        PbActivity.b nS4;
        PbModel pbModel86;
        PbModel pbModel87;
        PbModel pbModel88;
        el elVar47;
        el elVar48;
        fx fxVar57;
        String aJI;
        fx fxVar58;
        fx fxVar59;
        fx fxVar60;
        fx fxVar61;
        fx fxVar62;
        PbModel pbModel89;
        PbModel pbModel90;
        fx fxVar63;
        fx fxVar64;
        PbModel pbModel91;
        PbModel pbModel92;
        PbModel pbModel93;
        fx fxVar65;
        PbModel pbModel94;
        fx fxVar66;
        fx fxVar67;
        fx fxVar68;
        PbModel pbModel95;
        int i2;
        int i3;
        PbModel pbModel96;
        fx fxVar69;
        fx fxVar70;
        fx fxVar71;
        PbModel pbModel97;
        fx fxVar72;
        PbModel pbModel98;
        fx fxVar73;
        fx fxVar74;
        PbModel pbModel99;
        fx fxVar75;
        fx fxVar76;
        PbModel pbModel100;
        PbModel pbModel101;
        PbModel pbModel102;
        PbModel pbModel103;
        PbModel pbModel104;
        fx fxVar77;
        fx fxVar78;
        fx fxVar79;
        fx fxVar80;
        fx fxVar81;
        boolean z8;
        fx fxVar82;
        fx fxVar83;
        PbModel pbModel105;
        String aJW2;
        boolean nU;
        PbModel pbModel106;
        String aJW3;
        fx fxVar84;
        PbModel pbModel107;
        String aJW4;
        fx fxVar85;
        fx fxVar86;
        fx fxVar87;
        fx fxVar88;
        fx fxVar89;
        fx fxVar90;
        boolean or;
        PbModel pbModel108;
        fx fxVar91;
        PbModel pbModel109;
        PbModel pbModel110;
        PbModel pbModel111;
        PbModel pbModel112;
        fx fxVar92;
        fx fxVar93;
        PbModel pbModel113;
        PbModel pbModel114;
        PbModel pbModel115;
        String name;
        PbModel pbModel116;
        PbModel pbModel117;
        PbModel pbModel118;
        PbModel pbModel119;
        PbModel pbModel120;
        PbModel pbModel121;
        PbModel pbModel122;
        PbModel pbModel123;
        PbModel pbModel124;
        PbModel pbModel125;
        fx fxVar94;
        fx fxVar95;
        fx fxVar96;
        PbModel pbModel126;
        fx fxVar97;
        fx fxVar98;
        fx fxVar99;
        fx fxVar100;
        PbModel pbModel127;
        fx fxVar101;
        PbModel pbModel128;
        PbModel pbModel129;
        fx fxVar102;
        boolean z9;
        PbModel pbModel130;
        fx fxVar103;
        PbModel pbModel131;
        PbModel pbModel132;
        PbModel pbModel133;
        fx fxVar104;
        boolean z10;
        PbModel pbModel134;
        PbModel pbModel135;
        PbModel pbModel136;
        PbModel pbModel137;
        if (view != null) {
            if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                z10 = this.enc.elI;
                if (z10) {
                    this.enc.elI = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(w.h.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData3 = (PostData) obj;
                        pbModel134 = this.enc.ele;
                        if (pbModel134 != null) {
                            pbModel135 = this.enc.ele;
                            if (pbModel135.getPbData() != null && this.enc.aJE().aMf() != null && postData3.getAuthor() != null && postData3.big() != 1 && this.enc.checkUpIsLogin() && !com.baidu.tieba.pb.e.c(postData3)) {
                                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                pbModel136 = this.enc.ele;
                                nVar.b(pbModel136.getPbData().aIz());
                                pbModel137 = this.enc.ele;
                                nVar.N(pbModel137.getPbData().aIB());
                                nVar.e(postData3);
                                this.enc.aJE().aMf().d(nVar);
                                this.enc.aJE().aMf().setPostId(postData3.getId());
                                this.enc.a(view, postData3.getAuthor().getUserId(), "");
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
            fxVar = this.enc.elU;
            if (fxVar.esG.aNz() != null) {
                fxVar104 = this.enc.elU;
            }
            fxVar2 = this.enc.elU;
            if (fxVar2.aMt() != view) {
            }
            if (this.enc.checkUpIsLogin()) {
                pbModel131 = this.enc.ele;
                if (pbModel131 != null) {
                    pbModel132 = this.enc.ele;
                    if (pbModel132.getPbData() != null) {
                        pbModel133 = this.enc.ele;
                        if (com.baidu.tieba.pb.e.M(pbModel133.getPbData().aIB())) {
                            return;
                        }
                    }
                }
                fxVar3 = this.enc.elU;
                if (view == fxVar3.getNextView()) {
                    z9 = this.enc.mIsLoading;
                    if (!z9) {
                        pbModel130 = this.enc.ele;
                        if (pbModel130.ir(true)) {
                            this.enc.mIsLoading = true;
                            fxVar103 = this.enc.elU;
                            fxVar103.aMA();
                            return;
                        }
                        return;
                    }
                    return;
                }
                fxVar4 = this.enc.elU;
                if (view == fxVar4.aMl()) {
                    fxVar101 = this.enc.elU;
                    fxVar101.aMr();
                    if (UtilHelper.isFloatWindowOpAllowed(this.enc.getPageContext().getPageActivity())) {
                        this.enc.ema = true;
                        PbActivity pbActivity = this.enc;
                        pbModel128 = this.enc.ele;
                        pbActivity.a(pbModel128.getPbData(), 0, 1, true, true);
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10830");
                        pbModel129 = this.enc.ele;
                        TiebaStatic.log(asVar.Z("tid", pbModel129.getThreadID()));
                        fxVar102 = this.enc.elU;
                        fxVar102.avy();
                        return;
                    }
                    this.enc.Oj();
                    return;
                }
                fxVar5 = this.enc.elU;
                if (fxVar5.esG.aNz() != null) {
                    fxVar97 = this.enc.elU;
                    if (view == fxVar97.esG.aNz().aLK()) {
                        if (com.baidu.adp.lib.util.i.hk()) {
                            fxVar98 = this.enc.elU;
                            fxVar98.avy();
                            this.enc.aas();
                            fxVar99 = this.enc.elU;
                            fxVar99.aMz();
                            fxVar100 = this.enc.elU;
                            fxVar100.Pd();
                            pbModel127 = this.enc.ele;
                            pbModel127.oy(1);
                            return;
                        }
                        this.enc.showToast(w.l.network_not_available);
                        return;
                    }
                }
                fxVar6 = this.enc.elU;
                if (view == fxVar6.esG.aIp) {
                    fxVar96 = this.enc.elU;
                    pbModel126 = this.enc.ele;
                    if (!fxVar96.iS(pbModel126.aKR())) {
                        this.enc.elz = false;
                        this.enc.elx = false;
                        this.enc.finish();
                        return;
                    }
                    this.enc.aas();
                    return;
                }
                fxVar7 = this.enc.elU;
                if (view != fxVar7.aMx()) {
                    fxVar16 = this.enc.elU;
                    if (fxVar16.esG.aNz() != null) {
                        fxVar94 = this.enc.elU;
                        if (view != fxVar94.esG.aNz().aLJ()) {
                            fxVar95 = this.enc.elU;
                        }
                    }
                    fxVar17 = this.enc.elU;
                    if (view == fxVar17.aMM()) {
                        pbModel124 = this.enc.ele;
                        if (pbModel124 != null) {
                            pbModel125 = this.enc.ele;
                            com.baidu.tbadk.browser.f.S(this.enc.getPageContext().getPageActivity(), pbModel125.getPbData().aIB().ru().getLink());
                            return;
                        }
                        return;
                    }
                    fxVar18 = this.enc.elU;
                    if (view != fxVar18.esG.exi) {
                        fxVar19 = this.enc.elU;
                        if (view == fxVar19.esG.exk) {
                            pbModel109 = this.enc.ele;
                            if (pbModel109 != null) {
                                pbModel110 = this.enc.ele;
                                if (pbModel110.getPbData() != null) {
                                    pbModel111 = this.enc.ele;
                                    ArrayList<PostData> aID = pbModel111.getPbData().aID();
                                    if (aID == null || aID.size() <= 0) {
                                        pbModel112 = this.enc.ele;
                                        if (pbModel112.aKN()) {
                                            com.baidu.adp.lib.util.k.showToast(this.enc.getPageContext().getPageActivity(), this.enc.getPageContext().getString(w.l.pb_no_data_tips));
                                            return;
                                        }
                                    }
                                    fxVar92 = this.enc.elU;
                                    if (!fxVar92.aNb()) {
                                        fxVar93 = this.enc.elU;
                                        fxVar93.aKn();
                                    }
                                    this.enc.aJK();
                                    return;
                                }
                            }
                            com.baidu.adp.lib.util.k.showToast(this.enc.getPageContext().getPageActivity(), this.enc.getPageContext().getString(w.l.pb_no_data_tips));
                            return;
                        }
                        fxVar20 = this.enc.elU;
                        if (view != fxVar20.esG.exj && view.getId() != w.h.pb_god_user_tip_content) {
                            fxVar26 = this.enc.elU;
                            if (fxVar26.esG.aNz() != null) {
                                fxVar89 = this.enc.elU;
                                if (view == fxVar89.esG.aNz().aLt()) {
                                    if (com.baidu.adp.lib.util.i.hk()) {
                                        fxVar90 = this.enc.elU;
                                        fxVar90.avy();
                                        or = this.enc.or(11009);
                                        if (or) {
                                            pbModel108 = this.enc.ele;
                                            fxVar91 = this.enc.elU;
                                            if (pbModel108.oF(fxVar91.aME()) == null) {
                                                return;
                                            }
                                            this.enc.aJR();
                                            return;
                                        }
                                        return;
                                    }
                                    this.enc.showToast(w.l.network_not_available);
                                    return;
                                }
                            }
                            fxVar27 = this.enc.elU;
                            if (fxVar27.esG.aNz() != null) {
                                fxVar88 = this.enc.elU;
                            }
                            if (view.getId() != w.h.floor_owner_reply && view.getId() != w.h.reply_title) {
                                fxVar28 = this.enc.elU;
                                if (fxVar28.esG.aNz() != null) {
                                    fxVar77 = this.enc.elU;
                                    if (view != fxVar77.esG.aNz().getCancelView()) {
                                        fxVar79 = this.enc.elU;
                                    }
                                    fxVar78 = this.enc.elU;
                                    fxVar78.esG.oh();
                                    return;
                                }
                                fxVar29 = this.enc.elU;
                                if (fxVar29.esG.aNz() != null) {
                                    fxVar73 = this.enc.elU;
                                    if (view == fxVar73.esG.aNz().aLM()) {
                                        if (this.enc.checkUpIsLogin()) {
                                            if (com.baidu.adp.lib.util.k.hB()) {
                                                fxVar74 = this.enc.elU;
                                                fxVar74.avy();
                                                this.enc.aas();
                                                this.enc.os(2);
                                                pbModel99 = this.enc.ele;
                                                if (pbModel99 != null) {
                                                    pbModel101 = this.enc.ele;
                                                    if (pbModel101.getPbData() != null) {
                                                        pbModel102 = this.enc.ele;
                                                        if (pbModel102.getPbData().aIT() != null) {
                                                            pbModel103 = this.enc.ele;
                                                            if (!StringUtils.isNull(pbModel103.getPbData().aIT().pL(), true)) {
                                                                com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11678");
                                                                pbModel104 = this.enc.ele;
                                                                TiebaStatic.log(asVar2.Z("fid", pbModel104.getPbData().getForumId()));
                                                            }
                                                        }
                                                    }
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11939"));
                                                fxVar75 = this.enc.elU;
                                                fxVar75.Pd();
                                                fxVar76 = this.enc.elU;
                                                int i4 = view == fxVar76.euf ? 1 : 2;
                                                pbModel100 = this.enc.ele;
                                                pbModel100.aLo().p(CheckRealNameModel.TYPE_PB_SHARE, Integer.valueOf(i4));
                                                return;
                                            }
                                            this.enc.showToast(w.l.neterror);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                fxVar30 = this.enc.elU;
                                if (fxVar30.esG.aNz() != null) {
                                    fxVar70 = this.enc.elU;
                                    if (view == fxVar70.esG.aNz().aLB()) {
                                        fxVar71 = this.enc.elU;
                                        fxVar71.avy();
                                        pbModel97 = this.enc.ele;
                                        if (pbModel97.akK() != null) {
                                            fxVar72 = this.enc.elU;
                                            pbModel98 = this.enc.ele;
                                            fxVar72.a(pbModel98.akK(), this.enc.dVv);
                                        }
                                        TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                fxVar31 = this.enc.elU;
                                if (fxVar31.esG.aNz() != null) {
                                    fxVar69 = this.enc.elU;
                                }
                                if (view.getId() != w.h.pb_sort) {
                                    fxVar32 = this.enc.elU;
                                    if (fxVar32.esG.aNz() != null) {
                                        fxVar64 = this.enc.elU;
                                        if (view == fxVar64.esG.aNz().aLD()) {
                                            pbModel91 = this.enc.ele;
                                            if (pbModel91 != null) {
                                                pbModel92 = this.enc.ele;
                                                if (pbModel92.getPbData() != null) {
                                                    pbModel93 = this.enc.ele;
                                                    if (pbModel93.getPbData().aIB() != null) {
                                                        fxVar65 = this.enc.elU;
                                                        fxVar65.esG.oh();
                                                        PbActivity pbActivity2 = this.enc;
                                                        pbModel94 = this.enc.ele;
                                                        pbActivity2.nP(pbModel94.getPbData().aIB().rK());
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    fxVar33 = this.enc.elU;
                                    if (fxVar33.esG.aNz() != null) {
                                        fxVar60 = this.enc.elU;
                                        if (view == fxVar60.esG.aNz().aLE()) {
                                            TiebaStatic.log("c10414");
                                            fxVar61 = this.enc.elU;
                                            fxVar61.avy();
                                            fxVar62 = this.enc.elU;
                                            if (fxVar62.ri() != fx.euu) {
                                                pbModel89 = this.enc.ele;
                                                if (pbModel89.aLl() != null) {
                                                    pbModel90 = this.enc.ele;
                                                    pbModel90.aLl().ow(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                                    return;
                                                }
                                                return;
                                            }
                                            fxVar63 = this.enc.elU;
                                            fxVar63.aMR();
                                            return;
                                        }
                                    }
                                    fxVar34 = this.enc.elU;
                                    if (fxVar34.esG.aNz() != null) {
                                        fxVar57 = this.enc.elU;
                                        if (view == fxVar57.esG.aNz().aLF()) {
                                            aJI = this.enc.aJI();
                                            this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.enc.getPageContext().getPageActivity(), null, aJI, true)));
                                            fxVar58 = this.enc.elU;
                                            fxVar58.esG.oh();
                                            fxVar59 = this.enc.elU;
                                            fxVar59.esG.aNz().aLN();
                                            return;
                                        }
                                    }
                                    elVar = this.enc.elZ;
                                    if (elVar != null) {
                                        elVar48 = this.enc.elZ;
                                        if (view == elVar48.aLv()) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").r("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.i.hk()) {
                                                this.enc.showToast(w.l.network_not_available);
                                                return;
                                            }
                                            Object tag = view.getTag();
                                            if (!(tag instanceof String)) {
                                                if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                    if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray2.put(w.h.tag_from, 0);
                                                        sparseArray2.put(w.h.tag_check_mute_from, 2);
                                                        this.enc.d(sparseArray2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            this.enc.nP((String) tag);
                                            return;
                                        }
                                    }
                                    elVar2 = this.enc.elZ;
                                    if (elVar2 != null) {
                                        elVar47 = this.enc.elZ;
                                        if (view == elVar47.aLt()) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").r("obj_locate", 2));
                                            if (!this.enc.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.enc.aT(view);
                                            return;
                                        }
                                    }
                                    elVar3 = this.enc.elZ;
                                    if (elVar3 != null) {
                                        elVar45 = this.enc.elZ;
                                        if (view == elVar45.aLy()) {
                                            elVar46 = this.enc.elZ;
                                            if (elVar46.aLA()) {
                                                com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c12007");
                                                pbModel88 = this.enc.ele;
                                                TiebaStatic.log(asVar3.Z("tid", pbModel88.eph));
                                            } else {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").r("obj_locate", 1));
                                            }
                                            if (this.enc.checkUpIsLogin()) {
                                                pbModel83 = this.enc.ele;
                                                if (pbModel83.getPbData() != null) {
                                                    fxVar56 = this.enc.elU;
                                                    fxVar56.avy();
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
                                                        pbModel84 = this.enc.ele;
                                                        String threadID = pbModel84.getThreadID();
                                                        String id2 = postData2.getId();
                                                        int i5 = 0;
                                                        pbModel85 = this.enc.ele;
                                                        if (pbModel85.getPbData() != null) {
                                                            pbModel87 = this.enc.ele;
                                                            i5 = pbModel87.getPbData().aIM();
                                                        }
                                                        this.enc.aas();
                                                        nS4 = this.enc.nS(id2);
                                                        if (nS4 != null) {
                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.enc.getPageContext().getPageActivity());
                                                            SmallTailInfo aOB = postData2.aOB();
                                                            pbModel86 = this.enc.ele;
                                                            this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i5, aOB, pbModel86.getPbData().qh(), false, postData2.getAuthor().getIconInfo()).addBigImageData(nS4.ent, nS4.enu, nS4.env, nS4.index)));
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
                                    elVar4 = this.enc.elZ;
                                    if (elVar4 != null) {
                                        elVar44 = this.enc.elZ;
                                        if (view == elVar44.aLw()) {
                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(w.h.tag_del_post_type) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_id) instanceof String) && (sparseArray3.get(w.h.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(w.h.tag_del_post_is_self)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(w.h.tag_manage_user_identity)).intValue();
                                                if (!booleanValue && intValue != 0 && com.baidu.tieba.c.a.SV()) {
                                                    Context baseContext = this.enc.getBaseContext();
                                                    pbModel82 = this.enc.ele;
                                                    if (com.baidu.tieba.c.a.h(baseContext, pbModel82.getThreadID(), (String) sparseArray3.get(w.h.tag_del_post_id))) {
                                                        return;
                                                    }
                                                }
                                                fxVar55 = this.enc.elU;
                                                fxVar55.a(((Integer) sparseArray3.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray3.get(w.h.tag_del_post_id), intValue, booleanValue);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    elVar5 = this.enc.elZ;
                                    if (elVar5 != null) {
                                        elVar43 = this.enc.elZ;
                                        if (view == elVar43.aLx()) {
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
                                            pbModel81 = this.enc.ele;
                                            com.baidu.tieba.pb.data.f pbData = pbModel81.getPbData();
                                            String str3 = null;
                                            String str4 = null;
                                            String str5 = null;
                                            if (pbData != null && pbData.aIz() != null) {
                                                str3 = pbData.aIz().getId();
                                                str4 = pbData.aIz().getName();
                                                str5 = pbData.getThreadId();
                                            }
                                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                            this.enc.a(j, str2, str3, str4, str5, i6);
                                            return;
                                        }
                                    }
                                    fxVar35 = this.enc.elU;
                                    if (fxVar35.aMS() == view) {
                                        fxVar54 = this.enc.elU;
                                        if (fxVar54.aMS().getIndicateStatus()) {
                                            pbModel80 = this.enc.ele;
                                            com.baidu.tieba.pb.data.f pbData2 = pbModel80.getPbData();
                                            if (pbData2 != null && pbData2.aIB() != null && pbData2.aIB().rd() != null) {
                                                String px = pbData2.aIB().rd().px();
                                                if (StringUtils.isNull(px)) {
                                                    px = pbData2.aIB().rd().getTaskId();
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11107").Z("obj_id", px));
                                            }
                                        } else {
                                            com.baidu.tieba.tbadkCore.d.a.ca("c10725", null);
                                        }
                                        this.enc.aKd();
                                        return;
                                    }
                                    fxVar36 = this.enc.elU;
                                    if (fxVar36.aMt() != view) {
                                        elVar6 = this.enc.elZ;
                                        if (elVar6 != null) {
                                            elVar42 = this.enc.elZ;
                                            if (view == elVar42.aLu()) {
                                                if (!com.baidu.adp.lib.util.i.hk()) {
                                                    this.enc.showToast(w.l.network_not_available);
                                                    return;
                                                }
                                                SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                                if (sparseArray4 != null) {
                                                    if (com.baidu.tieba.c.a.SV() && sparseArray4.get(w.h.tag_del_post_id) != null) {
                                                        Context baseContext2 = this.enc.getBaseContext();
                                                        pbModel78 = this.enc.ele;
                                                        if (com.baidu.tieba.c.a.h(baseContext2, pbModel78.getThreadID(), (String) sparseArray4.get(w.h.tag_del_post_id))) {
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
                                                            this.enc.d(sparseArray4);
                                                            return;
                                                        }
                                                        sparseArray4.put(w.h.tag_check_mute_from, 2);
                                                        fxVar53 = this.enc.elU;
                                                        fxVar53.aX(view);
                                                        return;
                                                    } else if (booleanValue3) {
                                                        fxVar52 = this.enc.elU;
                                                        fxVar52.a(((Integer) sparseArray4.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray4.get(w.h.tag_del_post_id), ((Integer) sparseArray4.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(w.h.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        fxVar37 = this.enc.elU;
                                        if (fxVar37.esG.aNz() != null) {
                                            fxVar49 = this.enc.elU;
                                            if (view == fxVar49.esG.aNz().aLL()) {
                                                if (com.baidu.adp.lib.util.i.hk()) {
                                                    fxVar50 = this.enc.elU;
                                                    fxVar50.avy();
                                                    fxVar51 = this.enc.elU;
                                                    pbModel72 = this.enc.ele;
                                                    com.baidu.tieba.pb.data.f pbData3 = pbModel72.getPbData();
                                                    pbModel73 = this.enc.ele;
                                                    SparseArray<Object> c = fxVar51.c(pbData3, pbModel73.aKN(), 1);
                                                    if (c != null) {
                                                        pbModel74 = this.enc.ele;
                                                        PbActivity pbActivity3 = this.enc;
                                                        Activity pageActivity = this.enc.getPageContext().getPageActivity();
                                                        pbModel75 = this.enc.ele;
                                                        String id3 = pbModel75.getPbData().aIz().getId();
                                                        pbModel76 = this.enc.ele;
                                                        String name2 = pbModel76.getPbData().aIz().getName();
                                                        pbModel77 = this.enc.ele;
                                                        pbActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, pbModel77.getPbData().aIB().getId(), String.valueOf(pbModel74.getPbData().getUserData().getUserId()), (String) c.get(w.h.tag_forbid_user_name), (String) c.get(w.h.tag_forbid_user_post_id))));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.enc.showToast(w.l.network_not_available);
                                                return;
                                            }
                                        }
                                        fxVar38 = this.enc.elU;
                                        if (fxVar38.esG.aNz() != null) {
                                            fxVar45 = this.enc.elU;
                                            if (view == fxVar45.esG.aNz().aLI()) {
                                                if (com.baidu.adp.lib.util.i.hk()) {
                                                    fxVar46 = this.enc.elU;
                                                    pbModel70 = this.enc.ele;
                                                    com.baidu.tieba.pb.data.f pbData4 = pbModel70.getPbData();
                                                    pbModel71 = this.enc.ele;
                                                    SparseArray<Object> c2 = fxVar46.c(pbData4, pbModel71.aKN(), 1);
                                                    if (c2 != null) {
                                                        fxVar48 = this.enc.elU;
                                                        fxVar48.a(((Integer) c2.get(w.h.tag_del_post_type)).intValue(), (String) c2.get(w.h.tag_del_post_id), ((Integer) c2.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(w.h.tag_del_post_is_self)).booleanValue());
                                                    }
                                                    fxVar47 = this.enc.elU;
                                                    fxVar47.esG.oh();
                                                    return;
                                                }
                                                this.enc.showToast(w.l.network_not_available);
                                                return;
                                            }
                                        }
                                        if (view.getId() != w.h.sub_pb_more && view.getId() != w.h.sub_pb_item && view.getId() != w.h.pb_floor_reply_more) {
                                            fxVar40 = this.enc.elU;
                                            if (view != fxVar40.aJz()) {
                                                fxVar41 = this.enc.elU;
                                                if (view == fxVar41.esG.aNA()) {
                                                    fxVar44 = this.enc.elU;
                                                    fxVar44.aMF();
                                                    return;
                                                }
                                                int id4 = view.getId();
                                                if (id4 == w.h.pb_u9_text_view) {
                                                    if (this.enc.checkUpIsLogin() && (brVar = (com.baidu.tbadk.core.data.br) view.getTag()) != null && !StringUtils.isNull(brVar.sR())) {
                                                        TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                        com.baidu.tbadk.core.util.bb.vy().c(this.enc.getPageContext(), new String[]{brVar.sR()});
                                                        return;
                                                    }
                                                    return;
                                                } else if ((id4 == w.h.pb_floor_agree || id4 == w.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                    if (this.enc.checkUpIsLogin() && (postData = (PostData) view.getTag(w.h.tag_clip_board)) != null && !com.baidu.tieba.pb.e.c(postData)) {
                                                        if (postData.bit()) {
                                                            postData.cr(postData.bis() - 1);
                                                        } else {
                                                            postData.cr(postData.bis() + 1);
                                                        }
                                                        postData.lt(!postData.bit());
                                                        ((PbFloorAgreeView) view).a(postData.bit(), postData.bis(), true);
                                                        int i7 = postData.bit() ? 0 : 1;
                                                        pbModel22 = this.enc.ele;
                                                        pbModel22.aLm().ao(postData.getId(), i7);
                                                        int i8 = 2;
                                                        if (postData.getAuthor() != null && postData.getAuthor().getUserId() != null) {
                                                            i8 = postData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) ? 1 : 2;
                                                        }
                                                        if (postData.bit()) {
                                                            com.baidu.tbadk.core.util.as asVar4 = new com.baidu.tbadk.core.util.as("c12003");
                                                            pbModel24 = this.enc.ele;
                                                            com.baidu.tbadk.core.util.as r = asVar4.Z("tid", pbModel24.eph).r("obj_id", i8);
                                                            pbModel25 = this.enc.ele;
                                                            TiebaStatic.log(r.r("obj_param1", pbModel25.getPbData().aIB().getThreadType() == 40 ? 2 : 1));
                                                            return;
                                                        }
                                                        com.baidu.tbadk.core.util.as asVar5 = new com.baidu.tbadk.core.util.as("c12008");
                                                        pbModel23 = this.enc.ele;
                                                        TiebaStatic.log(asVar5.Z("tid", pbModel23.eph).r("obj_id", i8));
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.view_main_thread_praise_state) {
                                                    this.enc.f(view, 2, false);
                                                    return;
                                                } else if (id4 == w.h.view_main_thread_praise_num || id4 == w.h.view_main_thread_praise_name_list) {
                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                                                        pbModel26 = this.enc.ele;
                                                        if (pbModel26 != null) {
                                                            pbModel27 = this.enc.ele;
                                                            if (pbModel27.getPbData() != null) {
                                                                pbModel28 = this.enc.ele;
                                                                if (!StringUtils.isNull(pbModel28.getPbData().getThreadId())) {
                                                                    pbModel29 = this.enc.ele;
                                                                    com.baidu.tieba.pb.data.m aIY = pbModel29.getPbData().aIY();
                                                                    if (aIY != null && aIY.getPraiseNum() > 0) {
                                                                        StringBuilder sb = new StringBuilder("https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=");
                                                                        pbModel30 = this.enc.ele;
                                                                        com.baidu.tbadk.core.util.bb.vy().c(this.enc.getPageContext(), new String[]{sb.append(pbModel30.getPbData().getThreadId()).toString()});
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
                                                    if (this.enc.checkUpIsLogin()) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11740"));
                                                        PostData postData4 = null;
                                                        if (view != null && view.getTag() != null) {
                                                            postData4 = (PostData) ((SparseArray) view.getTag()).get(w.h.tag_load_sub_data);
                                                            if (postData4 == null || !com.baidu.tieba.pb.e.c(postData4)) {
                                                                elVar11 = this.enc.elZ;
                                                                if (elVar11 == null) {
                                                                    this.enc.elZ = new el(this.enc.getPageContext(), this.enc.bVy);
                                                                    elVar41 = this.enc.elZ;
                                                                    z7 = this.enc.mIsLogin;
                                                                    elVar41.iw(z7);
                                                                }
                                                                elVar12 = this.enc.elZ;
                                                                elVar12.showDialog();
                                                                boolean z11 = id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right;
                                                                if (z11) {
                                                                    com.baidu.tbadk.core.util.as asVar6 = new com.baidu.tbadk.core.util.as("c12006");
                                                                    pbModel33 = this.enc.ele;
                                                                    TiebaStatic.log(asVar6.Z("tid", pbModel33.eph));
                                                                }
                                                                SparseArray sparseArray5 = new SparseArray();
                                                                sparseArray5.put(w.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(w.h.tag_clip_board));
                                                                sparseArray5.put(w.h.tag_is_subpb, false);
                                                                elVar13 = this.enc.elZ;
                                                                elVar13.aLt().setTag(sparseArray5);
                                                                elVar14 = this.enc.elZ;
                                                                elVar14.aLy().setTag(view.getTag());
                                                                elVar15 = this.enc.elZ;
                                                                elVar15.iy(z11);
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
                                                                        elVar40 = this.enc.elZ;
                                                                        elVar40.aLw().setVisibility(0);
                                                                    } else {
                                                                        sparseArray7.put(w.h.tag_should_delete_visible, false);
                                                                        elVar35 = this.enc.elZ;
                                                                        elVar35.aLw().setVisibility(8);
                                                                    }
                                                                    elVar36 = this.enc.elZ;
                                                                    elVar36.aLu().setTag(sparseArray7);
                                                                    elVar37 = this.enc.elZ;
                                                                    elVar37.aLw().setTag(sparseArray7);
                                                                    elVar38 = this.enc.elZ;
                                                                    elVar38.aLu().setText(w.l.bar_manager);
                                                                    elVar39 = this.enc.elZ;
                                                                    elVar39.aLu().setVisibility(0);
                                                                } else if (!booleanValue7) {
                                                                    elVar16 = this.enc.elZ;
                                                                    elVar16.aLu().setVisibility(8);
                                                                    elVar17 = this.enc.elZ;
                                                                    elVar17.aLw().setVisibility(8);
                                                                } else {
                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                    sparseArray8.put(w.h.tag_should_manage_visible, false);
                                                                    sparseArray8.put(w.h.tag_user_mute_visible, false);
                                                                    sparseArray8.put(w.h.tag_should_delete_visible, true);
                                                                    sparseArray8.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                                    sparseArray8.put(w.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                    sparseArray8.put(w.h.tag_del_post_id, sparseArray6.get(w.h.tag_del_post_id));
                                                                    sparseArray8.put(w.h.tag_del_post_type, sparseArray6.get(w.h.tag_del_post_type));
                                                                    elVar18 = this.enc.elZ;
                                                                    elVar18.aLu().setTag(sparseArray8);
                                                                    elVar19 = this.enc.elZ;
                                                                    elVar19.aLw().setTag(sparseArray8);
                                                                    elVar20 = this.enc.elZ;
                                                                    elVar20.aLu().setText(w.l.delete);
                                                                    elVar21 = this.enc.elZ;
                                                                    elVar21.aLw().setVisibility(0);
                                                                    elVar22 = this.enc.elZ;
                                                                    elVar22.aLu().setVisibility(8);
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
                                                                    elVar31 = this.enc.elZ;
                                                                    elVar31.aLv().setTag(sparseArray10);
                                                                    elVar32 = this.enc.elZ;
                                                                    elVar32.aLv().setVisibility(0);
                                                                    elVar33 = this.enc.elZ;
                                                                    elVar33.aLu().setVisibility(8);
                                                                    elVar34 = this.enc.elZ;
                                                                    elVar34.aLv().setText(w.l.mute_option);
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
                                                                    ig = this.enc.ig(z5);
                                                                    boolean isLogin = ig & this.enc.isLogin();
                                                                    this.enc.emS = (PostData) sparseArray9.get(w.h.tag_clip_board);
                                                                    if (fw.i(this.enc.emS) ? false : isLogin) {
                                                                        elVar24 = this.enc.elZ;
                                                                        elVar24.aLv().setVisibility(0);
                                                                        elVar25 = this.enc.elZ;
                                                                        elVar25.aLv().setTag(str7);
                                                                    } else {
                                                                        elVar23 = this.enc.elZ;
                                                                        elVar23.aLv().setVisibility(8);
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
                                                                    elVar27 = this.enc.elZ;
                                                                    elVar27.aLx().setVisibility(0);
                                                                    elVar28 = this.enc.elZ;
                                                                    elVar28.aLx().setTag(w.h.tag_chudian_template_id, Long.valueOf(j2));
                                                                    elVar29 = this.enc.elZ;
                                                                    elVar29.aLx().setTag(w.h.tag_chudian_monitor_id, str);
                                                                    elVar30 = this.enc.elZ;
                                                                    elVar30.aLx().setTag(w.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                } else {
                                                                    elVar26 = this.enc.elZ;
                                                                    elVar26.aLx().setVisibility(8);
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        pbModel31 = this.enc.ele;
                                                        if (pbModel31.getPbData().nD()) {
                                                            pbModel32 = this.enc.ele;
                                                            String nC = pbModel32.getPbData().nC();
                                                            if (postData4 != null && !com.baidu.adp.lib.util.j.isEmpty(nC) && nC.equals(postData4.getId())) {
                                                                z2 = true;
                                                                if (!z2) {
                                                                    elVar10 = this.enc.elZ;
                                                                    elVar10.aLt().setText(w.l.remove_mark);
                                                                } else {
                                                                    elVar7 = this.enc.elZ;
                                                                    elVar7.aLt().setText(w.l.mark);
                                                                }
                                                                elVar8 = this.enc.elZ;
                                                                elVar8.ix(true);
                                                                elVar9 = this.enc.elZ;
                                                                elVar9.refreshUI();
                                                                return;
                                                            }
                                                        }
                                                        z2 = false;
                                                        if (!z2) {
                                                        }
                                                        elVar8 = this.enc.elZ;
                                                        elVar8.ix(true);
                                                        elVar9 = this.enc.elZ;
                                                        elVar9.refreshUI();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.pb_act_btn) {
                                                    pbModel61 = this.enc.ele;
                                                    if (pbModel61.getPbData() != null) {
                                                        pbModel62 = this.enc.ele;
                                                        if (pbModel62.getPbData().aIB() != null) {
                                                            pbModel63 = this.enc.ele;
                                                            if (pbModel63.getPbData().aIB().sa() != null) {
                                                                Activity activity = this.enc.getActivity();
                                                                pbModel64 = this.enc.ele;
                                                                com.baidu.tbadk.browser.f.S(activity, pbModel64.getPbData().aIB().sa());
                                                                pbModel65 = this.enc.ele;
                                                                if (pbModel65.getPbData().aIB().rY() != 1) {
                                                                    pbModel66 = this.enc.ele;
                                                                    if (pbModel66.getPbData().aIB().rY() == 2) {
                                                                        TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                        pbModel58 = this.enc.ele;
                                                        com.baidu.tbadk.core.util.as Z = asVar7.Z("fid", pbModel58.getPbData().getForumId());
                                                        pbModel59 = this.enc.ele;
                                                        TiebaStatic.log(Z.Z("tid", pbModel59.getPbData().getThreadId()).Z("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                        pbModel60 = this.enc.ele;
                                                        if (pbModel60.getPbData().getThreadId().equals(str8)) {
                                                            fxVar43 = this.enc.elU;
                                                            fxVar43.setSelection(0);
                                                            return;
                                                        }
                                                        this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.enc.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.pb_item_tail_content) {
                                                    if (com.baidu.tbadk.core.util.bh.aN(this.enc.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.m9getInst().getString(w.l.tail_web_view_title);
                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                        if (!StringUtils.isNull(string2)) {
                                                            TiebaStatic.log("c10056");
                                                            com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                        }
                                                        fxVar42 = this.enc.elU;
                                                        fxVar42.aKn();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id4 == w.h.join_vote_tv) {
                                                    if (view != null) {
                                                        com.baidu.tbadk.browser.f.S(this.enc.getActivity(), (String) view.getTag());
                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                        aJJ3 = this.enc.aJJ();
                                                        if (aJJ3 == 1) {
                                                            pbModel54 = this.enc.ele;
                                                            if (pbModel54 != null) {
                                                                pbModel55 = this.enc.ele;
                                                                if (pbModel55.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.as asVar8 = new com.baidu.tbadk.core.util.as("c10397");
                                                                    pbModel56 = this.enc.ele;
                                                                    com.baidu.tbadk.core.util.as Z2 = asVar8.Z("fid", pbModel56.getPbData().getForumId());
                                                                    pbModel57 = this.enc.ele;
                                                                    TiebaStatic.log(Z2.Z("tid", pbModel57.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        aJJ4 = this.enc.aJJ();
                                                        if (aJJ4 == 2) {
                                                            pbModel50 = this.enc.ele;
                                                            if (pbModel50 != null) {
                                                                pbModel51 = this.enc.ele;
                                                                if (pbModel51.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.as asVar9 = new com.baidu.tbadk.core.util.as("c10401");
                                                                    pbModel52 = this.enc.ele;
                                                                    com.baidu.tbadk.core.util.as Z3 = asVar9.Z("fid", pbModel52.getPbData().getForumId());
                                                                    pbModel53 = this.enc.ele;
                                                                    TiebaStatic.log(Z3.Z("tid", pbModel53.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                        com.baidu.tbadk.browser.f.S(this.enc.getActivity(), (String) view.getTag());
                                                        aJJ = this.enc.aJJ();
                                                        if (aJJ == 1) {
                                                            pbModel46 = this.enc.ele;
                                                            if (pbModel46 != null) {
                                                                pbModel47 = this.enc.ele;
                                                                if (pbModel47.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.as asVar10 = new com.baidu.tbadk.core.util.as("c10507");
                                                                    pbModel48 = this.enc.ele;
                                                                    com.baidu.tbadk.core.util.as Z4 = asVar10.Z("fid", pbModel48.getPbData().getForumId());
                                                                    pbModel49 = this.enc.ele;
                                                                    TiebaStatic.log(Z4.Z("tid", pbModel49.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        aJJ2 = this.enc.aJJ();
                                                        if (aJJ2 == 2) {
                                                            pbModel42 = this.enc.ele;
                                                            if (pbModel42 != null) {
                                                                pbModel43 = this.enc.ele;
                                                                if (pbModel43.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.as asVar11 = new com.baidu.tbadk.core.util.as("c10508");
                                                                    pbModel44 = this.enc.ele;
                                                                    com.baidu.tbadk.core.util.as Z5 = asVar11.Z("fid", pbModel44.getPbData().getForumId());
                                                                    pbModel45 = this.enc.ele;
                                                                    TiebaStatic.log(Z5.Z("tid", pbModel45.getPbData().getThreadId()).Z(SapiAccountManager.SESSION_UID, currentAccount2));
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
                                                            pbModel38 = this.enc.ele;
                                                            if (pbModel38 != null) {
                                                                pbModel39 = this.enc.ele;
                                                                if (pbModel39.getPbData() != null) {
                                                                    pbModel40 = this.enc.ele;
                                                                    if (pbModel40.getPbData().aIT() != null) {
                                                                        pbModel41 = this.enc.ele;
                                                                        com.baidu.tieba.pb.data.f pbData5 = pbModel41.getPbData();
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11679").Z("fid", pbData5.getForumId()));
                                                                        com.baidu.tbadk.core.util.bb.vy().c(this.enc.getPageContext(), new String[]{pbData5.aIT().aJa()});
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id4 == w.h.yule_head_img_all_rank) {
                                                            pbModel34 = this.enc.ele;
                                                            if (pbModel34 != null) {
                                                                pbModel35 = this.enc.ele;
                                                                if (pbModel35.getPbData() != null) {
                                                                    pbModel36 = this.enc.ele;
                                                                    if (pbModel36.getPbData().aIT() != null) {
                                                                        pbModel37 = this.enc.ele;
                                                                        com.baidu.tieba.pb.data.f pbData6 = pbModel37.getPbData();
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11678").Z("fid", pbData6.getForumId()));
                                                                        com.baidu.tbadk.core.util.bb.vy().c(this.enc.getPageContext(), new String[]{pbData6.aIT().aJa()});
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
                                                    this.enc.aJZ();
                                                    return;
                                                } else {
                                                    this.enc.aJY();
                                                    return;
                                                }
                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                long c3 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                pbModel67 = this.enc.ele;
                                                long c4 = com.baidu.adp.lib.g.b.c(pbModel67.getPbData().getForumId(), 0L);
                                                pbModel68 = this.enc.ele;
                                                long c5 = com.baidu.adp.lib.g.b.c(pbModel68.getThreadID(), 0L);
                                                pbModel69 = this.enc.ele;
                                                this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.enc.getPageContext().getPageActivity(), 24008, c4, c5, c3, pbModel69.getPbData().aIB().rO())));
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (this.enc.checkUpIsLogin()) {
                                            pbModel7 = this.enc.ele;
                                            if (pbModel7.getPbData() != null) {
                                                fxVar39 = this.enc.elU;
                                                fxVar39.avy();
                                                SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                PostData postData5 = (PostData) sparseArray12.get(w.h.tag_load_sub_data);
                                                View view2 = (View) sparseArray12.get(w.h.tag_load_sub_view);
                                                if (postData5 != null && view2 != null) {
                                                    pbModel8 = this.enc.ele;
                                                    String threadID2 = pbModel8.getThreadID();
                                                    String id5 = postData5.getId();
                                                    int i9 = 0;
                                                    pbModel9 = this.enc.ele;
                                                    if (pbModel9.getPbData() != null) {
                                                        pbModel20 = this.enc.ele;
                                                        i9 = pbModel20.getPbData().aIM();
                                                    }
                                                    if (com.baidu.tieba.pb.e.c(postData5)) {
                                                        return;
                                                    }
                                                    this.enc.aas();
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
                                                            nS2 = this.enc.nS(id5);
                                                            pbModel13 = this.enc.ele;
                                                            if (pbModel13 != null) {
                                                                pbModel14 = this.enc.ele;
                                                                if (pbModel14.getPbData() != null && nS2 != null && this.enc.aJE().aMf() != null) {
                                                                    com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                                                                    pbModel15 = this.enc.ele;
                                                                    nVar2.b(pbModel15.getPbData().aIz());
                                                                    pbModel16 = this.enc.ele;
                                                                    nVar2.N(pbModel16.getPbData().aIB());
                                                                    nVar2.e(postData6);
                                                                    this.enc.aJE().aMf().d(nVar2);
                                                                    this.enc.aJE().aMf().setPostId(str11);
                                                                    this.enc.a(view, str10, str9);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        TiebaStatic.log("c11742");
                                                        nS = this.enc.nS(id5);
                                                        if (postData5 != null) {
                                                            pbModel10 = this.enc.ele;
                                                            if (pbModel10 != null) {
                                                                pbModel11 = this.enc.ele;
                                                                if (pbModel11.getPbData() != null && nS != null) {
                                                                    SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.enc.getPageContext().getPageActivity());
                                                                    SmallTailInfo aOB2 = postData5.aOB();
                                                                    pbModel12 = this.enc.ele;
                                                                    this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i9, aOB2, pbModel12.getPbData().qh(), false, postData5.getAuthor().getIconInfo()).addBigImageData(nS.ent, nS.enu, nS.env, nS.index)));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    nS3 = this.enc.nS(id5);
                                                    pbModel17 = this.enc.ele;
                                                    if (pbModel17 != null) {
                                                        pbModel18 = this.enc.ele;
                                                        if (pbModel18.getPbData() != null && nS3 != null) {
                                                            SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.enc.getPageContext().getPageActivity());
                                                            SmallTailInfo aOB3 = postData5.aOB();
                                                            pbModel19 = this.enc.ele;
                                                            this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i9, aOB3, pbModel19.getPbData().qh(), false, postData5.getAuthor().getIconInfo()).addBigImageData(nS3.ent, nS3.enu, nS3.env, nS3.index)));
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
                                            com.baidu.tbadk.core.util.as r2 = new com.baidu.tbadk.core.util.as("c10517").r("obj_locate", 3);
                                            pbModel21 = this.enc.ele;
                                            TiebaStatic.log(r2.Z("fid", pbModel21.getPbData().getForumId()));
                                            return;
                                        }
                                    } else if (!this.enc.checkUpIsLogin()) {
                                        com.baidu.tbadk.core.util.as r3 = new com.baidu.tbadk.core.util.as("c10517").r("obj_locate", 2);
                                        pbModel79 = this.enc.ele;
                                        TiebaStatic.log(r3.Z("fid", pbModel79.getPbData().getForumId()));
                                        return;
                                    } else {
                                        this.enc.aJB();
                                        return;
                                    }
                                }
                                fxVar66 = this.enc.elU;
                                fxVar66.avy();
                                if (!com.baidu.adp.lib.util.i.hk()) {
                                    this.enc.showToast(w.l.network_not_available);
                                    return;
                                }
                                this.enc.os(2);
                                this.enc.aas();
                                fxVar67 = this.enc.elU;
                                fxVar67.aMz();
                                fxVar68 = this.enc.elU;
                                fxVar68.aMu().il(true);
                                boolean z12 = false;
                                if (view.getTag() instanceof Boolean) {
                                    pbModel96 = this.enc.ele;
                                    z12 = pbModel96.it(!((Boolean) view.getTag()).booleanValue());
                                } else {
                                    pbModel95 = this.enc.ele;
                                    pbModel95.aKX();
                                }
                                TiebaStatic.log("c12097");
                                if (z12 && this.enc.getListView() != null) {
                                    i2 = this.enc.emo;
                                    if (i2 > this.enc.getListView().getFirstVisiblePosition()) {
                                        this.enc.emo = this.enc.getListView().getFirstVisiblePosition();
                                    }
                                    View childAt = this.enc.getListView().getChildAt(0);
                                    int i10 = -1;
                                    if (childAt != null) {
                                        i10 = childAt.getTop();
                                    }
                                    fx aJE = this.enc.aJE();
                                    i3 = this.enc.emo;
                                    aJE.i(i3, i10);
                                    return;
                                }
                                return;
                            }
                            if (com.baidu.adp.lib.util.i.hk()) {
                                fxVar80 = this.enc.elU;
                                fxVar80.avy();
                                fxVar81 = this.enc.elU;
                                if (fxVar81.esG.aNz() != null) {
                                    fxVar85 = this.enc.elU;
                                    if (view == fxVar85.esG.aNz().aLG()) {
                                        fxVar86 = this.enc.elU;
                                        if (!fxVar86.aNb()) {
                                            fxVar87 = this.enc.elU;
                                            fxVar87.aKn();
                                        }
                                    }
                                }
                                z8 = this.enc.mIsLoading;
                                if (!z8) {
                                    fxVar82 = this.enc.elU;
                                    fxVar82.esG.exj.setEnabled(false);
                                    this.enc.aas();
                                    fxVar83 = this.enc.elU;
                                    fxVar83.aMz();
                                    if (view.getId() == w.h.floor_owner_reply) {
                                        pbModel107 = this.enc.ele;
                                        aJW4 = this.enc.aJW();
                                        nU = pbModel107.h(true, aJW4);
                                    } else if (view.getId() == w.h.reply_title) {
                                        pbModel106 = this.enc.ele;
                                        aJW3 = this.enc.aJW();
                                        nU = pbModel106.h(false, aJW3);
                                    } else {
                                        pbModel105 = this.enc.ele;
                                        aJW2 = this.enc.aJW();
                                        nU = pbModel105.nU(aJW2);
                                    }
                                    if (nU) {
                                        fxVar84 = this.enc.elU;
                                        fxVar84.aqn();
                                        this.enc.mIsLoading = true;
                                    }
                                    TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                    this.enc.os(2);
                                    return;
                                }
                                return;
                            }
                            this.enc.showToast(w.l.network_not_available);
                            return;
                        } else if (com.baidu.adp.lib.util.i.hk()) {
                            fxVar21 = this.enc.elU;
                            fxVar21.io(true);
                            fxVar22 = this.enc.elU;
                            fxVar22.aKn();
                            z = this.enc.mIsLoading;
                            if (!z) {
                                this.enc.mIsLoading = true;
                                fxVar23 = this.enc.elU;
                                fxVar23.esG.exj.setEnabled(false);
                                fxVar24 = this.enc.elU;
                                fxVar24.aqn();
                                this.enc.aas();
                                fxVar25 = this.enc.elU;
                                fxVar25.aMz();
                                pbModel6 = this.enc.ele;
                                aJW = this.enc.aJW();
                                pbModel6.nU(aJW);
                                TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                this.enc.os(2);
                                return;
                            }
                            return;
                        } else {
                            this.enc.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                    pbModel113 = this.enc.ele;
                    if (pbModel113.getPbData() != null) {
                        pbModel121 = this.enc.ele;
                        if (pbModel121.getPbData().aIB() != null) {
                            pbModel122 = this.enc.ele;
                            if (pbModel122.getPbData().aIB().sh()) {
                                pbModel123 = this.enc.ele;
                                if (pbModel123.getPbData().aIB().rL() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11922"));
                                }
                            }
                        }
                    }
                    pbModel114 = this.enc.ele;
                    if (pbModel114.getErrorNo() == 4) {
                        pbModel118 = this.enc.ele;
                        if (StringUtils.isNull(pbModel118.aKM())) {
                            pbModel119 = this.enc.ele;
                            if (pbModel119.getAppealInfo() != null) {
                                pbModel120 = this.enc.ele;
                                name = pbModel120.getAppealInfo().forumName;
                            }
                        }
                        this.enc.finish();
                        return;
                    }
                    pbModel115 = this.enc.ele;
                    name = pbModel115.getPbData().aIz().getName();
                    if (!StringUtils.isNull(name)) {
                        pbModel116 = this.enc.ele;
                        String aKM = pbModel116.aKM();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.enc.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                        pbModel117 = this.enc.ele;
                        if (pbModel117.aKO() && aKM != null && aKM.equals(name)) {
                            this.enc.finish();
                            return;
                        } else {
                            this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                            return;
                        }
                    }
                    this.enc.finish();
                    return;
                }
                if (com.baidu.adp.lib.util.i.hk()) {
                    pbModel = this.enc.ele;
                    if (pbModel.getPbData().aIM() == 1) {
                        forumManageModel = this.enc.elT;
                        if (!forumManageModel.biS()) {
                            fxVar8 = this.enc.elU;
                            fxVar8.avy();
                            int i11 = 0;
                            fxVar9 = this.enc.elU;
                            if (fxVar9.esG.aNz() != null) {
                                fxVar15 = this.enc.elU;
                                if (view == fxVar15.esG.aNz().aLH()) {
                                    pbModel5 = this.enc.ele;
                                    if (pbModel5.getPbData().aIB().rq() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    pbModel3 = this.enc.ele;
                                    ForumData aIz = pbModel3.getPbData().aIz();
                                    String name3 = aIz.getName();
                                    String id6 = aIz.getId();
                                    pbModel4 = this.enc.ele;
                                    id = pbModel4.getPbData().aIB().getId();
                                    if (com.baidu.tieba.c.a.SV() || !com.baidu.tieba.c.a.h(this.enc.getBaseContext(), id, null)) {
                                        fxVar13 = this.enc.elU;
                                        fxVar13.aMw();
                                        forumManageModel2 = this.enc.elT;
                                        fxVar14 = this.enc.elU;
                                        forumManageModel2.a(id6, name3, id, i11, fxVar14.aMy());
                                        return;
                                    }
                                    return;
                                }
                            }
                            fxVar10 = this.enc.elU;
                            if (fxVar10.esG.aNz() != null) {
                                fxVar12 = this.enc.elU;
                                if (view == fxVar12.esG.aNz().aLJ()) {
                                    pbModel2 = this.enc.ele;
                                    if (pbModel2.getPbData().aIB().rr() == 1) {
                                        i11 = 3;
                                    } else {
                                        i11 = 6;
                                    }
                                    pbModel3 = this.enc.ele;
                                    ForumData aIz2 = pbModel3.getPbData().aIz();
                                    String name32 = aIz2.getName();
                                    String id62 = aIz2.getId();
                                    pbModel4 = this.enc.ele;
                                    id = pbModel4.getPbData().aIB().getId();
                                    if (com.baidu.tieba.c.a.SV()) {
                                    }
                                    fxVar13 = this.enc.elU;
                                    fxVar13.aMw();
                                    forumManageModel2 = this.enc.elT;
                                    fxVar14 = this.enc.elU;
                                    forumManageModel2.a(id62, name32, id, i11, fxVar14.aMy());
                                    return;
                                }
                            }
                            fxVar11 = this.enc.elU;
                            if (view == fxVar11.aMx()) {
                                i11 = 2;
                            }
                            pbModel3 = this.enc.ele;
                            ForumData aIz22 = pbModel3.getPbData().aIz();
                            String name322 = aIz22.getName();
                            String id622 = aIz22.getId();
                            pbModel4 = this.enc.ele;
                            id = pbModel4.getPbData().aIB().getId();
                            if (com.baidu.tieba.c.a.SV()) {
                            }
                            fxVar13 = this.enc.elU;
                            fxVar13.aMw();
                            forumManageModel2 = this.enc.elT;
                            fxVar14 = this.enc.elU;
                            forumManageModel2.a(id622, name322, id, i11, fxVar14.aMy());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.enc.showToast(w.l.network_not_available);
            }
        }
    }
}
