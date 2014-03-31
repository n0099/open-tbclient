package com.baidu.tieba.pb.image;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class n implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImagePbActivity imagePbActivity) {
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
