package com.baidu.tieba.tbadkCore;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class r extends Dialog {
    private View.OnTouchListener aIu;
    private View ge;
    private ProgressBar mProgressBar;

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mProgressBar.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.ge);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().getDecorView().setOnTouchListener(this.aIu);
    }
}
