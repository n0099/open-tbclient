package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.setResult(0);
        this.a.finish();
    }
}
