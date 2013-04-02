package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ RecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(RecommendActivity recommendActivity) {
        this.a = recommendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hotspot_webview_item /* 2131231352 */:
                this.a.i();
                return;
            default:
                return;
        }
    }
}
