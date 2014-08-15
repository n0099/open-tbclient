package com.baidu.tieba.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteActivity writeActivity = this.a;
        inputMethodManager = this.a.d;
        editText = this.a.f;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.a;
        inputMethodManager2 = this.a.d;
        editText2 = this.a.i;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        editorToolComponetContainer = this.a.C;
        editorToolComponetContainer.p();
        this.a.m();
    }
}
