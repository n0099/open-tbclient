package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v158, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x06f7, code lost:
        if (r21 == r1.dmZ.azQ().ayq()) goto L134;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:361:0x1162  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x120a  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x1222  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x122c  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x1324  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x140a  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x1421  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x1437  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x1449  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x1457  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x14da  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x153a  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x160a  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x1622  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x1655  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x1658  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x1679  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x168c  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x169f  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x1a87  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x1a8a  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x1a8d  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x1a90  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x1a93  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x1a96  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x1a99  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        el elVar;
        el elVar2;
        el elVar3;
        el elVar4;
        el elVar5;
        el elVar6;
        cw cwVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        el elVar7;
        el elVar8;
        el elVar9;
        el elVar10;
        el elVar11;
        el elVar12;
        cw cwVar2;
        cw cwVar3;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        el elVar13;
        el elVar14;
        el elVar15;
        el elVar16;
        el elVar17;
        el elVar18;
        el elVar19;
        el elVar20;
        el elVar21;
        el elVar22;
        boolean z;
        el elVar23;
        el elVar24;
        el elVar25;
        cw cwVar4;
        String awN;
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
        dd ddVar;
        dd ddVar2;
        dd ddVar3;
        dd ddVar4;
        dd ddVar5;
        el elVar36;
        el elVar37;
        dd ddVar6;
        el elVar38;
        cw cwVar5;
        el elVar39;
        cw cwVar6;
        cw cwVar7;
        PbActivity.b lU;
        cw cwVar8;
        PbActivity.b lU2;
        cw cwVar9;
        PbActivity.b lU3;
        cw cwVar10;
        cw cwVar11;
        cw cwVar12;
        el elVar40;
        int awB;
        int awB2;
        cw cwVar13;
        cw cwVar14;
        cw cwVar15;
        cw cwVar16;
        cw cwVar17;
        cw cwVar18;
        cw cwVar19;
        cw cwVar20;
        int awB3;
        int awB4;
        cw cwVar21;
        cw cwVar22;
        cw cwVar23;
        cw cwVar24;
        cw cwVar25;
        cw cwVar26;
        cw cwVar27;
        cw cwVar28;
        el elVar41;
        cw cwVar29;
        cw cwVar30;
        cw cwVar31;
        el elVar42;
        cw cwVar32;
        cw cwVar33;
        cw cwVar34;
        cw cwVar35;
        cw cwVar36;
        cw cwVar37;
        el elVar43;
        el elVar44;
        cw cwVar38;
        dd ddVar7;
        dd ddVar8;
        cw cwVar39;
        boolean z2;
        dd ddVar9;
        dd ddVar10;
        dd ddVar11;
        dd ddVar12;
        cw cwVar40;
        dd ddVar13;
        SparseArray sparseArray;
        dd ddVar14;
        SparseArray sparseArray2;
        boolean booleanValue;
        boolean z3;
        dd ddVar15;
        dd ddVar16;
        dd ddVar17;
        dd ddVar18;
        dd ddVar19;
        dd ddVar20;
        dd ddVar21;
        SparseArray sparseArray3;
        boolean z4;
        boolean z5;
        boolean gw;
        boolean isLogin;
        dd ddVar22;
        dd ddVar23;
        dd ddVar24;
        SparseArray sparseArray4;
        boolean z6;
        String str;
        int i;
        dd ddVar25;
        dd ddVar26;
        dd ddVar27;
        dd ddVar28;
        dd ddVar29;
        dd ddVar30;
        dd ddVar31;
        dd ddVar32;
        dd ddVar33;
        dd ddVar34;
        dd ddVar35;
        dd ddVar36;
        dd ddVar37;
        dd ddVar38;
        dd ddVar39;
        dd ddVar40;
        dd ddVar41;
        cw cwVar41;
        dd ddVar42;
        dd ddVar43;
        boolean z7;
        com.baidu.tbadk.core.data.bc bcVar;
        cw cwVar42;
        cw cwVar43;
        el elVar45;
        el elVar46;
        el elVar47;
        cw cwVar44;
        cw cwVar45;
        cw cwVar46;
        cw cwVar47;
        el elVar48;
        el elVar49;
        dd ddVar44;
        el elVar50;
        el elVar51;
        cw cwVar48;
        el elVar52;
        cw cwVar49;
        dd ddVar45;
        cw cwVar50;
        dd ddVar46;
        el elVar53;
        dd ddVar47;
        cw cwVar51;
        el elVar54;
        cw cwVar52;
        dd ddVar48;
        dd ddVar49;
        el elVar55;
        el elVar56;
        el elVar57;
        cw cwVar53;
        cw cwVar54;
        el elVar58;
        el elVar59;
        cw cwVar55;
        cw cwVar56;
        cw cwVar57;
        el elVar60;
        cw cwVar58;
        el elVar61;
        el elVar62;
        el elVar63;
        cw cwVar59;
        el elVar64;
        el elVar65;
        cw cwVar60;
        el elVar66;
        cw cwVar61;
        el elVar67;
        el elVar68;
        el elVar69;
        el elVar70;
        el elVar71;
        el elVar72;
        el elVar73;
        boolean lJ;
        cw cwVar62;
        el elVar74;
        cw cwVar63;
        cw cwVar64;
        cw cwVar65;
        cw cwVar66;
        cw cwVar67;
        cw cwVar68;
        cw cwVar69;
        cw cwVar70;
        cw cwVar71;
        cw cwVar72;
        el elVar75;
        el elVar76;
        cw cwVar73;
        cw cwVar74;
        cw cwVar75;
        cw cwVar76;
        cw cwVar77;
        cw cwVar78;
        cw cwVar79;
        cw cwVar80;
        cw cwVar81;
        el elVar77;
        cw cwVar82;
        el elVar78;
        el elVar79;
        el elVar80;
        cw cwVar83;
        el elVar81;
        cw cwVar84;
        el elVar82;
        cw cwVar85;
        cw cwVar86;
        el elVar83;
        elVar = this.djE.diR;
        if (view == elVar.getNextView()) {
            cwVar86 = this.djE.dih;
            if (cwVar86.gE(true)) {
                elVar83 = this.djE.diR;
                elVar83.aze();
                return;
            }
            return;
        }
        elVar2 = this.djE.diR;
        if (view == elVar2.ayZ()) {
            elVar81 = this.djE.diR;
            elVar81.ayU();
            if (UtilHelper.isFloatWindowOpAllowed(this.djE.getPageContext().getPageActivity())) {
                this.djE.diV = true;
                PbActivity pbActivity = this.djE;
                cwVar84 = this.djE.dih;
                pbActivity.a(cwVar84.getPbData(), 0, 1, true, true);
                elVar82 = this.djE.diR;
                elVar82.ayT();
                com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10830");
                cwVar85 = this.djE.dih;
                TiebaStatic.log(awVar.ac("tid", cwVar85.getThreadID()));
                return;
            }
            this.djE.awA();
            return;
        }
        elVar3 = this.djE.diR;
        if (view == elVar3.azz()) {
            elVar78 = this.djE.diR;
            elVar78.amT();
            this.djE.Pm();
            elVar79 = this.djE.diR;
            elVar79.azd();
            elVar80 = this.djE.diR;
            elVar80.akx();
            cwVar83 = this.djE.dih;
            cwVar83.lN(1);
            return;
        }
        elVar4 = this.djE.diR;
        if (view == elVar4.dmZ.azx) {
            elVar77 = this.djE.diR;
            cwVar82 = this.djE.dih;
            if (!elVar77.gY(cwVar82.axI())) {
                this.djE.diz = false;
                this.djE.finish();
                return;
            }
            this.djE.Pm();
            return;
        }
        elVar5 = this.djE.diR;
        if (view != elVar5.azq()) {
            elVar14 = this.djE.diR;
            if (view != elVar14.azr()) {
                elVar15 = this.djE.diR;
                if (view != elVar15.azs()) {
                    elVar16 = this.djE.diR;
                    if (view != elVar16.azt()) {
                        elVar17 = this.djE.diR;
                        if (view != elVar17.azb()) {
                            elVar18 = this.djE.diR;
                            if (view == elVar18.azw()) {
                                cwVar80 = this.djE.dih;
                                if (cwVar80 != null) {
                                    cwVar81 = this.djE.dih;
                                    com.baidu.tbadk.browser.f.t(this.djE.getPageContext().getPageActivity(), cwVar81.getPbData().avE().qO().getLink());
                                    return;
                                }
                                return;
                            }
                            elVar19 = this.djE.diR;
                            if (view != elVar19.dmZ.dpU) {
                                elVar20 = this.djE.diR;
                                if (view == elVar20.dmZ.dpW) {
                                    cwVar69 = this.djE.dih;
                                    if (cwVar69 != null) {
                                        cwVar70 = this.djE.dih;
                                        if (cwVar70.getPbData() != null) {
                                            cwVar71 = this.djE.dih;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = cwVar71.getPbData().avF();
                                            if (avF == null || avF.size() <= 0) {
                                                cwVar72 = this.djE.dih;
                                                if (cwVar72.axE()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.djE.getPageContext().getPageActivity(), this.djE.getPageContext().getString(t.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            elVar75 = this.djE.diR;
                                            elVar75.ayK();
                                            elVar76 = this.djE.diR;
                                            elVar76.azB();
                                            this.djE.awC();
                                            this.djE.awU();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.djE.getPageContext().getPageActivity(), this.djE.getPageContext().getString(t.j.pb_no_data_tips));
                                    return;
                                }
                                elVar21 = this.djE.diR;
                                if (view != elVar21.dmZ.dpV && view.getId() != t.g.pb_god_user_tip_content) {
                                    elVar28 = this.djE.diR;
                                    if (view == elVar28.dmZ.dpX) {
                                        cwVar63 = this.djE.dih;
                                        AdditionData avN = cwVar63.getPbData().avN();
                                        if (!TextUtils.isEmpty(avN.getWarnMsg())) {
                                            com.baidu.adp.lib.util.k.showToast(this.djE.getPageContext().getPageActivity(), avN.getWarnMsg());
                                            return;
                                        } else if (avN.getAlreadyCount() != avN.getTotalCount()) {
                                            cwVar64 = this.djE.dih;
                                            ForumData avD = cwVar64.getPbData().avD();
                                            cwVar65 = this.djE.dih;
                                            com.baidu.tbadk.core.data.ax avE = cwVar65.getPbData().avE();
                                            cwVar66 = this.djE.dih;
                                            AntiData pz = cwVar66.getPbData().pz();
                                            if (avE.getId() != null) {
                                                if (pz != null && pz.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.k.showToast(this.djE.getPageContext().getPageActivity(), pz.getForbid_info());
                                                    return;
                                                }
                                                int i2 = 0;
                                                cwVar67 = this.djE.dih;
                                                if (cwVar67.getPbData().getUserData() != null) {
                                                    cwVar68 = this.djE.dih;
                                                    i2 = cwVar68.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.djE.getPageContext().getPageActivity(), 2, avD.getId(), avD.getName(), avE.getId(), avN.getPostId(), 0, pz, 13008, false, false, null, false, false, null, avN, null, i2)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.k.showToast(this.djE.getPageContext().getPageActivity(), String.format(this.djE.getPageContext().getString(t.j.write_addition_limit), Integer.valueOf(avN.getTotalCount())));
                                            return;
                                        }
                                    }
                                    elVar29 = this.djE.diR;
                                    if (elVar29.dmZ.azQ() != null) {
                                        elVar72 = this.djE.diR;
                                        if (view == elVar72.dmZ.azQ().ayb()) {
                                            elVar73 = this.djE.diR;
                                            elVar73.amT();
                                            lJ = this.djE.lJ(11009);
                                            if (lJ) {
                                                cwVar62 = this.djE.dih;
                                                elVar74 = this.djE.diR;
                                                if (cwVar62.lT(elVar74.azj()) == null) {
                                                    return;
                                                }
                                                this.djE.awH();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    elVar30 = this.djE.diR;
                                    if (elVar30.dmZ.azQ() != null) {
                                        elVar69 = this.djE.diR;
                                        if (view != elVar69.dmZ.azQ().ayp()) {
                                            elVar71 = this.djE.diR;
                                        }
                                        elVar70 = this.djE.diR;
                                        elVar70.dmZ.nv();
                                        return;
                                    }
                                    elVar31 = this.djE.diR;
                                    if (elVar31.dmZ.azQ() != null) {
                                        elVar67 = this.djE.diR;
                                        if (view == elVar67.dmZ.azQ().ayk()) {
                                            elVar68 = this.djE.diR;
                                            elVar68.amT();
                                            this.djE.Pm();
                                            this.djE.Qg();
                                            return;
                                        }
                                    }
                                    elVar32 = this.djE.diR;
                                    if (elVar32.dmZ.azQ() != null) {
                                        elVar64 = this.djE.diR;
                                        if (view == elVar64.dmZ.azQ().ayl()) {
                                            elVar65 = this.djE.diR;
                                            elVar65.amT();
                                            cwVar60 = this.djE.dih;
                                            if (cwVar60.abu() != null) {
                                                elVar66 = this.djE.diR;
                                                cwVar61 = this.djE.dih;
                                                elVar66.a(cwVar61.abu(), this.djE.daz);
                                            }
                                            TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    elVar33 = this.djE.diR;
                                    if (elVar33.dmZ.azQ() != null) {
                                        elVar61 = this.djE.diR;
                                        if (view == elVar61.dmZ.azQ().aym()) {
                                            elVar62 = this.djE.diR;
                                            elVar62.amT();
                                            this.djE.Pm();
                                            elVar63 = this.djE.diR;
                                            elVar63.azd();
                                            cwVar59 = this.djE.dih;
                                            cwVar59.axN();
                                            TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                            this.djE.awU();
                                            return;
                                        }
                                    }
                                    elVar34 = this.djE.diR;
                                    if (elVar34.dmZ.azQ() != null) {
                                        elVar59 = this.djE.diR;
                                        if (view == elVar59.dmZ.azQ().ayn()) {
                                            cwVar55 = this.djE.dih;
                                            if (cwVar55 != null) {
                                                cwVar56 = this.djE.dih;
                                                if (cwVar56.getPbData() != null) {
                                                    cwVar57 = this.djE.dih;
                                                    if (cwVar57.getPbData().avE() != null) {
                                                        elVar60 = this.djE.diR;
                                                        elVar60.dmZ.nv();
                                                        PbActivity pbActivity2 = this.djE;
                                                        cwVar58 = this.djE.dih;
                                                        pbActivity2.lR(cwVar58.getPbData().avE().ra());
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    elVar35 = this.djE.diR;
                                    if (elVar35.dmZ.azQ() != null) {
                                        elVar55 = this.djE.diR;
                                        if (view == elVar55.dmZ.azQ().ayo()) {
                                            TiebaStatic.log("c10414");
                                            elVar56 = this.djE.diR;
                                            elVar56.amT();
                                            elVar57 = this.djE.diR;
                                            if (elVar57.qL() != el.doH) {
                                                cwVar53 = this.djE.dih;
                                                if (cwVar53.aya() != null) {
                                                    cwVar54 = this.djE.dih;
                                                    cwVar54.aya().lL(cw.dkX);
                                                    return;
                                                }
                                                return;
                                            }
                                            elVar58 = this.djE.diR;
                                            elVar58.azF();
                                            return;
                                        }
                                    }
                                    ddVar = this.djE.diU;
                                    if (ddVar != null) {
                                        ddVar49 = this.djE.diU;
                                        if (view == ddVar49.ayd()) {
                                            Object tag = view.getTag();
                                            if (!(tag instanceof String)) {
                                                if (tag instanceof SparseArray) {
                                                    SparseArray<Object> sparseArray5 = (SparseArray) tag;
                                                    if ((sparseArray5.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(t.g.tag_user_mute_visible)).booleanValue()) {
                                                        sparseArray5.put(t.g.tag_from, 0);
                                                        sparseArray5.put(t.g.tag_check_mute_from, 2);
                                                        this.djE.d(sparseArray5);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            this.djE.lR((String) tag);
                                            return;
                                        }
                                    }
                                    ddVar2 = this.djE.diU;
                                    if (ddVar2 != null) {
                                        ddVar48 = this.djE.diU;
                                        if (view == ddVar48.ayb()) {
                                            if (!this.djE.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.djE.aO(view);
                                            return;
                                        }
                                    }
                                    ddVar3 = this.djE.diU;
                                    if (ddVar3 != null) {
                                        ddVar47 = this.djE.diU;
                                        if (view == ddVar47.ayh()) {
                                            if (view.getTag(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                cwVar51 = this.djE.dih;
                                                if (cwVar51 != null) {
                                                    elVar54 = this.djE.diR;
                                                    elVar54.ayU();
                                                    if (!UtilHelper.isFloatWindowOpAllowed(this.djE.getPageContext().getPageActivity())) {
                                                        this.djE.awA();
                                                        return;
                                                    }
                                                    int intValue = ((Integer) view.getTag(t.g.tag_pb_floor_postion)).intValue();
                                                    int intValue2 = ((Integer) view.getTag(t.g.tag_pb_floor_number)).intValue();
                                                    this.djE.diV = true;
                                                    PbActivity pbActivity3 = this.djE;
                                                    cwVar52 = this.djE.dih;
                                                    pbActivity3.a(cwVar52.getPbData(), intValue, intValue2, true, true);
                                                    TiebaStatic.log("c10834");
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ddVar4 = this.djE.diU;
                                    if (ddVar4 != null) {
                                        ddVar46 = this.djE.diU;
                                        if (view == ddVar46.aye()) {
                                            SparseArray sparseArray6 = (SparseArray) view.getTag();
                                            if (sparseArray6 != null && (sparseArray6.get(t.g.tag_del_post_type) instanceof Integer) && (sparseArray6.get(t.g.tag_del_post_id) instanceof String) && (sparseArray6.get(t.g.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(t.g.tag_del_post_is_self) instanceof Boolean)) {
                                                elVar53 = this.djE.diR;
                                                elVar53.a(((Integer) sparseArray6.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray6.get(t.g.tag_del_post_id), ((Integer) sparseArray6.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(t.g.tag_del_post_is_self)).booleanValue());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    ddVar5 = this.djE.diU;
                                    if (ddVar5 != null) {
                                        ddVar45 = this.djE.diU;
                                        if (view == ddVar45.ayf()) {
                                            long j = -1;
                                            String str2 = "";
                                            int i3 = 0;
                                            if (view.getTag(t.g.tag_chudian_template_id) instanceof Long) {
                                                j = ((Long) view.getTag(t.g.tag_chudian_template_id)).longValue();
                                            }
                                            if (view.getTag(t.g.tag_chudian_monitor_id) instanceof String) {
                                                str2 = (String) view.getTag(t.g.tag_chudian_monitor_id);
                                            }
                                            if (view.getTag(t.g.tag_chudian_hide_day) instanceof Integer) {
                                                i3 = ((Integer) view.getTag(t.g.tag_chudian_hide_day)).intValue();
                                            }
                                            cwVar50 = this.djE.dih;
                                            com.baidu.tieba.pb.data.e pbData = cwVar50.getPbData();
                                            String str3 = null;
                                            String str4 = null;
                                            String str5 = null;
                                            if (pbData != null && pbData.avD() != null) {
                                                str3 = pbData.avD().getId();
                                                str4 = pbData.avD().getName();
                                                str5 = pbData.getThreadId();
                                            }
                                            com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", str3, str4, str5);
                                            this.djE.a(j, str2, str3, str4, str5, i3);
                                            return;
                                        }
                                    }
                                    elVar36 = this.djE.diR;
                                    if (elVar36.azG() == view) {
                                        elVar52 = this.djE.diR;
                                        if (elVar52.azG().getIndicateStatus()) {
                                            cwVar49 = this.djE.dih;
                                            com.baidu.tieba.pb.data.e pbData2 = cwVar49.getPbData();
                                            if (pbData2 != null && pbData2.avE() != null && pbData2.avE().qF() != null) {
                                                String qE = pbData2.avE().qF().qE();
                                                if (StringUtils.isNull(qE)) {
                                                    qE = pbData2.avE().qF().getTaskId();
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c11107").ac("obj_id", qE));
                                            }
                                        } else {
                                            com.baidu.tieba.tbadkCore.d.a.bJ("c10725", null);
                                        }
                                        this.djE.awV();
                                        return;
                                    }
                                    elVar37 = this.djE.diR;
                                    if (elVar37.ayW() != view) {
                                        ddVar6 = this.djE.diU;
                                        if (ddVar6 != null) {
                                            ddVar44 = this.djE.diU;
                                            if (view == ddVar44.ayc()) {
                                                SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                                                if (sparseArray7 != null) {
                                                    boolean booleanValue2 = ((Boolean) sparseArray7.get(t.g.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue3 = ((Boolean) sparseArray7.get(t.g.tag_should_delete_visible)).booleanValue();
                                                    boolean booleanValue4 = ((Boolean) sparseArray7.get(t.g.tag_user_mute_visible)).booleanValue();
                                                    if (booleanValue2) {
                                                        if (booleanValue4) {
                                                            sparseArray7.put(t.g.tag_from, 1);
                                                            sparseArray7.put(t.g.tag_check_mute_from, 2);
                                                            this.djE.d(sparseArray7);
                                                            return;
                                                        }
                                                        sparseArray7.put(t.g.tag_check_mute_from, 2);
                                                        elVar51 = this.djE.diR;
                                                        elVar51.aR(view);
                                                        return;
                                                    } else if (booleanValue3) {
                                                        elVar50 = this.djE.diR;
                                                        elVar50.a(((Integer) sparseArray7.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(t.g.tag_del_post_id), ((Integer) sparseArray7.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(t.g.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        elVar38 = this.djE.diR;
                                        if (view == elVar38.axz()) {
                                            if (this.djE.checkUpIsLogin()) {
                                                elVar47 = this.djE.diR;
                                                if (!elVar47.axw()) {
                                                    cwVar44 = this.djE.dih;
                                                    if (cwVar44 != null) {
                                                        cwVar45 = this.djE.dih;
                                                        if (cwVar45.axY() != null) {
                                                            cwVar46 = this.djE.dih;
                                                            if (cwVar46.axY().axq() != null) {
                                                                cwVar47 = this.djE.dih;
                                                                if (com.baidu.tbadk.core.util.y.r(cwVar47.axY().axq().getItems()) != 0) {
                                                                    elVar48 = this.djE.diR;
                                                                    elVar48.axx();
                                                                    return;
                                                                }
                                                                this.djE.showToast(t.j.graffiti_quick_vote_empty);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                elVar49 = this.djE.diR;
                                                elVar49.axy();
                                                return;
                                            }
                                            return;
                                        } else if (view.getId() == t.g.pb_head_function_manage_delormanage) {
                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
                                            if (((Boolean) sparseArray8.get(t.g.tag_should_manage_visible)).booleanValue()) {
                                                elVar46 = this.djE.diR;
                                                elVar46.aR(view);
                                            } else {
                                                elVar45 = this.djE.diR;
                                                elVar45.a(((Integer) sparseArray8.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(t.g.tag_del_post_id), ((Integer) sparseArray8.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(t.g.tag_del_post_is_self)).booleanValue());
                                            }
                                            this.djE.awU();
                                            return;
                                        } else if (view.getId() != t.g.replybtn && view.getId() != t.g.sub_pb_more && view.getId() != t.g.sub_pb_item) {
                                            elVar40 = this.djE.diR;
                                            if (view == elVar40.awt()) {
                                                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                    long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                    cwVar42 = this.djE.dih;
                                                    long c2 = com.baidu.adp.lib.h.b.c(cwVar42.getPbData().getForumId(), 0L);
                                                    cwVar43 = this.djE.dih;
                                                    this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.djE.getPageContext().getPageActivity(), 24008, c2, com.baidu.adp.lib.h.b.c(cwVar43.getThreadID(), 0L), c)));
                                                    return;
                                                }
                                                return;
                                            }
                                            int id = view.getId();
                                            if (id == t.g.pb_u9_text_view) {
                                                if (this.djE.checkUpIsLogin() && (bcVar = (com.baidu.tbadk.core.data.bc) view.getTag()) != null && !StringUtils.isNull(bcVar.rL())) {
                                                    TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.bg.ut().c(this.djE.getPageContext(), new String[]{bcVar.rL()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == t.g.reply) {
                                                ddVar7 = this.djE.diU;
                                                if (ddVar7 == null) {
                                                    this.djE.diU = new dd(this.djE.getPageContext(), this.djE.bjV);
                                                    ddVar43 = this.djE.diU;
                                                    z7 = this.djE.mIsLogin;
                                                    ddVar43.gI(z7);
                                                }
                                                ddVar8 = this.djE.diU;
                                                ddVar8.Fk();
                                                com.baidu.tieba.tbadkCore.data.s sVar = null;
                                                if (view != null && view.getTag() != null) {
                                                    sVar = (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(t.g.tag_load_sub_data);
                                                    if (!this.djE.awP()) {
                                                        cwVar41 = this.djE.dih;
                                                        if (cwVar41.axO() && TbadkCoreApplication.m11getInst().isTTSCanUse()) {
                                                            ddVar42 = this.djE.diU;
                                                            ddVar42.ayj();
                                                            sparseArray = (SparseArray) view.getTag();
                                                            if (sparseArray.get(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                                int intValue3 = ((Integer) sparseArray.get(t.g.tag_pb_floor_postion)).intValue();
                                                                int intValue4 = ((Integer) sparseArray.get(t.g.tag_pb_floor_number)).intValue();
                                                                ddVar40 = this.djE.diU;
                                                                ddVar40.ayh().setTag(t.g.tag_pb_floor_postion, Integer.valueOf(intValue3));
                                                                ddVar41 = this.djE.diU;
                                                                ddVar41.ayh().setTag(t.g.tag_pb_floor_number, Integer.valueOf(intValue4));
                                                            }
                                                            SparseArray sparseArray9 = new SparseArray();
                                                            sparseArray9.put(t.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(t.g.tag_clip_board));
                                                            sparseArray9.put(t.g.tag_is_subpb, false);
                                                            ddVar14 = this.djE.diU;
                                                            ddVar14.ayb().setTag(sparseArray9);
                                                            sparseArray2 = (SparseArray) view.getTag();
                                                            booleanValue = ((Boolean) sparseArray2.get(t.g.tag_should_manage_visible)).booleanValue();
                                                            boolean booleanValue5 = ((Boolean) sparseArray2.get(t.g.tag_user_mute_visible)).booleanValue();
                                                            boolean booleanValue6 = ((Boolean) sparseArray2.get(t.g.tag_should_delete_visible)).booleanValue();
                                                            if (sparseArray2.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                                z3 = false;
                                                            } else {
                                                                z3 = ((Boolean) sparseArray2.get(t.g.tag_del_post_is_self)).booleanValue();
                                                            }
                                                            String str6 = null;
                                                            if (sparseArray2.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                                str6 = (String) sparseArray2.get(t.g.tag_forbid_user_post_id);
                                                            }
                                                            if (!booleanValue) {
                                                                SparseArray sparseArray10 = new SparseArray();
                                                                sparseArray10.put(t.g.tag_should_manage_visible, true);
                                                                sparseArray10.put(t.g.tag_manage_user_identity, sparseArray2.get(t.g.tag_manage_user_identity));
                                                                sparseArray10.put(t.g.tag_forbid_user_name, sparseArray2.get(t.g.tag_forbid_user_name));
                                                                sparseArray10.put(t.g.tag_forbid_user_post_id, str6);
                                                                if (booleanValue5) {
                                                                    sparseArray10.put(t.g.tag_user_mute_visible, true);
                                                                    sparseArray10.put(t.g.tag_is_mem, sparseArray2.get(t.g.tag_is_mem));
                                                                    sparseArray10.put(t.g.tag_user_mute_mute_userid, sparseArray2.get(t.g.tag_user_mute_mute_userid));
                                                                    sparseArray10.put(t.g.tag_user_mute_mute_username, sparseArray2.get(t.g.tag_user_mute_mute_username));
                                                                    sparseArray10.put(t.g.tag_user_mute_post_id, sparseArray2.get(t.g.tag_user_mute_post_id));
                                                                    sparseArray10.put(t.g.tag_user_mute_thread_id, sparseArray2.get(t.g.tag_user_mute_thread_id));
                                                                } else {
                                                                    sparseArray10.put(t.g.tag_user_mute_visible, false);
                                                                }
                                                                if (booleanValue6) {
                                                                    sparseArray10.put(t.g.tag_should_delete_visible, true);
                                                                    sparseArray10.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                    sparseArray10.put(t.g.tag_del_post_id, sparseArray2.get(t.g.tag_del_post_id));
                                                                    sparseArray10.put(t.g.tag_del_post_type, sparseArray2.get(t.g.tag_del_post_type));
                                                                    ddVar39 = this.djE.diU;
                                                                    ddVar39.aye().setVisibility(0);
                                                                } else {
                                                                    sparseArray10.put(t.g.tag_should_delete_visible, false);
                                                                    ddVar34 = this.djE.diU;
                                                                    ddVar34.aye().setVisibility(8);
                                                                }
                                                                ddVar35 = this.djE.diU;
                                                                ddVar35.ayc().setTag(sparseArray10);
                                                                ddVar36 = this.djE.diU;
                                                                ddVar36.aye().setTag(sparseArray10);
                                                                ddVar37 = this.djE.diU;
                                                                ddVar37.ayc().setText(t.j.bar_manager);
                                                                ddVar38 = this.djE.diU;
                                                                ddVar38.ayc().setVisibility(0);
                                                            } else if (!booleanValue6) {
                                                                ddVar15 = this.djE.diU;
                                                                ddVar15.ayc().setVisibility(8);
                                                                ddVar16 = this.djE.diU;
                                                                ddVar16.aye().setVisibility(8);
                                                            } else {
                                                                SparseArray sparseArray11 = new SparseArray();
                                                                sparseArray11.put(t.g.tag_should_manage_visible, false);
                                                                sparseArray11.put(t.g.tag_user_mute_visible, false);
                                                                sparseArray11.put(t.g.tag_should_delete_visible, true);
                                                                sparseArray11.put(t.g.tag_manage_user_identity, sparseArray2.get(t.g.tag_manage_user_identity));
                                                                sparseArray11.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                sparseArray11.put(t.g.tag_del_post_id, sparseArray2.get(t.g.tag_del_post_id));
                                                                sparseArray11.put(t.g.tag_del_post_type, sparseArray2.get(t.g.tag_del_post_type));
                                                                ddVar17 = this.djE.diU;
                                                                ddVar17.ayc().setTag(sparseArray11);
                                                                ddVar18 = this.djE.diU;
                                                                ddVar18.aye().setTag(sparseArray11);
                                                                ddVar19 = this.djE.diU;
                                                                ddVar19.ayc().setText(t.j.delete);
                                                                ddVar20 = this.djE.diU;
                                                                ddVar20.aye().setVisibility(0);
                                                                ddVar21 = this.djE.diU;
                                                                ddVar21.ayc().setVisibility(8);
                                                            }
                                                            sparseArray3 = (SparseArray) view.getTag();
                                                            if (sparseArray3.get(t.g.tag_user_mute_visible) instanceof Boolean) {
                                                                z4 = false;
                                                            } else {
                                                                z4 = ((Boolean) sparseArray3.get(t.g.tag_user_mute_visible)).booleanValue();
                                                            }
                                                            if (((Boolean) sparseArray3.get(t.g.tag_should_manage_visible)).booleanValue() && z4) {
                                                                SparseArray sparseArray12 = new SparseArray();
                                                                sparseArray12.put(t.g.tag_user_mute_visible, true);
                                                                sparseArray12.put(t.g.tag_is_mem, sparseArray3.get(t.g.tag_is_mem));
                                                                sparseArray12.put(t.g.tag_user_mute_mute_userid, sparseArray3.get(t.g.tag_user_mute_mute_userid));
                                                                sparseArray12.put(t.g.tag_user_mute_mute_username, sparseArray3.get(t.g.tag_user_mute_mute_username));
                                                                sparseArray12.put(t.g.tag_user_mute_post_id, sparseArray3.get(t.g.tag_user_mute_post_id));
                                                                sparseArray12.put(t.g.tag_user_mute_thread_id, sparseArray3.get(t.g.tag_user_mute_thread_id));
                                                                sparseArray12.put(t.g.tag_del_post_is_self, sparseArray3.get(t.g.tag_del_post_is_self));
                                                                sparseArray12.put(t.g.tag_del_post_type, sparseArray3.get(t.g.tag_del_post_type));
                                                                sparseArray12.put(t.g.tag_del_post_id, sparseArray3.get(t.g.tag_del_post_id));
                                                                sparseArray12.put(t.g.tag_manage_user_identity, sparseArray3.get(t.g.tag_manage_user_identity));
                                                                ddVar30 = this.djE.diU;
                                                                ddVar30.ayd().setTag(sparseArray12);
                                                                ddVar31 = this.djE.diU;
                                                                ddVar31.ayd().setVisibility(0);
                                                                ddVar32 = this.djE.diU;
                                                                ddVar32.ayc().setVisibility(8);
                                                                ddVar33 = this.djE.diU;
                                                                ddVar33.ayd().setText(t.j.mute_option);
                                                            } else {
                                                                if (sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                                    z5 = false;
                                                                } else {
                                                                    z5 = ((Boolean) sparseArray3.get(t.g.tag_del_post_is_self)).booleanValue();
                                                                }
                                                                String str7 = null;
                                                                if (sparseArray3.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                                    str7 = (String) sparseArray3.get(t.g.tag_forbid_user_post_id);
                                                                }
                                                                gw = this.djE.gw(z5);
                                                                isLogin = gw & this.djE.isLogin();
                                                                this.djE.djv = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(t.g.tag_clip_board);
                                                                if (!(!ek.g(this.djE.djv) ? false : isLogin)) {
                                                                    ddVar23 = this.djE.diU;
                                                                    ddVar23.ayd().setVisibility(0);
                                                                    ddVar24 = this.djE.diU;
                                                                    ddVar24.ayd().setTag(str7);
                                                                } else {
                                                                    ddVar22 = this.djE.diU;
                                                                    ddVar22.ayd().setVisibility(8);
                                                                }
                                                            }
                                                            sparseArray4 = (SparseArray) view.getTag();
                                                            long j2 = 0;
                                                            if (sparseArray4.get(t.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                                z6 = false;
                                                            } else {
                                                                z6 = ((Boolean) sparseArray4.get(t.g.tag_should_hide_chudian_visible)).booleanValue();
                                                            }
                                                            if (sparseArray4.get(t.g.tag_chudian_template_id) instanceof Long) {
                                                                j2 = ((Long) sparseArray4.get(t.g.tag_chudian_template_id)).longValue();
                                                            }
                                                            if (sparseArray4.get(t.g.tag_chudian_monitor_id) instanceof String) {
                                                                str = "";
                                                            } else {
                                                                str = (String) sparseArray4.get(t.g.tag_chudian_monitor_id);
                                                            }
                                                            if (sparseArray4.get(t.g.tag_chudian_hide_day) instanceof Integer) {
                                                                i = 0;
                                                            } else {
                                                                i = ((Integer) sparseArray4.get(t.g.tag_chudian_hide_day)).intValue();
                                                            }
                                                            if (!z6) {
                                                                ddVar26 = this.djE.diU;
                                                                ddVar26.ayf().setVisibility(0);
                                                                ddVar27 = this.djE.diU;
                                                                ddVar27.ayf().setTag(t.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                ddVar28 = this.djE.diU;
                                                                ddVar28.ayf().setTag(t.g.tag_chudian_monitor_id, str);
                                                                ddVar29 = this.djE.diU;
                                                                ddVar29.ayf().setTag(t.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                            } else {
                                                                ddVar25 = this.djE.diU;
                                                                ddVar25.ayf().setVisibility(8);
                                                            }
                                                        }
                                                    }
                                                    ddVar13 = this.djE.diU;
                                                    ddVar13.ayi();
                                                    sparseArray = (SparseArray) view.getTag();
                                                    if (sparseArray.get(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                    }
                                                    SparseArray sparseArray92 = new SparseArray();
                                                    sparseArray92.put(t.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(t.g.tag_clip_board));
                                                    sparseArray92.put(t.g.tag_is_subpb, false);
                                                    ddVar14 = this.djE.diU;
                                                    ddVar14.ayb().setTag(sparseArray92);
                                                    sparseArray2 = (SparseArray) view.getTag();
                                                    booleanValue = ((Boolean) sparseArray2.get(t.g.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue52 = ((Boolean) sparseArray2.get(t.g.tag_user_mute_visible)).booleanValue();
                                                    boolean booleanValue62 = ((Boolean) sparseArray2.get(t.g.tag_should_delete_visible)).booleanValue();
                                                    if (sparseArray2.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                    }
                                                    String str62 = null;
                                                    if (sparseArray2.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                    }
                                                    if (!booleanValue) {
                                                    }
                                                    sparseArray3 = (SparseArray) view.getTag();
                                                    if (sparseArray3.get(t.g.tag_user_mute_visible) instanceof Boolean) {
                                                    }
                                                    if (((Boolean) sparseArray3.get(t.g.tag_should_manage_visible)).booleanValue()) {
                                                    }
                                                    if (sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                                                    }
                                                    String str72 = null;
                                                    if (sparseArray3.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                    }
                                                    gw = this.djE.gw(z5);
                                                    isLogin = gw & this.djE.isLogin();
                                                    this.djE.djv = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(t.g.tag_clip_board);
                                                    if (!(!ek.g(this.djE.djv) ? false : isLogin)) {
                                                    }
                                                    sparseArray4 = (SparseArray) view.getTag();
                                                    long j22 = 0;
                                                    if (sparseArray4.get(t.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                    }
                                                    if (sparseArray4.get(t.g.tag_chudian_template_id) instanceof Long) {
                                                    }
                                                    if (sparseArray4.get(t.g.tag_chudian_monitor_id) instanceof String) {
                                                    }
                                                    if (sparseArray4.get(t.g.tag_chudian_hide_day) instanceof Integer) {
                                                    }
                                                    if (!z6) {
                                                    }
                                                }
                                                cwVar39 = this.djE.dih;
                                                if (cwVar39.getPbData().mP()) {
                                                    cwVar40 = this.djE.dih;
                                                    String mO = cwVar40.getPbData().mO();
                                                    if (sVar != null && !com.baidu.adp.lib.util.j.isEmpty(mO) && mO.equals(sVar.getId())) {
                                                        z2 = true;
                                                        if (!z2) {
                                                            ddVar12 = this.djE.diU;
                                                            ddVar12.ayb().setText(t.j.remove_mark);
                                                        } else {
                                                            ddVar9 = this.djE.diU;
                                                            ddVar9.ayb().setText(t.j.mark);
                                                        }
                                                        ddVar10 = this.djE.diU;
                                                        ddVar10.gJ(true);
                                                        ddVar11 = this.djE.diU;
                                                        ddVar11.uQ();
                                                        return;
                                                    }
                                                }
                                                z2 = false;
                                                if (!z2) {
                                                }
                                                ddVar10 = this.djE.diU;
                                                ddVar10.gJ(true);
                                                ddVar11 = this.djE.diU;
                                                ddVar11.uQ();
                                                return;
                                            } else if (id != t.g.pb_head_reverse_hint) {
                                                if (id == t.g.pb_act_btn) {
                                                    cwVar32 = this.djE.dih;
                                                    if (cwVar32.getPbData() != null) {
                                                        cwVar33 = this.djE.dih;
                                                        if (cwVar33.getPbData().avE() != null) {
                                                            cwVar34 = this.djE.dih;
                                                            if (cwVar34.getPbData().avE().rj() != null) {
                                                                Activity activity = this.djE.getActivity();
                                                                cwVar35 = this.djE.dih;
                                                                com.baidu.tbadk.browser.f.t(activity, cwVar35.getPbData().avE().rj());
                                                                cwVar36 = this.djE.dih;
                                                                if (cwVar36.getPbData().avE().rh() != 1) {
                                                                    cwVar37 = this.djE.dih;
                                                                    if (cwVar37.getPbData().avE().rh() == 2) {
                                                                        TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == t.g.lottery_tail) {
                                                    if (view.getTag(t.g.tag_pb_lottery_tail_link) instanceof String) {
                                                        String str8 = (String) view.getTag(t.g.tag_pb_lottery_tail_link);
                                                        com.baidu.tbadk.core.util.aw awVar2 = new com.baidu.tbadk.core.util.aw("c10912");
                                                        cwVar29 = this.djE.dih;
                                                        com.baidu.tbadk.core.util.aw ac = awVar2.ac("fid", cwVar29.getPbData().getForumId());
                                                        cwVar30 = this.djE.dih;
                                                        TiebaStatic.log(ac.ac("tid", cwVar30.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                        cwVar31 = this.djE.dih;
                                                        if (cwVar31.getPbData().getThreadId().equals(str8)) {
                                                            elVar42 = this.djE.diR;
                                                            elVar42.setSelection(0);
                                                            return;
                                                        }
                                                        this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.djE.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == t.g.pb_item_tail_content) {
                                                    if (com.baidu.tbadk.core.util.bl.ac(this.djE.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.m11getInst().getString(t.j.tail_web_view_title);
                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.sR().getString("tail_link", "");
                                                        if (!StringUtils.isNull(string2)) {
                                                            TiebaStatic.log("c10056");
                                                            com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                        }
                                                        elVar41 = this.djE.diR;
                                                        elVar41.ayK();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == t.g.join_vote_tv) {
                                                    if (view != null) {
                                                        com.baidu.tbadk.browser.f.t(this.djE.getActivity(), (String) view.getTag());
                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                        awB3 = this.djE.awB();
                                                        if (awB3 == 1) {
                                                            cwVar25 = this.djE.dih;
                                                            if (cwVar25 != null) {
                                                                cwVar26 = this.djE.dih;
                                                                if (cwVar26.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar3 = new com.baidu.tbadk.core.util.aw("c10397");
                                                                    cwVar27 = this.djE.dih;
                                                                    com.baidu.tbadk.core.util.aw ac2 = awVar3.ac("fid", cwVar27.getPbData().getForumId());
                                                                    cwVar28 = this.djE.dih;
                                                                    TiebaStatic.log(ac2.ac("tid", cwVar28.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        awB4 = this.djE.awB();
                                                        if (awB4 == 2) {
                                                            cwVar21 = this.djE.dih;
                                                            if (cwVar21 != null) {
                                                                cwVar22 = this.djE.dih;
                                                                if (cwVar22.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar4 = new com.baidu.tbadk.core.util.aw("c10401");
                                                                    cwVar23 = this.djE.dih;
                                                                    com.baidu.tbadk.core.util.aw ac3 = awVar4.ac("fid", cwVar23.getPbData().getForumId());
                                                                    cwVar24 = this.djE.dih;
                                                                    TiebaStatic.log(ac3.ac("tid", cwVar24.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == t.g.look_all_tv) {
                                                    if (view != null) {
                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                        com.baidu.tbadk.browser.f.t(this.djE.getActivity(), (String) view.getTag());
                                                        awB = this.djE.awB();
                                                        if (awB == 1) {
                                                            cwVar17 = this.djE.dih;
                                                            if (cwVar17 != null) {
                                                                cwVar18 = this.djE.dih;
                                                                if (cwVar18.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar5 = new com.baidu.tbadk.core.util.aw("c10507");
                                                                    cwVar19 = this.djE.dih;
                                                                    com.baidu.tbadk.core.util.aw ac4 = awVar5.ac("fid", cwVar19.getPbData().getForumId());
                                                                    cwVar20 = this.djE.dih;
                                                                    TiebaStatic.log(ac4.ac("tid", cwVar20.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        awB2 = this.djE.awB();
                                                        if (awB2 == 2) {
                                                            cwVar13 = this.djE.dih;
                                                            if (cwVar13 != null) {
                                                                cwVar14 = this.djE.dih;
                                                                if (cwVar14.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar6 = new com.baidu.tbadk.core.util.aw("c10508");
                                                                    cwVar15 = this.djE.dih;
                                                                    com.baidu.tbadk.core.util.aw ac5 = awVar6.ac("fid", cwVar15.getPbData().getForumId());
                                                                    cwVar16 = this.djE.dih;
                                                                    TiebaStatic.log(ac5.ac("tid", cwVar16.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id != t.g.manga_prev_btn) {
                                                    if (id != t.g.manga_next_btn) {
                                                        return;
                                                    }
                                                    this.djE.awR();
                                                    return;
                                                } else {
                                                    this.djE.awQ();
                                                    return;
                                                }
                                            } else {
                                                this.djE.Pm();
                                                elVar43 = this.djE.diR;
                                                elVar43.amT();
                                                elVar44 = this.djE.diR;
                                                elVar44.azd();
                                                cwVar38 = this.djE.dih;
                                                cwVar38.axN();
                                                return;
                                            }
                                        } else if (this.djE.checkUpIsLogin()) {
                                            cwVar5 = this.djE.dih;
                                            if (cwVar5.getPbData() != null) {
                                                elVar39 = this.djE.diR;
                                                elVar39.amT();
                                                SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) sparseArray13.get(t.g.tag_load_sub_data);
                                                View view2 = (View) sparseArray13.get(t.g.tag_load_sub_view);
                                                if (sVar2 != null && view2 != null) {
                                                    cwVar6 = this.djE.dih;
                                                    String threadID = cwVar6.getThreadID();
                                                    String id2 = sVar2.getId();
                                                    int i4 = 0;
                                                    cwVar7 = this.djE.dih;
                                                    if (cwVar7.getPbData() != null) {
                                                        cwVar11 = this.djE.dih;
                                                        i4 = cwVar11.getPbData().avK();
                                                    }
                                                    this.djE.Pm();
                                                    if (view.getId() != t.g.replybtn) {
                                                        if (view.getId() == t.g.sub_pb_item) {
                                                            SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                            String str9 = (String) sparseArray14.get(t.g.tag_photo_username);
                                                            com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) sparseArray14.get(t.g.tag_clip_board);
                                                            String str10 = null;
                                                            if (sVar3 != null) {
                                                                str10 = sVar3.getId();
                                                            }
                                                            TiebaStatic.log("c10088");
                                                            lU2 = this.djE.lU(id2);
                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.djE.getPageContext().getPageActivity());
                                                            SmallTailInfo aAF = sVar2.aAF();
                                                            cwVar9 = this.djE.dih;
                                                            this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, str9, true, str10, i4, aAF, cwVar9.getPbData().pz(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(lU2.djS, lU2.djT, lU2.djU, lU2.index)));
                                                            return;
                                                        }
                                                        TiebaStatic.log("c10089");
                                                        lU = this.djE.lU(id2);
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.djE.getPageContext().getPageActivity());
                                                        SmallTailInfo aAF2 = sVar2.aAF();
                                                        cwVar8 = this.djE.dih;
                                                        this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i4, aAF2, cwVar8.getPbData().pz(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(lU.djS, lU.djT, lU.djU, lU.index)));
                                                        return;
                                                    }
                                                    lU3 = this.djE.lU(id2);
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.djE.getPageContext().getPageActivity());
                                                    SmallTailInfo aAF3 = sVar2.aAF();
                                                    cwVar10 = this.djE.dih;
                                                    this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i4, aAF3, cwVar10.getPbData().pz(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(lU3.djS, lU3.djT, lU3.djU, lU3.index)));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.tbadk.core.util.aw s = new com.baidu.tbadk.core.util.aw("c10517").s("obj_locate", 3);
                                            cwVar12 = this.djE.dih;
                                            TiebaStatic.log(s.ac("fid", cwVar12.getPbData().getForumId()));
                                            return;
                                        }
                                    } else if (!this.djE.checkUpIsLogin()) {
                                        com.baidu.tbadk.core.util.aw s2 = new com.baidu.tbadk.core.util.aw("c10517").s("obj_locate", 2);
                                        cwVar48 = this.djE.dih;
                                        TiebaStatic.log(s2.ac("fid", cwVar48.getPbData().getForumId()));
                                        return;
                                    } else {
                                        this.djE.awv();
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.i.fq()) {
                                    elVar22 = this.djE.diR;
                                    elVar22.ayK();
                                    z = this.djE.mIsLoading;
                                    if (!z) {
                                        this.djE.mIsLoading = true;
                                        elVar23 = this.djE.diR;
                                        elVar23.dmZ.dpV.setEnabled(false);
                                        elVar24 = this.djE.diR;
                                        elVar24.agq();
                                        this.djE.Pm();
                                        elVar25 = this.djE.diR;
                                        elVar25.azd();
                                        cwVar4 = this.djE.dih;
                                        awN = this.djE.awN();
                                        cwVar4.lX(awN);
                                        TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        elVar26 = this.djE.diR;
                                        elVar26.azB();
                                        elVar27 = this.djE.diR;
                                        elVar27.axy();
                                        this.djE.awU();
                                        return;
                                    }
                                    return;
                                } else {
                                    this.djE.showToast(t.j.network_not_available);
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            cwVar73 = this.djE.dih;
                            if (cwVar73.getErrorNo() == 4) {
                                cwVar77 = this.djE.dih;
                                if (StringUtils.isNull(cwVar77.axD())) {
                                    cwVar78 = this.djE.dih;
                                    if (cwVar78.getAppealInfo() != null) {
                                        cwVar79 = this.djE.dih;
                                        this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.djE.getPageContext().getPageActivity()).createNormalCfg(cwVar79.getAppealInfo().forumName, FrsActivityConfig.FRS_FROM_PB)));
                                        return;
                                    }
                                }
                                this.djE.finish();
                                return;
                            }
                            String stringExtra = this.djE.getIntent().getStringExtra("from");
                            cwVar74 = this.djE.dih;
                            String name = cwVar74.getPbData().avD().getName();
                            cwVar75 = this.djE.dih;
                            if (!TextUtils.isEmpty(cwVar75.axD())) {
                                cwVar76 = this.djE.dih;
                                if (cwVar76.axD().equals(name) && StringUtils.isNull(stringExtra)) {
                                    this.djE.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.ay.aL(name)) {
                                this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.djE.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        elVar6 = this.djE.diR;
        elVar6.azv();
        cwVar = this.djE.dih;
        if (cwVar.getPbData().avK() == 1) {
            aVar = this.djE.diO;
            if (!aVar.aUO()) {
                elVar7 = this.djE.diR;
                elVar7.aza();
                int i5 = 0;
                elVar8 = this.djE.diR;
                if (view != elVar8.azq()) {
                    elVar9 = this.djE.diR;
                    if (view != elVar9.azr()) {
                        elVar10 = this.djE.diR;
                        if (view != elVar10.azs()) {
                            elVar11 = this.djE.diR;
                            if (view != elVar11.azt()) {
                                elVar12 = this.djE.diR;
                                if (view == elVar12.azb()) {
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
                cwVar2 = this.djE.dih;
                ForumData avD2 = cwVar2.getPbData().avD();
                String name2 = avD2.getName();
                String id3 = avD2.getId();
                cwVar3 = this.djE.dih;
                String id4 = cwVar3.getPbData().avE().getId();
                aVar2 = this.djE.diO;
                elVar13 = this.djE.diR;
                aVar2.a(id3, name2, id4, i5, elVar13.azc());
                this.djE.awU();
            }
        }
    }
}
