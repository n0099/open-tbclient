package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.square.SquareSearchActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ SearchBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(SearchBoxView searchBoxView) {
        this.a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        String str;
        if (view.getId() == R.id.search_bg_layout) {
            if (TiebaApplication.h().t()) {
                activity2 = this.a.a;
                str = this.a.b;
                StatService.onEvent(activity2, str, "click", 1);
            }
            activity = this.a.a;
            SquareSearchActivity.a(activity, "");
        }
    }
}
