package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommEnsureOrderActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.data.PbEcommRecommendMessage;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v170, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x06bc, code lost:
        if (r21 == r1.dTq.aIe().aGy()) goto L135;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:393:0x121d  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x12c5  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x12dd  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x12e7  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x13df  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x14c5  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x14dc  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x14f2  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x1504  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x1512  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x1595  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x15f5  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x16c5  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x16dd  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x1710  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x1713  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x1734  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x1747  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x175a  */
    /* JADX WARN: Removed duplicated region for block: B:570:0x1cfc  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x1cff  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x1d02  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x1d05  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x1d08  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x1d0b  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x1d0e  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        es esVar;
        es esVar2;
        es esVar3;
        es esVar4;
        es esVar5;
        es esVar6;
        dg dgVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        es esVar7;
        es esVar8;
        es esVar9;
        es esVar10;
        es esVar11;
        es esVar12;
        dg dgVar2;
        dg dgVar3;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        es esVar13;
        es esVar14;
        es esVar15;
        es esVar16;
        es esVar17;
        es esVar18;
        es esVar19;
        es esVar20;
        es esVar21;
        es esVar22;
        boolean z;
        es esVar23;
        es esVar24;
        es esVar25;
        dg dgVar4;
        String aEU;
        es esVar26;
        es esVar27;
        es esVar28;
        es esVar29;
        es esVar30;
        es esVar31;
        es esVar32;
        es esVar33;
        es esVar34;
        es esVar35;
        es esVar36;
        dn dnVar;
        dn dnVar2;
        dn dnVar3;
        dn dnVar4;
        dn dnVar5;
        es esVar37;
        es esVar38;
        dn dnVar6;
        es esVar39;
        dg dgVar5;
        es esVar40;
        dg dgVar6;
        dg dgVar7;
        PbActivity.b nv;
        dg dgVar8;
        dg dgVar9;
        dg dgVar10;
        PbActivity.b nv2;
        dg dgVar11;
        dg dgVar12;
        dg dgVar13;
        PbActivity.b nv3;
        dg dgVar14;
        dg dgVar15;
        dg dgVar16;
        dg dgVar17;
        dg dgVar18;
        es esVar41;
        dg dgVar19;
        dg dgVar20;
        dg dgVar21;
        dg dgVar22;
        dg dgVar23;
        dg dgVar24;
        dg dgVar25;
        dg dgVar26;
        dg dgVar27;
        dg dgVar28;
        dg dgVar29;
        dg dgVar30;
        dg dgVar31;
        dg dgVar32;
        PbEcommRecommendMessage pbEcommRecommendMessage;
        int aEI;
        int aEI2;
        dg dgVar33;
        dg dgVar34;
        dg dgVar35;
        dg dgVar36;
        dg dgVar37;
        dg dgVar38;
        dg dgVar39;
        dg dgVar40;
        int aEI3;
        int aEI4;
        dg dgVar41;
        dg dgVar42;
        dg dgVar43;
        dg dgVar44;
        dg dgVar45;
        dg dgVar46;
        dg dgVar47;
        dg dgVar48;
        es esVar42;
        dg dgVar49;
        dg dgVar50;
        dg dgVar51;
        es esVar43;
        dg dgVar52;
        dg dgVar53;
        dg dgVar54;
        dg dgVar55;
        dg dgVar56;
        dg dgVar57;
        es esVar44;
        es esVar45;
        dg dgVar58;
        dn dnVar7;
        dn dnVar8;
        dg dgVar59;
        boolean z2;
        dn dnVar9;
        dn dnVar10;
        dn dnVar11;
        dn dnVar12;
        dg dgVar60;
        dn dnVar13;
        SparseArray sparseArray;
        dn dnVar14;
        SparseArray sparseArray2;
        boolean booleanValue;
        boolean z3;
        dn dnVar15;
        dn dnVar16;
        dn dnVar17;
        dn dnVar18;
        dn dnVar19;
        dn dnVar20;
        dn dnVar21;
        SparseArray sparseArray3;
        boolean z4;
        boolean z5;
        boolean hp;
        boolean isLogin;
        dn dnVar22;
        dn dnVar23;
        dn dnVar24;
        SparseArray sparseArray4;
        boolean z6;
        String str;
        int i;
        dn dnVar25;
        dn dnVar26;
        dn dnVar27;
        dn dnVar28;
        dn dnVar29;
        dn dnVar30;
        dn dnVar31;
        dn dnVar32;
        dn dnVar33;
        dn dnVar34;
        dn dnVar35;
        dn dnVar36;
        dn dnVar37;
        dn dnVar38;
        dn dnVar39;
        dn dnVar40;
        dn dnVar41;
        dg dgVar61;
        dn dnVar42;
        dn dnVar43;
        boolean z7;
        com.baidu.tbadk.core.data.be beVar;
        dg dgVar62;
        dg dgVar63;
        dg dgVar64;
        es esVar46;
        es esVar47;
        es esVar48;
        dg dgVar65;
        dg dgVar66;
        dg dgVar67;
        dg dgVar68;
        es esVar49;
        es esVar50;
        dn dnVar44;
        es esVar51;
        es esVar52;
        dg dgVar69;
        es esVar53;
        dg dgVar70;
        dn dnVar45;
        dg dgVar71;
        dn dnVar46;
        es esVar54;
        dn dnVar47;
        dg dgVar72;
        es esVar55;
        dg dgVar73;
        dn dnVar48;
        dn dnVar49;
        es esVar56;
        es esVar57;
        es esVar58;
        dg dgVar74;
        dg dgVar75;
        es esVar59;
        es esVar60;
        dg dgVar76;
        dg dgVar77;
        dg dgVar78;
        es esVar61;
        es esVar62;
        dg dgVar79;
        dg dgVar80;
        dg dgVar81;
        es esVar63;
        dg dgVar82;
        es esVar64;
        es esVar65;
        es esVar66;
        dg dgVar83;
        es esVar67;
        es esVar68;
        dg dgVar84;
        es esVar69;
        dg dgVar85;
        es esVar70;
        es esVar71;
        es esVar72;
        es esVar73;
        es esVar74;
        es esVar75;
        boolean nh;
        dg dgVar86;
        es esVar76;
        dg dgVar87;
        dg dgVar88;
        dg dgVar89;
        dg dgVar90;
        dg dgVar91;
        dg dgVar92;
        dg dgVar93;
        dg dgVar94;
        dg dgVar95;
        dg dgVar96;
        es esVar77;
        es esVar78;
        dg dgVar97;
        dg dgVar98;
        String name;
        dg dgVar99;
        dg dgVar100;
        dg dgVar101;
        dg dgVar102;
        dg dgVar103;
        dg dgVar104;
        es esVar79;
        dg dgVar105;
        es esVar80;
        es esVar81;
        es esVar82;
        dg dgVar106;
        es esVar83;
        dg dgVar107;
        es esVar84;
        dg dgVar108;
        dg dgVar109;
        es esVar85;
        esVar = this.dPF.dOO;
        if (view == esVar.getNextView()) {
            dgVar109 = this.dPF.dOf;
            if (dgVar109.hw(true)) {
                esVar85 = this.dPF.dOO;
                esVar85.aHo();
                return;
            }
            return;
        }
        esVar2 = this.dPF.dOO;
        if (view == esVar2.aHj()) {
            esVar83 = this.dPF.dOO;
            esVar83.aHd();
            if (UtilHelper.isFloatWindowOpAllowed(this.dPF.getPageContext().getPageActivity())) {
                this.dPF.dOS = true;
                PbActivity pbActivity = this.dPF;
                dgVar107 = this.dPF.dOf;
                pbActivity.a(dgVar107.getPbData(), 0, 1, true, true);
                esVar84 = this.dPF.dOO;
                esVar84.aHc();
                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10830");
                dgVar108 = this.dPF.dOf;
                TiebaStatic.log(ayVar.ab("tid", dgVar108.getThreadID()));
                return;
            }
            this.dPF.aEH();
            return;
        }
        esVar3 = this.dPF.dOO;
        if (view == esVar3.aHK()) {
            esVar80 = this.dPF.dOO;
            esVar80.avf();
            this.dPF.UR();
            esVar81 = this.dPF.dOO;
            esVar81.aHn();
            esVar82 = this.dPF.dOO;
            esVar82.asK();
            dgVar106 = this.dPF.dOf;
            dgVar106.nm(1);
            return;
        }
        esVar4 = this.dPF.dOO;
        if (view == esVar4.dTq.aAp) {
            esVar79 = this.dPF.dOO;
            dgVar105 = this.dPF.dOf;
            if (!esVar79.hR(dgVar105.aFP())) {
                this.dPF.dOy = false;
                this.dPF.finish();
                return;
            }
            this.dPF.UR();
            return;
        }
        esVar5 = this.dPF.dOO;
        if (view != esVar5.aHB()) {
            esVar14 = this.dPF.dOO;
            if (view != esVar14.aHC()) {
                esVar15 = this.dPF.dOO;
                if (view != esVar15.aHD()) {
                    esVar16 = this.dPF.dOO;
                    if (view != esVar16.aHE()) {
                        esVar17 = this.dPF.dOO;
                        if (view != esVar17.aHl()) {
                            esVar18 = this.dPF.dOO;
                            if (view == esVar18.aHH()) {
                                dgVar103 = this.dPF.dOf;
                                if (dgVar103 != null) {
                                    dgVar104 = this.dPF.dOf;
                                    com.baidu.tbadk.browser.f.u(this.dPF.getPageContext().getPageActivity(), dgVar104.getPbData().aDO().qI().getLink());
                                    return;
                                }
                                return;
                            }
                            esVar19 = this.dPF.dOO;
                            if (view != esVar19.dTq.dWs) {
                                esVar20 = this.dPF.dOO;
                                if (view == esVar20.dTq.dWu) {
                                    dgVar93 = this.dPF.dOf;
                                    if (dgVar93 != null) {
                                        dgVar94 = this.dPF.dOf;
                                        if (dgVar94.getPbData() != null) {
                                            dgVar95 = this.dPF.dOf;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = dgVar95.getPbData().aDP();
                                            if (aDP == null || aDP.size() <= 0) {
                                                dgVar96 = this.dPF.dOf;
                                                if (dgVar96.aFM()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.dPF.getPageContext().getPageActivity(), this.dPF.getPageContext().getString(u.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            esVar77 = this.dPF.dOO;
                                            esVar77.aGT();
                                            esVar78 = this.dPF.dOO;
                                            esVar78.aHN();
                                            this.dPF.aEJ();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.dPF.getPageContext().getPageActivity(), this.dPF.getPageContext().getString(u.j.pb_no_data_tips));
                                    return;
                                }
                                esVar21 = this.dPF.dOO;
                                if (view != esVar21.dTq.dWt && view.getId() != u.g.pb_god_user_tip_content) {
                                    esVar28 = this.dPF.dOO;
                                    if (view == esVar28.dTq.dWv) {
                                        dgVar87 = this.dPF.dOf;
                                        AdditionData aDX = dgVar87.getPbData().aDX();
                                        if (!TextUtils.isEmpty(aDX.getWarnMsg())) {
                                            com.baidu.adp.lib.util.k.showToast(this.dPF.getPageContext().getPageActivity(), aDX.getWarnMsg());
                                            return;
                                        } else if (aDX.getAlreadyCount() != aDX.getTotalCount()) {
                                            dgVar88 = this.dPF.dOf;
                                            ForumData aDN = dgVar88.getPbData().aDN();
                                            dgVar89 = this.dPF.dOf;
                                            com.baidu.tbadk.core.data.az aDO = dgVar89.getPbData().aDO();
                                            dgVar90 = this.dPF.dOf;
                                            AntiData pt = dgVar90.getPbData().pt();
                                            if (aDO.getId() != null) {
                                                if (pt != null && pt.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.k.showToast(this.dPF.getPageContext().getPageActivity(), pt.getForbid_info());
                                                    return;
                                                }
                                                int i2 = 0;
                                                dgVar91 = this.dPF.dOf;
                                                if (dgVar91.getPbData().getUserData() != null) {
                                                    dgVar92 = this.dPF.dOf;
                                                    i2 = dgVar92.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.dPF.getPageContext().getPageActivity(), 2, aDN.getId(), aDN.getName(), aDO.getId(), aDX.getPostId(), 0, pt, 13008, false, false, null, false, false, null, aDX, null, i2)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.k.showToast(this.dPF.getPageContext().getPageActivity(), String.format(this.dPF.getPageContext().getString(u.j.write_addition_limit), Integer.valueOf(aDX.getTotalCount())));
                                            return;
                                        }
                                    }
                                    esVar29 = this.dPF.dOO;
                                    if (esVar29.dTq.aIe() != null) {
                                        esVar74 = this.dPF.dOO;
                                        if (view == esVar74.dTq.aIe().aGk()) {
                                            esVar75 = this.dPF.dOO;
                                            esVar75.avf();
                                            nh = this.dPF.nh(11009);
                                            if (nh) {
                                                dgVar86 = this.dPF.dOf;
                                                esVar76 = this.dPF.dOO;
                                                if (dgVar86.ns(esVar76.aHu()) == null) {
                                                    return;
                                                }
                                                this.dPF.aEO();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    esVar30 = this.dPF.dOO;
                                    if (esVar30.dTq.aIe() != null) {
                                        esVar71 = this.dPF.dOO;
                                        if (view != esVar71.dTq.aIe().aGx()) {
                                            esVar73 = this.dPF.dOO;
                                        }
                                        esVar72 = this.dPF.dOO;
                                        esVar72.dTq.nq();
                                        return;
                                    }
                                    esVar31 = this.dPF.dOO;
                                    if (view != esVar31.aHs()) {
                                        esVar32 = this.dPF.dOO;
                                        if (esVar32.dTq.aIe() != null) {
                                            esVar67 = this.dPF.dOO;
                                            if (view == esVar67.dTq.aIe().aGt()) {
                                                esVar68 = this.dPF.dOO;
                                                esVar68.avf();
                                                dgVar84 = this.dPF.dOf;
                                                if (dgVar84.ajw() != null) {
                                                    esVar69 = this.dPF.dOO;
                                                    dgVar85 = this.dPF.dOf;
                                                    esVar69.a(dgVar85.ajw(), this.dPF.dHf);
                                                }
                                                TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        esVar33 = this.dPF.dOO;
                                        if (esVar33.dTq.aIe() != null) {
                                            esVar64 = this.dPF.dOO;
                                            if (view == esVar64.dTq.aIe().aGu()) {
                                                esVar65 = this.dPF.dOO;
                                                esVar65.avf();
                                                this.dPF.ni(2);
                                                this.dPF.UR();
                                                esVar66 = this.dPF.dOO;
                                                esVar66.aHn();
                                                dgVar83 = this.dPF.dOf;
                                                dgVar83.aFV();
                                                TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        esVar34 = this.dPF.dOO;
                                        if (esVar34.dTq.aIe() != null) {
                                            esVar62 = this.dPF.dOO;
                                            if (view == esVar62.dTq.aIe().aGv()) {
                                                dgVar79 = this.dPF.dOf;
                                                if (dgVar79 != null) {
                                                    dgVar80 = this.dPF.dOf;
                                                    if (dgVar80.getPbData() != null) {
                                                        dgVar81 = this.dPF.dOf;
                                                        if (dgVar81.getPbData().aDO() != null) {
                                                            esVar63 = this.dPF.dOO;
                                                            esVar63.dTq.nq();
                                                            PbActivity pbActivity2 = this.dPF;
                                                            dgVar82 = this.dPF.dOf;
                                                            pbActivity2.ns(dgVar82.getPbData().aDO().qV());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        esVar35 = this.dPF.dOO;
                                        if (esVar35.dTq.aIe() != null) {
                                            esVar60 = this.dPF.dOO;
                                            if (view == esVar60.dTq.aIe().dRV) {
                                                dgVar76 = this.dPF.dOf;
                                                if (dgVar76 != null) {
                                                    dgVar77 = this.dPF.dOf;
                                                    if (dgVar77.getPbData() != null) {
                                                        dgVar78 = this.dPF.dOf;
                                                        if (dgVar78.getPbData().aDO() != null) {
                                                            esVar61 = this.dPF.dOO;
                                                            esVar61.dTq.nq();
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.dPF.getPageContext().getPageActivity(), 0, TbConfig.ECOMM_FEED_BACK_ID, TbConfig.ECOMM_FEED_BACK_NAME, null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0)));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        esVar36 = this.dPF.dOO;
                                        if (esVar36.dTq.aIe() != null) {
                                            esVar56 = this.dPF.dOO;
                                            if (view == esVar56.dTq.aIe().aGw()) {
                                                TiebaStatic.log("c10414");
                                                esVar57 = this.dPF.dOO;
                                                esVar57.avf();
                                                esVar58 = this.dPF.dOO;
                                                if (esVar58.qE() != es.dVg) {
                                                    dgVar74 = this.dPF.dOf;
                                                    if (dgVar74.aGj() != null) {
                                                        dgVar75 = this.dPF.dOf;
                                                        dgVar75.aGj().nk(dg.dQN);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                esVar59 = this.dPF.dOO;
                                                esVar59.aHR();
                                                return;
                                            }
                                        }
                                        dnVar = this.dPF.dOR;
                                        if (dnVar != null) {
                                            dnVar49 = this.dPF.dOR;
                                            if (view == dnVar49.aGm()) {
                                                Object tag = view.getTag();
                                                if (!(tag instanceof String)) {
                                                    if (tag instanceof SparseArray) {
                                                        SparseArray<Object> sparseArray5 = (SparseArray) tag;
                                                        if ((sparseArray5.get(u.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(u.g.tag_user_mute_visible)).booleanValue()) {
                                                            sparseArray5.put(u.g.tag_from, 0);
                                                            sparseArray5.put(u.g.tag_check_mute_from, 2);
                                                            this.dPF.d(sparseArray5);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.dPF.ns((String) tag);
                                                return;
                                            }
                                        }
                                        dnVar2 = this.dPF.dOR;
                                        if (dnVar2 != null) {
                                            dnVar48 = this.dPF.dOR;
                                            if (view == dnVar48.aGk()) {
                                                if (!this.dPF.checkUpIsLogin()) {
                                                    return;
                                                }
                                                this.dPF.aW(view);
                                                return;
                                            }
                                        }
                                        dnVar3 = this.dPF.dOR;
                                        if (dnVar3 != null) {
                                            dnVar47 = this.dPF.dOR;
                                            if (view == dnVar47.aGq()) {
                                                if (view.getTag(u.g.tag_pb_floor_postion) instanceof Integer) {
                                                    dgVar72 = this.dPF.dOf;
                                                    if (dgVar72 != null) {
                                                        esVar55 = this.dPF.dOO;
                                                        esVar55.aHd();
                                                        if (!UtilHelper.isFloatWindowOpAllowed(this.dPF.getPageContext().getPageActivity())) {
                                                            this.dPF.aEH();
                                                            return;
                                                        }
                                                        int intValue = ((Integer) view.getTag(u.g.tag_pb_floor_postion)).intValue();
                                                        int intValue2 = ((Integer) view.getTag(u.g.tag_pb_floor_number)).intValue();
                                                        this.dPF.dOS = true;
                                                        PbActivity pbActivity3 = this.dPF;
                                                        dgVar73 = this.dPF.dOf;
                                                        pbActivity3.a(dgVar73.getPbData(), intValue, intValue2, true, true);
                                                        TiebaStatic.log("c10834");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        dnVar4 = this.dPF.dOR;
                                        if (dnVar4 != null) {
                                            dnVar46 = this.dPF.dOR;
                                            if (view == dnVar46.aGn()) {
                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                if (sparseArray6 != null && (sparseArray6.get(u.g.tag_del_post_type) instanceof Integer) && (sparseArray6.get(u.g.tag_del_post_id) instanceof String) && (sparseArray6.get(u.g.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(u.g.tag_del_post_is_self) instanceof Boolean)) {
                                                    esVar54 = this.dPF.dOO;
                                                    esVar54.a(((Integer) sparseArray6.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray6.get(u.g.tag_del_post_id), ((Integer) sparseArray6.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(u.g.tag_del_post_is_self)).booleanValue());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        dnVar5 = this.dPF.dOR;
                                        if (dnVar5 != null) {
                                            dnVar45 = this.dPF.dOR;
                                            if (view == dnVar45.aGo()) {
                                                long j = -1;
                                                String str2 = "";
                                                int i3 = 0;
                                                if (view.getTag(u.g.tag_chudian_template_id) instanceof Long) {
                                                    j = ((Long) view.getTag(u.g.tag_chudian_template_id)).longValue();
                                                }
                                                if (view.getTag(u.g.tag_chudian_monitor_id) instanceof String) {
                                                    str2 = (String) view.getTag(u.g.tag_chudian_monitor_id);
                                                }
                                                if (view.getTag(u.g.tag_chudian_hide_day) instanceof Integer) {
                                                    i3 = ((Integer) view.getTag(u.g.tag_chudian_hide_day)).intValue();
                                                }
                                                dgVar71 = this.dPF.dOf;
                                                com.baidu.tieba.pb.data.h pbData = dgVar71.getPbData();
                                                String str3 = null;
                                                String str4 = null;
                                                String str5 = null;
                                                if (pbData != null && pbData.aDN() != null) {
                                                    str3 = pbData.aDN().getId();
                                                    str4 = pbData.aDN().getName();
                                                    str5 = pbData.getThreadId();
                                                }
                                                com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str3, str4, str5);
                                                this.dPF.a(j, str2, str3, str4, str5, i3);
                                                return;
                                            }
                                        }
                                        esVar37 = this.dPF.dOO;
                                        if (esVar37.aHS() == view) {
                                            esVar53 = this.dPF.dOO;
                                            if (esVar53.aHS().getIndicateStatus()) {
                                                dgVar70 = this.dPF.dOf;
                                                com.baidu.tieba.pb.data.h pbData2 = dgVar70.getPbData();
                                                if (pbData2 != null && pbData2.aDO() != null && pbData2.aDO().qy() != null) {
                                                    String oH = pbData2.aDO().qy().oH();
                                                    if (StringUtils.isNull(oH)) {
                                                        oH = pbData2.aDO().qy().getTaskId();
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11107").ab("obj_id", oH));
                                                }
                                            } else {
                                                com.baidu.tieba.tbadkCore.d.a.bL("c10725", null);
                                            }
                                            this.dPF.aFb();
                                            return;
                                        }
                                        esVar38 = this.dPF.dOO;
                                        if (esVar38.aHg() != view) {
                                            dnVar6 = this.dPF.dOR;
                                            if (dnVar6 != null) {
                                                dnVar44 = this.dPF.dOR;
                                                if (view == dnVar44.aGl()) {
                                                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                                                    if (sparseArray7 != null) {
                                                        boolean booleanValue2 = ((Boolean) sparseArray7.get(u.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue3 = ((Boolean) sparseArray7.get(u.g.tag_should_delete_visible)).booleanValue();
                                                        boolean booleanValue4 = ((Boolean) sparseArray7.get(u.g.tag_user_mute_visible)).booleanValue();
                                                        if (booleanValue2) {
                                                            if (booleanValue4) {
                                                                sparseArray7.put(u.g.tag_from, 1);
                                                                sparseArray7.put(u.g.tag_check_mute_from, 2);
                                                                this.dPF.d(sparseArray7);
                                                                return;
                                                            }
                                                            sparseArray7.put(u.g.tag_check_mute_from, 2);
                                                            esVar52 = this.dPF.dOO;
                                                            esVar52.aZ(view);
                                                            return;
                                                        } else if (booleanValue3) {
                                                            esVar51 = this.dPF.dOO;
                                                            esVar51.a(((Integer) sparseArray7.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(u.g.tag_del_post_id), ((Integer) sparseArray7.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(u.g.tag_del_post_is_self)).booleanValue());
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                            }
                                            esVar39 = this.dPF.dOO;
                                            if (view == esVar39.aFH()) {
                                                if (this.dPF.checkUpIsLogin()) {
                                                    esVar48 = this.dPF.dOO;
                                                    if (!esVar48.aFE()) {
                                                        dgVar65 = this.dPF.dOf;
                                                        if (dgVar65 != null) {
                                                            dgVar66 = this.dPF.dOf;
                                                            if (dgVar66.aGh() != null) {
                                                                dgVar67 = this.dPF.dOf;
                                                                if (dgVar67.aGh().aFy() != null) {
                                                                    dgVar68 = this.dPF.dOf;
                                                                    if (com.baidu.tbadk.core.util.y.s(dgVar68.aGh().aFy().getItems()) != 0) {
                                                                        esVar49 = this.dPF.dOO;
                                                                        esVar49.aFF();
                                                                        return;
                                                                    }
                                                                    this.dPF.showToast(u.j.graffiti_quick_vote_empty);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    esVar50 = this.dPF.dOO;
                                                    esVar50.aFG();
                                                    return;
                                                }
                                                return;
                                            } else if (view.getId() == u.g.pb_head_function_manage_delormanage) {
                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                if (((Boolean) sparseArray8.get(u.g.tag_should_manage_visible)).booleanValue()) {
                                                    esVar47 = this.dPF.dOO;
                                                    esVar47.aZ(view);
                                                    return;
                                                }
                                                esVar46 = this.dPF.dOO;
                                                esVar46.a(((Integer) sparseArray8.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(u.g.tag_del_post_id), ((Integer) sparseArray8.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(u.g.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else if (view.getId() != u.g.replybtn && view.getId() != u.g.sub_pb_more && view.getId() != u.g.sub_pb_item) {
                                                esVar41 = this.dPF.dOO;
                                                if (view == esVar41.aEy()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                        dgVar62 = this.dPF.dOf;
                                                        long c2 = com.baidu.adp.lib.h.b.c(dgVar62.getPbData().getForumId(), 0L);
                                                        dgVar63 = this.dPF.dOf;
                                                        long c3 = com.baidu.adp.lib.h.b.c(dgVar63.getThreadID(), 0L);
                                                        dgVar64 = this.dPF.dOf;
                                                        this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.dPF.getPageContext().getPageActivity(), 24008, c2, c3, c, dgVar64.getPbData().aDO().qY())));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                int id = view.getId();
                                                if (id == u.g.pb_u9_text_view) {
                                                    if (this.dPF.checkUpIsLogin() && (beVar = (com.baidu.tbadk.core.data.be) view.getTag()) != null && !StringUtils.isNull(beVar.rI())) {
                                                        TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                        com.baidu.tbadk.core.util.bi.us().c(this.dPF.getPageContext(), new String[]{beVar.rI()});
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == u.g.reply) {
                                                    dnVar7 = this.dPF.dOR;
                                                    if (dnVar7 == null) {
                                                        this.dPF.dOR = new dn(this.dPF.getPageContext(), this.dPF.bFi);
                                                        dnVar43 = this.dPF.dOR;
                                                        z7 = this.dPF.mIsLogin;
                                                        dnVar43.hA(z7);
                                                    }
                                                    dnVar8 = this.dPF.dOR;
                                                    dnVar8.Fs();
                                                    com.baidu.tieba.tbadkCore.data.s sVar = null;
                                                    if (view != null && view.getTag() != null) {
                                                        sVar = (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(u.g.tag_load_sub_data);
                                                        if (!this.dPF.aEV()) {
                                                            dgVar61 = this.dPF.dOf;
                                                            if (dgVar61.aFW() && TbadkCoreApplication.m9getInst().isTTSCanUse()) {
                                                                dnVar42 = this.dPF.dOR;
                                                                dnVar42.aGs();
                                                                sparseArray = (SparseArray) view.getTag();
                                                                if (sparseArray.get(u.g.tag_pb_floor_postion) instanceof Integer) {
                                                                    int intValue3 = ((Integer) sparseArray.get(u.g.tag_pb_floor_postion)).intValue();
                                                                    int intValue4 = ((Integer) sparseArray.get(u.g.tag_pb_floor_number)).intValue();
                                                                    dnVar40 = this.dPF.dOR;
                                                                    dnVar40.aGq().setTag(u.g.tag_pb_floor_postion, Integer.valueOf(intValue3));
                                                                    dnVar41 = this.dPF.dOR;
                                                                    dnVar41.aGq().setTag(u.g.tag_pb_floor_number, Integer.valueOf(intValue4));
                                                                }
                                                                SparseArray sparseArray9 = new SparseArray();
                                                                sparseArray9.put(u.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(u.g.tag_clip_board));
                                                                sparseArray9.put(u.g.tag_is_subpb, false);
                                                                dnVar14 = this.dPF.dOR;
                                                                dnVar14.aGk().setTag(sparseArray9);
                                                                sparseArray2 = (SparseArray) view.getTag();
                                                                booleanValue = ((Boolean) sparseArray2.get(u.g.tag_should_manage_visible)).booleanValue();
                                                                boolean booleanValue5 = ((Boolean) sparseArray2.get(u.g.tag_user_mute_visible)).booleanValue();
                                                                boolean booleanValue6 = ((Boolean) sparseArray2.get(u.g.tag_should_delete_visible)).booleanValue();
                                                                if (sparseArray2.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                                    z3 = false;
                                                                } else {
                                                                    z3 = ((Boolean) sparseArray2.get(u.g.tag_del_post_is_self)).booleanValue();
                                                                }
                                                                String str6 = null;
                                                                if (sparseArray2.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                                    str6 = (String) sparseArray2.get(u.g.tag_forbid_user_post_id);
                                                                }
                                                                if (!booleanValue) {
                                                                    SparseArray sparseArray10 = new SparseArray();
                                                                    sparseArray10.put(u.g.tag_should_manage_visible, true);
                                                                    sparseArray10.put(u.g.tag_manage_user_identity, sparseArray2.get(u.g.tag_manage_user_identity));
                                                                    sparseArray10.put(u.g.tag_forbid_user_name, sparseArray2.get(u.g.tag_forbid_user_name));
                                                                    sparseArray10.put(u.g.tag_forbid_user_post_id, str6);
                                                                    if (booleanValue5) {
                                                                        sparseArray10.put(u.g.tag_user_mute_visible, true);
                                                                        sparseArray10.put(u.g.tag_is_mem, sparseArray2.get(u.g.tag_is_mem));
                                                                        sparseArray10.put(u.g.tag_user_mute_mute_userid, sparseArray2.get(u.g.tag_user_mute_mute_userid));
                                                                        sparseArray10.put(u.g.tag_user_mute_mute_username, sparseArray2.get(u.g.tag_user_mute_mute_username));
                                                                        sparseArray10.put(u.g.tag_user_mute_post_id, sparseArray2.get(u.g.tag_user_mute_post_id));
                                                                        sparseArray10.put(u.g.tag_user_mute_thread_id, sparseArray2.get(u.g.tag_user_mute_thread_id));
                                                                    } else {
                                                                        sparseArray10.put(u.g.tag_user_mute_visible, false);
                                                                    }
                                                                    if (booleanValue6) {
                                                                        sparseArray10.put(u.g.tag_should_delete_visible, true);
                                                                        sparseArray10.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                        sparseArray10.put(u.g.tag_del_post_id, sparseArray2.get(u.g.tag_del_post_id));
                                                                        sparseArray10.put(u.g.tag_del_post_type, sparseArray2.get(u.g.tag_del_post_type));
                                                                        dnVar39 = this.dPF.dOR;
                                                                        dnVar39.aGn().setVisibility(0);
                                                                    } else {
                                                                        sparseArray10.put(u.g.tag_should_delete_visible, false);
                                                                        dnVar34 = this.dPF.dOR;
                                                                        dnVar34.aGn().setVisibility(8);
                                                                    }
                                                                    dnVar35 = this.dPF.dOR;
                                                                    dnVar35.aGl().setTag(sparseArray10);
                                                                    dnVar36 = this.dPF.dOR;
                                                                    dnVar36.aGn().setTag(sparseArray10);
                                                                    dnVar37 = this.dPF.dOR;
                                                                    dnVar37.aGl().setText(u.j.bar_manager);
                                                                    dnVar38 = this.dPF.dOR;
                                                                    dnVar38.aGl().setVisibility(0);
                                                                } else if (!booleanValue6) {
                                                                    dnVar15 = this.dPF.dOR;
                                                                    dnVar15.aGl().setVisibility(8);
                                                                    dnVar16 = this.dPF.dOR;
                                                                    dnVar16.aGn().setVisibility(8);
                                                                } else {
                                                                    SparseArray sparseArray11 = new SparseArray();
                                                                    sparseArray11.put(u.g.tag_should_manage_visible, false);
                                                                    sparseArray11.put(u.g.tag_user_mute_visible, false);
                                                                    sparseArray11.put(u.g.tag_should_delete_visible, true);
                                                                    sparseArray11.put(u.g.tag_manage_user_identity, sparseArray2.get(u.g.tag_manage_user_identity));
                                                                    sparseArray11.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                    sparseArray11.put(u.g.tag_del_post_id, sparseArray2.get(u.g.tag_del_post_id));
                                                                    sparseArray11.put(u.g.tag_del_post_type, sparseArray2.get(u.g.tag_del_post_type));
                                                                    dnVar17 = this.dPF.dOR;
                                                                    dnVar17.aGl().setTag(sparseArray11);
                                                                    dnVar18 = this.dPF.dOR;
                                                                    dnVar18.aGn().setTag(sparseArray11);
                                                                    dnVar19 = this.dPF.dOR;
                                                                    dnVar19.aGl().setText(u.j.delete);
                                                                    dnVar20 = this.dPF.dOR;
                                                                    dnVar20.aGn().setVisibility(0);
                                                                    dnVar21 = this.dPF.dOR;
                                                                    dnVar21.aGl().setVisibility(8);
                                                                }
                                                                sparseArray3 = (SparseArray) view.getTag();
                                                                if (sparseArray3.get(u.g.tag_user_mute_visible) instanceof Boolean) {
                                                                    z4 = false;
                                                                } else {
                                                                    z4 = ((Boolean) sparseArray3.get(u.g.tag_user_mute_visible)).booleanValue();
                                                                }
                                                                if (((Boolean) sparseArray3.get(u.g.tag_should_manage_visible)).booleanValue() && z4) {
                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                    sparseArray12.put(u.g.tag_user_mute_visible, true);
                                                                    sparseArray12.put(u.g.tag_is_mem, sparseArray3.get(u.g.tag_is_mem));
                                                                    sparseArray12.put(u.g.tag_user_mute_mute_userid, sparseArray3.get(u.g.tag_user_mute_mute_userid));
                                                                    sparseArray12.put(u.g.tag_user_mute_mute_username, sparseArray3.get(u.g.tag_user_mute_mute_username));
                                                                    sparseArray12.put(u.g.tag_user_mute_post_id, sparseArray3.get(u.g.tag_user_mute_post_id));
                                                                    sparseArray12.put(u.g.tag_user_mute_thread_id, sparseArray3.get(u.g.tag_user_mute_thread_id));
                                                                    sparseArray12.put(u.g.tag_del_post_is_self, sparseArray3.get(u.g.tag_del_post_is_self));
                                                                    sparseArray12.put(u.g.tag_del_post_type, sparseArray3.get(u.g.tag_del_post_type));
                                                                    sparseArray12.put(u.g.tag_del_post_id, sparseArray3.get(u.g.tag_del_post_id));
                                                                    sparseArray12.put(u.g.tag_manage_user_identity, sparseArray3.get(u.g.tag_manage_user_identity));
                                                                    dnVar30 = this.dPF.dOR;
                                                                    dnVar30.aGm().setTag(sparseArray12);
                                                                    dnVar31 = this.dPF.dOR;
                                                                    dnVar31.aGm().setVisibility(0);
                                                                    dnVar32 = this.dPF.dOR;
                                                                    dnVar32.aGl().setVisibility(8);
                                                                    dnVar33 = this.dPF.dOR;
                                                                    dnVar33.aGm().setText(u.j.mute_option);
                                                                } else {
                                                                    if (sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                                        z5 = false;
                                                                    } else {
                                                                        z5 = ((Boolean) sparseArray3.get(u.g.tag_del_post_is_self)).booleanValue();
                                                                    }
                                                                    String str7 = null;
                                                                    if (sparseArray3.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                                        str7 = (String) sparseArray3.get(u.g.tag_forbid_user_post_id);
                                                                    }
                                                                    hp = this.dPF.hp(z5);
                                                                    isLogin = hp & this.dPF.isLogin();
                                                                    this.dPF.dPw = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(u.g.tag_clip_board);
                                                                    if (!(!er.f(this.dPF.dPw) ? false : isLogin)) {
                                                                        dnVar23 = this.dPF.dOR;
                                                                        dnVar23.aGm().setVisibility(0);
                                                                        dnVar24 = this.dPF.dOR;
                                                                        dnVar24.aGm().setTag(str7);
                                                                    } else {
                                                                        dnVar22 = this.dPF.dOR;
                                                                        dnVar22.aGm().setVisibility(8);
                                                                    }
                                                                }
                                                                sparseArray4 = (SparseArray) view.getTag();
                                                                long j2 = 0;
                                                                if (sparseArray4.get(u.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = ((Boolean) sparseArray4.get(u.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                }
                                                                if (sparseArray4.get(u.g.tag_chudian_template_id) instanceof Long) {
                                                                    j2 = ((Long) sparseArray4.get(u.g.tag_chudian_template_id)).longValue();
                                                                }
                                                                if (sparseArray4.get(u.g.tag_chudian_monitor_id) instanceof String) {
                                                                    str = "";
                                                                } else {
                                                                    str = (String) sparseArray4.get(u.g.tag_chudian_monitor_id);
                                                                }
                                                                if (sparseArray4.get(u.g.tag_chudian_hide_day) instanceof Integer) {
                                                                    i = 0;
                                                                } else {
                                                                    i = ((Integer) sparseArray4.get(u.g.tag_chudian_hide_day)).intValue();
                                                                }
                                                                if (!z6) {
                                                                    dnVar26 = this.dPF.dOR;
                                                                    dnVar26.aGo().setVisibility(0);
                                                                    dnVar27 = this.dPF.dOR;
                                                                    dnVar27.aGo().setTag(u.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                    dnVar28 = this.dPF.dOR;
                                                                    dnVar28.aGo().setTag(u.g.tag_chudian_monitor_id, str);
                                                                    dnVar29 = this.dPF.dOR;
                                                                    dnVar29.aGo().setTag(u.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                } else {
                                                                    dnVar25 = this.dPF.dOR;
                                                                    dnVar25.aGo().setVisibility(8);
                                                                }
                                                            }
                                                        }
                                                        dnVar13 = this.dPF.dOR;
                                                        dnVar13.aGr();
                                                        sparseArray = (SparseArray) view.getTag();
                                                        if (sparseArray.get(u.g.tag_pb_floor_postion) instanceof Integer) {
                                                        }
                                                        SparseArray sparseArray92 = new SparseArray();
                                                        sparseArray92.put(u.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(u.g.tag_clip_board));
                                                        sparseArray92.put(u.g.tag_is_subpb, false);
                                                        dnVar14 = this.dPF.dOR;
                                                        dnVar14.aGk().setTag(sparseArray92);
                                                        sparseArray2 = (SparseArray) view.getTag();
                                                        booleanValue = ((Boolean) sparseArray2.get(u.g.tag_should_manage_visible)).booleanValue();
                                                        boolean booleanValue52 = ((Boolean) sparseArray2.get(u.g.tag_user_mute_visible)).booleanValue();
                                                        boolean booleanValue62 = ((Boolean) sparseArray2.get(u.g.tag_should_delete_visible)).booleanValue();
                                                        if (sparseArray2.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str62 = null;
                                                        if (sparseArray2.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        if (!booleanValue) {
                                                        }
                                                        sparseArray3 = (SparseArray) view.getTag();
                                                        if (sparseArray3.get(u.g.tag_user_mute_visible) instanceof Boolean) {
                                                        }
                                                        if (((Boolean) sparseArray3.get(u.g.tag_should_manage_visible)).booleanValue()) {
                                                        }
                                                        if (sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean) {
                                                        }
                                                        String str72 = null;
                                                        if (sparseArray3.get(u.g.tag_forbid_user_post_id) instanceof String) {
                                                        }
                                                        hp = this.dPF.hp(z5);
                                                        isLogin = hp & this.dPF.isLogin();
                                                        this.dPF.dPw = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(u.g.tag_clip_board);
                                                        if (!(!er.f(this.dPF.dPw) ? false : isLogin)) {
                                                        }
                                                        sparseArray4 = (SparseArray) view.getTag();
                                                        long j22 = 0;
                                                        if (sparseArray4.get(u.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                        }
                                                        if (sparseArray4.get(u.g.tag_chudian_template_id) instanceof Long) {
                                                        }
                                                        if (sparseArray4.get(u.g.tag_chudian_monitor_id) instanceof String) {
                                                        }
                                                        if (sparseArray4.get(u.g.tag_chudian_hide_day) instanceof Integer) {
                                                        }
                                                        if (!z6) {
                                                        }
                                                    }
                                                    dgVar59 = this.dPF.dOf;
                                                    if (dgVar59.getPbData().mK()) {
                                                        dgVar60 = this.dPF.dOf;
                                                        String mJ = dgVar60.getPbData().mJ();
                                                        if (sVar != null && !com.baidu.adp.lib.util.j.isEmpty(mJ) && mJ.equals(sVar.getId())) {
                                                            z2 = true;
                                                            if (!z2) {
                                                                dnVar12 = this.dPF.dOR;
                                                                dnVar12.aGk().setText(u.j.remove_mark);
                                                            } else {
                                                                dnVar9 = this.dPF.dOR;
                                                                dnVar9.aGk().setText(u.j.mark);
                                                            }
                                                            dnVar10 = this.dPF.dOR;
                                                            dnVar10.hB(true);
                                                            dnVar11 = this.dPF.dOR;
                                                            dnVar11.uP();
                                                            return;
                                                        }
                                                    }
                                                    z2 = false;
                                                    if (!z2) {
                                                    }
                                                    dnVar10 = this.dPF.dOR;
                                                    dnVar10.hB(true);
                                                    dnVar11 = this.dPF.dOR;
                                                    dnVar11.uP();
                                                    return;
                                                } else if (id != u.g.pb_head_reverse_hint) {
                                                    if (id == u.g.pb_act_btn) {
                                                        dgVar52 = this.dPF.dOf;
                                                        if (dgVar52.getPbData() != null) {
                                                            dgVar53 = this.dPF.dOf;
                                                            if (dgVar53.getPbData().aDO() != null) {
                                                                dgVar54 = this.dPF.dOf;
                                                                if (dgVar54.getPbData().aDO().rf() != null) {
                                                                    Activity activity = this.dPF.getActivity();
                                                                    dgVar55 = this.dPF.dOf;
                                                                    com.baidu.tbadk.browser.f.u(activity, dgVar55.getPbData().aDO().rf());
                                                                    dgVar56 = this.dPF.dOf;
                                                                    if (dgVar56.getPbData().aDO().rd() != 1) {
                                                                        dgVar57 = this.dPF.dOf;
                                                                        if (dgVar57.getPbData().aDO().rd() == 2) {
                                                                            TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == u.g.lottery_tail) {
                                                        if (view.getTag(u.g.tag_pb_lottery_tail_link) instanceof String) {
                                                            String str8 = (String) view.getTag(u.g.tag_pb_lottery_tail_link);
                                                            com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c10912");
                                                            dgVar49 = this.dPF.dOf;
                                                            com.baidu.tbadk.core.util.ay ab = ayVar2.ab("fid", dgVar49.getPbData().getForumId());
                                                            dgVar50 = this.dPF.dOf;
                                                            TiebaStatic.log(ab.ab("tid", dgVar50.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                            dgVar51 = this.dPF.dOf;
                                                            if (dgVar51.getPbData().getThreadId().equals(str8)) {
                                                                esVar43 = this.dPF.dOO;
                                                                esVar43.setSelection(0);
                                                                return;
                                                            }
                                                            this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.dPF.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == u.g.pb_item_tail_content) {
                                                        if (com.baidu.tbadk.core.util.bn.ab(this.dPF.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.m9getInst().getString(u.j.tail_web_view_title);
                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.sO().getString("tail_link", "");
                                                            if (!StringUtils.isNull(string2)) {
                                                                TiebaStatic.log("c10056");
                                                                com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                            }
                                                            esVar42 = this.dPF.dOO;
                                                            esVar42.aGT();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == u.g.join_vote_tv) {
                                                        if (view != null) {
                                                            com.baidu.tbadk.browser.f.u(this.dPF.getActivity(), (String) view.getTag());
                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                            aEI3 = this.dPF.aEI();
                                                            if (aEI3 == 1) {
                                                                dgVar45 = this.dPF.dOf;
                                                                if (dgVar45 != null) {
                                                                    dgVar46 = this.dPF.dOf;
                                                                    if (dgVar46.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c10397");
                                                                        dgVar47 = this.dPF.dOf;
                                                                        com.baidu.tbadk.core.util.ay ab2 = ayVar3.ab("fid", dgVar47.getPbData().getForumId());
                                                                        dgVar48 = this.dPF.dOf;
                                                                        TiebaStatic.log(ab2.ab("tid", dgVar48.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aEI4 = this.dPF.aEI();
                                                            if (aEI4 == 2) {
                                                                dgVar41 = this.dPF.dOf;
                                                                if (dgVar41 != null) {
                                                                    dgVar42 = this.dPF.dOf;
                                                                    if (dgVar42.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar4 = new com.baidu.tbadk.core.util.ay("c10401");
                                                                        dgVar43 = this.dPF.dOf;
                                                                        com.baidu.tbadk.core.util.ay ab3 = ayVar4.ab("fid", dgVar43.getPbData().getForumId());
                                                                        dgVar44 = this.dPF.dOf;
                                                                        TiebaStatic.log(ab3.ab("tid", dgVar44.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id == u.g.look_all_tv) {
                                                        if (view != null) {
                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                            com.baidu.tbadk.browser.f.u(this.dPF.getActivity(), (String) view.getTag());
                                                            aEI = this.dPF.aEI();
                                                            if (aEI == 1) {
                                                                dgVar37 = this.dPF.dOf;
                                                                if (dgVar37 != null) {
                                                                    dgVar38 = this.dPF.dOf;
                                                                    if (dgVar38.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar5 = new com.baidu.tbadk.core.util.ay("c10507");
                                                                        dgVar39 = this.dPF.dOf;
                                                                        com.baidu.tbadk.core.util.ay ab4 = ayVar5.ab("fid", dgVar39.getPbData().getForumId());
                                                                        dgVar40 = this.dPF.dOf;
                                                                        TiebaStatic.log(ab4.ab("tid", dgVar40.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            aEI2 = this.dPF.aEI();
                                                            if (aEI2 == 2) {
                                                                dgVar33 = this.dPF.dOf;
                                                                if (dgVar33 != null) {
                                                                    dgVar34 = this.dPF.dOf;
                                                                    if (dgVar34.getPbData() != null) {
                                                                        com.baidu.tbadk.core.util.ay ayVar6 = new com.baidu.tbadk.core.util.ay("c10508");
                                                                        dgVar35 = this.dPF.dOf;
                                                                        com.baidu.tbadk.core.util.ay ab5 = ayVar6.ab("fid", dgVar35.getPbData().getForumId());
                                                                        dgVar36 = this.dPF.dOf;
                                                                        TiebaStatic.log(ab5.ab("tid", dgVar36.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id != u.g.manga_prev_btn) {
                                                        if (id != u.g.manga_next_btn) {
                                                            if (id == u.g.pb_ecomm_like_button) {
                                                                dgVar27 = this.dPF.dOf;
                                                                if (dgVar27 != null) {
                                                                    dgVar29 = this.dPF.dOf;
                                                                    if (dgVar29.getPbData() != null) {
                                                                        dgVar30 = this.dPF.dOf;
                                                                        if (dgVar30.getPbData().aDO() != null) {
                                                                            dgVar31 = this.dPF.dOf;
                                                                            if (dgVar31.getPbData().aDO().Rl != null) {
                                                                                if (com.baidu.tbadk.core.util.bn.ab(this.dPF.getPageContext().getPageActivity())) {
                                                                                    dgVar32 = this.dPF.dOf;
                                                                                    DealInfoData dealInfoData = dgVar32.getPbData().aDO().Rl;
                                                                                    long j3 = dealInfoData.productId;
                                                                                    if (dealInfoData.hasRecommend) {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, false);
                                                                                    } else {
                                                                                        pbEcommRecommendMessage = new PbEcommRecommendMessage(j3, true);
                                                                                    }
                                                                                    this.dPF.sendMessage(pbEcommRecommendMessage);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ay ayVar7 = new com.baidu.tbadk.core.util.ay("c11428");
                                                                ayVar7.s("obj_param1", 1);
                                                                dgVar28 = this.dPF.dOf;
                                                                ayVar7.ab("obj_id", new StringBuilder(String.valueOf(dgVar28.getPbData().aDO().Rl.productId)).toString());
                                                                ayVar7.s("obj_locate", 3);
                                                                if (ayVar7 != null) {
                                                                    TiebaStatic.log(ayVar7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id == u.g.pb_editor_tool_comment_ecomm_buy_layout) {
                                                                dgVar19 = this.dPF.dOf;
                                                                if (dgVar19 != null) {
                                                                    dgVar21 = this.dPF.dOf;
                                                                    if (dgVar21.getPbData() != null) {
                                                                        dgVar22 = this.dPF.dOf;
                                                                        if (dgVar22.getPbData().aDO() != null) {
                                                                            dgVar23 = this.dPF.dOf;
                                                                            if (dgVar23.getPbData().aDO().Rl != null) {
                                                                                if (com.baidu.tbadk.core.util.bn.ab(this.dPF.getPageContext().getPageActivity())) {
                                                                                    dgVar24 = this.dPF.dOf;
                                                                                    long j4 = dgVar24.getPbData().aDO().Rl.productId;
                                                                                    dgVar25 = this.dPF.dOf;
                                                                                    String threadID = dgVar25.getThreadID();
                                                                                    dgVar26 = this.dPF.dOf;
                                                                                    String name2 = dgVar26.getPbData().aDN().getName();
                                                                                    EcommEnsureOrderActivityConfig ecommEnsureOrderActivityConfig = new EcommEnsureOrderActivityConfig(this.dPF.getPageContext().getPageActivity(), j4, threadID);
                                                                                    ecommEnsureOrderActivityConfig.setForumName(name2);
                                                                                    this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommEnsureOrderActivityConfig));
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                com.baidu.tbadk.core.util.ay ayVar8 = new com.baidu.tbadk.core.util.ay("c11428");
                                                                ayVar8.s("obj_param1", 1);
                                                                dgVar20 = this.dPF.dOf;
                                                                ayVar8.ab("obj_id", new StringBuilder(String.valueOf(dgVar20.getPbData().aDO().Rl.productId)).toString());
                                                                ayVar8.s("obj_locate", 2);
                                                                if (ayVar8 != null) {
                                                                    TiebaStatic.log(ayVar8);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        this.dPF.aEX();
                                                        return;
                                                    } else {
                                                        this.dPF.aEW();
                                                        return;
                                                    }
                                                } else {
                                                    this.dPF.UR();
                                                    esVar44 = this.dPF.dOO;
                                                    esVar44.avf();
                                                    esVar45 = this.dPF.dOO;
                                                    esVar45.aHn();
                                                    dgVar58 = this.dPF.dOf;
                                                    dgVar58.aFV();
                                                    this.dPF.ni(2);
                                                    this.dPF.aFa();
                                                    return;
                                                }
                                            } else if (this.dPF.checkUpIsLogin()) {
                                                dgVar5 = this.dPF.dOf;
                                                if (dgVar5.getPbData() != null) {
                                                    esVar40 = this.dPF.dOO;
                                                    esVar40.avf();
                                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) sparseArray13.get(u.g.tag_load_sub_data);
                                                    View view2 = (View) sparseArray13.get(u.g.tag_load_sub_view);
                                                    if (sVar2 != null && view2 != null) {
                                                        dgVar6 = this.dPF.dOf;
                                                        String threadID2 = dgVar6.getThreadID();
                                                        String id2 = sVar2.getId();
                                                        int i4 = 0;
                                                        dgVar7 = this.dPF.dOf;
                                                        if (dgVar7.getPbData() != null) {
                                                            dgVar17 = this.dPF.dOf;
                                                            i4 = dgVar17.getPbData().aDU();
                                                        }
                                                        this.dPF.UR();
                                                        if (view.getId() != u.g.replybtn) {
                                                            if (view.getId() == u.g.sub_pb_item) {
                                                                SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                                String str9 = (String) sparseArray14.get(u.g.tag_photo_username);
                                                                com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) sparseArray14.get(u.g.tag_clip_board);
                                                                String str10 = null;
                                                                if (sVar3 != null) {
                                                                    str10 = sVar3.getId();
                                                                }
                                                                TiebaStatic.log("c10088");
                                                                nv2 = this.dPF.nv(id2);
                                                                if (sVar2 != null) {
                                                                    dgVar11 = this.dPF.dOf;
                                                                    if (dgVar11 != null) {
                                                                        dgVar12 = this.dPF.dOf;
                                                                        if (dgVar12.getPbData() != null && nv2 != null) {
                                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.dPF.getPageContext().getPageActivity());
                                                                            SmallTailInfo aIV = sVar2.aIV();
                                                                            dgVar13 = this.dPF.dOf;
                                                                            this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID2, id2, "pb", true, str9, true, str10, i4, aIV, dgVar13.getPbData().pt(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(nv2.dPT, nv2.dPU, nv2.dPV, nv2.index)));
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.log("c10089");
                                                            nv = this.dPF.nv(id2);
                                                            if (sVar2 != null) {
                                                                dgVar8 = this.dPF.dOf;
                                                                if (dgVar8 != null) {
                                                                    dgVar9 = this.dPF.dOf;
                                                                    if (dgVar9.getPbData() != null && nv != null) {
                                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.dPF.getPageContext().getPageActivity());
                                                                        SmallTailInfo aIV2 = sVar2.aIV();
                                                                        dgVar10 = this.dPF.dOf;
                                                                        this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID2, id2, "pb", true, null, false, null, i4, aIV2, dgVar10.getPbData().pt(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(nv.dPT, nv.dPU, nv.dPV, nv.index)));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        nv3 = this.dPF.nv(id2);
                                                        if (sVar2 != null) {
                                                            dgVar14 = this.dPF.dOf;
                                                            if (dgVar14 != null) {
                                                                dgVar15 = this.dPF.dOf;
                                                                if (dgVar15.getPbData() != null && nv3 != null) {
                                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.dPF.getPageContext().getPageActivity());
                                                                    SmallTailInfo aIV3 = sVar2.aIV();
                                                                    dgVar16 = this.dPF.dOf;
                                                                    this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID2, id2, "pb", true, null, true, null, i4, aIV3, dgVar16.getPbData().pt(), false, sVar2.getAuthor().getIconInfo()).addBigImageData(nv3.dPT, nv3.dPU, nv3.dPV, nv3.index)));
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
                                                com.baidu.tbadk.core.util.ay s = new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 3);
                                                dgVar18 = this.dPF.dOf;
                                                TiebaStatic.log(s.ab("fid", dgVar18.getPbData().getForumId()));
                                                return;
                                            }
                                        } else if (!this.dPF.checkUpIsLogin()) {
                                            com.baidu.tbadk.core.util.ay s2 = new com.baidu.tbadk.core.util.ay("c10517").s("obj_locate", 2);
                                            dgVar69 = this.dPF.dOf;
                                            TiebaStatic.log(s2.ab("fid", dgVar69.getPbData().getForumId()));
                                            return;
                                        } else {
                                            this.dPF.aEA();
                                            return;
                                        }
                                    } else if (this.dPF.checkUpIsLogin()) {
                                        esVar70 = this.dPF.dOO;
                                        esVar70.avf();
                                        this.dPF.UR();
                                        this.dPF.ni(2);
                                        this.dPF.aaO();
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.i.fr()) {
                                    esVar22 = this.dPF.dOO;
                                    esVar22.aGT();
                                    z = this.dPF.mIsLoading;
                                    if (!z) {
                                        this.dPF.mIsLoading = true;
                                        esVar23 = this.dPF.dOO;
                                        esVar23.dTq.dWt.setEnabled(false);
                                        esVar24 = this.dPF.dOO;
                                        esVar24.aoD();
                                        this.dPF.UR();
                                        esVar25 = this.dPF.dOO;
                                        esVar25.aHn();
                                        dgVar4 = this.dPF.dOf;
                                        aEU = this.dPF.aEU();
                                        dgVar4.ny(aEU);
                                        TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        esVar26 = this.dPF.dOO;
                                        esVar26.aHN();
                                        esVar27 = this.dPF.dOO;
                                        esVar27.aFG();
                                        this.dPF.ni(2);
                                        return;
                                    }
                                    return;
                                } else {
                                    this.dPF.showToast(u.j.network_not_available);
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            dgVar97 = this.dPF.dOf;
                            if (dgVar97.getErrorNo() == 4) {
                                dgVar100 = this.dPF.dOf;
                                if (StringUtils.isNull(dgVar100.aFL())) {
                                    dgVar101 = this.dPF.dOf;
                                    if (dgVar101.getAppealInfo() != null) {
                                        dgVar102 = this.dPF.dOf;
                                        name = dgVar102.getAppealInfo().forumName;
                                    }
                                }
                                this.dPF.finish();
                                return;
                            }
                            dgVar98 = this.dPF.dOf;
                            name = dgVar98.getPbData().aDN().getName();
                            if (!StringUtils.isNull(name)) {
                                dgVar99 = this.dPF.dOf;
                                String aFL = dgVar99.aFL();
                                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.dPF.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (StringUtils.isNull(aFL)) {
                                    this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                } else if (aFL.equals(name)) {
                                    this.dPF.finish();
                                    return;
                                } else {
                                    this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    return;
                                }
                            }
                            this.dPF.finish();
                            return;
                        }
                    }
                }
            }
        }
        esVar6 = this.dPF.dOO;
        esVar6.aHG();
        dgVar = this.dPF.dOf;
        if (dgVar.getPbData().aDU() == 1) {
            aVar = this.dPF.dON;
            if (!aVar.bdc()) {
                esVar7 = this.dPF.dOO;
                esVar7.aHk();
                int i5 = 0;
                esVar8 = this.dPF.dOO;
                if (view != esVar8.aHB()) {
                    esVar9 = this.dPF.dOO;
                    if (view != esVar9.aHC()) {
                        esVar10 = this.dPF.dOO;
                        if (view != esVar10.aHD()) {
                            esVar11 = this.dPF.dOO;
                            if (view != esVar11.aHE()) {
                                esVar12 = this.dPF.dOO;
                                if (view == esVar12.aHl()) {
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
                dgVar2 = this.dPF.dOf;
                ForumData aDN2 = dgVar2.getPbData().aDN();
                String name3 = aDN2.getName();
                String id3 = aDN2.getId();
                dgVar3 = this.dPF.dOf;
                String id4 = dgVar3.getPbData().aDO().getId();
                aVar2 = this.dPF.dON;
                esVar13 = this.dPF.dOO;
                aVar2.a(id3, name3, id4, i5, esVar13.aHm());
            }
        }
    }
}
