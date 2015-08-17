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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v84, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0921, code lost:
        if (r21 != r1.adX()) goto L255;
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
        boolean ed;
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
        com.baidu.tbadk.core.data.z zVar;
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
        boolean io;
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
        cbVar = this.cbo.caQ;
        if (view == cbVar.getNextView()) {
            bkVar48 = this.cbo.caL;
            if (bkVar48.ek(true)) {
                cbVar56 = this.cbo.caQ;
                cbVar56.aen();
                return;
            }
            return;
        }
        cbVar2 = this.cbo.caQ;
        if (view == cbVar2.aeF()) {
            cbVar53 = this.cbo.caQ;
            cbVar53.aeA();
            this.cbo.stopVoice();
            cbVar54 = this.cbo.caQ;
            cbVar54.ael();
            cbVar55 = this.cbo.caQ;
            cbVar55.Yv();
            bkVar47 = this.cbo.caL;
            bkVar47.ir(1);
            return;
        }
        cbVar3 = this.cbo.caQ;
        if (view == cbVar3.cdM.ayN) {
            cbVar52 = this.cbo.caQ;
            bkVar46 = this.cbo.caL;
            if (!cbVar52.ez(bkVar46.adB())) {
                this.cbo.finish();
                return;
            } else {
                this.cbo.stopVoice();
                return;
            }
        }
        cbVar4 = this.cbo.caQ;
        if (view != cbVar4.aev()) {
            cbVar13 = this.cbo.caQ;
            if (view != cbVar13.aew()) {
                cbVar14 = this.cbo.caQ;
                if (view != cbVar14.aex()) {
                    cbVar15 = this.cbo.caQ;
                    if (view != cbVar15.aey()) {
                        cbVar16 = this.cbo.caQ;
                        if (view != cbVar16.aej()) {
                            cbVar17 = this.cbo.caQ;
                            if (view == cbVar17.aeC()) {
                                bkVar44 = this.cbo.caL;
                                if (bkVar44 != null) {
                                    bkVar45 = this.cbo.caL;
                                    com.baidu.tbadk.browser.f.B(this.cbo.getPageContext().getPageActivity(), bkVar45.getPbData().acH().sm().getLink());
                                    return;
                                }
                                return;
                            }
                            cbVar18 = this.cbo.caQ;
                            if (view != cbVar18.cdM.cfr) {
                                cbVar19 = this.cbo.caQ;
                                if (view == cbVar19.cdM.cft) {
                                    bkVar37 = this.cbo.caL;
                                    if (bkVar37 != null) {
                                        bkVar38 = this.cbo.caL;
                                        if (bkVar38.getPbData() != null) {
                                            bkVar39 = this.cbo.caL;
                                            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = bkVar39.getPbData().acI();
                                            if (acI == null || acI.size() <= 0) {
                                                bkVar40 = this.cbo.caL;
                                                if (bkVar40.ady()) {
                                                    com.baidu.adp.lib.util.k.showToast(this.cbo.getPageContext().getPageActivity(), this.cbo.getPageContext().getString(i.C0057i.pb_no_data_tips));
                                                    return;
                                                }
                                            }
                                            this.cbo.adc();
                                            return;
                                        }
                                    }
                                    com.baidu.adp.lib.util.k.showToast(this.cbo.getPageContext().getPageActivity(), this.cbo.getPageContext().getString(i.C0057i.pb_no_data_tips));
                                    return;
                                }
                                cbVar20 = this.cbo.caQ;
                                if (view == cbVar20.cdM.cfs) {
                                    z3 = this.cbo.atm;
                                    if (!z3) {
                                        this.cbo.atm = true;
                                        cbVar49 = this.cbo.caQ;
                                        cbVar49.cdM.cfs.setEnabled(false);
                                        cbVar50 = this.cbo.caQ;
                                        cbVar50.UL();
                                        this.cbo.stopVoice();
                                        cbVar51 = this.cbo.caQ;
                                        cbVar51.ael();
                                        bkVar36 = this.cbo.caL;
                                        bkVar36.adG();
                                        TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    return;
                                }
                                cbVar21 = this.cbo.caQ;
                                if (view == cbVar21.cdM.cfu) {
                                    bkVar30 = this.cbo.caL;
                                    AdditionData acN = bkVar30.getPbData().acN();
                                    if (!TextUtils.isEmpty(acN.getWarnMsg())) {
                                        com.baidu.adp.lib.util.k.showToast(this.cbo.getPageContext().getPageActivity(), acN.getWarnMsg());
                                        return;
                                    } else if (acN.getAlreadyCount() != acN.getTotalCount()) {
                                        bkVar31 = this.cbo.caL;
                                        ForumData acG = bkVar31.getPbData().acG();
                                        bkVar32 = this.cbo.caL;
                                        com.baidu.tbadk.core.data.v acH = bkVar32.getPbData().acH();
                                        bkVar33 = this.cbo.caL;
                                        AntiData rM = bkVar33.getPbData().rM();
                                        if (acH.getId() != null) {
                                            if (rM != null && rM.getIfpost() == 0) {
                                                com.baidu.adp.lib.util.k.showToast(this.cbo.getPageContext().getPageActivity(), rM.getForbid_info());
                                                return;
                                            }
                                            int i = 0;
                                            bkVar34 = this.cbo.caL;
                                            if (bkVar34.getPbData().getUserData() != null) {
                                                bkVar35 = this.cbo.caL;
                                                i = bkVar35.getPbData().getUserData().getIsMem();
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(this.cbo.getPageContext().getPageActivity(), 2, acG.getId(), acG.getName(), acH.getId(), acN.getPostId(), 0, rM, 13008, false, false, null, false, false, null, acN, null, i)));
                                            return;
                                        }
                                        return;
                                    } else {
                                        com.baidu.adp.lib.util.k.showToast(this.cbo.getPageContext().getPageActivity(), String.format(this.cbo.getPageContext().getString(i.C0057i.write_addition_limit), Integer.valueOf(acN.getTotalCount())));
                                        return;
                                    }
                                }
                                cbVar22 = this.cbo.caQ;
                                if (cbVar22.cdM.aeJ() != null) {
                                    cbVar46 = this.cbo.caQ;
                                    if (view == cbVar46.cdM.aeJ().adM()) {
                                        cbVar47 = this.cbo.caQ;
                                        cbVar47.aeA();
                                        io = this.cbo.io(11009);
                                        if (io) {
                                            bkVar29 = this.cbo.caL;
                                            cbVar48 = this.cbo.caQ;
                                            if (bkVar29.iw(cbVar48.aer()) == null) {
                                                return;
                                            }
                                            this.cbo.adg();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                cbVar23 = this.cbo.caQ;
                                if (cbVar23.cdM.aeJ() != null) {
                                    cbVar44 = this.cbo.caQ;
                                    if (view == cbVar44.cdM.aeJ().adN()) {
                                        cbVar45 = this.cbo.caQ;
                                        cbVar45.aeA();
                                        this.cbo.stopVoice();
                                        this.cbo.showShareDialog();
                                        return;
                                    }
                                }
                                cbVar24 = this.cbo.caQ;
                                if (cbVar24.cdM.aeJ() != null) {
                                    cbVar41 = this.cbo.caQ;
                                    if (view == cbVar41.cdM.aeJ().adP()) {
                                        cbVar42 = this.cbo.caQ;
                                        cbVar42.aeA();
                                        bkVar27 = this.cbo.caL;
                                        if (bkVar27.adD() != null) {
                                            cbVar43 = this.cbo.caQ;
                                            bkVar28 = this.cbo.caL;
                                            cbVar43.a(bkVar28.adD(), this.cbo.bWS);
                                        }
                                        TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                cbVar25 = this.cbo.caQ;
                                if (cbVar25.cdM.aeJ() != null) {
                                    cbVar38 = this.cbo.caQ;
                                    if (view == cbVar38.cdM.aeJ().adQ()) {
                                        cbVar39 = this.cbo.caQ;
                                        cbVar39.aeA();
                                        this.cbo.stopVoice();
                                        cbVar40 = this.cbo.caQ;
                                        cbVar40.ael();
                                        bkVar26 = this.cbo.caL;
                                        bkVar26.adH();
                                        TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                }
                                cbVar26 = this.cbo.caQ;
                                if (cbVar26.cdM.aeJ() != null) {
                                    cbVar36 = this.cbo.caQ;
                                    if (view == cbVar36.cdM.aeJ().adR()) {
                                        bkVar20 = this.cbo.caL;
                                        if (bkVar20 != null) {
                                            bkVar21 = this.cbo.caL;
                                            if (bkVar21.getPbData() != null) {
                                                bkVar22 = this.cbo.caL;
                                                if (bkVar22.getPbData().acH() != null) {
                                                    cbVar37 = this.cbo.caQ;
                                                    cbVar37.cdM.qB();
                                                    bkVar23 = this.cbo.caL;
                                                    if (bkVar23.getPbData().acI() != null) {
                                                        bkVar24 = this.cbo.caL;
                                                        if (bkVar24.getPbData().acI().size() > 0) {
                                                            PbActivity pbActivity = this.cbo;
                                                            bkVar25 = this.cbo.caL;
                                                            pbActivity.jh(bkVar25.getPbData().acI().get(0).getId());
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
                                bzVar = this.cbo.caV;
                                if (bzVar != null) {
                                    bzVar35 = this.cbo.caV;
                                    if (view == bzVar35.adZ()) {
                                        Object tag = view.getTag();
                                        if (!(tag instanceof String)) {
                                            if (tag instanceof SparseArray) {
                                                SparseArray<Object> sparseArray = (SparseArray) tag;
                                                if ((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
                                                    sparseArray.put(i.f.tag_from, 0);
                                                    this.cbo.d(sparseArray);
                                                }
                                            }
                                        } else {
                                            this.cbo.jh((String) tag);
                                        }
                                        morePopupWindow11 = this.cbo.caU;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow11, this.cbo.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                bzVar2 = this.cbo.caV;
                                if (bzVar2 != null) {
                                    bzVar34 = this.cbo.caV;
                                    if (view == bzVar34.adM()) {
                                        if (this.cbo.checkUpIsLogin()) {
                                            this.cbo.V(view);
                                        }
                                        morePopupWindow10 = this.cbo.caU;
                                        com.baidu.adp.lib.g.j.a(morePopupWindow10, this.cbo.getPageContext().getPageActivity());
                                        return;
                                    }
                                }
                                cbVar27 = this.cbo.caQ;
                                if (cbVar27.aef() != view) {
                                    bzVar3 = this.cbo.caV;
                                    if (bzVar3 != null) {
                                        bzVar33 = this.cbo.caV;
                                        if (view == bzVar33.adY()) {
                                            SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2 != null) {
                                                boolean booleanValue = ((Boolean) sparseArray2.get(i.f.tag_should_manage_visible)).booleanValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray2.get(i.f.tag_should_delete_visible)).booleanValue();
                                                boolean booleanValue3 = ((Boolean) sparseArray2.get(i.f.tag_display_reply_visible)).booleanValue();
                                                if (booleanValue) {
                                                    if (!booleanValue3) {
                                                        cbVar35 = this.cbo.caQ;
                                                        cbVar35.aa(view);
                                                    } else {
                                                        sparseArray2.put(i.f.tag_from, 1);
                                                        this.cbo.d(sparseArray2);
                                                    }
                                                } else if (booleanValue2) {
                                                    cbVar34 = this.cbo.caQ;
                                                    cbVar34.a(((Integer) sparseArray2.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray2.get(i.f.tag_del_post_id), ((Integer) sparseArray2.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(i.f.tag_del_post_is_self)).booleanValue());
                                                }
                                                morePopupWindow9 = this.cbo.caU;
                                                com.baidu.adp.lib.g.j.a(morePopupWindow9, this.cbo.getPageContext().getPageActivity());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (view.getId() != i.f.pb_head_function_manage_delormanage) {
                                        bzVar4 = this.cbo.caV;
                                        if (bzVar4 != null) {
                                            bzVar32 = this.cbo.caV;
                                        }
                                        if (view.getId() != i.f.sub_pb_more && view.getId() != i.f.sub_pb_item) {
                                            int id = view.getId();
                                            if (id == i.f.pb_u9_text_view) {
                                                if (this.cbo.checkUpIsLogin() && (zVar = (com.baidu.tbadk.core.data.z) view.getTag()) != null && !StringUtils.isNull(zVar.sL())) {
                                                    TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                    com.baidu.tbadk.core.util.ax.uR().b(this.cbo.getPageContext(), new String[]{zVar.sL()});
                                                    return;
                                                }
                                                return;
                                            } else if (id == i.f.reply) {
                                                morePopupWindow = this.cbo.caU;
                                                if (morePopupWindow != null) {
                                                    bzVar26 = this.cbo.caV;
                                                }
                                                this.cbo.ada();
                                                morePopupWindow2 = this.cbo.caU;
                                                if (morePopupWindow2.getIsIntercepted()) {
                                                    morePopupWindow5 = this.cbo.caU;
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
                                                    bzVar10 = this.cbo.caV;
                                                    bzVar10.adX().setTag(sparseArray4);
                                                    SparseArray sparseArray5 = new SparseArray();
                                                    sparseArray5.put(i.f.tag_clip_board, (com.baidu.tieba.tbadkCore.data.i) ((SparseArray) view.getTag()).get(i.f.tag_clip_board));
                                                    sparseArray5.put(i.f.tag_is_subpb, false);
                                                    bzVar11 = this.cbo.caV;
                                                    bzVar11.adM().setTag(sparseArray5);
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
                                                        bzVar23 = this.cbo.caV;
                                                        bzVar23.adY().setTag(sparseArray7);
                                                        bzVar24 = this.cbo.caV;
                                                        com.baidu.tbadk.core.util.al.c(bzVar24.adY(), i.e.icon_pb_set_n);
                                                        bzVar25 = this.cbo.caV;
                                                        bzVar25.adY().setVisibility(0);
                                                    } else if (!booleanValue6) {
                                                        bzVar12 = this.cbo.caV;
                                                        bzVar12.adY().setVisibility(8);
                                                    } else {
                                                        SparseArray sparseArray8 = new SparseArray();
                                                        sparseArray8.put(i.f.tag_should_manage_visible, false);
                                                        sparseArray8.put(i.f.tag_display_reply_visible, false);
                                                        sparseArray8.put(i.f.tag_should_delete_visible, true);
                                                        sparseArray8.put(i.f.tag_manage_user_identity, sparseArray6.get(i.f.tag_manage_user_identity));
                                                        sparseArray8.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
                                                        sparseArray8.put(i.f.tag_del_post_id, sparseArray6.get(i.f.tag_del_post_id));
                                                        sparseArray8.put(i.f.tag_del_post_type, sparseArray6.get(i.f.tag_del_post_type));
                                                        bzVar13 = this.cbo.caV;
                                                        bzVar13.adY().setTag(sparseArray8);
                                                        bzVar14 = this.cbo.caV;
                                                        com.baidu.tbadk.core.util.al.c(bzVar14.adY(), i.e.icon_pb_del_n);
                                                        bzVar15 = this.cbo.caV;
                                                        bzVar15.adY().setVisibility(0);
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
                                                        bzVar19 = this.cbo.caV;
                                                        bzVar19.adZ().setTag(sparseArray10);
                                                        bzVar20 = this.cbo.caV;
                                                        bzVar20.adZ().setVisibility(0);
                                                        bzVar21 = this.cbo.caV;
                                                        bzVar21.adY().setVisibility(8);
                                                        bzVar22 = this.cbo.caV;
                                                        com.baidu.tbadk.core.util.al.c(bzVar22.adZ(), i.e.icon_pb_gag);
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
                                                        ed = this.cbo.ed(z4);
                                                        if (ed & this.cbo.isLogin()) {
                                                            bzVar17 = this.cbo.caV;
                                                            bzVar17.adZ().setVisibility(0);
                                                            bzVar18 = this.cbo.caV;
                                                            bzVar18.adZ().setTag(str);
                                                        } else {
                                                            bzVar16 = this.cbo.caV;
                                                            bzVar16.adZ().setVisibility(8);
                                                        }
                                                    }
                                                }
                                                boolean z5 = false;
                                                bkVar11 = this.cbo.caL;
                                                if (bkVar11.getPbData().qr()) {
                                                    bkVar12 = this.cbo.caL;
                                                    String qq = bkVar12.getPbData().qq();
                                                    if (iVar != null && !com.baidu.adp.lib.util.j.isEmpty(qq) && qq.equals(iVar.getId())) {
                                                        z5 = true;
                                                    }
                                                }
                                                if (z5) {
                                                    bzVar8 = this.cbo.caV;
                                                    bzVar8.adM().setText(i.C0057i.marked);
                                                    bzVar9 = this.cbo.caV;
                                                    bzVar9.adM().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                } else {
                                                    bzVar5 = this.cbo.caV;
                                                    bzVar5.adM().setText(i.C0057i.mark);
                                                    bzVar6 = this.cbo.caV;
                                                    bzVar6.adM().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                }
                                                bzVar7 = this.cbo.caV;
                                                bzVar7.ep(true);
                                                morePopupWindow3 = this.cbo.caU;
                                                morePopupWindow3.reLayoutWidth();
                                                morePopupWindow4 = this.cbo.caU;
                                                morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                return;
                                            } else if (id != i.f.pb_head_reverse_hint) {
                                                if (id == i.f.pb_act_btn) {
                                                    bkVar4 = this.cbo.caL;
                                                    if (bkVar4.getPbData() != null) {
                                                        bkVar5 = this.cbo.caL;
                                                        if (bkVar5.getPbData().acH() != null) {
                                                            bkVar6 = this.cbo.caL;
                                                            if (bkVar6.getPbData().acH().sB() != null) {
                                                                Activity activity = this.cbo.getActivity();
                                                                bkVar7 = this.cbo.caL;
                                                                com.baidu.tbadk.browser.f.B(activity, bkVar7.getPbData().acH().sB());
                                                                bkVar8 = this.cbo.caL;
                                                                if (bkVar8.getPbData().acH().sz() != 1) {
                                                                    bkVar9 = this.cbo.caL;
                                                                    if (bkVar9.getPbData().acH().sz() == 2) {
                                                                        TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                this.cbo.stopVoice();
                                                cbVar28 = this.cbo.caQ;
                                                cbVar28.aeA();
                                                cbVar29 = this.cbo.caQ;
                                                cbVar29.ael();
                                                bkVar10 = this.cbo.caL;
                                                bkVar10.adH();
                                                return;
                                            }
                                        }
                                        if (!this.cbo.checkUpIsLogin()) {
                                            morePopupWindow8 = this.cbo.caU;
                                            com.baidu.adp.lib.g.j.a(morePopupWindow8, this.cbo.getPageContext().getPageActivity());
                                            return;
                                        }
                                        bzVar27 = this.cbo.caV;
                                        if (bzVar27 != null) {
                                            bzVar30 = this.cbo.caV;
                                            if (view == bzVar30.adX()) {
                                                bzVar31 = this.cbo.caV;
                                                if (!bzVar31.adW()) {
                                                    morePopupWindow7 = this.cbo.caU;
                                                    com.baidu.adp.lib.g.j.a(morePopupWindow7, this.cbo.getPageContext().getPageActivity());
                                                    return;
                                                }
                                            }
                                        }
                                        bkVar13 = this.cbo.caL;
                                        if (bkVar13.getPbData() != null) {
                                            cbVar30 = this.cbo.caQ;
                                            cbVar30.aeA();
                                            SparseArray sparseArray11 = (SparseArray) view.getTag();
                                            com.baidu.tieba.tbadkCore.data.i iVar2 = (com.baidu.tieba.tbadkCore.data.i) sparseArray11.get(i.f.tag_load_sub_data);
                                            View view2 = (View) sparseArray11.get(i.f.tag_load_sub_view);
                                            if (iVar2 != null && view2 != null) {
                                                bkVar14 = this.cbo.caL;
                                                String threadID = bkVar14.getThreadID();
                                                String id2 = iVar2.getId();
                                                int i2 = 0;
                                                bkVar15 = this.cbo.caL;
                                                if (bkVar15.getPbData() != null) {
                                                    bkVar19 = this.cbo.caL;
                                                    i2 = bkVar19.getPbData().acK();
                                                }
                                                this.cbo.stopVoice();
                                                bzVar28 = this.cbo.caV;
                                                if (bzVar28 != null) {
                                                    bzVar29 = this.cbo.caV;
                                                    if (view == bzVar29.adX()) {
                                                        morePopupWindow6 = this.cbo.caU;
                                                        com.baidu.adp.lib.g.j.a(morePopupWindow6, this.cbo.getPageContext().getPageActivity());
                                                        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.cbo.getPageContext().getPageActivity());
                                                        SmallTailInfo afz = iVar2.afz();
                                                        bkVar18 = this.cbo.caL;
                                                        this.cbo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig.createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, afz, bkVar18.getPbData().rM())));
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
                                                    SubPbActivityConfig subPbActivityConfig2 = new SubPbActivityConfig(this.cbo.getPageContext().getPageActivity());
                                                    SmallTailInfo afz2 = iVar2.afz();
                                                    bkVar17 = this.cbo.caL;
                                                    this.cbo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig2.createSubPbActivityConfig(threadID, id2, "pb", true, str3, true, str4, i2, afz2, bkVar17.getPbData().rM())));
                                                    return;
                                                } else if (iVar2.aqd()) {
                                                    TiebaStatic.log("c10089");
                                                    SubPbActivityConfig subPbActivityConfig3 = new SubPbActivityConfig(this.cbo.getPageContext().getPageActivity());
                                                    SmallTailInfo afz3 = iVar2.afz();
                                                    bkVar16 = this.cbo.caL;
                                                    this.cbo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, subPbActivityConfig3.createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i2, afz3, bkVar16.getPbData().rM())));
                                                    return;
                                                } else {
                                                    iVar2.fy(true);
                                                    cbVar31 = this.cbo.caQ;
                                                    cbVar31.aeg().notifyDataSetChanged();
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    SparseArray sparseArray13 = (SparseArray) view.getTag();
                                    if (((Boolean) sparseArray13.get(i.f.tag_should_manage_visible)).booleanValue()) {
                                        cbVar33 = this.cbo.caQ;
                                        cbVar33.aa(view);
                                        return;
                                    }
                                    cbVar32 = this.cbo.caQ;
                                    cbVar32.a(((Integer) sparseArray13.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray13.get(i.f.tag_del_post_id), ((Integer) sparseArray13.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray13.get(i.f.tag_del_post_is_self)).booleanValue());
                                    return;
                                } else if (this.cbo.checkUpIsLogin()) {
                                    this.cbo.acY();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                            bkVar41 = this.cbo.caL;
                            String name = bkVar41.getPbData().acG().getName();
                            bkVar42 = this.cbo.caL;
                            if (!TextUtils.isEmpty(bkVar42.adx())) {
                                bkVar43 = this.cbo.caL;
                                if (bkVar43.adx().equals(name)) {
                                    this.cbo.finish();
                                    return;
                                }
                            }
                            if (com.baidu.tbadk.core.util.aq.aP(name)) {
                                this.cbo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cbo.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB)));
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        cbVar5 = this.cbo.caQ;
        cbVar5.aeB();
        bkVar = this.cbo.caL;
        if (bkVar.getPbData().acK() == 1) {
            aVar = this.cbo.caN;
            if (!aVar.aqN()) {
                cbVar6 = this.cbo.caQ;
                cbVar6.aei();
                int i3 = 0;
                cbVar7 = this.cbo.caQ;
                if (view != cbVar7.aev()) {
                    cbVar8 = this.cbo.caQ;
                    if (view != cbVar8.aew()) {
                        cbVar9 = this.cbo.caQ;
                        if (view != cbVar9.aex()) {
                            cbVar10 = this.cbo.caQ;
                            if (view != cbVar10.aey()) {
                                cbVar11 = this.cbo.caQ;
                                if (view == cbVar11.aej()) {
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
                bkVar2 = this.cbo.caL;
                ForumData acG2 = bkVar2.getPbData().acG();
                String name2 = acG2.getName();
                String id3 = acG2.getId();
                bkVar3 = this.cbo.caL;
                String id4 = bkVar3.getPbData().acH().getId();
                aVar2 = this.cbo.caN;
                cbVar12 = this.cbo.caQ;
                aVar2.b(id3, name2, id4, i3, cbVar12.aek());
            }
        }
    }
}
