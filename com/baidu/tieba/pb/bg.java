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
class bg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1553a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.f1553a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        br brVar;
        br brVar2;
        br brVar3;
        com.baidu.tieba.model.bd bdVar;
        com.baidu.tieba.model.v vVar;
        br brVar4;
        br brVar5;
        br brVar6;
        br brVar7;
        br brVar8;
        br brVar9;
        com.baidu.tieba.model.bd bdVar2;
        com.baidu.tieba.model.bd bdVar3;
        com.baidu.tieba.model.v vVar2;
        br brVar10;
        br brVar11;
        br brVar12;
        br brVar13;
        br brVar14;
        br brVar15;
        br brVar16;
        br brVar17;
        br brVar18;
        br brVar19;
        br brVar20;
        br brVar21;
        br brVar22;
        String str;
        br brVar23;
        br brVar24;
        br brVar25;
        String str2;
        String str3;
        br brVar26;
        br brVar27;
        com.baidu.tieba.model.bd bdVar4;
        br brVar28;
        com.baidu.tieba.model.bd bdVar5;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bd bdVar6;
        com.baidu.tieba.model.bg bgVar2;
        com.baidu.tieba.model.bg bgVar3;
        br brVar29;
        com.baidu.tieba.model.bd bdVar7;
        br brVar30;
        com.baidu.tieba.model.bd bdVar8;
        br brVar31;
        com.baidu.tieba.model.bd bdVar9;
        com.baidu.tieba.model.bd bdVar10;
        br brVar32;
        com.baidu.tieba.model.bg bgVar4;
        com.baidu.tieba.model.bd bdVar11;
        com.baidu.tieba.model.bd bdVar12;
        com.baidu.tieba.model.bd bdVar13;
        com.baidu.tieba.model.bd bdVar14;
        com.baidu.tieba.model.bd bdVar15;
        boolean b;
        br brVar33;
        br brVar34;
        br brVar35;
        br brVar36;
        com.baidu.tieba.model.bd bdVar16;
        boolean b2;
        br brVar37;
        br brVar38;
        br brVar39;
        com.baidu.tieba.model.bd bdVar17;
        br brVar40;
        br brVar41;
        br brVar42;
        boolean b3;
        com.baidu.tieba.model.bd bdVar18;
        br brVar43;
        br brVar44;
        com.baidu.tieba.model.bd bdVar19;
        br brVar45;
        br brVar46;
        com.baidu.tieba.model.bd bdVar20;
        br brVar47;
        com.baidu.tieba.model.bd bdVar21;
        br brVar48;
        com.baidu.tieba.model.bd bdVar22;
        com.baidu.tieba.model.bd bdVar23;
        br brVar49;
        br brVar50;
        com.baidu.tieba.model.bd bdVar24;
        com.baidu.tieba.model.aw awVar;
        br brVar51;
        com.baidu.tieba.model.bg bgVar5;
        br brVar52;
        br brVar53;
        String str4;
        br brVar54;
        br brVar55;
        String str5;
        String str6;
        com.baidu.tieba.model.bg bgVar6;
        br brVar56;
        boolean b4;
        boolean b5;
        br brVar57;
        br brVar58;
        br brVar59;
        br brVar60;
        com.baidu.tieba.model.v vVar3;
        br brVar61;
        com.baidu.tieba.model.bd bdVar25;
        com.baidu.tieba.model.v vVar4;
        com.baidu.tieba.model.bd bdVar26;
        com.baidu.tieba.model.bd bdVar27;
        com.baidu.tieba.model.bd bdVar28;
        com.baidu.tieba.model.bg bgVar7;
        com.baidu.tieba.model.bg bgVar8;
        com.baidu.tieba.model.bg bgVar9;
        com.baidu.tieba.model.bg bgVar10;
        com.baidu.tieba.model.v vVar5;
        com.baidu.tieba.model.bg bgVar11;
        com.baidu.tieba.model.bg bgVar12;
        com.baidu.tieba.model.bg bgVar13;
        br brVar62;
        com.baidu.tieba.model.v vVar6;
        br brVar63;
        com.baidu.tieba.model.v vVar7;
        com.baidu.tieba.model.bd bdVar29;
        com.baidu.tieba.model.bd bdVar30;
        com.baidu.tieba.model.bd bdVar31;
        br brVar64;
        com.baidu.tieba.model.bd bdVar32;
        br brVar65;
        int i = 0;
        brVar = this.f1553a.t;
        if (view == brVar.T()) {
            bdVar32 = this.f1553a.n;
            if (bdVar32.a(true)) {
                brVar65 = this.f1553a.t;
                brVar65.z();
                return;
            }
            return;
        }
        brVar2 = this.f1553a.t;
        if (view != brVar2.W()) {
            brVar11 = this.f1553a.t;
            if (view != brVar11.X()) {
                brVar12 = this.f1553a.t;
                if (view != brVar12.Y()) {
                    brVar13 = this.f1553a.t;
                    if (view != brVar13.Z()) {
                        brVar14 = this.f1553a.t;
                        if (view != brVar14.q()) {
                            brVar15 = this.f1553a.t;
                            if (view == brVar15.o()) {
                                brVar62 = this.f1553a.t;
                                brVar62.ad();
                                String C = TiebaApplication.C();
                                if (C != null && C.length() > 0) {
                                    vVar6 = this.f1553a.s;
                                    if (!vVar6.b()) {
                                        brVar63 = this.f1553a.t;
                                        brVar63.m();
                                        vVar7 = this.f1553a.s;
                                        bdVar29 = this.f1553a.n;
                                        String a2 = bdVar29.k().b().a();
                                        bdVar30 = this.f1553a.n;
                                        String b6 = bdVar30.k().b().b();
                                        bdVar31 = this.f1553a.n;
                                        String a3 = bdVar31.k().c().a();
                                        brVar64 = this.f1553a.t;
                                        vVar7.a(a2, b6, a3, (String) view.getTag(), brVar64.p());
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1553a, this.f1553a.getString(R.string.login_to_use), true, 11018);
                                return;
                            }
                            brVar16 = this.f1553a.t;
                            if (view == brVar16.n()) {
                                brVar60 = this.f1553a.t;
                                brVar60.ad();
                                String C2 = TiebaApplication.C();
                                if (C2 != null && C2.length() > 0) {
                                    vVar3 = this.f1553a.s;
                                    if (!vVar3.b()) {
                                        brVar61 = this.f1553a.t;
                                        brVar61.m();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str7 = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bdVar25 = this.f1553a.n;
                                            if (bdVar25.h()) {
                                                bgVar7 = this.f1553a.r;
                                                if (bgVar7 != null) {
                                                    bgVar8 = this.f1553a.r;
                                                    if (bgVar8.c() != null) {
                                                        bgVar9 = this.f1553a.r;
                                                        if (bgVar9.c().g() != null) {
                                                            bgVar10 = this.f1553a.r;
                                                            if (bgVar10.c().l() != null) {
                                                                vVar5 = this.f1553a.s;
                                                                bgVar11 = this.f1553a.r;
                                                                String a4 = bgVar11.c().g().a();
                                                                bgVar12 = this.f1553a.r;
                                                                String b7 = bgVar12.c().g().b();
                                                                bgVar13 = this.f1553a.r;
                                                                vVar5.a(a4, b7, bgVar13.c().l().a(), str7, intValue2, intValue, booleanValue);
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
                                            vVar4 = this.f1553a.s;
                                            bdVar26 = this.f1553a.n;
                                            String a5 = bdVar26.k().b().a();
                                            bdVar27 = this.f1553a.n;
                                            String b8 = bdVar27.k().b().b();
                                            bdVar28 = this.f1553a.n;
                                            vVar4.a(a5, b8, bdVar28.k().c().a(), str7, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f1553a, this.f1553a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            brVar17 = this.f1553a.t;
                            if (view == brVar17.aa()) {
                                brVar59 = this.f1553a.t;
                                brVar59.b(true);
                                return;
                            }
                            brVar18 = this.f1553a.t;
                            if (view == brVar18.s()) {
                                brVar58 = this.f1553a.t;
                                brVar58.w();
                                return;
                            }
                            brVar19 = this.f1553a.t;
                            if (view != brVar19.v()) {
                                brVar20 = this.f1553a.t;
                                if (view != brVar20.t()) {
                                    brVar21 = this.f1553a.t;
                                    if (view == brVar21.u()) {
                                        bgVar6 = this.f1553a.r;
                                        if (bgVar6.e()) {
                                            brVar56 = this.f1553a.t;
                                            brVar56.D();
                                            return;
                                        }
                                        return;
                                    }
                                    brVar22 = this.f1553a.t;
                                    if (view != brVar22.d().getView()) {
                                        brVar26 = this.f1553a.t;
                                        if (view != brVar26.e().getView()) {
                                            brVar27 = this.f1553a.t;
                                            if (brVar27.f() != null) {
                                                brVar53 = this.f1553a.t;
                                                if (view == brVar53.f().getView()) {
                                                    str4 = this.f1553a.g;
                                                    if (str4 != null) {
                                                        str5 = this.f1553a.g;
                                                        if (str5.length() > 0) {
                                                            NewPbActivity newPbActivity = this.f1553a;
                                                            str6 = this.f1553a.g;
                                                            newPbActivity.a(str6);
                                                            return;
                                                        }
                                                    }
                                                    brVar54 = this.f1553a.t;
                                                    brVar54.h();
                                                    brVar55 = this.f1553a.t;
                                                    brVar55.f().a();
                                                    return;
                                                }
                                            }
                                            switch (view.getId()) {
                                                case R.id.sub_post_load_more /* 2131099660 */:
                                                    bgVar5 = this.f1553a.r;
                                                    if (bgVar5.e()) {
                                                        brVar52 = this.f1553a.t;
                                                        brVar52.D();
                                                        return;
                                                    }
                                                    return;
                                                case R.id.dialog_button_cancel /* 2131099915 */:
                                                    brVar37 = this.f1553a.t;
                                                    brVar37.ac();
                                                    return;
                                                case R.id.dialog_button_ok /* 2131099916 */:
                                                    brVar38 = this.f1553a.t;
                                                    brVar38.ac();
                                                    brVar39 = this.f1553a.t;
                                                    if (brVar39.Q() < 0) {
                                                        return;
                                                    }
                                                    this.f1553a.v();
                                                    bdVar17 = this.f1553a.n;
                                                    brVar40 = this.f1553a.t;
                                                    bdVar17.c(brVar40.Q());
                                                    brVar41 = this.f1553a.t;
                                                    brVar41.x();
                                                    return;
                                                case R.id.reply /* 2131100302 */:
                                                case R.id.sub_pb_item /* 2131100539 */:
                                                case R.id.sub_pb_more /* 2131100541 */:
                                                    try {
                                                        bdVar4 = this.f1553a.n;
                                                        if (bdVar4.k() != null) {
                                                            brVar28 = this.f1553a.t;
                                                            brVar28.ac();
                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                            com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) sparseArray2.get(R.id.tag_load_sub_data);
                                                            View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                            if (asVar != null && view2 != null) {
                                                                bdVar5 = this.f1553a.n;
                                                                com.baidu.tieba.data.bd a6 = bdVar5.a(asVar);
                                                                bgVar = this.f1553a.r;
                                                                bdVar6 = this.f1553a.n;
                                                                bgVar.a(bdVar6.a());
                                                                bgVar2 = this.f1553a.r;
                                                                bgVar2.b(asVar.d());
                                                                bgVar3 = this.f1553a.r;
                                                                bgVar3.b();
                                                                this.f1553a.v();
                                                                if (view.getId() == R.id.reply) {
                                                                    brVar31 = this.f1553a.t;
                                                                    bdVar9 = this.f1553a.n;
                                                                    brVar31.a(true, a6, false, null, view2, bdVar9.k().j());
                                                                } else if (view.getId() == R.id.sub_pb_item) {
                                                                    brVar30 = this.f1553a.t;
                                                                    bdVar8 = this.f1553a.n;
                                                                    brVar30.a(true, a6, false, (String) ((SparseArray) view.getTag()).get(R.id.tag_photo_username), view2, bdVar8.k().j());
                                                                } else {
                                                                    brVar29 = this.f1553a.t;
                                                                    bdVar7 = this.f1553a.n;
                                                                    brVar29.a(false, a6, true, null, view2, bdVar7.k().j());
                                                                }
                                                            }
                                                        }
                                                        return;
                                                    } catch (Exception e) {
                                                        com.baidu.tieba.util.av.b(getClass().getName(), "onClick", e.toString());
                                                        return;
                                                    }
                                                case R.id.pb_title_back /* 2131100495 */:
                                                    this.f1553a.g();
                                                    return;
                                                case R.id.pb_title_forum /* 2131100496 */:
                                                    brVar51 = this.f1553a.t;
                                                    brVar51.a(0);
                                                    if (TiebaApplication.g().s()) {
                                                        StatService.onEvent(this.f1553a, "pb_header_forum_name", "pbclick", 1);
                                                        return;
                                                    }
                                                    return;
                                                case R.id.pb_title_host /* 2131100497 */:
                                                    this.f1553a.v();
                                                    bdVar23 = this.f1553a.n;
                                                    bdVar23.p();
                                                    brVar49 = this.f1553a.t;
                                                    brVar49.x();
                                                    if (TiebaApplication.g().s()) {
                                                        StatService.onEvent(this.f1553a, "pb_set_host", "pbclick", 1);
                                                        return;
                                                    }
                                                    return;
                                                case R.id.pb_title_more /* 2131100498 */:
                                                    brVar50 = this.f1553a.t;
                                                    bdVar24 = this.f1553a.n;
                                                    boolean c = bdVar24.c();
                                                    awVar = this.f1553a.o;
                                                    brVar50.a(c, awVar.a());
                                                    return;
                                                case R.id.pb_list_header_bar /* 2131100506 */:
                                                    bdVar11 = this.f1553a.n;
                                                    if (bdVar11 != null) {
                                                        bdVar12 = this.f1553a.n;
                                                        if (bdVar12.k() != null) {
                                                            bdVar13 = this.f1553a.n;
                                                            if (bdVar13.k().b() != null) {
                                                                bdVar14 = this.f1553a.n;
                                                                String b9 = bdVar14.k().b().b();
                                                                if (b9 != null && b9.length() > 0) {
                                                                    bdVar15 = this.f1553a.n;
                                                                    if (bdVar15.d()) {
                                                                        this.f1553a.g();
                                                                        return;
                                                                    } else {
                                                                        FrsActivity.a(this.f1553a, b9, (String) null);
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
                                                case R.id.mark_layout /* 2131100526 */:
                                                    brVar42 = this.f1553a.t;
                                                    brVar42.ac();
                                                    b3 = this.f1553a.b(11009);
                                                    if (b3) {
                                                        bdVar18 = this.f1553a.n;
                                                        brVar43 = this.f1553a.t;
                                                        if (bdVar18.f(brVar43.P()) == null) {
                                                            return;
                                                        }
                                                        this.f1553a.s();
                                                        return;
                                                    }
                                                    return;
                                                case R.id.share_layout /* 2131100528 */:
                                                    this.f1553a.v();
                                                    brVar48 = this.f1553a.t;
                                                    brVar48.ac();
                                                    bdVar22 = this.f1553a.n;
                                                    bdVar22.r();
                                                    return;
                                                case R.id.skip_layout /* 2131100529 */:
                                                    brVar46 = this.f1553a.t;
                                                    brVar46.ac();
                                                    bdVar20 = this.f1553a.n;
                                                    if (bdVar20.l() != null) {
                                                        brVar47 = this.f1553a.t;
                                                        bdVar21 = this.f1553a.n;
                                                        brVar47.a(bdVar21.l());
                                                    }
                                                    if (TiebaApplication.g().s()) {
                                                        StatService.onEvent(this.f1553a, "pb_skip_page", "pbclick", 1);
                                                        return;
                                                    }
                                                    return;
                                                case R.id.reverse_layout /* 2131100530 */:
                                                    this.f1553a.v();
                                                    brVar44 = this.f1553a.t;
                                                    brVar44.ac();
                                                    bdVar19 = this.f1553a.n;
                                                    bdVar19.q();
                                                    brVar45 = this.f1553a.t;
                                                    brVar45.x();
                                                    if (TiebaApplication.g().s()) {
                                                        StatService.onEvent(this.f1553a, "pb_set_desc", "pbclick", 1);
                                                        return;
                                                    }
                                                    return;
                                                case R.id.sub_pb_buttom_layout /* 2131100533 */:
                                                    bdVar10 = this.f1553a.n;
                                                    if (bdVar10.h()) {
                                                        this.f1553a.g();
                                                        return;
                                                    }
                                                    this.f1553a.v();
                                                    brVar32 = this.f1553a.t;
                                                    brVar32.F();
                                                    bgVar4 = this.f1553a.r;
                                                    bgVar4.cancelLoadData();
                                                    return;
                                                case R.id.pb_reply_post /* 2131100538 */:
                                                    bdVar16 = this.f1553a.n;
                                                    if (bdVar16.k() == null) {
                                                        return;
                                                    }
                                                    b2 = this.f1553a.b(11001);
                                                    if (!b2) {
                                                        return;
                                                    }
                                                    this.f1553a.c((String) null);
                                                    return;
                                                case R.id.pb_button_camera1 /* 2131100560 */:
                                                case R.id.pb_button_camera /* 2131100693 */:
                                                    NewPbActivity newPbActivity2 = this.f1553a;
                                                    brVar35 = this.f1553a.t;
                                                    newPbActivity2.u = brVar35.ah();
                                                    ImageButton imageButton = (ImageButton) view;
                                                    if (imageButton.getTag() == null) {
                                                        brVar36 = this.f1553a.t;
                                                        brVar36.O();
                                                        return;
                                                    }
                                                    WriteImageActivity.a(this.f1553a, (Bitmap) imageButton.getTag(), 12003);
                                                    return;
                                                case R.id.pb_button_face1 /* 2131100561 */:
                                                case R.id.pb_button_face /* 2131100694 */:
                                                    brVar34 = this.f1553a.t;
                                                    brVar34.L();
                                                    return;
                                                case R.id.pb_button_at1 /* 2131100562 */:
                                                    b = this.f1553a.b(11025);
                                                    if (b) {
                                                        NewPbActivity newPbActivity3 = this.f1553a;
                                                        brVar33 = this.f1553a.t;
                                                        newPbActivity3.u = brVar33.ah();
                                                        AtListActivity.a(this.f1553a, 12004);
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                    }
                                    str = this.f1553a.g;
                                    if (str != null) {
                                        str2 = this.f1553a.g;
                                        if (str2.length() > 0) {
                                            NewPbActivity newPbActivity4 = this.f1553a;
                                            str3 = this.f1553a.g;
                                            newPbActivity4.a(str3);
                                            return;
                                        }
                                    }
                                    brVar23 = this.f1553a.t;
                                    brVar23.i();
                                    brVar24 = this.f1553a.t;
                                    brVar24.d().a();
                                    brVar25 = this.f1553a.t;
                                    brVar25.e().a();
                                    return;
                                }
                                b4 = this.f1553a.b(11027);
                                if (b4) {
                                    this.f1553a.c((String) view.getTag());
                                    return;
                                }
                                return;
                            }
                            b5 = this.f1553a.b(11026);
                            if (b5) {
                                NewPbActivity newPbActivity5 = this.f1553a;
                                brVar57 = this.f1553a.t;
                                newPbActivity5.u = brVar57.ah();
                                AtListActivity.a(this.f1553a, 12005);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        brVar3 = this.f1553a.t;
        brVar3.ad();
        bdVar = this.f1553a.n;
        if (bdVar.k().j() == 1) {
            vVar = this.f1553a.s;
            if (!vVar.b()) {
                brVar4 = this.f1553a.t;
                brVar4.m();
                brVar5 = this.f1553a.t;
                if (view != brVar5.W()) {
                    brVar6 = this.f1553a.t;
                    if (view != brVar6.X()) {
                        brVar7 = this.f1553a.t;
                        if (view != brVar7.Y()) {
                            brVar8 = this.f1553a.t;
                            if (view != brVar8.Z()) {
                                brVar9 = this.f1553a.t;
                                if (view == brVar9.q()) {
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
                bdVar2 = this.f1553a.n;
                com.baidu.tieba.data.v b10 = bdVar2.k().b();
                String b11 = b10.b();
                String a7 = b10.a();
                bdVar3 = this.f1553a.n;
                String a8 = bdVar3.k().c().a();
                vVar2 = this.f1553a.s;
                brVar10 = this.f1553a.t;
                vVar2.a(a7, b11, a8, i, brVar10.r());
            }
        }
    }
}
