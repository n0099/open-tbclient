package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ NavigationBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NavigationBar navigationBar) {
        this.a = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.a.a;
        if (z) {
            switch (view.getId()) {
                case R.id.navigationBarGoBack /* 2131101082 */:
                    activity2 = this.a.f;
                    activity2.finish();
                    return;
                case R.id.navigationBarCreateGroupBtn /* 2131101083 */:
                case R.id.navigationBarNewPost /* 2131101084 */:
                default:
                    return;
                case R.id.navigationBarHome /* 2131101085 */:
                    activity = this.a.f;
                    MainTabActivity.a(activity);
                    return;
            }
        }
    }
}
