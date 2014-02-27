package com.baidu.tieba.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.util.TbWebViewActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as implements View.OnClickListener {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.a = arVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.a.aq;
        if (!TextUtils.isEmpty(str)) {
            activity = this.a.y;
            activity2 = this.a.y;
            String string = activity2.getString(R.string.frs_badge_intro);
            str2 = this.a.aq;
            TbWebViewActivity.b(activity, string, str2);
        }
    }
}
