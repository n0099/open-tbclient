package com.baidu.tieba.pb;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        linearLayout = this.a.q;
        if (linearLayout.getVisibility() != 0) {
            this.a.finish();
        } else {
            this.a.b(false);
        }
    }
}
