package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText aUZ;
        InputMethodManager inputMethodManager2;
        EditText aUY;
        postCategoryView = this.ets.esW;
        postCategoryView.aTY();
        WriteActivity writeActivity = this.ets;
        inputMethodManager = this.ets.mInputManager;
        aUZ = this.ets.aUZ();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aUZ);
        WriteActivity writeActivity2 = this.ets;
        inputMethodManager2 = this.ets.mInputManager;
        aUY = this.ets.aUY();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aUY);
    }
}
