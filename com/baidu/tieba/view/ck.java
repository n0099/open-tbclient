package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class ck implements View.OnClickListener {
    final /* synthetic */ SearchBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(SearchBoxView searchBoxView) {
        this.a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        String str;
        Activity activity2;
        if (view.getId() == R.id.search_bg_layout) {
            activity = this.a.a;
            str = this.a.b;
            com.baidu.tieba.util.cb.a(activity, str, "click", 1, new Object[0]);
            activity2 = this.a.a;
            SquareSearchActivity.a(activity2);
        }
    }
}
