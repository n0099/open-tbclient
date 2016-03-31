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
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v152, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:351:0x1161  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x11e8  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x1200  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x120a  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x1302  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x13e8  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x13ff  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x1415  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x1427  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x1435  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x14b8  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x1518  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x15e8  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x1600  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x1633  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x1636  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x1657  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x166a  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x167d  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x1a41  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x1a44  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x1a47  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x1a4a  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x1a4d  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x1a50  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x1a53  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        eu euVar;
        eu euVar2;
        eu euVar3;
        eu euVar4;
        eu euVar5;
        eu euVar6;
        df dfVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        eu euVar7;
        eu euVar8;
        eu euVar9;
        eu euVar10;
        eu euVar11;
        eu euVar12;
        df dfVar2;
        df dfVar3;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        eu euVar13;
        eu euVar14;
        eu euVar15;
        eu euVar16;
        eu euVar17;
        eu euVar18;
        eu euVar19;
        eu euVar20;
        eu euVar21;
        eu euVar22;
        boolean z;
        eu euVar23;
        eu euVar24;
        eu euVar25;
        df dfVar4;
        String awC;
        eu euVar26;
        eu euVar27;
        eu euVar28;
        eu euVar29;
        eu euVar30;
        eu euVar31;
        eu euVar32;
        eu euVar33;
        eu euVar34;
        dn dnVar;
        dn dnVar2;
        dn dnVar3;
        dn dnVar4;
        dn dnVar5;
        eu euVar35;
        eu euVar36;
        dn dnVar6;
        eu euVar37;
        df dfVar5;
        eu euVar38;
        df dfVar6;
        df dfVar7;
        eu euVar39;
        PbActivity.b lU;
        df dfVar8;
        PbActivity.b lU2;
        df dfVar9;
        PbActivity.b lU3;
        df dfVar10;
        df dfVar11;
        df dfVar12;
        eu euVar40;
        int awo;
        int awo2;
        df dfVar13;
        df dfVar14;
        df dfVar15;
        df dfVar16;
        df dfVar17;
        df dfVar18;
        df dfVar19;
        df dfVar20;
        int awo3;
        int awo4;
        df dfVar21;
        df dfVar22;
        df dfVar23;
        df dfVar24;
        df dfVar25;
        df dfVar26;
        df dfVar27;
        df dfVar28;
        eu euVar41;
        df dfVar29;
        df dfVar30;
        df dfVar31;
        df dfVar32;
        df dfVar33;
        df dfVar34;
        df dfVar35;
        df dfVar36;
        eu euVar42;
        eu euVar43;
        df dfVar37;
        dn dnVar7;
        dn dnVar8;
        df dfVar38;
        boolean z2;
        dn dnVar9;
        dn dnVar10;
        dn dnVar11;
        dn dnVar12;
        df dfVar39;
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
        boolean fW;
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
        df dfVar40;
        dn dnVar41;
        com.baidu.tbadk.core.data.aw awVar;
        df dfVar41;
        df dfVar42;
        eu euVar44;
        eu euVar45;
        eu euVar46;
        df dfVar43;
        df dfVar44;
        df dfVar45;
        df dfVar46;
        eu euVar47;
        eu euVar48;
        dn dnVar42;
        eu euVar49;
        eu euVar50;
        df dfVar47;
        df dfVar48;
        df dfVar49;
        df dfVar50;
        df dfVar51;
        df dfVar52;
        df dfVar53;
        df dfVar54;
        dn dnVar43;
        df dfVar55;
        dn dnVar44;
        eu euVar51;
        dn dnVar45;
        df dfVar56;
        eu euVar52;
        df dfVar57;
        dn dnVar46;
        dn dnVar47;
        eu euVar53;
        eu euVar54;
        eu euVar55;
        df dfVar58;
        eu euVar56;
        eu euVar57;
        df dfVar59;
        df dfVar60;
        df dfVar61;
        eu euVar58;
        df dfVar62;
        df dfVar63;
        df dfVar64;
        eu euVar59;
        eu euVar60;
        eu euVar61;
        df dfVar65;
        eu euVar62;
        eu euVar63;
        df dfVar66;
        eu euVar64;
        df dfVar67;
        eu euVar65;
        eu euVar66;
        eu euVar67;
        eu euVar68;
        boolean lV;
        df dfVar68;
        eu euVar69;
        df dfVar69;
        df dfVar70;
        df dfVar71;
        df dfVar72;
        df dfVar73;
        df dfVar74;
        df dfVar75;
        df dfVar76;
        df dfVar77;
        df dfVar78;
        eu euVar70;
        eu euVar71;
        df dfVar79;
        df dfVar80;
        df dfVar81;
        df dfVar82;
        df dfVar83;
        df dfVar84;
        df dfVar85;
        df dfVar86;
        df dfVar87;
        eu euVar72;
        df dfVar88;
        eu euVar73;
        eu euVar74;
        eu euVar75;
        df dfVar89;
        eu euVar76;
        df dfVar90;
        eu euVar77;
        df dfVar91;
        df dfVar92;
        eu euVar78;
        euVar = this.dht.dgF;
        if (view == euVar.getNextView()) {
            dfVar92 = this.dht.dfV;
            if (dfVar92.gb(true)) {
                euVar78 = this.dht.dgF;
                euVar78.ayF();
                return;
            }
            return;
        }
        euVar2 = this.dht.dgF;
        if (view == euVar2.ayA()) {
            euVar76 = this.dht.dgF;
            euVar76.ayv();
            if (UtilHelper.isFloatWindowOpAllowed(this.dht.getPageContext().getPageActivity())) {
                this.dht.dgK = true;
                PbActivity pbActivity = this.dht;
                dfVar90 = this.dht.dfV;
                pbActivity.a(dfVar90.getPbData(), 0, true, true);
                euVar77 = this.dht.dgF;
                euVar77.ayu();
                com.baidu.tbadk.core.util.aw awVar2 = new com.baidu.tbadk.core.util.aw("c10830");
                dfVar91 = this.dht.dfV;
                TiebaStatic.log(awVar2.ac("tid", dfVar91.getThreadID()));
                return;
            }
            this.dht.awn();
            return;
        }
        euVar3 = this.dht.dgF;
        if (view == euVar3.aze()) {
            euVar73 = this.dht.dgF;
            euVar73.amI();
            this.dht.Qn();
            euVar74 = this.dht.dgF;
            euVar74.ayE();
            euVar75 = this.dht.dgF;
            euVar75.akp();
            dfVar89 = this.dht.dfV;
            dfVar89.lY(1);
            return;
        }
        euVar4 = this.dht.dgF;
        if (view == euVar4.dkF.aDt) {
            euVar72 = this.dht.dgF;
            dfVar88 = this.dht.dfV;
            if (!euVar72.gv(dfVar88.axi())) {
                this.dht.dgm = false;
                this.dht.finish();
                return;
            }
            this.dht.Qn();
            return;
        }
        euVar5 = this.dht.dgF;
        if (view != euVar5.ayU()) {
            euVar14 = this.dht.dgF;
            if (view != euVar14.ayV()) {
                euVar15 = this.dht.dgF;
                if (view != euVar15.ayW()) {
                    euVar16 = this.dht.dgF;
                    if (view != euVar16.ayX()) {
                        euVar17 = this.dht.dgF;
                        if (view != euVar17.ayC()) {
                            euVar18 = this.dht.dgF;
                            if (view == euVar18.azb()) {
                                dfVar86 = this.dht.dfV;
                                if (dfVar86 != null) {
                                    dfVar87 = this.dht.dfV;
                                    com.baidu.tbadk.browser.f.s(this.dht.getPageContext().getPageActivity(), dfVar87.getPbData().avv().tp().getLink());
                                    return;
                                }
                                return;
                            }
                            euVar19 = this.dht.dgF;
                            if (view != euVar19.dkF.dnF) {
                                euVar20 = this.dht.dgF;
                                if (view == euVar20.dkF.dnH) {
                                    dfVar75 = this.dht.dfV;
                                    if (dfVar75 != null) {
                                        dfVar76 = this.dht.dfV;
                                        if (dfVar76.getPbData() != null) {
                                            dfVar77 = this.dht.dfV;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = dfVar77.getPbData().avw();
                                            if (avw == null || avw.size() <= 0) {
                                                dfVar78 = this.dht.dfV;
                                                if (dfVar78.axe()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.dht.getPageContext().getPageActivity(), this.dht.getPageContext().getString(t.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            euVar70 = this.dht.dgF;
                                            euVar70.ayk();
                                            euVar71 = this.dht.dgF;
                                            euVar71.azg();
                                            this.dht.awp();
                                            this.dht.awJ();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.dht.getPageContext().getPageActivity(), this.dht.getPageContext().getString(t.j.pb_no_data_tips));
                                    return;
                                }
                                euVar21 = this.dht.dgF;
                                if (view == euVar21.dkF.dnG || view.getId() == t.g.pb_god_user_tip_content) {
                                    euVar22 = this.dht.dgF;
                                    euVar22.ayk();
                                    z = this.dht.mIsLoading;
                                    if (!z) {
                                        this.dht.mIsLoading = true;
                                        euVar23 = this.dht.dgF;
                                        euVar23.dkF.dnG.setEnabled(false);
                                        euVar24 = this.dht.dgF;
                                        euVar24.agh();
                                        this.dht.Qn();
                                        euVar25 = this.dht.dgF;
                                        euVar25.ayE();
                                        dfVar4 = this.dht.dfV;
                                        awC = this.dht.awC();
                                        dfVar4.lX(awC);
                                        TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        euVar26 = this.dht.dgF;
                                        euVar26.azg();
                                        euVar27 = this.dht.dgF;
                                        euVar27.ayL();
                                        this.dht.awJ();
                                        return;
                                    }
                                    return;
                                }
                                euVar28 = this.dht.dgF;
                                if (view == euVar28.dkF.dnI) {
                                    dfVar69 = this.dht.dfV;
                                    AdditionData avE = dfVar69.getPbData().avE();
                                    if (!TextUtils.isEmpty(avE.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.dht.getPageContext().getPageActivity(), avE.getWarnMsg());
                                        return;
                                    } else if (avE.getAlreadyCount() != avE.getTotalCount()) {
                                        dfVar70 = this.dht.dfV;
                                        ForumData avu = dfVar70.getPbData().avu();
                                        dfVar71 = this.dht.dfV;
                                        com.baidu.tbadk.core.data.as avv = dfVar71.getPbData().avv();
                                        dfVar72 = this.dht.dfV;
                                        AntiData sf = dfVar72.getPbData().sf();
                                        if (avv.getId() != null) {
                                            if (sf != null && sf.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.dht.getPageContext().getPageActivity(), sf.getForbid_info());
                                                return;
                                            }
                                            int i2 = 0;
                                            dfVar73 = this.dht.dfV;
                                            if (dfVar73.getPbData().getUserData() != null) {
                                                dfVar74 = this.dht.dfV;
                                                i2 = dfVar74.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.dht.getPageContext().getPageActivity(), 2, avu.getId(), avu.getName(), avv.getId(), avE.getPostId(), 0, sf, 13008, false, false, null, false, false, null, avE, null, i2)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.dht.getPageContext().getPageActivity(), String.format(this.dht.getPageContext().getString(t.j.write_addition_limit), Integer.valueOf(avE.getTotalCount())));
                                        return;
                                    }
                                }
                                euVar29 = this.dht.dgF;
                                if (euVar29.dkF.azw() != null) {
                                    euVar67 = this.dht.dgF;
                                    if (view == euVar67.dkF.azw().axB()) {
                                        euVar68 = this.dht.dgF;
                                        euVar68.amI();
                                        lV = this.dht.lV(11009);
                                        if (lV) {
                                            dfVar68 = this.dht.dfV;
                                            euVar69 = this.dht.dgF;
                                            if (dfVar68.me(euVar69.ayN()) == null) {
                                                return;
                                            }
                                            this.dht.awu();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                euVar30 = this.dht.dgF;
                                if (euVar30.dkF.azw() != null) {
                                    euVar65 = this.dht.dgF;
                                    if (view == euVar65.dkF.azw().axK()) {
                                        euVar66 = this.dht.dgF;
                                        euVar66.amI();
                                        this.dht.Qn();
                                        this.dht.Rf();
                                        return;
                                    }
                                }
                                euVar31 = this.dht.dgF;
                                if (euVar31.dkF.azw() != null) {
                                    euVar62 = this.dht.dgF;
                                    if (view == euVar62.dkF.azw().axM()) {
                                        euVar63 = this.dht.dgF;
                                        euVar63.amI();
                                        dfVar66 = this.dht.dfV;
                                        if (dfVar66.abt() != null) {
                                            euVar64 = this.dht.dgF;
                                            dfVar67 = this.dht.dfV;
                                            euVar64.a(dfVar67.abt(), this.dht.cYh);
                                        }
                                        TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                euVar32 = this.dht.dgF;
                                if (euVar32.dkF.azw() != null) {
                                    euVar59 = this.dht.dgF;
                                    if (view == euVar59.dkF.azw().axN()) {
                                        euVar60 = this.dht.dgF;
                                        euVar60.amI();
                                        this.dht.Qn();
                                        euVar61 = this.dht.dgF;
                                        euVar61.ayE();
                                        dfVar65 = this.dht.dfV;
                                        dfVar65.axn();
                                        TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        this.dht.awJ();
                                        return;
                                    }
                                }
                                euVar33 = this.dht.dgF;
                                if (euVar33.dkF.azw() != null) {
                                    euVar57 = this.dht.dgF;
                                    if (view == euVar57.dkF.azw().axO()) {
                                        dfVar59 = this.dht.dfV;
                                        if (dfVar59 != null) {
                                            dfVar60 = this.dht.dfV;
                                            if (dfVar60.getPbData() != null) {
                                                dfVar61 = this.dht.dfV;
                                                if (dfVar61.getPbData().avv() != null) {
                                                    euVar58 = this.dht.dgF;
                                                    euVar58.dkF.pZ();
                                                    dfVar62 = this.dht.dfV;
                                                    if (dfVar62.getPbData().avw() != null) {
                                                        dfVar63 = this.dht.dfV;
                                                        if (dfVar63.getPbData().avw().size() > 0) {
                                                            PbActivity pbActivity2 = this.dht;
                                                            dfVar64 = this.dht.dfV;
                                                            pbActivity2.lN(dfVar64.getPbData().avw().get(0).getId());
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
                                    }
                                }
                                euVar34 = this.dht.dgF;
                                if (euVar34.dkF.azw() != null) {
                                    euVar53 = this.dht.dgF;
                                    if (view == euVar53.dkF.azw().axP()) {
                                        TiebaStatic.log("c10414");
                                        euVar54 = this.dht.dgF;
                                        euVar54.amI();
                                        euVar55 = this.dht.dgF;
                                        if (euVar55.tl() != eu.dmo) {
                                            dfVar58 = this.dht.dfV;
                                            dfVar58.mf(df.djr);
                                            return;
                                        }
                                        euVar56 = this.dht.dgF;
                                        euVar56.azk();
                                        return;
                                    }
                                }
                                dnVar = this.dht.dgJ;
                                if (dnVar != null) {
                                    dnVar47 = this.dht.dgJ;
                                    if (view == dnVar47.axD()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray5 = (SparseArray) tag;
                                                if ((sparseArray5.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray5.get(t.g.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray5.put(t.g.tag_from, 0);
                                                    sparseArray5.put(t.g.tag_check_mute_from, 2);
                                                    this.dht.d(sparseArray5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        this.dht.lN((String) tag);
                                        return;
                                    }
                                }
                                dnVar2 = this.dht.dgJ;
                                if (dnVar2 != null) {
                                    dnVar46 = this.dht.dgJ;
                                    if (view == dnVar46.axB()) {
                                        if (!this.dht.checkUpIsLogin()) {
                                            return;
                                        }
                                        this.dht.aK(view);
                                        return;
                                    }
                                }
                                dnVar3 = this.dht.dgJ;
                                if (dnVar3 != null) {
                                    dnVar45 = this.dht.dgJ;
                                    if (view == dnVar45.axH()) {
                                        if (view.getTag(t.g.tag_pb_floor_postion) instanceof Integer) {
                                            dfVar56 = this.dht.dfV;
                                            if (dfVar56 != null) {
                                                euVar52 = this.dht.dgF;
                                                euVar52.ayv();
                                                if (!UtilHelper.isFloatWindowOpAllowed(this.dht.getPageContext().getPageActivity())) {
                                                    this.dht.awn();
                                                    return;
                                                }
                                                int intValue = ((Integer) view.getTag(t.g.tag_pb_floor_postion)).intValue();
                                                this.dht.dgK = true;
                                                PbActivity pbActivity3 = this.dht;
                                                dfVar57 = this.dht.dfV;
                                                pbActivity3.a(dfVar57.getPbData(), intValue, true, true);
                                                TiebaStatic.log("c10834");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                dnVar4 = this.dht.dgJ;
                                if (dnVar4 != null) {
                                    dnVar44 = this.dht.dgJ;
                                    if (view == dnVar44.axE()) {
                                        SparseArray sparseArray6 = (SparseArray) view.getTag();
                                        if (sparseArray6 != null && (sparseArray6.get(t.g.tag_del_post_type) instanceof Integer) && (sparseArray6.get(t.g.tag_del_post_id) instanceof String) && (sparseArray6.get(t.g.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(t.g.tag_del_post_is_self) instanceof Boolean)) {
                                            euVar51 = this.dht.dgF;
                                            euVar51.a(((Integer) sparseArray6.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray6.get(t.g.tag_del_post_id), ((Integer) sparseArray6.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(t.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                dnVar5 = this.dht.dgJ;
                                if (dnVar5 != null) {
                                    dnVar43 = this.dht.dgJ;
                                    if (view == dnVar43.axF()) {
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
                                        dfVar55 = this.dht.dfV;
                                        com.baidu.tieba.pb.data.e pbData = dfVar55.getPbData();
                                        String str3 = null;
                                        String str4 = null;
                                        String str5 = null;
                                        if (pbData != null && pbData.avu() != null) {
                                            str3 = pbData.avu().getId();
                                            str4 = pbData.avu().getName();
                                            str5 = pbData.getThreadId();
                                        }
                                        com.baidu.tieba.pb.b.a(j, str2, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", str3, str4, str5);
                                        this.dht.a(j, str2, str3, str4, str5, i3);
                                        return;
                                    }
                                }
                                euVar35 = this.dht.dgF;
                                if (euVar35.azl() != view) {
                                    euVar36 = this.dht.dgF;
                                    if (euVar36.ayx() != view) {
                                        dnVar6 = this.dht.dgJ;
                                        if (dnVar6 != null) {
                                            dnVar42 = this.dht.dgJ;
                                            if (view == dnVar42.axC()) {
                                                SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                                                if (sparseArray7 != null) {
                                                    boolean booleanValue2 = ((Boolean) sparseArray7.get(t.g.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue3 = ((Boolean) sparseArray7.get(t.g.tag_should_delete_visible)).booleanValue();
                                                    boolean booleanValue4 = ((Boolean) sparseArray7.get(t.g.tag_user_mute_visible)).booleanValue();
                                                    if (booleanValue2) {
                                                        if (booleanValue4) {
                                                            sparseArray7.put(t.g.tag_from, 1);
                                                            sparseArray7.put(t.g.tag_check_mute_from, 2);
                                                            this.dht.d(sparseArray7);
                                                            return;
                                                        }
                                                        sparseArray7.put(t.g.tag_check_mute_from, 2);
                                                        euVar50 = this.dht.dgF;
                                                        euVar50.aN(view);
                                                        return;
                                                    } else if (booleanValue3) {
                                                        euVar49 = this.dht.dgF;
                                                        euVar49.a(((Integer) sparseArray7.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(t.g.tag_del_post_id), ((Integer) sparseArray7.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(t.g.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        euVar37 = this.dht.dgF;
                                        if (view == euVar37.azp()) {
                                            if (this.dht.checkUpIsLogin()) {
                                                euVar46 = this.dht.dgF;
                                                if (!euVar46.ayJ()) {
                                                    dfVar43 = this.dht.dfV;
                                                    if (dfVar43 != null) {
                                                        dfVar44 = this.dht.dfV;
                                                        if (dfVar44.axA() != null) {
                                                            dfVar45 = this.dht.dfV;
                                                            if (dfVar45.axA().awW() != null) {
                                                                dfVar46 = this.dht.dfV;
                                                                if (com.baidu.tbadk.core.util.y.p(dfVar46.axA().awW().getItems()) != 0) {
                                                                    euVar47 = this.dht.dgF;
                                                                    euVar47.ayK();
                                                                    return;
                                                                }
                                                                this.dht.showToast(t.j.graffiti_quick_vote_empty);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                euVar48 = this.dht.dgF;
                                                euVar48.ayL();
                                                return;
                                            }
                                            return;
                                        } else if (view.getId() == t.g.pb_head_function_manage_delormanage) {
                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
                                            if (((Boolean) sparseArray8.get(t.g.tag_should_manage_visible)).booleanValue()) {
                                                euVar45 = this.dht.dgF;
                                                euVar45.aN(view);
                                            } else {
                                                euVar44 = this.dht.dgF;
                                                euVar44.a(((Integer) sparseArray8.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray8.get(t.g.tag_del_post_id), ((Integer) sparseArray8.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray8.get(t.g.tag_del_post_is_self)).booleanValue());
                                            }
                                            this.dht.awJ();
                                            return;
                                        } else if (view.getId() != t.g.replybtn && view.getId() != t.g.sub_pb_more && view.getId() != t.g.sub_pb_item) {
                                            euVar40 = this.dht.dgF;
                                            if (view == euVar40.ayY()) {
                                                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                    long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
                                                    dfVar41 = this.dht.dfV;
                                                    long c2 = com.baidu.adp.lib.h.b.c(dfVar41.getPbData().getForumId(), 0L);
                                                    dfVar42 = this.dht.dfV;
                                                    this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(this.dht.getPageContext().getPageActivity(), 24008, c2, com.baidu.adp.lib.h.b.c(dfVar42.getThreadID(), 0L), c)));
                                                    return;
                                                }
                                                return;
                                            }
                                            int id = view.getId();
                                            if (id == t.g.pb_u9_text_view) {
                                                if (this.dht.checkUpIsLogin() && (awVar = (com.baidu.tbadk.core.data.aw) view.getTag()) != null && !StringUtils.isNull(awVar.uf())) {
                                                    TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.bg.wM().c(this.dht.getPageContext(), new String[]{awVar.uf()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == t.g.reply) {
                                                dnVar7 = this.dht.dgJ;
                                                if (dnVar7 == null) {
                                                    this.dht.awl();
                                                }
                                                dnVar8 = this.dht.dgJ;
                                                dnVar8.Hl();
                                                com.baidu.tieba.tbadkCore.data.s sVar = null;
                                                if (view != null && view.getTag() != null) {
                                                    sVar = (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(t.g.tag_load_sub_data);
                                                    if (!this.dht.awE()) {
                                                        dfVar40 = this.dht.dfV;
                                                        if (dfVar40.axo() && TbadkCoreApplication.m411getInst().isTTSCanUse()) {
                                                            dnVar41 = this.dht.dgJ;
                                                            dnVar41.axJ();
                                                            sparseArray = (SparseArray) view.getTag();
                                                            if (sparseArray.get(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                                int intValue2 = ((Integer) sparseArray.get(t.g.tag_pb_floor_postion)).intValue();
                                                                dnVar40 = this.dht.dgJ;
                                                                dnVar40.axH().setTag(t.g.tag_pb_floor_postion, Integer.valueOf(intValue2));
                                                            }
                                                            SparseArray sparseArray9 = new SparseArray();
                                                            sparseArray9.put(t.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(t.g.tag_clip_board));
                                                            sparseArray9.put(t.g.tag_is_subpb, false);
                                                            dnVar14 = this.dht.dgJ;
                                                            dnVar14.axB().setTag(sparseArray9);
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
                                                                    dnVar39 = this.dht.dgJ;
                                                                    dnVar39.axE().setVisibility(0);
                                                                } else {
                                                                    sparseArray10.put(t.g.tag_should_delete_visible, false);
                                                                    dnVar34 = this.dht.dgJ;
                                                                    dnVar34.axE().setVisibility(8);
                                                                }
                                                                dnVar35 = this.dht.dgJ;
                                                                dnVar35.axC().setTag(sparseArray10);
                                                                dnVar36 = this.dht.dgJ;
                                                                dnVar36.axE().setTag(sparseArray10);
                                                                dnVar37 = this.dht.dgJ;
                                                                dnVar37.axC().setText(t.j.bar_manager);
                                                                dnVar38 = this.dht.dgJ;
                                                                dnVar38.axC().setVisibility(0);
                                                            } else if (!booleanValue6) {
                                                                dnVar15 = this.dht.dgJ;
                                                                dnVar15.axC().setVisibility(8);
                                                                dnVar16 = this.dht.dgJ;
                                                                dnVar16.axE().setVisibility(8);
                                                            } else {
                                                                SparseArray sparseArray11 = new SparseArray();
                                                                sparseArray11.put(t.g.tag_should_manage_visible, false);
                                                                sparseArray11.put(t.g.tag_user_mute_visible, false);
                                                                sparseArray11.put(t.g.tag_should_delete_visible, true);
                                                                sparseArray11.put(t.g.tag_manage_user_identity, sparseArray2.get(t.g.tag_manage_user_identity));
                                                                sparseArray11.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                sparseArray11.put(t.g.tag_del_post_id, sparseArray2.get(t.g.tag_del_post_id));
                                                                sparseArray11.put(t.g.tag_del_post_type, sparseArray2.get(t.g.tag_del_post_type));
                                                                dnVar17 = this.dht.dgJ;
                                                                dnVar17.axC().setTag(sparseArray11);
                                                                dnVar18 = this.dht.dgJ;
                                                                dnVar18.axE().setTag(sparseArray11);
                                                                dnVar19 = this.dht.dgJ;
                                                                dnVar19.axC().setText(t.j.delete);
                                                                dnVar20 = this.dht.dgJ;
                                                                dnVar20.axE().setVisibility(0);
                                                                dnVar21 = this.dht.dgJ;
                                                                dnVar21.axC().setVisibility(8);
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
                                                                dnVar30 = this.dht.dgJ;
                                                                dnVar30.axD().setTag(sparseArray12);
                                                                dnVar31 = this.dht.dgJ;
                                                                dnVar31.axD().setVisibility(0);
                                                                dnVar32 = this.dht.dgJ;
                                                                dnVar32.axC().setVisibility(8);
                                                                dnVar33 = this.dht.dgJ;
                                                                dnVar33.axD().setText(t.j.mute_option);
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
                                                                fW = this.dht.fW(z5);
                                                                isLogin = fW & this.dht.isLogin();
                                                                this.dht.dhl = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(t.g.tag_clip_board);
                                                                if (!(!et.g(this.dht.dhl) ? false : isLogin)) {
                                                                    dnVar23 = this.dht.dgJ;
                                                                    dnVar23.axD().setVisibility(0);
                                                                    dnVar24 = this.dht.dgJ;
                                                                    dnVar24.axD().setTag(str7);
                                                                } else {
                                                                    dnVar22 = this.dht.dgJ;
                                                                    dnVar22.axD().setVisibility(8);
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
                                                                dnVar26 = this.dht.dgJ;
                                                                dnVar26.axF().setVisibility(0);
                                                                dnVar27 = this.dht.dgJ;
                                                                dnVar27.axF().setTag(t.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                dnVar28 = this.dht.dgJ;
                                                                dnVar28.axF().setTag(t.g.tag_chudian_monitor_id, str);
                                                                dnVar29 = this.dht.dgJ;
                                                                dnVar29.axF().setTag(t.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                            } else {
                                                                dnVar25 = this.dht.dgJ;
                                                                dnVar25.axF().setVisibility(8);
                                                            }
                                                        }
                                                    }
                                                    dnVar13 = this.dht.dgJ;
                                                    dnVar13.axI();
                                                    sparseArray = (SparseArray) view.getTag();
                                                    if (sparseArray.get(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                    }
                                                    SparseArray sparseArray92 = new SparseArray();
                                                    sparseArray92.put(t.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.s) ((SparseArray) view.getTag()).get(t.g.tag_clip_board));
                                                    sparseArray92.put(t.g.tag_is_subpb, false);
                                                    dnVar14 = this.dht.dgJ;
                                                    dnVar14.axB().setTag(sparseArray92);
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
                                                    fW = this.dht.fW(z5);
                                                    isLogin = fW & this.dht.isLogin();
                                                    this.dht.dhl = (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(t.g.tag_clip_board);
                                                    if (!(!et.g(this.dht.dhl) ? false : isLogin)) {
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
                                                dfVar38 = this.dht.dfV;
                                                if (dfVar38.getPbData().pu()) {
                                                    dfVar39 = this.dht.dfV;
                                                    String ps = dfVar39.getPbData().ps();
                                                    if (sVar != null && !com.baidu.adp.lib.util.j.isEmpty(ps) && ps.equals(sVar.getId())) {
                                                        z2 = true;
                                                        if (!z2) {
                                                            dnVar12 = this.dht.dgJ;
                                                            dnVar12.axB().setText(t.j.remove_mark);
                                                        } else {
                                                            dnVar9 = this.dht.dgJ;
                                                            dnVar9.axB().setText(t.j.mark);
                                                        }
                                                        dnVar10 = this.dht.dgJ;
                                                        dnVar10.gg(true);
                                                        dnVar11 = this.dht.dgJ;
                                                        dnVar11.xg();
                                                        return;
                                                    }
                                                }
                                                z2 = false;
                                                if (!z2) {
                                                }
                                                dnVar10 = this.dht.dgJ;
                                                dnVar10.gg(true);
                                                dnVar11 = this.dht.dgJ;
                                                dnVar11.xg();
                                                return;
                                            } else if (id != t.g.pb_head_reverse_hint) {
                                                if (id == t.g.pb_act_btn) {
                                                    dfVar31 = this.dht.dfV;
                                                    if (dfVar31.getPbData() != null) {
                                                        dfVar32 = this.dht.dfV;
                                                        if (dfVar32.getPbData().avv() != null) {
                                                            dfVar33 = this.dht.dfV;
                                                            if (dfVar33.getPbData().avv().tK() != null) {
                                                                Activity activity = this.dht.getActivity();
                                                                dfVar34 = this.dht.dfV;
                                                                com.baidu.tbadk.browser.f.s(activity, dfVar34.getPbData().avv().tK());
                                                                dfVar35 = this.dht.dfV;
                                                                if (dfVar35.getPbData().avv().tI() != 1) {
                                                                    dfVar36 = this.dht.dfV;
                                                                    if (dfVar36.getPbData().avv().tI() == 2) {
                                                                        TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                        com.baidu.tbadk.core.util.aw awVar3 = new com.baidu.tbadk.core.util.aw("c10912");
                                                        dfVar29 = this.dht.dfV;
                                                        com.baidu.tbadk.core.util.aw ac = awVar3.ac("fid", dfVar29.getPbData().getForumId());
                                                        dfVar30 = this.dht.dfV;
                                                        TiebaStatic.log(ac.ac("tid", dfVar30.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str8, "_", TbadkCoreApplication.getCurrentAccount())));
                                                        this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.dht.getActivity()).createNormalCfg(str8, (String) null, (String) null, (String) null)));
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == t.g.pb_item_tail_content) {
                                                    if (com.baidu.tbadk.core.util.bl.ad(this.dht.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.m411getInst().getString(t.j.tail_web_view_title);
                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.vk().getString("tail_link", "");
                                                        if (!StringUtils.isNull(string2)) {
                                                            TiebaStatic.log("c10056");
                                                            com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                        }
                                                        euVar41 = this.dht.dgF;
                                                        euVar41.ayk();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == t.g.join_vote_tv) {
                                                    if (view != null) {
                                                        com.baidu.tbadk.browser.f.s(this.dht.getActivity(), (String) view.getTag());
                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                        awo3 = this.dht.awo();
                                                        if (awo3 == 1) {
                                                            dfVar25 = this.dht.dfV;
                                                            if (dfVar25 != null) {
                                                                dfVar26 = this.dht.dfV;
                                                                if (dfVar26.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar4 = new com.baidu.tbadk.core.util.aw("c10397");
                                                                    dfVar27 = this.dht.dfV;
                                                                    com.baidu.tbadk.core.util.aw ac2 = awVar4.ac("fid", dfVar27.getPbData().getForumId());
                                                                    dfVar28 = this.dht.dfV;
                                                                    TiebaStatic.log(ac2.ac("tid", dfVar28.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        awo4 = this.dht.awo();
                                                        if (awo4 == 2) {
                                                            dfVar21 = this.dht.dfV;
                                                            if (dfVar21 != null) {
                                                                dfVar22 = this.dht.dfV;
                                                                if (dfVar22.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar5 = new com.baidu.tbadk.core.util.aw("c10401");
                                                                    dfVar23 = this.dht.dfV;
                                                                    com.baidu.tbadk.core.util.aw ac3 = awVar5.ac("fid", dfVar23.getPbData().getForumId());
                                                                    dfVar24 = this.dht.dfV;
                                                                    TiebaStatic.log(ac3.ac("tid", dfVar24.getPbData().getThreadId()).ac("uid", currentAccount));
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
                                                        com.baidu.tbadk.browser.f.s(this.dht.getActivity(), (String) view.getTag());
                                                        awo = this.dht.awo();
                                                        if (awo == 1) {
                                                            dfVar17 = this.dht.dfV;
                                                            if (dfVar17 != null) {
                                                                dfVar18 = this.dht.dfV;
                                                                if (dfVar18.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar6 = new com.baidu.tbadk.core.util.aw("c10507");
                                                                    dfVar19 = this.dht.dfV;
                                                                    com.baidu.tbadk.core.util.aw ac4 = awVar6.ac("fid", dfVar19.getPbData().getForumId());
                                                                    dfVar20 = this.dht.dfV;
                                                                    TiebaStatic.log(ac4.ac("tid", dfVar20.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        awo2 = this.dht.awo();
                                                        if (awo2 == 2) {
                                                            dfVar13 = this.dht.dfV;
                                                            if (dfVar13 != null) {
                                                                dfVar14 = this.dht.dfV;
                                                                if (dfVar14.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aw awVar7 = new com.baidu.tbadk.core.util.aw("c10508");
                                                                    dfVar15 = this.dht.dfV;
                                                                    com.baidu.tbadk.core.util.aw ac5 = awVar7.ac("fid", dfVar15.getPbData().getForumId());
                                                                    dfVar16 = this.dht.dfV;
                                                                    TiebaStatic.log(ac5.ac("tid", dfVar16.getPbData().getThreadId()).ac("uid", currentAccount2));
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
                                                    this.dht.awG();
                                                    return;
                                                } else {
                                                    this.dht.awF();
                                                    return;
                                                }
                                            } else {
                                                this.dht.Qn();
                                                euVar42 = this.dht.dgF;
                                                euVar42.amI();
                                                euVar43 = this.dht.dgF;
                                                euVar43.ayE();
                                                dfVar37 = this.dht.dfV;
                                                dfVar37.axn();
                                                return;
                                            }
                                        } else if (this.dht.checkUpIsLogin()) {
                                            dfVar5 = this.dht.dfV;
                                            if (dfVar5.getPbData() != null) {
                                                euVar38 = this.dht.dgF;
                                                euVar38.amI();
                                                SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) sparseArray13.get(t.g.tag_load_sub_data);
                                                View view2 = (View) sparseArray13.get(t.g.tag_load_sub_view);
                                                if (sVar2 != null && view2 != null) {
                                                    dfVar6 = this.dht.dfV;
                                                    String threadID = dfVar6.getThreadID();
                                                    String id2 = sVar2.getId();
                                                    int i4 = 0;
                                                    dfVar7 = this.dht.dfV;
                                                    if (dfVar7.getPbData() != null) {
                                                        dfVar11 = this.dht.dfV;
                                                        i4 = dfVar11.getPbData().avB();
                                                    }
                                                    this.dht.Qn();
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
                                                            lU2 = this.dht.lU(id2);
                                                            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.dht.getPageContext().getPageActivity());
                                                            SmallTailInfo aAu = sVar2.aAu();
                                                            dfVar9 = this.dht.dfV;
                                                            this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, str9, true, str10, i4, aAu, dfVar9.getPbData().sf(), false).addBigImageData(lU2.dhK, lU2.dhL, lU2.dhM, lU2.index)));
                                                            return;
                                                        } else if (sVar2.aTA()) {
                                                            TiebaStatic.log("c10089");
                                                            lU = this.dht.lU(id2);
                                                            SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.dht.getPageContext().getPageActivity());
                                                            SmallTailInfo aAu2 = sVar2.aAu();
                                                            dfVar8 = this.dht.dfV;
                                                            this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i4, aAu2, dfVar8.getPbData().sf(), false).addBigImageData(lU.dhK, lU.dhL, lU.dhM, lU.index)));
                                                            return;
                                                        } else {
                                                            sVar2.iJ(true);
                                                            euVar39 = this.dht.dgF;
                                                            euVar39.ayy().notifyDataSetChanged();
                                                            return;
                                                        }
                                                    }
                                                    lU3 = this.dht.lU(id2);
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.dht.getPageContext().getPageActivity());
                                                    SmallTailInfo aAu3 = sVar2.aAu();
                                                    dfVar10 = this.dht.dfV;
                                                    this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i4, aAu3, dfVar10.getPbData().sf(), false).addBigImageData(lU3.dhK, lU3.dhL, lU3.dhM, lU3.index)));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.tbadk.core.util.aw r = new com.baidu.tbadk.core.util.aw("c10517").r("obj_locate", 3);
                                            dfVar12 = this.dht.dfV;
                                            TiebaStatic.log(r.ac("fid", dfVar12.getPbData().getForumId()));
                                            return;
                                        }
                                    } else if (!this.dht.checkUpIsLogin()) {
                                        com.baidu.tbadk.core.util.aw r2 = new com.baidu.tbadk.core.util.aw("c10517").r("obj_locate", 2);
                                        dfVar47 = this.dht.dfV;
                                        TiebaStatic.log(r2.ac("fid", dfVar47.getPbData().getForumId()));
                                        return;
                                    } else {
                                        this.dht.awh();
                                        return;
                                    }
                                }
                                com.baidu.tieba.tbadkCore.d.a.bE("c10725", null);
                                if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                    dfVar48 = this.dht.dfV;
                                    if (dfVar48.getPbData() != null) {
                                        dfVar49 = this.dht.dfV;
                                        if (dfVar49.getPbData().avv() != null) {
                                            dfVar50 = this.dht.dfV;
                                            if (dfVar50.getPbData().avv().tg() != null) {
                                                InterviewLiveActivityConfig interviewLiveActivityConfig = new InterviewLiveActivityConfig(this.dht.getPageContext().getPageActivity());
                                                dfVar51 = this.dht.dfV;
                                                String threadId = dfVar51.getPbData().avv().tg().getThreadId();
                                                dfVar52 = this.dht.dfV;
                                                String taskId = dfVar52.getPbData().avv().tg().getTaskId();
                                                dfVar53 = this.dht.dfV;
                                                String forumId = dfVar53.getPbData().avv().tg().getForumId();
                                                dfVar54 = this.dht.dfV;
                                                this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, interviewLiveActivityConfig.createNormalCfg(threadId, taskId, forumId, dfVar54.getPbData().avv().tg().getForumName())));
                                                this.dht.dgm = true;
                                                this.dht.finish();
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
                            TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            dfVar79 = this.dht.dfV;
                            if (dfVar79.getErrorNo() == 4) {
                                dfVar83 = this.dht.dfV;
                                if (StringUtils.isNull(dfVar83.axd())) {
                                    dfVar84 = this.dht.dfV;
                                    if (dfVar84.getAppealInfo() != null) {
                                        dfVar85 = this.dht.dfV;
                                        this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dht.getPageContext().getPageActivity()).createNormalCfg(dfVar85.getAppealInfo().forumName, FrsActivityConfig.FRS_FROM_PB)));
                                        return;
                                    }
                                }
                                this.dht.finish();
                                return;
                            }
                            String stringExtra = this.dht.getIntent().getStringExtra("from");
                            dfVar80 = this.dht.dfV;
                            String name = dfVar80.getPbData().avu().getName();
                            dfVar81 = this.dht.dfV;
                            if (!TextUtils.isEmpty(dfVar81.axd())) {
                                dfVar82 = this.dht.dfV;
                                if (dfVar82.axd().equals(name) && !com.baidu.tieba.card.bl.class.getName().equals(stringExtra)) {
                                    this.dht.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.ay.aS(name)) {
                                this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dht.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        euVar6 = this.dht.dgF;
        euVar6.aza();
        dfVar = this.dht.dfV;
        if (dfVar.getPbData().avB() == 1) {
            aVar = this.dht.dgC;
            if (!aVar.aUn()) {
                euVar7 = this.dht.dgF;
                euVar7.ayB();
                int i5 = 0;
                euVar8 = this.dht.dgF;
                if (view != euVar8.ayU()) {
                    euVar9 = this.dht.dgF;
                    if (view != euVar9.ayV()) {
                        euVar10 = this.dht.dgF;
                        if (view != euVar10.ayW()) {
                            euVar11 = this.dht.dgF;
                            if (view != euVar11.ayX()) {
                                euVar12 = this.dht.dgF;
                                if (view == euVar12.ayC()) {
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
                dfVar2 = this.dht.dfV;
                ForumData avu2 = dfVar2.getPbData().avu();
                String name2 = avu2.getName();
                String id3 = avu2.getId();
                dfVar3 = this.dht.dfV;
                String id4 = dfVar3.getPbData().avv().getId();
                aVar2 = this.dht.dgC;
                euVar13 = this.dht.dgF;
                aVar2.a(id3, name2, id4, i5, euVar13.ayD());
                this.dht.awJ();
            }
        }
    }
}
