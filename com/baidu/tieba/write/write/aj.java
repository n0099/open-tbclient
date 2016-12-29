package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bnx;
        InputMethodManager inputMethodManager2;
        EditText bnw;
        postCategoryView = this.fDQ.fDc;
        postCategoryView.bmx();
        WriteActivity writeActivity = this.fDQ;
        inputMethodManager = this.fDQ.mInputManager;
        bnx = this.fDQ.bnx();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bnx);
        WriteActivity writeActivity2 = this.fDQ;
        inputMethodManager2 = this.fDQ.mInputManager;
        bnw = this.fDQ.bnw();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bnw);
    }
}
