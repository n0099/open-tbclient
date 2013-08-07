package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cu f1513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cu cuVar) {
        this.f1513a = cuVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        gridView = this.f1513a.A;
        gridView.setVisibility(0);
        linearLayout = this.f1513a.s;
        linearLayout.setVisibility(0);
        linearLayout2 = this.f1513a.p;
        linearLayout2.setEnabled(false);
        editText = this.f1513a.F;
        editText.requestFocus();
    }
}
