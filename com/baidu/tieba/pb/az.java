package com.baidu.tieba.pb;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageButton;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.c.ax axVar;
        com.baidu.tieba.c.l lVar;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        com.baidu.tieba.c.ax axVar2;
        com.baidu.tieba.c.ax axVar3;
        com.baidu.tieba.c.l lVar2;
        bk bkVar10;
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
        com.baidu.tieba.c.ax axVar4;
        bk bkVar22;
        com.baidu.tieba.c.ax axVar5;
        com.baidu.tieba.c.ba baVar;
        com.baidu.tieba.c.ax axVar6;
        com.baidu.tieba.c.ba baVar2;
        com.baidu.tieba.c.ba baVar3;
        bk bkVar23;
        com.baidu.tieba.c.ax axVar7;
        bk bkVar24;
        com.baidu.tieba.c.ax axVar8;
        bk bkVar25;
        com.baidu.tieba.c.ax axVar9;
        com.baidu.tieba.c.ax axVar10;
        bk bkVar26;
        com.baidu.tieba.c.ba baVar4;
        com.baidu.tieba.c.ax axVar11;
        com.baidu.tieba.c.ax axVar12;
        com.baidu.tieba.c.ax axVar13;
        com.baidu.tieba.c.ax axVar14;
        com.baidu.tieba.c.ax axVar15;
        boolean c;
        bk bkVar27;
        bk bkVar28;
        bk bkVar29;
        bk bkVar30;
        com.baidu.tieba.c.ax axVar16;
        boolean c2;
        bk bkVar31;
        bk bkVar32;
        bk bkVar33;
        com.baidu.tieba.c.ax axVar17;
        bk bkVar34;
        bk bkVar35;
        bk bkVar36;
        boolean c3;
        com.baidu.tieba.c.ax axVar18;
        bk bkVar37;
        bk bkVar38;
        com.baidu.tieba.c.ax axVar19;
        bk bkVar39;
        bk bkVar40;
        com.baidu.tieba.c.ax axVar20;
        bk bkVar41;
        com.baidu.tieba.c.ax axVar21;
        bk bkVar42;
        com.baidu.tieba.c.ax axVar22;
        com.baidu.tieba.c.ax axVar23;
        bk bkVar43;
        bk bkVar44;
        com.baidu.tieba.c.ax axVar24;
        com.baidu.tieba.c.ak akVar;
        bk bkVar45;
        com.baidu.tieba.c.ba baVar5;
        bk bkVar46;
        com.baidu.tieba.c.ba baVar6;
        bk bkVar47;
        boolean c4;
        boolean c5;
        bk bkVar48;
        bk bkVar49;
        bk bkVar50;
        bk bkVar51;
        com.baidu.tieba.c.l lVar3;
        bk bkVar52;
        com.baidu.tieba.c.ax axVar25;
        com.baidu.tieba.c.l lVar4;
        com.baidu.tieba.c.ax axVar26;
        com.baidu.tieba.c.ax axVar27;
        com.baidu.tieba.c.ax axVar28;
        com.baidu.tieba.c.ba baVar7;
        com.baidu.tieba.c.ba baVar8;
        com.baidu.tieba.c.ba baVar9;
        com.baidu.tieba.c.ba baVar10;
        com.baidu.tieba.c.l lVar5;
        com.baidu.tieba.c.ba baVar11;
        com.baidu.tieba.c.ba baVar12;
        com.baidu.tieba.c.ba baVar13;
        bk bkVar53;
        com.baidu.tieba.c.l lVar6;
        bk bkVar54;
        com.baidu.tieba.c.l lVar7;
        com.baidu.tieba.c.ax axVar29;
        com.baidu.tieba.c.ax axVar30;
        com.baidu.tieba.c.ax axVar31;
        bk bkVar55;
        com.baidu.tieba.c.ax axVar32;
        bk bkVar56;
        int i = 0;
        bkVar = this.a.p;
        if (view == bkVar.F()) {
            axVar32 = this.a.j;
            if (axVar32.a(true)) {
                bkVar56 = this.a.p;
                bkVar56.p();
                return;
            }
            return;
        }
        bkVar2 = this.a.p;
        if (view != bkVar2.I()) {
            bkVar11 = this.a.p;
            if (view != bkVar11.J()) {
                bkVar12 = this.a.p;
                if (view != bkVar12.K()) {
                    bkVar13 = this.a.p;
                    if (view != bkVar13.L()) {
                        bkVar14 = this.a.p;
                        if (view != bkVar14.f()) {
                            bkVar15 = this.a.p;
                            if (view == bkVar15.d()) {
                                bkVar53 = this.a.p;
                                bkVar53.P();
                                String C = TiebaApplication.C();
                                if (C != null && C.length() > 0) {
                                    lVar6 = this.a.o;
                                    if (!lVar6.f()) {
                                        bkVar54 = this.a.p;
                                        bkVar54.b();
                                        lVar7 = this.a.o;
                                        axVar29 = this.a.j;
                                        String a = axVar29.m().a().a();
                                        axVar30 = this.a.j;
                                        String b = axVar30.m().a().b();
                                        axVar31 = this.a.j;
                                        String a2 = axVar31.m().b().a();
                                        bkVar55 = this.a.p;
                                        lVar7.a(a, b, a2, (String) view.getTag(R.id.tag_forbid_user_name), bkVar55.e());
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 1100018);
                                return;
                            }
                            bkVar16 = this.a.p;
                            if (view == bkVar16.c()) {
                                bkVar51 = this.a.p;
                                bkVar51.P();
                                String C2 = TiebaApplication.C();
                                if (C2 != null && C2.length() > 0) {
                                    lVar3 = this.a.o;
                                    if (!lVar3.f()) {
                                        bkVar52 = this.a.p;
                                        bkVar52.b();
                                        String str = (String) view.getTag(R.id.tag_del_post_id);
                                        int intValue = ((Integer) view.getTag(R.id.tag_manage_user_identity)).intValue();
                                        boolean booleanValue = ((Boolean) view.getTag(R.id.tag_del_post_is_self)).booleanValue();
                                        int intValue2 = ((Integer) view.getTag(R.id.tag_del_post_type)).intValue();
                                        axVar25 = this.a.j;
                                        if (axVar25.k()) {
                                            baVar7 = this.a.n;
                                            if (baVar7 != null) {
                                                baVar8 = this.a.n;
                                                if (baVar8.f() != null) {
                                                    baVar9 = this.a.n;
                                                    if (baVar9.f().g() != null) {
                                                        baVar10 = this.a.n;
                                                        if (baVar10.f().l() != null) {
                                                            lVar5 = this.a.o;
                                                            baVar11 = this.a.n;
                                                            String a3 = baVar11.f().g().a();
                                                            baVar12 = this.a.n;
                                                            String b2 = baVar12.f().g().b();
                                                            baVar13 = this.a.n;
                                                            lVar5.a(a3, b2, baVar13.f().l().a(), str, intValue2, intValue, booleanValue);
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
                                        lVar4 = this.a.o;
                                        axVar26 = this.a.j;
                                        String a4 = axVar26.m().a().a();
                                        axVar27 = this.a.j;
                                        String b3 = axVar27.m().a().b();
                                        axVar28 = this.a.j;
                                        lVar4.a(a4, b3, axVar28.m().b().a(), str, intValue2, intValue, booleanValue);
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 1100017);
                                return;
                            }
                            bkVar17 = this.a.p;
                            if (view == bkVar17.M()) {
                                bkVar50 = this.a.p;
                                bkVar50.a(true);
                                return;
                            }
                            bkVar18 = this.a.p;
                            if (view == bkVar18.h()) {
                                bkVar49 = this.a.p;
                                bkVar49.l();
                                return;
                            }
                            bkVar19 = this.a.p;
                            if (view != bkVar19.k()) {
                                bkVar20 = this.a.p;
                                if (view != bkVar20.i()) {
                                    bkVar21 = this.a.p;
                                    if (view == bkVar21.j()) {
                                        baVar6 = this.a.n;
                                        if (baVar6.i()) {
                                            bkVar47 = this.a.p;
                                            bkVar47.s();
                                            return;
                                        }
                                        return;
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099657 */:
                                            baVar5 = this.a.n;
                                            if (baVar5.i()) {
                                                bkVar46 = this.a.p;
                                                bkVar46.s();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131099903 */:
                                            bkVar31 = this.a.p;
                                            bkVar31.O();
                                            return;
                                        case R.id.dialog_button_ok /* 2131099904 */:
                                            bkVar32 = this.a.p;
                                            bkVar32.O();
                                            bkVar33 = this.a.p;
                                            if (bkVar33.C() >= 0) {
                                                axVar17 = this.a.j;
                                                bkVar34 = this.a.p;
                                                axVar17.d(bkVar34.C());
                                                bkVar35 = this.a.p;
                                                bkVar35.m();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100115 */:
                                        case R.id.sub_pb_item /* 2131100336 */:
                                        case R.id.sub_pb_more /* 2131100338 */:
                                            try {
                                                axVar4 = this.a.j;
                                                if (axVar4.m() != null) {
                                                    bkVar22 = this.a.p;
                                                    bkVar22.O();
                                                    SparseArray sparseArray = (SparseArray) view.getTag();
                                                    com.baidu.tieba.a.ar arVar = (com.baidu.tieba.a.ar) sparseArray.get(R.id.tag_load_sub_data);
                                                    View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                    if (arVar != null && view2 != null) {
                                                        axVar5 = this.a.j;
                                                        com.baidu.tieba.a.ay a5 = axVar5.a(arVar);
                                                        baVar = this.a.n;
                                                        axVar6 = this.a.j;
                                                        baVar.b(axVar6.d());
                                                        baVar2 = this.a.n;
                                                        baVar2.c(arVar.d());
                                                        baVar3 = this.a.n;
                                                        baVar3.e();
                                                        if (view.getId() == R.id.reply) {
                                                            bkVar25 = this.a.p;
                                                            axVar9 = this.a.j;
                                                            bkVar25.a(true, a5, false, null, view2, axVar9.m().l());
                                                        } else if (view.getId() == R.id.sub_pb_item) {
                                                            bkVar24 = this.a.p;
                                                            axVar8 = this.a.j;
                                                            bkVar24.a(true, a5, false, (String) ((SparseArray) view.getTag()).get(R.id.tag_photo_username), view2, axVar8.m().l());
                                                        } else {
                                                            bkVar23 = this.a.p;
                                                            axVar7 = this.a.j;
                                                            bkVar23.a(false, a5, true, null, view2, axVar7.m().l());
                                                        }
                                                    }
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.tieba.d.ae.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.pb_title_back /* 2131100295 */:
                                            this.a.f();
                                            return;
                                        case R.id.pb_title_forum /* 2131100296 */:
                                            bkVar45 = this.a.p;
                                            bkVar45.a(0);
                                            if (TiebaApplication.e().p()) {
                                                StatService.onEvent(this.a, "pb_header_forum_name", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_host /* 2131100297 */:
                                            axVar23 = this.a.j;
                                            axVar23.t();
                                            bkVar43 = this.a.p;
                                            bkVar43.m();
                                            if (TiebaApplication.e().p()) {
                                                StatService.onEvent(this.a, "pb_set_host", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_more /* 2131100298 */:
                                            bkVar44 = this.a.p;
                                            axVar24 = this.a.j;
                                            boolean f = axVar24.f();
                                            akVar = this.a.k;
                                            bkVar44.a(f, akVar.d());
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100303 */:
                                            axVar11 = this.a.j;
                                            if (axVar11 != null) {
                                                axVar12 = this.a.j;
                                                if (axVar12.m() != null) {
                                                    axVar13 = this.a.j;
                                                    if (axVar13.m().a() != null) {
                                                        axVar14 = this.a.j;
                                                        String b4 = axVar14.m().a().b();
                                                        if (b4 != null && b4.length() > 0) {
                                                            axVar15 = this.a.j;
                                                            if (axVar15.g()) {
                                                                this.a.f();
                                                                return;
                                                            } else {
                                                                FrsActivity.a(this.a, b4, (String) null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case R.id.mark_layout /* 2131100322 */:
                                            bkVar36 = this.a.p;
                                            bkVar36.O();
                                            c3 = this.a.c(1100009);
                                            if (c3) {
                                                axVar18 = this.a.j;
                                                bkVar37 = this.a.p;
                                                if (axVar18.g(bkVar37.B()) == null) {
                                                    return;
                                                }
                                                this.a.p();
                                                return;
                                            }
                                            return;
                                        case R.id.share_layout /* 2131100324 */:
                                            bkVar42 = this.a.p;
                                            bkVar42.O();
                                            axVar22 = this.a.j;
                                            axVar22.v();
                                            return;
                                        case R.id.skip_layout /* 2131100325 */:
                                            bkVar40 = this.a.p;
                                            bkVar40.O();
                                            axVar20 = this.a.j;
                                            if (axVar20.n() != null) {
                                                bkVar41 = this.a.p;
                                                axVar21 = this.a.j;
                                                bkVar41.a(axVar21.n());
                                            }
                                            if (TiebaApplication.e().p()) {
                                                StatService.onEvent(this.a, "pb_skip_page", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.reverse_layout /* 2131100326 */:
                                            bkVar38 = this.a.p;
                                            bkVar38.O();
                                            axVar19 = this.a.j;
                                            axVar19.u();
                                            bkVar39 = this.a.p;
                                            bkVar39.m();
                                            if (TiebaApplication.e().p()) {
                                                StatService.onEvent(this.a, "pb_set_desc", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.sub_pb_buttom_layout /* 2131100329 */:
                                            axVar10 = this.a.j;
                                            if (!axVar10.k()) {
                                                bkVar26 = this.a.p;
                                                bkVar26.u();
                                                baVar4 = this.a.n;
                                                baVar4.h();
                                                return;
                                            }
                                            this.a.f();
                                            return;
                                        case R.id.pb_button_face /* 2131100333 */:
                                        case R.id.pb_button_face1 /* 2131100438 */:
                                            bkVar28 = this.a.p;
                                            bkVar28.x();
                                            return;
                                        case R.id.pb_button_at /* 2131100334 */:
                                        case R.id.pb_button_at1 /* 2131100439 */:
                                            c = this.a.c(1100025);
                                            if (c) {
                                                NewPbActivity newPbActivity = this.a;
                                                bkVar27 = this.a.p;
                                                newPbActivity.q = bkVar27.T();
                                                AtListActivity.a(this.a, 1200004);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_reply_post /* 2131100335 */:
                                            axVar16 = this.a.j;
                                            if (axVar16.m() == null) {
                                                return;
                                            }
                                            c2 = this.a.c(1100001);
                                            if (!c2) {
                                                return;
                                            }
                                            this.a.c((String) null);
                                            return;
                                        case R.id.pb_button_camera /* 2131100435 */:
                                        case R.id.pb_button_camera1 /* 2131100437 */:
                                            NewPbActivity newPbActivity2 = this.a;
                                            bkVar29 = this.a.p;
                                            newPbActivity2.q = bkVar29.T();
                                            ImageButton imageButton = (ImageButton) view;
                                            if (imageButton.getTag() == null) {
                                                bkVar30 = this.a.p;
                                                bkVar30.A();
                                                return;
                                            }
                                            WriteImageActivity.a(this.a, (Bitmap) imageButton.getTag(), 1200003);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                c4 = this.a.c(1100027);
                                if (c4) {
                                    this.a.c((String) view.getTag());
                                    return;
                                }
                                return;
                            }
                            c5 = this.a.c(1100026);
                            if (c5) {
                                NewPbActivity newPbActivity3 = this.a;
                                bkVar48 = this.a.p;
                                newPbActivity3.q = bkVar48.T();
                                AtListActivity.a(this.a, 1200005);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        bkVar3 = this.a.p;
        bkVar3.P();
        axVar = this.a.j;
        if (axVar.m().l() == 1) {
            lVar = this.a.o;
            if (!lVar.f()) {
                bkVar4 = this.a.p;
                bkVar4.b();
                bkVar5 = this.a.p;
                if (view != bkVar5.I()) {
                    bkVar6 = this.a.p;
                    if (view != bkVar6.J()) {
                        bkVar7 = this.a.p;
                        if (view != bkVar7.K()) {
                            bkVar8 = this.a.p;
                            if (view != bkVar8.L()) {
                                bkVar9 = this.a.p;
                                if (view == bkVar9.f()) {
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
                axVar2 = this.a.j;
                com.baidu.tieba.a.s a6 = axVar2.m().a();
                String b5 = a6.b();
                String a7 = a6.a();
                axVar3 = this.a.j;
                String a8 = axVar3.m().b().a();
                lVar2 = this.a.o;
                bkVar10 = this.a.p;
                lVar2.a(a7, b5, a8, i, bkVar10.g());
            }
        }
    }
}
