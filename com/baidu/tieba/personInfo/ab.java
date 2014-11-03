package com.baidu.tieba.personInfo;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ z bGF;
    private final /* synthetic */ EditText bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, EditText editText) {
        this.bGF = zVar;
        this.bGG = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.bGG.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
