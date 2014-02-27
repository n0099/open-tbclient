package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
final class w implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImagePbActivity.u(this.a);
    }
}
