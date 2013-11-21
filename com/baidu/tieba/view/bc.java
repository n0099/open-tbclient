package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.square.SquareSearchActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchBoxView f2556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(SearchBoxView searchBoxView) {
        this.f2556a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        String str;
        if (view.getId() == R.id.search_bg_layout) {
            if (TiebaApplication.g().s()) {
                activity2 = this.f2556a.f2532a;
                str = this.f2556a.b;
                StatService.onEvent(activity2, str, "click", 1);
            }
            activity = this.f2556a.f2532a;
            SquareSearchActivity.a(activity, "");
        }
    }
}
