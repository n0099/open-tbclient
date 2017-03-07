package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText boJ;
        InputMethodManager inputMethodManager2;
        EditText boI;
        postCategoryView = this.fQG.fPS;
        postCategoryView.bnI();
        WriteActivity writeActivity = this.fQG;
        inputMethodManager = this.fQG.mInputManager;
        boJ = this.fQG.boJ();
        writeActivity.HidenSoftKeyPad(inputMethodManager, boJ);
        WriteActivity writeActivity2 = this.fQG;
        inputMethodManager2 = this.fQG.mInputManager;
        boI = this.fQG.boI();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, boI);
    }
}
