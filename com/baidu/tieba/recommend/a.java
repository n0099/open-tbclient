package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ DailyClassicalActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DailyClassicalActivity dailyClassicalActivity) {
        this.a = dailyClassicalActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099726 */:
                this.a.finish();
                return;
            case R.id.tag_webview_item /* 2131099893 */:
                this.a.b();
                return;
            default:
                return;
        }
    }
}
