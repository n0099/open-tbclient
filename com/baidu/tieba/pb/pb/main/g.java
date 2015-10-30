package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v86, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0929, code lost:
        if (r21 != r1.agf()) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0bb7, code lost:
        if (r1 == null) goto L338;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        cc ccVar4;
        cc ccVar5;
        bl blVar;
        com.baidu.tieba.tbadkCore.g.a aVar;
        cc ccVar6;
        cc ccVar7;
        cc ccVar8;
        cc ccVar9;
        cc ccVar10;
        cc ccVar11;
        bl blVar2;
        bl blVar3;
        com.baidu.tieba.tbadkCore.g.a aVar2;
        cc ccVar12;
        cc ccVar13;
        cc ccVar14;
        cc ccVar15;
        cc ccVar16;
        cc ccVar17;
        cc ccVar18;
        cc ccVar19;
        cc ccVar20;
        cc ccVar21;
        cc ccVar22;
        cc ccVar23;
        cc ccVar24;
        cc ccVar25;
        cc ccVar26;
        ca caVar;
        ca caVar2;
        cc ccVar27;
        ca caVar3;
        ca caVar4;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        bl blVar9;
        cc ccVar28;
        cc ccVar29;
        bl blVar10;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        bl blVar11;
        ca caVar5;
        ca caVar6;
        ca caVar7;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        ca caVar8;
        ca caVar9;
        bl blVar12;
        ca caVar10;
        ca caVar11;
        boolean z;
        ca caVar12;
        ca caVar13;
        ca caVar14;
        ca caVar15;
        boolean z2;
        String str;
        boolean es;
        ca caVar16;
        ca caVar17;
        ca caVar18;
        ca caVar19;
        ca caVar20;
        ca caVar21;
        ca caVar22;
        ca caVar23;
        ca caVar24;
        ca caVar25;
        MorePopupWindow morePopupWindow5;
        ca caVar26;
        com.baidu.tbadk.core.data.aa aaVar;
        ca caVar27;
        bl blVar13;
        cc ccVar30;
        bl blVar14;
        bl blVar15;
        ca caVar28;
        cc ccVar31;
        bl blVar16;
        bl blVar17;
        ca caVar29;
        MorePopupWindow morePopupWindow6;
        bl blVar18;
        bl blVar19;
        ca caVar30;
        ca caVar31;
        MorePopupWindow morePopupWindow7;
        MorePopupWindow morePopupWindow8;
        ca caVar32;
        cc ccVar32;
        cc ccVar33;
        ca caVar33;
        cc ccVar34;
        MorePopupWindow morePopupWindow9;
        cc ccVar35;
        ca caVar34;
        MorePopupWindow morePopupWindow10;
        ca caVar35;
        MorePopupWindow morePopupWindow11;
        cc ccVar36;
        bl blVar20;
        bl blVar21;
        bl blVar22;
        cc ccVar37;
        bl blVar23;
        bl blVar24;
        bl blVar25;
        cc ccVar38;
        cc ccVar39;
        cc ccVar40;
        bl blVar26;
        cc ccVar41;
        cc ccVar42;
        bl blVar27;
        cc ccVar43;
        bl blVar28;
        cc ccVar44;
        cc ccVar45;
        cc ccVar46;
        cc ccVar47;
        boolean iJ;
        bl blVar29;
        cc ccVar48;
        bl blVar30;
        bl blVar31;
        bl blVar32;
        bl blVar33;
        bl blVar34;
        bl blVar35;
        boolean z3;
        cc ccVar49;
        cc ccVar50;
        cc ccVar51;
        bl blVar36;
        String afv;
        bl blVar37;
        bl blVar38;
        bl blVar39;
        bl blVar40;
        bl blVar41;
        bl blVar42;
        bl blVar43;
        bl blVar44;
        bl blVar45;
        cc ccVar52;
        bl blVar46;
        cc ccVar53;
        cc ccVar54;
        cc ccVar55;
        bl blVar47;
        bl blVar48;
        cc ccVar56;
        ccVar = this.ciK.cim;
        if (view == ccVar.getNextView()) {
            blVar48 = this.ciK.cih;
            if (blVar48.ex(true)) {
                ccVar56 = this.ciK.cim;
                ccVar56.agv();
                return;
            }
            return;
        }
        ccVar2 = this.ciK.cim;
        if (view == ccVar2.agN()) {
            ccVar53 = this.ciK.cim;
            ccVar53.agI();
            this.ciK.stopVoice();
            ccVar54 = this.ciK.cim;
            ccVar54.agt();
            ccVar55 = this.ciK.cim;
            ccVar55.Zb();
            blVar47 = this.ciK.cih;
            blVar47.iM(1);
            return;
        }
        ccVar3 = this.ciK.cim;
        if (view == ccVar3.ckl.azh) {
            ccVar52 = this.ciK.cim;
            blVar46 = this.ciK.cih;
            if (!ccVar52.eM(blVar46.afL())) {
                this.ciK.finish();
                return;
            } else {
                this.ciK.stopVoice();
                return;
            }
        }
        ccVar4 = this.ciK.cim;
        if (view != ccVar4.agD()) {
            ccVar13 = this.ciK.cim;
            if (view != ccVar13.agE()) {
                ccVar14 = this.ciK.cim;
                if (view != ccVar14.agF()) {
                    ccVar15 = this.ciK.cim;
                    if (view != ccVar15.agG()) {
                        ccVar16 = this.ciK.cim;
                        if (view != ccVar16.agr()) {
                            ccVar17 = this.ciK.cim;
                            if (view == ccVar17.agK()) {
                                blVar44 = this.ciK.cih;
                                if (blVar44 != null) {
                                    blVar45 = this.ciK.cih;
                                    com.baidu.tbadk.browser.g.B(this.ciK.getPageContext().getPageActivity(), blVar45.getPbData().aeK().sf().getLink());
                                    return;
                                }
                                return;
                            }
                            ccVar18 = this.ciK.cim;
                            if (view != ccVar18.ckl.clU) {
                                ccVar19 = this.ciK.cim;
                                if (view == ccVar19.ckl.clW) {
                                    blVar37 = this.ciK.cih;
                                    if (blVar37 != null) {
                                        blVar38 = this.ciK.cih;
                                        if (blVar38.getPbData() != null) {
                                            blVar39 = this.ciK.cih;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeL = blVar39.getPbData().aeL();
                                            if (aeL == null || aeL.size() <= 0) {
                                                blVar40 = this.ciK.cih;
                                                if (blVar40.afH()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.ciK.getPageContext().getPageActivity(), this.ciK.getPageContext().getString(i.h.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            this.ciK.afj();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.ciK.getPageContext().getPageActivity(), this.ciK.getPageContext().getString(i.h.pb_no_data_tips));
                                    return;
                                }
                                ccVar20 = this.ciK.cim;
                                if (view == ccVar20.ckl.clV) {
                                    z3 = this.ciK.atu;
                                    if (!z3) {
                                        this.ciK.atu = true;
                                        ccVar49 = this.ciK.cim;
                                        ccVar49.ckl.clV.setEnabled(false);
                                        ccVar50 = this.ciK.cim;
                                        ccVar50.Vs();
                                        this.ciK.stopVoice();
                                        ccVar51 = this.ciK.cim;
                                        ccVar51.agt();
                                        blVar36 = this.ciK.cih;
                                        afv = this.ciK.afv();
                                        blVar36.jN(afv);
                                        TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                ccVar21 = this.ciK.cim;
                                if (view == ccVar21.ckl.clX) {
                                    blVar30 = this.ciK.cih;
                                    AdditionData aeR = blVar30.getPbData().aeR();
                                    if (!TextUtils.isEmpty(aeR.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.ciK.getPageContext().getPageActivity(), aeR.getWarnMsg());
                                        return;
                                    } else if (aeR.getAlreadyCount() != aeR.getTotalCount()) {
                                        blVar31 = this.ciK.cih;
                                        ForumData aeJ = blVar31.getPbData().aeJ();
                                        blVar32 = this.ciK.cih;
                                        com.baidu.tbadk.core.data.w aeK = blVar32.getPbData().aeK();
                                        blVar33 = this.ciK.cih;
                                        AntiData rC = blVar33.getPbData().rC();
                                        if (aeK.getId() != null) {
                                            if (rC != null && rC.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.ciK.getPageContext().getPageActivity(), rC.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            blVar34 = this.ciK.cih;
                                            if (blVar34.getPbData().getUserData() != null) {
                                                blVar35 = this.ciK.cih;
                                                i = blVar35.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.ciK.getPageContext().getPageActivity(), 2, aeJ.getId(), aeJ.getName(), aeK.getId(), aeR.getPostId(), 0, rC, 13008, false, false, null, false, false, null, aeR, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.ciK.getPageContext().getPageActivity(), String.format(this.ciK.getPageContext().getString(i.h.write_addition_limit), Integer.valueOf(aeR.getTotalCount())));
                                        return;
                                    }
                                }
                                ccVar22 = this.ciK.cim;
                                if (ccVar22.ckl.agS() != null) {
                                    ccVar46 = this.ciK.cim;
                                    if (view == ccVar46.ckl.agS().afU()) {
                                        ccVar47 = this.ciK.cim;
                                        ccVar47.agI();
                                        iJ = this.ciK.iJ(11009);
                                        if (iJ) {
                                            blVar29 = this.ciK.cih;
                                            ccVar48 = this.ciK.cim;
                                            if (blVar29.iS(ccVar48.agz()) == null) {
                                                return;
                                            }
                                            this.ciK.afn();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ccVar23 = this.ciK.cim;
                                if (ccVar23.ckl.agS() != null) {
                                    ccVar44 = this.ciK.cim;
                                    if (view == ccVar44.ckl.agS().afV()) {
                                        ccVar45 = this.ciK.cim;
                                        ccVar45.agI();
                                        this.ciK.stopVoice();
                                        this.ciK.showShareDialog();
                                        return;
                                    }
                                }
                                ccVar24 = this.ciK.cim;
                                if (ccVar24.ckl.agS() != null) {
                                    ccVar41 = this.ciK.cim;
                                    if (view == ccVar41.ckl.agS().afX()) {
                                        ccVar42 = this.ciK.cim;
                                        ccVar42.agI();
                                        blVar27 = this.ciK.cih;
                                        if (blVar27.QR() != null) {
                                            ccVar43 = this.ciK.cim;
                                            blVar28 = this.ciK.cih;
                                            ccVar43.a(blVar28.QR(), this.ciK.cbG);
                                        }
                                        TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                ccVar25 = this.ciK.cim;
                                if (ccVar25.ckl.agS() != null) {
                                    ccVar38 = this.ciK.cim;
                                    if (view == ccVar38.ckl.agS().afY()) {
                                        ccVar39 = this.ciK.cim;
                                        ccVar39.agI();
                                        this.ciK.stopVoice();
                                        ccVar40 = this.ciK.cim;
                                        ccVar40.agt();
                                        blVar26 = this.ciK.cih;
                                        blVar26.afP();
                                        TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                ccVar26 = this.ciK.cim;
                                if (ccVar26.ckl.agS() != null) {
                                    ccVar36 = this.ciK.cim;
                                    if (view == ccVar36.ckl.agS().afZ()) {
                                        blVar20 = this.ciK.cih;
                                        if (blVar20 != null) {
                                            blVar21 = this.ciK.cih;
                                            if (blVar21.getPbData() != null) {
                                                blVar22 = this.ciK.cih;
                                                if (blVar22.getPbData().aeK() != null) {
                                                    ccVar37 = this.ciK.cim;
                                                    ccVar37.ckl.qr();
                                                    blVar23 = this.ciK.cih;
                                                    if (blVar23.getPbData().aeL() != null) {
                                                        blVar24 = this.ciK.cih;
                                                        if (blVar24.getPbData().aeL().size() > 0) {
                                                            PbActivity pbActivity = this.ciK;
                                                            blVar25 = this.ciK.cih;
                                                            pbActivity.jI(blVar25.getPbData().aeL().get(0).getId());
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
                                caVar = this.ciK.cir;
                                if (caVar != null) {
                                    caVar35 = this.ciK.cir;
                                    if (view == caVar35.agh()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                                                    sparseArray.put(i.f.tag_from, 0);
                                                    this.ciK.d(sparseArray);
                                                }
                                            }
                                        } else {
                                            this.ciK.jI((String) tag);
                                        }
                                        morePopupWindow11 = this.ciK.ciq;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow11, this.ciK.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                caVar2 = this.ciK.cir;
                                if (caVar2 != null) {
                                    caVar34 = this.ciK.cir;
                                    if (view == caVar34.afU()) {
                                        if (this.ciK.checkUpIsLogin()) {
                                            this.ciK.X(view);
                                        }
                                        morePopupWindow10 = this.ciK.ciq;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow10, this.ciK.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                ccVar27 = this.ciK.cim;
                                if (ccVar27.agn() != view) {
                                    caVar3 = this.ciK.cir;
                                    if (caVar3 != null) {
                                        caVar33 = this.ciK.cir;
                                        if (view == caVar33.agg()) {
                                            SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2 != null) {
                                                boolean booleanValue = ((Boolean) sparseArray2.get(i.f.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray2.get(i.f.tag_should_delete_visible)).booleanValue();
                                                boolean booleanValue3 = ((Boolean) sparseArray2.get(i.f.tag_display_reply_visible)).booleanValue();
                                                if (booleanValue) {
                                                    if (!booleanValue3) {
                                                        ccVar35 = this.ciK.cim;
                                                        ccVar35.ac(view);
                                                    } else {
                                                        sparseArray2.put(i.f.tag_from, 1);
                                                        this.ciK.d(sparseArray2);
                                                    }
                                                } else if (booleanValue2) {
                                                    ccVar34 = this.ciK.cim;
                                                    ccVar34.a(((Integer) sparseArray2.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray2.get(i.f.tag_del_post_id), ((Integer) sparseArray2.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(i.f.tag_del_post_is_self)).booleanValue());
                                                }
                                                morePopupWindow9 = this.ciK.ciq;
                                                com.baidu.adp.lib.g.j.a(morePopupWindow9, this.ciK.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() != i.f.pb_head_function_manage_delormanage) {
                                        caVar4 = this.ciK.cir;
                                        if (caVar4 != null) {
                                            caVar32 = this.ciK.cir;
                                        }
                                        if (view.getId() != i.f.sub_pb_more && view.getId() != i.f.sub_pb_item) {
                                            int id = view.getId();
                                            if (id == i.f.pb_u9_text_view) {
                                                if (this.ciK.checkUpIsLogin() && (aaVar = (com.baidu.tbadk.core.data.aa) view.getTag()) != null && !StringUtils.isNull(aaVar.sK())) {
                                                    TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.az.uT().b(this.ciK.getPageContext(), new String[]{aaVar.sK()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == i.f.reply) {
                                                morePopupWindow = this.ciK.ciq;
                                                if (morePopupWindow != null) {
                                                    caVar26 = this.ciK.cir;
                                                }
                                                this.ciK.afh();
                                                morePopupWindow2 = this.ciK.ciq;
                                                if (morePopupWindow2.getIsIntercepted()) {
                                                    morePopupWindow5 = this.ciK.ciq;
                                                    morePopupWindow5.setIsIntercepted(false);
                                                    return;
                                                }
                                                com.baidu.tieba.tbadkCore.data.k kVar = null;
                                                if (view != null && view.getTag() != null) {
                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                    kVar = (com.baidu.tieba.tbadkCore.data.k) sparseArray3.get(i.f.tag_load_sub_data);
                                                    SparseArray sparseArray4 = new SparseArray();
                                                    sparseArray4.put(i.f.tag_load_sub_data, kVar);
                                                    sparseArray4.put(i.f.tag_load_sub_view, (View) sparseArray3.get(i.f.tag_load_sub_view));
                                                    caVar10 = this.ciK.cir;
                                                    caVar10.agf().setTag(sparseArray4);
                                                    SparseArray sparseArray5 = new SparseArray();
                                                    sparseArray5.put(i.f.tag_clip_board, (com.baidu.tieba.tbadkCore.data.k) ((SparseArray) view.getTag()).get(i.f.tag_clip_board));
                                                    sparseArray5.put(i.f.tag_is_subpb, false);
                                                    caVar11 = this.ciK.cir;
                                                    caVar11.afU().setTag(sparseArray5);
                                                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                    boolean booleanValue4 = ((Boolean) sparseArray6.get(i.f.tag_should_manage_visible)).booleanValue();
                                                    boolean booleanValue5 = ((Boolean) sparseArray6.get(i.f.tag_display_reply_visible)).booleanValue();
                                                    boolean booleanValue6 = ((Boolean) sparseArray6.get(i.f.tag_should_delete_visible)).booleanValue();
                                                    if (!(sparseArray6.get(i.f.tag_del_post_is_self) instanceof Boolean)) {
                                                        z = false;
                                                    } else {
                                                        z = ((Boolean) sparseArray6.get(i.f.tag_del_post_is_self)).booleanValue();
                                                    }
                                                    String str2 = null;
                                                    if (sparseArray6.get(i.f.tag_forbid_user_post_id) instanceof String) {
                                                        str2 = (String) sparseArray6.get(i.f.tag_forbid_user_post_id);
                                                    }
                                                    if (booleanValue4) {
                                                        SparseArray sparseArray7 = new SparseArray();
                                                        sparseArray7.put(i.f.tag_should_manage_visible, true);
                                                        sparseArray7.put(i.f.tag_manage_user_identity, sparseArray6.get(i.f.tag_manage_user_identity));
                                                        sparseArray7.put(i.f.tag_forbid_user_name, sparseArray6.get(i.f.tag_forbid_user_name));
                                                        sparseArray7.put(i.f.tag_forbid_user_post_id, str2);
                                                        if (booleanValue5) {
                                                            sparseArray7.put(i.f.tag_display_reply_visible, true);
                                                            sparseArray7.put(i.f.tag_is_mem, sparseArray6.get(i.f.tag_is_mem));
                                                            sparseArray7.put(i.f.tag_disable_reply_mute_userid, sparseArray6.get(i.f.tag_disable_reply_mute_userid));
                                                            sparseArray7.put(i.f.tag_disable_reply_mute_username, sparseArray6.get(i.f.tag_disable_reply_mute_username));
                                                            sparseArray7.put(i.f.tag_disable_reply_post_id, sparseArray6.get(i.f.tag_disable_reply_post_id));
                                                            sparseArray7.put(i.f.tag_disable_reply_thread_id, sparseArray6.get(i.f.tag_disable_reply_thread_id));
                                                        } else {
                                                            sparseArray7.put(i.f.tag_display_reply_visible, false);
                                                        }
                                                        if (booleanValue6) {
                                                            sparseArray7.put(i.f.tag_should_delete_visible, true);
                                                            sparseArray7.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
                                                            sparseArray7.put(i.f.tag_del_post_id, sparseArray6.get(i.f.tag_del_post_id));
                                                            sparseArray7.put(i.f.tag_del_post_type, sparseArray6.get(i.f.tag_del_post_type));
                                                        } else {
                                                            sparseArray7.put(i.f.tag_should_delete_visible, false);
                                                        }
                                                        caVar23 = this.ciK.cir;
                                                        caVar23.agg().setTag(sparseArray7);
                                                        caVar24 = this.ciK.cir;
                                                        com.baidu.tbadk.core.util.an.c(caVar24.agg(), i.e.icon_pb_set_n);
                                                        caVar25 = this.ciK.cir;
                                                        caVar25.agg().setVisibility(0);
                                                    } else if (!booleanValue6) {
                                                        caVar12 = this.ciK.cir;
                                                        caVar12.agg().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray8 = new SparseArray();
                                                        sparseArray8.put(i.f.tag_should_manage_visible, false);
                                                        sparseArray8.put(i.f.tag_display_reply_visible, false);
                                                        sparseArray8.put(i.f.tag_should_delete_visible, true);
                                                        sparseArray8.put(i.f.tag_manage_user_identity, sparseArray6.get(i.f.tag_manage_user_identity));
                                                        sparseArray8.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
                                                        sparseArray8.put(i.f.tag_del_post_id, sparseArray6.get(i.f.tag_del_post_id));
                                                        sparseArray8.put(i.f.tag_del_post_type, sparseArray6.get(i.f.tag_del_post_type));
                                                        caVar13 = this.ciK.cir;
                                                        caVar13.agg().setTag(sparseArray8);
                                                        caVar14 = this.ciK.cir;
                                                        com.baidu.tbadk.core.util.an.c(caVar14.agg(), i.e.icon_pb_del_n);
                                                        caVar15 = this.ciK.cir;
                                                        caVar15.agg().setVisibility(0);
                                                    }
                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                    if (!(sparseArray9.get(i.f.tag_display_reply_visible) instanceof Boolean)) {
                                                        z2 = false;
                                                    } else {
                                                        z2 = ((Boolean) sparseArray9.get(i.f.tag_display_reply_visible)).booleanValue();
                                                    }
                                                    if (!((Boolean) sparseArray9.get(i.f.tag_should_manage_visible)).booleanValue() && z2) {
                                                        SparseArray sparseArray10 = new SparseArray();
                                                        sparseArray10.put(i.f.tag_display_reply_visible, true);
                                                        sparseArray10.put(i.f.tag_is_mem, sparseArray9.get(i.f.tag_is_mem));
                                                        sparseArray10.put(i.f.tag_disable_reply_mute_userid, sparseArray9.get(i.f.tag_disable_reply_mute_userid));
                                                        sparseArray10.put(i.f.tag_disable_reply_mute_username, sparseArray9.get(i.f.tag_disable_reply_mute_username));
                                                        sparseArray10.put(i.f.tag_disable_reply_post_id, sparseArray9.get(i.f.tag_disable_reply_post_id));
                                                        sparseArray10.put(i.f.tag_disable_reply_thread_id, sparseArray9.get(i.f.tag_disable_reply_thread_id));
                                                        sparseArray10.put(i.f.tag_del_post_is_self, sparseArray9.get(i.f.tag_del_post_is_self));
                                                        sparseArray10.put(i.f.tag_del_post_type, sparseArray9.get(i.f.tag_del_post_type));
                                                        sparseArray10.put(i.f.tag_del_post_id, sparseArray9.get(i.f.tag_del_post_id));
                                                        sparseArray10.put(i.f.tag_manage_user_identity, sparseArray9.get(i.f.tag_manage_user_identity));
                                                        caVar19 = this.ciK.cir;
                                                        caVar19.agh().setTag(sparseArray10);
                                                        caVar20 = this.ciK.cir;
                                                        caVar20.agh().setVisibility(0);
                                                        caVar21 = this.ciK.cir;
                                                        caVar21.agg().setVisibility(8);
                                                        caVar22 = this.ciK.cir;
                                                        com.baidu.tbadk.core.util.an.c(caVar22.agh(), i.e.icon_pb_gag);
                                                    } else {
                                                        boolean z4 = false;
                                                        if (sparseArray9.get(i.f.tag_del_post_is_self) instanceof Boolean) {
                                                            z4 = ((Boolean) sparseArray9.get(i.f.tag_del_post_is_self)).booleanValue();
                                                        }
                                                        if (!(sparseArray9.get(i.f.tag_forbid_user_post_id) instanceof String)) {
                                                            str = null;
                                                        } else {
                                                            str = (String) sparseArray9.get(i.f.tag_forbid_user_post_id);
                                                        }
                                                        es = this.ciK.es(z4);
                                                        if (es & this.ciK.isLogin()) {
                                                            caVar17 = this.ciK.cir;
                                                            caVar17.agh().setVisibility(0);
                                                            caVar18 = this.ciK.cir;
                                                            caVar18.agh().setTag(str);
                                                        } else {
                                                            caVar16 = this.ciK.cir;
                                                            caVar16.agh().setVisibility(8);
                                                        }
                                                    }
                                                }
                                                boolean z5 = false;
                                                blVar11 = this.ciK.cih;
                                                if (blVar11.getPbData().qh()) {
                                                    blVar12 = this.ciK.cih;
                                                    String qg = blVar12.getPbData().qg();
                                                    if (kVar != null && !com.baidu.adp.lib.util.j.isEmpty(qg) && qg.equals(kVar.getId())) {
                                                        z5 = true;
                                                    }
                                                }
                                                if (z5) {
                                                    caVar8 = this.ciK.cir;
                                                    caVar8.afU().setText(i.h.marked);
                                                    caVar9 = this.ciK.cir;
                                                    caVar9.afU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                } else {
                                                    caVar5 = this.ciK.cir;
                                                    caVar5.afU().setText(i.h.mark);
                                                    caVar6 = this.ciK.cir;
                                                    caVar6.afU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                }
                                                caVar7 = this.ciK.cir;
                                                caVar7.eC(true);
                                                morePopupWindow3 = this.ciK.ciq;
                                                morePopupWindow3.reLayoutWidth();
                                                morePopupWindow4 = this.ciK.ciq;
                                                morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                return;
                                            } else if (id != i.f.pb_head_reverse_hint) {
                                                if (id == i.f.pb_act_btn) {
                                                    blVar4 = this.ciK.cih;
                                                    if (blVar4.getPbData() != null) {
                                                        blVar5 = this.ciK.cih;
                                                        if (blVar5.getPbData().aeK() != null) {
                                                            blVar6 = this.ciK.cih;
                                                            if (blVar6.getPbData().aeK().sw() != null) {
                                                                Activity activity = this.ciK.getActivity();
                                                                blVar7 = this.ciK.cih;
                                                                com.baidu.tbadk.browser.g.B(activity, blVar7.getPbData().aeK().sw());
                                                                blVar8 = this.ciK.cih;
                                                                if (blVar8.getPbData().aeK().su() != 1) {
                                                                    blVar9 = this.ciK.cih;
                                                                    if (blVar9.getPbData().aeK().su() == 2) {
                                                                        TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == i.f.pb_item_tail_content) {
                                                    String string = TbadkCoreApplication.m411getInst().getString(i.h.tail_web_view_title);
                                                    String string2 = com.baidu.tbadk.core.sharedPref.b.tr().getString("tail_link", "");
                                                    if (!StringUtils.isNull(string2)) {
                                                        TiebaStatic.log("c10056");
                                                        com.baidu.tbadk.browser.g.a(view.getContext(), string, string2, true, true, true);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                this.ciK.stopVoice();
                                                ccVar28 = this.ciK.cim;
                                                ccVar28.agI();
                                                ccVar29 = this.ciK.cim;
                                                ccVar29.agt();
                                                blVar10 = this.ciK.cih;
                                                blVar10.afP();
                                                return;
                                            }
                                        }
                                        if (!this.ciK.checkUpIsLogin()) {
                                            morePopupWindow8 = this.ciK.ciq;
                                            com.baidu.adp.lib.g.j.a(morePopupWindow8, this.ciK.getPageContext().getPageActivity());
                                            return;
                                        }
                                        caVar27 = this.ciK.cir;
                                        if (caVar27 != null) {
                                            caVar30 = this.ciK.cir;
                                            if (view == caVar30.agf()) {
                                                caVar31 = this.ciK.cir;
                                                if (!caVar31.age()) {
                                                    morePopupWindow7 = this.ciK.ciq;
                                                    com.baidu.adp.lib.g.j.a(morePopupWindow7, this.ciK.getPageContext().getPageActivity());
                                                    return;
                                                }
                                            }
                                        }
                                        blVar13 = this.ciK.cih;
                                        if (blVar13.getPbData() != null) {
                                            ccVar30 = this.ciK.cim;
                                            ccVar30.agI();
                                            SparseArray sparseArray11 = (SparseArray) view.getTag();
                                            com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) sparseArray11.get(i.f.tag_load_sub_data);
                                            View view2 = (View) sparseArray11.get(i.f.tag_load_sub_view);
                                            if (kVar2 != null && view2 != null) {
                                                blVar14 = this.ciK.cih;
                                                String threadID = blVar14.getThreadID();
                                                String id2 = kVar2.getId();
                                                int i2 = 0;
                                                blVar15 = this.ciK.cih;
                                                if (blVar15.getPbData() != null) {
                                                    blVar19 = this.ciK.cih;
                                                    i2 = blVar19.getPbData().aeO();
                                                }
                                                this.ciK.stopVoice();
                                                caVar28 = this.ciK.cir;
                                                if (caVar28 != null) {
                                                    caVar29 = this.ciK.cir;
                                                    if (view == caVar29.agf()) {
                                                        morePopupWindow6 = this.ciK.ciq;
                                                        com.baidu.adp.lib.g.j.a(morePopupWindow6, this.ciK.getPageContext().getPageActivity());
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.ciK.getPageContext().getPageActivity());
                                                        SmallTailInfo ahK = kVar2.ahK();
                                                        blVar18 = this.ciK.cih;
                                                        this.ciK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, ahK, blVar18.getPbData().rC(), false)));
                                                        return;
                                                    }
                                                }
                                                if (view.getId() == i.f.sub_pb_item) {
                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                    String str3 = (String) sparseArray12.get(i.f.tag_photo_username);
                                                    com.baidu.tieba.tbadkCore.data.k kVar3 = (com.baidu.tieba.tbadkCore.data.k) sparseArray12.get(i.f.tag_clip_board);
                                                    String str4 = null;
                                                    if (kVar3 != null) {
                                                        str4 = kVar3.getId();
                                                    }
                                                    TiebaStatic.log("c10088");
                                                    SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.ciK.getPageContext().getPageActivity());
                                                    SmallTailInfo ahK2 = kVar2.ahK();
                                                    blVar17 = this.ciK.cih;
                                                    this.ciK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id2, "pb", true, str3, true, str4, i2, ahK2, blVar17.getPbData().rC(), false)));
                                                    return;
                                                } else if (kVar2.awM()) {
                                                    TiebaStatic.log("c10089");
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.ciK.getPageContext().getPageActivity());
                                                    SmallTailInfo ahK3 = kVar2.ahK();
                                                    blVar16 = this.ciK.cih;
                                                    this.ciK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i2, ahK3, blVar16.getPbData().rC(), false)));
                                                    return;
                                                } else {
                                                    kVar2.gt(true);
                                                    ccVar31 = this.ciK.cim;
                                                    ccVar31.ago().notifyDataSetChanged();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                    if (((Boolean) sparseArray13.get(i.f.tag_should_manage_visible)).booleanValue()) {
                                        ccVar33 = this.ciK.cim;
                                        ccVar33.ac(view);
                                        return;
                                    }
                                    ccVar32 = this.ciK.cim;
                                    ccVar32.a(((Integer) sparseArray13.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray13.get(i.f.tag_del_post_id), ((Integer) sparseArray13.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray13.get(i.f.tag_del_post_is_self)).booleanValue());
                                    return;
                                } else if (this.ciK.checkUpIsLogin()) {
                                    this.ciK.aff();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            blVar41 = this.ciK.cih;
                            String name = blVar41.getPbData().aeJ().getName();
                            blVar42 = this.ciK.cih;
                            if (!TextUtils.isEmpty(blVar42.afG())) {
                                blVar43 = this.ciK.cih;
                                if (blVar43.afG().equals(name)) {
                                    this.ciK.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.as.aP(name)) {
                                this.ciK.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ciK.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        ccVar5 = this.ciK.cim;
        ccVar5.agJ();
        blVar = this.ciK.cih;
        if (blVar.getPbData().aeO() == 1) {
            aVar = this.ciK.cij;
            if (!aVar.axs()) {
                ccVar6 = this.ciK.cim;
                ccVar6.agq();
                int i3 = 0;
                ccVar7 = this.ciK.cim;
                if (view != ccVar7.agD()) {
                    ccVar8 = this.ciK.cim;
                    if (view != ccVar8.agE()) {
                        ccVar9 = this.ciK.cim;
                        if (view != ccVar9.agF()) {
                            ccVar10 = this.ciK.cim;
                            if (view != ccVar10.agG()) {
                                ccVar11 = this.ciK.cim;
                                if (view == ccVar11.agr()) {
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
                blVar2 = this.ciK.cih;
                ForumData aeJ2 = blVar2.getPbData().aeJ();
                String name2 = aeJ2.getName();
                String id3 = aeJ2.getId();
                blVar3 = this.ciK.cih;
                String id4 = blVar3.getPbData().aeK().getId();
                aVar2 = this.ciK.cij;
                ccVar12 = this.ciK.cim;
                aVar2.b(id3, name2, id4, i3, ccVar12.ags());
            }
        }
    }
}
