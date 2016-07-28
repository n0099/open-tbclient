package com.baidu.tieba.tbadkCore;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class u extends Dialog {
    private View.OnTouchListener aGS;
    private View dT;
    private ProgressBar mProgressBar;

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mProgressBar.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.dT);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().getDecorView().setOnTouchListener(this.aGS);
    }
}
