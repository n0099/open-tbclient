package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyClassicalActivity f2301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DailyClassicalActivity dailyClassicalActivity) {
        this.f2301a = dailyClassicalActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099658 */:
                this.f2301a.finish();
                return;
            case R.id.tag_webview_item /* 2131100006 */:
                this.f2301a.a();
                return;
            default:
                return;
        }
    }
}
