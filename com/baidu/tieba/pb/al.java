package com.baidu.tieba.pb;

import android.app.Activity;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
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
        cr crVar;
        cr crVar2;
        cr crVar3;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.ad adVar;
        cr crVar4;
        cr crVar5;
        cr crVar6;
        cr crVar7;
        cr crVar8;
        cr crVar9;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.ad adVar2;
        cr crVar10;
        cr crVar11;
        cr crVar12;
        cr crVar13;
        cr crVar14;
        cr crVar15;
        cr crVar16;
        cr crVar17;
        cr crVar18;
        cr crVar19;
        cr crVar20;
        cr crVar21;
        cr crVar22;
        cr crVar23;
        com.baidu.tieba.model.bm bmVar4;
        cr crVar24;
        com.baidu.tieba.model.bm bmVar5;
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bm bmVar6;
        com.baidu.tieba.model.bp bpVar2;
        com.baidu.tieba.model.bp bpVar3;
        Handler handler;
        cr crVar25;
        com.baidu.tieba.model.bm bmVar7;
        cr crVar26;
        com.baidu.tieba.model.bm bmVar8;
        com.baidu.tieba.model.bp bpVar4;
        cr crVar27;
        com.baidu.tieba.model.bm bmVar9;
        cr crVar28;
        com.baidu.tieba.model.bp bpVar5;
        com.baidu.tieba.model.bm bmVar10;
        com.baidu.tieba.model.bm bmVar11;
        com.baidu.tieba.model.bm bmVar12;
        com.baidu.tieba.model.bm bmVar13;
        com.baidu.tieba.model.bm bmVar14;
        com.baidu.tieba.model.bm bmVar15;
        cr crVar29;
        cr crVar30;
        cr crVar31;
        com.baidu.tieba.model.bm bmVar16;
        cr crVar32;
        cr crVar33;
        cr crVar34;
        boolean a;
        com.baidu.tieba.model.bm bmVar17;
        cr crVar35;
        cr crVar36;
        com.baidu.tieba.model.bm bmVar18;
        cr crVar37;
        cr crVar38;
        com.baidu.tieba.model.bm bmVar19;
        cr crVar39;
        com.baidu.tieba.model.bm bmVar20;
        cr crVar40;
        com.baidu.tieba.model.bp bpVar6;
        cr crVar41;
        com.baidu.tieba.model.bm bmVar21;
        cr crVar42;
        cr crVar43;
        com.baidu.tieba.model.bm bmVar22;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bm bmVar23;
        com.baidu.tieba.model.bm bmVar24;
        com.baidu.tieba.model.bp bpVar7;
        com.baidu.tieba.model.bp bpVar8;
        com.baidu.tieba.model.bp bpVar9;
        com.baidu.tieba.model.bp bpVar10;
        cr crVar44;
        cr crVar45;
        cr crVar46;
        com.baidu.tieba.model.ad adVar3;
        cr crVar47;
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
        cr crVar48;
        int i = 0;
        crVar = this.a.A;
        if (view == crVar.N()) {
            bmVar31 = this.a.u;
            if (bmVar31.a(true)) {
                crVar48 = this.a.A;
                crVar48.r();
                return;
            }
            return;
        }
        crVar2 = this.a.A;
        if (view != crVar2.R()) {
            crVar11 = this.a.A;
            if (view != crVar11.S()) {
                crVar12 = this.a.A;
                if (view != crVar12.T()) {
                    crVar13 = this.a.A;
                    if (view != crVar13.U()) {
                        crVar14 = this.a.A;
                        if (view != crVar14.m()) {
                            crVar15 = this.a.A;
                            if (view == crVar15.ag()) {
                                bmVar29 = this.a.u;
                                if (bmVar29 != null) {
                                    bmVar30 = this.a.u;
                                    UtilHelper.c(this.a, bmVar30.l().d().i().c());
                                    return;
                                }
                                return;
                            }
                            crVar16 = this.a.A;
                            if (view == crVar16.l()) {
                                crVar46 = this.a.A;
                                crVar46.aa();
                                String A = TiebaApplication.A();
                                if (A != null && A.length() > 0) {
                                    adVar3 = this.a.z;
                                    if (!adVar3.b()) {
                                        crVar47 = this.a.A;
                                        crVar47.k();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bmVar25 = this.a.u;
                                            if (bmVar25.i()) {
                                                bpVar11 = this.a.y;
                                                if (bpVar11 != null) {
                                                    bpVar12 = this.a.y;
                                                    if (bpVar12.e() != null) {
                                                        bpVar13 = this.a.y;
                                                        if (bpVar13.e().h() != null) {
                                                            bpVar14 = this.a.y;
                                                            if (bpVar14.e().m() != null) {
                                                                adVar5 = this.a.z;
                                                                bpVar15 = this.a.y;
                                                                String id = bpVar15.e().h().getId();
                                                                bpVar16 = this.a.y;
                                                                String name = bpVar16.e().h().getName();
                                                                bpVar17 = this.a.y;
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
                                            adVar4 = this.a.z;
                                            bmVar26 = this.a.u;
                                            String id2 = bmVar26.l().c().getId();
                                            bmVar27 = this.a.u;
                                            String name2 = bmVar27.l().c().getName();
                                            bmVar28 = this.a.u;
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
                            crVar17 = this.a.A;
                            if (view == crVar17.V()) {
                                crVar45 = this.a.A;
                                crVar45.b(true);
                                return;
                            }
                            crVar18 = this.a.A;
                            if (view == crVar18.o()) {
                                bpVar10 = this.a.y;
                                if (bpVar10.h()) {
                                    crVar44 = this.a.A;
                                    crVar44.w();
                                    return;
                                }
                                return;
                            }
                            crVar19 = this.a.A;
                            if (view == crVar19.h()) {
                                bpVar7 = this.a.y;
                                if (bpVar7 != null) {
                                    bpVar8 = this.a.y;
                                    if (bpVar8.a() != null) {
                                        NewPbActivity newPbActivity = this.a;
                                        bpVar9 = this.a.y;
                                        NewPbActivity.a(newPbActivity, bpVar9.a(), (String) null, (String) null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            crVar20 = this.a.A;
                            if (view != crVar20.b) {
                                crVar21 = this.a.A;
                                if (view != crVar21.c) {
                                    crVar22 = this.a.A;
                                    if (view == crVar22.e) {
                                        crVar43 = this.a.A;
                                        bmVar22 = this.a.u;
                                        boolean d = bmVar22.d();
                                        bgVar = this.a.v;
                                        crVar43.a(d, bgVar.a());
                                        return;
                                    }
                                    crVar23 = this.a.A;
                                    if (view == crVar23.d) {
                                        this.a.w();
                                        bmVar21 = this.a.u;
                                        bmVar21.q();
                                        crVar42 = this.a.A;
                                        crVar42.p();
                                        com.baidu.tieba.util.by.a(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                        return;
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099670 */:
                                            bpVar6 = this.a.y;
                                            if (bpVar6.h()) {
                                                crVar41 = this.a.A;
                                                crVar41.w();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131100006 */:
                                            crVar29 = this.a.A;
                                            crVar29.Z();
                                            return;
                                        case R.id.dialog_button_ok /* 2131100007 */:
                                            crVar30 = this.a.A;
                                            crVar30.Z();
                                            crVar31 = this.a.A;
                                            if (crVar31.I() >= 0) {
                                                this.a.w();
                                                bmVar16 = this.a.u;
                                                crVar32 = this.a.A;
                                                bmVar16.c(crVar32.I());
                                                crVar33 = this.a.A;
                                                crVar33.p();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100733 */:
                                        case R.id.sub_pb_item /* 2131101011 */:
                                        case R.id.sub_pb_more /* 2131101013 */:
                                            try {
                                                bmVar4 = this.a.u;
                                                if (bmVar4.l() != null) {
                                                    crVar24 = this.a.A;
                                                    crVar24.Z();
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) sparseArray2.get(R.id.tag_load_sub_data);
                                                    View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                    if (asVar != null && view2 != null) {
                                                        bmVar5 = this.a.u;
                                                        com.baidu.tieba.data.ax a2 = bmVar5.a(asVar);
                                                        bpVar = this.a.y;
                                                        bmVar6 = this.a.u;
                                                        bpVar.a(bmVar6.b());
                                                        bpVar2 = this.a.y;
                                                        bpVar2.b(asVar.d());
                                                        bpVar3 = this.a.y;
                                                        bpVar3.d();
                                                        this.a.w();
                                                        if (view.getId() == R.id.reply) {
                                                            crVar26 = this.a.A;
                                                            bmVar8 = this.a.u;
                                                            crVar26.a(true, a2, false, null, null, view2, bmVar8.l().l());
                                                            return;
                                                        } else if (view.getId() != R.id.sub_pb_item) {
                                                            handler = this.a.t;
                                                            handler.post(new am(this, a2, view2));
                                                            return;
                                                        } else {
                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                            String str2 = (String) sparseArray3.get(R.id.tag_photo_username);
                                                            com.baidu.tieba.data.as asVar2 = (com.baidu.tieba.data.as) sparseArray3.get(R.id.tag_clip_board);
                                                            String d2 = asVar2 != null ? asVar2.d() : null;
                                                            crVar25 = this.a.A;
                                                            bmVar7 = this.a.u;
                                                            crVar25.a(true, a2, false, str2, d2, view2, bmVar7.l().l());
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.adp.lib.g.e.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.btn_image_upload_camera /* 2131100749 */:
                                            com.baidu.tieba.write.bb.a(this.a);
                                            return;
                                        case R.id.btn_image_upload_album /* 2131100750 */:
                                            com.baidu.tieba.write.bb.b(this.a);
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100963 */:
                                            bmVar10 = this.a.u;
                                            if (bmVar10 != null) {
                                                bmVar11 = this.a.u;
                                                if (bmVar11.l() != null) {
                                                    bmVar12 = this.a.u;
                                                    if (bmVar12.l().c() != null) {
                                                        bmVar13 = this.a.u;
                                                        String name3 = bmVar13.l().c().getName();
                                                        if (name3 != null && name3.length() > 0) {
                                                            bmVar14 = this.a.u;
                                                            if (name3.equals(bmVar14.a())) {
                                                                bmVar15 = this.a.u;
                                                                if (bmVar15.e()) {
                                                                    this.a.closeActivity();
                                                                    return;
                                                                }
                                                            }
                                                            FrsActivity.a(this.a, name3, null);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case R.id.floor /* 2131100984 */:
                                            this.a.a(view);
                                            return;
                                        case R.id.mark_txt /* 2131100996 */:
                                            crVar34 = this.a.A;
                                            crVar34.Z();
                                            a = this.a.a(11009);
                                            if (a) {
                                                bmVar17 = this.a.u;
                                                crVar35 = this.a.A;
                                                if (bmVar17.f(crVar35.H()) != null) {
                                                    this.a.s();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case R.id.share_txt /* 2131100998 */:
                                            this.a.w();
                                            crVar40 = this.a.A;
                                            crVar40.Z();
                                            this.a.x();
                                            return;
                                        case R.id.skip_txt /* 2131101000 */:
                                            crVar38 = this.a.A;
                                            crVar38.Z();
                                            bmVar19 = this.a.u;
                                            if (bmVar19.m() != null) {
                                                crVar39 = this.a.A;
                                                bmVar20 = this.a.u;
                                                crVar39.a(bmVar20.m());
                                            }
                                            com.baidu.tieba.util.by.a(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                            return;
                                        case R.id.reverse_txt /* 2131101002 */:
                                            this.a.w();
                                            crVar36 = this.a.A;
                                            crVar36.Z();
                                            bmVar18 = this.a.u;
                                            bmVar18.r();
                                            crVar37 = this.a.A;
                                            crVar37.p();
                                            com.baidu.tieba.util.by.a(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                            return;
                                        case R.id.sub_pb_bottom_layout /* 2131101006 */:
                                            bmVar9 = this.a.u;
                                            if (!bmVar9.i()) {
                                                this.a.w();
                                                crVar28 = this.a.A;
                                                crVar28.z();
                                                bpVar5 = this.a.y;
                                                bpVar5.cancelLoadData();
                                                return;
                                            }
                                            this.a.closeActivity();
                                            return;
                                        case R.id.btn_loadprevious /* 2131101239 */:
                                            bpVar4 = this.a.y;
                                            if (bpVar4.k()) {
                                                crVar27 = this.a.A;
                                                crVar27.x();
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                com.baidu.tieba.util.by.a(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bmVar23 = this.a.u;
                                if (!bmVar23.e()) {
                                    bmVar24 = this.a.u;
                                    String name4 = bmVar24.l().c().getName();
                                    if (com.baidu.tieba.util.bu.b(name4)) {
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
        crVar3 = this.a.A;
        crVar3.aa();
        bmVar = this.a.u;
        if (bmVar.l().l() == 1) {
            adVar = this.a.z;
            if (!adVar.b()) {
                crVar4 = this.a.A;
                crVar4.k();
                crVar5 = this.a.A;
                if (view != crVar5.R()) {
                    crVar6 = this.a.A;
                    if (view != crVar6.S()) {
                        crVar7 = this.a.A;
                        if (view != crVar7.T()) {
                            crVar8 = this.a.A;
                            if (view != crVar8.U()) {
                                crVar9 = this.a.A;
                                if (view == crVar9.m()) {
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
                bmVar2 = this.a.u;
                ForumData c = bmVar2.l().c();
                String name5 = c.getName();
                String id3 = c.getId();
                bmVar3 = this.a.u;
                String a3 = bmVar3.l().d().a();
                adVar2 = this.a.z;
                crVar10 = this.a.A;
                adVar2.a(id3, name5, a3, i, crVar10.n());
            }
        }
    }
}
