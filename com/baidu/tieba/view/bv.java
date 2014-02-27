package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bv implements View.OnClickListener {
    final /* synthetic */ NavigationBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(NavigationBar navigationBar) {
        this.a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.a.a;
        if (z) {
            int id = view.getId();
            if (id == R.id.navigationBarGoBack) {
                activity2 = this.a.f;
                activity2.finish();
            } else if (id == R.id.navigationBarHome) {
                activity = this.a.f;
                com.baidu.tieba.mainentrance.d.a(activity);
            }
        }
    }
}
