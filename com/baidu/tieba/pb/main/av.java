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
final class av implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0445  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bf bfVar;
        com.baidu.tieba.model.v vVar;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        bm bmVar9;
        bm bmVar10;
        bf bfVar2;
        bf bfVar3;
        com.baidu.tieba.model.v vVar2;
        bm bmVar11;
        bm bmVar12;
        bm bmVar13;
        bm bmVar14;
        bm bmVar15;
        bm bmVar16;
        bm bmVar17;
        bm bmVar18;
        bm bmVar19;
        bm bmVar20;
        bm bmVar21;
        bm bmVar22;
        bm bmVar23;
        bm bmVar24;
        bm bmVar25;
        bm bmVar26;
        bm bmVar27;
        bm bmVar28;
        bm bmVar29;
        bl blVar;
        bm bmVar30;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bf bfVar4;
        bm bmVar31;
        bf bfVar5;
        com.baidu.tieba.pb.sub.f fVar;
        bf bfVar6;
        com.baidu.tieba.pb.sub.f fVar2;
        com.baidu.tieba.pb.sub.f fVar3;
        bl blVar5;
        Handler handler;
        bm bmVar32;
        bf bfVar7;
        com.baidu.tbadk.core.view.i iVar;
        bm bmVar33;
        bf bfVar8;
        bl blVar6;
        com.baidu.tbadk.core.view.i iVar2;
        bm bmVar34;
        bm bmVar35;
        bf bfVar9;
        bm bmVar36;
        bm bmVar37;
        com.baidu.tieba.pb.sub.f fVar4;
        bm bmVar38;
        bf bfVar10;
        bm bmVar39;
        com.baidu.tieba.pb.sub.f fVar5;
        com.baidu.tieba.pb.sub.f fVar6;
        bm bmVar40;
        com.baidu.tbadk.core.view.i iVar3;
        bf bfVar11;
        bl blVar7;
        bl blVar8;
        bl blVar9;
        bl blVar10;
        bl blVar11;
        com.baidu.tbadk.core.view.i iVar4;
        com.baidu.tbadk.core.view.i iVar5;
        bl blVar12;
        bl blVar13;
        bl blVar14;
        bl blVar15;
        bf bfVar12;
        bl blVar16;
        bl blVar17;
        bl blVar18;
        bl blVar19;
        bl blVar20;
        bl blVar21;
        bl blVar22;
        bl blVar23;
        bl blVar24;
        bm bmVar41;
        bm bmVar42;
        bm bmVar43;
        bf bfVar13;
        bm bmVar44;
        bm bmVar45;
        bm bmVar46;
        bm bmVar47;
        bm bmVar48;
        com.baidu.tbadk.core.view.i iVar6;
        bm bmVar49;
        com.baidu.tbadk.core.view.i iVar7;
        bm bmVar50;
        bf bfVar14;
        bm bmVar51;
        bm bmVar52;
        bf bfVar15;
        bm bmVar53;
        bf bfVar16;
        bm bmVar54;
        bm bmVar55;
        boolean a;
        bf bfVar17;
        bm bmVar56;
        bf bfVar18;
        bf bfVar19;
        bf bfVar20;
        bf bfVar21;
        bf bfVar22;
        bm bmVar57;
        bf bfVar23;
        bf bfVar24;
        bm bmVar58;
        com.baidu.tieba.pb.sub.f fVar7;
        com.baidu.tieba.pb.sub.f fVar8;
        com.baidu.tieba.pb.sub.f fVar9;
        com.baidu.tieba.pb.sub.f fVar10;
        bm bmVar59;
        com.baidu.tbadk.core.view.i iVar8;
        bf bfVar25;
        boolean z;
        bl blVar25;
        bl blVar26;
        bl blVar27;
        bl blVar28;
        bl blVar29;
        bl blVar30;
        com.baidu.tbadk.core.view.i iVar9;
        com.baidu.tbadk.core.view.i iVar10;
        bl blVar31;
        bl blVar32;
        bl blVar33;
        bl blVar34;
        bf bfVar26;
        bl blVar35;
        bm bmVar60;
        com.baidu.tieba.model.v vVar3;
        bm bmVar61;
        bf bfVar27;
        com.baidu.tieba.model.v vVar4;
        bf bfVar28;
        bf bfVar29;
        bf bfVar30;
        com.baidu.tieba.pb.sub.f fVar11;
        com.baidu.tieba.pb.sub.f fVar12;
        com.baidu.tieba.pb.sub.f fVar13;
        com.baidu.tieba.pb.sub.f fVar14;
        com.baidu.tieba.model.v vVar5;
        com.baidu.tieba.pb.sub.f fVar15;
        com.baidu.tieba.pb.sub.f fVar16;
        com.baidu.tieba.pb.sub.f fVar17;
        bf bfVar31;
        bf bfVar32;
        bm bmVar62;
        bf bfVar33;
        bf bfVar34;
        bm bmVar63;
        bmVar = this.a.D;
        if (view == bmVar.Q()) {
            bfVar34 = this.a.x;
            if (bfVar34.a(true)) {
                bmVar63 = this.a.D;
                bmVar63.v();
                return;
            }
            return;
        }
        bmVar2 = this.a.D;
        if (view == bmVar2.k) {
            bmVar62 = this.a.D;
            bfVar33 = this.a.x;
            if (!bmVar62.f(bfVar33.m())) {
                this.a.closeActivity();
                return;
            } else {
                this.a.v();
                return;
            }
        }
        bmVar3 = this.a.D;
        if (view != bmVar3.U()) {
            bmVar12 = this.a.D;
            if (view != bmVar12.V()) {
                bmVar13 = this.a.D;
                if (view != bmVar13.W()) {
                    bmVar14 = this.a.D;
                    if (view != bmVar14.X()) {
                        bmVar15 = this.a.D;
                        if (view != bmVar15.q()) {
                            bmVar16 = this.a.D;
                            if (view == bmVar16.ag()) {
                                bfVar31 = this.a.x;
                                if (bfVar31 != null) {
                                    bfVar32 = this.a.x;
                                    com.baidu.tbadk.browser.a.a(this.a, bfVar32.p().d().s().c());
                                    return;
                                }
                                return;
                            }
                            bmVar17 = this.a.D;
                            if (view == bmVar17.p()) {
                                bmVar60 = this.a.D;
                                bmVar60.ac();
                                String E = TbadkApplication.E();
                                if (E != null && E.length() > 0) {
                                    vVar3 = this.a.C;
                                    if (!vVar3.a()) {
                                        bmVar61 = this.a.D;
                                        bmVar61.n();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.a.h.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_type)).intValue();
                                            bfVar27 = this.a.x;
                                            if (bfVar27.m()) {
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
                                            bfVar28 = this.a.x;
                                            String id2 = bfVar28.p().c().getId();
                                            bfVar29 = this.a.x;
                                            String name2 = bfVar29.p().c().getName();
                                            bfVar30 = this.a.x;
                                            vVar4.a(id2, name2, bfVar30.p().d().l(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.a.k.login_to_use), true, 11017);
                                return;
                            }
                            bmVar18 = this.a.D;
                            if (view != bmVar18.Y()) {
                                bmVar19 = this.a.D;
                                if (view == bmVar19.s()) {
                                    fVar10 = this.a.B;
                                    if (fVar10.h()) {
                                        bmVar59 = this.a.D;
                                        bmVar59.B();
                                        return;
                                    }
                                    return;
                                }
                                bmVar20 = this.a.D;
                                if (view == bmVar20.k()) {
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
                                bmVar21 = this.a.D;
                                if (view == bmVar21.c) {
                                    bmVar58 = this.a.D;
                                    bmVar58.m();
                                    this.a.closeActivity();
                                    return;
                                }
                                bmVar22 = this.a.D;
                                if (view != bmVar22.e) {
                                    bmVar23 = this.a.D;
                                    if (view != bmVar23.g) {
                                        bmVar24 = this.a.D;
                                        if (view != bmVar24.f) {
                                            bmVar25 = this.a.D;
                                            if (view == bmVar25.h) {
                                                bfVar18 = this.a.x;
                                                AdditionData n = bfVar18.p().n();
                                                if (!TextUtils.isEmpty(n.getWarnMsg())) {
                                                    com.baidu.adp.lib.util.i.a((Context) this.a, n.getWarnMsg());
                                                    return;
                                                } else if (n.getAlreadyCount() != n.getTotalCount()) {
                                                    bfVar19 = this.a.x;
                                                    ForumData c = bfVar19.p().c();
                                                    bfVar20 = this.a.x;
                                                    com.baidu.tbadk.core.data.o d = bfVar20.p().d();
                                                    bfVar21 = this.a.x;
                                                    AntiData g = bfVar21.p().g();
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
                                            bmVar26 = this.a.D;
                                            if (view == bmVar26.g().d()) {
                                                bmVar55 = this.a.D;
                                                bmVar55.ab();
                                                a = this.a.a(11009);
                                                if (a) {
                                                    bfVar17 = this.a.x;
                                                    bmVar56 = this.a.D;
                                                    if (bfVar17.f(bmVar56.K()) == null) {
                                                        return;
                                                    }
                                                    this.a.t();
                                                    return;
                                                }
                                                return;
                                            }
                                            bmVar27 = this.a.D;
                                            if (view == bmVar27.g().e()) {
                                                bmVar54 = this.a.D;
                                                bmVar54.ab();
                                                this.a.v();
                                                PbActivity.l(this.a);
                                                return;
                                            }
                                            bmVar28 = this.a.D;
                                            if (view == bmVar28.g().g()) {
                                                bmVar52 = this.a.D;
                                                bmVar52.ab();
                                                bfVar15 = this.a.x;
                                                if (bfVar15.q() != null) {
                                                    bmVar53 = this.a.D;
                                                    bfVar16 = this.a.x;
                                                    bmVar53.a(bfVar16.q());
                                                }
                                                TiebaStatic.a(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            bmVar29 = this.a.D;
                                            if (view == bmVar29.g().h()) {
                                                bmVar50 = this.a.D;
                                                bmVar50.ab();
                                                this.a.v();
                                                bfVar14 = this.a.x;
                                                bfVar14.u();
                                                bmVar51 = this.a.D;
                                                bmVar51.t();
                                                TiebaStatic.a(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            blVar = this.a.H;
                                            if (view != blVar.e()) {
                                                bmVar30 = this.a.D;
                                                if (bmVar30.c() != view) {
                                                    blVar2 = this.a.H;
                                                    if (view == blVar2.g()) {
                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                        if (sparseArray2 != null) {
                                                            if ("".equals(sparseArray2.get(com.baidu.tieba.a.h.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_id))) {
                                                                bmVar48 = this.a.D;
                                                                bmVar48.a(((Integer) sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.a.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.a.h.tag_del_post_is_self)).booleanValue());
                                                            } else {
                                                                bmVar49 = this.a.D;
                                                                bmVar49.a(view);
                                                            }
                                                            iVar6 = this.a.G;
                                                            iVar6.dismiss();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != com.baidu.tieba.a.h.pb_head_function_manage_delormanage) {
                                                        blVar3 = this.a.H;
                                                        if (view == blVar3.f() || view.getId() == com.baidu.tieba.a.h.sub_pb_more || view.getId() == com.baidu.tieba.a.h.sub_pb_item) {
                                                            blVar4 = this.a.H;
                                                            if (view == blVar4.f()) {
                                                                blVar6 = this.a.H;
                                                                if (!blVar6.a()) {
                                                                    iVar2 = this.a.G;
                                                                    iVar2.dismiss();
                                                                    bmVar34 = this.a.D;
                                                                    bmVar34.b(true);
                                                                    return;
                                                                }
                                                            }
                                                            try {
                                                                bfVar4 = this.a.x;
                                                                if (bfVar4.p() != null) {
                                                                    bmVar31 = this.a.D;
                                                                    bmVar31.ab();
                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                    com.baidu.tieba.data.ai aiVar = (com.baidu.tieba.data.ai) sparseArray3.get(com.baidu.tieba.a.h.tag_load_sub_data);
                                                                    View view2 = (View) sparseArray3.get(com.baidu.tieba.a.h.tag_load_sub_view);
                                                                    if (aiVar != null && view2 != null) {
                                                                        bfVar5 = this.a.x;
                                                                        com.baidu.tieba.data.am a2 = bfVar5.a(aiVar);
                                                                        fVar = this.a.B;
                                                                        bfVar6 = this.a.x;
                                                                        fVar.a(bfVar6.f());
                                                                        fVar2 = this.a.B;
                                                                        fVar2.b(aiVar.d());
                                                                        fVar3 = this.a.B;
                                                                        fVar3.d();
                                                                        this.a.v();
                                                                        blVar5 = this.a.H;
                                                                        if (view == blVar5.f()) {
                                                                            iVar = this.a.G;
                                                                            iVar.dismiss();
                                                                            bmVar33 = this.a.D;
                                                                            bfVar8 = this.a.x;
                                                                            bmVar33.a(true, a2, null, null, view2, bfVar8.p().l());
                                                                            return;
                                                                        } else if (view.getId() != com.baidu.tieba.a.h.sub_pb_item) {
                                                                            handler = this.a.w;
                                                                            handler.post(new aw(this, a2, view2));
                                                                            return;
                                                                        } else {
                                                                            SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                            String str2 = (String) sparseArray4.get(com.baidu.tieba.a.h.tag_photo_username);
                                                                            com.baidu.tieba.data.ai aiVar2 = (com.baidu.tieba.data.ai) sparseArray4.get(com.baidu.tieba.a.h.tag_clip_board);
                                                                            String str3 = null;
                                                                            if (aiVar2 != null) {
                                                                                str3 = aiVar2.d();
                                                                            }
                                                                            bmVar32 = this.a.D;
                                                                            bfVar7 = this.a.x;
                                                                            bmVar32.a(true, a2, str2, str3, view2, bfVar7.p().l());
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
                                                            bmVar42 = this.a.D;
                                                            bmVar42.ab();
                                                            bmVar43 = this.a.D;
                                                            if (bmVar43.L() < 0) {
                                                                return;
                                                            }
                                                            this.a.v();
                                                            bfVar13 = this.a.x;
                                                            bmVar44 = this.a.D;
                                                            bfVar13.c(bmVar44.L());
                                                            bmVar45 = this.a.D;
                                                            bmVar45.t();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.a.h.dialog_button_cancel) {
                                                            bmVar41 = this.a.D;
                                                            bmVar41.ab();
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
                                                                    blVar16 = this.a.H;
                                                                    blVar16.f().setTag(sparseArray6);
                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                    sparseArray7.put(com.baidu.tieba.a.h.tag_clip_board, (com.baidu.tieba.data.ai) ((SparseArray) view.getTag()).get(com.baidu.tieba.a.h.tag_clip_board));
                                                                    sparseArray7.put(com.baidu.tieba.a.h.tag_is_subpb, false);
                                                                    blVar17 = this.a.H;
                                                                    blVar17.e().setTag(sparseArray7);
                                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                    if (!((Boolean) sparseArray8.get(com.baidu.tieba.a.h.tag_should_manage_visible)).booleanValue()) {
                                                                        blVar18 = this.a.H;
                                                                        blVar18.g().setVisibility(8);
                                                                    } else {
                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                        sparseArray9.put(com.baidu.tieba.a.h.tag_manage_user_identity, sparseArray8.get(com.baidu.tieba.a.h.tag_manage_user_identity));
                                                                        sparseArray9.put(com.baidu.tieba.a.h.tag_del_post_is_self, sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_is_self));
                                                                        sparseArray9.put(com.baidu.tieba.a.h.tag_del_post_id, sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_id));
                                                                        sparseArray9.put(com.baidu.tieba.a.h.tag_del_post_type, sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_type));
                                                                        sparseArray9.put(com.baidu.tieba.a.h.tag_forbid_user_name, sparseArray8.get(com.baidu.tieba.a.h.tag_forbid_user_name));
                                                                        blVar19 = this.a.H;
                                                                        blVar19.g().setTag(sparseArray9);
                                                                        int l = TbadkApplication.j().l();
                                                                        if (!"".equals(sparseArray8.get(com.baidu.tieba.a.h.tag_forbid_user_name)) && !"".equals(sparseArray8.get(com.baidu.tieba.a.h.tag_del_post_id))) {
                                                                            if (l == 1) {
                                                                                blVar24 = this.a.H;
                                                                                blVar24.g().setImageResource(com.baidu.tieba.a.g.icon_pb_set_n_1);
                                                                            } else {
                                                                                blVar23 = this.a.H;
                                                                                blVar23.g().setImageResource(com.baidu.tieba.a.g.icon_pb_set_n);
                                                                            }
                                                                        } else if (l == 1) {
                                                                            blVar21 = this.a.H;
                                                                            blVar21.g().setImageResource(com.baidu.tieba.a.g.icon_pb_del_n_1);
                                                                        } else {
                                                                            blVar20 = this.a.H;
                                                                            blVar20.g().setImageResource(com.baidu.tieba.a.g.icon_pb_del_n);
                                                                        }
                                                                        blVar22 = this.a.H;
                                                                        blVar22.g().setVisibility(0);
                                                                    }
                                                                }
                                                                boolean z2 = false;
                                                                bfVar11 = this.a.x;
                                                                if (bfVar11.p().i()) {
                                                                    bfVar12 = this.a.x;
                                                                    String j = bfVar12.p().j();
                                                                    if (aiVar3 != null && !com.baidu.adp.lib.util.h.b(j) && j.equals(aiVar3.d())) {
                                                                        z2 = true;
                                                                    }
                                                                }
                                                                if (TbadkApplication.j().l() == 1) {
                                                                    if (z2) {
                                                                        blVar14 = this.a.H;
                                                                        blVar14.e().setText(com.baidu.tieba.a.k.marked);
                                                                        blVar15 = this.a.H;
                                                                        blVar15.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s_1, 0, 0, 0);
                                                                    } else {
                                                                        blVar12 = this.a.H;
                                                                        blVar12.e().setText(com.baidu.tieba.a.k.mark);
                                                                        blVar13 = this.a.H;
                                                                        blVar13.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n_1, 0, 0, 0);
                                                                    }
                                                                } else if (z2) {
                                                                    blVar9 = this.a.H;
                                                                    blVar9.e().setText(com.baidu.tieba.a.k.marked);
                                                                    blVar10 = this.a.H;
                                                                    blVar10.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s, 0, 0, 0);
                                                                } else {
                                                                    blVar7 = this.a.H;
                                                                    blVar7.e().setText(com.baidu.tieba.a.k.mark);
                                                                    blVar8 = this.a.H;
                                                                    blVar8.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n, 0, 0, 0);
                                                                }
                                                                blVar11 = this.a.H;
                                                                blVar11.a(true);
                                                                iVar4 = this.a.G;
                                                                iVar4.a();
                                                                iVar5 = this.a.G;
                                                                iVar5.a(view, false);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.a.h.sub_post_load_more) {
                                                            fVar6 = this.a.B;
                                                            if (fVar6.h()) {
                                                                bmVar40 = this.a.D;
                                                                bmVar40.B();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.a.h.sub_pb_bottom_layout) {
                                                            bfVar10 = this.a.x;
                                                            if (bfVar10.m()) {
                                                                this.a.closeActivity();
                                                                return;
                                                            }
                                                            this.a.v();
                                                            bmVar39 = this.a.D;
                                                            bmVar39.E();
                                                            fVar5 = this.a.B;
                                                            fVar5.cancelLoadData();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.a.h.btn_loadprevious) {
                                                            fVar4 = this.a.B;
                                                            fVar4.k();
                                                            bmVar38 = this.a.D;
                                                            bmVar38.C();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.a.h.pb_new_guide) {
                                                            SharedPreferences.Editor edit = this.a.getSharedPreferences("settings", 0).edit();
                                                            edit.putBoolean("has_shown_pb_guide", true);
                                                            edit.commit();
                                                            bmVar37 = this.a.D;
                                                            bmVar37.o();
                                                            return;
                                                        } else if (id3 != com.baidu.tieba.a.h.pb_head_reverse_hint) {
                                                            return;
                                                        } else {
                                                            this.a.v();
                                                            bmVar35 = this.a.D;
                                                            bmVar35.ab();
                                                            bfVar9 = this.a.x;
                                                            bfVar9.u();
                                                            bmVar36 = this.a.D;
                                                            bmVar36.t();
                                                            return;
                                                        }
                                                    } else {
                                                        SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                        if (((Boolean) sparseArray10.get(com.baidu.tieba.a.h.tag_should_manage_visible)).booleanValue()) {
                                                            bmVar47 = this.a.D;
                                                            bmVar47.a(view);
                                                            return;
                                                        }
                                                        bmVar46 = this.a.D;
                                                        bmVar46.a(((Integer) sparseArray10.get(com.baidu.tieba.a.h.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.a.h.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.a.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.a.h.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    }
                                                }
                                                PbActivity.m(this.a);
                                                return;
                                            }
                                            PbActivity.a(this.a, view);
                                            iVar7 = this.a.G;
                                            iVar7.dismiss();
                                            return;
                                        }
                                        this.a.v();
                                        bfVar22 = this.a.x;
                                        bfVar22.t();
                                        bmVar57 = this.a.D;
                                        bmVar57.t();
                                        TiebaStatic.a(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    this.a.l();
                                    return;
                                }
                                TiebaStatic.a(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bfVar23 = this.a.x;
                                if (!bfVar23.i()) {
                                    bfVar24 = this.a.x;
                                    String name3 = bfVar24.p().c().getName();
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
                                    blVar35 = this.a.H;
                                    blVar35.e().setTag(sparseArray11);
                                }
                                bfVar25 = this.a.x;
                                if (bfVar25.p().i()) {
                                    bfVar26 = this.a.x;
                                    String j2 = bfVar26.p().j();
                                    if (aiVar4 != null && !com.baidu.adp.lib.util.h.b(j2) && j2.equals(aiVar4.d())) {
                                        z = true;
                                        if (TbadkApplication.j().l() != 1) {
                                            if (z) {
                                                blVar33 = this.a.H;
                                                blVar33.e().setText(com.baidu.tieba.a.k.marked);
                                                blVar34 = this.a.H;
                                                blVar34.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s_1, 0, 0, 0);
                                            } else {
                                                blVar31 = this.a.H;
                                                blVar31.e().setText(com.baidu.tieba.a.k.mark);
                                                blVar32 = this.a.H;
                                                blVar32.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n_1, 0, 0, 0);
                                            }
                                        } else if (z) {
                                            blVar27 = this.a.H;
                                            blVar27.e().setText(com.baidu.tieba.a.k.marked);
                                            blVar28 = this.a.H;
                                            blVar28.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_s, 0, 0, 0);
                                        } else {
                                            blVar25 = this.a.H;
                                            blVar25.e().setText(com.baidu.tieba.a.k.mark);
                                            blVar26 = this.a.H;
                                            blVar26.e().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_pb_collect_n, 0, 0, 0);
                                        }
                                        blVar29 = this.a.H;
                                        blVar29.g().setVisibility(8);
                                        blVar30 = this.a.H;
                                        blVar30.a(false);
                                        iVar9 = this.a.G;
                                        iVar9.a();
                                        iVar10 = this.a.G;
                                        iVar10.a(view, false);
                                        return;
                                    }
                                }
                                z = false;
                                if (TbadkApplication.j().l() != 1) {
                                }
                                blVar29 = this.a.H;
                                blVar29.g().setVisibility(8);
                                blVar30 = this.a.H;
                                blVar30.a(false);
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
        bmVar4 = this.a.D;
        bmVar4.ac();
        bfVar = this.a.x;
        if (bfVar.p().l() == 1) {
            vVar = this.a.C;
            if (!vVar.a()) {
                bmVar5 = this.a.D;
                bmVar5.n();
                int i = 0;
                bmVar6 = this.a.D;
                if (view != bmVar6.U()) {
                    bmVar7 = this.a.D;
                    if (view != bmVar7.V()) {
                        bmVar8 = this.a.D;
                        if (view != bmVar8.W()) {
                            bmVar9 = this.a.D;
                            if (view != bmVar9.X()) {
                                bmVar10 = this.a.D;
                                if (view == bmVar10.q()) {
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
                bfVar2 = this.a.x;
                ForumData c2 = bfVar2.p().c();
                String name4 = c2.getName();
                String id4 = c2.getId();
                bfVar3 = this.a.x;
                String l2 = bfVar3.p().d().l();
                vVar2 = this.a.C;
                bmVar11 = this.a.D;
                vVar2.a(id4, name4, l2, i, bmVar11.r());
            }
        }
    }
}
