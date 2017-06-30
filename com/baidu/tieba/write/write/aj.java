package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText but;
        InputMethodManager inputMethodManager2;
        EditText bus;
        postCategoryView = this.glP.gkX;
        postCategoryView.bts();
        WriteActivity writeActivity = this.glP;
        inputMethodManager = this.glP.mInputManager;
        but = this.glP.but();
        writeActivity.HidenSoftKeyPad(inputMethodManager, but);
        WriteActivity writeActivity2 = this.glP;
        inputMethodManager2 = this.glP.mInputManager;
        bus = this.glP.bus();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bus);
    }
}
