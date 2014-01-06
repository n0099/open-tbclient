package com.baidu.tieba;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ CommonWebviewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(CommonWebviewActivity commonWebviewActivity) {
        this.a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099658 */:
                this.a.finish();
                return;
            case R.id.refresh /* 2131099837 */:
                TiebaApplication.g().g(0);
                this.a.a();
                return;
            case R.id.common_webview_item /* 2131099955 */:
                this.a.a();
                return;
            default:
                return;
        }
    }
}
