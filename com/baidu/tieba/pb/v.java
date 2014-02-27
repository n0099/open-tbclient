package com.baidu.tieba.pb;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class v implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        linearLayout = this.a.q;
        if (linearLayout.getVisibility() != 0) {
            this.a.finish();
        } else {
            this.a.b(false);
        }
    }
}
