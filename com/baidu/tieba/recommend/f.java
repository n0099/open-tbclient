package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ RecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendActivity recommendActivity) {
        this.a = recommendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hotspot_webview_item /* 2131100363 */:
                this.a.b();
                return;
            default:
                return;
        }
    }
}
