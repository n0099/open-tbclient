package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationBar f2551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NavigationBar navigationBar) {
        this.f2551a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.f2551a.f2526a;
        if (z) {
            switch (view.getId()) {
                case R.id.navigationBarGoBack /* 2131100933 */:
                    activity2 = this.f2551a.f;
                    activity2.finish();
                    return;
                case R.id.navigationBarHome /* 2131100934 */:
                    activity = this.f2551a.f;
                    MainTabActivity.a(activity);
                    return;
                default:
                    return;
            }
        }
    }
}
