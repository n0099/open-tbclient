package com.baidu.tieba;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f2028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(CommonWebviewActivity commonWebviewActivity) {
        this.f2028a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099729 */:
                this.f2028a.finish();
                return;
            case R.id.refresh /* 2131099807 */:
                TiebaApplication.g().k(0);
                this.f2028a.b();
                return;
            case R.id.common_webview_item /* 2131099922 */:
                this.f2028a.b();
                return;
            default:
                return;
        }
    }
}
