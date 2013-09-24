package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ db f1600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(db dbVar) {
        this.f1600a = dbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbWriteToolView pbWriteToolView;
        GridView gridView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        pbWriteToolView = this.f1600a.f;
        pbWriteToolView.b();
        gridView = this.f1600a.B;
        gridView.setVisibility(0);
        linearLayout = this.f1600a.t;
        linearLayout.setVisibility(0);
        linearLayout2 = this.f1600a.q;
        linearLayout2.setEnabled(false);
        editText = this.f1600a.E;
        editText.requestFocus();
    }
}
