package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TagContentActivity f1658a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(TagContentActivity tagContentActivity) {
        this.f1658a = tagContentActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099730 */:
                this.f1658a.finish();
                return;
            case R.id.tag_webview_item /* 2131099947 */:
                this.f1658a.c();
                return;
            case R.id.attention /* 2131100492 */:
                this.f1658a.b();
                return;
            default:
                return;
        }
    }
}
