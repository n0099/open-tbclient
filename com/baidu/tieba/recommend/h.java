package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ TagContentActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TagContentActivity tagContentActivity) {
        this.a = tagContentActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099726 */:
                this.a.finish();
                return;
            case R.id.tag_webview_item /* 2131099893 */:
                this.a.c();
                return;
            case R.id.attention /* 2131100319 */:
                this.a.b();
                return;
            default:
                return;
        }
    }
}
