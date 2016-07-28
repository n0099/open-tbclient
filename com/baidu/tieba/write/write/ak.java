package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bpk;
        InputMethodManager inputMethodManager2;
        EditText bpj;
        postCategoryView = this.fVn.fUH;
        postCategoryView.boj();
        WriteActivity writeActivity = this.fVn;
        inputMethodManager = this.fVn.mInputManager;
        bpk = this.fVn.bpk();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bpk);
        WriteActivity writeActivity2 = this.fVn;
        inputMethodManager2 = this.fVn.mInputManager;
        bpj = this.fVn.bpj();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpj);
    }
}
