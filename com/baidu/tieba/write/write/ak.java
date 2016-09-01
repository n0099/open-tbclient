package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText btz;
        InputMethodManager inputMethodManager2;
        EditText bty;
        postCategoryView = this.gfs.geM;
        postCategoryView.bsy();
        WriteActivity writeActivity = this.gfs;
        inputMethodManager = this.gfs.mInputManager;
        btz = this.gfs.btz();
        writeActivity.HidenSoftKeyPad(inputMethodManager, btz);
        WriteActivity writeActivity2 = this.gfs;
        inputMethodManager2 = this.gfs.mInputManager;
        bty = this.gfs.bty();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bty);
    }
}
