package com.baidu.tieba.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.f2785a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteActivity writeActivity = this.f2785a;
        inputMethodManager = this.f2785a.e;
        editText = this.f2785a.f;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.f2785a;
        inputMethodManager2 = this.f2785a.e;
        editText2 = this.f2785a.h;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        editorToolComponetContainer = this.f2785a.B;
        editorToolComponetContainer.i();
        this.f2785a.m();
    }
}
