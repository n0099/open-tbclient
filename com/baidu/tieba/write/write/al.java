package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText aEn;
        InputMethodManager inputMethodManager2;
        EditText aEm;
        postCategoryView = this.dsa.drF;
        postCategoryView.aDl();
        WriteActivity writeActivity = this.dsa;
        inputMethodManager = this.dsa.mInputManager;
        aEn = this.dsa.aEn();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aEn);
        WriteActivity writeActivity2 = this.dsa;
        inputMethodManager2 = this.dsa.mInputManager;
        aEm = this.dsa.aEm();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aEm);
    }
}
