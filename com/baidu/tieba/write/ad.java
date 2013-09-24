package com.baidu.tieba.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.f2081a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        GridView gridView;
        GridView gridView2;
        WriteActivity writeActivity = this.f2081a;
        inputMethodManager = this.f2081a.d;
        editText = this.f2081a.e;
        writeActivity.a(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.f2081a;
        inputMethodManager2 = this.f2081a.d;
        editText2 = this.f2081a.g;
        writeActivity2.a(inputMethodManager2, editText2);
        gridView = this.f2081a.u;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.f2081a.u;
            gridView2.setVisibility(8);
        }
        this.f2081a.d();
    }
}
