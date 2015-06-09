package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MorePopupWindow;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v32, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x08d1, code lost:
        if (r21 != r1.abQ()) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0b22, code lost:
        if (r1 == null) goto L312;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        ch chVar4;
        ch chVar5;
        bo boVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        ch chVar6;
        ch chVar7;
        ch chVar8;
        ch chVar9;
        ch chVar10;
        ch chVar11;
        bo boVar2;
        bo boVar3;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        ch chVar12;
        ch chVar13;
        ch chVar14;
        ch chVar15;
        ch chVar16;
        ch chVar17;
        ch chVar18;
        ch chVar19;
        ch chVar20;
        ch chVar21;
        ch chVar22;
        ch chVar23;
        ch chVar24;
        ch chVar25;
        ch chVar26;
        cf cfVar;
        cf cfVar2;
        ch chVar27;
        cf cfVar3;
        cf cfVar4;
        bo boVar4;
        bo boVar5;
        bo boVar6;
        bo boVar7;
        bo boVar8;
        bo boVar9;
        ch chVar28;
        ch chVar29;
        bo boVar10;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        bo boVar11;
        cf cfVar5;
        cf cfVar6;
        cf cfVar7;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        cf cfVar8;
        cf cfVar9;
        bo boVar12;
        cf cfVar10;
        cf cfVar11;
        boolean z;
        cf cfVar12;
        boolean dQ;
        cf cfVar13;
        cf cfVar14;
        cf cfVar15;
        cf cfVar16;
        cf cfVar17;
        cf cfVar18;
        cf cfVar19;
        MorePopupWindow morePopupWindow5;
        cf cfVar20;
        com.baidu.tbadk.core.data.aa aaVar;
        cf cfVar21;
        bo boVar13;
        ch chVar30;
        bo boVar14;
        bo boVar15;
        cf cfVar22;
        ch chVar31;
        cf cfVar23;
        MorePopupWindow morePopupWindow6;
        bo boVar16;
        cf cfVar24;
        cf cfVar25;
        MorePopupWindow morePopupWindow7;
        ch chVar32;
        MorePopupWindow morePopupWindow8;
        cf cfVar26;
        ch chVar33;
        ch chVar34;
        cf cfVar27;
        ch chVar35;
        MorePopupWindow morePopupWindow9;
        ch chVar36;
        cf cfVar28;
        MorePopupWindow morePopupWindow10;
        cf cfVar29;
        MorePopupWindow morePopupWindow11;
        ch chVar37;
        bo boVar17;
        bo boVar18;
        bo boVar19;
        ch chVar38;
        bo boVar20;
        bo boVar21;
        bo boVar22;
        ch chVar39;
        ch chVar40;
        ch chVar41;
        bo boVar23;
        ch chVar42;
        ch chVar43;
        bo boVar24;
        ch chVar44;
        bo boVar25;
        ch chVar45;
        ch chVar46;
        ch chVar47;
        ch chVar48;
        boolean hx;
        bo boVar26;
        ch chVar49;
        bo boVar27;
        bo boVar28;
        bo boVar29;
        bo boVar30;
        bo boVar31;
        bo boVar32;
        boolean z2;
        ch chVar50;
        ch chVar51;
        ch chVar52;
        bo boVar33;
        bo boVar34;
        bo boVar35;
        bo boVar36;
        bo boVar37;
        bo boVar38;
        bo boVar39;
        bo boVar40;
        bo boVar41;
        bo boVar42;
        ch chVar53;
        bo boVar43;
        ch chVar54;
        ch chVar55;
        ch chVar56;
        bo boVar44;
        bo boVar45;
        ch chVar57;
        chVar = this.bKU.bKA;
        if (view == chVar.getNextView()) {
            boVar45 = this.bKU.bKw;
            if (boVar45.dV(true)) {
                chVar57 = this.bKU.bKA;
                chVar57.ach();
                return;
            }
            return;
        }
        chVar2 = this.bKU.bKA;
        if (view == chVar2.acD()) {
            chVar54 = this.bKU.bKA;
            chVar54.acx();
            this.bKU.stopVoice();
            chVar55 = this.bKU.bKA;
            chVar55.acg();
            chVar56 = this.bKU.bKA;
            chVar56.WP();
            boVar44 = this.bKU.bKw;
            boVar44.hA(1);
            return;
        }
        chVar3 = this.bKU.bKA;
        if (view == chVar3.bNj.arG) {
            chVar53 = this.bKU.bKA;
            boVar43 = this.bKU.bKw;
            if (!chVar53.eh(boVar43.abt())) {
                this.bKU.finish();
                return;
            } else {
                this.bKU.stopVoice();
                return;
            }
        }
        chVar4 = this.bKU.bKA;
        if (view != chVar4.acs()) {
            chVar13 = this.bKU.bKA;
            if (view != chVar13.act()) {
                chVar14 = this.bKU.bKA;
                if (view != chVar14.acu()) {
                    chVar15 = this.bKU.bKA;
                    if (view != chVar15.acv()) {
                        chVar16 = this.bKU.bKA;
                        if (view != chVar16.ace()) {
                            chVar17 = this.bKU.bKA;
                            if (view == chVar17.acz()) {
                                boVar41 = this.bKU.bKw;
                                if (boVar41 != null) {
                                    boVar42 = this.bKU.bKw;
                                    com.baidu.tbadk.browser.f.x(this.bKU.getPageContext().getPageActivity(), boVar42.getPbData().aat().rj().getLink());
                                    return;
                                }
                                return;
                            }
                            chVar18 = this.bKU.bKA;
                            if (view != chVar18.bNj.bOP) {
                                chVar19 = this.bKU.bKA;
                                if (view == chVar19.bNj.bOR) {
                                    boVar34 = this.bKU.bKw;
                                    if (boVar34 != null) {
                                        boVar35 = this.bKU.bKw;
                                        if (boVar35.getPbData() != null) {
                                            boVar36 = this.bKU.bKw;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = boVar36.getPbData().aau();
                                            if (aau == null || aau.size() <= 0) {
                                                boVar37 = this.bKU.bKw;
                                                if (boVar37.abq()) {
                                                    com.baidu.adp.lib.util.n.showToast(this.bKU.getPageContext().getPageActivity(), this.bKU.getPageContext().getString(com.baidu.tieba.t.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            this.bKU.aaR();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.n.showToast(this.bKU.getPageContext().getPageActivity(), this.bKU.getPageContext().getString(com.baidu.tieba.t.pb_no_data_tips));
                                    return;
                                }
                                chVar20 = this.bKU.bKA;
                                if (view == chVar20.bNj.bOQ) {
                                    z2 = this.bKU.alI;
                                    if (!z2) {
                                        this.bKU.alI = true;
                                        chVar50 = this.bKU.bKA;
                                        chVar50.bNj.bOQ.setEnabled(false);
                                        chVar51 = this.bKU.bKA;
                                        chVar51.Te();
                                        this.bKU.stopVoice();
                                        chVar52 = this.bKU.bKA;
                                        chVar52.acg();
                                        boVar33 = this.bKU.bKw;
                                        boVar33.aby();
                                        TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                chVar21 = this.bKU.bKA;
                                if (view == chVar21.bNj.bOS) {
                                    boVar27 = this.bKU.bKw;
                                    AdditionData aay = boVar27.getPbData().aay();
                                    if (!TextUtils.isEmpty(aay.getWarnMsg())) {
                                        com.baidu.adp.lib.util.n.showToast(this.bKU.getPageContext().getPageActivity(), aay.getWarnMsg());
                                        return;
                                    } else if (aay.getAlreadyCount() != aay.getTotalCount()) {
                                        boVar28 = this.bKU.bKw;
                                        ForumData aas = boVar28.getPbData().aas();
                                        boVar29 = this.bKU.bKw;
                                        com.baidu.tbadk.core.data.w aat = boVar29.getPbData().aat();
                                        boVar30 = this.bKU.bKw;
                                        AntiData qK = boVar30.getPbData().qK();
                                        if (aat.getId() != null) {
                                            if (qK != null && qK.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.n.showToast(this.bKU.getPageContext().getPageActivity(), qK.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            boVar31 = this.bKU.bKw;
                                            if (boVar31.getPbData().getUserData() != null) {
                                                boVar32 = this.bKU.bKw;
                                                i = boVar32.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bKU.getPageContext().getPageActivity(), 2, aas.getId(), aas.getName(), aat.getId(), aay.getPostId(), 0, qK, 13008, false, false, null, false, false, null, aay, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.n.showToast(this.bKU.getPageContext().getPageActivity(), String.format(this.bKU.getPageContext().getString(com.baidu.tieba.t.write_addition_limit), Integer.valueOf(aay.getTotalCount())));
                                        return;
                                    }
                                }
                                chVar22 = this.bKU.bKA;
                                if (chVar22.bNj.acI() != null) {
                                    chVar47 = this.bKU.bKA;
                                    if (view == chVar47.bNj.acI().abF()) {
                                        chVar48 = this.bKU.bKA;
                                        chVar48.acx();
                                        hx = this.bKU.hx(11009);
                                        if (hx) {
                                            boVar26 = this.bKU.bKw;
                                            chVar49 = this.bKU.bKA;
                                            if (boVar26.hF(chVar49.aco()) == null) {
                                                return;
                                            }
                                            this.bKU.aaW();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                chVar23 = this.bKU.bKA;
                                if (chVar23.bNj.acI() != null) {
                                    chVar45 = this.bKU.bKA;
                                    if (view == chVar45.bNj.acI().abG()) {
                                        chVar46 = this.bKU.bKA;
                                        chVar46.acx();
                                        this.bKU.stopVoice();
                                        this.bKU.showShareDialog();
                                        return;
                                    }
                                }
                                chVar24 = this.bKU.bKA;
                                if (chVar24.bNj.acI() != null) {
                                    chVar42 = this.bKU.bKA;
                                    if (view == chVar42.bNj.acI().abI()) {
                                        chVar43 = this.bKU.bKA;
                                        chVar43.acx();
                                        boVar24 = this.bKU.bKw;
                                        if (boVar24.abv() != null) {
                                            chVar44 = this.bKU.bKA;
                                            boVar25 = this.bKU.bKw;
                                            chVar44.a(boVar25.abv(), this.bKU.bHa);
                                        }
                                        TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                chVar25 = this.bKU.bKA;
                                if (chVar25.bNj.acI() != null) {
                                    chVar39 = this.bKU.bKA;
                                    if (view == chVar39.bNj.acI().abJ()) {
                                        chVar40 = this.bKU.bKA;
                                        chVar40.acx();
                                        this.bKU.stopVoice();
                                        chVar41 = this.bKU.bKA;
                                        chVar41.acg();
                                        boVar23 = this.bKU.bKw;
                                        boVar23.abz();
                                        TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                chVar26 = this.bKU.bKA;
                                if (chVar26.bNj.acI() != null) {
                                    chVar37 = this.bKU.bKA;
                                    if (view == chVar37.bNj.acI().abK()) {
                                        boVar17 = this.bKU.bKw;
                                        if (boVar17 != null) {
                                            boVar18 = this.bKU.bKw;
                                            if (boVar18.getPbData() != null) {
                                                boVar19 = this.bKU.bKw;
                                                if (boVar19.getPbData().aat() != null) {
                                                    chVar38 = this.bKU.bKA;
                                                    chVar38.bNj.pA();
                                                    boVar20 = this.bKU.bKw;
                                                    if (boVar20.getPbData().aau() != null) {
                                                        boVar21 = this.bKU.bKw;
                                                        if (boVar21.getPbData().aau().size() > 0) {
                                                            PbActivity pbActivity = this.bKU;
                                                            boVar22 = this.bKU.bKw;
                                                            pbActivity.im(boVar22.getPbData().aau().get(0).getId());
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
                                cfVar = this.bKU.bKF;
                                if (cfVar != null) {
                                    cfVar29 = this.bKU.bKF;
                                    if (view == cfVar29.abS()) {
                                        Object tag = view.getTag();
                                        if (tag instanceof String) {
                                            morePopupWindow11 = this.bKU.bKE;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow11, this.bKU.getPageContext().getPageActivity());
                                            this.bKU.im((String) tag);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                cfVar2 = this.bKU.bKF;
                                if (cfVar2 != null) {
                                    cfVar28 = this.bKU.bKF;
                                    if (view == cfVar28.abF()) {
                                        if (this.bKU.checkUpIsLogin()) {
                                            this.bKU.K(view);
                                        }
                                        morePopupWindow10 = this.bKU.bKE;
                                        com.baidu.adp.lib.g.k.a(morePopupWindow10, this.bKU.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                chVar27 = this.bKU.bKA;
                                if (chVar27.abZ() != view) {
                                    cfVar3 = this.bKU.bKF;
                                    if (cfVar3 != null) {
                                        cfVar27 = this.bKU.bKF;
                                        if (view == cfVar27.abR()) {
                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                            if (sparseArray != null) {
                                                if ("".equals(sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name)) || "".equals(sparseArray.get(com.baidu.tieba.q.tag_del_post_id))) {
                                                    chVar35 = this.bKU.bKA;
                                                    chVar35.a(((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
                                                } else {
                                                    chVar36 = this.bKU.bKA;
                                                    chVar36.P(view);
                                                }
                                                morePopupWindow9 = this.bKU.bKE;
                                                com.baidu.adp.lib.g.k.a(morePopupWindow9, this.bKU.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() != com.baidu.tieba.q.pb_head_function_manage_delormanage) {
                                        cfVar4 = this.bKU.bKF;
                                        if (cfVar4 != null) {
                                            cfVar26 = this.bKU.bKF;
                                        }
                                        if (view.getId() != com.baidu.tieba.q.sub_pb_more && view.getId() != com.baidu.tieba.q.sub_pb_item) {
                                            int id = view.getId();
                                            if (id == com.baidu.tieba.q.pb_u9_text_view) {
                                                if (this.bKU.checkUpIsLogin() && (aaVar = (com.baidu.tbadk.core.data.aa) view.getTag()) != null && !StringUtils.isNull(aaVar.rH())) {
                                                    TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.bi.tO().b(this.bKU.getPageContext(), new String[]{aaVar.rH()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == com.baidu.tieba.q.reply) {
                                                morePopupWindow = this.bKU.bKE;
                                                if (morePopupWindow != null) {
                                                    cfVar20 = this.bKU.bKF;
                                                }
                                                this.bKU.aaP();
                                                morePopupWindow2 = this.bKU.bKE;
                                                if (morePopupWindow2.getIsIntercepted()) {
                                                    morePopupWindow5 = this.bKU.bKE;
                                                    morePopupWindow5.setIsIntercepted(false);
                                                    return;
                                                }
                                                com.baidu.tieba.tbadkCore.data.j jVar = null;
                                                if (view != null && view.getTag() != null) {
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    jVar = (com.baidu.tieba.tbadkCore.data.j) sparseArray2.get(com.baidu.tieba.q.tag_load_sub_data);
                                                    SparseArray sparseArray3 = new SparseArray();
                                                    sparseArray3.put(com.baidu.tieba.q.tag_load_sub_data, jVar);
                                                    sparseArray3.put(com.baidu.tieba.q.tag_load_sub_view, (View) sparseArray2.get(com.baidu.tieba.q.tag_load_sub_view));
                                                    cfVar10 = this.bKU.bKF;
                                                    cfVar10.abQ().setTag(sparseArray3);
                                                    SparseArray sparseArray4 = new SparseArray();
                                                    sparseArray4.put(com.baidu.tieba.q.tag_clip_board, (com.baidu.tieba.tbadkCore.data.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.q.tag_clip_board));
                                                    sparseArray4.put(com.baidu.tieba.q.tag_is_subpb, false);
                                                    cfVar11 = this.bKU.bKF;
                                                    cfVar11.abF().setTag(sparseArray4);
                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                    boolean booleanValue = ((Boolean) sparseArray5.get(com.baidu.tieba.q.tag_should_manage_visible)).booleanValue();
                                                    if (!(sparseArray5.get(com.baidu.tieba.q.tag_del_post_is_self) instanceof Boolean)) {
                                                        z = false;
                                                    } else {
                                                        z = ((Boolean) sparseArray5.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue();
                                                    }
                                                    String str = null;
                                                    if (sparseArray5.get(com.baidu.tieba.q.tag_forbid_user_post_id) instanceof String) {
                                                        str = (String) sparseArray5.get(com.baidu.tieba.q.tag_forbid_user_post_id);
                                                    }
                                                    if (!booleanValue) {
                                                        cfVar12 = this.bKU.bKF;
                                                        cfVar12.abR().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray6 = new SparseArray();
                                                        sparseArray6.put(com.baidu.tieba.q.tag_manage_user_identity, sparseArray5.get(com.baidu.tieba.q.tag_manage_user_identity));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_del_post_id, sparseArray5.get(com.baidu.tieba.q.tag_del_post_id));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_del_post_type, sparseArray5.get(com.baidu.tieba.q.tag_del_post_type));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_forbid_user_name, sparseArray5.get(com.baidu.tieba.q.tag_forbid_user_name));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_forbid_user_post_id, str);
                                                        cfVar16 = this.bKU.bKF;
                                                        cfVar16.abR().setTag(sparseArray6);
                                                        if ("".equals(sparseArray5.get(com.baidu.tieba.q.tag_forbid_user_name)) || "".equals(sparseArray5.get(com.baidu.tieba.q.tag_del_post_id))) {
                                                            cfVar17 = this.bKU.bKF;
                                                            com.baidu.tbadk.core.util.ay.c(cfVar17.abR(), com.baidu.tieba.p.icon_pb_del_n);
                                                        } else {
                                                            cfVar19 = this.bKU.bKF;
                                                            com.baidu.tbadk.core.util.ay.c(cfVar19.abR(), com.baidu.tieba.p.icon_pb_set_n);
                                                        }
                                                        cfVar18 = this.bKU.bKF;
                                                        cfVar18.abR().setVisibility(0);
                                                    }
                                                    dQ = this.bKU.dQ(z);
                                                    if (dQ & this.bKU.isLogin()) {
                                                        cfVar14 = this.bKU.bKF;
                                                        cfVar14.abS().setVisibility(0);
                                                        cfVar15 = this.bKU.bKF;
                                                        cfVar15.abS().setTag(str);
                                                    } else {
                                                        cfVar13 = this.bKU.bKF;
                                                        cfVar13.abS().setVisibility(8);
                                                    }
                                                }
                                                boolean z3 = false;
                                                boVar11 = this.bKU.bKw;
                                                if (boVar11.getPbData().pq()) {
                                                    boVar12 = this.bKU.bKw;
                                                    String pp = boVar12.getPbData().pp();
                                                    if (jVar != null && !com.baidu.adp.lib.util.m.isEmpty(pp) && pp.equals(jVar.getId())) {
                                                        z3 = true;
                                                    }
                                                }
                                                if (z3) {
                                                    cfVar8 = this.bKU.bKF;
                                                    cfVar8.abF().setText(com.baidu.tieba.t.marked);
                                                    cfVar9 = this.bKU.bKF;
                                                    cfVar9.abF().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                } else {
                                                    cfVar5 = this.bKU.bKF;
                                                    cfVar5.abF().setText(com.baidu.tieba.t.mark);
                                                    cfVar6 = this.bKU.bKF;
                                                    cfVar6.abF().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                }
                                                cfVar7 = this.bKU.bKF;
                                                cfVar7.ea(true);
                                                morePopupWindow3 = this.bKU.bKE;
                                                morePopupWindow3.reLayoutWidth();
                                                morePopupWindow4 = this.bKU.bKE;
                                                morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                return;
                                            } else if (id != com.baidu.tieba.q.pb_head_reverse_hint) {
                                                if (id == com.baidu.tieba.q.pb_act_btn) {
                                                    boVar4 = this.bKU.bKw;
                                                    if (boVar4.getPbData() != null) {
                                                        boVar5 = this.bKU.bKw;
                                                        if (boVar5.getPbData().aat() != null) {
                                                            boVar6 = this.bKU.bKw;
                                                            if (boVar6.getPbData().aat().rx() != null) {
                                                                Activity activity = this.bKU.getActivity();
                                                                boVar7 = this.bKU.bKw;
                                                                com.baidu.tbadk.browser.f.x(activity, boVar7.getPbData().aat().rx());
                                                                boVar8 = this.bKU.bKw;
                                                                if (boVar8.getPbData().aat().rv() != 1) {
                                                                    boVar9 = this.bKU.bKw;
                                                                    if (boVar9.getPbData().aat().rv() == 2) {
                                                                        TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                this.bKU.stopVoice();
                                                chVar28 = this.bKU.bKA;
                                                chVar28.acx();
                                                chVar29 = this.bKU.bKA;
                                                chVar29.acg();
                                                boVar10 = this.bKU.bKw;
                                                boVar10.abz();
                                                return;
                                            }
                                        }
                                        if (!this.bKU.checkUpIsLogin()) {
                                            morePopupWindow8 = this.bKU.bKE;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow8, this.bKU.getPageContext().getPageActivity());
                                            return;
                                        }
                                        cfVar21 = this.bKU.bKF;
                                        if (cfVar21 != null) {
                                            cfVar24 = this.bKU.bKF;
                                            if (view == cfVar24.abQ()) {
                                                cfVar25 = this.bKU.bKF;
                                                if (!cfVar25.abP()) {
                                                    morePopupWindow7 = this.bKU.bKE;
                                                    com.baidu.adp.lib.g.k.a(morePopupWindow7, this.bKU.getPageContext().getPageActivity());
                                                    chVar32 = this.bKU.bKA;
                                                    chVar32.ef(true);
                                                    return;
                                                }
                                            }
                                        }
                                        boVar13 = this.bKU.bKw;
                                        if (boVar13.getPbData() != null) {
                                            chVar30 = this.bKU.bKA;
                                            chVar30.acx();
                                            SparseArray sparseArray7 = (SparseArray) view.getTag();
                                            com.baidu.tieba.tbadkCore.data.j jVar2 = (com.baidu.tieba.tbadkCore.data.j) sparseArray7.get(com.baidu.tieba.q.tag_load_sub_data);
                                            View view2 = (View) sparseArray7.get(com.baidu.tieba.q.tag_load_sub_view);
                                            if (jVar2 != null && view2 != null) {
                                                boVar14 = this.bKU.bKw;
                                                String abp = boVar14.abp();
                                                String id2 = jVar2.getId();
                                                int i2 = 0;
                                                boVar15 = this.bKU.bKw;
                                                if (boVar15.getPbData() != null) {
                                                    boVar16 = this.bKU.bKw;
                                                    i2 = boVar16.getPbData().aaw();
                                                }
                                                this.bKU.stopVoice();
                                                cfVar22 = this.bKU.bKF;
                                                if (cfVar22 != null) {
                                                    cfVar23 = this.bKU.bKF;
                                                    if (view == cfVar23.abQ()) {
                                                        morePopupWindow6 = this.bKU.bKE;
                                                        com.baidu.adp.lib.g.k.a(morePopupWindow6, this.bKU.getPageContext().getPageActivity());
                                                        this.bKU.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.bKU.getPageContext().getPageActivity()).createSubPbActivityConfig(abp, id2, "pb", true, null, true, null, i2)));
                                                        return;
                                                    }
                                                }
                                                if (view.getId() == com.baidu.tieba.q.sub_pb_item) {
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    String str2 = (String) sparseArray8.get(com.baidu.tieba.q.tag_photo_username);
                                                    com.baidu.tieba.tbadkCore.data.j jVar3 = (com.baidu.tieba.tbadkCore.data.j) sparseArray8.get(com.baidu.tieba.q.tag_clip_board);
                                                    String str3 = null;
                                                    if (jVar3 != null) {
                                                        str3 = jVar3.getId();
                                                    }
                                                    this.bKU.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.bKU.getPageContext().getPageActivity()).createSubPbActivityConfig(abp, id2, "pb", true, str2, true, str3, i2)));
                                                    return;
                                                } else if (jVar2.aoK()) {
                                                    this.bKU.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.bKU.getPageContext().getPageActivity()).createSubPbActivityConfig(abp, id2, "pb", true, null, false, null, i2)));
                                                    return;
                                                } else {
                                                    jVar2.fg(true);
                                                    chVar31 = this.bKU.bKA;
                                                    chVar31.acb().notifyDataSetChanged();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                    if (((Boolean) sparseArray9.get(com.baidu.tieba.q.tag_should_manage_visible)).booleanValue()) {
                                        chVar34 = this.bKU.bKA;
                                        chVar34.P(view);
                                        return;
                                    }
                                    chVar33 = this.bKU.bKA;
                                    chVar33.a(((Integer) sparseArray9.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray9.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray9.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray9.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
                                    return;
                                } else if (this.bKU.checkUpIsLogin()) {
                                    this.bKU.aaL();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            boVar38 = this.bKU.bKw;
                            String name = boVar38.getPbData().aas().getName();
                            boVar39 = this.bKU.bKw;
                            if (!TextUtils.isEmpty(boVar39.abo())) {
                                boVar40 = this.bKU.bKw;
                                if (boVar40.abo().equals(name)) {
                                    this.bKU.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.bb.aT(name)) {
                                this.bKU.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bKU.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        chVar5 = this.bKU.bKA;
        chVar5.acy();
        boVar = this.bKU.bKw;
        if (boVar.getPbData().aaw() == 1) {
            aVar = this.bKU.bKz;
            if (!aVar.apt()) {
                chVar6 = this.bKU.bKA;
                chVar6.acd();
                int i3 = 0;
                chVar7 = this.bKU.bKA;
                if (view != chVar7.acs()) {
                    chVar8 = this.bKU.bKA;
                    if (view != chVar8.act()) {
                        chVar9 = this.bKU.bKA;
                        if (view != chVar9.acu()) {
                            chVar10 = this.bKU.bKA;
                            if (view != chVar10.acv()) {
                                chVar11 = this.bKU.bKA;
                                if (view == chVar11.ace()) {
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
                boVar2 = this.bKU.bKw;
                ForumData aas2 = boVar2.getPbData().aas();
                String name2 = aas2.getName();
                String id3 = aas2.getId();
                boVar3 = this.bKU.bKw;
                String id4 = boVar3.getPbData().aat().getId();
                aVar2 = this.bKU.bKz;
                chVar12 = this.bKU.bKA;
                aVar2.b(id3, name2, id4, i3, chVar12.acf());
            }
        }
    }
}
