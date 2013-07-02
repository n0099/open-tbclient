package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ TagContentActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TagContentActivity tagContentActivity) {
        this.a = tagContentActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131165277 */:
                this.a.finish();
                return;
            case R.id.tag_webview_item /* 2131165482 */:
                this.a.c();
                return;
            case R.id.attention /* 2131165987 */:
                this.a.b();
                return;
            default:
                return;
        }
    }
}
