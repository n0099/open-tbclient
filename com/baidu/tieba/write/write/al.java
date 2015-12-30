package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText aMf;
        InputMethodManager inputMethodManager2;
        EditText aMe;
        postCategoryView = this.dYD.dYh;
        postCategoryView.aLd();
        WriteActivity writeActivity = this.dYD;
        inputMethodManager = this.dYD.mInputManager;
        aMf = this.dYD.aMf();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aMf);
        WriteActivity writeActivity2 = this.dYD;
        inputMethodManager2 = this.dYD.mInputManager;
        aMe = this.dYD.aMe();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aMe);
    }
}
