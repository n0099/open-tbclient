package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bwy;
        InputMethodManager inputMethodManager2;
        EditText bwx;
        postCategoryView = this.gpp.goA;
        postCategoryView.bvz();
        WriteActivity writeActivity = this.gpp;
        inputMethodManager = this.gpp.mInputManager;
        bwy = this.gpp.bwy();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bwy);
        WriteActivity writeActivity2 = this.gpp;
        inputMethodManager2 = this.gpp.mInputManager;
        bwx = this.gpp.bwx();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bwx);
    }
}
