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
class z implements View.OnClickListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v141, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v145, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v185, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0742, code lost:
        if (r18 != r1.emS.aMp().aKL()) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0867, code lost:
        if (r18 == r1.emS.aMp().SR()) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x09cc, code lost:
        if (r18 != r1.emS.aMp().aKH()) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02a7, code lost:
        if (r18 == r1.emS.aMp().aKM()) goto L900;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:641:0x1c66  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x1e22  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0357  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        fm fmVar4;
        fm fmVar5;
        PbModel pbModel;
        ForumManageModel forumManageModel;
        fm fmVar6;
        fm fmVar7;
        fm fmVar8;
        fm fmVar9;
        fm fmVar10;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        String id;
        fm fmVar11;
        ForumManageModel forumManageModel2;
        fm fmVar12;
        fm fmVar13;
        PbModel pbModel5;
        fm fmVar14;
        fm fmVar15;
        fm fmVar16;
        fm fmVar17;
        fm fmVar18;
        fm fmVar19;
        boolean z;
        fm fmVar20;
        fm fmVar21;
        fm fmVar22;
        PbModel pbModel6;
        String aJe;
        fm fmVar23;
        fm fmVar24;
        fm fmVar25;
        fm fmVar26;
        fm fmVar27;
        fm fmVar28;
        fm fmVar29;
        fm fmVar30;
        fm fmVar31;
        ec ecVar;
        ec ecVar2;
        ec ecVar3;
        ec ecVar4;
        ec ecVar5;
        fm fmVar32;
        fm fmVar33;
        ec ecVar6;
        fm fmVar34;
        fm fmVar35;
        PbModel pbModel7;
        fm fmVar36;
        PbModel pbModel8;
        PbModel pbModel9;
        PbActivity.b nG;
        PbModel pbModel10;
        PbModel pbModel11;
        PbModel pbModel12;
        PbActivity.b nG2;
        PbModel pbModel13;
        PbModel pbModel14;
        PbModel pbModel15;
        PbModel pbModel16;
        PbActivity.b nG3;
        PbModel pbModel17;
        PbModel pbModel18;
        PbModel pbModel19;
        PbModel pbModel20;
        PbModel pbModel21;
        fm fmVar37;
        fm fmVar38;
        PostData postData;
        PbModel pbModel22;
        PbModel pbModel23;
        PbModel pbModel24;
        PbModel pbModel25;
        PbModel pbModel26;
        PbModel pbModel27;
        PbModel pbModel28;
        ec ecVar7;
        ec ecVar8;
        PbModel pbModel29;
        boolean z2;
        ec ecVar9;
        ec ecVar10;
        ec ecVar11;
        ec ecVar12;
        PbModel pbModel30;
        ec ecVar13;
        ec ecVar14;
        ec ecVar15;
        boolean z3;
        ec ecVar16;
        ec ecVar17;
        ec ecVar18;
        ec ecVar19;
        ec ecVar20;
        ec ecVar21;
        ec ecVar22;
        boolean z4;
        boolean z5;
        boolean hS;
        ec ecVar23;
        ec ecVar24;
        ec ecVar25;
        boolean z6;
        String str;
        int i;
        ec ecVar26;
        ec ecVar27;
        ec ecVar28;
        ec ecVar29;
        ec ecVar30;
        ec ecVar31;
        ec ecVar32;
        ec ecVar33;
        ec ecVar34;
        ec ecVar35;
        ec ecVar36;
        ec ecVar37;
        ec ecVar38;
        ec ecVar39;
        ec ecVar40;
        PbModel pbModel31;
        ec ecVar41;
        boolean z7;
        PbModel pbModel32;
        PbModel pbModel33;
        PbModel pbModel34;
        PbModel pbModel35;
        PbModel pbModel36;
        PbModel pbModel37;
        PbModel pbModel38;
        PbModel pbModel39;
        int aIR;
        int aIR2;
        PbModel pbModel40;
        PbModel pbModel41;
        PbModel pbModel42;
        PbModel pbModel43;
        PbModel pbModel44;
        PbModel pbModel45;
        PbModel pbModel46;
        PbModel pbModel47;
        int aIR3;
        int aIR4;
        PbModel pbModel48;
        PbModel pbModel49;
        PbModel pbModel50;
        PbModel pbModel51;
        PbModel pbModel52;
        PbModel pbModel53;
        PbModel pbModel54;
        PbModel pbModel55;
        fm fmVar39;
        PbModel pbModel56;
        PbModel pbModel57;
        PbModel pbModel58;
        fm fmVar40;
        PbModel pbModel59;
        PbModel pbModel60;
        PbModel pbModel61;
        PbModel pbModel62;
        PbModel pbModel63;
        PbModel pbModel64;
        int i2;
        PbModel pbModel65;
        PbModel pbModel66;
        PbModel pbModel67;
        PbModel pbModel68;
        PbModel pbModel69;
        PbModel pbModel70;
        PbModel pbModel71;
        PbModel pbModel72;
        PbModel pbModel73;
        com.baidu.tbadk.core.data.bq bqVar;
        fm fmVar41;
        PbModel pbModel74;
        PbModel pbModel75;
        PbModel pbModel76;
        fm fmVar42;
        fm fmVar43;
        PbModel pbModel77;
        PbModel pbModel78;
        fm fmVar44;
        fm fmVar45;
        fm fmVar46;
        fm fmVar47;
        fm fmVar48;
        PbModel pbModel79;
        PbModel pbModel80;
        PbModel pbModel81;
        PbModel pbModel82;
        PbModel pbModel83;
        PbModel pbModel84;
        ec ecVar42;
        fm fmVar49;
        fm fmVar50;
        PbModel pbModel85;
        PbModel pbModel86;
        fm fmVar51;
        PbModel pbModel87;
        ec ecVar43;
        PbModel pbModel88;
        ec ecVar44;
        fm fmVar52;
        PbModel pbModel89;
        ec ecVar45;
        ec ecVar46;
        PbModel pbModel90;
        fm fmVar53;
        SparseArray sparseArray;
        PostData postData2;
        PbModel pbModel91;
        PbModel pbModel92;
        PbActivity.b nG4;
        PbModel pbModel93;
        PbModel pbModel94;
        PbModel pbModel95;
        ec ecVar47;
        ec ecVar48;
        fm fmVar54;
        String aIQ;
        fm fmVar55;
        fm fmVar56;
        fm fmVar57;
        fm fmVar58;
        fm fmVar59;
        PbModel pbModel96;
        PbModel pbModel97;
        fm fmVar60;
        fm fmVar61;
        PbModel pbModel98;
        PbModel pbModel99;
        PbModel pbModel100;
        fm fmVar62;
        PbModel pbModel101;
        fm fmVar63;
        fm fmVar64;
        fm fmVar65;
        PbModel pbModel102;
        int i3;
        int i4;
        PbModel pbModel103;
        fm fmVar66;
        fm fmVar67;
        fm fmVar68;
        PbModel pbModel104;
        fm fmVar69;
        PbModel pbModel105;
        fm fmVar70;
        PbModel pbModel106;
        fm fmVar71;
        PbModel pbModel107;
        PbModel pbModel108;
        PbModel pbModel109;
        PbModel pbModel110;
        fm fmVar72;
        fm fmVar73;
        fm fmVar74;
        fm fmVar75;
        fm fmVar76;
        boolean z8;
        fm fmVar77;
        fm fmVar78;
        PbModel pbModel111;
        String aJe2;
        boolean nI;
        PbModel pbModel112;
        String aJe3;
        fm fmVar79;
        PbModel pbModel113;
        String aJe4;
        fm fmVar80;
        fm fmVar81;
        fm fmVar82;
        boolean nY;
        PbModel pbModel114;
        fm fmVar83;
        PbModel pbModel115;
        PbModel pbModel116;
        PbModel pbModel117;
        PbModel pbModel118;
        fm fmVar84;
        PbModel pbModel119;
        PbModel pbModel120;
        PbModel pbModel121;
        String name;
        PbModel pbModel122;
        PbModel pbModel123;
        PbModel pbModel124;
        PbModel pbModel125;
        PbModel pbModel126;
        PbModel pbModel127;
        PbModel pbModel128;
        PbModel pbModel129;
        PbModel pbModel130;
        fm fmVar85;
        fm fmVar86;
        fm fmVar87;
        PbModel pbModel131;
        fm fmVar88;
        fm fmVar89;
        fm fmVar90;
        fm fmVar91;
        PbModel pbModel132;
        fm fmVar92;
        PbModel pbModel133;
        PbModel pbModel134;
        fm fmVar93;
        boolean z9;
        PbModel pbModel135;
        fm fmVar94;
        boolean z10;
        PbModel pbModel136;
        PbModel pbModel137;
        PbModel pbModel138;
        PbModel pbModel139;
        if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
            z10 = this.ehy.egj;
            if (z10) {
                this.ehy.egj = false;
                return;
            }
            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
            if (tbRichTextView.getTag() instanceof SparseArray) {
                Object obj = ((SparseArray) tbRichTextView.getTag()).get(w.h.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData3 = (PostData) obj;
                    pbModel136 = this.ehy.efE;
                    if (pbModel136 != null) {
                        pbModel137 = this.ehy.efE;
                        if (pbModel137.getPbData() != null && this.ehy.aIM().aLj() != null && postData3.getAuthor() != null && postData3.bgM() != 1 && this.ehy.checkUpIsLogin()) {
                            com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                            pbModel138 = this.ehy.efE;
                            lVar.b(pbModel138.getPbData().aHE());
                            pbModel139 = this.ehy.efE;
                            lVar.m(pbModel139.getPbData().aHG());
                            lVar.d(postData3);
                            this.ehy.aIM().aLj().d(lVar);
                            this.ehy.aIM().aLj().setPostId(postData3.getId());
                            this.ehy.a(view, postData3.getAuthor().getUserId(), "");
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
        fmVar = this.ehy.egt;
        if (view == fmVar.getNextView()) {
            z9 = this.ehy.mIsLoading;
            if (!z9) {
                pbModel135 = this.ehy.efE;
                if (pbModel135.ic(true)) {
                    this.ehy.mIsLoading = true;
                    fmVar94 = this.ehy.egt;
                    fmVar94.aLE();
                    return;
                }
                return;
            }
            return;
        }
        fmVar2 = this.ehy.egt;
        if (view == fmVar2.aLp()) {
            fmVar92 = this.ehy.egt;
            fmVar92.aLv();
            if (UtilHelper.isFloatWindowOpAllowed(this.ehy.getPageContext().getPageActivity())) {
                this.ehy.egz = true;
                PbActivity pbActivity = this.ehy;
                pbModel133 = this.ehy.efE;
                pbActivity.a(pbModel133.getPbData(), 0, 1, true, true);
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10830");
                pbModel134 = this.ehy.efE;
                TiebaStatic.log(asVar.aa("tid", pbModel134.getThreadID()));
                fmVar93 = this.ehy.egt;
                fmVar93.auE();
                return;
            }
            this.ehy.NZ();
            return;
        }
        fmVar3 = this.ehy.egt;
        if (fmVar3.emS.aMp() != null) {
            fmVar88 = this.ehy.egt;
            if (view == fmVar88.emS.aMp().aKP()) {
                if (com.baidu.adp.lib.util.i.hk()) {
                    fmVar89 = this.ehy.egt;
                    fmVar89.auE();
                    this.ehy.Zo();
                    fmVar90 = this.ehy.egt;
                    fmVar90.aLD();
                    fmVar91 = this.ehy.egt;
                    fmVar91.asr();
                    pbModel132 = this.ehy.efE;
                    pbModel132.of(1);
                    return;
                }
                this.ehy.showToast(w.l.network_not_available);
                return;
            }
        }
        fmVar4 = this.ehy.egt;
        if (view == fmVar4.emS.aIC) {
            fmVar87 = this.ehy.egt;
            pbModel131 = this.ehy.efE;
            if (!fmVar87.iD(pbModel131.aJX())) {
                this.ehy.ega = false;
                this.ehy.efY = false;
                this.ehy.finish();
                return;
            }
            this.ehy.Zo();
            return;
        }
        fmVar5 = this.ehy.egt;
        if (view != fmVar5.aLB()) {
            fmVar14 = this.ehy.egt;
            if (fmVar14.emS.aMp() != null) {
                fmVar85 = this.ehy.egt;
                if (view != fmVar85.emS.aMp().aKO()) {
                    fmVar86 = this.ehy.egt;
                }
            }
            fmVar15 = this.ehy.egt;
            if (view == fmVar15.aLS()) {
                pbModel129 = this.ehy.efE;
                if (pbModel129 != null) {
                    pbModel130 = this.ehy.efE;
                    com.baidu.tbadk.browser.f.S(this.ehy.getPageContext().getPageActivity(), pbModel130.getPbData().aHG().ry().getLink());
                    return;
                }
                return;
            }
            fmVar16 = this.ehy.egt;
            if (view != fmVar16.emS.eqa) {
                fmVar17 = this.ehy.egt;
                if (view == fmVar17.emS.eqc) {
                    pbModel115 = this.ehy.efE;
                    if (pbModel115 != null) {
                        pbModel116 = this.ehy.efE;
                        if (pbModel116.getPbData() != null) {
                            pbModel117 = this.ehy.efE;
                            ArrayList<PostData> aHI = pbModel117.getPbData().aHI();
                            if (aHI == null || aHI.size() <= 0) {
                                pbModel118 = this.ehy.efE;
                                if (pbModel118.aJT()) {
                                    com.baidu.adp.lib.util.k.showToast(this.ehy.getPageContext().getPageActivity(), this.ehy.getPageContext().getString(w.l.pb_no_data_tips));
                                    return;
                                }
                            }
                            fmVar84 = this.ehy.egt;
                            fmVar84.aLl();
                            this.ehy.aIS();
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.k.showToast(this.ehy.getPageContext().getPageActivity(), this.ehy.getPageContext().getString(w.l.pb_no_data_tips));
                    return;
                }
                fmVar18 = this.ehy.egt;
                if (view != fmVar18.emS.eqb && view.getId() != w.h.pb_god_user_tip_content) {
                    fmVar23 = this.ehy.egt;
                    if (fmVar23.emS.aMp() != null) {
                        fmVar81 = this.ehy.egt;
                        if (view == fmVar81.emS.aMp().aKy()) {
                            if (com.baidu.adp.lib.util.i.hk()) {
                                fmVar82 = this.ehy.egt;
                                fmVar82.auE();
                                nY = this.ehy.nY(11009);
                                if (nY) {
                                    pbModel114 = this.ehy.efE;
                                    fmVar83 = this.ehy.egt;
                                    if (pbModel114.ol(fmVar83.aLI()) == null) {
                                        return;
                                    }
                                    this.ehy.aIZ();
                                    return;
                                }
                                return;
                            }
                            this.ehy.showToast(w.l.network_not_available);
                            return;
                        }
                    }
                    fmVar24 = this.ehy.egt;
                    if (fmVar24.emS.aMp() != null) {
                        fmVar80 = this.ehy.egt;
                    }
                    if (view.getId() != w.h.floor_owner_reply && view.getId() != w.h.reply_title) {
                        fmVar25 = this.ehy.egt;
                        if (fmVar25.emS.aMp() != null) {
                            fmVar72 = this.ehy.egt;
                            if (view != fmVar72.emS.aMp().getCancelView()) {
                                fmVar74 = this.ehy.egt;
                            }
                            fmVar73 = this.ehy.egt;
                            fmVar73.emS.op();
                            return;
                        }
                        fmVar26 = this.ehy.egt;
                        if (view != fmVar26.eor) {
                            fmVar27 = this.ehy.egt;
                            if (fmVar27.emS.aMp() != null) {
                                fmVar67 = this.ehy.egt;
                                if (view == fmVar67.emS.aMp().aKG()) {
                                    fmVar68 = this.ehy.egt;
                                    fmVar68.auE();
                                    pbModel104 = this.ehy.efE;
                                    if (pbModel104.ajK() != null) {
                                        fmVar69 = this.ehy.egt;
                                        pbModel105 = this.ehy.efE;
                                        fmVar69.a(pbModel105.ajK(), this.ehy.dPZ);
                                    }
                                    TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                    return;
                                }
                            }
                            fmVar28 = this.ehy.egt;
                            if (fmVar28.emS.aMp() != null) {
                                fmVar66 = this.ehy.egt;
                            }
                            if (view.getId() != w.h.pb_sort) {
                                fmVar29 = this.ehy.egt;
                                if (fmVar29.emS.aMp() != null) {
                                    fmVar61 = this.ehy.egt;
                                    if (view == fmVar61.emS.aMp().aKI()) {
                                        pbModel98 = this.ehy.efE;
                                        if (pbModel98 != null) {
                                            pbModel99 = this.ehy.efE;
                                            if (pbModel99.getPbData() != null) {
                                                pbModel100 = this.ehy.efE;
                                                if (pbModel100.getPbData().aHG() != null) {
                                                    fmVar62 = this.ehy.egt;
                                                    fmVar62.emS.op();
                                                    PbActivity pbActivity2 = this.ehy;
                                                    pbModel101 = this.ehy.efE;
                                                    pbActivity2.nD(pbModel101.getPbData().aHG().rO());
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                fmVar30 = this.ehy.egt;
                                if (fmVar30.emS.aMp() != null) {
                                    fmVar57 = this.ehy.egt;
                                    if (view == fmVar57.emS.aMp().aKJ()) {
                                        TiebaStatic.log("c10414");
                                        fmVar58 = this.ehy.egt;
                                        fmVar58.auE();
                                        fmVar59 = this.ehy.egt;
                                        if (fmVar59.rm() != fm.eoE) {
                                            pbModel96 = this.ehy.efE;
                                            if (pbModel96.aKr() != null) {
                                                pbModel97 = this.ehy.efE;
                                                pbModel97.aKr().od(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                                return;
                                            }
                                            return;
                                        }
                                        fmVar60 = this.ehy.egt;
                                        fmVar60.aLX();
                                        return;
                                    }
                                }
                                fmVar31 = this.ehy.egt;
                                if (fmVar31.emS.aMp() != null) {
                                    fmVar54 = this.ehy.egt;
                                    if (view == fmVar54.emS.aMp().aKK()) {
                                        aIQ = this.ehy.aIQ();
                                        this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.ehy.getPageContext().getPageActivity(), null, aIQ, true)));
                                        fmVar55 = this.ehy.egt;
                                        fmVar55.emS.op();
                                        fmVar56 = this.ehy.egt;
                                        fmVar56.emS.aMp().aKR();
                                        return;
                                    }
                                }
                                ecVar = this.ehy.egy;
                                if (ecVar != null) {
                                    ecVar48 = this.ehy.egy;
                                    if (view == ecVar48.aKA()) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 4));
                                        if (!com.baidu.adp.lib.util.i.hk()) {
                                            this.ehy.showToast(w.l.network_not_available);
                                            return;
                                        }
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(w.h.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(w.h.tag_from, 0);
                                                    sparseArray2.put(w.h.tag_check_mute_from, 2);
                                                    this.ehy.d(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        this.ehy.nD((String) tag);
                                        return;
                                    }
                                }
                                ecVar2 = this.ehy.egy;
                                if (ecVar2 != null) {
                                    ecVar47 = this.ehy.egy;
                                    if (view == ecVar47.aKy()) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 2));
                                        if (!this.ehy.checkUpIsLogin()) {
                                            return;
                                        }
                                        this.ehy.aS(view);
                                        return;
                                    }
                                }
                                ecVar3 = this.ehy.egy;
                                if (ecVar3 != null) {
                                    ecVar45 = this.ehy.egy;
                                    if (view == ecVar45.aKD()) {
                                        ecVar46 = this.ehy.egy;
                                        if (ecVar46.aKF()) {
                                            com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c12007");
                                            pbModel95 = this.ehy.efE;
                                            TiebaStatic.log(asVar2.aa("tid", pbModel95.ejv));
                                        } else {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11739").s("obj_locate", 1));
                                        }
                                        if (this.ehy.checkUpIsLogin()) {
                                            pbModel90 = this.ehy.efE;
                                            if (pbModel90.getPbData() != null) {
                                                fmVar53 = this.ehy.egt;
                                                fmVar53.auE();
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
                                                    pbModel91 = this.ehy.efE;
                                                    String threadID = pbModel91.getThreadID();
                                                    String id2 = postData2.getId();
                                                    int i5 = 0;
                                                    pbModel92 = this.ehy.efE;
                                                    if (pbModel92.getPbData() != null) {
                                                        pbModel94 = this.ehy.efE;
                                                        i5 = pbModel94.getPbData().aHR();
                                                    }
                                                    this.ehy.Zo();
                                                    nG4 = this.ehy.nG(id2);
                                                    if (nG4 != null) {
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.ehy.getPageContext().getPageActivity());
                                                        SmallTailInfo aNs = postData2.aNs();
                                                        pbModel93 = this.ehy.efE;
                                                        this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i5, aNs, pbModel93.getPbData().ql(), false, postData2.getAuthor().getIconInfo()).addBigImageData(nG4.ehP, nG4.ehQ, nG4.ehR, nG4.index)));
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
                                ecVar4 = this.ehy.egy;
                                if (ecVar4 != null) {
                                    ecVar44 = this.ehy.egy;
                                    if (view == ecVar44.aKB()) {
                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                        if (sparseArray3 != null && (sparseArray3.get(w.h.tag_del_post_type) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_id) instanceof String) && (sparseArray3.get(w.h.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                            boolean booleanValue = ((Boolean) sparseArray3.get(w.h.tag_del_post_is_self)).booleanValue();
                                            int intValue = ((Integer) sparseArray3.get(w.h.tag_manage_user_identity)).intValue();
                                            if (!booleanValue && intValue != 0 && com.baidu.tieba.c.a.SJ()) {
                                                Context baseContext = this.ehy.getBaseContext();
                                                pbModel89 = this.ehy.efE;
                                                if (com.baidu.tieba.c.a.h(baseContext, pbModel89.getThreadID(), (String) sparseArray3.get(w.h.tag_del_post_id))) {
                                                    return;
                                                }
                                            }
                                            fmVar52 = this.ehy.egt;
                                            fmVar52.a(((Integer) sparseArray3.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray3.get(w.h.tag_del_post_id), intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ecVar5 = this.ehy.egy;
                                if (ecVar5 != null) {
                                    ecVar43 = this.ehy.egy;
                                    if (view == ecVar43.aKC()) {
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
                                        pbModel88 = this.ehy.efE;
                                        com.baidu.tieba.pb.data.f pbData = pbModel88.getPbData();
                                        String str3 = null;
                                        String str4 = null;
                                        String str5 = null;
                                        if (pbData != null && pbData.aHE() != null) {
                                            str3 = pbData.aHE().getId();
                                            str4 = pbData.aHE().getName();
                                            str5 = pbData.getThreadId();
                                        }
                                        com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                        this.ehy.a(j, str2, str3, str4, str5, i6);
                                        return;
                                    }
                                }
                                fmVar32 = this.ehy.egt;
                                if (fmVar32.aLY() == view) {
                                    fmVar51 = this.ehy.egt;
                                    if (fmVar51.aLY().getIndicateStatus()) {
                                        pbModel87 = this.ehy.efE;
                                        com.baidu.tieba.pb.data.f pbData2 = pbModel87.getPbData();
                                        if (pbData2 != null && pbData2.aHG() != null && pbData2.aHG().rh() != null) {
                                            String pF = pbData2.aHG().rh().pF();
                                            if (StringUtils.isNull(pF)) {
                                                pF = pbData2.aHG().rh().getTaskId();
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11107").aa("obj_id", pF));
                                        }
                                    } else {
                                        com.baidu.tieba.tbadkCore.d.a.ca("c10725", null);
                                    }
                                    this.ehy.aJl();
                                    return;
                                }
                                fmVar33 = this.ehy.egt;
                                if (fmVar33.aLx() != view) {
                                    ecVar6 = this.ehy.egy;
                                    if (ecVar6 != null) {
                                        ecVar42 = this.ehy.egy;
                                        if (view == ecVar42.aKz()) {
                                            if (!com.baidu.adp.lib.util.i.hk()) {
                                                this.ehy.showToast(w.l.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                            if (sparseArray4 != null) {
                                                if (com.baidu.tieba.c.a.SJ() && sparseArray4.get(w.h.tag_del_post_id) != null) {
                                                    Context baseContext2 = this.ehy.getBaseContext();
                                                    pbModel85 = this.ehy.efE;
                                                    if (com.baidu.tieba.c.a.h(baseContext2, pbModel85.getThreadID(), (String) sparseArray4.get(w.h.tag_del_post_id))) {
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
                                                        this.ehy.d(sparseArray4);
                                                        return;
                                                    }
                                                    sparseArray4.put(w.h.tag_check_mute_from, 2);
                                                    fmVar50 = this.ehy.egt;
                                                    fmVar50.aW(view);
                                                    return;
                                                } else if (booleanValue3) {
                                                    fmVar49 = this.ehy.egt;
                                                    fmVar49.a(((Integer) sparseArray4.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray4.get(w.h.tag_del_post_id), ((Integer) sparseArray4.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(w.h.tag_del_post_is_self)).booleanValue());
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    fmVar34 = this.ehy.egt;
                                    if (fmVar34.emS.aMp() != null) {
                                        fmVar46 = this.ehy.egt;
                                        if (view == fmVar46.emS.aMp().aKQ()) {
                                            if (com.baidu.adp.lib.util.i.hk()) {
                                                fmVar47 = this.ehy.egt;
                                                fmVar47.auE();
                                                fmVar48 = this.ehy.egt;
                                                pbModel79 = this.ehy.efE;
                                                com.baidu.tieba.pb.data.f pbData3 = pbModel79.getPbData();
                                                pbModel80 = this.ehy.efE;
                                                SparseArray<Object> c = fmVar48.c(pbData3, pbModel80.aJT(), 1);
                                                if (c != null) {
                                                    pbModel81 = this.ehy.efE;
                                                    PbActivity pbActivity3 = this.ehy;
                                                    Activity pageActivity = this.ehy.getPageContext().getPageActivity();
                                                    pbModel82 = this.ehy.efE;
                                                    String id3 = pbModel82.getPbData().aHE().getId();
                                                    pbModel83 = this.ehy.efE;
                                                    String name2 = pbModel83.getPbData().aHE().getName();
                                                    pbModel84 = this.ehy.efE;
                                                    pbActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id3, name2, pbModel84.getPbData().aHG().getId(), String.valueOf(pbModel81.getPbData().getUserData().getUserId()), (String) c.get(w.h.tag_forbid_user_name), (String) c.get(w.h.tag_forbid_user_post_id))));
                                                    return;
                                                }
                                                return;
                                            }
                                            this.ehy.showToast(w.l.network_not_available);
                                            return;
                                        }
                                    }
                                    fmVar35 = this.ehy.egt;
                                    if (fmVar35.emS.aMp() != null) {
                                        fmVar42 = this.ehy.egt;
                                        if (view == fmVar42.emS.aMp().aKN()) {
                                            if (com.baidu.adp.lib.util.i.hk()) {
                                                fmVar43 = this.ehy.egt;
                                                pbModel77 = this.ehy.efE;
                                                com.baidu.tieba.pb.data.f pbData4 = pbModel77.getPbData();
                                                pbModel78 = this.ehy.efE;
                                                SparseArray<Object> c2 = fmVar43.c(pbData4, pbModel78.aJT(), 1);
                                                if (c2 != null) {
                                                    fmVar45 = this.ehy.egt;
                                                    fmVar45.a(((Integer) c2.get(w.h.tag_del_post_type)).intValue(), (String) c2.get(w.h.tag_del_post_id), ((Integer) c2.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(w.h.tag_del_post_is_self)).booleanValue());
                                                }
                                                fmVar44 = this.ehy.egt;
                                                fmVar44.emS.op();
                                                return;
                                            }
                                            this.ehy.showToast(w.l.network_not_available);
                                            return;
                                        }
                                    }
                                    if (view.getId() != w.h.sub_pb_more && view.getId() != w.h.sub_pb_item && view.getId() != w.h.pb_floor_reply_more) {
                                        fmVar37 = this.ehy.egt;
                                        if (view != fmVar37.aIH()) {
                                            fmVar38 = this.ehy.egt;
                                            if (view == fmVar38.emS.aMq()) {
                                                fmVar41 = this.ehy.egt;
                                                fmVar41.aLL();
                                                return;
                                            }
                                            int id4 = view.getId();
                                            if (id4 == w.h.pb_u9_text_view) {
                                                if (this.ehy.checkUpIsLogin() && (bqVar = (com.baidu.tbadk.core.data.bq) view.getTag()) != null && !StringUtils.isNull(bqVar.sS())) {
                                                    TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.bb.vB().c(this.ehy.getPageContext(), new String[]{bqVar.sS()});
                                                    return;
                                                }
                                                return;
                                            } else if ((id4 == w.h.pb_floor_agree || id4 == w.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                if (this.ehy.checkUpIsLogin() && (postData = (PostData) view.getTag(w.h.tag_clip_board)) != null) {
                                                    if (postData.bgZ()) {
                                                        postData.cm(postData.bgY() - 1);
                                                    } else {
                                                        postData.cm(postData.bgY() + 1);
                                                    }
                                                    postData.kY(!postData.bgZ());
                                                    ((PbFloorAgreeView) view).a(postData.bgZ(), postData.bgY(), true);
                                                    int i7 = postData.bgZ() ? 0 : 1;
                                                    pbModel22 = this.ehy.efE;
                                                    pbModel22.aKs().ao(postData.getId(), i7);
                                                    int i8 = 2;
                                                    if (postData.getAuthor() != null && postData.getAuthor().getUserId() != null) {
                                                        i8 = postData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) ? 1 : 2;
                                                    }
                                                    if (postData.bgZ()) {
                                                        com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c12003");
                                                        pbModel24 = this.ehy.efE;
                                                        TiebaStatic.log(asVar3.aa("tid", pbModel24.ejv).s("obj_id", i8));
                                                        return;
                                                    }
                                                    com.baidu.tbadk.core.util.as asVar4 = new com.baidu.tbadk.core.util.as("c12008");
                                                    pbModel23 = this.ehy.efE;
                                                    TiebaStatic.log(asVar4.aa("tid", pbModel23.ejv).s("obj_id", i8));
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.view_main_thread_praise_state) {
                                                if (this.ehy.checkUpIsLogin()) {
                                                    if (!com.baidu.adp.lib.util.k.hB()) {
                                                        this.ehy.showToast(w.l.no_network_guide);
                                                        return;
                                                    }
                                                    com.baidu.tieba.pb.data.k kVar = (com.baidu.tieba.pb.data.k) view.getTag(w.h.pb_main_thread_praise_data);
                                                    fj fjVar = (fj) view.getTag(w.h.pb_main_thread_praise_view);
                                                    if (kVar != null && fjVar != null) {
                                                        if (kVar.aIl()) {
                                                            kVar.aIo();
                                                            i2 = 1;
                                                        } else {
                                                            kVar.aIn();
                                                            i2 = 0;
                                                        }
                                                        pbModel65 = this.ehy.efE;
                                                        if (pbModel65 != null) {
                                                            pbModel66 = this.ehy.efE;
                                                            if (pbModel66.aKs() != null) {
                                                                String str6 = "";
                                                                pbModel67 = this.ehy.efE;
                                                                if (pbModel67.getPbData() != null) {
                                                                    pbModel72 = this.ehy.efE;
                                                                    if (pbModel72.getPbData().aHG() != null) {
                                                                        pbModel73 = this.ehy.efE;
                                                                        str6 = pbModel73.getPbData().aHG().rO();
                                                                    }
                                                                }
                                                                pbModel68 = this.ehy.efE;
                                                                if (pbModel68.getPbData() != null) {
                                                                    pbModel71 = this.ehy.efE;
                                                                    pbModel71.getPbData().a(kVar);
                                                                }
                                                                pbModel69 = this.ehy.efE;
                                                                dp aKs = pbModel69.aKs();
                                                                pbModel70 = this.ehy.efE;
                                                                aKs.a(str6, i2, 3, 2, pbModel70.getForumId());
                                                            }
                                                        }
                                                        fjVar.b(kVar);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.view_main_thread_praise_num || id4 == w.h.view_main_thread_praise_name_list) {
                                                if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                                                    pbModel25 = this.ehy.efE;
                                                    if (pbModel25 != null) {
                                                        pbModel26 = this.ehy.efE;
                                                        if (pbModel26.getPbData() != null) {
                                                            pbModel27 = this.ehy.efE;
                                                            if (!StringUtils.isNull(pbModel27.getPbData().getThreadId())) {
                                                                StringBuilder sb = new StringBuilder("https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=");
                                                                pbModel28 = this.ehy.efE;
                                                                com.baidu.tbadk.core.util.bb.vB().c(this.ehy.getPageContext(), new String[]{sb.append(pbModel28.getPbData().getThreadId()).toString()});
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
                                                ecVar7 = this.ehy.egy;
                                                if (ecVar7 == null) {
                                                    this.ehy.egy = new ec(this.ehy.getPageContext(), this.ehy.bPI);
                                                    ecVar41 = this.ehy.egy;
                                                    z7 = this.ehy.mIsLogin;
                                                    ecVar41.ih(z7);
                                                }
                                                ecVar8 = this.ehy.egy;
                                                ecVar8.showDialog();
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11740"));
                                                PostData postData4 = null;
                                                if (view != null && view.getTag() != null) {
                                                    postData4 = (PostData) ((SparseArray) view.getTag()).get(w.h.tag_load_sub_data);
                                                    boolean z11 = id4 == w.h.replybtn_top_right || id4 == w.h.cover_reply_content_top_right;
                                                    if (z11) {
                                                        com.baidu.tbadk.core.util.as asVar5 = new com.baidu.tbadk.core.util.as("c12006");
                                                        pbModel31 = this.ehy.efE;
                                                        TiebaStatic.log(asVar5.aa("tid", pbModel31.ejv));
                                                    }
                                                    SparseArray sparseArray5 = new SparseArray();
                                                    sparseArray5.put(w.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(w.h.tag_clip_board));
                                                    sparseArray5.put(w.h.tag_is_subpb, false);
                                                    ecVar13 = this.ehy.egy;
                                                    ecVar13.aKy().setTag(sparseArray5);
                                                    ecVar14 = this.ehy.egy;
                                                    ecVar14.aKD().setTag(view.getTag());
                                                    ecVar15 = this.ehy.egy;
                                                    ecVar15.ij(z11);
                                                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                    boolean booleanValue5 = ((Boolean) sparseArray6.get(w.h.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue6 = ((Boolean) sparseArray6.get(w.h.tag_user_mute_visible)).booleanValue();
                                                    boolean booleanValue7 = ((Boolean) sparseArray6.get(w.h.tag_should_delete_visible)).booleanValue();
                                                    if (!(sparseArray6.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                                        z3 = false;
                                                    } else {
                                                        z3 = ((Boolean) sparseArray6.get(w.h.tag_del_post_is_self)).booleanValue();
                                                    }
                                                    String str7 = null;
                                                    if (sparseArray6.get(w.h.tag_forbid_user_post_id) instanceof String) {
                                                        str7 = (String) sparseArray6.get(w.h.tag_forbid_user_post_id);
                                                    }
                                                    if (booleanValue5) {
                                                        SparseArray sparseArray7 = new SparseArray();
                                                        sparseArray7.put(w.h.tag_should_manage_visible, true);
                                                        sparseArray7.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                        sparseArray7.put(w.h.tag_forbid_user_name, sparseArray6.get(w.h.tag_forbid_user_name));
                                                        sparseArray7.put(w.h.tag_forbid_user_post_id, str7);
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
                                                            ecVar40 = this.ehy.egy;
                                                            ecVar40.aKB().setVisibility(0);
                                                        } else {
                                                            sparseArray7.put(w.h.tag_should_delete_visible, false);
                                                            ecVar35 = this.ehy.egy;
                                                            ecVar35.aKB().setVisibility(8);
                                                        }
                                                        ecVar36 = this.ehy.egy;
                                                        ecVar36.aKz().setTag(sparseArray7);
                                                        ecVar37 = this.ehy.egy;
                                                        ecVar37.aKB().setTag(sparseArray7);
                                                        ecVar38 = this.ehy.egy;
                                                        ecVar38.aKz().setText(w.l.bar_manager);
                                                        ecVar39 = this.ehy.egy;
                                                        ecVar39.aKz().setVisibility(0);
                                                    } else if (!booleanValue7) {
                                                        ecVar16 = this.ehy.egy;
                                                        ecVar16.aKz().setVisibility(8);
                                                        ecVar17 = this.ehy.egy;
                                                        ecVar17.aKB().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray8 = new SparseArray();
                                                        sparseArray8.put(w.h.tag_should_manage_visible, false);
                                                        sparseArray8.put(w.h.tag_user_mute_visible, false);
                                                        sparseArray8.put(w.h.tag_should_delete_visible, true);
                                                        sparseArray8.put(w.h.tag_manage_user_identity, sparseArray6.get(w.h.tag_manage_user_identity));
                                                        sparseArray8.put(w.h.tag_del_post_is_self, Boolean.valueOf(z3));
                                                        sparseArray8.put(w.h.tag_del_post_id, sparseArray6.get(w.h.tag_del_post_id));
                                                        sparseArray8.put(w.h.tag_del_post_type, sparseArray6.get(w.h.tag_del_post_type));
                                                        ecVar18 = this.ehy.egy;
                                                        ecVar18.aKz().setTag(sparseArray8);
                                                        ecVar19 = this.ehy.egy;
                                                        ecVar19.aKB().setTag(sparseArray8);
                                                        ecVar20 = this.ehy.egy;
                                                        ecVar20.aKz().setText(w.l.delete);
                                                        ecVar21 = this.ehy.egy;
                                                        ecVar21.aKB().setVisibility(0);
                                                        ecVar22 = this.ehy.egy;
                                                        ecVar22.aKz().setVisibility(8);
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
                                                        ecVar31 = this.ehy.egy;
                                                        ecVar31.aKA().setTag(sparseArray10);
                                                        ecVar32 = this.ehy.egy;
                                                        ecVar32.aKA().setVisibility(0);
                                                        ecVar33 = this.ehy.egy;
                                                        ecVar33.aKz().setVisibility(8);
                                                        ecVar34 = this.ehy.egy;
                                                        ecVar34.aKA().setText(w.l.mute_option);
                                                    } else {
                                                        if (!(sparseArray9.get(w.h.tag_del_post_is_self) instanceof Boolean)) {
                                                            z5 = false;
                                                        } else {
                                                            z5 = ((Boolean) sparseArray9.get(w.h.tag_del_post_is_self)).booleanValue();
                                                        }
                                                        String str8 = null;
                                                        if (sparseArray9.get(w.h.tag_forbid_user_post_id) instanceof String) {
                                                            str8 = (String) sparseArray9.get(w.h.tag_forbid_user_post_id);
                                                        }
                                                        hS = this.ehy.hS(z5);
                                                        boolean isLogin = hS & this.ehy.isLogin();
                                                        this.ehy.eho = (PostData) sparseArray9.get(w.h.tag_clip_board);
                                                        if (fl.h(this.ehy.eho) ? false : isLogin) {
                                                            ecVar24 = this.ehy.egy;
                                                            ecVar24.aKA().setVisibility(0);
                                                            ecVar25 = this.ehy.egy;
                                                            ecVar25.aKA().setTag(str8);
                                                        } else {
                                                            ecVar23 = this.ehy.egy;
                                                            ecVar23.aKA().setVisibility(8);
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
                                                        ecVar27 = this.ehy.egy;
                                                        ecVar27.aKC().setVisibility(0);
                                                        ecVar28 = this.ehy.egy;
                                                        ecVar28.aKC().setTag(w.h.tag_chudian_template_id, Long.valueOf(j2));
                                                        ecVar29 = this.ehy.egy;
                                                        ecVar29.aKC().setTag(w.h.tag_chudian_monitor_id, str);
                                                        ecVar30 = this.ehy.egy;
                                                        ecVar30.aKC().setTag(w.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                    } else {
                                                        ecVar26 = this.ehy.egy;
                                                        ecVar26.aKC().setVisibility(8);
                                                    }
                                                }
                                                pbModel29 = this.ehy.efE;
                                                if (pbModel29.getPbData().nL()) {
                                                    pbModel30 = this.ehy.efE;
                                                    String nK = pbModel30.getPbData().nK();
                                                    if (postData4 != null && !com.baidu.adp.lib.util.j.isEmpty(nK) && nK.equals(postData4.getId())) {
                                                        z2 = true;
                                                        if (!z2) {
                                                            ecVar12 = this.ehy.egy;
                                                            ecVar12.aKy().setText(w.l.remove_mark);
                                                        } else {
                                                            ecVar9 = this.ehy.egy;
                                                            ecVar9.aKy().setText(w.l.mark);
                                                        }
                                                        ecVar10 = this.ehy.egy;
                                                        ecVar10.ii(true);
                                                        ecVar11 = this.ehy.egy;
                                                        ecVar11.refreshUI();
                                                        return;
                                                    }
                                                }
                                                z2 = false;
                                                if (!z2) {
                                                }
                                                ecVar10 = this.ehy.egy;
                                                ecVar10.ii(true);
                                                ecVar11 = this.ehy.egy;
                                                ecVar11.refreshUI();
                                                return;
                                            } else if (id4 == w.h.pb_act_btn) {
                                                pbModel59 = this.ehy.efE;
                                                if (pbModel59.getPbData() != null) {
                                                    pbModel60 = this.ehy.efE;
                                                    if (pbModel60.getPbData().aHG() != null) {
                                                        pbModel61 = this.ehy.efE;
                                                        if (pbModel61.getPbData().aHG().se() != null) {
                                                            Activity activity = this.ehy.getActivity();
                                                            pbModel62 = this.ehy.efE;
                                                            com.baidu.tbadk.browser.f.S(activity, pbModel62.getPbData().aHG().se());
                                                            pbModel63 = this.ehy.efE;
                                                            if (pbModel63.getPbData().aHG().sc() != 1) {
                                                                pbModel64 = this.ehy.efE;
                                                                if (pbModel64.getPbData().aHG().sc() == 2) {
                                                                    TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.lottery_tail) {
                                                if (view.getTag(w.h.tag_pb_lottery_tail_link) instanceof String) {
                                                    String str9 = (String) view.getTag(w.h.tag_pb_lottery_tail_link);
                                                    com.baidu.tbadk.core.util.as asVar6 = new com.baidu.tbadk.core.util.as("c10912");
                                                    pbModel56 = this.ehy.efE;
                                                    com.baidu.tbadk.core.util.as aa = asVar6.aa("fid", pbModel56.getPbData().getForumId());
                                                    pbModel57 = this.ehy.efE;
                                                    TiebaStatic.log(aa.aa("tid", pbModel57.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str9, "_", TbadkCoreApplication.getCurrentAccount())));
                                                    pbModel58 = this.ehy.efE;
                                                    if (pbModel58.getPbData().getThreadId().equals(str9)) {
                                                        fmVar40 = this.ehy.egt;
                                                        fmVar40.setSelection(0);
                                                        return;
                                                    }
                                                    this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ehy.getActivity()).createNormalCfg(str9, (String) null, (String) null, (String) null)));
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.pb_item_tail_content) {
                                                if (com.baidu.tbadk.core.util.bg.aN(this.ehy.getPageContext().getPageActivity())) {
                                                    String string = TbadkCoreApplication.m9getInst().getString(w.l.tail_web_view_title);
                                                    String string2 = com.baidu.tbadk.core.sharedPref.b.tX().getString("tail_link", "");
                                                    if (!StringUtils.isNull(string2)) {
                                                        TiebaStatic.log("c10056");
                                                        com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                    }
                                                    fmVar39 = this.ehy.egt;
                                                    fmVar39.aLl();
                                                    return;
                                                }
                                                return;
                                            } else if (id4 == w.h.join_vote_tv) {
                                                if (view != null) {
                                                    com.baidu.tbadk.browser.f.S(this.ehy.getActivity(), (String) view.getTag());
                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                    aIR3 = this.ehy.aIR();
                                                    if (aIR3 == 1) {
                                                        pbModel52 = this.ehy.efE;
                                                        if (pbModel52 != null) {
                                                            pbModel53 = this.ehy.efE;
                                                            if (pbModel53.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.as asVar7 = new com.baidu.tbadk.core.util.as("c10397");
                                                                pbModel54 = this.ehy.efE;
                                                                com.baidu.tbadk.core.util.as aa2 = asVar7.aa("fid", pbModel54.getPbData().getForumId());
                                                                pbModel55 = this.ehy.efE;
                                                                TiebaStatic.log(aa2.aa("tid", pbModel55.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    aIR4 = this.ehy.aIR();
                                                    if (aIR4 == 2) {
                                                        pbModel48 = this.ehy.efE;
                                                        if (pbModel48 != null) {
                                                            pbModel49 = this.ehy.efE;
                                                            if (pbModel49.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.as asVar8 = new com.baidu.tbadk.core.util.as("c10401");
                                                                pbModel50 = this.ehy.efE;
                                                                com.baidu.tbadk.core.util.as aa3 = asVar8.aa("fid", pbModel50.getPbData().getForumId());
                                                                pbModel51 = this.ehy.efE;
                                                                TiebaStatic.log(aa3.aa("tid", pbModel51.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                    com.baidu.tbadk.browser.f.S(this.ehy.getActivity(), (String) view.getTag());
                                                    aIR = this.ehy.aIR();
                                                    if (aIR == 1) {
                                                        pbModel44 = this.ehy.efE;
                                                        if (pbModel44 != null) {
                                                            pbModel45 = this.ehy.efE;
                                                            if (pbModel45.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.as asVar9 = new com.baidu.tbadk.core.util.as("c10507");
                                                                pbModel46 = this.ehy.efE;
                                                                com.baidu.tbadk.core.util.as aa4 = asVar9.aa("fid", pbModel46.getPbData().getForumId());
                                                                pbModel47 = this.ehy.efE;
                                                                TiebaStatic.log(aa4.aa("tid", pbModel47.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    aIR2 = this.ehy.aIR();
                                                    if (aIR2 == 2) {
                                                        pbModel40 = this.ehy.efE;
                                                        if (pbModel40 != null) {
                                                            pbModel41 = this.ehy.efE;
                                                            if (pbModel41.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.as asVar10 = new com.baidu.tbadk.core.util.as("c10508");
                                                                pbModel42 = this.ehy.efE;
                                                                com.baidu.tbadk.core.util.as aa5 = asVar10.aa("fid", pbModel42.getPbData().getForumId());
                                                                pbModel43 = this.ehy.efE;
                                                                TiebaStatic.log(aa5.aa("tid", pbModel43.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
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
                                                        pbModel36 = this.ehy.efE;
                                                        if (pbModel36 != null) {
                                                            pbModel37 = this.ehy.efE;
                                                            if (pbModel37.getPbData() != null) {
                                                                pbModel38 = this.ehy.efE;
                                                                if (pbModel38.getPbData().aHY() != null) {
                                                                    pbModel39 = this.ehy.efE;
                                                                    com.baidu.tieba.pb.data.f pbData5 = pbModel39.getPbData();
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11679").aa("fid", pbData5.getForumId()));
                                                                    com.baidu.tbadk.core.util.bb.vB().c(this.ehy.getPageContext(), new String[]{pbData5.aHY().aIf()});
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id4 == w.h.yule_head_img_all_rank) {
                                                        pbModel32 = this.ehy.efE;
                                                        if (pbModel32 != null) {
                                                            pbModel33 = this.ehy.efE;
                                                            if (pbModel33.getPbData() != null) {
                                                                pbModel34 = this.ehy.efE;
                                                                if (pbModel34.getPbData().aHY() != null) {
                                                                    pbModel35 = this.ehy.efE;
                                                                    com.baidu.tieba.pb.data.f pbData6 = pbModel35.getPbData();
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11678").aa("fid", pbData6.getForumId()));
                                                                    com.baidu.tbadk.core.util.bb.vB().c(this.ehy.getPageContext(), new String[]{pbData6.aHY().aIf()});
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
                                                this.ehy.aJh();
                                                return;
                                            } else {
                                                this.ehy.aJg();
                                                return;
                                            }
                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                            long c3 = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                            pbModel74 = this.ehy.efE;
                                            long c4 = com.baidu.adp.lib.g.b.c(pbModel74.getPbData().getForumId(), 0L);
                                            pbModel75 = this.ehy.efE;
                                            long c5 = com.baidu.adp.lib.g.b.c(pbModel75.getThreadID(), 0L);
                                            pbModel76 = this.ehy.efE;
                                            this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.ehy.getPageContext().getPageActivity(), 24008, c4, c5, c3, pbModel76.getPbData().aHG().rS())));
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (this.ehy.checkUpIsLogin()) {
                                        pbModel7 = this.ehy.efE;
                                        if (pbModel7.getPbData() != null) {
                                            fmVar36 = this.ehy.egt;
                                            fmVar36.auE();
                                            SparseArray sparseArray12 = (SparseArray) view.getTag();
                                            PostData postData5 = (PostData) sparseArray12.get(w.h.tag_load_sub_data);
                                            View view2 = (View) sparseArray12.get(w.h.tag_load_sub_view);
                                            if (postData5 != null && view2 != null) {
                                                pbModel8 = this.ehy.efE;
                                                String threadID2 = pbModel8.getThreadID();
                                                String id5 = postData5.getId();
                                                int i9 = 0;
                                                pbModel9 = this.ehy.efE;
                                                if (pbModel9.getPbData() != null) {
                                                    pbModel20 = this.ehy.efE;
                                                    i9 = pbModel20.getPbData().aHR();
                                                }
                                                this.ehy.Zo();
                                                if (view.getId() != w.h.replybtn) {
                                                    if (view.getId() == w.h.sub_pb_item) {
                                                        SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                        String str10 = (String) sparseArray13.get(w.h.tag_photo_username);
                                                        String str11 = (String) sparseArray12.get(w.h.tag_photo_userid);
                                                        PostData postData6 = (PostData) sparseArray13.get(w.h.tag_load_sub_data);
                                                        String str12 = null;
                                                        if (postData6 != null) {
                                                            str12 = postData6.getId();
                                                        }
                                                        TiebaStatic.log("c11741");
                                                        nG2 = this.ehy.nG(id5);
                                                        pbModel13 = this.ehy.efE;
                                                        if (pbModel13 != null) {
                                                            pbModel14 = this.ehy.efE;
                                                            if (pbModel14.getPbData() != null && nG2 != null && this.ehy.aIM().aLj() != null) {
                                                                com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                                                                pbModel15 = this.ehy.efE;
                                                                lVar2.b(pbModel15.getPbData().aHE());
                                                                pbModel16 = this.ehy.efE;
                                                                lVar2.m(pbModel16.getPbData().aHG());
                                                                lVar2.d(postData6);
                                                                this.ehy.aIM().aLj().d(lVar2);
                                                                this.ehy.aIM().aLj().setPostId(str12);
                                                                this.ehy.a(view, str11, str10);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    TiebaStatic.log("c11742");
                                                    nG = this.ehy.nG(id5);
                                                    if (postData5 != null) {
                                                        pbModel10 = this.ehy.efE;
                                                        if (pbModel10 != null) {
                                                            pbModel11 = this.ehy.efE;
                                                            if (pbModel11.getPbData() != null && nG != null) {
                                                                SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.ehy.getPageContext().getPageActivity());
                                                                SmallTailInfo aNs2 = postData5.aNs();
                                                                pbModel12 = this.ehy.efE;
                                                                this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id5, "pb", true, null, false, null, i9, aNs2, pbModel12.getPbData().ql(), false, postData5.getAuthor().getIconInfo()).addBigImageData(nG.ehP, nG.ehQ, nG.ehR, nG.index)));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                nG3 = this.ehy.nG(id5);
                                                pbModel17 = this.ehy.efE;
                                                if (pbModel17 != null) {
                                                    pbModel18 = this.ehy.efE;
                                                    if (pbModel18.getPbData() != null && nG3 != null) {
                                                        SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.ehy.getPageContext().getPageActivity());
                                                        SmallTailInfo aNs3 = postData5.aNs();
                                                        pbModel19 = this.ehy.efE;
                                                        this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id5, "pb", true, null, true, null, i9, aNs3, pbModel19.getPbData().ql(), false, postData5.getAuthor().getIconInfo()).addBigImageData(nG3.ehP, nG3.ehQ, nG3.ehR, nG3.index)));
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
                                        pbModel21 = this.ehy.efE;
                                        TiebaStatic.log(s.aa("fid", pbModel21.getPbData().getForumId()));
                                        return;
                                    }
                                } else if (!this.ehy.checkUpIsLogin()) {
                                    com.baidu.tbadk.core.util.as s2 = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 2);
                                    pbModel86 = this.ehy.efE;
                                    TiebaStatic.log(s2.aa("fid", pbModel86.getPbData().getForumId()));
                                    return;
                                } else {
                                    this.ehy.aIJ();
                                    return;
                                }
                            }
                            fmVar63 = this.ehy.egt;
                            fmVar63.auE();
                            if (!com.baidu.adp.lib.util.i.hk()) {
                                this.ehy.showToast(w.l.network_not_available);
                                return;
                            }
                            this.ehy.nZ(2);
                            this.ehy.Zo();
                            fmVar64 = this.ehy.egt;
                            fmVar64.aLD();
                            fmVar65 = this.ehy.egt;
                            fmVar65.aLy().hX(true);
                            boolean z12 = false;
                            if (view.getTag() instanceof Boolean) {
                                pbModel103 = this.ehy.efE;
                                z12 = pbModel103.ie(!((Boolean) view.getTag()).booleanValue());
                            } else {
                                pbModel102 = this.ehy.efE;
                                pbModel102.aKd();
                            }
                            TiebaStatic.log("c12097");
                            if (z12 && this.ehy.getListView() != null) {
                                i3 = this.ehy.egN;
                                if (i3 > this.ehy.getListView().getFirstVisiblePosition()) {
                                    this.ehy.egN = this.ehy.getListView().getFirstVisiblePosition();
                                }
                                View childAt = this.ehy.getListView().getChildAt(0);
                                int i10 = -1;
                                if (childAt != null) {
                                    i10 = childAt.getTop();
                                }
                                fm aIM = this.ehy.aIM();
                                i4 = this.ehy.egN;
                                aIM.i(i4, i10);
                                return;
                            }
                            return;
                        } else if (this.ehy.checkUpIsLogin()) {
                            fmVar70 = this.ehy.egt;
                            fmVar70.auE();
                            this.ehy.Zo();
                            this.ehy.nZ(2);
                            pbModel106 = this.ehy.efE;
                            if (pbModel106 != null) {
                                pbModel107 = this.ehy.efE;
                                if (pbModel107.getPbData() != null) {
                                    pbModel108 = this.ehy.efE;
                                    if (pbModel108.getPbData().aHY() != null) {
                                        pbModel109 = this.ehy.efE;
                                        if (!StringUtils.isNull(pbModel109.getPbData().aHY().pT(), true)) {
                                            com.baidu.tbadk.core.util.as asVar11 = new com.baidu.tbadk.core.util.as("c11678");
                                            pbModel110 = this.ehy.efE;
                                            TiebaStatic.log(asVar11.aa("fid", pbModel110.getPbData().getForumId()));
                                        }
                                    }
                                }
                            }
                            PbActivity pbActivity4 = this.ehy;
                            fmVar71 = this.ehy.egt;
                            pbActivity4.oa(view == fmVar71.eor ? 1 : 2);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11939"));
                            return;
                        } else {
                            return;
                        }
                    }
                    if (com.baidu.adp.lib.util.i.hk()) {
                        fmVar75 = this.ehy.egt;
                        fmVar75.auE();
                        fmVar76 = this.ehy.egt;
                        fmVar76.aLl();
                        z8 = this.ehy.mIsLoading;
                        if (!z8) {
                            fmVar77 = this.ehy.egt;
                            fmVar77.emS.eqb.setEnabled(false);
                            this.ehy.Zo();
                            fmVar78 = this.ehy.egt;
                            fmVar78.aLD();
                            if (view.getId() == w.h.floor_owner_reply) {
                                pbModel113 = this.ehy.efE;
                                aJe4 = this.ehy.aJe();
                                nI = pbModel113.h(true, aJe4);
                            } else if (view.getId() == w.h.reply_title) {
                                pbModel112 = this.ehy.efE;
                                aJe3 = this.ehy.aJe();
                                nI = pbModel112.h(false, aJe3);
                            } else {
                                pbModel111 = this.ehy.efE;
                                aJe2 = this.ehy.aJe();
                                nI = pbModel111.nI(aJe2);
                            }
                            if (nI) {
                                fmVar79 = this.ehy.egt;
                                fmVar79.apn();
                                this.ehy.mIsLoading = true;
                            }
                            TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                            this.ehy.nZ(2);
                            return;
                        }
                        return;
                    }
                    this.ehy.showToast(w.l.network_not_available);
                    return;
                } else if (com.baidu.adp.lib.util.i.hk()) {
                    fmVar19 = this.ehy.egt;
                    fmVar19.aLl();
                    z = this.ehy.mIsLoading;
                    if (!z) {
                        this.ehy.mIsLoading = true;
                        fmVar20 = this.ehy.egt;
                        fmVar20.emS.eqb.setEnabled(false);
                        fmVar21 = this.ehy.egt;
                        fmVar21.apn();
                        this.ehy.Zo();
                        fmVar22 = this.ehy.egt;
                        fmVar22.aLD();
                        pbModel6 = this.ehy.efE;
                        aJe = this.ehy.aJe();
                        pbModel6.nI(aJe);
                        TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        this.ehy.nZ(2);
                        return;
                    }
                    return;
                } else {
                    this.ehy.showToast(w.l.network_not_available);
                    return;
                }
            }
            TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            pbModel119 = this.ehy.efE;
            if (pbModel119.getPbData() != null) {
                pbModel126 = this.ehy.efE;
                if (pbModel126.getPbData().aHG() != null) {
                    pbModel127 = this.ehy.efE;
                    if (pbModel127.getPbData().aHG().sl()) {
                        pbModel128 = this.ehy.efE;
                        if (pbModel128.getPbData().aHG().rP() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11922"));
                        }
                    }
                }
            }
            pbModel120 = this.ehy.efE;
            if (pbModel120.getErrorNo() == 4) {
                pbModel123 = this.ehy.efE;
                if (StringUtils.isNull(pbModel123.aJS())) {
                    pbModel124 = this.ehy.efE;
                    if (pbModel124.getAppealInfo() != null) {
                        pbModel125 = this.ehy.efE;
                        name = pbModel125.getAppealInfo().forumName;
                    }
                }
                this.ehy.finish();
                return;
            }
            pbModel121 = this.ehy.efE;
            name = pbModel121.getPbData().aHE().getName();
            if (!StringUtils.isNull(name)) {
                pbModel122 = this.ehy.efE;
                String aJS = pbModel122.aJS();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.ehy.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                if (StringUtils.isNull(aJS)) {
                    this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                } else if (aJS.equals(name)) {
                    this.ehy.finish();
                    return;
                } else {
                    this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return;
                }
            }
            this.ehy.finish();
            return;
        }
        if (com.baidu.adp.lib.util.i.hk()) {
            pbModel = this.ehy.efE;
            if (pbModel.getPbData().aHR() == 1) {
                forumManageModel = this.ehy.egs;
                if (!forumManageModel.bhy()) {
                    fmVar6 = this.ehy.egt;
                    fmVar6.auE();
                    int i11 = 0;
                    fmVar7 = this.ehy.egt;
                    if (fmVar7.emS.aMp() != null) {
                        fmVar13 = this.ehy.egt;
                        if (view == fmVar13.emS.aMp().aKM()) {
                            pbModel5 = this.ehy.efE;
                            if (pbModel5.getPbData().aHG().ru() == 1) {
                                i11 = 5;
                            } else {
                                i11 = 4;
                            }
                            pbModel3 = this.ehy.efE;
                            ForumData aHE = pbModel3.getPbData().aHE();
                            String name3 = aHE.getName();
                            String id6 = aHE.getId();
                            pbModel4 = this.ehy.efE;
                            id = pbModel4.getPbData().aHG().getId();
                            if (com.baidu.tieba.c.a.SJ() || !com.baidu.tieba.c.a.h(this.ehy.getBaseContext(), id, null)) {
                                fmVar11 = this.ehy.egt;
                                fmVar11.aLA();
                                forumManageModel2 = this.ehy.egs;
                                fmVar12 = this.ehy.egt;
                                forumManageModel2.a(id6, name3, id, i11, fmVar12.aLC());
                                return;
                            }
                            return;
                        }
                    }
                    fmVar8 = this.ehy.egt;
                    if (fmVar8.emS.aMp() != null) {
                        fmVar10 = this.ehy.egt;
                        if (view == fmVar10.emS.aMp().aKO()) {
                            pbModel2 = this.ehy.efE;
                            if (pbModel2.getPbData().aHG().rv() == 1) {
                                i11 = 3;
                            } else {
                                i11 = 6;
                            }
                            pbModel3 = this.ehy.efE;
                            ForumData aHE2 = pbModel3.getPbData().aHE();
                            String name32 = aHE2.getName();
                            String id62 = aHE2.getId();
                            pbModel4 = this.ehy.efE;
                            id = pbModel4.getPbData().aHG().getId();
                            if (com.baidu.tieba.c.a.SJ()) {
                            }
                            fmVar11 = this.ehy.egt;
                            fmVar11.aLA();
                            forumManageModel2 = this.ehy.egs;
                            fmVar12 = this.ehy.egt;
                            forumManageModel2.a(id62, name32, id, i11, fmVar12.aLC());
                            return;
                        }
                    }
                    fmVar9 = this.ehy.egt;
                    if (view == fmVar9.aLB()) {
                        i11 = 2;
                    }
                    pbModel3 = this.ehy.efE;
                    ForumData aHE22 = pbModel3.getPbData().aHE();
                    String name322 = aHE22.getName();
                    String id622 = aHE22.getId();
                    pbModel4 = this.ehy.efE;
                    id = pbModel4.getPbData().aHG().getId();
                    if (com.baidu.tieba.c.a.SJ()) {
                    }
                    fmVar11 = this.ehy.egt;
                    fmVar11.aLA();
                    forumManageModel2 = this.ehy.egs;
                    fmVar12 = this.ehy.egt;
                    forumManageModel2.a(id622, name322, id, i11, fmVar12.aLC());
                    return;
                }
                return;
            }
            return;
        }
        this.ehy.showToast(w.l.network_not_available);
    }
}
