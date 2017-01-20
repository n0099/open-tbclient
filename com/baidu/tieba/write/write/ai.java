package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText boV;
        InputMethodManager inputMethodManager2;
        EditText boU;
        postCategoryView = this.fMl.fLx;
        postCategoryView.bnV();
        WriteActivity writeActivity = this.fMl;
        inputMethodManager = this.fMl.mInputManager;
        boV = this.fMl.boV();
        writeActivity.HidenSoftKeyPad(inputMethodManager, boV);
        WriteActivity writeActivity2 = this.fMl;
        inputMethodManager2 = this.fMl.mInputManager;
        boU = this.fMl.boU();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, boU);
    }
}
