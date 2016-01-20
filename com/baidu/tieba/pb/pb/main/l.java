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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v119, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0fac  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x1164  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        dk dkVar;
        dk dkVar2;
        dk dkVar3;
        dk dkVar4;
        dk dkVar5;
        cf cfVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        dk dkVar6;
        dk dkVar7;
        dk dkVar8;
        dk dkVar9;
        dk dkVar10;
        dk dkVar11;
        cf cfVar2;
        cf cfVar3;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        dk dkVar12;
        dk dkVar13;
        dk dkVar14;
        dk dkVar15;
        dk dkVar16;
        dk dkVar17;
        dk dkVar18;
        dk dkVar19;
        dk dkVar20;
        dk dkVar21;
        dk dkVar22;
        dk dkVar23;
        dk dkVar24;
        dk dkVar25;
        dk dkVar26;
        dk dkVar27;
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        dk dkVar28;
        cm cmVar5;
        cf cfVar4;
        dk dkVar29;
        cf cfVar5;
        cf cfVar6;
        dk dkVar30;
        cf cfVar7;
        cf cfVar8;
        cf cfVar9;
        cf cfVar10;
        cf cfVar11;
        int all;
        int all2;
        cf cfVar12;
        cf cfVar13;
        cf cfVar14;
        cf cfVar15;
        cf cfVar16;
        cf cfVar17;
        cf cfVar18;
        cf cfVar19;
        int all3;
        int all4;
        cf cfVar20;
        cf cfVar21;
        cf cfVar22;
        cf cfVar23;
        cf cfVar24;
        cf cfVar25;
        cf cfVar26;
        cf cfVar27;
        cf cfVar28;
        cf cfVar29;
        cf cfVar30;
        cf cfVar31;
        cf cfVar32;
        cf cfVar33;
        dk dkVar31;
        dk dkVar32;
        cf cfVar34;
        cm cmVar6;
        cm cmVar7;
        cf cfVar35;
        boolean z;
        cm cmVar8;
        cm cmVar9;
        cm cmVar10;
        cm cmVar11;
        cf cfVar36;
        cm cmVar12;
        boolean z2;
        cm cmVar13;
        cm cmVar14;
        cm cmVar15;
        cm cmVar16;
        cm cmVar17;
        cm cmVar18;
        cm cmVar19;
        boolean z3;
        boolean z4;
        boolean eX;
        cm cmVar20;
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
        cm cmVar35;
        com.baidu.tbadk.core.data.ad adVar;
        dk dkVar33;
        dk dkVar34;
        cm cmVar36;
        dk dkVar35;
        dk dkVar36;
        cm cmVar37;
        cf cfVar37;
        cm cmVar38;
        dk dkVar37;
        cm cmVar39;
        cm cmVar40;
        dk dkVar38;
        dk dkVar39;
        dk dkVar40;
        cf cfVar38;
        dk dkVar41;
        dk dkVar42;
        cf cfVar39;
        cf cfVar40;
        cf cfVar41;
        dk dkVar43;
        cf cfVar42;
        cf cfVar43;
        cf cfVar44;
        dk dkVar44;
        dk dkVar45;
        dk dkVar46;
        cf cfVar45;
        dk dkVar47;
        dk dkVar48;
        cf cfVar46;
        dk dkVar49;
        cf cfVar47;
        dk dkVar50;
        dk dkVar51;
        dk dkVar52;
        dk dkVar53;
        boolean kn;
        cf cfVar48;
        dk dkVar54;
        cf cfVar49;
        cf cfVar50;
        cf cfVar51;
        cf cfVar52;
        cf cfVar53;
        cf cfVar54;
        boolean z5;
        dk dkVar55;
        dk dkVar56;
        dk dkVar57;
        cf cfVar55;
        String aly;
        cf cfVar56;
        cf cfVar57;
        cf cfVar58;
        cf cfVar59;
        dk dkVar58;
        cf cfVar60;
        cf cfVar61;
        cf cfVar62;
        cf cfVar63;
        cf cfVar64;
        dk dkVar59;
        cf cfVar65;
        dk dkVar60;
        dk dkVar61;
        dk dkVar62;
        cf cfVar66;
        cf cfVar67;
        dk dkVar63;
        dkVar = this.cFS.cFq;
        if (view == dkVar.getNextView()) {
            cfVar67 = this.cFS.cFl;
            if (cfVar67.fc(true)) {
                dkVar63 = this.cFS.cFq;
                dkVar63.amL();
                return;
            }
            return;
        }
        dkVar2 = this.cFS.cFq;
        if (view == dkVar2.anf()) {
            dkVar60 = this.cFS.cFq;
            dkVar60.ana();
            this.cFS.stopVoice();
            dkVar61 = this.cFS.cFq;
            dkVar61.amJ();
            dkVar62 = this.cFS.cFq;
            dkVar62.adL();
            cfVar66 = this.cFS.cFl;
            cfVar66.kq(1);
            return;
        }
        dkVar3 = this.cFS.cFq;
        if (view == dkVar3.cIl.aBG) {
            dkVar59 = this.cFS.cFq;
            cfVar65 = this.cFS.cFl;
            if (!dkVar59.fs(cfVar65.alQ())) {
                this.cFS.finish();
                return;
            } else {
                this.cFS.stopVoice();
                return;
            }
        }
        dkVar4 = this.cFS.cFq;
        if (view != dkVar4.amV()) {
            dkVar13 = this.cFS.cFq;
            if (view != dkVar13.amW()) {
                dkVar14 = this.cFS.cFq;
                if (view != dkVar14.amX()) {
                    dkVar15 = this.cFS.cFq;
                    if (view != dkVar15.amY()) {
                        dkVar16 = this.cFS.cFq;
                        if (view != dkVar16.amH()) {
                            dkVar17 = this.cFS.cFq;
                            if (view == dkVar17.anc()) {
                                cfVar63 = this.cFS.cFl;
                                if (cfVar63 != null) {
                                    cfVar64 = this.cFS.cFl;
                                    com.baidu.tbadk.browser.f.B(this.cFS.getPageContext().getPageActivity(), cfVar64.getPbData().akH().su().getLink());
                                    return;
                                }
                                return;
                            }
                            dkVar18 = this.cFS.cFq;
                            if (view != dkVar18.cIl.cKt) {
                                dkVar19 = this.cFS.cFq;
                                if (view == dkVar19.cIl.cKv) {
                                    cfVar56 = this.cFS.cFl;
                                    if (cfVar56 != null) {
                                        cfVar57 = this.cFS.cFl;
                                        if (cfVar57.getPbData() != null) {
                                            cfVar58 = this.cFS.cFl;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = cfVar58.getPbData().akI();
                                            if (akI == null || akI.size() <= 0) {
                                                cfVar59 = this.cFS.cFl;
                                                if (cfVar59.alM()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.cFS.getPageContext().getPageActivity(), this.cFS.getPageContext().getString(n.j.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            dkVar58 = this.cFS.cFq;
                                            dkVar58.amz();
                                            this.cFS.alm();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.cFS.getPageContext().getPageActivity(), this.cFS.getPageContext().getString(n.j.pb_no_data_tips));
                                    return;
                                }
                                dkVar20 = this.cFS.cFq;
                                if (view == dkVar20.cIl.cKu) {
                                    z5 = this.cFS.mIsLoading;
                                    if (!z5) {
                                        this.cFS.mIsLoading = true;
                                        dkVar55 = this.cFS.cFq;
                                        dkVar55.cIl.cKu.setEnabled(false);
                                        dkVar56 = this.cFS.cFq;
                                        dkVar56.ZY();
                                        this.cFS.stopVoice();
                                        dkVar57 = this.cFS.cFq;
                                        dkVar57.amJ();
                                        cfVar55 = this.cFS.cFl;
                                        aly = this.cFS.aly();
                                        cfVar55.kF(aly);
                                        TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                dkVar21 = this.cFS.cFq;
                                if (view == dkVar21.cIl.cKw) {
                                    cfVar49 = this.cFS.cFl;
                                    AdditionData akO = cfVar49.getPbData().akO();
                                    if (!TextUtils.isEmpty(akO.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.cFS.getPageContext().getPageActivity(), akO.getWarnMsg());
                                        return;
                                    } else if (akO.getAlreadyCount() != akO.getTotalCount()) {
                                        cfVar50 = this.cFS.cFl;
                                        ForumData akG = cfVar50.getPbData().akG();
                                        cfVar51 = this.cFS.cFl;
                                        com.baidu.tbadk.core.data.z akH = cfVar51.getPbData().akH();
                                        cfVar52 = this.cFS.cFl;
                                        AntiData rI = cfVar52.getPbData().rI();
                                        if (akH.getId() != null) {
                                            if (rI != null && rI.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.cFS.getPageContext().getPageActivity(), rI.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            cfVar53 = this.cFS.cFl;
                                            if (cfVar53.getPbData().getUserData() != null) {
                                                cfVar54 = this.cFS.cFl;
                                                i = cfVar54.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.cFS.getPageContext().getPageActivity(), 2, akG.getId(), akG.getName(), akH.getId(), akO.getPostId(), 0, rI, 13008, false, false, null, false, false, null, akO, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.cFS.getPageContext().getPageActivity(), String.format(this.cFS.getPageContext().getString(n.j.write_addition_limit), Integer.valueOf(akO.getTotalCount())));
                                        return;
                                    }
                                }
                                dkVar22 = this.cFS.cFq;
                                if (dkVar22.cIl.ano() != null) {
                                    dkVar52 = this.cFS.cFq;
                                    if (view == dkVar52.cIl.ano().amf()) {
                                        dkVar53 = this.cFS.cFq;
                                        dkVar53.ana();
                                        kn = this.cFS.kn(11009);
                                        if (kn) {
                                            cfVar48 = this.cFS.cFl;
                                            dkVar54 = this.cFS.cFq;
                                            if (cfVar48.kw(dkVar54.amP()) == null) {
                                                return;
                                            }
                                            this.cFS.alq();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                dkVar23 = this.cFS.cFq;
                                if (dkVar23.cIl.ano() != null) {
                                    dkVar50 = this.cFS.cFq;
                                    if (view == dkVar50.cIl.ano().amk()) {
                                        dkVar51 = this.cFS.cFq;
                                        dkVar51.ana();
                                        this.cFS.stopVoice();
                                        this.cFS.showShareDialog();
                                        return;
                                    }
                                }
                                dkVar24 = this.cFS.cFq;
                                if (dkVar24.cIl.ano() != null) {
                                    dkVar47 = this.cFS.cFq;
                                    if (view == dkVar47.cIl.ano().amm()) {
                                        dkVar48 = this.cFS.cFq;
                                        dkVar48.ana();
                                        cfVar46 = this.cFS.cFl;
                                        if (cfVar46.VB() != null) {
                                            dkVar49 = this.cFS.cFq;
                                            cfVar47 = this.cFS.cFl;
                                            dkVar49.a(cfVar47.VB(), this.cFS.cyi);
                                        }
                                        TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                dkVar25 = this.cFS.cFq;
                                if (dkVar25.cIl.ano() != null) {
                                    dkVar44 = this.cFS.cFq;
                                    if (view == dkVar44.cIl.ano().amn()) {
                                        dkVar45 = this.cFS.cFq;
                                        dkVar45.ana();
                                        this.cFS.stopVoice();
                                        dkVar46 = this.cFS.cFq;
                                        dkVar46.amJ();
                                        cfVar45 = this.cFS.cFl;
                                        cfVar45.alV();
                                        TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                dkVar26 = this.cFS.cFq;
                                if (dkVar26.cIl.ano() != null) {
                                    dkVar42 = this.cFS.cFq;
                                    if (view == dkVar42.cIl.ano().amo()) {
                                        cfVar39 = this.cFS.cFl;
                                        if (cfVar39 != null) {
                                            cfVar40 = this.cFS.cFl;
                                            if (cfVar40.getPbData() != null) {
                                                cfVar41 = this.cFS.cFl;
                                                if (cfVar41.getPbData().akH() != null) {
                                                    dkVar43 = this.cFS.cFq;
                                                    dkVar43.cIl.qn();
                                                    cfVar42 = this.cFS.cFl;
                                                    if (cfVar42.getPbData().akI() != null) {
                                                        cfVar43 = this.cFS.cFl;
                                                        if (cfVar43.getPbData().akI().size() > 0) {
                                                            PbActivity pbActivity = this.cFS;
                                                            cfVar44 = this.cFS.cFl;
                                                            pbActivity.kw(cfVar44.getPbData().akI().get(0).getId());
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
                                dkVar27 = this.cFS.cFq;
                                if (dkVar27.cIl.ano() != null) {
                                    dkVar38 = this.cFS.cFq;
                                    if (view == dkVar38.cIl.ano().amp()) {
                                        TiebaStatic.log("c10414");
                                        dkVar39 = this.cFS.cFq;
                                        dkVar39.ana();
                                        dkVar40 = this.cFS.cFq;
                                        if (dkVar40.sq() != dk.cJI) {
                                            cfVar38 = this.cFS.cFl;
                                            cfVar38.kx(cf.cHs);
                                            return;
                                        }
                                        dkVar41 = this.cFS.cFq;
                                        dkVar41.ank();
                                        return;
                                    }
                                }
                                cmVar = this.cFS.cFu;
                                if (cmVar != null) {
                                    cmVar40 = this.cFS.cFu;
                                    if (view == cmVar40.amh()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray.put(n.g.tag_from, 0);
                                                    sparseArray.put(n.g.tag_check_mute_from, 2);
                                                    this.cFS.d(sparseArray);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        this.cFS.kw((String) tag);
                                        return;
                                    }
                                }
                                cmVar2 = this.cFS.cFu;
                                if (cmVar2 != null) {
                                    cmVar39 = this.cFS.cFu;
                                    if (view == cmVar39.amf()) {
                                        if (!this.cFS.checkUpIsLogin()) {
                                            return;
                                        }
                                        this.cFS.ai(view);
                                        return;
                                    }
                                }
                                cmVar3 = this.cFS.cFu;
                                if (cmVar3 != null) {
                                    cmVar38 = this.cFS.cFu;
                                    if (view == cmVar38.ami()) {
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null && (sparseArray2.get(n.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(n.g.tag_del_post_id) instanceof String) && (sparseArray2.get(n.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(n.g.tag_del_post_is_self) instanceof Boolean)) {
                                            dkVar37 = this.cFS.cFq;
                                            dkVar37.a(((Integer) sparseArray2.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(n.g.tag_del_post_id), ((Integer) sparseArray2.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(n.g.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                cmVar4 = this.cFS.cFu;
                                if (cmVar4 != null) {
                                    cmVar37 = this.cFS.cFu;
                                    if (view == cmVar37.amj()) {
                                        long j = -1;
                                        String str = "";
                                        if (view.getTag(n.g.tag_chudian_template_id) instanceof Long) {
                                            j = ((Long) view.getTag(n.g.tag_chudian_template_id)).longValue();
                                        }
                                        if (view.getTag(n.g.tag_chudian_monitor_id) instanceof String) {
                                            str = (String) view.getTag(n.g.tag_chudian_monitor_id);
                                        }
                                        cfVar37 = this.cFS.cFl;
                                        com.baidu.tieba.pb.a.c pbData = cfVar37.getPbData();
                                        String str2 = null;
                                        String str3 = null;
                                        String str4 = null;
                                        if (pbData != null && pbData.akG() != null) {
                                            str2 = pbData.akG().getId();
                                            str3 = pbData.akG().getName();
                                            str4 = pbData.getThreadId();
                                        }
                                        com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", str2, str3, str4);
                                        this.cFS.a(j, str, str2, str3, str4);
                                        return;
                                    }
                                }
                                dkVar28 = this.cFS.cFq;
                                if (dkVar28.amD() != view) {
                                    cmVar5 = this.cFS.cFu;
                                    if (cmVar5 != null) {
                                        cmVar36 = this.cFS.cFu;
                                        if (view == cmVar36.amg()) {
                                            SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                                            if (sparseArray3 != null) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(n.g.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(n.g.tag_should_delete_visible)).booleanValue();
                                                boolean booleanValue3 = ((Boolean) sparseArray3.get(n.g.tag_user_mute_visible)).booleanValue();
                                                if (booleanValue) {
                                                    if (booleanValue3) {
                                                        sparseArray3.put(n.g.tag_from, 1);
                                                        sparseArray3.put(n.g.tag_check_mute_from, 2);
                                                        this.cFS.d(sparseArray3);
                                                        return;
                                                    }
                                                    sparseArray3.put(n.g.tag_check_mute_from, 2);
                                                    dkVar36 = this.cFS.cFq;
                                                    dkVar36.ap(view);
                                                    return;
                                                } else if (booleanValue2) {
                                                    dkVar35 = this.cFS.cFq;
                                                    dkVar35.a(((Integer) sparseArray3.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(n.g.tag_del_post_id), ((Integer) sparseArray3.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(n.g.tag_del_post_is_self)).booleanValue());
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() == n.g.pb_head_function_manage_delormanage) {
                                        SparseArray sparseArray4 = (SparseArray) view.getTag();
                                        if (((Boolean) sparseArray4.get(n.g.tag_should_manage_visible)).booleanValue()) {
                                            dkVar34 = this.cFS.cFq;
                                            dkVar34.ap(view);
                                            return;
                                        }
                                        dkVar33 = this.cFS.cFq;
                                        dkVar33.a(((Integer) sparseArray4.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray4.get(n.g.tag_del_post_id), ((Integer) sparseArray4.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(n.g.tag_del_post_is_self)).booleanValue());
                                        return;
                                    } else if (view.getId() == n.g.replybtn || view.getId() == n.g.sub_pb_more || view.getId() == n.g.sub_pb_item) {
                                        if (this.cFS.checkUpIsLogin()) {
                                            cfVar4 = this.cFS.cFl;
                                            if (cfVar4.getPbData() != null) {
                                                dkVar29 = this.cFS.cFq;
                                                dkVar29.ana();
                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) sparseArray5.get(n.g.tag_load_sub_data);
                                                View view2 = (View) sparseArray5.get(n.g.tag_load_sub_view);
                                                if (rVar != null && view2 != null) {
                                                    cfVar5 = this.cFS.cFl;
                                                    String threadID = cfVar5.getThreadID();
                                                    String id = rVar.getId();
                                                    int i2 = 0;
                                                    cfVar6 = this.cFS.cFl;
                                                    if (cfVar6.getPbData() != null) {
                                                        cfVar10 = this.cFS.cFl;
                                                        i2 = cfVar10.getPbData().akL();
                                                    }
                                                    this.cFS.stopVoice();
                                                    if (view.getId() == n.g.replybtn) {
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.cFS.getPageContext().getPageActivity());
                                                        SmallTailInfo aoe = rVar.aoe();
                                                        cfVar9 = this.cFS.cFl;
                                                        this.cFS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, true, null, i2, aoe, cfVar9.getPbData().rI(), false)));
                                                        return;
                                                    } else if (view.getId() == n.g.sub_pb_item) {
                                                        SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                        String str5 = (String) sparseArray6.get(n.g.tag_photo_username);
                                                        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) sparseArray6.get(n.g.tag_clip_board);
                                                        String str6 = null;
                                                        if (rVar2 != null) {
                                                            str6 = rVar2.getId();
                                                        }
                                                        TiebaStatic.log("c10088");
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.cFS.getPageContext().getPageActivity());
                                                        SmallTailInfo aoe2 = rVar.aoe();
                                                        cfVar8 = this.cFS.cFl;
                                                        this.cFS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id, "pb", true, str5, true, str6, i2, aoe2, cfVar8.getPbData().rI(), false)));
                                                        return;
                                                    } else if (rVar.aFy()) {
                                                        TiebaStatic.log("c10089");
                                                        SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.cFS.getPageContext().getPageActivity());
                                                        SmallTailInfo aoe3 = rVar.aoe();
                                                        cfVar7 = this.cFS.cFl;
                                                        this.cFS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i2, aoe3, cfVar7.getPbData().rI(), false)));
                                                        return;
                                                    } else {
                                                        rVar.ht(true);
                                                        dkVar30 = this.cFS.cFq;
                                                        dkVar30.amE().notifyDataSetChanged();
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        com.baidu.tbadk.core.util.av r = new com.baidu.tbadk.core.util.av("c10517").r("obj_locate", 3);
                                        cfVar11 = this.cFS.cFl;
                                        TiebaStatic.log(r.aa(ImageViewerConfig.FORUM_ID, cfVar11.getPbData().getForumId()));
                                        return;
                                    } else {
                                        int id2 = view.getId();
                                        if (id2 == n.g.pb_u9_text_view) {
                                            if (this.cFS.checkUpIsLogin() && (adVar = (com.baidu.tbadk.core.data.ad) view.getTag()) != null && !StringUtils.isNull(adVar.tb())) {
                                                TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                com.baidu.tbadk.core.util.bf.vn().b(this.cFS.getPageContext(), new String[]{adVar.tb()});
                                                return;
                                            }
                                            return;
                                        } else if (id2 == n.g.reply) {
                                            cmVar6 = this.cFS.cFu;
                                            if (cmVar6 == null) {
                                                this.cFS.alj();
                                            }
                                            cmVar7 = this.cFS.cFu;
                                            cmVar7.showDialog();
                                            com.baidu.tieba.tbadkCore.data.r rVar3 = null;
                                            if (view != null && view.getTag() != null) {
                                                rVar3 = (com.baidu.tieba.tbadkCore.data.r) ((SparseArray) view.getTag()).get(n.g.tag_load_sub_data);
                                                SparseArray sparseArray7 = new SparseArray();
                                                sparseArray7.put(n.g.tag_clip_board, (com.baidu.tieba.tbadkCore.data.r) ((SparseArray) view.getTag()).get(n.g.tag_clip_board));
                                                sparseArray7.put(n.g.tag_is_subpb, false);
                                                cmVar12 = this.cFS.cFu;
                                                cmVar12.amf().setTag(sparseArray7);
                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                boolean booleanValue4 = ((Boolean) sparseArray8.get(n.g.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue5 = ((Boolean) sparseArray8.get(n.g.tag_user_mute_visible)).booleanValue();
                                                boolean booleanValue6 = ((Boolean) sparseArray8.get(n.g.tag_should_delete_visible)).booleanValue();
                                                if (!(sparseArray8.get(n.g.tag_del_post_is_self) instanceof Boolean)) {
                                                    z2 = false;
                                                } else {
                                                    z2 = ((Boolean) sparseArray8.get(n.g.tag_del_post_is_self)).booleanValue();
                                                }
                                                String str7 = null;
                                                if (sparseArray8.get(n.g.tag_forbid_user_post_id) instanceof String) {
                                                    str7 = (String) sparseArray8.get(n.g.tag_forbid_user_post_id);
                                                }
                                                if (booleanValue4) {
                                                    SparseArray sparseArray9 = new SparseArray();
                                                    sparseArray9.put(n.g.tag_should_manage_visible, true);
                                                    sparseArray9.put(n.g.tag_manage_user_identity, sparseArray8.get(n.g.tag_manage_user_identity));
                                                    sparseArray9.put(n.g.tag_forbid_user_name, sparseArray8.get(n.g.tag_forbid_user_name));
                                                    sparseArray9.put(n.g.tag_forbid_user_post_id, str7);
                                                    if (booleanValue5) {
                                                        sparseArray9.put(n.g.tag_user_mute_visible, true);
                                                        sparseArray9.put(n.g.tag_is_mem, sparseArray8.get(n.g.tag_is_mem));
                                                        sparseArray9.put(n.g.tag_user_mute_mute_userid, sparseArray8.get(n.g.tag_user_mute_mute_userid));
                                                        sparseArray9.put(n.g.tag_user_mute_mute_username, sparseArray8.get(n.g.tag_user_mute_mute_username));
                                                        sparseArray9.put(n.g.tag_user_mute_post_id, sparseArray8.get(n.g.tag_user_mute_post_id));
                                                        sparseArray9.put(n.g.tag_user_mute_thread_id, sparseArray8.get(n.g.tag_user_mute_thread_id));
                                                    } else {
                                                        sparseArray9.put(n.g.tag_user_mute_visible, false);
                                                    }
                                                    if (booleanValue6) {
                                                        sparseArray9.put(n.g.tag_should_delete_visible, true);
                                                        sparseArray9.put(n.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                        sparseArray9.put(n.g.tag_del_post_id, sparseArray8.get(n.g.tag_del_post_id));
                                                        sparseArray9.put(n.g.tag_del_post_type, sparseArray8.get(n.g.tag_del_post_type));
                                                        cmVar35 = this.cFS.cFu;
                                                        cmVar35.ami().setVisibility(0);
                                                    } else {
                                                        sparseArray9.put(n.g.tag_should_delete_visible, false);
                                                        cmVar30 = this.cFS.cFu;
                                                        cmVar30.ami().setVisibility(8);
                                                    }
                                                    cmVar31 = this.cFS.cFu;
                                                    cmVar31.amg().setTag(sparseArray9);
                                                    cmVar32 = this.cFS.cFu;
                                                    cmVar32.ami().setTag(sparseArray9);
                                                    cmVar33 = this.cFS.cFu;
                                                    cmVar33.amg().setText(n.j.bar_manager);
                                                    cmVar34 = this.cFS.cFu;
                                                    cmVar34.amg().setVisibility(0);
                                                } else if (!booleanValue6) {
                                                    cmVar13 = this.cFS.cFu;
                                                    cmVar13.amg().setVisibility(8);
                                                    cmVar14 = this.cFS.cFu;
                                                    cmVar14.ami().setVisibility(8);
                                                } else {
                                                    SparseArray sparseArray10 = new SparseArray();
                                                    sparseArray10.put(n.g.tag_should_manage_visible, false);
                                                    sparseArray10.put(n.g.tag_user_mute_visible, false);
                                                    sparseArray10.put(n.g.tag_should_delete_visible, true);
                                                    sparseArray10.put(n.g.tag_manage_user_identity, sparseArray8.get(n.g.tag_manage_user_identity));
                                                    sparseArray10.put(n.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                    sparseArray10.put(n.g.tag_del_post_id, sparseArray8.get(n.g.tag_del_post_id));
                                                    sparseArray10.put(n.g.tag_del_post_type, sparseArray8.get(n.g.tag_del_post_type));
                                                    cmVar15 = this.cFS.cFu;
                                                    cmVar15.amg().setTag(sparseArray10);
                                                    cmVar16 = this.cFS.cFu;
                                                    cmVar16.ami().setTag(sparseArray10);
                                                    cmVar17 = this.cFS.cFu;
                                                    cmVar17.amg().setText(n.j.delete);
                                                    cmVar18 = this.cFS.cFu;
                                                    cmVar18.ami().setVisibility(0);
                                                    cmVar19 = this.cFS.cFu;
                                                    cmVar19.amg().setVisibility(8);
                                                }
                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                if (!(sparseArray11.get(n.g.tag_user_mute_visible) instanceof Boolean)) {
                                                    z3 = false;
                                                } else {
                                                    z3 = ((Boolean) sparseArray11.get(n.g.tag_user_mute_visible)).booleanValue();
                                                }
                                                if (!((Boolean) sparseArray11.get(n.g.tag_should_manage_visible)).booleanValue() && z3) {
                                                    SparseArray sparseArray12 = new SparseArray();
                                                    sparseArray12.put(n.g.tag_user_mute_visible, true);
                                                    sparseArray12.put(n.g.tag_is_mem, sparseArray11.get(n.g.tag_is_mem));
                                                    sparseArray12.put(n.g.tag_user_mute_mute_userid, sparseArray11.get(n.g.tag_user_mute_mute_userid));
                                                    sparseArray12.put(n.g.tag_user_mute_mute_username, sparseArray11.get(n.g.tag_user_mute_mute_username));
                                                    sparseArray12.put(n.g.tag_user_mute_post_id, sparseArray11.get(n.g.tag_user_mute_post_id));
                                                    sparseArray12.put(n.g.tag_user_mute_thread_id, sparseArray11.get(n.g.tag_user_mute_thread_id));
                                                    sparseArray12.put(n.g.tag_del_post_is_self, sparseArray11.get(n.g.tag_del_post_is_self));
                                                    sparseArray12.put(n.g.tag_del_post_type, sparseArray11.get(n.g.tag_del_post_type));
                                                    sparseArray12.put(n.g.tag_del_post_id, sparseArray11.get(n.g.tag_del_post_id));
                                                    sparseArray12.put(n.g.tag_manage_user_identity, sparseArray11.get(n.g.tag_manage_user_identity));
                                                    cmVar26 = this.cFS.cFu;
                                                    cmVar26.amh().setTag(sparseArray12);
                                                    cmVar27 = this.cFS.cFu;
                                                    cmVar27.amh().setVisibility(0);
                                                    cmVar28 = this.cFS.cFu;
                                                    cmVar28.amg().setVisibility(8);
                                                    cmVar29 = this.cFS.cFu;
                                                    cmVar29.amh().setText(n.j.mute_option);
                                                } else {
                                                    if (!(sparseArray11.get(n.g.tag_del_post_is_self) instanceof Boolean)) {
                                                        z4 = false;
                                                    } else {
                                                        z4 = ((Boolean) sparseArray11.get(n.g.tag_del_post_is_self)).booleanValue();
                                                    }
                                                    String str8 = null;
                                                    if (sparseArray11.get(n.g.tag_forbid_user_post_id) instanceof String) {
                                                        str8 = (String) sparseArray11.get(n.g.tag_forbid_user_post_id);
                                                    }
                                                    eX = this.cFS.eX(z4);
                                                    boolean isLogin = eX & this.cFS.isLogin();
                                                    this.cFS.cFO = (com.baidu.tieba.tbadkCore.data.r) sparseArray11.get(n.g.tag_clip_board);
                                                    if (dj.e(this.cFS.cFO) ? false : isLogin) {
                                                        cmVar21 = this.cFS.cFu;
                                                        cmVar21.amh().setVisibility(0);
                                                        cmVar22 = this.cFS.cFu;
                                                        cmVar22.amh().setTag(str8);
                                                    } else {
                                                        cmVar20 = this.cFS.cFu;
                                                        cmVar20.amh().setVisibility(8);
                                                    }
                                                }
                                                SparseArray sparseArray13 = (SparseArray) view.getTag();
                                                boolean z6 = false;
                                                long j2 = 0;
                                                if (sparseArray13.get(n.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                                                    z6 = ((Boolean) sparseArray13.get(n.g.tag_should_hide_chudian_visible)).booleanValue();
                                                }
                                                if (sparseArray13.get(n.g.tag_chudian_template_id) instanceof Long) {
                                                    j2 = ((Long) sparseArray13.get(n.g.tag_chudian_template_id)).longValue();
                                                }
                                                if (z6) {
                                                    cmVar24 = this.cFS.cFu;
                                                    cmVar24.amj().setVisibility(0);
                                                    cmVar25 = this.cFS.cFu;
                                                    cmVar25.amj().setTag(n.g.tag_chudian_template_id, Long.valueOf(j2));
                                                } else {
                                                    cmVar23 = this.cFS.cFu;
                                                    cmVar23.amj().setVisibility(8);
                                                }
                                            }
                                            cfVar35 = this.cFS.cFl;
                                            if (cfVar35.getPbData().pN()) {
                                                cfVar36 = this.cFS.cFl;
                                                String pM = cfVar36.getPbData().pM();
                                                if (rVar3 != null && !com.baidu.adp.lib.util.j.isEmpty(pM) && pM.equals(rVar3.getId())) {
                                                    z = true;
                                                    if (!z) {
                                                        cmVar11 = this.cFS.cFu;
                                                        cmVar11.amf().setText(n.j.remove_mark);
                                                    } else {
                                                        cmVar8 = this.cFS.cFu;
                                                        cmVar8.amf().setText(n.j.mark);
                                                    }
                                                    cmVar9 = this.cFS.cFu;
                                                    cmVar9.fh(true);
                                                    cmVar10 = this.cFS.cFu;
                                                    cmVar10.NI();
                                                    return;
                                                }
                                            }
                                            z = false;
                                            if (!z) {
                                            }
                                            cmVar9 = this.cFS.cFu;
                                            cmVar9.fh(true);
                                            cmVar10 = this.cFS.cFu;
                                            cmVar10.NI();
                                            return;
                                        } else if (id2 != n.g.pb_head_reverse_hint) {
                                            if (id2 == n.g.pb_act_btn) {
                                                cfVar28 = this.cFS.cFl;
                                                if (cfVar28.getPbData() != null) {
                                                    cfVar29 = this.cFS.cFl;
                                                    if (cfVar29.getPbData().akH() != null) {
                                                        cfVar30 = this.cFS.cFl;
                                                        if (cfVar30.getPbData().akH().sK() != null) {
                                                            Activity activity = this.cFS.getActivity();
                                                            cfVar31 = this.cFS.cFl;
                                                            com.baidu.tbadk.browser.f.B(activity, cfVar31.getPbData().akH().sK());
                                                            cfVar32 = this.cFS.cFl;
                                                            if (cfVar32.getPbData().akH().sI() != 1) {
                                                                cfVar33 = this.cFS.cFl;
                                                                if (cfVar33.getPbData().akH().sI() == 2) {
                                                                    TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id2 == n.g.pb_item_tail_content) {
                                                String string = TbadkCoreApplication.m411getInst().getString(n.j.tail_web_view_title);
                                                String string2 = com.baidu.tbadk.core.sharedPref.b.tJ().getString("tail_link", "");
                                                if (!StringUtils.isNull(string2)) {
                                                    TiebaStatic.log("c10056");
                                                    com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                    return;
                                                }
                                                return;
                                            } else if (id2 == n.g.join_vote_tv) {
                                                if (view != null) {
                                                    com.baidu.tbadk.browser.f.B(this.cFS.getActivity(), (String) view.getTag());
                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                    all3 = this.cFS.all();
                                                    if (all3 == 1) {
                                                        cfVar24 = this.cFS.cFl;
                                                        if (cfVar24 != null) {
                                                            cfVar25 = this.cFS.cFl;
                                                            if (cfVar25.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10397");
                                                                cfVar26 = this.cFS.cFl;
                                                                com.baidu.tbadk.core.util.av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cfVar26.getPbData().getForumId());
                                                                cfVar27 = this.cFS.cFl;
                                                                TiebaStatic.log(aa.aa("tid", cfVar27.getPbData().getThreadId()).aa("uid", currentAccount));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    all4 = this.cFS.all();
                                                    if (all4 == 2) {
                                                        cfVar20 = this.cFS.cFl;
                                                        if (cfVar20 != null) {
                                                            cfVar21 = this.cFS.cFl;
                                                            if (cfVar21.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c10401");
                                                                cfVar22 = this.cFS.cFl;
                                                                com.baidu.tbadk.core.util.av aa2 = avVar2.aa(ImageViewerConfig.FORUM_ID, cfVar22.getPbData().getForumId());
                                                                cfVar23 = this.cFS.cFl;
                                                                TiebaStatic.log(aa2.aa("tid", cfVar23.getPbData().getThreadId()).aa("uid", currentAccount));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id2 == n.g.look_all_tv && view != null) {
                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                com.baidu.tbadk.browser.f.B(this.cFS.getActivity(), (String) view.getTag());
                                                all = this.cFS.all();
                                                if (all == 1) {
                                                    cfVar16 = this.cFS.cFl;
                                                    if (cfVar16 != null) {
                                                        cfVar17 = this.cFS.cFl;
                                                        if (cfVar17.getPbData() != null) {
                                                            com.baidu.tbadk.core.util.av avVar3 = new com.baidu.tbadk.core.util.av("c10507");
                                                            cfVar18 = this.cFS.cFl;
                                                            com.baidu.tbadk.core.util.av aa3 = avVar3.aa(ImageViewerConfig.FORUM_ID, cfVar18.getPbData().getForumId());
                                                            cfVar19 = this.cFS.cFl;
                                                            TiebaStatic.log(aa3.aa("tid", cfVar19.getPbData().getThreadId()).aa("uid", currentAccount2));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                all2 = this.cFS.all();
                                                if (all2 == 2) {
                                                    cfVar12 = this.cFS.cFl;
                                                    if (cfVar12 != null) {
                                                        cfVar13 = this.cFS.cFl;
                                                        if (cfVar13.getPbData() != null) {
                                                            com.baidu.tbadk.core.util.av avVar4 = new com.baidu.tbadk.core.util.av("c10508");
                                                            cfVar14 = this.cFS.cFl;
                                                            com.baidu.tbadk.core.util.av aa4 = avVar4.aa(ImageViewerConfig.FORUM_ID, cfVar14.getPbData().getForumId());
                                                            cfVar15 = this.cFS.cFl;
                                                            TiebaStatic.log(aa4.aa("tid", cfVar15.getPbData().getThreadId()).aa("uid", currentAccount2));
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
                                            this.cFS.stopVoice();
                                            dkVar31 = this.cFS.cFq;
                                            dkVar31.ana();
                                            dkVar32 = this.cFS.cFq;
                                            dkVar32.amJ();
                                            cfVar34 = this.cFS.cFl;
                                            cfVar34.alV();
                                            return;
                                        }
                                    }
                                } else if (this.cFS.checkUpIsLogin()) {
                                    this.cFS.alg();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            cfVar60 = this.cFS.cFl;
                            String name = cfVar60.getPbData().akG().getName();
                            cfVar61 = this.cFS.cFl;
                            if (!TextUtils.isEmpty(cfVar61.alL())) {
                                cfVar62 = this.cFS.cFl;
                                if (cfVar62.alL().equals(name)) {
                                    this.cFS.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.ax.aR(name)) {
                                this.cFS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cFS.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        dkVar5 = this.cFS.cFq;
        dkVar5.anb();
        cfVar = this.cFS.cFl;
        if (cfVar.getPbData().akL() == 1) {
            aVar = this.cFS.cFn;
            if (!aVar.aGg()) {
                dkVar6 = this.cFS.cFq;
                dkVar6.amG();
                int i3 = 0;
                dkVar7 = this.cFS.cFq;
                if (view != dkVar7.amV()) {
                    dkVar8 = this.cFS.cFq;
                    if (view != dkVar8.amW()) {
                        dkVar9 = this.cFS.cFq;
                        if (view != dkVar9.amX()) {
                            dkVar10 = this.cFS.cFq;
                            if (view != dkVar10.amY()) {
                                dkVar11 = this.cFS.cFq;
                                if (view == dkVar11.amH()) {
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
                cfVar2 = this.cFS.cFl;
                ForumData akG2 = cfVar2.getPbData().akG();
                String name2 = akG2.getName();
                String id3 = akG2.getId();
                cfVar3 = this.cFS.cFl;
                String id4 = cfVar3.getPbData().akH().getId();
                aVar2 = this.cFS.cFn;
                dkVar12 = this.cFS.cFq;
                aVar2.b(id3, name2, id4, i3, dkVar12.amI());
            }
        }
    }
}
