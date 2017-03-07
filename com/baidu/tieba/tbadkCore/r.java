package com.baidu.tieba.tbadkCore;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class r extends Dialog {
    private View.OnTouchListener aNR;
    private ProgressBar mProgressBar;
    private View nW;

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mProgressBar.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.nW);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().getDecorView().setOnTouchListener(this.aNR);
    }
}
