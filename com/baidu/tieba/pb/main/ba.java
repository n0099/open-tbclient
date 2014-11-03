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
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:212:0x09e9, code lost:
        if (r21 != r1.Xh()) goto L273;
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
        bvVar = this.bvu.buZ;
        if (view == bvVar.getNextView()) {
            bnVar42 = this.bvu.buU;
            if (bnVar42.dZ(true)) {
                bvVar65 = this.bvu.buZ;
                bvVar65.XE();
                return;
            }
            return;
        }
        bvVar2 = this.bvu.buZ;
        if (view == bvVar2.bxx.aTX) {
            bvVar64 = this.bvu.buZ;
            bnVar41 = this.bvu.buU;
            if (!bvVar64.ej(bnVar41.WM())) {
                this.bvu.closeActivity();
                return;
            } else {
                this.bvu.EC();
                return;
            }
        }
        bvVar3 = this.bvu.buZ;
        if (view != bvVar3.Ya()) {
            bvVar12 = this.bvu.buZ;
            if (view != bvVar12.Yb()) {
                bvVar13 = this.bvu.buZ;
                if (view != bvVar13.Yc()) {
                    bvVar14 = this.bvu.buZ;
                    if (view != bvVar14.Yd()) {
                        bvVar15 = this.bvu.buZ;
                        if (view != bvVar15.XA()) {
                            bvVar16 = this.bvu.buZ;
                            if (view == bvVar16.Yl()) {
                                bnVar39 = this.bvu.buU;
                                if (bnVar39 != null) {
                                    bnVar40 = this.bvu.buU;
                                    com.baidu.tbadk.browser.a.i(this.bvu, bnVar40.getPbData().zM().kx().getLink());
                                    return;
                                }
                                return;
                            }
                            bvVar17 = this.bvu.buZ;
                            if (view == bvVar17.Xz()) {
                                bvVar62 = this.bvu.buZ;
                                bvVar62.Yh();
                                String currentAccount = TbadkApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    vVar3 = this.bvu.buY;
                                    if (!vVar3.TA()) {
                                        bvVar63 = this.bvu.buZ;
                                        bvVar63.Xy();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue();
                                            bnVar35 = this.bvu.buU;
                                            if (bnVar35.WM()) {
                                                eVar11 = this.bvu.buX;
                                                if (eVar11 != null) {
                                                    eVar12 = this.bvu.buX;
                                                    if (eVar12.YN() != null) {
                                                        eVar13 = this.bvu.buX;
                                                        if (eVar13.YN().Ay() != null) {
                                                            eVar14 = this.bvu.buX;
                                                            if (eVar14.YN().AA() != null) {
                                                                vVar5 = this.bvu.buY;
                                                                eVar15 = this.bvu.buX;
                                                                String id = eVar15.YN().Ay().getId();
                                                                eVar16 = this.bvu.buX;
                                                                String name = eVar16.YN().Ay().getName();
                                                                eVar17 = this.bvu.buX;
                                                                vVar5.a(id, name, eVar17.YN().AA().getId(), str, intValue2, intValue, booleanValue);
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
                                            vVar4 = this.bvu.buY;
                                            bnVar36 = this.bvu.buU;
                                            String id2 = bnVar36.getPbData().zL().getId();
                                            bnVar37 = this.bvu.buU;
                                            String name2 = bnVar37.getPbData().zL().getName();
                                            bnVar38 = this.bvu.buU;
                                            vVar4.a(id2, name2, bnVar38.getPbData().zM().getId(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.bvu, this.bvu.getString(com.baidu.tieba.y.login_to_use), true, 11017);
                                return;
                            }
                            bvVar18 = this.bvu.buZ;
                            if (view != bvVar18.Ye()) {
                                bvVar19 = this.bvu.buZ;
                                if (view == bvVar19.XC()) {
                                    eVar10 = this.bvu.buX;
                                    if (eVar10.tN()) {
                                        bvVar61 = this.bvu.buZ;
                                        bvVar61.XK();
                                        return;
                                    }
                                    return;
                                }
                                bvVar20 = this.bvu.buZ;
                                if (view == bvVar20.Xv()) {
                                    eVar7 = this.bvu.buX;
                                    if (eVar7 != null) {
                                        eVar8 = this.bvu.buX;
                                        if (eVar8.WI() != null) {
                                            PbActivity pbActivity = this.bvu;
                                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bvu);
                                            eVar9 = this.bvu.buX;
                                            pbActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(eVar9.WI(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bvVar21 = this.bvu.buZ;
                                if (view != bvVar21.bxx.bzn) {
                                    bvVar22 = this.bvu.buZ;
                                    if (view == bvVar22.bxx.bzp) {
                                        bnVar26 = this.bvu.buU;
                                        if (bnVar26 != null) {
                                            bnVar27 = this.bvu.buU;
                                            if (bnVar27.getPbData() != null) {
                                                bnVar28 = this.bvu.buU;
                                                ArrayList<com.baidu.tieba.data.ak> zN = bnVar28.getPbData().zN();
                                                if (zN == null || zN.size() <= 0) {
                                                    com.baidu.adp.lib.util.m.showToast(this.bvu, this.bvu.getString(com.baidu.tieba.y.pb_no_data_tips));
                                                    return;
                                                } else {
                                                    this.bvu.Wj();
                                                    return;
                                                }
                                            }
                                        }
                                        com.baidu.adp.lib.util.m.showToast(this.bvu, this.bvu.getString(com.baidu.tieba.y.pb_no_data_tips));
                                        return;
                                    }
                                    bvVar23 = this.bvu.buZ;
                                    if (view != bvVar23.bxx.bzo) {
                                        bvVar24 = this.bvu.buZ;
                                        if (view == bvVar24.bxx.bzq) {
                                            bnVar19 = this.bvu.buU;
                                            AdditionData zT = bnVar19.getPbData().zT();
                                            if (!TextUtils.isEmpty(zT.getWarnMsg())) {
                                                com.baidu.adp.lib.util.m.showToast(this.bvu, zT.getWarnMsg());
                                                return;
                                            } else if (zT.getAlreadyCount() != zT.getTotalCount()) {
                                                bnVar20 = this.bvu.buU;
                                                ForumData zL = bnVar20.getPbData().zL();
                                                bnVar21 = this.bvu.buU;
                                                com.baidu.tbadk.core.data.q zM = bnVar21.getPbData().zM();
                                                bnVar22 = this.bvu.buU;
                                                AntiData jZ = bnVar22.getPbData().jZ();
                                                if (zM.getId() != null) {
                                                    if (jZ != null && jZ.getIfpost() == 0) {
                                                        com.baidu.adp.lib.util.m.showToast(this.bvu, jZ.getForbid_info());
                                                        return;
                                                    }
                                                    int i = 0;
                                                    bnVar23 = this.bvu.buU;
                                                    if (bnVar23.getPbData().getUserData() != null) {
                                                        bnVar24 = this.bvu.buU;
                                                        i = bnVar24.getPbData().getUserData().getIsMem();
                                                    }
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bvu, 2, zL.getId(), zL.getName(), zM.getId(), zT.getPostId(), 0, jZ, 13008, false, false, null, false, false, null, zT, null, i)));
                                                    return;
                                                }
                                                return;
                                            } else {
                                                com.baidu.adp.lib.util.m.showToast(this.bvu, String.format(this.bvu.getString(com.baidu.tieba.y.write_addition_limit), Integer.valueOf(zT.getTotalCount())));
                                                return;
                                            }
                                        }
                                        bvVar25 = this.bvu.buZ;
                                        if (bvVar25.bxx.Yt() != null) {
                                            bvVar57 = this.bvu.buZ;
                                            if (view == bvVar57.bxx.Yt().WX()) {
                                                bvVar58 = this.bvu.buZ;
                                                bvVar58.Yg();
                                                gJ = this.bvu.gJ(11009);
                                                if (gJ) {
                                                    bnVar18 = this.bvu.buU;
                                                    bvVar59 = this.bvu.buZ;
                                                    if (bnVar18.gQ(bvVar59.XS()) == null) {
                                                        return;
                                                    }
                                                    this.bvu.Wo();
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        bvVar26 = this.bvu.buZ;
                                        if (bvVar26.bxx.Yt() != null) {
                                            bvVar55 = this.bvu.buZ;
                                            if (view == bvVar55.bxx.Yt().WY()) {
                                                bvVar56 = this.bvu.buZ;
                                                bvVar56.Yg();
                                                this.bvu.EC();
                                                this.bvu.Hw();
                                                return;
                                            }
                                        }
                                        bvVar27 = this.bvu.buZ;
                                        if (bvVar27.bxx.Yt() != null) {
                                            bvVar52 = this.bvu.buZ;
                                            if (view == bvVar52.bxx.Yt().Xa()) {
                                                bvVar53 = this.bvu.buZ;
                                                bvVar53.Yg();
                                                bnVar16 = this.bvu.buU;
                                                if (bnVar16.WO() != null) {
                                                    bvVar54 = this.bvu.buZ;
                                                    bnVar17 = this.bvu.buU;
                                                    bvVar54.b(bnVar17.WO());
                                                }
                                                TiebaStatic.eventStat(this.bvu, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        bvVar28 = this.bvu.buZ;
                                        if (bvVar28.bxx.Yt() != null) {
                                            bvVar49 = this.bvu.buZ;
                                            if (view == bvVar49.bxx.Yt().Xb()) {
                                                bvVar50 = this.bvu.buZ;
                                                bvVar50.Yg();
                                                this.bvu.EC();
                                                bvVar51 = this.bvu.buZ;
                                                bvVar51.XD();
                                                bnVar15 = this.bvu.buU;
                                                bnVar15.WS();
                                                TiebaStatic.eventStat(this.bvu, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        buVar = this.bvu.bve;
                                        if (buVar != null) {
                                            buVar24 = this.bvu.bve;
                                            if (view == buVar24.WX()) {
                                                this.bvu.R(view);
                                                morePopupWindow9 = this.bvu.bvd;
                                                com.baidu.adp.lib.g.j.a(morePopupWindow9, this.bvu);
                                                return;
                                            }
                                        }
                                        bvVar29 = this.bvu.buZ;
                                        if (bvVar29.Xp() != view) {
                                            buVar2 = this.bvu.bve;
                                            if (buVar2 != null) {
                                                buVar23 = this.bvu.bve;
                                                if (view == buVar23.Xi()) {
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    if (sparseArray2 != null) {
                                                        if ("".equals(sparseArray2.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                            bvVar47 = this.bvu.buZ;
                                                            bvVar47.a(((Integer) sparseArray2.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                                        } else {
                                                            bvVar48 = this.bvu.buZ;
                                                            bvVar48.W(view);
                                                        }
                                                        morePopupWindow8 = this.bvu.bvd;
                                                        com.baidu.adp.lib.g.j.a(morePopupWindow8, this.bvu);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            if (view.getId() != com.baidu.tieba.v.pb_head_function_manage_delormanage) {
                                                buVar3 = this.bvu.bve;
                                                if (buVar3 != null) {
                                                    buVar22 = this.bvu.bve;
                                                }
                                                if (view.getId() != com.baidu.tieba.v.sub_pb_more && view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                    int id3 = view.getId();
                                                    if (id3 == com.baidu.tieba.v.dialog_button_ok) {
                                                        bnVar8 = this.bvu.buU;
                                                        com.baidu.tbadk.core.data.m WO = bnVar8.WO();
                                                        bvVar37 = this.bvu.buZ;
                                                        int pageNum = bvVar37.getPageNum();
                                                        if (pageNum <= 0) {
                                                            this.bvu.showToast(com.baidu.tieba.y.pb_page_error);
                                                            return;
                                                        } else if (WO == null || pageNum <= WO.kc()) {
                                                            bvVar38 = this.bvu.buZ;
                                                            bvVar38.Yg();
                                                            this.bvu.EC();
                                                            bvVar39 = this.bvu.buZ;
                                                            bvVar39.XD();
                                                            bnVar9 = this.bvu.buU;
                                                            bvVar40 = this.bvu.buZ;
                                                            bnVar9.gL(bvVar40.getPageNum());
                                                            return;
                                                        } else {
                                                            this.bvu.showToast(com.baidu.tieba.y.pb_page_error);
                                                            return;
                                                        }
                                                    } else if (id3 == com.baidu.tieba.v.dialog_button_cancel) {
                                                        bvVar36 = this.bvu.buZ;
                                                        bvVar36.Yg();
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.reply) {
                                                        morePopupWindow = this.bvu.bvd;
                                                        if (morePopupWindow != null) {
                                                            buVar16 = this.bvu.bve;
                                                        }
                                                        this.bvu.Wh();
                                                        morePopupWindow2 = this.bvu.bvd;
                                                        if (morePopupWindow2.getIsIntercepted()) {
                                                            morePopupWindow5 = this.bvu.bvd;
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
                                                            buVar9 = this.bvu.bve;
                                                            buVar9.Xh().setTag(sparseArray4);
                                                            SparseArray sparseArray5 = new SparseArray();
                                                            sparseArray5.put(com.baidu.tieba.v.tag_clip_board, (com.baidu.tieba.data.ak) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board));
                                                            sparseArray5.put(com.baidu.tieba.v.tag_is_subpb, false);
                                                            buVar10 = this.bvu.bve;
                                                            buVar10.WX().setTag(sparseArray5);
                                                            SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                            if (!((Boolean) sparseArray6.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                                buVar11 = this.bvu.bve;
                                                                buVar11.Xi().setVisibility(8);
                                                            } else {
                                                                SparseArray sparseArray7 = new SparseArray();
                                                                sparseArray7.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray6.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray6.get(com.baidu.tieba.v.tag_del_post_is_self));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_del_post_id, sparseArray6.get(com.baidu.tieba.v.tag_del_post_id));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_del_post_type, sparseArray6.get(com.baidu.tieba.v.tag_del_post_type));
                                                                sparseArray7.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                                buVar12 = this.bvu.bve;
                                                                buVar12.Xi().setTag(sparseArray7);
                                                                TbadkApplication.m251getInst().getSkinType();
                                                                if ("".equals(sparseArray6.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray6.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                    buVar13 = this.bvu.bve;
                                                                    com.baidu.tbadk.core.util.aw.c(buVar13.Xi(), com.baidu.tieba.u.icon_pb_del_n);
                                                                } else {
                                                                    buVar15 = this.bvu.bve;
                                                                    com.baidu.tbadk.core.util.aw.c(buVar15.Xi(), com.baidu.tieba.u.icon_pb_set_n);
                                                                }
                                                                buVar14 = this.bvu.bve;
                                                                buVar14.Xi().setVisibility(0);
                                                            }
                                                        }
                                                        boolean z2 = false;
                                                        bnVar6 = this.bvu.buU;
                                                        if (bnVar6.getPbData().zP()) {
                                                            bnVar7 = this.bvu.buU;
                                                            String zQ = bnVar7.getPbData().zQ();
                                                            if (akVar != null && !com.baidu.adp.lib.util.l.aA(zQ) && zQ.equals(akVar.getId())) {
                                                                z2 = true;
                                                            }
                                                        }
                                                        TbadkApplication.m251getInst().getSkinType();
                                                        if (z2) {
                                                            buVar7 = this.bvu.bve;
                                                            buVar7.WX().setText(com.baidu.tieba.y.marked);
                                                            buVar8 = this.bvu.bve;
                                                            buVar8.WX().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                                        } else {
                                                            buVar4 = this.bvu.bve;
                                                            buVar4.WX().setText(com.baidu.tieba.y.mark);
                                                            buVar5 = this.bvu.bve;
                                                            buVar5.WX().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                                        }
                                                        buVar6 = this.bvu.bve;
                                                        buVar6.ed(true);
                                                        morePopupWindow3 = this.bvu.bvd;
                                                        morePopupWindow3.reLayoutWidth();
                                                        morePopupWindow4 = this.bvu.bvd;
                                                        morePopupWindow4.showWindowInLeftCenterOfHost(view, false);
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.sub_post_load_more) {
                                                        eVar3 = this.bvu.buX;
                                                        if (eVar3.tN()) {
                                                            bvVar35 = this.bvu.buZ;
                                                            bvVar35.XK();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.sub_pb_bottom_layout) {
                                                        bnVar5 = this.bvu.buU;
                                                        if (bnVar5.WM()) {
                                                            this.bvu.closeActivity();
                                                            return;
                                                        }
                                                        this.bvu.EC();
                                                        bvVar34 = this.bvu.buZ;
                                                        bvVar34.XN();
                                                        eVar2 = this.bvu.buX;
                                                        eVar2.cancelLoadData();
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.btn_loadprevious) {
                                                        eVar = this.bvu.buX;
                                                        if (eVar.YT()) {
                                                            bvVar33 = this.bvu.buZ;
                                                            bvVar33.XL();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (id3 == com.baidu.tieba.v.pb_new_guide) {
                                                        SharedPreferences.Editor edit = this.bvu.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                        edit.putBoolean("has_shown_pb_guide", true);
                                                        edit.commit();
                                                        bvVar32 = this.bvu.buZ;
                                                        bvVar32.GI();
                                                        return;
                                                    } else if (id3 != com.baidu.tieba.v.pb_head_reverse_hint) {
                                                        return;
                                                    } else {
                                                        this.bvu.EC();
                                                        bvVar30 = this.bvu.buZ;
                                                        bvVar30.Yg();
                                                        bvVar31 = this.bvu.buZ;
                                                        bvVar31.XD();
                                                        bnVar4 = this.bvu.buU;
                                                        bnVar4.WS();
                                                        return;
                                                    }
                                                }
                                                buVar17 = this.bvu.bve;
                                                if (buVar17 != null) {
                                                    buVar20 = this.bvu.bve;
                                                    if (view == buVar20.Xh()) {
                                                        buVar21 = this.bvu.bve;
                                                        if (!buVar21.Xg()) {
                                                            morePopupWindow7 = this.bvu.bvd;
                                                            com.baidu.adp.lib.g.j.a(morePopupWindow7, this.bvu);
                                                            bvVar44 = this.bvu.buZ;
                                                            bvVar44.eg(true);
                                                            return;
                                                        }
                                                    }
                                                }
                                                try {
                                                    bnVar10 = this.bvu.buU;
                                                    if (bnVar10.getPbData() != null) {
                                                        bvVar41 = this.bvu.buZ;
                                                        bvVar41.Yg();
                                                        SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                        com.baidu.tieba.data.ak akVar2 = (com.baidu.tieba.data.ak) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_data);
                                                        View view2 = (View) sparseArray8.get(com.baidu.tieba.v.tag_load_sub_view);
                                                        if (akVar2 != null && view2 != null) {
                                                            bnVar11 = this.bvu.buU;
                                                            com.baidu.tieba.data.ar c = bnVar11.c(akVar2);
                                                            eVar4 = this.bvu.buX;
                                                            bnVar12 = this.bvu.buU;
                                                            eVar4.ha(bnVar12.WI());
                                                            eVar5 = this.bvu.buX;
                                                            eVar5.ey(akVar2.getId());
                                                            eVar6 = this.bvu.buX;
                                                            eVar6.resetData();
                                                            this.bvu.EC();
                                                            buVar18 = this.bvu.bve;
                                                            if (buVar18 != null) {
                                                                buVar19 = this.bvu.bve;
                                                                if (view == buVar19.Xh()) {
                                                                    morePopupWindow6 = this.bvu.bvd;
                                                                    com.baidu.adp.lib.g.j.a(morePopupWindow6, this.bvu);
                                                                    bvVar43 = this.bvu.buZ;
                                                                    bnVar14 = this.bvu.buU;
                                                                    bvVar43.a(true, c, false, null, null, view2, bnVar14.getPbData().zS());
                                                                    return;
                                                                }
                                                            }
                                                            if (view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                                handler = this.bvu.mHandler;
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
                                                            bvVar42 = this.bvu.buZ;
                                                            bnVar13 = this.bvu.buU;
                                                            bvVar42.a(true, c, false, str2, str3, view2, bnVar13.getPbData().zS());
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
                                                bvVar46 = this.bvu.buZ;
                                                bvVar46.W(view);
                                                return;
                                            }
                                            bvVar45 = this.bvu.buZ;
                                            bvVar45.a(((Integer) sparseArray10.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                            return;
                                        }
                                        this.bvu.Wd();
                                        return;
                                    }
                                    this.bvu.EC();
                                    bvVar60 = this.bvu.buZ;
                                    bvVar60.XD();
                                    bnVar25 = this.bvu.buU;
                                    bnVar25.WR();
                                    TiebaStatic.eventStat(this.bvu, "pb_set_host", "pbclick", 1, new Object[0]);
                                    return;
                                }
                                TiebaStatic.eventStat(this.bvu, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bnVar29 = this.bvu.buU;
                                String name3 = bnVar29.getPbData().zL().getName();
                                bnVar30 = this.bvu.buU;
                                if (!TextUtils.isEmpty(bnVar30.WH())) {
                                    bnVar31 = this.bvu.buU;
                                    if (bnVar31.WH().equals(name3)) {
                                        this.bvu.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.az.az(name3)) {
                                    this.bvu.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bvu).createNormalCfg(name3, FrsActivityConfig.FRS_FROM_PB)));
                                    return;
                                }
                                return;
                            }
                            morePopupWindow10 = this.bvu.bvd;
                            if (morePopupWindow10 != null) {
                                buVar32 = this.bvu.bve;
                            }
                            this.bvu.Wh();
                            com.baidu.tieba.data.ak akVar4 = null;
                            if (view != null && view.getTag() != null) {
                                akVar4 = (com.baidu.tieba.data.ak) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board);
                                SparseArray sparseArray11 = new SparseArray();
                                sparseArray11.put(com.baidu.tieba.v.tag_clip_board, akVar4);
                                sparseArray11.put(com.baidu.tieba.v.tag_is_subpb, false);
                                buVar31 = this.bvu.bve;
                                buVar31.WX().setTag(sparseArray11);
                            }
                            bnVar32 = this.bvu.buU;
                            if (bnVar32.getPbData() != null) {
                                bnVar33 = this.bvu.buU;
                                if (bnVar33.getPbData().zP()) {
                                    bnVar34 = this.bvu.buU;
                                    String zQ2 = bnVar34.getPbData().zQ();
                                    if (akVar4 != null && !com.baidu.adp.lib.util.l.aA(zQ2) && zQ2.equals(akVar4.getId())) {
                                        z = true;
                                        if (!z) {
                                            buVar29 = this.bvu.bve;
                                            buVar29.WX().setText(com.baidu.tieba.y.marked);
                                            buVar30 = this.bvu.bve;
                                            buVar30.WX().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
                                        } else {
                                            buVar25 = this.bvu.bve;
                                            buVar25.WX().setText(com.baidu.tieba.y.mark);
                                            buVar26 = this.bvu.bve;
                                            buVar26.WX().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                        }
                                        buVar27 = this.bvu.bve;
                                        buVar27.Xi().setVisibility(8);
                                        buVar28 = this.bvu.bve;
                                        buVar28.ed(false);
                                        morePopupWindow11 = this.bvu.bvd;
                                        morePopupWindow11.reLayoutWidth();
                                        morePopupWindow12 = this.bvu.bvd;
                                        morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                                        return;
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                            buVar27 = this.bvu.bve;
                            buVar27.Xi().setVisibility(8);
                            buVar28 = this.bvu.bve;
                            buVar28.ed(false);
                            morePopupWindow11 = this.bvu.bvd;
                            morePopupWindow11.reLayoutWidth();
                            morePopupWindow12 = this.bvu.bvd;
                            morePopupWindow12.showWindowInLeftCenterOfHost(view, false);
                            return;
                        }
                    }
                }
            }
        }
        bvVar4 = this.bvu.buZ;
        bvVar4.Yh();
        bnVar = this.bvu.buU;
        if (bnVar.getPbData().zS() == 1) {
            vVar = this.bvu.buY;
            if (!vVar.TA()) {
                bvVar5 = this.bvu.buZ;
                bvVar5.Xy();
                int i2 = 0;
                bvVar6 = this.bvu.buZ;
                if (view != bvVar6.Ya()) {
                    bvVar7 = this.bvu.buZ;
                    if (view != bvVar7.Yb()) {
                        bvVar8 = this.bvu.buZ;
                        if (view != bvVar8.Yc()) {
                            bvVar9 = this.bvu.buZ;
                            if (view != bvVar9.Yd()) {
                                bvVar10 = this.bvu.buZ;
                                if (view == bvVar10.XA()) {
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
                bnVar2 = this.bvu.buU;
                ForumData zL2 = bnVar2.getPbData().zL();
                String name4 = zL2.getName();
                String id4 = zL2.getId();
                bnVar3 = this.bvu.buU;
                String id5 = bnVar3.getPbData().zM().getId();
                vVar2 = this.bvu.buY;
                bvVar11 = this.bvu.buZ;
                vVar2.a(id4, name4, id5, i2, bvVar11.XB());
            }
        }
    }
}
