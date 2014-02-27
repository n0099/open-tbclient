package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.barcode.CaptureActivity;
/* loaded from: classes.dex */
final class cj implements View.OnClickListener {
    final /* synthetic */ SearchBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(SearchBoxView searchBoxView) {
        this.a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        activity = this.a.a;
        CaptureActivity.a(activity, 16003);
    }
}
