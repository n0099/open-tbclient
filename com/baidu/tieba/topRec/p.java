package com.baidu.tieba.topRec;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    Activity f2440a;
    int b = 0;

    public p(Activity activity) {
        this.f2440a = activity;
    }

    public static boolean a() {
        return com.baidu.tieba.sharedPref.b.a().a("toprec_first_in", false);
    }

    public static void b() {
        com.baidu.tieba.sharedPref.b.a().b("toprec_first_in", true);
    }

    public void a(View view) {
        if (!a() && TiebaApplication.g().ap() == 0) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(view).a(150).b(true);
            q qVar = new q(this);
            gVar.a(qVar).a(new r(this));
            gVar.a().a(this.f2440a);
            bg.e("TOPRECTipCover", "show", "done");
            b();
        }
    }
}
