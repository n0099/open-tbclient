package com.baidu.tieba;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f1262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(CommonWebviewActivity commonWebviewActivity) {
        this.f1262a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099730 */:
                this.f1262a.finish();
                return;
            case R.id.refresh /* 2131099800 */:
                TiebaApplication.f().j(0);
                this.f1262a.b();
                return;
            case R.id.common_webview_item /* 2131099916 */:
                this.f1262a.b();
                return;
            default:
                return;
        }
    }
}
