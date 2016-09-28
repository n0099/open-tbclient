package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bug;
        InputMethodManager inputMethodManager2;
        EditText buf;
        postCategoryView = this.ghD.ggV;
        postCategoryView.bte();
        WriteActivity writeActivity = this.ghD;
        inputMethodManager = this.ghD.mInputManager;
        bug = this.ghD.bug();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bug);
        WriteActivity writeActivity2 = this.ghD;
        inputMethodManager2 = this.ghD.mInputManager;
        buf = this.ghD.buf();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, buf);
    }
}
