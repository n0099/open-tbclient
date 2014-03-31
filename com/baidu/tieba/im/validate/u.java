package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements View.OnClickListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ValidateActivity validateActivity;
        validateActivity = this.a.d;
        validateActivity.finish();
    }
}
