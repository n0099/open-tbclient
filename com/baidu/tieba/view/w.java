package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.CommonWebviewActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsHeaderView f2583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsHeaderView frsHeaderView) {
        this.f2583a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.f2583a.aj;
        if (str != null) {
            activity = this.f2583a.E;
            activity2 = this.f2583a.E;
            String string = activity2.getString(R.string.frs_badge_intro);
            str2 = this.f2583a.aj;
            CommonWebviewActivity.a(activity, string, str2, true);
        }
    }
}
