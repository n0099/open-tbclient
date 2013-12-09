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
public class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.f2161a = newPbActivity;
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
        boolean a2;
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
        cr crVar44;
        com.baidu.tieba.model.bp bpVar7;
        com.baidu.tieba.model.bp bpVar8;
        com.baidu.tieba.model.bp bpVar9;
        com.baidu.tieba.model.bp bpVar10;
        cr crVar45;
        cr crVar46;
        cr crVar47;
        com.baidu.tieba.model.ad adVar3;
        cr crVar48;
        com.baidu.tieba.model.bm bmVar23;
        com.baidu.tieba.model.ad adVar4;
        com.baidu.tieba.model.bm bmVar24;
        com.baidu.tieba.model.bm bmVar25;
        com.baidu.tieba.model.bm bmVar26;
        com.baidu.tieba.model.bp bpVar11;
        com.baidu.tieba.model.bp bpVar12;
        com.baidu.tieba.model.bp bpVar13;
        com.baidu.tieba.model.bp bpVar14;
        com.baidu.tieba.model.ad adVar5;
        com.baidu.tieba.model.bp bpVar15;
        com.baidu.tieba.model.bp bpVar16;
        com.baidu.tieba.model.bp bpVar17;
        com.baidu.tieba.model.bm bmVar27;
        com.baidu.tieba.model.bm bmVar28;
        com.baidu.tieba.model.bm bmVar29;
        cr crVar49;
        int i = 0;
        crVar = this.f2161a.y;
        if (view == crVar.N()) {
            bmVar29 = this.f2161a.s;
            if (bmVar29.a(true)) {
                crVar49 = this.f2161a.y;
                crVar49.q();
                return;
            }
            return;
        }
        crVar2 = this.f2161a.y;
        if (view != crVar2.R()) {
            crVar11 = this.f2161a.y;
            if (view != crVar11.S()) {
                crVar12 = this.f2161a.y;
                if (view != crVar12.T()) {
                    crVar13 = this.f2161a.y;
                    if (view != crVar13.U()) {
                        crVar14 = this.f2161a.y;
                        if (view != crVar14.l()) {
                            crVar15 = this.f2161a.y;
                            if (view == crVar15.ag()) {
                                bmVar27 = this.f2161a.s;
                                if (bmVar27 != null) {
                                    bmVar28 = this.f2161a.s;
                                    UtilHelper.b(this.f2161a, bmVar28.l().d().i().c());
                                    return;
                                }
                                return;
                            }
                            crVar16 = this.f2161a.y;
                            if (view == crVar16.k()) {
                                crVar47 = this.f2161a.y;
                                crVar47.aa();
                                String B = TiebaApplication.B();
                                if (B != null && B.length() > 0) {
                                    adVar3 = this.f2161a.x;
                                    if (!adVar3.b()) {
                                        crVar48 = this.f2161a.y;
                                        crVar48.j();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bmVar23 = this.f2161a.s;
                                            if (bmVar23.i()) {
                                                bpVar11 = this.f2161a.w;
                                                if (bpVar11 != null) {
                                                    bpVar12 = this.f2161a.w;
                                                    if (bpVar12.e() != null) {
                                                        bpVar13 = this.f2161a.w;
                                                        if (bpVar13.e().h() != null) {
                                                            bpVar14 = this.f2161a.w;
                                                            if (bpVar14.e().m() != null) {
                                                                adVar5 = this.f2161a.x;
                                                                bpVar15 = this.f2161a.w;
                                                                String id = bpVar15.e().h().getId();
                                                                bpVar16 = this.f2161a.w;
                                                                String name = bpVar16.e().h().getName();
                                                                bpVar17 = this.f2161a.w;
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
                                            adVar4 = this.f2161a.x;
                                            bmVar24 = this.f2161a.s;
                                            String id2 = bmVar24.l().c().getId();
                                            bmVar25 = this.f2161a.s;
                                            String name2 = bmVar25.l().c().getName();
                                            bmVar26 = this.f2161a.s;
                                            adVar4.a(id2, name2, bmVar26.l().d().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f2161a, this.f2161a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            crVar17 = this.f2161a.y;
                            if (view == crVar17.V()) {
                                crVar46 = this.f2161a.y;
                                crVar46.b(true);
                                return;
                            }
                            crVar18 = this.f2161a.y;
                            if (view == crVar18.n()) {
                                bpVar10 = this.f2161a.w;
                                if (bpVar10.h()) {
                                    crVar45 = this.f2161a.y;
                                    crVar45.v();
                                    return;
                                }
                                return;
                            }
                            crVar19 = this.f2161a.y;
                            if (view == crVar19.h()) {
                                bpVar7 = this.f2161a.w;
                                if (bpVar7 != null) {
                                    bpVar8 = this.f2161a.w;
                                    if (bpVar8.a() != null) {
                                        NewPbActivity newPbActivity = this.f2161a;
                                        bpVar9 = this.f2161a.w;
                                        NewPbActivity.a(newPbActivity, bpVar9.a(), null, null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            crVar20 = this.f2161a.y;
                            if (view != crVar20.b) {
                                crVar21 = this.f2161a.y;
                                if (view == crVar21.c) {
                                    crVar44 = this.f2161a.y;
                                    crVar44.a(0);
                                    if (TiebaApplication.h().t()) {
                                        StatService.onEvent(this.f2161a, "pb_header_forum_name", "pbclick", 1);
                                        return;
                                    }
                                    return;
                                }
                                crVar22 = this.f2161a.y;
                                if (view == crVar22.e) {
                                    crVar43 = this.f2161a.y;
                                    bmVar22 = this.f2161a.s;
                                    boolean d = bmVar22.d();
                                    bgVar = this.f2161a.t;
                                    crVar43.a(d, bgVar.a());
                                    return;
                                }
                                crVar23 = this.f2161a.y;
                                if (view == crVar23.d) {
                                    this.f2161a.u();
                                    bmVar21 = this.f2161a.s;
                                    bmVar21.q();
                                    crVar42 = this.f2161a.y;
                                    crVar42.o();
                                    if (TiebaApplication.h().t()) {
                                        StatService.onEvent(this.f2161a, "pb_set_host", "pbclick", 1);
                                        return;
                                    }
                                    return;
                                }
                                switch (view.getId()) {
                                    case R.id.sub_post_load_more /* 2131099670 */:
                                        bpVar6 = this.f2161a.w;
                                        if (bpVar6.h()) {
                                            crVar41 = this.f2161a.y;
                                            crVar41.v();
                                            return;
                                        }
                                        return;
                                    case R.id.dialog_button_cancel /* 2131099954 */:
                                        crVar29 = this.f2161a.y;
                                        crVar29.Z();
                                        return;
                                    case R.id.dialog_button_ok /* 2131099955 */:
                                        crVar30 = this.f2161a.y;
                                        crVar30.Z();
                                        crVar31 = this.f2161a.y;
                                        if (crVar31.I() >= 0) {
                                            this.f2161a.u();
                                            bmVar16 = this.f2161a.s;
                                            crVar32 = this.f2161a.y;
                                            bmVar16.c(crVar32.I());
                                            crVar33 = this.f2161a.y;
                                            crVar33.o();
                                            return;
                                        }
                                        return;
                                    case R.id.reply /* 2131100550 */:
                                    case R.id.sub_pb_item /* 2131100786 */:
                                    case R.id.sub_pb_more /* 2131100788 */:
                                        try {
                                            bmVar4 = this.f2161a.s;
                                            if (bmVar4.l() != null) {
                                                crVar24 = this.f2161a.y;
                                                crVar24.Z();
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                com.baidu.tieba.data.ar arVar = (com.baidu.tieba.data.ar) sparseArray2.get(R.id.tag_load_sub_data);
                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                if (arVar != null && view2 != null) {
                                                    bmVar5 = this.f2161a.s;
                                                    com.baidu.tieba.data.av a3 = bmVar5.a(arVar);
                                                    bpVar = this.f2161a.w;
                                                    bmVar6 = this.f2161a.s;
                                                    bpVar.a(bmVar6.b());
                                                    bpVar2 = this.f2161a.w;
                                                    bpVar2.b(arVar.d());
                                                    bpVar3 = this.f2161a.w;
                                                    bpVar3.d();
                                                    this.f2161a.u();
                                                    if (view.getId() == R.id.reply) {
                                                        crVar26 = this.f2161a.y;
                                                        bmVar8 = this.f2161a.s;
                                                        crVar26.a(true, a3, false, null, null, view2, bmVar8.l().l());
                                                        return;
                                                    } else if (view.getId() != R.id.sub_pb_item) {
                                                        handler = this.f2161a.r;
                                                        handler.post(new an(this, a3, view2));
                                                        return;
                                                    } else {
                                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                        String str2 = (String) sparseArray3.get(R.id.tag_photo_username);
                                                        com.baidu.tieba.data.ar arVar2 = (com.baidu.tieba.data.ar) sparseArray3.get(R.id.tag_clip_board);
                                                        String d2 = arVar2 != null ? arVar2.d() : null;
                                                        crVar25 = this.f2161a.y;
                                                        bmVar7 = this.f2161a.s;
                                                        crVar25.a(true, a3, false, str2, d2, view2, bmVar7.l().l());
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Exception e) {
                                            com.baidu.tieba.util.bd.b(getClass().getName(), "onClick", e.toString());
                                            return;
                                        }
                                    case R.id.btn_image_upload_camera /* 2131100565 */:
                                        com.baidu.tieba.write.bd.a(this.f2161a);
                                        return;
                                    case R.id.btn_image_upload_album /* 2131100566 */:
                                        com.baidu.tieba.write.bd.b(this.f2161a);
                                        return;
                                    case R.id.pb_list_header_bar /* 2131100738 */:
                                        bmVar10 = this.f2161a.s;
                                        if (bmVar10 != null) {
                                            bmVar11 = this.f2161a.s;
                                            if (bmVar11.l() != null) {
                                                bmVar12 = this.f2161a.s;
                                                if (bmVar12.l().c() != null) {
                                                    bmVar13 = this.f2161a.s;
                                                    String name3 = bmVar13.l().c().getName();
                                                    if (name3 != null && name3.length() > 0) {
                                                        bmVar14 = this.f2161a.s;
                                                        if (name3.equals(bmVar14.a())) {
                                                            bmVar15 = this.f2161a.s;
                                                            if (bmVar15.e()) {
                                                                this.f2161a.closeActivity();
                                                                return;
                                                            }
                                                        }
                                                        FrsActivity.a(this.f2161a, name3, (String) null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case R.id.floor /* 2131100760 */:
                                        this.f2161a.a(view);
                                        return;
                                    case R.id.mark_txt /* 2131100771 */:
                                        crVar34 = this.f2161a.y;
                                        crVar34.Z();
                                        a2 = this.f2161a.a(11009);
                                        if (a2) {
                                            bmVar17 = this.f2161a.s;
                                            crVar35 = this.f2161a.y;
                                            if (bmVar17.f(crVar35.H()) != null) {
                                                this.f2161a.q();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case R.id.share_txt /* 2131100773 */:
                                        this.f2161a.u();
                                        crVar40 = this.f2161a.y;
                                        crVar40.Z();
                                        this.f2161a.v();
                                        return;
                                    case R.id.skip_txt /* 2131100775 */:
                                        crVar38 = this.f2161a.y;
                                        crVar38.Z();
                                        bmVar19 = this.f2161a.s;
                                        if (bmVar19.m() != null) {
                                            crVar39 = this.f2161a.y;
                                            bmVar20 = this.f2161a.s;
                                            crVar39.a(bmVar20.m());
                                        }
                                        if (TiebaApplication.h().t()) {
                                            StatService.onEvent(this.f2161a, "pb_skip_page", "pbclick", 1);
                                            return;
                                        }
                                        return;
                                    case R.id.reverse_txt /* 2131100777 */:
                                        this.f2161a.u();
                                        crVar36 = this.f2161a.y;
                                        crVar36.Z();
                                        bmVar18 = this.f2161a.s;
                                        bmVar18.r();
                                        crVar37 = this.f2161a.y;
                                        crVar37.o();
                                        if (TiebaApplication.h().t()) {
                                            StatService.onEvent(this.f2161a, "pb_set_desc", "pbclick", 1);
                                            return;
                                        }
                                        return;
                                    case R.id.sub_pb_bottom_layout /* 2131100781 */:
                                        bmVar9 = this.f2161a.s;
                                        if (!bmVar9.i()) {
                                            this.f2161a.u();
                                            crVar28 = this.f2161a.y;
                                            crVar28.y();
                                            bpVar5 = this.f2161a.w;
                                            bpVar5.cancelLoadData();
                                            return;
                                        }
                                        this.f2161a.closeActivity();
                                        return;
                                    case R.id.btn_loadprevious /* 2131100995 */:
                                        bpVar4 = this.f2161a.w;
                                        if (bpVar4.k()) {
                                            crVar27 = this.f2161a.y;
                                            crVar27.w();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            this.f2161a.closeActivity();
                            return;
                        }
                    }
                }
            }
        }
        crVar3 = this.f2161a.y;
        crVar3.aa();
        bmVar = this.f2161a.s;
        if (bmVar.l().l() == 1) {
            adVar = this.f2161a.x;
            if (!adVar.b()) {
                crVar4 = this.f2161a.y;
                crVar4.j();
                crVar5 = this.f2161a.y;
                if (view != crVar5.R()) {
                    crVar6 = this.f2161a.y;
                    if (view != crVar6.S()) {
                        crVar7 = this.f2161a.y;
                        if (view != crVar7.T()) {
                            crVar8 = this.f2161a.y;
                            if (view != crVar8.U()) {
                                crVar9 = this.f2161a.y;
                                if (view == crVar9.l()) {
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
                bmVar2 = this.f2161a.s;
                ForumData c = bmVar2.l().c();
                String name4 = c.getName();
                String id3 = c.getId();
                bmVar3 = this.f2161a.s;
                String a4 = bmVar3.l().d().a();
                adVar2 = this.f2161a.x;
                crVar10 = this.f2161a.y;
                adVar2.a(id3, name4, a4, i, crVar10.m());
            }
        }
    }
}
