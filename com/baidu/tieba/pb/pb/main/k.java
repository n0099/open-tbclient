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
class k implements View.OnClickListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v114, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0ec0  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x1049  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        da daVar;
        da daVar2;
        da daVar3;
        da daVar4;
        da daVar5;
        cc ccVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        da daVar6;
        da daVar7;
        da daVar8;
        da daVar9;
        da daVar10;
        da daVar11;
        cc ccVar2;
        cc ccVar3;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        da daVar12;
        da daVar13;
        da daVar14;
        da daVar15;
        da daVar16;
        da daVar17;
        da daVar18;
        da daVar19;
        da daVar20;
        da daVar21;
        da daVar22;
        da daVar23;
        da daVar24;
        da daVar25;
        da daVar26;
        da daVar27;
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        da daVar28;
        ci ciVar4;
        cc ccVar4;
        da daVar29;
        cc ccVar5;
        cc ccVar6;
        da daVar30;
        cc ccVar7;
        cc ccVar8;
        cc ccVar9;
        cc ccVar10;
        cc ccVar11;
        int ake;
        int ake2;
        cc ccVar12;
        cc ccVar13;
        cc ccVar14;
        cc ccVar15;
        cc ccVar16;
        cc ccVar17;
        cc ccVar18;
        cc ccVar19;
        int ake3;
        int ake4;
        cc ccVar20;
        cc ccVar21;
        cc ccVar22;
        cc ccVar23;
        cc ccVar24;
        cc ccVar25;
        cc ccVar26;
        cc ccVar27;
        cc ccVar28;
        cc ccVar29;
        cc ccVar30;
        cc ccVar31;
        cc ccVar32;
        cc ccVar33;
        da daVar31;
        da daVar32;
        cc ccVar34;
        ci ciVar5;
        ci ciVar6;
        cc ccVar35;
        boolean z;
        ci ciVar7;
        ci ciVar8;
        ci ciVar9;
        ci ciVar10;
        cc ccVar36;
        ci ciVar11;
        boolean z2;
        ci ciVar12;
        ci ciVar13;
        ci ciVar14;
        ci ciVar15;
        ci ciVar16;
        ci ciVar17;
        ci ciVar18;
        boolean z3;
        String str;
        boolean eY;
        ci ciVar19;
        ci ciVar20;
        ci ciVar21;
        ci ciVar22;
        ci ciVar23;
        ci ciVar24;
        ci ciVar25;
        ci ciVar26;
        ci ciVar27;
        ci ciVar28;
        ci ciVar29;
        ci ciVar30;
        ci ciVar31;
        com.baidu.tbadk.core.data.ad adVar;
        da daVar33;
        da daVar34;
        ci ciVar32;
        da daVar35;
        da daVar36;
        ci ciVar33;
        da daVar37;
        ci ciVar34;
        ci ciVar35;
        da daVar38;
        da daVar39;
        da daVar40;
        cc ccVar37;
        da daVar41;
        da daVar42;
        cc ccVar38;
        cc ccVar39;
        cc ccVar40;
        da daVar43;
        cc ccVar41;
        cc ccVar42;
        cc ccVar43;
        da daVar44;
        da daVar45;
        da daVar46;
        cc ccVar44;
        da daVar47;
        da daVar48;
        cc ccVar45;
        da daVar49;
        cc ccVar46;
        da daVar50;
        da daVar51;
        da daVar52;
        da daVar53;
        boolean jQ;
        cc ccVar47;
        da daVar54;
        cc ccVar48;
        cc ccVar49;
        cc ccVar50;
        cc ccVar51;
        cc ccVar52;
        cc ccVar53;
        boolean z4;
        da daVar55;
        da daVar56;
        da daVar57;
        cc ccVar54;
        String akr;
        cc ccVar55;
        cc ccVar56;
        cc ccVar57;
        cc ccVar58;
        da daVar58;
        cc ccVar59;
        cc ccVar60;
        cc ccVar61;
        cc ccVar62;
        cc ccVar63;
        da daVar59;
        cc ccVar64;
        da daVar60;
        da daVar61;
        da daVar62;
        cc ccVar65;
        cc ccVar66;
        da daVar63;
        daVar = this.cCm.cBL;
        if (view == daVar.getNextView()) {
            ccVar66 = this.cCm.cBG;
            if (ccVar66.fd(true)) {
                daVar63 = this.cCm.cBL;
                daVar63.alz();
                return;
            }
            return;
        }
        daVar2 = this.cCm.cBL;
        if (view == daVar2.alT()) {
            daVar60 = this.cCm.cBL;
            daVar60.alO();
            this.cCm.stopVoice();
            daVar61 = this.cCm.cBL;
            daVar61.alx();
            daVar62 = this.cCm.cBL;
            daVar62.acC();
            ccVar65 = this.cCm.cBG;
            ccVar65.jT(1);
            return;
        }
        daVar3 = this.cCm.cBL;
        if (view == daVar3.cEm.azZ) {
            daVar59 = this.cCm.cBL;
            ccVar64 = this.cCm.cBG;
            if (!daVar59.ft(ccVar64.akJ())) {
                this.cCm.finish();
                return;
            } else {
                this.cCm.stopVoice();
                return;
            }
        }
        daVar4 = this.cCm.cBL;
        if (view != daVar4.alJ()) {
            daVar13 = this.cCm.cBL;
            if (view != daVar13.alK()) {
                daVar14 = this.cCm.cBL;
                if (view != daVar14.alL()) {
                    daVar15 = this.cCm.cBL;
                    if (view != daVar15.alM()) {
                        daVar16 = this.cCm.cBL;
                        if (view != daVar16.alv()) {
                            daVar17 = this.cCm.cBL;
                            if (view == daVar17.alQ()) {
                                ccVar62 = this.cCm.cBG;
                                if (ccVar62 != null) {
                                    ccVar63 = this.cCm.cBG;
                                    com.baidu.tbadk.browser.f.B(this.cCm.getPageContext().getPageActivity(), ccVar63.getPbData().ajz().sK().getLink());
                                    return;
                                }
                                return;
                            }
                            daVar18 = this.cCm.cBL;
                            if (view != daVar18.cEm.cGu) {
                                daVar19 = this.cCm.cBL;
                                if (view == daVar19.cEm.cGw) {
                                    ccVar55 = this.cCm.cBG;
                                    if (ccVar55 != null) {
                                        ccVar56 = this.cCm.cBG;
                                        if (ccVar56.getPbData() != null) {
                                            ccVar57 = this.cCm.cBG;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = ccVar57.getPbData().ajA();
                                            if (ajA == null || ajA.size() <= 0) {
                                                ccVar58 = this.cCm.cBG;
                                                if (ccVar58.akF()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.cCm.getPageContext().getPageActivity(), this.cCm.getPageContext().getString(n.i.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            daVar58 = this.cCm.cBL;
                                            daVar58.aln();
                                            this.cCm.akf();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.cCm.getPageContext().getPageActivity(), this.cCm.getPageContext().getString(n.i.pb_no_data_tips));
                                    return;
                                }
                                daVar20 = this.cCm.cBL;
                                if (view == daVar20.cEm.cGv) {
                                    z4 = this.cCm.mIsLoading;
                                    if (!z4) {
                                        this.cCm.mIsLoading = true;
                                        daVar55 = this.cCm.cBL;
                                        daVar55.cEm.cGv.setEnabled(false);
                                        daVar56 = this.cCm.cBL;
                                        daVar56.YT();
                                        this.cCm.stopVoice();
                                        daVar57 = this.cCm.cBL;
                                        daVar57.alx();
                                        ccVar54 = this.cCm.cBG;
                                        akr = this.cCm.akr();
                                        ccVar54.kH(akr);
                                        TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                daVar21 = this.cCm.cBL;
                                if (view == daVar21.cEm.cGx) {
                                    ccVar48 = this.cCm.cBG;
                                    AdditionData ajG = ccVar48.getPbData().ajG();
                                    if (!TextUtils.isEmpty(ajG.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.cCm.getPageContext().getPageActivity(), ajG.getWarnMsg());
                                        return;
                                    } else if (ajG.getAlreadyCount() != ajG.getTotalCount()) {
                                        ccVar49 = this.cCm.cBG;
                                        ForumData ajy = ccVar49.getPbData().ajy();
                                        ccVar50 = this.cCm.cBG;
                                        com.baidu.tbadk.core.data.z ajz = ccVar50.getPbData().ajz();
                                        ccVar51 = this.cCm.cBG;
                                        AntiData rZ = ccVar51.getPbData().rZ();
                                        if (ajz.getId() != null) {
                                            if (rZ != null && rZ.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.cCm.getPageContext().getPageActivity(), rZ.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            ccVar52 = this.cCm.cBG;
                                            if (ccVar52.getPbData().getUserData() != null) {
                                                ccVar53 = this.cCm.cBG;
                                                i = ccVar53.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.cCm.getPageContext().getPageActivity(), 2, ajy.getId(), ajy.getName(), ajz.getId(), ajG.getPostId(), 0, rZ, 13008, false, false, null, false, false, null, ajG, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.cCm.getPageContext().getPageActivity(), String.format(this.cCm.getPageContext().getString(n.i.write_addition_limit), Integer.valueOf(ajG.getTotalCount())));
                                        return;
                                    }
                                }
                                daVar22 = this.cCm.cBL;
                                if (daVar22.cEm.amc() != null) {
                                    daVar52 = this.cCm.cBL;
                                    if (view == daVar52.cEm.amc().akU()) {
                                        daVar53 = this.cCm.cBL;
                                        daVar53.alO();
                                        jQ = this.cCm.jQ(11009);
                                        if (jQ) {
                                            ccVar47 = this.cCm.cBG;
                                            daVar54 = this.cCm.cBL;
                                            if (ccVar47.jZ(daVar54.alD()) == null) {
                                                return;
                                            }
                                            this.cCm.akj();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                daVar23 = this.cCm.cBL;
                                if (daVar23.cEm.amc() != null) {
                                    daVar50 = this.cCm.cBL;
                                    if (view == daVar50.cEm.amc().akY()) {
                                        daVar51 = this.cCm.cBL;
                                        daVar51.alO();
                                        this.cCm.stopVoice();
                                        this.cCm.showShareDialog();
                                        return;
                                    }
                                }
                                daVar24 = this.cCm.cBL;
                                if (daVar24.cEm.amc() != null) {
                                    daVar47 = this.cCm.cBL;
                                    if (view == daVar47.cEm.amc().ala()) {
                                        daVar48 = this.cCm.cBL;
                                        daVar48.alO();
                                        ccVar45 = this.cCm.cBG;
                                        if (ccVar45.Uy() != null) {
                                            daVar49 = this.cCm.cBL;
                                            ccVar46 = this.cCm.cBG;
                                            daVar49.a(ccVar46.Uy(), this.cCm.cuh);
                                        }
                                        TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                daVar25 = this.cCm.cBL;
                                if (daVar25.cEm.amc() != null) {
                                    daVar44 = this.cCm.cBL;
                                    if (view == daVar44.cEm.amc().alb()) {
                                        daVar45 = this.cCm.cBL;
                                        daVar45.alO();
                                        this.cCm.stopVoice();
                                        daVar46 = this.cCm.cBL;
                                        daVar46.alx();
                                        ccVar44 = this.cCm.cBG;
                                        ccVar44.akO();
                                        TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                daVar26 = this.cCm.cBL;
                                if (daVar26.cEm.amc() != null) {
                                    daVar42 = this.cCm.cBL;
                                    if (view == daVar42.cEm.amc().alc()) {
                                        ccVar38 = this.cCm.cBG;
                                        if (ccVar38 != null) {
                                            ccVar39 = this.cCm.cBG;
                                            if (ccVar39.getPbData() != null) {
                                                ccVar40 = this.cCm.cBG;
                                                if (ccVar40.getPbData().ajz() != null) {
                                                    daVar43 = this.cCm.cBL;
                                                    daVar43.cEm.qE();
                                                    ccVar41 = this.cCm.cBG;
                                                    if (ccVar41.getPbData().ajA() != null) {
                                                        ccVar42 = this.cCm.cBG;
                                                        if (ccVar42.getPbData().ajA().size() > 0) {
                                                            PbActivity pbActivity = this.cCm;
                                                            ccVar43 = this.cCm.cBG;
                                                            pbActivity.kz(ccVar43.getPbData().ajA().get(0).getId());
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
                                daVar27 = this.cCm.cBL;
                                if (daVar27.cEm.amc() != null) {
                                    daVar38 = this.cCm.cBL;
                                    if (view == daVar38.cEm.amc().ald()) {
                                        TiebaStatic.log("c10414");
                                        daVar39 = this.cCm.cBL;
                                        daVar39.alO();
                                        daVar40 = this.cCm.cBL;
                                        if (daVar40.sG() != da.cFJ) {
                                            ccVar37 = this.cCm.cBG;
                                            ccVar37.ka(cc.cDA);
                                            return;
                                        }
                                        daVar41 = this.cCm.cBL;
                                        daVar41.alY();
                                        return;
                                    }
                                }
                                ciVar = this.cCm.cBP;
                                if (ciVar != null) {
                                    ciVar35 = this.cCm.cBP;
                                    if (view == ciVar35.akW()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(n.f.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray.put(n.f.tag_from, 0);
                                                    sparseArray.put(n.f.tag_check_mute_from, 2);
                                                    this.cCm.d(sparseArray);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        this.cCm.kz((String) tag);
                                        return;
                                    }
                                }
                                ciVar2 = this.cCm.cBP;
                                if (ciVar2 != null) {
                                    ciVar34 = this.cCm.cBP;
                                    if (view == ciVar34.akU()) {
                                        if (!this.cCm.checkUpIsLogin()) {
                                            return;
                                        }
                                        this.cCm.ad(view);
                                        return;
                                    }
                                }
                                ciVar3 = this.cCm.cBP;
                                if (ciVar3 != null) {
                                    ciVar33 = this.cCm.cBP;
                                    if (view == ciVar33.akX()) {
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2 != null && (sparseArray2.get(n.f.tag_del_post_type) instanceof Integer) && (sparseArray2.get(n.f.tag_del_post_id) instanceof String) && (sparseArray2.get(n.f.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(n.f.tag_del_post_is_self) instanceof Boolean)) {
                                            daVar37 = this.cCm.cBL;
                                            daVar37.a(((Integer) sparseArray2.get(n.f.tag_del_post_type)).intValue(), (String) sparseArray2.get(n.f.tag_del_post_id), ((Integer) sparseArray2.get(n.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(n.f.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                daVar28 = this.cCm.cBL;
                                if (daVar28.alr() != view) {
                                    ciVar4 = this.cCm.cBP;
                                    if (ciVar4 != null) {
                                        ciVar32 = this.cCm.cBP;
                                        if (view == ciVar32.akV()) {
                                            SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                                            if (sparseArray3 != null) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(n.f.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(n.f.tag_should_delete_visible)).booleanValue();
                                                boolean booleanValue3 = ((Boolean) sparseArray3.get(n.f.tag_user_mute_visible)).booleanValue();
                                                if (booleanValue) {
                                                    if (booleanValue3) {
                                                        sparseArray3.put(n.f.tag_from, 1);
                                                        sparseArray3.put(n.f.tag_check_mute_from, 2);
                                                        this.cCm.d(sparseArray3);
                                                        return;
                                                    }
                                                    sparseArray3.put(n.f.tag_check_mute_from, 2);
                                                    daVar36 = this.cCm.cBL;
                                                    daVar36.ak(view);
                                                    return;
                                                } else if (booleanValue2) {
                                                    daVar35 = this.cCm.cBL;
                                                    daVar35.a(((Integer) sparseArray3.get(n.f.tag_del_post_type)).intValue(), (String) sparseArray3.get(n.f.tag_del_post_id), ((Integer) sparseArray3.get(n.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(n.f.tag_del_post_is_self)).booleanValue());
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() == n.f.pb_head_function_manage_delormanage) {
                                        SparseArray sparseArray4 = (SparseArray) view.getTag();
                                        if (((Boolean) sparseArray4.get(n.f.tag_should_manage_visible)).booleanValue()) {
                                            daVar34 = this.cCm.cBL;
                                            daVar34.ak(view);
                                            return;
                                        }
                                        daVar33 = this.cCm.cBL;
                                        daVar33.a(((Integer) sparseArray4.get(n.f.tag_del_post_type)).intValue(), (String) sparseArray4.get(n.f.tag_del_post_id), ((Integer) sparseArray4.get(n.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(n.f.tag_del_post_is_self)).booleanValue());
                                        return;
                                    } else if (view.getId() == n.f.replybtn || view.getId() == n.f.sub_pb_more || view.getId() == n.f.sub_pb_item) {
                                        if (this.cCm.checkUpIsLogin()) {
                                            ccVar4 = this.cCm.cBG;
                                            if (ccVar4.getPbData() != null) {
                                                daVar29 = this.cCm.cBL;
                                                daVar29.alO();
                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) sparseArray5.get(n.f.tag_load_sub_data);
                                                View view2 = (View) sparseArray5.get(n.f.tag_load_sub_view);
                                                if (oVar != null && view2 != null) {
                                                    ccVar5 = this.cCm.cBG;
                                                    String threadID = ccVar5.getThreadID();
                                                    String id = oVar.getId();
                                                    int i2 = 0;
                                                    ccVar6 = this.cCm.cBG;
                                                    if (ccVar6.getPbData() != null) {
                                                        ccVar10 = this.cCm.cBG;
                                                        i2 = ccVar10.getPbData().ajD();
                                                    }
                                                    this.cCm.stopVoice();
                                                    if (view.getId() == n.f.replybtn) {
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.cCm.getPageContext().getPageActivity());
                                                        SmallTailInfo amT = oVar.amT();
                                                        ccVar9 = this.cCm.cBG;
                                                        this.cCm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id, "pb", true, null, true, null, i2, amT, ccVar9.getPbData().rZ(), false)));
                                                        return;
                                                    } else if (view.getId() == n.f.sub_pb_item) {
                                                        SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                        String str2 = (String) sparseArray6.get(n.f.tag_photo_username);
                                                        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) sparseArray6.get(n.f.tag_clip_board);
                                                        String str3 = null;
                                                        if (oVar2 != null) {
                                                            str3 = oVar2.getId();
                                                        }
                                                        TiebaStatic.log("c10088");
                                                        SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.cCm.getPageContext().getPageActivity());
                                                        SmallTailInfo amT2 = oVar.amT();
                                                        ccVar8 = this.cCm.cBG;
                                                        this.cCm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id, "pb", true, str2, true, str3, i2, amT2, ccVar8.getPbData().rZ(), false)));
                                                        return;
                                                    } else if (oVar.aDl()) {
                                                        TiebaStatic.log("c10089");
                                                        SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.cCm.getPageContext().getPageActivity());
                                                        SmallTailInfo amT3 = oVar.amT();
                                                        ccVar7 = this.cCm.cBG;
                                                        this.cCm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i2, amT3, ccVar7.getPbData().rZ(), false)));
                                                        return;
                                                    } else {
                                                        oVar.hk(true);
                                                        daVar30 = this.cCm.cBL;
                                                        daVar30.als().notifyDataSetChanged();
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        com.baidu.tbadk.core.util.av r = new com.baidu.tbadk.core.util.av("c10517").r("obj_locate", 3);
                                        ccVar11 = this.cCm.cBG;
                                        TiebaStatic.log(r.ab(ImageViewerConfig.FORUM_ID, ccVar11.getPbData().getForumId()));
                                        return;
                                    } else {
                                        int id2 = view.getId();
                                        if (id2 == n.f.pb_u9_text_view) {
                                            if (this.cCm.checkUpIsLogin() && (adVar = (com.baidu.tbadk.core.data.ad) view.getTag()) != null && !StringUtils.isNull(adVar.tr())) {
                                                TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                com.baidu.tbadk.core.util.bf.vD().b(this.cCm.getPageContext(), new String[]{adVar.tr()});
                                                return;
                                            }
                                            return;
                                        } else if (id2 == n.f.reply) {
                                            ciVar5 = this.cCm.cBP;
                                            if (ciVar5 == null) {
                                                this.cCm.akc();
                                            }
                                            ciVar6 = this.cCm.cBP;
                                            ciVar6.showDialog();
                                            com.baidu.tieba.tbadkCore.data.o oVar3 = null;
                                            if (view != null && view.getTag() != null) {
                                                oVar3 = (com.baidu.tieba.tbadkCore.data.o) ((SparseArray) view.getTag()).get(n.f.tag_load_sub_data);
                                                SparseArray sparseArray7 = new SparseArray();
                                                sparseArray7.put(n.f.tag_clip_board, (com.baidu.tieba.tbadkCore.data.o) ((SparseArray) view.getTag()).get(n.f.tag_clip_board));
                                                sparseArray7.put(n.f.tag_is_subpb, false);
                                                ciVar11 = this.cCm.cBP;
                                                ciVar11.akU().setTag(sparseArray7);
                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                boolean booleanValue4 = ((Boolean) sparseArray8.get(n.f.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue5 = ((Boolean) sparseArray8.get(n.f.tag_user_mute_visible)).booleanValue();
                                                boolean booleanValue6 = ((Boolean) sparseArray8.get(n.f.tag_should_delete_visible)).booleanValue();
                                                if (!(sparseArray8.get(n.f.tag_del_post_is_self) instanceof Boolean)) {
                                                    z2 = false;
                                                } else {
                                                    z2 = ((Boolean) sparseArray8.get(n.f.tag_del_post_is_self)).booleanValue();
                                                }
                                                String str4 = null;
                                                if (sparseArray8.get(n.f.tag_forbid_user_post_id) instanceof String) {
                                                    str4 = (String) sparseArray8.get(n.f.tag_forbid_user_post_id);
                                                }
                                                if (booleanValue4) {
                                                    SparseArray sparseArray9 = new SparseArray();
                                                    sparseArray9.put(n.f.tag_should_manage_visible, true);
                                                    sparseArray9.put(n.f.tag_manage_user_identity, sparseArray8.get(n.f.tag_manage_user_identity));
                                                    sparseArray9.put(n.f.tag_forbid_user_name, sparseArray8.get(n.f.tag_forbid_user_name));
                                                    sparseArray9.put(n.f.tag_forbid_user_post_id, str4);
                                                    if (booleanValue5) {
                                                        sparseArray9.put(n.f.tag_user_mute_visible, true);
                                                        sparseArray9.put(n.f.tag_is_mem, sparseArray8.get(n.f.tag_is_mem));
                                                        sparseArray9.put(n.f.tag_user_mute_mute_userid, sparseArray8.get(n.f.tag_user_mute_mute_userid));
                                                        sparseArray9.put(n.f.tag_user_mute_mute_username, sparseArray8.get(n.f.tag_user_mute_mute_username));
                                                        sparseArray9.put(n.f.tag_user_mute_post_id, sparseArray8.get(n.f.tag_user_mute_post_id));
                                                        sparseArray9.put(n.f.tag_user_mute_thread_id, sparseArray8.get(n.f.tag_user_mute_thread_id));
                                                    } else {
                                                        sparseArray9.put(n.f.tag_user_mute_visible, false);
                                                    }
                                                    if (booleanValue6) {
                                                        sparseArray9.put(n.f.tag_should_delete_visible, true);
                                                        sparseArray9.put(n.f.tag_del_post_is_self, Boolean.valueOf(z2));
                                                        sparseArray9.put(n.f.tag_del_post_id, sparseArray8.get(n.f.tag_del_post_id));
                                                        sparseArray9.put(n.f.tag_del_post_type, sparseArray8.get(n.f.tag_del_post_type));
                                                        ciVar31 = this.cCm.cBP;
                                                        ciVar31.akX().setVisibility(0);
                                                    } else {
                                                        sparseArray9.put(n.f.tag_should_delete_visible, false);
                                                        ciVar26 = this.cCm.cBP;
                                                        ciVar26.akX().setVisibility(8);
                                                    }
                                                    ciVar27 = this.cCm.cBP;
                                                    ciVar27.akV().setTag(sparseArray9);
                                                    ciVar28 = this.cCm.cBP;
                                                    ciVar28.akX().setTag(sparseArray9);
                                                    ciVar29 = this.cCm.cBP;
                                                    ciVar29.akV().setText(n.i.bar_manager);
                                                    ciVar30 = this.cCm.cBP;
                                                    ciVar30.akV().setVisibility(0);
                                                } else if (!booleanValue6) {
                                                    ciVar12 = this.cCm.cBP;
                                                    ciVar12.akV().setVisibility(8);
                                                    ciVar13 = this.cCm.cBP;
                                                    ciVar13.akX().setVisibility(8);
                                                } else {
                                                    SparseArray sparseArray10 = new SparseArray();
                                                    sparseArray10.put(n.f.tag_should_manage_visible, false);
                                                    sparseArray10.put(n.f.tag_user_mute_visible, false);
                                                    sparseArray10.put(n.f.tag_should_delete_visible, true);
                                                    sparseArray10.put(n.f.tag_manage_user_identity, sparseArray8.get(n.f.tag_manage_user_identity));
                                                    sparseArray10.put(n.f.tag_del_post_is_self, Boolean.valueOf(z2));
                                                    sparseArray10.put(n.f.tag_del_post_id, sparseArray8.get(n.f.tag_del_post_id));
                                                    sparseArray10.put(n.f.tag_del_post_type, sparseArray8.get(n.f.tag_del_post_type));
                                                    ciVar14 = this.cCm.cBP;
                                                    ciVar14.akV().setTag(sparseArray10);
                                                    ciVar15 = this.cCm.cBP;
                                                    ciVar15.akX().setTag(sparseArray10);
                                                    ciVar16 = this.cCm.cBP;
                                                    ciVar16.akV().setText(n.i.delete);
                                                    ciVar17 = this.cCm.cBP;
                                                    ciVar17.akX().setVisibility(0);
                                                    ciVar18 = this.cCm.cBP;
                                                    ciVar18.akV().setVisibility(8);
                                                }
                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                if (!(sparseArray11.get(n.f.tag_user_mute_visible) instanceof Boolean)) {
                                                    z3 = false;
                                                } else {
                                                    z3 = ((Boolean) sparseArray11.get(n.f.tag_user_mute_visible)).booleanValue();
                                                }
                                                if (!((Boolean) sparseArray11.get(n.f.tag_should_manage_visible)).booleanValue() && z3) {
                                                    SparseArray sparseArray12 = new SparseArray();
                                                    sparseArray12.put(n.f.tag_user_mute_visible, true);
                                                    sparseArray12.put(n.f.tag_is_mem, sparseArray11.get(n.f.tag_is_mem));
                                                    sparseArray12.put(n.f.tag_user_mute_mute_userid, sparseArray11.get(n.f.tag_user_mute_mute_userid));
                                                    sparseArray12.put(n.f.tag_user_mute_mute_username, sparseArray11.get(n.f.tag_user_mute_mute_username));
                                                    sparseArray12.put(n.f.tag_user_mute_post_id, sparseArray11.get(n.f.tag_user_mute_post_id));
                                                    sparseArray12.put(n.f.tag_user_mute_thread_id, sparseArray11.get(n.f.tag_user_mute_thread_id));
                                                    sparseArray12.put(n.f.tag_del_post_is_self, sparseArray11.get(n.f.tag_del_post_is_self));
                                                    sparseArray12.put(n.f.tag_del_post_type, sparseArray11.get(n.f.tag_del_post_type));
                                                    sparseArray12.put(n.f.tag_del_post_id, sparseArray11.get(n.f.tag_del_post_id));
                                                    sparseArray12.put(n.f.tag_manage_user_identity, sparseArray11.get(n.f.tag_manage_user_identity));
                                                    ciVar22 = this.cCm.cBP;
                                                    ciVar22.akW().setTag(sparseArray12);
                                                    ciVar23 = this.cCm.cBP;
                                                    ciVar23.akW().setVisibility(0);
                                                    ciVar24 = this.cCm.cBP;
                                                    ciVar24.akV().setVisibility(8);
                                                    ciVar25 = this.cCm.cBP;
                                                    ciVar25.akW().setText(n.i.mute_option);
                                                } else {
                                                    boolean z5 = false;
                                                    if (sparseArray11.get(n.f.tag_del_post_is_self) instanceof Boolean) {
                                                        z5 = ((Boolean) sparseArray11.get(n.f.tag_del_post_is_self)).booleanValue();
                                                    }
                                                    if (!(sparseArray11.get(n.f.tag_forbid_user_post_id) instanceof String)) {
                                                        str = null;
                                                    } else {
                                                        str = (String) sparseArray11.get(n.f.tag_forbid_user_post_id);
                                                    }
                                                    eY = this.cCm.eY(z5);
                                                    if (eY & this.cCm.isLogin()) {
                                                        ciVar20 = this.cCm.cBP;
                                                        ciVar20.akW().setVisibility(0);
                                                        ciVar21 = this.cCm.cBP;
                                                        ciVar21.akW().setTag(str);
                                                    } else {
                                                        ciVar19 = this.cCm.cBP;
                                                        ciVar19.akW().setVisibility(8);
                                                    }
                                                }
                                            }
                                            ccVar35 = this.cCm.cBG;
                                            if (ccVar35.getPbData().qp()) {
                                                ccVar36 = this.cCm.cBG;
                                                String qo = ccVar36.getPbData().qo();
                                                if (oVar3 != null && !com.baidu.adp.lib.util.j.isEmpty(qo) && qo.equals(oVar3.getId())) {
                                                    z = true;
                                                    if (!z) {
                                                        ciVar10 = this.cCm.cBP;
                                                        ciVar10.akU().setText(n.i.remove_mark);
                                                    } else {
                                                        ciVar7 = this.cCm.cBP;
                                                        ciVar7.akU().setText(n.i.mark);
                                                    }
                                                    ciVar8 = this.cCm.cBP;
                                                    ciVar8.fi(true);
                                                    ciVar9 = this.cCm.cBP;
                                                    ciVar9.Np();
                                                    return;
                                                }
                                            }
                                            z = false;
                                            if (!z) {
                                            }
                                            ciVar8 = this.cCm.cBP;
                                            ciVar8.fi(true);
                                            ciVar9 = this.cCm.cBP;
                                            ciVar9.Np();
                                            return;
                                        } else if (id2 != n.f.pb_head_reverse_hint) {
                                            if (id2 == n.f.pb_act_btn) {
                                                ccVar28 = this.cCm.cBG;
                                                if (ccVar28.getPbData() != null) {
                                                    ccVar29 = this.cCm.cBG;
                                                    if (ccVar29.getPbData().ajz() != null) {
                                                        ccVar30 = this.cCm.cBG;
                                                        if (ccVar30.getPbData().ajz().ta() != null) {
                                                            Activity activity = this.cCm.getActivity();
                                                            ccVar31 = this.cCm.cBG;
                                                            com.baidu.tbadk.browser.f.B(activity, ccVar31.getPbData().ajz().ta());
                                                            ccVar32 = this.cCm.cBG;
                                                            if (ccVar32.getPbData().ajz().sY() != 1) {
                                                                ccVar33 = this.cCm.cBG;
                                                                if (ccVar33.getPbData().ajz().sY() == 2) {
                                                                    TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id2 == n.f.pb_item_tail_content) {
                                                String string = TbadkCoreApplication.m411getInst().getString(n.i.tail_web_view_title);
                                                String string2 = com.baidu.tbadk.core.sharedPref.b.tZ().getString("tail_link", "");
                                                if (!StringUtils.isNull(string2)) {
                                                    TiebaStatic.log("c10056");
                                                    com.baidu.tbadk.browser.f.a(view.getContext(), string, string2, true, true, true);
                                                    return;
                                                }
                                                return;
                                            } else if (id2 == n.f.join_vote_tv) {
                                                if (view != null) {
                                                    com.baidu.tbadk.browser.f.B(this.cCm.getActivity(), (String) view.getTag());
                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                    ake3 = this.cCm.ake();
                                                    if (ake3 == 1) {
                                                        ccVar24 = this.cCm.cBG;
                                                        if (ccVar24 != null) {
                                                            ccVar25 = this.cCm.cBG;
                                                            if (ccVar25.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10397");
                                                                ccVar26 = this.cCm.cBG;
                                                                com.baidu.tbadk.core.util.av ab = avVar.ab(ImageViewerConfig.FORUM_ID, ccVar26.getPbData().getForumId());
                                                                ccVar27 = this.cCm.cBG;
                                                                TiebaStatic.log(ab.ab("tid", ccVar27.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    ake4 = this.cCm.ake();
                                                    if (ake4 == 2) {
                                                        ccVar20 = this.cCm.cBG;
                                                        if (ccVar20 != null) {
                                                            ccVar21 = this.cCm.cBG;
                                                            if (ccVar21.getPbData() != null) {
                                                                com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c10401");
                                                                ccVar22 = this.cCm.cBG;
                                                                com.baidu.tbadk.core.util.av ab2 = avVar2.ab(ImageViewerConfig.FORUM_ID, ccVar22.getPbData().getForumId());
                                                                ccVar23 = this.cCm.cBG;
                                                                TiebaStatic.log(ab2.ab("tid", ccVar23.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (id2 == n.f.look_all_tv && view != null) {
                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                com.baidu.tbadk.browser.f.B(this.cCm.getActivity(), (String) view.getTag());
                                                ake = this.cCm.ake();
                                                if (ake == 1) {
                                                    ccVar16 = this.cCm.cBG;
                                                    if (ccVar16 != null) {
                                                        ccVar17 = this.cCm.cBG;
                                                        if (ccVar17.getPbData() != null) {
                                                            com.baidu.tbadk.core.util.av avVar3 = new com.baidu.tbadk.core.util.av("c10507");
                                                            ccVar18 = this.cCm.cBG;
                                                            com.baidu.tbadk.core.util.av ab3 = avVar3.ab(ImageViewerConfig.FORUM_ID, ccVar18.getPbData().getForumId());
                                                            ccVar19 = this.cCm.cBG;
                                                            TiebaStatic.log(ab3.ab("tid", ccVar19.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                ake2 = this.cCm.ake();
                                                if (ake2 == 2) {
                                                    ccVar12 = this.cCm.cBG;
                                                    if (ccVar12 != null) {
                                                        ccVar13 = this.cCm.cBG;
                                                        if (ccVar13.getPbData() != null) {
                                                            com.baidu.tbadk.core.util.av avVar4 = new com.baidu.tbadk.core.util.av("c10508");
                                                            ccVar14 = this.cCm.cBG;
                                                            com.baidu.tbadk.core.util.av ab4 = avVar4.ab(ImageViewerConfig.FORUM_ID, ccVar14.getPbData().getForumId());
                                                            ccVar15 = this.cCm.cBG;
                                                            TiebaStatic.log(ab4.ab("tid", ccVar15.getPbData().getThreadId()).ab("uid", currentAccount2));
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
                                            this.cCm.stopVoice();
                                            daVar31 = this.cCm.cBL;
                                            daVar31.alO();
                                            daVar32 = this.cCm.cBL;
                                            daVar32.alx();
                                            ccVar34 = this.cCm.cBG;
                                            ccVar34.akO();
                                            return;
                                        }
                                    }
                                } else if (this.cCm.checkUpIsLogin()) {
                                    this.cCm.ajZ();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            ccVar59 = this.cCm.cBG;
                            String name = ccVar59.getPbData().ajy().getName();
                            ccVar60 = this.cCm.cBG;
                            if (!TextUtils.isEmpty(ccVar60.akE())) {
                                ccVar61 = this.cCm.cBG;
                                if (ccVar61.akE().equals(name)) {
                                    this.cCm.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.ax.aR(name)) {
                                this.cCm.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cCm.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        daVar5 = this.cCm.cBL;
        daVar5.alP();
        ccVar = this.cCm.cBG;
        if (ccVar.getPbData().ajD() == 1) {
            aVar = this.cCm.cBI;
            if (!aVar.aDT()) {
                daVar6 = this.cCm.cBL;
                daVar6.alu();
                int i3 = 0;
                daVar7 = this.cCm.cBL;
                if (view != daVar7.alJ()) {
                    daVar8 = this.cCm.cBL;
                    if (view != daVar8.alK()) {
                        daVar9 = this.cCm.cBL;
                        if (view != daVar9.alL()) {
                            daVar10 = this.cCm.cBL;
                            if (view != daVar10.alM()) {
                                daVar11 = this.cCm.cBL;
                                if (view == daVar11.alv()) {
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
                ccVar2 = this.cCm.cBG;
                ForumData ajy2 = ccVar2.getPbData().ajy();
                String name2 = ajy2.getName();
                String id3 = ajy2.getId();
                ccVar3 = this.cCm.cBG;
                String id4 = ccVar3.getPbData().ajz().getId();
                aVar2 = this.cCm.cBI;
                daVar12 = this.cCm.cBL;
                aVar2.b(id3, name2, id4, i3, daVar12.alw());
            }
        }
    }
}
