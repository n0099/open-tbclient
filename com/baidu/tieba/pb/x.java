package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
final class x implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b(true);
    }
}
