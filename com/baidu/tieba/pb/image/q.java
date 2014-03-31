package com.baidu.tieba.pb.image;

import android.view.View;
/* loaded from: classes.dex */
final class q implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImagePbActivity.v(this.a);
    }
}
