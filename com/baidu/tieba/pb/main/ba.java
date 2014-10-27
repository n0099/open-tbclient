package com.baidu.tieba.pb.main;

import android.app.Activity;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:212:0x09e9, code lost:
        if (r21 != r1.Xe()) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0c00, code lost:
        if (r1 == null) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x034f, code lost:
        if (r1 == null) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0439  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bv bvVar4;
        bn bnVar;
        com.baidu.tieba.model.v vVar;
        bv bvVar5;
        bv bvVar6;
        bv bvVar7;
        bv bvVar8;
        bv bvVar9;
        bv bvVar10;
        bn bnVar2;
        bn bnVar3;
        com.baidu.tieba.model.v vVar2;
        bv bvVar11;
        bv bvVar12;
        bv bvVar13;
        bv bvVar14;
        bv bvVar15;
        bv bvVar16;
        bv bvVar17;
        bv bvVar18;
        bv bvVar19;
        bv bvVar20;
        bv bvVar21;
        bv bvVar22;
        bv bvVar23;
        bv bvVar24;
        bv bvVar25;
        bv bvVar26;
        bv bvVar27;
        bv bvVar28;
        bu buVar;
        bv bvVar29;
        bu buVar2;
        bu buVar3;
        bv bvVar30;
        bv bvVar31;
        bn bnVar4;
        bv bvVar32;
        com.baidu.tieba.pb.sub.e eVar;
        bv bvVar33;
        bn bnVar5;
        bv bvVar34;
        com.baidu.tieba.pb.sub.e eVar2;
        com.baidu.tieba.pb.sub.e eVar3;
        bv bvVar35;
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        bn bnVar6;
        bu buVar4;
        bu buVar5;
        bu buVar6;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        bu buVar7;
        bu buVar8;
        bn bnVar7;
        bu buVar9;
        bu buVar10;
        bu buVar11;
        bu buVar12;
        bu buVar13;
        bu buVar14;
        bu buVar15;
        MorePopupWindow morePopupWindow5;
        bu buVar16;
        bv bvVar36;
        bn bnVar8;
        bv bvVar37;
        bv bvVar38;
        bv bvVar39;
        bn bnVar9;
        bv bvVar40;
        bu buVar17;
        bn bnVar10;
        bv bvVar41;
        bn bnVar11;
        com.baidu.tieba.pb.sub.e eVar4;
        bn bnVar12;
        com.baidu.tieba.pb.sub.e eVar5;
        com.baidu.tieba.pb.sub.e eVar6;
        bu buVar18;
        Handler handler;
        bv bvVar42;
        bn bnVar13;
        bu buVar19;
        MorePopupWindow morePopupWindow6;
        bv bvVar43;
        bn bnVar14;
        bu buVar20;
        bu buVar21;
        MorePopupWindow morePopupWindow7;
        bv bvVar44;
        bu buVar22;
        bv bvVar45;
        bv bvVar46;
        bu buVar23;
        bv bvVar47;
        MorePopupWindow morePopupWindow8;
        bv bvVar48;
        bu buVar24;
        MorePopupWindow morePopupWindow9;
        bv bvVar49;
        bv bvVar50;
        bv bvVar51;
        bn bnVar15;
        bv bvVar52;
        bv bvVar53;
        bn bnVar16;
        bv bvVar54;
        bn bnVar17;
        bv bvVar55;
        bv bvVar56;
        bv bvVar57;
        bv bvVar58;
        boolean gJ;
        bn bnVar18;
        bv bvVar59;
        bn bnVar19;
        bn bnVar20;
        bn bnVar21;
        bn bnVar22;
        bn bnVar23;
        bn bnVar24;
        bv bvVar60;
        bn bnVar25;
        bn bnVar26;
        bn bnVar27;
        bn bnVar28;
        bn bnVar29;
        bn bnVar30;
        bn bnVar31;
        com.baidu.tieba.pb.sub.e eVar7;
        com.baidu.tieba.pb.sub.e eVar8;
        com.baidu.tieba.pb.sub.e eVar9;
        com.baidu.tieba.pb.sub.e eVar10;
        bv bvVar61;
        MorePopupWindow morePopupWindow10;
        bn bnVar32;
        boolean z;
        bu buVar25;
        bu buVar26;
        bu buVar27;
        bu buVar28;
        MorePopupWindow morePopupWindow11;
        MorePopupWindow morePopupWindow12;
        bu buVar29;
        bu buVar30;
        bn bnVar33;
        bn bnVar34;
        bu buVar31;
        bu buVar32;
        bv bvVar62;
        com.baidu.tieba.model.v vVar3;
        bv bvVar63;
        bn bnVar35;
        com.baidu.tieba.model.v vVar4;
        bn bnVar36;
        bn bnVar37;
        bn bnVar38;
        com.baidu.tieba.pb.sub.e eVar11;
        com.baidu.tieba.pb.sub.e eVar12;
        com.baidu.tieba.pb.sub.e eVar13;
        com.baidu.tieba.pb.sub.e eVar14;
        com.baidu.tieba.model.v vVar5;
        com.baidu.tieba.pb.sub.e eVar15;
        com.baidu.tieba.pb.sub.e eVar16;
        com.baidu.tieba.pb.sub.e eVar17;
        bn bnVar39;
        bn bnVar40;
        bv bvVar64;
        bn bnVar41;
        bn bnVar42;
        bv bvVar65;
        bvVar = this.bvg.buL;
        if (view == bvVar.getNextView()) {
            bnVar42 = this.bvg.buG;
            if (bnVar42.dZ(true)) {
                bvVar65 = this.bvg.buL;
                bvVar65.XB();
                return;
            }
            return;
        }
        bvVar2 = this.bvg.buL;
        if (view == bvVar2.bxj.aTJ) {
            bvVar64 = this.bvg.buL;
            bnVar41 = this.bvg.buG;
            if (!bvVar64.ej(bnVar41.WJ())) {
                this.bvg.closeActivity();
                return;
            } else {
                this.bvg.EA();
                return;
            }
        }
        bvVar3 = this.bvg.buL;
        if (view != bvVar3.XX()) {
            bvVar12 = this.bvg.buL;
            if (view != bvVar12.XY()) {
                bvVar13 = this.bvg.buL;
                if (view != bvVar13.XZ()) {
                    bvVar14 = this.bvg.buL;
                    if (view != bvVar14.Ya()) {
                        bvVar15 = this.bvg.buL;
                        if (view != bvVar15.Xx()) {
                            bvVar16 = this.bvg.buL;
                            if (view == bvVar16.Yi()) {
                                bnVar39 = this.bvg.buG;
                                if (bnVar39 != null) {
                                    bnVar40 = this.bvg.buG;
                                    com.baidu.tbadk.browser.a.i(this.bvg, bnVar40.getPbData().zK().kx().getLink());
                                    return;
                                }
                                return;
                            }
                            bvVar17 = this.bvg.buL;
                            if (view == bvVar17.Xw()) {
                                bvVar62 = this.bvg.buL;
                                bvVar62.Ye();
                                String currentAccount = TbadkApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    vVar3 = this.bvg.buK;
                                    if (!vVar3.Tx()) {
                                        bvVar63 = this.bvg.buL;
                                        bvVar63.Xv();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue();
                                            bnVar35 = this.bvg.buG;
                                            if (bnVar35.WJ()) {
                                                eVar11 = this.bvg.buJ;
                                                if (eVar11 != null) {
                                                    eVar12 = this.bvg.buJ;
                                                    if (eVar12.YK() != null) {
                                                        eVar13 = this.bvg.buJ;
                                                        if (eVar13.YK().Aw() != null) {
                                                            eVar14 = this.bvg.buJ;
                                                            if (eVar14.YK().Ay() != null) {
                                                                vVar5 = this.bvg.buK;
                                                                eVar15 = this.bvg.buJ;
                                                                String id = eVar15.YK().Aw().getId();
                                                                eVar16 = this.bvg.buJ;
                                                                String name = eVar16.YK().Aw().getName();
                                                                eVar17 = this.bvg.buJ;
                                                                vVar5.a(id, name, eVar17.YK().Ay().getId(), str, intValue2, intValue, booleanValue);
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
                                            vVar4 = this.bvg.buK;
                                            bnVar36 = this.bvg.buG;
                                            String id2 = bnVar36.getPbData().zJ().getId();
                                            bnVar37 = this.bvg.buG;
                                            String name2 = bnVar37.getPbData().zJ().getName();
                                            bnVar38 = this.bvg.buG;
                                            vVar4.a(id2, name2, bnVar38.getPbData().zK().getId(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.bvg, this.bvg.getString(com.baidu.tieba.y.login_to_use), true, 11017);
                                return;
                            }
                            bvVar18 = this.bvg.buL;
                            if (view != bvVar18.Yb()) {
                                bvVar19 = this.bvg.buL;
                                if (view == bvVar19.Xz()) {
                                    eVar10 = this.bvg.buJ;
                                    if (eVar10.tL()) {
                                        bvVar61 = this.bvg.buL;
                                        bvVar61.XH();
                                        return;
                                    }
                                    return;
                                }
                                bvVar20 = this.bvg.buL;
                                if (view == bvVar20.Xs()) {
                                    eVar7 = this.bvg.buJ;
                                    if (eVar7 != null) {
                                        eVar8 = this.bvg.buJ;
                                        if (eVar8.WF() != null) {
                                            PbActivity pbActivity = this.bvg;
                                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bvg);
                                            eVar9 = this.bvg.buJ;
                                            pbActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(eVar9.WF(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bvVar21 = this.bvg.buL;
                                if (view != bvVar21.bxj.byZ) {
                                    bvVar22 = this.bvg.buL;
                                    if (view == bvVar22.bxj.bzb) {
                                        bnVar26 = this.bvg.buG;
                                        if (bnVar26 != null) {
                                            bnVar27 = this.bvg.buG;
                                            if (bnVar27.getPbData() != null) {
                                                bnVar28 = this.bvg.buG;
                                                ArrayList<com.baidu.tieba.data.ak> zL = bnVar28.getPbData().zL();
                                                if (zL == null || zL.size() <= 0) {
                                                    com.baidu.adp.lib.util.m.showToast(this.bvg, this.bvg.getString(com.baidu.tieba.y.pb_no_data_tips));
                                                    return;
                                                } else {
                                                    this.bvg.Wg();
                                                    return;
                                                }
                                            }
                                        }
                                        com.baidu.adp.lib.util.m.showToast(this.bvg, this.bvg.getString(com.baidu.tieba.y.pb_no_data_tips));
                                        return;
                                    }
                                    bvVar23 = this.bvg.buL;
                                    if (view != bvVar23.bxj.bza) {
                                        bvVar24 = this.bvg.buL;
                                        if (view == bvVar24.bxj.bzc) {
                                            bnVar19 = this.bvg.buG;
                                            AdditionData zR = bnVar19.getPbData().zR();
                                            if (!TextUtils.isEmpty(zR.getWarnMsg())) {
                                                com.baidu.adp.lib.util.m.showToast(this.bvg, zR.getWarnMsg());
                                                return;
                                            } else if (zR.getAlreadyCount() != zR.getTotalCount()) {
                                                bnVar20 = this.bvg.buG;
                                                ForumData zJ = bnVar20.getPbData().zJ();
                                                bnVar21 = this.bvg.buG;
                                                com.baidu.tbadk.core.data.q zK = bnVar21.getPbData().zK();
                                                bnVar22 = this.bvg.buG;
                                                AntiData jZ = bnVar22.getPbData().jZ();
                                                if (zK.getId() != null) {
                                                    if (jZ != null && jZ.getIfpost() == 0) {
                                                        com.baidu.adp.lib.util.m.showToast(this.bvg, jZ.getForbid_info());
                                                        return;
                                                    }
                                                    int i = 0;
                                                    bnVar23 = this.bvg.buG;
                                                    if (bnVar23.getPbData().getUserData() != null) {
                                                        bnVar24 = this.bvg.buG;
                                                        i = bnVar24.getPbData().getUserData().getIsMem();
                                                    }
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bvg, 2, zJ.getId(), zJ.getName(), zK.getId(), zR.getPostId(), 0, jZ, 13008, false, false, null, false, false, null, zR, null, i)));
                                                    return;
                                                }
                                                return;
                                            } else {
                                                com.baidu.adp.lib.util.m.showToast(this.bvg, String.format(this.bvg.getString(com.baidu.tieba.y.write_addition_limit), Integer.valueOf(zR.getTotalCount())));
                                                return;
                                            }
                                        }
                                        bvVar25 = this.bvg.buL;
                                        if (bvVar25.bxj.Yq() != null) {
                                            bvVar57 = this.bvg.buL;
                                            if (view == bvVar57.bxj.Yq().WU()) {
                                                bvVar58 = this.bvg.buL;
                                                bvVar58.Yd();
                                                gJ = this.bvg.gJ(11009);
                                                if (gJ) {
                                                    bnVar18 = this.bvg.buG;
                                                    bvVar59 = this.bvg.buL;
                                                    if (bnVar18.gQ(bvVar59.XP()) == null) {
                                                        return;
                                                    }
                                                    this.bvg.Wl();
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        bvVar26 = this.bvg.buL;
                                        if (bvVar26.bxj.Yq() != null) {
                                            bvVar55 = this.bvg.buL;
                                            if (view == bvVar55.bxj.Yq().WV()) {
                                                bvVar56 = this.bvg.buL;
                                                bvVar56.Yd();
                                                this.bvg.EA();
                                                this.bvg.Hv();
                                                return;
                                            }
                                        }
                                        bvVar27 = this.bvg.buL;
                                        if (bvVar27.bxj.Yq() != null) {
                                            bvVar52 = this.bvg.buL;
                                            if (view == bvVar52.bxj.Yq().WX()) {
                                                bvVar53 = this.bvg.buL;
                                                bvVar53.Yd();
                                                bnVar16 = this.bvg.buG;
                                                if (bnVar16.WL() != null) {
                                                    bvVar54 = this.bvg.buL;
                                                    bnVar17 = this.bvg.buG;
                                                    bvVar54.b(bnVar17.WL());
                                                }
                                                TiebaStatic.eventStat(this.bvg, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        bvVar28 = this.bvg.buL;
                                        if (bvVar28.bxj.Yq() != null) {
                                            bvVar49 = this.bvg.buL;
                                            if (view == bvVar49.bxj.Yq().WY()) {
                                                bvVar50 = this.bvg.buL;
                                                bvVar50.Yd();
                                                this.bvg.EA();
                                                bvVar51 = this.bvg.buL;
                                                bvVar51.XA();
                                                bnVar15 = this.bvg.buG;
                                                bnVar15.WP();
                                                TiebaStatic.eventStat(this.bvg, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        buVar = this.bvg.buQ;
                                        if (buVar != null) {
                                            buVar24 = this.bvg.buQ;
                                            if (view == buVar24.WU()) {
                                                this.bvg.R(view);
                                                morePopupWindow9 = this.bvg.buP;
                                                com.baidu.adp.lib.g.j.a(morePopupWindow9, this.bvg);
                                                return;
                                            }
                                        }
                                        bvVar29 = this.bvg.buL;
                                        if (bvVar29.Xm() != view) {
                                            buVar2 = this.bvg.buQ;
                                            if (buVar2 != null) {
                                                buVar23 = this.bvg.buQ;
                                                if (view == buVar23.Xf()) {
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    if (sparseArray2 != null) {
                                                        if ("".equals(sparseArray2.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                            bvVar47 = this.bvg.buL;
                                                            bvVar47.a(((Integer) sparseArray2.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                                        } else {
                                                            bvVar48 = this.bvg.buL;
                                                            bvVar48.W(view);
                                                        }
                                                        morePopupWindow8 = this.bvg.buP;
                                                        com.baidu.adp.lib.g.j.a(morePopupWindow8, this.bvg);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            if (view.getId() != com.baidu.tieba.v.pb_head_function_manage_delormanage) {
                                                buVar3 = this.bvg.buQ;
                                                if (buVar3 != null) {
                                                    buVar22 = this.bvg.buQ;
                                                }
                                                if (view.getId() != com.baidu.tieba.v.sub_pb_more && view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                    int id3 = view.getId();
                                                    if (id3 == com.baidu.tieba.v.dialog_button_ok) {
                                                        bnVar8 = this.bvg.buG;
                                                        com.baidu.tbadk.core.data.m WL = bnVar8.WL();
                                                        bvVar37 = this.bvg.buL;
                                                        int pageNum = bvVar37.getPageNum();
                                                        if (pageNum <= 0) {
                                                            this.bvg.showToast(com.baidu.tieba.y.pb_page_error);
                                                            return;
                                                        } else if (WL == null || pageNum <= WL.kc()) {
                                                            bvVar38 = this.bvg.buL;
                                                            bvVar38.Yd();
                                                            this.bvg.EA();
                                                            bvVar39 = this.bvg.buL;
                                                            bvVar39.XA();
                                                            bnVar9 = this.bvg.buG;
                                                            bvVar40 = this.bvg.buL;
                                                            bnVar9.gL(bvVar40.getPageNum());
                                                            return;
                                                        } else {
                                                            this.bvg.showToast(com.baidu.tieba.y.pb_page_error);
                                                            return;
                                                        }
                                                    } else if (id3 == com.baidu.tieba.v.dialog_button_cancel) {
                                                        bvVar36 = this.bvg.buL;
                                                        bvVar36.Yd();
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.reply) {
                                                        morePopupWindow = this.bvg.buP;
                                                        if (morePopupWindow != null) {
                                                            buVar16 = this.bvg.buQ;
                                                        }
                                                        this.bvg.We();
                                                        morePopupWindow2 = this.bvg.buP;
                                                        if (morePopupWindow2.getIsIntercepted()) {
                                                            morePopupWindow5 = this.bvg.buP;
                                                            morePopupWindow5.setIsIntercepted(false);
                                                            return;
                                                        }
                                                        com.baidu.tieba.data.ak akVar = null;
                                                        if (view != null && view.getTag() != null) {
                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                            akVar = (com.baidu.tieba.data.ak) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_data);
                                                            SparseArray sparseArray4 = new SparseArray();
                                                            sparseArray4.put(com.baidu.tieba.v.tag_load_sub_data, akVar);
                                                            sparseArray4.put(com.baidu.tieba.v.tag_load_sub_view, (View) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_view));
                                                            buVar9 = this.bvg.buQ;
                                                            buVar9.Xe().setTag(sparseArray4);
                                                            SparseArray sparseArray5 = new SparseArray();
                                                            sparseArray5.put(com.baidu.tieba.v.tag_clip_board, (com.baidu.tieba.data.ak) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board));
                                                            sparseArray5.put(com.baidu.tieba.v.tag_is_subpb, false);
                                                            buVar10 = this.bvg.buQ;
                                                            buVar10.WU().setTag(sparseArray5);
                                                            SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                            if (!((Boolean) sparseArray6.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                                buVar11 = this.bvg.buQ;
                                                                buVar11.Xf().setVisibility(8);
                                                            } else {
                                                                SparseArray sparseArray7 = new SparseArray();
                                                                sparseArray7.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray6.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray6.get(com.baidu.tieba.v.tag_del_post_is_self));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_del_post_id, sparseArray6.get(com.baidu.tieba.v.tag_del_post_id));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_del_post_type, sparseArray6.get(com.baidu.tieba.v.tag_del_post_type));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                                buVar12 = this.bvg.buQ;
                                                                buVar12.Xf().setTag(sparseArray7);
                                                                TbadkApplication.m251getInst().getSkinType();
                                                                if ("".equals(sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray6.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                    buVar13 = this.bvg.buQ;
                                                                    com.baidu.tbadk.core.util.aw.c(buVar13.Xf(), com.baidu.tieba.u.icon_pb_del_n);
                                                                } else {
                                                                    buVar15 = this.bvg.buQ;
                                                                    com.baidu.tbadk.core.util.aw.c(buVar15.Xf(), com.baidu.tieba.u.icon_pb_set_n);
                                                                }
                                                                buVar14 = this.bvg.buQ;
                                                                buVar14.Xf().setVisibility(0);
                                                            }
                                                        }
                                                        boolean z2 = false;
                                                        bnVar6 = this.bvg.buG;
                                                        if (bnVar6.getPbData().zN()) {
                                                            bnVar7 = this.bvg.buG;
                                                            String zO = bnVar7.getPbData().zO();
                                                            if (akVar != null && !com.baidu.adp.lib.util.l.aA(zO) && zO.equals(akVar.getId())) {
                                                                z2 = true;
                                                            }
                                                        }
                                                        TbadkApplication.m251getInst().getSkinType();
                                                        if (z2) {
                                                            buVar7 = this.bvg.buQ;
                                                            buVar7.WU().setText(com.baidu.tieba.y.marked);
                                                            buVar8 = this.bvg.buQ;
                                                            buVar8.WU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                        } else {
                                                            buVar4 = this.bvg.buQ;
                                                            buVar4.WU().setText(com.baidu.tieba.y.mark);
                                                            buVar5 = this.bvg.buQ;
                                                            buVar5.WU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                        }
                                                        buVar6 = this.bvg.buQ;
                                                        buVar6.ed(true);
                                                        morePopupWindow3 = this.bvg.buP;
                                                        morePopupWindow3.reLayoutWidth();
                                                        morePopupWindow4 = this.bvg.buP;
                                                        morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.sub_post_load_more) {
                                                        eVar3 = this.bvg.buJ;
                                                        if (eVar3.tL()) {
                                                            bvVar35 = this.bvg.buL;
                                                            bvVar35.XH();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.sub_pb_bottom_layout) {
                                                        bnVar5 = this.bvg.buG;
                                                        if (bnVar5.WJ()) {
                                                            this.bvg.closeActivity();
                                                            return;
                                                        }
                                                        this.bvg.EA();
                                                        bvVar34 = this.bvg.buL;
                                                        bvVar34.XK();
                                                        eVar2 = this.bvg.buJ;
                                                        eVar2.cancelLoadData();
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.btn_loadprevious) {
                                                        eVar = this.bvg.buJ;
                                                        if (eVar.YQ()) {
                                                            bvVar33 = this.bvg.buL;
                                                            bvVar33.XI();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.pb_new_guide) {
                                                        SharedPreferences.Editor edit = this.bvg.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                        edit.putBoolean("has_shown_pb_guide", true);
                                                        edit.commit();
                                                        bvVar32 = this.bvg.buL;
                                                        bvVar32.GG();
                                                        return;
                                                    } else if (id3 != com.baidu.tieba.v.pb_head_reverse_hint) {
                                                        return;
                                                    } else {
                                                        this.bvg.EA();
                                                        bvVar30 = this.bvg.buL;
                                                        bvVar30.Yd();
                                                        bvVar31 = this.bvg.buL;
                                                        bvVar31.XA();
                                                        bnVar4 = this.bvg.buG;
                                                        bnVar4.WP();
                                                        return;
                                                    }
                                                }
                                                buVar17 = this.bvg.buQ;
                                                if (buVar17 != null) {
                                                    buVar20 = this.bvg.buQ;
                                                    if (view == buVar20.Xe()) {
                                                        buVar21 = this.bvg.buQ;
                                                        if (!buVar21.Xd()) {
                                                            morePopupWindow7 = this.bvg.buP;
                                                            com.baidu.adp.lib.g.j.a(morePopupWindow7, this.bvg);
                                                            bvVar44 = this.bvg.buL;
                                                            bvVar44.eg(true);
                                                            return;
                                                        }
                                                    }
                                                }
                                                try {
                                                    bnVar10 = this.bvg.buG;
                                                    if (bnVar10.getPbData() != null) {
                                                        bvVar41 = this.bvg.buL;
                                                        bvVar41.Yd();
                                                        SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                        com.baidu.tieba.data.ak akVar2 = (com.baidu.tieba.data.ak) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_data);
                                                        View view2 = (View) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_view);
                                                        if (akVar2 != null && view2 != null) {
                                                            bnVar11 = this.bvg.buG;
                                                            com.baidu.tieba.data.ar c = bnVar11.c(akVar2);
                                                            eVar4 = this.bvg.buJ;
                                                            bnVar12 = this.bvg.buG;
                                                            eVar4.ha(bnVar12.WF());
                                                            eVar5 = this.bvg.buJ;
                                                            eVar5.ey(akVar2.getId());
                                                            eVar6 = this.bvg.buJ;
                                                            eVar6.resetData();
                                                            this.bvg.EA();
                                                            buVar18 = this.bvg.buQ;
                                                            if (buVar18 != null) {
                                                                buVar19 = this.bvg.buQ;
                                                                if (view == buVar19.Xe()) {
                                                                    morePopupWindow6 = this.bvg.buP;
                                                                    com.baidu.adp.lib.g.j.a(morePopupWindow6, this.bvg);
                                                                    bvVar43 = this.bvg.buL;
                                                                    bnVar14 = this.bvg.buG;
                                                                    bvVar43.a(true, c, false, null, null, view2, bnVar14.getPbData().zQ());
                                                                    return;
                                                                }
                                                            }
                                                            if (view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                                handler = this.bvg.mHandler;
                                                                handler.post(new bb(this, c, view2));
                                                                return;
                                                            }
                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                            String str2 = (String) sparseArray9.get(com.baidu.tieba.v.tag_photo_username);
                                                            com.baidu.tieba.data.ak akVar3 = (com.baidu.tieba.data.ak) sparseArray9.get(com.baidu.tieba.v.tag_clip_board);
                                                            String str3 = null;
                                                            if (akVar3 != null) {
                                                                str3 = akVar3.getId();
                                                            }
                                                            bvVar42 = this.bvg.buL;
                                                            bnVar13 = this.bvg.buG;
                                                            bvVar42.a(true, c, false, str2, str3, view2, bnVar13.getPbData().zQ());
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
                                            if (((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                bvVar46 = this.bvg.buL;
                                                bvVar46.W(view);
                                                return;
                                            }
                                            bvVar45 = this.bvg.buL;
                                            bvVar45.a(((Integer) sparseArray10.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        this.bvg.Wa();
                                        return;
                                    }
                                    this.bvg.EA();
                                    bvVar60 = this.bvg.buL;
                                    bvVar60.XA();
                                    bnVar25 = this.bvg.buG;
                                    bnVar25.WO();
                                    TiebaStatic.eventStat(this.bvg, "pb_set_host", "pbclick", 1, new Object[0]);
                                    return;
                                }
                                TiebaStatic.eventStat(this.bvg, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bnVar29 = this.bvg.buG;
                                String name3 = bnVar29.getPbData().zJ().getName();
                                bnVar30 = this.bvg.buG;
                                if (!TextUtils.isEmpty(bnVar30.WE())) {
                                    bnVar31 = this.bvg.buG;
                                    if (bnVar31.WE().equals(name3)) {
                                        this.bvg.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.ay.az(name3)) {
                                    this.bvg.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bvg).createNormalCfg(name3, FrsActivityConfig.FRS_FROM_PB)));
                                    return;
                                }
                                return;
                            }
                            morePopupWindow10 = this.bvg.buP;
                            if (morePopupWindow10 != null) {
                                buVar32 = this.bvg.buQ;
                            }
                            this.bvg.We();
                            com.baidu.tieba.data.ak akVar4 = null;
                            if (view != null && view.getTag() != null) {
                                akVar4 = (com.baidu.tieba.data.ak) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board);
                                SparseArray sparseArray11 = new SparseArray();
                                sparseArray11.put(com.baidu.tieba.v.tag_clip_board, akVar4);
                                sparseArray11.put(com.baidu.tieba.v.tag_is_subpb, false);
                                buVar31 = this.bvg.buQ;
                                buVar31.WU().setTag(sparseArray11);
                            }
                            bnVar32 = this.bvg.buG;
                            if (bnVar32.getPbData() != null) {
                                bnVar33 = this.bvg.buG;
                                if (bnVar33.getPbData().zN()) {
                                    bnVar34 = this.bvg.buG;
                                    String zO2 = bnVar34.getPbData().zO();
                                    if (akVar4 != null && !com.baidu.adp.lib.util.l.aA(zO2) && zO2.equals(akVar4.getId())) {
                                        z = true;
                                        if (!z) {
                                            buVar29 = this.bvg.buQ;
                                            buVar29.WU().setText(com.baidu.tieba.y.marked);
                                            buVar30 = this.bvg.buQ;
                                            buVar30.WU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                        } else {
                                            buVar25 = this.bvg.buQ;
                                            buVar25.WU().setText(com.baidu.tieba.y.mark);
                                            buVar26 = this.bvg.buQ;
                                            buVar26.WU().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                        }
                                        buVar27 = this.bvg.buQ;
                                        buVar27.Xf().setVisibility(8);
                                        buVar28 = this.bvg.buQ;
                                        buVar28.ed(false);
                                        morePopupWindow11 = this.bvg.buP;
                                        morePopupWindow11.reLayoutWidth();
                                        morePopupWindow12 = this.bvg.buP;
                                        morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                                        return;
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                            buVar27 = this.bvg.buQ;
                            buVar27.Xf().setVisibility(8);
                            buVar28 = this.bvg.buQ;
                            buVar28.ed(false);
                            morePopupWindow11 = this.bvg.buP;
                            morePopupWindow11.reLayoutWidth();
                            morePopupWindow12 = this.bvg.buP;
                            morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                            return;
                        }
                    }
                }
            }
        }
        bvVar4 = this.bvg.buL;
        bvVar4.Ye();
        bnVar = this.bvg.buG;
        if (bnVar.getPbData().zQ() == 1) {
            vVar = this.bvg.buK;
            if (!vVar.Tx()) {
                bvVar5 = this.bvg.buL;
                bvVar5.Xv();
                int i2 = 0;
                bvVar6 = this.bvg.buL;
                if (view != bvVar6.XX()) {
                    bvVar7 = this.bvg.buL;
                    if (view != bvVar7.XY()) {
                        bvVar8 = this.bvg.buL;
                        if (view != bvVar8.XZ()) {
                            bvVar9 = this.bvg.buL;
                            if (view != bvVar9.Ya()) {
                                bvVar10 = this.bvg.buL;
                                if (view == bvVar10.Xx()) {
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
                bnVar2 = this.bvg.buG;
                ForumData zJ2 = bnVar2.getPbData().zJ();
                String name4 = zJ2.getName();
                String id4 = zJ2.getId();
                bnVar3 = this.bvg.buG;
                String id5 = bnVar3.getPbData().zK().getId();
                vVar2 = this.bvg.buK;
                bvVar11 = this.bvg.buL;
                vVar2.a(id4, name4, id5, i2, bvVar11.Xy());
            }
        }
    }
}
