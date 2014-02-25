package com.baidu.tieba.mainentrance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a {
    public static c a(Bundle bundle) {
        c cVar = new c();
        cVar.a = new com.baidu.tieba.home.f();
        cVar.a.setArguments(bundle);
        cVar.e = 1;
        cVar.b = R.drawable.tabs_home;
        cVar.c = R.drawable.tabs_home_1;
        cVar.d = R.string.home;
        return cVar;
    }

    public static void a(Fragment fragment) {
        if (fragment != null) {
            try {
                ((com.baidu.tieba.home.f) fragment).a();
            } catch (ClassCastException e) {
                com.baidu.adp.lib.util.f.a("EnterForumProxy", "closePossibleDialogs", e);
            }
        }
    }
}
