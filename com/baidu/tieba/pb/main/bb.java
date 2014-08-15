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
class bb implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0453  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bl blVar;
        com.baidu.tieba.model.u uVar;
        bs bsVar5;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        bs bsVar10;
        bl blVar2;
        bl blVar3;
        com.baidu.tieba.model.u uVar2;
        bs bsVar11;
        bs bsVar12;
        bs bsVar13;
        bs bsVar14;
        bs bsVar15;
        bs bsVar16;
        bs bsVar17;
        bs bsVar18;
        bs bsVar19;
        bs bsVar20;
        bs bsVar21;
        bs bsVar22;
        bs bsVar23;
        bs bsVar24;
        bs bsVar25;
        bs bsVar26;
        bs bsVar27;
        bs bsVar28;
        br brVar;
        bs bsVar29;
        br brVar2;
        br brVar3;
        br brVar4;
        bl blVar4;
        bs bsVar30;
        bl blVar5;
        com.baidu.tieba.pb.sub.e eVar;
        bl blVar6;
        com.baidu.tieba.pb.sub.e eVar2;
        com.baidu.tieba.pb.sub.e eVar3;
        br brVar5;
        Handler handler;
        bs bsVar31;
        bl blVar7;
        com.baidu.tbadk.core.view.m mVar;
        bs bsVar32;
        bl blVar8;
        br brVar6;
        com.baidu.tbadk.core.view.m mVar2;
        bs bsVar33;
        bs bsVar34;
        bs bsVar35;
        bl blVar9;
        bs bsVar36;
        com.baidu.tieba.pb.sub.e eVar4;
        bs bsVar37;
        bl blVar10;
        bs bsVar38;
        com.baidu.tieba.pb.sub.e eVar5;
        com.baidu.tieba.pb.sub.e eVar6;
        bs bsVar39;
        com.baidu.tbadk.core.view.m mVar3;
        bl blVar11;
        br brVar7;
        br brVar8;
        br brVar9;
        br brVar10;
        br brVar11;
        com.baidu.tbadk.core.view.m mVar4;
        com.baidu.tbadk.core.view.m mVar5;
        br brVar12;
        br brVar13;
        br brVar14;
        br brVar15;
        bl blVar12;
        br brVar16;
        br brVar17;
        br brVar18;
        br brVar19;
        br brVar20;
        br brVar21;
        br brVar22;
        br brVar23;
        br brVar24;
        bs bsVar40;
        bl blVar13;
        bs bsVar41;
        bs bsVar42;
        bs bsVar43;
        bl blVar14;
        bs bsVar44;
        bs bsVar45;
        bs bsVar46;
        bs bsVar47;
        com.baidu.tbadk.core.view.m mVar6;
        bs bsVar48;
        com.baidu.tbadk.core.view.m mVar7;
        bs bsVar49;
        bs bsVar50;
        bl blVar15;
        bs bsVar51;
        bl blVar16;
        bs bsVar52;
        bl blVar17;
        bs bsVar53;
        bs bsVar54;
        boolean b;
        bl blVar18;
        bs bsVar55;
        bl blVar19;
        bl blVar20;
        bl blVar21;
        bl blVar22;
        bl blVar23;
        bl blVar24;
        bs bsVar56;
        bl blVar25;
        bl blVar26;
        bl blVar27;
        bl blVar28;
        com.baidu.tieba.pb.sub.e eVar7;
        com.baidu.tieba.pb.sub.e eVar8;
        com.baidu.tieba.pb.sub.e eVar9;
        com.baidu.tieba.pb.sub.e eVar10;
        bs bsVar57;
        com.baidu.tbadk.core.view.m mVar8;
        bl blVar29;
        boolean z;
        br brVar25;
        br brVar26;
        br brVar27;
        br brVar28;
        br brVar29;
        br brVar30;
        com.baidu.tbadk.core.view.m mVar9;
        com.baidu.tbadk.core.view.m mVar10;
        br brVar31;
        br brVar32;
        br brVar33;
        br brVar34;
        bl blVar30;
        bl blVar31;
        br brVar35;
        bs bsVar58;
        com.baidu.tieba.model.u uVar3;
        bs bsVar59;
        bl blVar32;
        com.baidu.tieba.model.u uVar4;
        bl blVar33;
        bl blVar34;
        bl blVar35;
        com.baidu.tieba.pb.sub.e eVar11;
        com.baidu.tieba.pb.sub.e eVar12;
        com.baidu.tieba.pb.sub.e eVar13;
        com.baidu.tieba.pb.sub.e eVar14;
        com.baidu.tieba.model.u uVar5;
        com.baidu.tieba.pb.sub.e eVar15;
        com.baidu.tieba.pb.sub.e eVar16;
        com.baidu.tieba.pb.sub.e eVar17;
        bl blVar36;
        bl blVar37;
        bs bsVar60;
        bl blVar38;
        bl blVar39;
        bs bsVar61;
        bsVar = this.a.D;
        if (view == bsVar.R()) {
            blVar39 = this.a.x;
            if (blVar39.a(true)) {
                bsVar61 = this.a.D;
                bsVar61.w();
                return;
            }
            return;
        }
        bsVar2 = this.a.D;
        if (view == bsVar2.i) {
            bsVar60 = this.a.D;
            blVar38 = this.a.x;
            if (!bsVar60.f(blVar38.o())) {
                this.a.closeActivity();
                return;
            } else {
                this.a.G();
                return;
            }
        }
        bsVar3 = this.a.D;
        if (view != bsVar3.V()) {
            bsVar12 = this.a.D;
            if (view != bsVar12.W()) {
                bsVar13 = this.a.D;
                if (view != bsVar13.X()) {
                    bsVar14 = this.a.D;
                    if (view != bsVar14.Y()) {
                        bsVar15 = this.a.D;
                        if (view != bsVar15.r()) {
                            bsVar16 = this.a.D;
                            if (view == bsVar16.ag()) {
                                blVar36 = this.a.x;
                                if (blVar36 != null) {
                                    blVar37 = this.a.x;
                                    com.baidu.tbadk.browser.a.a(this.a, blVar37.r().d().p().c());
                                    return;
                                }
                                return;
                            }
                            bsVar17 = this.a.D;
                            if (view == bsVar17.q()) {
                                bsVar58 = this.a.D;
                                bsVar58.ae();
                                String currentAccount = TbadkApplication.getCurrentAccount();
                                if (currentAccount != null && currentAccount.length() > 0) {
                                    uVar3 = this.a.C;
                                    if (!uVar3.b()) {
                                        bsVar59 = this.a.D;
                                        bsVar59.o();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(com.baidu.tieba.u.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(com.baidu.tieba.u.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.u.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(com.baidu.tieba.u.tag_del_post_type)).intValue();
                                            blVar32 = this.a.x;
                                            if (blVar32.o()) {
                                                eVar11 = this.a.B;
                                                if (eVar11 != null) {
                                                    eVar12 = this.a.B;
                                                    if (eVar12.e() != null) {
                                                        eVar13 = this.a.B;
                                                        if (eVar13.e().i() != null) {
                                                            eVar14 = this.a.B;
                                                            if (eVar14.e().n() != null) {
                                                                uVar5 = this.a.C;
                                                                eVar15 = this.a.B;
                                                                String id = eVar15.e().i().getId();
                                                                eVar16 = this.a.B;
                                                                String name = eVar16.e().i().getName();
                                                                eVar17 = this.a.B;
                                                                uVar5.a(id, name, eVar17.e().n().h(), str, intValue2, intValue, booleanValue);
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
                                            uVar4 = this.a.C;
                                            blVar33 = this.a.x;
                                            String id2 = blVar33.r().c().getId();
                                            blVar34 = this.a.x;
                                            String name2 = blVar34.r().c().getName();
                                            blVar35 = this.a.x;
                                            uVar4.a(id2, name2, blVar35.r().d().h(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(com.baidu.tieba.x.login_to_use), true, 11017);
                                return;
                            }
                            bsVar18 = this.a.D;
                            if (view != bsVar18.Z()) {
                                bsVar19 = this.a.D;
                                if (view == bsVar19.t()) {
                                    eVar10 = this.a.B;
                                    if (eVar10.j()) {
                                        bsVar57 = this.a.D;
                                        bsVar57.C();
                                        return;
                                    }
                                    return;
                                }
                                bsVar20 = this.a.D;
                                if (view == bsVar20.l()) {
                                    eVar7 = this.a.B;
                                    if (eVar7 != null) {
                                        eVar8 = this.a.B;
                                        if (eVar8.a() != null) {
                                            PbActivity pbActivity = this.a;
                                            com.baidu.tbadk.core.atomData.bb bbVar = new com.baidu.tbadk.core.atomData.bb(this.a);
                                            eVar9 = this.a.B;
                                            pbActivity.sendMessage(new CustomMessage(2004001, bbVar.a(eVar9.a(), null, null)));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                bsVar21 = this.a.D;
                                if (view != bsVar21.c) {
                                    bsVar22 = this.a.D;
                                    if (view != bsVar22.e) {
                                        bsVar23 = this.a.D;
                                        if (view != bsVar23.d) {
                                            bsVar24 = this.a.D;
                                            if (view == bsVar24.f) {
                                                blVar19 = this.a.x;
                                                AdditionData n = blVar19.r().n();
                                                if (!TextUtils.isEmpty(n.getWarnMsg())) {
                                                    com.baidu.adp.lib.util.j.a((Context) this.a, n.getWarnMsg());
                                                    return;
                                                } else if (n.getAlreadyCount() != n.getTotalCount()) {
                                                    blVar20 = this.a.x;
                                                    ForumData c = blVar20.r().c();
                                                    blVar21 = this.a.x;
                                                    com.baidu.tbadk.core.data.n d = blVar21.r().d();
                                                    blVar22 = this.a.x;
                                                    AntiData g = blVar22.r().g();
                                                    if (d.h() != null) {
                                                        if (g != null && g.getIfpost() == 0) {
                                                            com.baidu.adp.lib.util.j.a((Context) this.a, g.getForbid_info());
                                                            return;
                                                        }
                                                        int i = 0;
                                                        blVar23 = this.a.x;
                                                        if (blVar23.r().h() != null) {
                                                            blVar24 = this.a.x;
                                                            i = blVar24.r().h().getIsMem();
                                                        }
                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ce(this.a, 2, c.getId(), c.getName(), d.h(), n.getPostId(), 0, g, 13008, false, false, null, false, false, null, n, null, i)));
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    com.baidu.adp.lib.util.j.a((Context) this.a, String.format(this.a.getString(com.baidu.tieba.x.write_addition_limit), Integer.valueOf(n.getTotalCount())));
                                                    return;
                                                }
                                            }
                                            bsVar25 = this.a.D;
                                            if (view == bsVar25.h().b()) {
                                                bsVar54 = this.a.D;
                                                bsVar54.ad();
                                                b = this.a.b(11009);
                                                if (b) {
                                                    blVar18 = this.a.x;
                                                    bsVar55 = this.a.D;
                                                    if (blVar18.h(bsVar55.L()) == null) {
                                                        return;
                                                    }
                                                    this.a.C();
                                                    return;
                                                }
                                                return;
                                            }
                                            bsVar26 = this.a.D;
                                            if (view == bsVar26.h().c()) {
                                                bsVar53 = this.a.D;
                                                bsVar53.ad();
                                                this.a.G();
                                                this.a.H();
                                                return;
                                            }
                                            bsVar27 = this.a.D;
                                            if (view == bsVar27.h().e()) {
                                                bsVar51 = this.a.D;
                                                bsVar51.ad();
                                                blVar16 = this.a.x;
                                                if (blVar16.s() != null) {
                                                    bsVar52 = this.a.D;
                                                    blVar17 = this.a.x;
                                                    bsVar52.a(blVar17.s());
                                                }
                                                TiebaStatic.eventStat(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            bsVar28 = this.a.D;
                                            if (view == bsVar28.h().f()) {
                                                bsVar49 = this.a.D;
                                                bsVar49.ad();
                                                this.a.G();
                                                bsVar50 = this.a.D;
                                                bsVar50.u();
                                                blVar15 = this.a.x;
                                                blVar15.y();
                                                TiebaStatic.eventStat(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                            brVar = this.a.H;
                                            if (view != brVar.c()) {
                                                bsVar29 = this.a.D;
                                                if (bsVar29.d() != view) {
                                                    brVar2 = this.a.H;
                                                    if (view == brVar2.e()) {
                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                        if (sparseArray2 != null) {
                                                            if ("".equals(sparseArray2.get(com.baidu.tieba.u.tag_forbid_user_name)) || "".equals(sparseArray2.get(com.baidu.tieba.u.tag_del_post_id))) {
                                                                bsVar47 = this.a.D;
                                                                bsVar47.a(((Integer) sparseArray2.get(com.baidu.tieba.u.tag_del_post_type)).intValue(), (String) sparseArray2.get(com.baidu.tieba.u.tag_del_post_id), ((Integer) sparseArray2.get(com.baidu.tieba.u.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(com.baidu.tieba.u.tag_del_post_is_self)).booleanValue());
                                                            } else {
                                                                bsVar48 = this.a.D;
                                                                bsVar48.a(view);
                                                            }
                                                            mVar6 = this.a.G;
                                                            mVar6.dismiss();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != com.baidu.tieba.u.pb_head_function_manage_delormanage) {
                                                        brVar3 = this.a.H;
                                                        if (view == brVar3.d() || view.getId() == com.baidu.tieba.u.sub_pb_more || view.getId() == com.baidu.tieba.u.sub_pb_item) {
                                                            brVar4 = this.a.H;
                                                            if (view == brVar4.d()) {
                                                                brVar6 = this.a.H;
                                                                if (!brVar6.a()) {
                                                                    mVar2 = this.a.G;
                                                                    mVar2.dismiss();
                                                                    bsVar33 = this.a.D;
                                                                    bsVar33.b(true);
                                                                    return;
                                                                }
                                                            }
                                                            try {
                                                                blVar4 = this.a.x;
                                                                if (blVar4.r() != null) {
                                                                    bsVar30 = this.a.D;
                                                                    bsVar30.ad();
                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                    com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) sparseArray3.get(com.baidu.tieba.u.tag_load_sub_data);
                                                                    View view2 = (View) sparseArray3.get(com.baidu.tieba.u.tag_load_sub_view);
                                                                    if (anVar != null && view2 != null) {
                                                                        blVar5 = this.a.x;
                                                                        com.baidu.tieba.data.au a = blVar5.a(anVar);
                                                                        eVar = this.a.B;
                                                                        blVar6 = this.a.x;
                                                                        eVar.a(blVar6.g());
                                                                        eVar2 = this.a.B;
                                                                        eVar2.b(anVar.d());
                                                                        eVar3 = this.a.B;
                                                                        eVar3.d();
                                                                        this.a.G();
                                                                        brVar5 = this.a.H;
                                                                        if (view == brVar5.d()) {
                                                                            mVar = this.a.G;
                                                                            mVar.dismiss();
                                                                            bsVar32 = this.a.D;
                                                                            blVar8 = this.a.x;
                                                                            bsVar32.a(true, a, false, null, null, view2, blVar8.r().l());
                                                                            return;
                                                                        } else if (view.getId() != com.baidu.tieba.u.sub_pb_item) {
                                                                            handler = this.a.w;
                                                                            handler.post(new bc(this, a, view2));
                                                                            return;
                                                                        } else {
                                                                            SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                            String str2 = (String) sparseArray4.get(com.baidu.tieba.u.tag_photo_username);
                                                                            com.baidu.tieba.data.an anVar2 = (com.baidu.tieba.data.an) sparseArray4.get(com.baidu.tieba.u.tag_clip_board);
                                                                            String str3 = null;
                                                                            if (anVar2 != null) {
                                                                                str3 = anVar2.d();
                                                                            }
                                                                            bsVar31 = this.a.D;
                                                                            blVar7 = this.a.x;
                                                                            bsVar31.a(true, a, false, str2, str3, view2, blVar7.r().l());
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
                                                        if (id3 == com.baidu.tieba.u.dialog_button_ok) {
                                                            blVar13 = this.a.x;
                                                            com.baidu.tbadk.core.data.l s = blVar13.s();
                                                            bsVar41 = this.a.D;
                                                            int M = bsVar41.M();
                                                            if (M <= 0) {
                                                                this.a.showToast(com.baidu.tieba.x.pb_page_error);
                                                                return;
                                                            } else if (s == null || M <= s.a()) {
                                                                bsVar42 = this.a.D;
                                                                bsVar42.ad();
                                                                this.a.G();
                                                                bsVar43 = this.a.D;
                                                                bsVar43.u();
                                                                blVar14 = this.a.x;
                                                                bsVar44 = this.a.D;
                                                                blVar14.c(bsVar44.M());
                                                                return;
                                                            } else {
                                                                this.a.showToast(com.baidu.tieba.x.pb_page_error);
                                                                return;
                                                            }
                                                        } else if (id3 == com.baidu.tieba.u.dialog_button_cancel) {
                                                            bsVar40 = this.a.D;
                                                            bsVar40.ad();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.u.reply) {
                                                            mVar3 = this.a.G;
                                                            if (mVar3 != null) {
                                                                com.baidu.tieba.data.an anVar3 = null;
                                                                if (view != null && view.getTag() != null) {
                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                    anVar3 = (com.baidu.tieba.data.an) sparseArray5.get(com.baidu.tieba.u.tag_load_sub_data);
                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                    sparseArray6.put(com.baidu.tieba.u.tag_load_sub_data, anVar3);
                                                                    sparseArray6.put(com.baidu.tieba.u.tag_load_sub_view, (View) sparseArray5.get(com.baidu.tieba.u.tag_load_sub_view));
                                                                    brVar16 = this.a.H;
                                                                    brVar16.d().setTag(sparseArray6);
                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                    sparseArray7.put(com.baidu.tieba.u.tag_clip_board, (com.baidu.tieba.data.an) ((SparseArray) view.getTag()).get(com.baidu.tieba.u.tag_clip_board));
                                                                    sparseArray7.put(com.baidu.tieba.u.tag_is_subpb, false);
                                                                    brVar17 = this.a.H;
                                                                    brVar17.c().setTag(sparseArray7);
                                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                    if (!((Boolean) sparseArray8.get(com.baidu.tieba.u.tag_should_manage_visible)).booleanValue()) {
                                                                        brVar18 = this.a.H;
                                                                        brVar18.e().setVisibility(8);
                                                                    } else {
                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                        sparseArray9.put(com.baidu.tieba.u.tag_manage_user_identity, sparseArray8.get(com.baidu.tieba.u.tag_manage_user_identity));
                                                                        sparseArray9.put(com.baidu.tieba.u.tag_del_post_is_self, sparseArray8.get(com.baidu.tieba.u.tag_del_post_is_self));
                                                                        sparseArray9.put(com.baidu.tieba.u.tag_del_post_id, sparseArray8.get(com.baidu.tieba.u.tag_del_post_id));
                                                                        sparseArray9.put(com.baidu.tieba.u.tag_del_post_type, sparseArray8.get(com.baidu.tieba.u.tag_del_post_type));
                                                                        sparseArray9.put(com.baidu.tieba.u.tag_forbid_user_name, sparseArray8.get(com.baidu.tieba.u.tag_forbid_user_name));
                                                                        brVar19 = this.a.H;
                                                                        brVar19.e().setTag(sparseArray9);
                                                                        int skinType = TbadkApplication.m252getInst().getSkinType();
                                                                        if (!"".equals(sparseArray8.get(com.baidu.tieba.u.tag_forbid_user_name)) && !"".equals(sparseArray8.get(com.baidu.tieba.u.tag_del_post_id))) {
                                                                            if (skinType == 1) {
                                                                                brVar24 = this.a.H;
                                                                                brVar24.e().setImageResource(com.baidu.tieba.t.icon_pb_set_n_1);
                                                                            } else {
                                                                                brVar23 = this.a.H;
                                                                                brVar23.e().setImageResource(com.baidu.tieba.t.icon_pb_set_n);
                                                                            }
                                                                        } else if (skinType == 1) {
                                                                            brVar21 = this.a.H;
                                                                            brVar21.e().setImageResource(com.baidu.tieba.t.icon_pb_del_n_1);
                                                                        } else {
                                                                            brVar20 = this.a.H;
                                                                            brVar20.e().setImageResource(com.baidu.tieba.t.icon_pb_del_n);
                                                                        }
                                                                        brVar22 = this.a.H;
                                                                        brVar22.e().setVisibility(0);
                                                                    }
                                                                }
                                                                boolean z2 = false;
                                                                blVar11 = this.a.x;
                                                                if (blVar11.r().i()) {
                                                                    blVar12 = this.a.x;
                                                                    String j = blVar12.r().j();
                                                                    if (anVar3 != null && !com.baidu.adp.lib.util.i.c(j) && j.equals(anVar3.d())) {
                                                                        z2 = true;
                                                                    }
                                                                }
                                                                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                                                                    if (z2) {
                                                                        brVar14 = this.a.H;
                                                                        brVar14.c().setText(com.baidu.tieba.x.marked);
                                                                        brVar15 = this.a.H;
                                                                        brVar15.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_s_1, 0, 0, 0);
                                                                    } else {
                                                                        brVar12 = this.a.H;
                                                                        brVar12.c().setText(com.baidu.tieba.x.mark);
                                                                        brVar13 = this.a.H;
                                                                        brVar13.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_n_1, 0, 0, 0);
                                                                    }
                                                                } else if (z2) {
                                                                    brVar9 = this.a.H;
                                                                    brVar9.c().setText(com.baidu.tieba.x.marked);
                                                                    brVar10 = this.a.H;
                                                                    brVar10.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_s, 0, 0, 0);
                                                                } else {
                                                                    brVar7 = this.a.H;
                                                                    brVar7.c().setText(com.baidu.tieba.x.mark);
                                                                    brVar8 = this.a.H;
                                                                    brVar8.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_n, 0, 0, 0);
                                                                }
                                                                brVar11 = this.a.H;
                                                                brVar11.a(true);
                                                                mVar4 = this.a.G;
                                                                mVar4.a();
                                                                mVar5 = this.a.G;
                                                                mVar5.a(view, false);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.u.sub_post_load_more) {
                                                            eVar6 = this.a.B;
                                                            if (eVar6.j()) {
                                                                bsVar39 = this.a.D;
                                                                bsVar39.C();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.u.sub_pb_bottom_layout) {
                                                            blVar10 = this.a.x;
                                                            if (blVar10.o()) {
                                                                this.a.closeActivity();
                                                                return;
                                                            }
                                                            this.a.G();
                                                            bsVar38 = this.a.D;
                                                            bsVar38.F();
                                                            eVar5 = this.a.B;
                                                            eVar5.cancelLoadData();
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.u.btn_loadprevious) {
                                                            eVar4 = this.a.B;
                                                            if (eVar4.n()) {
                                                                bsVar37 = this.a.D;
                                                                bsVar37.D();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == com.baidu.tieba.u.pb_new_guide) {
                                                            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
                                                            edit.putBoolean("has_shown_pb_guide", true);
                                                            edit.commit();
                                                            bsVar36 = this.a.D;
                                                            bsVar36.p();
                                                            return;
                                                        } else if (id3 != com.baidu.tieba.u.pb_head_reverse_hint) {
                                                            return;
                                                        } else {
                                                            this.a.G();
                                                            bsVar34 = this.a.D;
                                                            bsVar34.ad();
                                                            bsVar35 = this.a.D;
                                                            bsVar35.u();
                                                            blVar9 = this.a.x;
                                                            blVar9.y();
                                                            return;
                                                        }
                                                    } else {
                                                        SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                        if (((Boolean) sparseArray10.get(com.baidu.tieba.u.tag_should_manage_visible)).booleanValue()) {
                                                            bsVar46 = this.a.D;
                                                            bsVar46.a(view);
                                                            return;
                                                        }
                                                        bsVar45 = this.a.D;
                                                        bsVar45.a(((Integer) sparseArray10.get(com.baidu.tieba.u.tag_del_post_type)).intValue(), (String) sparseArray10.get(com.baidu.tieba.u.tag_del_post_id), ((Integer) sparseArray10.get(com.baidu.tieba.u.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(com.baidu.tieba.u.tag_del_post_is_self)).booleanValue());
                                                        return;
                                                    }
                                                }
                                                this.a.u();
                                                return;
                                            }
                                            this.a.a(view);
                                            mVar7 = this.a.G;
                                            mVar7.dismiss();
                                            return;
                                        }
                                        this.a.G();
                                        bsVar56 = this.a.D;
                                        bsVar56.u();
                                        blVar25 = this.a.x;
                                        blVar25.x();
                                        TiebaStatic.eventStat(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    this.a.k();
                                    return;
                                }
                                TiebaStatic.eventStat(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                blVar26 = this.a.x;
                                String name3 = blVar26.r().c().getName();
                                blVar27 = this.a.x;
                                if (!TextUtils.isEmpty(blVar27.f())) {
                                    blVar28 = this.a.x;
                                    if (blVar28.f().equals(name3)) {
                                        this.a.finish();
                                        return;
                                    }
                                }
                                if (com.baidu.tbadk.core.util.ba.b(name3)) {
                                    this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.a).a(name3, "tb_pb")));
                                    return;
                                }
                                return;
                            }
                            mVar8 = this.a.G;
                            if (mVar8 != null) {
                                com.baidu.tieba.data.an anVar4 = null;
                                if (view != null && view.getTag() != null) {
                                    anVar4 = (com.baidu.tieba.data.an) ((SparseArray) view.getTag()).get(com.baidu.tieba.u.tag_clip_board);
                                    SparseArray sparseArray11 = new SparseArray();
                                    sparseArray11.put(com.baidu.tieba.u.tag_clip_board, anVar4);
                                    sparseArray11.put(com.baidu.tieba.u.tag_is_subpb, false);
                                    brVar35 = this.a.H;
                                    brVar35.c().setTag(sparseArray11);
                                }
                                blVar29 = this.a.x;
                                if (blVar29.r() != null) {
                                    blVar30 = this.a.x;
                                    if (blVar30.r().i()) {
                                        blVar31 = this.a.x;
                                        String j2 = blVar31.r().j();
                                        if (anVar4 != null && !com.baidu.adp.lib.util.i.c(j2) && j2.equals(anVar4.d())) {
                                            z = true;
                                            if (TbadkApplication.m252getInst().getSkinType() != 1) {
                                                if (z) {
                                                    brVar33 = this.a.H;
                                                    brVar33.c().setText(com.baidu.tieba.x.marked);
                                                    brVar34 = this.a.H;
                                                    brVar34.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_s_1, 0, 0, 0);
                                                } else {
                                                    brVar31 = this.a.H;
                                                    brVar31.c().setText(com.baidu.tieba.x.mark);
                                                    brVar32 = this.a.H;
                                                    brVar32.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_n_1, 0, 0, 0);
                                                }
                                            } else if (z) {
                                                brVar27 = this.a.H;
                                                brVar27.c().setText(com.baidu.tieba.x.marked);
                                                brVar28 = this.a.H;
                                                brVar28.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_s, 0, 0, 0);
                                            } else {
                                                brVar25 = this.a.H;
                                                brVar25.c().setText(com.baidu.tieba.x.mark);
                                                brVar26 = this.a.H;
                                                brVar26.c().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_pb_collect_n, 0, 0, 0);
                                            }
                                            brVar29 = this.a.H;
                                            brVar29.e().setVisibility(8);
                                            brVar30 = this.a.H;
                                            brVar30.a(false);
                                            mVar9 = this.a.G;
                                            mVar9.a();
                                            mVar10 = this.a.G;
                                            mVar10.a(view, false);
                                            return;
                                        }
                                    }
                                }
                                z = false;
                                if (TbadkApplication.m252getInst().getSkinType() != 1) {
                                }
                                brVar29 = this.a.H;
                                brVar29.e().setVisibility(8);
                                brVar30 = this.a.H;
                                brVar30.a(false);
                                mVar9 = this.a.G;
                                mVar9.a();
                                mVar10 = this.a.G;
                                mVar10.a(view, false);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        bsVar4 = this.a.D;
        bsVar4.ae();
        blVar = this.a.x;
        if (blVar.r().l() == 1) {
            uVar = this.a.C;
            if (!uVar.b()) {
                bsVar5 = this.a.D;
                bsVar5.o();
                int i2 = 0;
                bsVar6 = this.a.D;
                if (view != bsVar6.V()) {
                    bsVar7 = this.a.D;
                    if (view != bsVar7.W()) {
                        bsVar8 = this.a.D;
                        if (view != bsVar8.X()) {
                            bsVar9 = this.a.D;
                            if (view != bsVar9.Y()) {
                                bsVar10 = this.a.D;
                                if (view == bsVar10.r()) {
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
                blVar2 = this.a.x;
                ForumData c2 = blVar2.r().c();
                String name4 = c2.getName();
                String id4 = c2.getId();
                blVar3 = this.a.x;
                String h = blVar3.r().d().h();
                uVar2 = this.a.C;
                bsVar11 = this.a.D;
                uVar2.a(id4, name4, h, i2, bsVar11.s());
            }
        }
    }
}
