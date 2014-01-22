package com.baidu.tieba.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.CommonWebviewActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
            CommonWebviewActivity.a(activity, string, str2, true);
        }
    }
}
