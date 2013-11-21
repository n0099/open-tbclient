package com.baidu.tieba;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f2027a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(CommonWebviewActivity commonWebviewActivity) {
        this.f2027a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099658 */:
                this.f2027a.finish();
                return;
            case R.id.refresh /* 2131099826 */:
                TiebaApplication.g().h(0);
                this.f2027a.a();
                return;
            case R.id.common_webview_item /* 2131099949 */:
                this.f2027a.a();
                return;
            default:
                return;
        }
    }
}
