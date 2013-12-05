package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationBar f2666a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NavigationBar navigationBar) {
        this.f2666a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.f2666a.f2640a;
        if (z) {
            switch (view.getId()) {
                case R.id.navigationBarGoBack /* 2131101051 */:
                    activity2 = this.f2666a.f;
                    activity2.finish();
                    return;
                case R.id.navigationBarNewPost /* 2131101052 */:
                default:
                    return;
                case R.id.navigationBarHome /* 2131101053 */:
                    activity = this.f2666a.f;
                    MainTabActivity.a(activity);
                    return;
            }
        }
    }
}
