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
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bj bjVar;
        com.baidu.tieba.model.v vVar;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        bq bqVar10;
        bj bjVar2;
        bj bjVar3;
        com.baidu.tieba.model.v vVar2;
        bq bqVar11;
        bq bqVar12;
        bq bqVar13;
        bq bqVar14;
        bq bqVar15;
        bq bqVar16;
        bq bqVar17;
        bq bqVar18;
        bq bqVar19;
        bq bqVar20;
        bq bqVar21;
        bq bqVar22;
        bq bqVar23;
        bq bqVar24;
        bq bqVar25;
        bq bqVar26;
        bq bqVar27;
        bq bqVar28;
        bq bqVar29;
        bp bpVar;
        bq bqVar30;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        bj bjVar4;
        bq bqVar31;
        bj bjVar5;
        com.baidu.tieba.pb.sub.f fVar;
        bj bjVar6;
        com.baidu.tieba.pb.sub.f fVar2;
        com.baidu.tieba.pb.sub.f fVar3;
        bp bpVar5;
        Handler handler;
        bq bqVar32;
        bj bjVar7;
        com.baidu.tbadk.core.view.i iVar;
        bq bqVar33;
        bj bjVar8;
        bp bpVar6;
        com.baidu.tbadk.core.view.i iVar2;
        bq bqVar34;
        bq bqVar35;
        bj bjVar9;
        bq bqVar36;
        bq bqVar37;
        com.baidu.tieba.pb.sub.f fVar4;
        bq bqVar38;
        bj bjVar10;
        bq bqVar39;
        com.baidu.tieba.pb.sub.f fVar5;
        com.baidu.tieba.pb.sub.f fVar6;
        bq bqVar40;
        com.baidu.tbadk.core.view.i iVar3;
        bj bjVar11;
        bp bpVar7;
        bp bpVar8;
        bp bpVar9;
        bp bpVar10;
        bp bpVar11;
        com.baidu.tbadk.core.view.i iVar4;
        com.baidu.tbadk.core.view.i iVar5;
        bp bpVar12;
        bp bpVar13;
        bp bpVar14;
        bp bpVar15;
        bj bjVar12;
        bp bpVar16;
        bp bpVar17;
        bp bpVar18;
        bp bpVar19;
        bp bpVar20;
        bp bpVar21;
        bp bpVar22;
        bp bpVar23;
        bp bpVar24;
        bq bqVar41;
        bq bqVar42;
        bq bqVar43;
        bj bjVar13;
        bq bqVar44;
        bq bqVar45;
        bq bqVar46;
        bq bqVar47;
        bq bqVar48;
        com.baidu.tbadk.core.view.i iVar6;
        bq bqVar49;
        com.baidu.tbadk.core.view.i iVar7;
        bq bqVar50;
        bj bjVar14;
        bq bqVar51;
        bq bqVar52;
        bj bjVar15;
        bq bqVar53;
        bj bjVar16;
        bq bqVar54;
        bq bqVar55;
        boolean b;
        bj bjVar17;
        bq bqVar56;
        bj bjVar18;
        bj bjVar19;
        bj bjVar20;
        bj bjVar21;
        bj bjVar22;
        bq bqVar57;
        bj bjVar23;
        bj bjVar24;
        bj bjVar25;
        bq bqVar58;
        com.baidu.tieba.pb.sub.f fVar7;
        com.baidu.tieba.pb.sub.f fVar8;
        com.baidu.tieba.pb.sub.f fVar9;
        com.baidu.tieba.pb.sub.f fVar10;
        bq bqVar59;
        com.baidu.tbadk.core.view.i iVar8;
        bj bjVar26;
        boolean z;
        bp bpVar25;
        bp bpVar26;
        bp bpVar27;
        bp bpVar28;
        bp bpVar29;
        bp bpVar30;
        com.baidu.tbadk.core.view.i iVar9;
        com.baidu.tbadk.core.view.i iVar10;
        bp bpVar31;
        bp bpVar32;
        bp bpVar33;
        bp bpVar34;
        bj bjVar27;
        bp bpVar35;
        bq bqVar60;
        com.baidu.tieba.model.v vVar3;
        bq bqVar61;
        bj bjVar28;
        com.baidu.tieba.model.v vVar4;
        bj bjVar29;
        bj bjVar30;
        bj bjVar31;
        com.baidu.tieba.pb.sub.f fVar11;
        com.baidu.tieba.pb.sub.f fVar12;
        com.baidu.tieba.pb.sub.f fVar13;
        com.baidu.tieba.pb.sub.f fVar14;
        com.baidu.tieba.model.v vVar5;
        com.baidu.tieba.pb.sub.f fVar15;
        com.baidu.tieba.pb.sub.f fVar16;
        com.baidu.tieba.pb.sub.f fVar17;
        bj bjVar32;
        bj bjVar33;
        bq bqVar62;
        bj bjVar34;
        bj bjVar35;
        bq bqVar63;
        bqVar = this.a.D;
        if (view == bqVar.Q()) {
            bjVar35 = this.a.x;
            if (bjVar35.a(true)) {
                bqVar63 = this.a.D;
                bqVar63.v();
                return;
            }
            return;
        }
        bqVar2 = this.a.D;
        if (view == bqVar2.k) {
            bqVar62 = this.a.D;
            bjVar34 = this.a.x;
            if (!bqVar62.f(bjVar34.n())) {
                this.a.closeActivity();
                return;
            } else {
                this.a.D();
                return;
            }
        }
        bqVar3 = this.a.D;
        if (view != bqVar3.U()) {
            bqVar12 = this.a.D;
            if (view != bqVar12.V()) {
                bqVar13 = this.a.D;
                if (view != bqVar13.W()) {
                    bqVar14 = this.a.D;
                    if (view != bqVar14.X()) {
                        bqVar15 = this.a.D;
                        if (view != bqVar15.q()) {
                            bqVar16 = this.a.D;
                            if (view == bqVar16.ag()) {
                                bjVar32 = this.a.x;
                                if (bjVar32 != null) {
                                    bjVar33 = this.a.x;
                                    com.baidu.tbadk.browser.a.a(this.a, bjVar33.q().d().x().c());
                                    return;
                                }
                                return;
                            }
                            bqVar17 = this.a.D;
                            if (view == bqVar17.p()) {
                                bqVar60 = this.a.D;
                                bqVar60.ad();
                                String currentAccount = TbadkApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    vVar3 = this.a.C;
                                    if (!vVar3.b()) {
                                        bqVar61 = this.a.D;
                                        bqVar61.n();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue();
                                            bjVar28 = this.a.x;
                                            if (bjVar28.n()) {
                                                fVar11 = this.a.B;
                                                if (fVar11 != null) {
                                                    fVar12 = this.a.B;
                                                    if (fVar12.e() != null) {
                                                        fVar13 = this.a.B;
                                                        if (fVar13.e().h() != null) {
                                                            fVar14 = this.a.B;
                                                            if (fVar14.e().m() != null) {
                                                                vVar5 = this.a.C;
                                                                fVar15 = this.a.B;
                                                                String id = fVar15.e().h().getId();
                                                                fVar16 = this.a.B;
                                                                String name = fVar16.e().h().getName();
                                                                fVar17 = this.a.B;
                                                                vVar5.a(id, name, fVar17.e().m().p(), str, intValue2, intValue, booleanValue);
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
                                            bjVar29 = this.a.x;
                                            String id2 = bjVar29.q().c().getId();
                                            bjVar30 = this.a.x;
                                            String name2 = bjVar30.q().c().getName();
                                            bjVar31 = this.a.x;
                                            vVar4.a(id2, name2, bjVar31.q().d().p(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.y.login_to_use), true, 11017);
                                return;
                            }
                            bqVar18 = this.a.D;
                            if (view != bqVar18.Y()) {
                                bqVar19 = this.a.D;
                                if (view == bqVar19.s()) {
                                    fVar10 = this.a.B;
                                    if (fVar10.h()) {
                                        bqVar59 = this.a.D;
                                        bqVar59.B();
                                        return;
                                    }
                                    return;
                                }
                                bqVar20 = this.a.D;
                                if (view == bqVar20.k()) {
                                    fVar7 = this.a.B;
                                    if (fVar7 != null) {
                                        fVar8 = this.a.B;
                                        if (fVar8.a() != null) {
                                            PbActivity pbActivity = this.a;
                                            com.baidu.tbadk.core.atomData.as asVar = new com.baidu.tbadk.core.atomData.as(this.a);
                                            fVar9 = this.a.B;
                                            pbActivity.sendMessage(new CustomMessage(2006001, asVar.a(fVar9.a(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bqVar21 = this.a.D;
                                if (view == bqVar21.c) {
                                    bqVar58 = this.a.D;
                                    bqVar58.m();
                                    this.a.closeActivity();
                                    return;
                                }
                                bqVar22 = this.a.D;
                                if (view != bqVar22.e) {
                                    bqVar23 = this.a.D;
                                    if (view != bqVar23.g) {
                                        bqVar24 = this.a.D;
                                        if (view != bqVar24.f) {
                                            bqVar25 = this.a.D;
                                            if (view == bqVar25.h) {
                                                bjVar18 = this.a.x;
                                                AdditionData n = bjVar18.q().n();
                                                if (!TextUtils.isEmpty(n.getWarnMsg())) {
                                                    com.baidu.adp.lib.util.k.a((Context) this.a, n.getWarnMsg());
                                                    return;
                                                } else if (n.getAlreadyCount() != n.getTotalCount()) {
                                                    bjVar19 = this.a.x;
                                                    ForumData c = bjVar19.q().c();
                                                    bjVar20 = this.a.x;
                                                    com.baidu.tbadk.core.data.n d = bjVar20.q().d();
                                                    bjVar21 = this.a.x;
                                                    AntiData g = bjVar21.q().g();
                                                    if (d.p() != null) {
                                                        if (g != null && g.getIfpost() == 0) {
                                                            com.baidu.adp.lib.util.k.a((Context) this.a, g.getForbid_info());
                                                            return;
                                                        } else {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bi(this.a, 2, c.getId(), c.getName(), d.p(), n.getPostId(), 0, g, 13008, false, false, null, false, false, null, n, null)));
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else {
                                                    com.baidu.adp.lib.util.k.a((Context) this.a, String.format(this.a.getString(com.baidu.tieba.y.write_addition_limit), Integer.valueOf(n.getTotalCount())));
                                                    return;
                                                }
                                            }
                                            bqVar26 = this.a.D;
                                            if (view == bqVar26.g().b()) {
                                                bqVar55 = this.a.D;
                                                bqVar55.ac();
                                                b = this.a.b(11009);
                                                if (b) {
                                                    bjVar17 = this.a.x;
                                                    bqVar56 = this.a.D;
                                                    if (bjVar17.f(bqVar56.K()) == null) {
                                                        return;
                                                    }
                                                    this.a.z();
                                                    return;
                                                }
                                                return;
                                            }
                                            bqVar27 = this.a.D;
                                            if (view == bqVar27.g().c()) {
                                                bqVar54 = this.a.D;
                                                bqVar54.ac();
                                                this.a.D();
                                                this.a.E();
                                                return;
                                            }
                                            bqVar28 = this.a.D;
                                            if (view == bqVar28.g().e()) {
                                                bqVar52 = this.a.D;
                                                bqVar52.ac();
                                                bjVar15 = this.a.x;
                                                if (bjVar15.r() != null) {
                                                    bqVar53 = this.a.D;
                                                    bjVar16 = this.a.x;
                                                    bqVar53.a(bjVar16.r());
                                                }
                                                TiebaStatic.eventStat(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            bqVar29 = this.a.D;
                                            if (view == bqVar29.g().f()) {
                                                bqVar50 = this.a.D;
                                                bqVar50.ac();
                                                this.a.D();
                                                bjVar14 = this.a.x;
                                                bjVar14.w();
                                                bqVar51 = this.a.D;
                                                bqVar51.t();
                                                TiebaStatic.eventStat(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            bpVar = this.a.H;
                                            if (view != bpVar.c()) {
                                                bqVar30 = this.a.D;
                                                if (bqVar30.c() != view) {
                                                    bpVar2 = this.a.H;
                                                    if (view == bpVar2.e()) {
                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                        if (sparseArray2 != null) {
                                                            if ("".equals(sparseArray2.get(com.baidu.tieba.v.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                bqVar48 = this.a.D;
                                                                bqVar48.a(((Integer) sparseArray2.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
                                                            } else {
                                                                bqVar49 = this.a.D;
                                                                bqVar49.a(view);
                                                            }
                                                            iVar6 = this.a.G;
                                                            iVar6.dismiss();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != com.baidu.tieba.v.pb_head_function_manage_delormanage) {
                                                        bpVar3 = this.a.H;
                                                        if (view == bpVar3.d() || view.getId() == com.baidu.tieba.v.sub_pb_more || view.getId() == com.baidu.tieba.v.sub_pb_item) {
                                                            bpVar4 = this.a.H;
                                                            if (view == bpVar4.d()) {
                                                                bpVar6 = this.a.H;
                                                                if (!bpVar6.a()) {
                                                                    iVar2 = this.a.G;
                                                                    iVar2.dismiss();
                                                                    bqVar34 = this.a.D;
                                                                    bqVar34.b(true);
                                                                    return;
                                                                }
                                                            }
                                                            try {
                                                                bjVar4 = this.a.x;
                                                                if (bjVar4.q() != null) {
                                                                    bqVar31 = this.a.D;
                                                                    bqVar31.ac();
                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                    com.baidu.tieba.data.ai aiVar = (com.baidu.tieba.data.ai) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_data);
                                                                    View view2 = (View) sparseArray3.get(com.baidu.tieba.v.tag_load_sub_view);
                                                                    if (aiVar != null && view2 != null) {
                                                                        bjVar5 = this.a.x;
                                                                        com.baidu.tieba.data.ap a = bjVar5.a(aiVar);
                                                                        fVar = this.a.B;
                                                                        bjVar6 = this.a.x;
                                                                        fVar.a(bjVar6.g());
                                                                        fVar2 = this.a.B;
                                                                        fVar2.b(aiVar.l());
                                                                        fVar3 = this.a.B;
                                                                        fVar3.d();
                                                                        this.a.D();
                                                                        bpVar5 = this.a.H;
                                                                        if (view == bpVar5.d()) {
                                                                            iVar = this.a.G;
                                                                            iVar.dismiss();
                                                                            bqVar33 = this.a.D;
                                                                            bjVar8 = this.a.x;
                                                                            bqVar33.a(true, a, false, null, null, view2, bjVar8.q().l());
                                                                            return;
                                                                        } else if (view.getId() != com.baidu.tieba.v.sub_pb_item) {
                                                                            handler = this.a.w;
                                                                            handler.post(new av(this, a, view2));
                                                                            return;
                                                                        } else {
                                                                            SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                            String str2 = (String) sparseArray4.get(com.baidu.tieba.v.tag_photo_username);
                                                                            com.baidu.tieba.data.ai aiVar2 = (com.baidu.tieba.data.ai) sparseArray4.get(com.baidu.tieba.v.tag_clip_board);
                                                                            String str3 = null;
                                                                            if (aiVar2 != null) {
                                                                                str3 = aiVar2.l();
                                                                            }
                                                                            bqVar32 = this.a.D;
                                                                            bjVar7 = this.a.x;
                                                                            bqVar32.a(true, a, false, str2, str3, view2, bjVar7.q().l());
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
                                                        if (id3 == com.baidu.tieba.v.dialog_button_ok) {
                                                            bqVar42 = this.a.D;
                                                            bqVar42.ac();
                                                            bqVar43 = this.a.D;
                                                            if (bqVar43.L() < 0) {
                                                                return;
                                                            }
                                                            this.a.D();
                                                            bjVar13 = this.a.x;
                                                            bqVar44 = this.a.D;
                                                            bjVar13.c(bqVar44.L());
                                                            bqVar45 = this.a.D;
                                                            bqVar45.t();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.dialog_button_cancel) {
                                                            bqVar41 = this.a.D;
                                                            bqVar41.ac();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.reply) {
                                                            iVar3 = this.a.G;
                                                            if (iVar3 != null) {
                                                                com.baidu.tieba.data.ai aiVar3 = null;
                                                                if (view != null && view.getTag() != null) {
                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                    aiVar3 = (com.baidu.tieba.data.ai) sparseArray5.get(com.baidu.tieba.v.tag_load_sub_data);
                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                    sparseArray6.put(com.baidu.tieba.v.tag_load_sub_data, aiVar3);
                                                                    sparseArray6.put(com.baidu.tieba.v.tag_load_sub_view, (View) sparseArray5.get(com.baidu.tieba.v.tag_load_sub_view));
                                                                    bpVar16 = this.a.H;
                                                                    bpVar16.d().setTag(sparseArray6);
                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                    sparseArray7.put(com.baidu.tieba.v.tag_clip_board, (com.baidu.tieba.data.ai) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board));
                                                                    sparseArray7.put(com.baidu.tieba.v.tag_is_subpb, false);
                                                                    bpVar17 = this.a.H;
                                                                    bpVar17.c().setTag(sparseArray7);
                                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                    if (!((Boolean) sparseArray8.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                                        bpVar18 = this.a.H;
                                                                        bpVar18.e().setVisibility(8);
                                                                    } else {
                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray8.get(com.baidu.tieba.v.tag_manage_user_identity));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray8.get(com.baidu.tieba.v.tag_del_post_is_self));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_del_post_id, sparseArray8.get(com.baidu.tieba.v.tag_del_post_id));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_del_post_type, sparseArray8.get(com.baidu.tieba.v.tag_del_post_type));
                                                                        sparseArray9.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray8.get(com.baidu.tieba.v.tag_forbid_user_name));
                                                                        bpVar19 = this.a.H;
                                                                        bpVar19.e().setTag(sparseArray9);
                                                                        int skinType = TbadkApplication.m252getInst().getSkinType();
                                                                        if (!"".equals(sparseArray8.get(com.baidu.tieba.v.tag_forbid_user_name)) && !"".equals(sparseArray8.get(com.baidu.tieba.v.tag_del_post_id))) {
                                                                            if (skinType == 1) {
                                                                                bpVar24 = this.a.H;
                                                                                bpVar24.e().setImageResource(com.baidu.tieba.u.icon_pb_set_n_1);
                                                                            } else {
                                                                                bpVar23 = this.a.H;
                                                                                bpVar23.e().setImageResource(com.baidu.tieba.u.icon_pb_set_n);
                                                                            }
                                                                        } else if (skinType == 1) {
                                                                            bpVar21 = this.a.H;
                                                                            bpVar21.e().setImageResource(com.baidu.tieba.u.icon_pb_del_n_1);
                                                                        } else {
                                                                            bpVar20 = this.a.H;
                                                                            bpVar20.e().setImageResource(com.baidu.tieba.u.icon_pb_del_n);
                                                                        }
                                                                        bpVar22 = this.a.H;
                                                                        bpVar22.e().setVisibility(0);
                                                                    }
                                                                }
                                                                boolean z2 = false;
                                                                bjVar11 = this.a.x;
                                                                if (bjVar11.q().i()) {
                                                                    bjVar12 = this.a.x;
                                                                    String j = bjVar12.q().j();
                                                                    if (aiVar3 != null && !com.baidu.adp.lib.util.j.b(j) && j.equals(aiVar3.l())) {
                                                                        z2 = true;
                                                                    }
                                                                }
                                                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                                                    if (z2) {
                                                                        bpVar14 = this.a.H;
                                                                        bpVar14.c().setText(com.baidu.tieba.y.marked);
                                                                        bpVar15 = this.a.H;
                                                                        bpVar15.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s_1, 0, 0, 0);
                                                                    } else {
                                                                        bpVar12 = this.a.H;
                                                                        bpVar12.c().setText(com.baidu.tieba.y.mark);
                                                                        bpVar13 = this.a.H;
                                                                        bpVar13.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n_1, 0, 0, 0);
                                                                    }
                                                                } else if (z2) {
                                                                    bpVar9 = this.a.H;
                                                                    bpVar9.c().setText(com.baidu.tieba.y.marked);
                                                                    bpVar10 = this.a.H;
                                                                    bpVar10.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s, 0, 0, 0);
                                                                } else {
                                                                    bpVar7 = this.a.H;
                                                                    bpVar7.c().setText(com.baidu.tieba.y.mark);
                                                                    bpVar8 = this.a.H;
                                                                    bpVar8.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n, 0, 0, 0);
                                                                }
                                                                bpVar11 = this.a.H;
                                                                bpVar11.a(true);
                                                                iVar4 = this.a.G;
                                                                iVar4.a();
                                                                iVar5 = this.a.G;
                                                                iVar5.a(view, false);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.sub_post_load_more) {
                                                            fVar6 = this.a.B;
                                                            if (fVar6.h()) {
                                                                bqVar40 = this.a.D;
                                                                bqVar40.B();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.sub_pb_bottom_layout) {
                                                            bjVar10 = this.a.x;
                                                            if (bjVar10.n()) {
                                                                this.a.closeActivity();
                                                                return;
                                                            }
                                                            this.a.D();
                                                            bqVar39 = this.a.D;
                                                            bqVar39.E();
                                                            fVar5 = this.a.B;
                                                            fVar5.cancelLoadData();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.btn_loadprevious) {
                                                            fVar4 = this.a.B;
                                                            if (fVar4.k()) {
                                                                bqVar38 = this.a.D;
                                                                bqVar38.C();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.v.pb_new_guide) {
                                                            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                            edit.putBoolean("has_shown_pb_guide", true);
                                                            edit.commit();
                                                            bqVar37 = this.a.D;
                                                            bqVar37.o();
                                                            return;
                                                        } else if (id3 != com.baidu.tieba.v.pb_head_reverse_hint) {
                                                            return;
                                                        } else {
                                                            this.a.D();
                                                            bqVar35 = this.a.D;
                                                            bqVar35.ac();
                                                            bjVar9 = this.a.x;
                                                            bjVar9.w();
                                                            bqVar36 = this.a.D;
                                                            bqVar36.t();
                                                            return;
                                                        }
                                                    } else {
                                                        SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                        if (((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_should_manage_visible)).booleanValue()) {
                                                            bqVar47 = this.a.D;
                                                            bqVar47.a(view);
                                                            return;
                                                        }
                                                        bqVar46 = this.a.D;
                                                        bqVar46.a(((Integer) sparseArray10.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
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
                                        bjVar22 = this.a.x;
                                        bjVar22.v();
                                        bqVar57 = this.a.D;
                                        bqVar57.t();
                                        TiebaStatic.eventStat(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    this.a.k();
                                    return;
                                }
                                TiebaStatic.eventStat(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bjVar23 = this.a.x;
                                String name3 = bjVar23.q().c().getName();
                                bjVar24 = this.a.x;
                                if (!TextUtils.isEmpty(bjVar24.f())) {
                                    bjVar25 = this.a.x;
                                    if (bjVar25.f().equals(name3)) {
                                        this.a.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.be.b(name3)) {
                                    this.a.sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.a).a(name3, "tb_pb")));
                                    return;
                                }
                                return;
                            }
                            iVar8 = this.a.G;
                            if (iVar8 != null) {
                                com.baidu.tieba.data.ai aiVar4 = null;
                                if (view != null && view.getTag() != null) {
                                    aiVar4 = (com.baidu.tieba.data.ai) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_clip_board);
                                    SparseArray sparseArray11 = new SparseArray();
                                    sparseArray11.put(com.baidu.tieba.v.tag_clip_board, aiVar4);
                                    sparseArray11.put(com.baidu.tieba.v.tag_is_subpb, false);
                                    bpVar35 = this.a.H;
                                    bpVar35.c().setTag(sparseArray11);
                                }
                                bjVar26 = this.a.x;
                                if (bjVar26.q().i()) {
                                    bjVar27 = this.a.x;
                                    String j2 = bjVar27.q().j();
                                    if (aiVar4 != null && !com.baidu.adp.lib.util.j.b(j2) && j2.equals(aiVar4.l())) {
                                        z = true;
                                        if (TbadkApplication.m252getInst().getSkinType() != 1) {
                                            if (z) {
                                                bpVar33 = this.a.H;
                                                bpVar33.c().setText(com.baidu.tieba.y.marked);
                                                bpVar34 = this.a.H;
                                                bpVar34.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s_1, 0, 0, 0);
                                            } else {
                                                bpVar31 = this.a.H;
                                                bpVar31.c().setText(com.baidu.tieba.y.mark);
                                                bpVar32 = this.a.H;
                                                bpVar32.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n_1, 0, 0, 0);
                                            }
                                        } else if (z) {
                                            bpVar27 = this.a.H;
                                            bpVar27.c().setText(com.baidu.tieba.y.marked);
                                            bpVar28 = this.a.H;
                                            bpVar28.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_s, 0, 0, 0);
                                        } else {
                                            bpVar25 = this.a.H;
                                            bpVar25.c().setText(com.baidu.tieba.y.mark);
                                            bpVar26 = this.a.H;
                                            bpVar26.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_pb_collect_n, 0, 0, 0);
                                        }
                                        bpVar29 = this.a.H;
                                        bpVar29.e().setVisibility(8);
                                        bpVar30 = this.a.H;
                                        bpVar30.a(false);
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
                                bpVar29 = this.a.H;
                                bpVar29.e().setVisibility(8);
                                bpVar30 = this.a.H;
                                bpVar30.a(false);
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
        bqVar4 = this.a.D;
        bqVar4.ad();
        bjVar = this.a.x;
        if (bjVar.q().l() == 1) {
            vVar = this.a.C;
            if (!vVar.b()) {
                bqVar5 = this.a.D;
                bqVar5.n();
                int i = 0;
                bqVar6 = this.a.D;
                if (view != bqVar6.U()) {
                    bqVar7 = this.a.D;
                    if (view != bqVar7.V()) {
                        bqVar8 = this.a.D;
                        if (view != bqVar8.W()) {
                            bqVar9 = this.a.D;
                            if (view != bqVar9.X()) {
                                bqVar10 = this.a.D;
                                if (view == bqVar10.q()) {
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
                bjVar2 = this.a.x;
                ForumData c2 = bjVar2.q().c();
                String name4 = c2.getName();
                String id4 = c2.getId();
                bjVar3 = this.a.x;
                String p = bjVar3.q().d().p();
                vVar2 = this.a.C;
                bqVar11 = this.a.D;
                vVar2.a(id4, name4, p, i, bqVar11.r());
            }
        }
    }
}
