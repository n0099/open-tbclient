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
    final /* synthetic */ NewPbActivity f2070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.f2070a = newPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x05ef, code lost:
        if (r0.equals(r1.a()) != false) goto L154;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        cp cpVar;
        cp cpVar2;
        cp cpVar3;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.ad adVar;
        cp cpVar4;
        cp cpVar5;
        cp cpVar6;
        cp cpVar7;
        cp cpVar8;
        cp cpVar9;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.ad adVar2;
        cp cpVar10;
        cp cpVar11;
        cp cpVar12;
        cp cpVar13;
        cp cpVar14;
        cp cpVar15;
        cp cpVar16;
        cp cpVar17;
        cp cpVar18;
        cp cpVar19;
        cp cpVar20;
        cp cpVar21;
        cp cpVar22;
        cp cpVar23;
        com.baidu.tieba.model.bm bmVar4;
        cp cpVar24;
        com.baidu.tieba.model.bm bmVar5;
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bm bmVar6;
        com.baidu.tieba.model.bp bpVar2;
        com.baidu.tieba.model.bp bpVar3;
        Handler handler;
        cp cpVar25;
        com.baidu.tieba.model.bm bmVar7;
        cp cpVar26;
        com.baidu.tieba.model.bm bmVar8;
        com.baidu.tieba.model.bp bpVar4;
        cp cpVar27;
        com.baidu.tieba.model.bm bmVar9;
        cp cpVar28;
        com.baidu.tieba.model.bp bpVar5;
        com.baidu.tieba.model.bm bmVar10;
        com.baidu.tieba.model.bm bmVar11;
        com.baidu.tieba.model.bm bmVar12;
        com.baidu.tieba.model.bm bmVar13;
        com.baidu.tieba.model.bm bmVar14;
        com.baidu.tieba.model.bm bmVar15;
        com.baidu.tieba.model.bm bmVar16;
        cp cpVar29;
        cp cpVar30;
        cp cpVar31;
        com.baidu.tieba.model.bm bmVar17;
        cp cpVar32;
        cp cpVar33;
        cp cpVar34;
        boolean a2;
        com.baidu.tieba.model.bm bmVar18;
        cp cpVar35;
        cp cpVar36;
        com.baidu.tieba.model.bm bmVar19;
        cp cpVar37;
        cp cpVar38;
        com.baidu.tieba.model.bm bmVar20;
        cp cpVar39;
        com.baidu.tieba.model.bm bmVar21;
        cp cpVar40;
        com.baidu.tieba.model.bp bpVar6;
        cp cpVar41;
        com.baidu.tieba.model.bm bmVar22;
        cp cpVar42;
        cp cpVar43;
        com.baidu.tieba.model.bm bmVar23;
        com.baidu.tieba.model.bg bgVar;
        cp cpVar44;
        com.baidu.tieba.model.bp bpVar7;
        com.baidu.tieba.model.bp bpVar8;
        com.baidu.tieba.model.bp bpVar9;
        com.baidu.tieba.model.bp bpVar10;
        cp cpVar45;
        cp cpVar46;
        cp cpVar47;
        com.baidu.tieba.model.ad adVar3;
        cp cpVar48;
        com.baidu.tieba.model.bm bmVar24;
        com.baidu.tieba.model.ad adVar4;
        com.baidu.tieba.model.bm bmVar25;
        com.baidu.tieba.model.bm bmVar26;
        com.baidu.tieba.model.bm bmVar27;
        com.baidu.tieba.model.bp bpVar11;
        com.baidu.tieba.model.bp bpVar12;
        com.baidu.tieba.model.bp bpVar13;
        com.baidu.tieba.model.bp bpVar14;
        com.baidu.tieba.model.ad adVar5;
        com.baidu.tieba.model.bp bpVar15;
        com.baidu.tieba.model.bp bpVar16;
        com.baidu.tieba.model.bp bpVar17;
        com.baidu.tieba.model.bm bmVar28;
        com.baidu.tieba.model.bm bmVar29;
        com.baidu.tieba.model.bm bmVar30;
        cp cpVar49;
        int i = 2;
        cpVar = this.f2070a.y;
        if (view == cpVar.N()) {
            bmVar30 = this.f2070a.s;
            if (bmVar30.a(true)) {
                cpVar49 = this.f2070a.y;
                cpVar49.q();
                return;
            }
            return;
        }
        cpVar2 = this.f2070a.y;
        if (view != cpVar2.R()) {
            cpVar11 = this.f2070a.y;
            if (view != cpVar11.S()) {
                cpVar12 = this.f2070a.y;
                if (view != cpVar12.T()) {
                    cpVar13 = this.f2070a.y;
                    if (view != cpVar13.U()) {
                        cpVar14 = this.f2070a.y;
                        if (view != cpVar14.l()) {
                            cpVar15 = this.f2070a.y;
                            if (view == cpVar15.ag()) {
                                bmVar28 = this.f2070a.s;
                                if (bmVar28 != null) {
                                    bmVar29 = this.f2070a.s;
                                    UtilHelper.c(this.f2070a, bmVar29.l().d().i().c());
                                    return;
                                }
                                return;
                            }
                            cpVar16 = this.f2070a.y;
                            if (view == cpVar16.k()) {
                                cpVar47 = this.f2070a.y;
                                cpVar47.aa();
                                String A = TiebaApplication.A();
                                if (A != null && A.length() > 0) {
                                    adVar3 = this.f2070a.x;
                                    if (!adVar3.b()) {
                                        cpVar48 = this.f2070a.y;
                                        cpVar48.j();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bmVar24 = this.f2070a.s;
                                            if (bmVar24.i()) {
                                                bpVar11 = this.f2070a.w;
                                                if (bpVar11 != null) {
                                                    bpVar12 = this.f2070a.w;
                                                    if (bpVar12.e() != null) {
                                                        bpVar13 = this.f2070a.w;
                                                        if (bpVar13.e().h() != null) {
                                                            bpVar14 = this.f2070a.w;
                                                            if (bpVar14.e().m() != null) {
                                                                adVar5 = this.f2070a.x;
                                                                bpVar15 = this.f2070a.w;
                                                                String id = bpVar15.e().h().getId();
                                                                bpVar16 = this.f2070a.w;
                                                                String name = bpVar16.e().h().getName();
                                                                bpVar17 = this.f2070a.w;
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
                                            adVar4 = this.f2070a.x;
                                            bmVar25 = this.f2070a.s;
                                            String id2 = bmVar25.l().c().getId();
                                            bmVar26 = this.f2070a.s;
                                            String name2 = bmVar26.l().c().getName();
                                            bmVar27 = this.f2070a.s;
                                            adVar4.a(id2, name2, bmVar27.l().d().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f2070a, this.f2070a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            cpVar17 = this.f2070a.y;
                            if (view == cpVar17.V()) {
                                cpVar46 = this.f2070a.y;
                                cpVar46.b(true);
                                return;
                            }
                            cpVar18 = this.f2070a.y;
                            if (view == cpVar18.n()) {
                                bpVar10 = this.f2070a.w;
                                if (bpVar10.h()) {
                                    cpVar45 = this.f2070a.y;
                                    cpVar45.v();
                                    return;
                                }
                                return;
                            }
                            cpVar19 = this.f2070a.y;
                            if (view == cpVar19.h()) {
                                bpVar7 = this.f2070a.w;
                                if (bpVar7 != null) {
                                    bpVar8 = this.f2070a.w;
                                    if (bpVar8.a() != null) {
                                        NewPbActivity newPbActivity = this.f2070a;
                                        bpVar9 = this.f2070a.w;
                                        NewPbActivity.a(newPbActivity, bpVar9.a(), null, null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            cpVar20 = this.f2070a.y;
                            if (view != cpVar20.b) {
                                cpVar21 = this.f2070a.y;
                                if (view == cpVar21.c) {
                                    cpVar44 = this.f2070a.y;
                                    cpVar44.a(0);
                                    if (TiebaApplication.g().s()) {
                                        StatService.onEvent(this.f2070a, "pb_header_forum_name", "pbclick", 1);
                                        return;
                                    }
                                    return;
                                }
                                cpVar22 = this.f2070a.y;
                                if (view == cpVar22.e) {
                                    cpVar43 = this.f2070a.y;
                                    bmVar23 = this.f2070a.s;
                                    boolean d = bmVar23.d();
                                    bgVar = this.f2070a.t;
                                    cpVar43.a(d, bgVar.a());
                                    return;
                                }
                                cpVar23 = this.f2070a.y;
                                if (view == cpVar23.d) {
                                    this.f2070a.t();
                                    bmVar22 = this.f2070a.s;
                                    bmVar22.q();
                                    cpVar42 = this.f2070a.y;
                                    cpVar42.o();
                                    if (TiebaApplication.g().s()) {
                                        StatService.onEvent(this.f2070a, "pb_set_host", "pbclick", 1);
                                        return;
                                    }
                                    return;
                                }
                                switch (view.getId()) {
                                    case R.id.sub_post_load_more /* 2131099670 */:
                                        bpVar6 = this.f2070a.w;
                                        if (bpVar6.h()) {
                                            cpVar41 = this.f2070a.y;
                                            cpVar41.v();
                                            return;
                                        }
                                        return;
                                    case R.id.dialog_button_cancel /* 2131099944 */:
                                        cpVar29 = this.f2070a.y;
                                        cpVar29.Z();
                                        return;
                                    case R.id.dialog_button_ok /* 2131099945 */:
                                        cpVar30 = this.f2070a.y;
                                        cpVar30.Z();
                                        cpVar31 = this.f2070a.y;
                                        if (cpVar31.I() >= 0) {
                                            this.f2070a.t();
                                            bmVar17 = this.f2070a.s;
                                            cpVar32 = this.f2070a.y;
                                            bmVar17.c(cpVar32.I());
                                            cpVar33 = this.f2070a.y;
                                            cpVar33.o();
                                            return;
                                        }
                                        return;
                                    case R.id.reply /* 2131100447 */:
                                    case R.id.sub_pb_item /* 2131100683 */:
                                    case R.id.sub_pb_more /* 2131100685 */:
                                        try {
                                            bmVar4 = this.f2070a.s;
                                            if (bmVar4.l() != null) {
                                                cpVar24 = this.f2070a.y;
                                                cpVar24.Z();
                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) sparseArray2.get(R.id.tag_load_sub_data);
                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                if (asVar != null && view2 != null) {
                                                    bmVar5 = this.f2070a.s;
                                                    com.baidu.tieba.data.aw a3 = bmVar5.a(asVar);
                                                    bpVar = this.f2070a.w;
                                                    bmVar6 = this.f2070a.s;
                                                    bpVar.a(bmVar6.b());
                                                    bpVar2 = this.f2070a.w;
                                                    bpVar2.b(asVar.d());
                                                    bpVar3 = this.f2070a.w;
                                                    bpVar3.d();
                                                    this.f2070a.t();
                                                    if (view.getId() == R.id.reply) {
                                                        cpVar26 = this.f2070a.y;
                                                        bmVar8 = this.f2070a.s;
                                                        cpVar26.a(true, a3, false, null, null, view2, bmVar8.l().l());
                                                        return;
                                                    } else if (view.getId() != R.id.sub_pb_item) {
                                                        handler = this.f2070a.r;
                                                        handler.post(new an(this, a3, view2));
                                                        return;
                                                    } else {
                                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                        String str2 = (String) sparseArray3.get(R.id.tag_photo_username);
                                                        com.baidu.tieba.data.as asVar2 = (com.baidu.tieba.data.as) sparseArray3.get(R.id.tag_clip_board);
                                                        String d2 = asVar2 != null ? asVar2.d() : null;
                                                        cpVar25 = this.f2070a.y;
                                                        bmVar7 = this.f2070a.s;
                                                        cpVar25.a(true, a3, false, str2, d2, view2, bmVar7.l().l());
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Exception e) {
                                            com.baidu.tieba.util.bg.b(getClass().getName(), "onClick", e.toString());
                                            return;
                                        }
                                    case R.id.btn_image_upload_camera /* 2131100462 */:
                                        com.baidu.tieba.write.bc.a(this.f2070a);
                                        return;
                                    case R.id.btn_image_upload_album /* 2131100463 */:
                                        com.baidu.tieba.write.bc.b(this.f2070a);
                                        return;
                                    case R.id.pb_list_header_bar /* 2131100635 */:
                                        bmVar10 = this.f2070a.s;
                                        if (bmVar10 != null) {
                                            bmVar11 = this.f2070a.s;
                                            if (bmVar11.l() != null) {
                                                bmVar12 = this.f2070a.s;
                                                if (bmVar12.l().c() != null) {
                                                    bmVar13 = this.f2070a.s;
                                                    String name3 = bmVar13.l().c().getName();
                                                    if (name3 != null && name3.length() > 0) {
                                                        bmVar14 = this.f2070a.s;
                                                        if (bmVar14.h() == 2) {
                                                            bmVar16 = this.f2070a.s;
                                                            break;
                                                        }
                                                        bmVar15 = this.f2070a.s;
                                                        if (bmVar15.e()) {
                                                            this.f2070a.closeActivity();
                                                            return;
                                                        }
                                                        FrsActivity.a(this.f2070a, name3, (String) null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case R.id.floor /* 2131100657 */:
                                        this.f2070a.a(view);
                                        return;
                                    case R.id.mark_txt /* 2131100668 */:
                                        cpVar34 = this.f2070a.y;
                                        cpVar34.Z();
                                        a2 = this.f2070a.a(11009);
                                        if (a2) {
                                            bmVar18 = this.f2070a.s;
                                            cpVar35 = this.f2070a.y;
                                            if (bmVar18.f(cpVar35.H()) != null) {
                                                this.f2070a.q();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case R.id.share_txt /* 2131100670 */:
                                        this.f2070a.t();
                                        cpVar40 = this.f2070a.y;
                                        cpVar40.Z();
                                        this.f2070a.u();
                                        return;
                                    case R.id.skip_txt /* 2131100672 */:
                                        cpVar38 = this.f2070a.y;
                                        cpVar38.Z();
                                        bmVar20 = this.f2070a.s;
                                        if (bmVar20.m() != null) {
                                            cpVar39 = this.f2070a.y;
                                            bmVar21 = this.f2070a.s;
                                            cpVar39.a(bmVar21.m());
                                        }
                                        if (TiebaApplication.g().s()) {
                                            StatService.onEvent(this.f2070a, "pb_skip_page", "pbclick", 1);
                                            return;
                                        }
                                        return;
                                    case R.id.reverse_txt /* 2131100674 */:
                                        this.f2070a.t();
                                        cpVar36 = this.f2070a.y;
                                        cpVar36.Z();
                                        bmVar19 = this.f2070a.s;
                                        bmVar19.r();
                                        cpVar37 = this.f2070a.y;
                                        cpVar37.o();
                                        if (TiebaApplication.g().s()) {
                                            StatService.onEvent(this.f2070a, "pb_set_desc", "pbclick", 1);
                                            return;
                                        }
                                        return;
                                    case R.id.sub_pb_bottom_layout /* 2131100678 */:
                                        bmVar9 = this.f2070a.s;
                                        if (!bmVar9.i()) {
                                            this.f2070a.t();
                                            cpVar28 = this.f2070a.y;
                                            cpVar28.y();
                                            bpVar5 = this.f2070a.w;
                                            bpVar5.cancelLoadData();
                                            return;
                                        }
                                        this.f2070a.closeActivity();
                                        return;
                                    case R.id.btn_loadprevious /* 2131100890 */:
                                        bpVar4 = this.f2070a.w;
                                        if (bpVar4.k()) {
                                            cpVar27 = this.f2070a.y;
                                            cpVar27.w();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            this.f2070a.closeActivity();
                            return;
                        }
                    }
                }
            }
        }
        cpVar3 = this.f2070a.y;
        cpVar3.aa();
        bmVar = this.f2070a.s;
        if (bmVar.l().l() == 1) {
            adVar = this.f2070a.x;
            if (!adVar.b()) {
                cpVar4 = this.f2070a.y;
                cpVar4.j();
                cpVar5 = this.f2070a.y;
                if (view != cpVar5.R()) {
                    cpVar6 = this.f2070a.y;
                    if (view != cpVar6.S()) {
                        cpVar7 = this.f2070a.y;
                        if (view != cpVar7.T()) {
                            cpVar8 = this.f2070a.y;
                            if (view != cpVar8.U()) {
                                cpVar9 = this.f2070a.y;
                                if (view != cpVar9.l()) {
                                    i = 0;
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
                bmVar2 = this.f2070a.s;
                ForumData c = bmVar2.l().c();
                String name4 = c.getName();
                String id3 = c.getId();
                bmVar3 = this.f2070a.s;
                String a4 = bmVar3.l().d().a();
                adVar2 = this.f2070a.x;
                cpVar10 = this.f2070a.y;
                adVar2.a(id3, name4, a4, i, cpVar10.m());
            }
        }
    }
}
