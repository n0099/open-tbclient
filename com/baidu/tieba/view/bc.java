package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ NavigationBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NavigationBar navigationBar) {
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
                case R.id.navigationBarGoBack /* 2131101176 */:
                    activity2 = this.a.f;
                    activity2.finish();
                    return;
                case R.id.navigationBarCreateGroupBtn /* 2131101177 */:
                case R.id.navigationBarNewPost /* 2131101178 */:
                default:
                    return;
                case R.id.navigationBarHome /* 2131101179 */:
                    activity = this.a.f;
                    MainTabActivity.a(activity);
                    return;
            }
        }
    }
}
