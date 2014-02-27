package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
final class y implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImagePbActivity.v(this.a);
    }
}
