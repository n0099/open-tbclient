package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f2028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(CommonWebviewActivity commonWebviewActivity) {
        this.f2028a = commonWebviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2028a.finish();
    }
}
