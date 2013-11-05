package com.baidu.tieba.pb;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageButton;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bl implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(NewPbActivity newPbActivity) {
        this.f2075a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        com.baidu.tieba.model.bl blVar;
        com.baidu.tieba.model.ad adVar;
        bt btVar4;
        bt btVar5;
        bt btVar6;
        bt btVar7;
        bt btVar8;
        bt btVar9;
        com.baidu.tieba.model.bl blVar2;
        com.baidu.tieba.model.bl blVar3;
        com.baidu.tieba.model.ad adVar2;
        bt btVar10;
        bt btVar11;
        bt btVar12;
        bt btVar13;
        bt btVar14;
        bt btVar15;
        bt btVar16;
        bt btVar17;
        bt btVar18;
        bt btVar19;
        bt btVar20;
        bt btVar21;
        bt btVar22;
        String str;
        bt btVar23;
        bt btVar24;
        bt btVar25;
        String str2;
        String str3;
        bt btVar26;
        bt btVar27;
        com.baidu.tieba.model.bl blVar4;
        bt btVar28;
        com.baidu.tieba.model.bl blVar5;
        com.baidu.tieba.model.bo boVar;
        com.baidu.tieba.model.bl blVar6;
        com.baidu.tieba.model.bo boVar2;
        com.baidu.tieba.model.bo boVar3;
        bt btVar29;
        com.baidu.tieba.model.bl blVar7;
        bt btVar30;
        com.baidu.tieba.model.bl blVar8;
        bt btVar31;
        com.baidu.tieba.model.bl blVar9;
        com.baidu.tieba.model.bl blVar10;
        bt btVar32;
        com.baidu.tieba.model.bo boVar4;
        com.baidu.tieba.model.bl blVar11;
        com.baidu.tieba.model.bl blVar12;
        com.baidu.tieba.model.bl blVar13;
        com.baidu.tieba.model.bl blVar14;
        com.baidu.tieba.model.bl blVar15;
        boolean d;
        bt btVar33;
        bt btVar34;
        bt btVar35;
        bt btVar36;
        com.baidu.tieba.model.bl blVar16;
        boolean d2;
        bt btVar37;
        bt btVar38;
        bt btVar39;
        com.baidu.tieba.model.bl blVar17;
        bt btVar40;
        bt btVar41;
        bt btVar42;
        boolean d3;
        com.baidu.tieba.model.bl blVar18;
        bt btVar43;
        bt btVar44;
        com.baidu.tieba.model.bl blVar19;
        bt btVar45;
        bt btVar46;
        com.baidu.tieba.model.bl blVar20;
        bt btVar47;
        com.baidu.tieba.model.bl blVar21;
        bt btVar48;
        com.baidu.tieba.model.bl blVar22;
        com.baidu.tieba.model.bl blVar23;
        bt btVar49;
        bt btVar50;
        com.baidu.tieba.model.bl blVar24;
        com.baidu.tieba.model.bf bfVar;
        bt btVar51;
        com.baidu.tieba.model.bo boVar5;
        bt btVar52;
        bt btVar53;
        String str4;
        bt btVar54;
        bt btVar55;
        String str5;
        String str6;
        com.baidu.tieba.model.bo boVar6;
        bt btVar56;
        boolean d4;
        boolean d5;
        bt btVar57;
        bt btVar58;
        bt btVar59;
        bt btVar60;
        com.baidu.tieba.model.ad adVar3;
        bt btVar61;
        com.baidu.tieba.model.bl blVar25;
        com.baidu.tieba.model.ad adVar4;
        com.baidu.tieba.model.bl blVar26;
        com.baidu.tieba.model.bl blVar27;
        com.baidu.tieba.model.bl blVar28;
        com.baidu.tieba.model.bo boVar7;
        com.baidu.tieba.model.bo boVar8;
        com.baidu.tieba.model.bo boVar9;
        com.baidu.tieba.model.bo boVar10;
        com.baidu.tieba.model.ad adVar5;
        com.baidu.tieba.model.bo boVar11;
        com.baidu.tieba.model.bo boVar12;
        com.baidu.tieba.model.bo boVar13;
        bt btVar62;
        com.baidu.tieba.model.ad adVar6;
        bt btVar63;
        com.baidu.tieba.model.ad adVar7;
        com.baidu.tieba.model.bl blVar29;
        com.baidu.tieba.model.bl blVar30;
        com.baidu.tieba.model.bl blVar31;
        bt btVar64;
        com.baidu.tieba.model.bl blVar32;
        bt btVar65;
        int i = 0;
        btVar = this.f2075a.u;
        if (view == btVar.T()) {
            blVar32 = this.f2075a.o;
            if (blVar32.a(true)) {
                btVar65 = this.f2075a.u;
                btVar65.z();
                return;
            }
            return;
        }
        btVar2 = this.f2075a.u;
        if (view != btVar2.W()) {
            btVar11 = this.f2075a.u;
            if (view != btVar11.X()) {
                btVar12 = this.f2075a.u;
                if (view != btVar12.Y()) {
                    btVar13 = this.f2075a.u;
                    if (view != btVar13.Z()) {
                        btVar14 = this.f2075a.u;
                        if (view != btVar14.q()) {
                            btVar15 = this.f2075a.u;
                            if (view == btVar15.o()) {
                                btVar62 = this.f2075a.u;
                                btVar62.ad();
                                String C = TiebaApplication.C();
                                if (C != null && C.length() > 0) {
                                    adVar6 = this.f2075a.t;
                                    if (!adVar6.b()) {
                                        btVar63 = this.f2075a.u;
                                        btVar63.m();
                                        adVar7 = this.f2075a.t;
                                        blVar29 = this.f2075a.o;
                                        String id = blVar29.k().b().getId();
                                        blVar30 = this.f2075a.o;
                                        String name = blVar30.k().b().getName();
                                        blVar31 = this.f2075a.o;
                                        String a2 = blVar31.k().c().a();
                                        btVar64 = this.f2075a.u;
                                        adVar7.a(id, name, a2, (String) view.getTag(), btVar64.p());
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f2075a, this.f2075a.getString(R.string.login_to_use), true, 11018);
                                return;
                            }
                            btVar16 = this.f2075a.u;
                            if (view == btVar16.n()) {
                                btVar60 = this.f2075a.u;
                                btVar60.ad();
                                String C2 = TiebaApplication.C();
                                if (C2 != null && C2.length() > 0) {
                                    adVar3 = this.f2075a.t;
                                    if (!adVar3.b()) {
                                        btVar61 = this.f2075a.u;
                                        btVar61.m();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str7 = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            blVar25 = this.f2075a.o;
                                            if (blVar25.h()) {
                                                boVar7 = this.f2075a.s;
                                                if (boVar7 != null) {
                                                    boVar8 = this.f2075a.s;
                                                    if (boVar8.c() != null) {
                                                        boVar9 = this.f2075a.s;
                                                        if (boVar9.c().g() != null) {
                                                            boVar10 = this.f2075a.s;
                                                            if (boVar10.c().l() != null) {
                                                                adVar5 = this.f2075a.t;
                                                                boVar11 = this.f2075a.s;
                                                                String id2 = boVar11.c().g().getId();
                                                                boVar12 = this.f2075a.s;
                                                                String name2 = boVar12.c().g().getName();
                                                                boVar13 = this.f2075a.s;
                                                                adVar5.a(id2, name2, boVar13.c().l().a(), str7, intValue2, intValue, booleanValue);
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
                                            adVar4 = this.f2075a.t;
                                            blVar26 = this.f2075a.o;
                                            String id3 = blVar26.k().b().getId();
                                            blVar27 = this.f2075a.o;
                                            String name3 = blVar27.k().b().getName();
                                            blVar28 = this.f2075a.o;
                                            adVar4.a(id3, name3, blVar28.k().c().a(), str7, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.f2075a, this.f2075a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            btVar17 = this.f2075a.u;
                            if (view == btVar17.aa()) {
                                btVar59 = this.f2075a.u;
                                btVar59.b(true);
                                return;
                            }
                            btVar18 = this.f2075a.u;
                            if (view == btVar18.s()) {
                                btVar58 = this.f2075a.u;
                                btVar58.w();
                                return;
                            }
                            btVar19 = this.f2075a.u;
                            if (view == btVar19.v()) {
                                d5 = this.f2075a.d(11026);
                                if (d5) {
                                    NewPbActivity newPbActivity = this.f2075a;
                                    btVar57 = this.f2075a.u;
                                    newPbActivity.v = btVar57.ah();
                                    AtListActivity.a(this.f2075a, 12005);
                                    return;
                                }
                                return;
                            }
                            btVar20 = this.f2075a.u;
                            if (view == btVar20.t()) {
                                d4 = this.f2075a.d(11027);
                                if (d4) {
                                    this.f2075a.c((String) view.getTag());
                                    return;
                                }
                                return;
                            }
                            btVar21 = this.f2075a.u;
                            if (view == btVar21.u()) {
                                boVar6 = this.f2075a.s;
                                if (boVar6.e()) {
                                    btVar56 = this.f2075a.u;
                                    btVar56.D();
                                    return;
                                }
                                return;
                            }
                            btVar22 = this.f2075a.u;
                            if (view != btVar22.d().getView()) {
                                btVar26 = this.f2075a.u;
                                if (view != btVar26.e().getView()) {
                                    btVar27 = this.f2075a.u;
                                    if (btVar27.f() != null) {
                                        btVar53 = this.f2075a.u;
                                        if (view == btVar53.f().getView()) {
                                            str4 = this.f2075a.g;
                                            if (str4 != null) {
                                                str5 = this.f2075a.g;
                                                if (str5.length() > 0) {
                                                    NewPbActivity newPbActivity2 = this.f2075a;
                                                    str6 = this.f2075a.g;
                                                    newPbActivity2.a(str6);
                                                    return;
                                                }
                                            }
                                            btVar54 = this.f2075a.u;
                                            btVar54.h();
                                            btVar55 = this.f2075a.u;
                                            btVar55.f().a();
                                            return;
                                        }
                                    }
                                    switch (view.getId()) {
                                        case R.id.sub_post_load_more /* 2131099660 */:
                                            boVar5 = this.f2075a.s;
                                            if (boVar5.e()) {
                                                btVar52 = this.f2075a.u;
                                                btVar52.D();
                                                return;
                                            }
                                            return;
                                        case R.id.dialog_button_cancel /* 2131099920 */:
                                            btVar37 = this.f2075a.u;
                                            btVar37.ac();
                                            return;
                                        case R.id.dialog_button_ok /* 2131099921 */:
                                            btVar38 = this.f2075a.u;
                                            btVar38.ac();
                                            btVar39 = this.f2075a.u;
                                            if (btVar39.Q() >= 0) {
                                                this.f2075a.w();
                                                blVar17 = this.f2075a.o;
                                                btVar40 = this.f2075a.u;
                                                blVar17.c(btVar40.Q());
                                                btVar41 = this.f2075a.u;
                                                btVar41.x();
                                                return;
                                            }
                                            return;
                                        case R.id.reply /* 2131100478 */:
                                        case R.id.sub_pb_item /* 2131100755 */:
                                        case R.id.sub_pb_more /* 2131100757 */:
                                            try {
                                                blVar4 = this.f2075a.o;
                                                if (blVar4.k() != null) {
                                                    btVar28 = this.f2075a.u;
                                                    btVar28.ac();
                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                    com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) sparseArray2.get(R.id.tag_load_sub_data);
                                                    View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                    if (asVar != null && view2 != null) {
                                                        blVar5 = this.f2075a.o;
                                                        com.baidu.tieba.data.bb a3 = blVar5.a(asVar);
                                                        boVar = this.f2075a.s;
                                                        blVar6 = this.f2075a.o;
                                                        boVar.a(blVar6.a());
                                                        boVar2 = this.f2075a.s;
                                                        boVar2.b(asVar.d());
                                                        boVar3 = this.f2075a.s;
                                                        boVar3.b();
                                                        this.f2075a.w();
                                                        if (view.getId() == R.id.reply) {
                                                            btVar31 = this.f2075a.u;
                                                            blVar9 = this.f2075a.o;
                                                            btVar31.a(true, a3, false, null, view2, blVar9.k().j());
                                                        } else if (view.getId() == R.id.sub_pb_item) {
                                                            btVar30 = this.f2075a.u;
                                                            blVar8 = this.f2075a.o;
                                                            btVar30.a(true, a3, false, (String) ((SparseArray) view.getTag()).get(R.id.tag_photo_username), view2, blVar8.k().j());
                                                        } else {
                                                            btVar29 = this.f2075a.u;
                                                            blVar7 = this.f2075a.o;
                                                            btVar29.a(false, a3, true, null, view2, blVar7.k().j());
                                                        }
                                                    }
                                                }
                                                return;
                                            } catch (Exception e) {
                                                com.baidu.tieba.util.be.b(getClass().getName(), "onClick", e.toString());
                                                return;
                                            }
                                        case R.id.pb_title_back /* 2131100711 */:
                                            this.f2075a.h();
                                            return;
                                        case R.id.pb_title_forum /* 2131100712 */:
                                            btVar51 = this.f2075a.u;
                                            btVar51.a(0);
                                            if (TiebaApplication.g().s()) {
                                                StatService.onEvent(this.f2075a, "pb_header_forum_name", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_host /* 2131100713 */:
                                            this.f2075a.w();
                                            blVar23 = this.f2075a.o;
                                            blVar23.p();
                                            btVar49 = this.f2075a.u;
                                            btVar49.x();
                                            if (TiebaApplication.g().s()) {
                                                StatService.onEvent(this.f2075a, "pb_set_host", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.pb_title_more /* 2131100714 */:
                                            btVar50 = this.f2075a.u;
                                            blVar24 = this.f2075a.o;
                                            boolean c = blVar24.c();
                                            bfVar = this.f2075a.p;
                                            btVar50.a(c, bfVar.a());
                                            return;
                                        case R.id.pb_list_header_bar /* 2131100722 */:
                                            blVar11 = this.f2075a.o;
                                            if (blVar11 != null) {
                                                blVar12 = this.f2075a.o;
                                                if (blVar12.k() != null) {
                                                    blVar13 = this.f2075a.o;
                                                    if (blVar13.k().b() != null) {
                                                        blVar14 = this.f2075a.o;
                                                        String name4 = blVar14.k().b().getName();
                                                        if (name4 != null && name4.length() > 0) {
                                                            blVar15 = this.f2075a.o;
                                                            if (blVar15.d()) {
                                                                this.f2075a.h();
                                                                return;
                                                            } else {
                                                                FrsActivity.a(this.f2075a, name4, (String) null);
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
                                        case R.id.mark_layout /* 2131100742 */:
                                            btVar42 = this.f2075a.u;
                                            btVar42.ac();
                                            d3 = this.f2075a.d(11009);
                                            if (d3) {
                                                blVar18 = this.f2075a.o;
                                                btVar43 = this.f2075a.u;
                                                if (blVar18.f(btVar43.P()) != null) {
                                                    this.f2075a.t();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case R.id.share_layout /* 2131100744 */:
                                            this.f2075a.w();
                                            btVar48 = this.f2075a.u;
                                            btVar48.ac();
                                            blVar22 = this.f2075a.o;
                                            blVar22.r();
                                            return;
                                        case R.id.skip_layout /* 2131100745 */:
                                            btVar46 = this.f2075a.u;
                                            btVar46.ac();
                                            blVar20 = this.f2075a.o;
                                            if (blVar20.l() != null) {
                                                btVar47 = this.f2075a.u;
                                                blVar21 = this.f2075a.o;
                                                btVar47.a(blVar21.l());
                                            }
                                            if (TiebaApplication.g().s()) {
                                                StatService.onEvent(this.f2075a, "pb_skip_page", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.reverse_layout /* 2131100746 */:
                                            this.f2075a.w();
                                            btVar44 = this.f2075a.u;
                                            btVar44.ac();
                                            blVar19 = this.f2075a.o;
                                            blVar19.q();
                                            btVar45 = this.f2075a.u;
                                            btVar45.x();
                                            if (TiebaApplication.g().s()) {
                                                StatService.onEvent(this.f2075a, "pb_set_desc", "pbclick", 1);
                                                return;
                                            }
                                            return;
                                        case R.id.sub_pb_buttom_layout /* 2131100749 */:
                                            blVar10 = this.f2075a.o;
                                            if (!blVar10.h()) {
                                                this.f2075a.w();
                                                btVar32 = this.f2075a.u;
                                                btVar32.F();
                                                boVar4 = this.f2075a.s;
                                                boVar4.cancelLoadData();
                                                return;
                                            }
                                            this.f2075a.h();
                                            return;
                                        case R.id.pb_reply_post /* 2131100754 */:
                                            blVar16 = this.f2075a.o;
                                            if (blVar16.k() != null) {
                                                d2 = this.f2075a.d(11001);
                                                if (d2) {
                                                    this.f2075a.c((String) null);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case R.id.pb_button_camera1 /* 2131100776 */:
                                        case R.id.pb_button_camera /* 2131100912 */:
                                            NewPbActivity newPbActivity3 = this.f2075a;
                                            btVar35 = this.f2075a.u;
                                            newPbActivity3.v = btVar35.ah();
                                            ImageButton imageButton = (ImageButton) view;
                                            if (imageButton.getTag() == null) {
                                                btVar36 = this.f2075a.u;
                                                btVar36.O();
                                                return;
                                            }
                                            WriteImageActivity.a(this.f2075a, (Bitmap) imageButton.getTag(), 12003);
                                            return;
                                        case R.id.pb_button_face1 /* 2131100777 */:
                                        case R.id.pb_button_face /* 2131100913 */:
                                            btVar34 = this.f2075a.u;
                                            btVar34.L();
                                            return;
                                        case R.id.pb_button_at1 /* 2131100778 */:
                                            d = this.f2075a.d(11025);
                                            if (d) {
                                                NewPbActivity newPbActivity4 = this.f2075a;
                                                btVar33 = this.f2075a.u;
                                                newPbActivity4.v = btVar33.ah();
                                                AtListActivity.a(this.f2075a, 12004);
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            }
                            str = this.f2075a.g;
                            if (str != null) {
                                str2 = this.f2075a.g;
                                if (str2.length() > 0) {
                                    NewPbActivity newPbActivity5 = this.f2075a;
                                    str3 = this.f2075a.g;
                                    newPbActivity5.a(str3);
                                    return;
                                }
                            }
                            btVar23 = this.f2075a.u;
                            btVar23.i();
                            btVar24 = this.f2075a.u;
                            btVar24.d().a();
                            btVar25 = this.f2075a.u;
                            btVar25.e().a();
                            return;
                        }
                    }
                }
            }
        }
        btVar3 = this.f2075a.u;
        btVar3.ad();
        blVar = this.f2075a.o;
        if (blVar.k().j() == 1) {
            adVar = this.f2075a.t;
            if (!adVar.b()) {
                btVar4 = this.f2075a.u;
                btVar4.m();
                btVar5 = this.f2075a.u;
                if (view != btVar5.W()) {
                    btVar6 = this.f2075a.u;
                    if (view != btVar6.X()) {
                        btVar7 = this.f2075a.u;
                        if (view != btVar7.Y()) {
                            btVar8 = this.f2075a.u;
                            if (view != btVar8.Z()) {
                                btVar9 = this.f2075a.u;
                                if (view == btVar9.q()) {
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
                blVar2 = this.f2075a.o;
                ForumData b = blVar2.k().b();
                String name5 = b.getName();
                String id4 = b.getId();
                blVar3 = this.f2075a.o;
                String a4 = blVar3.k().c().a();
                adVar2 = this.f2075a.t;
                btVar10 = this.f2075a.u;
                adVar2.a(id4, name5, a4, i, btVar10.r());
            }
        }
    }
}
