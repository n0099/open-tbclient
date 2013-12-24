package com.baidu.tieba.person;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bz {
    Activity a;

    public bz(Activity activity) {
        this.a = activity;
    }

    public static boolean a() {
        return com.baidu.tieba.sharedPref.b.a().a("is_show_person_photo_cover", true);
    }

    public static void b() {
        com.baidu.tieba.sharedPref.b.a().b("is_show_person_photo_cover", true);
    }

    public void a(View view) {
        if (!a() && TiebaApplication.C()) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(view).a(150).b(true);
            ca caVar = new ca(this);
            gVar.a(caVar).a(new cb(this));
            gVar.a().a(this.a);
            com.baidu.adp.lib.h.e.e("PersonPhotoCover", "show", "done");
            b();
        }
    }
}
