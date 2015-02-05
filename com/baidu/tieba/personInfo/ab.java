package com.baidu.tieba.personInfo;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ z bLJ;
    private final /* synthetic */ EditText bLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, EditText editText) {
        this.bLJ = zVar;
        this.bLK = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.bLK.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
