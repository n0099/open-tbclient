package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.barcode.CaptureActivity;
/* loaded from: classes.dex */
class bd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchBoxView f2671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(SearchBoxView searchBoxView) {
        this.f2671a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.f2671a.f2647a;
        CaptureActivity.a(activity, 16003);
    }
}
