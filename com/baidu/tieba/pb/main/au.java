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
class au implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0445  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bc bcVar;
        com.baidu.tieba.model.v vVar;
        bj bjVar5;
        bj bjVar6;
        bj bjVar7;
        bj bjVar8;
        bj bjVar9;
        bj bjVar10;
        bc bcVar2;
        bc bcVar3;
        com.baidu.tieba.model.v vVar2;
        bj bjVar11;
        bj bjVar12;
        bj bjVar13;
        bj bjVar14;
        bj bjVar15;
        bj bjVar16;
        bj bjVar17;
        bj bjVar18;
        bj bjVar19;
        bj bjVar20;
        bj bjVar21;
        bj bjVar22;
        bj bjVar23;
        bj bjVar24;
        bj bjVar25;
        bj bjVar26;
        bj bjVar27;
        bj bjVar28;
        bj bjVar29;
        bi biVar;
        bj bjVar30;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bc bcVar4;
        bj bjVar31;
        bc bcVar5;
        com.baidu.tieba.pb.sub.f fVar;
        bc bcVar6;
        com.baidu.tieba.pb.sub.f fVar2;
        com.baidu.tieba.pb.sub.f fVar3;
        bi biVar5;
        Handler handler;
        bj bjVar32;
        bc bcVar7;
        com.baidu.tbadk.core.view.i iVar;
        bj bjVar33;
        bc bcVar8;
        bi biVar6;
        com.baidu.tbadk.core.view.i iVar2;
        bj bjVar34;
        bj bjVar35;
        bc bcVar9;
        bj bjVar36;
        bj bjVar37;
        com.baidu.tieba.pb.sub.f fVar4;
        bj bjVar38;
        bc bcVar10;
        bj bjVar39;
        com.baidu.tieba.pb.sub.f fVar5;
        com.baidu.tieba.pb.sub.f fVar6;
        bj bjVar40;
        com.baidu.tbadk.core.view.i iVar3;
        bc bcVar11;
        bi biVar7;
        bi biVar8;
        bi biVar9;
        bi biVar10;
        bi biVar11;
        com.baidu.tbadk.core.view.i iVar4;
        com.baidu.tbadk.core.view.i iVar5;
        bi biVar12;
        bi biVar13;
        bi biVar14;
        bi biVar15;
        bc bcVar12;
        bi biVar16;
        bi biVar17;
        bi biVar18;
        bi biVar19;
        bi biVar20;
        bi biVar21;
        bi biVar22;
        bi biVar23;
        bi biVar24;
        bj bjVar41;
        bj bjVar42;
        bj bjVar43;
        bc bcVar13;
        bj bjVar44;
        bj bjVar45;
        bj bjVar46;
        bj bjVar47;
        bj bjVar48;
        com.baidu.tbadk.core.view.i iVar6;
        bj bjVar49;
        com.baidu.tbadk.core.view.i iVar7;
        bj bjVar50;
        bc bcVar14;
        bj bjVar51;
        bj bjVar52;
        bc bcVar15;
        bj bjVar53;
        bc bcVar16;
        bj bjVar54;
        bj bjVar55;
        boolean b;
        bc bcVar17;
        bj bjVar56;
        bc bcVar18;
        bc bcVar19;
        bc bcVar20;
        bc bcVar21;
        bc bcVar22;
        bj bjVar57;
        bc bcVar23;
        bc bcVar24;
        bj bjVar58;
        com.baidu.tieba.pb.sub.f fVar7;
        com.baidu.tieba.pb.sub.f fVar8;
        com.baidu.tieba.pb.sub.f fVar9;
        com.baidu.tieba.pb.sub.f fVar10;
        bj bjVar59;
        com.baidu.tbadk.core.view.i iVar8;
        bc bcVar25;
        boolean z;
        bi biVar25;
        bi biVar26;
        bi biVar27;
        bi biVar28;
        bi biVar29;
        bi biVar30;
        com.baidu.tbadk.core.view.i iVar9;
        com.baidu.tbadk.core.view.i iVar10;
        bi biVar31;
        bi biVar32;
        bi biVar33;
        bi biVar34;
        bc bcVar26;
        bi biVar35;
        bj bjVar60;
        com.baidu.tieba.model.v vVar3;
        bj bjVar61;
        bc bcVar27;
        com.baidu.tieba.model.v vVar4;
        bc bcVar28;
        bc bcVar29;
        bc bcVar30;
        com.baidu.tieba.pb.sub.f fVar11;
        com.baidu.tieba.pb.sub.f fVar12;
        com.baidu.tieba.pb.sub.f fVar13;
        com.baidu.tieba.pb.sub.f fVar14;
        com.baidu.tieba.model.v vVar5;
        com.baidu.tieba.pb.sub.f fVar15;
        com.baidu.tieba.pb.sub.f fVar16;
        com.baidu.tieba.pb.sub.f fVar17;
        bc bcVar31;
        bc bcVar32;
        bj bjVar62;
        bc bcVar33;
        bc bcVar34;
        bj bjVar63;
        bjVar = this.a.E;
        if (view == bjVar.Q()) {
            bcVar34 = this.a.y;
            if (bcVar34.a(true)) {
                bjVar63 = this.a.E;
                bjVar63.v();
                return;
            }
            return;
        }
        bjVar2 = this.a.E;
        if (view == bjVar2.k) {
            bjVar62 = this.a.E;
            bcVar33 = this.a.y;
            if (!bjVar62.f(bcVar33.m())) {
                this.a.closeActivity();
                return;
            } else {
                this.a.C();
                return;
            }
        }
        bjVar3 = this.a.E;
        if (view != bjVar3.U()) {
            bjVar12 = this.a.E;
            if (view != bjVar12.V()) {
                bjVar13 = this.a.E;
                if (view != bjVar13.W()) {
                    bjVar14 = this.a.E;
                    if (view != bjVar14.X()) {
                        bjVar15 = this.a.E;
                        if (view != bjVar15.q()) {
                            bjVar16 = this.a.E;
                            if (view == bjVar16.ah()) {
                                bcVar31 = this.a.y;
                                if (bcVar31 != null) {
                                    bcVar32 = this.a.y;
                                    com.baidu.tbadk.browser.a.a(this.a, bcVar32.p().d().s().c());
                                    return;
                                }
                                return;
                            }
                            bjVar17 = this.a.E;
                            if (view == bjVar17.p()) {
                                bjVar60 = this.a.E;
                                bjVar60.ad();
                                String currentAccount = TbadkApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    vVar3 = this.a.D;
                                    if (!vVar3.b()) {
                                        bjVar61 = this.a.E;
                                        bjVar61.n();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.r.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.r.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.r.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.r.tag_del_post_type)).intValue();
                                            bcVar27 = this.a.y;
                                            if (bcVar27.m()) {
                                                fVar11 = this.a.C;
                                                if (fVar11 != null) {
                                                    fVar12 = this.a.C;
                                                    if (fVar12.e() != null) {
                                                        fVar13 = this.a.C;
                                                        if (fVar13.e().h() != null) {
                                                            fVar14 = this.a.C;
                                                            if (fVar14.e().m() != null) {
                                                                vVar5 = this.a.D;
                                                                fVar15 = this.a.C;
                                                                String id = fVar15.e().h().getId();
                                                                fVar16 = this.a.C;
                                                                String name = fVar16.e().h().getName();
                                                                fVar17 = this.a.C;
                                                                vVar5.a(id, name, fVar17.e().m().k(), str, intValue2, intValue, booleanValue);
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
                                            vVar4 = this.a.D;
                                            bcVar28 = this.a.y;
                                            String id2 = bcVar28.p().c().getId();
                                            bcVar29 = this.a.y;
                                            String name2 = bcVar29.p().c().getName();
                                            bcVar30 = this.a.y;
                                            vVar4.a(id2, name2, bcVar30.p().d().k(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.u.login_to_use), true, 11017);
                                return;
                            }
                            bjVar18 = this.a.E;
                            if (view != bjVar18.Y()) {
                                bjVar19 = this.a.E;
                                if (view == bjVar19.s()) {
                                    fVar10 = this.a.C;
                                    if (fVar10.h()) {
                                        bjVar59 = this.a.E;
                                        bjVar59.B();
                                        return;
                                    }
                                    return;
                                }
                                bjVar20 = this.a.E;
                                if (view == bjVar20.k()) {
                                    fVar7 = this.a.C;
                                    if (fVar7 != null) {
                                        fVar8 = this.a.C;
                                        if (fVar8.a() != null) {
                                            PbActivity pbActivity = this.a;
                                            com.baidu.tbadk.core.atomData.as asVar = new com.baidu.tbadk.core.atomData.as(this.a);
                                            fVar9 = this.a.C;
                                            pbActivity.sendMessage(new CustomMessage(2006001, asVar.a(fVar9.a(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bjVar21 = this.a.E;
                                if (view == bjVar21.c) {
                                    bjVar58 = this.a.E;
                                    bjVar58.m();
                                    this.a.closeActivity();
                                    return;
                                }
                                bjVar22 = this.a.E;
                                if (view != bjVar22.e) {
                                    bjVar23 = this.a.E;
                                    if (view != bjVar23.g) {
                                        bjVar24 = this.a.E;
                                        if (view != bjVar24.f) {
                                            bjVar25 = this.a.E;
                                            if (view == bjVar25.h) {
                                                bcVar18 = this.a.y;
                                                AdditionData n = bcVar18.p().n();
                                                if (!TextUtils.isEmpty(n.getWarnMsg())) {
                                                    com.baidu.adp.lib.util.h.a((Context) this.a, n.getWarnMsg());
                                                    return;
                                                } else if (n.getAlreadyCount() != n.getTotalCount()) {
                                                    bcVar19 = this.a.y;
                                                    ForumData c = bcVar19.p().c();
                                                    bcVar20 = this.a.y;
                                                    com.baidu.tbadk.core.data.o d = bcVar20.p().d();
                                                    bcVar21 = this.a.y;
                                                    AntiData g = bcVar21.p().g();
                                                    if (d.k() != null) {
                                                        if (g != null && g.getIfpost() == 0) {
                                                            com.baidu.adp.lib.util.h.a((Context) this.a, g.getForbid_info());
                                                            return;
                                                        } else {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bh(this.a, 2, c.getId(), c.getName(), d.k(), n.getPostId(), 0, g, 13008, false, false, null, false, false, null, n, null)));
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else {
                                                    com.baidu.adp.lib.util.h.a((Context) this.a, String.format(this.a.getString(com.baidu.tieba.u.write_addition_limit), Integer.valueOf(n.getTotalCount())));
                                                    return;
                                                }
                                            }
                                            bjVar26 = this.a.E;
                                            if (view == bjVar26.g().b()) {
                                                bjVar55 = this.a.E;
                                                bjVar55.ac();
                                                b = this.a.b(11009);
                                                if (b) {
                                                    bcVar17 = this.a.y;
                                                    bjVar56 = this.a.E;
                                                    if (bcVar17.f(bjVar56.K()) == null) {
                                                        return;
                                                    }
                                                    this.a.y();
                                                    return;
                                                }
                                                return;
                                            }
                                            bjVar27 = this.a.E;
                                            if (view == bjVar27.g().c()) {
                                                bjVar54 = this.a.E;
                                                bjVar54.ac();
                                                this.a.C();
                                                this.a.D();
                                                return;
                                            }
                                            bjVar28 = this.a.E;
                                            if (view == bjVar28.g().e()) {
                                                bjVar52 = this.a.E;
                                                bjVar52.ac();
                                                bcVar15 = this.a.y;
                                                if (bcVar15.q() != null) {
                                                    bjVar53 = this.a.E;
                                                    bcVar16 = this.a.y;
                                                    bjVar53.a(bcVar16.q());
                                                }
                                                TiebaStatic.eventStat(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            bjVar29 = this.a.E;
                                            if (view == bjVar29.g().f()) {
                                                bjVar50 = this.a.E;
                                                bjVar50.ac();
                                                this.a.C();
                                                bcVar14 = this.a.y;
                                                bcVar14.v();
                                                bjVar51 = this.a.E;
                                                bjVar51.t();
                                                TiebaStatic.eventStat(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            biVar = this.a.I;
                                            if (view != biVar.c()) {
                                                bjVar30 = this.a.E;
                                                if (bjVar30.c() != view) {
                                                    biVar2 = this.a.I;
                                                    if (view == biVar2.e()) {
                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                        if (sparseArray2 != null) {
                                                            if ("".equals(sparseArray2.get(com.baidu.tieba.r.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.r.tag_del_post_id))) {
                                                                bjVar48 = this.a.E;
                                                                bjVar48.a(((Integer) sparseArray2.get(com.baidu.tieba.r.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.r.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.r.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.r.tag_del_post_is_self)).booleanValue());
                                                            } else {
                                                                bjVar49 = this.a.E;
                                                                bjVar49.a(view);
                                                            }
                                                            iVar6 = this.a.H;
                                                            iVar6.dismiss();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != com.baidu.tieba.r.pb_head_function_manage_delormanage) {
                                                        biVar3 = this.a.I;
                                                        if (view == biVar3.d() || view.getId() == com.baidu.tieba.r.sub_pb_more || view.getId() == com.baidu.tieba.r.sub_pb_item) {
                                                            biVar4 = this.a.I;
                                                            if (view == biVar4.d()) {
                                                                biVar6 = this.a.I;
                                                                if (!biVar6.a()) {
                                                                    iVar2 = this.a.H;
                                                                    iVar2.dismiss();
                                                                    bjVar34 = this.a.E;
                                                                    bjVar34.b(true);
                                                                    return;
                                                                }
                                                            }
                                                            try {
                                                                bcVar4 = this.a.y;
                                                                if (bcVar4.p() != null) {
                                                                    bjVar31 = this.a.E;
                                                                    bjVar31.ac();
                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                    com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) sparseArray3.get(com.baidu.tieba.r.tag_load_sub_data);
                                                                    View view2 = (View) sparseArray3.get(com.baidu.tieba.r.tag_load_sub_view);
                                                                    if (ahVar != null && view2 != null) {
                                                                        bcVar5 = this.a.y;
                                                                        com.baidu.tieba.data.ao a = bcVar5.a(ahVar);
                                                                        fVar = this.a.C;
                                                                        bcVar6 = this.a.y;
                                                                        fVar.a(bcVar6.f());
                                                                        fVar2 = this.a.C;
                                                                        fVar2.b(ahVar.d());
                                                                        fVar3 = this.a.C;
                                                                        fVar3.d();
                                                                        this.a.C();
                                                                        biVar5 = this.a.I;
                                                                        if (view == biVar5.d()) {
                                                                            iVar = this.a.H;
                                                                            iVar.dismiss();
                                                                            bjVar33 = this.a.E;
                                                                            bcVar8 = this.a.y;
                                                                            bjVar33.a(true, a, false, null, null, view2, bcVar8.p().l());
                                                                            return;
                                                                        } else if (view.getId() != com.baidu.tieba.r.sub_pb_item) {
                                                                            handler = this.a.x;
                                                                            handler.post(new av(this, a, view2));
                                                                            return;
                                                                        } else {
                                                                            SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                            String str2 = (String) sparseArray4.get(com.baidu.tieba.r.tag_photo_username);
                                                                            com.baidu.tieba.data.ah ahVar2 = (com.baidu.tieba.data.ah) sparseArray4.get(com.baidu.tieba.r.tag_clip_board);
                                                                            String str3 = null;
                                                                            if (ahVar2 != null) {
                                                                                str3 = ahVar2.d();
                                                                            }
                                                                            bjVar32 = this.a.E;
                                                                            bcVar7 = this.a.y;
                                                                            bjVar32.a(true, a, false, str2, str3, view2, bcVar7.p().l());
                                                                            return;
                                                                        }
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            } catch (Exception e) {
                                                                BdLog.e(getClass().getName(), "onClick", e.toString());
                                                                return;
                                                            }
                                                        }
                                                        int id3 = view.getId();
                                                        if (id3 == com.baidu.tieba.r.dialog_button_ok) {
                                                            bjVar42 = this.a.E;
                                                            bjVar42.ac();
                                                            bjVar43 = this.a.E;
                                                            if (bjVar43.L() < 0) {
                                                                return;
                                                            }
                                                            this.a.C();
                                                            bcVar13 = this.a.y;
                                                            bjVar44 = this.a.E;
                                                            bcVar13.c(bjVar44.L());
                                                            bjVar45 = this.a.E;
                                                            bjVar45.t();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.r.dialog_button_cancel) {
                                                            bjVar41 = this.a.E;
                                                            bjVar41.ac();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.r.reply) {
                                                            iVar3 = this.a.H;
                                                            if (iVar3 != null) {
                                                                com.baidu.tieba.data.ah ahVar3 = null;
                                                                if (view != null && view.getTag() != null) {
                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                    ahVar3 = (com.baidu.tieba.data.ah) sparseArray5.get(com.baidu.tieba.r.tag_load_sub_data);
                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                    sparseArray6.put(com.baidu.tieba.r.tag_load_sub_data, ahVar3);
                                                                    sparseArray6.put(com.baidu.tieba.r.tag_load_sub_view, (View) sparseArray5.get(com.baidu.tieba.r.tag_load_sub_view));
                                                                    biVar16 = this.a.I;
                                                                    biVar16.d().setTag(sparseArray6);
                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                    sparseArray7.put(com.baidu.tieba.r.tag_clip_board, (com.baidu.tieba.data.ah) ((SparseArray) view.getTag()).get(com.baidu.tieba.r.tag_clip_board));
                                                                    sparseArray7.put(com.baidu.tieba.r.tag_is_subpb, false);
                                                                    biVar17 = this.a.I;
                                                                    biVar17.c().setTag(sparseArray7);
                                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                    if (!((Boolean) sparseArray8.get(com.baidu.tieba.r.tag_should_manage_visible)).booleanValue()) {
                                                                        biVar18 = this.a.I;
                                                                        biVar18.e().setVisibility(8);
                                                                    } else {
                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                        sparseArray9.put(com.baidu.tieba.r.tag_manage_user_identity, sparseArray8.get(com.baidu.tieba.r.tag_manage_user_identity));
                                                                        sparseArray9.put(com.baidu.tieba.r.tag_del_post_is_self, sparseArray8.get(com.baidu.tieba.r.tag_del_post_is_self));
                                                                        sparseArray9.put(com.baidu.tieba.r.tag_del_post_id, sparseArray8.get(com.baidu.tieba.r.tag_del_post_id));
                                                                        sparseArray9.put(com.baidu.tieba.r.tag_del_post_type, sparseArray8.get(com.baidu.tieba.r.tag_del_post_type));
                                                                        sparseArray9.put(com.baidu.tieba.r.tag_forbid_user_name, sparseArray8.get(com.baidu.tieba.r.tag_forbid_user_name));
                                                                        biVar19 = this.a.I;
                                                                        biVar19.e().setTag(sparseArray9);
                                                                        int skinType = TbadkApplication.m252getInst().getSkinType();
                                                                        if (!"".equals(sparseArray8.get(com.baidu.tieba.r.tag_forbid_user_name)) && !"".equals(sparseArray8.get(com.baidu.tieba.r.tag_del_post_id))) {
                                                                            if (skinType == 1) {
                                                                                biVar24 = this.a.I;
                                                                                biVar24.e().setImageResource(com.baidu.tieba.q.icon_pb_set_n_1);
                                                                            } else {
                                                                                biVar23 = this.a.I;
                                                                                biVar23.e().setImageResource(com.baidu.tieba.q.icon_pb_set_n);
                                                                            }
                                                                        } else if (skinType == 1) {
                                                                            biVar21 = this.a.I;
                                                                            biVar21.e().setImageResource(com.baidu.tieba.q.icon_pb_del_n_1);
                                                                        } else {
                                                                            biVar20 = this.a.I;
                                                                            biVar20.e().setImageResource(com.baidu.tieba.q.icon_pb_del_n);
                                                                        }
                                                                        biVar22 = this.a.I;
                                                                        biVar22.e().setVisibility(0);
                                                                    }
                                                                }
                                                                boolean z2 = false;
                                                                bcVar11 = this.a.y;
                                                                if (bcVar11.p().i()) {
                                                                    bcVar12 = this.a.y;
                                                                    String j = bcVar12.p().j();
                                                                    if (ahVar3 != null && !com.baidu.adp.lib.util.g.b(j) && j.equals(ahVar3.d())) {
                                                                        z2 = true;
                                                                    }
                                                                }
                                                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                                                    if (z2) {
                                                                        biVar14 = this.a.I;
                                                                        biVar14.c().setText(com.baidu.tieba.u.marked);
                                                                        biVar15 = this.a.I;
                                                                        biVar15.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_s_1, 0, 0, 0);
                                                                    } else {
                                                                        biVar12 = this.a.I;
                                                                        biVar12.c().setText(com.baidu.tieba.u.mark);
                                                                        biVar13 = this.a.I;
                                                                        biVar13.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_n_1, 0, 0, 0);
                                                                    }
                                                                } else if (z2) {
                                                                    biVar9 = this.a.I;
                                                                    biVar9.c().setText(com.baidu.tieba.u.marked);
                                                                    biVar10 = this.a.I;
                                                                    biVar10.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_s, 0, 0, 0);
                                                                } else {
                                                                    biVar7 = this.a.I;
                                                                    biVar7.c().setText(com.baidu.tieba.u.mark);
                                                                    biVar8 = this.a.I;
                                                                    biVar8.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_n, 0, 0, 0);
                                                                }
                                                                biVar11 = this.a.I;
                                                                biVar11.a(true);
                                                                iVar4 = this.a.H;
                                                                iVar4.a();
                                                                iVar5 = this.a.H;
                                                                iVar5.a(view, false);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.r.sub_post_load_more) {
                                                            fVar6 = this.a.C;
                                                            if (fVar6.h()) {
                                                                bjVar40 = this.a.E;
                                                                bjVar40.B();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.r.sub_pb_bottom_layout) {
                                                            bcVar10 = this.a.y;
                                                            if (bcVar10.m()) {
                                                                this.a.closeActivity();
                                                                return;
                                                            }
                                                            this.a.C();
                                                            bjVar39 = this.a.E;
                                                            bjVar39.E();
                                                            fVar5 = this.a.C;
                                                            fVar5.cancelLoadData();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.r.btn_loadprevious) {
                                                            fVar4 = this.a.C;
                                                            if (fVar4.k()) {
                                                                bjVar38 = this.a.E;
                                                                bjVar38.C();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.r.pb_new_guide) {
                                                            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                            edit.putBoolean("has_shown_pb_guide", true);
                                                            edit.commit();
                                                            bjVar37 = this.a.E;
                                                            bjVar37.o();
                                                            return;
                                                        } else if (id3 != com.baidu.tieba.r.pb_head_reverse_hint) {
                                                            return;
                                                        } else {
                                                            this.a.C();
                                                            bjVar35 = this.a.E;
                                                            bjVar35.ac();
                                                            bcVar9 = this.a.y;
                                                            bcVar9.v();
                                                            bjVar36 = this.a.E;
                                                            bjVar36.t();
                                                            return;
                                                        }
                                                    } else {
                                                        SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                        if (((Boolean) sparseArray10.get(com.baidu.tieba.r.tag_should_manage_visible)).booleanValue()) {
                                                            bjVar47 = this.a.E;
                                                            bjVar47.a(view);
                                                            return;
                                                        }
                                                        bjVar46 = this.a.E;
                                                        bjVar46.a(((Integer) sparseArray10.get(com.baidu.tieba.r.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.r.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.r.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.r.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    }
                                                }
                                                this.a.r();
                                                return;
                                            }
                                            this.a.a(view);
                                            iVar7 = this.a.H;
                                            iVar7.dismiss();
                                            return;
                                        }
                                        this.a.C();
                                        bcVar22 = this.a.y;
                                        bcVar22.u();
                                        bjVar57 = this.a.E;
                                        bjVar57.t();
                                        TiebaStatic.eventStat(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    this.a.k();
                                    return;
                                }
                                TiebaStatic.eventStat(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bcVar23 = this.a.y;
                                if (!bcVar23.i()) {
                                    bcVar24 = this.a.y;
                                    String name3 = bcVar24.p().c().getName();
                                    if (com.baidu.tbadk.core.util.be.b(name3)) {
                                        this.a.sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.a).a(name3, "tb_pb")));
                                        return;
                                    }
                                    return;
                                }
                                this.a.finish();
                                return;
                            }
                            iVar8 = this.a.H;
                            if (iVar8 != null) {
                                com.baidu.tieba.data.ah ahVar4 = null;
                                if (view != null && view.getTag() != null) {
                                    ahVar4 = (com.baidu.tieba.data.ah) ((SparseArray) view.getTag()).get(com.baidu.tieba.r.tag_clip_board);
                                    SparseArray sparseArray11 = new SparseArray();
                                    sparseArray11.put(com.baidu.tieba.r.tag_clip_board, ahVar4);
                                    sparseArray11.put(com.baidu.tieba.r.tag_is_subpb, false);
                                    biVar35 = this.a.I;
                                    biVar35.c().setTag(sparseArray11);
                                }
                                bcVar25 = this.a.y;
                                if (bcVar25.p().i()) {
                                    bcVar26 = this.a.y;
                                    String j2 = bcVar26.p().j();
                                    if (ahVar4 != null && !com.baidu.adp.lib.util.g.b(j2) && j2.equals(ahVar4.d())) {
                                        z = true;
                                        if (TbadkApplication.m252getInst().getSkinType() != 1) {
                                            if (z) {
                                                biVar33 = this.a.I;
                                                biVar33.c().setText(com.baidu.tieba.u.marked);
                                                biVar34 = this.a.I;
                                                biVar34.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_s_1, 0, 0, 0);
                                            } else {
                                                biVar31 = this.a.I;
                                                biVar31.c().setText(com.baidu.tieba.u.mark);
                                                biVar32 = this.a.I;
                                                biVar32.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_n_1, 0, 0, 0);
                                            }
                                        } else if (z) {
                                            biVar27 = this.a.I;
                                            biVar27.c().setText(com.baidu.tieba.u.marked);
                                            biVar28 = this.a.I;
                                            biVar28.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_s, 0, 0, 0);
                                        } else {
                                            biVar25 = this.a.I;
                                            biVar25.c().setText(com.baidu.tieba.u.mark);
                                            biVar26 = this.a.I;
                                            biVar26.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.q.icon_pb_collect_n, 0, 0, 0);
                                        }
                                        biVar29 = this.a.I;
                                        biVar29.e().setVisibility(8);
                                        biVar30 = this.a.I;
                                        biVar30.a(false);
                                        iVar9 = this.a.H;
                                        iVar9.a();
                                        iVar10 = this.a.H;
                                        iVar10.a(view, false);
                                        return;
                                    }
                                }
                                z = false;
                                if (TbadkApplication.m252getInst().getSkinType() != 1) {
                                }
                                biVar29 = this.a.I;
                                biVar29.e().setVisibility(8);
                                biVar30 = this.a.I;
                                biVar30.a(false);
                                iVar9 = this.a.H;
                                iVar9.a();
                                iVar10 = this.a.H;
                                iVar10.a(view, false);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        bjVar4 = this.a.E;
        bjVar4.ad();
        bcVar = this.a.y;
        if (bcVar.p().l() == 1) {
            vVar = this.a.D;
            if (!vVar.b()) {
                bjVar5 = this.a.E;
                bjVar5.n();
                int i = 0;
                bjVar6 = this.a.E;
                if (view != bjVar6.U()) {
                    bjVar7 = this.a.E;
                    if (view != bjVar7.V()) {
                        bjVar8 = this.a.E;
                        if (view != bjVar8.W()) {
                            bjVar9 = this.a.E;
                            if (view != bjVar9.X()) {
                                bjVar10 = this.a.E;
                                if (view == bjVar10.q()) {
                                    i = 2;
                                }
                            } else {
                                i = 5;
                            }
                        } else {
                            i = 4;
                        }
                    } else {
                        i = 3;
                    }
                } else {
                    i = 6;
                }
                bcVar2 = this.a.y;
                ForumData c2 = bcVar2.p().c();
                String name4 = c2.getName();
                String id4 = c2.getId();
                bcVar3 = this.a.y;
                String k = bcVar3.p().d().k();
                vVar2 = this.a.D;
                bjVar11 = this.a.E;
                vVar2.a(id4, name4, k, i, bjVar11.r());
            }
        }
    }
}
