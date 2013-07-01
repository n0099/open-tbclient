package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TagContentActivity f1389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TagContentActivity tagContentActivity) {
        this.f1389a = tagContentActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099728 */:
                this.f1389a.finish();
                return;
            case R.id.tag_webview_item /* 2131099928 */:
                this.f1389a.c();
                return;
            case R.id.attention /* 2131100405 */:
                this.f1389a.b();
                return;
            default:
                return;
        }
    }
}
