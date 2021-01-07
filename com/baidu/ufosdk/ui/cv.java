package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes8.dex */
final class cv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5791a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cg cgVar) {
        this.f5791a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f5697a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f5791a.f5772a.startActivity(new Intent(this.f5791a.f5772a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
