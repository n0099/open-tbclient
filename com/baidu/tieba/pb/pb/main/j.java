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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
class j implements View.OnClickListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v102, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0929, code lost:
        if (r21 != r1.agK()) goto L255;
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
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        ct ctVar5;
        ca caVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        ct ctVar6;
        ct ctVar7;
        ct ctVar8;
        ct ctVar9;
        ct ctVar10;
        ct ctVar11;
        ca caVar2;
        ca caVar3;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        ct ctVar12;
        ct ctVar13;
        ct ctVar14;
        ct ctVar15;
        ct ctVar16;
        ct ctVar17;
        ct ctVar18;
        ct ctVar19;
        ct ctVar20;
        ct ctVar21;
        ct ctVar22;
        ct ctVar23;
        ct ctVar24;
        ct ctVar25;
        ct ctVar26;
        cr crVar;
        cr crVar2;
        ct ctVar27;
        cr crVar3;
        cr crVar4;
        int afM;
        int afM2;
        ca caVar4;
        ca caVar5;
        ca caVar6;
        ca caVar7;
        ca caVar8;
        ca caVar9;
        ca caVar10;
        ca caVar11;
        ca caVar12;
        ca caVar13;
        ca caVar14;
        ca caVar15;
        ca caVar16;
        ca caVar17;
        ct ctVar28;
        ct ctVar29;
        ca caVar18;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        ca caVar19;
        cr crVar5;
        cr crVar6;
        cr crVar7;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        cr crVar8;
        cr crVar9;
        ca caVar20;
        cr crVar10;
        cr crVar11;
        boolean z;
        cr crVar12;
        cr crVar13;
        cr crVar14;
        cr crVar15;
        boolean z2;
        String str;
        boolean ev;
        cr crVar16;
        cr crVar17;
        cr crVar18;
        cr crVar19;
        cr crVar20;
        cr crVar21;
        cr crVar22;
        cr crVar23;
        cr crVar24;
        cr crVar25;
        MorePopupWindow morePopupWindow5;
        cr crVar26;
        com.baidu.tbadk.core.data.aa aaVar;
        cr crVar27;
        ca caVar21;
        ct ctVar30;
        ca caVar22;
        ca caVar23;
        cr crVar28;
        ct ctVar31;
        ca caVar24;
        ca caVar25;
        cr crVar29;
        MorePopupWindow morePopupWindow6;
        ca caVar26;
        ca caVar27;
        cr crVar30;
        cr crVar31;
        MorePopupWindow morePopupWindow7;
        MorePopupWindow morePopupWindow8;
        cr crVar32;
        ct ctVar32;
        ct ctVar33;
        cr crVar33;
        ct ctVar34;
        MorePopupWindow morePopupWindow9;
        ct ctVar35;
        cr crVar34;
        MorePopupWindow morePopupWindow10;
        cr crVar35;
        MorePopupWindow morePopupWindow11;
        ct ctVar36;
        ca caVar28;
        ca caVar29;
        ca caVar30;
        ct ctVar37;
        ca caVar31;
        ca caVar32;
        ca caVar33;
        ct ctVar38;
        ct ctVar39;
        ct ctVar40;
        ca caVar34;
        ct ctVar41;
        ct ctVar42;
        ca caVar35;
        ct ctVar43;
        ca caVar36;
        ct ctVar44;
        ct ctVar45;
        ct ctVar46;
        ct ctVar47;
        boolean iY;
        ca caVar37;
        ct ctVar48;
        ca caVar38;
        ca caVar39;
        ca caVar40;
        ca caVar41;
        ca caVar42;
        ca caVar43;
        boolean z3;
        ct ctVar49;
        ct ctVar50;
        ct ctVar51;
        ca caVar44;
        String afZ;
        ca caVar45;
        ca caVar46;
        ca caVar47;
        ca caVar48;
        ca caVar49;
        ca caVar50;
        ca caVar51;
        ca caVar52;
        ca caVar53;
        ct ctVar52;
        ca caVar54;
        ct ctVar53;
        ct ctVar54;
        ct ctVar55;
        ca caVar55;
        ca caVar56;
        ct ctVar56;
        ctVar = this.cjN.cjo;
        if (view == ctVar.getNextView()) {
            caVar56 = this.cjN.cjj;
            if (caVar56.eA(true)) {
                ctVar56 = this.cjN.cjo;
                ctVar56.ahb();
                return;
            }
            return;
        }
        ctVar2 = this.cjN.cjo;
        if (view == ctVar2.aht()) {
            ctVar53 = this.cjN.cjo;
            ctVar53.aho();
            this.cjN.stopVoice();
            ctVar54 = this.cjN.cjo;
            ctVar54.agZ();
            ctVar55 = this.cjN.cjo;
            ctVar55.Zw();
            caVar55 = this.cjN.cjj;
            caVar55.jb(1);
            return;
        }
        ctVar3 = this.cjN.cjo;
        if (view == ctVar3.cly.axV) {
            ctVar52 = this.cjN.cjo;
            caVar54 = this.cjN.cjj;
            if (!ctVar52.eP(caVar54.agq())) {
                this.cjN.finish();
                return;
            } else {
                this.cjN.stopVoice();
                return;
            }
        }
        ctVar4 = this.cjN.cjo;
        if (view != ctVar4.ahj()) {
            ctVar13 = this.cjN.cjo;
            if (view != ctVar13.ahk()) {
                ctVar14 = this.cjN.cjo;
                if (view != ctVar14.ahl()) {
                    ctVar15 = this.cjN.cjo;
                    if (view != ctVar15.ahm()) {
                        ctVar16 = this.cjN.cjo;
                        if (view != ctVar16.agX()) {
                            ctVar17 = this.cjN.cjo;
                            if (view == ctVar17.ahq()) {
                                caVar52 = this.cjN.cjj;
                                if (caVar52 != null) {
                                    caVar53 = this.cjN.cjj;
                                    com.baidu.tbadk.browser.g.B(this.cjN.getPageContext().getPageActivity(), caVar53.getPbData().afh().si().getLink());
                                    return;
                                }
                                return;
                            }
                            ctVar18 = this.cjN.cjo;
                            if (view != ctVar18.cly.cnj) {
                                ctVar19 = this.cjN.cjo;
                                if (view == ctVar19.cly.cnl) {
                                    caVar45 = this.cjN.cjj;
                                    if (caVar45 != null) {
                                        caVar46 = this.cjN.cjj;
                                        if (caVar46.getPbData() != null) {
                                            caVar47 = this.cjN.cjj;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = caVar47.getPbData().afi();
                                            if (afi == null || afi.size() <= 0) {
                                                caVar48 = this.cjN.cjj;
                                                if (caVar48.agm()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.cjN.getPageContext().getPageActivity(), this.cjN.getPageContext().getString(i.h.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            this.cjN.afN();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.cjN.getPageContext().getPageActivity(), this.cjN.getPageContext().getString(i.h.pb_no_data_tips));
                                    return;
                                }
                                ctVar20 = this.cjN.cjo;
                                if (view == ctVar20.cly.cnk) {
                                    z3 = this.cjN.asi;
                                    if (!z3) {
                                        this.cjN.asi = true;
                                        ctVar49 = this.cjN.cjo;
                                        ctVar49.cly.cnk.setEnabled(false);
                                        ctVar50 = this.cjN.cjo;
                                        ctVar50.VN();
                                        this.cjN.stopVoice();
                                        ctVar51 = this.cjN.cjo;
                                        ctVar51.agZ();
                                        caVar44 = this.cjN.cjj;
                                        afZ = this.cjN.afZ();
                                        caVar44.jQ(afZ);
                                        TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                ctVar21 = this.cjN.cjo;
                                if (view == ctVar21.cly.cnm) {
                                    caVar38 = this.cjN.cjj;
                                    AdditionData afo = caVar38.getPbData().afo();
                                    if (!TextUtils.isEmpty(afo.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.cjN.getPageContext().getPageActivity(), afo.getWarnMsg());
                                        return;
                                    } else if (afo.getAlreadyCount() != afo.getTotalCount()) {
                                        caVar39 = this.cjN.cjj;
                                        ForumData afg = caVar39.getPbData().afg();
                                        caVar40 = this.cjN.cjj;
                                        com.baidu.tbadk.core.data.w afh = caVar40.getPbData().afh();
                                        caVar41 = this.cjN.cjj;
                                        AntiData rE = caVar41.getPbData().rE();
                                        if (afh.getId() != null) {
                                            if (rE != null && rE.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.cjN.getPageContext().getPageActivity(), rE.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            caVar42 = this.cjN.cjj;
                                            if (caVar42.getPbData().getUserData() != null) {
                                                caVar43 = this.cjN.cjj;
                                                i = caVar43.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.cjN.getPageContext().getPageActivity(), 2, afg.getId(), afg.getName(), afh.getId(), afo.getPostId(), 0, rE, 13008, false, false, null, false, false, null, afo, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.cjN.getPageContext().getPageActivity(), String.format(this.cjN.getPageContext().getString(i.h.write_addition_limit), Integer.valueOf(afo.getTotalCount())));
                                        return;
                                    }
                                }
                                ctVar22 = this.cjN.cjo;
                                if (ctVar22.cly.ahy() != null) {
                                    ctVar46 = this.cjN.cjo;
                                    if (view == ctVar46.cly.ahy().agz()) {
                                        ctVar47 = this.cjN.cjo;
                                        ctVar47.aho();
                                        iY = this.cjN.iY(11009);
                                        if (iY) {
                                            caVar37 = this.cjN.cjj;
                                            ctVar48 = this.cjN.cjo;
                                            if (caVar37.jh(ctVar48.ahf()) == null) {
                                                return;
                                            }
                                            this.cjN.afR();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ctVar23 = this.cjN.cjo;
                                if (ctVar23.cly.ahy() != null) {
                                    ctVar44 = this.cjN.cjo;
                                    if (view == ctVar44.cly.ahy().agA()) {
                                        ctVar45 = this.cjN.cjo;
                                        ctVar45.aho();
                                        this.cjN.stopVoice();
                                        this.cjN.showShareDialog();
                                        return;
                                    }
                                }
                                ctVar24 = this.cjN.cjo;
                                if (ctVar24.cly.ahy() != null) {
                                    ctVar41 = this.cjN.cjo;
                                    if (view == ctVar41.cly.ahy().agC()) {
                                        ctVar42 = this.cjN.cjo;
                                        ctVar42.aho();
                                        caVar35 = this.cjN.cjj;
                                        if (caVar35.Rn() != null) {
                                            ctVar43 = this.cjN.cjo;
                                            caVar36 = this.cjN.cjj;
                                            ctVar43.a(caVar36.Rn(), this.cjN.cch);
                                        }
                                        TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                ctVar25 = this.cjN.cjo;
                                if (ctVar25.cly.ahy() != null) {
                                    ctVar38 = this.cjN.cjo;
                                    if (view == ctVar38.cly.ahy().agD()) {
                                        ctVar39 = this.cjN.cjo;
                                        ctVar39.aho();
                                        this.cjN.stopVoice();
                                        ctVar40 = this.cjN.cjo;
                                        ctVar40.agZ();
                                        caVar34 = this.cjN.cjj;
                                        caVar34.agu();
                                        TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                ctVar26 = this.cjN.cjo;
                                if (ctVar26.cly.ahy() != null) {
                                    ctVar36 = this.cjN.cjo;
                                    if (view == ctVar36.cly.ahy().agE()) {
                                        caVar28 = this.cjN.cjj;
                                        if (caVar28 != null) {
                                            caVar29 = this.cjN.cjj;
                                            if (caVar29.getPbData() != null) {
                                                caVar30 = this.cjN.cjj;
                                                if (caVar30.getPbData().afh() != null) {
                                                    ctVar37 = this.cjN.cjo;
                                                    ctVar37.cly.qs();
                                                    caVar31 = this.cjN.cjj;
                                                    if (caVar31.getPbData().afi() != null) {
                                                        caVar32 = this.cjN.cjj;
                                                        if (caVar32.getPbData().afi().size() > 0) {
                                                            PbActivity pbActivity = this.cjN;
                                                            caVar33 = this.cjN.cjj;
                                                            pbActivity.jK(caVar33.getPbData().afi().get(0).getId());
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
                                crVar = this.cjN.cjt;
                                if (crVar != null) {
                                    crVar35 = this.cjN.cjt;
                                    if (view == crVar35.agM()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                                                    sparseArray.put(i.f.tag_from, 0);
                                                    this.cjN.d(sparseArray);
                                                }
                                            }
                                        } else {
                                            this.cjN.jK((String) tag);
                                        }
                                        morePopupWindow11 = this.cjN.cjs;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow11, this.cjN.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                crVar2 = this.cjN.cjt;
                                if (crVar2 != null) {
                                    crVar34 = this.cjN.cjt;
                                    if (view == crVar34.agz()) {
                                        if (this.cjN.checkUpIsLogin()) {
                                            this.cjN.W(view);
                                        }
                                        morePopupWindow10 = this.cjN.cjs;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow10, this.cjN.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                ctVar27 = this.cjN.cjo;
                                if (ctVar27.agT() != view) {
                                    crVar3 = this.cjN.cjt;
                                    if (crVar3 != null) {
                                        crVar33 = this.cjN.cjt;
                                        if (view == crVar33.agL()) {
                                            SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2 != null) {
                                                boolean booleanValue = ((Boolean) sparseArray2.get(i.f.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray2.get(i.f.tag_should_delete_visible)).booleanValue();
                                                boolean booleanValue3 = ((Boolean) sparseArray2.get(i.f.tag_display_reply_visible)).booleanValue();
                                                if (booleanValue) {
                                                    if (!booleanValue3) {
                                                        ctVar35 = this.cjN.cjo;
                                                        ctVar35.ab(view);
                                                    } else {
                                                        sparseArray2.put(i.f.tag_from, 1);
                                                        this.cjN.d(sparseArray2);
                                                    }
                                                } else if (booleanValue2) {
                                                    ctVar34 = this.cjN.cjo;
                                                    ctVar34.a(((Integer) sparseArray2.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray2.get(i.f.tag_del_post_id), ((Integer) sparseArray2.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(i.f.tag_del_post_is_self)).booleanValue());
                                                }
                                                morePopupWindow9 = this.cjN.cjs;
                                                com.baidu.adp.lib.g.j.a(morePopupWindow9, this.cjN.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() != i.f.pb_head_function_manage_delormanage) {
                                        crVar4 = this.cjN.cjt;
                                        if (crVar4 != null) {
                                            crVar32 = this.cjN.cjt;
                                        }
                                        if (view.getId() != i.f.sub_pb_more && view.getId() != i.f.sub_pb_item) {
                                            int id = view.getId();
                                            if (id == i.f.pb_u9_text_view) {
                                                if (this.cjN.checkUpIsLogin() && (aaVar = (com.baidu.tbadk.core.data.aa) view.getTag()) != null && !StringUtils.isNull(aaVar.sN())) {
                                                    TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.az.uX().b(this.cjN.getPageContext(), new String[]{aaVar.sN()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == i.f.reply) {
                                                morePopupWindow = this.cjN.cjs;
                                                if (morePopupWindow != null) {
                                                    crVar26 = this.cjN.cjt;
                                                }
                                                this.cjN.afK();
                                                morePopupWindow2 = this.cjN.cjs;
                                                if (morePopupWindow2.getIsIntercepted()) {
                                                    morePopupWindow5 = this.cjN.cjs;
                                                    morePopupWindow5.setIsIntercepted(false);
                                                    return;
                                                }
                                                com.baidu.tieba.tbadkCore.data.o oVar = null;
                                                if (view != null && view.getTag() != null) {
                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                    oVar = (com.baidu.tieba.tbadkCore.data.o) sparseArray3.get(i.f.tag_load_sub_data);
                                                    SparseArray sparseArray4 = new SparseArray();
                                                    sparseArray4.put(i.f.tag_load_sub_data, oVar);
                                                    sparseArray4.put(i.f.tag_load_sub_view, (View) sparseArray3.get(i.f.tag_load_sub_view));
                                                    crVar10 = this.cjN.cjt;
                                                    crVar10.agK().setTag(sparseArray4);
                                                    SparseArray sparseArray5 = new SparseArray();
                                                    sparseArray5.put(i.f.tag_clip_board, (com.baidu.tieba.tbadkCore.data.o) ((SparseArray) view.getTag()).get(i.f.tag_clip_board));
                                                    sparseArray5.put(i.f.tag_is_subpb, false);
                                                    crVar11 = this.cjN.cjt;
                                                    crVar11.agz().setTag(sparseArray5);
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
                                                        crVar23 = this.cjN.cjt;
                                                        crVar23.agL().setTag(sparseArray7);
                                                        crVar24 = this.cjN.cjt;
                                                        com.baidu.tbadk.core.util.an.c(crVar24.agL(), i.e.icon_pb_set_n);
                                                        crVar25 = this.cjN.cjt;
                                                        crVar25.agL().setVisibility(0);
                                                    } else if (!booleanValue6) {
                                                        crVar12 = this.cjN.cjt;
                                                        crVar12.agL().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray8 = new SparseArray();
                                                        sparseArray8.put(i.f.tag_should_manage_visible, false);
                                                        sparseArray8.put(i.f.tag_display_reply_visible, false);
                                                        sparseArray8.put(i.f.tag_should_delete_visible, true);
                                                        sparseArray8.put(i.f.tag_manage_user_identity, sparseArray6.get(i.f.tag_manage_user_identity));
                                                        sparseArray8.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
                                                        sparseArray8.put(i.f.tag_del_post_id, sparseArray6.get(i.f.tag_del_post_id));
                                                        sparseArray8.put(i.f.tag_del_post_type, sparseArray6.get(i.f.tag_del_post_type));
                                                        crVar13 = this.cjN.cjt;
                                                        crVar13.agL().setTag(sparseArray8);
                                                        crVar14 = this.cjN.cjt;
                                                        com.baidu.tbadk.core.util.an.c(crVar14.agL(), i.e.icon_pb_del_n);
                                                        crVar15 = this.cjN.cjt;
                                                        crVar15.agL().setVisibility(0);
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
                                                        crVar19 = this.cjN.cjt;
                                                        crVar19.agM().setTag(sparseArray10);
                                                        crVar20 = this.cjN.cjt;
                                                        crVar20.agM().setVisibility(0);
                                                        crVar21 = this.cjN.cjt;
                                                        crVar21.agL().setVisibility(8);
                                                        crVar22 = this.cjN.cjt;
                                                        com.baidu.tbadk.core.util.an.c(crVar22.agM(), i.e.icon_pb_gag);
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
                                                        ev = this.cjN.ev(z4);
                                                        if (ev & this.cjN.isLogin()) {
                                                            crVar17 = this.cjN.cjt;
                                                            crVar17.agM().setVisibility(0);
                                                            crVar18 = this.cjN.cjt;
                                                            crVar18.agM().setTag(str);
                                                        } else {
                                                            crVar16 = this.cjN.cjt;
                                                            crVar16.agM().setVisibility(8);
                                                        }
                                                    }
                                                }
                                                boolean z5 = false;
                                                caVar19 = this.cjN.cjj;
                                                if (caVar19.getPbData().qi()) {
                                                    caVar20 = this.cjN.cjj;
                                                    String qh = caVar20.getPbData().qh();
                                                    if (oVar != null && !com.baidu.adp.lib.util.j.isEmpty(qh) && qh.equals(oVar.getId())) {
                                                        z5 = true;
                                                    }
                                                }
                                                if (z5) {
                                                    crVar8 = this.cjN.cjt;
                                                    crVar8.agz().setText(i.h.marked);
                                                    crVar9 = this.cjN.cjt;
                                                    crVar9.agz().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                } else {
                                                    crVar5 = this.cjN.cjt;
                                                    crVar5.agz().setText(i.h.mark);
                                                    crVar6 = this.cjN.cjt;
                                                    crVar6.agz().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                }
                                                crVar7 = this.cjN.cjt;
                                                crVar7.eF(true);
                                                morePopupWindow3 = this.cjN.cjs;
                                                morePopupWindow3.reLayoutWidth();
                                                morePopupWindow4 = this.cjN.cjs;
                                                morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                return;
                                            } else if (id != i.f.pb_head_reverse_hint) {
                                                if (id == i.f.pb_act_btn) {
                                                    caVar12 = this.cjN.cjj;
                                                    if (caVar12.getPbData() != null) {
                                                        caVar13 = this.cjN.cjj;
                                                        if (caVar13.getPbData().afh() != null) {
                                                            caVar14 = this.cjN.cjj;
                                                            if (caVar14.getPbData().afh().sz() != null) {
                                                                Activity activity = this.cjN.getActivity();
                                                                caVar15 = this.cjN.cjj;
                                                                com.baidu.tbadk.browser.g.B(activity, caVar15.getPbData().afh().sz());
                                                                caVar16 = this.cjN.cjj;
                                                                if (caVar16.getPbData().afh().sx() != 1) {
                                                                    caVar17 = this.cjN.cjj;
                                                                    if (caVar17.getPbData().afh().sx() == 2) {
                                                                        TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                } else if (id == i.f.join_vote_tv) {
                                                    if (view != null) {
                                                        com.baidu.tbadk.browser.g.B(this.cjN.getActivity(), (String) view.getTag());
                                                        afM = this.cjN.afM();
                                                        if (afM == 1) {
                                                            caVar8 = this.cjN.cjj;
                                                            if (caVar8 != null) {
                                                                caVar9 = this.cjN.cjj;
                                                                if (caVar9.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10397");
                                                                    caVar10 = this.cjN.cjj;
                                                                    com.baidu.tbadk.core.util.aq ae = aqVar.ae(ImageViewerConfig.FORUM_ID, caVar10.getPbData().getForumId());
                                                                    caVar11 = this.cjN.cjj;
                                                                    TiebaStatic.log(ae.ae("tid", caVar11.getPbData().getThreadId()));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        afM2 = this.cjN.afM();
                                                        if (afM2 == 2) {
                                                            caVar4 = this.cjN.cjj;
                                                            if (caVar4 != null) {
                                                                caVar5 = this.cjN.cjj;
                                                                if (caVar5.getPbData() != null) {
                                                                    com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c10401");
                                                                    caVar6 = this.cjN.cjj;
                                                                    com.baidu.tbadk.core.util.aq ae2 = aqVar2.ae(ImageViewerConfig.FORUM_ID, caVar6.getPbData().getForumId());
                                                                    caVar7 = this.cjN.cjj;
                                                                    TiebaStatic.log(ae2.ae("tid", caVar7.getPbData().getThreadId()));
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == i.f.look_all_tv && view != null) {
                                                    com.baidu.tbadk.browser.g.B(this.cjN.getActivity(), (String) view.getTag());
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                this.cjN.stopVoice();
                                                ctVar28 = this.cjN.cjo;
                                                ctVar28.aho();
                                                ctVar29 = this.cjN.cjo;
                                                ctVar29.agZ();
                                                caVar18 = this.cjN.cjj;
                                                caVar18.agu();
                                                return;
                                            }
                                        }
                                        if (!this.cjN.checkUpIsLogin()) {
                                            morePopupWindow8 = this.cjN.cjs;
                                            com.baidu.adp.lib.g.j.a(morePopupWindow8, this.cjN.getPageContext().getPageActivity());
                                            return;
                                        }
                                        crVar27 = this.cjN.cjt;
                                        if (crVar27 != null) {
                                            crVar30 = this.cjN.cjt;
                                            if (view == crVar30.agK()) {
                                                crVar31 = this.cjN.cjt;
                                                if (!crVar31.agJ()) {
                                                    morePopupWindow7 = this.cjN.cjs;
                                                    com.baidu.adp.lib.g.j.a(morePopupWindow7, this.cjN.getPageContext().getPageActivity());
                                                    return;
                                                }
                                            }
                                        }
                                        caVar21 = this.cjN.cjj;
                                        if (caVar21.getPbData() != null) {
                                            ctVar30 = this.cjN.cjo;
                                            ctVar30.aho();
                                            SparseArray sparseArray11 = (SparseArray) view.getTag();
                                            com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) sparseArray11.get(i.f.tag_load_sub_data);
                                            View view2 = (View) sparseArray11.get(i.f.tag_load_sub_view);
                                            if (oVar2 != null && view2 != null) {
                                                caVar22 = this.cjN.cjj;
                                                String threadID = caVar22.getThreadID();
                                                String id2 = oVar2.getId();
                                                int i2 = 0;
                                                caVar23 = this.cjN.cjj;
                                                if (caVar23.getPbData() != null) {
                                                    caVar27 = this.cjN.cjj;
                                                    i2 = caVar27.getPbData().afl();
                                                }
                                                this.cjN.stopVoice();
                                                crVar28 = this.cjN.cjt;
                                                if (crVar28 != null) {
                                                    crVar29 = this.cjN.cjt;
                                                    if (view == crVar29.agK()) {
                                                        morePopupWindow6 = this.cjN.cjs;
                                                        com.baidu.adp.lib.g.j.a(morePopupWindow6, this.cjN.getPageContext().getPageActivity());
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.cjN.getPageContext().getPageActivity());
                                                        SmallTailInfo aiq = oVar2.aiq();
                                                        caVar26 = this.cjN.cjj;
                                                        this.cjN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, aiq, caVar26.getPbData().rE(), false)));
                                                        return;
                                                    }
                                                }
                                                if (view.getId() == i.f.sub_pb_item) {
                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                    String str3 = (String) sparseArray12.get(i.f.tag_photo_username);
                                                    com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray12.get(i.f.tag_clip_board);
                                                    String str4 = null;
                                                    if (oVar3 != null) {
                                                        str4 = oVar3.getId();
                                                    }
                                                    TiebaStatic.log("c10088");
                                                    SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.cjN.getPageContext().getPageActivity());
                                                    SmallTailInfo aiq2 = oVar2.aiq();
                                                    caVar25 = this.cjN.cjj;
                                                    this.cjN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id2, "pb", true, str3, true, str4, i2, aiq2, caVar25.getPbData().rE(), false)));
                                                    return;
                                                } else if (oVar2.axB()) {
                                                    TiebaStatic.log("c10089");
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.cjN.getPageContext().getPageActivity());
                                                    SmallTailInfo aiq3 = oVar2.aiq();
                                                    caVar24 = this.cjN.cjj;
                                                    this.cjN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i2, aiq3, caVar24.getPbData().rE(), false)));
                                                    return;
                                                } else {
                                                    oVar2.gw(true);
                                                    ctVar31 = this.cjN.cjo;
                                                    ctVar31.agU().notifyDataSetChanged();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                    if (((Boolean) sparseArray13.get(i.f.tag_should_manage_visible)).booleanValue()) {
                                        ctVar33 = this.cjN.cjo;
                                        ctVar33.ab(view);
                                        return;
                                    }
                                    ctVar32 = this.cjN.cjo;
                                    ctVar32.a(((Integer) sparseArray13.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray13.get(i.f.tag_del_post_id), ((Integer) sparseArray13.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray13.get(i.f.tag_del_post_is_self)).booleanValue());
                                    return;
                                } else if (this.cjN.checkUpIsLogin()) {
                                    this.cjN.afH();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            caVar49 = this.cjN.cjj;
                            String name = caVar49.getPbData().afg().getName();
                            caVar50 = this.cjN.cjj;
                            if (!TextUtils.isEmpty(caVar50.agl())) {
                                caVar51 = this.cjN.cjj;
                                if (caVar51.agl().equals(name)) {
                                    this.cjN.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.as.aN(name)) {
                                this.cjN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cjN.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        ctVar5 = this.cjN.cjo;
        ctVar5.ahp();
        caVar = this.cjN.cjj;
        if (caVar.getPbData().afl() == 1) {
            aVar = this.cjN.cjl;
            if (!aVar.ayB()) {
                ctVar6 = this.cjN.cjo;
                ctVar6.agW();
                int i3 = 0;
                ctVar7 = this.cjN.cjo;
                if (view != ctVar7.ahj()) {
                    ctVar8 = this.cjN.cjo;
                    if (view != ctVar8.ahk()) {
                        ctVar9 = this.cjN.cjo;
                        if (view != ctVar9.ahl()) {
                            ctVar10 = this.cjN.cjo;
                            if (view != ctVar10.ahm()) {
                                ctVar11 = this.cjN.cjo;
                                if (view == ctVar11.agX()) {
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
                caVar2 = this.cjN.cjj;
                ForumData afg2 = caVar2.getPbData().afg();
                String name2 = afg2.getName();
                String id3 = afg2.getId();
                caVar3 = this.cjN.cjj;
                String id4 = caVar3.getPbData().afh().getId();
                aVar2 = this.cjN.cjl;
                ctVar12 = this.cjN.cjo;
                aVar2.b(id3, name2, id4, i3, ctVar12.agY());
            }
        }
    }
}
