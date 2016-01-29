package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
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
class n implements View.OnClickListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v132, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:354:0x12bb  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x1480  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        dz dzVar;
        dz dzVar2;
        dz dzVar3;
        dz dzVar4;
        dz dzVar5;
        dz dzVar6;
        cm cmVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        dz dzVar7;
        dz dzVar8;
        dz dzVar9;
        dz dzVar10;
        dz dzVar11;
        dz dzVar12;
        cm cmVar2;
        cm cmVar3;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        dz dzVar13;
        dz dzVar14;
        dz dzVar15;
        dz dzVar16;
        dz dzVar17;
        dz dzVar18;
        dz dzVar19;
        dz dzVar20;
        dz dzVar21;
        boolean z;
        dz dzVar22;
        dz dzVar23;
        dz dzVar24;
        cm cmVar4;
        String apB;
        dz dzVar25;
        dz dzVar26;
        dz dzVar27;
        dz dzVar28;
        dz dzVar29;
        dz dzVar30;
        dz dzVar31;
        dz dzVar32;
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        ct ctVar5;
        dz dzVar33;
        dz dzVar34;
        ct ctVar6;
        cm cmVar5;
        dz dzVar35;
        cm cmVar6;
        cm cmVar7;
        dz dzVar36;
        PbActivity.b kH;
        cm cmVar8;
        PbActivity.b kH2;
        cm cmVar9;
        PbActivity.b kH3;
        cm cmVar10;
        cm cmVar11;
        cm cmVar12;
        int app;
        int app2;
        cm cmVar13;
        cm cmVar14;
        cm cmVar15;
        cm cmVar16;
        cm cmVar17;
        cm cmVar18;
        cm cmVar19;
        cm cmVar20;
        int app3;
        int app4;
        cm cmVar21;
        cm cmVar22;
        cm cmVar23;
        cm cmVar24;
        cm cmVar25;
        cm cmVar26;
        cm cmVar27;
        cm cmVar28;
        cm cmVar29;
        cm cmVar30;
        cm cmVar31;
        cm cmVar32;
        cm cmVar33;
        cm cmVar34;
        dz dzVar37;
        dz dzVar38;
        cm cmVar35;
        ct ctVar7;
        ct ctVar8;
        cm cmVar36;
        boolean z2;
        ct ctVar9;
        ct ctVar10;
        ct ctVar11;
        ct ctVar12;
        cm cmVar37;
        cm cmVar38;
        ct ctVar13;
        ct ctVar14;
        boolean z3;
        ct ctVar15;
        ct ctVar16;
        ct ctVar17;
        ct ctVar18;
        ct ctVar19;
        ct ctVar20;
        ct ctVar21;
        boolean z4;
        boolean z5;
        boolean fl;
        ct ctVar22;
        ct ctVar23;
        ct ctVar24;
        ct ctVar25;
        ct ctVar26;
        ct ctVar27;
        ct ctVar28;
        ct ctVar29;
        ct ctVar30;
        ct ctVar31;
        ct ctVar32;
        ct ctVar33;
        ct ctVar34;
        ct ctVar35;
        ct ctVar36;
        ct ctVar37;
        ct ctVar38;
        ct ctVar39;
        com.baidu.tbadk.core.data.al alVar;
        dz dzVar39;
        dz dzVar40;
        ct ctVar40;
        dz dzVar41;
        dz dzVar42;
        cm cmVar39;
        cm cmVar40;
        cm cmVar41;
        cm cmVar42;
        cm cmVar43;
        cm cmVar44;
        cm cmVar45;
        ct ctVar41;
        cm cmVar46;
        ct ctVar42;
        dz dzVar43;
        ct ctVar43;
        cm cmVar47;
        dz dzVar44;
        cm cmVar48;
        ct ctVar44;
        ct ctVar45;
        dz dzVar45;
        dz dzVar46;
        dz dzVar47;
        cm cmVar49;
        dz dzVar48;
        dz dzVar49;
        cm cmVar50;
        cm cmVar51;
        cm cmVar52;
        dz dzVar50;
        cm cmVar53;
        cm cmVar54;
        cm cmVar55;
        dz dzVar51;
        dz dzVar52;
        dz dzVar53;
        cm cmVar56;
        dz dzVar54;
        dz dzVar55;
        cm cmVar57;
        dz dzVar56;
        cm cmVar58;
        dz dzVar57;
        dz dzVar58;
        dz dzVar59;
        dz dzVar60;
        boolean kN;
        cm cmVar59;
        dz dzVar61;
        cm cmVar60;
        cm cmVar61;
        cm cmVar62;
        cm cmVar63;
        cm cmVar64;
        cm cmVar65;
        cm cmVar66;
        cm cmVar67;
        cm cmVar68;
        cm cmVar69;
        dz dzVar62;
        dz dzVar63;
        cm cmVar70;
        cm cmVar71;
        cm cmVar72;
        cm cmVar73;
        cm cmVar74;
        dz dzVar64;
        cm cmVar75;
        dz dzVar65;
        dz dzVar66;
        dz dzVar67;
        cm cmVar76;
        dz dzVar68;
        cm cmVar77;
        dz dzVar69;
        cm cmVar78;
        cm cmVar79;
        dz dzVar70;
        dzVar = this.cNq.cMK;
        if (view == dzVar.getNextView()) {
            cmVar79 = this.cNq.cMF;
            if (cmVar79.fr(true)) {
                dzVar70 = this.cNq.cMK;
                dzVar70.ari();
                return;
            }
            return;
        }
        dzVar2 = this.cNq.cMK;
        if (view == dzVar2.ard()) {
            dzVar68 = this.cNq.cMK;
            dzVar68.aqY();
            if (UtilHelper.isFloatWindowOpAllowed(this.cNq.getPageContext().getPageActivity())) {
                this.cNq.cMP = true;
                PbActivity pbActivity = this.cNq;
                cmVar77 = this.cNq.cMF;
                pbActivity.a(cmVar77.getPbData(), 0, true, true);
                dzVar69 = this.cNq.cMK;
                dzVar69.aqX();
                com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10830");
                cmVar78 = this.cNq.cMF;
                TiebaStatic.log(auVar.aa("tid", cmVar78.getThreadID()));
                return;
            }
            this.cNq.apo();
            return;
        }
        dzVar3 = this.cNq.cMK;
        if (view == dzVar3.arD()) {
            dzVar65 = this.cNq.cMK;
            dzVar65.ajp();
            this.cNq.Oy();
            dzVar66 = this.cNq.cMK;
            dzVar66.arh();
            dzVar67 = this.cNq.cMK;
            dzVar67.agV();
            cmVar76 = this.cNq.cMF;
            cmVar76.kQ(1);
            return;
        }
        dzVar4 = this.cNq.cMK;
        if (view == dzVar4.cQn.aCv) {
            dzVar64 = this.cNq.cMK;
            cmVar75 = this.cNq.cMF;
            if (!dzVar64.fJ(cmVar75.apT())) {
                this.cNq.cMs = false;
                this.cNq.finish();
                return;
            }
            this.cNq.Oy();
            return;
        }
        dzVar5 = this.cNq.cMK;
        if (view != dzVar5.aru()) {
            dzVar14 = this.cNq.cMK;
            if (view != dzVar14.arv()) {
                dzVar15 = this.cNq.cMK;
                if (view != dzVar15.arw()) {
                    dzVar16 = this.cNq.cMK;
                    if (view != dzVar16.arx()) {
                        dzVar17 = this.cNq.cMK;
                        if (view != dzVar17.arf()) {
                            dzVar18 = this.cNq.cMK;
                            if (view == dzVar18.arA()) {
                                cmVar73 = this.cNq.cMF;
                                if (cmVar73 != null) {
                                    cmVar74 = this.cNq.cMF;
                                    com.baidu.tbadk.browser.f.B(this.cNq.getPageContext().getPageActivity(), cmVar74.getPbData().aoF().tm().getLink());
                                    return;
                                }
                                return;
                            }
                            dzVar19 = this.cNq.cMK;
                            if (view != dzVar19.cQn.cSL) {
                                dzVar20 = this.cNq.cMK;
                                if (view == dzVar20.cQn.cSN) {
                                    cmVar66 = this.cNq.cMF;
                                    if (cmVar66 != null) {
                                        cmVar67 = this.cNq.cMF;
                                        if (cmVar67.getPbData() != null) {
                                            cmVar68 = this.cNq.cMF;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = cmVar68.getPbData().aoG();
                                            if (aoG == null || aoG.size() <= 0) {
                                                cmVar69 = this.cNq.cMF;
                                                if (cmVar69.apP()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.cNq.getPageContext().getPageActivity(), this.cNq.getPageContext().getString(t.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            dzVar62 = this.cNq.cMK;
                                            dzVar62.aqT();
                                            dzVar63 = this.cNq.cMK;
                                            dzVar63.arF();
                                            this.cNq.apq();
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.cNq.getPageContext().getPageActivity(), this.cNq.getPageContext().getString(t.j.pb_no_data_tips));
                                    return;
                                }
                                dzVar21 = this.cNq.cMK;
                                if (view == dzVar21.cQn.cSM || view.getId() == t.g.pb_god_user_tip_content) {
                                    z = this.cNq.mIsLoading;
                                    if (!z) {
                                        this.cNq.mIsLoading = true;
                                        dzVar22 = this.cNq.cMK;
                                        dzVar22.cQn.cSM.setEnabled(false);
                                        dzVar23 = this.cNq.cMK;
                                        dzVar23.acM();
                                        this.cNq.Oy();
                                        dzVar24 = this.cNq.cMK;
                                        dzVar24.arh();
                                        cmVar4 = this.cNq.cMF;
                                        apB = this.cNq.apB();
                                        cmVar4.kK(apB);
                                        TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        dzVar25 = this.cNq.cMK;
                                        dzVar25.arF();
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                                        return;
                                    }
                                    return;
                                }
                                dzVar26 = this.cNq.cMK;
                                if (view == dzVar26.cQn.cSO) {
                                    cmVar60 = this.cNq.cMF;
                                    AdditionData aoM = cmVar60.getPbData().aoM();
                                    if (!TextUtils.isEmpty(aoM.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.cNq.getPageContext().getPageActivity(), aoM.getWarnMsg());
                                        return;
                                    } else if (aoM.getAlreadyCount() != aoM.getTotalCount()) {
                                        cmVar61 = this.cNq.cMF;
                                        ForumData aoE = cmVar61.getPbData().aoE();
                                        cmVar62 = this.cNq.cMF;
                                        com.baidu.tbadk.core.data.ah aoF = cmVar62.getPbData().aoF();
                                        cmVar63 = this.cNq.cMF;
                                        AntiData so = cmVar63.getPbData().so();
                                        if (aoF.getId() != null) {
                                            if (so != null && so.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.cNq.getPageContext().getPageActivity(), so.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            cmVar64 = this.cNq.cMF;
                                            if (cmVar64.getPbData().getUserData() != null) {
                                                cmVar65 = this.cNq.cMF;
                                                i = cmVar65.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.cNq.getPageContext().getPageActivity(), 2, aoE.getId(), aoE.getName(), aoF.getId(), aoM.getPostId(), 0, so, 13008, false, false, null, false, false, null, aoM, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.cNq.getPageContext().getPageActivity(), String.format(this.cNq.getPageContext().getString(t.j.write_addition_limit), Integer.valueOf(aoM.getTotalCount())));
                                        return;
                                    }
                                }
                                dzVar27 = this.cNq.cMK;
                                if (dzVar27.cQn.arO() != null) {
                                    dzVar59 = this.cNq.cMK;
                                    if (view == dzVar59.cQn.arO().aql()) {
                                        dzVar60 = this.cNq.cMK;
                                        dzVar60.ajp();
                                        kN = this.cNq.kN(11009);
                                        if (kN) {
                                            cmVar59 = this.cNq.cMF;
                                            dzVar61 = this.cNq.cMK;
                                            if (cmVar59.kW(dzVar61.arn()) == null) {
                                                return;
                                            }
                                            this.cNq.apu();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                dzVar28 = this.cNq.cMK;
                                if (dzVar28.cQn.arO() != null) {
                                    dzVar57 = this.cNq.cMK;
                                    if (view == dzVar57.cQn.arO().aqu()) {
                                        dzVar58 = this.cNq.cMK;
                                        dzVar58.ajp();
                                        this.cNq.Oy();
                                        this.cNq.Pq();
                                        return;
                                    }
                                }
                                dzVar29 = this.cNq.cMK;
                                if (dzVar29.cQn.arO() != null) {
                                    dzVar54 = this.cNq.cMK;
                                    if (view == dzVar54.cQn.arO().aqw()) {
                                        dzVar55 = this.cNq.cMK;
                                        dzVar55.ajp();
                                        cmVar57 = this.cNq.cMF;
                                        if (cmVar57.XU() != null) {
                                            dzVar56 = this.cNq.cMK;
                                            cmVar58 = this.cNq.cMF;
                                            dzVar56.a(cmVar58.XU(), this.cNq.cEP);
                                        }
                                        TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                dzVar30 = this.cNq.cMK;
                                if (dzVar30.cQn.arO() != null) {
                                    dzVar51 = this.cNq.cMK;
                                    if (view == dzVar51.cQn.arO().aqx()) {
                                        dzVar52 = this.cNq.cMK;
                                        dzVar52.ajp();
                                        this.cNq.Oy();
                                        dzVar53 = this.cNq.cMK;
                                        dzVar53.arh();
                                        cmVar56 = this.cNq.cMF;
                                        cmVar56.apY();
                                        TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                                        return;
                                    }
                                }
                                dzVar31 = this.cNq.cMK;
                                if (dzVar31.cQn.arO() != null) {
                                    dzVar49 = this.cNq.cMK;
                                    if (view == dzVar49.cQn.arO().aqy()) {
                                        cmVar50 = this.cNq.cMF;
                                        if (cmVar50 != null) {
                                            cmVar51 = this.cNq.cMF;
                                            if (cmVar51.getPbData() != null) {
                                                cmVar52 = this.cNq.cMF;
                                                if (cmVar52.getPbData().aoF() != null) {
                                                    dzVar50 = this.cNq.cMK;
                                                    dzVar50.cQn.qI();
                                                    cmVar53 = this.cNq.cMF;
                                                    if (cmVar53.getPbData().aoG() != null) {
                                                        cmVar54 = this.cNq.cMF;
                                                        if (cmVar54.getPbData().aoG().size() > 0) {
                                                            PbActivity pbActivity2 = this.cNq;
                                                            cmVar55 = this.cNq.cMF;
                                                            pbActivity2.kA(cmVar55.getPbData().aoG().get(0).getId());
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
                                dzVar32 = this.cNq.cMK;
                                if (dzVar32.cQn.arO() != null) {
                                    dzVar45 = this.cNq.cMK;
                                    if (view == dzVar45.cQn.arO().aqz()) {
                                        TiebaStatic.log("c10414");
                                        dzVar46 = this.cNq.cMK;
                                        dzVar46.ajp();
                                        dzVar47 = this.cNq.cMK;
                                        if (dzVar47.tj() != dz.cRN) {
                                            cmVar49 = this.cNq.cMF;
                                            cmVar49.kX(cm.cPa);
                                            return;
                                        }
                                        dzVar48 = this.cNq.cMK;
                                        dzVar48.arJ();
                                        return;
                                    }
                                }
                                ctVar = this.cNq.cMO;
                                if (ctVar != null) {
                                    ctVar45 = this.cNq.cMO;
                                    if (view == ctVar45.aqn()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray.put(t.g.tag_from, 0);
                                                    sparseArray.put(t.g.tag_check_mute_from, 2);
                                                    this.cNq.d(sparseArray);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        this.cNq.kA((String) tag);
                                        return;
                                    }
                                }
                                ctVar2 = this.cNq.cMO;
                                if (ctVar2 != null) {
                                    ctVar44 = this.cNq.cMO;
                                    if (view == ctVar44.aql()) {
                                        if (!this.cNq.checkUpIsLogin()) {
                                            return;
                                        }
                                        this.cNq.aB(view);
                                        return;
                                    }
                                }
                                ctVar3 = this.cNq.cMO;
                                if (ctVar3 != null) {
                                    ctVar43 = this.cNq.cMO;
                                    if (view == ctVar43.aqr()) {
                                        if (view.getTag(t.g.tag_pb_floor_postion) instanceof Integer) {
                                            cmVar47 = this.cNq.cMF;
                                            if (cmVar47 != null) {
                                                dzVar44 = this.cNq.cMK;
                                                dzVar44.aqY();
                                                if (!UtilHelper.isFloatWindowOpAllowed(this.cNq.getPageContext().getPageActivity())) {
                                                    this.cNq.apo();
                                                    return;
                                                }
                                                int intValue = ((Integer) view.getTag(t.g.tag_pb_floor_postion)).intValue();
                                                this.cNq.cMP = true;
                                                PbActivity pbActivity3 = this.cNq;
                                                cmVar48 = this.cNq.cMF;
                                                pbActivity3.a(cmVar48.getPbData(), intValue, true, true);
                                                TiebaStatic.log("c10834");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ctVar4 = this.cNq.cMO;
                                if (ctVar4 != null) {
                                    ctVar42 = this.cNq.cMO;
                                    if (view == ctVar42.aqo()) {
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null && (sparseArray2.get(t.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(t.g.tag_del_post_id) instanceof String) && (sparseArray2.get(t.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(t.g.tag_del_post_is_self) instanceof Boolean)) {
                                            dzVar43 = this.cNq.cMK;
                                            dzVar43.a(((Integer) sparseArray2.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(t.g.tag_del_post_id), ((Integer) sparseArray2.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(t.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ctVar5 = this.cNq.cMO;
                                if (ctVar5 != null) {
                                    ctVar41 = this.cNq.cMO;
                                    if (view == ctVar41.aqp()) {
                                        long j = -1;
                                        String str = "";
                                        if (view.getTag(t.g.tag_chudian_template_id) instanceof Long) {
                                            j = ((Long) view.getTag(t.g.tag_chudian_template_id)).longValue();
                                        }
                                        if (view.getTag(t.g.tag_chudian_monitor_id) instanceof String) {
                                            str = (String) view.getTag(t.g.tag_chudian_monitor_id);
                                        }
                                        cmVar46 = this.cNq.cMF;
                                        com.baidu.tieba.pb.a.c pbData = cmVar46.getPbData();
                                        String str2 = null;
                                        String str3 = null;
                                        String str4 = null;
                                        if (pbData != null && pbData.aoE() != null) {
                                            str2 = pbData.aoE().getId();
                                            str3 = pbData.aoE().getName();
                                            str4 = pbData.getThreadId();
                                        }
                                        com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", str2, str3, str4);
                                        this.cNq.a(j, str, str2, str3, str4);
                                        return;
                                    }
                                }
                                dzVar33 = this.cNq.cMK;
                                if (dzVar33.arK() != view) {
                                    dzVar34 = this.cNq.cMK;
                                    if (dzVar34.ara() != view) {
                                        ctVar6 = this.cNq.cMO;
                                        if (ctVar6 != null) {
                                            ctVar40 = this.cNq.cMO;
                                            if (view == ctVar40.aqm()) {
                                                SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                                                if (sparseArray3 != null) {
                                                    boolean booleanValue = ((Boolean) sparseArray3.get(t.g.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue2 = ((Boolean) sparseArray3.get(t.g.tag_should_delete_visible)).booleanValue();
                                                    boolean booleanValue3 = ((Boolean) sparseArray3.get(t.g.tag_user_mute_visible)).booleanValue();
                                                    if (booleanValue) {
                                                        if (booleanValue3) {
                                                            sparseArray3.put(t.g.tag_from, 1);
                                                            sparseArray3.put(t.g.tag_check_mute_from, 2);
                                                            this.cNq.d(sparseArray3);
                                                            return;
                                                        }
                                                        sparseArray3.put(t.g.tag_check_mute_from, 2);
                                                        dzVar42 = this.cNq.cMK;
                                                        dzVar42.aF(view);
                                                        return;
                                                    } else if (booleanValue2) {
                                                        dzVar41 = this.cNq.cMK;
                                                        dzVar41.a(((Integer) sparseArray3.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(t.g.tag_del_post_id), ((Integer) sparseArray3.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(t.g.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        if (view.getId() == t.g.pb_head_function_manage_delormanage) {
                                            SparseArray sparseArray4 = (SparseArray) view.getTag();
                                            if (((Boolean) sparseArray4.get(t.g.tag_should_manage_visible)).booleanValue()) {
                                                dzVar40 = this.cNq.cMK;
                                                dzVar40.aF(view);
                                            } else {
                                                dzVar39 = this.cNq.cMK;
                                                dzVar39.a(((Integer) sparseArray4.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray4.get(t.g.tag_del_post_id), ((Integer) sparseArray4.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(t.g.tag_del_post_is_self)).booleanValue());
                                            }
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                                            return;
                                        } else if (view.getId() == t.g.replybtn || view.getId() == t.g.sub_pb_more || view.getId() == t.g.sub_pb_item) {
                                            if (this.cNq.checkUpIsLogin()) {
                                                cmVar5 = this.cNq.cMF;
                                                if (cmVar5.getPbData() != null) {
                                                    dzVar35 = this.cNq.cMK;
                                                    dzVar35.ajp();
                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) sparseArray5.get(t.g.tag_load_sub_data);
                                                    View view2 = (View) sparseArray5.get(t.g.tag_load_sub_view);
                                                    if (rVar != null && view2 != null) {
                                                        cmVar6 = this.cNq.cMF;
                                                        String threadID = cmVar6.getThreadID();
                                                        String id = rVar.getId();
                                                        int i2 = 0;
                                                        cmVar7 = this.cNq.cMF;
                                                        if (cmVar7.getPbData() != null) {
                                                            cmVar11 = this.cNq.cMF;
                                                            i2 = cmVar11.getPbData().aoJ();
                                                        }
                                                        this.cNq.Oy();
                                                        if (view.getId() != t.g.replybtn) {
                                                            if (view.getId() == t.g.sub_pb_item) {
                                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                String str5 = (String) sparseArray6.get(t.g.tag_photo_username);
                                                                com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) sparseArray6.get(t.g.tag_clip_board);
                                                                String str6 = null;
                                                                if (rVar2 != null) {
                                                                    str6 = rVar2.getId();
                                                                }
                                                                TiebaStatic.log("c10088");
                                                                kH2 = this.cNq.kH(id);
                                                                SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.cNq.getPageContext().getPageActivity());
                                                                SmallTailInfo asK = rVar.asK();
                                                                cmVar9 = this.cNq.cMF;
                                                                this.cNq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, str5, true, str6, i2, asK, cmVar9.getPbData().so(), false).addBigImageData(kH2.cNG, kH2.cNH, kH2.cNI, kH2.index)));
                                                                return;
                                                            } else if (rVar.aMD()) {
                                                                TiebaStatic.log("c10089");
                                                                kH = this.cNq.kH(id);
                                                                SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.cNq.getPageContext().getPageActivity());
                                                                SmallTailInfo asK2 = rVar.asK();
                                                                cmVar8 = this.cNq.cMF;
                                                                this.cNq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i2, asK2, cmVar8.getPbData().so(), false).addBigImageData(kH.cNG, kH.cNH, kH.cNI, kH.index)));
                                                                return;
                                                            } else {
                                                                rVar.hU(true);
                                                                dzVar36 = this.cNq.cMK;
                                                                dzVar36.arb().notifyDataSetChanged();
                                                                return;
                                                            }
                                                        }
                                                        kH3 = this.cNq.kH(id);
                                                        SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.cNq.getPageContext().getPageActivity());
                                                        SmallTailInfo asK3 = rVar.asK();
                                                        cmVar10 = this.cNq.cMF;
                                                        this.cNq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id, "pb", true, null, true, null, i2, asK3, cmVar10.getPbData().so(), false).addBigImageData(kH3.cNG, kH3.cNH, kH3.cNI, kH3.index)));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            com.baidu.tbadk.core.util.au r = new com.baidu.tbadk.core.util.au("c10517").r("obj_locate", 3);
                                            cmVar12 = this.cNq.cMF;
                                            TiebaStatic.log(r.aa(ImageViewerConfig.FORUM_ID, cmVar12.getPbData().getForumId()));
                                            return;
                                        } else {
                                            int id2 = view.getId();
                                            if (id2 == t.g.pb_u9_text_view) {
                                                if (this.cNq.checkUpIsLogin() && (alVar = (com.baidu.tbadk.core.data.al) view.getTag()) != null && !StringUtils.isNull(alVar.tZ())) {
                                                    TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.be.wt().c(this.cNq.getPageContext(), new String[]{alVar.tZ()});
                                                    return;
                                                }
                                                return;
                                            } else if (id2 == t.g.reply) {
                                                ctVar7 = this.cNq.cMO;
                                                if (ctVar7 == null) {
                                                    this.cNq.apm();
                                                }
                                                ctVar8 = this.cNq.cMO;
                                                ctVar8.Gp();
                                                com.baidu.tieba.tbadkCore.data.r rVar3 = null;
                                                if (view != null && view.getTag() != null) {
                                                    rVar3 = (com.baidu.tieba.tbadkCore.data.r) ((SparseArray) view.getTag()).get(t.g.tag_load_sub_data);
                                                    cmVar38 = this.cNq.cMF;
                                                    if (!cmVar38.apZ() || !TbadkCoreApplication.m411getInst().isTTSCanUse()) {
                                                        ctVar13 = this.cNq.cMO;
                                                        ctVar13.aqs();
                                                    } else {
                                                        ctVar39 = this.cNq.cMO;
                                                        ctVar39.aqt();
                                                    }
                                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                                    if (sparseArray7.get(t.g.tag_pb_floor_postion) instanceof Integer) {
                                                        int intValue2 = ((Integer) sparseArray7.get(t.g.tag_pb_floor_postion)).intValue();
                                                        ctVar38 = this.cNq.cMO;
                                                        ctVar38.aqr().setTag(t.g.tag_pb_floor_postion, Integer.valueOf(intValue2));
                                                    }
                                                    SparseArray sparseArray8 = new SparseArray();
                                                    sparseArray8.put(t.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.r) ((SparseArray) view.getTag()).get(t.g.tag_clip_board));
                                                    sparseArray8.put(t.g.tag_is_subpb, false);
                                                    ctVar14 = this.cNq.cMO;
                                                    ctVar14.aql().setTag(sparseArray8);
                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                    boolean booleanValue4 = ((Boolean) sparseArray9.get(t.g.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue5 = ((Boolean) sparseArray9.get(t.g.tag_user_mute_visible)).booleanValue();
                                                    boolean booleanValue6 = ((Boolean) sparseArray9.get(t.g.tag_should_delete_visible)).booleanValue();
                                                    if (!(sparseArray9.get(t.g.tag_del_post_is_self) instanceof Boolean)) {
                                                        z3 = false;
                                                    } else {
                                                        z3 = ((Boolean) sparseArray9.get(t.g.tag_del_post_is_self)).booleanValue();
                                                    }
                                                    String str7 = null;
                                                    if (sparseArray9.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                        str7 = (String) sparseArray9.get(t.g.tag_forbid_user_post_id);
                                                    }
                                                    if (booleanValue4) {
                                                        SparseArray sparseArray10 = new SparseArray();
                                                        sparseArray10.put(t.g.tag_should_manage_visible, true);
                                                        sparseArray10.put(t.g.tag_manage_user_identity, sparseArray9.get(t.g.tag_manage_user_identity));
                                                        sparseArray10.put(t.g.tag_forbid_user_name, sparseArray9.get(t.g.tag_forbid_user_name));
                                                        sparseArray10.put(t.g.tag_forbid_user_post_id, str7);
                                                        if (booleanValue5) {
                                                            sparseArray10.put(t.g.tag_user_mute_visible, true);
                                                            sparseArray10.put(t.g.tag_is_mem, sparseArray9.get(t.g.tag_is_mem));
                                                            sparseArray10.put(t.g.tag_user_mute_mute_userid, sparseArray9.get(t.g.tag_user_mute_mute_userid));
                                                            sparseArray10.put(t.g.tag_user_mute_mute_username, sparseArray9.get(t.g.tag_user_mute_mute_username));
                                                            sparseArray10.put(t.g.tag_user_mute_post_id, sparseArray9.get(t.g.tag_user_mute_post_id));
                                                            sparseArray10.put(t.g.tag_user_mute_thread_id, sparseArray9.get(t.g.tag_user_mute_thread_id));
                                                        } else {
                                                            sparseArray10.put(t.g.tag_user_mute_visible, false);
                                                        }
                                                        if (booleanValue6) {
                                                            sparseArray10.put(t.g.tag_should_delete_visible, true);
                                                            sparseArray10.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                            sparseArray10.put(t.g.tag_del_post_id, sparseArray9.get(t.g.tag_del_post_id));
                                                            sparseArray10.put(t.g.tag_del_post_type, sparseArray9.get(t.g.tag_del_post_type));
                                                            ctVar37 = this.cNq.cMO;
                                                            ctVar37.aqo().setVisibility(0);
                                                        } else {
                                                            sparseArray10.put(t.g.tag_should_delete_visible, false);
                                                            ctVar32 = this.cNq.cMO;
                                                            ctVar32.aqo().setVisibility(8);
                                                        }
                                                        ctVar33 = this.cNq.cMO;
                                                        ctVar33.aqm().setTag(sparseArray10);
                                                        ctVar34 = this.cNq.cMO;
                                                        ctVar34.aqo().setTag(sparseArray10);
                                                        ctVar35 = this.cNq.cMO;
                                                        ctVar35.aqm().setText(t.j.bar_manager);
                                                        ctVar36 = this.cNq.cMO;
                                                        ctVar36.aqm().setVisibility(0);
                                                    } else if (!booleanValue6) {
                                                        ctVar15 = this.cNq.cMO;
                                                        ctVar15.aqm().setVisibility(8);
                                                        ctVar16 = this.cNq.cMO;
                                                        ctVar16.aqo().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray11 = new SparseArray();
                                                        sparseArray11.put(t.g.tag_should_manage_visible, false);
                                                        sparseArray11.put(t.g.tag_user_mute_visible, false);
                                                        sparseArray11.put(t.g.tag_should_delete_visible, true);
                                                        sparseArray11.put(t.g.tag_manage_user_identity, sparseArray9.get(t.g.tag_manage_user_identity));
                                                        sparseArray11.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                        sparseArray11.put(t.g.tag_del_post_id, sparseArray9.get(t.g.tag_del_post_id));
                                                        sparseArray11.put(t.g.tag_del_post_type, sparseArray9.get(t.g.tag_del_post_type));
                                                        ctVar17 = this.cNq.cMO;
                                                        ctVar17.aqm().setTag(sparseArray11);
                                                        ctVar18 = this.cNq.cMO;
                                                        ctVar18.aqo().setTag(sparseArray11);
                                                        ctVar19 = this.cNq.cMO;
                                                        ctVar19.aqm().setText(t.j.delete);
                                                        ctVar20 = this.cNq.cMO;
                                                        ctVar20.aqo().setVisibility(0);
                                                        ctVar21 = this.cNq.cMO;
                                                        ctVar21.aqm().setVisibility(8);
                                                    }
                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                    if (!(sparseArray12.get(t.g.tag_user_mute_visible) instanceof Boolean)) {
                                                        z4 = false;
                                                    } else {
                                                        z4 = ((Boolean) sparseArray12.get(t.g.tag_user_mute_visible)).booleanValue();
                                                    }
                                                    if (!((Boolean) sparseArray12.get(t.g.tag_should_manage_visible)).booleanValue() && z4) {
                                                        SparseArray sparseArray13 = new SparseArray();
                                                        sparseArray13.put(t.g.tag_user_mute_visible, true);
                                                        sparseArray13.put(t.g.tag_is_mem, sparseArray12.get(t.g.tag_is_mem));
                                                        sparseArray13.put(t.g.tag_user_mute_mute_userid, sparseArray12.get(t.g.tag_user_mute_mute_userid));
                                                        sparseArray13.put(t.g.tag_user_mute_mute_username, sparseArray12.get(t.g.tag_user_mute_mute_username));
                                                        sparseArray13.put(t.g.tag_user_mute_post_id, sparseArray12.get(t.g.tag_user_mute_post_id));
                                                        sparseArray13.put(t.g.tag_user_mute_thread_id, sparseArray12.get(t.g.tag_user_mute_thread_id));
                                                        sparseArray13.put(t.g.tag_del_post_is_self, sparseArray12.get(t.g.tag_del_post_is_self));
                                                        sparseArray13.put(t.g.tag_del_post_type, sparseArray12.get(t.g.tag_del_post_type));
                                                        sparseArray13.put(t.g.tag_del_post_id, sparseArray12.get(t.g.tag_del_post_id));
                                                        sparseArray13.put(t.g.tag_manage_user_identity, sparseArray12.get(t.g.tag_manage_user_identity));
                                                        ctVar28 = this.cNq.cMO;
                                                        ctVar28.aqn().setTag(sparseArray13);
                                                        ctVar29 = this.cNq.cMO;
                                                        ctVar29.aqn().setVisibility(0);
                                                        ctVar30 = this.cNq.cMO;
                                                        ctVar30.aqm().setVisibility(8);
                                                        ctVar31 = this.cNq.cMO;
                                                        ctVar31.aqn().setText(t.j.mute_option);
                                                    } else {
                                                        if (!(sparseArray12.get(t.g.tag_del_post_is_self) instanceof Boolean)) {
                                                            z5 = false;
                                                        } else {
                                                            z5 = ((Boolean) sparseArray12.get(t.g.tag_del_post_is_self)).booleanValue();
                                                        }
                                                        String str8 = null;
                                                        if (sparseArray12.get(t.g.tag_forbid_user_post_id) instanceof String) {
                                                            str8 = (String) sparseArray12.get(t.g.tag_forbid_user_post_id);
                                                        }
                                                        fl = this.cNq.fl(z5);
                                                        boolean isLogin = fl & this.cNq.isLogin();
                                                        this.cNq.cNm = (com.baidu.tieba.tbadkCore.data.r) sparseArray12.get(t.g.tag_clip_board);
                                                        if (dy.g(this.cNq.cNm) ? false : isLogin) {
                                                            ctVar23 = this.cNq.cMO;
                                                            ctVar23.aqn().setVisibility(0);
                                                            ctVar24 = this.cNq.cMO;
                                                            ctVar24.aqn().setTag(str8);
                                                        } else {
                                                            ctVar22 = this.cNq.cMO;
                                                            ctVar22.aqn().setVisibility(8);
                                                        }
                                                    }
                                                    SparseArray sparseArray14 = (SparseArray) view.getTag();
                                                    boolean z6 = false;
                                                    long j2 = 0;
                                                    if (sparseArray14.get(t.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                        z6 = ((Boolean) sparseArray14.get(t.g.tag_should_hide_chudian_visible)).booleanValue();
                                                    }
                                                    if (sparseArray14.get(t.g.tag_chudian_template_id) instanceof Long) {
                                                        j2 = ((Long) sparseArray14.get(t.g.tag_chudian_template_id)).longValue();
                                                    }
                                                    if (z6) {
                                                        ctVar26 = this.cNq.cMO;
                                                        ctVar26.aqp().setVisibility(0);
                                                        ctVar27 = this.cNq.cMO;
                                                        ctVar27.aqp().setTag(t.g.tag_chudian_template_id, Long.valueOf(j2));
                                                    } else {
                                                        ctVar25 = this.cNq.cMO;
                                                        ctVar25.aqp().setVisibility(8);
                                                    }
                                                }
                                                cmVar36 = this.cNq.cMF;
                                                if (cmVar36.getPbData().qg()) {
                                                    cmVar37 = this.cNq.cMF;
                                                    String qf = cmVar37.getPbData().qf();
                                                    if (rVar3 != null && !com.baidu.adp.lib.util.j.isEmpty(qf) && qf.equals(rVar3.getId())) {
                                                        z2 = true;
                                                        if (!z2) {
                                                            ctVar12 = this.cNq.cMO;
                                                            ctVar12.aql().setText(t.j.remove_mark);
                                                        } else {
                                                            ctVar9 = this.cNq.cMO;
                                                            ctVar9.aql().setText(t.j.mark);
                                                        }
                                                        ctVar10 = this.cNq.cMO;
                                                        ctVar10.fw(true);
                                                        ctVar11 = this.cNq.cMO;
                                                        ctVar11.wO();
                                                        return;
                                                    }
                                                }
                                                z2 = false;
                                                if (!z2) {
                                                }
                                                ctVar10 = this.cNq.cMO;
                                                ctVar10.fw(true);
                                                ctVar11 = this.cNq.cMO;
                                                ctVar11.wO();
                                                return;
                                            } else if (id2 != t.g.pb_head_reverse_hint) {
                                                if (id2 == t.g.pb_act_btn) {
                                                    cmVar29 = this.cNq.cMF;
                                                    if (cmVar29.getPbData() != null) {
                                                        cmVar30 = this.cNq.cMF;
                                                        if (cmVar30.getPbData().aoF() != null) {
                                                            cmVar31 = this.cNq.cMF;
                                                            if (cmVar31.getPbData().aoF().tG() != null) {
                                                                Activity activity = this.cNq.getActivity();
                                                                cmVar32 = this.cNq.cMF;
                                                                com.baidu.tbadk.browser.f.B(activity, cmVar32.getPbData().aoF().tG());
                                                                cmVar33 = this.cNq.cMF;
                                                                if (cmVar33.getPbData().aoF().tE() != 1) {
                                                                    cmVar34 = this.cNq.cMF;
                                                                    if (cmVar34.getPbData().aoF().tE() == 2) {
                                                                        TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id2 == t.g.pb_item_tail_content) {
                                                    String string = TbadkCoreApplication.m411getInst().getString(t.j.tail_web_view_title);
                                                    String string2 = com.baidu.tbadk.core.sharedPref.b.uO().getString("tail_link", "");
                                                    if (!StringUtils.isNull(string2)) {
                                                        TiebaStatic.log("c10056");
                                                        com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                        return;
                                                    }
                                                    return;
                                                } else if (id2 == t.g.join_vote_tv) {
                                                    if (view != null) {
                                                        com.baidu.tbadk.browser.f.B(this.cNq.getActivity(), (String) view.getTag());
                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                        app3 = this.cNq.app();
                                                        if (app3 == 1) {
                                                            cmVar25 = this.cNq.cMF;
                                                            if (cmVar25 != null) {
                                                                cmVar26 = this.cNq.cMF;
                                                                if (cmVar26.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c10397");
                                                                    cmVar27 = this.cNq.cMF;
                                                                    com.baidu.tbadk.core.util.au aa = auVar2.aa(ImageViewerConfig.FORUM_ID, cmVar27.getPbData().getForumId());
                                                                    cmVar28 = this.cNq.cMF;
                                                                    TiebaStatic.log(aa.aa("tid", cmVar28.getPbData().getThreadId()).aa("uid", currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        app4 = this.cNq.app();
                                                        if (app4 == 2) {
                                                            cmVar21 = this.cNq.cMF;
                                                            if (cmVar21 != null) {
                                                                cmVar22 = this.cNq.cMF;
                                                                if (cmVar22.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.au auVar3 = new com.baidu.tbadk.core.util.au("c10401");
                                                                    cmVar23 = this.cNq.cMF;
                                                                    com.baidu.tbadk.core.util.au aa2 = auVar3.aa(ImageViewerConfig.FORUM_ID, cmVar23.getPbData().getForumId());
                                                                    cmVar24 = this.cNq.cMF;
                                                                    TiebaStatic.log(aa2.aa("tid", cmVar24.getPbData().getThreadId()).aa("uid", currentAccount));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id2 == t.g.look_all_tv && view != null) {
                                                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                    com.baidu.tbadk.browser.f.B(this.cNq.getActivity(), (String) view.getTag());
                                                    app = this.cNq.app();
                                                    if (app == 1) {
                                                        cmVar17 = this.cNq.cMF;
                                                        if (cmVar17 != null) {
                                                            cmVar18 = this.cNq.cMF;
                                                            if (cmVar18.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.au auVar4 = new com.baidu.tbadk.core.util.au("c10507");
                                                                cmVar19 = this.cNq.cMF;
                                                                com.baidu.tbadk.core.util.au aa3 = auVar4.aa(ImageViewerConfig.FORUM_ID, cmVar19.getPbData().getForumId());
                                                                cmVar20 = this.cNq.cMF;
                                                                TiebaStatic.log(aa3.aa("tid", cmVar20.getPbData().getThreadId()).aa("uid", currentAccount2));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    app2 = this.cNq.app();
                                                    if (app2 == 2) {
                                                        cmVar13 = this.cNq.cMF;
                                                        if (cmVar13 != null) {
                                                            cmVar14 = this.cNq.cMF;
                                                            if (cmVar14.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.au auVar5 = new com.baidu.tbadk.core.util.au("c10508");
                                                                cmVar15 = this.cNq.cMF;
                                                                com.baidu.tbadk.core.util.au aa4 = auVar5.aa(ImageViewerConfig.FORUM_ID, cmVar15.getPbData().getForumId());
                                                                cmVar16 = this.cNq.cMF;
                                                                TiebaStatic.log(aa4.aa("tid", cmVar16.getPbData().getThreadId()).aa("uid", currentAccount2));
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
                                            } else {
                                                this.cNq.Oy();
                                                dzVar37 = this.cNq.cMK;
                                                dzVar37.ajp();
                                                dzVar38 = this.cNq.cMK;
                                                dzVar38.arh();
                                                cmVar35 = this.cNq.cMF;
                                                cmVar35.apY();
                                                return;
                                            }
                                        }
                                    } else if (this.cNq.checkUpIsLogin()) {
                                        this.cNq.api();
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                com.baidu.tieba.tbadkCore.d.a.bn("c10725", null);
                                if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                    cmVar39 = this.cNq.cMF;
                                    if (cmVar39.getPbData() != null) {
                                        cmVar40 = this.cNq.cMF;
                                        if (cmVar40.getPbData().aoF() != null) {
                                            cmVar41 = this.cNq.cMF;
                                            if (cmVar41.getPbData().aoF().te() != null) {
                                                InterviewLiveActivityConfig interviewLiveActivityConfig = new InterviewLiveActivityConfig(this.cNq.getPageContext().getPageActivity());
                                                cmVar42 = this.cNq.cMF;
                                                String threadId = cmVar42.getPbData().aoF().te().getThreadId();
                                                cmVar43 = this.cNq.cMF;
                                                String taskId = cmVar43.getPbData().aoF().te().getTaskId();
                                                cmVar44 = this.cNq.cMF;
                                                String forumId = cmVar44.getPbData().aoF().te().getForumId();
                                                cmVar45 = this.cNq.cMF;
                                                this.cNq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, interviewLiveActivityConfig.createNormalCfg(threadId, taskId, forumId, cmVar45.getPbData().aoF().te().getForumName())));
                                                this.cNq.cMs = true;
                                                this.cNq.finish();
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
                            TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            String stringExtra = this.cNq.getIntent().getStringExtra("from");
                            cmVar70 = this.cNq.cMF;
                            String name = cmVar70.getPbData().aoE().getName();
                            cmVar71 = this.cNq.cMF;
                            if (!TextUtils.isEmpty(cmVar71.apO())) {
                                cmVar72 = this.cNq.cMF;
                                if (cmVar72.apO().equals(name) && !com.baidu.tieba.card.af.class.getName().equals(stringExtra)) {
                                    this.cNq.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.aw.aQ(name)) {
                                this.cNq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cNq.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        dzVar6 = this.cNq.cMK;
        dzVar6.arz();
        cmVar = this.cNq.cMF;
        if (cmVar.getPbData().aoJ() == 1) {
            aVar = this.cNq.cMH;
            if (!aVar.aNl()) {
                dzVar7 = this.cNq.cMK;
                dzVar7.are();
                int i3 = 0;
                dzVar8 = this.cNq.cMK;
                if (view != dzVar8.aru()) {
                    dzVar9 = this.cNq.cMK;
                    if (view != dzVar9.arv()) {
                        dzVar10 = this.cNq.cMK;
                        if (view != dzVar10.arw()) {
                            dzVar11 = this.cNq.cMK;
                            if (view != dzVar11.arx()) {
                                dzVar12 = this.cNq.cMK;
                                if (view == dzVar12.arf()) {
                                    i3 = 2;
                                }
                            } else {
                                i3 = 5;
                            }
                        } else {
                            i3 = 4;
                        }
                    } else {
                        i3 = 3;
                    }
                } else {
                    i3 = 6;
                }
                cmVar2 = this.cNq.cMF;
                ForumData aoE2 = cmVar2.getPbData().aoE();
                String name2 = aoE2.getName();
                String id3 = aoE2.getId();
                cmVar3 = this.cNq.cMF;
                String id4 = cmVar3.getPbData().aoF().getId();
                aVar2 = this.cNq.cMH;
                dzVar13 = this.cNq.cMK;
                aVar2.b(id3, name2, id4, i3, dzVar13.arg());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            }
        }
    }
}
