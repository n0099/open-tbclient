package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
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
            case R.id.back /* 2131099728 */:
                this.a.finish();
                return;
            case R.id.tag_webview_item /* 2131099922 */:
                this.a.c();
                return;
            case R.id.attention /* 2131100370 */:
                this.a.b();
                return;
            default:
                return;
        }
    }
}
