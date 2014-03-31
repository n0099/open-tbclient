package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
final class at implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0422  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bd bdVar;
        com.baidu.tieba.model.v vVar;
        bk bkVar5;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        bk bkVar10;
        bd bdVar2;
        bd bdVar3;
        com.baidu.tieba.model.v vVar2;
        bk bkVar11;
        bk bkVar12;
        bk bkVar13;
        bk bkVar14;
        bk bkVar15;
        bk bkVar16;
        bk bkVar17;
        bk bkVar18;
        bk bkVar19;
        bk bkVar20;
        bk bkVar21;
        bk bkVar22;
        bk bkVar23;
        bk bkVar24;
        bk bkVar25;
        bk bkVar26;
        bk bkVar27;
        bk bkVar28;
        bk bkVar29;
        bj bjVar;
        bk bkVar30;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bd bdVar4;
        bk bkVar31;
        bd bdVar5;
        com.baidu.tieba.pb.sub.f fVar;
        bd bdVar6;
        com.baidu.tieba.pb.sub.f fVar2;
        com.baidu.tieba.pb.sub.f fVar3;
        bj bjVar5;
        Handler handler;
        bk bkVar32;
        bd bdVar7;
        com.baidu.tbadk.core.view.i iVar;
        bk bkVar33;
        bd bdVar8;
        bj bjVar6;
        com.baidu.tbadk.core.view.i iVar2;
        bk bkVar34;
        bk bkVar35;
        bd bdVar9;
        bk bkVar36;
        bk bkVar37;
        com.baidu.tieba.pb.sub.f fVar4;
        bk bkVar38;
        bd bdVar10;
        bk bkVar39;
        com.baidu.tieba.pb.sub.f fVar5;
        com.baidu.tieba.pb.sub.f fVar6;
        bk bkVar40;
        com.baidu.tbadk.core.view.i iVar3;
        bd bdVar11;
        bj bjVar7;
        bj bjVar8;
        bj bjVar9;
        com.baidu.tbadk.core.view.i iVar4;
        com.baidu.tbadk.core.view.i iVar5;
        bj bjVar10;
        bj bjVar11;
        bd bdVar12;
        bj bjVar12;
        bj bjVar13;
        bj bjVar14;
        bj bjVar15;
        bj bjVar16;
        bj bjVar17;
        bj bjVar18;
        bj bjVar19;
        bj bjVar20;
        bk bkVar41;
        bk bkVar42;
        bk bkVar43;
        bd bdVar13;
        bk bkVar44;
        bk bkVar45;
        bk bkVar46;
        bk bkVar47;
        bk bkVar48;
        com.baidu.tbadk.core.view.i iVar6;
        bk bkVar49;
        com.baidu.tbadk.core.view.i iVar7;
        bk bkVar50;
        bd bdVar14;
        bk bkVar51;
        bk bkVar52;
        bd bdVar15;
        bk bkVar53;
        bd bdVar16;
        bk bkVar54;
        bk bkVar55;
        boolean a;
        bd bdVar17;
        bk bkVar56;
        bd bdVar18;
        bd bdVar19;
        bd bdVar20;
        bd bdVar21;
        bd bdVar22;
        bk bkVar57;
        bd bdVar23;
        bd bdVar24;
        bk bkVar58;
        com.baidu.tieba.pb.sub.f fVar7;
        com.baidu.tieba.pb.sub.f fVar8;
        com.baidu.tieba.pb.sub.f fVar9;
        com.baidu.tieba.pb.sub.f fVar10;
        bk bkVar59;
        com.baidu.tbadk.core.view.i iVar8;
        bd bdVar25;
        boolean z;
        bj bjVar21;
        bj bjVar22;
        bj bjVar23;
        bj bjVar24;
        com.baidu.tbadk.core.view.i iVar9;
        com.baidu.tbadk.core.view.i iVar10;
        bj bjVar25;
        bj bjVar26;
        bd bdVar26;
        bj bjVar27;
        bk bkVar60;
        com.baidu.tieba.model.v vVar3;
        bk bkVar61;
        bd bdVar27;
        com.baidu.tieba.model.v vVar4;
        bd bdVar28;
        bd bdVar29;
        bd bdVar30;
        com.baidu.tieba.pb.sub.f fVar11;
        com.baidu.tieba.pb.sub.f fVar12;
        com.baidu.tieba.pb.sub.f fVar13;
        com.baidu.tieba.pb.sub.f fVar14;
        com.baidu.tieba.model.v vVar5;
        com.baidu.tieba.pb.sub.f fVar15;
        com.baidu.tieba.pb.sub.f fVar16;
        com.baidu.tieba.pb.sub.f fVar17;
        bd bdVar31;
        bd bdVar32;
        bk bkVar62;
        bd bdVar33;
        bd bdVar34;
        bk bkVar63;
        bkVar = this.a.D;
        if (view == bkVar.Q()) {
            bdVar34 = this.a.x;
            if (bdVar34.a(true)) {
                bkVar63 = this.a.D;
                bkVar63.v();
                return;
            }
            return;
        }
        bkVar2 = this.a.D;
        if (view == bkVar2.k) {
            bkVar62 = this.a.D;
            bdVar33 = this.a.x;
            if (!bkVar62.f(bdVar33.m())) {
                this.a.closeActivity();
                return;
            } else {
                this.a.v();
                return;
            }
        }
        bkVar3 = this.a.D;
        if (view != bkVar3.U()) {
            bkVar12 = this.a.D;
            if (view != bkVar12.V()) {
                bkVar13 = this.a.D;
                if (view != bkVar13.W()) {
                    bkVar14 = this.a.D;
                    if (view != bkVar14.X()) {
                        bkVar15 = this.a.D;
                        if (view != bkVar15.q()) {
                            bkVar16 = this.a.D;
                            if (view == bkVar16.ag()) {
                                bdVar31 = this.a.x;
                                if (bdVar31 != null) {
                                    bdVar32 = this.a.x;
                                    com.baidu.tbadk.browser.a.a(this.a, bdVar32.p().d().s().c());
                                    return;
                                }
                                return;
                            }
                            bkVar17 = this.a.D;
                            if (view == bkVar17.p()) {
                                bkVar60 = this.a.D;
                                bkVar60.ac();
                                String E = TbadkApplication.E();
                                if (E != null && E.length() > 0) {
                                    vVar3 = this.a.C;
                                    if (!vVar3.a()) {
                                        bkVar61 = this.a.D;
                                        bkVar61.n();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.a.h.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_type)).intValue();
                                            bdVar27 = this.a.x;
                                            if (bdVar27.m()) {
                                                fVar11 = this.a.B;
                                                if (fVar11 != null) {
                                                    fVar12 = this.a.B;
                                                    if (fVar12.e() != null) {
                                                        fVar13 = this.a.B;
                                                        if (fVar13.e().g() != null) {
                                                            fVar14 = this.a.B;
                                                            if (fVar14.e().l() != null) {
                                                                vVar5 = this.a.C;
                                                                fVar15 = this.a.B;
                                                                String id = fVar15.e().g().getId();
                                                                fVar16 = this.a.B;
                                                                String name = fVar16.e().g().getName();
                                                                fVar17 = this.a.B;
                                                                vVar5.a(id, name, fVar17.e().l().l(), str, intValue2, intValue, booleanValue);
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
                                            vVar4 = this.a.C;
                                            bdVar28 = this.a.x;
                                            String id2 = bdVar28.p().c().getId();
                                            bdVar29 = this.a.x;
                                            String name2 = bdVar29.p().c().getName();
                                            bdVar30 = this.a.x;
                                            vVar4.a(id2, name2, bdVar30.p().d().l(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.a.k.login_to_use), true, 11017);
                                return;
                            }
                            bkVar18 = this.a.D;
                            if (view != bkVar18.Y()) {
                                bkVar19 = this.a.D;
                                if (view == bkVar19.s()) {
                                    fVar10 = this.a.B;
                                    if (fVar10.h()) {
                                        bkVar59 = this.a.D;
                                        bkVar59.B();
                                        return;
                                    }
                                    return;
                                }
                                bkVar20 = this.a.D;
                                if (view == bkVar20.k()) {
                                    fVar7 = this.a.B;
                                    if (fVar7 != null) {
                                        fVar8 = this.a.B;
                                        if (fVar8.a() != null) {
                                            PbActivity pbActivity = this.a;
                                            com.baidu.tbadk.core.b.af afVar = new com.baidu.tbadk.core.b.af(this.a);
                                            fVar9 = this.a.B;
                                            pbActivity.sendMessage(new com.baidu.adp.framework.message.a(2004001, afVar.a(fVar9.a(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bkVar21 = this.a.D;
                                if (view == bkVar21.c) {
                                    bkVar58 = this.a.D;
                                    bkVar58.m();
                                    this.a.closeActivity();
                                    return;
                                }
                                bkVar22 = this.a.D;
                                if (view != bkVar22.e) {
                                    bkVar23 = this.a.D;
                                    if (view != bkVar23.g) {
                                        bkVar24 = this.a.D;
                                        if (view != bkVar24.f) {
                                            bkVar25 = this.a.D;
                                            if (view == bkVar25.h) {
                                                bdVar18 = this.a.x;
                                                AdditionData n = bdVar18.p().n();
                                                if (!TextUtils.isEmpty(n.getWarnMsg())) {
                                                    com.baidu.adp.lib.util.i.a((Context) this.a, n.getWarnMsg());
                                                    return;
                                                } else if (n.getAlreadyCount() != n.getTotalCount()) {
                                                    bdVar19 = this.a.x;
                                                    ForumData c = bdVar19.p().c();
                                                    bdVar20 = this.a.x;
                                                    com.baidu.tbadk.core.data.o d = bdVar20.p().d();
                                                    bdVar21 = this.a.x;
                                                    AntiData g = bdVar21.p().g();
                                                    if (d.l() != null) {
                                                        if (g != null && g.getIfpost() == 0) {
                                                            com.baidu.adp.lib.util.i.a((Context) this.a, g.getForbid_info());
                                                            return;
                                                        } else {
                                                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.av(this.a, 2, c.getId(), c.getName(), d.l(), n.getPostId(), 0, g, 13008, false, false, null, false, false, null, n, null)));
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else {
                                                    com.baidu.adp.lib.util.i.a((Context) this.a, String.format(this.a.getString(com.baidu.tieba.a.k.write_addition_limit), Integer.valueOf(n.getTotalCount())));
                                                    return;
                                                }
                                            }
                                            bkVar26 = this.a.D;
                                            if (view == bkVar26.g().d()) {
                                                bkVar55 = this.a.D;
                                                bkVar55.ab();
                                                a = this.a.a(11009);
                                                if (a) {
                                                    bdVar17 = this.a.x;
                                                    bkVar56 = this.a.D;
                                                    if (bdVar17.f(bkVar56.K()) == null) {
                                                        return;
                                                    }
                                                    this.a.t();
                                                    return;
                                                }
                                                return;
                                            }
                                            bkVar27 = this.a.D;
                                            if (view != bkVar27.g().e()) {
                                                bkVar28 = this.a.D;
                                                if (view == bkVar28.g().g()) {
                                                    bkVar52 = this.a.D;
                                                    bkVar52.ab();
                                                    bdVar15 = this.a.x;
                                                    if (bdVar15.q() != null) {
                                                        bkVar53 = this.a.D;
                                                        bdVar16 = this.a.x;
                                                        bkVar53.a(bdVar16.q());
                                                    }
                                                    TiebaStatic.a(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    return;
                                                }
                                                bkVar29 = this.a.D;
                                                if (view != bkVar29.g().h()) {
                                                    bjVar = this.a.H;
                                                    if (view != bjVar.e()) {
                                                        bkVar30 = this.a.D;
                                                        if (bkVar30.c() != view) {
                                                            bjVar2 = this.a.H;
                                                            if (view == bjVar2.g()) {
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null) {
                                                                    if ("".equals(sparseArray2.get(com.baidu.tieba.a.h.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_id))) {
                                                                        bkVar48 = this.a.D;
                                                                        bkVar48.a(((Integer) sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.a.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_is_self)).booleanValue());
                                                                    } else {
                                                                        bkVar49 = this.a.D;
                                                                        bkVar49.a(view);
                                                                    }
                                                                    iVar6 = this.a.G;
                                                                    iVar6.dismiss();
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (view.getId() != com.baidu.tieba.a.h.pb_head_function_manage_delormanage) {
                                                                bjVar3 = this.a.H;
                                                                if (view == bjVar3.f() || view.getId() == com.baidu.tieba.a.h.sub_pb_more || view.getId() == com.baidu.tieba.a.h.sub_pb_item) {
                                                                    bjVar4 = this.a.H;
                                                                    if (view == bjVar4.f()) {
                                                                        bjVar6 = this.a.H;
                                                                        if (!bjVar6.a()) {
                                                                            iVar2 = this.a.G;
                                                                            iVar2.dismiss();
                                                                            bkVar34 = this.a.D;
                                                                            bkVar34.b(true);
                                                                            return;
                                                                        }
                                                                    }
                                                                    try {
                                                                        bdVar4 = this.a.x;
                                                                        if (bdVar4.p() != null) {
                                                                            bkVar31 = this.a.D;
                                                                            bkVar31.ab();
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            com.baidu.tieba.data.ai aiVar = (com.baidu.tieba.data.ai) sparseArray3.get(com.baidu.tieba.a.h.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray3.get(com.baidu.tieba.a.h.tag_load_sub_view);
                                                                            if (aiVar != null && view2 != null) {
                                                                                bdVar5 = this.a.x;
                                                                                com.baidu.tieba.data.an a2 = bdVar5.a(aiVar);
                                                                                fVar = this.a.B;
                                                                                bdVar6 = this.a.x;
                                                                                fVar.a(bdVar6.f());
                                                                                fVar2 = this.a.B;
                                                                                fVar2.b(aiVar.d());
                                                                                fVar3 = this.a.B;
                                                                                fVar3.d();
                                                                                this.a.v();
                                                                                bjVar5 = this.a.H;
                                                                                if (view == bjVar5.f()) {
                                                                                    iVar = this.a.G;
                                                                                    iVar.dismiss();
                                                                                    bkVar33 = this.a.D;
                                                                                    bdVar8 = this.a.x;
                                                                                    bkVar33.a(true, a2, null, null, view2, bdVar8.p().l());
                                                                                    return;
                                                                                } else if (view.getId() != com.baidu.tieba.a.h.sub_pb_item) {
                                                                                    handler = this.a.w;
                                                                                    handler.post(new au(this, a2, view2));
                                                                                    return;
                                                                                } else {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    String str2 = (String) sparseArray4.get(com.baidu.tieba.a.h.tag_photo_username);
                                                                                    com.baidu.tieba.data.ai aiVar2 = (com.baidu.tieba.data.ai) sparseArray4.get(com.baidu.tieba.a.h.tag_clip_board);
                                                                                    String str3 = null;
                                                                                    if (aiVar2 != null) {
                                                                                        str3 = aiVar2.d();
                                                                                    }
                                                                                    bkVar32 = this.a.D;
                                                                                    bdVar7 = this.a.x;
                                                                                    bkVar32.a(true, a2, str2, str3, view2, bdVar7.p().l());
                                                                                    return;
                                                                                }
                                                                            }
                                                                            return;
                                                                        }
                                                                        return;
                                                                    } catch (Exception e) {
                                                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e.toString());
                                                                        return;
                                                                    }
                                                                }
                                                                int id3 = view.getId();
                                                                if (id3 == com.baidu.tieba.a.h.dialog_button_ok) {
                                                                    bkVar42 = this.a.D;
                                                                    bkVar42.ab();
                                                                    bkVar43 = this.a.D;
                                                                    if (bkVar43.L() < 0) {
                                                                        return;
                                                                    }
                                                                    this.a.v();
                                                                    bdVar13 = this.a.x;
                                                                    bkVar44 = this.a.D;
                                                                    bdVar13.c(bkVar44.L());
                                                                    bkVar45 = this.a.D;
                                                                    bkVar45.t();
                                                                    return;
                                                                } else if (id3 == com.baidu.tieba.a.h.dialog_button_cancel) {
                                                                    bkVar41 = this.a.D;
                                                                    bkVar41.ab();
                                                                    return;
                                                                } else if (id3 == com.baidu.tieba.a.h.reply) {
                                                                    iVar3 = this.a.G;
                                                                    if (iVar3 != null) {
                                                                        com.baidu.tieba.data.ai aiVar3 = null;
                                                                        if (view != null && view.getTag() != null) {
                                                                            SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                            aiVar3 = (com.baidu.tieba.data.ai) sparseArray5.get(com.baidu.tieba.a.h.tag_load_sub_data);
                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                            sparseArray6.put(com.baidu.tieba.a.h.tag_load_sub_data, aiVar3);
                                                                            sparseArray6.put(com.baidu.tieba.a.h.tag_load_sub_view, (View) sparseArray5.get(com.baidu.tieba.a.h.tag_load_sub_view));
                                                                            bjVar12 = this.a.H;
                                                                            bjVar12.f().setTag(sparseArray6);
                                                                            SparseArray sparseArray7 = new SparseArray();
                                                                            sparseArray7.put(com.baidu.tieba.a.h.tag_clip_board, (com.baidu.tieba.data.ai) ((SparseArray) view.getTag()).get(com.baidu.tieba.a.h.tag_clip_board));
                                                                            sparseArray7.put(com.baidu.tieba.a.h.tag_is_subpb, false);
                                                                            bjVar13 = this.a.H;
                                                                            bjVar13.e().setTag(sparseArray7);
                                                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                            if (!((Boolean) sparseArray8.get(com.baidu.tieba.a.h.tag_should_manage_visible)).booleanValue()) {
                                                                                bjVar14 = this.a.H;
                                                                                bjVar14.g().setVisibility(8);
                                                                            } else {
                                                                                SparseArray sparseArray9 = new SparseArray();
                                                                                sparseArray9.put(com.baidu.tieba.a.h.tag_manage_user_identity, sparseArray8.get(com.baidu.tieba.a.h.tag_manage_user_identity));
                                                                                sparseArray9.put(com.baidu.tieba.a.h.tag_del_post_is_self, sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_is_self));
                                                                                sparseArray9.put(com.baidu.tieba.a.h.tag_del_post_id, sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_id));
                                                                                sparseArray9.put(com.baidu.tieba.a.h.tag_del_post_type, sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_type));
                                                                                sparseArray9.put(com.baidu.tieba.a.h.tag_forbid_user_name, sparseArray8.get(com.baidu.tieba.a.h.tag_forbid_user_name));
                                                                                bjVar15 = this.a.H;
                                                                                bjVar15.g().setTag(sparseArray9);
                                                                                int l = TbadkApplication.j().l();
                                                                                if (!"".equals(sparseArray8.get(com.baidu.tieba.a.h.tag_forbid_user_name)) && !"".equals(sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_id))) {
                                                                                    if (l == 1) {
                                                                                        bjVar20 = this.a.H;
                                                                                        bjVar20.g().setImageResource(com.baidu.tieba.a.g.icon_pb_set_n_1);
                                                                                    } else {
                                                                                        bjVar19 = this.a.H;
                                                                                        bjVar19.g().setImageResource(com.baidu.tieba.a.g.icon_pb_set_n);
                                                                                    }
                                                                                } else if (l == 1) {
                                                                                    bjVar17 = this.a.H;
                                                                                    bjVar17.g().setImageResource(com.baidu.tieba.a.g.icon_pb_del_n_1);
                                                                                } else {
                                                                                    bjVar16 = this.a.H;
                                                                                    bjVar16.g().setImageResource(com.baidu.tieba.a.g.icon_pb_del_n);
                                                                                }
                                                                                bjVar18 = this.a.H;
                                                                                bjVar18.g().setVisibility(0);
                                                                            }
                                                                        }
                                                                        boolean z2 = false;
                                                                        bdVar11 = this.a.x;
                                                                        if (bdVar11.p().i()) {
                                                                            bdVar12 = this.a.x;
                                                                            String j = bdVar12.p().j();
                                                                            if (aiVar3 != null && !com.baidu.adp.lib.util.h.b(j) && j.equals(aiVar3.d())) {
                                                                                z2 = true;
                                                                            }
                                                                        }
                                                                        if (TbadkApplication.j().l() == 1) {
                                                                            if (z2) {
                                                                                bjVar11 = this.a.H;
                                                                                bjVar11.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s_1, 0, 0, 0);
                                                                            } else {
                                                                                bjVar10 = this.a.H;
                                                                                bjVar10.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n_1, 0, 0, 0);
                                                                            }
                                                                        } else if (z2) {
                                                                            bjVar8 = this.a.H;
                                                                            bjVar8.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s, 0, 0, 0);
                                                                        } else {
                                                                            bjVar7 = this.a.H;
                                                                            bjVar7.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n, 0, 0, 0);
                                                                        }
                                                                        bjVar9 = this.a.H;
                                                                        bjVar9.a(true);
                                                                        iVar4 = this.a.G;
                                                                        iVar4.a();
                                                                        iVar5 = this.a.G;
                                                                        iVar5.a(view);
                                                                        return;
                                                                    }
                                                                    return;
                                                                } else if (id3 == com.baidu.tieba.a.h.sub_post_load_more) {
                                                                    fVar6 = this.a.B;
                                                                    if (fVar6.h()) {
                                                                        bkVar40 = this.a.D;
                                                                        bkVar40.B();
                                                                        return;
                                                                    }
                                                                    return;
                                                                } else if (id3 == com.baidu.tieba.a.h.sub_pb_bottom_layout) {
                                                                    bdVar10 = this.a.x;
                                                                    if (bdVar10.m()) {
                                                                        this.a.closeActivity();
                                                                        return;
                                                                    }
                                                                    this.a.v();
                                                                    bkVar39 = this.a.D;
                                                                    bkVar39.E();
                                                                    fVar5 = this.a.B;
                                                                    fVar5.cancelLoadData();
                                                                    return;
                                                                } else if (id3 == com.baidu.tieba.a.h.btn_loadprevious) {
                                                                    fVar4 = this.a.B;
                                                                    fVar4.k();
                                                                    bkVar38 = this.a.D;
                                                                    bkVar38.C();
                                                                    return;
                                                                } else if (id3 == com.baidu.tieba.a.h.pb_new_guide) {
                                                                    SharedPreferences.Editor edit = this.a.getSharedPreferences("settings", 0).edit();
                                                                    edit.putBoolean("has_shown_pb_guide", true);
                                                                    edit.commit();
                                                                    bkVar37 = this.a.D;
                                                                    bkVar37.o();
                                                                    return;
                                                                } else if (id3 != com.baidu.tieba.a.h.pb_head_reverse_hint) {
                                                                    return;
                                                                } else {
                                                                    this.a.v();
                                                                    bkVar35 = this.a.D;
                                                                    bkVar35.ab();
                                                                    bdVar9 = this.a.x;
                                                                    bdVar9.u();
                                                                    bkVar36 = this.a.D;
                                                                    bkVar36.t();
                                                                    return;
                                                                }
                                                            } else {
                                                                SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                                if (((Boolean) sparseArray10.get(com.baidu.tieba.a.h.tag_should_manage_visible)).booleanValue()) {
                                                                    bkVar47 = this.a.D;
                                                                    bkVar47.a(view);
                                                                    return;
                                                                }
                                                                bkVar46 = this.a.D;
                                                                bkVar46.a(((Integer) sparseArray10.get(com.baidu.tieba.a.h.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.a.h.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.a.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.a.h.tag_del_post_is_self)).booleanValue());
                                                                return;
                                                            }
                                                        }
                                                        PbActivity.l(this.a);
                                                        return;
                                                    }
                                                    PbActivity.a(this.a, view);
                                                    iVar7 = this.a.G;
                                                    iVar7.dismiss();
                                                    return;
                                                }
                                                this.a.v();
                                                bkVar50 = this.a.D;
                                                bkVar50.ab();
                                                bdVar14 = this.a.x;
                                                bdVar14.u();
                                                bkVar51 = this.a.D;
                                                bkVar51.t();
                                                TiebaStatic.a(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            this.a.v();
                                            bkVar54 = this.a.D;
                                            bkVar54.ab();
                                            PbActivity.k(this.a);
                                            return;
                                        }
                                        this.a.v();
                                        bdVar22 = this.a.x;
                                        bdVar22.t();
                                        bkVar57 = this.a.D;
                                        bkVar57.t();
                                        TiebaStatic.a(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    this.a.l();
                                    return;
                                }
                                TiebaStatic.a(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bdVar23 = this.a.x;
                                if (!bdVar23.i()) {
                                    bdVar24 = this.a.x;
                                    String name3 = bdVar24.p().c().getName();
                                    if (com.baidu.tbadk.core.util.bc.b(name3)) {
                                        this.a.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.a).a(name3, "tb_pb")));
                                        return;
                                    }
                                    return;
                                }
                                this.a.finish();
                                return;
                            }
                            iVar8 = this.a.G;
                            if (iVar8 != null) {
                                com.baidu.tieba.data.ai aiVar4 = null;
                                if (view != null && view.getTag() != null) {
                                    aiVar4 = (com.baidu.tieba.data.ai) ((SparseArray) view.getTag()).get(com.baidu.tieba.a.h.tag_clip_board);
                                    SparseArray sparseArray11 = new SparseArray();
                                    sparseArray11.put(com.baidu.tieba.a.h.tag_clip_board, aiVar4);
                                    sparseArray11.put(com.baidu.tieba.a.h.tag_is_subpb, false);
                                    bjVar27 = this.a.H;
                                    bjVar27.e().setTag(sparseArray11);
                                }
                                bdVar25 = this.a.x;
                                if (bdVar25.p().i()) {
                                    bdVar26 = this.a.x;
                                    String j2 = bdVar26.p().j();
                                    if (aiVar4 != null && !com.baidu.adp.lib.util.h.b(j2) && j2.equals(aiVar4.d())) {
                                        z = true;
                                        if (TbadkApplication.j().l() != 1) {
                                            if (z) {
                                                bjVar26 = this.a.H;
                                                bjVar26.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s_1, 0, 0, 0);
                                            } else {
                                                bjVar25 = this.a.H;
                                                bjVar25.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n_1, 0, 0, 0);
                                            }
                                        } else if (z) {
                                            bjVar22 = this.a.H;
                                            bjVar22.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s, 0, 0, 0);
                                        } else {
                                            bjVar21 = this.a.H;
                                            bjVar21.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n, 0, 0, 0);
                                        }
                                        bjVar23 = this.a.H;
                                        bjVar23.g().setVisibility(8);
                                        bjVar24 = this.a.H;
                                        bjVar24.a(false);
                                        iVar9 = this.a.G;
                                        iVar9.a();
                                        iVar10 = this.a.G;
                                        iVar10.a(view);
                                        return;
                                    }
                                }
                                z = false;
                                if (TbadkApplication.j().l() != 1) {
                                }
                                bjVar23 = this.a.H;
                                bjVar23.g().setVisibility(8);
                                bjVar24 = this.a.H;
                                bjVar24.a(false);
                                iVar9 = this.a.G;
                                iVar9.a();
                                iVar10 = this.a.G;
                                iVar10.a(view);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        bkVar4 = this.a.D;
        bkVar4.ac();
        bdVar = this.a.x;
        if (bdVar.p().l() == 1) {
            vVar = this.a.C;
            if (!vVar.a()) {
                bkVar5 = this.a.D;
                bkVar5.n();
                int i = 0;
                bkVar6 = this.a.D;
                if (view != bkVar6.U()) {
                    bkVar7 = this.a.D;
                    if (view != bkVar7.V()) {
                        bkVar8 = this.a.D;
                        if (view != bkVar8.W()) {
                            bkVar9 = this.a.D;
                            if (view != bkVar9.X()) {
                                bkVar10 = this.a.D;
                                if (view == bkVar10.q()) {
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
                bdVar2 = this.a.x;
                ForumData c2 = bdVar2.p().c();
                String name4 = c2.getName();
                String id4 = c2.getId();
                bdVar3 = this.a.x;
                String l2 = bdVar3.p().d().l();
                vVar2 = this.a.C;
                bkVar11 = this.a.D;
                vVar2.a(id4, name4, l2, i, bkVar11.r());
            }
        }
    }
}
