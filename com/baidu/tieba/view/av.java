package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationBar f1982a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NavigationBar navigationBar) {
        this.f1982a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        switch (view.getId()) {
            case R.id.navigationBarGoBack /* 2131100765 */:
                activity2 = this.f1982a.d;
                activity2.finish();
                return;
            case R.id.navigationBarHome /* 2131100766 */:
                activity = this.f1982a.d;
                MainTabActivity.a(activity);
                return;
            default:
                return;
        }
    }
}
