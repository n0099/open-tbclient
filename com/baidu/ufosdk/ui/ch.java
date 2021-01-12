package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes7.dex */
final class ch implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.f5491a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f5414a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f5491a.f5489a.startActivity(new Intent(this.f5491a.f5489a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e) {
        }
    }
}
