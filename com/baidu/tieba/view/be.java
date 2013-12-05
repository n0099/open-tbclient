package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.square.SquareSearchActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class be implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchBoxView f2672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(SearchBoxView searchBoxView) {
        this.f2672a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        String str;
        if (view.getId() == R.id.search_bg_layout) {
            if (TiebaApplication.h().t()) {
                activity2 = this.f2672a.f2647a;
                str = this.f2672a.b;
                StatService.onEvent(activity2, str, "click", 1);
            }
            activity = this.f2672a.f2647a;
            SquareSearchActivity.a(activity, "");
        }
    }
}
