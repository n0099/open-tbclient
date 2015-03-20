package com.baidu.tieba.personInfo;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ z bTT;
    private final /* synthetic */ EditText bTU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, EditText editText) {
        this.bTT = zVar;
        this.bTU = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.bTU.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
