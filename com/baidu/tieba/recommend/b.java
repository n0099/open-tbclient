package com.baidu.tieba.recommend;

import android.view.View;
/* loaded from: classes.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ DailyClassicalActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DailyClassicalActivity dailyClassicalActivity) {
        this.a = dailyClassicalActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.back) {
            this.a.finish();
        } else if (id == com.baidu.tieba.a.h.tag_webview_item) {
            this.a.a();
        }
    }
}
