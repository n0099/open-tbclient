package com.baidu.tieba.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        GridView gridView;
        GridView gridView2;
        WriteActivity writeActivity = this.a;
        inputMethodManager = this.a.e;
        editText = this.a.f;
        writeActivity.a(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.a;
        inputMethodManager2 = this.a.e;
        editText2 = this.a.g;
        writeActivity2.a(inputMethodManager2, editText2);
        gridView = this.a.p;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.a.p;
            gridView2.setVisibility(8);
        }
        this.a.g();
    }
}
