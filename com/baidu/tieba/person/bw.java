package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bw {

    /* renamed from: a  reason: collision with root package name */
    Activity f2346a;

    public bw(Activity activity) {
        this.f2346a = activity;
    }

    public static boolean a() {
        return com.baidu.tieba.sharedPref.b.a().a("is_show_person_photo_cover", false);
    }

    public static void b() {
        com.baidu.tieba.sharedPref.b.a().b("is_show_person_photo_cover", true);
    }

    public void a(View view) {
        if (!a() && TiebaApplication.C()) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(view).a(150).b(true);
            bx bxVar = new bx(this);
            gVar.a(bxVar).a(new by(this));
            gVar.a().a(this.f2346a);
            com.baidu.adp.lib.h.e.e("PersonPhotoCover", "show", "done");
            b();
        }
    }
}
