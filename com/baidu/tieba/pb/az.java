package com.baidu.tieba.pb;

import android.app.Activity;
import android.graphics.Bitmap;
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
        bl blVar;
        bl blVar2;
        bl blVar3;
        com.baidu.tieba.c.au auVar;
        com.baidu.tieba.c.i iVar;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        bl blVar9;
        com.baidu.tieba.c.au auVar2;
        com.baidu.tieba.c.au auVar3;
        com.baidu.tieba.c.i iVar2;
        bl blVar10;
        bl blVar11;
        bl blVar12;
        bl blVar13;
        bl blVar14;
        bl blVar15;
        bl blVar16;
        bl blVar17;
        bl blVar18;
        bl blVar19;
        bl blVar20;
        bl blVar21;
        com.baidu.tieba.c.au auVar4;
        bl blVar22;
        com.baidu.tieba.c.au auVar5;
        com.baidu.tieba.c.ax axVar;
        com.baidu.tieba.c.au auVar6;
        com.baidu.tieba.c.ax axVar2;
        com.baidu.tieba.c.ax axVar3;
        bl blVar23;
        com.baidu.tieba.c.au auVar7;
        bl blVar24;
        com.baidu.tieba.c.au auVar8;
        bl blVar25;
        com.baidu.tieba.c.au auVar9;
        com.baidu.tieba.c.au auVar10;
        bl blVar26;
        com.baidu.tieba.c.ax axVar4;
        com.baidu.tieba.c.au auVar11;
        com.baidu.tieba.c.au auVar12;
        com.baidu.tieba.c.au auVar13;
        com.baidu.tieba.c.au auVar14;
        com.baidu.tieba.c.au auVar15;
        boolean c;
        bl blVar27;
        bl blVar28;
        bl blVar29;
        bl blVar30;
        com.baidu.tieba.c.au auVar16;
        boolean c2;
        bl blVar31;
        bl blVar32;
        bl blVar33;
        com.baidu.tieba.c.au auVar17;
        bl blVar34;
        bl blVar35;
        bl blVar36;
        boolean c3;
        com.baidu.tieba.c.au auVar18;
        bl blVar37;
        bl blVar38;
        com.baidu.tieba.c.au auVar19;
        bl blVar39;
        bl blVar40;
        com.baidu.tieba.c.au auVar20;
        bl blVar41;
        com.baidu.tieba.c.au auVar21;
        bl blVar42;
        com.baidu.tieba.c.au auVar22;
        com.baidu.tieba.c.au auVar23;
        bl blVar43;
        bl blVar44;
        com.baidu.tieba.c.au auVar24;
        com.baidu.tieba.c.ah ahVar;
        bl blVar45;
        com.baidu.tieba.c.ax axVar5;
        bl blVar46;
        com.baidu.tieba.c.ax axVar6;
        bl blVar47;
        boolean c4;
        boolean c5;
        bl blVar48;
        bl blVar49;
        bl blVar50;
        bl blVar51;
        com.baidu.tieba.c.i iVar3;
        bl blVar52;
        com.baidu.tieba.c.au auVar25;
        com.baidu.tieba.c.i iVar4;
        com.baidu.tieba.c.au auVar26;
        com.baidu.tieba.c.au auVar27;
        com.baidu.tieba.c.au auVar28;
        com.baidu.tieba.c.ax axVar7;
        com.baidu.tieba.c.ax axVar8;
        com.baidu.tieba.c.ax axVar9;
        com.baidu.tieba.c.ax axVar10;
        com.baidu.tieba.c.i iVar5;
        com.baidu.tieba.c.ax axVar11;
        com.baidu.tieba.c.ax axVar12;
        com.baidu.tieba.c.ax axVar13;
        bl blVar53;
        com.baidu.tieba.c.i iVar6;
        bl blVar54;
        com.baidu.tieba.c.i iVar7;
        com.baidu.tieba.c.au auVar29;
        com.baidu.tieba.c.au auVar30;
        com.baidu.tieba.c.au auVar31;
        bl blVar55;
        com.baidu.tieba.c.au auVar32;
        bl blVar56;
        int i = 0;
        blVar = this.a.o;
        if (view == blVar.E()) {
            auVar32 = this.a.i;
            if (auVar32.a(true)) {
                blVar56 = this.a.o;
                blVar56.p();
                return;
            }
            return;
        }
        blVar2 = this.a.o;
        if (view != blVar2.H()) {
            blVar11 = this.a.o;
            if (view != blVar11.I()) {
                blVar12 = this.a.o;
                if (view != blVar12.J()) {
                    blVar13 = this.a.o;
                    if (view != blVar13.K()) {
                        blVar14 = this.a.o;
                        if (view != blVar14.f()) {
                            blVar15 = this.a.o;
                            if (view == blVar15.d()) {
                                blVar53 = this.a.o;
                                blVar53.O();
                                String z = TiebaApplication.z();
                                if (z != null && z.length() > 0) {
                                    iVar6 = this.a.n;
                                    if (!iVar6.f()) {
                                        blVar54 = this.a.o;
                                        blVar54.b();
                                        iVar7 = this.a.n;
                                        auVar29 = this.a.i;
                                        String a = auVar29.l().a().a();
                                        auVar30 = this.a.i;
                                        String b = auVar30.l().a().b();
                                        auVar31 = this.a.i;
                                        String a2 = auVar31.l().b().a();
                                        blVar55 = this.a.o;
                                        iVar7.a(a, b, a2, (String) view.getTag(R.id.tag_forbid_user_name), blVar55.e());
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 1100018);
                                return;
                            }
                            blVar16 = this.a.o;
                            if (view == blVar16.c()) {
                                blVar51 = this.a.o;
                                blVar51.O();
                                String z2 = TiebaApplication.z();
                                if (z2 != null && z2.length() > 0) {
                                    iVar3 = this.a.n;
                                    if (!iVar3.f()) {
                                        blVar52 = this.a.o;
                                        blVar52.b();
                                        String str = (String) view.getTag(R.id.tag_del_post_id);
                                        int intValue = ((Integer) view.getTag(R.id.tag_manage_user_identity)).intValue();
                                        int intValue2 = ((Integer) view.getTag(R.id.tag_del_post_type)).intValue();
                                        auVar25 = this.a.i;
                                        if (auVar25.k()) {
                                            axVar7 = this.a.m;
                                            if (axVar7 != null) {
                                                axVar8 = this.a.m;
                                                if (axVar8.f() != null) {
                                                    axVar9 = this.a.m;
                                                    if (axVar9.f().g() != null) {
                                                        axVar10 = this.a.m;
                                                        if (axVar10.f().l() != null) {
                                                            iVar5 = this.a.n;
                                                            axVar11 = this.a.m;
                                                            String a3 = axVar11.f().g().a();
                                                            axVar12 = this.a.m;
                                                            String b2 = axVar12.f().g().b();
                                                            axVar13 = this.a.m;
                                                            iVar5.a(a3, b2, axVar13.f().l().a(), str, intValue2, intValue);
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
                                        iVar4 = this.a.n;
                                        auVar26 = this.a.i;
                                        String a4 = auVar26.l().a().a();
                                        auVar27 = this.a.i;
                                        String b3 = auVar27.l().a().b();
                                        auVar28 = this.a.i;
                                        iVar4.a(a4, b3, auVar28.l().b().a(), str, intValue2, intValue);
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 1100017);
                                return;
                            }
                            blVar17 = this.a.o;
                            if (view == blVar17.L()) {
                                blVar50 = this.a.o;
                                blVar50.a(true);
                                return;
                            }
                            blVar18 = this.a.o;
                            if (view == blVar18.h()) {
                                blVar49 = this.a.o;
                                blVar49.l();
                                return;
                            }
                            blVar19 = this.a.o;
                            if (view != blVar19.k()) {
                                blVar20 = this.a.o;
                                if (view != blVar20.i()) {
                                    blVar21 = this.a.o;
                                    if (view == blVar21.j()) {
                                        axVar6 = this.a.m;
                                        if (axVar6.i()) {
                                            blVar47 = this.a.o;
                                            blVar47.s();
                                            return;
                                        }
                                        return;
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099657 */:
                                            axVar5 = this.a.m;
                                            if (axVar5.i()) {
                                                blVar46 = this.a.o;
                                                blVar46.s();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131099874 */:
                                            blVar31 = this.a.o;
                                            blVar31.N();
                                            return;
                                        case R.id.dialog_button_ok /* 2131099875 */:
                                            blVar32 = this.a.o;
                                            blVar32.N();
                                            blVar33 = this.a.o;
                                            if (blVar33.B() >= 0) {
                                                auVar17 = this.a.i;
                                                blVar34 = this.a.o;
                                                auVar17.d(blVar34.B());
                                                blVar35 = this.a.o;
                                                blVar35.m();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100079 */:
                                        case R.id.sub_pb_item /* 2131100285 */:
                                        case R.id.sub_pb_more /* 2131100287 */:
                                            try {
                                                auVar4 = this.a.i;
                                                if (auVar4.l() != null) {
                                                    blVar22 = this.a.o;
                                                    blVar22.N();
                                                    com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) view.getTag(R.id.tag_load_sub_data);
                                                    View view2 = (View) view.getTag(R.id.tag_load_sub_view);
                                                    if (aqVar != null && view2 != null) {
                                                        auVar5 = this.a.i;
                                                        com.baidu.tieba.a.ax a5 = auVar5.a(aqVar);
                                                        axVar = this.a.m;
                                                        auVar6 = this.a.i;
                                                        axVar.b(auVar6.d());
                                                        axVar2 = this.a.m;
                                                        axVar2.c(aqVar.d());
                                                        axVar3 = this.a.m;
                                                        axVar3.e();
                                                        if (view.getId() == R.id.reply) {
                                                            blVar25 = this.a.o;
                                                            auVar9 = this.a.i;
                                                            blVar25.a(true, a5, false, null, view2, auVar9.l().l());
                                                        } else if (view.getId() == R.id.sub_pb_item) {
                                                            blVar24 = this.a.o;
                                                            auVar8 = this.a.i;
                                                            blVar24.a(true, a5, false, (String) view.getTag(R.id.tag_photo_username), view2, auVar8.l().l());
                                                        } else {
                                                            blVar23 = this.a.o;
                                                            auVar7 = this.a.i;
                                                            blVar23.a(false, a5, true, null, view2, auVar7.l().l());
                                                        }
                                                    }
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.tieba.d.ae.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.pb_title_back /* 2131100244 */:
                                            this.a.f();
                                            return;
                                        case R.id.pb_title_forum /* 2131100245 */:
                                            blVar45 = this.a.o;
                                            blVar45.a(0);
                                            if (TiebaApplication.d().n()) {
                                                StatService.onEvent(this.a, "pb_header_forum_name", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_host /* 2131100246 */:
                                            auVar23 = this.a.i;
                                            auVar23.s();
                                            blVar43 = this.a.o;
                                            blVar43.m();
                                            if (TiebaApplication.d().n()) {
                                                StatService.onEvent(this.a, "pb_set_host", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_more /* 2131100247 */:
                                            blVar44 = this.a.o;
                                            auVar24 = this.a.i;
                                            boolean f = auVar24.f();
                                            ahVar = this.a.j;
                                            blVar44.a(f, ahVar.d());
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100252 */:
                                            auVar11 = this.a.i;
                                            if (auVar11 != null) {
                                                auVar12 = this.a.i;
                                                if (auVar12.l() != null) {
                                                    auVar13 = this.a.i;
                                                    if (auVar13.l().a() != null) {
                                                        auVar14 = this.a.i;
                                                        String b4 = auVar14.l().a().b();
                                                        if (b4 != null && b4.length() > 0) {
                                                            auVar15 = this.a.i;
                                                            if (auVar15.g()) {
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
                                        case R.id.mark_layout /* 2131100271 */:
                                            blVar36 = this.a.o;
                                            blVar36.N();
                                            c3 = this.a.c(1100009);
                                            if (c3) {
                                                auVar18 = this.a.i;
                                                blVar37 = this.a.o;
                                                if (auVar18.g(blVar37.A()) == null) {
                                                    return;
                                                }
                                                this.a.p();
                                                return;
                                            }
                                            return;
                                        case R.id.share_layout /* 2131100273 */:
                                            blVar42 = this.a.o;
                                            blVar42.N();
                                            auVar22 = this.a.i;
                                            auVar22.u();
                                            return;
                                        case R.id.skip_layout /* 2131100274 */:
                                            blVar40 = this.a.o;
                                            blVar40.N();
                                            auVar20 = this.a.i;
                                            if (auVar20.m() != null) {
                                                blVar41 = this.a.o;
                                                auVar21 = this.a.i;
                                                blVar41.a(auVar21.m());
                                            }
                                            if (TiebaApplication.d().n()) {
                                                StatService.onEvent(this.a, "pb_skip_page", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.reverse_layout /* 2131100275 */:
                                            blVar38 = this.a.o;
                                            blVar38.N();
                                            auVar19 = this.a.i;
                                            auVar19.t();
                                            blVar39 = this.a.o;
                                            blVar39.m();
                                            if (TiebaApplication.d().n()) {
                                                StatService.onEvent(this.a, "pb_set_desc", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.sub_pb_buttom_layout /* 2131100278 */:
                                            auVar10 = this.a.i;
                                            if (!auVar10.k()) {
                                                blVar26 = this.a.o;
                                                blVar26.u();
                                                axVar4 = this.a.m;
                                                axVar4.h();
                                                return;
                                            }
                                            this.a.f();
                                            return;
                                        case R.id.pb_button_face /* 2131100282 */:
                                        case R.id.pb_button_face1 /* 2131100377 */:
                                            blVar28 = this.a.o;
                                            blVar28.x();
                                            return;
                                        case R.id.pb_button_at /* 2131100283 */:
                                        case R.id.pb_button_at1 /* 2131100378 */:
                                            c = this.a.c(1100025);
                                            if (c) {
                                                NewPbActivity newPbActivity = this.a;
                                                blVar27 = this.a.o;
                                                newPbActivity.p = blVar27.S();
                                                AtListActivity.a(this.a, 1200004);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_reply_post /* 2131100284 */:
                                            auVar16 = this.a.i;
                                            if (auVar16.l() == null) {
                                                return;
                                            }
                                            c2 = this.a.c(1100001);
                                            if (!c2) {
                                                return;
                                            }
                                            this.a.c((String) null);
                                            return;
                                        case R.id.pb_button_camera /* 2131100374 */:
                                        case R.id.pb_button_camera1 /* 2131100376 */:
                                            NewPbActivity newPbActivity2 = this.a;
                                            blVar29 = this.a.o;
                                            newPbActivity2.p = blVar29.S();
                                            ImageButton imageButton = (ImageButton) view;
                                            if (imageButton.getTag() == null) {
                                                blVar30 = this.a.o;
                                                blVar30.z();
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
                                    this.a.c((String) view.getTag(R.id.tag_post_id));
                                    return;
                                }
                                return;
                            }
                            c5 = this.a.c(1100026);
                            if (c5) {
                                NewPbActivity newPbActivity3 = this.a;
                                blVar48 = this.a.o;
                                newPbActivity3.p = blVar48.S();
                                AtListActivity.a(this.a, 1200005);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        blVar3 = this.a.o;
        blVar3.O();
        auVar = this.a.i;
        if (auVar.l().l() == 1) {
            iVar = this.a.n;
            if (!iVar.f()) {
                blVar4 = this.a.o;
                blVar4.b();
                blVar5 = this.a.o;
                if (view != blVar5.H()) {
                    blVar6 = this.a.o;
                    if (view != blVar6.I()) {
                        blVar7 = this.a.o;
                        if (view != blVar7.J()) {
                            blVar8 = this.a.o;
                            if (view != blVar8.K()) {
                                blVar9 = this.a.o;
                                if (view == blVar9.f()) {
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
                auVar2 = this.a.i;
                com.baidu.tieba.a.s a6 = auVar2.l().a();
                String b5 = a6.b();
                String a7 = a6.a();
                auVar3 = this.a.i;
                String a8 = auVar3.l().b().a();
                iVar2 = this.a.n;
                blVar10 = this.a.o;
                iVar2.a(a7, b5, a8, i, blVar10.g());
            }
        }
    }
}
