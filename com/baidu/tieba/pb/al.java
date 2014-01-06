package com.baidu.tieba.pb;

import android.app.Activity;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.ad adVar;
        cs csVar4;
        cs csVar5;
        cs csVar6;
        cs csVar7;
        cs csVar8;
        cs csVar9;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.ad adVar2;
        cs csVar10;
        cs csVar11;
        cs csVar12;
        cs csVar13;
        cs csVar14;
        cs csVar15;
        cs csVar16;
        cs csVar17;
        cs csVar18;
        cs csVar19;
        cs csVar20;
        cs csVar21;
        cs csVar22;
        cs csVar23;
        com.baidu.tieba.model.bm bmVar4;
        cs csVar24;
        com.baidu.tieba.model.bm bmVar5;
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bm bmVar6;
        com.baidu.tieba.model.bp bpVar2;
        com.baidu.tieba.model.bp bpVar3;
        Handler handler;
        cs csVar25;
        com.baidu.tieba.model.bm bmVar7;
        cs csVar26;
        com.baidu.tieba.model.bm bmVar8;
        com.baidu.tieba.model.bp bpVar4;
        cs csVar27;
        com.baidu.tieba.model.bm bmVar9;
        cs csVar28;
        com.baidu.tieba.model.bp bpVar5;
        com.baidu.tieba.model.bm bmVar10;
        com.baidu.tieba.model.bm bmVar11;
        com.baidu.tieba.model.bm bmVar12;
        com.baidu.tieba.model.bm bmVar13;
        com.baidu.tieba.model.bm bmVar14;
        com.baidu.tieba.model.bm bmVar15;
        cs csVar29;
        cs csVar30;
        cs csVar31;
        com.baidu.tieba.model.bm bmVar16;
        cs csVar32;
        cs csVar33;
        cs csVar34;
        boolean a;
        com.baidu.tieba.model.bm bmVar17;
        cs csVar35;
        cs csVar36;
        com.baidu.tieba.model.bm bmVar18;
        cs csVar37;
        cs csVar38;
        com.baidu.tieba.model.bm bmVar19;
        cs csVar39;
        com.baidu.tieba.model.bm bmVar20;
        cs csVar40;
        com.baidu.tieba.model.bp bpVar6;
        cs csVar41;
        com.baidu.tieba.model.bm bmVar21;
        cs csVar42;
        cs csVar43;
        com.baidu.tieba.model.bm bmVar22;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bm bmVar23;
        com.baidu.tieba.model.bm bmVar24;
        com.baidu.tieba.model.bp bpVar7;
        com.baidu.tieba.model.bp bpVar8;
        com.baidu.tieba.model.bp bpVar9;
        com.baidu.tieba.model.bp bpVar10;
        cs csVar44;
        cs csVar45;
        cs csVar46;
        com.baidu.tieba.model.ad adVar3;
        cs csVar47;
        com.baidu.tieba.model.bm bmVar25;
        com.baidu.tieba.model.ad adVar4;
        com.baidu.tieba.model.bm bmVar26;
        com.baidu.tieba.model.bm bmVar27;
        com.baidu.tieba.model.bm bmVar28;
        com.baidu.tieba.model.bp bpVar11;
        com.baidu.tieba.model.bp bpVar12;
        com.baidu.tieba.model.bp bpVar13;
        com.baidu.tieba.model.bp bpVar14;
        com.baidu.tieba.model.ad adVar5;
        com.baidu.tieba.model.bp bpVar15;
        com.baidu.tieba.model.bp bpVar16;
        com.baidu.tieba.model.bp bpVar17;
        com.baidu.tieba.model.bm bmVar29;
        com.baidu.tieba.model.bm bmVar30;
        com.baidu.tieba.model.bm bmVar31;
        cs csVar48;
        int i = 0;
        csVar = this.a.z;
        if (view == csVar.N()) {
            bmVar31 = this.a.t;
            if (bmVar31.a(true)) {
                csVar48 = this.a.z;
                csVar48.r();
                return;
            }
            return;
        }
        csVar2 = this.a.z;
        if (view != csVar2.R()) {
            csVar11 = this.a.z;
            if (view != csVar11.S()) {
                csVar12 = this.a.z;
                if (view != csVar12.T()) {
                    csVar13 = this.a.z;
                    if (view != csVar13.U()) {
                        csVar14 = this.a.z;
                        if (view != csVar14.m()) {
                            csVar15 = this.a.z;
                            if (view == csVar15.ag()) {
                                bmVar29 = this.a.t;
                                if (bmVar29 != null) {
                                    bmVar30 = this.a.t;
                                    UtilHelper.c(this.a, bmVar30.l().d().i().c());
                                    return;
                                }
                                return;
                            }
                            csVar16 = this.a.z;
                            if (view == csVar16.l()) {
                                csVar46 = this.a.z;
                                csVar46.aa();
                                String A = TiebaApplication.A();
                                if (A != null && A.length() > 0) {
                                    adVar3 = this.a.y;
                                    if (!adVar3.b()) {
                                        csVar47 = this.a.z;
                                        csVar47.k();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bmVar25 = this.a.t;
                                            if (bmVar25.i()) {
                                                bpVar11 = this.a.x;
                                                if (bpVar11 != null) {
                                                    bpVar12 = this.a.x;
                                                    if (bpVar12.e() != null) {
                                                        bpVar13 = this.a.x;
                                                        if (bpVar13.e().h() != null) {
                                                            bpVar14 = this.a.x;
                                                            if (bpVar14.e().m() != null) {
                                                                adVar5 = this.a.y;
                                                                bpVar15 = this.a.x;
                                                                String id = bpVar15.e().h().getId();
                                                                bpVar16 = this.a.x;
                                                                String name = bpVar16.e().h().getName();
                                                                bpVar17 = this.a.x;
                                                                adVar5.a(id, name, bpVar17.e().m().a(), str, intValue2, intValue, booleanValue);
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
                                            adVar4 = this.a.y;
                                            bmVar26 = this.a.t;
                                            String id2 = bmVar26.l().c().getId();
                                            bmVar27 = this.a.t;
                                            String name2 = bmVar27.l().c().getName();
                                            bmVar28 = this.a.t;
                                            adVar4.a(id2, name2, bmVar28.l().d().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            csVar17 = this.a.z;
                            if (view == csVar17.V()) {
                                csVar45 = this.a.z;
                                csVar45.b(true);
                                return;
                            }
                            csVar18 = this.a.z;
                            if (view == csVar18.o()) {
                                bpVar10 = this.a.x;
                                if (bpVar10.h()) {
                                    csVar44 = this.a.z;
                                    csVar44.w();
                                    return;
                                }
                                return;
                            }
                            csVar19 = this.a.z;
                            if (view == csVar19.h()) {
                                bpVar7 = this.a.x;
                                if (bpVar7 != null) {
                                    bpVar8 = this.a.x;
                                    if (bpVar8.a() != null) {
                                        NewPbActivity newPbActivity = this.a;
                                        bpVar9 = this.a.x;
                                        NewPbActivity.a(newPbActivity, bpVar9.a(), (String) null, (String) null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            csVar20 = this.a.z;
                            if (view != csVar20.b) {
                                csVar21 = this.a.z;
                                if (view != csVar21.c) {
                                    csVar22 = this.a.z;
                                    if (view == csVar22.e) {
                                        csVar43 = this.a.z;
                                        bmVar22 = this.a.t;
                                        boolean d = bmVar22.d();
                                        bgVar = this.a.u;
                                        csVar43.a(d, bgVar.a());
                                        return;
                                    }
                                    csVar23 = this.a.z;
                                    if (view == csVar23.d) {
                                        this.a.w();
                                        bmVar21 = this.a.t;
                                        bmVar21.q();
                                        csVar42 = this.a.z;
                                        csVar42.p();
                                        if (TiebaApplication.g().s()) {
                                            StatService.onEvent(this.a, "pb_set_host", "pbclick", 1);
                                            return;
                                        }
                                        return;
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099670 */:
                                            bpVar6 = this.a.x;
                                            if (bpVar6.h()) {
                                                csVar41 = this.a.z;
                                                csVar41.w();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131099953 */:
                                            csVar29 = this.a.z;
                                            csVar29.Z();
                                            return;
                                        case R.id.dialog_button_ok /* 2131099954 */:
                                            csVar30 = this.a.z;
                                            csVar30.Z();
                                            csVar31 = this.a.z;
                                            if (csVar31.I() >= 0) {
                                                this.a.w();
                                                bmVar16 = this.a.t;
                                                csVar32 = this.a.z;
                                                bmVar16.c(csVar32.I());
                                                csVar33 = this.a.z;
                                                csVar33.p();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100635 */:
                                        case R.id.sub_pb_item /* 2131100898 */:
                                        case R.id.sub_pb_more /* 2131100900 */:
                                            try {
                                                bmVar4 = this.a.t;
                                                if (bmVar4.l() != null) {
                                                    csVar24 = this.a.z;
                                                    csVar24.Z();
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) sparseArray2.get(R.id.tag_load_sub_data);
                                                    View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                    if (asVar != null && view2 != null) {
                                                        bmVar5 = this.a.t;
                                                        com.baidu.tieba.data.ax a2 = bmVar5.a(asVar);
                                                        bpVar = this.a.x;
                                                        bmVar6 = this.a.t;
                                                        bpVar.a(bmVar6.b());
                                                        bpVar2 = this.a.x;
                                                        bpVar2.b(asVar.d());
                                                        bpVar3 = this.a.x;
                                                        bpVar3.d();
                                                        this.a.w();
                                                        if (view.getId() == R.id.reply) {
                                                            csVar26 = this.a.z;
                                                            bmVar8 = this.a.t;
                                                            csVar26.a(true, a2, false, null, null, view2, bmVar8.l().l());
                                                            return;
                                                        } else if (view.getId() != R.id.sub_pb_item) {
                                                            handler = this.a.s;
                                                            handler.post(new am(this, a2, view2));
                                                            return;
                                                        } else {
                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                            String str2 = (String) sparseArray3.get(R.id.tag_photo_username);
                                                            com.baidu.tieba.data.as asVar2 = (com.baidu.tieba.data.as) sparseArray3.get(R.id.tag_clip_board);
                                                            String d2 = asVar2 != null ? asVar2.d() : null;
                                                            csVar25 = this.a.z;
                                                            bmVar7 = this.a.t;
                                                            csVar25.a(true, a2, false, str2, d2, view2, bmVar7.l().l());
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.tieba.util.bo.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.btn_image_upload_camera /* 2131100651 */:
                                            com.baidu.tieba.write.bb.a(this.a);
                                            return;
                                        case R.id.btn_image_upload_album /* 2131100652 */:
                                            com.baidu.tieba.write.bb.b(this.a);
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100850 */:
                                            bmVar10 = this.a.t;
                                            if (bmVar10 != null) {
                                                bmVar11 = this.a.t;
                                                if (bmVar11.l() != null) {
                                                    bmVar12 = this.a.t;
                                                    if (bmVar12.l().c() != null) {
                                                        bmVar13 = this.a.t;
                                                        String name3 = bmVar13.l().c().getName();
                                                        if (name3 != null && name3.length() > 0) {
                                                            bmVar14 = this.a.t;
                                                            if (name3.equals(bmVar14.a())) {
                                                                bmVar15 = this.a.t;
                                                                if (bmVar15.e()) {
                                                                    this.a.closeActivity();
                                                                    return;
                                                                }
                                                            }
                                                            FrsActivity.a(this.a, name3, (String) null);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case R.id.floor /* 2131100871 */:
                                            this.a.a(view);
                                            return;
                                        case R.id.mark_txt /* 2131100883 */:
                                            csVar34 = this.a.z;
                                            csVar34.Z();
                                            a = this.a.a(11009);
                                            if (a) {
                                                bmVar17 = this.a.t;
                                                csVar35 = this.a.z;
                                                if (bmVar17.f(csVar35.H()) != null) {
                                                    this.a.s();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case R.id.share_txt /* 2131100885 */:
                                            this.a.w();
                                            csVar40 = this.a.z;
                                            csVar40.Z();
                                            this.a.x();
                                            return;
                                        case R.id.skip_txt /* 2131100887 */:
                                            csVar38 = this.a.z;
                                            csVar38.Z();
                                            bmVar19 = this.a.t;
                                            if (bmVar19.m() != null) {
                                                csVar39 = this.a.z;
                                                bmVar20 = this.a.t;
                                                csVar39.a(bmVar20.m());
                                            }
                                            if (TiebaApplication.g().s()) {
                                                StatService.onEvent(this.a, "pb_skip_page", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.reverse_txt /* 2131100889 */:
                                            this.a.w();
                                            csVar36 = this.a.z;
                                            csVar36.Z();
                                            bmVar18 = this.a.t;
                                            bmVar18.r();
                                            csVar37 = this.a.z;
                                            csVar37.p();
                                            if (TiebaApplication.g().s()) {
                                                StatService.onEvent(this.a, "pb_set_desc", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.sub_pb_bottom_layout /* 2131100893 */:
                                            bmVar9 = this.a.t;
                                            if (!bmVar9.i()) {
                                                this.a.w();
                                                csVar28 = this.a.z;
                                                csVar28.z();
                                                bpVar5 = this.a.x;
                                                bpVar5.cancelLoadData();
                                                return;
                                            }
                                            this.a.closeActivity();
                                            return;
                                        case R.id.btn_loadprevious /* 2131101121 */:
                                            bpVar4 = this.a.x;
                                            if (bpVar4.k()) {
                                                csVar27 = this.a.z;
                                                csVar27.x();
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                if (TiebaApplication.g().s()) {
                                    StatService.onEvent(this.a, "pb_header_forum_name", "pbclick", 1);
                                }
                                bmVar23 = this.a.t;
                                if (!bmVar23.e()) {
                                    bmVar24 = this.a.t;
                                    String name4 = bmVar24.l().c().getName();
                                    if (com.baidu.tieba.util.bm.b(name4)) {
                                        FrsActivity.a(this.a, name4, "tb_pb");
                                        return;
                                    }
                                    return;
                                }
                                this.a.finish();
                                return;
                            }
                            this.a.closeActivity();
                            return;
                        }
                    }
                }
            }
        }
        csVar3 = this.a.z;
        csVar3.aa();
        bmVar = this.a.t;
        if (bmVar.l().l() == 1) {
            adVar = this.a.y;
            if (!adVar.b()) {
                csVar4 = this.a.z;
                csVar4.k();
                csVar5 = this.a.z;
                if (view != csVar5.R()) {
                    csVar6 = this.a.z;
                    if (view != csVar6.S()) {
                        csVar7 = this.a.z;
                        if (view != csVar7.T()) {
                            csVar8 = this.a.z;
                            if (view != csVar8.U()) {
                                csVar9 = this.a.z;
                                if (view == csVar9.m()) {
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
                bmVar2 = this.a.t;
                ForumData c = bmVar2.l().c();
                String name5 = c.getName();
                String id3 = c.getId();
                bmVar3 = this.a.t;
                String a3 = bmVar3.l().d().a();
                adVar2 = this.a.y;
                csVar10 = this.a.z;
                adVar2.a(id3, name5, a3, i, csVar10.n());
            }
        }
    }
}
