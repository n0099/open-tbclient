package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class bw implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.s sVar;
        cu cuVar4;
        cu cuVar5;
        cu cuVar6;
        cu cuVar7;
        cu cuVar8;
        cu cuVar9;
        com.baidu.tieba.model.bb bbVar2;
        com.baidu.tieba.model.bb bbVar3;
        com.baidu.tieba.model.s sVar2;
        cu cuVar10;
        cu cuVar11;
        cu cuVar12;
        cu cuVar13;
        cu cuVar14;
        cu cuVar15;
        cu cuVar16;
        cu cuVar17;
        cu cuVar18;
        cu cuVar19;
        cu cuVar20;
        cu cuVar21;
        cu cuVar22;
        cu cuVar23;
        com.baidu.tieba.model.bb bbVar4;
        cu cuVar24;
        com.baidu.tieba.model.bb bbVar5;
        com.baidu.tieba.model.be beVar;
        com.baidu.tieba.model.bb bbVar6;
        com.baidu.tieba.model.be beVar2;
        com.baidu.tieba.model.be beVar3;
        Handler handler;
        cu cuVar25;
        com.baidu.tieba.model.bb bbVar7;
        cu cuVar26;
        com.baidu.tieba.model.bb bbVar8;
        cu cuVar27;
        com.baidu.tieba.model.be beVar4;
        cu cuVar28;
        com.baidu.tieba.model.bb bbVar9;
        cu cuVar29;
        com.baidu.tieba.model.be beVar5;
        com.baidu.tieba.model.bb bbVar10;
        com.baidu.tieba.model.bb bbVar11;
        com.baidu.tieba.model.bb bbVar12;
        com.baidu.tieba.model.bb bbVar13;
        com.baidu.tieba.model.bb bbVar14;
        com.baidu.tieba.model.bb bbVar15;
        com.baidu.tieba.model.be beVar6;
        cu cuVar30;
        cu cuVar31;
        cu cuVar32;
        cu cuVar33;
        com.baidu.tieba.model.bb bbVar16;
        cu cuVar34;
        cu cuVar35;
        cu cuVar36;
        boolean a;
        com.baidu.tieba.model.bb bbVar17;
        cu cuVar37;
        cu cuVar38;
        com.baidu.tieba.model.bb bbVar18;
        cu cuVar39;
        cu cuVar40;
        com.baidu.tieba.model.bb bbVar19;
        cu cuVar41;
        com.baidu.tieba.model.bb bbVar20;
        cu cuVar42;
        com.baidu.tieba.model.bb bbVar21;
        cu cuVar43;
        cu cuVar44;
        com.baidu.tieba.model.bb bbVar22;
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.bb bbVar23;
        com.baidu.tieba.model.bb bbVar24;
        com.baidu.tieba.model.be beVar7;
        com.baidu.tieba.model.be beVar8;
        com.baidu.tieba.model.be beVar9;
        com.baidu.tieba.model.be beVar10;
        cu cuVar45;
        cu cuVar46;
        cu cuVar47;
        com.baidu.tieba.model.s sVar3;
        cu cuVar48;
        com.baidu.tieba.model.bb bbVar25;
        com.baidu.tieba.model.s sVar4;
        com.baidu.tieba.model.bb bbVar26;
        com.baidu.tieba.model.bb bbVar27;
        com.baidu.tieba.model.bb bbVar28;
        com.baidu.tieba.model.be beVar11;
        com.baidu.tieba.model.be beVar12;
        com.baidu.tieba.model.be beVar13;
        com.baidu.tieba.model.be beVar14;
        com.baidu.tieba.model.s sVar5;
        com.baidu.tieba.model.be beVar15;
        com.baidu.tieba.model.be beVar16;
        com.baidu.tieba.model.be beVar17;
        com.baidu.tieba.model.bb bbVar29;
        com.baidu.tieba.model.bb bbVar30;
        com.baidu.tieba.model.bb bbVar31;
        cu cuVar49;
        int i = 0;
        cuVar = this.a.C;
        if (view == cuVar.I()) {
            bbVar31 = this.a.w;
            if (bbVar31.a(true)) {
                cuVar49 = this.a.C;
                cuVar49.q();
                return;
            }
            return;
        }
        cuVar2 = this.a.C;
        if (view != cuVar2.K()) {
            cuVar11 = this.a.C;
            if (view != cuVar11.L()) {
                cuVar12 = this.a.C;
                if (view != cuVar12.M()) {
                    cuVar13 = this.a.C;
                    if (view != cuVar13.N()) {
                        cuVar14 = this.a.C;
                        if (view != cuVar14.l()) {
                            cuVar15 = this.a.C;
                            if (view == cuVar15.X()) {
                                bbVar29 = this.a.w;
                                if (bbVar29 != null) {
                                    bbVar30 = this.a.w;
                                    UtilHelper.c(this.a, bbVar30.q().d().h().c());
                                    return;
                                }
                                return;
                            }
                            cuVar16 = this.a.C;
                            if (view == cuVar16.k()) {
                                cuVar47 = this.a.C;
                                cuVar47.S();
                                String v = TiebaApplication.v();
                                if (v != null && v.length() > 0) {
                                    sVar3 = this.a.B;
                                    if (!sVar3.a()) {
                                        cuVar48 = this.a.C;
                                        cuVar48.i();
                                        SparseArray sparseArray = (SparseArray) view.getTag();
                                        if (sparseArray != null) {
                                            String str = (String) sparseArray.get(R.id.tag_del_post_id);
                                            int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                                            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                            int intValue2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                                            bbVar25 = this.a.w;
                                            if (bbVar25.n()) {
                                                beVar11 = this.a.A;
                                                if (beVar11 != null) {
                                                    beVar12 = this.a.A;
                                                    if (beVar12.e() != null) {
                                                        beVar13 = this.a.A;
                                                        if (beVar13.e().g() != null) {
                                                            beVar14 = this.a.A;
                                                            if (beVar14.e().l() != null) {
                                                                sVar5 = this.a.B;
                                                                beVar15 = this.a.A;
                                                                String id = beVar15.e().g().getId();
                                                                beVar16 = this.a.A;
                                                                String name = beVar16.e().g().getName();
                                                                beVar17 = this.a.A;
                                                                sVar5.a(id, name, beVar17.e().l().a(), str, intValue2, intValue, booleanValue);
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
                                            sVar4 = this.a.B;
                                            bbVar26 = this.a.w;
                                            String id2 = bbVar26.q().c().getId();
                                            bbVar27 = this.a.w;
                                            String name2 = bbVar27.q().c().getName();
                                            bbVar28 = this.a.w;
                                            sVar4.a(id2, name2, bbVar28.q().d().a(), str, intValue2, intValue, booleanValue);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                LoginActivity.a((Activity) this.a, this.a.getString(R.string.login_to_use), true, 11017);
                                return;
                            }
                            cuVar17 = this.a.C;
                            if (view == cuVar17.O()) {
                                cuVar46 = this.a.C;
                                cuVar46.b(true);
                                return;
                            }
                            cuVar18 = this.a.C;
                            if (view == cuVar18.n()) {
                                beVar10 = this.a.A;
                                if (beVar10.h()) {
                                    cuVar45 = this.a.C;
                                    cuVar45.v();
                                    return;
                                }
                                return;
                            }
                            cuVar19 = this.a.C;
                            if (view == cuVar19.f()) {
                                beVar7 = this.a.A;
                                if (beVar7 != null) {
                                    beVar8 = this.a.A;
                                    if (beVar8.a() != null) {
                                        NewPbActivity newPbActivity = this.a;
                                        beVar9 = this.a.A;
                                        NewPbActivity.a(newPbActivity, beVar9.a(), (String) null, (String) null);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            cuVar20 = this.a.C;
                            if (view != cuVar20.b) {
                                cuVar21 = this.a.C;
                                if (view != cuVar21.c) {
                                    cuVar22 = this.a.C;
                                    if (view == cuVar22.e) {
                                        cuVar44 = this.a.C;
                                        bbVar22 = this.a.w;
                                        boolean i2 = bbVar22.i();
                                        avVar = this.a.x;
                                        cuVar44.a(i2, avVar.a());
                                        return;
                                    }
                                    cuVar23 = this.a.C;
                                    if (view != cuVar23.d) {
                                        int id3 = view.getId();
                                        if (id3 != R.id.share_txt) {
                                            if (id3 == R.id.skip_txt) {
                                                cuVar40 = this.a.C;
                                                cuVar40.R();
                                                bbVar19 = this.a.w;
                                                if (bbVar19.r() != null) {
                                                    cuVar41 = this.a.C;
                                                    bbVar20 = this.a.w;
                                                    cuVar41.a(bbVar20.r());
                                                }
                                                com.baidu.tieba.util.cb.a(this.a, "pb_skip_page", "pbclick", 1, new Object[0]);
                                                return;
                                            } else if (id3 != R.id.reverse_txt) {
                                                if (id3 == R.id.mark_txt) {
                                                    cuVar36 = this.a.C;
                                                    cuVar36.R();
                                                    a = this.a.a(11009);
                                                    if (a) {
                                                        bbVar17 = this.a.w;
                                                        cuVar37 = this.a.C;
                                                        if (bbVar17.f(cuVar37.D()) == null) {
                                                            return;
                                                        }
                                                        this.a.r();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == R.id.dialog_button_ok) {
                                                    cuVar32 = this.a.C;
                                                    cuVar32.R();
                                                    cuVar33 = this.a.C;
                                                    if (cuVar33.E() < 0) {
                                                        return;
                                                    }
                                                    this.a.t();
                                                    bbVar16 = this.a.w;
                                                    cuVar34 = this.a.C;
                                                    bbVar16.c(cuVar34.E());
                                                    cuVar35 = this.a.C;
                                                    cuVar35.o();
                                                    return;
                                                } else if (id3 == R.id.dialog_button_cancel) {
                                                    cuVar31 = this.a.C;
                                                    cuVar31.R();
                                                    return;
                                                } else if (id3 == R.id.reply || id3 == R.id.sub_pb_more || id3 == R.id.sub_pb_item) {
                                                    try {
                                                        bbVar4 = this.a.w;
                                                        if (bbVar4.q() != null) {
                                                            cuVar24 = this.a.C;
                                                            cuVar24.R();
                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                            com.baidu.tieba.data.aq aqVar = (com.baidu.tieba.data.aq) sparseArray2.get(R.id.tag_load_sub_data);
                                                            View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                            if (aqVar != null && view2 != null) {
                                                                bbVar5 = this.a.w;
                                                                com.baidu.tieba.data.av a2 = bbVar5.a(aqVar);
                                                                beVar = this.a.A;
                                                                bbVar6 = this.a.w;
                                                                beVar.a(bbVar6.g());
                                                                beVar2 = this.a.A;
                                                                beVar2.b(aqVar.d());
                                                                beVar3 = this.a.A;
                                                                beVar3.d();
                                                                this.a.t();
                                                                if (view.getId() == R.id.reply) {
                                                                    cuVar26 = this.a.C;
                                                                    bbVar8 = this.a.w;
                                                                    cuVar26.a(true, a2, null, null, view2, bbVar8.q().l());
                                                                    return;
                                                                } else if (view.getId() != R.id.sub_pb_item) {
                                                                    handler = this.a.v;
                                                                    handler.post(new bx(this, a2, view2));
                                                                    return;
                                                                } else {
                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                    String str2 = (String) sparseArray3.get(R.id.tag_photo_username);
                                                                    com.baidu.tieba.data.aq aqVar2 = (com.baidu.tieba.data.aq) sparseArray3.get(R.id.tag_clip_board);
                                                                    String d = aqVar2 != null ? aqVar2.d() : null;
                                                                    cuVar25 = this.a.C;
                                                                    bbVar7 = this.a.w;
                                                                    cuVar25.a(true, a2, str2, d, view2, bbVar7.q().l());
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Exception e) {
                                                        com.baidu.adp.lib.util.e.b(getClass().getName(), "onClick", e.toString());
                                                        return;
                                                    }
                                                } else if (id3 == R.id.sub_post_load_more) {
                                                    beVar6 = this.a.A;
                                                    if (beVar6.h()) {
                                                        cuVar30 = this.a.C;
                                                        cuVar30.v();
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == R.id.pb_list_header_bar) {
                                                    bbVar10 = this.a.w;
                                                    if (bbVar10 != null) {
                                                        bbVar11 = this.a.w;
                                                        if (bbVar11.q() != null) {
                                                            bbVar12 = this.a.w;
                                                            if (bbVar12.q().c() != null) {
                                                                bbVar13 = this.a.w;
                                                                String name3 = bbVar13.q().c().getName();
                                                                if (name3 != null && name3.length() > 0) {
                                                                    bbVar14 = this.a.w;
                                                                    if (name3.equals(bbVar14.f())) {
                                                                        bbVar15 = this.a.w;
                                                                        if (bbVar15.j()) {
                                                                            this.a.closeActivity();
                                                                            return;
                                                                        }
                                                                    }
                                                                    FrsActivity.a(this.a, name3, null);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (id3 == R.id.sub_pb_bottom_layout) {
                                                    bbVar9 = this.a.w;
                                                    if (bbVar9.n()) {
                                                        this.a.closeActivity();
                                                        return;
                                                    }
                                                    this.a.t();
                                                    cuVar29 = this.a.C;
                                                    cuVar29.y();
                                                    beVar5 = this.a.A;
                                                    beVar5.cancelLoadData();
                                                    return;
                                                } else if (id3 == R.id.btn_loadprevious) {
                                                    beVar4 = this.a.A;
                                                    beVar4.k();
                                                    cuVar28 = this.a.C;
                                                    cuVar28.w();
                                                    return;
                                                } else if (id3 == R.id.floor) {
                                                    NewPbActivity.a(this.a, view);
                                                    return;
                                                } else if (id3 == R.id.pb_new_guide) {
                                                    SharedPreferences.Editor edit = this.a.getSharedPreferences("settings", 0).edit();
                                                    edit.putBoolean("has_shown_pb_guide", true);
                                                    edit.commit();
                                                    cuVar27 = this.a.C;
                                                    cuVar27.j();
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                this.a.t();
                                                cuVar38 = this.a.C;
                                                cuVar38.R();
                                                bbVar18 = this.a.w;
                                                bbVar18.v();
                                                cuVar39 = this.a.C;
                                                cuVar39.o();
                                                com.baidu.tieba.util.cb.a(this.a, "pb_set_desc", "pbclick", 1, new Object[0]);
                                                return;
                                            }
                                        }
                                        this.a.t();
                                        cuVar42 = this.a.C;
                                        cuVar42.R();
                                        NewPbActivity.h(this.a);
                                        return;
                                    }
                                    this.a.t();
                                    bbVar21 = this.a.w;
                                    bbVar21.u();
                                    cuVar43 = this.a.C;
                                    cuVar43.o();
                                    com.baidu.tieba.util.cb.a(this.a, "pb_set_host", "pbclick", 1, new Object[0]);
                                    return;
                                }
                                com.baidu.tieba.util.cb.a(this.a, "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                bbVar23 = this.a.w;
                                if (!bbVar23.j()) {
                                    bbVar24 = this.a.w;
                                    String name4 = bbVar24.q().c().getName();
                                    if (com.baidu.tieba.util.bs.b(name4)) {
                                        FrsActivity.a(this.a, name4, "tb_pb");
                                        return;
                                    }
                                    return;
                                }
                                this.a.finish();
                                return;
                            }
                            this.a.closeActivity();
                            return;
                        }
                    }
                }
            }
        }
        cuVar3 = this.a.C;
        cuVar3.S();
        bbVar = this.a.w;
        if (bbVar.q().l() == 1) {
            sVar = this.a.B;
            if (!sVar.a()) {
                cuVar4 = this.a.C;
                cuVar4.i();
                cuVar5 = this.a.C;
                if (view != cuVar5.K()) {
                    cuVar6 = this.a.C;
                    if (view != cuVar6.L()) {
                        cuVar7 = this.a.C;
                        if (view != cuVar7.M()) {
                            cuVar8 = this.a.C;
                            if (view != cuVar8.N()) {
                                cuVar9 = this.a.C;
                                if (view == cuVar9.l()) {
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
                bbVar2 = this.a.w;
                ForumData c = bbVar2.q().c();
                String name5 = c.getName();
                String id4 = c.getId();
                bbVar3 = this.a.w;
                String a3 = bbVar3.q().d().a();
                sVar2 = this.a.B;
                cuVar10 = this.a.C;
                sVar2.a(id4, name5, a3, i, cuVar10.m());
            }
        }
    }
}
