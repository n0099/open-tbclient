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
class bd implements View.OnClickListener {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:214:0x0ab7, code lost:
        if (r21 != r1.Ye()) goto L276;
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
        boolean gY;
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
        bzVar = this.bAS.bAw;
        if (view == bzVar.getNextView()) {
            bqVar48 = this.bAS.bAr;
            if (bqVar48.dQ(true)) {
                bzVar67 = this.bAS.bAw;
                bzVar67.YB();
                return;
            }
            return;
        }
        bzVar2 = this.bAS.bAw;
        if (view == bzVar2.bCX.aWQ) {
            bzVar66 = this.bAS.bAw;
            bqVar47 = this.bAS.bAr;
            if (!bzVar66.ea(bqVar47.XJ())) {
                this.bAS.closeActivity();
                return;
            } else {
                this.bAS.stopVoice();
                return;
            }
        }
        bzVar3 = this.bAS.bAw;
        if (view != bzVar3.YY()) {
            bzVar12 = this.bAS.bAw;
            if (view != bzVar12.YZ()) {
                bzVar13 = this.bAS.bAw;
                if (view != bzVar13.Za()) {
                    bzVar14 = this.bAS.bAw;
                    if (view != bzVar14.Zb()) {
                        bzVar15 = this.bAS.bAw;
                        if (view != bzVar15.Yx()) {
                            bzVar16 = this.bAS.bAw;
                            if (view == bzVar16.Zj()) {
                                bqVar45 = this.bAS.bAr;
                                if (bqVar45 != null) {
                                    bqVar46 = this.bAS.bAr;
                                    com.baidu.tbadk.browser.a.x(this.bAS.getPageContext().getPageActivity(), bqVar46.getPbData().ahe().nm().getLink());
                                    return;
                                }
                                return;
                            }
                            bzVar17 = this.bAS.bAw;
                            if (view == bzVar17.Yw()) {
                                bzVar64 = this.bAS.bAw;
                                bzVar64.Zf();
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    aVar3 = this.bAS.bAv;
                                    if (!aVar3.aii()) {
                                        bzVar65 = this.bAS.bAw;
                                        bzVar65.Yv();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.w.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.w.tag_del_post_type)).intValue();
                                            bqVar41 = this.bAS.bAr;
                                            if (bqVar41.XJ()) {
                                                eVar11 = this.bAS.bAu;
                                                if (eVar11 != null) {
                                                    eVar12 = this.bAS.bAu;
                                                    if (eVar12.ZH() != null) {
                                                        eVar13 = this.bAS.bAu;
                                                        if (eVar13.ZH().ahG() != null) {
                                                            eVar14 = this.bAS.bAu;
                                                            if (eVar14.ZH().ahH() != null) {
                                                                aVar5 = this.bAS.bAv;
                                                                eVar15 = this.bAS.bAu;
                                                                String id = eVar15.ZH().ahG().getId();
                                                                eVar16 = this.bAS.bAu;
                                                                String name = eVar16.ZH().ahG().getName();
                                                                eVar17 = this.bAS.bAu;
                                                                aVar5.a(id, name, eVar17.ZH().ahH().getId(), str, intValue2, intValue, booleanValue);
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
                                            aVar4 = this.bAS.bAv;
                                            bqVar42 = this.bAS.bAr;
                                            String id2 = bqVar42.getPbData().aeI().getId();
                                            bqVar43 = this.bAS.bAr;
                                            String name2 = bqVar43.getPbData().aeI().getName();
                                            bqVar44 = this.bAS.bAr;
                                            aVar4.a(id2, name2, bqVar44.getPbData().ahe().getId(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                this.bAS.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bAS.getPageContext().getPageActivity(), this.bAS.getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11017)));
                                return;
                            }
                            bzVar18 = this.bAS.bAw;
                            if (view != bzVar18.Zc()) {
                                bzVar19 = this.bAS.bAw;
                                if (view == bzVar19.Yz()) {
                                    eVar10 = this.bAS.bAu;
                                    if (eVar10.xF()) {
                                        bzVar63 = this.bAS.bAw;
                                        bzVar63.YH();
                                        return;
                                    }
                                    return;
                                }
                                bzVar20 = this.bAS.bAw;
                                if (view == bzVar20.Ys()) {
                                    eVar7 = this.bAS.bAu;
                                    if (eVar7 != null) {
                                        eVar8 = this.bAS.bAu;
                                        if (eVar8.XF() != null) {
                                            PbActivity pbActivity = this.bAS;
                                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bAS.getPageContext().getPageActivity());
                                            eVar9 = this.bAS.bAu;
                                            pbActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(eVar9.XF(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bzVar21 = this.bAS.bAw;
                                if (view != bzVar21.bCX.bET) {
                                    bzVar22 = this.bAS.bAw;
                                    if (view == bzVar22.bCX.bEV) {
                                        bqVar32 = this.bAS.bAr;
                                        if (bqVar32 != null) {
                                            bqVar33 = this.bAS.bAr;
                                            if (bqVar33.getPbData() != null) {
                                                bqVar34 = this.bAS.bAr;
                                                ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = bqVar34.getPbData().ahf();
                                                if (ahf == null || ahf.size() <= 0) {
                                                    com.baidu.adp.lib.util.l.showToast(this.bAS.getPageContext().getPageActivity(), this.bAS.getPageContext().getString(com.baidu.tieba.z.pb_no_data_tips));
                                                    return;
                                                } else {
                                                    this.bAS.Xg();
                                                    return;
                                                }
                                            }
                                        }
                                        com.baidu.adp.lib.util.l.showToast(this.bAS.getPageContext().getPageActivity(), this.bAS.getPageContext().getString(com.baidu.tieba.z.pb_no_data_tips));
                                        return;
                                    }
                                    bzVar23 = this.bAS.bAw;
                                    if (view == bzVar23.bCX.bEU) {
                                        z = this.bAS.aab;
                                        if (!z) {
                                            this.bAS.aab = true;
                                            bzVar60 = this.bAS.bAw;
                                            bzVar60.bCX.bEU.setEnabled(false);
                                            bzVar61 = this.bAS.bAw;
                                            bzVar61.Qj();
                                            this.bAS.stopVoice();
                                            bzVar62 = this.bAS.bAw;
                                            bzVar62.YA();
                                            bqVar31 = this.bAS.bAr;
                                            bqVar31.XO();
                                            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                        return;
                                    }
                                    bzVar24 = this.bAS.bAw;
                                    if (view == bzVar24.bCX.bEW) {
                                        bqVar25 = this.bAS.bAr;
                                        AdditionData ahh = bqVar25.getPbData().ahh();
                                        if (!TextUtils.isEmpty(ahh.getWarnMsg())) {
                                            com.baidu.adp.lib.util.l.showToast(this.bAS.getPageContext().getPageActivity(), ahh.getWarnMsg());
                                            return;
                                        } else if (ahh.getAlreadyCount() != ahh.getTotalCount()) {
                                            bqVar26 = this.bAS.bAr;
                                            ForumData aeI = bqVar26.getPbData().aeI();
                                            bqVar27 = this.bAS.bAr;
                                            com.baidu.tbadk.core.data.x ahe = bqVar27.getPbData().ahe();
                                            bqVar28 = this.bAS.bAr;
                                            AntiData mK = bqVar28.getPbData().mK();
                                            if (ahe.getId() != null) {
                                                if (mK != null && mK.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.l.showToast(this.bAS.getPageContext().getPageActivity(), mK.getForbid_info());
                                                    return;
                                                }
                                                int i = 0;
                                                bqVar29 = this.bAS.bAr;
                                                if (bqVar29.getPbData().getUserData() != null) {
                                                    bqVar30 = this.bAS.bAr;
                                                    i = bqVar30.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bAS.getPageContext().getPageActivity(), 2, aeI.getId(), aeI.getName(), ahe.getId(), ahh.getPostId(), 0, mK, 13008, false, false, null, false, false, null, ahh, null, i)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(this.bAS.getPageContext().getPageActivity(), String.format(this.bAS.getPageContext().getString(com.baidu.tieba.z.write_addition_limit), Integer.valueOf(ahh.getTotalCount())));
                                            return;
                                        }
                                    }
                                    bzVar25 = this.bAS.bAw;
                                    if (bzVar25.bCX.Zr() != null) {
                                        bzVar57 = this.bAS.bAw;
                                        if (view == bzVar57.bCX.Zr().XU()) {
                                            bzVar58 = this.bAS.bAw;
                                            bzVar58.Ze();
                                            gY = this.bAS.gY(11009);
                                            if (gY) {
                                                bqVar24 = this.bAS.bAr;
                                                bzVar59 = this.bAS.bAw;
                                                if (bqVar24.hf(bzVar59.YR()) == null) {
                                                    return;
                                                }
                                                this.bAS.Xl();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    bzVar26 = this.bAS.bAw;
                                    if (bzVar26.bCX.Zr() != null) {
                                        bzVar55 = this.bAS.bAw;
                                        if (view == bzVar55.bCX.Zr().XV()) {
                                            bzVar56 = this.bAS.bAw;
                                            bzVar56.Ze();
                                            this.bAS.stopVoice();
                                            this.bAS.showShareDialog();
                                            return;
                                        }
                                    }
                                    bzVar27 = this.bAS.bAw;
                                    if (bzVar27.bCX.Zr() != null) {
                                        bzVar52 = this.bAS.bAw;
                                        if (view == bzVar52.bCX.Zr().XX()) {
                                            bzVar53 = this.bAS.bAw;
                                            bzVar53.Ze();
                                            bqVar22 = this.bAS.bAr;
                                            if (bqVar22.XL() != null) {
                                                bzVar54 = this.bAS.bAw;
                                                bqVar23 = this.bAS.bAr;
                                                bzVar54.b(bqVar23.XL());
                                            }
                                            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    bzVar28 = this.bAS.bAw;
                                    if (bzVar28.bCX.Zr() != null) {
                                        bzVar49 = this.bAS.bAw;
                                        if (view == bzVar49.bCX.Zr().XY()) {
                                            bzVar50 = this.bAS.bAw;
                                            bzVar50.Ze();
                                            this.bAS.stopVoice();
                                            bzVar51 = this.bAS.bAw;
                                            bzVar51.YA();
                                            bqVar21 = this.bAS.bAr;
                                            bqVar21.XP();
                                            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    byVar = this.bAS.bAB;
                                    if (byVar != null) {
                                        byVar24 = this.bAS.bAB;
                                        if (view == byVar24.XU()) {
                                            this.bAS.K(view);
                                            morePopupWindow9 = this.bAS.bAA;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow9, this.bAS.getPageContext().getPageActivity());
                                            return;
                                        }
                                    }
                                    bzVar29 = this.bAS.bAw;
                                    if (bzVar29.Ym() != view) {
                                        byVar2 = this.bAS.bAB;
                                        if (byVar2 != null) {
                                            byVar23 = this.bAS.bAB;
                                            if (view == byVar23.Yf()) {
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                if (sparseArray2 != null) {
                                                    if ("".equals(sparseArray2.get(com.baidu.tieba.w.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.w.tag_del_post_id))) {
                                                        bzVar47 = this.bAS.bAw;
                                                        bzVar47.a(((Integer) sparseArray2.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
                                                    } else {
                                                        bzVar48 = this.bAS.bAw;
                                                        bzVar48.P(view);
                                                    }
                                                    morePopupWindow8 = this.bAS.bAA;
                                                    com.baidu.adp.lib.g.k.a(morePopupWindow8, this.bAS.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        if (view.getId() != com.baidu.tieba.w.pb_head_function_manage_delormanage) {
                                            byVar3 = this.bAS.bAB;
                                            if (byVar3 != null) {
                                                byVar22 = this.bAS.bAB;
                                            }
                                            if (view.getId() != com.baidu.tieba.w.sub_pb_more && view.getId() != com.baidu.tieba.w.sub_pb_item) {
                                                int id3 = view.getId();
                                                if (id3 == com.baidu.tieba.w.dialog_button_ok) {
                                                    bqVar14 = this.bAS.bAr;
                                                    com.baidu.tbadk.core.data.q XL = bqVar14.XL();
                                                    bzVar37 = this.bAS.bAw;
                                                    int pageNum = bzVar37.getPageNum();
                                                    if (pageNum <= 0) {
                                                        this.bAS.showToast(com.baidu.tieba.z.pb_page_error);
                                                        return;
                                                    } else if (XL == null || pageNum <= XL.mN()) {
                                                        bzVar38 = this.bAS.bAw;
                                                        bzVar38.Ze();
                                                        this.bAS.stopVoice();
                                                        bzVar39 = this.bAS.bAw;
                                                        bzVar39.YA();
                                                        bqVar15 = this.bAS.bAr;
                                                        bzVar40 = this.bAS.bAw;
                                                        bqVar15.ha(bzVar40.getPageNum());
                                                        return;
                                                    } else {
                                                        this.bAS.showToast(com.baidu.tieba.z.pb_page_error);
                                                        return;
                                                    }
                                                } else if (id3 == com.baidu.tieba.w.dialog_button_cancel) {
                                                    bzVar36 = this.bAS.bAw;
                                                    bzVar36.Ze();
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.reply) {
                                                    morePopupWindow = this.bAS.bAA;
                                                    if (morePopupWindow != null) {
                                                        byVar16 = this.bAS.bAB;
                                                    }
                                                    this.bAS.Xe();
                                                    morePopupWindow2 = this.bAS.bAA;
                                                    if (morePopupWindow2.getIsIntercepted()) {
                                                        morePopupWindow5 = this.bAS.bAA;
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
                                                        byVar9 = this.bAS.bAB;
                                                        byVar9.Ye().setTag(sparseArray4);
                                                        SparseArray sparseArray5 = new SparseArray();
                                                        sparseArray5.put(com.baidu.tieba.w.tag_clip_board, (com.baidu.tieba.tbadkCore.b.k) ((SparseArray) view.getTag()).get(com.baidu.tieba.w.tag_clip_board));
                                                        sparseArray5.put(com.baidu.tieba.w.tag_is_subpb, false);
                                                        byVar10 = this.bAS.bAB;
                                                        byVar10.XU().setTag(sparseArray5);
                                                        SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                        if (!((Boolean) sparseArray6.get(com.baidu.tieba.w.tag_should_manage_visible)).booleanValue()) {
                                                            byVar11 = this.bAS.bAB;
                                                            byVar11.Yf().setVisibility(8);
                                                        } else {
                                                            SparseArray sparseArray7 = new SparseArray();
                                                            sparseArray7.put(com.baidu.tieba.w.tag_manage_user_identity, sparseArray6.get(com.baidu.tieba.w.tag_manage_user_identity));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_is_self, sparseArray6.get(com.baidu.tieba.w.tag_del_post_is_self));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_id, sparseArray6.get(com.baidu.tieba.w.tag_del_post_id));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_type, sparseArray6.get(com.baidu.tieba.w.tag_del_post_type));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_forbid_user_post_id, sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_post_id));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_forbid_user_name, sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_name));
                                                            byVar12 = this.bAS.bAB;
                                                            byVar12.Yf().setTag(sparseArray7);
                                                            if ("".equals(sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_name)) || "".equals(sparseArray6.get(com.baidu.tieba.w.tag_del_post_id))) {
                                                                byVar13 = this.bAS.bAB;
                                                                com.baidu.tbadk.core.util.bc.c(byVar13.Yf(), com.baidu.tieba.v.icon_pb_del_n);
                                                            } else {
                                                                byVar15 = this.bAS.bAB;
                                                                com.baidu.tbadk.core.util.bc.c(byVar15.Yf(), com.baidu.tieba.v.icon_pb_set_n);
                                                            }
                                                            byVar14 = this.bAS.bAB;
                                                            byVar14.Yf().setVisibility(0);
                                                        }
                                                    }
                                                    boolean z3 = false;
                                                    bqVar12 = this.bAS.bAr;
                                                    if (bqVar12.getPbData().lb()) {
                                                        bqVar13 = this.bAS.bAr;
                                                        String ld = bqVar13.getPbData().ld();
                                                        if (kVar != null && !com.baidu.adp.lib.util.k.isEmpty(ld) && ld.equals(kVar.getId())) {
                                                            z3 = true;
                                                        }
                                                    }
                                                    if (z3) {
                                                        byVar7 = this.bAS.bAB;
                                                        byVar7.XU().setText(com.baidu.tieba.z.marked);
                                                        byVar8 = this.bAS.bAB;
                                                        byVar8.XU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    } else {
                                                        byVar4 = this.bAS.bAB;
                                                        byVar4.XU().setText(com.baidu.tieba.z.mark);
                                                        byVar5 = this.bAS.bAB;
                                                        byVar5.XU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    }
                                                    byVar6 = this.bAS.bAB;
                                                    byVar6.dU(true);
                                                    morePopupWindow3 = this.bAS.bAA;
                                                    morePopupWindow3.reLayoutWidth();
                                                    morePopupWindow4 = this.bAS.bAA;
                                                    morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.sub_post_load_more) {
                                                    eVar3 = this.bAS.bAu;
                                                    if (eVar3.xF()) {
                                                        bzVar35 = this.bAS.bAw;
                                                        bzVar35.YH();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.sub_pb_bottom_layout) {
                                                    bqVar11 = this.bAS.bAr;
                                                    if (bqVar11.XJ()) {
                                                        this.bAS.closeActivity();
                                                        return;
                                                    }
                                                    this.bAS.stopVoice();
                                                    bzVar34 = this.bAS.bAw;
                                                    bzVar34.YK();
                                                    eVar2 = this.bAS.bAu;
                                                    eVar2.cancelLoadData();
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.btn_loadprevious) {
                                                    eVar = this.bAS.bAu;
                                                    if (eVar.ZN()) {
                                                        bzVar33 = this.bAS.bAw;
                                                        bzVar33.YI();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.pb_new_guide) {
                                                    SharedPreferences.Editor edit = this.bAS.getPageContext().getPageActivity().getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                    edit.putBoolean("has_shown_pb_guide", true);
                                                    edit.commit();
                                                    bzVar32 = this.bAS.bAw;
                                                    bzVar32.He();
                                                    return;
                                                } else if (id3 != com.baidu.tieba.w.pb_head_reverse_hint) {
                                                    if (id3 == com.baidu.tieba.w.pb_act_btn) {
                                                        bqVar4 = this.bAS.bAr;
                                                        if (bqVar4.getPbData() != null) {
                                                            bqVar5 = this.bAS.bAr;
                                                            if (bqVar5.getPbData().ahe() != null) {
                                                                bqVar6 = this.bAS.bAr;
                                                                if (bqVar6.getPbData().ahe().nD() != null) {
                                                                    Activity activity = this.bAS.getActivity();
                                                                    bqVar7 = this.bAS.bAr;
                                                                    com.baidu.tbadk.browser.a.x(activity, bqVar7.getPbData().ahe().nD());
                                                                    bqVar8 = this.bAS.bAr;
                                                                    if (bqVar8.getPbData().ahe().nB() != 1) {
                                                                        bqVar9 = this.bAS.bAr;
                                                                        if (bqVar9.getPbData().ahe().nB() == 2) {
                                                                            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                    this.bAS.stopVoice();
                                                    bzVar30 = this.bAS.bAw;
                                                    bzVar30.Ze();
                                                    bzVar31 = this.bAS.bAw;
                                                    bzVar31.YA();
                                                    bqVar10 = this.bAS.bAr;
                                                    bqVar10.XP();
                                                    return;
                                                }
                                            }
                                            byVar17 = this.bAS.bAB;
                                            if (byVar17 != null) {
                                                byVar20 = this.bAS.bAB;
                                                if (view == byVar20.Ye()) {
                                                    byVar21 = this.bAS.bAB;
                                                    if (!byVar21.Yd()) {
                                                        morePopupWindow7 = this.bAS.bAA;
                                                        com.baidu.adp.lib.g.k.a(morePopupWindow7, this.bAS.getPageContext().getPageActivity());
                                                        bzVar44 = this.bAS.bAw;
                                                        bzVar44.dX(true);
                                                        return;
                                                    }
                                                }
                                            }
                                            try {
                                                bqVar16 = this.bAS.bAr;
                                                if (bqVar16.getPbData() != null) {
                                                    bzVar41 = this.bAS.bAw;
                                                    bzVar41.Ze();
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.b.k kVar2 = (com.baidu.tieba.tbadkCore.b.k) sparseArray8.get(com.baidu.tieba.w.tag_load_sub_data);
                                                    View view2 = (View) sparseArray8.get(com.baidu.tieba.w.tag_load_sub_view);
                                                    if (kVar2 != null && view2 != null) {
                                                        bqVar17 = this.bAS.bAr;
                                                        com.baidu.tieba.tbadkCore.b.o b = bqVar17.b(kVar2);
                                                        eVar4 = this.bAS.bAu;
                                                        bqVar18 = this.bAS.bAr;
                                                        eVar4.hD(bqVar18.XF());
                                                        eVar5 = this.bAS.bAu;
                                                        eVar5.bB(kVar2.getId());
                                                        eVar6 = this.bAS.bAu;
                                                        eVar6.resetData();
                                                        this.bAS.stopVoice();
                                                        byVar18 = this.bAS.bAB;
                                                        if (byVar18 != null) {
                                                            byVar19 = this.bAS.bAB;
                                                            if (view == byVar19.Ye()) {
                                                                morePopupWindow6 = this.bAS.bAA;
                                                                com.baidu.adp.lib.g.k.a(morePopupWindow6, this.bAS.getPageContext().getPageActivity());
                                                                bzVar43 = this.bAS.bAw;
                                                                bqVar20 = this.bAS.bAr;
                                                                bzVar43.a(true, b, false, null, null, view2, bqVar20.getPbData().ahg());
                                                                return;
                                                            }
                                                        }
                                                        if (view.getId() != com.baidu.tieba.w.sub_pb_item) {
                                                            handler = this.bAS.mHandler;
                                                            handler.post(new be(this, b, view2));
                                                            return;
                                                        }
                                                        SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                        String str2 = (String) sparseArray9.get(com.baidu.tieba.w.tag_photo_username);
                                                        com.baidu.tieba.tbadkCore.b.k kVar3 = (com.baidu.tieba.tbadkCore.b.k) sparseArray9.get(com.baidu.tieba.w.tag_clip_board);
                                                        String str3 = null;
                                                        if (kVar3 != null) {
                                                            str3 = kVar3.getId();
                                                        }
                                                        bzVar42 = this.bAS.bAw;
                                                        bqVar19 = this.bAS.bAr;
                                                        bzVar42.a(true, b, false, str2, str3, view2, bqVar19.getPbData().ahg());
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
                                            bzVar46 = this.bAS.bAw;
                                            bzVar46.P(view);
                                            return;
                                        }
                                        bzVar45 = this.bAS.bAw;
                                        bzVar45.a(((Integer) sparseArray10.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
                                        return;
                                    }
                                    this.bAS.Xa();
                                    return;
                                }
                                TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bqVar35 = this.bAS.bAr;
                                String name3 = bqVar35.getPbData().aeI().getName();
                                bqVar36 = this.bAS.bAr;
                                if (!TextUtils.isEmpty(bqVar36.XE())) {
                                    bqVar37 = this.bAS.bAr;
                                    if (bqVar37.XE().equals(name3)) {
                                        this.bAS.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.bf.aC(name3)) {
                                    this.bAS.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bAS.getPageContext().getPageActivity()).createNormalCfg(name3, FrsActivityConfig.FRS_FROM_PB)));
                                    return;
                                }
                                return;
                            }
                            morePopupWindow10 = this.bAS.bAA;
                            if (morePopupWindow10 != null) {
                                byVar32 = this.bAS.bAB;
                            }
                            this.bAS.Xe();
                            com.baidu.tieba.tbadkCore.b.k kVar4 = null;
                            if (view != null && view.getTag() != null) {
                                kVar4 = (com.baidu.tieba.tbadkCore.b.k) ((SparseArray) view.getTag()).get(com.baidu.tieba.w.tag_clip_board);
                                SparseArray sparseArray11 = new SparseArray();
                                sparseArray11.put(com.baidu.tieba.w.tag_clip_board, kVar4);
                                sparseArray11.put(com.baidu.tieba.w.tag_is_subpb, false);
                                byVar31 = this.bAS.bAB;
                                byVar31.XU().setTag(sparseArray11);
                            }
                            bqVar38 = this.bAS.bAr;
                            if (bqVar38.getPbData() != null) {
                                bqVar39 = this.bAS.bAr;
                                if (bqVar39.getPbData().lb()) {
                                    bqVar40 = this.bAS.bAr;
                                    String ld2 = bqVar40.getPbData().ld();
                                    if (kVar4 != null && !com.baidu.adp.lib.util.k.isEmpty(ld2) && ld2.equals(kVar4.getId())) {
                                        z2 = true;
                                        if (!z2) {
                                            byVar29 = this.bAS.bAB;
                                            byVar29.XU().setText(com.baidu.tieba.z.marked);
                                            byVar30 = this.bAS.bAB;
                                            byVar30.XU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                        } else {
                                            byVar25 = this.bAS.bAB;
                                            byVar25.XU().setText(com.baidu.tieba.z.mark);
                                            byVar26 = this.bAS.bAB;
                                            byVar26.XU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                        }
                                        byVar27 = this.bAS.bAB;
                                        byVar27.Yf().setVisibility(8);
                                        byVar28 = this.bAS.bAB;
                                        byVar28.dU(false);
                                        morePopupWindow11 = this.bAS.bAA;
                                        morePopupWindow11.reLayoutWidth();
                                        morePopupWindow12 = this.bAS.bAA;
                                        morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                                        return;
                                    }
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                            byVar27 = this.bAS.bAB;
                            byVar27.Yf().setVisibility(8);
                            byVar28 = this.bAS.bAB;
                            byVar28.dU(false);
                            morePopupWindow11 = this.bAS.bAA;
                            morePopupWindow11.reLayoutWidth();
                            morePopupWindow12 = this.bAS.bAA;
                            morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                            return;
                        }
                    }
                }
            }
        }
        bzVar4 = this.bAS.bAw;
        bzVar4.Zf();
        bqVar = this.bAS.bAr;
        if (bqVar.getPbData().ahg() == 1) {
            aVar = this.bAS.bAv;
            if (!aVar.aii()) {
                bzVar5 = this.bAS.bAw;
                bzVar5.Yv();
                int i2 = 0;
                bzVar6 = this.bAS.bAw;
                if (view != bzVar6.YY()) {
                    bzVar7 = this.bAS.bAw;
                    if (view != bzVar7.YZ()) {
                        bzVar8 = this.bAS.bAw;
                        if (view != bzVar8.Za()) {
                            bzVar9 = this.bAS.bAw;
                            if (view != bzVar9.Zb()) {
                                bzVar10 = this.bAS.bAw;
                                if (view == bzVar10.Yx()) {
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
                bqVar2 = this.bAS.bAr;
                ForumData aeI2 = bqVar2.getPbData().aeI();
                String name4 = aeI2.getName();
                String id4 = aeI2.getId();
                bqVar3 = this.bAS.bAr;
                String id5 = bqVar3.getPbData().ahe().getId();
                aVar2 = this.bAS.bAv;
                bzVar11 = this.bAS.bAw;
                aVar2.b(id4, name4, id5, i2, bzVar11.Yy());
            }
        }
    }
}
