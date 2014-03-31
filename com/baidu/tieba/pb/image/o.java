package com.baidu.tieba.pb.image;

import android.view.View;
/* loaded from: classes.dex */
final class o implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImagePbActivity.u(this.a);
    }
}
