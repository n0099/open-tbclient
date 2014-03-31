package com.baidu.tieba.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public final class t extends Dialog {
    private View a;
    private ProgressBar b;
    private View.OnTouchListener c;

    @Override // android.app.Dialog
    protected final void onStop() {
        super.onStop();
        this.b.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.a);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().getDecorView().setOnTouchListener(this.c);
    }
}
