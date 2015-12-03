package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText aJK;
        InputMethodManager inputMethodManager2;
        EditText aJJ;
        postCategoryView = this.dRf.dQJ;
        postCategoryView.aII();
        WriteActivity writeActivity = this.dRf;
        inputMethodManager = this.dRf.mInputManager;
        aJK = this.dRf.aJK();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aJK);
        WriteActivity writeActivity2 = this.dRf;
        inputMethodManager2 = this.dRf.mInputManager;
        aJJ = this.dRf.aJJ();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aJJ);
    }
}
