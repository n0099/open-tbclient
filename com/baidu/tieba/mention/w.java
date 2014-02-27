package com.baidu.tieba.mention;

import android.view.View;
/* loaded from: classes.dex */
final class w implements View.OnClickListener {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
