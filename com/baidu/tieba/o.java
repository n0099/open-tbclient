package com.baidu.tieba;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f1511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(CommonWebviewActivity commonWebviewActivity) {
        this.f1511a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099729 */:
                this.f1511a.finish();
                return;
            case R.id.refresh /* 2131099804 */:
                TiebaApplication.g().k(0);
                this.f1511a.b();
                return;
            case R.id.common_webview_item /* 2131099917 */:
                this.f1511a.b();
                return;
            default:
                return;
        }
    }
}
