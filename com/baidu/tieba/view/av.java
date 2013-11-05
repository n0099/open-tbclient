package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationBar f2515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NavigationBar navigationBar) {
        this.f2515a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.f2515a.f2489a;
        if (z) {
            switch (view.getId()) {
                case R.id.navigationBarGoBack /* 2131101020 */:
                    activity2 = this.f2515a.e;
                    activity2.finish();
                    return;
                case R.id.navigationBarHome /* 2131101021 */:
                    activity = this.f2515a.e;
                    MainTabActivity.a(activity);
                    return;
                default:
                    return;
            }
        }
    }
}
