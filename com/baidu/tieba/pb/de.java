package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dd f2118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.f2118a = ddVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbWriteToolView pbWriteToolView;
        GridView gridView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        pbWriteToolView = this.f2118a.f;
        pbWriteToolView.b();
        gridView = this.f2118a.B;
        gridView.setVisibility(0);
        linearLayout = this.f2118a.t;
        linearLayout.setVisibility(0);
        linearLayout2 = this.f2118a.q;
        linearLayout2.setEnabled(false);
        editText = this.f2118a.E;
        editText.requestFocus();
    }
}
