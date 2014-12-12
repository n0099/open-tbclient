package com.baidu.tieba.personInfo;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ z bJZ;
    private final /* synthetic */ EditText bKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, EditText editText) {
        this.bJZ = zVar;
        this.bKa = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.bKa.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
