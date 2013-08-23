package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cv f1551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cv cvVar) {
        this.f1551a = cvVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        gridView = this.f1551a.A;
        gridView.setVisibility(0);
        linearLayout = this.f1551a.s;
        linearLayout.setVisibility(0);
        linearLayout2 = this.f1551a.p;
        linearLayout2.setEnabled(false);
        editText = this.f1551a.F;
        editText.requestFocus();
    }
}
