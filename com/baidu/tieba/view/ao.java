package com.baidu.tieba.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.util.TbWebViewActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ao implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.a.aj;
        if (!TextUtils.isEmpty(str)) {
            activity = this.a.A;
            activity2 = this.a.A;
            String string = activity2.getString(R.string.frs_badge_intro);
            str2 = this.a.aj;
            TbWebViewActivity.b(activity, string, str2);
        }
    }
}
