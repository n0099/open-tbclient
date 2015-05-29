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
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v32, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x08d1, code lost:
        if (r21 != r1.abP()) goto L247;
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
        chVar = this.bKT.bKz;
        if (view == chVar.getNextView()) {
            boVar45 = this.bKT.bKv;
            if (boVar45.dV(true)) {
                chVar57 = this.bKT.bKz;
                chVar57.acg();
                return;
            }
            return;
        }
        chVar2 = this.bKT.bKz;
        if (view == chVar2.acC()) {
            chVar54 = this.bKT.bKz;
            chVar54.acw();
            this.bKT.stopVoice();
            chVar55 = this.bKT.bKz;
            chVar55.acf();
            chVar56 = this.bKT.bKz;
            chVar56.WO();
            boVar44 = this.bKT.bKv;
            boVar44.hA(1);
            return;
        }
        chVar3 = this.bKT.bKz;
        if (view == chVar3.bNi.arG) {
            chVar53 = this.bKT.bKz;
            boVar43 = this.bKT.bKv;
            if (!chVar53.eh(boVar43.abs())) {
                this.bKT.finish();
                return;
            } else {
                this.bKT.stopVoice();
                return;
            }
        }
        chVar4 = this.bKT.bKz;
        if (view != chVar4.acr()) {
            chVar13 = this.bKT.bKz;
            if (view != chVar13.acs()) {
                chVar14 = this.bKT.bKz;
                if (view != chVar14.act()) {
                    chVar15 = this.bKT.bKz;
                    if (view != chVar15.acu()) {
                        chVar16 = this.bKT.bKz;
                        if (view != chVar16.acd()) {
                            chVar17 = this.bKT.bKz;
                            if (view == chVar17.acy()) {
                                boVar41 = this.bKT.bKv;
                                if (boVar41 != null) {
                                    boVar42 = this.bKT.bKv;
                                    com.baidu.tbadk.browser.f.x(this.bKT.getPageContext().getPageActivity(), boVar42.getPbData().aas().rj().getLink());
                                    return;
                                }
                                return;
                            }
                            chVar18 = this.bKT.bKz;
                            if (view != chVar18.bNi.bOO) {
                                chVar19 = this.bKT.bKz;
                                if (view == chVar19.bNi.bOQ) {
                                    boVar34 = this.bKT.bKv;
                                    if (boVar34 != null) {
                                        boVar35 = this.bKT.bKv;
                                        if (boVar35.getPbData() != null) {
                                            boVar36 = this.bKT.bKv;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = boVar36.getPbData().aat();
                                            if (aat == null || aat.size() <= 0) {
                                                boVar37 = this.bKT.bKv;
                                                if (boVar37.abp()) {
                                                    com.baidu.adp.lib.util.n.showToast(this.bKT.getPageContext().getPageActivity(), this.bKT.getPageContext().getString(com.baidu.tieba.t.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            this.bKT.aaQ();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.n.showToast(this.bKT.getPageContext().getPageActivity(), this.bKT.getPageContext().getString(com.baidu.tieba.t.pb_no_data_tips));
                                    return;
                                }
                                chVar20 = this.bKT.bKz;
                                if (view == chVar20.bNi.bOP) {
                                    z2 = this.bKT.alI;
                                    if (!z2) {
                                        this.bKT.alI = true;
                                        chVar50 = this.bKT.bKz;
                                        chVar50.bNi.bOP.setEnabled(false);
                                        chVar51 = this.bKT.bKz;
                                        chVar51.Td();
                                        this.bKT.stopVoice();
                                        chVar52 = this.bKT.bKz;
                                        chVar52.acf();
                                        boVar33 = this.bKT.bKv;
                                        boVar33.abx();
                                        TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                chVar21 = this.bKT.bKz;
                                if (view == chVar21.bNi.bOR) {
                                    boVar27 = this.bKT.bKv;
                                    AdditionData aax = boVar27.getPbData().aax();
                                    if (!TextUtils.isEmpty(aax.getWarnMsg())) {
                                        com.baidu.adp.lib.util.n.showToast(this.bKT.getPageContext().getPageActivity(), aax.getWarnMsg());
                                        return;
                                    } else if (aax.getAlreadyCount() != aax.getTotalCount()) {
                                        boVar28 = this.bKT.bKv;
                                        ForumData aar = boVar28.getPbData().aar();
                                        boVar29 = this.bKT.bKv;
                                        com.baidu.tbadk.core.data.w aas = boVar29.getPbData().aas();
                                        boVar30 = this.bKT.bKv;
                                        AntiData qK = boVar30.getPbData().qK();
                                        if (aas.getId() != null) {
                                            if (qK != null && qK.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.n.showToast(this.bKT.getPageContext().getPageActivity(), qK.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            boVar31 = this.bKT.bKv;
                                            if (boVar31.getPbData().getUserData() != null) {
                                                boVar32 = this.bKT.bKv;
                                                i = boVar32.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bKT.getPageContext().getPageActivity(), 2, aar.getId(), aar.getName(), aas.getId(), aax.getPostId(), 0, qK, 13008, false, false, null, false, false, null, aax, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.n.showToast(this.bKT.getPageContext().getPageActivity(), String.format(this.bKT.getPageContext().getString(com.baidu.tieba.t.write_addition_limit), Integer.valueOf(aax.getTotalCount())));
                                        return;
                                    }
                                }
                                chVar22 = this.bKT.bKz;
                                if (chVar22.bNi.acH() != null) {
                                    chVar47 = this.bKT.bKz;
                                    if (view == chVar47.bNi.acH().abE()) {
                                        chVar48 = this.bKT.bKz;
                                        chVar48.acw();
                                        hx = this.bKT.hx(11009);
                                        if (hx) {
                                            boVar26 = this.bKT.bKv;
                                            chVar49 = this.bKT.bKz;
                                            if (boVar26.hF(chVar49.acn()) == null) {
                                                return;
                                            }
                                            this.bKT.aaV();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                chVar23 = this.bKT.bKz;
                                if (chVar23.bNi.acH() != null) {
                                    chVar45 = this.bKT.bKz;
                                    if (view == chVar45.bNi.acH().abF()) {
                                        chVar46 = this.bKT.bKz;
                                        chVar46.acw();
                                        this.bKT.stopVoice();
                                        this.bKT.showShareDialog();
                                        return;
                                    }
                                }
                                chVar24 = this.bKT.bKz;
                                if (chVar24.bNi.acH() != null) {
                                    chVar42 = this.bKT.bKz;
                                    if (view == chVar42.bNi.acH().abH()) {
                                        chVar43 = this.bKT.bKz;
                                        chVar43.acw();
                                        boVar24 = this.bKT.bKv;
                                        if (boVar24.abu() != null) {
                                            chVar44 = this.bKT.bKz;
                                            boVar25 = this.bKT.bKv;
                                            chVar44.a(boVar25.abu(), this.bKT.bGZ);
                                        }
                                        TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                chVar25 = this.bKT.bKz;
                                if (chVar25.bNi.acH() != null) {
                                    chVar39 = this.bKT.bKz;
                                    if (view == chVar39.bNi.acH().abI()) {
                                        chVar40 = this.bKT.bKz;
                                        chVar40.acw();
                                        this.bKT.stopVoice();
                                        chVar41 = this.bKT.bKz;
                                        chVar41.acf();
                                        boVar23 = this.bKT.bKv;
                                        boVar23.aby();
                                        TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                chVar26 = this.bKT.bKz;
                                if (chVar26.bNi.acH() != null) {
                                    chVar37 = this.bKT.bKz;
                                    if (view == chVar37.bNi.acH().abJ()) {
                                        boVar17 = this.bKT.bKv;
                                        if (boVar17 != null) {
                                            boVar18 = this.bKT.bKv;
                                            if (boVar18.getPbData() != null) {
                                                boVar19 = this.bKT.bKv;
                                                if (boVar19.getPbData().aas() != null) {
                                                    chVar38 = this.bKT.bKz;
                                                    chVar38.bNi.pA();
                                                    boVar20 = this.bKT.bKv;
                                                    if (boVar20.getPbData().aat() != null) {
                                                        boVar21 = this.bKT.bKv;
                                                        if (boVar21.getPbData().aat().size() > 0) {
                                                            PbActivity pbActivity = this.bKT;
                                                            boVar22 = this.bKT.bKv;
                                                            pbActivity.im(boVar22.getPbData().aat().get(0).getId());
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
                                cfVar = this.bKT.bKE;
                                if (cfVar != null) {
                                    cfVar29 = this.bKT.bKE;
                                    if (view == cfVar29.abR()) {
                                        Object tag = view.getTag();
                                        if (tag instanceof String) {
                                            morePopupWindow11 = this.bKT.bKD;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow11, this.bKT.getPageContext().getPageActivity());
                                            this.bKT.im((String) tag);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                cfVar2 = this.bKT.bKE;
                                if (cfVar2 != null) {
                                    cfVar28 = this.bKT.bKE;
                                    if (view == cfVar28.abE()) {
                                        if (this.bKT.checkUpIsLogin()) {
                                            this.bKT.K(view);
                                        }
                                        morePopupWindow10 = this.bKT.bKD;
                                        com.baidu.adp.lib.g.k.a(morePopupWindow10, this.bKT.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                chVar27 = this.bKT.bKz;
                                if (chVar27.abY() != view) {
                                    cfVar3 = this.bKT.bKE;
                                    if (cfVar3 != null) {
                                        cfVar27 = this.bKT.bKE;
                                        if (view == cfVar27.abQ()) {
                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                            if (sparseArray != null) {
                                                if ("".equals(sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name)) || "".equals(sparseArray.get(com.baidu.tieba.q.tag_del_post_id))) {
                                                    chVar35 = this.bKT.bKz;
                                                    chVar35.a(((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
                                                } else {
                                                    chVar36 = this.bKT.bKz;
                                                    chVar36.P(view);
                                                }
                                                morePopupWindow9 = this.bKT.bKD;
                                                com.baidu.adp.lib.g.k.a(morePopupWindow9, this.bKT.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() != com.baidu.tieba.q.pb_head_function_manage_delormanage) {
                                        cfVar4 = this.bKT.bKE;
                                        if (cfVar4 != null) {
                                            cfVar26 = this.bKT.bKE;
                                        }
                                        if (view.getId() != com.baidu.tieba.q.sub_pb_more && view.getId() != com.baidu.tieba.q.sub_pb_item) {
                                            int id = view.getId();
                                            if (id == com.baidu.tieba.q.pb_u9_text_view) {
                                                if (this.bKT.checkUpIsLogin() && (aaVar = (com.baidu.tbadk.core.data.aa) view.getTag()) != null && !StringUtils.isNull(aaVar.rH())) {
                                                    TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.bi.tO().b(this.bKT.getPageContext(), new String[]{aaVar.rH()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == com.baidu.tieba.q.reply) {
                                                morePopupWindow = this.bKT.bKD;
                                                if (morePopupWindow != null) {
                                                    cfVar20 = this.bKT.bKE;
                                                }
                                                this.bKT.aaO();
                                                morePopupWindow2 = this.bKT.bKD;
                                                if (morePopupWindow2.getIsIntercepted()) {
                                                    morePopupWindow5 = this.bKT.bKD;
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
                                                    cfVar10 = this.bKT.bKE;
                                                    cfVar10.abP().setTag(sparseArray3);
                                                    SparseArray sparseArray4 = new SparseArray();
                                                    sparseArray4.put(com.baidu.tieba.q.tag_clip_board, (com.baidu.tieba.tbadkCore.data.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.q.tag_clip_board));
                                                    sparseArray4.put(com.baidu.tieba.q.tag_is_subpb, false);
                                                    cfVar11 = this.bKT.bKE;
                                                    cfVar11.abE().setTag(sparseArray4);
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
                                                        cfVar12 = this.bKT.bKE;
                                                        cfVar12.abQ().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray6 = new SparseArray();
                                                        sparseArray6.put(com.baidu.tieba.q.tag_manage_user_identity, sparseArray5.get(com.baidu.tieba.q.tag_manage_user_identity));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_del_post_id, sparseArray5.get(com.baidu.tieba.q.tag_del_post_id));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_del_post_type, sparseArray5.get(com.baidu.tieba.q.tag_del_post_type));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_forbid_user_name, sparseArray5.get(com.baidu.tieba.q.tag_forbid_user_name));
                                                        sparseArray6.put(com.baidu.tieba.q.tag_forbid_user_post_id, str);
                                                        cfVar16 = this.bKT.bKE;
                                                        cfVar16.abQ().setTag(sparseArray6);
                                                        if ("".equals(sparseArray5.get(com.baidu.tieba.q.tag_forbid_user_name)) || "".equals(sparseArray5.get(com.baidu.tieba.q.tag_del_post_id))) {
                                                            cfVar17 = this.bKT.bKE;
                                                            com.baidu.tbadk.core.util.ay.c(cfVar17.abQ(), com.baidu.tieba.p.icon_pb_del_n);
                                                        } else {
                                                            cfVar19 = this.bKT.bKE;
                                                            com.baidu.tbadk.core.util.ay.c(cfVar19.abQ(), com.baidu.tieba.p.icon_pb_set_n);
                                                        }
                                                        cfVar18 = this.bKT.bKE;
                                                        cfVar18.abQ().setVisibility(0);
                                                    }
                                                    dQ = this.bKT.dQ(z);
                                                    if (dQ & this.bKT.isLogin()) {
                                                        cfVar14 = this.bKT.bKE;
                                                        cfVar14.abR().setVisibility(0);
                                                        cfVar15 = this.bKT.bKE;
                                                        cfVar15.abR().setTag(str);
                                                    } else {
                                                        cfVar13 = this.bKT.bKE;
                                                        cfVar13.abR().setVisibility(8);
                                                    }
                                                }
                                                boolean z3 = false;
                                                boVar11 = this.bKT.bKv;
                                                if (boVar11.getPbData().pq()) {
                                                    boVar12 = this.bKT.bKv;
                                                    String pp = boVar12.getPbData().pp();
                                                    if (jVar != null && !com.baidu.adp.lib.util.m.isEmpty(pp) && pp.equals(jVar.getId())) {
                                                        z3 = true;
                                                    }
                                                }
                                                if (z3) {
                                                    cfVar8 = this.bKT.bKE;
                                                    cfVar8.abE().setText(com.baidu.tieba.t.marked);
                                                    cfVar9 = this.bKT.bKE;
                                                    cfVar9.abE().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                } else {
                                                    cfVar5 = this.bKT.bKE;
                                                    cfVar5.abE().setText(com.baidu.tieba.t.mark);
                                                    cfVar6 = this.bKT.bKE;
                                                    cfVar6.abE().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                }
                                                cfVar7 = this.bKT.bKE;
                                                cfVar7.ea(true);
                                                morePopupWindow3 = this.bKT.bKD;
                                                morePopupWindow3.reLayoutWidth();
                                                morePopupWindow4 = this.bKT.bKD;
                                                morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                return;
                                            } else if (id != com.baidu.tieba.q.pb_head_reverse_hint) {
                                                if (id == com.baidu.tieba.q.pb_act_btn) {
                                                    boVar4 = this.bKT.bKv;
                                                    if (boVar4.getPbData() != null) {
                                                        boVar5 = this.bKT.bKv;
                                                        if (boVar5.getPbData().aas() != null) {
                                                            boVar6 = this.bKT.bKv;
                                                            if (boVar6.getPbData().aas().rx() != null) {
                                                                Activity activity = this.bKT.getActivity();
                                                                boVar7 = this.bKT.bKv;
                                                                com.baidu.tbadk.browser.f.x(activity, boVar7.getPbData().aas().rx());
                                                                boVar8 = this.bKT.bKv;
                                                                if (boVar8.getPbData().aas().rv() != 1) {
                                                                    boVar9 = this.bKT.bKv;
                                                                    if (boVar9.getPbData().aas().rv() == 2) {
                                                                        TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                this.bKT.stopVoice();
                                                chVar28 = this.bKT.bKz;
                                                chVar28.acw();
                                                chVar29 = this.bKT.bKz;
                                                chVar29.acf();
                                                boVar10 = this.bKT.bKv;
                                                boVar10.aby();
                                                return;
                                            }
                                        }
                                        if (!this.bKT.checkUpIsLogin()) {
                                            morePopupWindow8 = this.bKT.bKD;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow8, this.bKT.getPageContext().getPageActivity());
                                            return;
                                        }
                                        cfVar21 = this.bKT.bKE;
                                        if (cfVar21 != null) {
                                            cfVar24 = this.bKT.bKE;
                                            if (view == cfVar24.abP()) {
                                                cfVar25 = this.bKT.bKE;
                                                if (!cfVar25.abO()) {
                                                    morePopupWindow7 = this.bKT.bKD;
                                                    com.baidu.adp.lib.g.k.a(morePopupWindow7, this.bKT.getPageContext().getPageActivity());
                                                    chVar32 = this.bKT.bKz;
                                                    chVar32.ef(true);
                                                    return;
                                                }
                                            }
                                        }
                                        boVar13 = this.bKT.bKv;
                                        if (boVar13.getPbData() != null) {
                                            chVar30 = this.bKT.bKz;
                                            chVar30.acw();
                                            SparseArray sparseArray7 = (SparseArray) view.getTag();
                                            com.baidu.tieba.tbadkCore.data.j jVar2 = (com.baidu.tieba.tbadkCore.data.j) sparseArray7.get(com.baidu.tieba.q.tag_load_sub_data);
                                            View view2 = (View) sparseArray7.get(com.baidu.tieba.q.tag_load_sub_view);
                                            if (jVar2 != null && view2 != null) {
                                                boVar14 = this.bKT.bKv;
                                                String abo = boVar14.abo();
                                                String id2 = jVar2.getId();
                                                int i2 = 0;
                                                boVar15 = this.bKT.bKv;
                                                if (boVar15.getPbData() != null) {
                                                    boVar16 = this.bKT.bKv;
                                                    i2 = boVar16.getPbData().aav();
                                                }
                                                this.bKT.stopVoice();
                                                cfVar22 = this.bKT.bKE;
                                                if (cfVar22 != null) {
                                                    cfVar23 = this.bKT.bKE;
                                                    if (view == cfVar23.abP()) {
                                                        morePopupWindow6 = this.bKT.bKD;
                                                        com.baidu.adp.lib.g.k.a(morePopupWindow6, this.bKT.getPageContext().getPageActivity());
                                                        this.bKT.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.bKT.getPageContext().getPageActivity()).createSubPbActivityConfig(abo, id2, "pb", true, null, true, null, i2)));
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
                                                    this.bKT.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.bKT.getPageContext().getPageActivity()).createSubPbActivityConfig(abo, id2, "pb", true, str2, true, str3, i2)));
                                                    return;
                                                } else if (jVar2.aoJ()) {
                                                    this.bKT.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.bKT.getPageContext().getPageActivity()).createSubPbActivityConfig(abo, id2, "pb", true, null, false, null, i2)));
                                                    return;
                                                } else {
                                                    jVar2.fg(true);
                                                    chVar31 = this.bKT.bKz;
                                                    chVar31.aca().notifyDataSetChanged();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                    if (((Boolean) sparseArray9.get(com.baidu.tieba.q.tag_should_manage_visible)).booleanValue()) {
                                        chVar34 = this.bKT.bKz;
                                        chVar34.P(view);
                                        return;
                                    }
                                    chVar33 = this.bKT.bKz;
                                    chVar33.a(((Integer) sparseArray9.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray9.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray9.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray9.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
                                    return;
                                } else if (this.bKT.checkUpIsLogin()) {
                                    this.bKT.aaK();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            boVar38 = this.bKT.bKv;
                            String name = boVar38.getPbData().aar().getName();
                            boVar39 = this.bKT.bKv;
                            if (!TextUtils.isEmpty(boVar39.abn())) {
                                boVar40 = this.bKT.bKv;
                                if (boVar40.abn().equals(name)) {
                                    this.bKT.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.bb.aT(name)) {
                                this.bKT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bKT.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        chVar5 = this.bKT.bKz;
        chVar5.acx();
        boVar = this.bKT.bKv;
        if (boVar.getPbData().aav() == 1) {
            aVar = this.bKT.bKy;
            if (!aVar.aps()) {
                chVar6 = this.bKT.bKz;
                chVar6.acc();
                int i3 = 0;
                chVar7 = this.bKT.bKz;
                if (view != chVar7.acr()) {
                    chVar8 = this.bKT.bKz;
                    if (view != chVar8.acs()) {
                        chVar9 = this.bKT.bKz;
                        if (view != chVar9.act()) {
                            chVar10 = this.bKT.bKz;
                            if (view != chVar10.acu()) {
                                chVar11 = this.bKT.bKz;
                                if (view == chVar11.acd()) {
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
                boVar2 = this.bKT.bKv;
                ForumData aar2 = boVar2.getPbData().aar();
                String name2 = aar2.getName();
                String id3 = aar2.getId();
                boVar3 = this.bKT.bKv;
                String id4 = boVar3.getPbData().aas().getId();
                aVar2 = this.bKT.bKy;
                chVar12 = this.bKT.bKz;
                aVar2.b(id3, name2, id4, i3, chVar12.ace());
            }
        }
    }
}
