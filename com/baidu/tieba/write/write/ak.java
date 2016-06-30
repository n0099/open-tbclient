package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bmq;
        InputMethodManager inputMethodManager2;
        EditText bmp;
        postCategoryView = this.fJw.fIQ;
        postCategoryView.blo();
        WriteActivity writeActivity = this.fJw;
        inputMethodManager = this.fJw.mInputManager;
        bmq = this.fJw.bmq();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bmq);
        WriteActivity writeActivity2 = this.fJw;
        inputMethodManager2 = this.fJw.mInputManager;
        bmp = this.fJw.bmp();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bmp);
    }
}
