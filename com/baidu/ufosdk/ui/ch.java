package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes22.dex */
final class ch implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f3805a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.f3805a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f3740a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f3805a.f3804a.startActivity(new Intent(this.f3805a.f3804a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e) {
        }
    }
}
