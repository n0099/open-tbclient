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
    final /* synthetic */ SearchBoxView f2573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(SearchBoxView searchBoxView) {
        this.f2573a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        String str;
        if (view.getId() == R.id.search_bg_layout) {
            if (TiebaApplication.g().s()) {
                activity2 = this.f2573a.f2549a;
                str = this.f2573a.b;
                StatService.onEvent(activity2, str, "click", 1);
            }
            activity = this.f2573a.f2549a;
            SquareSearchActivity.a(activity, "");
        }
    }
}
