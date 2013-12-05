package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.CommonWebviewActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f2651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.f2651a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.f2651a.aB;
        if (str != null) {
            activity = this.f2651a.D;
            activity2 = this.f2651a.D;
            String string = activity2.getString(R.string.frs_badge_intro);
            str2 = this.f2651a.aB;
            CommonWebviewActivity.a(activity, string, str2, true);
        }
    }
}
