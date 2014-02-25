package com.baidu.tieba.topRec;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class o {
    Activity a;
    int b = 0;

    public o(Activity activity) {
        this.a = activity;
    }

    public static boolean a() {
        return com.baidu.tieba.sharedPref.b.a().a("toprec_first_in", false);
    }

    public static void b() {
        com.baidu.tieba.sharedPref.b.a().b("toprec_first_in", true);
    }

    public void a(View view) {
        if (!a() && TiebaApplication.g().al() == 0) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(view).a(SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED).b(true);
            p pVar = new p(this);
            gVar.a(pVar).a(new q(this));
            gVar.a().a(this.a);
            com.baidu.adp.lib.util.f.e("TOPRECTipCover", "show", "done");
            b();
        }
    }
}
