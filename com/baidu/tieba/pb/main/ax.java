package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0445  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bm bmVar;
        com.baidu.tieba.model.t tVar;
        bt btVar5;
        bt btVar6;
        bt btVar7;
        bt btVar8;
        bt btVar9;
        bt btVar10;
        bm bmVar2;
        bm bmVar3;
        com.baidu.tieba.model.t tVar2;
        bt btVar11;
        bt btVar12;
        bt btVar13;
        bt btVar14;
        bt btVar15;
        bt btVar16;
        bt btVar17;
        bt btVar18;
        bt btVar19;
        bt btVar20;
        bt btVar21;
        bt btVar22;
        bt btVar23;
        bt btVar24;
        bt btVar25;
        bt btVar26;
        bt btVar27;
        bt btVar28;
        bs bsVar;
        bt btVar29;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bm bmVar4;
        bt btVar30;
        bm bmVar5;
        com.baidu.tieba.pb.sub.f fVar;
        bm bmVar6;
        com.baidu.tieba.pb.sub.f fVar2;
        com.baidu.tieba.pb.sub.f fVar3;
        bs bsVar5;
        Handler handler;
        bt btVar31;
        bm bmVar7;
        com.baidu.tbadk.core.view.i iVar;
        bt btVar32;
        bm bmVar8;
        bs bsVar6;
        com.baidu.tbadk.core.view.i iVar2;
        bt btVar33;
        bt btVar34;
        bm bmVar9;
        bt btVar35;
        bt btVar36;
        com.baidu.tieba.pb.sub.f fVar4;
        bt btVar37;
        bm bmVar10;
        bt btVar38;
        com.baidu.tieba.pb.sub.f fVar5;
        com.baidu.tieba.pb.sub.f fVar6;
        bt btVar39;
        com.baidu.tbadk.core.view.i iVar3;
        bm bmVar11;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        bs bsVar10;
        bs bsVar11;
        com.baidu.tbadk.core.view.i iVar4;
        com.baidu.tbadk.core.view.i iVar5;
        bs bsVar12;
        bs bsVar13;
        bs bsVar14;
        bs bsVar15;
        bm bmVar12;
        bs bsVar16;
        bs bsVar17;
        bs bsVar18;
        bs bsVar19;
        bs bsVar20;
        bs bsVar21;
        bs bsVar22;
        bs bsVar23;
        bs bsVar24;
        bt btVar40;
        bt btVar41;
        bt btVar42;
        bm bmVar13;
        bt btVar43;
        bt btVar44;
        bt btVar45;
        bt btVar46;
        bt btVar47;
        com.baidu.tbadk.core.view.i iVar6;
        bt btVar48;
        com.baidu.tbadk.core.view.i iVar7;
        bt btVar49;
        bm bmVar14;
        bt btVar50;
        bt btVar51;
        bm bmVar15;
        bt btVar52;
        bm bmVar16;
        bt btVar53;
        bt btVar54;
        boolean b;
        bm bmVar17;
        bt btVar55;
        bm bmVar18;
        bm bmVar19;
        bm bmVar20;
        bm bmVar21;
        bm bmVar22;
        bm bmVar23;
        bm bmVar24;
        bt btVar56;
        bm bmVar25;
        bm bmVar26;
        bm bmVar27;
        com.baidu.tieba.pb.sub.f fVar7;
        com.baidu.tieba.pb.sub.f fVar8;
        com.baidu.tieba.pb.sub.f fVar9;
        com.baidu.tieba.pb.sub.f fVar10;
        bt btVar57;
        com.baidu.tbadk.core.view.i iVar8;
        bm bmVar28;
        boolean z;
        bs bsVar25;
        bs bsVar26;
        bs bsVar27;
        bs bsVar28;
        bs bsVar29;
        bs bsVar30;
        com.baidu.tbadk.core.view.i iVar9;
        com.baidu.tbadk.core.view.i iVar10;
        bs bsVar31;
        bs bsVar32;
        bs bsVar33;
        bs bsVar34;
        bm bmVar29;
        bs bsVar35;
        bt btVar58;
        com.baidu.tieba.model.t tVar3;
        bt btVar59;
        bm bmVar30;
        com.baidu.tieba.model.t tVar4;
        bm bmVar31;
        bm bmVar32;
        bm bmVar33;
        com.baidu.tieba.pb.sub.f fVar11;
        com.baidu.tieba.pb.sub.f fVar12;
        com.baidu.tieba.pb.sub.f fVar13;
        com.baidu.tieba.pb.sub.f fVar14;
        com.baidu.tieba.model.t tVar5;
        com.baidu.tieba.pb.sub.f fVar15;
        com.baidu.tieba.pb.sub.f fVar16;
        com.baidu.tieba.pb.sub.f fVar17;
        bm bmVar34;
        bm bmVar35;
        bt btVar60;
        bm bmVar36;
        bm bmVar37;
        bt btVar61;
        btVar = this.a.D;
        if (view == btVar.R()) {
            bmVar37 = this.a.x;
            if (bmVar37.a(true)) {
                btVar61 = this.a.D;
                btVar61.w();
                return;
            }
            return;
        }
        btVar2 = this.a.D;
        if (view == btVar2.i) {
            btVar60 = this.a.D;
            bmVar36 = this.a.x;
            if (!btVar60.f(bmVar36.o())) {
                this.a.closeActivity();
                return;
            } else {
                this.a.D();
                return;
            }
        }
        btVar3 = this.a.D;
        if (view != btVar3.V()) {
            btVar12 = this.a.D;
            if (view != btVar12.W()) {
                btVar13 = this.a.D;
                if (view != btVar13.X()) {
                    btVar14 = this.a.D;
                    if (view != btVar14.Y()) {
                        btVar15 = this.a.D;
                        if (view != btVar15.r()) {
                            btVar16 = this.a.D;
                            if (view == btVar16.ag()) {
                                bmVar34 = this.a.x;
                                if (bmVar34 != null) {
                                    bmVar35 = this.a.x;
                                    com.baidu.tbadk.browser.a.a(this.a, bmVar35.r().c().x().c());
                                    return;
                                }
                                return;
                            }
                            btVar17 = this.a.D;
                            if (view == btVar17.q()) {
                                btVar58 = this.a.D;
                                btVar58.ae();
                                String currentAccount = TbadkApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    tVar3 = this.a.C;
                                    if (!tVar3.b()) {
                                        btVar59 = this.a.D;
                                        btVar59.o();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue();
                                            bmVar30 = this.a.x;
                                            if (bmVar30.o()) {
                                                fVar11 = this.a.B;
                                                if (fVar11 != null) {
                                                    fVar12 = this.a.B;
                                                    if (fVar12.e() != null) {
                                                        fVar13 = this.a.B;
                                                        if (fVar13.e().h() != null) {
                                                            fVar14 = this.a.B;
                                                            if (fVar14.e().m() != null) {
                                                                tVar5 = this.a.C;
                                                                fVar15 = this.a.B;
                                                                String id = fVar15.e().h().getId();
                                                                fVar16 = this.a.B;
                                                                String name = fVar16.e().h().getName();
                                                                fVar17 = this.a.B;
                                                                tVar5.a(id, name, fVar17.e().m().p(), str, intValue2, intValue, booleanValue);
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
                                            tVar4 = this.a.C;
                                            bmVar31 = this.a.x;
                                            String id2 = bmVar31.r().b().getId();
                                            bmVar32 = this.a.x;
                                            String name2 = bmVar32.r().b().getName();
                                            bmVar33 = this.a.x;
                                            tVar4.a(id2, name2, bmVar33.r().c().p(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.y.login_to_use), true, 11017);
                                return;
                            }
                            btVar18 = this.a.D;
                            if (view != btVar18.Z()) {
                                btVar19 = this.a.D;
                                if (view == btVar19.t()) {
                                    fVar10 = this.a.B;
                                    if (fVar10.i()) {
                                        btVar57 = this.a.D;
                                        btVar57.C();
                                        return;
                                    }
                                    return;
                                }
                                btVar20 = this.a.D;
                                if (view == btVar20.l()) {
                                    fVar7 = this.a.B;
                                    if (fVar7 != null) {
                                        fVar8 = this.a.B;
                                        if (fVar8.a() != null) {
                                            PbActivity pbActivity = this.a;
                                            com.baidu.tbadk.core.atomData.aw awVar = new com.baidu.tbadk.core.atomData.aw(this.a);
                                            fVar9 = this.a.B;
                                            pbActivity.sendMessage(new CustomMessage(2004001, awVar.a(fVar9.a(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                btVar21 = this.a.D;
                                if (view != btVar21.c) {
                                    btVar22 = this.a.D;
                                    if (view != btVar22.e) {
                                        btVar23 = this.a.D;
                                        if (view != btVar23.d) {
                                            btVar24 = this.a.D;
                                            if (view == btVar24.f) {
                                                bmVar18 = this.a.x;
                                                AdditionData m = bmVar18.r().m();
                                                if (!TextUtils.isEmpty(m.getWarnMsg())) {
                                                    com.baidu.adp.lib.util.j.a((Context) this.a, m.getWarnMsg());
                                                    return;
                                                } else if (m.getAlreadyCount() != m.getTotalCount()) {
                                                    bmVar19 = this.a.x;
                                                    ForumData b2 = bmVar19.r().b();
                                                    bmVar20 = this.a.x;
                                                    com.baidu.tbadk.core.data.m c = bmVar20.r().c();
                                                    bmVar21 = this.a.x;
                                                    AntiData f = bmVar21.r().f();
                                                    if (c.p() != null) {
                                                        if (f != null && f.getIfpost() == 0) {
                                                            com.baidu.adp.lib.util.j.a((Context) this.a, f.getForbid_info());
                                                            return;
                                                        }
                                                        int i = 0;
                                                        bmVar22 = this.a.x;
                                                        if (bmVar22.r().g() != null) {
                                                            bmVar23 = this.a.x;
                                                            i = bmVar23.r().g().getIsMem();
                                                        }
                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bv(this.a, 2, b2.getId(), b2.getName(), c.p(), m.getPostId(), 0, f, 13008, false, false, null, false, false, null, m, null, i)));
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    com.baidu.adp.lib.util.j.a((Context) this.a, String.format(this.a.getString(com.baidu.tieba.y.write_addition_limit), Integer.valueOf(m.getTotalCount())));
                                                    return;
                                                }
                                            }
                                            btVar25 = this.a.D;
                                            if (view == btVar25.h().b()) {
                                                btVar54 = this.a.D;
                                                btVar54.ad();
                                                b = this.a.b(11009);
                                                if (b) {
                                                    bmVar17 = this.a.x;
                                                    btVar55 = this.a.D;
                                                    if (bmVar17.f(btVar55.L()) == null) {
                                                        return;
                                                    }
                                                    this.a.z();
                                                    return;
                                                }
                                                return;
                                            }
                                            btVar26 = this.a.D;
                                            if (view == btVar26.h().c()) {
                                                btVar53 = this.a.D;
                                                btVar53.ad();
                                                this.a.D();
                                                this.a.E();
                                                return;
                                            }
                                            btVar27 = this.a.D;
                                            if (view == btVar27.h().e()) {
                                                btVar51 = this.a.D;
                                                btVar51.ad();
                                                bmVar15 = this.a.x;
                                                if (bmVar15.s() != null) {
                                                    btVar52 = this.a.D;
                                                    bmVar16 = this.a.x;
                                                    btVar52.a(bmVar16.s());
                                                }
                                                TiebaStatic.eventStat(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            btVar28 = this.a.D;
                                            if (view == btVar28.h().f()) {
                                                btVar49 = this.a.D;
                                                btVar49.ad();
                                                this.a.D();
                                                bmVar14 = this.a.x;
                                                bmVar14.y();
                                                btVar50 = this.a.D;
                                                btVar50.u();
                                                TiebaStatic.eventStat(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            bsVar = this.a.H;
                                            if (view != bsVar.c()) {
                                                btVar29 = this.a.D;
                                                if (btVar29.d() != view) {
                                                    bsVar2 = this.a.H;
                                                    if (view == bsVar2.e()) {
                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                        if (sparseArray2 != null) {
                                                            if ("".equals(sparseArray2.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                btVar47 = this.a.D;
                                                                btVar47.a(((Integer) sparseArray2.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                                            } else {
                                                                btVar48 = this.a.D;
                                                                btVar48.a(view);
                                                            }
                                                            iVar6 = this.a.G;
                                                            iVar6.dismiss();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != com.baidu.tieba.v.pb_head_function_manage_delormanage) {
                                                        bsVar3 = this.a.H;
                                                        if (view == bsVar3.d() || view.getId() == com.baidu.tieba.v.sub_pb_more || view.getId() == com.baidu.tieba.v.sub_pb_item) {
                                                            bsVar4 = this.a.H;
                                                            if (view == bsVar4.d()) {
                                                                bsVar6 = this.a.H;
                                                                if (!bsVar6.a()) {
                                                                    iVar2 = this.a.G;
                                                                    iVar2.dismiss();
                                                                    btVar33 = this.a.D;
                                                                    btVar33.b(true);
                                                                    return;
                                                                }
                                                            }
                                                            try {
                                                                bmVar4 = this.a.x;
                                                                if (bmVar4.r() != null) {
                                                                    btVar30 = this.a.D;
                                                                    btVar30.ad();
                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                    com.baidu.tieba.data.am amVar = (com.baidu.tieba.data.am) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_data);
                                                                    View view2 = (View) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_view);
                                                                    if (amVar != null && view2 != null) {
                                                                        bmVar5 = this.a.x;
                                                                        com.baidu.tieba.data.at a = bmVar5.a(amVar);
                                                                        fVar = this.a.B;
                                                                        bmVar6 = this.a.x;
                                                                        fVar.a(bmVar6.g());
                                                                        fVar2 = this.a.B;
                                                                        fVar2.b(amVar.l());
                                                                        fVar3 = this.a.B;
                                                                        fVar3.d();
                                                                        this.a.D();
                                                                        bsVar5 = this.a.H;
                                                                        if (view == bsVar5.d()) {
                                                                            iVar = this.a.G;
                                                                            iVar.dismiss();
                                                                            btVar32 = this.a.D;
                                                                            bmVar8 = this.a.x;
                                                                            btVar32.a(true, a, false, null, null, view2, bmVar8.r().k());
                                                                            return;
                                                                        } else if (view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                                            handler = this.a.w;
                                                                            handler.post(new ay(this, a, view2));
                                                                            return;
                                                                        } else {
                                                                            SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                            String str2 = (String) sparseArray4.get(com.baidu.tieba.v.tag_photo_username);
                                                                            com.baidu.tieba.data.am amVar2 = (com.baidu.tieba.data.am) sparseArray4.get(com.baidu.tieba.v.tag_clip_board);
                                                                            String str3 = null;
                                                                            if (amVar2 != null) {
                                                                                str3 = amVar2.l();
                                                                            }
                                                                            btVar31 = this.a.D;
                                                                            bmVar7 = this.a.x;
                                                                            btVar31.a(true, a, false, str2, str3, view2, bmVar7.r().k());
                                                                            return;
                                                                        }
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (Exception e) {
                                                                BdLog.e(e.toString());
                                                                return;
                                                            }
                                                        }
                                                        int id3 = view.getId();
                                                        if (id3 == com.baidu.tieba.v.dialog_button_ok) {
                                                            btVar41 = this.a.D;
                                                            btVar41.ad();
                                                            btVar42 = this.a.D;
                                                            if (btVar42.M() < 0) {
                                                                return;
                                                            }
                                                            this.a.D();
                                                            bmVar13 = this.a.x;
                                                            btVar43 = this.a.D;
                                                            bmVar13.c(btVar43.M());
                                                            btVar44 = this.a.D;
                                                            btVar44.u();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.dialog_button_cancel) {
                                                            btVar40 = this.a.D;
                                                            btVar40.ad();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.reply) {
                                                            iVar3 = this.a.G;
                                                            if (iVar3 != null) {
                                                                com.baidu.tieba.data.am amVar3 = null;
                                                                if (view != null && view.getTag() != null) {
                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                    amVar3 = (com.baidu.tieba.data.am) sparseArray5.get(com.baidu.tieba.v.tag_load_sub_data);
                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                    sparseArray6.put(com.baidu.tieba.v.tag_load_sub_data, amVar3);
                                                                    sparseArray6.put(com.baidu.tieba.v.tag_load_sub_view, (View) sparseArray5.get(com.baidu.tieba.v.tag_load_sub_view));
                                                                    bsVar16 = this.a.H;
                                                                    bsVar16.d().setTag(sparseArray6);
                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                    sparseArray7.put(com.baidu.tieba.v.tag_clip_board, (com.baidu.tieba.data.am) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board));
                                                                    sparseArray7.put(com.baidu.tieba.v.tag_is_subpb, false);
                                                                    bsVar17 = this.a.H;
                                                                    bsVar17.c().setTag(sparseArray7);
                                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                    if (!((Boolean) sparseArray8.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                                        bsVar18 = this.a.H;
                                                                        bsVar18.e().setVisibility(8);
                                                                    } else {
                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray8.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray8.get(com.baidu.tieba.v.tag_del_post_is_self));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_del_post_id, sparseArray8.get(com.baidu.tieba.v.tag_del_post_id));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_del_post_type, sparseArray8.get(com.baidu.tieba.v.tag_del_post_type));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray8.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                                        bsVar19 = this.a.H;
                                                                        bsVar19.e().setTag(sparseArray9);
                                                                        int skinType = TbadkApplication.m252getInst().getSkinType();
                                                                        if (!"".equals(sparseArray8.get(com.baidu.tieba.v.tag_forbid_user_name)) && !"".equals(sparseArray8.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                            if (skinType == 1) {
                                                                                bsVar24 = this.a.H;
                                                                                bsVar24.e().setImageResource(com.baidu.tieba.u.icon_pb_set_n_1);
                                                                            } else {
                                                                                bsVar23 = this.a.H;
                                                                                bsVar23.e().setImageResource(com.baidu.tieba.u.icon_pb_set_n);
                                                                            }
                                                                        } else if (skinType == 1) {
                                                                            bsVar21 = this.a.H;
                                                                            bsVar21.e().setImageResource(com.baidu.tieba.u.icon_pb_del_n_1);
                                                                        } else {
                                                                            bsVar20 = this.a.H;
                                                                            bsVar20.e().setImageResource(com.baidu.tieba.u.icon_pb_del_n);
                                                                        }
                                                                        bsVar22 = this.a.H;
                                                                        bsVar22.e().setVisibility(0);
                                                                    }
                                                                }
                                                                boolean z2 = false;
                                                                bmVar11 = this.a.x;
                                                                if (bmVar11.r().h()) {
                                                                    bmVar12 = this.a.x;
                                                                    String i2 = bmVar12.r().i();
                                                                    if (amVar3 != null && !com.baidu.adp.lib.util.i.b(i2) && i2.equals(amVar3.l())) {
                                                                        z2 = true;
                                                                    }
                                                                }
                                                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                                                    if (z2) {
                                                                        bsVar14 = this.a.H;
                                                                        bsVar14.c().setText(com.baidu.tieba.y.marked);
                                                                        bsVar15 = this.a.H;
                                                                        bsVar15.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s_1, 0, 0, 0);
                                                                    } else {
                                                                        bsVar12 = this.a.H;
                                                                        bsVar12.c().setText(com.baidu.tieba.y.mark);
                                                                        bsVar13 = this.a.H;
                                                                        bsVar13.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n_1, 0, 0, 0);
                                                                    }
                                                                } else if (z2) {
                                                                    bsVar9 = this.a.H;
                                                                    bsVar9.c().setText(com.baidu.tieba.y.marked);
                                                                    bsVar10 = this.a.H;
                                                                    bsVar10.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s, 0, 0, 0);
                                                                } else {
                                                                    bsVar7 = this.a.H;
                                                                    bsVar7.c().setText(com.baidu.tieba.y.mark);
                                                                    bsVar8 = this.a.H;
                                                                    bsVar8.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n, 0, 0, 0);
                                                                }
                                                                bsVar11 = this.a.H;
                                                                bsVar11.a(true);
                                                                iVar4 = this.a.G;
                                                                iVar4.a();
                                                                iVar5 = this.a.G;
                                                                iVar5.a(view, false);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.sub_post_load_more) {
                                                            fVar6 = this.a.B;
                                                            if (fVar6.i()) {
                                                                btVar39 = this.a.D;
                                                                btVar39.C();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.sub_pb_bottom_layout) {
                                                            bmVar10 = this.a.x;
                                                            if (bmVar10.o()) {
                                                                this.a.closeActivity();
                                                                return;
                                                            }
                                                            this.a.D();
                                                            btVar38 = this.a.D;
                                                            btVar38.F();
                                                            fVar5 = this.a.B;
                                                            fVar5.cancelLoadData();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.btn_loadprevious) {
                                                            fVar4 = this.a.B;
                                                            if (fVar4.l()) {
                                                                btVar37 = this.a.D;
                                                                btVar37.D();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.pb_new_guide) {
                                                            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                            edit.putBoolean("has_shown_pb_guide", true);
                                                            edit.commit();
                                                            btVar36 = this.a.D;
                                                            btVar36.p();
                                                            return;
                                                        } else if (id3 != com.baidu.tieba.v.pb_head_reverse_hint) {
                                                            return;
                                                        } else {
                                                            this.a.D();
                                                            btVar34 = this.a.D;
                                                            btVar34.ad();
                                                            bmVar9 = this.a.x;
                                                            bmVar9.y();
                                                            btVar35 = this.a.D;
                                                            btVar35.u();
                                                            return;
                                                        }
                                                    } else {
                                                        SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                        if (((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                            btVar46 = this.a.D;
                                                            btVar46.a(view);
                                                            return;
                                                        }
                                                        btVar45 = this.a.D;
                                                        btVar45.a(((Integer) sparseArray10.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    }
                                                }
                                                this.a.s();
                                                return;
                                            }
                                            this.a.a(view);
                                            iVar7 = this.a.G;
                                            iVar7.dismiss();
                                            return;
                                        }
                                        this.a.D();
                                        bmVar24 = this.a.x;
                                        bmVar24.x();
                                        btVar56 = this.a.D;
                                        btVar56.u();
                                        TiebaStatic.eventStat(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    this.a.k();
                                    return;
                                }
                                TiebaStatic.eventStat(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bmVar25 = this.a.x;
                                String name3 = bmVar25.r().b().getName();
                                bmVar26 = this.a.x;
                                if (!TextUtils.isEmpty(bmVar26.f())) {
                                    bmVar27 = this.a.x;
                                    if (bmVar27.f().equals(name3)) {
                                        this.a.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.bm.b(name3)) {
                                    this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(this.a).a(name3, "tb_pb")));
                                    return;
                                }
                                return;
                            }
                            iVar8 = this.a.G;
                            if (iVar8 != null) {
                                com.baidu.tieba.data.am amVar4 = null;
                                if (view != null && view.getTag() != null) {
                                    amVar4 = (com.baidu.tieba.data.am) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board);
                                    SparseArray sparseArray11 = new SparseArray();
                                    sparseArray11.put(com.baidu.tieba.v.tag_clip_board, amVar4);
                                    sparseArray11.put(com.baidu.tieba.v.tag_is_subpb, false);
                                    bsVar35 = this.a.H;
                                    bsVar35.c().setTag(sparseArray11);
                                }
                                bmVar28 = this.a.x;
                                if (bmVar28.r().h()) {
                                    bmVar29 = this.a.x;
                                    String i3 = bmVar29.r().i();
                                    if (amVar4 != null && !com.baidu.adp.lib.util.i.b(i3) && i3.equals(amVar4.l())) {
                                        z = true;
                                        if (TbadkApplication.m252getInst().getSkinType() != 1) {
                                            if (z) {
                                                bsVar33 = this.a.H;
                                                bsVar33.c().setText(com.baidu.tieba.y.marked);
                                                bsVar34 = this.a.H;
                                                bsVar34.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s_1, 0, 0, 0);
                                            } else {
                                                bsVar31 = this.a.H;
                                                bsVar31.c().setText(com.baidu.tieba.y.mark);
                                                bsVar32 = this.a.H;
                                                bsVar32.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n_1, 0, 0, 0);
                                            }
                                        } else if (z) {
                                            bsVar27 = this.a.H;
                                            bsVar27.c().setText(com.baidu.tieba.y.marked);
                                            bsVar28 = this.a.H;
                                            bsVar28.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s, 0, 0, 0);
                                        } else {
                                            bsVar25 = this.a.H;
                                            bsVar25.c().setText(com.baidu.tieba.y.mark);
                                            bsVar26 = this.a.H;
                                            bsVar26.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n, 0, 0, 0);
                                        }
                                        bsVar29 = this.a.H;
                                        bsVar29.e().setVisibility(8);
                                        bsVar30 = this.a.H;
                                        bsVar30.a(false);
                                        iVar9 = this.a.G;
                                        iVar9.a();
                                        iVar10 = this.a.G;
                                        iVar10.a(view, false);
                                        return;
                                    }
                                }
                                z = false;
                                if (TbadkApplication.m252getInst().getSkinType() != 1) {
                                }
                                bsVar29 = this.a.H;
                                bsVar29.e().setVisibility(8);
                                bsVar30 = this.a.H;
                                bsVar30.a(false);
                                iVar9 = this.a.G;
                                iVar9.a();
                                iVar10 = this.a.G;
                                iVar10.a(view, false);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        btVar4 = this.a.D;
        btVar4.ae();
        bmVar = this.a.x;
        if (bmVar.r().k() == 1) {
            tVar = this.a.C;
            if (!tVar.b()) {
                btVar5 = this.a.D;
                btVar5.o();
                int i4 = 0;
                btVar6 = this.a.D;
                if (view != btVar6.V()) {
                    btVar7 = this.a.D;
                    if (view != btVar7.W()) {
                        btVar8 = this.a.D;
                        if (view != btVar8.X()) {
                            btVar9 = this.a.D;
                            if (view != btVar9.Y()) {
                                btVar10 = this.a.D;
                                if (view == btVar10.r()) {
                                    i4 = 2;
                                }
                            } else {
                                i4 = 5;
                            }
                        } else {
                            i4 = 4;
                        }
                    } else {
                        i4 = 3;
                    }
                } else {
                    i4 = 6;
                }
                bmVar2 = this.a.x;
                ForumData b3 = bmVar2.r().b();
                String name4 = b3.getName();
                String id4 = b3.getId();
                bmVar3 = this.a.x;
                String p = bmVar3.r().c().p();
                tVar2 = this.a.C;
                btVar11 = this.a.D;
                tVar2.a(id4, name4, p, i4, btVar11.s());
            }
        }
    }
}
