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
class bc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.f1471a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        com.baidu.tieba.model.bc bcVar;
        com.baidu.tieba.model.t tVar;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        bn bnVar7;
        bn bnVar8;
        bn bnVar9;
        com.baidu.tieba.model.bc bcVar2;
        com.baidu.tieba.model.bc bcVar3;
        com.baidu.tieba.model.t tVar2;
        bn bnVar10;
        bn bnVar11;
        bn bnVar12;
        bn bnVar13;
        bn bnVar14;
        bn bnVar15;
        bn bnVar16;
        bn bnVar17;
        bn bnVar18;
        bn bnVar19;
        bn bnVar20;
        bn bnVar21;
        com.baidu.tieba.model.bc bcVar4;
        bn bnVar22;
        com.baidu.tieba.model.bc bcVar5;
        com.baidu.tieba.model.bf bfVar;
        com.baidu.tieba.model.bc bcVar6;
        com.baidu.tieba.model.bf bfVar2;
        com.baidu.tieba.model.bf bfVar3;
        bn bnVar23;
        com.baidu.tieba.model.bc bcVar7;
        bn bnVar24;
        com.baidu.tieba.model.bc bcVar8;
        bn bnVar25;
        com.baidu.tieba.model.bc bcVar9;
        com.baidu.tieba.model.bc bcVar10;
        bn bnVar26;
        com.baidu.tieba.model.bf bfVar4;
        com.baidu.tieba.model.bc bcVar11;
        com.baidu.tieba.model.bc bcVar12;
        com.baidu.tieba.model.bc bcVar13;
        com.baidu.tieba.model.bc bcVar14;
        com.baidu.tieba.model.bc bcVar15;
        boolean b;
        bn bnVar27;
        bn bnVar28;
        bn bnVar29;
        bn bnVar30;
        com.baidu.tieba.model.bc bcVar16;
        boolean b2;
        bn bnVar31;
        bn bnVar32;
        bn bnVar33;
        com.baidu.tieba.model.bc bcVar17;
        bn bnVar34;
        bn bnVar35;
        bn bnVar36;
        boolean b3;
        com.baidu.tieba.model.bc bcVar18;
        bn bnVar37;
        bn bnVar38;
        com.baidu.tieba.model.bc bcVar19;
        bn bnVar39;
        bn bnVar40;
        com.baidu.tieba.model.bc bcVar20;
        bn bnVar41;
        com.baidu.tieba.model.bc bcVar21;
        bn bnVar42;
        com.baidu.tieba.model.bc bcVar22;
        com.baidu.tieba.model.bc bcVar23;
        bn bnVar43;
        bn bnVar44;
        com.baidu.tieba.model.bc bcVar24;
        com.baidu.tieba.model.av avVar;
        bn bnVar45;
        com.baidu.tieba.model.bf bfVar5;
        bn bnVar46;
        com.baidu.tieba.model.bf bfVar6;
        bn bnVar47;
        boolean b4;
        boolean b5;
        bn bnVar48;
        bn bnVar49;
        bn bnVar50;
        bn bnVar51;
        com.baidu.tieba.model.t tVar3;
        bn bnVar52;
        com.baidu.tieba.model.bc bcVar25;
        com.baidu.tieba.model.t tVar4;
        com.baidu.tieba.model.bc bcVar26;
        com.baidu.tieba.model.bc bcVar27;
        com.baidu.tieba.model.bc bcVar28;
        com.baidu.tieba.model.bf bfVar7;
        com.baidu.tieba.model.bf bfVar8;
        com.baidu.tieba.model.bf bfVar9;
        com.baidu.tieba.model.bf bfVar10;
        com.baidu.tieba.model.t tVar5;
        com.baidu.tieba.model.bf bfVar11;
        com.baidu.tieba.model.bf bfVar12;
        com.baidu.tieba.model.bf bfVar13;
        bn bnVar53;
        com.baidu.tieba.model.t tVar6;
        bn bnVar54;
        com.baidu.tieba.model.t tVar7;
        com.baidu.tieba.model.bc bcVar29;
        com.baidu.tieba.model.bc bcVar30;
        com.baidu.tieba.model.bc bcVar31;
        bn bnVar55;
        com.baidu.tieba.model.bc bcVar32;
        bn bnVar56;
        int i = 0;
        bnVar = this.f1471a.p;
        if (view == bnVar.F()) {
            bcVar32 = this.f1471a.j;
            if (bcVar32.a(true)) {
                bnVar56 = this.f1471a.p;
                bnVar56.o();
                return;
            }
            return;
        }
        bnVar2 = this.f1471a.p;
        if (view != bnVar2.I()) {
            bnVar11 = this.f1471a.p;
            if (view != bnVar11.J()) {
                bnVar12 = this.f1471a.p;
                if (view != bnVar12.K()) {
                    bnVar13 = this.f1471a.p;
                    if (view != bnVar13.L()) {
                        bnVar14 = this.f1471a.p;
                        if (view != bnVar14.f()) {
                            bnVar15 = this.f1471a.p;
                            if (view == bnVar15.d()) {
                                bnVar53 = this.f1471a.p;
                                bnVar53.P();
                                String E = TiebaApplication.E();
                                if (E != null && E.length() > 0) {
                                    tVar6 = this.f1471a.o;
                                    if (!tVar6.b()) {
                                        bnVar54 = this.f1471a.p;
                                        bnVar54.b();
                                        tVar7 = this.f1471a.o;
                                        bcVar29 = this.f1471a.j;
                                        String a2 = bcVar29.j().a().a();
                                        bcVar30 = this.f1471a.j;
                                        String b6 = bcVar30.j().a().b();
                                        bcVar31 = this.f1471a.j;
                                        String a3 = bcVar31.j().b().a();
                                        bnVar55 = this.f1471a.p;
                                        tVar7.a(a2, b6, a3, (String) view.getTag(), bnVar55.e());
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1471a, this.f1471a.getString(R.string.login_to_use), true, 11018);
                                return;
                            }
                            bnVar16 = this.f1471a.p;
                            if (view == bnVar16.c()) {
                                bnVar51 = this.f1471a.p;
                                bnVar51.P();
                                String E2 = TiebaApplication.E();
                                if (E2 != null && E2.length() > 0) {
                                    tVar3 = this.f1471a.o;
                                    if (!tVar3.b()) {
                                        bnVar52 = this.f1471a.p;
                                        bnVar52.b();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bcVar25 = this.f1471a.j;
                                            if (bcVar25.h()) {
                                                bfVar7 = this.f1471a.n;
                                                if (bfVar7 != null) {
                                                    bfVar8 = this.f1471a.n;
                                                    if (bfVar8.c() != null) {
                                                        bfVar9 = this.f1471a.n;
                                                        if (bfVar9.c().g() != null) {
                                                            bfVar10 = this.f1471a.n;
                                                            if (bfVar10.c().l() != null) {
                                                                tVar5 = this.f1471a.o;
                                                                bfVar11 = this.f1471a.n;
                                                                String a4 = bfVar11.c().g().a();
                                                                bfVar12 = this.f1471a.n;
                                                                String b7 = bfVar12.c().g().b();
                                                                bfVar13 = this.f1471a.n;
                                                                tVar5.a(a4, b7, bfVar13.c().l().a(), str, intValue2, intValue, booleanValue);
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
                                            tVar4 = this.f1471a.o;
                                            bcVar26 = this.f1471a.j;
                                            String a5 = bcVar26.j().a().a();
                                            bcVar27 = this.f1471a.j;
                                            String b8 = bcVar27.j().a().b();
                                            bcVar28 = this.f1471a.j;
                                            tVar4.a(a5, b8, bcVar28.j().b().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1471a, this.f1471a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            bnVar17 = this.f1471a.p;
                            if (view == bnVar17.M()) {
                                bnVar50 = this.f1471a.p;
                                bnVar50.b(true);
                                return;
                            }
                            bnVar18 = this.f1471a.p;
                            if (view == bnVar18.h()) {
                                bnVar49 = this.f1471a.p;
                                bnVar49.l();
                                return;
                            }
                            bnVar19 = this.f1471a.p;
                            if (view != bnVar19.k()) {
                                bnVar20 = this.f1471a.p;
                                if (view != bnVar20.i()) {
                                    bnVar21 = this.f1471a.p;
                                    if (view == bnVar21.j()) {
                                        bfVar6 = this.f1471a.n;
                                        if (bfVar6.e()) {
                                            bnVar47 = this.f1471a.p;
                                            bnVar47.s();
                                            return;
                                        }
                                        return;
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099658 */:
                                            bfVar5 = this.f1471a.n;
                                            if (bfVar5.e()) {
                                                bnVar46 = this.f1471a.p;
                                                bnVar46.s();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131099914 */:
                                            bnVar31 = this.f1471a.p;
                                            bnVar31.O();
                                            return;
                                        case R.id.dialog_button_ok /* 2131099915 */:
                                            bnVar32 = this.f1471a.p;
                                            bnVar32.O();
                                            bnVar33 = this.f1471a.p;
                                            if (bnVar33.C() >= 0) {
                                                bcVar17 = this.f1471a.j;
                                                bnVar34 = this.f1471a.p;
                                                bcVar17.c(bnVar34.C());
                                                bnVar35 = this.f1471a.p;
                                                bnVar35.m();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100218 */:
                                        case R.id.sub_pb_item /* 2131100459 */:
                                        case R.id.sub_pb_more /* 2131100461 */:
                                            try {
                                                bcVar4 = this.f1471a.j;
                                                if (bcVar4.j() != null) {
                                                    bnVar22 = this.f1471a.p;
                                                    bnVar22.O();
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) sparseArray2.get(R.id.tag_load_sub_data);
                                                    View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                    if (awVar != null && view2 != null) {
                                                        bcVar5 = this.f1471a.j;
                                                        com.baidu.tieba.data.bh a6 = bcVar5.a(awVar);
                                                        bfVar = this.f1471a.n;
                                                        bcVar6 = this.f1471a.j;
                                                        bfVar.a(bcVar6.a());
                                                        bfVar2 = this.f1471a.n;
                                                        bfVar2.b(awVar.d());
                                                        bfVar3 = this.f1471a.n;
                                                        bfVar3.b();
                                                        if (view.getId() == R.id.reply) {
                                                            bnVar25 = this.f1471a.p;
                                                            bcVar9 = this.f1471a.j;
                                                            bnVar25.a(true, a6, false, null, view2, bcVar9.j().i());
                                                        } else if (view.getId() == R.id.sub_pb_item) {
                                                            bnVar24 = this.f1471a.p;
                                                            bcVar8 = this.f1471a.j;
                                                            bnVar24.a(true, a6, false, (String) ((SparseArray) view.getTag()).get(R.id.tag_photo_username), view2, bcVar8.j().i());
                                                        } else {
                                                            bnVar23 = this.f1471a.p;
                                                            bcVar7 = this.f1471a.j;
                                                            bnVar23.a(false, a6, true, null, view2, bcVar7.j().i());
                                                        }
                                                    }
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.tieba.util.aj.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.pb_title_back /* 2131100418 */:
                                            this.f1471a.f();
                                            return;
                                        case R.id.pb_title_forum /* 2131100419 */:
                                            bnVar45 = this.f1471a.p;
                                            bnVar45.a(0);
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1471a, "pb_header_forum_name", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_host /* 2131100420 */:
                                            bcVar23 = this.f1471a.j;
                                            bcVar23.o();
                                            bnVar43 = this.f1471a.p;
                                            bnVar43.m();
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1471a, "pb_set_host", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_more /* 2131100421 */:
                                            bnVar44 = this.f1471a.p;
                                            bcVar24 = this.f1471a.j;
                                            boolean c = bcVar24.c();
                                            avVar = this.f1471a.k;
                                            bnVar44.a(c, avVar.a());
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100426 */:
                                            bcVar11 = this.f1471a.j;
                                            if (bcVar11 != null) {
                                                bcVar12 = this.f1471a.j;
                                                if (bcVar12.j() != null) {
                                                    bcVar13 = this.f1471a.j;
                                                    if (bcVar13.j().a() != null) {
                                                        bcVar14 = this.f1471a.j;
                                                        String b9 = bcVar14.j().a().b();
                                                        if (b9 != null && b9.length() > 0) {
                                                            bcVar15 = this.f1471a.j;
                                                            if (bcVar15.d()) {
                                                                this.f1471a.f();
                                                                return;
                                                            } else {
                                                                FrsActivity.a(this.f1471a, b9, (String) null);
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
                                        case R.id.mark_layout /* 2131100445 */:
                                            bnVar36 = this.f1471a.p;
                                            bnVar36.O();
                                            b3 = this.f1471a.b(11009);
                                            if (b3) {
                                                bcVar18 = this.f1471a.j;
                                                bnVar37 = this.f1471a.p;
                                                if (bcVar18.f(bnVar37.B()) == null) {
                                                    return;
                                                }
                                                this.f1471a.n();
                                                return;
                                            }
                                            return;
                                        case R.id.share_layout /* 2131100447 */:
                                            bnVar42 = this.f1471a.p;
                                            bnVar42.O();
                                            bcVar22 = this.f1471a.j;
                                            bcVar22.q();
                                            return;
                                        case R.id.skip_layout /* 2131100448 */:
                                            bnVar40 = this.f1471a.p;
                                            bnVar40.O();
                                            bcVar20 = this.f1471a.j;
                                            if (bcVar20.k() != null) {
                                                bnVar41 = this.f1471a.p;
                                                bcVar21 = this.f1471a.j;
                                                bnVar41.a(bcVar21.k());
                                            }
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1471a, "pb_skip_page", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.reverse_layout /* 2131100449 */:
                                            bnVar38 = this.f1471a.p;
                                            bnVar38.O();
                                            bcVar19 = this.f1471a.j;
                                            bcVar19.p();
                                            bnVar39 = this.f1471a.p;
                                            bnVar39.m();
                                            if (TiebaApplication.f().t()) {
                                                StatService.onEvent(this.f1471a, "pb_set_desc", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.sub_pb_buttom_layout /* 2131100452 */:
                                            bcVar10 = this.f1471a.j;
                                            if (!bcVar10.h()) {
                                                bnVar26 = this.f1471a.p;
                                                bnVar26.u();
                                                bfVar4 = this.f1471a.n;
                                                bfVar4.cancelLoadData();
                                                return;
                                            }
                                            this.f1471a.f();
                                            return;
                                        case R.id.pb_button_face /* 2131100456 */:
                                        case R.id.pb_button_face1 /* 2131100553 */:
                                            bnVar28 = this.f1471a.p;
                                            bnVar28.x();
                                            return;
                                        case R.id.pb_button_at /* 2131100457 */:
                                        case R.id.pb_button_at1 /* 2131100554 */:
                                            b = this.f1471a.b(11025);
                                            if (b) {
                                                NewPbActivity newPbActivity = this.f1471a;
                                                bnVar27 = this.f1471a.p;
                                                newPbActivity.q = bnVar27.T();
                                                AtListActivity.a(this.f1471a, 12004);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_reply_post /* 2131100458 */:
                                            bcVar16 = this.f1471a.j;
                                            if (bcVar16.j() == null) {
                                                return;
                                            }
                                            b2 = this.f1471a.b(11001);
                                            if (!b2) {
                                                return;
                                            }
                                            this.f1471a.c((String) null);
                                            return;
                                        case R.id.pb_button_camera /* 2131100550 */:
                                        case R.id.pb_button_camera1 /* 2131100552 */:
                                            NewPbActivity newPbActivity2 = this.f1471a;
                                            bnVar29 = this.f1471a.p;
                                            newPbActivity2.q = bnVar29.T();
                                            ImageButton imageButton = (ImageButton) view;
                                            if (imageButton.getTag() == null) {
                                                bnVar30 = this.f1471a.p;
                                                bnVar30.A();
                                                return;
                                            }
                                            WriteImageActivity.a(this.f1471a, (Bitmap) imageButton.getTag(), 12003);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                b4 = this.f1471a.b(11027);
                                if (b4) {
                                    this.f1471a.c((String) view.getTag());
                                    return;
                                }
                                return;
                            }
                            b5 = this.f1471a.b(11026);
                            if (b5) {
                                NewPbActivity newPbActivity3 = this.f1471a;
                                bnVar48 = this.f1471a.p;
                                newPbActivity3.q = bnVar48.T();
                                AtListActivity.a(this.f1471a, 12005);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        bnVar3 = this.f1471a.p;
        bnVar3.P();
        bcVar = this.f1471a.j;
        if (bcVar.j().i() == 1) {
            tVar = this.f1471a.o;
            if (!tVar.b()) {
                bnVar4 = this.f1471a.p;
                bnVar4.b();
                bnVar5 = this.f1471a.p;
                if (view != bnVar5.I()) {
                    bnVar6 = this.f1471a.p;
                    if (view != bnVar6.J()) {
                        bnVar7 = this.f1471a.p;
                        if (view != bnVar7.K()) {
                            bnVar8 = this.f1471a.p;
                            if (view != bnVar8.L()) {
                                bnVar9 = this.f1471a.p;
                                if (view == bnVar9.f()) {
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
                bcVar2 = this.f1471a.j;
                com.baidu.tieba.data.v a7 = bcVar2.j().a();
                String b10 = a7.b();
                String a8 = a7.a();
                bcVar3 = this.f1471a.j;
                String a9 = bcVar3.j().b().a();
                tVar2 = this.f1471a.o;
                bnVar10 = this.f1471a.p;
                tVar2.a(a8, b10, a9, i, bnVar10.g());
            }
        }
    }
}
