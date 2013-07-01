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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.f1217a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.model.ax axVar;
        com.baidu.tieba.model.o oVar;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        com.baidu.tieba.model.ax axVar2;
        com.baidu.tieba.model.ax axVar3;
        com.baidu.tieba.model.o oVar2;
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
        com.baidu.tieba.model.ax axVar4;
        bk bkVar22;
        com.baidu.tieba.model.ax axVar5;
        com.baidu.tieba.model.ba baVar;
        com.baidu.tieba.model.ax axVar6;
        com.baidu.tieba.model.ba baVar2;
        com.baidu.tieba.model.ba baVar3;
        bk bkVar23;
        com.baidu.tieba.model.ax axVar7;
        bk bkVar24;
        com.baidu.tieba.model.ax axVar8;
        bk bkVar25;
        com.baidu.tieba.model.ax axVar9;
        com.baidu.tieba.model.ax axVar10;
        bk bkVar26;
        com.baidu.tieba.model.ba baVar4;
        com.baidu.tieba.model.ax axVar11;
        com.baidu.tieba.model.ax axVar12;
        com.baidu.tieba.model.ax axVar13;
        com.baidu.tieba.model.ax axVar14;
        com.baidu.tieba.model.ax axVar15;
        boolean b;
        bk bkVar27;
        bk bkVar28;
        bk bkVar29;
        bk bkVar30;
        com.baidu.tieba.model.ax axVar16;
        boolean b2;
        bk bkVar31;
        bk bkVar32;
        bk bkVar33;
        com.baidu.tieba.model.ax axVar17;
        bk bkVar34;
        bk bkVar35;
        bk bkVar36;
        boolean b3;
        com.baidu.tieba.model.ax axVar18;
        bk bkVar37;
        bk bkVar38;
        com.baidu.tieba.model.ax axVar19;
        bk bkVar39;
        bk bkVar40;
        com.baidu.tieba.model.ax axVar20;
        bk bkVar41;
        com.baidu.tieba.model.ax axVar21;
        bk bkVar42;
        com.baidu.tieba.model.ax axVar22;
        com.baidu.tieba.model.ax axVar23;
        bk bkVar43;
        bk bkVar44;
        com.baidu.tieba.model.ax axVar24;
        com.baidu.tieba.model.am amVar;
        bk bkVar45;
        com.baidu.tieba.model.ba baVar5;
        bk bkVar46;
        com.baidu.tieba.model.ba baVar6;
        bk bkVar47;
        boolean b4;
        boolean b5;
        bk bkVar48;
        bk bkVar49;
        bk bkVar50;
        bk bkVar51;
        com.baidu.tieba.model.o oVar3;
        bk bkVar52;
        com.baidu.tieba.model.ax axVar25;
        com.baidu.tieba.model.o oVar4;
        com.baidu.tieba.model.ax axVar26;
        com.baidu.tieba.model.ax axVar27;
        com.baidu.tieba.model.ax axVar28;
        com.baidu.tieba.model.ba baVar7;
        com.baidu.tieba.model.ba baVar8;
        com.baidu.tieba.model.ba baVar9;
        com.baidu.tieba.model.ba baVar10;
        com.baidu.tieba.model.o oVar5;
        com.baidu.tieba.model.ba baVar11;
        com.baidu.tieba.model.ba baVar12;
        com.baidu.tieba.model.ba baVar13;
        bk bkVar53;
        com.baidu.tieba.model.o oVar6;
        bk bkVar54;
        com.baidu.tieba.model.o oVar7;
        com.baidu.tieba.model.ax axVar29;
        com.baidu.tieba.model.ax axVar30;
        com.baidu.tieba.model.ax axVar31;
        bk bkVar55;
        com.baidu.tieba.model.ax axVar32;
        bk bkVar56;
        int i = 0;
        bkVar = this.f1217a.p;
        if (view == bkVar.F()) {
            axVar32 = this.f1217a.j;
            if (axVar32.a(true)) {
                bkVar56 = this.f1217a.p;
                bkVar56.o();
                return;
            }
            return;
        }
        bkVar2 = this.f1217a.p;
        if (view != bkVar2.I()) {
            bkVar11 = this.f1217a.p;
            if (view != bkVar11.J()) {
                bkVar12 = this.f1217a.p;
                if (view != bkVar12.K()) {
                    bkVar13 = this.f1217a.p;
                    if (view != bkVar13.L()) {
                        bkVar14 = this.f1217a.p;
                        if (view != bkVar14.f()) {
                            bkVar15 = this.f1217a.p;
                            if (view == bkVar15.d()) {
                                bkVar53 = this.f1217a.p;
                                bkVar53.P();
                                String E = TiebaApplication.E();
                                if (E != null && E.length() > 0) {
                                    oVar6 = this.f1217a.o;
                                    if (!oVar6.b()) {
                                        bkVar54 = this.f1217a.p;
                                        bkVar54.b();
                                        oVar7 = this.f1217a.o;
                                        axVar29 = this.f1217a.j;
                                        String a2 = axVar29.j().a().a();
                                        axVar30 = this.f1217a.j;
                                        String b6 = axVar30.j().a().b();
                                        axVar31 = this.f1217a.j;
                                        String a3 = axVar31.j().b().a();
                                        bkVar55 = this.f1217a.p;
                                        oVar7.a(a2, b6, a3, (String) view.getTag(), bkVar55.e());
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1217a, this.f1217a.getString(R.string.login_to_use), true, 1100018);
                                return;
                            }
                            bkVar16 = this.f1217a.p;
                            if (view == bkVar16.c()) {
                                bkVar51 = this.f1217a.p;
                                bkVar51.P();
                                String E2 = TiebaApplication.E();
                                if (E2 != null && E2.length() > 0) {
                                    oVar3 = this.f1217a.o;
                                    if (!oVar3.b()) {
                                        bkVar52 = this.f1217a.p;
                                        bkVar52.b();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            axVar25 = this.f1217a.j;
                                            if (axVar25.h()) {
                                                baVar7 = this.f1217a.n;
                                                if (baVar7 != null) {
                                                    baVar8 = this.f1217a.n;
                                                    if (baVar8.c() != null) {
                                                        baVar9 = this.f1217a.n;
                                                        if (baVar9.c().g() != null) {
                                                            baVar10 = this.f1217a.n;
                                                            if (baVar10.c().l() != null) {
                                                                oVar5 = this.f1217a.o;
                                                                baVar11 = this.f1217a.n;
                                                                String a4 = baVar11.c().g().a();
                                                                baVar12 = this.f1217a.n;
                                                                String b7 = baVar12.c().g().b();
                                                                baVar13 = this.f1217a.n;
                                                                oVar5.a(a4, b7, baVar13.c().l().a(), str, intValue2, intValue, booleanValue);
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
                                            oVar4 = this.f1217a.o;
                                            axVar26 = this.f1217a.j;
                                            String a5 = axVar26.j().a().a();
                                            axVar27 = this.f1217a.j;
                                            String b8 = axVar27.j().a().b();
                                            axVar28 = this.f1217a.j;
                                            oVar4.a(a5, b8, axVar28.j().b().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1217a, this.f1217a.getString(R.string.login_to_use), true, 1100017);
                                return;
                            }
                            bkVar17 = this.f1217a.p;
                            if (view == bkVar17.M()) {
                                bkVar50 = this.f1217a.p;
                                bkVar50.b(true);
                                return;
                            }
                            bkVar18 = this.f1217a.p;
                            if (view == bkVar18.h()) {
                                bkVar49 = this.f1217a.p;
                                bkVar49.l();
                                return;
                            }
                            bkVar19 = this.f1217a.p;
                            if (view != bkVar19.k()) {
                                bkVar20 = this.f1217a.p;
                                if (view != bkVar20.i()) {
                                    bkVar21 = this.f1217a.p;
                                    if (view == bkVar21.j()) {
                                        baVar6 = this.f1217a.n;
                                        if (baVar6.e()) {
                                            bkVar47 = this.f1217a.p;
                                            bkVar47.s();
                                            return;
                                        }
                                        return;
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099657 */:
                                            baVar5 = this.f1217a.n;
                                            if (baVar5.e()) {
                                                bkVar46 = this.f1217a.p;
                                                bkVar46.s();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131099909 */:
                                            bkVar31 = this.f1217a.p;
                                            bkVar31.O();
                                            return;
                                        case R.id.dialog_button_ok /* 2131099910 */:
                                            bkVar32 = this.f1217a.p;
                                            bkVar32.O();
                                            bkVar33 = this.f1217a.p;
                                            if (bkVar33.C() >= 0) {
                                                axVar17 = this.f1217a.j;
                                                bkVar34 = this.f1217a.p;
                                                axVar17.c(bkVar34.C());
                                                bkVar35 = this.f1217a.p;
                                                bkVar35.m();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100156 */:
                                        case R.id.sub_pb_item /* 2131100372 */:
                                        case R.id.sub_pb_more /* 2131100374 */:
                                            try {
                                                axVar4 = this.f1217a.j;
                                                if (axVar4.j() != null) {
                                                    bkVar22 = this.f1217a.p;
                                                    bkVar22.O();
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) sparseArray2.get(R.id.tag_load_sub_data);
                                                    View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                    if (anVar != null && view2 != null) {
                                                        axVar5 = this.f1217a.j;
                                                        com.baidu.tieba.data.aw a6 = axVar5.a(anVar);
                                                        baVar = this.f1217a.n;
                                                        axVar6 = this.f1217a.j;
                                                        baVar.a(axVar6.a());
                                                        baVar2 = this.f1217a.n;
                                                        baVar2.b(anVar.d());
                                                        baVar3 = this.f1217a.n;
                                                        baVar3.b();
                                                        if (view.getId() == R.id.reply) {
                                                            bkVar25 = this.f1217a.p;
                                                            axVar9 = this.f1217a.j;
                                                            bkVar25.a(true, a6, false, null, view2, axVar9.j().l());
                                                        } else if (view.getId() == R.id.sub_pb_item) {
                                                            bkVar24 = this.f1217a.p;
                                                            axVar8 = this.f1217a.j;
                                                            bkVar24.a(true, a6, false, (String) ((SparseArray) view.getTag()).get(R.id.tag_photo_username), view2, axVar8.j().l());
                                                        } else {
                                                            bkVar23 = this.f1217a.p;
                                                            axVar7 = this.f1217a.j;
                                                            bkVar23.a(false, a6, true, null, view2, axVar7.j().l());
                                                        }
                                                    }
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.tieba.util.z.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.pb_title_back /* 2131100331 */:
                                            this.f1217a.f();
                                            return;
                                        case R.id.pb_title_forum /* 2131100332 */:
                                            bkVar45 = this.f1217a.p;
                                            bkVar45.a(0);
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1217a, "pb_header_forum_name", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_host /* 2131100333 */:
                                            axVar23 = this.f1217a.j;
                                            axVar23.o();
                                            bkVar43 = this.f1217a.p;
                                            bkVar43.m();
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1217a, "pb_set_host", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_more /* 2131100334 */:
                                            bkVar44 = this.f1217a.p;
                                            axVar24 = this.f1217a.j;
                                            boolean c = axVar24.c();
                                            amVar = this.f1217a.k;
                                            bkVar44.a(c, amVar.a());
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100339 */:
                                            axVar11 = this.f1217a.j;
                                            if (axVar11 != null) {
                                                axVar12 = this.f1217a.j;
                                                if (axVar12.j() != null) {
                                                    axVar13 = this.f1217a.j;
                                                    if (axVar13.j().a() != null) {
                                                        axVar14 = this.f1217a.j;
                                                        String b9 = axVar14.j().a().b();
                                                        if (b9 != null && b9.length() > 0) {
                                                            axVar15 = this.f1217a.j;
                                                            if (axVar15.d()) {
                                                                this.f1217a.f();
                                                                return;
                                                            } else {
                                                                FrsActivity.a(this.f1217a, b9, (String) null);
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
                                        case R.id.mark_layout /* 2131100358 */:
                                            bkVar36 = this.f1217a.p;
                                            bkVar36.O();
                                            b3 = this.f1217a.b(1100009);
                                            if (b3) {
                                                axVar18 = this.f1217a.j;
                                                bkVar37 = this.f1217a.p;
                                                if (axVar18.f(bkVar37.B()) == null) {
                                                    return;
                                                }
                                                this.f1217a.p();
                                                return;
                                            }
                                            return;
                                        case R.id.share_layout /* 2131100360 */:
                                            bkVar42 = this.f1217a.p;
                                            bkVar42.O();
                                            axVar22 = this.f1217a.j;
                                            axVar22.q();
                                            return;
                                        case R.id.skip_layout /* 2131100361 */:
                                            bkVar40 = this.f1217a.p;
                                            bkVar40.O();
                                            axVar20 = this.f1217a.j;
                                            if (axVar20.k() != null) {
                                                bkVar41 = this.f1217a.p;
                                                axVar21 = this.f1217a.j;
                                                bkVar41.a(axVar21.k());
                                            }
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1217a, "pb_skip_page", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.reverse_layout /* 2131100362 */:
                                            bkVar38 = this.f1217a.p;
                                            bkVar38.O();
                                            axVar19 = this.f1217a.j;
                                            axVar19.p();
                                            bkVar39 = this.f1217a.p;
                                            bkVar39.m();
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1217a, "pb_set_desc", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.sub_pb_buttom_layout /* 2131100365 */:
                                            axVar10 = this.f1217a.j;
                                            if (!axVar10.h()) {
                                                bkVar26 = this.f1217a.p;
                                                bkVar26.u();
                                                baVar4 = this.f1217a.n;
                                                baVar4.cancelLoadData();
                                                return;
                                            }
                                            this.f1217a.f();
                                            return;
                                        case R.id.pb_button_face /* 2131100369 */:
                                        case R.id.pb_button_face1 /* 2131100473 */:
                                            bkVar28 = this.f1217a.p;
                                            bkVar28.x();
                                            return;
                                        case R.id.pb_button_at /* 2131100370 */:
                                        case R.id.pb_button_at1 /* 2131100474 */:
                                            b = this.f1217a.b(1100025);
                                            if (b) {
                                                NewPbActivity newPbActivity = this.f1217a;
                                                bkVar27 = this.f1217a.p;
                                                newPbActivity.q = bkVar27.T();
                                                AtListActivity.a(this.f1217a, 1200004);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_reply_post /* 2131100371 */:
                                            axVar16 = this.f1217a.j;
                                            if (axVar16.j() == null) {
                                                return;
                                            }
                                            b2 = this.f1217a.b(1100001);
                                            if (!b2) {
                                                return;
                                            }
                                            this.f1217a.c((String) null);
                                            return;
                                        case R.id.pb_button_camera /* 2131100470 */:
                                        case R.id.pb_button_camera1 /* 2131100472 */:
                                            NewPbActivity newPbActivity2 = this.f1217a;
                                            bkVar29 = this.f1217a.p;
                                            newPbActivity2.q = bkVar29.T();
                                            ImageButton imageButton = (ImageButton) view;
                                            if (imageButton.getTag() == null) {
                                                bkVar30 = this.f1217a.p;
                                                bkVar30.A();
                                                return;
                                            }
                                            WriteImageActivity.a(this.f1217a, (Bitmap) imageButton.getTag(), 1200003);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                b4 = this.f1217a.b(1100027);
                                if (b4) {
                                    this.f1217a.c((String) view.getTag());
                                    return;
                                }
                                return;
                            }
                            b5 = this.f1217a.b(1100026);
                            if (b5) {
                                NewPbActivity newPbActivity3 = this.f1217a;
                                bkVar48 = this.f1217a.p;
                                newPbActivity3.q = bkVar48.T();
                                AtListActivity.a(this.f1217a, 1200005);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        bkVar3 = this.f1217a.p;
        bkVar3.P();
        axVar = this.f1217a.j;
        if (axVar.j().l() == 1) {
            oVar = this.f1217a.o;
            if (!oVar.b()) {
                bkVar4 = this.f1217a.p;
                bkVar4.b();
                bkVar5 = this.f1217a.p;
                if (view != bkVar5.I()) {
                    bkVar6 = this.f1217a.p;
                    if (view != bkVar6.J()) {
                        bkVar7 = this.f1217a.p;
                        if (view != bkVar7.K()) {
                            bkVar8 = this.f1217a.p;
                            if (view != bkVar8.L()) {
                                bkVar9 = this.f1217a.p;
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
                axVar2 = this.f1217a.j;
                com.baidu.tieba.data.r a7 = axVar2.j().a();
                String b10 = a7.b();
                String a8 = a7.a();
                axVar3 = this.f1217a.j;
                String a9 = axVar3.j().b().a();
                oVar2 = this.f1217a.o;
                bkVar10 = this.f1217a.p;
                oVar2.a(a8, b10, a9, i, bkVar10.g());
            }
        }
    }
}
