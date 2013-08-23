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
class bd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewPbActivity newPbActivity) {
        this.f1507a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.t tVar;
        bo boVar4;
        bo boVar5;
        bo boVar6;
        bo boVar7;
        bo boVar8;
        bo boVar9;
        com.baidu.tieba.model.bb bbVar2;
        com.baidu.tieba.model.bb bbVar3;
        com.baidu.tieba.model.t tVar2;
        bo boVar10;
        bo boVar11;
        bo boVar12;
        bo boVar13;
        bo boVar14;
        bo boVar15;
        bo boVar16;
        bo boVar17;
        bo boVar18;
        bo boVar19;
        bo boVar20;
        bo boVar21;
        com.baidu.tieba.model.bb bbVar4;
        bo boVar22;
        com.baidu.tieba.model.bb bbVar5;
        com.baidu.tieba.model.be beVar;
        com.baidu.tieba.model.bb bbVar6;
        com.baidu.tieba.model.be beVar2;
        com.baidu.tieba.model.be beVar3;
        bo boVar23;
        com.baidu.tieba.model.bb bbVar7;
        bo boVar24;
        com.baidu.tieba.model.bb bbVar8;
        bo boVar25;
        com.baidu.tieba.model.bb bbVar9;
        com.baidu.tieba.model.bb bbVar10;
        bo boVar26;
        com.baidu.tieba.model.be beVar4;
        com.baidu.tieba.model.bb bbVar11;
        com.baidu.tieba.model.bb bbVar12;
        com.baidu.tieba.model.bb bbVar13;
        com.baidu.tieba.model.bb bbVar14;
        com.baidu.tieba.model.bb bbVar15;
        boolean b;
        bo boVar27;
        bo boVar28;
        bo boVar29;
        bo boVar30;
        com.baidu.tieba.model.bb bbVar16;
        boolean b2;
        bo boVar31;
        bo boVar32;
        bo boVar33;
        com.baidu.tieba.model.bb bbVar17;
        bo boVar34;
        bo boVar35;
        bo boVar36;
        boolean b3;
        com.baidu.tieba.model.bb bbVar18;
        bo boVar37;
        bo boVar38;
        com.baidu.tieba.model.bb bbVar19;
        bo boVar39;
        bo boVar40;
        com.baidu.tieba.model.bb bbVar20;
        bo boVar41;
        com.baidu.tieba.model.bb bbVar21;
        bo boVar42;
        com.baidu.tieba.model.bb bbVar22;
        com.baidu.tieba.model.bb bbVar23;
        bo boVar43;
        bo boVar44;
        com.baidu.tieba.model.bb bbVar24;
        com.baidu.tieba.model.au auVar;
        bo boVar45;
        com.baidu.tieba.model.be beVar5;
        bo boVar46;
        com.baidu.tieba.model.be beVar6;
        bo boVar47;
        boolean b4;
        boolean b5;
        bo boVar48;
        bo boVar49;
        bo boVar50;
        bo boVar51;
        com.baidu.tieba.model.t tVar3;
        bo boVar52;
        com.baidu.tieba.model.bb bbVar25;
        com.baidu.tieba.model.t tVar4;
        com.baidu.tieba.model.bb bbVar26;
        com.baidu.tieba.model.bb bbVar27;
        com.baidu.tieba.model.bb bbVar28;
        com.baidu.tieba.model.be beVar7;
        com.baidu.tieba.model.be beVar8;
        com.baidu.tieba.model.be beVar9;
        com.baidu.tieba.model.be beVar10;
        com.baidu.tieba.model.t tVar5;
        com.baidu.tieba.model.be beVar11;
        com.baidu.tieba.model.be beVar12;
        com.baidu.tieba.model.be beVar13;
        bo boVar53;
        com.baidu.tieba.model.t tVar6;
        bo boVar54;
        com.baidu.tieba.model.t tVar7;
        com.baidu.tieba.model.bb bbVar29;
        com.baidu.tieba.model.bb bbVar30;
        com.baidu.tieba.model.bb bbVar31;
        bo boVar55;
        com.baidu.tieba.model.bb bbVar32;
        bo boVar56;
        int i = 0;
        boVar = this.f1507a.q;
        if (view == boVar.G()) {
            bbVar32 = this.f1507a.k;
            if (bbVar32.a(true)) {
                boVar56 = this.f1507a.q;
                boVar56.p();
                return;
            }
            return;
        }
        boVar2 = this.f1507a.q;
        if (view != boVar2.J()) {
            boVar11 = this.f1507a.q;
            if (view != boVar11.K()) {
                boVar12 = this.f1507a.q;
                if (view != boVar12.L()) {
                    boVar13 = this.f1507a.q;
                    if (view != boVar13.M()) {
                        boVar14 = this.f1507a.q;
                        if (view != boVar14.g()) {
                            boVar15 = this.f1507a.q;
                            if (view == boVar15.e()) {
                                boVar53 = this.f1507a.q;
                                boVar53.Q();
                                String E = TiebaApplication.E();
                                if (E != null && E.length() > 0) {
                                    tVar6 = this.f1507a.p;
                                    if (!tVar6.b()) {
                                        boVar54 = this.f1507a.q;
                                        boVar54.c();
                                        tVar7 = this.f1507a.p;
                                        bbVar29 = this.f1507a.k;
                                        String a2 = bbVar29.k().b().a();
                                        bbVar30 = this.f1507a.k;
                                        String b6 = bbVar30.k().b().b();
                                        bbVar31 = this.f1507a.k;
                                        String a3 = bbVar31.k().c().a();
                                        boVar55 = this.f1507a.q;
                                        tVar7.a(a2, b6, a3, (String) view.getTag(), boVar55.f());
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1507a, this.f1507a.getString(R.string.login_to_use), true, 11018);
                                return;
                            }
                            boVar16 = this.f1507a.q;
                            if (view == boVar16.d()) {
                                boVar51 = this.f1507a.q;
                                boVar51.Q();
                                String E2 = TiebaApplication.E();
                                if (E2 != null && E2.length() > 0) {
                                    tVar3 = this.f1507a.p;
                                    if (!tVar3.b()) {
                                        boVar52 = this.f1507a.q;
                                        boVar52.c();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bbVar25 = this.f1507a.k;
                                            if (bbVar25.h()) {
                                                beVar7 = this.f1507a.o;
                                                if (beVar7 != null) {
                                                    beVar8 = this.f1507a.o;
                                                    if (beVar8.c() != null) {
                                                        beVar9 = this.f1507a.o;
                                                        if (beVar9.c().g() != null) {
                                                            beVar10 = this.f1507a.o;
                                                            if (beVar10.c().l() != null) {
                                                                tVar5 = this.f1507a.p;
                                                                beVar11 = this.f1507a.o;
                                                                String a4 = beVar11.c().g().a();
                                                                beVar12 = this.f1507a.o;
                                                                String b7 = beVar12.c().g().b();
                                                                beVar13 = this.f1507a.o;
                                                                tVar5.a(a4, b7, beVar13.c().l().a(), str, intValue2, intValue, booleanValue);
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
                                            tVar4 = this.f1507a.p;
                                            bbVar26 = this.f1507a.k;
                                            String a5 = bbVar26.k().b().a();
                                            bbVar27 = this.f1507a.k;
                                            String b8 = bbVar27.k().b().b();
                                            bbVar28 = this.f1507a.k;
                                            tVar4.a(a5, b8, bbVar28.k().c().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1507a, this.f1507a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            boVar17 = this.f1507a.q;
                            if (view == boVar17.N()) {
                                boVar50 = this.f1507a.q;
                                boVar50.b(true);
                                return;
                            }
                            boVar18 = this.f1507a.q;
                            if (view == boVar18.i()) {
                                boVar49 = this.f1507a.q;
                                boVar49.m();
                                return;
                            }
                            boVar19 = this.f1507a.q;
                            if (view != boVar19.l()) {
                                boVar20 = this.f1507a.q;
                                if (view != boVar20.j()) {
                                    boVar21 = this.f1507a.q;
                                    if (view == boVar21.k()) {
                                        beVar6 = this.f1507a.o;
                                        if (beVar6.e()) {
                                            boVar47 = this.f1507a.q;
                                            boVar47.t();
                                            return;
                                        }
                                        return;
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099658 */:
                                            beVar5 = this.f1507a.o;
                                            if (beVar5.e()) {
                                                boVar46 = this.f1507a.q;
                                                boVar46.t();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131099916 */:
                                            boVar31 = this.f1507a.q;
                                            boVar31.P();
                                            return;
                                        case R.id.dialog_button_ok /* 2131099917 */:
                                            boVar32 = this.f1507a.q;
                                            boVar32.P();
                                            boVar33 = this.f1507a.q;
                                            if (boVar33.D() >= 0) {
                                                bbVar17 = this.f1507a.k;
                                                boVar34 = this.f1507a.q;
                                                bbVar17.c(boVar34.D());
                                                boVar35 = this.f1507a.q;
                                                boVar35.n();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100257 */:
                                        case R.id.sub_pb_item /* 2131100500 */:
                                        case R.id.sub_pb_more /* 2131100502 */:
                                            try {
                                                bbVar4 = this.f1507a.k;
                                                if (bbVar4.k() != null) {
                                                    boVar22 = this.f1507a.q;
                                                    boVar22.P();
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) sparseArray2.get(R.id.tag_load_sub_data);
                                                    View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                    if (asVar != null && view2 != null) {
                                                        bbVar5 = this.f1507a.k;
                                                        com.baidu.tieba.data.bd a6 = bbVar5.a(asVar);
                                                        beVar = this.f1507a.o;
                                                        bbVar6 = this.f1507a.k;
                                                        beVar.a(bbVar6.a());
                                                        beVar2 = this.f1507a.o;
                                                        beVar2.b(asVar.d());
                                                        beVar3 = this.f1507a.o;
                                                        beVar3.b();
                                                        if (view.getId() == R.id.reply) {
                                                            boVar25 = this.f1507a.q;
                                                            bbVar9 = this.f1507a.k;
                                                            boVar25.a(true, a6, false, null, view2, bbVar9.k().j());
                                                        } else if (view.getId() == R.id.sub_pb_item) {
                                                            boVar24 = this.f1507a.q;
                                                            bbVar8 = this.f1507a.k;
                                                            boVar24.a(true, a6, false, (String) ((SparseArray) view.getTag()).get(R.id.tag_photo_username), view2, bbVar8.k().j());
                                                        } else {
                                                            boVar23 = this.f1507a.q;
                                                            bbVar7 = this.f1507a.k;
                                                            boVar23.a(false, a6, true, null, view2, bbVar7.k().j());
                                                        }
                                                    }
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.tieba.util.aq.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.pb_title_back /* 2131100459 */:
                                            this.f1507a.f();
                                            return;
                                        case R.id.pb_title_forum /* 2131100460 */:
                                            boVar45 = this.f1507a.q;
                                            boVar45.a(0);
                                            if (TiebaApplication.g().u()) {
                                                StatService.onEvent(this.f1507a, "pb_header_forum_name", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_host /* 2131100461 */:
                                            bbVar23 = this.f1507a.k;
                                            bbVar23.p();
                                            boVar43 = this.f1507a.q;
                                            boVar43.n();
                                            if (TiebaApplication.g().u()) {
                                                StatService.onEvent(this.f1507a, "pb_set_host", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_more /* 2131100462 */:
                                            boVar44 = this.f1507a.q;
                                            bbVar24 = this.f1507a.k;
                                            boolean c = bbVar24.c();
                                            auVar = this.f1507a.l;
                                            boVar44.a(c, auVar.a());
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100467 */:
                                            bbVar11 = this.f1507a.k;
                                            if (bbVar11 != null) {
                                                bbVar12 = this.f1507a.k;
                                                if (bbVar12.k() != null) {
                                                    bbVar13 = this.f1507a.k;
                                                    if (bbVar13.k().b() != null) {
                                                        bbVar14 = this.f1507a.k;
                                                        String b9 = bbVar14.k().b().b();
                                                        if (b9 != null && b9.length() > 0) {
                                                            bbVar15 = this.f1507a.k;
                                                            if (bbVar15.d()) {
                                                                this.f1507a.f();
                                                                return;
                                                            } else {
                                                                FrsActivity.a(this.f1507a, b9, (String) null);
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
                                        case R.id.mark_layout /* 2131100486 */:
                                            boVar36 = this.f1507a.q;
                                            boVar36.P();
                                            b3 = this.f1507a.b(11009);
                                            if (b3) {
                                                bbVar18 = this.f1507a.k;
                                                boVar37 = this.f1507a.q;
                                                if (bbVar18.f(boVar37.C()) == null) {
                                                    return;
                                                }
                                                this.f1507a.o();
                                                return;
                                            }
                                            return;
                                        case R.id.share_layout /* 2131100488 */:
                                            boVar42 = this.f1507a.q;
                                            boVar42.P();
                                            bbVar22 = this.f1507a.k;
                                            bbVar22.r();
                                            return;
                                        case R.id.skip_layout /* 2131100489 */:
                                            boVar40 = this.f1507a.q;
                                            boVar40.P();
                                            bbVar20 = this.f1507a.k;
                                            if (bbVar20.l() != null) {
                                                boVar41 = this.f1507a.q;
                                                bbVar21 = this.f1507a.k;
                                                boVar41.a(bbVar21.l());
                                            }
                                            if (TiebaApplication.g().u()) {
                                                StatService.onEvent(this.f1507a, "pb_skip_page", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.reverse_layout /* 2131100490 */:
                                            boVar38 = this.f1507a.q;
                                            boVar38.P();
                                            bbVar19 = this.f1507a.k;
                                            bbVar19.q();
                                            boVar39 = this.f1507a.q;
                                            boVar39.n();
                                            if (TiebaApplication.g().u()) {
                                                StatService.onEvent(this.f1507a, "pb_set_desc", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.sub_pb_buttom_layout /* 2131100493 */:
                                            bbVar10 = this.f1507a.k;
                                            if (!bbVar10.h()) {
                                                boVar26 = this.f1507a.q;
                                                boVar26.v();
                                                beVar4 = this.f1507a.o;
                                                beVar4.cancelLoadData();
                                                return;
                                            }
                                            this.f1507a.f();
                                            return;
                                        case R.id.pb_button_face /* 2131100497 */:
                                        case R.id.pb_button_face1 /* 2131100623 */:
                                            boVar28 = this.f1507a.q;
                                            boVar28.y();
                                            return;
                                        case R.id.pb_button_at /* 2131100498 */:
                                        case R.id.pb_button_at1 /* 2131100624 */:
                                            b = this.f1507a.b(11025);
                                            if (b) {
                                                NewPbActivity newPbActivity = this.f1507a;
                                                boVar27 = this.f1507a.q;
                                                newPbActivity.r = boVar27.U();
                                                AtListActivity.a(this.f1507a, 12004);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_reply_post /* 2131100499 */:
                                            bbVar16 = this.f1507a.k;
                                            if (bbVar16.k() == null) {
                                                return;
                                            }
                                            b2 = this.f1507a.b(11001);
                                            if (!b2) {
                                                return;
                                            }
                                            this.f1507a.c((String) null);
                                            return;
                                        case R.id.pb_button_camera /* 2131100620 */:
                                        case R.id.pb_button_camera1 /* 2131100622 */:
                                            NewPbActivity newPbActivity2 = this.f1507a;
                                            boVar29 = this.f1507a.q;
                                            newPbActivity2.r = boVar29.U();
                                            ImageButton imageButton = (ImageButton) view;
                                            if (imageButton.getTag() == null) {
                                                boVar30 = this.f1507a.q;
                                                boVar30.B();
                                                return;
                                            }
                                            WriteImageActivity.a(this.f1507a, (Bitmap) imageButton.getTag(), 12003);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                b4 = this.f1507a.b(11027);
                                if (b4) {
                                    this.f1507a.c((String) view.getTag());
                                    return;
                                }
                                return;
                            }
                            b5 = this.f1507a.b(11026);
                            if (b5) {
                                NewPbActivity newPbActivity3 = this.f1507a;
                                boVar48 = this.f1507a.q;
                                newPbActivity3.r = boVar48.U();
                                AtListActivity.a(this.f1507a, 12005);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        boVar3 = this.f1507a.q;
        boVar3.Q();
        bbVar = this.f1507a.k;
        if (bbVar.k().j() == 1) {
            tVar = this.f1507a.p;
            if (!tVar.b()) {
                boVar4 = this.f1507a.q;
                boVar4.c();
                boVar5 = this.f1507a.q;
                if (view != boVar5.J()) {
                    boVar6 = this.f1507a.q;
                    if (view != boVar6.K()) {
                        boVar7 = this.f1507a.q;
                        if (view != boVar7.L()) {
                            boVar8 = this.f1507a.q;
                            if (view != boVar8.M()) {
                                boVar9 = this.f1507a.q;
                                if (view == boVar9.g()) {
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
                bbVar2 = this.f1507a.k;
                com.baidu.tieba.data.v b10 = bbVar2.k().b();
                String b11 = b10.b();
                String a7 = b10.a();
                bbVar3 = this.f1507a.k;
                String a8 = bbVar3.k().c().a();
                tVar2 = this.f1507a.p;
                boVar10 = this.f1507a.q;
                tVar2.a(a7, b11, a8, i, boVar10.h());
            }
        }
    }
}
