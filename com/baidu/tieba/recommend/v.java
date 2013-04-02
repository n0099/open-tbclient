package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ TagContentActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TagContentActivity tagContentActivity) {
        this.a = tagContentActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131230738 */:
                this.a.finish();
                return;
            case R.id.tag_webview_item /* 2131230932 */:
                this.a.j();
                return;
            case R.id.attention /* 2131231317 */:
                this.a.i();
                return;
            default:
                return;
        }
    }
}
