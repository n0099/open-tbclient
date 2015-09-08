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
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v86, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0921, code lost:
        if (r21 != r1.ael()) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0bac, code lost:
        if (r1 == null) goto L338;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        cb cbVar4;
        cb cbVar5;
        bk bkVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        cb cbVar6;
        cb cbVar7;
        cb cbVar8;
        cb cbVar9;
        cb cbVar10;
        cb cbVar11;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        cb cbVar12;
        cb cbVar13;
        cb cbVar14;
        cb cbVar15;
        cb cbVar16;
        cb cbVar17;
        cb cbVar18;
        cb cbVar19;
        cb cbVar20;
        cb cbVar21;
        cb cbVar22;
        cb cbVar23;
        cb cbVar24;
        cb cbVar25;
        cb cbVar26;
        bz bzVar;
        bz bzVar2;
        cb cbVar27;
        bz bzVar3;
        bz bzVar4;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        cb cbVar28;
        cb cbVar29;
        bk bkVar10;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        bk bkVar11;
        bz bzVar5;
        bz bzVar6;
        bz bzVar7;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        bz bzVar8;
        bz bzVar9;
        bk bkVar12;
        bz bzVar10;
        bz bzVar11;
        boolean z;
        bz bzVar12;
        bz bzVar13;
        bz bzVar14;
        bz bzVar15;
        boolean z2;
        String str;
        boolean ek;
        bz bzVar16;
        bz bzVar17;
        bz bzVar18;
        bz bzVar19;
        bz bzVar20;
        bz bzVar21;
        bz bzVar22;
        bz bzVar23;
        bz bzVar24;
        bz bzVar25;
        MorePopupWindow morePopupWindow5;
        bz bzVar26;
        com.baidu.tbadk.core.data.ab abVar;
        bz bzVar27;
        bk bkVar13;
        cb cbVar30;
        bk bkVar14;
        bk bkVar15;
        bz bzVar28;
        cb cbVar31;
        bk bkVar16;
        bk bkVar17;
        bz bzVar29;
        MorePopupWindow morePopupWindow6;
        bk bkVar18;
        bk bkVar19;
        bz bzVar30;
        bz bzVar31;
        MorePopupWindow morePopupWindow7;
        MorePopupWindow morePopupWindow8;
        bz bzVar32;
        cb cbVar32;
        cb cbVar33;
        bz bzVar33;
        cb cbVar34;
        MorePopupWindow morePopupWindow9;
        cb cbVar35;
        bz bzVar34;
        MorePopupWindow morePopupWindow10;
        bz bzVar35;
        MorePopupWindow morePopupWindow11;
        cb cbVar36;
        bk bkVar20;
        bk bkVar21;
        bk bkVar22;
        cb cbVar37;
        bk bkVar23;
        bk bkVar24;
        bk bkVar25;
        cb cbVar38;
        cb cbVar39;
        cb cbVar40;
        bk bkVar26;
        cb cbVar41;
        cb cbVar42;
        bk bkVar27;
        cb cbVar43;
        bk bkVar28;
        cb cbVar44;
        cb cbVar45;
        cb cbVar46;
        cb cbVar47;
        boolean iz;
        bk bkVar29;
        cb cbVar48;
        bk bkVar30;
        bk bkVar31;
        bk bkVar32;
        bk bkVar33;
        bk bkVar34;
        bk bkVar35;
        boolean z3;
        cb cbVar49;
        cb cbVar50;
        cb cbVar51;
        bk bkVar36;
        bk bkVar37;
        bk bkVar38;
        bk bkVar39;
        bk bkVar40;
        bk bkVar41;
        bk bkVar42;
        bk bkVar43;
        bk bkVar44;
        bk bkVar45;
        cb cbVar52;
        bk bkVar46;
        cb cbVar53;
        cb cbVar54;
        cb cbVar55;
        bk bkVar47;
        bk bkVar48;
        cb cbVar56;
        cbVar = this.ccj.cbL;
        if (view == cbVar.getNextView()) {
            bkVar48 = this.ccj.cbG;
            if (bkVar48.es(true)) {
                cbVar56 = this.ccj.cbL;
                cbVar56.aeB();
                return;
            }
            return;
        }
        cbVar2 = this.ccj.cbL;
        if (view == cbVar2.aeT()) {
            cbVar53 = this.ccj.cbL;
            cbVar53.aeO();
            this.ccj.stopVoice();
            cbVar54 = this.ccj.cbL;
            cbVar54.aez();
            cbVar55 = this.ccj.cbL;
            cbVar55.Yx();
            bkVar47 = this.ccj.cbG;
            bkVar47.iC(1);
            return;
        }
        cbVar3 = this.ccj.cbL;
        if (view == cbVar3.ceJ.aAv) {
            cbVar52 = this.ccj.cbL;
            bkVar46 = this.ccj.cbG;
            if (!cbVar52.eH(bkVar46.adP())) {
                this.ccj.finish();
                return;
            } else {
                this.ccj.stopVoice();
                return;
            }
        }
        cbVar4 = this.ccj.cbL;
        if (view != cbVar4.aeJ()) {
            cbVar13 = this.ccj.cbL;
            if (view != cbVar13.aeK()) {
                cbVar14 = this.ccj.cbL;
                if (view != cbVar14.aeL()) {
                    cbVar15 = this.ccj.cbL;
                    if (view != cbVar15.aeM()) {
                        cbVar16 = this.ccj.cbL;
                        if (view != cbVar16.aex()) {
                            cbVar17 = this.ccj.cbL;
                            if (view == cbVar17.aeQ()) {
                                bkVar44 = this.ccj.cbG;
                                if (bkVar44 != null) {
                                    bkVar45 = this.ccj.cbG;
                                    com.baidu.tbadk.browser.g.B(this.ccj.getPageContext().getPageActivity(), bkVar45.getPbData().acQ().sn().getLink());
                                    return;
                                }
                                return;
                            }
                            cbVar18 = this.ccj.cbL;
                            if (view != cbVar18.ceJ.cgo) {
                                cbVar19 = this.ccj.cbL;
                                if (view == cbVar19.ceJ.cgq) {
                                    bkVar37 = this.ccj.cbG;
                                    if (bkVar37 != null) {
                                        bkVar38 = this.ccj.cbG;
                                        if (bkVar38.getPbData() != null) {
                                            bkVar39 = this.ccj.cbG;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = bkVar39.getPbData().acR();
                                            if (acR == null || acR.size() <= 0) {
                                                bkVar40 = this.ccj.cbG;
                                                if (bkVar40.adM()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.ccj.getPageContext().getPageActivity(), this.ccj.getPageContext().getString(i.h.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            this.ccj.adp();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.ccj.getPageContext().getPageActivity(), this.ccj.getPageContext().getString(i.h.pb_no_data_tips));
                                    return;
                                }
                                cbVar20 = this.ccj.cbL;
                                if (view == cbVar20.ceJ.cgp) {
                                    z3 = this.ccj.auW;
                                    if (!z3) {
                                        this.ccj.auW = true;
                                        cbVar49 = this.ccj.cbL;
                                        cbVar49.ceJ.cgp.setEnabled(false);
                                        cbVar50 = this.ccj.cbL;
                                        cbVar50.UN();
                                        this.ccj.stopVoice();
                                        cbVar51 = this.ccj.cbL;
                                        cbVar51.aez();
                                        bkVar36 = this.ccj.cbG;
                                        bkVar36.adU();
                                        TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                cbVar21 = this.ccj.cbL;
                                if (view == cbVar21.ceJ.cgr) {
                                    bkVar30 = this.ccj.cbG;
                                    AdditionData acX = bkVar30.getPbData().acX();
                                    if (!TextUtils.isEmpty(acX.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.ccj.getPageContext().getPageActivity(), acX.getWarnMsg());
                                        return;
                                    } else if (acX.getAlreadyCount() != acX.getTotalCount()) {
                                        bkVar31 = this.ccj.cbG;
                                        ForumData acP = bkVar31.getPbData().acP();
                                        bkVar32 = this.ccj.cbG;
                                        com.baidu.tbadk.core.data.x acQ = bkVar32.getPbData().acQ();
                                        bkVar33 = this.ccj.cbG;
                                        AntiData rK = bkVar33.getPbData().rK();
                                        if (acQ.getId() != null) {
                                            if (rK != null && rK.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.ccj.getPageContext().getPageActivity(), rK.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            bkVar34 = this.ccj.cbG;
                                            if (bkVar34.getPbData().getUserData() != null) {
                                                bkVar35 = this.ccj.cbG;
                                                i = bkVar35.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.ccj.getPageContext().getPageActivity(), 2, acP.getId(), acP.getName(), acQ.getId(), acX.getPostId(), 0, rK, 13008, false, false, null, false, false, null, acX, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.ccj.getPageContext().getPageActivity(), String.format(this.ccj.getPageContext().getString(i.h.write_addition_limit), Integer.valueOf(acX.getTotalCount())));
                                        return;
                                    }
                                }
                                cbVar22 = this.ccj.cbL;
                                if (cbVar22.ceJ.aeX() != null) {
                                    cbVar46 = this.ccj.cbL;
                                    if (view == cbVar46.ceJ.aeX().aea()) {
                                        cbVar47 = this.ccj.cbL;
                                        cbVar47.aeO();
                                        iz = this.ccj.iz(11009);
                                        if (iz) {
                                            bkVar29 = this.ccj.cbG;
                                            cbVar48 = this.ccj.cbL;
                                            if (bkVar29.iI(cbVar48.aeF()) == null) {
                                                return;
                                            }
                                            this.ccj.adt();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                cbVar23 = this.ccj.cbL;
                                if (cbVar23.ceJ.aeX() != null) {
                                    cbVar44 = this.ccj.cbL;
                                    if (view == cbVar44.ceJ.aeX().aeb()) {
                                        cbVar45 = this.ccj.cbL;
                                        cbVar45.aeO();
                                        this.ccj.stopVoice();
                                        this.ccj.showShareDialog();
                                        return;
                                    }
                                }
                                cbVar24 = this.ccj.cbL;
                                if (cbVar24.ceJ.aeX() != null) {
                                    cbVar41 = this.ccj.cbL;
                                    if (view == cbVar41.ceJ.aeX().aed()) {
                                        cbVar42 = this.ccj.cbL;
                                        cbVar42.aeO();
                                        bkVar27 = this.ccj.cbG;
                                        if (bkVar27.adR() != null) {
                                            cbVar43 = this.ccj.cbL;
                                            bkVar28 = this.ccj.cbG;
                                            cbVar43.a(bkVar28.adR(), this.ccj.bXJ);
                                        }
                                        TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                cbVar25 = this.ccj.cbL;
                                if (cbVar25.ceJ.aeX() != null) {
                                    cbVar38 = this.ccj.cbL;
                                    if (view == cbVar38.ceJ.aeX().aee()) {
                                        cbVar39 = this.ccj.cbL;
                                        cbVar39.aeO();
                                        this.ccj.stopVoice();
                                        cbVar40 = this.ccj.cbL;
                                        cbVar40.aez();
                                        bkVar26 = this.ccj.cbG;
                                        bkVar26.adV();
                                        TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                cbVar26 = this.ccj.cbL;
                                if (cbVar26.ceJ.aeX() != null) {
                                    cbVar36 = this.ccj.cbL;
                                    if (view == cbVar36.ceJ.aeX().aef()) {
                                        bkVar20 = this.ccj.cbG;
                                        if (bkVar20 != null) {
                                            bkVar21 = this.ccj.cbG;
                                            if (bkVar21.getPbData() != null) {
                                                bkVar22 = this.ccj.cbG;
                                                if (bkVar22.getPbData().acQ() != null) {
                                                    cbVar37 = this.ccj.cbL;
                                                    cbVar37.ceJ.qy();
                                                    bkVar23 = this.ccj.cbG;
                                                    if (bkVar23.getPbData().acR() != null) {
                                                        bkVar24 = this.ccj.cbG;
                                                        if (bkVar24.getPbData().acR().size() > 0) {
                                                            PbActivity pbActivity = this.ccj;
                                                            bkVar25 = this.ccj.cbG;
                                                            pbActivity.jp(bkVar25.getPbData().acR().get(0).getId());
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
                                bzVar = this.ccj.cbQ;
                                if (bzVar != null) {
                                    bzVar35 = this.ccj.cbQ;
                                    if (view == bzVar35.aen()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                                                    sparseArray.put(i.f.tag_from, 0);
                                                    this.ccj.d(sparseArray);
                                                }
                                            }
                                        } else {
                                            this.ccj.jp((String) tag);
                                        }
                                        morePopupWindow11 = this.ccj.cbP;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow11, this.ccj.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                bzVar2 = this.ccj.cbQ;
                                if (bzVar2 != null) {
                                    bzVar34 = this.ccj.cbQ;
                                    if (view == bzVar34.aea()) {
                                        if (this.ccj.checkUpIsLogin()) {
                                            this.ccj.V(view);
                                        }
                                        morePopupWindow10 = this.ccj.cbP;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow10, this.ccj.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                cbVar27 = this.ccj.cbL;
                                if (cbVar27.aet() != view) {
                                    bzVar3 = this.ccj.cbQ;
                                    if (bzVar3 != null) {
                                        bzVar33 = this.ccj.cbQ;
                                        if (view == bzVar33.aem()) {
                                            SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2 != null) {
                                                boolean booleanValue = ((Boolean) sparseArray2.get(i.f.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray2.get(i.f.tag_should_delete_visible)).booleanValue();
                                                boolean booleanValue3 = ((Boolean) sparseArray2.get(i.f.tag_display_reply_visible)).booleanValue();
                                                if (booleanValue) {
                                                    if (!booleanValue3) {
                                                        cbVar35 = this.ccj.cbL;
                                                        cbVar35.aa(view);
                                                    } else {
                                                        sparseArray2.put(i.f.tag_from, 1);
                                                        this.ccj.d(sparseArray2);
                                                    }
                                                } else if (booleanValue2) {
                                                    cbVar34 = this.ccj.cbL;
                                                    cbVar34.a(((Integer) sparseArray2.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray2.get(i.f.tag_del_post_id), ((Integer) sparseArray2.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(i.f.tag_del_post_is_self)).booleanValue());
                                                }
                                                morePopupWindow9 = this.ccj.cbP;
                                                com.baidu.adp.lib.g.j.a(morePopupWindow9, this.ccj.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() != i.f.pb_head_function_manage_delormanage) {
                                        bzVar4 = this.ccj.cbQ;
                                        if (bzVar4 != null) {
                                            bzVar32 = this.ccj.cbQ;
                                        }
                                        if (view.getId() != i.f.sub_pb_more && view.getId() != i.f.sub_pb_item) {
                                            int id = view.getId();
                                            if (id == i.f.pb_u9_text_view) {
                                                if (this.ccj.checkUpIsLogin() && (abVar = (com.baidu.tbadk.core.data.ab) view.getTag()) != null && !StringUtils.isNull(abVar.sQ())) {
                                                    TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.ax.uX().b(this.ccj.getPageContext(), new String[]{abVar.sQ()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == i.f.reply) {
                                                morePopupWindow = this.ccj.cbP;
                                                if (morePopupWindow != null) {
                                                    bzVar26 = this.ccj.cbQ;
                                                }
                                                this.ccj.adn();
                                                morePopupWindow2 = this.ccj.cbP;
                                                if (morePopupWindow2.getIsIntercepted()) {
                                                    morePopupWindow5 = this.ccj.cbP;
                                                    morePopupWindow5.setIsIntercepted(false);
                                                    return;
                                                }
                                                com.baidu.tieba.tbadkCore.data.i iVar = null;
                                                if (view != null && view.getTag() != null) {
                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                    iVar = (com.baidu.tieba.tbadkCore.data.i) sparseArray3.get(i.f.tag_load_sub_data);
                                                    SparseArray sparseArray4 = new SparseArray();
                                                    sparseArray4.put(i.f.tag_load_sub_data, iVar);
                                                    sparseArray4.put(i.f.tag_load_sub_view, (View) sparseArray3.get(i.f.tag_load_sub_view));
                                                    bzVar10 = this.ccj.cbQ;
                                                    bzVar10.ael().setTag(sparseArray4);
                                                    SparseArray sparseArray5 = new SparseArray();
                                                    sparseArray5.put(i.f.tag_clip_board, (com.baidu.tieba.tbadkCore.data.i) ((SparseArray) view.getTag()).get(i.f.tag_clip_board));
                                                    sparseArray5.put(i.f.tag_is_subpb, false);
                                                    bzVar11 = this.ccj.cbQ;
                                                    bzVar11.aea().setTag(sparseArray5);
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
                                                        bzVar23 = this.ccj.cbQ;
                                                        bzVar23.aem().setTag(sparseArray7);
                                                        bzVar24 = this.ccj.cbQ;
                                                        com.baidu.tbadk.core.util.al.c(bzVar24.aem(), i.e.icon_pb_set_n);
                                                        bzVar25 = this.ccj.cbQ;
                                                        bzVar25.aem().setVisibility(0);
                                                    } else if (!booleanValue6) {
                                                        bzVar12 = this.ccj.cbQ;
                                                        bzVar12.aem().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray8 = new SparseArray();
                                                        sparseArray8.put(i.f.tag_should_manage_visible, false);
                                                        sparseArray8.put(i.f.tag_display_reply_visible, false);
                                                        sparseArray8.put(i.f.tag_should_delete_visible, true);
                                                        sparseArray8.put(i.f.tag_manage_user_identity, sparseArray6.get(i.f.tag_manage_user_identity));
                                                        sparseArray8.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
                                                        sparseArray8.put(i.f.tag_del_post_id, sparseArray6.get(i.f.tag_del_post_id));
                                                        sparseArray8.put(i.f.tag_del_post_type, sparseArray6.get(i.f.tag_del_post_type));
                                                        bzVar13 = this.ccj.cbQ;
                                                        bzVar13.aem().setTag(sparseArray8);
                                                        bzVar14 = this.ccj.cbQ;
                                                        com.baidu.tbadk.core.util.al.c(bzVar14.aem(), i.e.icon_pb_del_n);
                                                        bzVar15 = this.ccj.cbQ;
                                                        bzVar15.aem().setVisibility(0);
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
                                                        bzVar19 = this.ccj.cbQ;
                                                        bzVar19.aen().setTag(sparseArray10);
                                                        bzVar20 = this.ccj.cbQ;
                                                        bzVar20.aen().setVisibility(0);
                                                        bzVar21 = this.ccj.cbQ;
                                                        bzVar21.aem().setVisibility(8);
                                                        bzVar22 = this.ccj.cbQ;
                                                        com.baidu.tbadk.core.util.al.c(bzVar22.aen(), i.e.icon_pb_gag);
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
                                                        ek = this.ccj.ek(z4);
                                                        if (ek & this.ccj.isLogin()) {
                                                            bzVar17 = this.ccj.cbQ;
                                                            bzVar17.aen().setVisibility(0);
                                                            bzVar18 = this.ccj.cbQ;
                                                            bzVar18.aen().setTag(str);
                                                        } else {
                                                            bzVar16 = this.ccj.cbQ;
                                                            bzVar16.aen().setVisibility(8);
                                                        }
                                                    }
                                                }
                                                boolean z5 = false;
                                                bkVar11 = this.ccj.cbG;
                                                if (bkVar11.getPbData().qo()) {
                                                    bkVar12 = this.ccj.cbG;
                                                    String qn = bkVar12.getPbData().qn();
                                                    if (iVar != null && !com.baidu.adp.lib.util.j.isEmpty(qn) && qn.equals(iVar.getId())) {
                                                        z5 = true;
                                                    }
                                                }
                                                if (z5) {
                                                    bzVar8 = this.ccj.cbQ;
                                                    bzVar8.aea().setText(i.h.marked);
                                                    bzVar9 = this.ccj.cbQ;
                                                    bzVar9.aea().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                } else {
                                                    bzVar5 = this.ccj.cbQ;
                                                    bzVar5.aea().setText(i.h.mark);
                                                    bzVar6 = this.ccj.cbQ;
                                                    bzVar6.aea().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                }
                                                bzVar7 = this.ccj.cbQ;
                                                bzVar7.ex(true);
                                                morePopupWindow3 = this.ccj.cbP;
                                                morePopupWindow3.reLayoutWidth();
                                                morePopupWindow4 = this.ccj.cbP;
                                                morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                return;
                                            } else if (id != i.f.pb_head_reverse_hint) {
                                                if (id == i.f.pb_act_btn) {
                                                    bkVar4 = this.ccj.cbG;
                                                    if (bkVar4.getPbData() != null) {
                                                        bkVar5 = this.ccj.cbG;
                                                        if (bkVar5.getPbData().acQ() != null) {
                                                            bkVar6 = this.ccj.cbG;
                                                            if (bkVar6.getPbData().acQ().sE() != null) {
                                                                Activity activity = this.ccj.getActivity();
                                                                bkVar7 = this.ccj.cbG;
                                                                com.baidu.tbadk.browser.g.B(activity, bkVar7.getPbData().acQ().sE());
                                                                bkVar8 = this.ccj.cbG;
                                                                if (bkVar8.getPbData().acQ().sC() != 1) {
                                                                    bkVar9 = this.ccj.cbG;
                                                                    if (bkVar9.getPbData().acQ().sC() == 2) {
                                                                        TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id == i.f.pb_item_tail_content) {
                                                    String string = TbadkCoreApplication.m411getInst().getString(i.h.tail_web_view_title);
                                                    String string2 = com.baidu.tbadk.core.sharedPref.b.tx().getString("tail_link", "");
                                                    if (!StringUtils.isNull(string2)) {
                                                        com.baidu.tbadk.browser.g.a(view.getContext(), string, string2, true, true, true);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                this.ccj.stopVoice();
                                                cbVar28 = this.ccj.cbL;
                                                cbVar28.aeO();
                                                cbVar29 = this.ccj.cbL;
                                                cbVar29.aez();
                                                bkVar10 = this.ccj.cbG;
                                                bkVar10.adV();
                                                return;
                                            }
                                        }
                                        if (!this.ccj.checkUpIsLogin()) {
                                            morePopupWindow8 = this.ccj.cbP;
                                            com.baidu.adp.lib.g.j.a(morePopupWindow8, this.ccj.getPageContext().getPageActivity());
                                            return;
                                        }
                                        bzVar27 = this.ccj.cbQ;
                                        if (bzVar27 != null) {
                                            bzVar30 = this.ccj.cbQ;
                                            if (view == bzVar30.ael()) {
                                                bzVar31 = this.ccj.cbQ;
                                                if (!bzVar31.aek()) {
                                                    morePopupWindow7 = this.ccj.cbP;
                                                    com.baidu.adp.lib.g.j.a(morePopupWindow7, this.ccj.getPageContext().getPageActivity());
                                                    return;
                                                }
                                            }
                                        }
                                        bkVar13 = this.ccj.cbG;
                                        if (bkVar13.getPbData() != null) {
                                            cbVar30 = this.ccj.cbL;
                                            cbVar30.aeO();
                                            SparseArray sparseArray11 = (SparseArray) view.getTag();
                                            com.baidu.tieba.tbadkCore.data.i iVar2 = (com.baidu.tieba.tbadkCore.data.i) sparseArray11.get(i.f.tag_load_sub_data);
                                            View view2 = (View) sparseArray11.get(i.f.tag_load_sub_view);
                                            if (iVar2 != null && view2 != null) {
                                                bkVar14 = this.ccj.cbG;
                                                String threadID = bkVar14.getThreadID();
                                                String id2 = iVar2.getId();
                                                int i2 = 0;
                                                bkVar15 = this.ccj.cbG;
                                                if (bkVar15.getPbData() != null) {
                                                    bkVar19 = this.ccj.cbG;
                                                    i2 = bkVar19.getPbData().acU();
                                                }
                                                this.ccj.stopVoice();
                                                bzVar28 = this.ccj.cbQ;
                                                if (bzVar28 != null) {
                                                    bzVar29 = this.ccj.cbQ;
                                                    if (view == bzVar29.ael()) {
                                                        morePopupWindow6 = this.ccj.cbP;
                                                        com.baidu.adp.lib.g.j.a(morePopupWindow6, this.ccj.getPageContext().getPageActivity());
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.ccj.getPageContext().getPageActivity());
                                                        SmallTailInfo afQ = iVar2.afQ();
                                                        bkVar18 = this.ccj.cbG;
                                                        this.ccj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, afQ, bkVar18.getPbData().rK())));
                                                        return;
                                                    }
                                                }
                                                if (view.getId() == i.f.sub_pb_item) {
                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                    String str3 = (String) sparseArray12.get(i.f.tag_photo_username);
                                                    com.baidu.tieba.tbadkCore.data.i iVar3 = (com.baidu.tieba.tbadkCore.data.i) sparseArray12.get(i.f.tag_clip_board);
                                                    String str4 = null;
                                                    if (iVar3 != null) {
                                                        str4 = iVar3.getId();
                                                    }
                                                    TiebaStatic.log("c10088");
                                                    SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.ccj.getPageContext().getPageActivity());
                                                    SmallTailInfo afQ2 = iVar2.afQ();
                                                    bkVar17 = this.ccj.cbG;
                                                    this.ccj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id2, "pb", true, str3, true, str4, i2, afQ2, bkVar17.getPbData().rK())));
                                                    return;
                                                } else if (iVar2.aur()) {
                                                    TiebaStatic.log("c10089");
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.ccj.getPageContext().getPageActivity());
                                                    SmallTailInfo afQ3 = iVar2.afQ();
                                                    bkVar16 = this.ccj.cbG;
                                                    this.ccj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i2, afQ3, bkVar16.getPbData().rK())));
                                                    return;
                                                } else {
                                                    iVar2.gj(true);
                                                    cbVar31 = this.ccj.cbL;
                                                    cbVar31.aeu().notifyDataSetChanged();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                    if (((Boolean) sparseArray13.get(i.f.tag_should_manage_visible)).booleanValue()) {
                                        cbVar33 = this.ccj.cbL;
                                        cbVar33.aa(view);
                                        return;
                                    }
                                    cbVar32 = this.ccj.cbL;
                                    cbVar32.a(((Integer) sparseArray13.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray13.get(i.f.tag_del_post_id), ((Integer) sparseArray13.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray13.get(i.f.tag_del_post_is_self)).booleanValue());
                                    return;
                                } else if (this.ccj.checkUpIsLogin()) {
                                    this.ccj.adl();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            bkVar41 = this.ccj.cbG;
                            String name = bkVar41.getPbData().acP().getName();
                            bkVar42 = this.ccj.cbG;
                            if (!TextUtils.isEmpty(bkVar42.adL())) {
                                bkVar43 = this.ccj.cbG;
                                if (bkVar43.adL().equals(name)) {
                                    this.ccj.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.aq.aP(name)) {
                                this.ccj.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ccj.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        cbVar5 = this.ccj.cbL;
        cbVar5.aeP();
        bkVar = this.ccj.cbG;
        if (bkVar.getPbData().acU() == 1) {
            aVar = this.ccj.cbI;
            if (!aVar.avb()) {
                cbVar6 = this.ccj.cbL;
                cbVar6.aew();
                int i3 = 0;
                cbVar7 = this.ccj.cbL;
                if (view != cbVar7.aeJ()) {
                    cbVar8 = this.ccj.cbL;
                    if (view != cbVar8.aeK()) {
                        cbVar9 = this.ccj.cbL;
                        if (view != cbVar9.aeL()) {
                            cbVar10 = this.ccj.cbL;
                            if (view != cbVar10.aeM()) {
                                cbVar11 = this.ccj.cbL;
                                if (view == cbVar11.aex()) {
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
                bkVar2 = this.ccj.cbG;
                ForumData acP2 = bkVar2.getPbData().acP();
                String name2 = acP2.getName();
                String id3 = acP2.getId();
                bkVar3 = this.ccj.cbG;
                String id4 = bkVar3.getPbData().acQ().getId();
                aVar2 = this.ccj.cbI;
                cbVar12 = this.ccj.cbL;
                aVar2.b(id3, name2, id4, i3, cbVar12.aey());
            }
        }
    }
}
