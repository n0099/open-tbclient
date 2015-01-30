package com.baidu.tieba.personInfo;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ z bLK;
    private final /* synthetic */ EditText bLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, EditText editText) {
        this.bLK = zVar;
        this.bLL = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.bLL.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
