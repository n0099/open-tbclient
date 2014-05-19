package com.baidu.tieba.topRec;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class o {
    Activity a;
    int b = 0;

    public o(Activity activity) {
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
            p pVar = new p(this);
            gVar.a(pVar).a(new q(this));
            gVar.a().a(this.a);
            BdLog.d("TOPRECTipCover", "show", "done");
            b();
        }
    }
}
