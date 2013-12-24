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
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
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
        crVar = this.a.x;
        if (view == crVar.N()) {
            bmVar29 = this.a.r;
            if (bmVar29.a(true)) {
                crVar49 = this.a.x;
                crVar49.q();
                return;
            }
            return;
        }
        crVar2 = this.a.x;
        if (view != crVar2.R()) {
            crVar11 = this.a.x;
            if (view != crVar11.S()) {
                crVar12 = this.a.x;
                if (view != crVar12.T()) {
                    crVar13 = this.a.x;
                    if (view != crVar13.U()) {
                        crVar14 = this.a.x;
                        if (view != crVar14.l()) {
                            crVar15 = this.a.x;
                            if (view == crVar15.ag()) {
                                bmVar27 = this.a.r;
                                if (bmVar27 != null) {
                                    bmVar28 = this.a.r;
                                    UtilHelper.b(this.a, bmVar28.l().d().i().c());
                                    return;
                                }
                                return;
                            }
                            crVar16 = this.a.x;
                            if (view == crVar16.k()) {
                                crVar47 = this.a.x;
                                crVar47.aa();
                                String B = TiebaApplication.B();
                                if (B != null && B.length() > 0) {
                                    adVar3 = this.a.w;
                                    if (!adVar3.b()) {
                                        crVar48 = this.a.x;
                                        crVar48.j();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bmVar23 = this.a.r;
                                            if (bmVar23.i()) {
                                                bpVar11 = this.a.v;
                                                if (bpVar11 != null) {
                                                    bpVar12 = this.a.v;
                                                    if (bpVar12.e() != null) {
                                                        bpVar13 = this.a.v;
                                                        if (bpVar13.e().h() != null) {
                                                            bpVar14 = this.a.v;
                                                            if (bpVar14.e().m() != null) {
                                                                adVar5 = this.a.w;
                                                                bpVar15 = this.a.v;
                                                                String id = bpVar15.e().h().getId();
                                                                bpVar16 = this.a.v;
                                                                String name = bpVar16.e().h().getName();
                                                                bpVar17 = this.a.v;
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
                                            adVar4 = this.a.w;
                                            bmVar24 = this.a.r;
                                            String id2 = bmVar24.l().c().getId();
                                            bmVar25 = this.a.r;
                                            String name2 = bmVar25.l().c().getName();
                                            bmVar26 = this.a.r;
                                            adVar4.a(id2, name2, bmVar26.l().d().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            crVar17 = this.a.x;
                            if (view == crVar17.V()) {
                                crVar46 = this.a.x;
                                crVar46.b(true);
                                return;
                            }
                            crVar18 = this.a.x;
                            if (view == crVar18.n()) {
                                bpVar10 = this.a.v;
                                if (bpVar10.h()) {
                                    crVar45 = this.a.x;
                                    crVar45.v();
                                    return;
                                }
                                return;
                            }
                            crVar19 = this.a.x;
                            if (view == crVar19.h()) {
                                bpVar7 = this.a.v;
                                if (bpVar7 != null) {
                                    bpVar8 = this.a.v;
                                    if (bpVar8.a() != null) {
                                        NewPbActivity newPbActivity = this.a;
                                        bpVar9 = this.a.v;
                                        NewPbActivity.a(newPbActivity, bpVar9.a(), null, null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            crVar20 = this.a.x;
                            if (view != crVar20.b) {
                                crVar21 = this.a.x;
                                if (view == crVar21.c) {
                                    crVar44 = this.a.x;
                                    crVar44.a(0);
                                    if (TiebaApplication.h().t()) {
                                        StatService.onEvent(this.a, "pb_header_forum_name", "pbclick", 1);
                                        return;
                                    }
                                    return;
                                }
                                crVar22 = this.a.x;
                                if (view == crVar22.e) {
                                    crVar43 = this.a.x;
                                    bmVar22 = this.a.r;
                                    boolean d = bmVar22.d();
                                    bgVar = this.a.s;
                                    crVar43.a(d, bgVar.a());
                                    return;
                                }
                                crVar23 = this.a.x;
                                if (view == crVar23.d) {
                                    this.a.u();
                                    bmVar21 = this.a.r;
                                    bmVar21.q();
                                    crVar42 = this.a.x;
                                    crVar42.o();
                                    if (TiebaApplication.h().t()) {
                                        StatService.onEvent(this.a, "pb_set_host", "pbclick", 1);
                                        return;
                                    }
                                    return;
                                }
                                switch (view.getId()) {
                                    case R.id.sub_post_load_more /* 2131099670 */:
                                        bpVar6 = this.a.v;
                                        if (bpVar6.h()) {
                                            crVar41 = this.a.x;
                                            crVar41.v();
                                            return;
                                        }
                                        return;
                                    case R.id.dialog_button_cancel /* 2131099954 */:
                                        crVar29 = this.a.x;
                                        crVar29.Z();
                                        return;
                                    case R.id.dialog_button_ok /* 2131099955 */:
                                        crVar30 = this.a.x;
                                        crVar30.Z();
                                        crVar31 = this.a.x;
                                        if (crVar31.I() >= 0) {
                                            this.a.u();
                                            bmVar16 = this.a.r;
                                            crVar32 = this.a.x;
                                            bmVar16.c(crVar32.I());
                                            crVar33 = this.a.x;
                                            crVar33.o();
                                            return;
                                        }
                                        return;
                                    case R.id.reply /* 2131100550 */:
                                    case R.id.sub_pb_item /* 2131100796 */:
                                    case R.id.sub_pb_more /* 2131100798 */:
                                        try {
                                            bmVar4 = this.a.r;
                                            if (bmVar4.l() != null) {
                                                crVar24 = this.a.x;
                                                crVar24.Z();
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                com.baidu.tieba.data.ar arVar = (com.baidu.tieba.data.ar) sparseArray2.get(R.id.tag_load_sub_data);
                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                if (arVar != null && view2 != null) {
                                                    bmVar5 = this.a.r;
                                                    com.baidu.tieba.data.av a2 = bmVar5.a(arVar);
                                                    bpVar = this.a.v;
                                                    bmVar6 = this.a.r;
                                                    bpVar.a(bmVar6.b());
                                                    bpVar2 = this.a.v;
                                                    bpVar2.b(arVar.d());
                                                    bpVar3 = this.a.v;
                                                    bpVar3.d();
                                                    this.a.u();
                                                    if (view.getId() == R.id.reply) {
                                                        crVar26 = this.a.x;
                                                        bmVar8 = this.a.r;
                                                        crVar26.a(true, a2, false, null, null, view2, bmVar8.l().l());
                                                        return;
                                                    } else if (view.getId() != R.id.sub_pb_item) {
                                                        handler = this.a.q;
                                                        handler.post(new an(this, a2, view2));
                                                        return;
                                                    } else {
                                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                        String str2 = (String) sparseArray3.get(R.id.tag_photo_username);
                                                        com.baidu.tieba.data.ar arVar2 = (com.baidu.tieba.data.ar) sparseArray3.get(R.id.tag_clip_board);
                                                        String d2 = arVar2 != null ? arVar2.d() : null;
                                                        crVar25 = this.a.x;
                                                        bmVar7 = this.a.r;
                                                        crVar25.a(true, a2, false, str2, d2, view2, bmVar7.l().l());
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Exception e) {
                                            com.baidu.tieba.util.be.b(getClass().getName(), "onClick", e.toString());
                                            return;
                                        }
                                    case R.id.btn_image_upload_camera /* 2131100565 */:
                                        com.baidu.tieba.write.bd.a(this.a);
                                        return;
                                    case R.id.btn_image_upload_album /* 2131100566 */:
                                        com.baidu.tieba.write.bd.b(this.a);
                                        return;
                                    case R.id.pb_list_header_bar /* 2131100748 */:
                                        bmVar10 = this.a.r;
                                        if (bmVar10 != null) {
                                            bmVar11 = this.a.r;
                                            if (bmVar11.l() != null) {
                                                bmVar12 = this.a.r;
                                                if (bmVar12.l().c() != null) {
                                                    bmVar13 = this.a.r;
                                                    String name3 = bmVar13.l().c().getName();
                                                    if (name3 != null && name3.length() > 0) {
                                                        bmVar14 = this.a.r;
                                                        if (name3.equals(bmVar14.a())) {
                                                            bmVar15 = this.a.r;
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
                                    case R.id.floor /* 2131100770 */:
                                        this.a.a(view);
                                        return;
                                    case R.id.mark_txt /* 2131100781 */:
                                        crVar34 = this.a.x;
                                        crVar34.Z();
                                        a = this.a.a(11009);
                                        if (a) {
                                            bmVar17 = this.a.r;
                                            crVar35 = this.a.x;
                                            if (bmVar17.f(crVar35.H()) != null) {
                                                this.a.q();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case R.id.share_txt /* 2131100783 */:
                                        this.a.u();
                                        crVar40 = this.a.x;
                                        crVar40.Z();
                                        this.a.v();
                                        return;
                                    case R.id.skip_txt /* 2131100785 */:
                                        crVar38 = this.a.x;
                                        crVar38.Z();
                                        bmVar19 = this.a.r;
                                        if (bmVar19.m() != null) {
                                            crVar39 = this.a.x;
                                            bmVar20 = this.a.r;
                                            crVar39.a(bmVar20.m());
                                        }
                                        if (TiebaApplication.h().t()) {
                                            StatService.onEvent(this.a, "pb_skip_page", "pbclick", 1);
                                            return;
                                        }
                                        return;
                                    case R.id.reverse_txt /* 2131100787 */:
                                        this.a.u();
                                        crVar36 = this.a.x;
                                        crVar36.Z();
                                        bmVar18 = this.a.r;
                                        bmVar18.r();
                                        crVar37 = this.a.x;
                                        crVar37.o();
                                        if (TiebaApplication.h().t()) {
                                            StatService.onEvent(this.a, "pb_set_desc", "pbclick", 1);
                                            return;
                                        }
                                        return;
                                    case R.id.sub_pb_bottom_layout /* 2131100791 */:
                                        bmVar9 = this.a.r;
                                        if (!bmVar9.i()) {
                                            this.a.u();
                                            crVar28 = this.a.x;
                                            crVar28.y();
                                            bpVar5 = this.a.v;
                                            bpVar5.cancelLoadData();
                                            return;
                                        }
                                        this.a.closeActivity();
                                        return;
                                    case R.id.btn_loadprevious /* 2131101026 */:
                                        bpVar4 = this.a.v;
                                        if (bpVar4.k()) {
                                            crVar27 = this.a.x;
                                            crVar27.w();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            this.a.closeActivity();
                            return;
                        }
                    }
                }
            }
        }
        crVar3 = this.a.x;
        crVar3.aa();
        bmVar = this.a.r;
        if (bmVar.l().l() == 1) {
            adVar = this.a.w;
            if (!adVar.b()) {
                crVar4 = this.a.x;
                crVar4.j();
                crVar5 = this.a.x;
                if (view != crVar5.R()) {
                    crVar6 = this.a.x;
                    if (view != crVar6.S()) {
                        crVar7 = this.a.x;
                        if (view != crVar7.T()) {
                            crVar8 = this.a.x;
                            if (view != crVar8.U()) {
                                crVar9 = this.a.x;
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
                bmVar2 = this.a.r;
                ForumData c = bmVar2.l().c();
                String name4 = c.getName();
                String id3 = c.getId();
                bmVar3 = this.a.r;
                String a3 = bmVar3.l().d().a();
                adVar2 = this.a.w;
                crVar10 = this.a.x;
                adVar2.a(id3, name4, a3, i, crVar10.m());
            }
        }
    }
}
