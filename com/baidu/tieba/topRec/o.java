package com.baidu.tieba.topRec;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.av;
import com.baidu.zeus.WebChromeClient;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    Activity f1876a;
    int b = 0;

    public o(Activity activity) {
        this.f1876a = activity;
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
            gVar.a(view).a(WebChromeClient.STRING_DLG_BTN_SET).a(true);
            p pVar = new p(this);
            gVar.a(pVar).a(new q(this));
            gVar.a().a(this.f1876a);
            av.e("TOPRECTipCover", "show", "done");
            b();
        }
    }
}
