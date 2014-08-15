package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ DailyClassicalActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DailyClassicalActivity dailyClassicalActivity) {
        this.a = dailyClassicalActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == u.back) {
            this.a.finish();
        } else if (id == u.tag_webview_item) {
            this.a.a();
        }
    }
}
