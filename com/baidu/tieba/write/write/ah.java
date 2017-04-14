package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bps;
        InputMethodManager inputMethodManager2;
        EditText bpr;
        postCategoryView = this.fSq.fRC;
        postCategoryView.bos();
        WriteActivity writeActivity = this.fSq;
        inputMethodManager = this.fSq.mInputManager;
        bps = this.fSq.bps();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bps);
        WriteActivity writeActivity2 = this.fSq;
        inputMethodManager2 = this.fSq.mInputManager;
        bpr = this.fSq.bpr();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpr);
    }
}
