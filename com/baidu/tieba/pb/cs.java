package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Runnable {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        gridView = this.a.A;
        gridView.setVisibility(0);
        linearLayout = this.a.s;
        linearLayout.setVisibility(0);
        linearLayout2 = this.a.p;
        linearLayout2.setEnabled(false);
        editText = this.a.F;
        editText.requestFocus();
    }
}
