package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes8.dex */
final class ch implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5773a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.f5773a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f5696a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f5773a.f5771a.startActivity(new Intent(this.f5773a.f5771a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e) {
        }
    }
}
