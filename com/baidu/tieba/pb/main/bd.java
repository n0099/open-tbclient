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
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:214:0x0ab7, code lost:
        if (r21 != r1.Yj()) goto L276;
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
        bzVar = this.bAT.bAx;
        if (view == bzVar.getNextView()) {
            bqVar48 = this.bAT.bAs;
            if (bqVar48.dQ(true)) {
                bzVar67 = this.bAT.bAx;
                bzVar67.YG();
                return;
            }
            return;
        }
        bzVar2 = this.bAT.bAx;
        if (view == bzVar2.bCY.aWR) {
            bzVar66 = this.bAT.bAx;
            bqVar47 = this.bAT.bAs;
            if (!bzVar66.ea(bqVar47.XO())) {
                this.bAT.closeActivity();
                return;
            } else {
                this.bAT.stopVoice();
                return;
            }
        }
        bzVar3 = this.bAT.bAx;
        if (view != bzVar3.Zd()) {
            bzVar12 = this.bAT.bAx;
            if (view != bzVar12.Ze()) {
                bzVar13 = this.bAT.bAx;
                if (view != bzVar13.Zf()) {
                    bzVar14 = this.bAT.bAx;
                    if (view != bzVar14.Zg()) {
                        bzVar15 = this.bAT.bAx;
                        if (view != bzVar15.YC()) {
                            bzVar16 = this.bAT.bAx;
                            if (view == bzVar16.Zo()) {
                                bqVar45 = this.bAT.bAs;
                                if (bqVar45 != null) {
                                    bqVar46 = this.bAT.bAs;
                                    com.baidu.tbadk.browser.a.x(this.bAT.getPageContext().getPageActivity(), bqVar46.getPbData().ahj().nt().getLink());
                                    return;
                                }
                                return;
                            }
                            bzVar17 = this.bAT.bAx;
                            if (view == bzVar17.YB()) {
                                bzVar64 = this.bAT.bAx;
                                bzVar64.Zk();
                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    aVar3 = this.bAT.bAw;
                                    if (!aVar3.ain()) {
                                        bzVar65 = this.bAT.bAx;
                                        bzVar65.YA();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.w.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.w.tag_del_post_type)).intValue();
                                            bqVar41 = this.bAT.bAs;
                                            if (bqVar41.XO()) {
                                                eVar11 = this.bAT.bAv;
                                                if (eVar11 != null) {
                                                    eVar12 = this.bAT.bAv;
                                                    if (eVar12.ZM() != null) {
                                                        eVar13 = this.bAT.bAv;
                                                        if (eVar13.ZM().ahL() != null) {
                                                            eVar14 = this.bAT.bAv;
                                                            if (eVar14.ZM().ahM() != null) {
                                                                aVar5 = this.bAT.bAw;
                                                                eVar15 = this.bAT.bAv;
                                                                String id = eVar15.ZM().ahL().getId();
                                                                eVar16 = this.bAT.bAv;
                                                                String name = eVar16.ZM().ahL().getName();
                                                                eVar17 = this.bAT.bAv;
                                                                aVar5.a(id, name, eVar17.ZM().ahM().getId(), str, intValue2, intValue, booleanValue);
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
                                            aVar4 = this.bAT.bAw;
                                            bqVar42 = this.bAT.bAs;
                                            String id2 = bqVar42.getPbData().aeN().getId();
                                            bqVar43 = this.bAT.bAs;
                                            String name2 = bqVar43.getPbData().aeN().getName();
                                            bqVar44 = this.bAT.bAs;
                                            aVar4.a(id2, name2, bqVar44.getPbData().ahj().getId(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                this.bAT.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.bAT.getPageContext().getPageActivity(), this.bAT.getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11017)));
                                return;
                            }
                            bzVar18 = this.bAT.bAx;
                            if (view != bzVar18.Zh()) {
                                bzVar19 = this.bAT.bAx;
                                if (view == bzVar19.YE()) {
                                    eVar10 = this.bAT.bAv;
                                    if (eVar10.xL()) {
                                        bzVar63 = this.bAT.bAx;
                                        bzVar63.YM();
                                        return;
                                    }
                                    return;
                                }
                                bzVar20 = this.bAT.bAx;
                                if (view == bzVar20.Yx()) {
                                    eVar7 = this.bAT.bAv;
                                    if (eVar7 != null) {
                                        eVar8 = this.bAT.bAv;
                                        if (eVar8.XK() != null) {
                                            PbActivity pbActivity = this.bAT;
                                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bAT.getPageContext().getPageActivity());
                                            eVar9 = this.bAT.bAv;
                                            pbActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(eVar9.XK(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bzVar21 = this.bAT.bAx;
                                if (view != bzVar21.bCY.bEU) {
                                    bzVar22 = this.bAT.bAx;
                                    if (view == bzVar22.bCY.bEW) {
                                        bqVar32 = this.bAT.bAs;
                                        if (bqVar32 != null) {
                                            bqVar33 = this.bAT.bAs;
                                            if (bqVar33.getPbData() != null) {
                                                bqVar34 = this.bAT.bAs;
                                                ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = bqVar34.getPbData().ahk();
                                                if (ahk == null || ahk.size() <= 0) {
                                                    com.baidu.adp.lib.util.l.showToast(this.bAT.getPageContext().getPageActivity(), this.bAT.getPageContext().getString(com.baidu.tieba.z.pb_no_data_tips));
                                                    return;
                                                } else {
                                                    this.bAT.Xl();
                                                    return;
                                                }
                                            }
                                        }
                                        com.baidu.adp.lib.util.l.showToast(this.bAT.getPageContext().getPageActivity(), this.bAT.getPageContext().getString(com.baidu.tieba.z.pb_no_data_tips));
                                        return;
                                    }
                                    bzVar23 = this.bAT.bAx;
                                    if (view == bzVar23.bCY.bEV) {
                                        z = this.bAT.aae;
                                        if (!z) {
                                            this.bAT.aae = true;
                                            bzVar60 = this.bAT.bAx;
                                            bzVar60.bCY.bEV.setEnabled(false);
                                            bzVar61 = this.bAT.bAx;
                                            bzVar61.Qo();
                                            this.bAT.stopVoice();
                                            bzVar62 = this.bAT.bAx;
                                            bzVar62.YF();
                                            bqVar31 = this.bAT.bAs;
                                            bqVar31.XT();
                                            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                        return;
                                    }
                                    bzVar24 = this.bAT.bAx;
                                    if (view == bzVar24.bCY.bEX) {
                                        bqVar25 = this.bAT.bAs;
                                        AdditionData ahm = bqVar25.getPbData().ahm();
                                        if (!TextUtils.isEmpty(ahm.getWarnMsg())) {
                                            com.baidu.adp.lib.util.l.showToast(this.bAT.getPageContext().getPageActivity(), ahm.getWarnMsg());
                                            return;
                                        } else if (ahm.getAlreadyCount() != ahm.getTotalCount()) {
                                            bqVar26 = this.bAT.bAs;
                                            ForumData aeN = bqVar26.getPbData().aeN();
                                            bqVar27 = this.bAT.bAs;
                                            com.baidu.tbadk.core.data.x ahj = bqVar27.getPbData().ahj();
                                            bqVar28 = this.bAT.bAs;
                                            AntiData mR = bqVar28.getPbData().mR();
                                            if (ahj.getId() != null) {
                                                if (mR != null && mR.getIfpost() == 0) {
                                                    com.baidu.adp.lib.util.l.showToast(this.bAT.getPageContext().getPageActivity(), mR.getForbid_info());
                                                    return;
                                                }
                                                int i = 0;
                                                bqVar29 = this.bAT.bAs;
                                                if (bqVar29.getPbData().getUserData() != null) {
                                                    bqVar30 = this.bAT.bAs;
                                                    i = bqVar30.getPbData().getUserData().getIsMem();
                                                }
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bAT.getPageContext().getPageActivity(), 2, aeN.getId(), aeN.getName(), ahj.getId(), ahm.getPostId(), 0, mR, 13008, false, false, null, false, false, null, ahm, null, i)));
                                                return;
                                            }
                                            return;
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(this.bAT.getPageContext().getPageActivity(), String.format(this.bAT.getPageContext().getString(com.baidu.tieba.z.write_addition_limit), Integer.valueOf(ahm.getTotalCount())));
                                            return;
                                        }
                                    }
                                    bzVar25 = this.bAT.bAx;
                                    if (bzVar25.bCY.Zw() != null) {
                                        bzVar57 = this.bAT.bAx;
                                        if (view == bzVar57.bCY.Zw().XZ()) {
                                            bzVar58 = this.bAT.bAx;
                                            bzVar58.Zj();
                                            gY = this.bAT.gY(11009);
                                            if (gY) {
                                                bqVar24 = this.bAT.bAs;
                                                bzVar59 = this.bAT.bAx;
                                                if (bqVar24.hf(bzVar59.YW()) == null) {
                                                    return;
                                                }
                                                this.bAT.Xq();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    bzVar26 = this.bAT.bAx;
                                    if (bzVar26.bCY.Zw() != null) {
                                        bzVar55 = this.bAT.bAx;
                                        if (view == bzVar55.bCY.Zw().Ya()) {
                                            bzVar56 = this.bAT.bAx;
                                            bzVar56.Zj();
                                            this.bAT.stopVoice();
                                            this.bAT.showShareDialog();
                                            return;
                                        }
                                    }
                                    bzVar27 = this.bAT.bAx;
                                    if (bzVar27.bCY.Zw() != null) {
                                        bzVar52 = this.bAT.bAx;
                                        if (view == bzVar52.bCY.Zw().Yc()) {
                                            bzVar53 = this.bAT.bAx;
                                            bzVar53.Zj();
                                            bqVar22 = this.bAT.bAs;
                                            if (bqVar22.XQ() != null) {
                                                bzVar54 = this.bAT.bAx;
                                                bqVar23 = this.bAT.bAs;
                                                bzVar54.b(bqVar23.XQ());
                                            }
                                            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    bzVar28 = this.bAT.bAx;
                                    if (bzVar28.bCY.Zw() != null) {
                                        bzVar49 = this.bAT.bAx;
                                        if (view == bzVar49.bCY.Zw().Yd()) {
                                            bzVar50 = this.bAT.bAx;
                                            bzVar50.Zj();
                                            this.bAT.stopVoice();
                                            bzVar51 = this.bAT.bAx;
                                            bzVar51.YF();
                                            bqVar21 = this.bAT.bAs;
                                            bqVar21.XU();
                                            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_set_desc", "pbclick", 1, new Object[0]);
                                            return;
                                        }
                                    }
                                    byVar = this.bAT.bAC;
                                    if (byVar != null) {
                                        byVar24 = this.bAT.bAC;
                                        if (view == byVar24.XZ()) {
                                            this.bAT.K(view);
                                            morePopupWindow9 = this.bAT.bAB;
                                            com.baidu.adp.lib.g.k.a(morePopupWindow9, this.bAT.getPageContext().getPageActivity());
                                            return;
                                        }
                                    }
                                    bzVar29 = this.bAT.bAx;
                                    if (bzVar29.Yr() != view) {
                                        byVar2 = this.bAT.bAC;
                                        if (byVar2 != null) {
                                            byVar23 = this.bAT.bAC;
                                            if (view == byVar23.Yk()) {
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                if (sparseArray2 != null) {
                                                    if ("".equals(sparseArray2.get(com.baidu.tieba.w.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.w.tag_del_post_id))) {
                                                        bzVar47 = this.bAT.bAx;
                                                        bzVar47.a(((Integer) sparseArray2.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
                                                    } else {
                                                        bzVar48 = this.bAT.bAx;
                                                        bzVar48.P(view);
                                                    }
                                                    morePopupWindow8 = this.bAT.bAB;
                                                    com.baidu.adp.lib.g.k.a(morePopupWindow8, this.bAT.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        if (view.getId() != com.baidu.tieba.w.pb_head_function_manage_delormanage) {
                                            byVar3 = this.bAT.bAC;
                                            if (byVar3 != null) {
                                                byVar22 = this.bAT.bAC;
                                            }
                                            if (view.getId() != com.baidu.tieba.w.sub_pb_more && view.getId() != com.baidu.tieba.w.sub_pb_item) {
                                                int id3 = view.getId();
                                                if (id3 == com.baidu.tieba.w.dialog_button_ok) {
                                                    bqVar14 = this.bAT.bAs;
                                                    com.baidu.tbadk.core.data.q XQ = bqVar14.XQ();
                                                    bzVar37 = this.bAT.bAx;
                                                    int pageNum = bzVar37.getPageNum();
                                                    if (pageNum <= 0) {
                                                        this.bAT.showToast(com.baidu.tieba.z.pb_page_error);
                                                        return;
                                                    } else if (XQ == null || pageNum <= XQ.mU()) {
                                                        bzVar38 = this.bAT.bAx;
                                                        bzVar38.Zj();
                                                        this.bAT.stopVoice();
                                                        bzVar39 = this.bAT.bAx;
                                                        bzVar39.YF();
                                                        bqVar15 = this.bAT.bAs;
                                                        bzVar40 = this.bAT.bAx;
                                                        bqVar15.ha(bzVar40.getPageNum());
                                                        return;
                                                    } else {
                                                        this.bAT.showToast(com.baidu.tieba.z.pb_page_error);
                                                        return;
                                                    }
                                                } else if (id3 == com.baidu.tieba.w.dialog_button_cancel) {
                                                    bzVar36 = this.bAT.bAx;
                                                    bzVar36.Zj();
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.reply) {
                                                    morePopupWindow = this.bAT.bAB;
                                                    if (morePopupWindow != null) {
                                                        byVar16 = this.bAT.bAC;
                                                    }
                                                    this.bAT.Xj();
                                                    morePopupWindow2 = this.bAT.bAB;
                                                    if (morePopupWindow2.getIsIntercepted()) {
                                                        morePopupWindow5 = this.bAT.bAB;
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
                                                        byVar9 = this.bAT.bAC;
                                                        byVar9.Yj().setTag(sparseArray4);
                                                        SparseArray sparseArray5 = new SparseArray();
                                                        sparseArray5.put(com.baidu.tieba.w.tag_clip_board, (com.baidu.tieba.tbadkCore.b.k) ((SparseArray) view.getTag()).get(com.baidu.tieba.w.tag_clip_board));
                                                        sparseArray5.put(com.baidu.tieba.w.tag_is_subpb, false);
                                                        byVar10 = this.bAT.bAC;
                                                        byVar10.XZ().setTag(sparseArray5);
                                                        SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                        if (!((Boolean) sparseArray6.get(com.baidu.tieba.w.tag_should_manage_visible)).booleanValue()) {
                                                            byVar11 = this.bAT.bAC;
                                                            byVar11.Yk().setVisibility(8);
                                                        } else {
                                                            SparseArray sparseArray7 = new SparseArray();
                                                            sparseArray7.put(com.baidu.tieba.w.tag_manage_user_identity, sparseArray6.get(com.baidu.tieba.w.tag_manage_user_identity));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_is_self, sparseArray6.get(com.baidu.tieba.w.tag_del_post_is_self));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_id, sparseArray6.get(com.baidu.tieba.w.tag_del_post_id));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_del_post_type, sparseArray6.get(com.baidu.tieba.w.tag_del_post_type));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_forbid_user_post_id, sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_post_id));
                                                            sparseArray7.put(com.baidu.tieba.w.tag_forbid_user_name, sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_name));
                                                            byVar12 = this.bAT.bAC;
                                                            byVar12.Yk().setTag(sparseArray7);
                                                            if ("".equals(sparseArray6.get(com.baidu.tieba.w.tag_forbid_user_name)) || "".equals(sparseArray6.get(com.baidu.tieba.w.tag_del_post_id))) {
                                                                byVar13 = this.bAT.bAC;
                                                                com.baidu.tbadk.core.util.bc.c(byVar13.Yk(), com.baidu.tieba.v.icon_pb_del_n);
                                                            } else {
                                                                byVar15 = this.bAT.bAC;
                                                                com.baidu.tbadk.core.util.bc.c(byVar15.Yk(), com.baidu.tieba.v.icon_pb_set_n);
                                                            }
                                                            byVar14 = this.bAT.bAC;
                                                            byVar14.Yk().setVisibility(0);
                                                        }
                                                    }
                                                    boolean z3 = false;
                                                    bqVar12 = this.bAT.bAs;
                                                    if (bqVar12.getPbData().li()) {
                                                        bqVar13 = this.bAT.bAs;
                                                        String lk = bqVar13.getPbData().lk();
                                                        if (kVar != null && !com.baidu.adp.lib.util.k.isEmpty(lk) && lk.equals(kVar.getId())) {
                                                            z3 = true;
                                                        }
                                                    }
                                                    if (z3) {
                                                        byVar7 = this.bAT.bAC;
                                                        byVar7.XZ().setText(com.baidu.tieba.z.marked);
                                                        byVar8 = this.bAT.bAC;
                                                        byVar8.XZ().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    } else {
                                                        byVar4 = this.bAT.bAC;
                                                        byVar4.XZ().setText(com.baidu.tieba.z.mark);
                                                        byVar5 = this.bAT.bAC;
                                                        byVar5.XZ().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                    }
                                                    byVar6 = this.bAT.bAC;
                                                    byVar6.dU(true);
                                                    morePopupWindow3 = this.bAT.bAB;
                                                    morePopupWindow3.reLayoutWidth();
                                                    morePopupWindow4 = this.bAT.bAB;
                                                    morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.sub_post_load_more) {
                                                    eVar3 = this.bAT.bAv;
                                                    if (eVar3.xL()) {
                                                        bzVar35 = this.bAT.bAx;
                                                        bzVar35.YM();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.sub_pb_bottom_layout) {
                                                    bqVar11 = this.bAT.bAs;
                                                    if (bqVar11.XO()) {
                                                        this.bAT.closeActivity();
                                                        return;
                                                    }
                                                    this.bAT.stopVoice();
                                                    bzVar34 = this.bAT.bAx;
                                                    bzVar34.YP();
                                                    eVar2 = this.bAT.bAv;
                                                    eVar2.cancelLoadData();
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.btn_loadprevious) {
                                                    eVar = this.bAT.bAv;
                                                    if (eVar.ZS()) {
                                                        bzVar33 = this.bAT.bAx;
                                                        bzVar33.YN();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == com.baidu.tieba.w.pb_new_guide) {
                                                    SharedPreferences.Editor edit = this.bAT.getPageContext().getPageActivity().getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                    edit.putBoolean("has_shown_pb_guide", true);
                                                    edit.commit();
                                                    bzVar32 = this.bAT.bAx;
                                                    bzVar32.Hk();
                                                    return;
                                                } else if (id3 != com.baidu.tieba.w.pb_head_reverse_hint) {
                                                    if (id3 == com.baidu.tieba.w.pb_act_btn) {
                                                        bqVar4 = this.bAT.bAs;
                                                        if (bqVar4.getPbData() != null) {
                                                            bqVar5 = this.bAT.bAs;
                                                            if (bqVar5.getPbData().ahj() != null) {
                                                                bqVar6 = this.bAT.bAs;
                                                                if (bqVar6.getPbData().ahj().nK() != null) {
                                                                    Activity activity = this.bAT.getActivity();
                                                                    bqVar7 = this.bAT.bAs;
                                                                    com.baidu.tbadk.browser.a.x(activity, bqVar7.getPbData().ahj().nK());
                                                                    bqVar8 = this.bAT.bAs;
                                                                    if (bqVar8.getPbData().ahj().nI() != 1) {
                                                                        bqVar9 = this.bAT.bAs;
                                                                        if (bqVar9.getPbData().ahj().nI() == 2) {
                                                                            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
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
                                                    this.bAT.stopVoice();
                                                    bzVar30 = this.bAT.bAx;
                                                    bzVar30.Zj();
                                                    bzVar31 = this.bAT.bAx;
                                                    bzVar31.YF();
                                                    bqVar10 = this.bAT.bAs;
                                                    bqVar10.XU();
                                                    return;
                                                }
                                            }
                                            byVar17 = this.bAT.bAC;
                                            if (byVar17 != null) {
                                                byVar20 = this.bAT.bAC;
                                                if (view == byVar20.Yj()) {
                                                    byVar21 = this.bAT.bAC;
                                                    if (!byVar21.Yi()) {
                                                        morePopupWindow7 = this.bAT.bAB;
                                                        com.baidu.adp.lib.g.k.a(morePopupWindow7, this.bAT.getPageContext().getPageActivity());
                                                        bzVar44 = this.bAT.bAx;
                                                        bzVar44.dX(true);
                                                        return;
                                                    }
                                                }
                                            }
                                            try {
                                                bqVar16 = this.bAT.bAs;
                                                if (bqVar16.getPbData() != null) {
                                                    bzVar41 = this.bAT.bAx;
                                                    bzVar41.Zj();
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.tbadkCore.b.k kVar2 = (com.baidu.tieba.tbadkCore.b.k) sparseArray8.get(com.baidu.tieba.w.tag_load_sub_data);
                                                    View view2 = (View) sparseArray8.get(com.baidu.tieba.w.tag_load_sub_view);
                                                    if (kVar2 != null && view2 != null) {
                                                        bqVar17 = this.bAT.bAs;
                                                        com.baidu.tieba.tbadkCore.b.o b = bqVar17.b(kVar2);
                                                        eVar4 = this.bAT.bAv;
                                                        bqVar18 = this.bAT.bAs;
                                                        eVar4.hG(bqVar18.XK());
                                                        eVar5 = this.bAT.bAv;
                                                        eVar5.bE(kVar2.getId());
                                                        eVar6 = this.bAT.bAv;
                                                        eVar6.resetData();
                                                        this.bAT.stopVoice();
                                                        byVar18 = this.bAT.bAC;
                                                        if (byVar18 != null) {
                                                            byVar19 = this.bAT.bAC;
                                                            if (view == byVar19.Yj()) {
                                                                morePopupWindow6 = this.bAT.bAB;
                                                                com.baidu.adp.lib.g.k.a(morePopupWindow6, this.bAT.getPageContext().getPageActivity());
                                                                bzVar43 = this.bAT.bAx;
                                                                bqVar20 = this.bAT.bAs;
                                                                bzVar43.a(true, b, false, null, null, view2, bqVar20.getPbData().ahl());
                                                                return;
                                                            }
                                                        }
                                                        if (view.getId() != com.baidu.tieba.w.sub_pb_item) {
                                                            handler = this.bAT.mHandler;
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
                                                        bzVar42 = this.bAT.bAx;
                                                        bqVar19 = this.bAT.bAs;
                                                        bzVar42.a(true, b, false, str2, str3, view2, bqVar19.getPbData().ahl());
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
                                            bzVar46 = this.bAT.bAx;
                                            bzVar46.P(view);
                                            return;
                                        }
                                        bzVar45 = this.bAT.bAx;
                                        bzVar45.a(((Integer) sparseArray10.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
                                        return;
                                    }
                                    this.bAT.Xf();
                                    return;
                                }
                                TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bqVar35 = this.bAT.bAs;
                                String name3 = bqVar35.getPbData().aeN().getName();
                                bqVar36 = this.bAT.bAs;
                                if (!TextUtils.isEmpty(bqVar36.XJ())) {
                                    bqVar37 = this.bAT.bAs;
                                    if (bqVar37.XJ().equals(name3)) {
                                        this.bAT.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.bf.aC(name3)) {
                                    this.bAT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bAT.getPageContext().getPageActivity()).createNormalCfg(name3, FrsActivityConfig.FRS_FROM_PB)));
                                    return;
                                }
                                return;
                            }
                            morePopupWindow10 = this.bAT.bAB;
                            if (morePopupWindow10 != null) {
                                byVar32 = this.bAT.bAC;
                            }
                            this.bAT.Xj();
                            com.baidu.tieba.tbadkCore.b.k kVar4 = null;
                            if (view != null && view.getTag() != null) {
                                kVar4 = (com.baidu.tieba.tbadkCore.b.k) ((SparseArray) view.getTag()).get(com.baidu.tieba.w.tag_clip_board);
                                SparseArray sparseArray11 = new SparseArray();
                                sparseArray11.put(com.baidu.tieba.w.tag_clip_board, kVar4);
                                sparseArray11.put(com.baidu.tieba.w.tag_is_subpb, false);
                                byVar31 = this.bAT.bAC;
                                byVar31.XZ().setTag(sparseArray11);
                            }
                            bqVar38 = this.bAT.bAs;
                            if (bqVar38.getPbData() != null) {
                                bqVar39 = this.bAT.bAs;
                                if (bqVar39.getPbData().li()) {
                                    bqVar40 = this.bAT.bAs;
                                    String lk2 = bqVar40.getPbData().lk();
                                    if (kVar4 != null && !com.baidu.adp.lib.util.k.isEmpty(lk2) && lk2.equals(kVar4.getId())) {
                                        z2 = true;
                                        if (!z2) {
                                            byVar29 = this.bAT.bAC;
                                            byVar29.XZ().setText(com.baidu.tieba.z.marked);
                                            byVar30 = this.bAT.bAC;
                                            byVar30.XZ().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                        } else {
                                            byVar25 = this.bAT.bAC;
                                            byVar25.XZ().setText(com.baidu.tieba.z.mark);
                                            byVar26 = this.bAT.bAC;
                                            byVar26.XZ().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                        }
                                        byVar27 = this.bAT.bAC;
                                        byVar27.Yk().setVisibility(8);
                                        byVar28 = this.bAT.bAC;
                                        byVar28.dU(false);
                                        morePopupWindow11 = this.bAT.bAB;
                                        morePopupWindow11.reLayoutWidth();
                                        morePopupWindow12 = this.bAT.bAB;
                                        morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                                        return;
                                    }
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                            byVar27 = this.bAT.bAC;
                            byVar27.Yk().setVisibility(8);
                            byVar28 = this.bAT.bAC;
                            byVar28.dU(false);
                            morePopupWindow11 = this.bAT.bAB;
                            morePopupWindow11.reLayoutWidth();
                            morePopupWindow12 = this.bAT.bAB;
                            morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                            return;
                        }
                    }
                }
            }
        }
        bzVar4 = this.bAT.bAx;
        bzVar4.Zk();
        bqVar = this.bAT.bAs;
        if (bqVar.getPbData().ahl() == 1) {
            aVar = this.bAT.bAw;
            if (!aVar.ain()) {
                bzVar5 = this.bAT.bAx;
                bzVar5.YA();
                int i2 = 0;
                bzVar6 = this.bAT.bAx;
                if (view != bzVar6.Zd()) {
                    bzVar7 = this.bAT.bAx;
                    if (view != bzVar7.Ze()) {
                        bzVar8 = this.bAT.bAx;
                        if (view != bzVar8.Zf()) {
                            bzVar9 = this.bAT.bAx;
                            if (view != bzVar9.Zg()) {
                                bzVar10 = this.bAT.bAx;
                                if (view == bzVar10.YC()) {
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
                bqVar2 = this.bAT.bAs;
                ForumData aeN2 = bqVar2.getPbData().aeN();
                String name4 = aeN2.getName();
                String id4 = aeN2.getId();
                bqVar3 = this.bAT.bAs;
                String id5 = bqVar3.getPbData().ahj().getId();
                aVar2 = this.bAT.bAw;
                bzVar11 = this.bAT.bAx;
                aVar2.b(id4, name4, id5, i2, bzVar11.YD());
            }
        }
    }
}
