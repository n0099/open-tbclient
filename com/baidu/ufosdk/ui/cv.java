package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes21.dex */
final class cv implements View.OnClickListener {
    final /* synthetic */ cg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cg cgVar) {
        this.a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.a.a.startActivity(new Intent(this.a.a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
