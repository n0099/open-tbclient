package com.baidu.tieba.person;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    final /* synthetic */ as a;
    private final /* synthetic */ EditText b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar, EditText editText) {
        this.a = asVar;
        this.b = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.b.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
