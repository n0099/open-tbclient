package com.baidu.tieba.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.CommonWebviewActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.a.aB;
        if (!TextUtils.isEmpty(str)) {
            activity = this.a.D;
            activity2 = this.a.D;
            String string = activity2.getString(R.string.frs_badge_intro);
            str2 = this.a.aB;
            CommonWebviewActivity.a(activity, string, str2, true);
        }
    }
}
