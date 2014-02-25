package com.baidu.tieba.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
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
        inputMethodManager = this.a.e;
        editText = this.a.g;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.a;
        inputMethodManager2 = this.a.e;
        editText2 = this.a.j;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        editorToolComponetContainer = this.a.B;
        editorToolComponetContainer.k();
        this.a.l();
    }
}
