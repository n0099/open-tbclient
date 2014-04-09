package com.baidu.tieba.pb.image;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class m implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        linearLayout = this.a.p;
        if (linearLayout.getVisibility() != 0) {
            this.a.finish();
        } else {
            this.a.b(false);
        }
    }
}
