package com.baidu.tieba.pb;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImagePbActivity imagePbActivity) {
        this.f2282a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        linearLayout = this.f2282a.q;
        if (linearLayout.getVisibility() == 0) {
            this.f2282a.b(false);
        } else {
            this.f2282a.finish();
        }
    }
}
