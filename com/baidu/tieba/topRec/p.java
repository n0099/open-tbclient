package com.baidu.tieba.topRec;

import android.app.Activity;
import android.view.View;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class p {
    Activity a;
    int b = 0;

    public p(Activity activity) {
        this.a = activity;
    }

    public static boolean a() {
        return com.baidu.tieba.sharedPref.b.a().a("toprec_first_in", false);
    }

    public static void b() {
        com.baidu.tieba.sharedPref.b.a().b("toprec_first_in", true);
    }

    public void a(View view) {
        if (!a() && TiebaApplication.h().al() == 0) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(view).a(SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED).b(true);
            q qVar = new q(this);
            gVar.a(qVar).a(new r(this));
            gVar.a().a(this.a);
            com.baidu.adp.lib.g.e.e("TOPRECTipCover", "show", "done");
            b();
        }
    }
}
