package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText box;
        InputMethodManager inputMethodManager2;
        EditText bow;
        postCategoryView = this.fSV.fSd;
        postCategoryView.bnv();
        WriteActivity writeActivity = this.fSV;
        inputMethodManager = this.fSV.mInputManager;
        box = this.fSV.box();
        writeActivity.HidenSoftKeyPad(inputMethodManager, box);
        WriteActivity writeActivity2 = this.fSV;
        inputMethodManager2 = this.fSV.mInputManager;
        bow = this.fSV.bow();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bow);
    }
}
