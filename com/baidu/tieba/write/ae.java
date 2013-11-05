package com.baidu.tieba.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.f2626a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        GridView gridView;
        GridView gridView2;
        WriteActivity writeActivity = this.f2626a;
        inputMethodManager = this.f2626a.d;
        editText = this.f2626a.e;
        writeActivity.a(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.f2626a;
        inputMethodManager2 = this.f2626a.d;
        editText2 = this.f2626a.g;
        writeActivity2.a(inputMethodManager2, editText2);
        gridView = this.f2626a.u;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.f2626a.u;
            gridView2.setVisibility(8);
        }
        this.f2626a.d();
    }
}
