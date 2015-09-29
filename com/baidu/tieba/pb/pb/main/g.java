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
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v86, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0929, code lost:
        if (r21 != r1.agj()) goto L255;
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
        com.baidu.tbadk.core.data.z zVar;
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
        String afz;
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
        ccVar = this.ciz.cia;
        if (view == ccVar.getNextView()) {
            blVar48 = this.ciz.chV;
            if (blVar48.ex(true)) {
                ccVar56 = this.ciz.cia;
                ccVar56.agz();
                return;
            }
            return;
        }
        ccVar2 = this.ciz.cia;
        if (view == ccVar2.agR()) {
            ccVar53 = this.ciz.cia;
            ccVar53.agM();
            this.ciz.stopVoice();
            ccVar54 = this.ciz.cia;
            ccVar54.agx();
            ccVar55 = this.ciz.cia;
            ccVar55.Zf();
            blVar47 = this.ciz.chV;
            blVar47.iM(1);
            return;
        }
        ccVar3 = this.ciz.cia;
        if (view == ccVar3.cka.ayW) {
            ccVar52 = this.ciz.cia;
            blVar46 = this.ciz.chV;
            if (!ccVar52.eM(blVar46.afP())) {
                this.ciz.finish();
                return;
            } else {
                this.ciz.stopVoice();
                return;
            }
        }
        ccVar4 = this.ciz.cia;
        if (view != ccVar4.agH()) {
            ccVar13 = this.ciz.cia;
            if (view != ccVar13.agI()) {
                ccVar14 = this.ciz.cia;
                if (view != ccVar14.agJ()) {
                    ccVar15 = this.ciz.cia;
                    if (view != ccVar15.agK()) {
                        ccVar16 = this.ciz.cia;
                        if (view != ccVar16.agv()) {
                            ccVar17 = this.ciz.cia;
                            if (view == ccVar17.agO()) {
                                blVar44 = this.ciz.chV;
                                if (blVar44 != null) {
                                    blVar45 = this.ciz.chV;
                                    com.baidu.tbadk.browser.g.B(this.ciz.getPageContext().getPageActivity(), blVar45.getPbData().aeO().si().getLink());
                                    return;
                                }
                                return;
                            }
                            ccVar18 = this.ciz.cia;
                            if (view != ccVar18.cka.clJ) {
                                ccVar19 = this.ciz.cia;
                                if (view == ccVar19.cka.clL) {
                                    blVar37 = this.ciz.chV;
                                    if (blVar37 != null) {
                                        blVar38 = this.ciz.chV;
                                        if (blVar38.getPbData() != null) {
                                            blVar39 = this.ciz.chV;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = blVar39.getPbData().aeP();
                                            if (aeP == null || aeP.size() <= 0) {
                                                blVar40 = this.ciz.chV;
                                                if (blVar40.afL()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.ciz.getPageContext().getPageActivity(), this.ciz.getPageContext().getString(i.h.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            this.ciz.afn();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.ciz.getPageContext().getPageActivity(), this.ciz.getPageContext().getString(i.h.pb_no_data_tips));
                                    return;
                                }
                                ccVar20 = this.ciz.cia;
                                if (view == ccVar20.cka.clK) {
                                    z3 = this.ciz.att;
                                    if (!z3) {
                                        this.ciz.att = true;
                                        ccVar49 = this.ciz.cia;
                                        ccVar49.cka.clK.setEnabled(false);
                                        ccVar50 = this.ciz.cia;
                                        ccVar50.Vw();
                                        this.ciz.stopVoice();
                                        ccVar51 = this.ciz.cia;
                                        ccVar51.agx();
                                        blVar36 = this.ciz.chV;
                                        afz = this.ciz.afz();
                                        blVar36.jN(afz);
                                        TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                ccVar21 = this.ciz.cia;
                                if (view == ccVar21.cka.clM) {
                                    blVar30 = this.ciz.chV;
                                    AdditionData aeV = blVar30.getPbData().aeV();
                                    if (!TextUtils.isEmpty(aeV.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.ciz.getPageContext().getPageActivity(), aeV.getWarnMsg());
                                        return;
                                    } else if (aeV.getAlreadyCount() != aeV.getTotalCount()) {
                                        blVar31 = this.ciz.chV;
                                        ForumData aeN = blVar31.getPbData().aeN();
                                        blVar32 = this.ciz.chV;
                                        com.baidu.tbadk.core.data.v aeO = blVar32.getPbData().aeO();
                                        blVar33 = this.ciz.chV;
                                        AntiData rF = blVar33.getPbData().rF();
                                        if (aeO.getId() != null) {
                                            if (rF == null || rF.getIfpost() != 0) {
                                                int i = 0;
                                                blVar34 = this.ciz.chV;
                                                if (blVar34.getPbData().getUserData() != null) {
                                                    blVar35 = this.ciz.chV;
                                                    i = blVar35.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.ciz.getPageContext().getPageActivity(), 2, aeN.getId(), aeN.getName(), aeO.getId(), aeV.getPostId(), 0, rF, 13008, false, false, null, false, false, null, aeV, null, i)));
                                                return;
                                            }
                                            com.baidu.adp.lib.util.k.showToast(this.ciz.getPageContext().getPageActivity(), rF.getForbid_info());
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.ciz.getPageContext().getPageActivity(), String.format(this.ciz.getPageContext().getString(i.h.write_addition_limit), Integer.valueOf(aeV.getTotalCount())));
                                        return;
                                    }
                                }
                                ccVar22 = this.ciz.cia;
                                if (ccVar22.cka.agW() != null) {
                                    ccVar46 = this.ciz.cia;
                                    if (view == ccVar46.cka.agW().afY()) {
                                        ccVar47 = this.ciz.cia;
                                        ccVar47.agM();
                                        iJ = this.ciz.iJ(11009);
                                        if (iJ) {
                                            blVar29 = this.ciz.chV;
                                            ccVar48 = this.ciz.cia;
                                            if (blVar29.iS(ccVar48.agD()) == null) {
                                                return;
                                            }
                                            this.ciz.afr();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ccVar23 = this.ciz.cia;
                                if (ccVar23.cka.agW() != null) {
                                    ccVar44 = this.ciz.cia;
                                    if (view == ccVar44.cka.agW().afZ()) {
                                        ccVar45 = this.ciz.cia;
                                        ccVar45.agM();
                                        this.ciz.stopVoice();
                                        this.ciz.showShareDialog();
                                        return;
                                    }
                                }
                                ccVar24 = this.ciz.cia;
                                if (ccVar24.cka.agW() != null) {
                                    ccVar41 = this.ciz.cia;
                                    if (view == ccVar41.cka.agW().agb()) {
                                        ccVar42 = this.ciz.cia;
                                        ccVar42.agM();
                                        blVar27 = this.ciz.chV;
                                        if (blVar27.QV() != null) {
                                            ccVar43 = this.ciz.cia;
                                            blVar28 = this.ciz.chV;
                                            ccVar43.a(blVar28.QV(), this.ciz.cbv);
                                        }
                                        TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                ccVar25 = this.ciz.cia;
                                if (ccVar25.cka.agW() != null) {
                                    ccVar38 = this.ciz.cia;
                                    if (view == ccVar38.cka.agW().agc()) {
                                        ccVar39 = this.ciz.cia;
                                        ccVar39.agM();
                                        this.ciz.stopVoice();
                                        ccVar40 = this.ciz.cia;
                                        ccVar40.agx();
                                        blVar26 = this.ciz.chV;
                                        blVar26.afT();
                                        TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                ccVar26 = this.ciz.cia;
                                if (ccVar26.cka.agW() != null) {
                                    ccVar36 = this.ciz.cia;
                                    if (view == ccVar36.cka.agW().agd()) {
                                        blVar20 = this.ciz.chV;
                                        if (blVar20 != null) {
                                            blVar21 = this.ciz.chV;
                                            if (blVar21.getPbData() != null) {
                                                blVar22 = this.ciz.chV;
                                                if (blVar22.getPbData().aeO() != null) {
                                                    ccVar37 = this.ciz.cia;
                                                    ccVar37.cka.qu();
                                                    blVar23 = this.ciz.chV;
                                                    if (blVar23.getPbData().aeP() != null) {
                                                        blVar24 = this.ciz.chV;
                                                        if (blVar24.getPbData().aeP().size() > 0) {
                                                            PbActivity pbActivity = this.ciz;
                                                            blVar25 = this.ciz.chV;
                                                            pbActivity.jI(blVar25.getPbData().aeP().get(0).getId());
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
                                caVar = this.ciz.cig;
                                if (caVar != null) {
                                    caVar35 = this.ciz.cig;
                                    if (view == caVar35.agl()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                                                    sparseArray.put(i.f.tag_from, 0);
                                                    this.ciz.d(sparseArray);
                                                }
                                            }
                                        } else {
                                            this.ciz.jI((String) tag);
                                        }
                                        morePopupWindow11 = this.ciz.cif;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow11, this.ciz.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                caVar2 = this.ciz.cig;
                                if (caVar2 != null) {
                                    caVar34 = this.ciz.cig;
                                    if (view == caVar34.afY()) {
                                        if (this.ciz.checkUpIsLogin()) {
                                            this.ciz.X(view);
                                        }
                                        morePopupWindow10 = this.ciz.cif;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow10, this.ciz.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                ccVar27 = this.ciz.cia;
                                if (ccVar27.agr() != view) {
                                    caVar3 = this.ciz.cig;
                                    if (caVar3 != null) {
                                        caVar33 = this.ciz.cig;
                                        if (view == caVar33.agk()) {
                                            SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2 != null) {
                                                boolean booleanValue = ((Boolean) sparseArray2.get(i.f.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray2.get(i.f.tag_should_delete_visible)).booleanValue();
                                                boolean booleanValue3 = ((Boolean) sparseArray2.get(i.f.tag_display_reply_visible)).booleanValue();
                                                if (booleanValue) {
                                                    if (!booleanValue3) {
                                                        ccVar35 = this.ciz.cia;
                                                        ccVar35.ac(view);
                                                    } else {
                                                        sparseArray2.put(i.f.tag_from, 1);
                                                        this.ciz.d(sparseArray2);
                                                    }
                                                } else if (booleanValue2) {
                                                    ccVar34 = this.ciz.cia;
                                                    ccVar34.a(((Integer) sparseArray2.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray2.get(i.f.tag_del_post_id), ((Integer) sparseArray2.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(i.f.tag_del_post_is_self)).booleanValue());
                                                }
                                                morePopupWindow9 = this.ciz.cif;
                                                com.baidu.adp.lib.g.j.a(morePopupWindow9, this.ciz.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() != i.f.pb_head_function_manage_delormanage) {
                                        caVar4 = this.ciz.cig;
                                        if (caVar4 != null) {
                                            caVar32 = this.ciz.cig;
                                        }
                                        if (view.getId() != i.f.sub_pb_more && view.getId() != i.f.sub_pb_item) {
                                            int id = view.getId();
                                            if (id == i.f.pb_u9_text_view) {
                                                if (this.ciz.checkUpIsLogin() && (zVar = (com.baidu.tbadk.core.data.z) view.getTag()) != null && !StringUtils.isNull(zVar.sN())) {
                                                    TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.ay.uV().b(this.ciz.getPageContext(), new String[]{zVar.sN()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == i.f.reply) {
                                                morePopupWindow = this.ciz.cif;
                                                if (morePopupWindow != null) {
                                                    caVar26 = this.ciz.cig;
                                                }
                                                this.ciz.afl();
                                                morePopupWindow2 = this.ciz.cif;
                                                if (morePopupWindow2.getIsIntercepted()) {
                                                    morePopupWindow5 = this.ciz.cif;
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
                                                    caVar10 = this.ciz.cig;
                                                    caVar10.agj().setTag(sparseArray4);
                                                    SparseArray sparseArray5 = new SparseArray();
                                                    sparseArray5.put(i.f.tag_clip_board, (com.baidu.tieba.tbadkCore.data.k) ((SparseArray) view.getTag()).get(i.f.tag_clip_board));
                                                    sparseArray5.put(i.f.tag_is_subpb, false);
                                                    caVar11 = this.ciz.cig;
                                                    caVar11.afY().setTag(sparseArray5);
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
                                                        caVar23 = this.ciz.cig;
                                                        caVar23.agk().setTag(sparseArray7);
                                                        caVar24 = this.ciz.cig;
                                                        com.baidu.tbadk.core.util.am.c(caVar24.agk(), i.e.icon_pb_set_n);
                                                        caVar25 = this.ciz.cig;
                                                        caVar25.agk().setVisibility(0);
                                                    } else if (!booleanValue6) {
                                                        caVar12 = this.ciz.cig;
                                                        caVar12.agk().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray8 = new SparseArray();
                                                        sparseArray8.put(i.f.tag_should_manage_visible, false);
                                                        sparseArray8.put(i.f.tag_display_reply_visible, false);
                                                        sparseArray8.put(i.f.tag_should_delete_visible, true);
                                                        sparseArray8.put(i.f.tag_manage_user_identity, sparseArray6.get(i.f.tag_manage_user_identity));
                                                        sparseArray8.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
                                                        sparseArray8.put(i.f.tag_del_post_id, sparseArray6.get(i.f.tag_del_post_id));
                                                        sparseArray8.put(i.f.tag_del_post_type, sparseArray6.get(i.f.tag_del_post_type));
                                                        caVar13 = this.ciz.cig;
                                                        caVar13.agk().setTag(sparseArray8);
                                                        caVar14 = this.ciz.cig;
                                                        com.baidu.tbadk.core.util.am.c(caVar14.agk(), i.e.icon_pb_del_n);
                                                        caVar15 = this.ciz.cig;
                                                        caVar15.agk().setVisibility(0);
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
                                                        caVar19 = this.ciz.cig;
                                                        caVar19.agl().setTag(sparseArray10);
                                                        caVar20 = this.ciz.cig;
                                                        caVar20.agl().setVisibility(0);
                                                        caVar21 = this.ciz.cig;
                                                        caVar21.agk().setVisibility(8);
                                                        caVar22 = this.ciz.cig;
                                                        com.baidu.tbadk.core.util.am.c(caVar22.agl(), i.e.icon_pb_gag);
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
                                                        es = this.ciz.es(z4);
                                                        if (es & this.ciz.isLogin()) {
                                                            caVar17 = this.ciz.cig;
                                                            caVar17.agl().setVisibility(0);
                                                            caVar18 = this.ciz.cig;
                                                            caVar18.agl().setTag(str);
                                                        } else {
                                                            caVar16 = this.ciz.cig;
                                                            caVar16.agl().setVisibility(8);
                                                        }
                                                    }
                                                }
                                                boolean z5 = false;
                                                blVar11 = this.ciz.chV;
                                                if (blVar11.getPbData().qk()) {
                                                    blVar12 = this.ciz.chV;
                                                    String qj = blVar12.getPbData().qj();
                                                    if (kVar != null && !com.baidu.adp.lib.util.j.isEmpty(qj) && qj.equals(kVar.getId())) {
                                                        z5 = true;
                                                    }
                                                }
                                                if (z5) {
                                                    caVar8 = this.ciz.cig;
                                                    caVar8.afY().setText(i.h.marked);
                                                    caVar9 = this.ciz.cig;
                                                    caVar9.afY().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                } else {
                                                    caVar5 = this.ciz.cig;
                                                    caVar5.afY().setText(i.h.mark);
                                                    caVar6 = this.ciz.cig;
                                                    caVar6.afY().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                }
                                                caVar7 = this.ciz.cig;
                                                caVar7.eC(true);
                                                morePopupWindow3 = this.ciz.cif;
                                                morePopupWindow3.reLayoutWidth();
                                                morePopupWindow4 = this.ciz.cif;
                                                morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                return;
                                            } else if (id != i.f.pb_head_reverse_hint) {
                                                if (id == i.f.pb_act_btn) {
                                                    blVar4 = this.ciz.chV;
                                                    if (blVar4.getPbData() != null) {
                                                        blVar5 = this.ciz.chV;
                                                        if (blVar5.getPbData().aeO() != null) {
                                                            blVar6 = this.ciz.chV;
                                                            if (blVar6.getPbData().aeO().sz() != null) {
                                                                Activity activity = this.ciz.getActivity();
                                                                blVar7 = this.ciz.chV;
                                                                com.baidu.tbadk.browser.g.B(activity, blVar7.getPbData().aeO().sz());
                                                                blVar8 = this.ciz.chV;
                                                                if (blVar8.getPbData().aeO().sx() != 1) {
                                                                    blVar9 = this.ciz.chV;
                                                                    if (blVar9.getPbData().aeO().sx() == 2) {
                                                                        TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == i.f.pb_item_tail_content) {
                                                    String string = TbadkCoreApplication.m411getInst().getString(i.h.tail_web_view_title);
                                                    String string2 = com.baidu.tbadk.core.sharedPref.b.tu().getString("tail_link", "");
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
                                                this.ciz.stopVoice();
                                                ccVar28 = this.ciz.cia;
                                                ccVar28.agM();
                                                ccVar29 = this.ciz.cia;
                                                ccVar29.agx();
                                                blVar10 = this.ciz.chV;
                                                blVar10.afT();
                                                return;
                                            }
                                        }
                                        if (!this.ciz.checkUpIsLogin()) {
                                            morePopupWindow8 = this.ciz.cif;
                                            com.baidu.adp.lib.g.j.a(morePopupWindow8, this.ciz.getPageContext().getPageActivity());
                                            return;
                                        }
                                        caVar27 = this.ciz.cig;
                                        if (caVar27 != null) {
                                            caVar30 = this.ciz.cig;
                                            if (view == caVar30.agj()) {
                                                caVar31 = this.ciz.cig;
                                                if (!caVar31.agi()) {
                                                    morePopupWindow7 = this.ciz.cif;
                                                    com.baidu.adp.lib.g.j.a(morePopupWindow7, this.ciz.getPageContext().getPageActivity());
                                                    return;
                                                }
                                            }
                                        }
                                        blVar13 = this.ciz.chV;
                                        if (blVar13.getPbData() != null) {
                                            ccVar30 = this.ciz.cia;
                                            ccVar30.agM();
                                            SparseArray sparseArray11 = (SparseArray) view.getTag();
                                            com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) sparseArray11.get(i.f.tag_load_sub_data);
                                            View view2 = (View) sparseArray11.get(i.f.tag_load_sub_view);
                                            if (kVar2 != null && view2 != null) {
                                                blVar14 = this.ciz.chV;
                                                String threadID = blVar14.getThreadID();
                                                String id2 = kVar2.getId();
                                                int i2 = 0;
                                                blVar15 = this.ciz.chV;
                                                if (blVar15.getPbData() != null) {
                                                    blVar19 = this.ciz.chV;
                                                    i2 = blVar19.getPbData().aeS();
                                                }
                                                this.ciz.stopVoice();
                                                caVar28 = this.ciz.cig;
                                                if (caVar28 != null) {
                                                    caVar29 = this.ciz.cig;
                                                    if (view == caVar29.agj()) {
                                                        morePopupWindow6 = this.ciz.cif;
                                                        com.baidu.adp.lib.g.j.a(morePopupWindow6, this.ciz.getPageContext().getPageActivity());
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.ciz.getPageContext().getPageActivity());
                                                        SmallTailInfo ahO = kVar2.ahO();
                                                        blVar18 = this.ciz.chV;
                                                        this.ciz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, ahO, blVar18.getPbData().rF(), false)));
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
                                                    SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.ciz.getPageContext().getPageActivity());
                                                    SmallTailInfo ahO2 = kVar2.ahO();
                                                    blVar17 = this.ciz.chV;
                                                    this.ciz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id2, "pb", true, str3, true, str4, i2, ahO2, blVar17.getPbData().rF(), false)));
                                                    return;
                                                } else if (kVar2.awG()) {
                                                    TiebaStatic.log("c10089");
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.ciz.getPageContext().getPageActivity());
                                                    SmallTailInfo ahO3 = kVar2.ahO();
                                                    blVar16 = this.ciz.chV;
                                                    this.ciz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i2, ahO3, blVar16.getPbData().rF(), false)));
                                                    return;
                                                } else {
                                                    kVar2.gt(true);
                                                    ccVar31 = this.ciz.cia;
                                                    ccVar31.ags().notifyDataSetChanged();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                    if (((Boolean) sparseArray13.get(i.f.tag_should_manage_visible)).booleanValue()) {
                                        ccVar33 = this.ciz.cia;
                                        ccVar33.ac(view);
                                        return;
                                    }
                                    ccVar32 = this.ciz.cia;
                                    ccVar32.a(((Integer) sparseArray13.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray13.get(i.f.tag_del_post_id), ((Integer) sparseArray13.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray13.get(i.f.tag_del_post_is_self)).booleanValue());
                                    return;
                                } else if (this.ciz.checkUpIsLogin()) {
                                    this.ciz.afj();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            blVar41 = this.ciz.chV;
                            String name = blVar41.getPbData().aeN().getName();
                            blVar42 = this.ciz.chV;
                            if (!TextUtils.isEmpty(blVar42.afK())) {
                                blVar43 = this.ciz.chV;
                                if (blVar43.afK().equals(name)) {
                                    this.ciz.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.ar.aP(name)) {
                                this.ciz.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ciz.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        ccVar5 = this.ciz.cia;
        ccVar5.agN();
        blVar = this.ciz.chV;
        if (blVar.getPbData().aeS() == 1) {
            aVar = this.ciz.chX;
            if (!aVar.axm()) {
                ccVar6 = this.ciz.cia;
                ccVar6.agu();
                int i3 = 0;
                ccVar7 = this.ciz.cia;
                if (view != ccVar7.agH()) {
                    ccVar8 = this.ciz.cia;
                    if (view != ccVar8.agI()) {
                        ccVar9 = this.ciz.cia;
                        if (view != ccVar9.agJ()) {
                            ccVar10 = this.ciz.cia;
                            if (view != ccVar10.agK()) {
                                ccVar11 = this.ciz.cia;
                                if (view == ccVar11.agv()) {
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
                blVar2 = this.ciz.chV;
                ForumData aeN2 = blVar2.getPbData().aeN();
                String name2 = aeN2.getName();
                String id3 = aeN2.getId();
                blVar3 = this.ciz.chV;
                String id4 = blVar3.getPbData().aeO().getId();
                aVar2 = this.ciz.chX;
                ccVar12 = this.ciz.cia;
                aVar2.b(id3, name2, id4, i3, ccVar12.agw());
            }
        }
    }
}
