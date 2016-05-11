package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bdO;
        InputMethodManager inputMethodManager2;
        EditText bdN;
        postCategoryView = this.feb.fdx;
        postCategoryView.bcL();
        WriteActivity writeActivity = this.feb;
        inputMethodManager = this.feb.mInputManager;
        bdO = this.feb.bdO();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bdO);
        WriteActivity writeActivity2 = this.feb;
        inputMethodManager2 = this.feb.mInputManager;
        bdN = this.feb.bdN();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bdN);
    }
}
