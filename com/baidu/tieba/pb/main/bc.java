package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MorePopupWindow;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:214:0x0ab7, code lost:
        if (r21 != r1.XE()) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0cde, code lost:
        if (r1 == null) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0374, code lost:
        if (r1 == null) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x045e  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bz bzVar4;
        bq bqVar;
        com.baidu.tieba.tbadkCore.e.a aVar;
        bz bzVar5;
        bz bzVar6;
        bz bzVar7;
        bz bzVar8;
        bz bzVar9;
        bz bzVar10;
        bq bqVar2;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        bz bzVar11;
        bz bzVar12;
        bz bzVar13;
        bz bzVar14;
        bz bzVar15;
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
        bz bzVar26;
        bz bzVar27;
        bz bzVar28;
        by byVar;
        bz bzVar29;
        by byVar2;
        by byVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        bz bzVar30;
        bz bzVar31;
        bq bqVar10;
        bz bzVar32;
        com.baidu.tieba.pb.sub.e eVar;
        bz bzVar33;
        bq bqVar11;
        bz bzVar34;
        com.baidu.tieba.pb.sub.e eVar2;
        com.baidu.tieba.pb.sub.e eVar3;
        bz bzVar35;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        bq bqVar12;
        by byVar4;
        by byVar5;
        by byVar6;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        by byVar7;
        by byVar8;
        bq bqVar13;
        by byVar9;
        by byVar10;
        by byVar11;
        by byVar12;
        by byVar13;
        by byVar14;
        by byVar15;
        MorePopupWindow morePopupWindow5;
        by byVar16;
        bz bzVar36;
        bq bqVar14;
        bz bzVar37;
        bz bzVar38;
        bz bzVar39;
        bq bqVar15;
        bz bzVar40;
        by byVar17;
        bq bqVar16;
        bz bzVar41;
        bq bqVar17;
        com.baidu.tieba.pb.sub.e eVar4;
        bq bqVar18;
        com.baidu.tieba.pb.sub.e eVar5;
        com.baidu.tieba.pb.sub.e eVar6;
        by byVar18;
        Handler handler;
        bz bzVar42;
        bq bqVar19;
        by byVar19;
        MorePopupWindow morePopupWindow6;
        bz bzVar43;
        bq bqVar20;
        by byVar20;
        by byVar21;
        MorePopupWindow morePopupWindow7;
        bz bzVar44;
        by byVar22;
        bz bzVar45;
        bz bzVar46;
        by byVar23;
        bz bzVar47;
        MorePopupWindow morePopupWindow8;
        bz bzVar48;
        by byVar24;
        MorePopupWindow morePopupWindow9;
        bz bzVar49;
        bz bzVar50;
        bz bzVar51;
        bq bqVar21;
        bz bzVar52;
        bz bzVar53;
        bq bqVar22;
        bz bzVar54;
        bq bqVar23;
        bz bzVar55;
        bz bzVar56;
        bz bzVar57;
        bz bzVar58;
        boolean gP;
        bq bqVar24;
        bz bzVar59;
        bq bqVar25;
        bq bqVar26;
        bq bqVar27;
        bq bqVar28;
        bq bqVar29;
        bq bqVar30;
        boolean z;
        bz bzVar60;
        bz bzVar61;
        bz bzVar62;
        bq bqVar31;
        bq bqVar32;
        bq bqVar33;
        bq bqVar34;
        bq bqVar35;
        bq bqVar36;
        bq bqVar37;
        com.baidu.tieba.pb.sub.e eVar7;
        com.baidu.tieba.pb.sub.e eVar8;
        com.baidu.tieba.pb.sub.e eVar9;
        com.baidu.tieba.pb.sub.e eVar10;
        bz bzVar63;
        MorePopupWindow morePopupWindow10;
        bq bqVar38;
        boolean z2;
        by byVar25;
        by byVar26;
        by byVar27;
        by byVar28;
        MorePopupWindow morePopupWindow11;
        MorePopupWindow morePopupWindow12;
        by byVar29;
        by byVar30;
        bq bqVar39;
        bq bqVar40;
        by byVar31;
        by byVar32;
        bz bzVar64;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        bz bzVar65;
        bq bqVar41;
        com.baidu.tieba.tbadkCore.e.a aVar4;
        bq bqVar42;
        bq bqVar43;
        bq bqVar44;
        com.baidu.tieba.pb.sub.e eVar11;
        com.baidu.tieba.pb.sub.e eVar12;
        com.baidu.tieba.pb.sub.e eVar13;
        com.baidu.tieba.pb.sub.e eVar14;
        com.baidu.tieba.tbadkCore.e.a aVar5;
        com.baidu.tieba.pb.sub.e eVar15;
        com.baidu.tieba.pb.sub.e eVar16;
        com.baidu.tieba.pb.sub.e eVar17;
        bq bqVar45;
        bq bqVar46;
        bz bzVar66;
        bq bqVar47;
        bq bqVar48;
        bz bzVar67;
        bzVar = this.bzj.byO;
        if (view == bzVar.getNextView()) {
            bqVar48 = this.bzj.byJ;
            if (bqVar48.dK(true)) {
                bzVar67 = this.bzj.byO;
                bzVar67.Yb();
                return;
            }
            return;
        }
        bzVar2 = this.bzj.byO;
        if (view == bzVar2.bBo.aVy) {
            bzVar66 = this.bzj.byO;
            bqVar47 = this.bzj.byJ;
            if (!bzVar66.dU(bqVar47.Xj())) {
                this.bzj.closeActivity();
                return;
            } else {
                this.bzj.stopVoice();
                return;
            }
        }
        bzVar3 = this.bzj.byO;
        if (view != bzVar3.Yy()) {
            bzVar12 = this.bzj.byO;
            if (view != bzVar12.Yz()) {
                bzVar13 = this.bzj.byO;
                if (view != bzVar13.YA()) {
                    bzVar14 = this.bzj.byO;
                    if (view != bzVar14.YB()) {
                        bzVar15 = this.bzj.byO;
                        if (view != bzVar15.XX()) {
                            bzVar16 = this.bzj.byO;
                            if (view == bzVar16.YJ()) {
                                bqVar45 = this.bzj.byJ;
                                if (bqVar45 != null) {
                                    bqVar46 = this.bzj.byJ;
                                    com.baidu.tbadk.browser.a.y(this.bzj.getPageContext().getPageActivity(), bqVar46.getPbData().agE().nr().getLink());
                                    return;
                                }
                                return;
                            }
                            bzVar17 = this.bzj.byO;
                            if (view == bzVar17.XW()) {
                                bzVar64 = this.bzj.byO;
                                bzVar64.YF();
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    aVar3 = this.bzj.byN;
                                    if (!aVar3.ahJ()) {
                                        bzVar65 = this.bzj.byO;
                                        bzVar65.XV();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.w.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.w.tag_del_post_type)).intValue();
                                            bqVar41 = this.bzj.byJ;
                                            if (bqVar41.Xj()) {
                                                eVar11 = this.bzj.byM;
                                                if (eVar11 != null) {
                                                    eVar12 = this.bzj.byM;
                                                    if (eVar12.Zh() != null) {
                                                        eVar13 = this.bzj.byM;
                                                        if (eVar13.Zh().ahg() != null) {
                                                            eVar14 = this.bzj.byM;
                                                            if (eVar14.Zh().ahh() != null) {
                                                                aVar5 = this.bzj.byN;
                                                                eVar15 = this.bzj.byM;
                                                                String id = eVar15.Zh().ahg().getId();
                                                                eVar16 = this.bzj.byM;
                                                                String name = eVar16.Zh().ahg().getName();
                                                                eVar17 = this.bzj.byM;
                                                                aVar5.a(id, name, eVar17.Zh().ahh().getId(), str, intValue2, intValue, booleanValue);
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
                                            aVar4 = this.bzj.byN;
                                            bqVar42 = this.bzj.byJ;
                                            String id2 = bqVar42.getPbData().aej().getId();
                                            bqVar43 = this.bzj.byJ;
                                            String name2 = bqVar43.getPbData().aej().getName();
                                            bqVar44 = this.bzj.byJ;
                                            aVar4.a(id2, name2, bqVar44.getPbData().agE().getId(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                this.bzj.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bzj.getPageContext().getPageActivity(), this.bzj.getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11017)));
                                return;
                            }
                            bzVar18 = this.bzj.byO;
                            if (view != bzVar18.YC()) {
                                bzVar19 = this.bzj.byO;
                                if (view == bzVar19.XZ()) {
                                    eVar10 = this.bzj.byM;
                                    if (eVar10.xv()) {
                                        bzVar63 = this.bzj.byO;
                                        bzVar63.Yh();
                                        return;
                                    }
                                    return;
                                }
                                bzVar20 = this.bzj.byO;
                                if (view == bzVar20.XS()) {
                                    eVar7 = this.bzj.byM;
                                    if (eVar7 != null) {
                                        eVar8 = this.bzj.byM;
                                        if (eVar8.Xf() != null) {
                                            PbActivity pbActivity = this.bzj;
                                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bzj.getPageContext().getPageActivity());
                                            eVar9 = this.bzj.byM;
                                            pbActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(eVar9.Xf(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bzVar21 = this.bzj.byO;
                                if (view != bzVar21.bBo.bDj) {
                                    bzVar22 = this.bzj.byO;
                                    if (view == bzVar22.bBo.bDl) {
                                        bqVar32 = this.bzj.byJ;
                                        if (bqVar32 != null) {
                                            bqVar33 = this.bzj.byJ;
                                            if (bqVar33.getPbData() != null) {
                                                bqVar34 = this.bzj.byJ;
                                                ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = bqVar34.getPbData().agF();
                                                if (agF == null || agF.size() <= 0) {
                                                    com.baidu.adp.lib.util.l.showToast(this.bzj.getPageContext().getPageActivity(), this.bzj.getPageContext().getString(com.baidu.tieba.z.pb_no_data_tips));
                                                    return;
                                                } else {
                                                    this.bzj.WG();
                                                    return;
                                                }
                                            }
                                        }
                                        com.baidu.adp.lib.util.l.showToast(this.bzj.getPageContext().getPageActivity(), this.bzj.getPageContext().getString(com.baidu.tieba.z.pb_no_data_tips));
                                        return;
                                    }
                                    bzVar23 = this.bzj.byO;
                                    if (view == bzVar23.bBo.bDk) {
                                        z = this.bzj.ZD;
                                        if (!z) {
                                            this.bzj.ZD = true;
                                            bzVar60 = this.bzj.byO;
                                            bzVar60.bBo.bDk.setEnabled(false);
                                            bzVar61 = this.bzj.byO;
                                            bzVar61.PR();
                                            this.bzj.stopVoice();
                                            bzVar62 = this.bzj.byO;
                                            bzVar62.Ya();
                                            bqVar31 = this.bzj.byJ;
                                            bqVar31.Xo();
                                            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                        return;
                                    }
                                    bzVar24 = this.bzj.byO;
                                    if (view == bzVar24.bBo.bDm) {
                                        bqVar25 = this.bzj.byJ;
                                        AdditionData agH = bqVar25.getPbData().agH();
                                        if (!TextUtils.isEmpty(agH.getWarnMsg())) {
                                            com.baidu.adp.lib.util.l.showToast(this.bzj.getPageContext().getPageActivity(), agH.getWarnMsg());
                                            return;
                                        } else if (agH.getAlreadyCount() != agH.getTotalCount()) {
                                            bqVar26 = this.bzj.byJ;
                                            ForumData aej = bqVar26.getPbData().aej();
                                            bqVar27 = this.bzj.byJ;
                                            com.baidu.tbadk.core.data.w agE = bqVar27.getPbData().agE();
                                            bqVar28 = this.bzj.byJ;
                                            AntiData mP = bqVar28.getPbData().mP();
                                            if (agE.getId() != null) {
                                                if (mP != null && mP.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.l.showToast(this.bzj.getPageContext().getPageActivity(), mP.getForbid_info());
                                                    return;
                                                }
                                                int i = 0;
                                                bqVar29 = this.bzj.byJ;
                                                if (bqVar29.getPbData().getUserData() != null) {
                                                    bqVar30 = this.bzj.byJ;
                                                    i = bqVar30.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bzj.getPageContext().getPageActivity(), 2, aej.getId(), aej.getName(), agE.getId(), agH.getPostId(), 0, mP, 13008, false, false, null, false, false, null, agH, null, i)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(this.bzj.getPageContext().getPageActivity(), String.format(this.bzj.getPageContext().getString(com.baidu.tieba.z.write_addition_limit), Integer.valueOf(agH.getTotalCount())));
                                            return;
                                        }
                                    }
                                    bzVar25 = this.bzj.byO;
                                    if (bzVar25.bBo.YR() != null) {
                                        bzVar57 = this.bzj.byO;
                                        if (view == bzVar57.bBo.YR().Xu()) {
                                            bzVar58 = this.bzj.byO;
                                            bzVar58.YE();
                                            gP = this.bzj.gP(11009);
                                            if (gP) {
                                                bqVar24 = this.bzj.byJ;
                                                bzVar59 = this.bzj.byO;
                                                if (bqVar24.gW(bzVar59.Yr()) == null) {
                                                    return;
                                                }
                                                this.bzj.WL();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    bzVar26 = this.bzj.byO;
                                    if (bzVar26.bBo.YR() != null) {
                                        bzVar55 = this.bzj.byO;
                                        if (view == bzVar55.bBo.YR().Xv()) {
                                            bzVar56 = this.bzj.byO;
                                            bzVar56.YE();
                                            this.bzj.stopVoice();
                                            this.bzj.showShareDialog();
                                            return;
                                        }
                                    }
                                    bzVar27 = this.bzj.byO;
                                    if (bzVar27.bBo.YR() != null) {
                                        bzVar52 = this.bzj.byO;
                                        if (view == bzVar52.bBo.YR().Xx()) {
                                            bzVar53 = this.bzj.byO;
                                            bzVar53.YE();
                                            bqVar22 = this.bzj.byJ;
                                            if (bqVar22.Xl() != null) {
                                                bzVar54 = this.bzj.byO;
                                                bqVar23 = this.bzj.byJ;
                                                bzVar54.b(bqVar23.Xl());
                                            }
                                            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    bzVar28 = this.bzj.byO;
                                    if (bzVar28.bBo.YR() != null) {
                                        bzVar49 = this.bzj.byO;
                                        if (view == bzVar49.bBo.YR().Xy()) {
                                            bzVar50 = this.bzj.byO;
                                            bzVar50.YE();
                                            this.bzj.stopVoice();
                                            bzVar51 = this.bzj.byO;
                                            bzVar51.Ya();
                                            bqVar21 = this.bzj.byJ;
                                            bqVar21.Xp();
                                            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    byVar = this.bzj.byT;
                                    if (byVar != null) {
                                        byVar24 = this.bzj.byT;
                                        if (view == byVar24.Xu()) {
                                            this.bzj.I(view);
                                            morePopupWindow9 = this.bzj.byS;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow9, this.bzj.getPageContext().getPageActivity());
                                            return;
                                        }
                                    }
                                    bzVar29 = this.bzj.byO;
                                    if (bzVar29.XM() != view) {
                                        byVar2 = this.bzj.byT;
                                        if (byVar2 != null) {
                                            byVar23 = this.bzj.byT;
                                            if (view == byVar23.XF()) {
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                if (sparseArray2 != null) {
                                                    if ("".equals(sparseArray2.get(com.baidu.tieba.w.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.w.tag_del_post_id))) {
                                                        bzVar47 = this.bzj.byO;
                                                        bzVar47.a(((Integer) sparseArray2.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
                                                    } else {
                                                        bzVar48 = this.bzj.byO;
                                                        bzVar48.N(view);
                                                    }
                                                    morePopupWindow8 = this.bzj.byS;
                                                    com.baidu.adp.lib.g.k.a(morePopupWindow8, this.bzj.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        if (view.getId() != com.baidu.tieba.w.pb_head_function_manage_delormanage) {
                                            byVar3 = this.bzj.byT;
                                            if (byVar3 != null) {
                                                byVar22 = this.bzj.byT;
                                            }
                                            if (view.getId() != com.baidu.tieba.w.sub_pb_more && view.getId() != com.baidu.tieba.w.sub_pb_item) {
                                                int id3 = view.getId();
                                                if (id3 == com.baidu.tieba.w.dialog_button_ok) {
                                                    bqVar14 = this.bzj.byJ;
                                                    com.baidu.tbadk.core.data.p Xl = bqVar14.Xl();
                                                    bzVar37 = this.bzj.byO;
                                                    int pageNum = bzVar37.getPageNum();
                                                    if (pageNum <= 0) {
                                                        this.bzj.showToast(com.baidu.tieba.z.pb_page_error);
                                                        return;
                                                    } else if (Xl == null || pageNum <= Xl.mS()) {
                                                        bzVar38 = this.bzj.byO;
                                                        bzVar38.YE();
                                                        this.bzj.stopVoice();
                                                        bzVar39 = this.bzj.byO;
                                                        bzVar39.Ya();
                                                        bqVar15 = this.bzj.byJ;
                                                        bzVar40 = this.bzj.byO;
                                                        bqVar15.gR(bzVar40.getPageNum());
                                                        return;
                                                    } else {
                                                        this.bzj.showToast(com.baidu.tieba.z.pb_page_error);
                                                        return;
                                                    }
                                                } else if (id3 == com.baidu.tieba.w.dialog_button_cancel) {
                                                    bzVar36 = this.bzj.byO;
                                                    bzVar36.YE();
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.reply) {
                                                    morePopupWindow = this.bzj.byS;
                                                    if (morePopupWindow != null) {
                                                        byVar16 = this.bzj.byT;
                                                    }
                                                    this.bzj.WE();
                                                    morePopupWindow2 = this.bzj.byS;
                                                    if (morePopupWindow2.getIsIntercepted()) {
                                                        morePopupWindow5 = this.bzj.byS;
                                                        morePopupWindow5.setIsIntercepted(false);
                                                        return;
                                                    }
                                                    com.baidu.tieba.tbadkCore.b.k kVar = null;
                                                    if (view != null && view.getTag() != null) {
                                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                        kVar = (com.baidu.tieba.tbadkCore.b.k) sparseArray3.get(com.baidu.tieba.w.tag_load_sub_data);
                                                        SparseArray sparseArray4 = new SparseArray();
                                                        sparseArray4.put(com.baidu.tieba.w.tag_load_sub_data, kVar);
                                                        sparseArray4.put(com.baidu.tieba.w.tag_load_sub_view, (View) sparseArray3.get(com.baidu.tieba.w.tag_load_sub_view));
                                                        byVar9 = this.bzj.byT;
                                                        byVar9.XE().setTag(sparseArray4);
                                                        SparseArray sparseArray5 = new SparseArray();
                                                        sparseArray5.put(com.baidu.tieba.w.tag_clip_board, (com.baidu.tieba.tbadkCore.b.k) ((SparseArray) view.getTag()).get(com.baidu.tieba.w.tag_clip_board));
                                                        sparseArray5.put(com.baidu.tieba.w.tag_is_subpb, false);
                                                        byVar10 = this.bzj.byT;
                                                        byVar10.Xu().setTag(sparseArray5);
                                                        SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                        if (!((Boolean) sparseArray6.get(com.baidu.tieba.w.tag_should_manage_visible)).booleanValue()) {
                                                            byVar11 = this.bzj.byT;
                                                            byVar11.XF().setVisibility(8);
                                                        } else {
                                                            SparseArray sparseArray7 = new SparseArray();
                                                            sparseArray7.put(com.baidu.tieba.w.tag_manage_user_identity, sparseArray6.get(com.baidu.tieba.w.tag_manage_user_identity));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_is_self, sparseArray6.get(com.baidu.tieba.w.tag_del_post_is_self));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_id, sparseArray6.get(com.baidu.tieba.w.tag_del_post_id));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_type, sparseArray6.get(com.baidu.tieba.w.tag_del_post_type));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_forbid_user_name, sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_name));
                                                            byVar12 = this.bzj.byT;
                                                            byVar12.XF().setTag(sparseArray7);
                                                            if ("".equals(sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_name)) || "".equals(sparseArray6.get(com.baidu.tieba.w.tag_del_post_id))) {
                                                                byVar13 = this.bzj.byT;
                                                                com.baidu.tbadk.core.util.ax.c(byVar13.XF(), com.baidu.tieba.v.icon_pb_del_n);
                                                            } else {
                                                                byVar15 = this.bzj.byT;
                                                                com.baidu.tbadk.core.util.ax.c(byVar15.XF(), com.baidu.tieba.v.icon_pb_set_n);
                                                            }
                                                            byVar14 = this.bzj.byT;
                                                            byVar14.XF().setVisibility(0);
                                                        }
                                                    }
                                                    boolean z3 = false;
                                                    bqVar12 = this.bzj.byJ;
                                                    if (bqVar12.getPbData().li()) {
                                                        bqVar13 = this.bzj.byJ;
                                                        String lk = bqVar13.getPbData().lk();
                                                        if (kVar != null && !com.baidu.adp.lib.util.k.isEmpty(lk) && lk.equals(kVar.getId())) {
                                                            z3 = true;
                                                        }
                                                    }
                                                    if (z3) {
                                                        byVar7 = this.bzj.byT;
                                                        byVar7.Xu().setText(com.baidu.tieba.z.marked);
                                                        byVar8 = this.bzj.byT;
                                                        byVar8.Xu().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    } else {
                                                        byVar4 = this.bzj.byT;
                                                        byVar4.Xu().setText(com.baidu.tieba.z.mark);
                                                        byVar5 = this.bzj.byT;
                                                        byVar5.Xu().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    }
                                                    byVar6 = this.bzj.byT;
                                                    byVar6.dO(true);
                                                    morePopupWindow3 = this.bzj.byS;
                                                    morePopupWindow3.reLayoutWidth();
                                                    morePopupWindow4 = this.bzj.byS;
                                                    morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.sub_post_load_more) {
                                                    eVar3 = this.bzj.byM;
                                                    if (eVar3.xv()) {
                                                        bzVar35 = this.bzj.byO;
                                                        bzVar35.Yh();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.sub_pb_bottom_layout) {
                                                    bqVar11 = this.bzj.byJ;
                                                    if (bqVar11.Xj()) {
                                                        this.bzj.closeActivity();
                                                        return;
                                                    }
                                                    this.bzj.stopVoice();
                                                    bzVar34 = this.bzj.byO;
                                                    bzVar34.Yk();
                                                    eVar2 = this.bzj.byM;
                                                    eVar2.cancelLoadData();
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.btn_loadprevious) {
                                                    eVar = this.bzj.byM;
                                                    if (eVar.Zn()) {
                                                        bzVar33 = this.bzj.byO;
                                                        bzVar33.Yi();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.pb_new_guide) {
                                                    SharedPreferences.Editor edit = this.bzj.getPageContext().getPageActivity().getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                    edit.putBoolean("has_shown_pb_guide", true);
                                                    edit.commit();
                                                    bzVar32 = this.bzj.byO;
                                                    bzVar32.GN();
                                                    return;
                                                } else if (id3 != com.baidu.tieba.w.pb_head_reverse_hint) {
                                                    if (id3 == com.baidu.tieba.w.pb_act_btn) {
                                                        bqVar4 = this.bzj.byJ;
                                                        if (bqVar4.getPbData() != null) {
                                                            bqVar5 = this.bzj.byJ;
                                                            if (bqVar5.getPbData().agE() != null) {
                                                                bqVar6 = this.bzj.byJ;
                                                                if (bqVar6.getPbData().agE().nI() != null) {
                                                                    Activity activity = this.bzj.getActivity();
                                                                    bqVar7 = this.bzj.byJ;
                                                                    com.baidu.tbadk.browser.a.y(activity, bqVar7.getPbData().agE().nI());
                                                                    bqVar8 = this.bzj.byJ;
                                                                    if (bqVar8.getPbData().agE().nG() != 1) {
                                                                        bqVar9 = this.bzj.byJ;
                                                                        if (bqVar9.getPbData().agE().nG() == 2) {
                                                                            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                    this.bzj.stopVoice();
                                                    bzVar30 = this.bzj.byO;
                                                    bzVar30.YE();
                                                    bzVar31 = this.bzj.byO;
                                                    bzVar31.Ya();
                                                    bqVar10 = this.bzj.byJ;
                                                    bqVar10.Xp();
                                                    return;
                                                }
                                            }
                                            byVar17 = this.bzj.byT;
                                            if (byVar17 != null) {
                                                byVar20 = this.bzj.byT;
                                                if (view == byVar20.XE()) {
                                                    byVar21 = this.bzj.byT;
                                                    if (!byVar21.XD()) {
                                                        morePopupWindow7 = this.bzj.byS;
                                                        com.baidu.adp.lib.g.k.a(morePopupWindow7, this.bzj.getPageContext().getPageActivity());
                                                        bzVar44 = this.bzj.byO;
                                                        bzVar44.dR(true);
                                                        return;
                                                    }
                                                }
                                            }
                                            try {
                                                bqVar16 = this.bzj.byJ;
                                                if (bqVar16.getPbData() != null) {
                                                    bzVar41 = this.bzj.byO;
                                                    bzVar41.YE();
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.b.k kVar2 = (com.baidu.tieba.tbadkCore.b.k) sparseArray8.get(com.baidu.tieba.w.tag_load_sub_data);
                                                    View view2 = (View) sparseArray8.get(com.baidu.tieba.w.tag_load_sub_view);
                                                    if (kVar2 != null && view2 != null) {
                                                        bqVar17 = this.bzj.byJ;
                                                        com.baidu.tieba.tbadkCore.b.o b = bqVar17.b(kVar2);
                                                        eVar4 = this.bzj.byM;
                                                        bqVar18 = this.bzj.byJ;
                                                        eVar4.hz(bqVar18.Xf());
                                                        eVar5 = this.bzj.byM;
                                                        eVar5.bG(kVar2.getId());
                                                        eVar6 = this.bzj.byM;
                                                        eVar6.resetData();
                                                        this.bzj.stopVoice();
                                                        byVar18 = this.bzj.byT;
                                                        if (byVar18 != null) {
                                                            byVar19 = this.bzj.byT;
                                                            if (view == byVar19.XE()) {
                                                                morePopupWindow6 = this.bzj.byS;
                                                                com.baidu.adp.lib.g.k.a(morePopupWindow6, this.bzj.getPageContext().getPageActivity());
                                                                bzVar43 = this.bzj.byO;
                                                                bqVar20 = this.bzj.byJ;
                                                                bzVar43.a(true, b, false, null, null, view2, bqVar20.getPbData().agG());
                                                                return;
                                                            }
                                                        }
                                                        if (view.getId() != com.baidu.tieba.w.sub_pb_item) {
                                                            handler = this.bzj.mHandler;
                                                            handler.post(new bd(this, b, view2));
                                                            return;
                                                        }
                                                        SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                        String str2 = (String) sparseArray9.get(com.baidu.tieba.w.tag_photo_username);
                                                        com.baidu.tieba.tbadkCore.b.k kVar3 = (com.baidu.tieba.tbadkCore.b.k) sparseArray9.get(com.baidu.tieba.w.tag_clip_board);
                                                        String str3 = null;
                                                        if (kVar3 != null) {
                                                            str3 = kVar3.getId();
                                                        }
                                                        bzVar42 = this.bzj.byO;
                                                        bqVar19 = this.bzj.byJ;
                                                        bzVar42.a(true, b, false, str2, str3, view2, bqVar19.getPbData().agG());
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } catch (Exception e) {
                                                BdLog.e(e.toString());
                                                return;
                                            }
                                        }
                                        SparseArray sparseArray10 = (SparseArray) view.getTag();
                                        if (((Boolean) sparseArray10.get(com.baidu.tieba.w.tag_should_manage_visible)).booleanValue()) {
                                            bzVar46 = this.bzj.byO;
                                            bzVar46.N(view);
                                            return;
                                        }
                                        bzVar45 = this.bzj.byO;
                                        bzVar45.a(((Integer) sparseArray10.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
                                        return;
                                    }
                                    this.bzj.WA();
                                    return;
                                }
                                TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bqVar35 = this.bzj.byJ;
                                String name3 = bqVar35.getPbData().aej().getName();
                                bqVar36 = this.bzj.byJ;
                                if (!TextUtils.isEmpty(bqVar36.Xe())) {
                                    bqVar37 = this.bzj.byJ;
                                    if (bqVar37.Xe().equals(name3)) {
                                        this.bzj.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.ba.aC(name3)) {
                                    this.bzj.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bzj.getPageContext().getPageActivity()).createNormalCfg(name3, FrsActivityConfig.FRS_FROM_PB)));
                                    return;
                                }
                                return;
                            }
                            morePopupWindow10 = this.bzj.byS;
                            if (morePopupWindow10 != null) {
                                byVar32 = this.bzj.byT;
                            }
                            this.bzj.WE();
                            com.baidu.tieba.tbadkCore.b.k kVar4 = null;
                            if (view != null && view.getTag() != null) {
                                kVar4 = (com.baidu.tieba.tbadkCore.b.k) ((SparseArray) view.getTag()).get(com.baidu.tieba.w.tag_clip_board);
                                SparseArray sparseArray11 = new SparseArray();
                                sparseArray11.put(com.baidu.tieba.w.tag_clip_board, kVar4);
                                sparseArray11.put(com.baidu.tieba.w.tag_is_subpb, false);
                                byVar31 = this.bzj.byT;
                                byVar31.Xu().setTag(sparseArray11);
                            }
                            bqVar38 = this.bzj.byJ;
                            if (bqVar38.getPbData() != null) {
                                bqVar39 = this.bzj.byJ;
                                if (bqVar39.getPbData().li()) {
                                    bqVar40 = this.bzj.byJ;
                                    String lk2 = bqVar40.getPbData().lk();
                                    if (kVar4 != null && !com.baidu.adp.lib.util.k.isEmpty(lk2) && lk2.equals(kVar4.getId())) {
                                        z2 = true;
                                        if (!z2) {
                                            byVar29 = this.bzj.byT;
                                            byVar29.Xu().setText(com.baidu.tieba.z.marked);
                                            byVar30 = this.bzj.byT;
                                            byVar30.Xu().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                        } else {
                                            byVar25 = this.bzj.byT;
                                            byVar25.Xu().setText(com.baidu.tieba.z.mark);
                                            byVar26 = this.bzj.byT;
                                            byVar26.Xu().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                        }
                                        byVar27 = this.bzj.byT;
                                        byVar27.XF().setVisibility(8);
                                        byVar28 = this.bzj.byT;
                                        byVar28.dO(false);
                                        morePopupWindow11 = this.bzj.byS;
                                        morePopupWindow11.reLayoutWidth();
                                        morePopupWindow12 = this.bzj.byS;
                                        morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                                        return;
                                    }
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                            byVar27 = this.bzj.byT;
                            byVar27.XF().setVisibility(8);
                            byVar28 = this.bzj.byT;
                            byVar28.dO(false);
                            morePopupWindow11 = this.bzj.byS;
                            morePopupWindow11.reLayoutWidth();
                            morePopupWindow12 = this.bzj.byS;
                            morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                            return;
                        }
                    }
                }
            }
        }
        bzVar4 = this.bzj.byO;
        bzVar4.YF();
        bqVar = this.bzj.byJ;
        if (bqVar.getPbData().agG() == 1) {
            aVar = this.bzj.byN;
            if (!aVar.ahJ()) {
                bzVar5 = this.bzj.byO;
                bzVar5.XV();
                int i2 = 0;
                bzVar6 = this.bzj.byO;
                if (view != bzVar6.Yy()) {
                    bzVar7 = this.bzj.byO;
                    if (view != bzVar7.Yz()) {
                        bzVar8 = this.bzj.byO;
                        if (view != bzVar8.YA()) {
                            bzVar9 = this.bzj.byO;
                            if (view != bzVar9.YB()) {
                                bzVar10 = this.bzj.byO;
                                if (view == bzVar10.XX()) {
                                    i2 = 2;
                                }
                            } else {
                                i2 = 5;
                            }
                        } else {
                            i2 = 4;
                        }
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 6;
                }
                bqVar2 = this.bzj.byJ;
                ForumData aej2 = bqVar2.getPbData().aej();
                String name4 = aej2.getName();
                String id4 = aej2.getId();
                bqVar3 = this.bzj.byJ;
                String id5 = bqVar3.getPbData().agE().getId();
                aVar2 = this.bzj.byN;
                bzVar11 = this.bzj.byO;
                aVar2.b(id4, name4, id5, i2, bzVar11.XY());
            }
        }
    }
}
