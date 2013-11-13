package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationBar f2568a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NavigationBar navigationBar) {
        this.f2568a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.f2568a.f2543a;
        if (z) {
            switch (view.getId()) {
                case R.id.navigationBarGoBack /* 2131100945 */:
                    activity2 = this.f2568a.f;
                    activity2.finish();
                    return;
                case R.id.navigationBarHome /* 2131100946 */:
                    activity = this.f2568a.f;
                    MainTabActivity.a(activity);
                    return;
                default:
                    return;
            }
        }
    }
}
