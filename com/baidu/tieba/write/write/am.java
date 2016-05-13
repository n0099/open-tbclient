package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bdV;
        InputMethodManager inputMethodManager2;
        EditText bdU;
        postCategoryView = this.fea.fdw;
        postCategoryView.bcS();
        WriteActivity writeActivity = this.fea;
        inputMethodManager = this.fea.mInputManager;
        bdV = this.fea.bdV();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bdV);
        WriteActivity writeActivity2 = this.fea;
        inputMethodManager2 = this.fea.mInputManager;
        bdU = this.fea.bdU();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bdU);
    }
}
