package com.baidu.tieba.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity) {
        this.f1900a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        GridView gridView;
        GridView gridView2;
        WriteActivity writeActivity = this.f1900a;
        inputMethodManager = this.f1900a.d;
        editText = this.f1900a.e;
        writeActivity.a(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.f1900a;
        inputMethodManager2 = this.f1900a.d;
        editText2 = this.f1900a.f;
        writeActivity2.a(inputMethodManager2, editText2);
        gridView = this.f1900a.r;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.f1900a.r;
            gridView2.setVisibility(8);
        }
        this.f1900a.b();
    }
}
