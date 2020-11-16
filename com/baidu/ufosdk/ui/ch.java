package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes21.dex */
final class ch implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f3802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.f3802a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f3737a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f3802a.f3801a.startActivity(new Intent(this.f3802a.f3801a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e) {
        }
    }
}
