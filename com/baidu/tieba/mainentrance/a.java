package com.baidu.tieba.mainentrance;

import android.support.v4.app.Fragment;
/* loaded from: classes.dex */
public final class a {
    public static void a(Fragment fragment) {
        if (fragment != null) {
            try {
                ((com.baidu.tieba.home.f) fragment).a();
            } catch (ClassCastException e) {
                com.baidu.adp.lib.util.e.a("EnterForumProxy", "closePossibleDialogs", e);
            }
        }
    }
}
