package com.baidu.tieba.tbadkCore;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class t extends Dialog {
    private View.OnTouchListener aFz;
    private View dq;
    private ProgressBar mProgressBar;

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mProgressBar.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.dq);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().getDecorView().setOnTouchListener(this.aFz);
    }
}
