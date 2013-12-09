package com.baidu.tieba;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f2136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(CommonWebviewActivity commonWebviewActivity) {
        this.f2136a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099658 */:
                this.f2136a.finish();
                return;
            case R.id.refresh /* 2131099833 */:
                TiebaApplication.h().g(0);
                this.f2136a.a();
                return;
            case R.id.common_webview_item /* 2131099958 */:
                this.f2136a.a();
                return;
            default:
                return;
        }
    }
}
