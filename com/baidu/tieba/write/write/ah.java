package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bqt;
        InputMethodManager inputMethodManager2;
        EditText bqs;
        postCategoryView = this.fUM.fTY;
        postCategoryView.bpt();
        WriteActivity writeActivity = this.fUM;
        inputMethodManager = this.fUM.mInputManager;
        bqt = this.fUM.bqt();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bqt);
        WriteActivity writeActivity2 = this.fUM;
        inputMethodManager2 = this.fUM.mInputManager;
        bqs = this.fUM.bqs();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bqs);
    }
}
