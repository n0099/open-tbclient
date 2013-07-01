package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f1262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.f1262a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        gridView = this.f1262a.A;
        gridView.setVisibility(0);
        linearLayout = this.f1262a.s;
        linearLayout.setVisibility(0);
        linearLayout2 = this.f1262a.p;
        linearLayout2.setEnabled(false);
        editText = this.f1262a.F;
        editText.requestFocus();
    }
}
