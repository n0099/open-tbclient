package com.baidu.tieba.topRec;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class n {
    Activity a;
    int b = 0;

    public n(Activity activity) {
        this.a = activity;
    }

    public static boolean a() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("toprec_first_in", false);
    }

    public static void b() {
        com.baidu.tbadk.core.sharedPref.b.a().b("toprec_first_in", true);
    }

    public void a(View view) {
        if (!a() && TbadkApplication.m252getInst().getSkinType() == 0) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(view).a(150).b(true);
            o oVar = new o(this);
            gVar.a(oVar).a(new p(this));
            gVar.a().a(this.a);
            b();
        }
    }
}
