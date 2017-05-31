package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bpW;
        InputMethodManager inputMethodManager2;
        EditText bpV;
        postCategoryView = this.gaR.fZZ;
        postCategoryView.boU();
        WriteActivity writeActivity = this.gaR;
        inputMethodManager = this.gaR.mInputManager;
        bpW = this.gaR.bpW();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bpW);
        WriteActivity writeActivity2 = this.gaR;
        inputMethodManager2 = this.gaR.mInputManager;
        bpV = this.gaR.bpV();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpV);
    }
}
